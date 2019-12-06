/*
Navicat MySQL Data Transfer

Source Server         : gg
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : springmvc

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-12-06 16:12:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for testmybaits
-- ----------------------------
DROP TABLE IF EXISTS `testmybaits`;
CREATE TABLE `testmybaits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testmybaits
-- ----------------------------
INSERT INTO `testmybaits` VALUES ('1', 'tom', '1', '1@gkm');
INSERT INTO `testmybaits` VALUES ('2', 'zs', '0', 'hh@');
INSERT INTO `testmybaits` VALUES ('3', 'gk', '0', 'gk@123');
INSERT INTO `testmybaits` VALUES ('4', 'gk', '0', 'gk@123');
INSERT INTO `testmybaits` VALUES ('5', 'gkm', '0', 'gkm@2');
INSERT INTO `testmybaits` VALUES ('6', 'gkm', '1', '111@2');
INSERT INTO `testmybaits` VALUES ('7', 'laoliu', '1', '111@2');
INSERT INTO `testmybaits` VALUES ('14', 'zs', '0', '111@111');
INSERT INTO `testmybaits` VALUES ('15', 'zs', '0', '111@111');
INSERT INTO `testmybaits` VALUES ('16', 'gkm', '1', '111@2');
INSERT INTO `testmybaits` VALUES ('18', '111gkm', '0', '111@2');
INSERT INTO `testmybaits` VALUES ('19', '666laoliu', '1', '111@2');
INSERT INTO `testmybaits` VALUES ('20', '77777laoliu', '1', '111@2');
INSERT INTO `testmybaits` VALUES ('21', '77777laoliu', '1', '111@2');
INSERT INTO `testmybaits` VALUES ('22', 'laoliu', '1', '111@2');
INSERT INTO `testmybaits` VALUES ('23', 'laoliu', '1', '111@2');
INSERT INTO `testmybaits` VALUES ('24', 'laoliu', '1', '111@2');
INSERT INTO `testmybaits` VALUES ('25', 'laoliu', '1', '111@2');
