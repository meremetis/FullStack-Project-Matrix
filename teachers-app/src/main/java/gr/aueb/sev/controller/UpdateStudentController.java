package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.IStudentDAO;
import gr.aueb.sev.dao.StudentDAOImple;
import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.service.IStudentService;
import gr.aueb.sev.service.StudentServiceImple;


@WebServlet("/update-student")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentDAO studentDAO = new StudentDAOImple();
	IStudentService studentServ = new StudentServiceImple(studentDAO);
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		
		
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(id);
		studentDTO.setFirstname(firstname);
		studentDTO.setLastname(lastname);
		
		
		request.setAttribute("student", studentDTO);
		request.getRequestDispatcher("/jsps/studentupdate.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		
		StudentDTO oldStudentDTO = new StudentDTO();
		oldStudentDTO.setId(id);
		
		
		StudentDTO newStudentDTO = new StudentDTO();
		newStudentDTO.setFirstname(firstname);
		newStudentDTO.setLastname(lastname);
		
		
		try 
		{	
			
			studentServ.updateStudent(oldStudentDTO,newStudentDTO);
			
			
			request.setAttribute("student", newStudentDTO);
			
			request.getRequestDispatcher("/jsps/studentupdated.jsp")
			.forward(request, response);
		}
		catch(SQLException e)
		{		
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/menu.jsp")
			.forward(request, response);
		}
	}

}
