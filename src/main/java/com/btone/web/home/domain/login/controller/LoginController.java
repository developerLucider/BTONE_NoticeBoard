package com.btone.web.home.domain.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
		
	@GetMapping("/find/{type}")
	public String ShowFirst(@PathVariable("type")String type, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.debug("------------------- homecotroller 진입");
		logger.debug("type tostring = {}", type.toString());
		
		if(type.toString().equals("id")) {
			model.addAttribute("type", "id");				
		} else if (type.equals("pw")) {
			model.addAttribute("type", "pw");
		} else {
			model.addAttribute("type", "none");
		}
		
		
		return "findAccount";
	}	
}
