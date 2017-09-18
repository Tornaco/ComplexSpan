package github.tornaco.span.handler;

import android.graphics.Paint;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.TextView;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public interface EmojiProvider {

    Emoji getFromEmojiString(@NonNull String emojiString);

    class Emoji {

        @DrawableRes
        int res;
        float size;

        public Emoji(int res, float size) {
            this.res = res;
            this.size = size;
        }

        public Emoji(TextView textView, int res) {
            this(res, defaultSize(textView));
        }

        public int getRes() {
            return res;
        }

        public float getSize() {
            return size;
        }

        public static float defaultSize(TextView textView) {
            final Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
            return fontMetrics.descent - fontMetrics.ascent;
        }
    }
}
