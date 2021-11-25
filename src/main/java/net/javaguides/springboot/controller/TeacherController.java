package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.entity.Teacher;
import net.javaguides.springboot.service.TeacherService;

@Controller
public class TeacherController {
	private TeacherService teacherService;

	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}
	
	//handler method to handle list students and return mode and view
	@GetMapping("/teachers")
	public String listTeachers(Model model){
		model.addAttribute("teachers", teacherService.getAllTeachers());
		return "teachers";
	}
	
	@GetMapping("/teachers/new")
	public String createTeacherForm(Model model){
		
		//create student object to hold student from data
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "create_teacher";
	}
	
	@PostMapping("/teachers")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){
		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/edit/{id}")
	public String editTeacherForm(@PathVariable Long id, Model model){
		model.addAttribute("teacher", teacherService.getTeacherById(id));
		return "edit_teacher";
	}
	
	@PostMapping("/teachers/{id}")
	public String updateTeacher(@PathVariable Long id,
			@ModelAttribute("teachers")Teacher teacher,
			Model model){
		
		//get students from database by id
		Teacher existingTeacher = teacherService.getTeacherById(id);
		existingTeacher.setId(id);
		existingTeacher.setFirstName(teacher.getFirstName());
		existingTeacher.setLastName(teacher.getLastName());
		existingTeacher.setEmail(teacher.getEmail());
		existingTeacher.setDepartment(teacher.getDepartment());
		existingTeacher.setAddress(teacher.getAddress());
		existingTeacher.setNumber(teacher.getNumber());

		
		//save updated teacher object
		teacherService.updateTeacher(existingTeacher);
		return "redirect:/teachers";
	}
	
	//handler method to handle delete student request
	@GetMapping("/teachers/{id}")
	public String deleteTeacher(@PathVariable Long id){
		teacherService.deleteTeacherById(id);
		return "redirect:/teachers";
		
	}

}
