package github.tornaco.span.handler;

import github.tornaco.span.ClickableSpanNoUL;

/**
 * Created by guohao4 on 2017/9/18.
 * Email: Tornaco@163.com
 */

class TopicClickableSpan extends ClickableSpanNoUL {

    private String topic;

    String getTopic() {
        return topic;
    }

    void setTopic(String topic) {
        this.topic = topic;
    }

    TopicClickableSpan(OnClickListener<ClickableSpanNoUL> onClickListener) {
        super(onClickListener);
    }
}
