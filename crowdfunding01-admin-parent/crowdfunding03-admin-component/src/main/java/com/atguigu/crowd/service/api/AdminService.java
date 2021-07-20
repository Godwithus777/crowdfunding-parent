package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;

public interface AdminService {

	
	void saveAdmin(Admin admin);

	List<Admin> getAll();
	// 登录方法
	Admin getAdminByLoginAcct(String loginAcct, String userPswd);
	
	// 分页显示Admin数据
	PageInfo<Admin> getPageInfo(String keyword, Integer pageNum,
			Integer pageSize);
}
