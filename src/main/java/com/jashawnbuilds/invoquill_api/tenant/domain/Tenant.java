package com.jashawnbuilds.invoquill_api.tenant.domain;

import com.jashawnbuilds.invoquill_api.shared.domain.Address;
import com.jashawnbuilds.invoquill_api.shared.domain.EmailAddress;
import com.jashawnbuilds.invoquill_api.shared.domain.UsPhoneNumber;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Table("tenants")
public class Tenant {

    @Id
    private UUID id;

    private BusinessName businessName;

    private CompanyCode companyCode;

    private TenantStatus tenantStatus;

    private EmailAddress businessEmail;

   @Embedded.Nullable(prefix = "business_address_")
    private Address businessAddress;

    private UsPhoneNumber businessPhoneNumber;

    private String taxIdentificationNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private Tenant() {}

    private Tenant(
            BusinessName businessName,
            Address businessAddress,
            EmailAddress businessEmail,
            UsPhoneNumber businessPhoneNumber,
            CompanyCode companyCode,
            TenantStatus tenantStatus
    ) {
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessEmail = businessEmail;
        this.businessPhoneNumber = businessPhoneNumber;
        this.companyCode = companyCode;
        this.tenantStatus = tenantStatus;
    }

    public static Tenant create(
            BusinessName businessName,
            Address businessAddress,
            EmailAddress businessEmail,
            UsPhoneNumber businessPhoneNumber
    ) {
        CompanyCode companyCode = CompanyCode.generateFrom(businessName);
        TenantStatus tenantStatus = TenantStatus.ACTIVE;

        return new Tenant(
                businessName,
                businessAddress,
                businessEmail,
                businessPhoneNumber,
                companyCode,
                tenantStatus
        );
    }

    public void updateBusinessName(BusinessName name) {
        if (!this.tenantStatus.equals(TenantStatus.ACTIVE))
            throw new RuntimeException();

        if (this.deletedAt != null)
            throw new RuntimeException();

        this.businessName = name;
        this.companyCode = CompanyCode.generateFrom(name);
        this.updatedAt = LocalDateTime.now();
    }

    public void updateEmail(EmailAddress email) {
        if (!this.tenantStatus.equals(TenantStatus.ACTIVE))
            throw new RuntimeException();

        if (this.deletedAt != null)
            throw new RuntimeException();

        this.businessEmail = email;
        this.updatedAt = LocalDateTime.now();
    }

    public void updatePhoneNumber(UsPhoneNumber phoneNumber) {
        if (!this.tenantStatus.equals(TenantStatus.ACTIVE))
            throw new RuntimeException();

        if (this.deletedAt != null)
            throw new RuntimeException();

        this.businessPhoneNumber = phoneNumber;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateAddress(Address address) {
        if (!this.tenantStatus.equals(TenantStatus.ACTIVE))
            throw new RuntimeException();

        if (this.deletedAt != null)
            throw new RuntimeException();

        this.businessAddress = address;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateTaxIdNumber(String taxIdentificationNumber) {
        if (!this.tenantStatus.equals(TenantStatus.ACTIVE))
            throw new RuntimeException();

        if (this.deletedAt != null)
            throw new RuntimeException();

        if (this.taxIdentificationNumber != null) {
            if (this.taxIdentificationNumber.equals(taxIdentificationNumber))
                return;
        }

        this.taxIdentificationNumber = taxIdentificationNumber;
        this.updatedAt = LocalDateTime.now();
    }

    public void activate() {
        if (this.tenantStatus.equals(TenantStatus.ACTIVE)) return;

        if (this.deletedAt != null)
            throw new RuntimeException();

        this.tenantStatus = TenantStatus.ACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void deactivate() {
        if (this.tenantStatus.equals(TenantStatus.INACTIVE)) return;
        if (this.deletedAt != null) return;

        this.tenantStatus = TenantStatus.INACTIVE;
        this.updatedAt = LocalDateTime.now();
        this.deletedAt = LocalDateTime.now();
    }
}

