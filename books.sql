/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : ruanjian301

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2020-12-10 17:16:17
*/

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE IF NOT EXISTS books;

-- ----------------------------
-- Table structure for `tb_books`
-- ----------------------------
DROP TABLE IF EXISTS `tb_books`;
CREATE TABLE `tb_books` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(100) DEFAULT NULL,
  `book_name` varchar(100) DEFAULT NULL,
  `book_price` decimal(10,2) DEFAULT NULL,
  `book_author` varchar(100) DEFAULT NULL,
  `published_house` varchar(100) DEFAULT NULL,
  `book_category` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ISBN` (`ISBN`),
  KEY `book_category` (`book_category`),
  CONSTRAINT `tb_books_ibfk_1` FOREIGN KEY (`book_category`) REFERENCES `tb_books_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1015 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_books
-- ----------------------------
INSERT INTO `tb_books` VALUES ('1001', '978-7-100-10618-4', '《如何阅读一本好书》', '56.00', '(美) 莫提默·J. 艾德勒, 查尔斯·范多伦', '商务印书馆', '111');
INSERT INTO `tb_books` VALUES ('1002', '978-7-111-29544-0', '《设计模式之禅》', '69.00', '秦小波', '机械工业出版社', '113');
INSERT INTO `tb_books` VALUES ('1003', '978-7-115-21687-8', '《代码整洁之道》', '59.00', '(美)Robert C. Martin', '人民邮电出版社', '113');
INSERT INTO `tb_books` VALUES ('1004', '978-7-300-11134-6', '《金融学》', '59.00', '兹维·博迪', '中国人民大学出版社', '114');
INSERT INTO `tb_books` VALUES ('1006', '978-7-302-27544-2', '《C语言程序设计》', '29.00', '李爱玲', '机械工业出版社', '113');
INSERT INTO `tb_books` VALUES ('1007', '978-7-302-29391-0', '《网络安全技术》', '34.50', '曾湘黔', '清华大学出版社', '113');
INSERT INTO `tb_books` VALUES ('1008', '978-7-5117-0157-2', '《傲慢与偏见》', '16.00', '(英) 简·奥斯汀', '中央编译出版社', '111');
INSERT INTO `tb_books` VALUES ('1009', '978-7-5327-5110-5', '《悲惨世界》', '58.00', '(法)雨果', '上海译文出版社', '112');
INSERT INTO `tb_books` VALUES ('1010', '978-7-5399-3321-4', '《纳兰容若词传》', '28.50', '苏缨, 毛晓雯, 夏如意', '江苏文艺出版社', '115');
INSERT INTO `tb_books` VALUES ('1011', '978-7-5399-5488-2', '《瓦尔登湖 : 梭罗散文选》', '34.00', '(美) 梭罗', '江苏文艺出版社', '112');
INSERT INTO `tb_books` VALUES ('1013', '978-7-302-23755-6', '《Java程序设计实践教程》', '36.00', '颜志军, 栾媛媛', '人民邮电出版社', '113');
INSERT INTO `tb_books` VALUES ('1014', '654-9-7656-5654-5', '《斗破苍穹》', '24.00', '苍穹', '江苏文艺出版社', '116');

-- ----------------------------
-- Table structure for `tb_books_type`
-- ----------------------------
DROP TABLE IF EXISTS `tb_books_type`;
CREATE TABLE `tb_books_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) NOT NULL,
  `type_max_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_books_type
-- ----------------------------
INSERT INTO `tb_books_type` VALUES ('111', '哲学', '10');
INSERT INTO `tb_books_type` VALUES ('112', '散文', '12');
INSERT INTO `tb_books_type` VALUES ('113', '计算机', '90');
INSERT INTO `tb_books_type` VALUES ('114', '社会', '80');
INSERT INTO `tb_books_type` VALUES ('115', '诗词', '70');
INSERT INTO `tb_books_type` VALUES ('116', '漫画', '100');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(100) NOT NULL,
  `passwd` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('101', 'root', '123456');
INSERT INTO `tb_user` VALUES ('102', '李梦', '123456');
INSERT INTO `tb_user` VALUES ('103', '大宝', '654321');
INSERT INTO `tb_user` VALUES ('104', '嘴炮', '113579');
INSERT INTO `tb_user` VALUES ('105', '小花', '123456');
INSERT INTO `tb_user` VALUES ('106', '大黄蜂', '123456');

-- ----------------------------
-- Table structure for `tb_user_book`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_book`;
CREATE TABLE `tb_user_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `begin_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_book
-- ----------------------------
INSERT INTO `tb_user_book` VALUES ('1', '102', '1001', '2017-10-19', '2017-11-25', '0');
INSERT INTO `tb_user_book` VALUES ('2', '103', '1002', '2017-11-20', '2017-11-25', '0');
INSERT INTO `tb_user_book` VALUES ('4', '102', '1004', '2018-05-08', '2018-06-25', '0');
INSERT INTO `tb_user_book` VALUES ('5', '102', '1005', '2018-08-25', '2018-09-25', '0');
INSERT INTO `tb_user_book` VALUES ('7', '103', '1007', '2019-12-26', '2020-01-26', '0');
INSERT INTO `tb_user_book` VALUES ('8', '101', '1007', '2020-04-01', '2020-04-06', '0');
INSERT INTO `tb_user_book` VALUES ('9', '104', '1013', '2020-04-06', '2020-04-30', '1');
INSERT INTO `tb_user_book` VALUES ('10', '102', '1009', '2020-04-01', '2020-04-10', '1');
INSERT INTO `tb_user_book` VALUES ('11', '102', '1008', '2020-04-01', '2020-04-17', '1');
INSERT INTO `tb_user_book` VALUES ('12', '102', '1014', '2020-04-14', '2020-04-16', '1');
INSERT INTO `tb_user_book` VALUES ('13', '102', '1001', '2020-04-14', '2020-04-21', '1');
INSERT INTO `tb_user_book` VALUES ('14', '102', '1002', '2020-04-14', '2020-04-30', '1');
DROP TRIGGER IF EXISTS `deletUser`;
DELIMITER ;;
CREATE TRIGGER `deletUser` AFTER DELETE ON `tb_user` FOR EACH ROW begin
	delete from tb_user_book where user_id=old.id;
end
;;
DELIMITER ;
