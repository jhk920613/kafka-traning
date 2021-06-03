package io.namoosori.springkafka.api.rest;

import io.namoosori.springkafka.domain.entity.TenantStats;
import io.namoosori.springkafka.store.TenantStatsStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantStatsResource {
    //
    private final TenantStatsStore tenantStatsStore;

    public TenantStatsResource(TenantStatsStore tenantStatsStore) {
        //
        this.tenantStatsStore = tenantStatsStore;
    }

    @GetMapping(value = { "", "/" })
    public TenantStats find() {
        //
        return this.tenantStatsStore.retrieve();
    }
}
