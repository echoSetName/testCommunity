CREATE TABLE QUESTION  (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
title varchar(50),
description text,
gmt_create bigint DEFAULT 0,
gmt_modified BIGINT DEFAULT 0,
creator bigint DEFAULT NULL,
comment_count int DEFAULT 0,
view_count int DEFAULT 0,
like_count int DEFAULT 0,
tag varchar(256) DEFAULT NULL
);
