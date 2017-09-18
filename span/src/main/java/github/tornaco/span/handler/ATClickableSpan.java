package github.tornaco.span.handler;

import github.tornaco.span.ClickableSpanNoUL;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

class ATClickableSpan extends ClickableSpanNoUL {

    private String who;

    ATClickableSpan(OnClickListener<ClickableSpanNoUL> onClickListener) {
        super(onClickListener);
    }

    String getWho() {
        return who;
    }

    void setWho(String who) {
        this.who = who;
    }

}
