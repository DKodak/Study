/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50549
 Source Host           : localhost:3306
 Source Schema         : springbootdb

 Target Server Type    : MySQL
 Target Server Version : 50549
 File Encoding         : 65001

 Date: 19/10/2018 12:30:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NULL',
  `phone` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NULL',
  `address` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NULL',
  `email` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NULL',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张6', '11111111111', '江干区', '111@qq.com');
INSERT INTO `user` VALUES (2, '李四', '22222222222', '拱墅区', '222@qq.com');
INSERT INTO `user` VALUES (3, '王五', '33333333333', '西湖区', '333@qq.com');
INSERT INTO `user` VALUES (4, 'bye ONCE', '18258821917', '江干区笕桥镇', '2785068439@qq.com');
INSERT INTO `user` VALUES (6, 'dsadsa', '1', 'dadsa', 'dsa@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
