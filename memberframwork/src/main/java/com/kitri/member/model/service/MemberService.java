package com.kitri.member.model.service;

import java.util.Map;

import com.kitri.member.model.*;

public interface MemberService {
	
	String idCheck(String id);	//int래...왜...?
	String zipSearch(String doro);
	int registerMember(MemberDetailDto memberdetailDto);
//	MemberDto loginMember(String id, String pass);
	MemberDto loginMember(Map<String, String> map);
	
	
//	여기부턴 내가
	MemberDetailDto getMember(String id);
	int modifyMember(MemberDetailDto memberDetailDto);
	int deleteMember(String id);
}
