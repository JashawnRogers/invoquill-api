package com.jashawnbuilds.invoquill_api.tenant.application.out;

import com.jashawnbuilds.invoquill_api.tenant.domain.tenant.BusinessName;
import com.jashawnbuilds.invoquill_api.tenant.domain.tenant.CompanyCode;
import com.jashawnbuilds.invoquill_api.tenant.domain.tenant.Tenant;

import java.util.Optional;
import java.util.UUID;

public interface TenantRepository {
    Optional<Tenant> findById(UUID id);
    Optional<Tenant> findByCompanyCode(CompanyCode companyCode);
    Optional<Tenant> findByBusinessName(BusinessName businessName);
    void save(Tenant tenant);
}
