package com.mercadolibre.notification.listener;

import com.mercadolibre.commons.messaging.QueueConstants;
import com.mercadolibre.commons.messaging.QueueEvents;
import com.mercadolibre.commons.messaging.QueueMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);


    @RabbitListener(queues = QueueConstants.QUEUE_SPECIFIC_NAME)
    public void processNotification(QueueMessage queueMessage) {

        //Check and log the event
        if(queueMessage.getEventName().equals(QueueEvents.SALE_CREATED)) {
            Integer saleId = (Integer) queueMessage.getData();
            log.info("Got message with sale id: {}", saleId);

        }
    }
}
