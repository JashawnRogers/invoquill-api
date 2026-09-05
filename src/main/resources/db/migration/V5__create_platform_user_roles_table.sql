CREATE TABLE IF NOT EXISTS platform_user_roles (
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,
    granted_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    granted_by UUID NOT NULL,

    CONSTRAINT pk_platform_user_roles
        PRIMARY KEY (user_id, role_id)

    CONSTRAINT fk_platform_user_roles_user_id
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE,

    CONSTRAINT fk_platform_user_roles_role_id
        FOREIGN KEY (role_id)
        REFERENCES user_roles (id)
        ON DELETE CASCADE
);