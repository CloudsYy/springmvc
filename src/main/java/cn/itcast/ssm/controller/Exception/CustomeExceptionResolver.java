package cn.itcast.ssm.controller.Exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomeExceptionResolver  implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //解析异常类型
        CustomeException customeException=null;
        //如果是系统自定义异常，直接取出异常信息，在错误页面展示
        if (e instanceof CustomeException){
            customeException = (CustomeException)e;
        }else {
            customeException = new CustomeException("未知错误");
        }

        String message=customeException.getMessage();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("message",message);

        modelAndView.setViewName("error");

        return modelAndView;
    }
}
