package com.ja.stm.handler;

import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

import com.ja.stm.compoment.DataModel;
import com.ja.stm.dto.StudentDto;
import com.ja.stm.util.IoUtil;

public class StatisticsHandler implements CommeandHandcler {
	private DataModel dataModel;
	
	public void AddStudentHandler(DataModel dataModel) {
		this.dataModel = dataModel;
	}
	public void doProcess() {
		IoUtil.println("학생 정보 통계");
		StudentDto[] list = dataModel.getList();
		
		int sum = 0;
		for(StudentDto studentDto : list) {
			sum += studentDto.getScore();
		}
		double average = sum/(double)list.length;

		IoUtil.println("총 인원 : " + list.length);
		IoUtil.println("평균 : " + average);
	}
}

