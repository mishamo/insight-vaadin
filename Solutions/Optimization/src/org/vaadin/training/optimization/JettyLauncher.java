package org.vaadin.training.optimization;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class JettyLauncher {
	public static void main(String args[]) throws Exception {
		Server server = new Server(8080);

		WebAppContext context = new WebAppContext();
		context.setContextPath("/Optimization");
		context.setResourceBase("WebContent");
		context.setClassLoader(Thread.currentThread().getContextClassLoader());

		server.setHandler(context);
		server.start();
		server.join();
	}
}
