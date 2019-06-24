package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.AlbumDto;

public interface AlbumService {

	int writeArticle(AlbumDto albumDto);	// 글쓰기
	List<AlbumDto> listArticle(Map<String, String> parameter); // 글목록
	AlbumDto viewArticle(int seq); // 글보기(글번호)
	int modifyArticle(AlbumDto albumDto); // 글수정
	void deleteArticle(int seq); // 글삭제
	
}
