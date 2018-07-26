package com.byd.performance_main.dao;


import com.byd.performance_main.model.UserBean;

import java.util.List;

public interface UserDao {
    int insert(UserBean userBean);

    List<UserBean> queryUserBean();
}
