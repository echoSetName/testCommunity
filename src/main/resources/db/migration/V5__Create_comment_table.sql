CREATE TABLE comment  (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  parent_id bigint NOT NULL,
  type int NOT NULL,
  commentator bigint NOT NULL,
  gmt_create bigint NOT NULL,
  gmt_modified bigint NOT NULL,
  like_count bigint DEFAULT 0
) ;