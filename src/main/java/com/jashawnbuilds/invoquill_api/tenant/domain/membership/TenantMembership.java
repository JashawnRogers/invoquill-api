package com.jashawnbuilds.invoquill_api.tenant.domain.membership;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Table(name = "tenant_memberships")
public class TenantMembership {

    @Id
    private UUID id;
    private final UUID userId;
    private final UUID tenantId;
    private UUID roleId;
    private MembershipStatus membershipStatus;
    private final LocalDateTime joinedAt;
    private LocalDateTime roleGrantedAt;

    private TenantMembership(
            UUID userId,
            UUID tenantId,
            UUID roleId,
            MembershipStatus membershipStatus,
            LocalDateTime joinedAt,
            LocalDateTime roleGrantedAt
    ) {
        this.userId = userId;
        this.tenantId = tenantId;
        this.roleId = roleId;
        this.membershipStatus = membershipStatus;
        this.joinedAt = joinedAt;
        this.roleGrantedAt = roleGrantedAt;
    }

    public static TenantMembership create(
            UUID userId,
            UUID tenantId,
            UUID roleId
    ) {
        if (userId == null)
            throw new RuntimeException("");

        if (tenantId == null)
            throw new RuntimeException("");

        if (roleId == null)
            throw new RuntimeException("");

        MembershipStatus status = MembershipStatus.ACTIVE;
        LocalDateTime joinedAt = LocalDateTime.now();
        LocalDateTime roleGrantedAt = LocalDateTime.now();

        return new TenantMembership(
                userId,
                tenantId,
                roleId,
                status,
                joinedAt,
                roleGrantedAt
        );
    }
}
