package com.niit.Backend.DAO;

import java.util.List;
import com.niit.Backend.modal.Cart;
import com.niit.Backend.modal.CartLines;

public interface CartLinesDAO {

	public List<CartLines> list(int cartId);
	public CartLines get(int id);	
	public boolean add(CartLines cartLine);
	public boolean update(CartLines cartLine);
	public boolean remove(CartLines cartLine);
	boolean updateCart(Cart cart);
	public List<CartLines> listAvailable(int cartId);
}
