package github.tornaco.span;

import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public interface SpanHandler {
    void handle(@NonNull TextView targetView, @NonNull CharSequence sequence, @NonNull SpannableStringBuilder ssb);
}
