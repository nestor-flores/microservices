package com.mercadolibre.commons.messaging;

import java.io.Serializable;

public class QueueMessage implements Serializable {

    private String eventName;

    private Object data;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
