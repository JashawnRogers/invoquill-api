package com.jashawnbuilds.invoquill_api.tenant.application.out;

import com.jashawnbuilds.invoquill_api.tenant.domain.membership.TenantMembership;

import java.util.Optional;
import java.util.UUID;

public interface TenantMembershipRepository {
    Optional<TenantMembership> findByUserIdAndTenantId(UUID userId, UUID tenantId);
    Optional<TenantMembership> findById(UUID membershipId);
    boolean existsByUserIdAndTenantId(UUID userId, UUID tenantId);
    TenantMembership save(TenantMembership membership);
}
