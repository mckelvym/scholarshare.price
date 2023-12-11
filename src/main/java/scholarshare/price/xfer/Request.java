package scholarshare.price.xfer;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Maps;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import scholarshare.price.config.Properties;

/**
 * Used to make a request. Loads default values from beans by scanning
 * parameters.
 *
 * @author mckelvym
 * @since Nov 23, 2017
 */
@Data
@Configuration
@ToString
@EqualsAndHashCode
public class Request {
    /**
     * @since Nov 23, 2017
     */
    @Autowired
    private Properties properties;

    /**
     * @throws IllegalStateException if request parameters are not properly parameterized
     * @author mckelvym
     * @since Nov 23, 2017
     */
    private void checkValid() throws IllegalStateException {
        checkNotNull(properties.getServiceUrl(), "Service URL required.");
    }

    /**
     * @return a URI template string to be used by
     * {@link RestTemplate#getForEntity(String, Class, Map)}
     * @throws IllegalStateException if request parameters are not properly parameterized
     * @since Nov 23, 2017
     */
    public String toUriTemplate() {
        checkValid();
        return properties.getServiceUrl();
    }

    /**
     * @return a map that can be used by
     * {@link RestTemplate#getForEntity(String, Class, Map)}
     * @throws IllegalStateException if request parameters are not properly parameterized
     * @since Nov 23, 2017
     */
    public Map<String, Object> toUriVariables() {
        checkValid();
        return Maps.newHashMap();
    }
}
