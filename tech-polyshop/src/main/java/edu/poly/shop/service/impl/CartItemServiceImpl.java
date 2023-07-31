package edu.poly.shop.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.poly.shop.domain.CartItem;
import edu.poly.shop.service.CartItemServive;

@Service
public class CartItemServiceImpl implements CartItemServive{
	Map<Long, CartItem> maps = new HashMap<>();
	
	@Override
	public void add(CartItem item) {
		CartItem items = maps.get(item.getProductId());
		if (items == null) {
			maps.put(item.getProductId(), item);
		}else {
			items.setQuantity(items.getQuantity() +1);
		}
	}
	@Override
	public void remove(Long id) {
		maps.remove(id);
	}
	@Override
	public CartItem update(Long productid, int qty) {
		CartItem cartItem = maps.get(productid);
		cartItem.setQuantity(qty);
		return cartItem;
	}
	@Override
	public void clear() {
		maps.clear();
	}
	@Override
	public Collection<CartItem> getAll(){
		return maps.values();
	}
	@Override
	public int getCount() {
		return maps.values().size();
	}
	@Override
	public double getAmount() {
		return maps.values().stream().mapToDouble(item -> item.getQuantity()* item.getUnitPrice()).sum();
	}
}

























