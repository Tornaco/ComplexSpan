package github.tornaco.span.handler;

import github.tornaco.span.ClickableSpanNoUL;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

class UrlClickableSpan extends ClickableSpanNoUL {

    private String url;

    UrlClickableSpan(OnClickListener<ClickableSpanNoUL> onClickListener) {
        super(onClickListener);
    }

    String getUrl() {
        return url;
    }

    void setUrl(String url) {
        this.url = url;
    }

}
