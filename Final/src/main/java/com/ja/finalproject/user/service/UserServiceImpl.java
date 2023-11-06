package com.ja.finalproject.user.service;

import java.util.List;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ja.finalproject.dto.HobbyCategoryDto;
import com.ja.finalproject.dto.MailAuthenticationDto;
import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.dto.UserHobbyDto;
import com.ja.finalproject.user.mapper.UserSqlMapper;

@Service
public class UserServiceImpl{
	
	@Autowired
	private JavaMailSender javaMailSender; 
	
	@Autowired
	private UserSqlMapper userSqlMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder; 
	
	
	public void register(UserDto userDto, int[] hobbyIdList) {
		// 2차: .... 암호화
		// 2차: 이메일 인증...
		
		//데이터 베이스에 입력
		//...
		int userPk = userSqlMapper.createUserPk();
		
		userDto.setId(userPk);
		
		// 비번 암호화
		String encodedPassword = passwordEncoder.encode(userDto.getPassword());
		userDto.setPassword(encodedPassword);
		
		userSqlMapper.insert(userDto);

		if(hobbyIdList != null) {
			for(int hobbyId : hobbyIdList) {
				UserHobbyDto userHobbyDto = new UserHobbyDto();
				userHobbyDto.setHobby_id(hobbyId);
				userHobbyDto.setUser_id(userPk);
				
				userSqlMapper.insertUserHobby(userHobbyDto);
			}
		}
		
		// 메일 보내기
		
		String authKey = UUID.randomUUID().toString();
		
		MailAuthenticationDto mailAuthenticationDto = new MailAuthenticationDto();
		mailAuthenticationDto.setUser_id(userPk);
		mailAuthenticationDto.setAuth_key(authKey);
		
		userSqlMapper.insertMailAuthentication(mailAuthenticationDto);

		// 쓰레드로 메일 전송(비동기식..)
		new MailSendThread(javaMailSender, userDto.getEmail(), authKey).start();
		
	}
	
	public UserDto getUserInfoByUserIdAndPassword(UserDto userDto){
		
		UserDto result = userSqlMapper.selectByUserId(userDto);
		
		if(result != null) {
			if(!passwordEncoder.matches(userDto.getPassword(), result.getPassword())) {
				return null;
			}
		}
		
		return result; 
	}

	public List<HobbyCategoryDto> getHobbyList(){
		return userSqlMapper.selectHobbyCategoryAll();
	}

	public void authenticateMail(String key) {
		userSqlMapper.updateMailAuthenticationByKey(key);		
	}
	
}

class MailSendThread extends Thread{
	
	private JavaMailSender javaMailSender;
	private String to;
	private String key;
	
	public MailSendThread(JavaMailSender javaMailSender, String to, String key) {
		super();
		this.javaMailSender = javaMailSender;
		this.to = to;
		this.key = key;
	}

	public void run() {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
			
			mimeMessageHelper.setSubject("[fp board]회원가입을 축하드립니다.");
			
			String text = "회원가입해 주셔서 감사합니다.<br>";
			text += "아래 링크를 클릭하셔서 인증을 완료해주시기 바랍니다.<br><br>";
			text += "<a href='http://localhost:8181/finalproject/user/mailAuthProcess?key="+key+"'>인증하기</a>";
			
			mimeMessageHelper.setText(text, true);
			mimeMessageHelper.setFrom("admin", "FP 관리자");
			mimeMessageHelper.setTo(to);
			
			javaMailSender.send(mimeMessage);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
}








