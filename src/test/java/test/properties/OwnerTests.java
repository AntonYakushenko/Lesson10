package test.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tag("properties")
public class OwnerTests {
    public  CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);


    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();
        String browserURL = credentials.browserURL();

        System.out.println(login);
        System.out.println(password);
        System.out.println(browserURL);

        String message = format("i login as %s with password %s and browser URL %s" , login, password, browserURL);
        System.out.println(message);
    }

}
