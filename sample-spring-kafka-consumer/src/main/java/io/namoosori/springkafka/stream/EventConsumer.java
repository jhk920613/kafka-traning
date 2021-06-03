package io.namoosori.springkafka.stream;

import com.google.gson.Gson;
import io.namoosori.springkafka.domain.entity.TenantStats;
import io.namoosori.springkafka.domain.event.TenantCreated;
import io.namoosori.springkafka.domain.event.TenantRemoved;
import io.namoosori.springkafka.store.TenantStatsStore;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class EventConsumer {
    //
    private final TenantStatsStore tenantStatsStore;

    public EventConsumer(TenantStatsStore tenantStatsStore) {
        //
        this.tenantStatsStore = tenantStatsStore;
    }

    @StreamListener(value = EventStream.INBOUND, condition = "headers['EventType'] == 'TenantCreated'")
    public void consumeEvent(@Payload TenantCreated event) {
        //
        System.out.println("EventConsumer.consumeEvent(TenantCreated): " + (new Gson()).toJson(event));
        TenantStats stats = this.tenantStatsStore.retrieve();
        stats.increase();
        this.tenantStatsStore.update(stats);
    }

    @StreamListener(value = EventStream.INBOUND, condition = "headers['EventType'] == 'TenantRemoved'")
    public void consumeEvent(@Payload TenantRemoved event) {
        //
        System.out.println("EventConsumer.consumeEvent(TenantRemoved): " + (new Gson()).toJson(event));
        TenantStats stats = this.tenantStatsStore.retrieve();
        stats.decrease();
        this.tenantStatsStore.update(stats);
    }
}
