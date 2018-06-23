package com.pibigstar.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pibigstar.domain.Answers;
import com.pibigstar.domain.AnswersWithBLOBs;
import com.pibigstar.domain.result.MyResponse;
import com.pibigstar.service.AnswersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/answers")
@Api(tags="答卷管理Controller")
public class AnswersController extends BaseController{
	@Autowired
	private AnswersService answersService;
	
	@ApiOperation("根据id查询回答")
	@GetMapping("get/{id}")
	public MyResponse get(@PathVariable Long id) {
		Answers answers = answersService.get(id);
		return success(answers);
	}
	
	
	@ApiOperation("查询全部")
	@GetMapping("list")
	public MyResponse list() {
		List<Answers> answeres = answersService.findAll();
		return success(answeres);
	}
	
	@ApiOperation("添加回答")
	@PostMapping("add")
	public MyResponse add(AnswersWithBLOBs answers) {
		int result = answersService.add(answers);
		return success("添加成功！",result);
	}
	
	@ApiOperation("更新回答")
	@PutMapping("update")
	public MyResponse update(AnswersWithBLOBs answers) {
		int result = answersService.update(answers);
		return success("更新成功！",result);
	}
	
	@ApiOperation("删除回答")
	@DeleteMapping("delete/{id}")
	public MyResponse delete(@PathVariable Long id) {
		int result = answersService.delete(id);
		return success(result);
	}
	
}
