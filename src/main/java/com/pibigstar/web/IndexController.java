package com.pibigstar.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;

@Controller
@Api(tags = "页面跳转Controller")
public class IndexController extends BaseController{

	@GetMapping(value = {"/index","/"})
	public String toIndex() {
		return "index";
	}
	
}
