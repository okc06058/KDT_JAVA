package com.ja.stm.compoment;

import java.io.IOError;
import java.security.PublicKey;

import com.ja.stm.util.IoUtil;

public class Wrapper {
	
	private CommandHandler commandHandler = new CommandHandler();
	
	public void run() {
		printWelcomeMessage();
		while(true) {
			printCommandMenu();
			String input = IoUtil.input("입력 > ");
			
			if(input.equals("q")) break;
			
			CommandHandler commandHandler = null;
			commandHandler.doprocess();
			
			
			IoUtil.pause();
		}
		
		printByeMessage();
	}
	
	private void printCommandMenu() {
		IoUtil.println("1. 정보 입력");
		IoUtil.println("2. 리스트 출력");
		IoUtil.println("3. 정보 검색");
		IoUtil.println("4. 정보 삭제");
		IoUtil.println("5. 정보 통계");
		IoUtil.println("q. 종료");
	}
	
	private void printWelcomeMessage() {
		IoUtil.println("**************************");
		IoUtil.println("*  학생 정보 관리 프로그램 V1  *");
		IoUtil.println("**************************");
	}
	
	private void printByeMessage() {
		IoUtil.println("종료");
	}
	
}
