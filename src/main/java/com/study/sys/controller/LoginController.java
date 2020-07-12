package com.study.sys.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.common.ResultObj;
import com.study.sys.pojo.User;
import com.study.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * <p>
 *  前端控制器
 *  登录控制器
 * </p>
 *
 * @author Deja wu
 * @since 2020-07-09
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService iUserService;

    /**
     * 跳转到登录页面
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public ResultObj login(String loginname, String pwd,String code,HttpSession session){

        //将前端用户输入的验证码与session中生成的验证码比对
        if (code!=null&&code.equals(session.getAttribute("code"))) {
            //组装mp查询条件
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("loginname",loginname);
            userQueryWrapper.eq("pwd",pwd);
            //从数据库中返回一个结果
            User user = iUserService.getOne(userQueryWrapper);
            if (user!=null){
                session.setAttribute("user",user);
                return new ResultObj(200,"登录成功");
            }else {
                return new ResultObj(-1,"用户名或密码正确");
            }
        }else{
            return new ResultObj(-1,"验证码错误");
        }
    }

    @RequestMapping("getCode")
    public void getCode(HttpServletResponse resp, HttpSession session) throws IOException {
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(116, 36,4,5);
        //获取验证码
        String code = circleCaptcha.getCode();
        //放入session中
        session.setAttribute("code",code);
        ServletOutputStream outputStream = resp.getOutputStream();
        circleCaptcha.write(outputStream);
        outputStream.close();
    }
}

