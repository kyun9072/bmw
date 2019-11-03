/**
 * @author 나영균,이성민
 *  메일 전송에 관련된 모든내용(인증메일보내기, 아이디찾기, 비밀번호 변경) 외 이성민작업.
 */
package com.team3.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.dao.UserRepository;
import com.team3.vo.Member;


@Controller
public class LoginController {
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	private JavaMailSender javaMailSender;
	private  StringBuffer temp = new StringBuffer();
	@Autowired
	private UserRepository userRepository;

	public void sendPass(String username) throws MessagingException {
		temp = null;
		temp = new StringBuffer();
		MimeMessage message = javaMailSender.createMimeMessage();
		message.setSubject("임시 비밀번호입니다.");
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(username));
		Random rnd = new Random();
		for (int i = 0; i < 8; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		message.setText(temp.toString());
		message.setSentDate(new Date());
		javaMailSender.send(message);
	}
	public void sendMail(String email) throws MessagingException {
		temp = null;
		temp = new StringBuffer();
		MimeMessage message = javaMailSender.createMimeMessage();
		message.setSubject("인증번호를 확인하세요.");
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {

			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		message.setText(temp.toString());
		message.setSentDate(new Date());
		javaMailSender.send(message);
	}


	@RequestMapping("/confirm")
	@ResponseBody
	public void confirm(String email, HttpServletResponse response) throws MessagingException, IOException {
		sendMail(email);
	}
	@RequestMapping("/num")
	@ResponseBody
	public boolean num(String num) {
		if(temp.toString().equals(num)&&num!="") {
			return true;
		}else
			return false;
	}

	@RequestMapping(value = "/modify",method = RequestMethod.GET)
	public String modify() {
		return "member/changePass";
	}
	@RequestMapping(value = "/changekPass",method = RequestMethod.POST)
	public String passCheck(Member member,HttpSession session) {
		userRepository.updatePass(bcryptPasswordEncoder.encode( member.getPassword()),member.getUsername());
		return "redirect:/";
	}
	@RequestMapping(value = "/searchId",method = RequestMethod.GET)
	public String searchId() {
		return "member/searchId";
	}
	@RequestMapping(value = "/resultSearch",method = RequestMethod.GET)
	public String searchIdSuc(Member member, Model model, HttpServletResponse res) {
		String page;

		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;

		String id = userRepository.findId(member.getName(), member.getEmail());
		if(id!=null) {
			model.addAttribute("id",id);
			page="member/resultSearch";
		}else {
			try {
				out = res.getWriter();
				out.println("<script>alert('이름과 이메일을 확인하세요');</script>");
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			page="member/searchId";
		}
		return page;
	}
	@RequestMapping(value = "/searchPass",method = RequestMethod.GET)
	public String searchPass() {
		return "member/searchPass";
	}
	@RequestMapping(value = "/searchPassSuc",method = RequestMethod.POST)
	public String searchPassSuc(Member member , HttpServletResponse res) throws IOException {
		String password,email;
		String page="";
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		if(userRepository.findByUsernameAndName(member.getName(), member.getUsername())!=null) {
			email= userRepository.findByUsernameAndName(member.getName(), member.getUsername());
			try {
				sendPass(email);
				System.out.println(temp.toString());
				password=bcryptPasswordEncoder.encode(temp.toString());
				userRepository.sendPass(password, email);
				out = res.getWriter();
				out.println("<script>alert('가입한 이메일로 임시 비밀번호를 전송하였습니다.');window.close();</script>");
				out.flush();
				return null;
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else {
			out = res.getWriter();
			out.println("<script>alert('이름과 이메일을 확인하세요');</script>");
			out.flush();
			page="member/searchPass";
		}
		return page;
	}
}