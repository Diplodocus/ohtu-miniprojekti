package miniprojekti;

/**
 * Created by jani on 1.4.2015.
 */
import miniprojekti.profiles.DevProfile;
import miniprojekti.profiles.ProdProfile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import({DevProfile.class, ProdProfile.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}