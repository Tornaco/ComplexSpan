package github.tornaco.span.handler;

import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import github.tornaco.span.ClickableSpanNoUL;
import github.tornaco.span.SpanHandler;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public class AtHandler implements SpanHandler {

    private static final Pattern AT = Pattern.compile("@\\S+");

    public interface OnATClickListener {
        void onATClick(String who);
    }

    private OnATClickListener onATClickListener;

    public AtHandler(OnATClickListener onATClickListener) {
        this.onATClickListener = onATClickListener;
    }

    @Override
    public void handle(@NonNull CharSequence sequence, @NonNull SpannableStringBuilder ssb) {
        Matcher matcher = AT.matcher(sequence);
        while (matcher.find()) {
            final String who = matcher.group();
            int length = who.length();
            int startIndex = matcher.start();

            ATClickableSpan t = new ATClickableSpan(new ClickableSpanNoUL
                    .OnClickListener<ClickableSpanNoUL>() {
                @Override
                public void onClick(View widget, ClickableSpanNoUL span) {
                    ATClickableSpan atClickableSpan = (ATClickableSpan) span;
                    onATClickListener.onATClick(atClickableSpan.getWho());
                }
            });
            t.setWho(who);

            ssb.setSpan(t, startIndex, startIndex
                    + length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }
}
