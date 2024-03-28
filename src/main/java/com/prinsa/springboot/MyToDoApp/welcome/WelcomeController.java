package com.prinsa.springboot.MyToDoApp.welcome;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {


	// http://localhost:8080/login
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLopggedinUserName());
		return "welcome";
	}
  private String getLopggedinUserName() {
	  
	Authentication authentication=  SecurityContextHolder.getContext().getAuthentication();
	authentication.getName();
	return authentication.getName();
  }
}
