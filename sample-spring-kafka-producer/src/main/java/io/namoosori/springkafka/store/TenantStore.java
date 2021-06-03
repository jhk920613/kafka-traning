package io.namoosori.springkafka.store;

import io.namoosori.springkafka.domain.entity.Tenant;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TenantStore {
    //
    private Map<String, Tenant> tenants;

    public TenantStore() {
        //
        this.tenants = new HashMap<>();
    }

    public void create(Tenant tenant) {
        //
        this.tenants.put(tenant.getTenantId(), tenant);
    }

    public Tenant retrieve(String tenantId) {
        //
        return this.tenants.get(tenantId);
    }

    public void delete(String tenantId) {
        //
        this.tenants.remove(tenantId);
    }
}
