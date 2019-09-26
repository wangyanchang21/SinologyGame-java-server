/*
 Navicat Premium Data Transfer

 Source Server         : LocalSQL
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : sinology

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 22/09/2019 22:37:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(64) DEFAULT NULL COMMENT '用户名',
  `userAvatar` varchar(128) DEFAULT NULL COMMENT '头像',
  `userLevel` bigint(20) NOT NULL COMMENT '用户等级',
  `bestPass` bigint(20) NOT NULL COMMENT '最高关卡',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
