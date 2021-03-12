package servlet;

import dao.UserDAO;
import entity.User;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("name:" + username);
        System.out.println("password:" + password);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置utf-8，防止出现乱码情况
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取注册的用户名
        String username = request.getParameter("username");
        //获取注册的密码
        String password = request.getParameter("password");
        System.out.println("name:" + username);
        System.out.println("password:" + password);


        UserDAO userDao = new UserDAO();

        List<User> userList = userDao.login(username,password);
        System.out.println(userList);
        if (userList.size()!=0){
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
//            resp.getWriter().write("success!");
            response.getWriter().write(String.valueOf(userList));
        }
        else{
            response.getWriter().write("登录失败!");
        }


//        if (username.equals("123") && password.equals("123")) {
//            System.out.println("登录成功，欢迎你：" + username);
//        }
    }

    public void destroy() {
    }
}