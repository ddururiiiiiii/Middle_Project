package kr.or.ddit.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.project.vo.ProjectOptionVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class ProjectOptionDaoImpl implements IProjectOptionDao {

	private static IProjectOptionDao projectOptionDao;
	
	public ProjectOptionDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static IProjectOptionDao getInstance() {
		if(projectOptionDao == null) {
			projectOptionDao = new ProjectOptionDaoImpl();
		}
		return projectOptionDao;
	}

	@Override
	public List<ProjectOptionVO> getAllProjectOption(SqlMapClient smc) throws SQLException {
		return smc.queryForList("projectOption.getAllProjectOption");
	}

	@Override
	public List<ProjectOptionVO> getProjectOption(SqlMapClient smc, ProjectOptionVO pov) throws SQLException {
		return smc.queryForList("projectOption.getProjectOption", pov);
	}

	@Override
	public int insertProjectOption(SqlMapClient smc, ProjectOptionVO pov) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("projectOption.insertProjectOption", pov);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}


	@Override
	public int deleteProjectOption(SqlMapClient smc, ProjectOptionVO pov) throws SQLException {
		return smc.delete("projectOption.deleteProjectOption", pov);
	}

}
