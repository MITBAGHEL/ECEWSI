package com.ecewsi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.CategoryImageVO;
import com.ecewsi.model.CategoryVO;
import com.ecewsi.model.LoginVO;
import com.ecewsi.service.CategoryImageService;
import com.ecewsi.service.CategoryService;
import com.ecewsi.service.LoginService;
import com.ecewsi.utils.Basemethods;

@Controller
public class CategoryController
{
	@Autowired
	LoginService loginService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryImageService categoryImageService;

	@RequestMapping(value="admin/addCategory" , method=RequestMethod.GET)
	public ModelAndView loadCategory(@ModelAttribute CategoryImageVO categoryImageVO)
	{
		List categoryImageList=this.categoryImageService.searchCategoryImage(categoryImageVO);
		return new ModelAndView("admin/addCategory","CategoryVO",new CategoryVO()).addObject("categoryImageVO",categoryImageList);
	}
	
	@RequestMapping(value = "admin/insertCategory" ,method = RequestMethod.POST)
	public ModelAndView insertInteriorProduct(@ModelAttribute CategoryVO categoryVO, @RequestParam int id,
			@RequestParam(name = "file") List<MultipartFile> file, HttpSession session, HttpServletRequest request,
			@ModelAttribute LoginVO loginVO) {

		System.out.println(categoryVO.getCategoryName());
		System.out.println(categoryVO.getCategoryDiscription());
		//System.out.println(categoryVO.getS3CategoryImageLink());
		System.out.println(categoryVO.getId());
		System.out.println(loginVO.getLoginId());
		// productVO.setId(id);

		// loginVO.setLoginId(loginId);
		// loginVO.getLoginId();

		String userName = Basemethods.getUser();

		List loginList = loginService.searchLoginID(userName);

		/* System.out.println(userName); */

		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		//categoryVO.setLoginVO(loginVO2);

		categoryVO.setStatus(true);
		this.categoryService.insertCategory(categoryVO);

		for (MultipartFile multipartFile : file) {

			CategoryImageVO categoryImageVO = new CategoryImageVO();

			String path = request.getSession().getServletContext().getRealPath("/");

			String filePath = path + "document\\CategoryImage\\";
			String fileName = multipartFile.getOriginalFilename();

			try {
				byte barr[] = multipartFile.getBytes();
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

				bout.write(barr);
				bout.flush();
				bout.close();

				String link = Basemethods.uploadFileIntoS3(fileName,filePath,"CategoryImage");
				
				categoryImageVO.setS3CategoryImageLink(link);
				System.out.println("Link="+link);
				
				File f = new File(filePath + "/" + fileName);
				f.delete();
				
				
			}

			catch (Exception e) {
				e.printStackTrace();
			}

			
			categoryImageVO.setCategoryVO(categoryVO);
			categoryImageVO.setStatus(true);
			this.categoryImageService.insertCategoryImage(categoryImageVO);

			}
		return new ModelAndView("redirect:/admin/addCategory");
		}
	
	
	/*
	@RequestMapping(value="admin/insertCategory", method=RequestMethod.POST)
	public ModelAndView insertCategory(@ModelAttribute CategoryVO categoryVO)
	{
		categoryVO.setStatus(true);
		this.categoryService.insertCategory(categoryVO);
		return new ModelAndView("redirect:/admin/addCategory");
	}*/
	@RequestMapping(value="admin/viewCategory",method=RequestMethod.GET)
	public ModelAndView searchCategory(@ModelAttribute CategoryVO categoryVO,@ModelAttribute CategoryImageVO categoryImageVO)
	{
		List categoryList=this.categoryService.searchCategory(categoryVO);
		List categoryImageList=this.categoryImageService.searchCategoryImage(categoryImageVO);
		return new ModelAndView("admin/viewCategory","categoryList",categoryList).addObject("categoryImageVO",categoryImageList);	
	}
	@RequestMapping(value="admin/deleteCategory", method=RequestMethod.GET)
	public ModelAndView deleteCategory(@ModelAttribute CategoryVO categoryVO,@RequestParam int id)
	{
		categoryVO.getId();
		List deleteCategoryList=categoryService.searchByIdCategory(categoryVO);
		CategoryVO deleteCategory=(CategoryVO) deleteCategoryList.get(0);
		deleteCategory.setStatus(false);
		categoryService.insertCategory(deleteCategory);
		return new ModelAndView("redirect:/admin/viewCategory");	
	}
	@RequestMapping(value="admin/editCategory", method=RequestMethod.GET)
	public ModelAndView editCategory(@ModelAttribute CategoryVO categoryVO,@RequestParam int id)
	{
		categoryVO.setId(id);
		List editCategoryList=categoryService.searchByIdCategory(categoryVO);
		CategoryVO editList=(CategoryVO) editCategoryList.get(0);
		return new ModelAndView("admin/addCategory","CategoryVO",editList);
	}
}

