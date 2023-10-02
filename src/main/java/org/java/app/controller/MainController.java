package org.java.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@GetMapping("/")
	@ResponseBody
	public String home (Model model) {
		final String  name = "Lorenzo";
		model.addAttribute("name",name);
		return "Home";
	}
}
