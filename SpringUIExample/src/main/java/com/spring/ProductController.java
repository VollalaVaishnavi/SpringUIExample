package com.spring;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProductController {
@Autowired
private ProductService service;

@RequestMapping("/")
public String viewHomePage(Model model) {
	List<Product>listProducts=service.listAll();
	model.addAttribute("listProducts",listProducts);
	return "index";
}
@RequestMapping(path = {"/search"})
public String home(Product p, Model model, String keyword) {
 if(keyword!=null) {
  List<Product> listProducts = service.getByKeyword(keyword);
  model.addAttribute("listProducts",listProducts);
 }else {
 List<Product> listProducts = service.listAll();
 model.addAttribute("listProducts",listProducts);}
 return "index";
}

@RequestMapping("/new")
public String showNewProductPage(Model model) {
	Product product=new Product();
	model.addAttribute("product",product);
	return "NewProduct"; 
	
}
@RequestMapping(value="/save",method=RequestMethod.POST)
public String saveProduct(@Valid @ModelAttribute("product")Product product,BindingResult bindingResult) {
	if(bindingResult.hasErrors()) {
		System.out.println(">>>>>"+bindingResult.hasErrors());
		return "NewProduct";
	}
	System.out.println("###########"+bindingResult.hasErrors());
	service.save(product);
	return "redirect:/";


}
@RequestMapping("/edit/{id}")
public ModelAndView showEditProductPage(@PathVariable(name="id")Integer id) {
	ModelAndView mod=new ModelAndView("edit_product");
	Product product=service.get(id);
	mod.addObject("product",product);
	return mod;
}

@RequestMapping("/delete/{id}")
public String deleteProduct(@PathVariable(name="id")Integer id) {
	service.delete(id);
	return "redirect:/";
}
 
}

