package github.tornaco.span.handler;

import android.support.annotation.NonNull;
import android.support.v4.util.PatternsCompat;
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

public class UrlHandler implements SpanHandler {

    public interface OnUrlClickListener {
        void onUrlClick(String url);
    }

    private OnUrlClickListener onUrlClickListener;

    public UrlHandler(OnUrlClickListener onUrlClickListener) {
        this.onUrlClickListener = onUrlClickListener;
    }

    @Override
    public void handle(@NonNull TextView textView, @NonNull CharSequence sequence, @NonNull SpannableStringBuilder ssb) {
        Pattern pattern = PatternsCompat.WEB_URL;
        Matcher matcher = pattern.matcher(sequence);
        while (matcher.find()) {
            String url = matcher.group();
            int length = url.length();
            int startIndex = matcher.start();

            final UrlClickableSpan u = new UrlClickableSpan(new ClickableSpanNoUL.OnClickListener<ClickableSpanNoUL>() {
                @Override
                public void onClick(View widget, ClickableSpanNoUL span) {
                    UrlClickableSpan urlClickableSpan = (UrlClickableSpan) span;
                    onUrlClickListener.onUrlClick(urlClickableSpan.getUrl());
                }
            });
            u.setUrl(url);

            ssb.setSpan(u, startIndex, startIndex
                    + length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }
}

