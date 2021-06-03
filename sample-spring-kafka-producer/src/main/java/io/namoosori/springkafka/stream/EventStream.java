package io.namoosori.springkafka.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventStream {
    //
    String OUTBOUND = "event-producer";

    @Output(OUTBOUND)
    MessageChannel producer();
}