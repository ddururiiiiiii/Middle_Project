package kr.or.ddit.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.project.dao.IProjectOptionDao;
import kr.or.ddit.project.dao.ProjectOptionDaoImpl;
import kr.or.ddit.project.vo.ProjectOptionVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class ProjectOptionServiceImpl implements IProjectOptionService{

	private IProjectOptionDao projectOptionDao;
	private SqlMapClient smc;
	
	private static IProjectOptionService projectOptionService;
	
	public ProjectOptionServiceImpl() {
		projectOptionDao = ProjectOptionDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IProjectOptionService getInstance() {
		if(projectOptionService == null) {
			projectOptionService = new ProjectOptionServiceImpl();
		}
		return projectOptionService;
	}

	@Override
	public List<ProjectOptionVO> getAllProjectOptionList() {
		List<ProjectOptionVO> list = new ArrayList<>();
		try {
			list = projectOptionDao.getAllProjectOption(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProjectOptionVO> getProjectOption(ProjectOptionVO pov) {
		List<ProjectOptionVO> list = new ArrayList<>();
		try {
			list = projectOptionDao.getProjectOption(smc, pov);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertProjectOption(ProjectOptionVO pov) {
		int cnt = 0;
		try {
			cnt = projectOptionDao.insertProjectOption(smc, pov);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public int deleteProjectOption(ProjectOptionVO pov) {
		int cnt = 0;
		try {
			cnt = projectOptionDao.deleteProjectOption(smc, pov);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
