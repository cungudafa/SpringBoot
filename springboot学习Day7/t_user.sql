/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : springboot_mysql

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 17/08/2019 16:57:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `t_id` int(11) NOT NULL,
  `t_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_age` int(10) NULL DEFAULT NULL,
  `t_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_password` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '小王', 21, '重庆', 123456);
INSERT INTO `t_user` VALUES (2, 'admin', 22, '重庆', 123456);
INSERT INTO `t_user` VALUES (3, 'min', 19, '北京', 123456);
INSERT INTO `t_user` VALUES (4, 'test', 20, '北京', 123456);
INSERT INTO `t_user` VALUES (5, '小王', 19, '上海', 123456);
INSERT INTO `t_user` VALUES (6, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (7, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (8, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (9, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (10, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (11, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (12, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (13, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (14, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (15, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (16, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (17, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (18, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (19, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (20, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (21, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (22, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (23, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (24, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (25, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (26, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (27, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (28, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (29, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (30, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (31, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (32, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (33, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (34, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (35, 'wang', 21, '上海', 123);
INSERT INTO `t_user` VALUES (36, 'wang', 21, '上海', 123);

SET FOREIGN_KEY_CHECKS = 1;
