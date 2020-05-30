package com.ecewsi.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.ComplaintVO;
import com.ecewsi.model.LoginVO;
import com.ecewsi.service.ComplaintService;
import com.ecewsi.service.LoginService;
import com.ecewsi.utils.Basemethods;


@Controller
public class ComplaintController {

	@Autowired
	ComplaintService complaintService;
	
	
	@Autowired
	LoginService loginService;
	
	/******** User Complain***********/
	@RequestMapping(value="user/addComplain",method=RequestMethod.GET)
	public ModelAndView loadComplaint(){
		return new ModelAndView("user/addComplain","ComplainVO",new ComplaintVO());
	}
	
	@RequestMapping(value="user/insertAddComplain",method=RequestMethod.POST)
	public ModelAndView insertComplaint(@ModelAttribute ComplaintVO complaintVO, @RequestParam(name="file") MultipartFile file ,HttpSession session){
		
		String path = session.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();
		
		String finalPath = path+"document/complain/"; 
		
		try {
			byte b[] = file.getBytes();
			
			BufferedOutputStream bufferedOutputStream = 
					 new BufferedOutputStream(new FileOutputStream(finalPath+fileName));
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		complaintVO.setLoginVO(loginVO2);
		complaintVO.setComplaintDate(dateFormat.format(d));
		complaintVO.setComplaintFileName(fileName);
		complaintVO.setComplaintFilePath(finalPath);
		complaintVO.setComplainStatus("PENDING");
		this.complaintService.insertComplaint(complaintVO);
		return new ModelAndView("redirect:/user/addComplain");
	}
	
	@RequestMapping(value="user/viewComplain",method=RequestMethod.GET)
	public ModelAndView seeComplaint(@ModelAttribute ComplaintVO complaintVO) {
		
		
		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID(userName);
    	
    	/*System.out.println(userName);*/
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		
		complaintVO.setLoginVO(loginVO2);
		
		List complaintList = this.complaintService.seeComplaint(complaintVO);
		
		return new ModelAndView("user/viewComplain","complaintList",complaintList);
		
	}
	
	
	
	/******** Admin Complain***********/
	
	@RequestMapping(value="/admin/viewComplain",method=RequestMethod.GET)
	public ModelAndView viewComplain() {
		
		List complaintList = this.complaintService.viewComplaint();
		
		return new ModelAndView("/admin/viewComplain","complaintList",complaintList);
		
	}
	
	@RequestMapping(value="admin/addReplyComplain",method=RequestMethod.GET)
	public ModelAndView loadReply(@RequestParam int id,@ModelAttribute ComplaintVO complaintVO) {
		
		
		complaintVO.setId(id);
		
		List complaintList = this.complaintService.searchComplain(complaintVO);
		
		return new ModelAndView("admin/addReplyComplain","complaintVO",complaintList.get(0));
	}
	
	@RequestMapping(value="admin/insertReply",method=RequestMethod.POST)
	public ModelAndView insertReply(@ModelAttribute ComplaintVO complaintVO) {
		
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		complaintVO.setReplyDate(dateFormat.format(d));
		complaintVO.setComplainStatus("resolved");
		
		this.complaintService.insertComplaint(complaintVO);
		
		return new ModelAndView("redirect:/admin/viewComplain");
	}
	
	
}
