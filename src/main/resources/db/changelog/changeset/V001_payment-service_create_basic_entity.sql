CREATE TABLE bank_account
(
    id                   BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    costumer_id          BIGINT         NOT NULL,
    number               VARCHAR(50)    NOT NULL UNIQUE,
    balance              DECIMAL(19, 4) NOT NULL,
    currency             CHAR(3)        NOT NULL,
    created_at           TIMESTAMPTZ    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at           TIMESTAMPTZ    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    bank_account_version INT            NOT NULL DEFAULT 1
);

CREATE TABLE payment_transaction
(
    id                          BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    amount                      DECIMAL(19, 4) NOT NULL,
    currency                    CHAR(3)        NOT NULL,
    status                      VARCHAR        NOT NULL,
    source_bank_account_id      BIGINT         NOT NULL,
    destination_bank_account_id BIGINT         NOT NULL,
    error_message               VARCHAR,
    created_at                  TIMESTAMPTZ    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at                  TIMESTAMPTZ    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_source_bank_account_id
        FOREIGN KEY (source_bank_account_id)
            REFERENCES bank_account (id)
            ON DELETE CASCADE,
    CONSTRAINT fk_destination_bank_account_id
        FOREIGN KEY (destination_bank_account_id)
            REFERENCES bank_account (id)
            ON DELETE CASCADE

);

CREATE TABLE refund
(
    id                     BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    payment_transaction_id BIGINT         NOT NULL,
    refund_amount          DECIMAL(19, 4) NULL,
    status                 VARCHAR        NOT NULL,
    reason                 TEXT,
    created_at             TIMESTAMPTZ    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at             TIMESTAMPTZ    NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_payment_transaction_id
        FOREIGN KEY (payment_transaction_id)
            REFERENCES payment_transaction (id)
            ON DELETE CASCADE
);