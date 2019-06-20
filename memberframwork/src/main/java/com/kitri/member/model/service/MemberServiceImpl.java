package com.kitri.member.model.service;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDao;

@Repository
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public String idCheck(String id) {
		int cnt = memberDao.idCheck(id);
//		System.out.println("cnt : " + cnt);
		
//		String result = "";
//		result += "<idcount>\n";//루트엘리먼트만듦!
//		result += "	<cnt>" + cnt + "</cnt>\n";
//		result += "	<sid>" + cnt + "</sid>\n"; // 무슨 아이디는 사용하고있습니다 할때 사용할 수 있음!
//		result += "</idcount>"; 이부분을 json으로!!!!
		
		JSONObject json = new JSONObject();
		json.put("idcount", cnt);	
		
		return json.toString();	//{"idcount" : 0}
	}

	@Override
	public String zipSearch(String doro) {
		//String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

		List<ZipcodeDto> list = memberDao.zipSearch(doro);

		//		result += "<ziplist>";
//		for(ZipcodeDto zipDto : list) {
//			result += "	<zip>\n";	//우편번호 하나당!
//			result += "		<zipcode>"+zipDto.getZipcode()+"</zipcode>\n";
//			result += "		<address><![CDATA["+zipDto.getSido()+" "+zipDto.getGugun()+" " + zipDto.getUpmyon() +" " + zipDto.getDoro() + " "  + zipDto.getBuildingNumber() + " " + zipDto.getSigugunBuildingName()+"]]>></address>\n";
//			result += "	</zip>\n";
//		}
//		result += "</ziplist>";
	
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray(list);
		
//		JSONArray jarray = new JSONArray();
//		for(ZipcodeDto zipcodeDto : list) {
//			JSONObject	zipcode = new JSONObject(); // jsonobject 하나하나 만들기
//			zipcode.put("zipcode", zipcodeDto.getZipcode());
//			zipcode.put("address", zipcodeDto.getSido() + " " + 
//							zipcodeDto.getGugun() + " " + 
//							zipcodeDto.getUpmyon() + " " + 
//							zipcodeDto.getDoro()+ " " + 
//							zipcodeDto.getBuildingNumber()+ " " + 
//							zipcodeDto.getSigugunBuildingName());
//			jarray.put(zipcode);
//		}	// 배열이 만들어졌다!
		json.put("ziplist", jarray);	//아래있는 것이 만들어졌다!!
		//System.out.println(json.toString());
//		{"ziplist":[
//					{"zipcode":"08378","address":"서울특별시 구로구   디지털로34길 43 코오롱싸이언스밸리1차"},
//					{"zipcode":"08378","address":"서울특별시 구로구   디지털로34길 55 코오롱싸이언스밸리2차"}
//					]
//		}
		return json.toString();
	}

	@Override
	public int registerMember(MemberDetailDto memberdetailDto) {
		
		return memberDao.registerMember(memberdetailDto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		return memberDao.loginMember(map);
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
