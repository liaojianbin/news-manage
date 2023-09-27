
CREATE DATABASE `news_manage` /*!40100 DEFAULT CHARACTER SET utf8 */;

-- news_manage.tb_news definition

CREATE TABLE `tb_news` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `news_name` varchar(100) NOT NULL,
                           `news_type_id` int(11) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- news_manage.tb_news_type definition

CREATE TABLE `tb_news_type` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `type_name` varchar(50) DEFAULT NULL,
                                `parent_id` int(11) NOT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;