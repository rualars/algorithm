package com.me.algorithm.web.aspect;

import com.me.algorithm.web.dto.TestResponseDTO;
import com.me.algorithm.web.entity.User;
import com.me.algorithm.web.repository.UserRepository;
import com.me.algorithm.web.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class CheckUser {

    @Autowired
    private UserRepository userRepository;

    @Pointcut(value = "@annotation(com.me.algorithm.web.annotation.Check)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object checkUser(ProceedingJoinPoint joinPoint) throws Throwable {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String uidStr = request.getHeader("uid");

        if (uidStr == null || uidStr.isEmpty()) {
            return new TestResponseDTO(0, "请使用用户UID访问", null);
        }
        try {
            int uid = Integer.parseInt(uidStr);
            User user = userRepository.getByUid(uid);
            if (user == null) {
                return new TestResponseDTO(0, "用户信息不存在", null);
            }
            return joinPoint.proceed();
        } catch (Exception e) {
            return new TestResponseDTO(0, "用户UID错误", null);
        }
    }
}
