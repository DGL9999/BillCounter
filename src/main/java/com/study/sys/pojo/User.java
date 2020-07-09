package com.study.sys.pojo;

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
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String username;

    private String loginname;

    private String pwd;

    private String sex;


}
