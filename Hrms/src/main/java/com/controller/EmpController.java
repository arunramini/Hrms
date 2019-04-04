package com.controller;

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
import com.model.HrmsLogin;
import com.service.EmpService;
import com.service.HrmsEmployeLeaveService;
import com.service.LeavesService;

@Controller
@RequestMapping("/Emp")
public class EmpController {

	@Autowired
	private EmpService empService;

	@Autowired
	private LeavesService leavesService;
	
	@Autowired
	private HrmsEmployeLeaveService HrmsEmployeLeaveService;
	
	@RequestMapping("/viewProfile/{id}")
	public ModelAndView viewProfile(@PathVariable("id") int id) {

		List<HrmsEmployeeDetails> list = empService.getEmployeeDetail(id);
		ModelAndView model = new ModelAndView();
		model.addObject("viewProfile", list);
		model.setViewName("profile");
		return model;
	}

	@RequestMapping("/UpdatePassword")
	public ModelAndView changePassword() {

		ModelAndView model = new ModelAndView();
		model.addObject("changePassword", new HrmsLogin());
		model.setViewName("changePassword");
		return model;
	}

	@RequestMapping("/change")
	public String change(@Valid @ModelAttribute("employee") HrmsLogin hrmsLogin, BindingResult result,
			Model model, HttpServletRequest request) {
	
		ModelAndView modelAndView= new ModelAndView();
		this.empService.updateEmployeePassword(hrmsLogin);
		modelAndView.setViewName("changePassword");
		return "redirect:/LogOut";
	}
	
	@RequestMapping("/LeaveRequest")
	public ModelAndView LeaveRequest(ModelAndView model)
	{
		//List<Leaves> leaves=leavesService.getLeaves();
		model.addObject("employeeLeave", new HrmsEmployeeLeaves());
		model.addObject("LeavesList",this.leavesService.getLeaves());
		model.setViewName("leaverequest");
		return model;
	}
	
	
	@RequestMapping("/sendLeaveRequest")
	public ModelAndView sendLeaveRequest(@Valid @ModelAttribute("employeeLeave") HrmsEmployeeLeaves hrmsEmployeeLeaves, BindingResult result,
			Model model1, HttpServletRequest request)
	{
		ModelAndView model =new ModelAndView();
		System.out.println("employeeLeave"+hrmsEmployeeLeaves.getHrmsEmployeeDetails().getEmpId());
		HrmsEmployeLeaveService.save(hrmsEmployeeLeaves);
		model.setViewName("leaverequest");
		model.addObject("Success","Request Sent Successfully");
		return model;
	}
}
