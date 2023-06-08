package com.niit.Frontend.model;

import java.io.Serializable;
import java.util.List;

import com.niit.Backend.modal.Address;
import com.niit.Backend.modal.Cart;
import com.niit.Backend.modal.CartLines;
import com.niit.Backend.modal.OrderDetails;
import com.niit.Backend.modal.User;

public class CheckoutModel implements Serializable 
{

	private static final long serialVersionUID = 1L;

	private User user;
	private Address shipping;
	private Cart cart;
	private List<CartLines> cartLines;
	private double checkoutTotal;
private OrderDetails orderDetails;

	
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public double getCheckoutTotal() {
		return checkoutTotal;
	}

	public void setCheckoutTotal(double checkoutTotal) {
		this.checkoutTotal = checkoutTotal;
	}

	public List<CartLines> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<CartLines> cartLines) {
		this.cartLines = cartLines;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getShipping() {
		return shipping;
	}

	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}
}
