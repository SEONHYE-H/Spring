package com.kitri.member.model.dao;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.kitri.member.model.*;
import com.kitri.sqlmap.MyBatisConfiguration;


public class MemberDaoImpl implements MemberDao {

	private final String NAME_SPACE = "com.kitri.member.model.dao.MemberDao";
	
	private static MemberDao memberDao; 	//2
	
	static {
		memberDao = new MemberDaoImpl();	//3
	}
	
	private MemberDaoImpl () {} 			//1
	
	public static MemberDao getMemberDao() {//4
		return memberDao;
	}

	@Override
	public int idCheck(String id) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE + ".idcheck", id);	// member.xml에 설정해준걸 사용한다.
		}finally{
			session.close();
		}
	}

	@Override
	public List<ZipcodeDto> zipSearch(String doro) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectList(NAME_SPACE + ".zipSearch", doro);	// member.xml에 설정해준걸 사용한다.
		}finally{
			session.close();
		}
	}

	@Override
	public int registerMember(MemberDetailDto memberdetailDto) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			session.insert(NAME_SPACE + ".registerMember", memberdetailDto);	// member.xml에 설정해준걸 사용한다.
			session.commit();	// 커밋을 안해줘서 회원가입 성공은 했지만 DB에 저장은 안됐음
			return 1;
		}finally{
			session.close();
		}
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		try {
			return session.selectOne(NAME_SPACE + ".loginMember", map);	// member.xml에 설정해준걸 사용한다.
		}finally{
			session.close();
		}
	}

	@Override
	public MemberDetailDto getMember(String id) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		SqlSession session = MyBatisConfiguration.getSqlSessionFactory().openSession();
		return 0;
	}										
}
