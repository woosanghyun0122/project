package com.moggoji.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	MemberDto member_getInfo(MemberDto dto);
	int member_isDuplicate(MemberDto dto);
	void member_insert(MemberDto dto);
	MemberDto member_findId(MemberDto dto);
	MemberDto member_findPw(MemberDto dto);
	void update(MemberDto dto);

}
