package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;


import com.kitri.cafe.board.model.MemoDto;

public interface MemoService {
	
	void writeMemo(MemoDto memoDto);	// 글쓰기
	List<MemoDto> listMemo(Map<String, String> parameter); // 글목록  || 포함되는 글번호
	void modifyMemo(MemoDto memoDto); // 글수정
	void deleteMemo(int mseq); // 글삭제 || 메모글의 글번호
	
}
