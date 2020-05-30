package com.ecewsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.BlockVO;
import com.ecewsi.model.FloorVO;
import com.ecewsi.model.StoreVO;
import com.ecewsi.service.BlockService;
import com.ecewsi.service.FloorService;
import com.ecewsi.service.StoreService;
@Controller
public class StoreController {
	
	@Autowired
	StoreService  storeService;
	
	@Autowired
	FloorService floorService;
	
	@Autowired 
	BlockService blockService;
	
	@RequestMapping(value="admin/addStore",method=RequestMethod.GET)
	public ModelAndView load()
	{
		List floorList=this.floorService.searchFloor();
		List blockList=this.blockService.searchBlock();
		return new ModelAndView("admin/addStore","StoreVO",new StoreVO()).addObject("floorList",floorList).addObject("blockList",blockList);
	}
	
	@RequestMapping(value="admin/insertStore",method=RequestMethod.POST)
	public ModelAndView insertStore(@ModelAttribute StoreVO storeVO)
	{
		this.storeService.insertStore(storeVO);
		return new ModelAndView("redirect:/admin/addStore");
	}
	@RequestMapping(value="admin/viewStore",method=RequestMethod.GET)
	public ModelAndView searchStore(@ModelAttribute StoreVO storeVO)
	{
		List storeList=this.storeService.searchStore();
		return new ModelAndView("admin/viewStore","ViewStore",storeList);
	}
	@RequestMapping(value="admin/deleteStore",method=RequestMethod.GET)
	public ModelAndView deleteStore(@ModelAttribute StoreVO storeVO,@RequestParam int id)
	{
		storeVO.getId();
		List storeList=storeService.searchByIdStore(storeVO);
		StoreVO deleteStoreList=(StoreVO) storeList.get(0);
		deleteStoreList.setStatus(false);//categoryService.insertCategory(deleteCategory);
		storeService.insertStore(deleteStoreList);
		return new ModelAndView("redirect:/admin/viewStore");
	}
	@RequestMapping(value="admin/editStore",method=RequestMethod.GET)
	public ModelAndView editStore(@ModelAttribute StoreVO storeVO,@ModelAttribute FloorVO floorVO,@ModelAttribute BlockVO blockVO,@RequestParam int id)
	{
		floorVO.getId();
		List floorList=this.floorService.searchFloor();
		FloorVO floorListById=(FloorVO) floorList.get(0);
		
		blockVO.getId();
		List blockList=this.blockService.searchBlock();
		BlockVO blockListById=(BlockVO) blockList.get(0);
		
		storeVO.getId();
		List storeList=this.storeService.searchByIdStore(storeVO);
		StoreVO editStoreList=(StoreVO) storeList.get(0);
		
		return new ModelAndView("admin/addStore","StoreVO", editStoreList).addObject("floorList",floorList).addObject("blockList",blockList);
		
	}
	
	
	
	
	

}
