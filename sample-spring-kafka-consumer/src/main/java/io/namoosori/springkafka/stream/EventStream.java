package io.namoosori.springkafka.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EventStream {
    //
    String INBOUND = "event-consumer";

    @Input(INBOUND)
    SubscribableChannel consumer();
}
