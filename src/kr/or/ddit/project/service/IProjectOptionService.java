package kr.or.ddit.project.service;

import java.util.List;

import kr.or.ddit.project.vo.ProjectOptionVO;

public interface IProjectOptionService {

	/**
	 * 프로젝트 옵션 전체목록 조회 메서드
	 * @return List<ProjectOptionVO>
	 */
	public List<ProjectOptionVO> getAllProjectOptionList();
	
	/**
	 * 프로젝트 옵션 조회 메서드
	 * @return ProjectOptionVO
	 */
	public List<ProjectOptionVO> getProjectOption(ProjectOptionVO pov);
	
	/**
	 * 프로젝트 옵션 등록 메서드
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int insertProjectOption(ProjectOptionVO pov);
	
	/**
	 * QnA 게시글 삭제 메서드
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteProjectOption(ProjectOptionVO pov);

	/**
	 * 전체 프로젝트 수 반환하는 메서드
	 * @return 전체 프로젝트 수 
	 */
}
