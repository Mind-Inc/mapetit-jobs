CREATE TABLE company_profile (
     company_id BIGSERIAL PRIMARY KEY NOT NULL,
     name VARCHAR(100) NOT NULL,
     handle VARCHAR(100) NOT NULL,
     logo VARCHAR(1000),
     website VARCHAR(1000),
     address VARCHAR(1000),
     industry VARCHAR(1000),
     company_type VARCHAR(1000),
     tagline TEXT,
     mission TEXT,
     purpose TEXT,
     value_and_culture TEXT,
     short_description TEXT,
     long_description TEXT,
     workplace_policy TEXT,
     company_growth_description TEXT,
     company_size INT NOT NULL,
     creator_user_name VARCHAR(1000),
     created_at timestamp with time zone NOT null default CURRENT_TIMESTAMP,
     updated_at timestamp with time zone NOT null default CURRENT_TIMESTAMP
);

CREATE TABLE job (
     job_id BIGSERIAL PRIMARY KEY NOT NULL,
     company_id BIGINT REFERENCES "company_profile"(company_id) NOT NULL,
     title VARCHAR(100) NOT NULL,
     job_location VARCHAR(1000) NOT NULL,
     job_type VARCHAR(1000),
     employment_type VARCHAR(1000),
     description TEXT,
     terms_and_condition TEXT,
     posted_on timestamp with time zone NOT null,
     valid_until timestamp with time zone NOT null,
     created_at timestamp with time zone NOT null default CURRENT_TIMESTAMP,
     updated_at timestamp with time zone NOT null default CURRENT_TIMESTAMP
);

CREATE TABLE job_qualification (
    qualification_id BIGSERIAL PRIMARY KEY NOT NULL,
    job_id BIGINT REFERENCES "job"(job_id) NOT NULL,
    qualification_type VARCHAR(100) NOT NULL,
    qualification TEXT  NOT NULL,
    created_at timestamp with time zone NOT null default CURRENT_TIMESTAMP,
    updated_at timestamp with time zone NOT null default CURRENT_TIMESTAMP
);

CREATE TABLE job_responsibility (
    responsibility_id BIGSERIAL PRIMARY KEY NOT NULL,
    job_id BIGINT REFERENCES "job"(job_id) NOT NULL,
    responsibility TEXT  NOT NULL,
    created_at timestamp with time zone NOT null default CURRENT_TIMESTAMP,
    updated_at timestamp with time zone NOT null default CURRENT_TIMESTAMP
);

CREATE TABLE job_contact (
     contact_id BIGSERIAL PRIMARY KEY NOT NULL,
     job_id BIGINT REFERENCES "job"(job_id) NOT NULL,
     contact_type VARCHAR(100) NOT NULL,
     contact TEXT  NOT NULL,
     created_at timestamp with time zone NOT null default CURRENT_TIMESTAMP,
     updated_at timestamp with time zone NOT null default CURRENT_TIMESTAMP
);