/*
Navicat MySQL Data Transfer

Source Server         : master@Centos
Source Server Version : 80019
Source Host           : 192.168.170.128:3306
Source Database       : miaosha

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-03-30 16:05:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint NOT NULL,
  `goods_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品名称',
  `goods_title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品标题',
  `goods_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品的图片',
  `goods_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '商品的详情介绍',
  `goods_price` decimal(10,2) DEFAULT '0.00' COMMENT '商品的单价',
  `goods_stock` int DEFAULT NULL COMMENT '商品的库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'iphoneX', 'Apple iphone x 苹果X (A1865) 全网通4G手机 银色 256GB', 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/48897/36/1245/426422/5cefee1cE6d3a34a7/f6627df06c448a55.png', '屏幕尺寸5.8英寸，重量174克，高度143.6mm，宽度和厚度分别为70.9mm、7.7mm，2436 * 1125 像素分辨率，458 ppi。\r\n背部后置双摄，为1200万像素广角镜头（F/1.8光圈）+1200万像素长焦镜头（F/2.4光圈）组合，支持人像模式背景虚化。\r\n电池容量为2716mAh。 [8] \r\n处理器：A11 Bionic采用6核64位架构，集成M11运动协处理器，A11比A10运行速度提升70%，苹果自主研发的GPU性能则提升30%。', '8765.00', '10000');
INSERT INTO `goods` VALUES ('2', '华为mate9', '华为（HUAWEI） 华为 Mate9 移动联通电信 全网通4G 智能手机 双卡双待 黑色 (6G RAM+128G ROM)', 'https://bkimg.cdn.bcebos.com/pic/d0c8a786c9177f3e1057f33f7bcf3bc79f3d56a4?x-bce-process=image/resize,m_lfit,w_268,limit_1/format,f_jpg', '造型设计：直板\r\n机身颜色：陶瓷白、香槟金、摩卡金、月光银、玫瑰金、苍穹灰、黑色、 [4]  帕托蓝、玛瑙红 [4]  。\r\n材质：航空级铝合金\r\n工艺：精选球面型陶瓷珠砂，粒径控制在0.45um级别；利用隧道旋转式高压气枪进行全方位的3D喷覆。\r\n尺寸：156.9×78.9×7.9mm [3]  [5] \r\n重量：190g', '3212.00', '-1');

-- ----------------------------
-- Table structure for miaosha_goods
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_goods`;
CREATE TABLE `miaosha_goods` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '秒杀的商品id',
  `goods_id` bigint DEFAULT NULL COMMENT '商品id',
  `miaosha_price` decimal(10,2) DEFAULT '0.00' COMMENT '秒杀价',
  `stock_count` int DEFAULT NULL COMMENT '库存数量',
  `start_date` datetime DEFAULT NULL COMMENT '秒杀开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '秒杀结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='秒杀的商品列表';

-- ----------------------------
-- Records of miaosha_goods
-- ----------------------------
INSERT INTO `miaosha_goods` VALUES ('1', '1', '0.01', '9', '2020-03-30 14:55:57', '2020-03-30 16:55:59');
INSERT INTO `miaosha_goods` VALUES ('2', '2', '0.01', '10', '2020-03-30 14:56:21', '2020-03-30 14:56:24');

-- ----------------------------
-- Table structure for miaosha_order
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_order`;
CREATE TABLE `miaosha_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `order_id` bigint DEFAULT NULL COMMENT '订单id',
  `goods_id` bigint DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of miaosha_order
-- ----------------------------
INSERT INTO `miaosha_order` VALUES ('1', '13211046190', '1', '1');

-- ----------------------------
-- Table structure for miaosha_user
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_user`;
CREATE TABLE `miaosha_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id，手机号码',
  `nickname` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `salt` varchar(10) DEFAULT NULL,
  `head` varchar(128) DEFAULT NULL COMMENT '头像，云存储的Id',
  `register_date` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login` datetime DEFAULT NULL COMMENT '上次登录时间',
  `login_count` bigint DEFAULT NULL COMMENT '登录次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13211046191 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of miaosha_user
-- ----------------------------
INSERT INTO `miaosha_user` VALUES ('13211046190', 'admin', 'b7797cce01b4b131b433b6acf4add449', '1a2b3c4d', null, '2020-03-28 15:55:12', '2020-03-28 15:55:15', '1');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `goods_id` bigint DEFAULT NULL COMMENT '商品id',
  `delivery_addr_id` bigint DEFAULT NULL COMMENT '收获地址Id',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '冗余过来的商品名称',
  `goods_count` varchar(255) DEFAULT NULL COMMENT '商品数量',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品的单价',
  `order_channel` tinyint DEFAULT NULL COMMENT '1为pc,2为Android，3为ios',
  `status` tinyint DEFAULT NULL COMMENT '订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成',
  `create_date` datetime DEFAULT NULL COMMENT '订单的创建时间',
  `pay_date` datetime DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('3', '13211046190', '1', null, 'iphoneX', '1', '0.01', '1', '0', '2020-03-30 16:03:59', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin');
