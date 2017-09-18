package github.tornaco.span;

import android.text.SpannableStringBuilder;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public class ComplexSpan {

    public static SpannableStringBuilder apply(CharSequence content, SpanHandler... handlers) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        for (SpanHandler h : handlers) {
            h.handle(content, ssb);
        }
        return ssb;
    }

    public static SpannableStringBuilder apply(
            SpanHandlerProvider spanHandlerProvider, CharSequence content) {
        if (spanHandlerProvider == null)
            throw new IllegalArgumentException("SpanHandlerProvider can not be null");
        return apply(content, spanHandlerProvider.getSpanHandler());
    }
}
