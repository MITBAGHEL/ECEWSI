package com.ecewsi.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
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

import com.ecewsi.model.BlockVO;
import com.ecewsi.model.CategoryVO;
import com.ecewsi.model.FloorVO;
import com.ecewsi.model.LoginVO;
import com.ecewsi.model.ProductImageVO;
import com.ecewsi.model.ProductVO;
import com.ecewsi.model.SubProductVO;
import com.ecewsi.model.RackVO;
import com.ecewsi.model.StoreVO;
import com.ecewsi.model.SubCategoryVO;
import com.ecewsi.service.BlockService;
import com.ecewsi.service.CategoryService;
import com.ecewsi.service.FloorService;
import com.ecewsi.service.LoginService;
import com.ecewsi.service.ProductImageService;
import com.ecewsi.service.ProductService;
import com.ecewsi.service.RackService;
import com.ecewsi.service.StoreService;
import com.ecewsi.service.SubCategoryService;
import com.ecewsi.utils.Basemethods;

@Controller
public class ProductController {

	@Autowired
	StoreService storeService;

	@Autowired
	LoginService loginService;

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubCategoryService subCategoryService;

	@Autowired
	FloorService floorService;

	@Autowired
	BlockService blockService;

	@Autowired
	RackService rackService;

	@Autowired
	ProductImageService productImageService;

	@RequestMapping(value = "admin/addProduct", method = RequestMethod.GET)
	public ModelAndView loadProduct(@ModelAttribute CategoryVO categoryVO) {
		List categoryList = this.categoryService.searchCategory(categoryVO);
		List subCategoryList = this.subCategoryService.searchSubCategory();
		List rackList = this.rackService.searchRack();
		List storeList = this.storeService.searchStore();
		return new ModelAndView("admin/addProduct", "ProductVO", new ProductVO())
				.addObject("CategoryList", categoryList).addObject("SubCategoryList", subCategoryList)
				.addObject("RackList", rackList).addObject("StoreList", storeList);
	}

	@RequestMapping(value = "admin/insertProduct", method = RequestMethod.POST)
	public ModelAndView insertInteriorProduct(@ModelAttribute ProductVO productVO, @RequestParam int id,
			@RequestParam(name = "file") List<MultipartFile> file, HttpSession session, HttpServletRequest request,
			@ModelAttribute LoginVO loginVO) {

		//System.out.println(productVO.getProductName());
		/*System.out.println(productVO.getCategoryVO());
		System.out.println(productVO.getSubCategoryVO());
		System.out.println(productVO.getId());
		System.out.println(loginVO.getLoginId());*/
		// productVO.setId(id);

		// loginVO.setLoginId(loginId);
		// loginVO.getLoginId();

		String userName = Basemethods.getUser();

		List loginList = loginService.searchLoginID(userName);

		/* System.out.println(userName); */

		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		productVO.setLoginVO(loginVO2);

		productVO.setStatus(true);
		this.productService.insertProduct(productVO);

		for (MultipartFile multipartFile : file) {

			ProductImageVO productImageVO = new ProductImageVO();

			String path = request.getSession().getServletContext().getRealPath("/");

			String filePath = path + "document\\ProductImage\\";
			String fileName = multipartFile.getOriginalFilename();

			try {
				byte barr[] = multipartFile.getBytes();
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

				bout.write(barr);
				bout.flush();
				bout.close();

				String link = Basemethods.uploadFileIntoS3(fileName,filePath,"ProductImage");
				
				productVO.setS3productLink(link);
				System.out.println("Link="+link);
				
			}

			catch (Exception e) {
				e.printStackTrace();
			}

			productImageVO.setProductVO(productVO);
			productImageVO.setStatus(true);
			this.productService.insertProduct(productVO);
		}

		return new ModelAndView("redirect:/admin/addProduct");
	}

	@RequestMapping(value = "admin/viewProduct", method = RequestMethod.GET)
	public ModelAndView searchProduct(@ModelAttribute CategoryVO categoryVO,
			@ModelAttribute SubCategoryVO subCategoryVO, @ModelAttribute ProductVO productVO,
			@ModelAttribute ProductImageVO productImageVO, @ModelAttribute RackVO rackVO,
			@ModelAttribute StoreVO storeVO) {
		System.out.println(productVO);
		List productSearchList = this.productService.searchProduct(productVO);
		List rackList = this.rackService.searchRack();
		List storeList = this.storeService.searchStore();
		List productImageSearchList = this.productImageService.searchProductImage(productImageVO);

		System.out.println("image list : " + productSearchList.size());
		return new ModelAndView("admin/viewProduct", "productSearchList", productSearchList)
				.addObject("productImageSearchList", productImageSearchList).addObject("RackList", rackList)
				.addObject("StoreList", storeList);
	}
	
	@RequestMapping(value = "admin/viewImage", method = RequestMethod.GET)
	public ModelAndView viewImage(@ModelAttribute ProductImageVO productImageVO,@RequestParam int id)
	{
		
		ProductVO productVO = new ProductVO();
		productVO.setId(id);
		productImageVO.setProductVO(productVO);
		
		List productImageSearchList = this.productImageService.searchByIdImage(productImageVO);
		System.out.print("Image size="+productImageSearchList.size());
	
		return new ModelAndView("admin/viewImage","productImageSearchList", productImageSearchList);
	}
	

	@RequestMapping(value = "admin/editProduct", method = RequestMethod.GET)
	public ModelAndView editProduct(@ModelAttribute CategoryVO categoryVO, @ModelAttribute SubCategoryVO subCategoryVO,
			@ModelAttribute FloorVO floorVO, @ModelAttribute StoreVO storeVO, @ModelAttribute BlockVO blockVO,
			@ModelAttribute RackVO rackVO, @RequestParam int id, @ModelAttribute ProductVO productVO) {
		categoryVO.getId();
		List categoryList = this.categoryService.searchCategory(categoryVO);
		//CategoryVO categorySearchList = (CategoryVO) categoryList.get(0);

		subCategoryVO.getId();
		List subCategoryList = this.subCategoryService.searchSubCategory();
		//SubCategoryVO subCategorySearchList = (SubCategoryVO) subCategoryList.get(0);

		storeVO.getId();
		List storeNameList = this.storeService.searchStore();
		//StoreVO storeSearchList = (StoreVO) storeNameList.get(0);

		rackVO.getId();
		List rackList = this.rackService.searchRack();
		//RackVO rackSearchList = (RackVO) rackList.get(0);

		productVO.getId();
		List productList = this.productService.searchByIdProduct(productVO);
		ProductVO productSearchList = (ProductVO) productList.get(0);

		return new ModelAndView("admin/addProduct", "ProductVO", productSearchList).addObject("RackList", rackList)
				.addObject("CategoryList", categoryList).addObject("SubCategoryList", subCategoryList)
				.addObject("StoreList", storeNameList);
	}

	
	@RequestMapping(value = "admin/deleteImages", method = RequestMethod.GET)
	public ModelAndView imagesSearchById(@ModelAttribute CategoryVO categoryVO,
			@ModelAttribute SubCategoryVO subCategoryVO, @ModelAttribute ProductVO productVO, @RequestParam int id,
			@ModelAttribute ProductImageVO productImageVO)
	{

		productImageVO.setId(id);
		List productImageSearchList = productImageService.productImageSearchById(productImageVO);
		ProductImageVO productImageVO2 = (ProductImageVO) productImageSearchList.get(0);
		productImageVO2.setStatus(false);
		productImageService.insertProductImage(productImageVO2);

		return new ModelAndView("redirect:/admin/viewProduct");
	}

	@RequestMapping(value = "admin/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@ModelAttribute ProductVO productVO,@RequestParam int id) {
		productVO.setId(id);
		List deleteProduct = this.productService.searchByIdProduct(productVO);
		ProductVO deleteSearchProduct = (ProductVO) deleteProduct.get(0);
		deleteSearchProduct.setStatus(false);
		productService.insertProduct(deleteSearchProduct);
		return new ModelAndView("redirect:/admin/viewProduct");
	}

	

	@RequestMapping(value = "admin/addImages", method = RequestMethod.GET)
	public ModelAndView addImages(@ModelAttribute CategoryVO categoryVO, @ModelAttribute SubCategoryVO subCategoryVO,
			@ModelAttribute ProductVO productVO, @RequestParam int id) {
		categoryVO.getId();
		List categoryList = this.categoryService.searchCategory(categoryVO);
		
		subCategoryVO.getId();
		List subCategoryList = this.subCategoryService.searchSubCategory();
		
		List rackList = this.rackService.searchRack();

		List storeList = this.storeService.searchStore();
		productVO.getId();
		List productList = this.productService.searchByIdProduct(productVO);
		ProductVO productSearchList = (ProductVO) productList.get(0);
		return new ModelAndView("admin/addProduct", "ProductVO", productSearchList)
				.addObject("CategoryList", categoryList).addObject("SubCategoryList", subCategoryList)
				.addObject("RackList", rackList).addObject("StoreList", storeList);
	}

}
