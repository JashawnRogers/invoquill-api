package com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence;

import com.jashawnbuilds.invoquill_api.tenant.application.out.TenantRepository;
import com.jashawnbuilds.invoquill_api.tenant.domain.BusinessName;
import com.jashawnbuilds.invoquill_api.tenant.domain.CompanyCode;
import com.jashawnbuilds.invoquill_api.tenant.domain.Tenant;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JdbcTenantRepository implements TenantRepository {

    private final SpringDataTenantRepository repository;

    public JdbcTenantRepository(SpringDataTenantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Tenant> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Tenant> findByCompanyCode(CompanyCode companyCode) {
        return repository.findByCompanyCode(companyCode);
    }

    @Override
    public Optional<Tenant> findByBusinessName(BusinessName businessName) {
        return repository.findByBusinessName(businessName);
    }

    @Override
    public void save(Tenant tenant) {
        repository.save(tenant);
    }
}
