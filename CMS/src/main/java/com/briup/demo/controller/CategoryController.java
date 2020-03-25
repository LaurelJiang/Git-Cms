package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 栏目相关的Controller
 * 
 * @author JT
 *
 */
@RestController
@Api(description = "栏目相关接口")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	/**
	 * 查询所有的栏目信息
	 */
	@PostMapping("/getAllCategory")
	@ApiOperation("获取所有的栏目信息")
	public Message<List<Category>> findAllCategory() {
		return MessageUtil.success(categoryService.findAllCategorys());
	}
	
	/**
	 * 新增栏目信息
	 * @return
	 */
	@PostMapping("/saveCategory")
	@ApiOperation("新增栏目信息")
	public Message<List<Category>> saveCategory(Category category) {
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (Exception e) {
			return MessageUtil.error(StatusCodeUtil.ERROE_CODE, "系统错误");
		}
	}
	/**
	 * 新增栏目信息
	 */
	@PostMapping("/updateCategory")
	@ApiOperation("修改栏目信息")
	public Message<String> updateCategory(Category category) {
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (Exception e) {
			return MessageUtil.error(StatusCodeUtil.ERROE_CODE, "系统错误");
		}

	}
	
	/**
	 * 根据id删除栏目信息
	 */
	@GetMapping("/deleteCategoryById")
	@ApiOperation("根据id删除栏目信息")
	public Message<List<Category>>  deleteCategory(int id) {
		categoryService.deleteCategoryById(id);
		return MessageUtil.success();
	}

	/**
	 * 根据id查找栏目信息
	 */
	@GetMapping("/findCategoryById")
	@ApiOperation("根据id查找栏目信息")
	public Message<Category>  findCategory(int id) {
		return MessageUtil.success(categoryService.findCategoryById(id));
	}
	
	/**
	 * 查询栏目及其包含的文章所有数据
	 */
	@GetMapping("/findAllCategoryExById")
	@ApiOperation("根据id查找栏目信息")
	public  Message<CategoryEx>  findAllCategoryExById(int id){
		return MessageUtil.success(categoryService.findCategoryExById(id));
		
	}
}
