package com.niit.Frontend.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.Backend.DAO.CartLinesDAO;
import com.niit.Backend.DAO.ProductDAO;
import com.niit.Backend.DAO.UserDAO;
import com.niit.Backend.modal.Address;
import com.niit.Backend.modal.Cart;
import com.niit.Backend.modal.CartLines;
import com.niit.Backend.modal.OrderDetails;
import com.niit.Backend.modal.OrderItem;
import com.niit.Backend.modal.Product;
import com.niit.Backend.modal.User;
import com.niit.Frontend.model.CheckoutModel;
import com.niit.Frontend.model.UserModel;

@Component("checkoutHandler")
public class CheckoutHandler 
{

	@Autowired
	UserDAO userDAO;

	@Autowired
	CartLinesDAO cartlinesDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;

	public List<Address> getShippingAddresses(CheckoutModel model) {

		List<Address> addresses = userDAO.getShippingAddress(model.getUser().getId());

		if (addresses.size() == 0) {
			addresses = new ArrayList<>();
		}

		addresses.add(addresses.size(), userDAO.getBillingAddress(model.getUser().getId()));

		return addresses;
	}

	public CheckoutModel init(String name) throws Exception {

		User user = userDAO.getUser(name);

		CheckoutModel checkoutModel = null;

		if (user != null) {
			checkoutModel = new CheckoutModel();
			checkoutModel.setUser(user);
			checkoutModel.setCart(user.getCart());

			double checkoutTotal = 0.0;
			List<CartLines> cartLines = cartlinesDAO.list(user.getCart().getId());

			if (cartLines.size() == 0) {
				throw new Exception("There are no products available for checkout now!");
			}

			for (CartLines cartLine : cartLines) {
				checkoutTotal += cartLine.getTotal();
			}

			checkoutModel.setCartLines(cartLines);
			checkoutModel.setCheckoutTotal(checkoutTotal);
		}

		return checkoutModel;
	}

	public String saveAddress(CheckoutModel checkoutModel, Address shipping) {

		String transitionValue = "success";

		shipping.setUserId(checkoutModel.getUser().getId());
		shipping.setShipping(true);
		userDAO.insertAddress(shipping);

		checkoutModel.setShipping(shipping);

		return transitionValue;
	}

	public String saveAddressSelection(CheckoutModel checkoutModel, int shippingId) {

		String transitionValue = "success";
		Address shipping = userDAO.getAddress(shippingId);
		checkoutModel.setShipping(shipping);
		return transitionValue;

	}

	public String saveOrder(CheckoutModel checkoutModel) {
		String transitionValue = "success";

		OrderDetails orderDetail = new OrderDetails();

		orderDetail.setUser(checkoutModel.getUser());
		orderDetail.setBilling(userDAO.getBillingAddress(checkoutModel.getUser().getId()));
		orderDetail.setShipping(checkoutModel.getShipping());
		orderDetail.setOrderDate(new Date());
		orderDetail.setOrderCount(checkoutModel.getCart().getCartLines());
		orderDetail.setOrderTotal(checkoutModel.getCheckoutTotal());

		List<CartLines> cartLines = checkoutModel.getCartLines();
		
		OrderItem orderItem = null;
		Product product = null;
		for (CartLines cartLine : cartLines) 
		{

			orderItem = new OrderItem();

			orderItem.setBuyingPrice(cartLine.getBuyingPrice());
			orderItem.setProduct(cartLine.getProduct());
			orderItem.setProductCount(cartLine.getProductCount());
			orderItem.setTotal(cartLine.getTotal());

			orderItem.setOrderDetail(orderDetail);
			
			orderDetail.getOrderItems().add(orderItem);

			
			product = cartLine.getProduct();
			product.setQuantity(product.getQuantity() - cartLine.getProductCount());
			productDAO.update(product);

			// delete the cartLine
			cartlinesDAO.remove(cartLine);
		}
		
		
		cartlinesDAO.addOrderDetail(orderDetail);

				
		// update the cart
		Cart cart = checkoutModel.getCart();
		cart.setGrandTotal(0);
		cart.setCartLines(0);
		cartlinesDAO.updateCart(cart);
		
		// update the cart if its in the session
		UserModel userModel = (UserModel) session.getAttribute("userModel");
		if(userModel!=null) 
		{
			userModel.setCart(cart);
		}
		
		checkoutModel.setOrderDetails(orderDetail);

		return transitionValue;
	}
	
	public OrderDetails getOrderDetails(CheckoutModel checkoutModel)
	{
		return checkoutModel.getOrderDetails();


}

}

