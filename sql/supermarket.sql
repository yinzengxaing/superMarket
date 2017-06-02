/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : supermarket

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2017-06-02 15:52:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `depName` varchar(30) DEFAULT NULL,
  `principal` varchar(30) DEFAULT NULL,
  `description` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '收银部门', '小陈', '负责收银');
INSERT INTO `department` VALUES ('3', '销售部门', '李思', '销售相关');
INSERT INTO `department` VALUES ('7', '客服部', '小张', '服务客户');

-- ----------------------------
-- Table structure for duty
-- ----------------------------
DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `dutyName` varchar(30) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of duty
-- ----------------------------
INSERT INTO `duty` VALUES ('2', '经理', '负责管理超市各种事情');
INSERT INTO `duty` VALUES ('3', '销售经理', '主管销售');
INSERT INTO `duty` VALUES ('4', '业务员', '联络业务');
INSERT INTO `duty` VALUES ('6', '店长', '管理分店的负责人');
INSERT INTO `duty` VALUES ('7', '普通员工', '普通员工');
INSERT INTO `duty` VALUES ('8', '防损员', '检查物品是否损坏');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `age` int(30) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `duty` varchar(30) DEFAULT NULL,
  `department` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `officePhone` varchar(30) DEFAULT NULL,
  `fax` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('3', '连娜娜', '29', '女', '业务员', '销售部门', '15654785984', '2245426', '2245551', '15463455@qq.com', '郑州金水区');
INSERT INTO `employee` VALUES ('6', '张三', '36', '男', '销售经理', '销售部门', '15698545632', '156565655', '256542', '156942@qq.com', '郑州二七区');
INSERT INTO `employee` VALUES ('7', '张三ssssss', '36', '男', '销售经理', '客服部', '15698545632', '156565655', '256542', '156942@qq.com', '郑州二七区');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(30) DEFAULT NULL,
  `goodsBewrite` varchar(30) DEFAULT NULL,
  `units` varchar(10) DEFAULT NULL,
  `stockPrice` float(10,2) unsigned zerofill DEFAULT '0000000.00',
  `retailPrice` float(10,2) unsigned zerofill DEFAULT '0000000.00',
  `associatorPrice` float(10,2) unsigned zerofill DEFAULT '0000000.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '小涴熊方便面', '食品', '袋', '0000000.80', '0000001.10', '0000000.98');
INSERT INTO `goods` VALUES ('2', '海飞丝洗发露', '生活品', '瓶', '0000019.80', '0000025.33', '0000022.60');
INSERT INTO `goods` VALUES ('3', '手机', '超长待机', '部', '0002350.00', '0002700.00', '0002599.00');
INSERT INTO `goods` VALUES ('5', '美好时光海苔', '食品', '袋', '0000002.30', '0000003.00', '0000002.60');
INSERT INTO `goods` VALUES ('6', '康师傅桶装方便面', '食品', '桶', '0000003.01', '0000004.00', '0000003.50');
INSERT INTO `goods` VALUES ('7', '空调', '家电', '台', '0001899.00', '0002600.00', '0002300.00');
INSERT INTO `goods` VALUES ('10', '笔记本', '文具', '本', '0000000.90', '0000001.50', '0000001.30');
INSERT INTO `goods` VALUES ('11', '电视', '家电', '台', '0000999.00', '0001999.00', '0001888.00');
INSERT INTO `goods` VALUES ('12', '方便面', '吃的', '袋', '0000001.00', '0000001.52', '0000001.30');
INSERT INTO `goods` VALUES ('13', 'aaaaaaaaaa', 'aaaaaaa', 'aaaa', '0000001.00', '0000001.00', '0000001.00');

-- ----------------------------
-- Table structure for inwarehouse
-- ----------------------------
DROP TABLE IF EXISTS `inwarehouse`;
CREATE TABLE `inwarehouse` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(30) DEFAULT NULL,
  `warehouseId` varchar(30) DEFAULT NULL,
  `goodsName` varchar(40) DEFAULT NULL,
  `inDate` varchar(40) DEFAULT NULL,
  `weight` double(40,0) DEFAULT NULL,
  `remark` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inwarehouse
-- ----------------------------
INSERT INTO `inwarehouse` VALUES ('2', 'c7d4320170622', '3', '生活用品', '2017-06-01 17:06:14', '20', '无111');
INSERT INTO `inwarehouse` VALUES ('3', 'c7d4320170622', '1', '11', '2017-06-01 16:06:04', '11', '11');
INSERT INTO `inwarehouse` VALUES ('4', 'c7d4320170622', '1', '试试', '2017-06-02 11:06:53', '1', '试试');

-- ----------------------------
-- Table structure for outwarehouse
-- ----------------------------
DROP TABLE IF EXISTS `outwarehouse`;
CREATE TABLE `outwarehouse` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(30) DEFAULT NULL,
  `warehouseId` varchar(30) DEFAULT NULL,
  `goodsName` varchar(40) DEFAULT NULL,
  `outDate` varchar(40) DEFAULT NULL,
  `weight` double(40,0) DEFAULT NULL,
  `remark` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outwarehouse
-- ----------------------------
INSERT INTO `outwarehouse` VALUES ('4', '20170507', '1', 'aaaaaaa', '2017-06-01 18:06:20', '1', 'aaa');

-- ----------------------------
-- Table structure for seller
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT '',
  `address` varchar(30) DEFAULT NULL,
  `linkman` varchar(30) DEFAULT NULL,
  `linkPhone` varchar(30) DEFAULT NULL,
  `faxes` varchar(30) DEFAULT NULL,
  `postNum` varchar(30) DEFAULT NULL,
  `bankNum` varchar(30) DEFAULT NULL,
  `netAddress` varchar(30) DEFAULT NULL,
  `emailAddress` varchar(30) DEFAULT NULL,
  `remark` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

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
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `sName` varchar(255) DEFAULT NULL,
  `orderId` varchar(30) DEFAULT NULL,
  `consignmentDate` varchar(30) DEFAULT NULL,
  `goodsName` varchar(30) DEFAULT NULL,
  `count` int(30) DEFAULT NULL,
  `money` varchar(30) DEFAULT NULL,
  `isInStock` int(30) DEFAULT '0',
  `warehouseId` int(30) DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('9', '22', 'c7d4320170622', '2017-06-22', '22', '22', '22.0', '1', '4');
INSERT INTO `stock` VALUES ('10', '啊啊', 'ceaf420170507', '2017-05-07', '啊啊啊', '1', '1.0', '1', '5');
INSERT INTO `stock` VALUES ('12', '111', '20170507', '2017-05-07', '11', '11', '11.0', '1', '1');
INSERT INTO `stock` VALUES ('14', '12', '20170507', '2017-05-07', '11', '1', '2.0', '1', '1');
INSERT INTO `stock` VALUES ('16', '1111111', '20170530', '2017-05-30', '11', '111', '11.0', '1', '4');
INSERT INTO `stock` VALUES ('17', '大时代', 'e474120170530', '2017-05-30', '订单', '32', '33.0', '1', '2');
INSERT INTO `stock` VALUES ('18', '12121', '4345320170511', '2017-05-11', '1213', '2131', '1233.0', '1', '4');
INSERT INTO `stock` VALUES ('20', '2222', 'e803920170511', '2017-05-11', '222', '5555', '2221.0', '0', '-1');
INSERT INTO `stock` VALUES ('21', 'ttt', 'e308620170511', '2017-05-11', 'ttt', '111', '11.0', '1', '1');
INSERT INTO `stock` VALUES ('22', '33', '20c0520170511', '2017-05-11', '33', '33', '33.0', '0', '-1');
INSERT INTO `stock` VALUES ('23', '3', '4f51720170511', '2017-05-11', '3', '3', '3.0', '1', '1');
INSERT INTO `stock` VALUES ('24', 'ss', 'aa62d20170519', '2017-05-19', 'ee', '2', '2.0', '1', '1');
INSERT INTO `stock` VALUES ('25', 'ss', 'b4ff920170519', '2017-05-19', 'ww', '1', '1.0', '1', '1');
INSERT INTO `stock` VALUES ('26', '11', '0e53620170519', '2017-05-19', '1', '1', '1.0', '0', '-1');
INSERT INTO `stock` VALUES ('28', 'dd', 'd2dba20170519', '2017-05-19', '33', '2', '3.0', '1', '1');
INSERT INTO `stock` VALUES ('29', '1111', '51f4020170519', '2017-05-19', '111', '1111', '111.0', '1', '1');
INSERT INTO `stock` VALUES ('30', 'aa', 'ba62120170519', '2017-05-19', 'w', '23', '232.0', '1', '1');
INSERT INTO `stock` VALUES ('31', '11', 'c289f20170519', '2017-05-19', '11', '111', '11.0', '1', '4');
INSERT INTO `stock` VALUES ('32', '1111', '644fb20170526', '2017-05-26', '111', '11', '111.0', '1', '3');
INSERT INTO `stock` VALUES ('33', '111', '8dfc620170723', '2017-07-23', '111', '111', '11.0', '1', '4');
INSERT INTO `stock` VALUES ('34', 'd', 'b5b1d20170613', '2017-06-13', 'd', '1', '1.0', '0', '-1');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT '',
  `address` varchar(30) DEFAULT NULL,
  `provide` varchar(30) DEFAULT NULL,
  `linkman` varchar(30) DEFAULT NULL,
  `linkPhone` varchar(30) DEFAULT NULL,
  `faxes` varchar(30) DEFAULT NULL,
  `postNum` varchar(30) DEFAULT NULL,
  `bankNum` varchar(30) DEFAULT NULL,
  `netAddress` varchar(30) DEFAULT NULL,
  `emailAddress` varchar(30) DEFAULT NULL,
  `remark` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('3', '伊利乳业', '内蒙古', '奶制品', '张宝军222222', '3546432', '3524654', '11548', '254563532648975', 'www.yili.com', 'zhangbao@163.com', '没有保鲜奶奶制品000000');
INSERT INTO `supplier` VALUES ('9', '看书', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10');
INSERT INTO `supplier` VALUES ('11', '哇集团', '常州', '饮料', '张涛', '12545354', '54432', '5445354', '7872575864415', 'www.wahaha.com', 'zhangtao@163.com', '无');
INSERT INTO `supplier` VALUES ('12', '乐事集团', '北京', '乐事薯片', '王', '186454645', '56745', '34564', '4527', '74825', 'wang@163.com', '无');
INSERT INTO `supplier` VALUES ('15', '141', '1', '11', '1', '1', '', '1', '', '', '', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123123');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `principal` varchar(30) DEFAULT NULL,
  `bewrite` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('1', '酒水仓库', '小二黑', '酒水饮料放置地');
INSERT INTO `warehouse` VALUES ('2', '粮油仓库', '小一黑', '粮油放置地');
INSERT INTO `warehouse` VALUES ('3', '食品仓库', '黑子2', '存放食品的仓库');
INSERT INTO `warehouse` VALUES ('4', '家电仓库', '小白', '存放家电的仓库');
INSERT INTO `warehouse` VALUES ('5', '杂货仓库', '小明', '存放各种杂货');
INSERT INTO `warehouse` VALUES ('6', '奶制品仓库', '李四', '存放奶制品');
INSERT INTO `warehouse` VALUES ('7', '水库', '11', '');
