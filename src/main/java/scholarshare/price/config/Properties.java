package scholarshare.price.config;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties class. See application.properties
 *
 * @author mckelvym
 * @since Nov 23, 2017
 */
@Data
@Getter
@ToString
@EnableConfigurationProperties
@ConfigurationProperties("scholarshare")
@Configuration
public class Properties {
    /**
     * The remote service URL
     *
     * @since Nov 23, 2017
     */
    private String serviceUrl;

    /**
     * @since Dec 10, 2023
     */
    private String repoUrl;

    /**
     * @since Dec 10, 2023
     */
    private String csvUrl;
}
