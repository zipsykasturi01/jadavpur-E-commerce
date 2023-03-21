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
	
	@Test
	public void testInsert()
	{
		Category = new Category();
		Category.setId(18);
		Category.setCategoryName("AC");
		Category.setDescription("Sample Category for AC");
		Category.setActive(true);
		
		assertEquals("Error adding Category" , true, categoryDAO.insert(Category));
	}
	//@Test
	public void testDelete()
	{
		Category = categoryDAO.getCategory(1);
		
		
		assertEquals("Error deleting Category" , true, categoryDAO.delete(Category));
	}
	//@Test
	public void testUpdate()
	{
		Category = categoryDAO.getCategory(1);
		Category.setCategoryName("Television");
		
		
		assertEquals("Error updating Category" , true, categoryDAO.update(Category));
	}
	
	//@Test
	public void testCategoryList()
	{
		
		
		assertEquals("Error updating Category" , 3, categoryDAO.categoryList().size());
	}

}
