package com.moggoji.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {
	
	private String m_id;
	private String login_id;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	private String address;
	private String date;
	
	
	public MemberDto() {
		super();
		
	}


	@Override
	public String toString() {
		return "MemberDto [m_id=" + m_id + ", login_id=" + login_id + ", password=" + password + ", name=" + name
				+ ", nickname=" + nickname + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", date=" + date + "]";
	}
	
	
	
	

}
