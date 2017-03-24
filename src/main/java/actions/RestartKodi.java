package actions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.ProcessBuilder.Redirect.PIPE;
import static java.lang.ProcessBuilder.Redirect.appendTo;

public class RestartKodi {
    public static InputStream restartKodi() throws IOException {
        return new ProcessBuilder()
                .command("sudo", "/usr/bin/service", "lightdm", "restart")
                .redirectErrorStream(true)
                .redirectOutput(appendTo(new File("ctrlpanel.log")))
                .redirectOutput(PIPE)
                .start()
                .getInputStream();

    }
}
