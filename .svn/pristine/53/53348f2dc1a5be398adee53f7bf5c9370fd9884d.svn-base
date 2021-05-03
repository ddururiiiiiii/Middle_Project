package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.FreeBoardVO;
import kr.or.ddit.comm.vo.PagingVO;

public interface IFreeService {

	/**
	 * 자유 게시판 전체목록 조회 메서드
	 * @return List<FreeBoardVO>
	 */
	public List<FreeBoardVO> getAllFreeBoardList(PagingVO pv);
	
	/**
	 * 전체 게시글 수를 반환하는 메서드
	 * @return 전체 게시글 수
	 */
	public int getAllFreeBoardListCount();
	
	/**
	 * 자유 게시글 조회 메서드
	 * @return FreeBoardVO
	 */
	public FreeBoardVO getFreeBoard(FreeBoardVO fv);
	
	/**
	 * 자유 게시글 등록 메서드
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int insertFreeBoard(FreeBoardVO fv);
	
	/**
	 * 자유 게시글 수정 메서드
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateFreeBoard(FreeBoardVO fv);
	
	/**
	 * 자유 게시글 삭제 메서드
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteFreeBoard(FreeBoardVO fv);
	
	/**
	 * 자유 게시글 검색하는 메서드
	 * @param fv
	 * @return List<FreeBoardVO>
	 */
	public List<FreeBoardVO> searchFreeBoard(String str);
	
}
