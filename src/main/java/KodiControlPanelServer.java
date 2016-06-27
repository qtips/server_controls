import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

import java.net.URL;

public class KodiControlPanelServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(args.length == 0 ? 8080 : Integer.parseInt(args[0]));

        URL classes = KodiControlPanelServer.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation();

        WebAppContext webapp = new WebAppContext(classes.toExternalForm(), "");
        webapp.setConfigurations(new Configuration[]{
                new AnnotationConfiguration(),
                new WebXmlConfiguration(),
                new WebInfConfiguration(),
//                new PlusConfiguration(),
//                new MetaInfConfiguration(),
//                new FragmentConfiguration(),
//                  new EnvConfiguration()
        });

        server.setHandler(webapp);
        server.start();
        server.join();
    }
}
