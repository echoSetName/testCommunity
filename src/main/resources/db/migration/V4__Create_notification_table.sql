CREATE TABLE notification  (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  notifier bigint NOT NULL,
  notifier_name varchar(100) null,
  receiver bigint NOT NULL,
  outerid bigint NOT NULL,
  outer_title varchar(256) null,
  gmt_create bigint NOT NULL,
  type int NOT NULL,
  status int DEFAULT 0 not null
);