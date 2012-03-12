set hive.format=json;

CREATE DATABASE IF NOT EXISTS db1 COMMENT 'Test database' LOCATION '${hiveconf:hive.metastore.warehouse.dir}/db1' WITH DBPROPERTIES ('id' = 'db1'); 

DESCRIBE DATABASE db1;

DESCRIBE DATABASE EXTENDED db1;

DROP DATABASE db1;

CREATE DATABASE db1;

DESCRIBE DATABASE db1;

DESCRIBE DATABASE EXTENDED db1;

DROP DATABASE db1;

set hive.format=text;
