package com.hyh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyh.entity.Item;

@Mapper
public interface ItemMapper {

	public List<Item> findItemList(Item item);
	
	public Item getItemById(int id);
	
	public void updateItem(Item item);

	public void deleteItem(int id);
}
