CREATE TABLE IF NOT EXISTS user_permissions (
    id UUID PRIMARY KEY,
    resource VARCHAR(100) NOT NULL,
    action VARCHAR(100) NOT NULL,
    description TEXT,
    CONSTRAINT uq_user_permissions UNIQUE (resource, action)
);