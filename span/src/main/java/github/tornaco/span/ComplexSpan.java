package github.tornaco.span;

import android.text.SpannableStringBuilder;
import android.widget.TextView;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public class ComplexSpan {

    public static void apply(TextView textView,
                             CharSequence content,
                             SpanHandler... handlers) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        for (SpanHandler h : handlers) {
            h.handle(textView, content, ssb);
        }
        // Apply MM.
        textView.setMovementMethod(ClickableMovementMethod.getInstance());
        textView.setText(ssb);
    }

    public static void apply(
            TextView textView,
            SpanHandlerProvider spanHandlerProvider,
            CharSequence content) {
        if (spanHandlerProvider == null)
            throw new IllegalArgumentException("SpanHandlerProvider can not be null");
        apply(textView, content, spanHandlerProvider.getSpanHandler());
    }
}
