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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_meeting`
--

LOCK TABLES `tb_meeting` WRITE;
/*!40000 ALTER TABLE `tb_meeting` DISABLE KEYS */;
INSERT INTO `tb_meeting` VALUES (1,1,'2020-12-31 04:07:00','2020-12-10 09:46:04','<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">四周都是高山，太阳八点多钟才从山坳里出来。最先照着的是那块平地，在平地上，有一排平房。前面有一个很大的土操场。天晴的日子，场子里总有人在蹦蹦跳跳，一到下雨或者下雪的时候，蹦跳就在走廊上。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">高先生正规师范毕业，另外四个老师都是&ldquo;土八路&rdquo;。高先生不是校长，校长是沈先生，沈先生忙里忙外，要去小镇上买一些<a style=\"color: #252525; text-decoration-line: none;\" href=\"https://www.bidushe.com/jingdian/suibi/\">生活</a>用品，拖欠的工资要去找镇上的领导要。高先生一个人过，据说在别的地方的时候，有一个相好，也不知真假，他从不说。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">他上课的时候，教室门都开着，哪怕是下雪的日子，冷得不行，门也开着。高先生一讲课，整个山谷都有回声。有一次，一个学生家长找自己的孩子，农村里谁家没有一些事情呢，要么是家里的牛跑了，或者家里来了亲戚，再不就是家长要去做客了，把孩子接走一起做客。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">家长在门外喊孩子，高先生硬是不理睬，绝对不让那个孩子走出教室，就是下课后，也不让那个孩子走，最后是沈校长跟高先生商量，才让那个孩子的家长接走了。这以后，家长都知道了，高先生上课的时候，站都不能站到教室门口，只有等别的老师上课，才能接孩子。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">高先生喜欢跑步，早晨从这个山头跑到对面山上另一个山头。好多农人都在坡地里锄草，栽苗或者挖地，见到高先生从这边跑到那边，然后又从那边跑到这边，他们都议论，这高先生是不是脑子不太好使。有那么多的力气还不如挖几块地呢。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">高先生不只是跑步，而且边跑的时候边唱歌：&ldquo;日出东边神气爽，西边霞来飞满天。半空腾云楼阁现，济济一堂如春风。山河响彻云崖暖，青峰岭上欢乐扬。待到一日风帆起，直挂沧海破云霄。&rdquo;</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">那断断续续的声音，在山谷里也是断断续续的。有那力气，真不如弄些吃的。好多人都这样想。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">高先生在上课的时候，也教学生唱：&ldquo;日出东边神气爽&hellip;&hellip;&rdquo;学生一起唱，嫩嫩的声音，嫩嫩的歌曲，唱得学生摇头晃脑，高先生也把头扭过去，扭过去，一直扭到不能再扭了，最后一巴掌拍在桌子上，那只讲桌只有三条腿，那里经受得了高先生的一巴掌，一下就歪到一边去了，正好压到了高先生的脚上。他嘿嘿地笑了笑，一般的人那里看得出高先生那笑里的意思啊，桌子压着他的脚，疼呢。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">高先生把学生拉到场子上，站好队伍，先也是一起唱：&ldquo;日出东边神气爽&hellip;&hellip;&rdquo;高年级的同学散乱地站在一边，也跟着唱了起来。沈校长总是不组织其他班级一起唱，可是孩子一听到歌声就出来了，那些老师也鼓励孩子跟着高先生这班级里的孩子一起唱。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">我毕业的时候，高先生还没有结婚。有一个女孩子，长相普通，来过几次找高先生，可是高先生总不冷不热，女孩待了一阵子又走了。女孩子来的时候，好多的学生趴在窗子边上，从一层塑料油纸边上看，看着高先生坐在一把破凳子上，女孩子坐在另外一把破凳子上，高先生轻轻地哼着：&ldquo;&hellip;&hellip;西边霞来飞满天&hellip;&hellip;&rdquo;女孩子问，你看这事情怎么样。那时候高先生唱到了&ldquo;待得一日风帆起&rdquo;。女孩真的起来了，一甩手，就走了出去。那些趴在窗子前的学生，一下轰地散开。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">我们离开学校的那一天，那首歌我们唱了好多遍，唱到最后，我们才知道，它就好象一汪奔涌的泉水，会从我们的眼睛里出来。我们心里都把它叫做校歌。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">&ldquo;&hellip;&hellip;待到一日风帆起，直挂沧海破云霄。&rdquo;唱着唱着，我们就把高先生抬了起来，抛了起来。高先生，就是我们的风帆。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">这校歌，是我们一生里记得最清楚的歌曲，也是我们最会唱的歌，它如血液一样，在我们周身飞快地转动着，慢慢地进入到了我们的骨髓里，跟我们一起成长。</p>','座谈会',0),(2,1,'2020-12-31 04:07:00',NULL,'<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(3,1,'2020-12-31 04:07:00',NULL,'<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff;\"><span style=\"color: #2dc26b;\">每年的阳春三月，我们幕阜山区的天气总以晴好为主，并时不时地下一阵毛毛细雨，常会出现&ldquo;东边日出西边雨&rdquo;的景象。不仅气候温和，而且空气湿度大。（10月也有极其接近的气候，在当地且有&ldquo;十月小阳春&rdquo;之说。）这时，小山丘松树林下红红的蓬松的松针层下便会不断地长出小伞般红红的香香的松菇来。长辈们都说，第一个松菇的菇口朝哪方，哪方就能找到一大串的松菇。而我却从没看过菇口的方向，因为小时候我的一双小眼睛对于探找红松毛下一朵一朵红色小伞似的小松菇那是特别的灵敏，简直就像长着上百个眼珠子复眼的鹰眼，总是刚捡了第一个，马上就发现了第三、第四个，甚至是第七、第八个，霎时间，我便忙都忙不过来，哪还有什么心思去看菇口呀！要说那个松菇呀，尤其是在那个短吃少穿的年代，在我们小村里那简直就是珍宝了，无论是放上大蒜炒着吃，还是打汤煮豆结、油面吃，那都是又香又甜又鲜，好吃极了。</span></p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff;\"><span style=\"background-color: #bfedd2;\">除了鲜亮的松菇，松林里时常还会&ldquo;扑腾腾&rdquo;飞出长颈的白鹭、长尾巴的喜鹊线来，有时还会遇见肥胖而笨重的松鸡和&ldquo;二十四个喉咙咽&rdquo;的猫头鹰。到了夏季，还有伏在有龙鳞般树皮的树干上&ldquo;吱&mdash;&mdash;吱&mdash;&mdash;&rdquo;地阵阵鸣叫的黑壳老蝉。我们这些山里孩子，只要一见到草帽似的支在松树枝杈上的鸟窝，手就痒痒的，于是便猴子般地纵身爬到两三丈高的松树杈上去，可惜的是，那些鸟窝十有八九都是空的；好不容易掏了一窝杏子大小的鸟蛋回家，煨熟剥开后，才发现里面全都是长毛带血的小鸟，不能吃。我们于是又找来竹竿，在竿头上撑着塑料袋，举得高高的按到松树干上去捕蝉。没想到还真管用，一会儿就捕到了十几只，装在布袋里撞着叫着，可以玩好几天呢。</span></p>','座谈会',0),(4,1,'2020-12-31 04:07:00','2020-12-10 09:44:36','<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(5,1,'2020-12-31 04:07:00','2020-12-10 09:44:37','<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(6,1,'2020-12-31 04:07:00',NULL,'<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(7,1,'2020-12-31 04:07:00',NULL,'<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(8,1,'2020-12-31 04:07:00',NULL,'<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(9,1,'2020-12-31 04:07:00',NULL,'<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(10,1,'2020-12-31 04:07:00','2020-12-10 09:39:00','<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(11,1,'2020-12-31 04:07:00','2020-12-10 09:39:02','<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(12,1,'2020-12-31 04:07:00',NULL,'<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(13,1,'2020-12-31 04:07:00',NULL,'<p><em>希<span style=\"font-family: symbol;\"><span style=\"color: #843fa1;\">望</span><span style=\"color: #f1c40f;\">创</span></span></em><span style=\"background-color: #3598db;\"><span style=\"color: #f1c40f;\"><em><span style=\"font-family: symbol;\">建</span>成</em></span>功啊</span></p>','座谈会',0),(14,1,'2020-12-10 06:58:42','2020-12-10 14:56:51','<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\"><strong>在如今这个现实的社会中谈恋爱是男女交往中不得不花钱的过程，可是一般情况下，都是男生花钱的，很少有女生花钱的，而现在用金钱来衡量<a style=\"color: #252525; text-decoration-line: none;\" href=\"https://www.bidushe.com/qinggan/aiqing/\">爱情</a>了，可是也有个别的男生，认为凭什么要自已花钱，难道在一起一定要男生花钱，所以他们一次又一次向女生索取，显得十分吝啬，出手显得十分小气，还铮铮有理地说，是人重要还是钱重要，还说这样的钱花的是值得，还说记得你的恩情，一有钱了就会如数归还，听起来挺有信用的，再加上平时按时归还的，所以因为之前的信任，再加上，情侣之间也有所帮忙，连吃个饭也要索要一点小钱。</strong></p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff;\"><span style=\"background-color: #f1c40f;\">钱，其实也是其次，谈恋爱中的爱，是互相的，不是利用，平时虽然在联系，也没有什么甜言蜜语，可是并不是被差遣办事的，好像有一点不开心了，说几句冷心的话，就不去体谅了吗？虽然吵架是难免的，可是不是一句对不起可以解决的，你的利益是最大化了，可是态度的问题还是关键，甚至怀疑这根要不是爱，纯属利用感情。</span></p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff;\"><span style=\"color: #2dc26b;\">爱情是什么，不只是一个承诺，对于付出，除了金钱以外，作为一个男人又付出了多少，不要说自已有多可怜，像一个乞丐一样，吃的是女人的施舍，用的是女人血汗钱，难道不用去心疼吗？对于婚姻总是在回避，事业的事以后可以解决，可是连<a style=\"color: #2dc26b;\" href=\"https://www.bidushe.com/jingdian/suibi/\">生活</a>的细节都要靠女人来维持，算什么有担当的男人，说难听点就是一个吃软饭的。</span></p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff;\"><sub><code>爱是互相的，其实已经失去了平衡，当撒谎成了一种习惯，去欺骗所有的人，让自已获利，利益最大化，其实就是一个自私的表现，难怪现在的渣男和渣女这么多，让爱情的真谛变得越来现实，谁还会去相信爱情，所以只能让多金钱来替代，说什么愿意花钱，才是越爱你的。</code></sub></p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff;\"><span style=\"text-decoration: line-through;\">当爱情变得现实，有人贪钱，有人贪利，有人贪心，现在只能用钱来衡量了，可是钱并不是每个人都有的，都是工作的血汗钱，还说你能几个钱，你很有钱吗？好像用别人的钱不会心疼一样。感情这个东西，在于付出，不是一味索取。可是现实的人，就是这样的，非得让自已利益最大化。</span></p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff;\"><em>因为人是自私的，所以爱情中的分分合合变得家常便饭，可是分了几次，是真爱还是利用，只是当事人才知道。本来可以勇敢的面对生活，积极的过日子，是一件<a style=\"color: #252525; text-decoration-line: none;\" href=\"https://www.bidushe.com/diary/kuaile/\">快乐</a>的事，可是总是会波折来考验你的真情，经历每个人不一样，所以人者见人智者见智。</em></p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">一段爱情走到这里，成了一个教训，人心的可怕，让爱变质了， 现实的社会，让人性变得黑暗无比，善良就是这样，人善而欺天不欺，钱就是最现实的东西，爱情同金钱一样，付出越多，不一定有回报的，看人家的良心了，有的人良心说的好听，其实早点被自私给淹没了，无情加绝情。</p>\n<p style=\"margin: 25px auto 0px; padding: 0px; color: #252525; font-family: \'Microsoft Yahei\', Arial; font-size: 16px; background-color: #ffffff; text-align: center;\">这就是现在爱情与金钱的关系！</p>','经验交流会',0);
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
INSERT INTO `tb_menu_item` VALUES (1,'当前任务',0,NULL,'currentTask',1),(2,'用户历史任务',0,NULL,'userHistoryTask',1),(3,'周报',0,NULL,'weekSummary',1),(4,'个人资料',0,NULL,'personal',1),(5,'统计',0,NULL,'myStat',1),(6,'录入职员',0,NULL,'addEmployee',2),(7,'修改职员信息',0,NULL,'updateEmployee',2),(8,'搜索职员',0,NULL,'searchEmployee',3),(9,'搜索周报',0,NULL,'searchWeekSummary',3),(10,'搜索会议',0,NULL,'searchMeeting',3),(11,'搜索任务',0,NULL,'searchTask',3),(16,'分组管理',0,NULL,'groupManageGroup',4),(17,'任务管理',0,NULL,'tasksManage',4),(18,'职员任务',0,NULL,'employeeTask',4),(19,'历史任务',0,NULL,'allHistoryTask',4),(20,'创建会议',0,NULL,'createMeeting',5),(21,'当前会议',0,NULL,'currentMeeting',5),(22,'修改当前会议',0,NULL,'updateMeeting',5),(23,'历史会议',0,NULL,'historyMeeting',5),(24,'发起通知',0,NULL,'createMessage',6),(25,'历史通知',0,NULL,'historyMessage',6),(26,'删除通知',0,NULL,'deletedMessage',7),(27,'删除会议',0,NULL,'deletedMeeting',7),(28,'删除任务',0,NULL,'deletedTask',7),(29,'删除职员',0,NULL,'deleteEmployee',7);
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
INSERT INTO `tb_role_resource_list` VALUES (1,1),(2,1),(1,2),(2,2),(1,3),(2,3),(1,4),(2,4),(1,5),(2,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(2,21),(1,22),(1,23),(2,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'2018250','$2a$10$2jUojQkN9IXmJ/oT1JDwFOfn/PgnRVZ9OmLT5bJE1b19i7w9vtNfa',NULL,'张三',0,'2020-12-06',2000,0,'管理员',NULL,'13128863336',NULL,NULL,NULL,NULL,0,1),(2,'2018251','$2a$10$2jUojQkN9IXmJ/oT1JDwFOfn/PgnRVZ9OmLT5bJE1b19i7w9vtNfa',NULL,'李四',0,'2020-12-06',2000,0,'普通用户',NULL,'13199963336',NULL,NULL,NULL,NULL,0,1);
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
INSERT INTO `tb_user_role_list` VALUES (1,1),(1,2),(2,2);
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

-- Dump completed on 2020-12-10 23:55:29
