/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : manager

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-05-28 20:39:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ausername` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `apassword` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for admin_menus
-- ----------------------------
DROP TABLE IF EXISTS `admin_menus`;
CREATE TABLE `admin_menus` (
  `mid` int(11) NOT NULL,
  `menuname` varchar(10) DEFAULT NULL,
  `menuurl` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_menus
-- ----------------------------
INSERT INTO `admin_menus` VALUES ('1', '学生管理', '/admin/stu');
INSERT INTO `admin_menus` VALUES ('2', '教师管理', '/admin/tea');
INSERT INTO `admin_menus` VALUES ('3', '公告管理', '/admin/notice');
INSERT INTO `admin_menus` VALUES ('4', '课程管理', '/admin/course');
INSERT INTO `admin_menus` VALUES ('5', '教室管理', '/admin/room');
INSERT INTO `admin_menus` VALUES ('6', '其他管理', '/admin/other');

-- ----------------------------
-- Table structure for admin_notice
-- ----------------------------
DROP TABLE IF EXISTS `admin_notice`;
CREATE TABLE `admin_notice` (
  `nid` int(11) NOT NULL,
  `context` varchar(30) DEFAULT NULL,
  `time` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_notice
-- ----------------------------
INSERT INTO `admin_notice` VALUES ('1', '系统已经更新，请查看最新的功能吧', '2019-05-04');
INSERT INTO `admin_notice` VALUES ('2', '系统持续更新中', '2019-05-06');
INSERT INTO `admin_notice` VALUES ('3', '测试', '2020');
INSERT INTO `admin_notice` VALUES ('4', '第二个测试', '2019-9-9');
INSERT INTO `admin_notice` VALUES ('99', '99', '99');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cno` varchar(10) NOT NULL,
  `cname` varchar(10) DEFAULT NULL,
  `cteacher` varchar(10) DEFAULT NULL,
  `cnumber` int(11) DEFAULT NULL,
  `coursetab` varchar(20) NOT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('602', 'javaEE', '陈少杰', '109', '课表');
INSERT INTO `course` VALUES ('603', '数据库', '梁倩', '120', '课表');

-- ----------------------------
-- Table structure for coursetable
-- ----------------------------
DROP TABLE IF EXISTS `coursetable`;
CREATE TABLE `coursetable` (
  `ttime` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `taddress` varchar(10) DEFAULT NULL,
  `troom` varchar(10) DEFAULT NULL,
  `tteacher` varchar(10) DEFAULT NULL,
  `tstudent` varchar(10) DEFAULT NULL,
  `cno` varchar(10) NOT NULL,
  PRIMARY KEY (`ttime`),
  KEY `cno` (`cno`),
  CONSTRAINT `coursetable_ibfk_1` FOREIGN KEY (`cno`) REFERENCES `course` (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursetable
-- ----------------------------
INSERT INTO `coursetable` VALUES ('1-13周，周二第二节', '西苑八号楼', '8-310', '梁倩', '查看', '603');
INSERT INTO `coursetable` VALUES ('1-13周，周五第二节', '西苑九号楼', '9-401', '梁倩', '查看', '603');
INSERT INTO `coursetable` VALUES ('1-14周，周二第三节', '西苑八号楼', '8-211', '陈少杰', '查看', '602');
INSERT INTO `coursetable` VALUES ('1-14周，周四第三节', '西苑九号楼', '9-201', '陈少杰', '查看', '602');

-- ----------------------------
-- Table structure for javaeestudent
-- ----------------------------
DROP TABLE IF EXISTS `javaeestudent`;
CREATE TABLE `javaeestudent` (
  `sno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(10) DEFAULT NULL,
  `ssex` varchar(10) DEFAULT NULL,
  `sclass` varchar(10) DEFAULT NULL,
  `susername` varchar(15) DEFAULT NULL,
  `spassword` varchar(15) DEFAULT NULL,
  `gradeone` int(11) DEFAULT NULL,
  `gradetwo` int(11) DEFAULT NULL,
  `gradeall` int(11) DEFAULT NULL,
  `object` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of javaeestudent
-- ----------------------------

-- ----------------------------
-- Table structure for oraclestudent
-- ----------------------------
DROP TABLE IF EXISTS `oraclestudent`;
CREATE TABLE `oraclestudent` (
  `sno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(10) DEFAULT NULL,
  `ssex` varchar(10) DEFAULT NULL,
  `sclass` varchar(10) DEFAULT NULL,
  `susername` varchar(15) DEFAULT NULL,
  `spassword` varchar(15) DEFAULT NULL,
  `gradeall` int(11) DEFAULT NULL,
  `gradeone` int(11) DEFAULT NULL,
  `gradetwo` int(11) DEFAULT NULL,
  `object` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oraclestudent
-- ----------------------------

-- ----------------------------
-- Table structure for profess
-- ----------------------------
DROP TABLE IF EXISTS `profess`;
CREATE TABLE `profess` (
  `pno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profess
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `rno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rnumber` int(11) DEFAULT NULL,
  `rcomputer` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`rno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('8-210', '150', '有');
INSERT INTO `room` VALUES ('8-311', '150', '有');
INSERT INTO `room` VALUES ('8-4', '350', '有');
INSERT INTO `room` VALUES ('8-5', '350', '无');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(10) DEFAULT NULL,
  `ssex` varchar(10) DEFAULT NULL,
  `sclass` varchar(10) DEFAULT NULL,
  `susername` varchar(20) DEFAULT NULL,
  `spassword` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1218', '王鑫垚', '男', '161012', '16101218', '16101218');
INSERT INTO `student` VALUES ('1219', '武大郎', '男', '161012', '16101219', '16101219');
INSERT INTO `student` VALUES ('1230', '张琦', '女', '161012', '16101230', '16101230');
INSERT INTO `student` VALUES ('1308', '王帅帅', '男', '161013', '16101308', '16101308');
INSERT INTO `student` VALUES ('1409', '李强', '男', '161014', '16101409', '16101409');

-- ----------------------------
-- Table structure for studenttest
-- ----------------------------
DROP TABLE IF EXISTS `studenttest`;
CREATE TABLE `studenttest` (
  `cno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  `cteacher` varchar(20) DEFAULT NULL,
  `cnumber` int(11) DEFAULT NULL,
  `coursetab` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studenttest
-- ----------------------------

-- ----------------------------
-- Table structure for student_menus
-- ----------------------------
DROP TABLE IF EXISTS `student_menus`;
CREATE TABLE `student_menus` (
  `sid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `menuname` varchar(10) DEFAULT NULL,
  `menuurl` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_menus
-- ----------------------------
INSERT INTO `student_menus` VALUES ('1', '我的信息', '/student/infor');
INSERT INTO `student_menus` VALUES ('2', '我要选课', '/student/choose/');
INSERT INTO `student_menus` VALUES ('3', '我的课表', '/student/coursetable');
INSERT INTO `student_menus` VALUES ('4', '我的成绩', '/student/grade');
INSERT INTO `student_menus` VALUES ('5', '我的公告', '/student/notice');

-- ----------------------------
-- Table structure for student_notice
-- ----------------------------
DROP TABLE IF EXISTS `student_notice`;
CREATE TABLE `student_notice` (
  `nid` int(11) NOT NULL,
  `context` varchar(30) DEFAULT NULL,
  `time` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_notice
-- ----------------------------
INSERT INTO `student_notice` VALUES ('4', '第二个测试', '2019-9-9');
INSERT INTO `student_notice` VALUES ('99', '99', '99');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tno` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tname` varchar(10) DEFAULT NULL,
  `tphone` varchar(10) DEFAULT NULL,
  `tprofess` varchar(10) DEFAULT NULL,
  `tcourse` varchar(10) DEFAULT NULL,
  `tusername` varchar(20) DEFAULT NULL,
  `tpassword` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('9001', '陈少杰', '60605565', '计算机科学与技术专业', 'java', '123456', '123456');
INSERT INTO `teacher` VALUES ('9002', '梁倩', '60606695', '物联网', '数据库', '123', '123');

-- ----------------------------
-- Table structure for teacher_menus
-- ----------------------------
DROP TABLE IF EXISTS `teacher_menus`;
CREATE TABLE `teacher_menus` (
  `tid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `menuname` varchar(20) DEFAULT NULL,
  `menuurl` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_menus
-- ----------------------------
INSERT INTO `teacher_menus` VALUES ('1', '我的信息', '/teacher/infor');
INSERT INTO `teacher_menus` VALUES ('2', '学生管理', '/teacher/student');
INSERT INTO `teacher_menus` VALUES ('3', '成绩管理', '/teacher/grade');
INSERT INTO `teacher_menus` VALUES ('4', '公告管理', '/teacher/notice');

-- ----------------------------
-- Table structure for teacher_notice
-- ----------------------------
DROP TABLE IF EXISTS `teacher_notice`;
CREATE TABLE `teacher_notice` (
  `nid` int(11) NOT NULL,
  `context` varchar(30) DEFAULT NULL,
  `time` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_notice
-- ----------------------------
INSERT INTO `teacher_notice` VALUES ('4', '第二个测试', '2019-9-9');
INSERT INTO `teacher_notice` VALUES ('99', '99', '99');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('c87fab56-9e10-415f-9bf5-a091ce56d998', '/6/0/7A30A4C4E9CF439C822BAE16F4AA1CBF.png');
INSERT INTO `users` VALUES ('5f8fcc67-2496-491e-b091-2d56824e18fa', '/B/0/E35EAD29C2F64B01B3AA203984232E71.png');
INSERT INTO `users` VALUES ('89563e28-a918-453b-993f-31efb5b2df4c', '/D/1/23948FF13E8046C6B1F325C13CE97C71.png');
INSERT INTO `users` VALUES ('87537bba-1db4-46d8-892d-da97ef371375', '/3/A/8B7C32B660494EA7868446B08A7421B2.jpg');
