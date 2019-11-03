/**
 * @author 나영균
 * 
 */
package com.team3.dao.guide;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team3.vo.guide.map.KoreaMap;

public interface KoreaMapRepository extends JpaRepository<KoreaMap, Integer> {
	@Query(value = "SELECT distinct cido FROM KOREA_MAP ORDER BY REGEXP_REPLACE(cido,'[ㄱ-ㅎ]')",nativeQuery = true)
	List<String> cido();
	@Query(value = "SELECT distinct cigungoo FROM KOREA_MAP WHERE CIDO=? ORDER BY REGEXP_REPLACE(cigungoo,'[ㄱ-ㅎ]')",nativeQuery = true)
	List<String> cigungoo(String cido);
	@Query(value = "SELECT eupmyundong FROM KOREA_MAP WHERE CIGUNGOO=? ORDER BY REGEXP_REPLACE(eupmyundong,'[ㄱ-ㅎ]')",nativeQuery = true)
	List<String> eupmyundong(String cigungoo);
	
}
