package cn.itcast.ssm.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor{
    //进入 Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取请求的url
        String url = httpServletRequest.getRequestURI();

        //判断url是否是公开的地址
        //如果是公开就放行
        if (url.indexOf("login.action")>=0){
            return true;
        }else if (url.indexOf("valid.action")>=0){
            return true;
        }

        //开启一个session
        HttpSession session = httpServletRequest.getSession();

        //从session取出用户信息
        String username = (String) session.getAttribute("username");

        //判断从session取出的username是否存在
        if (username!=null){
            return true;
        }

        httpServletRequest.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(httpServletRequest,httpServletResponse);

        //true表示放行，false表示拦截，不执行下一步..
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
