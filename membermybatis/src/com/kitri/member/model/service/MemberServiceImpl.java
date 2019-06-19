package com.kitri.member.model.service;

import java.util.*;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	
	
	private static MemberService memberService; // 이거 안에서만 써야하고 통틀어서 하나만 만들어야한다!!
	
	static {
		memberService = new MemberServiceImpl();
	}
	
	private MemberServiceImpl() {}
	
	public static MemberService getMemberService() {
		return memberService;
	}														// 싱글톤 패턴!!!
	

	
	
	
	
	@Override
	public String idCheck(String id) {
		int cnt = MemberDaoImpl.getMemberDao().idCheck(id);
//		System.out.println("cnt : " + cnt);
		String result = "";
		result += "<idcount>\n";//루트엘리먼트만듦!
		result += "	<cnt>" + cnt + "</cnt>\n";
		result += "	<sid>" + cnt + "</sid>\n"; // 무슨 아이디는 사용하고있습니다 할때 사용할 수 있음!
		result += "</idcount>";
		return result;	// 컨트롤러로 넘어가야한다!
	}

	@Override
	public String zipSearch(String doro) {
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		List<ZipcodeDto> list = MemberDaoImpl.getMemberDao().zipSearch(doro);
		result += "<ziplist>";
		for(ZipcodeDto zipDto : list) {
			result += "	<zip>\n";	//우편번호 하나당!
			result += "		<zipcode>"+zipDto.getZipcode()+"</zipcode>\n";
			result += "		<address><![CDATA["+zipDto.getSido()+" "+zipDto.getGugun()+" " + zipDto.getUpmyon() +" " + zipDto.getDoro() + " "  + zipDto.getBuildingNumber() + " " + zipDto.getSigugunBuildingName()+"]]>></address>\n";
			result += "	</zip>\n";
		}
		result += "</ziplist>";
	
		return result;
	}

	@Override
	public int registerMember(MemberDetailDto memberdetailDto) {
		
		return MemberDaoImpl.getMemberDao().registerMember(memberdetailDto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		return MemberDaoImpl.getMemberDao().loginMember(map);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		
		return 0;
	}

	

}
