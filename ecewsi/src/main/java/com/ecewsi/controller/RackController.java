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
import com.ecewsi.model.RackVO;
import com.ecewsi.service.BlockService;
import com.ecewsi.service.FloorService;
import com.ecewsi.service.RackService;

@Controller
public class RackController {
	@Autowired
	RackService rackService;
	
	@Autowired
	FloorService floorService;
	
	@Autowired
	BlockService blockService;
	
	@RequestMapping(value="admin/addRack",method=RequestMethod.GET)
	public ModelAndView loadRack()
	{
		List floorList=this.floorService.searchFloor();
		List blockList=this.blockService.searchBlock();
		System.out.println(floorList.size()+"and"+blockList.size());
		return new ModelAndView("admin/addRack","RackVO",new RackVO()).addObject("floorList",floorList).addObject("blockList",blockList);
	}
	@RequestMapping(value="admin/insertRack", method=RequestMethod.POST)
	public ModelAndView insertRack(@ModelAttribute RackVO rackVO)
	{
		rackVO.setStatus(true);
		this.rackService.insertRack(rackVO);
		return new ModelAndView("redirect:/admin/addRack");
	}
	@RequestMapping(value="admin/viewRack",method=RequestMethod.GET)
	public ModelAndView searchRack()
	{
		List searchRackList=this.rackService.searchRack();
		return new ModelAndView("admin/viewRack","rackList",searchRackList);
	}
	@RequestMapping(value="admin/editRack",method=RequestMethod.GET)
	public ModelAndView editRack(@ModelAttribute RackVO rackVO,@ModelAttribute FloorVO floorVO,@ModelAttribute BlockVO blockVO)
	{
		floorVO.getId();
		List floorList=this.floorService.searchFloor();
		FloorVO floorSearchList=(FloorVO) floorList.get(0);
		//System.out.println();
		System.out.println(floorList.size());
		
		blockVO.getId();
		List blockList=this.blockService.searchBlock();
		BlockVO blockSearchList=(BlockVO) blockList.get(0);
		System.out.println(blockList.size());
		
		rackVO.getId();
		List rackList=this.rackService.searchByIdRack(rackVO);
		RackVO rackSearchList=(RackVO) rackList.get(0);
		return new ModelAndView("admin/addRack","RackVO", rackSearchList).addObject("floorList",floorList).addObject("blockList",blockList);
		
	}
	@RequestMapping(value="admin/deleteRack", method=RequestMethod.GET)
	public ModelAndView deleteRack(@ModelAttribute RackVO rackVO,@RequestParam int id)
	{
		rackVO.getId();
		List deleteRack=rackService.searchRack();
		RackVO deleteSearchRack=(RackVO) deleteRack.get(0);
		deleteSearchRack.setStatus(false);
		rackService.insertRack(deleteSearchRack);
		return new ModelAndView("redirect:/admin/viewRack");	
	}
}
