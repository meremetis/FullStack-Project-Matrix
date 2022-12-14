package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.CourseDAOImple;
import gr.aueb.sev.dao.ICourseDAO;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.service.CourseServiceImple;
import gr.aueb.sev.service.ICourseService;


@WebServlet("/update-course")
public class UpdateCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ICourseDAO courseDAO = new CourseDAOImple();
	ICourseService courseServ = new CourseServiceImple(courseDAO);
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		response.setContentType("text/html, charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String description = request.getParameter("description").trim();
		int teacherId =  Integer.parseInt(request.getParameter("teacherId").trim());
		
		
		CourseDTO courseDTO= new CourseDTO();
		courseDTO.setId(id);
		courseDTO.setDescription(description);
		courseDTO.setTeacherId(teacherId);
		
		
		request.setAttribute("course", courseDTO);
		request.getRequestDispatcher("/jsps/courseupdate.jsp")
		.forward(request, response);
	}

	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		
		response.setContentType("text/html, charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String description = request.getParameter("description").trim();
		int teacherId =  Integer.parseInt(request.getParameter("teacherId").trim());
		
		
		CourseDTO oldCourseDTO= new CourseDTO();
		oldCourseDTO.setId(id);
		
		
		CourseDTO newCourseDTO= new CourseDTO();
		newCourseDTO.setDescription(description);
		newCourseDTO.setTeacherId(teacherId);
		
		try 
		{	
			
			courseServ.updateCourse(oldCourseDTO,newCourseDTO);
			
			
			request.setAttribute("course", newCourseDTO);
			
			request.getRequestDispatcher("/jsps/courseupdated.jsp")
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
