import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class MyServer {

  private Server server;

  public MyServer() throws Exception {
    ServletContainer servletContainer = new ServletContainer(new MyResourceConfig());
    ServletHolder servletHolder = new ServletHolder(servletContainer);
    ServletContextHandler servletContextHandler = new ServletContextHandler();
    servletContextHandler.setContextPath("/");
    servletContextHandler.addServlet(servletHolder, "/*");

    server = new Server(40000);

    HandlerCollection handlers = new HandlerCollection();
    handlers.addHandler(servletContextHandler);

    server.setHandler(handlers);
    server.start();
  }

  public static void main(String[] args) throws Exception {
    new MyServer();
  }
}
