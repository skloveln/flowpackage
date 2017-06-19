insert into cf_admin (login_name, password, real_name, mobile, email, 
create_user_name, create_time, modify_name, update_time, available_flag, isSuper)
values ('admin', '5dfa01d892c3cc6efece0a37c471ff9a', '超级管理员', '13439911995', '429110293@qq.com',
'admin', now(), 'admin', NOW(), 1, 1);

insert into sys_application (application_code, application_name, application_desc) 
values (1001, '流量充值平台', '流量充值后台管理模块');

insert into sys_menu (menu_no, application_code, menu_parent_no, menu_order, munu_name, munu_url, menu_icon, is_visible, is_leaf)
values (1, 1001, null, 1, '管理员管理', null, 'Hui-iconfont-root', true, false);
insert into sys_menu (menu_no, application_code, menu_parent_no, menu_order, munu_name, munu_url, menu_icon, is_visible, is_leaf)
values (101, 1001, 1, 1, '管理员列表', 'admin-list.html', null, true, true);
insert into sys_menu (menu_no, application_code, menu_parent_no, menu_order, munu_name, munu_url, menu_icon, is_visible, is_leaf)
values (102, 1001, 1, 2, '权限管理', 'admin-permission.html', null, true, true);

insert into sys_menu (menu_no, application_code, menu_parent_no, menu_order, munu_name, munu_url, menu_icon, is_visible, is_leaf)
values (2, 1001, null, 2, '系统管理', null, 'Hui-iconfont-system', true, false);
insert into sys_menu (menu_no, application_code, menu_parent_no, menu_order, munu_name, munu_url, menu_icon, is_visible, is_leaf)
values (201, 1001, null, 2, '系统日志', 'system-log.html', null, true, false);

