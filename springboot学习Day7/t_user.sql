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

 Date: 14/08/2019 18:46:14
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
INSERT INTO `t_user` VALUES (2, 'admin', 22, 'chongqing', 123456);
INSERT INTO `t_user` VALUES (3, 'min', 19, 'beijing', 123456);
INSERT INTO `t_user` VALUES (4, 'test', 20, 'beijing', 123456);
INSERT INTO `t_user` VALUES (5, NULL, 19, 'shanghai', 123456);

SET FOREIGN_KEY_CHECKS = 1;
