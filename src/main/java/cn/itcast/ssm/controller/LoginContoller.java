package cn.itcast.ssm.controller;

import cn.itcast.ssm.controller.Exception.CustomeException;
import cn.itcast.ssm.po.User;
import cn.itcast.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginContoller {

    @Autowired
    private UserService userService;

    //你是猪吗？
    //用户登录验证
    @RequestMapping("/login")
    public String login(HttpSession httpSession, User user, Model model, HttpServletRequest request) throws Exception {
        //调用service接口，验证用户信息
        List<User> number = userService.findUserByNameandpwd(user);

        //注：加number==null进不去
        //PrintWriter out=response.getWriter();
        if (number.size() == 0) {
            //throw new CustomeException("用户名或密码错误！");
            //out.print("<script language='javascript'>alert('用户名或密码错误！');window.location.href='login.jsp';</script>");
            request.setAttribute("error1", "用户名或密码错误！");

            return "login";
        }
        String username = user.getUsername();

        //向session记录用户信息
        httpSession.setAttribute("username", username);

        //重定向到商品信息页面
        return "redirect:/queryItems.action";
    }

    @RequestMapping("/valid")
    public String valid() throws Exception{
        return "registered";
    }

    @RequestMapping("/regisitered")
    public void regisitered(HttpServletRequest request, User user,HttpServletResponse response,String username,Model model) throws Exception {
            //调用service接口，验证用户信息
            List<User> number = userService.findUserByName(user);

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");

            PrintWriter out = response.getWriter();

            if (number.size() != 0) {
                out.print(true);
            } else {
                userService.insertUser(user);

                request.setAttribute("message", "注册成功，请返回登录页面~");

                request.getRequestDispatcher("WEB-INF/jsp/success.jsp").forward(request, response);
            }
        }

    //用户退出
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {

        //清除session
        httpSession.invalidate();

        //重定向到商品信息页面
        return "redirect:queryItems.action";
    }
}
