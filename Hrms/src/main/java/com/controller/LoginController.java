package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.LoginForm;
import com.service.LoginService;

@Controller

public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private Validator loginValidator;

	@RequestMapping("/hrms")
	public ModelAndView showLoginPage(Model model, LoginForm loginForm) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginForm", loginForm);
		modelAndView.setViewName("Login");
		return modelAndView;
	}

	@RequestMapping("/validUser")
	public ModelAndView submitForm(Model model, @Validated @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginForm", loginForm);

		String result=null;
		if (bindingResult.hasErrors()) {
			loginForm = new LoginForm();
			result = "login";
			model.addAttribute("loginForm", loginForm);
		} else {
			String username = loginForm.getUsername();
			String password = loginForm.getPassword();
			boolean valid = loginService.validUser(username, password);
			System.out.println(valid);

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
		modelAndView.setViewName(result);
		return modelAndView;
	}

	@InitBinder("loginForm")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(loginValidator);
	}

}
