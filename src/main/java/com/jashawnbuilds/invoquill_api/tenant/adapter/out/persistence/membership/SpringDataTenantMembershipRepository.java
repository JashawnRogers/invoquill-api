package com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence.membership;

import com.jashawnbuilds.invoquill_api.tenant.domain.membership.TenantMembership;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataTenantMembershipRepository
        extends CrudRepository<TenantMembership, UUID> {

    Optional<TenantMembership> findByUserIdAndTenantId(UUID userId, UUID tenantId);
    boolean existsByUserIdAndTenantId(UUID userId, UUID tenantId);
}
