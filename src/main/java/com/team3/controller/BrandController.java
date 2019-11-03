/**
 * @author 나영균
 * 
 */
package com.team3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.dao.brand.service.BrandService;
import com.team3.vo.brand.Brand;
@Controller
public class BrandController {
	@Autowired
	BrandService service;
	
	//줄일 방법을 언젠가 찾을..
	@RequestMapping("/brand.history")
	public String history(Brand brand, Model model) {
		model.addAttribute("brand", service.callBrand());
		return "brand/brand_history";
	}
	@RequestMapping("/brand.intro")
	public String introduce(Brand brand, Model model) {
		model.addAttribute("brand", service.callBrand());
		return "brand/brand_introduce";
	}
	@RequestMapping("/brand.fact")
	public String factory(Brand brand, Model model) {
		model.addAttribute("brand", service.callBrand());
		return "brand/factory_info";
	}
}
