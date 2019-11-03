/**
 * @author 나영균,이성민
 *  메일전송에 관련된 내용(아이디찾기, 임시비밀번호 전송, 비밀번호 변경) 외 이성민 작업
 */
package com.team3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team3.vo.Member;

@Repository
public interface UserRepository extends JpaRepository<Member, String> {
	@Query(value = "select password from member where username = ?", nativeQuery = true)
	String checkPass(String username);
	@Query(value = "select email from member where email = ?", nativeQuery = true)
	String findemail(String email);
	@Query(value = "select phone from member where username = ?", nativeQuery = true)
	String findphone(String username);
	@Query(value = "select phone from member where email = ?", nativeQuery = true)
	String findphone2(String email);
	@Query(value = "select email from member where name = ? and username = ?",nativeQuery = true)
	String findByUsernameAndName(String name, String username);
	@Query(value = "select username from member where name = ? and email = ?",nativeQuery = true)
	String findId(String name, String email);
	@Modifying
	@Transactional
//	@Query(value = "update member set memeber.username = ?,memeber.b_day = ?,memeber.b_month = ?,memeber.b_year = ?,memeber.name = ?,memeber.password = ?,memeber.phone = ? where member.email = ?", nativeQuery = true)
	@Query(value = "update member set username = ? , password = ? , name = ? , phone = ? , b_day = ? , b_month = ? , b_year = ? where email = ?", nativeQuery = true)
	void update(String username, String password, String name, String phone, int b_day, int b_month, int b_year, 
			String email);
	@Modifying
	@Transactional
	@Query(value = "update member set password = ? where email = ?", nativeQuery = true)
	void sendPass(String email,String password);
	@Modifying
	@Transactional
	@Query(value = "update member set password = ? where username = ?", nativeQuery = true)
	void updatePass(String username,String password);
	
	@Query(value = "SELECT CASE WHEN MAX(email) IS NULL THEN 'true' ELSE 'false' END email FROM member WHERE email = ?",nativeQuery = true)
	boolean checkemail(String email);
	
	@Query(value = "select username from member where email = ?", nativeQuery = true)
	String findusername(String email);
}
