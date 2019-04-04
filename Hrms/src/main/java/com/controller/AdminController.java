package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.HrmsEmployeeDetails;
import com.model.HrmsEmployeeLeaves;
import com.service.AdminService;
import com.service.DepartmentService;
import com.service.HrmsEmployeLeaveService;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HrmsEmployeLeaveService hrmsEmployeLeaveService;
	
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/viewAllEmployees")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<HrmsEmployeeDetails> listEmployee = this.adminService.listEmployees();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("listEmployees");
		return model;
	}

	@RequestMapping("/RegisterEmployee")
	public ModelAndView loadEmployeeRegisterPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employee", new HrmsEmployeeDetails());
		modelAndView.setViewName("registrationForm");
		return modelAndView;
	}

	@RequestMapping("/saveEmployee")
	public String saveEmployee(@Valid @ModelAttribute("employee") HrmsEmployeeDetails hrmsEmployeeDetails,
			BindingResult result, Model model, HttpServletRequest request) throws IOException {

		this.adminService.addEmployee(hrmsEmployeeDetails);
		return "admin_dashboard";
	}

	@RequestMapping("/editEmployee/{id}")
	public ModelAndView editEmployee(@PathVariable("id") int id) {

		HrmsEmployeeDetails customerRegistration = adminService.getEmployee(id);
		ModelAndView model = new ModelAndView("registrationForm");
		model.addObject("departments",departmentService.getDepartments());
		model.addObject("employee", customerRegistration);
		model.setViewName("registrationForm");
		return model;
	}

	@RequestMapping("/removeEmployee/{id}")
	public String removeEmployee(@PathVariable("id") int id) {

		this.adminService.removeEmployee(id);
		return "redirect:/Admin/viewAllEmployees";
	}
	
	@RequestMapping("/leaveHistoryRequest")
	public ModelAndView leaveHistoryRequest()
	{
		ModelAndView model= new ModelAndView();
		List<HrmsEmployeeLeaves> list=hrmsEmployeLeaveService.getLeavesList();
		
		model.addObject("leaves", hrmsEmployeLeaveService.getLeavesList());
		model.setViewName("LeavesList");
		return model;
	}
	
}
