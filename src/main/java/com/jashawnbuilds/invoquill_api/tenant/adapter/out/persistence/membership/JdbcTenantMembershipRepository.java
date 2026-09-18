package com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence.membership;

import com.jashawnbuilds.invoquill_api.tenant.application.out.TenantMembershipRepository;
import com.jashawnbuilds.invoquill_api.tenant.domain.membership.TenantMembership;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JdbcTenantMembershipRepository implements TenantMembershipRepository {

    private final SpringDataTenantMembershipRepository repository;

    public JdbcTenantMembershipRepository(SpringDataTenantMembershipRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<TenantMembership> findByUserIdAndTenantId(UUID userId, UUID tenantId) {
        return repository.findByUserIdAndTenantId(userId, tenantId);
    }

    @Override
    public Optional<TenantMembership> findById(UUID membershipId) {
        return repository.findById(membershipId);
    }

    @Override
    public boolean existsByUserIdAndTenantId(UUID userId, UUID tenantId) {
        return repository.existsByUserIdAndTenantId(userId, tenantId);
    }

    @Override
    public TenantMembership save(TenantMembership membership) {
        return repository.save(membership);
    }
}
