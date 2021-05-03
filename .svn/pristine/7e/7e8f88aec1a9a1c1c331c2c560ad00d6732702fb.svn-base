package kr.or.ddit.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.project.vo.ProjectOptionVO;

public interface IProjectOptionDao {
	
	/**
	 * 프로젝트 옵션목록을 보는 메서드
	 * @param smc
	 * @return List<ProjectVO>
	 * @throws SQLException
	 */
	public List<ProjectOptionVO> getAllProjectOption(SqlMapClient smc) throws SQLException;
	
	/**
	 * 프로젝트옵션을 확인하는 메서드
	 * @param smc, poNm
	 * @return List<ProjectVO>
	 * @throws SQLException
	 */
	public List<ProjectOptionVO> getProjectOption(SqlMapClient smc, ProjectOptionVO pov) throws SQLException;

	/**
	 * 프로젝트옵션 생성 메서드
	 * @param smc, pov
	 * @return int
	 * @throws SQLException
	 */
	public int insertProjectOption(SqlMapClient smc, ProjectOptionVO pov) throws SQLException;
	
	

	/**
	 * 게시글을 삭제하는 메서드
	 * @param smc, pov
	 * @return int
	 * @throws SQLException
	 */
	public int deleteProjectOption(SqlMapClient smc, ProjectOptionVO pov) throws SQLException;

}