package github.tornaco.span;

import android.content.Context;
import android.support.annotation.NonNull;

import github.tornaco.span.handler.AtHandler;
import github.tornaco.span.handler.EmojiProvider;
import github.tornaco.span.handler.TopicHandler;
import github.tornaco.span.handler.UrlHandler;
import github.tornaco.span.handler.WeiboEmojiHandler;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

public abstract class WeiboSpanHandlerProvider implements SpanHandlerProvider,
        TopicHandler.OnTopicClickListener,
        UrlHandler.OnUrlClickListener,
        AtHandler.OnATClickListener, EmojiProvider {

    @NonNull
    @Override
    public SpanHandler[] getSpanHandler() {
        return new SpanHandler[]{
                new UrlHandler(this),
                new TopicHandler(this),
                new AtHandler(this),
                new WeiboEmojiHandler(this),
        };
    }
}
