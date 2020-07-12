package com.study.sys.service.impl;

import com.study.sys.pojo.Billtype;
import com.study.sys.mapper.BilltypeMapper;
import com.study.sys.service.IBilltypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Deja wu
 * @since 2020-07-09
 */
@Service
public class BilltypeServiceImpl extends ServiceImpl<BilltypeMapper, Billtype> implements IBilltypeService {

    @Override
    public Billtype getById(Serializable id) {
        return super.getById(id);
    }
}
