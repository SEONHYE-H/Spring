package com.kitri.cafe.admin.board.dao;

import java.util.List;

import com.kitri.cafe.admin.board.model.BoardListDto;
import com.kitri.cafe.admin.board.model.BoardTypeDto;
import com.kitri.cafe.admin.board.model.CategoryDto;

public interface BoardAdminDao {	// 할일 : 게시판 리스트 얻어오기

	List<BoardListDto> getBoardMenu(int ccode);//왼쪽 메뉴(전체) BoardListDto : 게시판 이름 가지고있는것	// 0번이면 전체!
	//List<BoardTypeDto> getBoardMenuList(int ccode);	//목록들 보여주기	(해당카테고리)(카테고리코드)
	
	List<CategoryDto> getCategoryList();//카테고리 목록
	void makeCategory(CategoryDto categoryDto);					//카테고리 만들기
	
	List<BoardTypeDto> getBoardTypeList();			//게시판 형식
	void makeBoard(BoardListDto boardListDto);
	
	
	
}
