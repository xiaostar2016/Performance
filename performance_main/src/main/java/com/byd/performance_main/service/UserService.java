package com.byd.performance_main.service;


import com.byd.performance_main.model.UserBean;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    int addUser(UserBean user);

    PageInfo<UserBean> findAllUser(int pageNum, int pageSize);

    List<UserBean> findAllUser();
}
