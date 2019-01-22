package com.hyh.service;

import java.util.List;

import com.hyh.entity.Item;

public interface ItemService {

	public List<Item> findItemList(Item item);
	
	public Item getItemById(int id);
	
	public void updateItem(Item item);

	public void deleteItem(int[] id);
}
