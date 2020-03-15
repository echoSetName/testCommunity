CREATE TABLE QUESTION  (
`id` int(0) NOT NULL AUTO_INCREMENT,
`title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
`description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
`gmt_create` bigint(0) NULL DEFAULT NULL,
`gmt_modified` bigint(0) NULL DEFAULT NULL,
`creator` int(0) NULL DEFAULT NULL,
`comment_count` int(255) UNSIGNED ZEROFILL NULL DEFAULT 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000,
`view_count` int(255) UNSIGNED ZEROFILL NULL DEFAULT 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000,
`like_count` int(255) UNSIGNED ZEROFILL NULL DEFAULT 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000,
`tag` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;