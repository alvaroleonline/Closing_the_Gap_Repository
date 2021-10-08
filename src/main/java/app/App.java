package app;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;


/**
 * Main Application Class.
 * <p>
 * Running this class as regular java application will start the 
 * Javalin HTTP Server and our web application.
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class App {

    public static final int         JAVALIN_PORT    = 7000;
    public static final String      CSS_DIR         = "css/";
    public static final String      IMAGES_DIR      = "images/";

    public static void main(String[] args) {
        // Create our HTTP server and listen in port 7000
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));
            
            // Uncomment this if you have files in the CSS Directory
            config.addStaticFiles(CSS_DIR);

            // Uncomment this if you have files in the Images Directory
            config.addStaticFiles(IMAGES_DIR);
        }).start(JAVALIN_PORT);


        // Configure Web Routes
        configureRoutes(app);
    }

    public static void configureRoutes(Javalin app) {
        // All webpages are listed here as GET pages
        app.get(Index.URL, new Index());
        app.get(Page1.URL, new Page1());
        app.get(Page2.URL, new Page2());
        app.get(Page3.URL, new Page3());
        app.get(Page4.URL, new Page4());
        app.get(Page5.URL, new Page5());
        app.get(Page6.URL, new Page6());

        // Add / uncomment POST commands for any pages that need web form POSTS
        // app.post(Index.URL, new Index());
        // app.post(Page1.URL, new Page1());
        // app.post(Page2.URL, new Page2());
        // app.post(Page3.URL, new Page3());
        // app.post(Page4.URL, new Page4());
        // app.post(Page5.URL, new Page5());
        // app.post(Page6.URL, new Page6());
    }

}
