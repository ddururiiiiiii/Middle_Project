package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.NoticeBoardVO;
import kr.or.ddit.comm.vo.PagingVO;


public interface INoticeService {
	
	/**
	 * 전체 공지사항 목록 조회 메서드
	 * @return 공지사항 정보를 담고있는 List
	 */
	public List<NoticeBoardVO> getAllNoticeBoard(PagingVO pv);
	
	/**
	 * 게시글 수 반환
	 * @return
	 */
	public int getNoticeBoardListCount();
	
	/**
	 * 공지사항 번호로 해당 공지사항 조회 
	 * @param noticeNm
	 * @return 해당 공지사항 정보
	 */
	public NoticeBoardVO getNoticeBoard(String noticNm);

	/**
	 * 공지사항 등록하는 메서드
	 * @param noticeVO
	 * @return 성공1 실패 0 반환
	 */
	public int insertNoticeBoard(NoticeBoardVO noticeVO);
		
	/**
	 * 공지사항 삭제하는 메서드
	 * @param notice_nm 삭제할 공지사항 번호
	 * @return 성공1 실패 0 반환
	 */
	public int deleteNoticeBoard(NoticeBoardVO noticeVO);
	
	/**
	 * 공지사항 수정 메서드
	 * @param nv
	 * @return 성공1 실패 0 반환
	 */
	public int updateNoticeBoard(NoticeBoardVO nv);
	
	/**
	 * 공지사항 검색 메서드
	 * @param nv
	 * @return 검색된 결과를 담은 List
	 */
	public List<NoticeBoardVO> getSearchNoticeBoardList(String noticeTitle);
	
	
}
