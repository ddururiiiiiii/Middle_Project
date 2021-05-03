package kr.or.ddit.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.project.vo.ProjectVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class ProjectDaoImpl implements IProjectDao {

	private static IProjectDao projectDao;
	
	public ProjectDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static IProjectDao getInstance() {
		if(projectDao == null) {
			projectDao = new ProjectDaoImpl();
		}
		return projectDao;
	}

	@Override
	public List<ProjectVO> getAllProject(SqlMapClient smc) throws SQLException {
		return smc.queryForList("project.getAllProject");
	}

	@Override
	public ProjectVO getProject(SqlMapClient smc, long pjNm) throws SQLException {
		return (ProjectVO) smc.queryForObject("project.getProject", pjNm);
	}

	@Override
	public long insertProject(SqlMapClient smc, ProjectVO pv) throws SQLException {
		return (long)smc.insert("project.insertProject", pv);
	}

	@Override
	public int updateProject(SqlMapClient smc, ProjectVO pv) throws SQLException {
		return smc.update("project.updateProject", pv);
	}

	@Override
	public int deleteProject(SqlMapClient smc, ProjectVO pv) throws SQLException {
		return smc.delete("project.deleteProject", pv);
	}

	@Override
	public List<ProjectVO> searchProject(SqlMapClient smc, String pjName) throws SQLException {
		return smc.queryForList("project.searchProject", pjName);
	}
	
	@Override
	public List<ProjectVO> searchProjectSelect(SqlMapClient smc, String pjCategory) throws SQLException {
		return smc.queryForList("project.searchProjectSelect", pjCategory);
	}
	
	@Override
	public int getAllProjectListCount(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("project.getProjectAllCount");
		return cnt;
	}

	@Override
	public int getDonation(SqlMapClient smc, ProjectVO pv) throws SQLException {
		return smc.update("project.getDonation", pv);
	}
}
