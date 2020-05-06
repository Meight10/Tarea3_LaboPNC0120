package com.uca.tercerTareaLabo.controller;

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.tercerTareaLabo.domain.Product;

@Controller
public class ProductController {
	
	
	private ArrayList<Product> products = new ArrayList<Product>();

	
	@GetMapping("/productos")
	public ModelAndView compraProducto() {
		
		ModelAndView mav = new ModelAndView();
		
		products.add(new Product(0, "Manzana", 50));
		products.add(new Product(1, "Otra manzana", 50));
		products.add(new Product(2, "Uva", 50));
		products.add(new Product(3, "Kiwi", 50));	
		products.add(new Product(4, "Sandia", 1)); 
		products.add(new Product(5, "Cereza", 100));
		products.add(new Product(6, "Chile", 12));
		products.add(new Product(7, "Ramen", 20));
		products.add(new Product(8, "Espagueti", 20));
		products.add(new Product(9, "Sopa", 15));
		products.add(new Product(10, "Estuche", 7));


		
		mav.setViewName("productos");

		mav.addObject("product", new Product());
		mav.addObject("productList", products);
		
		return mav;
		
	}
	
	@PostMapping("/validar")
	@ResponseBody
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		
		if(products.get(product.getId()).getCantidad() >= product.getCantidad()) {
			
			mav.setViewName("/compra");
		
		} else {
		
			mav.setViewName("/error");
			
		}
		
		mav.addObject("nombre", products.get(product.getId()).getNombre());
		
		return mav;
	}
	

}
