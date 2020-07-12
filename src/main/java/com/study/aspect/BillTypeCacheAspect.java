package com.study.aspect;

import com.study.sys.pojo.Billtype;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@EnableAspectJAutoProxy
public class BillTypeCacheAspect {

    /**
     * 缓存的对象
     */
    private Map<String,Object> cache = new HashMap<>();

    /**
     * 缓存的前缀
     */
    private static final String BILL_TYPE_CACHE_PREFIX="billType:";

    @Pointcut("execution(* com.study.sys.service.impl.BilltypeServiceImpl.getById(..))")
    public void pc(){

    }

    @Around(value = "pc()")
    public Object cacheBillType(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();  //得到目标方法的参数
        //取出id
        Integer typeID = (Integer) args[0];
        //使用id从缓存中取对象
        Object obj = cache.get(BILL_TYPE_CACHE_PREFIX + typeID);
        if (obj!=null){   //缓存中有数据
            System.out.println("缓存中有数据");
            return obj;
        }else {
            System.err.println("缓存中没有数据执行SQL查询");
            //说明缓存中没有， 放行执行目标方法查询数据
            Billtype result = (Billtype) point.proceed();
            //将数据放入缓存
            cache.put(BILL_TYPE_CACHE_PREFIX+result.getId(),result);
            return result;
        }
    }
}
