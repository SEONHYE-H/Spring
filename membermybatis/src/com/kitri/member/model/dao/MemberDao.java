package com.kitri.member.model.dao;

import java.util.List;
import java.util.Map;

import com.kitri.member.model.*;

public interface MemberDao {

		
		int idCheck(String id);
		List<ZipcodeDto> zipSearch(String doro);
		int registerMember(MemberDetailDto memberdetailDto);
		MemberDto loginMember(Map<String, String> map);
		
		
//		여기부턴 내가
		MemberDetailDto getMember(String id);
		int modifyMember(MemberDetailDto memberDetailDto);
		int deleteMember(String id);	
		
	
}
