CREATE TABLE `taskManager`.`userAccount` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `user_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
