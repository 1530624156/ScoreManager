/*
 Navicat Premium Data Transfer

 Source Server         : MySQL5.7
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : localhost:3306
 Source Schema         : scoremanager

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : 65001

 Date: 27/05/2024 17:54:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `adminpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cid` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程编号',
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程名称',
  `schoolyear` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学年',
  `semester` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学期',
  `credit` float(20, 2) NULL DEFAULT NULL COMMENT '学分',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sid` varchar(24) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cid` varchar(24) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `score` float(8, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` varchar(22) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(48) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `college` varchar(48) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `profession` varchar(48) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `grade` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- View structure for scoreinfo
-- ----------------------------
DROP VIEW IF EXISTS `scoreinfo`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `scoreinfo` AS select `sc`.`uuid` AS `uuid`,`sc`.`sid` AS `sid`,`sc`.`cid` AS `cid`,`sc`.`score` AS `score`,`st`.`name` AS `name`,`co`.`cname` AS `cname`,`co`.`credit` AS `credit`,concat(`co`.`schoolyear`,'-',`co`.`semester`) AS `xnxq` from ((`score` `sc` left join `student` `st` on((`sc`.`sid` = `st`.`sid`))) left join `course` `co` on((`sc`.`cid` = `co`.`cid`)));

SET FOREIGN_KEY_CHECKS = 1;
