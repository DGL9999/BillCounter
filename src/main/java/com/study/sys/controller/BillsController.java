package com.study.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.DataGridView;
import com.study.sys.pojo.Bills;
import com.study.sys.pojo.Billtype;
import com.study.sys.service.IBillsService;
import com.study.sys.service.IBilltypeService;
import com.study.sys.vo.BillsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


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

    @Autowired
    private IBillsService iBillsService;

    @Autowired
    private IBilltypeService iBilltypeService;

    /**
     * 跳转到系统登录的主页
     */
    @RequestMapping("toBillsList")
    public String toBillsList(){
        return "list";
    }

    /**
     * 加载账单数据列表
     */
    @RequestMapping("loadAllBills")
    @ResponseBody
    public DataGridView loadAllBills(BillsVo billsVo){
        IPage<Bills> page = new Page<>(billsVo.getPage(),billsVo.getLimit());
        QueryWrapper<Bills> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(billsVo.getTypeid()!=null && billsVo.getTypeid()!=0,"typeid",billsVo.getTypeid());
        queryWrapper.ge(billsVo.getStartDate()!=null,"billTime",billsVo.getStartDate());
        queryWrapper.le(billsVo.getEndDate()!=null,"billTime",billsVo.getEndDate());
        queryWrapper.orderByDesc("billTime");
        this.iBillsService.page(page,queryWrapper);
        List<Bills> records = page.getRecords();

        for (Bills bills : records) {
            Billtype billtype = this.iBilltypeService.getById(bills.getId());
            bills.setTypeName(billtype.getName());
        }
        return new DataGridView(page.getTotal(),records);
    }
}

