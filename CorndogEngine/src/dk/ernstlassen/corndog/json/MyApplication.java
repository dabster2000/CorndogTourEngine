package dk.ernstlassen.corndog.json;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("dk.ernstlassen.corndog.json");
    }

}
