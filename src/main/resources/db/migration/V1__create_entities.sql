-- Create extension for UUID generation (Postgres). Uses uuid-ossp extension.
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Address table
CREATE TABLE IF NOT EXISTS address (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    street VARCHAR(200) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100),
    postal_code VARCHAR(20),
    country VARCHAR(100) NOT NULL,
    CONSTRAINT uk_address_natural UNIQUE (street, city, state, postal_code, country)
);

-- Customer table
CREATE TABLE IF NOT EXISTS customer (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(50),
    details TEXT,
    date_of_birth DATE,
    address_id UUID,
    loyalty_points INTEGER,
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE,
    notes TEXT,
    CONSTRAINT fk_customer_address FOREIGN KEY (address_id) REFERENCES address(id)
);

-- Enforce unique email at DB level (matches @Column(unique=true))
CREATE UNIQUE INDEX IF NOT EXISTS ux_customer_email ON customer (email);

-- Optional: index on address_id for FK lookups
CREATE INDEX IF NOT EXISTS idx_customer_address_id ON customer (address_id);

