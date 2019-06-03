package com.steins.dao;

import com.steins.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

public interface AdminUserDao {
    public AdminUser login(AdminUser admin);
    public Integer updatePW(@Param("uid") Integer uid, @Param("npw") String npw);
    public AdminUser selectAdmin(Integer uid);
}
