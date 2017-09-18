package github.tornaco.span.handler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

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
    private Context context;

    public WeiboEmojiHandler(Context context, EmojiProvider emojiProvider) {
        this.emojiProvider = emojiProvider;
        this.context = context;
    }

    @Override
    public void handle(@NonNull CharSequence sequence, @NonNull SpannableStringBuilder ssb) {
        Matcher matcher = EMOJI.matcher(sequence);
        while (matcher.find()) {
            final String em = matcher.group();
            int length = em.length();
            int startIndex = matcher.start();

            EmojiProvider.Emoji emoji = emojiProvider.getFromEmojiString(em);
            if (emoji != null) {
                ssb.setSpan(new EmojiSpan(this.context, emoji.res, emoji.size),
                        startIndex, startIndex + length,
                        Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            }
        }
    }
}
