/**
 * @author 나영균
 * 
 */
package com.team3.dao.guide;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team3.vo.car.Common_Option;

public interface CommonOptionRepository extends JpaRepository<Common_Option, Integer> {

	@Query(value = "SELECT * FROM COMMON_OPTION WHERE CAR_SIZE = ?",nativeQuery = true)
	List<Common_Option> commonOption(String carSize);
}
