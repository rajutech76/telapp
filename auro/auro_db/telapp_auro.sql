SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `telapp_auro`.`auro_auth`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `telapp_auro`.`auro_auth` ;

CREATE TABLE IF NOT EXISTS `telapp_auro`.`auro_auth` (
  `auth_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `create_time` DATETIME NULL,
  `update_time` DATETIME NULL,
  `created_user` VARCHAR(45) NULL DEFAULT 'system',
  PRIMARY KEY (`auth_id`),
  UNIQUE INDEX `auth_id_UNIQUE` (`auth_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `telapp_auro`.`auro_slot_reg`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `telapp_auro`.`auro_slot_reg` ;

CREATE TABLE IF NOT EXISTS `telapp_auro`.`auro_slot_reg` (
  `idauro_slot_reg` INT NOT NULL AUTO_INCREMENT,
  `slot_name` VARCHAR(45) NULL,
  `slot_location` VARCHAR(250) NULL,
  `slot_description` VARCHAR(45) NULL,
  PRIMARY KEY (`idauro_slot_reg`),
  UNIQUE INDEX `idauro_slot_reg_UNIQUE` (`idauro_slot_reg` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `telapp_auro`.`auro_device_reg`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `telapp_auro`.`auro_device_reg` ;

CREATE TABLE IF NOT EXISTS `telapp_auro`.`auro_device_reg` (
  `idauro_device_reg` INT NOT NULL AUTO_INCREMENT,
  `device_name` VARCHAR(45) NULL,
  `device_mac_id` VARCHAR(250) NULL,
  `slot_Id` INT NULL,
  PRIMARY KEY (`idauro_device_reg`),
  UNIQUE INDEX `idauro_device_reg_UNIQUE` (`idauro_device_reg` ASC),
  UNIQUE INDEX `device_mac_id_UNIQUE` (`device_mac_id` ASC),
  INDEX `fk_auro_device_reg_1_idx` (`slot_Id` ASC),
  CONSTRAINT `fk_auro_device_reg_1`
    FOREIGN KEY (`slot_Id`)
    REFERENCES `telapp_auro`.`auro_slot_reg` (`idauro_slot_reg`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `telapp_auro`.`auro_slot_statistics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `telapp_auro`.`auro_slot_statistics` ;

CREATE TABLE IF NOT EXISTS `telapp_auro`.`auro_slot_statistics` (
  `idauro_slot_statistics` INT NOT NULL AUTO_INCREMENT,
  `device_id` INT NULL,
  `slot_status` INT NULL,
  `upated_time` DATETIME NULL,
  PRIMARY KEY (`idauro_slot_statistics`),
  UNIQUE INDEX `idauro_slot_statistics_UNIQUE` (`idauro_slot_statistics` ASC),
  UNIQUE INDEX `device_id_UNIQUE` (`device_id` ASC),
  CONSTRAINT `fk_auro_slot_statistics_1`
    FOREIGN KEY (`device_id`)
    REFERENCES `telapp_auro`.`auro_device_reg` (`idauro_device_reg`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `telapp_auro`.`Auro_log_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `telapp_auro`.`Auro_log_table` ;

CREATE TABLE IF NOT EXISTS `telapp_auro`.`Auro_log_table` (
  `auro_log_id` INT NOT NULL AUTO_INCREMENT,
  `device_name` VARCHAR(45) NULL,
  `device_mac_id` VARCHAR(250) NULL,
  `slotname` VARCHAR(45) NULL,
  `slotstatus` INT NULL,
  `created_time` DATETIME NULL,
  PRIMARY KEY (`auro_log_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
