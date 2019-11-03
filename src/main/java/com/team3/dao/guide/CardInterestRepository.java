/**
 * @author 나영균
 * 
 */
package com.team3.dao.guide;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team3.vo.guide.card.CardInterest;

public interface CardInterestRepository extends JpaRepository<CardInterest, Integer> {
	@Query(value = "SELECT * FROM CARD_INTEREST WHERE CODE = ? ORDER BY CARD_MONTH",nativeQuery = true)
	List<CardInterest> interest(String interest);
}
