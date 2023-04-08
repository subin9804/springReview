package org.koreait.controllers;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberSearch {
	

	@DateTimeFormat(pattern="yyyy-MM-dd")	// 문자열 Date -> 파싱되어 localDate 형식으로 변환
	private LocalDate sdate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate edate;
	
	
	public LocalDate getSdate() {
		return sdate;
	}
	public void setSdate(LocalDate sdate) {
		this.sdate = sdate;
	}
	public LocalDate getEdate() {
		return edate;
	}
	public void setEdate(LocalDate edate) {
		this.edate = edate;
	}
	
}
