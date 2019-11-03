package com.team3.dao.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.guide.CommonOptionRepository;
import com.team3.dao.guide.KoreaMapRepository;
import com.team3.dao.guide.AddOptionRepository;
import com.team3.dao.guide.CarRepository;
import com.team3.dao.guide.CardInterestRepository;
import com.team3.dao.guide.CardRepository;
import com.team3.vo.car.Add_Option;
import com.team3.vo.car.Car;
import com.team3.vo.car.Common_Option;
import com.team3.vo.guide.card.Card;
import com.team3.vo.guide.card.CardInterest;

@Service("guideService")
public class GuideServiceImpl implements GuideService {
	@Autowired
	private CarRepository cSize;
	@Autowired
	private CommonOptionRepository common;
	@Autowired
	private AddOptionRepository add;
	@Autowired
	private CardRepository card;
	@Autowired
	private CardInterestRepository cardIn;
	@Autowired
	private KoreaMapRepository kMap;
	
	
	@Override
	public List<Car> carList() {
		return cSize.findAll();
	}
	
	
	@Override
	public List<Common_Option> commonOption(String carSize) {
		// TODO Auto-generated method stub
		return common.commonOption(carSize);
	}
	@Override
	public List<Add_Option> addOption(String carSize) {
		// TODO Auto-generated method stub
		return add.addOption(carSize);
	}
	@Override
	public List<String> cido() {
		if(kMap.cido().isEmpty()) {
		return null;
		}
		return kMap.cido();
	}
	@Override
	public List<String> cigungoo(String cido) {
		// TODO Auto-generated method stub
		return kMap.cigungoo(cido);
	}
	@Override
	public List<String> eupmyundong(String cigungoo) {
		// TODO Auto-generated method stub
		return kMap.eupmyundong(cigungoo);
	}
	@Override
	public List<Card> card() {
		// TODO Auto-generated method stub
		return card.findAll();
	}
	@Override
	public List<CardInterest> interest(String interest) {
		// TODO Auto-generated method stub
		return cardIn.interest(interest);
	}
	@Override
	public String model3d(String carSize) {
		// TODO Auto-generated method stub
		return cSize.model3d(carSize);
	}
	@Override
	public List<Car> detailCar(int dbno) {
		// TODO Auto-generated method stub
		return cSize.detailCar(dbno);
	}

	@Override
	public String viewCatalog(int dbno) {
		// TODO Auto-generated method stub
		return cSize.viewCatalog(dbno);
	}



}
