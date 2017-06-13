CREATE TABLE useraccount (
       id BIGINT NOT NULL AUTO_INCREMENT
     , email VARCHAR (150) NOT NULL
     , password VARCHAR (100) NOT NULL
     , authority ENUM ('ROLE_NONE', 'ROLE_ADMIN', 'ROLE_APPLICANT', 'ROLE_UNDERWRITER', 'ROLE_ENGINE') NOT NULL
     , disabled BOOLEAN NOT NULL DEFAULT FALSE
     , PRIMARY KEY (id)
     , INDEX (email)
     , UNIQUE (email)
)ENGINE=InnoDB;

CREATE TABLE applicant (
       id BIGINT NOT NULL
     , surname VARCHAR (50) NOT NULL
     , middleNames VARCHAR (50)
     , name VARCHAR (50) NOT NULL
     , PRIMARY KEY (id)
     , FOREIGN KEY (id) REFERENCES useraccount (id)
     , INDEX (name)
     , INDEX (surname)
)ENGINE=InnoDB;

CREATE TABLE loanprovider (
       id Integer NOT NULL AUTO_INCREMENT
     , name VARCHAR (150) NOT NULL
     , address VARCHAR (200) NOT NULL
     , telephone CHAR (15) NOT NULL
     , PRIMARY KEY (id)
     , INDEX (name)
)ENGINE=InnoDB;

CREATE TABLE loantype (
       id BIGINT NOT NULL AUTO_INCREMENT
     , loanProviderId Integer NOT NULL
     , term Integer NOT NULL
     , rate Float NOT NULL
     , fee Float NOT NULL DEFAULT 0
     , maximumAmount Integer
     , PRIMARY KEY (id)
     , FOREIGN KEY (loanProviderId) REFERENCES loanprovider (id)
)ENGINE=InnoDB;

CREATE TABLE loanapplication (
       id BIGINT NOT NULL AUTO_INCREMENT
     , applicantId BIGINT NOT NULL
     , loanTypeId BIGINT NOT NULL
     , appliedAmount Integer NOT NULL
     , approvedAmount Integer
     , applicationTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
     , lastUpdatedTime timestamp NOT NULL
     , status ENUM ('STATUS_APPLY', 'STATUS_SUBMITTED', 'STATUS_PENDING', 'STATUS_APPROVED', 'STATUS_REJECTED') NOT NULL
     , PRIMARY KEY (id)
     , FOREIGN KEY (applicantId) REFERENCES loanprovider (id)
     , INDEX (applicantId)
     , INDEX (status)
     , FOREIGN KEY (loanTypeId) REFERENCES loantype (id)
)ENGINE=InnoDB;

CREATE TABLE loanapplicationprogress (
       id BIGINT NOT NULL AUTO_INCREMENT
     , loanApplicationId BIGINT NOT NULL
     , userAccountId BIGINT NOT NULL
     , updatedTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
     , previousStatus ENUM ('STATUS_APPLY', 'STATUS_SUBMITTED', 'STATUS_PENDING', 'STATUS_APPROVED', 'STATUS_REJECTED') NOT NULL
     , currentStatus ENUM ('STATUS_APPLY', 'STATUS_SUBMITTED', 'STATUS_PENDING', 'STATUS_APPROVED', 'STATUS_REJECTED') NOT NULL
     , notificationSent BOOLEAN NOT NULL DEFAULT FALSE
     , info VARCHAR (500)
     , PRIMARY KEY (id)
     , INDEX (loanapplicationId)
     , FOREIGN KEY (loanApplicationId) REFERENCES loanapplication (id)
     , FOREIGN KEY (userAccountId) REFERENCES useraccount (id)
     , INDEX (notificationSent, currentStatus, previousStatus)
)ENGINE=InnoDB;

CREATE TABLE auditlog (
       id INTEGER NOT NULL AUTO_INCREMENT
     , userAccountId BIGINT
     , logTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
     , info VARCHAR (500)
     , PRIMARY KEY (id)
     , INDEX (userAccountId)
)ENGINE=InnoDB;
