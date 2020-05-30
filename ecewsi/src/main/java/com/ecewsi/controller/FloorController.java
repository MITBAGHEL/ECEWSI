package com.ecewsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.FloorVO;
import com.ecewsi.service.FloorService;

@Controller
public class FloorController {

	@Autowired
	FloorService floorService;
	
	@RequestMapping(value="admin/addFloor",method=RequestMethod.GET)
	public ModelAndView loadFloor()
	{
		return new ModelAndView("admin/addFloor","FloorVO",new FloorVO());
	}
	@RequestMapping(value="admin/insertFloor",method=RequestMethod.POST)
	public ModelAndView insertFloor(@ModelAttribute FloorVO floorVO,@RequestParam int floor)
	{
		floorVO.setStatus(true);
		this.floorService.insertFloor(floorVO);
		return new ModelAndView("redirect:/admin/addFloor");
	}
	@RequestMapping(value="admin/viewFloor",method=RequestMethod.GET)
	public ModelAndView searchFloor(@ModelAttribute FloorVO floorVO)
	{
		List FloorList=this.floorService.searchFloor();
		return new ModelAndView("admin/viewFloor","FloorList",FloorList);	
	}
	@RequestMapping(value="admin/flooredit", method=RequestMethod.GET)
	public ModelAndView editFloor(@ModelAttribute FloorVO floorVO,@RequestParam int id)
	{
		floorVO.setId(id);
		List editFloorList=floorService.searchByIdFloor(floorVO);
		FloorVO editList=(FloorVO) editFloorList.get(0);
		return new ModelAndView("admin/addFloor","FloorVO",editList);
	}
	@RequestMapping(value="admin/floordelete", method=RequestMethod.GET)
	public ModelAndView deleteFloor(@ModelAttribute FloorVO floorVO,@RequestParam int id)
	{
		floorVO.getId();
		List deleteFloorList=floorService.searchByIdFloor(floorVO);
		FloorVO deleteFloor=(FloorVO) deleteFloorList.get(0);
		deleteFloor.setStatus(false);
		floorService.insertFloor(deleteFloor);
		return new ModelAndView("redirect:/admin/viewFloor");	
	}
}
