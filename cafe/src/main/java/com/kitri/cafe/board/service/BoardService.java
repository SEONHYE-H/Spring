package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.BoardDto;

public interface BoardService {
	
	int writeArticle(BoardDto boardDto);	// 글쓰기
	List<BoardDto> listArticle(Map<String, String> parameter); // 글목록
	BoardDto viewArticle(int seq); // 글보기(글번호)
	int modifyArticle(BoardDto boardDto); // 글수정
	void deleteArticle(int seq); // 글삭제
}
