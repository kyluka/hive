set hive.format=json;

CREATE TABLE IF NOT EXISTS jsontable (key INT, value STRING) COMMENT 'json table' STORED AS TEXTFILE;

SHOW TABLES;

SHOW TABLES LIKE 'json*';

DESCRIBE jsontable;

DESCRIBE extended jsontable;

DROP TABLE jsontable;

set hive.format=text;
