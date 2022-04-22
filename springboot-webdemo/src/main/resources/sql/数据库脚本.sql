create database webdemo;
use webdemo;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT, -- 用户编号
  `username` varchar(32) DEFAULT NULL,	-- 用户名字
  `password` varchar(32) DEFAULT NULL,	-- 用户密码
  `remark` varchar(32) DEFAULT NULL,	-- 用户备注
  `email` varchar(32) DEFAULT NULL,		-- 用户邮箱
  `createTime` timestamp not NULL DEFAULT CURRENT_TIMESTAMP, -- 该用户创建时间
  `updateTime` timestamp not NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 该用户修改时间
  PRIMARY KEY (`id`) -- 设置主键
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- timestamp 时间戳, 添加数据的时候createTime=null那么createTime = 系统当前时间 (年月日 时分秒)
-- updateTime 在你执行update语句,自动修改为修改的当前时间
-- 此语法在mysql8.0上是不兼容的可以修改成 `createTime` datetime
-- ----------------------------
-- Records of t_user
-- ----------------------------

insert into t_user values(null,'admin','123',null,'admin@163.com',null,null),(null,'zhansan','123',null,'zhansan@163.com',null,null);

# 角色表
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT, -- 角色id
  `name` varchar(32) DEFAULT NULL,	-- 角色名字
  `keyword` varchar(64) DEFAULT NULL,	-- 角色关键字
  `description` varchar(128) DEFAULT NULL,	-- 角色描述
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', 'ROLE_ADMIN', '这是管理员')
,('2', '会员', 'ROLE_MEMBER', '这是会员')
,('3', '游客', 'ROLE_VISITOR', '这是游客');

# 权限表
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT, -- 权限编号
  `name` varchar(32) DEFAULT NULL,		-- 权限名字
  `keyword` varchar(64) DEFAULT NULL,	-- 权限关键字
  `description` varchar(128) DEFAULT NULL,	-- 权限描述
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '新增', 'ITEM_ADD', '这是新增权限')
,('2', '删除', 'ITEM_DELETE', '这是删除权限')
,('3', '编辑', 'ITEM_EDIT', '这是编辑权限')
,('4', '查询', 'ITEM_QUERY', '这是查询权限');

# 用户角色中间表
CREATE TABLE `t_user_role` (
  `user_id` int(11) NOT NULL, 
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_Reference_8` (`role_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 联合主键
	-- 1. 一张表只能有一个主键 (唯一标识)
	-- 2. 一个主键可以多个字段 (联合主键)
		-- 2.1   class=316  班级号
		-- 2.2   number=5   座位号
		-- 2.3   以上任一字段都无法确定一个同学, 两者合在一起就可以唯一确定一位同学(联合主键)
		
-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1'),('1','2'),('2', '2');

# 角色权限中间表
CREATE TABLE `t_role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FK_Reference_12` (`permission_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` 
	VALUES ('1', '1'),('1', '2'),('1', '3'),('1', '4'),('2', '3'),('2', '4'),('3', '4');





