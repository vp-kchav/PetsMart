package edu.mum.petsmart.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;




@Entity
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761112110046894436L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable
	private List<Item> cartItems;
	
	public Cart() {
		cartItems = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}

	public void addCartItem(Item cartItem) {
		cartItems.add(cartItem);
	}
	
	public double getTotalPrice() {
		double sum = 0;
		for(Item i : cartItems) {
			sum += i.getDiscount();
		}
		return sum;
	}
	
}
