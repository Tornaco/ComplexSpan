package github.tornaco.span.handler;

import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import github.tornaco.span.SpanHandler;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public class WeiboEmojiHandler implements SpanHandler {

    private static final Pattern EMOJI = Pattern.compile("\\[.*\\]");

    private EmojiProvider emojiProvider;

    public WeiboEmojiHandler(EmojiProvider emojiProvider) {
        this.emojiProvider = emojiProvider;
    }

    @Override
    public void handle(@NonNull TextView targetView, @NonNull CharSequence sequence, @NonNull SpannableStringBuilder ssb) {
        Matcher matcher = EMOJI.matcher(sequence);
        while (matcher.find()) {
            final String em = matcher.group();
            int length = em.length();
            int startIndex = matcher.start();

            EmojiProvider.Emoji emoji = emojiProvider.getFromEmojiString(em);
            if (emoji != null) {
                ssb.setSpan(new EmojiSpan(targetView.getContext(), emoji.res,
                                EmojiProvider.Emoji.defaultSize(targetView)),
                        startIndex, startIndex + length,
                        Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            }
        }
    }
}
