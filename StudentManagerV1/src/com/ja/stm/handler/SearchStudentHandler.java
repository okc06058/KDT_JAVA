package com.ja.stm.handler;

import com.ja.stm.compoment.DataModel;
import com.ja.stm.dto.StudentDto;
import com.ja.stm.util.IoUtil;

public class SearchStudentHandler implements CommandHandler{

	private DataModel dataModel;
	
	public void AddStudentHandler(DataModel dataModel) {
		this.dataModel = dataModel;
	}
	public void doProcess() {
		IoUtil.println("학생 검색을 시작합니다.");
		String search = IoUtil.input("검색할 학생 이름 입력 > ");
		
		StudentDto[] list = dataModel.getList();
		int searchCount = 0;
		for (StudentDto studentDto : list) {
			if (!studentDto.getName().contains(search)) continue;
			String text = "이름 : " + studentDto.getName();
			text += ", 나이: " + studentDto.getAge();  
			text += ", 점수: " + studentDto.getScore();  
	
			IoUtil.println(text);
			searchCount++;
		}
		IoUtil.println("검색된 학생 수 : " + searchCount);
	}
}
