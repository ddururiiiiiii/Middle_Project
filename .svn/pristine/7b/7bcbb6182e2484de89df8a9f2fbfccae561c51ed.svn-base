package kr.or.ddit.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.project.vo.ProjectVO;

public interface IProjectDao {
	
	/**
	 * 프로젝트 목록을 보는 메서드
	 * @param smc
	 * @return List<ProjectVO>
	 * @throws SQLException
	 */
	public List<ProjectVO> getAllProject(SqlMapClient smc) throws SQLException;
	
	/**
	 * 프로젝트를 확인하는 메서드
	 * @param smc, pv
	 * @return List<ProjectVO>
	 * @throws SQLException
	 */
	public ProjectVO getProject(SqlMapClient smc, long pjNm) throws SQLException;

	/**
	 * 프로젝트 생성 메서드
	 * @param smc, pv
	 * @return int
	 * @throws SQLException
	 */
	public long insertProject(SqlMapClient smc, ProjectVO pv) throws SQLException;
	
	/**
	 * 프로젝트를 수정하는 메서드
	 * @param smc, pv
	 * @return int
	 * @throws SQLException
	 */
	public int updateProject(SqlMapClient smc, ProjectVO pv) throws SQLException;
	
	/**
	 * 게시글을 삭제하는 메서드
	 * @param smc, pv
	 * @return int
	 * @throws SQLException
	 */
	public int deleteProject(SqlMapClient smc, ProjectVO pv) throws SQLException;
	
	/**
	 * 프로젝트 이름을 검색하는 메서드
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public List<ProjectVO> searchProject(SqlMapClient smc, String pjName) throws SQLException;

	/**
	 * 프로젝트 카테고리 검색
	 * @param smc
	 * @param pjCategory
	 * @return
	 * @throws SQLException
	 */
	public List<ProjectVO> searchProjectSelect(SqlMapClient smc, String pjCategory) throws SQLException;

	/**
	 * 전체 프로젝트 카운트
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public int getAllProjectListCount(SqlMapClient smc) throws SQLException;

	/**
	 * 후원이 들어오면 후원금 및 후원자 증가
	 * @param smc
	 * @param pv
	 * @return
	 * @throws SQLException
	 */
	public int getDonation(SqlMapClient smc, ProjectVO pv) throws SQLException;
	
}


