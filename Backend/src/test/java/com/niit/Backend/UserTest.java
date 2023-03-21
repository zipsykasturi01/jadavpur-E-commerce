package com.niit.Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.DAO.UserDAO;
import com.niit.Backend.modal.User;

public class UserTest {
	private static AnnotationConfigApplicationContext context;
	static User user;
	static UserDAO userDAO;	
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void testInsert()
	{
		user = new User();
		
		
		user.setContactNumber("8988098734");
		user.setEmail("arjun@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Allu");
		//user.setId(9);
		user.setLastName("mita");
		user.setPassword("supplier12375");
		user.setRole("SUPPLIER");
		
		
		assertEquals("Error inserting user" ,  true , userDAO.insert(user));
	}
	
	//@Test
	public void testGetUser()
	{
		user = userDAO.getUser("rohan@gmail.com");
		assertEquals("Error fetching user" , "Rohan" , user.getFirstName());
	}
	
	//@Test
	public void testSupplierList()
	{
			
			assertEquals("Error fetching user" , 2 , userDAO.getSupplierList().size());
	}
	
	
}

	