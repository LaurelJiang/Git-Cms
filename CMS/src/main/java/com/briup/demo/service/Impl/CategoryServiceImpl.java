package com.briup.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.mapper.ex.CategoryExMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class CategoryServiceImpl implements ICategoryService{
	//栏目的dao
	@Autowired 
	private CategoryMapper categoryMapper;
	//栏目的拓展dao
	@Autowired
	private CategoryExMapper categoryExMapper;
	//文章的dao
	@Autowired
	private ArticleMapper articleMapper;
	//查找所有的栏目
	@Override
	public List<Category> findAllCategorys() throws CustomerException {
//		CategoryExample example = new CategoryExample();
//		List<Category> list = categoryMapper.selectByExample(example);
//		return list;
		return categoryMapper.selectByExample(new CategoryExample());
	}
	
	
	@Override
	public void saveOrUpdateCategory(Category category) throws CustomerException {
		//保存即将插入的栏目
		if (category==null) {
			throw new CustomerException(StatusCodeUtil.ERROE_CODE
					, "参数为空！");
		}if (category.getId()==null) {
				categoryMapper.insert(category);
		}else {
			categoryMapper.updateByPrimaryKey(category);
		}
	}
	
	//删除指定id的栏目
	@Override
	public void deleteCategoryById(int id) throws CustomerException {
//		categoryMapper.deleteByPrimaryKey(id);
		//删除栏目的同时，需要先删除栏目中包含的文章信息。
				ArticleExample example = new ArticleExample();
				example.createCriteria().andCategoryIdEqualTo(id);
				articleMapper.deleteByExample(example);
				
				categoryMapper.deleteByPrimaryKey(id);
	}
	
	//通过id查询栏目
	@Override
	public Category findCategoryById(int id) throws CustomerException {
		return categoryMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<CategoryEx> findAllCategoryEx() throws CustomerException {
		return categoryExMapper.findAllCategoryExs();
	}


	@Override
	public CategoryEx findCategoryExById(int id) throws CustomerException {
		return categoryExMapper.findCategoryExById(id);
	}

}
