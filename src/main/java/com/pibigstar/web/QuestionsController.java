package com.pibigstar.web;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pibigstar.domain.Questions;
import com.pibigstar.domain.extend.QuestionModel;
import com.pibigstar.domain.result.MyResponse;
import com.pibigstar.service.QuestionsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/question")
@Api(tags="问题管理Controller")
public class QuestionsController extends BaseController{

	@Autowired
	private QuestionsService questionsService;
	
	@ApiOperation("根据id查询问题")
	@GetMapping("get/{id}")
	public MyResponse get(@PathVariable Long id) {
		Questions questions = questionsService.get(id);
		return success(questions);
	}
	
	@ApiOperation("查询全部问题")
	@GetMapping("list")
	public MyResponse list() {
		List<QuestionModel> questions = questionsService.findAll();
		return success(questions);
	}
	
	@ApiOperation("添加问题")
	@PostMapping("add")
	public MyResponse add(Questions question) {
		int result = questionsService.add(question);
		return success(result);
	}

	@ApiOperation("更新问题")
	@PutMapping("update")
	public MyResponse Update(Questions question) {
		int result = questionsService.update(question);
		return success(result);
	}
	
	@ApiOperation("删除问题")
	@DeleteMapping("delete/{id}")
	public MyResponse delete(@PathVariable Long id) {
		int result = questionsService.delete(id);
		return success("删除成功！",result);
	}
	
	
	
}
