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
import com.ecewsi.service.BlockService;
import com.ecewsi.service.FloorService;

@Controller
public class BlockController {
	@Autowired
	BlockService blockService;
	
	@Autowired
	FloorService floorService;
	
	@RequestMapping(value="admin/addBlock",method=RequestMethod.GET)
	public ModelAndView loadBlock(@ModelAttribute BlockVO blockVO)
	{
		List FloorList=this.floorService.searchFloor();
		return new ModelAndView("admin/addBlock","BlockVO",new BlockVO()).addObject("FloorList",FloorList);
	}
	@RequestMapping(value="admin/insertBlock",method=RequestMethod.POST)
	public ModelAndView insertBlock(@ModelAttribute BlockVO blockVO,@ModelAttribute FloorVO floorVO)
	{
		blockVO.getFloorVO().setStatus(true);
		blockVO.setStatus(true);
		this.blockService.insertBlock(blockVO);
		return new ModelAndView("redirect:/admin/addBlock");
	}
	@RequestMapping(value="admin/viewBlock",method=RequestMethod.GET)
	public ModelAndView searchBlock()
	{
		List blockList=this.blockService.searchBlock();
		return new ModelAndView("admin/viewBlock","BlockList",blockList);
	}
	
	@RequestMapping(value="admin/editBlock", method=RequestMethod.GET)
	public ModelAndView editBLock(@ModelAttribute BlockVO blockVO,@RequestParam int id,@ModelAttribute FloorVO floorVO)
	{
		
		floorVO.getId();
		List floorList=this.floorService.searchFloor();
		FloorVO floorSearchList=(FloorVO) floorList.get(0);
		
		blockVO.getId();
		List editBlockList=this.blockService.searchByIdBlock(blockVO);
		BlockVO editBlockSearchList=(BlockVO) editBlockList.get(0);
		return new ModelAndView("admin/addBlock","BlockVO",editBlockSearchList).addObject("FloorList", floorList);
	}
	
	@RequestMapping(value="admin/deleteBlock", method=RequestMethod.GET)
	public ModelAndView deleteBlock(@ModelAttribute BlockVO blockVO,@RequestParam int id)
	{
		blockVO.getId();
		List deleteBlockList=blockService.searchByIdBlock(blockVO);
		BlockVO deleteBlock=(BlockVO) deleteBlockList.get(0);
		deleteBlock.setStatus(false);
		blockService.insertBlock(deleteBlock);
		return new ModelAndView("redirect:/admin/viewBlock");	
	}

}
