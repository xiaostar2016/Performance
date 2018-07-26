package com.byd.performance_main.control;


import com.byd.performance_main.model.UserBean;
import com.byd.performance_main.service.UserService;
import com.byd.performance_utils.base.BaseController;
import com.byd.performance_utils.utils.CommonMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(UserBean user) {
        logger.info("进入/add页面");
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        logger.info("进入/all页面");
        return userService.findAllUser(pageNum, pageSize);
    }

    @ResponseBody
    @GetMapping("/alls")
    public Map<String, Object> findAllUser() {
        logger.info("进入/alls页面");
        List<UserBean> userBeans = userService.findAllUser();
        Map<String, Object> map = new HashMap<>();
        map.put("allUsers", userBeans);
        return map;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        logger.info("进入/hello页面");
        Date currentDate = CommonMethod.getCurrentDate();

        return "Current Date: " + currentDate.toString() + " hello world";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showIndexHtml() {
        logger.info("进入/index页面");
        return "/index";
    }
}
