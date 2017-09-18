package github.tornaco.span;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

class ClickableMovementMethod extends LinkMovementMethod {

    private static final ClickableMovementMethod sMe = new ClickableMovementMethod();

    public static ClickableMovementMethod getInstance() {
        return sMe;
    }

    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer,
                                MotionEvent event) {
        int action = event.getAction();

        ClickableSpanNoUL spanNoUL = getPressedSpan(widget, buffer, event);

        if (spanNoUL == null) return super.onTouchEvent(widget, buffer, event);

        if (action == MotionEvent.ACTION_DOWN) {
            spanNoUL.setPressed(true);
        } else {
            spanNoUL.setPressed(false);
        }

        return super.onTouchEvent(widget, buffer, event);
    }

    private ClickableSpanNoUL getPressedSpan(TextView textView, Spannable spannable, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        x -= textView.getTotalPaddingLeft();
        y -= textView.getTotalPaddingTop();

        x += textView.getScrollX();
        y += textView.getScrollY();

        Layout layout = textView.getLayout();
        int line = layout.getLineForVertical(y);
        int off = layout.getOffsetForHorizontal(line, x);

        ClickableSpanNoUL[] link = spannable.getSpans(off, off, ClickableSpanNoUL.class);
        ClickableSpanNoUL touchedSpan = null;
        if (link.length > 0) {
            touchedSpan = link[0];
        }
        return touchedSpan;
    }
}
