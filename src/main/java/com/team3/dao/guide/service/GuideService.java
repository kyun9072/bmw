/**
 * @author 나영균
 * 
 */
package com.team3.dao.guide.service;

import java.util.List;

import com.team3.vo.car.Add_Option;
import com.team3.vo.car.Car;
import com.team3.vo.car.Common_Option;
import com.team3.vo.guide.card.Card;
import com.team3.vo.guide.card.CardInterest;


public interface GuideService {
	List<String> cido();
	List<String> cigungoo(String cido);
	List<String> eupmyundong(String cigungoo);
	String model3d(String carSize);
	List<Car> carList();
	List<Common_Option> commonOption(String carSize);
	List<Add_Option> addOption(String carSize);
	List<Card> card();
	List<CardInterest> interest(String interest);
	List<Car> detailCar(int dbno);
	String viewCatalog(int dbno);
}
