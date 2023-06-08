package com.niit.Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.DAO.*;
import com.niit.Backend.modal.*;

public class CategoryTest {
	private static AnnotationConfigApplicationContext context;
	static Category Category;
	static CategoryDAO categoryDAO;	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*
	//@Test
	public void testInsert()
	{
		category = new Category();
		category.setId(5);
		category.setCategoryName("Laptop");
		category.setDescription("Sample category for Laptop");
		category.setActive(true);
		
		assertEquals("Error adding Category" , true, categoryDAO.insert(category));
	}
	
	//@Test
	public void testDelete()
	{
		category = categoryDAO.getCategory(12);
		
		assertEquals("Error deleting Category" , true, categoryDAO.delete(category));
	}
	
	//@Test
	public void testUpdate()
	{
		category = categoryDAO.getCategory(1);
		category.setCategoryName("Television");
		
		assertEquals("Error updating Category" , true, categoryDAO.update(category));
	}
	
	//@Test
	public void testCategoryList()
	{
		assertEquals("Error updating Category" , 2, categoryDAO.categoryList().size());
	}
*/
}