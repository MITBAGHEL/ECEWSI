package com.ecewsi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecewsi.model.BlockVO;
import com.ecewsi.model.CategoryVO;
import com.ecewsi.model.FloorVO;
import com.ecewsi.model.LoginVO;
import com.ecewsi.model.ProductVO;
import com.ecewsi.model.RackVO;
import com.ecewsi.model.StoreVO;
import com.ecewsi.model.SubCategoryVO;
import com.ecewsi.model.SubProductVO;
import com.ecewsi.service.BlockService;
import com.ecewsi.service.CategoryService;
import com.ecewsi.service.FloorService;
import com.ecewsi.service.LoginService;
import com.ecewsi.service.ProductService;
import com.ecewsi.service.RackService;
import com.ecewsi.service.StoreService;
import com.ecewsi.service.SubCategoryService;
import com.ecewsi.service.SubProductService;
import com.ecewsi.utils.Basemethods;

@Controller
public class SubProductController {
	
	@Autowired
	SubProductService subProductService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	RackService rackService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired 
	StoreService storeService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired 
	FloorService floorService;
	
	@Autowired
	BlockService blockService;
	
	@RequestMapping(value="admin/addSubProduct",method=RequestMethod.GET)
	public ModelAndView loadSubProduct(@ModelAttribute SubProductVO subProductVO,@ModelAttribute ProductVO productVO,@ModelAttribute CategoryVO categoryVO)
	{
		List productList=this.productService.searchProduct(productVO);
		List categoryList=this.categoryService.searchCategory(categoryVO);
		List subCategoryList=this.subCategoryService.searchSubCategory();
		List rackList=this.rackService.searchRack();
		List storeList=this.storeService.searchStore();
		List floorList=this.floorService.searchFloor();
		List blockList=this.blockService.searchBlock();
		return new ModelAndView("admin/addSubProduct","SubProductVO",new SubProductVO()).addObject("categoryList",categoryList).addObject("subCategoryList",subCategoryList).addObject("rackList",rackList).addObject("storeList",storeList).addObject("productList",productList).addObject("floorList",floorList).addObject("blockList",blockList);
	}
	@RequestMapping(value="admin/insertSubProduct",method=RequestMethod.POST)
	public ModelAndView insertSubProduct(@RequestParam MultipartFile file,@ModelAttribute SubProductVO subProductVO,HttpServletRequest request)
	{

		String path = request.getSession().getServletContext().getRealPath("/");

		String filePath = path + "document\\SubProductImage\\";
		String fileName = file.getOriginalFilename();
		
		String username=Basemethods.getUser();
		List loginList=loginService.searchLoginID(username);
		
		LoginVO loginId=(LoginVO) loginList.get(0);
		subProductVO.setLoginVO(loginId);
		try {
			byte barr[] = file.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

			bout.write(barr);
			bout.flush();
			bout.close();

			String link = Basemethods.uploadFileIntoS3(fileName,filePath,"SubProductImage");
			
			subProductVO.setSubProductImagelink(link);
			System.out.println("Link="+link);
		
			subProductVO.setStatus(true);
			this.subProductService.insertSubProduct(subProductVO);
			File f = new File(filePath + "/" + fileName);
			f.delete();
			
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/addSubProduct");
	}
	@RequestMapping(value="admin/viewSubProduct",method=RequestMethod.GET)
	public ModelAndView searchSubProduct(@ModelAttribute CategoryVO categoryVO,@ModelAttribute ProductVO productVO,@ModelAttribute SubProductVO subProductVO)
	{
		List subProductList=this.subProductService.searchSubProduct(subProductVO);
		List categoryList=this.categoryService.searchCategory(categoryVO);
		List subCategoryList=this.subCategoryService.searchSubCategory();
		List rackList=this.rackService.searchRack();
		List storeList=this.storeService.searchStore();
		List productList=this.productService.searchProduct(productVO);
		List floorList=this.floorService.searchFloor();
		List blockList=this.blockService.searchBlock();
		return new ModelAndView("admin/viewSubProduct","subProductList",subProductList).addObject("categoryList",categoryList).addObject("subCategoryList",subCategoryList).addObject("rackList",rackList).addObject("storeList",storeList).addObject("productList",productList).addObject("floorList",floorList).addObject("blockList",blockList);
	}
	@RequestMapping(value="admin/deleteSubProduct", method=RequestMethod.GET)
	public ModelAndView deleteSubProduct(@ModelAttribute SubProductVO subProductVO,@RequestParam int id)
	{
		subProductVO.getId();
		List deleteSubProductList=subProductService.searchByIdSubProduct(subProductVO);
		SubProductVO deleteSubProduct=(SubProductVO) deleteSubProductList.get(0);
		deleteSubProduct.setStatus(false);
		subProductService.insertSubProduct(deleteSubProduct);
		return new ModelAndView("redirect:/admin/viewSubProduct");	
	}
	@RequestMapping(value="admin/editSubProduct", method=RequestMethod.GET)
	public ModelAndView editSubProduct(@ModelAttribute SubProductVO subProductVO,@RequestParam int id,@ModelAttribute CategoryVO categoryVO
										,@ModelAttribute FloorVO floorVO,@ModelAttribute BlockVO blockVO,@ModelAttribute ProductVO productVO,@ModelAttribute SubCategoryVO subCategoryVO,@ModelAttribute RackVO rackVO,@ModelAttribute StoreVO storeVO)
	{
		
		categoryVO.getId();
		List categoryList=this.categoryService.searchCategory(categoryVO);
		
		subCategoryVO.getId();
		List subCategoryList=this.subCategoryService.searchSubCategory();
		
		rackVO.getId();
		List rackList=this.rackService.searchRack();
		
		storeVO.getId();
		List storeList=this.storeService.searchStore();
		StoreVO storeEditList=(StoreVO) storeList.get(0);
		
		productVO.getId();
		List productList=this.productService.searchProduct(productVO);
		
		floorVO.getId();
		List floorList=this.floorService.searchFloor();
		
		blockVO.getId();
		List blockList=this.blockService.searchBlock();
		
		
		subProductVO.getId();
		List subProductList=this.subProductService.searchByIdSubProduct(subProductVO);
		SubProductVO subProductEditList=(SubProductVO) subProductList.get(0);

		return new ModelAndView("admin/addSubProduct","SubProductVO",subProductEditList).addObject("categoryList",categoryList).addObject("subCategoryList",subCategoryList).addObject("rackList",rackList).addObject("storeList",storeList).addObject("productList",productList).addObject("floorList",floorList).addObject("blockList",blockList);
	}	

}
