package test.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OwnerTests {
    public  CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @Tag("properties")
    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();

        System.out.println(login);
        System.out.println(password);
    }

}
