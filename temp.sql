-- MySQL dump 10.13  Distrib 5.7.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: treffen
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_dept`
--

DROP TABLE IF EXISTS `tb_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_dept` (
  `dept_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `dept_name` varchar(14) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称（索引）',
  `dept_desc` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '部门描述',
  `dept_location` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '部门位置',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `tb_dept_dept_name_uindex` (`dept_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_dept`
--

LOCK TABLES `tb_dept` WRITE;
/*!40000 ALTER TABLE `tb_dept` DISABLE KEYS */;
INSERT INTO `tb_dept` VALUES (1,'无部门','用户的默认部门','',0);
/*!40000 ALTER TABLE `tb_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_meeting`
--

DROP TABLE IF EXISTS `tb_meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_meeting` (
  `meeting_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `host_id` int(10) unsigned DEFAULT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  `record_desc` text COLLATE utf8mb4_unicode_ci,
  `record_type` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '无主题',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`meeting_id`),
  KEY `tb_meeting_tb_user_emp_id_fk` (`host_id`),
  CONSTRAINT `tb_meeting_tb_user_emp_id_fk` FOREIGN KEY (`host_id`) REFERENCES `tb_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_meeting`
--

LOCK TABLES `tb_meeting` WRITE;
/*!40000 ALTER TABLE `tb_meeting` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_meeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_meeting_attendee_list`
--

DROP TABLE IF EXISTS `tb_meeting_attendee_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_meeting_attendee_list` (
  `meeting_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`meeting_id`,`user_id`),
  KEY `tb_meeting_attendee_tb_user_user_id_fk` (`user_id`),
  CONSTRAINT `tb_meeting_attendee_tb_meeting_meeting_id_fk` FOREIGN KEY (`meeting_id`) REFERENCES `tb_meeting` (`meeting_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_meeting_attendee_tb_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_meeting_attendee_list`
--

LOCK TABLES `tb_meeting_attendee_list` WRITE;
/*!40000 ALTER TABLE `tb_meeting_attendee_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_meeting_attendee_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menu_item`
--

DROP TABLE IF EXISTS `tb_menu_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_menu_item` (
  `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单每项的名称',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  `item_desc` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单功能描述',
  `item_path` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `item_group` int(10) unsigned DEFAULT NULL COMMENT '设置分组，标识当前这个 item 属于哪个分组下面的',
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `tb_menu_item_item_name_uindex` (`item_name`),
  KEY `tb_menu_item_tb_menu_item_group_group_id_fk` (`item_group`),
  CONSTRAINT `tb_menu_item_tb_menu_item_group_group_id_fk` FOREIGN KEY (`item_group`) REFERENCES `tb_menu_item_group` (`group_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu_item`
--

LOCK TABLES `tb_menu_item` WRITE;
/*!40000 ALTER TABLE `tb_menu_item` DISABLE KEYS */;
INSERT INTO `tb_menu_item` VALUES (1,'当前任务',0,NULL,'currentTask',1),(2,'用户历史任务',0,NULL,'userHistoryTask',1),(3,'周报',0,NULL,'weekSummary',1),(4,'个人资料',0,NULL,'personal',1),(5,'统计',0,NULL,'myStat',1),(6,'录入职员',0,NULL,'addEmployee',2),(7,'修改职员信息',0,NULL,'updateEmployee',2),(8,'搜索职员',0,NULL,'searchEmployee',3),(9,'搜索周报',0,NULL,'searchWeekSummary',3),(10,'搜索会议',0,NULL,'searchMeeting',3),(11,'搜索任务',0,NULL,'searchTask',3),(16,'分组管理',0,NULL,'groupManageGroup',4),(17,'任务管理',0,NULL,'tasksManage',4),(18,'职员任务',0,NULL,'employeeTask',4),(19,'历史任务',0,NULL,'allHistoryTask',4),(20,'创建会议',0,NULL,'createMeeting',5),(21,'修改会议',0,NULL,'updateMeeting',5),(22,'审核会议',0,NULL,'checkMeeting',5),(23,'历史会议',0,NULL,'historyMeeting',5),(24,'发起通知',0,NULL,'createMessage',6),(25,'历史通知',0,NULL,'historyMessage',6),(26,'删除通知',0,NULL,'deletedMessage',7),(27,'删除会议',0,NULL,'deletedMeeting',7),(28,'删除任务',0,NULL,'deletedTask',7),(29,'删除职员',0,NULL,'deleteEmployee',7);
/*!40000 ALTER TABLE `tb_menu_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menu_item_group`
--

DROP TABLE IF EXISTS `tb_menu_item_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_menu_item_group` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分组的名称',
  `group_icon` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'el-icon-s-home',
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `tb_menu_item_group_group_name_uindex` (`group_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu_item_group`
--

LOCK TABLES `tb_menu_item_group` WRITE;
/*!40000 ALTER TABLE `tb_menu_item_group` DISABLE KEYS */;
INSERT INTO `tb_menu_item_group` VALUES (1,'个人中心','el-icon-s-home'),(2,'人员管理','el-icon-user-solid'),(3,'搜索资料','el-icon-search'),(4,'任务系统','el-icon-s-claim'),(5,'会议管理','el-icon-data-analysis'),(6,'通知系统','el-icon-message-solid'),(7,'删除信息','el-icon-delete-solid');
/*!40000 ALTER TABLE `tb_menu_item_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role_resource_list`
--

DROP TABLE IF EXISTS `tb_role_resource_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_role_resource_list` (
  `role_id` int(10) unsigned NOT NULL,
  `item_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`role_id`,`item_id`),
  KEY `tb_menu_item_privileges_role_id_item_id_index` (`role_id`,`item_id`),
  KEY `tb_menu_item_privileges_tb_roles_role_id_fk` (`item_id`),
  CONSTRAINT `tb_menu_item_privileges_tb_menu_item_item_id_fk` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_menu_item_privileges_tb_roles_role_id_fk` FOREIGN KEY (`item_id`) REFERENCES `tb_menu_item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色权限能访问的item';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role_resource_list`
--

LOCK TABLES `tb_role_resource_list` WRITE;
/*!40000 ALTER TABLE `tb_role_resource_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_role_resource_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_roles`
--

DROP TABLE IF EXISTS `tb_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_roles` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(14) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限名称',
  `role_desc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `tb_roles_role_name_uindex` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_roles`
--

LOCK TABLES `tb_roles` WRITE;
/*!40000 ALTER TABLE `tb_roles` DISABLE KEYS */;
INSERT INTO `tb_roles` VALUES (1,'ROLE_ADMIN','管理员',0,'2020-12-06 20:28:04'),(2,'ROLE_USER','普通用户',0,'2020-12-06 23:56:28');
/*!40000 ALTER TABLE `tb_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tags`
--

DROP TABLE IF EXISTS `tb_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tags` (
  `tag_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tag_create_time` datetime NOT NULL COMMENT '创建时间',
  `tag_desc` text COLLATE utf8mb4_unicode_ci,
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `user_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `tb_tags_tb_user_user_id_fk` (`user_id`),
  CONSTRAINT `tb_tags_tb_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='任务时的进展，或者标签';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tags`
--

LOCK TABLES `tb_tags` WRITE;
/*!40000 ALTER TABLE `tb_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_task_tag_list`
--

DROP TABLE IF EXISTS `tb_task_tag_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_task_tag_list` (
  `task_id` int(10) unsigned NOT NULL,
  `tag_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`task_id`,`tag_id`),
  KEY `tb_task_tag_list_tb_tags_tag_id_fk` (`tag_id`),
  CONSTRAINT `tb_task_tag_list_tb_tags_tag_id_fk` FOREIGN KEY (`tag_id`) REFERENCES `tb_tags` (`tag_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_task_tag_list_tb_tasks_task_id_fk` FOREIGN KEY (`task_id`) REFERENCES `tb_tasks` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_task_tag_list`
--

LOCK TABLES `tb_task_tag_list` WRITE;
/*!40000 ALTER TABLE `tb_task_tag_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_task_tag_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tasks`
--

DROP TABLE IF EXISTS `tb_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tasks` (
  `task_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `task_desc` text COLLATE utf8mb4_unicode_ci COMMENT '任务描述',
  `attendee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用来存储出席人物的 用户/部门，记录的是 用户/部门的数组，每个值使用;进行分隔',
  `is_dept` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用来标识是否于部门有关：要考虑以下情况1. 接收人是一个用户2. 接收人是一个部门 3. 接收人是多个部门 4. 接收人是多个不同部门的人',
  `create_time` datetime NOT NULL,
  `is_end` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '任务的进度，0 任务中 1 结束',
  `host_id` int(10) unsigned DEFAULT NULL COMMENT '任务负责人',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`task_id`),
  KEY `tb_tasks_tb_user_user_id_fk` (`host_id`),
  CONSTRAINT `tb_tasks_tb_user_user_id_fk` FOREIGN KEY (`host_id`) REFERENCES `tb_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tasks`
--

LOCK TABLES `tb_tasks` WRITE;
/*!40000 ALTER TABLE `tb_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '人员编号',
  `user_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '这个是登陆的用户ID，这里就是工号',
  `user_password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mgr_id` int(10) unsigned DEFAULT NULL COMMENT '上级领导的编号',
  `true_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '真实名称',
  `sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 男，1 女',
  `hire_date` date DEFAULT NULL COMMENT '入职时间',
  `sal` decimal(10,0) NOT NULL DEFAULT '2000' COMMENT '工资',
  `comm` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '提成，奖金之类的',
  `job` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职位',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `phone` char(11) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号',
  `photo` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像地址',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱地址',
  `last_ip` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最后的登陆ip',
  `last_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '1 表示删除了，0 表示未删除',
  `dept_id` int(10) unsigned DEFAULT '1' COMMENT '部门id（0 表示无部门）',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_emp_no_uindex` (`user_name`),
  KEY `tb_user_tb_dept_dept_id_fk` (`dept_id`),
  CONSTRAINT `tb_user_tb_dept_dept_id_fk` FOREIGN KEY (`dept_id`) REFERENCES `tb_dept` (`dept_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'2018250','$2a$10$2jUojQkN9IXmJ/oT1JDwFOfn/PgnRVZ9OmLT5bJE1b19i7w9vtNfa',NULL,'张三',0,'2020-12-06',2000,0,'管理员',NULL,'13128863336',NULL,NULL,NULL,NULL,0,1);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_role_list`
--

DROP TABLE IF EXISTS `tb_user_role_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_role_list` (
  `user_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `tb_user_role_list_tb_roles_role_id_fk` (`role_id`),
  CONSTRAINT `tb_user_role_list_tb_roles_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_role_list_tb_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_role_list`
--

LOCK TABLES `tb_user_role_list` WRITE;
/*!40000 ALTER TABLE `tb_user_role_list` DISABLE KEYS */;
INSERT INTO `tb_user_role_list` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `tb_user_role_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-08  0:47:03
