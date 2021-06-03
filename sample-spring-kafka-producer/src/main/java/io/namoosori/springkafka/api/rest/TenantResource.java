package io.namoosori.springkafka.api.rest;

import io.namoosori.springkafka.api.command.CreateTenant;
import io.namoosori.springkafka.domain.entity.Tenant;
import io.namoosori.springkafka.domain.logic.TenantLogic;
import org.springframework.web.bind.annotation.*;

@RestController
public class TenantResource {
    //
    private final TenantLogic tenantLogic;

    public TenantResource(TenantLogic tenantLogic) {
        //
        this.tenantLogic = tenantLogic;
    }

    @PostMapping
    public String createTenant(@RequestBody CreateTenant command) {
        //
        return this.tenantLogic.createTenant(command);
    }

    @GetMapping(value = "/{tenantId}")
    public Tenant findTenant(@PathVariable String tenantId) {
        //

        return this.tenantLogic.findTenant(tenantId);
    }

    @DeleteMapping(value = "/{tenantId}")
    public void removeTenant(@PathVariable String tenantId) {
        //
        this.tenantLogic.removeTenant(tenantId);
    }
}
