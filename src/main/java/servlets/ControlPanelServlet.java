package servlets;

import actions.Rebooter;
import actions.RestartKodi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet({ControlPanelServlet.RESTART_PATH, ControlPanelServlet.REBOOT_PATH})
public class ControlPanelServlet extends HttpServlet {

    public static final String RESTART_PATH = "/restart";
    public static final String REBOOT_PATH = "/reboot";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();
        responseWriter.println("utfører "+ req.getServletPath() +"... sjekk TV'en! Melding fra boksen:");
        InputStream log = null;
        if (req.getServletPath().equals(REBOOT_PATH)) {
            log = Rebooter.reboot();

        }
        if (req.getServletPath().equals(RESTART_PATH)) {
            log = RestartKodi.restartKodi();
        }

        writeInputstream(responseWriter, log);


    }

    private void writeInputstream(PrintWriter responseWriter, InputStream log) throws IOException {
        responseWriter.println(
                new BufferedReader(
                        new InputStreamReader(
                                log)).readLine());
    }
}
