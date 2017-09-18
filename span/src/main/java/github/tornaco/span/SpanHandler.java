package github.tornaco.span;

import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public interface SpanHandler {
    void handle(@NonNull CharSequence sequence, @NonNull SpannableStringBuilder ssb);
}
