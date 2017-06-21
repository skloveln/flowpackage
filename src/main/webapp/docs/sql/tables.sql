drop table if exists cf_admin;

/*==============================================================*/
/* Table: cf_admin                                              */
/*==============================================================*/
create table cf_admin
(
   id                   int not null auto_increment comment '主键',
   login_name           varchar(32) comment '账号',
   password             varchar(48) comment '密码',
   real_name            varchar(32) comment '真实姓名',
   sex                  char(1) default '1' comment '性别 1男　2女',
   mobile               varchar(16) comment '手机号',
   email                varchar(32) comment '邮件',
   create_user_name     varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人名字',
   update_time          datetime comment '更改时间',
   first_login_time     datetime comment '第一次登录时间',
   last_login_time      datetime comment '最后一次登录时间',
   available_flag       boolean default true comment '是否可用',
   is_super             boolean default false comment '是否为超级管理员',
   primary key (id)
);

alter table cf_admin comment '管理员表';

drop table if exists cf_role;

/*==============================================================*/
/* Table: cf_role                                               */
/*==============================================================*/
create table cf_role
(
   id                   int not null auto_increment,
   role_name            varchar(32) comment '角色名称',
   role_desc            varchar(256) comment '角色描述',
   create_name          varchar(32) comment '创建人',
   create_time          datetime comment '创建时间',
   modify_name          varchar(32) comment '修改人',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table cf_role comment '角色表';

drop table if exists cf_adminRole;

/*==============================================================*/
/* Table: cf_adminRole                                          */
/*==============================================================*/
create table cf_adminRole
(
   id                   int not null auto_increment comment '主键',
   admin_id             int comment '管理员id',
   role_id              int comment '角色id',
   primary key (id)
);

alter table cf_adminRole comment '管理员角色关联表';

alter table cf_adminRole add constraint FK_Reference_1 foreign key (role_id)
      references cf_role (id) on delete restrict on update restrict;

alter table cf_adminRole add constraint FK_Reference_2 foreign key (admin_id)
      references cf_admin (id) on delete restrict on update restrict;

      
drop table if exists cf_privilege;

/*==============================================================*/
/* Table: cf_privilege                                          */
/*==============================================================*/
create table cf_privilege
(
   id                   int not null auto_increment comment '主键',
   master_type          tinyint comment '权限主体  1 角色 2 用户  ',
   master_id            int comment '权限主体id',
   access_type          tinyint comment '权限访问类型  1 菜单 2 按钮 3 模块',
   access_no            smallint comment '权限访问no  menuNo或者buttonNo或者applicationCode',
   is_operatation       boolean comment '禁止使用   默认false',
   primary key (id)
);

alter table cf_privilege comment '管理员权限表';

drop table if exists sys_application;

/*==============================================================*/
/* Table: sys_application                                       */
/*==============================================================*/
create table sys_application
(
   id                   int not null auto_increment comment '主键',
   application_code     smallint comment '模块code',
   application_name     varchar(32) comment '模块名称',
   application_desc     varchar(256) comment '模块描述',
   primary key (id)
);
ALTER TABLE sys_application ADD UNIQUE (application_code); 
alter table sys_application comment '系统模块';



drop table if exists sys_menu;

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   id                   int not null comment '主键',
   menu_no              smallint comment '菜单编码',
   application_code     smallint comment '模块code',
   menu_parent_no       smallint comment '父菜单编码',
   menu_order           smallint comment '菜单顺序',
   menu_name            varchar(32) comment '菜单名称',
   menu_url             varchar(256) comment '菜单url',
   menu_icon            varchar(256) comment '菜单icon',
   is_visible           boolean comment '是否可用 1可用 0不可用',
   is_leaf              boolean,
   primary key (id)
);
ALTER TABLE sys_menu ADD UNIQUE (menu_no);
alter table sys_menu comment '系统菜单表';

drop table if exists sys_button;

/*==============================================================*/
/* Table: sys_button                                            */
/*==============================================================*/
create table sys_button
(
   id                   int not null auto_increment comment '主键',
   btn_no               smallint comment '按钮编码',
   btn_name             varchar(32) comment '按钮名称',
   btn_class            varchar(32) comment '按钮类型',
   btn_icon             varchar(32) comment '按钮icon',
   menu_no              int comment '所属菜单id',
   init_status          boolean comment '初始化状态  1 可用 0 不可用',
   primary key (id)
);

alter table sys_button comment '系统按钮表';
      