import java.io.File;
import java.io.IOException;

import static java.lang.ProcessBuilder.Redirect.appendTo;

public class Rebooter {

    public void reboot() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("sudo", "/sbin/shutdown", "-r", "now");
        processBuilder.redirectErrorStream(true);
        processBuilder.redirectOutput(appendTo(new File("ctrlpanel.log")));
        processBuilder.start();
    }

}
