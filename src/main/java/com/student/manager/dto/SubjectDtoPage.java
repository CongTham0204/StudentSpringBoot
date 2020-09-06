package com.student.manager.dto;

import java.util.List;

public class SubjectDtoPage {
	private int totalPage;
	private List<SubjectDto> subjectDtos;

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<SubjectDto> getSubjectDtos() {
		return subjectDtos;
	}

	public void setSubjectDtos(List<SubjectDto> subjectDtos) {
		this.subjectDtos = subjectDtos;
	}

}
