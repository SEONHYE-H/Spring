package com.kitri.cafe.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.ReboardDto;

public interface ReboardDao {

	int writeArticle(ReboardDto reboardDto);	// 글쓰기
	List<ReboardDto> listArticle(Map<String, String> parameter); // 글목록
	ReboardDto viewArticle(int seq); // 글보기(글번호)
	int modifyArticle(ReboardDto reboardDto); // 글수정
	void deleteArticle(int seq); // 글삭제
	
}
