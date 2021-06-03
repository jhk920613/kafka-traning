package io.namoosori.springkafka.domain.logic;

import io.namoosori.springkafka.api.command.CreateTenant;
import io.namoosori.springkafka.domain.entity.Tenant;
import io.namoosori.springkafka.domain.event.TenantCreated;
import io.namoosori.springkafka.domain.event.TenantRemoved;
import io.namoosori.springkafka.store.TenantStore;
import io.namoosori.springkafka.stream.EventProducer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TenantLogic {
    //
    private final TenantStore tenantStore;
    private final EventProducer eventProducer;

    public TenantLogic(TenantStore tenantStore,
                       EventProducer eventProducer) {
        //
        this.tenantStore = tenantStore;
        this.eventProducer = eventProducer;
    }

    public String createTenant(CreateTenant command) {
        //
        String newTenantId = UUID.randomUUID().toString();
        Tenant tenant = new Tenant(newTenantId, command.getTenantName());
        this.tenantStore.create(tenant);

        eventProducer.produceEvent(new TenantCreated(newTenantId, command.getTenantName()));

        return newTenantId;
    }

    public Tenant findTenant(String tenantId) {
        //
        return this.tenantStore.retrieve(tenantId);
    }

    public void removeTenant(String tenantId) {
        //
        this.tenantStore.delete(tenantId);

        eventProducer.produceEvent(new TenantRemoved(tenantId));
    }
}
