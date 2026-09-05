CREATE TABLE IF NOT EXISTS tenant_subscriptions (
    id UUID PRIMARY KEY,
    tenant_id UUID UNIQUE NOT NULL,
    plan_code VARCHAR(30) NOT NULL,
    billing_interval VARCHAR(20) NOT NULL,
    subscription_status VARCHAR(30) NOT NULL,
    grace_period_starts_at TIMESTAMPTZ,
    grace_period_ends_at TIMESTAMPTZ,
    current_period_starts_at TIMESTAMPTZ,
    current_period_ends_at TIMESTAMPTZ,
    cancel_at_period_end BOOLEAN DEFAULT FALSE,
    stripe_customer_id TEXT UNIQUE,
    stripe_subscription_id TEXT UNIQUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ,

    CONSTRAINT fk_tenant_subscriptions_tenant
        FOREIGN KEY (tenant_id)
        REFERENCES tenants (id)
);