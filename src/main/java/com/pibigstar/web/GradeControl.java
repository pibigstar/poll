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

import com.pibigstar.domain.Grade;
import com.pibigstar.domain.result.MyResponse;
import com.pibigstar.service.GradeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/grade")
@Api(tags="年级管理Controller")
public class GradeControl extends BaseController{
	@Autowired
	private GradeService gradeService;
	

	@ApiOperation("根据id查询")
	@GetMapping("get/{id}")
	public MyResponse get(Long id) {
		Grade grade = gradeService.getOneById(id);
		return success(grade);
	}
	
	@ApiOperation("查询全部年级")
	@GetMapping("list")
	public MyResponse list() {
		List<Grade> grades = gradeService.list();
		return success(grades);
	}
	
	@ApiOperation("添加年级")
	@PostMapping("add")
	public MyResponse add(Grade grade) {
		int result = gradeService.add(grade);
		return success("添加成功！",result);
	}
	
	@ApiOperation("删除年级")
	@DeleteMapping("delete/{id}")
	public MyResponse delete(@PathVariable Long id) {
		int result = gradeService.delete(id);
		return success("删除成功！",result);
	}
	
	@ApiOperation("更新年级")
	@PutMapping("update")
	public MyResponse update(Grade grade) {
		int result = gradeService.update(grade);
		return success("更新成功！",result);
	}
	
}
