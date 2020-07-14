package com.study.sys.controller;


import com.study.common.DataGridView;
import com.study.sys.service.IBilltypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Deja wu
 * @since 2020-07-09
 */
@RestController
@RequestMapping("/billtype")
public class BilltypeController {

    @Autowired
    private IBilltypeService iBilltypeService;

    @RequestMapping("loadAllBillType")
    public DataGridView loadAllBillType(){
        return new DataGridView(0L,iBilltypeService.list());
    }
}

