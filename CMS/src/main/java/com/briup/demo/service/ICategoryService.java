package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.utils.CustomerException;

public interface ICategoryService {
	/**
	 * 查询所有的栏目
	 * @return
	 * @throws CustomerException
	 */
	public List<Category> findAllCategorys() throws CustomerException;
	
	/**
	 * 添加或者修改栏目信息
	 * @param category
	 * @throws CustomerException
	 */
	public void saveOrUpdateCategory(Category category) throws CustomerException;
	
	/**
	 * 根据id删除栏目信息
	 * @param id
	 * @throws CustomerException
	 */
	public void deleteCategoryById(int id) throws CustomerException;
	
	/**
	 * 通过id查询栏目的信息
	 * @param id
	 * @return
	 * @throws CustomerException
	 */
	public Category findCategoryById(int id) throws CustomerException;
	/**
	 * 查询栏目信息并且级联查询包含的文章信息
	 * @return 
	 */
	public List<CategoryEx> findAllCategoryEx() throws CustomerException;
	
	/**
	 * 查询栏目及其包含的文章所有数据
	 */
	CategoryEx   findCategoryExById(int id) throws  CustomerException;
}
