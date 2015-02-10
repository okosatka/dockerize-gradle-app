package org.glassfish.jersey.examples.helloworld;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {

    private static final String HOST = "0.0.0.0";
    public static final String ROOT_PATH = "helloworld";
    private static String port = "8080";

    public static void main(String[] args) {
        HttpServer server = null;
        try {
            System.out.println("\"Hello World\" Jersey Example App");

            InputStream is = App.class.getClassLoader().getResourceAsStream("grizzly.properties");
            Properties properties = new Properties();
            properties.load(is);
            port = properties.getProperty("port");

            final ResourceConfig resourceConfig = new ResourceConfig(HelloWorldResource.class);
            server = GrizzlyHttpServerFactory.createHttpServer(getBaseUri(), resourceConfig);

            System.out.println(String.format("Application started.\nTry out %s%s",
                    getBaseUri(), ROOT_PATH));
            synchronized (server) {
                server.wait();
            }
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            server.shutdown();
        }

    }

    private static URI getBaseUri() {
        return URI.create(String.format("http://%s:%s/base/", HOST, port));
    }
}
