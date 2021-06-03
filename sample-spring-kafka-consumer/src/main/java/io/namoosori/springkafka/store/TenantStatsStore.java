package io.namoosori.springkafka.store;

import io.namoosori.springkafka.domain.entity.TenantStats;
import org.springframework.stereotype.Repository;

@Repository
public class TenantStatsStore {
    //
    private TenantStats tenantStats;

    public TenantStatsStore() {
        //
        this.tenantStats = new TenantStats();
    }

    public TenantStats retrieve() {
        //
        return this.tenantStats;
    }

    public void update(TenantStats tenantStats) {
        //
        this.tenantStats = tenantStats;
    }
}
