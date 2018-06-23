package com.pibigstar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pibigstar.domain.Survey;
import com.pibigstar.domain.result.MyResponse;
import com.pibigstar.service.SurveyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/survey")
@Api(tags="课调管理Controller")
public class SurveyController extends BaseController{
	
	@Autowired
	private SurveyService surveyService;
	
	@ApiOperation("根据id查询课调")
	@GetMapping("get/{id}")
	public MyResponse get(Long id) {
		return success(surveyService.get(id));
	}
	
	@ApiOperation("查询全部课调")
	@GetMapping("list")
	public MyResponse list() {
		return success(surveyService.findAll());
	}
	
	@ApiOperation("添加课调")
	@PostMapping("add")
	public MyResponse add(Survey survey) {
		return success(surveyService.add(survey));
	}
	
	@ApiOperation("更新课调")
	@PutMapping("update")
	public MyResponse update(Survey survey) {
		return success(surveyService.update(survey));
	}
	
	@ApiOperation("删除课调")
	@DeleteMapping("delete")
	public MyResponse delete(Long id) {
		return success(surveyService.delete(id));
	}

}
