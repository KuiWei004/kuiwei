package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDao;
import entity.Address;

/**
 * Servlet implementation class AddressServlet
 */
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private AddressDao addressDao=new AddressDao();
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=request.getParameter("method");
		String path="list.jsp";
		boolean redirect=false;
		if(method.equals("list")){
			PrintWriter out=response.getWriter();
			List<Address> list=addressDao.findAll();
			if(list==null){out.println("error");}
			request.setAttribute("list", list);
		}else if (method.equals("add")) {
			Address address=new Address();
			String name=request.getParameter("name");
			String street=request.getParameter("street");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String zip=request.getParameter("zip");
			address.setName(name);
			address.setCity(city);
			address.setStreet(street);
			address.setState(state);
			address.setZip(zip);
			addressDao.add(address);
			path="AddressServlet?method=list";
			redirect=true;
		}else if (method.equals("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			addressDao.delete(id);
			path="AddressServlet?method=list";
			redirect=true;
		}else if(method.equals("toedit")){
			int id=Integer.parseInt(request.getParameter("id"));
			Address address=addressDao.findById(id);
			path="edit.jsp";
			request.setAttribute("address", address);
			redirect=true;
		}else if(method.equals("edit")){
			Address address=new Address();
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String street=request.getParameter("street");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String zip=request.getParameter("zip");
			address.setId(id);
			address.setName(name);
			address.setCity(city);
			address.setStreet(street);
			address.setState(state);
			address.setZip(zip);
			addressDao.update(address);
			path="AddressServlet?method=list";
			redirect=true;
		}
		if(redirect){
			response.sendRedirect(path);
			redirect=false;
		}else {
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
