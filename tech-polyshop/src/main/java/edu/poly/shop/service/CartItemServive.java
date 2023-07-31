package edu.poly.shop.service;

import java.util.Collection;

import edu.poly.shop.domain.CartItem;

public interface CartItemServive {

	double getAmount();

	int getCount();

	Collection<CartItem> getAll();

	void clear();

	CartItem update(Long productid, int qty);

	void remove(Long id);

	void add(CartItem item);

}
