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
//		HttpSession session = request.getSession();//��ȡsession  
//        Object name = session.getAttribute("username");//��session�л�ȡ�û���  
//        Object pwd = session.getAttribute("password");//��session��ȡ�û�����  
//        System.out.println(name+":"+pwd); //����һ�£������ȡ���û���������  
//        session.invalidate(); //ע��session  
//        response.sendRedirect("login.html"); //��ת��login.htmlҳ��
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���Ϊutf-8  
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        
        String username = request.getParameter("username");//ȡ���û���
        String password = request.getParameter("password");//ȡ������
        System.out.println(username+":"+password); //����һ�£������ȡ���û���������
        DBUtil db = new DBUtil();//�������ݿ����
        boolean canLogin =  db.loginSuccess(username, password);
        if(canLogin){//���ݵ�½�������תҳ��
        response.sendRedirect("success.html");
        }else{
        response.sendRedirect("login.html");
        }
  
//        // ��ȡ�û���������  
//        String name = request.getParameter("username");  
//        String pwd = request.getParameter("password");  
//        System.out.println(name+":"+pwd); //����һ�£������ȡ���û���������
//        // У���û����������Ƿ���ȷ  
//        if ("admin".equals(name) && "123".equals(pwd)) {// ��֤�ɹ�  
//            HttpSession session = request.getSession();//��ȡsession  
//            session.setAttribute("username", name);// ���û��������뱣����session��  
//            session.setAttribute("password", pwd);// ���û��������뱣����session��  
////            System.out.println(name+":"+pwd); //����һ�£������ȡ���û���������  
//            response.sendRedirect("success.html");// ��ת��success.jspҳ��  
//        } else {// У�鲻�ɹ�����������ת��login.jspҳ��  
//            response.sendRedirect("login.html");  
//        }  
	}
	}
