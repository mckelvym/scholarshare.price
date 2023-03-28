package scholarshare.price;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.google.common.base.Joiner;
import com.google.common.io.Files;

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
	private static final Logger	log	= LoggerFactory
			.getLogger(Application.class);

	/**
	 * @since Mar 8, 2020
	 */
	private static String		s_MergeFile;

	/**
	 * @since Mar 8, 2020
	 */
	private static String		s_OutFile;

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
		System.setProperty("spring.main.allow-bean-definition-overriding",
				"true");

		for (final String arg : args)
		{
			System.out.println("Arg: " + arg);
		}

		s_MergeFile = args[0];
		s_OutFile = args[1];
		log.info("Mergefile: " + s_MergeFile);
		log.info("Outfile: " + s_OutFile);
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
				final List<String> elements = new ArrayList<>();
				final String date = String.valueOf(o.getDate());
				elements.add(date);
				final List<Fund> ordered = new ArrayList<>(Fund.getOrdered());
				Collections.reverse(ordered);
				ordered.stream().map(o.getValue()::get)
						.map(v -> String.format("%.2f", v))
						.forEach(elements::add);

				System.out.println(
						"Date," + ordered.stream().map(Fund::getDescription)
								.collect(Collectors.joining(",")));
				System.out.println(Joiner.on(",").join(elements));

				if (s_OutFile != null)
				{
					log.info("Write to " + s_OutFile);
					try (BufferedWriter writer = Files.newWriter(
							new File(s_OutFile), Charset.defaultCharset()))
					{
						writer.write("Date,"
								+ ordered.stream().map(Fund::getDescription)
										.collect(Collectors.joining(",")));
						writer.newLine();
						writer.write(Joiner.on(",").join(elements));
						writer.newLine();

						if (s_MergeFile != null)
						{
							log.info("Read from: " + s_MergeFile);
							Files.readLines(new File(s_MergeFile),
									Charset.defaultCharset()).stream().skip(1)
									.forEach(line ->
									{
										try
										{
											writer.write(line);
											writer.newLine();
										}
										catch (final FileNotFoundException e)
										{
											final String message = String
													.format("Unable to locate file: "
															+ s_MergeFile);
											log.error(message, e);
										}
										catch (final IOException e)
										{
											final String message = String
													.format("Unable to read: "
															+ s_MergeFile);
											log.error(message, e);
										}
									});
						}
					}
					catch (final FileNotFoundException e)
					{
						final String message = String
								.format("Unable to locate file: " + s_OutFile);
						log.error(message, e);
					}
					catch (final IOException e)
					{
						final String message = String
								.format("Unable to write to: " + s_OutFile);
						log.error(message, e);
					}
				}
			});

			context.close();
		};
	}
}
