package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.QnaBoardVO;
import kr.or.ddit.boardComment.vo.QnaCmVO;
import kr.or.ddit.comm.vo.PagingVO;

public interface IQnaService {

	/**
	 * QnA 게시판 전체목록 조회 메서드
	 * @return List<QnaBoardVO>
	 */
	public List<QnaBoardVO> getAllQnaBoardList(PagingVO pv);
	
	/**
	 * QnA 게시판 글 수를 반환하는 메서드
	 * @return
	 */
	public int getAllQnaBoardListCount();
	
	/**
	 * QnA 게시글 조회 메서드
	 * @return QnaBoardVO
	 */
	public QnaBoardVO getQnaBoard(String qnaNm);
	
	/**
	 * QnA 게시글 등록 메서드
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int insertQnaBoard(QnaBoardVO qbv);
	
	/**
	 * QnA 게시글 수정 메서드
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateQnaBoard(QnaBoardVO qbv);
	
	/**
	 * QnA 게시글 삭제 메서드
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteQnaBoard(QnaBoardVO qbv);
	
	/**
	 * QnA 게시글 검색하는 메서드
	 * @param qbv
	 * @return List<QnaBoardVO>
	 */
	public List<QnaBoardVO> searchQnaBoard(String str);
	
}
