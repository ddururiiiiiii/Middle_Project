package kr.or.ddit.boardComment.service;

import java.util.List;

import kr.or.ddit.boardComment.vo.FreeCmVO;
import kr.or.ddit.comm.vo.PagingVO;

public interface IFreeCmService {
	
	/**
	 * 자유 게시판 댓글 출력 메서드
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public List<FreeCmVO> getAllFreeCm(PagingVO pv);
	
	/**
	 * 자유 게시판 총 댓글 출력 메서드
	 * @return
	 */
	public int getAllFreeCmCount(String freeNm);
	
	/**
	 * 자유 게시판 댓글 작성 메서드
	 * @param fcv
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int insertFreeCm(FreeCmVO fcv);
	
	/**
	 * 자유 게시판 댓글 수정 메서드
	 * @param fcv
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateFreeCm(FreeCmVO fcv);
	
	/**
	 * 자유 게시판 댓글 삭제 메서드
	 * @param fcNm
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteFreeCm(FreeCmVO fcv);
	
}
