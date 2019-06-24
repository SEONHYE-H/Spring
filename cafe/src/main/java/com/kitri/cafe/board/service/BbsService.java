package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.BbsDto;

public interface BbsService {	//자료실

	int writeArticle(BbsDto bbsDto);	// 글쓰기
	List<BbsDto> listArticle(Map<String, String> parameter); // 글목록
	BbsDto viewArticle(int seq); // 글보기(글번호)
	int modifyArticle(BbsDto bbsDto); // 글수정
	void deleteArticle(int seq); // 글삭제
	
}
