import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.*;

import java.net.URL;
import java.util.Arrays;

public class KodiControlPanelServer {


    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

//        new Rebooter().reboot();

        URL classes = KodiControlPanelServer.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation();


        WebAppContext context = new WebAppContext();
        context.setResourceBase("/");
        context.getMetaData()
                .setWebInfClassesDirs(
                        Arrays.asList(Resource.newResource(classes)));
//        ServletContextHandler handler = new ServletContextHandler();
//        handler.addServlet(new ServletHolder(new ControlPanelServlet()));

        context.setConfigurations(new Configuration[]{
                new AnnotationConfiguration(), new WebXmlConfiguration(),
                new WebInfConfiguration(),
                new PlusConfiguration(), new MetaInfConfiguration(),
                new FragmentConfiguration(), new EnvConfiguration()});


        server.setHandler(context);
        server.start();
        server.join();
    }
}
