/**
 * @author 나영균
 * 
 */
package com.team3.dao.guide;
import org.springframework.data.jpa.repository.JpaRepository;

import com.team3.vo.guide.card.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
