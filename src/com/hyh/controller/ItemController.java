package com.hyh.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hyh.entity.Item;
import com.hyh.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	// 查询商品列表
	@RequestMapping("/itemList")
	public String itemList(Item item,HttpServletRequest request){
	    List<Item> list = itemService.findItemList(item);
	    request.setAttribute("list", list);
		return "items";
	}
	
	// 跳转修改商品信息页面
	@RequestMapping("/goUpdateItem")
	public String goUpdateItem(int id,HttpServletRequest request) {
		Item item = itemService.getItemById(id);
		request.setAttribute("item", item);
		return "updateItem";
	}

	// 商品信息修改处理
	@RequestMapping("/updateItem")
	public String updateItem(Item item,MultipartFile multipartFile) throws Exception {
		if(multipartFile.getSize()>0) {
			String fileName = multipartFile.getOriginalFilename();
			String filePath = "D:\\eclipse\\apache-tomcat-8.5.33\\webapps\\pic";
			String newFileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
			File file = new File(filePath+"/"+newFileName);
			multipartFile.transferTo(file);		
			item.setPic(newFileName);
		}
		itemService.updateItem(item);
		return "redirect:itemList.action";
	}
	
	// 删除商品处理
	@RequestMapping("/deleteItem")
	public String deleteItem(int[] id) {
		itemService.deleteItem(id);
		return "redirect:itemList.action";
	}
}
