package servlet;

import java.io.IOException;
import jdbc.DBUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();//获取session  
//        Object name = session.getAttribute("username");//从session中获取用户名  
//        Object pwd = session.getAttribute("password");//从session获取用户密码  
//        System.out.println(name+":"+pwd); //测试一下，输出获取的用户名和密码  
//        session.invalidate(); //注销session  
//        response.sendRedirect("login.html"); //跳转到login.html页面
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码为utf-8  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        
        String username = request.getParameter("username");//取得用户名
        String password = request.getParameter("password");//取得密码
        System.out.println(username+":"+password); //测试一下，输出获取的用户名和密码
        DBUtil db = new DBUtil();//构建数据库对象
        boolean canLogin =  db.loginSuccess(username, password);
        if(canLogin){//根据登陆情况，跳转页面
        response.sendRedirect("success.html");
        }else{
        response.sendRedirect("login.html");
        }
  
//        // 获取用户名和密码  
//        String name = request.getParameter("username");  
//        String pwd = request.getParameter("password");  
//        System.out.println(name+":"+pwd); //测试一下，输出获取的用户名和密码
//        // 校验用户名和密码是否正确  
//        if ("admin".equals(name) && "123".equals(pwd)) {// 验证成功  
//            HttpSession session = request.getSession();//获取session  
//            session.setAttribute("username", name);// 将用户名和密码保存在session中  
//            session.setAttribute("password", pwd);// 将用户名和密码保存在session中  
////            System.out.println(name+":"+pwd); //测试一下，输出获取的用户名和密码  
//            response.sendRedirect("success.html");// 跳转到success.jsp页面  
//        } else {// 校验不成功，则留在跳转到login.jsp页面  
//            response.sendRedirect("login.html");  
//        }  
	}
	}
