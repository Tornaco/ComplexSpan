package github.tornaco.span;

import android.support.annotation.NonNull;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public interface SpanHandlerProvider {
    @NonNull
    SpanHandler[] getSpanHandler();
}
