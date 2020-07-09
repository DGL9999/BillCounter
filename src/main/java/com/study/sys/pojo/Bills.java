package com.study.sys.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Deja wu
 * @since 2020-07-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Bills implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private LocalDateTime billtime;

    private Integer typeid;

    private Double price;

    private String remark;


}
