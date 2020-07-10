package com.study.sys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Deja wu
 * @since 2020-07-09
 */
@Controller
@RequestMapping("/bills")
public class BillsController {

    /**
     * 跳转到系统登录的主页
     */
    @RequestMapping("toBillsList")
    public String toBillsList(){
        return "list";
    }
}

