package xh.mybatis.mapper;

import java.util.List;

import xh.mybatis.bean.UserBean;

public interface WebUserMapper {
	/**
	 * 根据GameID判断该用户是否存在
	 * @return
	 * @throws Exception
	 */
	public int exists_user(int GameID)throws Exception;
	/**
	 *修改用户的代理信息 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int update_user(int GameID)throws Exception;
	/*top10*/
	public List<UserBean> top_20()throws Exception;
}
