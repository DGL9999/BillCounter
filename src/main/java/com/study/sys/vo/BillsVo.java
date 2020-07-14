package com.study.sys.vo;

import com.study.sys.pojo.Bills;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
public class BillsVo extends Bills {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Integer page=1;
    private Integer limit=10;
}
