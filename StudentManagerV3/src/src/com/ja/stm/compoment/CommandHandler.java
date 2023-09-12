package com.ja.stm.compoment;

import org.w3c.dom.Text;

import com.ja.stm.dto.StudentDto;
import com.ja.stm.util.IoUtil;

public class CommandHandler {
	
	private DataModel datamodel = new DataModel();
	
	public void addStudent() {
		IoUtil.println("학생 정보 등록을 시작합니다.");
		String name = IoUtil.input("학생 이름 입력 > ");
		int age = Integer.parseInt(IoUtil.input("학생 나이 입력 > "));
		int score = Integer.parseInt(IoUtil.input("학생 성적 입력 > "));
	
		StudentDto student = new StudentDto(name,age,score);
		datamodel.add(student);
		
		IoUtil.println("학생 정보 등록이 완료 되었습니다.");
	}
	
	public void printStudentList() {
		IoUtil.println("학생 정보 리스트를 출력합니다.");
		
	//	int count = datamodel.getCount();
		StudentDto[] list = datamodel.getList();
	
		for (StudentDto studentDto : list) {
			//StudentDto studentDto = list[x];
			String text = "이름 : " + studentDto.getName();
			text += ", 나이: " + studentDto.getAge();  
			text += ", 점수: " + studentDto.getScore();  
	
			IoUtil.println(text);
		}
		IoUtil.println("총 학생 수 : "+list.length);
	}

	public void searchStudent() {
		IoUtil.println("학생 검색을 시작합니다.");
		String search = IoUtil.input("검색할 학생 이름 입력 > ");
		
		StudentDto[] list = datamodel.getList();
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
	public void deleteStudent() {
		IoUtil.println("학생 정보 삭제를 시작합니다.");
		String delete = IoUtil.input("삭제할 학생의 이름 > ");
		
		int count = datamodel.remove(delete);
		IoUtil.println(count+"명의 학생 정보가 삭제 되었습니다.");
	}
	public void printStateustucs() {
	
		IoUtil.println("학생 정보 통계");
		StudentDto[] list = datamodel.getList();
		
		int sum = 0;
		for(StudentDto studentDto : list) {
			sum += studentDto.getScore();
		}
		double average = sum/(double)list.length;

		IoUtil.println("총 인원 : " + list.length);
		IoUtil.println("평균 : " + average);
	}
}
