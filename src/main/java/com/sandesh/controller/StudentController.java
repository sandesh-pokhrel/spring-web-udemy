package com.sandesh.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sandesh.model.Student;
import com.sandesh.model.StudentCS;
import com.sandesh.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) throws SQLException {
		Student student = new Student();
		student.setName("Sandesh");
		student.setGender("Male");
		student.setCountry("NP");
		
		StudentCS studentCS = new StudentCS("This is the dummy description for student's character certificate.");
		model.addAttribute("student", student);
		model.addAttribute("studentCS", studentCS);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "student-form";
		}
		studentService.addStudent(student);
		return "student-output";
	}
	
	@RequestMapping("/retrieveStudent")
	public String retrieveStudent(@RequestParam Integer roll, Model model) {
		Student student = studentService.getStudent(roll);
		model.addAttribute("student", student);
		System.out.println("Student received is: " + student);
		System.out.println("Associated student CS is: " + student.getStudentCS());
		return "student-output";
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudent(@RequestParam Integer roll, Model model) {
		Student student = studentService.getStudent(roll);
		if (student != null) {
			student.setName("Updated Name");
			studentService.updateStudent(student);
			model.addAttribute("student", student);
			return "student-output";
		} else {
			return "student_not_found";
		}
	}
	
	@RequestMapping("/retrieveStudents")
	public String retrieveStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudent());
		return "student-list";
	}
	
	@RequestMapping("/retrieveStudentsOnGender/{gender}")
	public String getMaleStudents(@PathVariable String gender, Model model) {
		model.addAttribute("students", studentService.getStudentByGender(gender));
		return "student-list";
	}
	
	@RequestMapping("/processFormStdCs")
	public String processFormStdCs(@RequestParam Integer roll, 
			@Valid @ModelAttribute StudentCS studentCS, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "student-form";
		}
		model.addAttribute("roll", roll);
		Student student = studentService.getStudent(roll);
		if (student != null) {
			studentCS.setStudent(student);
			studentService.addStudentCS(studentCS);
			return "student-cs-output";
		}
		return "student_not_found";
	}
	
}
