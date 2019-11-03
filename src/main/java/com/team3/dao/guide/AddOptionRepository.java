/**
 * @author 나영균
 * 
 */
package com.team3.dao.guide;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team3.vo.car.Add_Option;

public interface AddOptionRepository extends JpaRepository<Add_Option, Integer> {
	@Query(value = "SELECT * FROM ADD_OPTION WHERE CAR_SIZE = ?",nativeQuery = true)
	List<Add_Option> addOption(String carSize);
}
