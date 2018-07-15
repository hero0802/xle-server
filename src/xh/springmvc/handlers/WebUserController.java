package xh.springmvc.handlers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xh.func.plugin.FlexJSON;
import xh.func.plugin.FunUtil;
import xh.mybatis.bean.UserBean;
import xh.mybatis.service.WebUserServices;

@Controller
public class WebUserController {
	private boolean success;
	private String message;
	private FunUtil funUtil=new FunUtil();
	protected final Log log = LogFactory.getLog(WebUserController.class);
	public static int User_RG_Count=0;
	private FlexJSON json=new FlexJSON();
	
	
	/**
	 * 绑定用户
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/user/regUser",method=RequestMethod.GET)
	public void regUser(HttpServletRequest request, HttpServletResponse response){
		int resultCode=-1;
		String msg="";
		
		try {
			int GameID=funUtil.StringToInt(request.getParameter("GameID"));
			log.info("GameID="+GameID);
			resultCode=WebUserServices.exists_user(GameID);
			if(resultCode>0){
				resultCode=WebUserServices.update_user(GameID);
				if(resultCode>0){
					resultCode=1;
					msg="用户绑定成功";
					User_RG_Count++;
				}else{
					resultCode=2;
					msg="绑定用户失败";
				}
			}else if(resultCode==0){
				resultCode=0;
				msg="该用户不存在,或者已经被其他绑定";
			}else{
				resultCode=-1;
				msg="参数非法";
			}
			
			HashMap result = new HashMap();
			result.put("resultCode", resultCode);
			result.put("msg",msg);
			response.setContentType("application/json;charset=utf-8");
			String jsonstr = json.Encode(result);
			log.info("==================绑定用户=======================");
			log.info("当前绑定用户数："+User_RG_Count);
			log.info("GameID="+GameID);
			log.info(result);
			log.info("===================/绑定用户======================");
			response.getWriter().write(jsonstr);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("绑定用户失败!"+e);
			e.printStackTrace();
		}
	}
	/**
	 * 绑定用户
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/user/userTop20",method=RequestMethod.GET)
	public void userTop20(HttpServletRequest request, HttpServletResponse response){
		try {
			List<UserBean> list=WebUserServices.top_20();	    		
			HashMap result = new HashMap();
			result.put("totals", list.size());
			result.put("items", list);
			response.setContentType("application/json;charset=utf-8");
			String jsonstr = json.Encode(result);
			log.info("==================获取TOP20=======================");
			log.info(result.toString());
			log.info("===================/获取TOP20======================");
			response.getWriter().write(jsonstr);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("获取TOP20失败!"+e);
		}
	
	
}
	
	
}
