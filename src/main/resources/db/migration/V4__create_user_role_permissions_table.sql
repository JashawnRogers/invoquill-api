CREATE TABLE IF NOT EXISTS user_role_permissions (
    role_id UUID NOT NULL,
    permission_id UUID NOT NULL,

    CONSTRAINT pk_user_role_permissions
        PRIMARY KEY (role_id, permission_id),

    CONSTRAINT fk_user_role_permissions_role
        FOREIGN KEY (role_id)
        REFERENCES user_roles (id)
        ON DELETE CASCADE,

    CONSTRAINT fk_user_role_permissions_permission
        FOREIGN KEY (permission_id)
        REFERENCES user_permissions (id)
        ON DELETE CASCADE
);