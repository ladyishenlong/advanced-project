package com.ladyishenlong.annotation.annotation.eventListener;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author ruanchenhao
 * @Date 2020/5/6 11:31 上午
 */
@Setter
@Getter
public class TestEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public TestEvent(Object source) {
        super(source);
    }

    private String message;

}
