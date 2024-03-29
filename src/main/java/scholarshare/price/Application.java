package scholarshare.price;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import scholarshare.price.xfer.Request;

/**
 * Downloads share price information from scholarshare site.
 *
 * @author mckelvym
 * @since Nov 23, 2017
 */
@SpringBootApplication
public class Application {
    /**
     * @param args
     * @since Nov 23, 2017
     */
    public static void main(final String[] args) {
        System.setProperty("spring.main.allow-bean-definition-overriding",
                "true");
        System.setProperty("spring.main.web-application-type", "NONE");

        System.exit(SpringApplication
                .exit(SpringApplication.run(Application.class, args)));
    }

    /**
     * @return new {@link Request}
     * @since Nov 23, 2017
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Request request() {
        return new Request();
    }
}
