package com.dteam.app.dto;

import java.sql.Date;

public class MemberDto {
    String member_id;
    String member_pw;
    String member_nickname;
    String member_tel;
    String member_addr;
    String member_latitude;
    String member_longitude;
    int member_grade;
    String member_name;

    // ȸ������ �� �����ͺ��̽��� ��� ������ �߰��� ��
    public MemberDto(String member_id, String member_pw, String member_nickname, String member_tel, String member_addr,
			String member_latitude, String member_longitude, int member_grade, String member_name) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_nickname = member_nickname;
		this.member_tel = member_tel;
		this.member_addr = member_addr;
		this.member_latitude = member_latitude;
		this.member_longitude = member_longitude;
		this.member_grade = member_grade;
		this.member_name = member_name;
	}

    
    // ��ȣ ���� ��� ������ ������ ��
    public MemberDto(String member_id, String member_nickname,
                     String member_tel, String member_addr, String member_latitude,
                     String member_longitude, int member_grade, String member_name) {
        this.member_id = member_id;
        this.member_nickname = member_nickname;
        this.member_tel = member_tel;
        this.member_addr = member_addr;
        this.member_latitude = member_latitude;
        this.member_longitude = member_longitude;
        this.member_grade = member_grade;
        this.member_name = member_name;
    }

	public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public String getMember_nickname() {
        return member_nickname;
    }

    public void setMember_nickname(String member_nickname) {
        this.member_nickname = member_nickname;
    }

    public String getMember_tel() {
        return member_tel;
    }

    public void setMember_tel(String member_tel) {
        this.member_tel = member_tel;
    }

    public String getMember_addr() {
        return member_addr;
    }

    public void setMember_addr(String member_addr) {
        this.member_addr = member_addr;
    }

    public String getMember_latitude() {
        return member_latitude;
    }

    public void setMember_latitude(String member_latitude) {
        this.member_latitude = member_latitude;
    }

    public String getMember_longitude() {
        return member_longitude;
    }

    public void setMember_longitude(String member_longitude) {
        this.member_longitude = member_longitude;
    }

    public int getMember_grade() {
        return member_grade;
    }

    public void setMember_grade(int member_grade) {
        this.member_grade = member_grade;
    }
}