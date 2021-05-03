package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.FaqBoardVO;
import kr.or.ddit.comm.vo.PagingVO;



public interface IFaqService {

	/**
	 * 게시글 전체 조회
	 * @return List
	 */
	List<FaqBoardVO> getAllFaqBoard(PagingVO pagingVO);
	
	/**
	 * 게시글 조회
	 * @param faqNm
	 * @return 
	 */
	public FaqBoardVO getFaqBoard(String faqNm);
	
	
	/**
	 * 게시글 등록
	 * @param fbv
	 * @return 
	 */
	public int insertFaqBoard(FaqBoardVO fbv);
	

	/**
	 * 게시글 수정
	 * @param fbv
	 * @return
	 */
	public int updateFaqBoard(FaqBoardVO fbv);

	/**
	 * 게시글 삭제
	 * @param fbv
	 * @return
	 */
	public int deleteFaqBoard(FaqBoardVO fbv);
	
	/**
	 * 게시글 검색
	 * @param str
	 * @return
	 */
	public List<FaqBoardVO> searchFaqBoard(String faqTitle);

	/**
	 * 전체 faq 게시글 수 반환하는 메서드
	 * @return 전체 게시글 수 
	 */
	public int getAllFaqBoardListCount();

	
}
