package kr.or.ddit.boardComment.service;

import java.util.List;

import kr.or.ddit.boardComment.vo.NoticeCmVO;

public interface INoticeCmService {

	/**
	 * 공지사항 댓글 등록
	 * @param ncv
	 * @return 성공1 실패 0
	 */
	public int insertNoticeCm(NoticeCmVO ncv);
	
	/**
	 * 공지사항 댓글 조회
	 * @return 공지사항 댓글 List
	 */
	public List<NoticeCmVO> getNoticeCmListByNoticeNm(String noticNm);
	
	/**
	 * 공지사항 댓글 수정
	 * @param ncv
	 * @return 성공1 실패 0
	 */
	public int updateNoticeCm(NoticeCmVO ncv);
	
	/**
	 * 공지사항 댓글 삭제
	 * @param ncNm
	 * @return 성공1 실패 0
	 */
	public int deleteNoticeCm(NoticeCmVO ncv);
	
	
	
}
