package com.steins.service.impl;


import com.steins.dao.AdminUserDao;
import com.steins.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author Sunny
 */
@Service
@Transactional
public class AdminUserService {
	@Autowired
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
//登录
	public AdminUser login(AdminUser admin) {
		return adminUserDao.login(admin);
	}
//所有信息
	public AdminUser select(Integer uid){
		AdminUser adminUser=new AdminUser();
		adminUser=adminUserDao.selectAdmin(uid);
		return adminUser;
	}
//修改密码
	public Integer updatePW(Integer uid, String npw) {
		return adminUserDao.updatePW(uid,npw);
	}

}
