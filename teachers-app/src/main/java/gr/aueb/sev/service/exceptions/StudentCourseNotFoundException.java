package gr.aueb.sev.service.exceptions;

import gr.aueb.sev.model.StudentCourse;

public class StudentCourseNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public StudentCourseNotFoundException(StudentCourse studentcourse) 
	{
		super("StudentCourse with studentId = " + studentcourse.getStudentId() 
		+" and courseId =  "+ studentcourse.getCourseId() +" was not found");
	}
}
