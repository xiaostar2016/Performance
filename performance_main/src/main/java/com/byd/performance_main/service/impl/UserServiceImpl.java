package com.byd.performance_main.service.impl;


import com.byd.performance_main.dao.UserDao;
import com.byd.performance_main.model.UserBean;
import com.byd.performance_main.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响

    @Override
    public int addUser(UserBean user) {
        return userDao.insert(user);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<UserBean> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<UserBean> userBeans = userDao.queryUserBean();
        PageInfo result = new PageInfo(userBeans);
        return result;
    }

    @Override
    public List<UserBean> findAllUser() {
        List<UserBean> userBeans = userDao.queryUserBean();
        return userBeans;
    }


}
