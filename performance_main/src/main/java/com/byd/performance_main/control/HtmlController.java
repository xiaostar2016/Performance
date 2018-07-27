package com.byd.performance_main.control;


import com.byd.performance_main.model.UserBean;
import com.byd.performance_utils.base.BaseController;
import com.byd.performance_utils.utils.CommonMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
//@RequestMapping(value = "/html")
public class HtmlController extends BaseController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        Date currentDate = CommonMethod.getCurrentDate();
        logger.info("进入/hello页面");
        return "Current Date: " + currentDate.toString() + " hello world";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showIndexHtml() {
        logger.info("进入/index");
        return "/index";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String showIndexHtml(Model mode) {
        logger.info("进入/test");

        UserBean userBean = new UserBean();
        userBean.setUserName("玲玲");
        userBean.setUserPassword("12345");
        userBean.setUserPhone("6666666666");
        mode.addAttribute("userBean", userBean);
        return "/test";
    }

}
