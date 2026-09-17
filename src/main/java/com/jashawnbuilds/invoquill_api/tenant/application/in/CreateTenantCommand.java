package com.jashawnbuilds.invoquill_api.tenant.application.in;

import com.jashawnbuilds.invoquill_api.shared.domain.Address;
import com.jashawnbuilds.invoquill_api.shared.domain.EmailAddress;
import com.jashawnbuilds.invoquill_api.shared.domain.UsPhoneNumber;
import com.jashawnbuilds.invoquill_api.tenant.domain.tenant.BusinessName;

public record CreateTenantCommand(
        BusinessName businessName,
        Address businessAddress,
        EmailAddress businessEmail,
        UsPhoneNumber businessPhoneNumber
) {
}
