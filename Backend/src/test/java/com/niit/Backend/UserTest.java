package com.niit.Backend;

import static org.junit.Assert.assertEquals;

import java.beans.Transient;
import java.util.UUID;

import javax.persistence.Column;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.niit.Backend.DAO.UserDAO;
import com.niit.Backend.modal.Address;
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
		/*
		user.setContactNumber("1234567890");
		user.setEmail("rohan@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Rohan");
		user.setLastName("Mishra");
		user.setPassword("user12345");
		user.setRole("USER");
		assertEquals("Error inserting user" ,  true , userDAO.insert(user));
		*/
		
		user.setContactNumber("9807898734");
		user.setEmail("sd@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Soham");
		user.setLastName("Das");
		user.setPassword("supplier12345");
		user.setRole("SUPPLIER");
		assertEquals("Error inserting user" ,  true , userDAO.insert(user));
		
		/*
		user.setContactNumber("9087667890");
		user.setEmail("niitjadavpur@gmail.com");
		user.setEnabled(true);
		user.setFirstName("Niit");
		user.setLastName("Jadavpur");
		user.setPassword("admin12345");
		user.setRole("ADMIN");
		assertEquals("Error inserting user" ,  true , userDAO.insert(user));
	}
	/*
	
	//@Test
	public void testGetUser()
	{
		user = userDAO.getUser("rohan@gmail.com");
		assertEquals("Error fetching user" , "Rohan" , user.getFirstName());
	}
	
	
	@Test
	public void testAddUser() 
	{
		
		Address address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		
		address.setUserId(33);
			
		assertEquals("Failed to add the billing address!", true, userDAO.insertAddress(address));
		
		
		
		
	}*/

	
	
	}}

	