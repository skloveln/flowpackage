--添加模块
insert into sys_application (id, application_code, application_name, application_desc) 
values (1, 1001, '流量充值平台', '流量充值后台管理模块');

--添加菜单
insert into sys_menu (id, menu_no, application_code, menu_parent_no, menu_order, menu_name, menu_url, menu_icon, is_visible, is_leaf)
	values (1, 1, 1001, null, 1, '管理员管理', null, 'Hui-iconfont-root', true, false);
insert into sys_menu (id, menu_no, application_code, menu_parent_no, menu_order, menu_name, menu_url, menu_icon, is_visible, is_leaf)
	values (2, 101, 1001, 1, 1, '管理员列表', 'admin-list.html', null, true, true);
insert into sys_menu (id, menu_no, application_code, menu_parent_no, menu_order, menu_name, menu_url, menu_icon, is_visible, is_leaf)
	values (3, 102, 1001, 1, 2, '权限管理', 'admin-permission.html', null, true, true);

insert into sys_menu (id, menu_no, application_code, menu_parent_no, menu_order, menu_name, menu_url, menu_icon, is_visible, is_leaf)
	values (4, 2, 1001, null, 99, '系统管理', null, 'Hui-iconfont-system', true, false);
insert into sys_menu (id, menu_no, application_code, menu_parent_no, menu_order, menu_name, menu_url, menu_icon, is_visible, is_leaf)
	values (5, 201, 1001, 2, 1, '系统日志', 'system-log.html', null, true, true);

insert into sys_menu (id, menu_no, application_code, menu_parent_no, menu_order, menu_name, menu_url, menu_icon, is_visible, is_leaf)
	values (6, 3, 1001, null, 2, '商家管理', null, 'Hui-iconfont-huangguan', true, false);
insert into sys_menu (id, menu_no, application_code, menu_parent_no, menu_order, menu_name, menu_url, menu_icon, is_visible, is_leaf)
	values (7, 301, 1001, 3, 1, '商家列表', 'merchant-list.html', null, true, true);
insert into sys_menu (id, menu_no, application_code, menu_parent_no, menu_order, menu_name, menu_url, menu_icon, is_visible, is_leaf)
	values (8, 302, 1001, 3, 2, '订单列表', 'order-list.html', null, true, true);
	
--添加角色
insert into cf_role (id, role_name, role_desc, create_name, create_time) values (1, '超级管理员', '超级管理员权限组', 'admin', now());
insert into cf_role (id, role_name, role_desc, create_name, create_time) values (2, '普通管理员', '普通管理员权限组', 'admin', now());

--添加管理员
insert into cf_admin (id, login_name, password, real_name, mobile, email, 
	create_user_name, create_time, modify_name, update_time, available_flag, is_super)
	values (1, 'admin', '5dfa01d892c3cc6efece0a37c471ff9a', '超级管理员', '13439911995', '429110293@qq.com',
	'admin', now(), 'admin', NOW(), 1, 1);
insert into cf_admin (id, login_name, password, real_name, mobile, email, 
	create_user_name, create_time, modify_name, update_time, available_flag, is_super)
	values (2, 'wangdaojian', '123456', '王道健', '13439911995', '429110293@qq.com',
	'admin', now(), 'admin', NOW(), 1, 0);

--添加管理员角色关联
insert into cf_adminRole (id, admin_id, role_id) values (1, 1, 1);
insert into cf_adminRole (id, admin_id, role_id) values (2, 2, 2);

--添加角色权限关联
insert into cf_privilege (id, master_type, master_id, access_type, access_no, is_operatation) values (1, 2, 2, 3, 1001, false);
insert into cf_privilege (id, master_type, master_id, access_type, access_no, is_operatation) values (2, 2, 2, 1, 2, false);
insert into cf_privilege (id, master_type, master_id, access_type, access_no, is_operatation) values (3, 2, 2, 1, 201, false);
insert into cf_privilege (id, master_type, master_id, access_type, access_no, is_operatation) values (4, 2, 2, 1, 3, false);
insert into cf_privilege (id, master_type, master_id, access_type, access_no, is_operatation) values (5, 2, 2, 1, 301, false);
insert into cf_privilege (id, master_type, master_id, access_type, access_no, is_operatation) values (6, 2, 2, 1, 302, false);



