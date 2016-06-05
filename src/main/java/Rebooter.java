import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.ProcessBuilder.Redirect.PIPE;
import static java.lang.ProcessBuilder.Redirect.appendTo;

public class Rebooter {

    public static InputStream reboot() throws IOException {
        return new ProcessBuilder()
                .command("sudo", "/sbin/shutdown", "-r", "now")
                .redirectErrorStream(true)
                .redirectOutput(appendTo(new File("ctrlpanel.log")))
                .redirectOutput(PIPE)
                .start()
                .getInputStream();

    }

}
