package github.tornaco.span;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public class ClickableSpanNoUL extends ClickableSpan {

    private static final String TAG = "ClickableSpan";

    private OnClickListener<ClickableSpanNoUL> onClickListener;

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    private boolean pressed;

    public ClickableSpanNoUL(OnClickListener<ClickableSpanNoUL> onClickListener) {
        super();
        this.onClickListener = onClickListener;
    }

    /**
     * Makes the text underlined and in the link color.
     */
    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        super.updateDrawState(ds);
        ds.clearShadowLayer();
        ds.setUnderlineText(false);
        Log.d("ClickableSpanNoUL", getClass().getSimpleName() + ",pressed?" + pressed);
        ds.bgColor = pressed ? ds.bgColor : Color.TRANSPARENT;
    }

    /**
     * Performs the click action associated with this span.
     */
    @Override
    public void onClick(View widget) {
        if (this.onClickListener != null) {
            this.onClickListener.onClick(widget, this);
        } else {
            Log.w(TAG, "listener was null");
        }
    }

    public interface OnClickListener<T extends ClickableSpanNoUL> {
        void onClick(View widget, T span);
    }

}
