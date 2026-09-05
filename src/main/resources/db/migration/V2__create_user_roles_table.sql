CREATE TABLE IF NOT EXISTS user_roles (
    id UUID PRIMARY KEY,
    name VARCHAR(100) UNIQUE,
    description TEXT,
    role_scope VARCHAR(20)
);