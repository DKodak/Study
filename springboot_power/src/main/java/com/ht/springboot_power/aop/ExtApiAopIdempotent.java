package com.ht.springboot_power.aop;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-06-03 -20:32
 * @Email:2270301642@qq.com
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.springboot_power.common.ExtApiIdempotent;
import com.ht.springboot_power.utils.ConstantUtils;
import com.ht.springboot_power.utils.RedisTokenUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



@Aspect
@Component
public class ExtApiAopIdempotent {
    @Autowired
    private RedisTokenUtils redisTokenUtils;

    //需要作用的类
    @Pointcut("execution(public * com.ht.springboot_power.controller.*.*(..))")
    public void rlAop() {
    }

    // 前置通知转发Token参数  进行拦截的逻辑
    @Before("rlAop()")
    public void before(JoinPoint point) {
        //获取并判断类上是否有注解
        MethodSignature signature = (MethodSignature) point.getSignature();//统一的返回值
        ExtApiIdempotent extApiToken = signature.getMethod().getDeclaredAnnotation(ExtApiIdempotent.class);//参数是注解的那个
        if (extApiToken != null) { //如果有注解的情况
            extApiToken();
        }
    }

    // 环绕通知验证参数
    @Around("rlAop()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        ExtApiIdempotent extApiIdempotent = signature.getMethod().getDeclaredAnnotation(ExtApiIdempotent.class);
        if (extApiIdempotent != null) { //有注解的情况 有注解的说明需要进行token校验
            return extApiIdempotent(proceedingJoinPoint, signature);
        }
        // 放行
        Object proceed = proceedingJoinPoint.proceed(); //放行 正常执行后面（Controller）的业务逻辑
        return proceed;
    }

    // 验证Token  方法的封装
    public Object extApiIdempotent(ProceedingJoinPoint proceedingJoinPoint, MethodSignature signature)
            throws Throwable {
        ExtApiIdempotent extApiIdempotent = signature.getMethod().getDeclaredAnnotation(ExtApiIdempotent.class);
        if (extApiIdempotent == null) {
            // 直接执行程序
            Object proceed = proceedingJoinPoint.proceed();
            return proceed;
        }
        // 代码步骤：
        // 1.获取令牌 存放在请求头中
        HttpServletRequest request = getRequest();
        // value就是获取类型 请求头之类的
        String valueType = extApiIdempotent.value();
        if (StringUtils.isEmpty(valueType)) {
            response("参数错误!");
            return null;
        }
        String token = null;
        if (valueType.equals(ConstantUtils.EXTAPIHEAD)) { //如果存在header中 从头中获取
            token = request.getHeader("token"); //从头中获取
        } else {
            token = request.getParameter("token"); //否则从 请求参数获取
        }
        if (StringUtils.isEmpty(token)) {
            response("参数错误!");
            return null;
        }
        if (!redisTokenUtils.findToken(token)) {
            response("请勿重复提交!");
            return null;
        }
        Object proceed = proceedingJoinPoint.proceed();
        return proceed;
    }

    public void extApiToken() {
        String token = redisTokenUtils.getToken();
        getRequest().setAttribute("token", token);

    }

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }

    public void response(String msg) throws IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            writer.println(msg);
        } catch (Exception e) {

        } finally {
            writer.close();
        }

    }

}
