/*
 Navicat Premium Data Transfer

 Source Server         : jzh
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : homework2

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 07/01/2023 16:21:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for 宿舍成员表
-- ----------------------------
DROP TABLE IF EXISTS `宿舍成员表`;
CREATE TABLE `宿舍成员表`  (
  `memberid` int(0) NOT NULL,
  `membername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dormitoryid` int(0) NOT NULL,
  `record` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`memberid`) USING BTREE,
  INDEX `dormitoryid`(`dormitoryid`) USING BTREE,
  CONSTRAINT `dormitoryid` FOREIGN KEY (`dormitoryid`) REFERENCES `宿舍表` (`dormitoryid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `memberid` FOREIGN KEY (`memberid`) REFERENCES `用户信息表` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 宿舍成员表
-- ----------------------------
INSERT INTO `宿舍成员表` VALUES (1005, '456', 612, 1);
INSERT INTO `宿舍成员表` VALUES (1006, '333', 612, 0);
INSERT INTO `宿舍成员表` VALUES (1007, '444', 612, 0);
INSERT INTO `宿舍成员表` VALUES (1008, '1111', 612, 0);
INSERT INTO `宿舍成员表` VALUES (20201002, 'ljy', 612, 1);

-- ----------------------------
-- Table structure for 宿舍表
-- ----------------------------
DROP TABLE IF EXISTS `宿舍表`;
CREATE TABLE `宿舍表`  (
  `dormitoryid` int(0) NOT NULL,
  `leaderid` int(0) NOT NULL,
  `classid` int(0) NOT NULL,
  PRIMARY KEY (`dormitoryid`) USING BTREE,
  INDEX `classid`(`classid`) USING BTREE,
  INDEX `leaderid`(`leaderid`) USING BTREE,
  CONSTRAINT `classid` FOREIGN KEY (`classid`) REFERENCES `班级表` (`classid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `leaderid` FOREIGN KEY (`leaderid`) REFERENCES `用户信息表` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 宿舍表
-- ----------------------------
INSERT INTO `宿舍表` VALUES (612, 1001, 1001);

-- ----------------------------
-- Table structure for 班级表
-- ----------------------------
DROP TABLE IF EXISTS `班级表`;
CREATE TABLE `班级表`  (
  `classid` int(0) NOT NULL AUTO_INCREMENT,
  `classname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`classid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1001 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 班级表
-- ----------------------------
INSERT INTO `班级表` VALUES (1001, '软件204');

-- ----------------------------
-- Table structure for 用户信息表
-- ----------------------------
DROP TABLE IF EXISTS `用户信息表`;
CREATE TABLE `用户信息表`  (
  `userid` int(0) NOT NULL,
  `userpwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usergender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usernumber` int(0) NOT NULL,
  `role` int(0) NOT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 用户信息表
-- ----------------------------
INSERT INTO `用户信息表` VALUES (1001, '123456', 'gjx', '男', 371001, 1);
INSERT INTO `用户信息表` VALUES (1005, '123456', '456', '男', 111, 0);
INSERT INTO `用户信息表` VALUES (1006, '123', '333', '男', 333, 0);
INSERT INTO `用户信息表` VALUES (1007, '123', '444', '男', 444, 0);
INSERT INTO `用户信息表` VALUES (1008, '123', '1111', '男', 111, 0);
INSERT INTO `用户信息表` VALUES (11111111, 'admin', 'admin', '男', 123, 2);
INSERT INTO `用户信息表` VALUES (20201002, '123456', 'ljy', '男', 371002, 0);

-- ----------------------------
-- Table structure for 考勤表
-- ----------------------------
DROP TABLE IF EXISTS `考勤表`;
CREATE TABLE `考勤表`  (
  `memberid` int(0) NOT NULL,
  `record` int(0) NOT NULL,
  PRIMARY KEY (`memberid`, `record`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 考勤表
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
