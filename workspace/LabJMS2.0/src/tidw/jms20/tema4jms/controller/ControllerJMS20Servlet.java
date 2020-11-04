package tidw.jms20.tema4jms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tidw.jms20.tema4jms.comunication.JmsComunication;

/**
 * Servlet implementation class ControllerJMS20Servlet
 */
@WebServlet("/proxyjms20")
public class ControllerJMS20Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerJMS20Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		System.out.println("antes");
		JmsComunication _sender=new JmsComunication();
	System.out.println(_sender.toString());
	System.out.println("despues");
	_sender.sendMessageJMS20(request.getParameter("mensaje"));
	
	request.getRequestDispatcher("index.html").forward(request, response);
	
	}

}
