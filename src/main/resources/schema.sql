DROP TABLE IF EXISTS MESSAGE;

CREATE TABLE MESSAGE (
  id    BIGINT  PRIMARY KEY AUTO_INCREMENT   NOT NULL,
  text  VARCHAR(255)                         NOT NULL
);