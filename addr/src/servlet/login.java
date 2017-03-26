package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import entity.User;

//@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao dao=new UserDao();
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		User user=new User();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		user.setUsername(username);
		user.setPassword(password);
//		System.out.println("usrname:"+username);
		PrintWriter out = response.getWriter();
		String path="";
		String filename;
		filename=getServletContext().getRealPath("WEB-INF")+"\\login.txt";
		//System.out.println(filename);
		dao.setFilename(filename);
		
		if(username==null || username.equals("")){
			out.println("please input username");
			out.close();
			return;
		}
		if (dao.login(user)) {
			path="AddressServlet?method=list";
			request.getSession().setAttribute("username", user.getUsername());
		}else {
			path="login.html";
		}
		//System.out.println(dao.login(user));
//		List<String> list=Arrays.asList(new String[]{"java","C#","C++"});
//		request.setAttribute("list", list);
		request.setAttribute("name", username);
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		//out.println("num is ="+(inum%2==0?"even":"odd"));
		//out.println("IP Address:"+request.getRemoteAddr()+"Date is:"+new Date());
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
