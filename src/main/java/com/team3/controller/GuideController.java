/**
 * @author 나영균
 * 
 */
package com.team3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.dao.car.CarThumbnailRepository;
import com.team3.dao.guide.service.GuideService;
import com.team3.vo.car.Add_Option;
import com.team3.vo.car.CarThumbnail;
import com.team3.vo.car.Common_Option;
import com.team3.vo.guide.card.Card;
import com.team3.vo.guide.card.CardInterest;


@Controller
public class GuideController {

	@Autowired
	private CarThumbnailRepository carThumbnailRepo;
	
	@Autowired
	private GuideService service;

	@RequestMapping("/repair")
	public String repair_info( Model model) {
		List<String> kmaps = service.cido();
		List<String> map = new ArrayList<String>();
		
		for(int i=0; i<kmaps.size(); i++) {
				map.add(kmaps.get(i));
			}
		model.addAttribute("map", map);
		List<CarThumbnail> carListMenu = carThumbnailRepo.findAll();
		model.addAttribute("carListMenu",carListMenu);
		
		return "support/repair_info";
	}
	@RequestMapping("/map")
	public String businessMap( Model model) {
		List<String> kmaps = service.cido();
		List<String> map = new ArrayList<String>();
		
		for(int i=0; i<kmaps.size(); i++) {
				map.add(kmaps.get(i));
			}
		model.addAttribute("map", map);
		
		List<CarThumbnail> ecoList = carThumbnailRepo.ecoList();
		model.addAttribute("ecoList",ecoList);
		
		List<CarThumbnail> midList = carThumbnailRepo.midList();
		model.addAttribute("midList",midList);
		
		List<CarThumbnail> flagList = carThumbnailRepo.flagList();
		model.addAttribute("flagList",flagList);
		
		List<CarThumbnail> truckList = carThumbnailRepo.truckList();
		model.addAttribute("truckList",truckList);
		
		
		return "guide/business_network";
	}

	@RequestMapping("/gungooSearch")
	@ResponseBody
	public List<String> gungooSearch(String cido){
	 List<String> cigungoos = service.cigungoo(cido);
	 List<String> name = new ArrayList<String>();
	 for(int i=0; i<cigungoos.size();i++) {
		 name.add(cigungoos.get(i));
	 }
	
		return name;
	}
	@RequestMapping("/upmyunSearch")
	@ResponseBody
	public List<String> upmyunSearch(String cigungoo){
		 List<String> eups = service.eupmyundong(cigungoo);
		 List<String> name = new ArrayList<String>();
		 for(int i=0; i<eups.size();i++) {
			 name.add(eups.get(i));
		 }
			return name;
		
	}
	
	@RequestMapping("/estimate")
	public String estimate(Model model) {
		List<Card> card = service.card();
		model.addAttribute("carList", service.carList());
		model.addAttribute("card", card);
		List<CarThumbnail> ecoList = carThumbnailRepo.ecoList();
		model.addAttribute("ecoList",ecoList);
		
		List<CarThumbnail> midList = carThumbnailRepo.midList();
		model.addAttribute("midList",midList);
		
		List<CarThumbnail> flagList = carThumbnailRepo.flagList();
		model.addAttribute("flagList",flagList);
		
		List<CarThumbnail> truckList = carThumbnailRepo.truckList();
		model.addAttribute("truckList",truckList);
		return "guide/estimate";
	}
	
	@RequestMapping("/model")
	@ResponseBody
	public String model3d(String carSize,Model model){
		String car=	service.model3d(carSize);		
			return car;
	}
	@RequestMapping("/common")
	@ResponseBody
	public ArrayList<Common_Option> commonOption(String carSize){
		ArrayList<Common_Option> ops =
				(ArrayList<Common_Option>) service.commonOption(carSize);
			return ops;
		
	}
	@RequestMapping("/add")
	@ResponseBody
	public ArrayList<Add_Option> addOption(String carSize,HttpServletResponse res){
		 ArrayList<Add_Option> ops =
				 (ArrayList<Add_Option>) service.addOption(carSize);
		 return ops;
	}
	@RequestMapping("/card")
	@ResponseBody
	public ArrayList<CardInterest> card(String card){
		System.out.println(card);
		ArrayList<CardInterest> ops = new ArrayList<CardInterest>();
		if(card.equals("카드사를 선택하세요")) {
			return ops;
		}
			ops =	(ArrayList<CardInterest>) service.interest(card);
			return ops;
		
	}
	
	@RequestMapping("/catalog")
	public String catalog(Model model) {
	
		model.addAttribute("ecoList",carThumbnailRepo.ecoList());
		
		model.addAttribute("midList",carThumbnailRepo.midList());
		
		model.addAttribute("flagList",carThumbnailRepo.flagList());
		
		model.addAttribute("truckList",carThumbnailRepo.truckList());		
		
		return "guide/catalog";
	}
	@RequestMapping("/viewCatalog")
	public String detailCatalog(Model model, CarThumbnail cat) {
	model.addAttribute("view", service.viewCatalog(cat.getDb_no()));
		return "/guide/viewCatalog";				
	}
	
	@RequestMapping("/reservation")
	public String getCarList(HttpSession session, Model model, CarThumbnail carThumbnail) {
		List<CarThumbnail> ecoList = carThumbnailRepo.ecoList();
		model.addAttribute("ecoList",ecoList);
		
		List<CarThumbnail> midList = carThumbnailRepo.midList();
		model.addAttribute("midList",midList);
		
		List<CarThumbnail> flagList = carThumbnailRepo.flagList();
		model.addAttribute("flagList",flagList);
		
		List<CarThumbnail> truckList = carThumbnailRepo.truckList();
		model.addAttribute("truckList",truckList);		
		
		model.addAttribute("carList", service.carList());
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("member", username);
		
		return "guide/ride_reservation";
	}

	
	
}

