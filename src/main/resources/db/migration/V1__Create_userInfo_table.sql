CREATE TABLE USERINFO  (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  account_id varchar(100) NOT NULL,
  name varchar(50)  NOT NULL,
  token char(36),
  gmt_create bigint DEFAULT 0,
  gmt_modified bigint DEFAULT 0,
  avatar_url VARCHAR(100) NULL
)