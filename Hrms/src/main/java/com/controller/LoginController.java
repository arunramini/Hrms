package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.HrmsLogin;
import com.model.LoginForm;
import com.service.LoginService;

@Controller
@SessionAttributes("user")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping("/hrms")
	public ModelAndView showLoginPage(Model model, LoginForm loginForm) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginForm", loginForm);
		modelAndView.setViewName("Login");
		return modelAndView;
	}

	@RequestMapping("/LogOut")
	public ModelAndView showLogOutPage(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginForm", new LoginForm());
		modelAndView.setViewName("Login");
		return modelAndView;
	}

	@RequestMapping("/validUser")
	public ModelAndView submitForm(Model model, @Validated @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult bindingResult) {
		int id = 0;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginForm", loginForm);
		String username = null;
		String result = null;
		if (bindingResult.hasErrors()) {
			loginForm = new LoginForm();
			result = "login";
			model.addAttribute("loginForm", loginForm);
		} else {
			username = loginForm.getUsername();
			String password = loginForm.getPassword();
			boolean valid = loginService.validUser(username, password);
			
			List<HrmsLogin> list = loginService.getEmployee(username);

			for (HrmsLogin emp : list)
				id = emp.getHrmsEmployeeDetails().getEmpId();
			loginForm.setId(id);
			
			if (valid) {
				String role = loginService.checkRole(username, password);
				if (role.equalsIgnoreCase("admin")) {
					result = "admin_dashboard";
				} else if (role.equalsIgnoreCase("hr")) {
					result = "hr_dashboard";
				} else if (role.equalsIgnoreCase("employee")) {
					result = "emp_dashboard";
				}

			} else {
				loginForm = new LoginForm();
				result = "login";
			}

		}
		modelAndView.addObject("user", loginForm);
		modelAndView.setViewName(result);
		return modelAndView;
	}

}
