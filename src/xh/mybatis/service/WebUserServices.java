package xh.mybatis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import xh.mybatis.bean.UserBean;
import xh.mybatis.mapper.WebUserMapper;
import xh.mybatis.tools.MoreDbTools;

public class WebUserServices {
	
	/**
	 * 根据GameID判断该用户是否存在
	 * @return
	 */
	public static int exists_user(int GameID) {
		SqlSession sqlSession=MoreDbTools.getSession(MoreDbTools.DataSourceEnvironment.sqlServer);
		WebUserMapper mapper=sqlSession.getMapper(WebUserMapper.class);
		int count=-1;
		try {
			count=mapper.exists_user(GameID);
			sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  count;	
	}
	/**
	 * 修改用户的代理信息 
	 * @param root
	 * @return
	 */
	public static int update_user(int GameID) {
		SqlSession sqlSession=MoreDbTools.getSession(MoreDbTools.DataSourceEnvironment.sqlServer);
		WebUserMapper mapper=sqlSession.getMapper(WebUserMapper.class);
		int count=-1;
		try {
			count=mapper.update_user(GameID);
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  count;	
	}
	/**
	 * top20
	 * @param root
	 * @return
	 */
	public static List<UserBean> top_20() {
		SqlSession sqlSession=MoreDbTools.getSession(MoreDbTools.DataSourceEnvironment.sqlServer);
		WebUserMapper mapper=sqlSession.getMapper(WebUserMapper.class);
		List<UserBean> list=new ArrayList<UserBean>();
		try {
			list=mapper.top_20();
			sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
}
