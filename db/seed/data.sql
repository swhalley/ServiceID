CREATE DATABASE `myDatabase`;

USE `myDatabase`;

CREATE TABLE idTable (
  `label` VARCHAR(10) NOT NULL,
  `nextValue` INT NULL DEFAULT 0,
  PRIMARY KEY (`label`)
  );

/* SEED Data */
INSERT INTO idTable VALUES ( "aService", 0);

/* Stored Procedure */
DROP procedure IF EXISTS `getNextID`;

DELIMITER $$
USE `myDatabase`$$
CREATE DEFINER=`root`@`%` PROCEDURE `getNextID`(
	in inValue VARCHAR(20),
  OUT result INT
)
BEGIN

	START TRANSACTION;
    
    UPDATE idTable 
      SET nextValue = nextValue + 1
      WHERE label = inValue;
         
	  SELECT nextValue INTO result
      FROM idTable 
      WHERE label = inValue;
    
	COMMIT;
END$$

DELIMITER ;

