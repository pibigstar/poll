package com.pibigstar.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pibigstar.dao.SchoolMapper;
import com.pibigstar.domain.School;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.pibigstar.dao")
public class SchoolDaoTest {

	@Autowired
	private SchoolMapper schoolMapper;
	
	@Test
	public void testFindAll() {
		List<School> schools = schoolMapper.findAll();
		for (School school : schools) {
			System.out.println(school);
		}	
	}
	
	@Test
	public void testFindAllLikeName() {
		List<School> schools = schoolMapper.findAllLikeName("%郑州%");
		System.out.println(schools.size());
		for (School school : schools) {
			System.out.println(school);
		}
	}
	
	@Test
	public void testSelectOne() {
		School school = schoolMapper.selectByPrimaryKey(1L);
		System.out.println(school);
	}
	
}
