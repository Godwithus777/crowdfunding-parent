package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.Admin;

public interface AdminService {

	
	void saveAdmin(Admin admin);

	List<Admin> getAll();
	// 登录方法
	Admin getAdminByLoginAcct(String loginAcct, String userPswd);
}
