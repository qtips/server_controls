import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/control")
public class ControlPanelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseWriter = resp.getWriter();
        responseWriter.println("startet restart... sjekk TV'en! Melding fra boksen:");
        InputStream rebootLog = Rebooter.reboot();
        responseWriter.println(new BufferedReader(new InputStreamReader(
                rebootLog)).readLine());
    }
}
