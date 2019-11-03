/**
 * @author 나영균
 * 
 */
package com.team3.dao.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team3.vo.brand.Brand;

public interface BrandRepository extends JpaRepository<Brand, String> {
	
	@Query(value = "SELECT history,brandinfo,factoryinfo FROM BRAND",nativeQuery = true) 
	Brand CallBrand();
}
