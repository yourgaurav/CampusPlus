
ALTER TABLE users
ADD COLUMN department_id BIGINT NULL;

ALTER TABLE users
    ADD CONSTRAINT fk_users_deparment
        FOREIGN KEY (department_id)
            REFERENCES departments(id);