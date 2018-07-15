package xh.org.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import xh.func.plugin.FunUtil;

public class TcpClientListenner implements ServletContextListener{

	 private String ip;
	 private int port;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
