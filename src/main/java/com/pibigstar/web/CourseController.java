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

import com.pibigstar.domain.Course;
import com.pibigstar.domain.result.MyResponse;
import com.pibigstar.service.CourseService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController{

	@Autowired
	private CourseService courseService;
	
	@ApiOperation("根据id查询课程")
	@GetMapping("get/{id}")
	public MyResponse get(@PathVariable Long id) {
		Course course = courseService.getOneById(id);
		return success(course);
	}
	
	@ApiOperation("查询全部课程")
	@GetMapping("list")
	public MyResponse list() {
		List<Course> courses = courseService.findAll();
		return success(courses);
	}
	
	@ApiOperation("添加课程")
	@PostMapping("add")
	public MyResponse add(Course course) {
		int result = courseService.add(course);
		return success("添加成功！",result);
	}
	
	@ApiOperation("更新课程")
	@PutMapping("update")
	public MyResponse update(Course course) {
		int result = courseService.update(course);
		return success("更新成功！",result);
	}
	
	@ApiOperation("删除课程")
	@DeleteMapping("delete")
	public MyResponse delete(Long id) {
		int result = courseService.delete(id);
		return success("删除成功！",result);
	}
}
