package com.hyh.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyh.entity.Item;
import com.hyh.mapper.ItemMapper;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	public List<Item> findItemList(Item item) {	
		return itemMapper.findItemList(item);
	}

	public Item getItemById(int id) {
		return itemMapper.getItemById(id);
	}

	public void updateItem(Item item) {
		itemMapper.updateItem(item);
	}

	public void deleteItem(int[] id) {
		for(int i:id) {
			itemMapper.deleteItem(i);
		}		
	}
}
