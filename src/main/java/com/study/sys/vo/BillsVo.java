package com.study.sys.vo;

import com.study.sys.pojo.Bills;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
public class BillsVo extends Bills {

    private Date startDate;
    private Date endDate;

    private Integer page=1;
    private Integer limit=10;
}
