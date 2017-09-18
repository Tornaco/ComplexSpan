package github.tornaco.span.handler;

import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import github.tornaco.span.ClickableSpanNoUL;
import github.tornaco.span.SpanHandler;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public class TopicHandler implements SpanHandler {

    private static final Pattern TOPIC = Pattern.compile("#.*#");

    public interface OnTopicClickListener {
        void onTopicClick(String topic);
    }

    private OnTopicClickListener topicClickListener;

    public TopicHandler(OnTopicClickListener topicClickListener) {
        this.topicClickListener = topicClickListener;
    }

    @Override
    public void handle(@NonNull TextView targetView, @NonNull CharSequence sequence, @NonNull SpannableStringBuilder ssb) {
        Matcher matcher = TOPIC.matcher(sequence);
        while (matcher.find()) {
            final String top = matcher.group();
            int length = top.length();
            int startIndex = matcher.start();

            TopicClickableSpan t = new TopicClickableSpan(new ClickableSpanNoUL
                    .OnClickListener<ClickableSpanNoUL>() {
                @Override
                public void onClick(View widget, ClickableSpanNoUL span) {
                    TopicClickableSpan topicClickableSpan = (TopicClickableSpan) span;
                    topicClickListener.onTopicClick(topicClickableSpan.getTopic());
                }
            });
            t.setTopic(top);

            ssb.setSpan(t, startIndex, startIndex
                    + length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }
}
