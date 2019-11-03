/**
 * @author 나영균,박경민
 *  search 박경민
 */
package com.team3.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team3.dao.car.CarThumbnailRepository;
import com.team3.dao.guide.service.GuideService;
import com.team3.vo.car.CarThumbnail;

@Controller
public class MainController {

	@Autowired
	private CarThumbnailRepository carThumbnailRepo;
	@Autowired
	GuideService car;

	@RequestMapping("/")
	public String getCarList(Model model,CarThumbnail carThumbnail) {
		
		List<CarThumbnail> ecoList = carThumbnailRepo.ecoList();
		model.addAttribute("ecoList",ecoList);
		
		List<CarThumbnail> midList = carThumbnailRepo.midList();
		model.addAttribute("midList",midList);
		
		List<CarThumbnail> flagList = carThumbnailRepo.flagList();
		model.addAttribute("flagList",flagList);
		
		List<CarThumbnail> truckList = carThumbnailRepo.truckList();
		model.addAttribute("truckList",truckList);
		
		return "index";		
		}	
	
	@RequestMapping("/detail")
	public String detail(CarThumbnail ct, Model model) {
		
		model.addAttribute("ecoList", carThumbnailRepo.ecoList());
		model.addAttribute("midList", carThumbnailRepo.midList());
		model.addAttribute("flagList", carThumbnailRepo.flagList());
		model.addAttribute("truckList", carThumbnailRepo.truckList());	
		model.addAttribute("carList", car.detailCar(ct.getDb_no()));
		return "showCars/detail_segment"; 
	}
	
	@RequestMapping("/search")
	public String doSearch(@RequestParam(value="searchText", required=false, defaultValue="null")String searchword, Model model,CarThumbnail carThumbnail) {		
		List<CarThumbnail> ecoList = carThumbnailRepo.ecoList();
		model.addAttribute("ecoList",ecoList);
		
		List<CarThumbnail> midList = carThumbnailRepo.midList();
		model.addAttribute("midList",midList);
		
		List<CarThumbnail> flagList = carThumbnailRepo.flagList();
		model.addAttribute("flagList",flagList);
		
		List<CarThumbnail> truckList = carThumbnailRepo.truckList();
		model.addAttribute("truckList",truckList);		
		
		List<CarThumbnail> allList = carThumbnailRepo.findAll();
		model.addAttribute("allList",allList);
		model.addAttribute("searchList",searchword);
	    System.out.println("써치워드 = "+searchword);
	    return "search";
	}
	
	
}
