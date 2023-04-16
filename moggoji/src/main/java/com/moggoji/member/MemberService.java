package com.moggoji.member;

import com.moggoji.mail.MailDto;

public interface MemberService {
	
	MemberDto member_getInfo(MemberDto dto);
	int member_isDuplicate(MemberDto dto);
	void member_insert(MemberDto dto);
	MemberDto member_findId(MemberDto dto);
	MemberDto member_findPw(MemberDto dto);
	void update(MemberDto dto);
	MailDto createMailAndChangePassword(String memberEmail);
	void updatePassword(String str, String userEmail);
	String getTempPassword();
	void mailSend(MailDto mailDto);
	
	
}
