
-- 创建mytest数据库
CREATE DATABASE mytest;

-- 创建tb_user表格
CREATE TABLE tb_user (
  userId       INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userName     VARCHAR(255) NOT NULL,
  userPassword VARCHAR(255) NOT NULL,
  userPhone    VARCHAR(255) NOT NULL
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;