package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.CommunityBoardVO;
import kr.or.ddit.comm.vo.PagingVO;

public interface ICommunityService {
	
	/**
	 * 게시글 전체 조회
	 * @param pagingVO
	 * @return
	 */
	List<CommunityBoardVO> getAllCommunityBoardList();
	
	/**
	 * 한 프로젝트의 게시글 조회
	 * @param pjNm
	 * @return
	 */
	List<CommunityBoardVO> getPjCommunityBoard(String pjNm);
	
	/**
	 * 게시글 선택 조회
	 * @param cbNm
	 * @return
	 */
	public CommunityBoardVO getCommunityBoard(String cbNm);
	
	

	/**
	 * 게시글 등록
	 * @param cbv
	 * @return
	 */
	public int insertCommunityBoard(CommunityBoardVO cbv);
	


	/**
	 * 게시글 수정
	 * @param cbv
	 * @return
	 */
	public int updateCommunityBoard(CommunityBoardVO cbv);


	/**
	 * 게시글 삭제
	 * @param cbv
	 * @return
	 */
	public int deleteCommunityBoard(CommunityBoardVO cbv);
	

	/**
	 * 게시글 검색
	 * @param cbTitle
	 * @return
	 */
	public List<CommunityBoardVO> searchCommunityBoard(CommunityBoardVO cb);

	
	/**
	 * 게시글 전체 수
	 * @return
	 */
	public int getAllCommunityListCount();

}
