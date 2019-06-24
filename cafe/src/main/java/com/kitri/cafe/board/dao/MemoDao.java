package com.kitri.cafe.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.MemoDto;

public interface MemoDao {

	int writeArticle(MemoDto memoDto);	// 글쓰기
	List<MemoDto> listArticle(Map<String, String> parameter); // 글목록
	MemoDto viewArticle(int seq); // 글보기(글번호)
	int modifyArticle(MemoDto memoDto); // 글수정
	void deleteArticle(int seq); // 글삭제
	
}
