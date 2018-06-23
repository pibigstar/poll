package com.pibigstar.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController extends BaseController{

	@GetMapping(value = {"/index","/"})
	public String toIndex() {
		return "index";
	}
	
}
