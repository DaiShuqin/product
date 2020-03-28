/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shop`;

/*Table structure for table `shop_city` */

DROP TABLE IF EXISTS `shop_city`;

CREATE TABLE `shop_city` (
  `city_id` int(4) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(50) NOT NULL COMMENT '城市名',
  `zipcode` varchar(50) NOT NULL COMMENT '邮编',
  `province_id` int(4) NOT NULL COMMENT '省份id',
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_city` */

/*Table structure for table `shop_coupon` */

DROP TABLE IF EXISTS `shop_coupon`;

CREATE TABLE `shop_coupon` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `coupon_name` varchar(50) NOT NULL COMMENT '优惠卷名称',
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `status` int(4) DEFAULT NULL COMMENT '状态 1：正常，2：过期，3:已删除',
  `goods_id` int(4) NOT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_coupon` */

/*Table structure for table `shop_dictionary` */

DROP TABLE IF EXISTS `shop_dictionary`;

CREATE TABLE `shop_dictionary` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '字典',
  `dic_name` int(4) NOT NULL,
  `dic_type` int(4) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_dictionary` */

/*Table structure for table `shop_district` */

DROP TABLE IF EXISTS `shop_district`;

CREATE TABLE `shop_district` (
  `district_id` int(4) NOT NULL AUTO_INCREMENT,
  `district_name` varchar(50) NOT NULL,
  `city_id` int(4) NOT NULL,
  PRIMARY KEY (`district_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_district` */

/*Table structure for table `shop_goods_category` */

DROP TABLE IF EXISTS `shop_goods_category`;

CREATE TABLE `shop_goods_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `parent_id` int(10) NOT NULL COMMENT '父级目录id',
  `type` int(11) DEFAULT NULL COMMENT '级别(1:一级 2：二级 3：三级)',
  `iconClass` varchar(255) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___9EC2A4E236B12243` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=697 DEFAULT CHARSET=utf8;

/*Data for the table `shop_goods_category` */

insert  into `shop_goods_category`(`id`,`name`,`parent_id`,`type`,`iconClass`) values (548,'化妆品',0,1,''),(628,'家用商品',0,1,''),(654,'面部护理',548,2,''),(655,'少女派',654,3,''),(656,'餐具',628,2,''),(657,'卫具',628,2,''),(658,'叉子',656,3,''),(659,'锅',656,3,''),(660,'进口食品,生鲜',0,1,''),(661,'零食/糖果/巧克力',660,2,''),(662,'坚果',661,3,''),(663,'蜜饯',661,3,''),(669,'孕期教育',546,3,''),(670,'电子商品',0,1,''),(671,'手机',670,2,''),(672,'华为手机',671,3,''),(673,'联想手机',671,3,''),(674,'手环',670,2,''),(675,'小米手环',674,3,''),(676,'保健食品',0,1,''),(677,'老年保健品',676,2,''),(678,'中年营养品',676,2,''),(679,'儿童保健品',676,2,''),(680,'脑白金',677,3,''),(681,'箱包',0,1,''),(682,'旅行箱',681,2,''),(683,'手提箱',681,2,''),(684,'大型',683,3,''),(685,'小型',683,3,''),(686,'中型',683,3,''),(687,'大型',682,3,''),(688,'中型',682,3,''),(689,'小型',682,3,''),(690,'电脑',670,2,''),(691,'联想电脑',690,3,''),(692,'刀叉',656,3,NULL),(693,'碗筷',656,3,NULL),(696,'客厅专用',628,2,'');

/*Table structure for table `shop_goods_comment` */

DROP TABLE IF EXISTS `shop_goods_comment`;

CREATE TABLE `shop_goods_comment` (
  `comment_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `goods_id` int(10) unsigned NOT NULL COMMENT '商品ID',
  `order_id` bigint(20) unsigned NOT NULL COMMENT '订单ID',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户ID',
  `title` varchar(50) NOT NULL COMMENT '评论标题',
  `content` varchar(300) NOT NULL COMMENT '评论内容',
  `audit_status` tinyint(4) NOT NULL COMMENT '审核状态：0未审核，1已审核',
  `audit_time` datetime NOT NULL COMMENT '评论时间',
  `modified_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品评论表';

/*Data for the table `shop_goods_comment` */

/*Table structure for table `shop_goods_info` */

DROP TABLE IF EXISTS `shop_goods_info`;

CREATE TABLE `shop_goods_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_name` varchar(20) NOT NULL COMMENT '名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `price` float NOT NULL COMMENT '价格',
  `stock` int(10) NOT NULL COMMENT '库存',
  `categoryLevel1Id` int(10) DEFAULT NULL COMMENT '分类1',
  `categoryLevel2Id` int(10) DEFAULT NULL COMMENT '分类2',
  `categoryLevel3Id` int(10) DEFAULT NULL COMMENT '分类3',
  `fileName` varchar(200) DEFAULT NULL COMMENT '商品主图',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(4) DEFAULT NULL COMMENT '记录状态 1、审核中的商品 2、出',
  `isDelete` int(1) DEFAULT '0' COMMENT '是否删除(1：删除 0：未删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___94F6E55132E0915F` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=771 DEFAULT CHARSET=utf8;

/*Data for the table `shop_goods_info` */

insert  into `shop_goods_info`(`id`,`goods_name`,`description`,`price`,`stock`,`categoryLevel1Id`,`categoryLevel2Id`,`categoryLevel3Id`,`fileName`,`create_time`,`update_time`,`status`,`isDelete`) values (733,'香奈儿','订单',152,94,548,654,655,'27A1789ED5764D82A5506DF3DC3933F9.jpg','2020-03-17 18:06:08',NULL,NULL,0),(734,'洗面奶','',152,995,548,654,655,'D6C9BD438C5643D6B1A6C52E5426FE22.jpg','2020-03-17 18:06:08',NULL,NULL,0),(735,'啫喱水','',152,998,548,654,655,'1A836D2B3A3348DDAB19807E6CEA8028.jpg','2020-03-17 18:06:08',NULL,NULL,0),(736,'香水5852','',152,1000,548,654,655,'4D9499BAD92A42D291094E797BA2EA3F.jpg','2020-03-17 18:06:08',NULL,NULL,0),(737,'香水','',152,111,548,654,655,'A9924F9DB68B4DF99FDBF05902075AF0.jpg','2020-03-17 18:06:08',NULL,NULL,0),(738,'润肤露','',45,109,548,654,655,'3B059EDB5237407980458CE9EA9D3204.jpg','2020-03-17 18:06:08',NULL,NULL,0),(739,'洁面装','',156,99,548,654,655,'A62C6DF55116440CA3DE9DB37901ED4F.jpg','2020-03-17 18:06:08',NULL,NULL,0),(740,'电饭锅','',158,100,628,656,659,'40C3B76BA31246618E3CFC8723D33517.jpg','2020-03-17 18:06:08',NULL,NULL,0),(741,'婴儿喂奶装','',569,100,632,637,653,'401004B3D47C4C6FB1BC5EF19C21FC77.jpg','2020-03-17 18:06:08',NULL,NULL,0),(742,'坚果套餐','',158,1000,660,661,662,'E03D74145A034F6D909879829CB99D80.jpg','2020-03-17 18:06:08',NULL,NULL,0),(743,'超甜蜜崭','',589,1000,660,661,663,'7121E55099FC477680B1229205CE3D29.jpg','2020-03-17 18:06:08',NULL,NULL,0),(744,'华为2566','',589,1000,670,671,672,'F24B4140A2284B3788A38F3B5AD1809A.jpg','2020-03-17 18:06:08',NULL,NULL,0),(745,'荣耀3C','',589,100,670,671,672,'F3921E12552A4D0AA3F75467B146A959.jpg','2020-03-17 18:06:08',NULL,NULL,0),(746,'小米手环','',963,100,670,674,675,'72F75A371B0B4C26A7F72FAAEF96FC68.jpg','2020-03-17 18:06:08',NULL,NULL,0),(747,'华为2265','',896,1000,670,671,673,'161F355A8A8549BA8F7F4CE3B4F07E40.jpg','2020-03-17 18:06:08',NULL,NULL,0),(748,'越南坚果','',520,1000,660,661,662,'CBC98D3C9E544830821632F5C313D93E.jpg','2020-03-17 18:06:08',NULL,NULL,0),(749,'日本进口马桶','',5866,100,628,657,0,'A5AF40825E6940B2A59A040100E181A8.jpg','2020-03-17 18:06:08',NULL,NULL,0),(750,'联想Y系列','',569,1000,670,690,691,'956DB0BEC41B41B8A06C05C950130E23.jpg','2020-03-17 18:06:08',NULL,NULL,0),(751,'脑白金1号','',589,1000,676,677,680,'66E96AF9E9714A5C9EA901811173D662.jpg','2020-03-17 18:06:08',NULL,NULL,0),(752,'莫里斯按','',589,1000,676,678,0,'A7436BC607E74C81B392DCFE69D4AEAB.jpg','2020-03-17 18:06:08',NULL,NULL,0),(753,'三鹿好奶粉','',859,100,676,679,0,'3C465E7B8A324A8DA2A2EEE202E36166.jpg','2020-03-17 18:06:08',NULL,NULL,0),(754,'儿童牛奶','',5896,100,676,679,0,'D1AC9AE71ED348FA8D880FD4279D3422.jpg','2020-03-17 18:06:08',NULL,NULL,0),(755,'软沙发','',8596,99,628,696,0,'ED7921DE40FC47E18365754709A21194.jpg','2020-03-17 18:06:08',NULL,NULL,0),(756,'收纳盒','',5966,100,628,696,0,'DB86CA25CA4F4B4AA906F46BE542C6A6.jpg','2020-03-17 18:06:08',NULL,NULL,0),(757,'洗衣液','',58,1000,628,696,0,'E6CCDC343ACC471C908E9748776C6421.jpg','2020-03-17 18:06:08',NULL,NULL,0),(758,'红短沙发','',596,123,628,696,0,'BD5C77465DC2466BBCE7F95FB9764392.jpg','2020-03-17 18:06:08',NULL,NULL,0),(759,'新西兰奶粉','',5896,100,676,679,0,'9ED375098D42497B8FC33167E06D0EE8.jpg','2020-03-17 18:06:08',NULL,NULL,0),(760,'婴儿车','',11000,100,681,682,687,'1DBC0930641D43C29D74A9E1B40FEEBB.jpg','2020-03-17 18:06:08',NULL,NULL,0),(761,'夏款婴儿车','',963,100,681,682,688,'16290C4DBEAC4F00A636667019621468.jpg','2020-03-17 18:06:08',NULL,NULL,0),(762,'抗压旅行箱','',569,1000,681,683,685,'272CC434BE7A4469AB0E7882BD1A85FF.jpg','2020-03-17 18:06:08',NULL,NULL,0),(763,'透明手提箱','',8596,1000,681,683,684,'EAA8E66259BF4239B4A2237B62520EF1.jpg','2020-03-17 18:06:08',NULL,NULL,0),(764,'婴儿果粉','',5896,1000,660,661,662,'08BE30BF7B5F4930B0093D8CC4056057.jpg','2020-03-17 18:06:08',NULL,NULL,0),(765,'椰子粉','',5963,1000,660,661,662,'9C006B8BD1AD45398F474A8471ADC50B.jpg','2020-03-17 18:06:08',NULL,NULL,0),(766,'坚果蛋糕','',200,100,660,661,663,'2E5A16E21E0640E0BAE03E9B995DCD28.jpg','2020-03-17 18:06:08',NULL,NULL,0),(767,'编制手提箱','',5896,1000,681,682,688,'2E1D2A5E65A94FEEA17C72E47C530057.jpg','2020-03-17 18:06:08',NULL,NULL,0),(768,'纸箱','',5896,100,681,682,687,'443E5A4122064209AFE89250179A2FF0.jpg','2020-03-17 18:06:08',NULL,NULL,0),(769,'健胃液','',152,1000,676,679,0,'30B5547CD7384DAA8A2F4F4D8C0BBF89.jpg','2020-03-17 18:06:08',NULL,NULL,0),(770,'联想NTC','',8596,100,670,671,673,'48BC371A85A548B7A7589E3F542D911D.jpg','2020-03-17 18:06:08',NULL,NULL,0);

/*Table structure for table `shop_goods_sku` */

DROP TABLE IF EXISTS `shop_goods_sku`;

CREATE TABLE `shop_goods_sku` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_id` int(10) unsigned NOT NULL COMMENT '商品ID',
  `weight` float DEFAULT NULL COMMENT '商品重量',
  `length` float DEFAULT NULL COMMENT '商品长度',
  `height` float DEFAULT NULL COMMENT '商品高度',
  `width` float DEFAULT NULL COMMENT '商品宽度',
  `color_type` enum('红','黄','蓝','黑') DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片信息表';

/*Data for the table `shop_goods_sku` */

/*Table structure for table `shop_mycoupon` */

DROP TABLE IF EXISTS `shop_mycoupon`;

CREATE TABLE `shop_mycoupon` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `coupon_id` int(4) NOT NULL COMMENT '优惠卷id',
  `status` int(4) NOT NULL COMMENT '状态，1 未使用，2 已使用',
  `usetype` int(4) NOT NULL COMMENT '使用类型，1：订单支付，2：积分',
  `order_id` int(4) NOT NULL COMMENT '对应订单号',
  `user_id` int(4) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_mycoupon` */

/*Table structure for table `shop_notice_info` */

DROP TABLE IF EXISTS `shop_notice_info`;

CREATE TABLE `shop_notice_info` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT,
  `notice_name` varchar(4) NOT NULL COMMENT '商品公告名',
  `notice_content` varchar(255) NOT NULL COMMENT '公共内容',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` int(4) DEFAULT '2' COMMENT '1隐藏，2显示',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=704 DEFAULT CHARSET=utf8;

/*Data for the table `shop_notice_info` */

insert  into `shop_notice_info`(`notice_id`,`notice_name`,`notice_content`,`start_time`,`end_time`,`status`) values (531,'会员特惠','会员特惠月开始了,亲们赶快下单啊,不到剁手誓不罢休啊,不到离婚誓不清空购物车啊。更多优惠，尽在易买网。','2010-12-22 00:00:00',NULL,2),(597,'迎双旦促','迎双旦促销大酬宾','2010-12-24 00:00:00',NULL,2),(649,'加入会员','加入会员，赢千万大礼包','2010-12-22 00:00:00',NULL,2),(650,'新年不夜','新年不夜天，通宵也是开张了','2011-05-22 00:00:00',NULL,2),(651,'积分兑换','积分兑换开始了','2010-12-22 00:00:00',NULL,2),(653,'团购阿迪','团购阿迪1折起','2010-12-22 00:00:00',NULL,2),(664,'最新酷睿','IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。','2013-08-05 00:00:00',NULL,2),(675,'aa','宝马奔驰车钥匙打火机','2013-08-14 00:00:00',NULL,2),(676,'Resu','洗衣服大减价','2016-03-28 00:00:00',NULL,2),(677,'会员特惠','会员特惠月开始了','2010-12-22 00:00:00',NULL,2),(678,'迎双旦促','迎双旦促销大酬宾','2010-12-24 00:00:00',NULL,2),(679,'加入会员','加入会员，赢千万大礼包','2010-12-22 00:00:00',NULL,2),(680,'新年不夜','新年不夜天，通宵也是开张了','2011-05-22 00:00:00',NULL,2),(681,'积分兑换','积分兑换开始了','2010-12-22 00:00:00',NULL,2),(682,'团购阿迪','团购阿迪1折起','2010-12-22 00:00:00',NULL,2),(683,'最新酷睿','IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。','2013-08-05 00:00:00',NULL,2),(684,'aa8','012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234','2013-08-14 00:00:00',NULL,2),(685,'Resu','ResultResultResultResultResu','2016-03-28 00:00:00',NULL,2),(686,'会员特惠','会员特惠月开始了','2010-12-22 00:00:00',NULL,2),(687,'迎双旦促','迎双旦促销大酬宾','2010-12-24 00:00:00',NULL,2),(688,'加入会员','加入会员，赢千万大礼包','2010-12-22 00:00:00',NULL,2),(689,'新年不夜','新年不夜天，通宵也是开张了','2011-05-22 00:00:00',NULL,2),(690,'积分兑换','积分兑换开始了','2010-12-22 00:00:00',NULL,2),(691,'团购阿迪','团购阿迪1折起','2010-12-22 00:00:00',NULL,2),(692,'最新酷睿','IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。','2013-08-05 00:00:00',NULL,2),(693,'aa81','012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234','2013-08-14 00:00:00',NULL,2),(694,'Resu','ResultResultResultResultResu','2016-03-28 00:00:00',NULL,2),(695,'会员特惠','会员特惠月开始了','2010-12-22 00:00:00',NULL,2),(696,'迎双旦促','迎双旦促销大酬宾','2010-12-24 00:00:00',NULL,2),(697,'加入会员','加入会员，赢千万大礼包','2010-12-22 00:00:00',NULL,2),(698,'新年不夜','新年不夜天，通宵也是开张了','2011-05-22 00:00:00',NULL,2),(699,'积分兑换','积分兑换开始了','2010-12-22 00:00:00',NULL,2),(700,'团购阿迪','团购阿迪1折起','2010-12-22 00:00:00',NULL,2),(701,'最新酷睿','IBME系列全场促销中，最新酷睿双核处理器，保证CPU更高效的运转。','2013-08-05 00:00:00',NULL,2),(702,'aa81','012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234','2013-08-14 00:00:00',NULL,2),(703,'Resu','ResultResultResultResultResu','2016-03-28 00:00:00',NULL,2);

/*Table structure for table `shop_order_detail` */

DROP TABLE IF EXISTS `shop_order_detail`;

CREATE TABLE `shop_order_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单详情表ID',
  `order_id` int(10) unsigned NOT NULL COMMENT '订单表ID',
  `goods_id` int(10) unsigned NOT NULL COMMENT '订单商品ID',
  `goods_name` varchar(50) NOT NULL COMMENT '商品名称',
  `goods_cnt` int(11) NOT NULL DEFAULT '1' COMMENT '购买商品数量',
  `goods_price` decimal(8,2) NOT NULL COMMENT '购买商品单价',
  `average_cost` decimal(8,2) NOT NULL COMMENT '平均成本价格',
  `fee_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '优惠分摊金额',
  `w_id` int(10) unsigned NOT NULL COMMENT '仓库ID',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

/*Data for the table `shop_order_detail` */

/*Table structure for table `shop_order_master` */

DROP TABLE IF EXISTS `shop_order_master`;

CREATE TABLE `shop_order_master` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_sn` bigint(20) unsigned NOT NULL COMMENT '订单编号 yyyymmddnnnnnnnn',
  `user_id` int(10) unsigned NOT NULL COMMENT '下单人ID',
  `shipping_user` varchar(10) NOT NULL COMMENT '收货人姓名',
  `user_address_id` int(100) NOT NULL COMMENT '地址',
  `payment_method` tinyint(4) NOT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
  `order_money` decimal(8,2) NOT NULL COMMENT '订单金额',
  `district_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `shipping_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '运费金额',
  `payment_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '支付金额',
  `post_id` varchar(10) DEFAULT NULL COMMENT '快递公司id',
  `shipping_sn` varchar(50) DEFAULT NULL COMMENT '快递单号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `shipping_time` datetime DEFAULT NULL COMMENT '发货时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `receive_time` datetime DEFAULT NULL COMMENT '收货时间',
  `order_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `isRefund` int(4) DEFAULT NULL COMMENT '是否有退款，1：没有退款、2：正在退款、3：退款成功',
  `order_point` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '订单积分',
  `modified_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单主表';

/*Data for the table `shop_order_master` */

/*Table structure for table `shop_pay` */

DROP TABLE IF EXISTS `shop_pay`;

CREATE TABLE `shop_pay` (
  `pay_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '支付记录编号',
  `user_id` int(4) NOT NULL COMMENT '用户编号',
  `order_id` int(4) NOT NULL COMMENT '订单编号',
  `pay_before` decimal(20,2) NOT NULL COMMENT '支付前余额',
  `pay_after` decimal(20,2) NOT NULL COMMENT '支付后余额',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `isPay` int(4) DEFAULT NULL COMMENT '1支付成功，2支付失败',
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付信息表';

/*Data for the table `shop_pay` */

/*Table structure for table `shop_pic_info` */

DROP TABLE IF EXISTS `shop_pic_info`;

CREATE TABLE `shop_pic_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品图片ID',
  `goods_id` int(10) unsigned NOT NULL COMMENT '商品ID',
  `pic_desc` varchar(50) DEFAULT NULL COMMENT '图片描述',
  `pic_url` varchar(200) NOT NULL COMMENT '图片URL',
  `is_master` tinyint(4) DEFAULT '0' COMMENT '是否主图：0.非主图1.主图',
  `pic_order` tinyint(4) DEFAULT '0' COMMENT '图片排序',
  `pic_status` tinyint(4) DEFAULT '1' COMMENT '图片是否有效：0无效 1有效',
  `modified_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='商品图片信息表';

/*Data for the table `shop_pic_info` */

insert  into `shop_pic_info`(`id`,`goods_id`,`pic_desc`,`pic_url`,`is_master`,`pic_order`,`pic_status`,`modified_time`) values (1,733,'商品图片','27A1789ED5764D82A5506DF3DC3933F9.jpg',0,0,1,'2020-03-18 14:25:22'),(2,733,NULL,'27A1789ED5764D82A5506DF3DC3933F9.jpg',0,0,1,'2020-03-18 19:48:11'),(3,734,NULL,'D6C9BD438C5643D6B1A6C52E5426FE22.jpg',0,0,1,'2020-03-18 19:48:11'),(4,735,NULL,'1A836D2B3A3348DDAB19807E6CEA8028.jpg',0,0,1,'2020-03-18 19:48:11'),(5,736,NULL,'4D9499BAD92A42D291094E797BA2EA3F.jpg',0,0,1,'2020-03-18 19:48:11'),(6,737,NULL,'A9924F9DB68B4DF99FDBF05902075AF0.jpg',0,0,1,'2020-03-18 19:48:11'),(7,738,NULL,'3B059EDB5237407980458CE9EA9D3204.jpg',0,0,1,'2020-03-18 19:48:11'),(8,739,NULL,'A62C6DF55116440CA3DE9DB37901ED4F.jpg',0,0,1,'2020-03-18 19:48:11'),(9,740,NULL,'40C3B76BA31246618E3CFC8723D33517.jpg',0,0,1,'2020-03-18 19:48:11'),(10,741,NULL,'401004B3D47C4C6FB1BC5EF19C21FC77.jpg',0,0,1,'2020-03-18 19:48:11'),(11,742,NULL,'E03D74145A034F6D909879829CB99D80.jpg',0,0,1,'2020-03-18 19:48:11'),(12,743,NULL,'7121E55099FC477680B1229205CE3D29.jpg',0,0,1,'2020-03-18 19:48:11'),(13,744,NULL,'F24B4140A2284B3788A38F3B5AD1809A.jpg',0,0,1,'2020-03-18 19:48:11'),(14,745,NULL,'F3921E12552A4D0AA3F75467B146A959.jpg',0,0,1,'2020-03-18 19:48:11'),(15,746,NULL,'72F75A371B0B4C26A7F72FAAEF96FC68.jpg',0,0,1,'2020-03-18 19:48:11'),(16,747,NULL,'161F355A8A8549BA8F7F4CE3B4F07E40.jpg',0,0,1,'2020-03-18 19:48:11'),(17,748,NULL,'CBC98D3C9E544830821632F5C313D93E.jpg',0,0,1,'2020-03-18 19:48:11'),(18,749,NULL,'A5AF40825E6940B2A59A040100E181A8.jpg',0,0,1,'2020-03-18 19:48:11'),(19,750,NULL,'956DB0BEC41B41B8A06C05C950130E23.jpg',0,0,1,'2020-03-18 19:48:11'),(20,751,NULL,'66E96AF9E9714A5C9EA901811173D662.jpg',0,0,1,'2020-03-18 19:48:11'),(21,752,NULL,'A7436BC607E74C81B392DCFE69D4AEAB.jpg',0,0,1,'2020-03-18 19:48:11'),(22,753,NULL,'3C465E7B8A324A8DA2A2EEE202E36166.jpg',0,0,1,'2020-03-18 19:48:11'),(23,754,NULL,'D1AC9AE71ED348FA8D880FD4279D3422.jpg',0,0,1,'2020-03-18 19:48:11'),(24,755,NULL,'ED7921DE40FC47E18365754709A21194.jpg',0,0,1,'2020-03-18 19:48:11'),(25,756,NULL,'DB86CA25CA4F4B4AA906F46BE542C6A6.jpg',0,0,1,'2020-03-18 19:48:11'),(26,757,NULL,'E6CCDC343ACC471C908E9748776C6421.jpg',0,0,1,'2020-03-18 19:48:11'),(27,758,NULL,'BD5C77465DC2466BBCE7F95FB9764392.jpg',0,0,1,'2020-03-18 19:48:11'),(28,759,NULL,'9ED375098D42497B8FC33167E06D0EE8.jpg',0,0,1,'2020-03-18 19:48:11'),(29,760,NULL,'1DBC0930641D43C29D74A9E1B40FEEBB.jpg',0,0,1,'2020-03-18 19:48:11'),(30,761,NULL,'16290C4DBEAC4F00A636667019621468.jpg',0,0,1,'2020-03-18 19:48:11'),(31,762,NULL,'272CC434BE7A4469AB0E7882BD1A85FF.jpg',0,0,1,'2020-03-18 19:48:11'),(32,763,NULL,'EAA8E66259BF4239B4A2237B62520EF1.jpg',0,0,1,'2020-03-18 19:48:11'),(33,764,NULL,'08BE30BF7B5F4930B0093D8CC4056057.jpg',0,0,1,'2020-03-18 19:48:11'),(34,765,NULL,'9C006B8BD1AD45398F474A8471ADC50B.jpg',0,0,1,'2020-03-18 19:48:11'),(35,766,NULL,'2E5A16E21E0640E0BAE03E9B995DCD28.jpg',0,0,1,'2020-03-18 19:48:11'),(36,767,NULL,'2E1D2A5E65A94FEEA17C72E47C530057.jpg',0,0,1,'2020-03-18 19:48:11'),(37,768,NULL,'443E5A4122064209AFE89250179A2FF0.jpg',0,0,1,'2020-03-18 19:48:11'),(38,769,NULL,'30B5547CD7384DAA8A2F4F4D8C0BBF89.jpg',0,0,1,'2020-03-18 19:48:11'),(39,770,NULL,'48BC371A85A548B7A7589E3F542D911D.jpg',0,0,1,'2020-03-18 19:48:11');

/*Table structure for table `shop_postoffice` */

DROP TABLE IF EXISTS `shop_postoffice`;

CREATE TABLE `shop_postoffice` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `post_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_postoffice` */

/*Table structure for table `shop_province` */

DROP TABLE IF EXISTS `shop_province`;

CREATE TABLE `shop_province` (
  `c_id` int(4) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(50) NOT NULL COMMENT '省份',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_province` */

/*Table structure for table `shop_refund` */

DROP TABLE IF EXISTS `shop_refund`;

CREATE TABLE `shop_refund` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '退款id',
  `goods_id` int(4) NOT NULL,
  `user_id` int(4) NOT NULL,
  `refund_price` decimal(10,0) NOT NULL COMMENT '退款金额',
  `refund_cause` varchar(255) DEFAULT NULL COMMENT '退款原因',
  `refund_type` int(4) DEFAULT NULL COMMENT '1,退货；2取消订单',
  `refund_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_refund` */

/*Table structure for table `shop_shipping_info` */

DROP TABLE IF EXISTS `shop_shipping_info`;

CREATE TABLE `shop_shipping_info` (
  `ship_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ship_name` varchar(20) NOT NULL COMMENT '物流公司名称',
  `ship_contact` varchar(20) NOT NULL COMMENT '物流公司联系人',
  `telephone` varchar(20) NOT NULL COMMENT '物流公司联系电话',
  `price` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '配送价格',
  `address` varchar(255) DEFAULT NULL COMMENT '到达地址',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`ship_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流公司信息表';

/*Data for the table `shop_shipping_info` */

/*Table structure for table `shop_shopcart` */

DROP TABLE IF EXISTS `shop_shopcart`;

CREATE TABLE `shop_shopcart` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `goods_id` int(4) NOT NULL COMMENT '商品id',
  `user_id` int(4) NOT NULL COMMENT '用户id',
  `number` decimal(10,0) NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_shopcart` */

/*Table structure for table `shop_slideshow` */

DROP TABLE IF EXISTS `shop_slideshow`;

CREATE TABLE `shop_slideshow` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `slide_url` varchar(50) NOT NULL COMMENT '轮播图路径',
  `goods_id` int(4) NOT NULL COMMENT '轮播图商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_slideshow` */

/*Table structure for table `shop_user` */

DROP TABLE IF EXISTS `shop_user`;

CREATE TABLE `shop_user` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `phoneno` varchar(50) NOT NULL COMMENT '手机号',
  `pw_err_count` int(4) DEFAULT NULL COMMENT '密码错误次数',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别，1 男，2 女',
  `user_balance` decimal(10,0) NOT NULL COMMENT '用户余额',
  `url` varchar(255) DEFAULT NULL COMMENT '用户头像地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `shop_user` */

insert  into `shop_user`(`id`,`user_name`,`phoneno`,`pw_err_count`,`password`,`sex`,`user_balance`,`url`,`create_time`) values (2,'admin','12345678909',NULL,'e10adc3949ba59abbe56e057f20f883e',NULL,'1000',NULL,'2020-03-18 21:43:26');

/*Table structure for table `shop_user_address` */

DROP TABLE IF EXISTS `shop_user_address`;

CREATE TABLE `shop_user_address` (
  `customer_addr_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `customer_id` int(10) unsigned NOT NULL COMMENT 'customer_login表的自增ID',
  `zip` smallint(6) NOT NULL COMMENT '邮编',
  `province` smallint(6) NOT NULL COMMENT '地区表中省份的ID',
  `city` smallint(6) NOT NULL COMMENT '地区表中城市的ID',
  `district` smallint(6) NOT NULL COMMENT '地区表中的区ID',
  `address` varchar(200) NOT NULL COMMENT '具体的地址门牌号',
  `is_default` tinyint(4) NOT NULL COMMENT '是否默认',
  `modified_time` datetime NOT NULL COMMENT '最后修改时间',
  `status` int(4) DEFAULT NULL COMMENT '1正常，2禁用',
  PRIMARY KEY (`customer_addr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址表';

/*Data for the table `shop_user_address` */

/*Table structure for table `shop_user_collect` */

DROP TABLE IF EXISTS `shop_user_collect`;

CREATE TABLE `shop_user_collect` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `user_id` int(4) NOT NULL,
  `goods_id` int(4) NOT NULL,
  `collect_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_user_collect` */

/*Table structure for table `shop_vcode` */

DROP TABLE IF EXISTS `shop_vcode`;

CREATE TABLE `shop_vcode` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `user_id` int(4) DEFAULT NULL,
  `vcode` varchar(50) NOT NULL,
  `type` int(4) NOT NULL COMMENT '1注册，2找回密码，3找回用户名',
  `create_time` datetime DEFAULT NULL,
  `isNo` int(4) NOT NULL DEFAULT '1' COMMENT '1正常，2禁止',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_vcode` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
