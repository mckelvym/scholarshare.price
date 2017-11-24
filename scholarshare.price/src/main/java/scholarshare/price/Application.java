package scholarshare.price;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

/**
 * Downloads share price information from TSP site.
 *
 * @author mckelvym
 * @since Nov 23, 2017
 *
 */
@SpringBootApplication
public class Application
{

	/**
	 * Class logger
	 *
	 * @since Nov 23, 2017
	 */
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Application.class);

	/**
	 * Suppress normal logging from httpclient and http headers traffic.
	 *
	 * @since Feb 16, 2016
	 */
	private static void disableNoisyLogging()
	{
		/**
		 * HTTP traffic log will be really noisy without this...
		 */
		java.util.logging.Logger.getLogger("org.apache.http.wire")
				.setLevel(java.util.logging.Level.FINEST);
		java.util.logging.Logger.getLogger("org.apache.http.headers")
				.setLevel(java.util.logging.Level.FINEST);
		System.setProperty("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime",
				"true");
		System.setProperty(
				"org.apache.commons.logging.simplelog.log.httpclient.wire",
				"ERROR");
		System.setProperty(
				"org.apache.commons.logging.simplelog.log.org.apache.http",
				"ERROR");
		System.setProperty(
				"org.apache.commons.logging.simplelog.log.org.apache.http.headers",
				"ERROR");
	}

	/**
	 * @param args
	 * @since Nov 23, 2017
	 */
	public static void main(final String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	/**
	 * @since Nov 23, 2017
	 */
	@Autowired
	private ConfigurableApplicationContext context;

	/**
	 * @return new {@link Request}
	 * @since Nov 23, 2017
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	Request request()
	{
		return new Request();
	}

	/**
	 * @return {@link CommandLineRunner}
	 * @since Nov 23, 2017
	 */
	@Bean
	@Profile(value = { "default" })
	public CommandLineRunner run()
	{
		return p_args ->
		{
			disableNoisyLogging();

			log.info(String.format("Starting..."));
			@SuppressWarnings("null")
			final Response response = context.getBean(ServiceClient.class)
					.get(context.getBean(Request.class));

			response.getObservations().forEach(o ->
			{
				final List<String> elements = Lists.newArrayList();
				elements.add(String.valueOf(o.getDate()));
				Fund.getOrdered().stream().map(o.getValue()::get)
						.map(String::valueOf).forEach(elements::add);

				System.out.println(Joiner.on(",").join(elements));
			});

			context.close();
		};
	}
}
