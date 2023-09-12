package com.ja.stm.compoment;

import com.ja.stm.dto.StudentDto;
import com.ja.stm.util.IoUtil;

public class DataModel {
	private StudentDto[] studentList = new StudentDto[10];
	private int count;
	
	public void add(StudentDto studentDto) {
		studentList[count] = studentDto;
		count++;
		
		if(studentList.length >= count) {
			StudentDto[] newList = new StudentDto[studentList.length*2];
			
			for(int x = 0 ; x<count; x++) {
				newList[x]= studentList[x];
			}
			studentList = newList;
		}
	}
	
	public StudentDto[] getList() {
		
		StudentDto[] cloneList = new StudentDto[count];
		
		
		for(int x=0; x<count; x++) {
			//얕은 복사
			//cloneList[x] = studentList[x];
			
			//깊은 복사
			StudentDto newStudentDto = new StudentDto(
					studentList[x].getName(),
					studentList[x].getAge(),
					studentList[x].getScore()					
					);
			cloneList[x] = newStudentDto;
		}
		
		return cloneList;
	}
	
	public int remove(String name) {
		int removeCount = 0;
		
		for(int x=0; x<count; x++) {
			StudentDto studentDto = studentList[x]; 
			if(studentDto.getName().equals(name)) {
								
				for(int y=x; y<count-1; y++) {
					studentList[y] = studentList[y+1];
				}
				count--;
				x--;
				removeCount++;
			}
		}
				
		return removeCount;
	}
	
	public int getCount() {
		return count;
	}

}
