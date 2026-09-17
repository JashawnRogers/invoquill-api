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
    private LocalDateTime updatedAt;

    private TenantMembership(
            UUID userId,
            UUID tenantId,
            UUID roleId,
            MembershipStatus membershipStatus,
            LocalDateTime joinedAt
    ) {
        this.userId = userId;
        this.tenantId = tenantId;
        this.roleId = roleId;
        this.membershipStatus = membershipStatus;
        this.joinedAt = joinedAt;
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

        return new TenantMembership(
                userId,
                tenantId,
                roleId,
                status,
                joinedAt
        );
    }

    public void changeRole(UUID roleId) {
        if (roleId == null)
            throw new RuntimeException("");

        if (this.roleId.equals(roleId)) return;

        if (this.membershipStatus.equals(MembershipStatus.DEACTIVATED))
            throw new RuntimeException();

        if (this.membershipStatus.equals(MembershipStatus.SUSPENDED))
            throw new RuntimeException();

        this.roleId = roleId;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Intended to temporarily suspend access to tenant.
     */
    public void suspend() {
        if (this.membershipStatus.equals(MembershipStatus.DEACTIVATED))
            throw new RuntimeException();

        if (this.membershipStatus.equals(MembershipStatus.SUSPENDED)) return;

        this.membershipStatus = MembershipStatus.SUSPENDED;
        this.updatedAt = LocalDateTime.now();
    }
}
