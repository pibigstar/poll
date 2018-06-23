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

import com.pibigstar.domain.School;
import com.pibigstar.domain.result.MyResponse;
import com.pibigstar.service.SchoolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping("/school")
@Api(tags="school-controller")
public class SchoolController extends BaseController{
	@Autowired
	private SchoolService schoolService;
	
	@ApiOperation("模糊查询")
	@GetMapping("findlike/{name}")
	public MyResponse findLike(@PathVariable String name) {
		try {
			List<School> schools = schoolService.findAllLikeName(name);
			return success(schools);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
		
	}
	@ApiOperation("查询全部")
	@GetMapping("list")
	public MyResponse list() {
		try {
			List<School> schools = schoolService.findAll();
			return success(schools);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation("根据id删除")
	@ApiImplicitParam(name="id",value="用户id",required=true,dataType="Long")
	@DeleteMapping("delete/{id}")
	public MyResponse delete(@PathVariable Long id) {
		try {
			int result = schoolService.delete(id);
			return success("删除成功！",result);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return error(e.getMessage());
		}
	}
	
	@ApiOperation("更新")
	@PutMapping("update")
	public MyResponse update(School school) {
		int result = schoolService.update(school);
		return success("更新成功！",result);
	}
	
	@ApiOperation("新增")
	@PostMapping("add")
	public MyResponse add(School school) {
		int result = schoolService.add(school);
		return success("添加成功！",result);
	}

}
