package xh.mybatis.tools;

import java.io.IOException;
import java.io.InputStream;
import java.net.NoRouteToHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.util.IOUtils;
import org.springframework.util.ObjectUtils;

import com.microsoft.sqlserver.jdbc.SQLServerException;


public class MoreDbTools {
	private static final String CONFIGURATION_PATH = "mybatis.cfg.xml";  
	protected static final Log logger = LogFactory.getLog(MoreDbTools.class);
    private static final Map<DataSourceEnvironment, SqlSessionFactory> SQLSESSIONFACTORYS   
        = new HashMap<DataSourceEnvironment, SqlSessionFactory>();  
      
    /** 
     * 根据指定的DataSourceEnvironment获取对应的SqlSessionFactory 
     * @param environment 数据源environment 
     * @return SqlSessionFactory 
     */  
    public static SqlSessionFactory getSqlSessionFactory(DataSourceEnvironment environment) {  
          
        SqlSessionFactory sqlSessionFactory = SQLSESSIONFACTORYS.get(environment); 
      
       
        if (!ObjectUtils.isEmpty(sqlSessionFactory))  
            return sqlSessionFactory;  
        else {  
            InputStream inputStream = null;  
            try {  
                inputStream = Resources.getResourceAsStream(CONFIGURATION_PATH);  
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, environment.name());  
                  
                logger.info("Get {"+environment.name()+"} SqlSessionFactory successfully.");  
            }catch(NoRouteToHostException e){
    			logger.info("到主机的TCP/IP连接失败");
    		} catch(PersistenceException e){
    			logger.info("数据库连接失败");
    		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            finally {  
                IOUtils.closeQuietly(inputStream);  
            }  
              
            SQLSESSIONFACTORYS.put(environment, sqlSessionFactory);  
            return sqlSessionFactory;  
        } 
     	
        
    }  
      
    /**
     * 配置到mybatis.cfg.xml文件中的数据源的environment的枚举描述  
     * @author muwei
     *
     */
    public static enum DataSourceEnvironment {  
        master,  
        slave,
        gps_voice_master,
        gps_voice_slave,
        emh,
        sqlServer,
        mysqlDb,
        sf800M,
        eastcom;  
    } 
    /**
     * 创建能执行映射文件中sql的sqlSession
     * @return
     */
    
    public static SqlSession getSession(DataSourceEnvironment environment){
    	if (environment.toString().isEmpty()) {
    		return getSqlSessionFactory(DataSourceEnvironment.master).openSession();
		}
        return getSqlSessionFactory(environment).openSession();
    }
}
