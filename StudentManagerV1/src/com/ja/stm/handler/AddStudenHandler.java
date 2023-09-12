package com.ja.stm.handler;

import com.ja.stm.compoment.DataModel;
import com.ja.stm.dto.StudentDto;
import com.ja.stm.util.IoUtil;

public class AddStudenHandler implements CommandHandler {
	
	private DataModel dataModel;
	
	public void AddStudentHandler(DataModel dataModel) {
		this.dataModel = dataModel;
	}
	
	public void doProcess() {
		IoUtil.println("학생 정보 등록을 시작합니다.");
		String name = IoUtil.input("학생 이름 입력 > ");
		int age = Integer.parseInt(IoUtil.input("학생 나이 입력 > "));
		int score = Integer.parseInt(IoUtil.input("학생 성적 입력 > "));
	
		StudentDto student = new StudentDto(name,age,score);
		dataModel.add(student);
		
		IoUtil.println("학생 정보 등록이 완료 되었습니다.");
	}

}
