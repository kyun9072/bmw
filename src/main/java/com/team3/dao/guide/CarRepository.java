/**
 * @author 나영균
 * 
 */
package com.team3.dao.guide;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team3.vo.car.Car;

public interface CarRepository extends JpaRepository<Car, String> {
	@Query(value = "SELECT model3d FROM CAR WHERE CAR_MODEL = ?",nativeQuery = true)
	String model3d(String carSize);
	//카에 대한 모든것
	@Query(value = "SELECT  * FROM CAR WHERE db_no = ? ",nativeQuery = true)
	List<Car> detailCar(int dbno);
	@Query(value = "SELECT  catalog FROM CAR WHERE db_no = ? and rownum=1",nativeQuery = true)
	String viewCatalog(int dbno);
}
