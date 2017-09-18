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

        String code;

        public Emoji(int res, String code) {
            this.res = res;
            this.code = code;
        }

        public int getRes() {
            return res;
        }

        public String getCode() {
            return code;
        }

        public static float defaultSize(TextView textView) {
            final Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
            return fontMetrics.descent - fontMetrics.ascent;
        }
    }
}
