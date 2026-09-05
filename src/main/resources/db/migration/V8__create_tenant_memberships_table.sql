CREATE TABLE IF NOT EXISTS tenant_memberships (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,
    tenant_id UUID NOT NULL,
    membership_status VARHCAR(30) NOT NULL,
    joined_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    role_granted_at TIMESTAMPTZ,

    CONSTRAINT fk_tenant_membership_user_id
        FOREIGN KEY (user_id)
        REFERENCES users (id)

    CONSTRAINT fk_tenant_membership_role_id
        FOREIGN KEY (role_id)
        REFERENCES user_roles (id)

    CONSTRAINT fk_tenant_membership_tenant_id
        FOREIGN KEY (tenant_id)
        REFERENCES tenants (id)
);