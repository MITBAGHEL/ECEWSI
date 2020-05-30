package com.ecewsi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.CategoryVO;
import com.ecewsi.model.SubCategoryVO;
import com.ecewsi.service.CategoryService;
import com.ecewsi.service.SubCategoryService;
import com.ecewsi.utils.Basemethods;

@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="admin/addSubCategory",method=RequestMethod.GET)
	public ModelAndView loadSubCategory(@ModelAttribute CategoryVO categoryVO)
	{
		List CategoryList=this.categoryService.searchCategory(categoryVO);
		return new ModelAndView("admin/addSubCategory","SubCategoryVO",new SubCategoryVO()).addObject("CategoryList",CategoryList);
	}
	@RequestMapping(value="admin/insertSubCategory",method=RequestMethod.POST)
	public ModelAndView insertSubCategory(@RequestParam MultipartFile file,@ModelAttribute SubCategoryVO subCategoryVO,HttpServletRequest request)
	{

		String path = request.getSession().getServletContext().getRealPath("/");

		String filePath = path + "document\\SubCategoryImage\\";
		String fileName = file.getOriginalFilename();

		try {
			byte barr[] = file.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

			bout.write(barr);
			bout.flush();
			bout.close();

			String link = Basemethods.uploadFileIntoS3(fileName,filePath,"SubCategoryImage");
			
			subCategoryVO.setLink(link);
			System.out.println("Link="+link);
		
			

			subCategoryVO.setStatus(true);
			this.subCategoryService.insertSubCategory(subCategoryVO);
			File f = new File(filePath + "/" + fileName);
			f.delete();
			
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}


		
		
		return new ModelAndView("redirect:/admin/addSubCategory");
	}
	@RequestMapping(value="admin/viewSubCategory",method=RequestMethod.GET)
	public ModelAndView searchSubCategory()
	{
		List subCategoryList=this.subCategoryService.searchSubCategory();
		return new ModelAndView("admin/viewSubCategory","subCategoryList",subCategoryList);
	}
	@RequestMapping(value="admin/deleteSubCategory", method=RequestMethod.GET)
	public ModelAndView deleteSubCategory(@ModelAttribute SubCategoryVO subCategoryVO,@RequestParam int id)
	{
		subCategoryVO.getId();
		List deleteSubCategoryList=subCategoryService.searchByIdSubCategory(subCategoryVO);
		SubCategoryVO deleteSubCategory=(SubCategoryVO) deleteSubCategoryList.get(0);
		deleteSubCategory.setStatus(false);
		subCategoryService.insertSubCategory(deleteSubCategory);
		return new ModelAndView("redirect:/admin/viewSubCategory");	
	}
	@RequestMapping(value="admin/editSubCategory", method=RequestMethod.GET)
	public ModelAndView editSubCategory(@ModelAttribute SubCategoryVO subCategoryVO,@RequestParam int id,@ModelAttribute CategoryVO categoryVO)
	{
		
		categoryVO.getId();
		List categoryList=this.categoryService.searchCategory(categoryVO);
		CategoryVO categorySearchList=(CategoryVO) categoryList.get(0);
		
		subCategoryVO.getId();
		List editSubCategoryList=this.subCategoryService.searchByIdSubCategory(subCategoryVO);
		SubCategoryVO editsubCategorysearchList=(SubCategoryVO) editSubCategoryList.get(0);
		return new ModelAndView("admin/addSubCategory","SubCategoryVO",editsubCategorysearchList).addObject("CategoryList", categoryList);
	}	
}
