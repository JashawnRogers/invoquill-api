package com.jashawnbuilds.invoquill_api.tenant.adapter.out.persistence;

import com.jashawnbuilds.invoquill_api.tenant.domain.BusinessName;
import com.jashawnbuilds.invoquill_api.tenant.domain.CompanyCode;
import com.jashawnbuilds.invoquill_api.tenant.domain.Tenant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataTenantRepository extends CrudRepository<Tenant, UUID> {

    Optional<Tenant> findByCompanyCode(CompanyCode companyCode);
    Optional<Tenant> findByBusinessName(BusinessName businessName);
}
