CREATE TABLE IF NOT EXISTS tenants (
    id UUID PRIMARY KEY,
    business_name TEXT NOT NULL,
    company_code VARCHAR(9) UNIQUE NOT NULL,
    tenant_status VARCHAR(30) NOT NULL,
    business_email TEXT NOT NULL,
    business_address TEXT NOT NULL,
    business_phone_number VARCHAR(20),
    tax_identification_number VARCHAR(9) UNIQUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ,
    deleted_at TIMESTAMPTZ
);