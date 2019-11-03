/**
 * @author 나영균
 * 
 */
package com.team3.dao.brand.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.dao.brand.BrandRepository;
import com.team3.vo.brand.Brand;
@Service("brandService")
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository repository;

	@Override
	public Brand callBrand() {
		
		return repository.CallBrand();
	}


}
