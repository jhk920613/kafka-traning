package io.namoosori.springkafka.stream;

import com.google.gson.Gson;
import io.namoosori.springkafka.domain.event.TenantCreated;
import io.namoosori.springkafka.domain.event.TenantRemoved;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
public class EventProducer {
    //
    private final EventStream eventStream;

    public EventProducer(EventStream eventStream) {
        //
        this.eventStream = eventStream;
    }

    public boolean produceEvent(TenantCreated event) {
        //
        System.out.println("Producing events --> name: "+ (new Gson()).toJson(event));
        MessageChannel messageChannel = eventStream.producer();
        return messageChannel
                .send(MessageBuilder.withPayload(event)
                        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                        .setHeader("EventType", event.getClass().getSimpleName())
                        .build());
    }

    public boolean produceEvent(TenantRemoved event) {
        //
        System.out.println("Producing events --> name: "+ (new Gson()).toJson(event));
        MessageChannel messageChannel = eventStream.producer();
        return messageChannel
                .send(MessageBuilder.withPayload(event)
                        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                        .setHeader("EventType", event.getClass().getSimpleName())
                        .build());
    }
}
