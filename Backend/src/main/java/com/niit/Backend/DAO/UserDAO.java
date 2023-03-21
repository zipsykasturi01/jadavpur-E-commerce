package com.niit.Backend.DAO;

import java.util.List;

import com.niit.Backend.modal.Address;
import com.niit.Backend.modal.User;

public interface UserDAO {
	public boolean insert(User user);
	public User getUser(String email);
	public List<User> getSupplierList();
	
	public boolean insertAddress(Address address);
	
}
