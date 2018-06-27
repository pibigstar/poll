package com.pibigstar.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pibigstar.domain.Questionnaire;
import com.pibigstar.domain.result.MyResponse;
import com.pibigstar.service.QuestionnaireService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/questionnaire")
@Api(tags="问卷管理Controller")
public class QuestionnaireController extends BaseController{

	@Autowired
	private QuestionnaireService questionnaireService;
	
	@ApiOperation("根据id查询问卷")
	@GetMapping("get/{id}")
	public MyResponse get(@PathVariable Long id) {
		Questionnaire questionnaire = questionnaireService.get(id);
		return success(questionnaire);
	}
	
	@ApiOperation("查询全部问卷")
	@GetMapping("list")
	public MyResponse list() {
		return success(questionnaireService.findAll());
	}
	@ApiOperation("查询全部问卷")
	@GetMapping("listModel")
	public MyResponse listModel() {
		return success(questionnaireService.findAllModel());
	}
	
	@ApiOperation("添加问卷")
	@PostMapping("add")
	public MyResponse add(Questionnaire questionnaire) {
		return success(questionnaireService.add(questionnaire));
	}
	
	@ApiOperation("删除问卷")
	@DeleteMapping("delete/{id}")
	public MyResponse delete(@PathVariable Long id) {
		return success(questionnaireService.delete(id));
	}
	
	@ApiOperation("更新问卷")
	@PostMapping("update")
	public MyResponse update(Questionnaire questionnaire) {
		return success(questionnaireService.update(questionnaire));
	}
	
	
}
