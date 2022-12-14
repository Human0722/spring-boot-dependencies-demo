package io.github.human0722.demo.interceptor;

import io.github.human0722.demo.annotation.Auth;
import io.github.human0722.demo.annotation.Logical;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xueliang
 * @date 2022-12-12 17:04
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    private static Logger log =  LoggerFactory.getLogger(LogInterceptor.class);


    /**
     * 执行控制器方法前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        String token = request.getHeader("token");
        log.info("Token from LogInterceptor:" + request.getHeader("token"));
        String[] split = token.split(",");
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Boolean clazzHasPermission = true;
            Auth clazzAuth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
            if (clazzAuth != null) {
                String[] clazzPermissions = clazzAuth.permissions();
                List<String> requiredPermissions = new ArrayList<>(Arrays.asList(clazzPermissions));
                String clazzLogical = clazzAuth.logical();
                log.info("Clazz require permission: {}, Mode: {}, Has permissions: {}", requiredPermissions, clazzLogical, split);
                for (String permission: split) {
                    requiredPermissions.remove(permission);
                }
                clazzHasPermission = (Logical.OR.equals(clazzLogical) && requiredPermissions.size() < split.length) || (Logical.AND.equals(clazzLogical) && requiredPermissions.size() == 0);
            }

            Boolean methodHasPermission = true;
            if (clazzHasPermission) {
                Auth methodAuth = handlerMethod.getMethod().getAnnotation(Auth.class);
                if (methodAuth != null) {
                    String[] methodPermissions = methodAuth.permissions();
                    String methodLogical = methodAuth.logical();
                    List<String> requiredPermissions = new ArrayList<>(Arrays.asList(methodPermissions));
                    log.info("Method require permissions: {}, Mode: {}, Has permissions: {}", requiredPermissions, methodLogical, split);
                    for (String  permission : split) {
                        requiredPermissions.remove(permission);
                    }
                    methodHasPermission = (Logical.OR.equals(methodLogical) && requiredPermissions.size() < split.length) || (Logical.AND.equals(methodLogical) && requiredPermissions.size() == 0);
                }

            }

            flag = clazzHasPermission && methodHasPermission;
        }
        if (!flag) {
            response.reset();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return flag;
    }

    /**
     * 执行完控制器方法，但在渲染ModelAndView前执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 控制器方法执行完执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
