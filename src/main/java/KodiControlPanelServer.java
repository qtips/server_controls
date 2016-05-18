import java.io.IOException;

public class KodiControlPanelServer {


    public static void main(String[] args) throws IOException {
//    Server server = new Server(8080);

        new Rebooter().reboot();
    }
}
