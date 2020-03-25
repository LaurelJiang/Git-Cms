package com.briup.demo.mapper.ex;

import java.util.List;

import com.briup.demo.bean.ex.CategoryEx;

/**
 * 处理查询栏目及其包含的文章信息
 * @author JT
 *
 */
public interface CategoryExMapper {
	/**
	 * 实现查询栏目及其包含的文章信息
	 * @return
	 */
	List<CategoryEx> findAllCategoryExs();
	
	/**
	 * 通过id查询对应栏目及其包含的文章信息
	 */
	CategoryEx findCategoryExById(int id);
}
