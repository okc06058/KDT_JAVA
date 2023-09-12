package com.ja.stm.handler;

import com.ja.stm.compoment.DataModel;
import com.ja.stm.dto.StudentDto;
import com.ja.stm.util.IoUtil;

public class StudentListHandler implements CommandHandler{
	
	private DataModel dataModel;
	
	public void AddStudentHandler(DataModel dataModel) {
		this.dataModel = dataModel;
	}
	
	public void doProcess() {
		IoUtil.println("학생 정보 리스트를 출력합니다.");
		
		//	int count = datamodel.getCount();
			StudentDto[] list = dataModel.getList();
		
			for (StudentDto studentDto : list) {
				//StudentDto studentDto = list[x];
				String text = "이름 : " + studentDto.getName();
				text += ", 나이: " + studentDto.getAge();  
				text += ", 점수: " + studentDto.getScore();  
		
				IoUtil.println(text);
			}
			IoUtil.println("총 학생 수 : "+list.length);
	}
	
}
