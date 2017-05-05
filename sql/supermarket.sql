/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : supermarket

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2017-04-28 12:00:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for duty
-- ----------------------------
DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty` (
  `id` int(30) NOT NULL auto_increment,
  `dutyName` varchar(30) default NULL,
  `description` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of duty
-- ----------------------------
INSERT INTO `duty` VALUES ('2', '经理', '负责管理超市各种事情');
INSERT INTO `duty` VALUES ('3', '销售经理', '主管销售');
INSERT INTO `duty` VALUES ('4', '业务员', '联络业务');
INSERT INTO `duty` VALUES ('6', '店长', '管理分店的负责人');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(30) NOT NULL auto_increment,
  `goodsName` varchar(30) default NULL,
  `goodsBewrite` varchar(30) default NULL,
  `units` varchar(10) default NULL,
  `stockPrice` float(10,2) unsigned zerofill default '0000000.00',
  `retailPrice` float(10,2) unsigned zerofill default '0000000.00',
  `associatorPrice` float(10,2) unsigned zerofill default '0000000.00',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '小涴熊方便面', '食品', '袋', '0000000.80', '0000001.10', '0000000.90');
INSERT INTO `goods` VALUES ('2', '海飞丝洗发露', '生活品', '瓶', '0000019.80', '0000025.33', '0000022.60');
INSERT INTO `goods` VALUES ('3', '手机', '超长待机', '部', '0002350.00', '0002700.00', '0002599.00');
INSERT INTO `goods` VALUES ('5', '美好时光海苔', '食品', '袋', '0000002.30', '0000003.00', '0000002.60');
INSERT INTO `goods` VALUES ('6', '康师傅桶装方便面', '食品', '桶', '0000003.01', '0000004.00', '0000003.50');
INSERT INTO `goods` VALUES ('7', '空调', '家电', '台', '0001899.00', '0002600.00', '0002300.00');
INSERT INTO `goods` VALUES ('8', '空调', '家电', '台', '0001600.00', '0002000.00', '0001988.00');
INSERT INTO `goods` VALUES ('10', '笔记本', '文具', '本', '0000000.90', '0000001.50', '0000001.30');
INSERT INTO `goods` VALUES ('11', '电视', '家电', '台', '0000999.00', '0001999.00', '0001888.00');
INSERT INTO `goods` VALUES ('12', '方便面', '吃的', '袋', '0000001.00', '0000001.52', '0000001.30');

-- ----------------------------
-- Table structure for seller
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `id` int(20) NOT NULL auto_increment,
  `name` varchar(30) default '',
  `address` varchar(30) default NULL,
  `linkman` varchar(30) default NULL,
  `linkPhone` varchar(30) default NULL,
  `faxes` varchar(30) default NULL,
  `postNum` varchar(30) default NULL,
  `bankNum` varchar(30) default NULL,
  `netAddress` varchar(30) default NULL,
  `emailAddress` varchar(30) default NULL,
  `remark` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO `seller` VALUES ('18', '是多大', '', '', '', '', '', '', '', '', '');
INSERT INTO `seller` VALUES ('31', '看书是是是试试多对多', '1', '1', '4', '5', '6', '', '8', '9', '10');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(30) NOT NULL auto_increment,
  `sNmae` varchar(255) default NULL,
  `orderId` varchar(30) default NULL,
  `consignmentDate` varchar(30) default NULL,
  `goodsNsme` varchar(30) default NULL,
  `count` int(30) default NULL,
  `money` varchar(30) default NULL,
  `isInStock` int(30) default '0',
  `warehouseId` int(30) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(20) NOT NULL auto_increment,
  `name` varchar(30) default '',
  `address` varchar(30) default NULL,
  `provide` varchar(30) default NULL,
  `linkman` varchar(30) default NULL,
  `linkPhone` varchar(30) default NULL,
  `faxes` varchar(30) default NULL,
  `postNum` varchar(30) default NULL,
  `bankNum` varchar(30) default NULL,
  `netAddress` varchar(30) default NULL,
  `emailAddress` varchar(30) default NULL,
  `remark` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('3', '伊利乳业', '内蒙古', '奶制品', '张宝军', '3546432', '3524654', '11548', '254563532648975', 'www.yili.com', 'zhangbao@163.com', '没有保鲜奶奶制品000000');
INSERT INTO `supplier` VALUES ('5', '中华', '北京', '香烟', '张三', '1214545', '', '', '', '', '', '');
INSERT INTO `supplier` VALUES ('8', '看书', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10');
INSERT INTO `supplier` VALUES ('9', '看书', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10');
INSERT INTO `supplier` VALUES ('11', '哇集团', '常州', '饮料', '张涛', '12545354', '54432', '5445354', '7872575864415', 'www.wahaha.com', 'zhangtao@163.com', '无');
INSERT INTO `supplier` VALUES ('12', '乐事集团', '北京', '乐事薯片', '王', '186454645', '56745', '34564', '4527', '74825', 'wang@163.com', '无');
INSERT INTO `supplier` VALUES ('13', '保洁集团', '北京', '卫生用具', '李', '156445786', '4545745', '545745', '4545', '4543', 'li@163.com', '无');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(30) NOT NULL auto_increment,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123123');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  `principal` varchar(30) default NULL,
  `bewrite` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('1', '酒水仓库', '小二黑', '酒水饮料放置地');
INSERT INTO `warehouse` VALUES ('2', '粮油仓库', '小一黑', '粮油放置地');
INSERT INTO `warehouse` VALUES ('3', '食品仓库', '黑子2', '存放食品的仓库');
INSERT INTO `warehouse` VALUES ('4', '家电仓库', '小白', '存放家电的仓库');
