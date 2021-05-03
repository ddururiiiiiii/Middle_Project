package kr.or.ddit.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.project.dao.IProjectDao;
import kr.or.ddit.project.dao.ProjectDaoImpl;
import kr.or.ddit.project.vo.ProjectVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class ProjectServiceImpl implements IProjectService{

	private IProjectDao projectDao;
	private SqlMapClient smc;
	
	private static IProjectService projectService;
	
	public ProjectServiceImpl() {
		projectDao = ProjectDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IProjectService getInstance() {
		if(projectService == null) {
			projectService = new ProjectServiceImpl();
		}
		return projectService;
	}

	@Override
	public List<ProjectVO> getAllProjectList() {
		List<ProjectVO> list = new ArrayList<>();
		try {
			list = projectDao.getAllProject(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProjectVO getProject(long pjNm) {
		ProjectVO pv = new ProjectVO();
		try {
			pv = projectDao.getProject(smc, pjNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pv;
	}
	
	@Override
	public long insertProject(ProjectVO pv) {
		long pjNm = 0;
		try {
			pjNm = projectDao.insertProject(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pjNm;
	}

	@Override
	public long updateProject(ProjectVO pv) {
		int cnt = 0;
		try {
			cnt = projectDao.updateProject(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteProject(ProjectVO pv) {
		int cnt = 0;
		try {
			cnt = projectDao.deleteProject(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<ProjectVO> searchProject(String pjNama) {
		List<ProjectVO> list = new ArrayList<>();
		
		try {
			list = projectDao.searchProject(smc, pjNama);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProjectVO> searchProjectSelect(String pjCategory) {
		List<ProjectVO> list = new ArrayList<>();
		
		try {
			list = projectDao.searchProjectSelect(smc, pjCategory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int getAllProjectListCount() {
		int cnt = 0;
		try {
			cnt = projectDao.getAllProjectListCount(smc);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int getDonation(ProjectVO pv) {
		int cnt = 0;
		try {
			cnt = projectDao.getDonation(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
