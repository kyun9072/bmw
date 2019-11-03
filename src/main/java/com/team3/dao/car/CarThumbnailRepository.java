/**
 * @author 박경민
 * 
 */
package com.team3.dao.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team3.vo.car.CarThumbnail;

@Repository
public interface CarThumbnailRepository extends JpaRepository<CarThumbnail, String> {
	@Query(value = "SELECT * FROM CAR_THUMBNAIL WHERE CAR_TYPE='eco'", nativeQuery = true)
	List<CarThumbnail> ecoList();	
	
	@Query(value = "SELECT * FROM CAR_THUMBNAIL WHERE CAR_TYPE='mid'", nativeQuery = true)
	List<CarThumbnail> midList();	
	
	@Query(value = "SELECT * FROM CAR_THUMBNAIL WHERE CAR_TYPE='flagship'", nativeQuery = true)
	List<CarThumbnail> flagList();	
	
	@Query(value = "SELECT * FROM CAR_THUMBNAIL WHERE CAR_TYPE='truck'", nativeQuery = true)
	List<CarThumbnail> truckList();	
}