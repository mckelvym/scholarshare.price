package scholarshare.price;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * Makes requests and parses them.
 *
 * @author mckelvym
 * @since Nov 23, 2017
 *
 */
@Service
public class ServiceClient
{
	/**
	 * @since Mar 8, 2020
	 */
	private static final Logger log = LoggerFactory
			.getLogger(ServiceClient.class);

	/**
	 * Read the daily prices page and return a listing of entries.
	 *
	 * @param p_Request
	 *            the {@link Request}
	 * @return the listing of parsed entries.
	 * @throws IOException
	 * @throws MalformedURLException
	 * @throws ParseException
	 * @since Feb 16, 2016
	 */
	private static List<ScholarshareEntry> getDailyEntries(
			final Request p_Request)
			throws IOException, MalformedURLException, ParseException
	{
		final List<ScholarshareEntry> entries = Lists.newArrayList();
		try (WebClient client = new WebClient())
		{
			client.getOptions().setCssEnabled(false);
			client.getOptions().setJavaScriptEnabled(false);

			final URI uri = new DefaultUriBuilderFactory().expand(
					p_Request.toUriTemplate(), p_Request.toUriVariables());
			final HtmlPage page = client.getPage(uri.toString());
			page.cleanUp();

			final CharMatcher numberMatcher = CharMatcher.digit()
					.or(CharMatcher.is('.'));
			LocalDate date = null;

			final List<Object> div = page
					.getByXPath("//div[@class='panel-group nomobile']");

			final List<HtmlElement> tables = ((HtmlElement) div.get(0))
					.getElementsByTagName("table");
			for (final HtmlElement table : tables)
			{
				if (date == null)
				{
					final List<HtmlElement> items = table
							.getElementsByTagName("th");
					String dateS = items.get(1).getTextContent();
					dateS = dateS.replace("Unit Value as of", "").trim();

					date = LocalDate.parse(dateS,
							DateTimeFormatter.ofPattern("MMMM d, yyyy"));
				}
				final List<HtmlElement> items = Lists
						.newArrayList(table.getElementsByTagName("td"));
				final List<HtmlElement> heading = Lists
						.newArrayList(table.getElementsByTagName("th"));
				while (!items.isEmpty())
				{
					if (items.size() < 4)
					{
						continue;
					}
					final String groupS = heading.get(0).getTextContent();
					final String nameS = items.remove(0).getTextContent();
					final String valueS = items.remove(0).getTextContent();
					final String changeS = items.remove(0).getTextContent();
					final String changePcS = items.remove(0).getTextContent();

					final String valueS_Cleaned = numberMatcher
							.retainFrom(valueS);
					final String changeS_Cleaned = numberMatcher
							.retainFrom(changeS);
					final String changePcS_Cleaned = numberMatcher
							.retainFrom(changePcS);

					final Number value = Double.parseDouble(valueS_Cleaned);
					final Number change = Double.parseDouble(changeS_Cleaned);
					final Number changePc = Double
							.parseDouble(changePcS_Cleaned);

					log.info(String.format(
							"Build entry from name=%s group=%s value=%s change=%s changePercent=%s date=%s",
							nameS, groupS, value, change, changePc, date));
					final ScholarshareEntry entry = ScholarshareEntry.builder()
							.name(nameS).group(groupS).value(value)
							.change(change).changePercent(changePc).date(date)
							.build();
					entries.add(entry);
				}
			}
		}
		return entries;
	}

	/**
	 * Query the server for {@link Response}
	 *
	 * @param p_Request
	 *            the {@link Request} request parameters
	 * @return the {@link Response} returned
	 * @throws RestClientException,
	 *             HttpClientErrorException
	 * @since Nov 23, 2017
	 */
	public Response get(final Request p_Request) throws RestClientException
	{
		try
		{
			final List<ScholarshareEntry> entries = getDailyEntries(p_Request);
			// entries.forEach(e ->
			// {
			// System.out.println(String.format(
			// "%s{ public String getDescription() {return \"%s\";} },",
			// e.getFormattedAsEnum(), e.getNameAndGroup()));

			// System.out.println(e.getFormattedAsEnum() + ",");
			// });
			if (!entries.isEmpty())
			{
				final LocalDate date = entries.get(0).getDate();
				final Map<Fund, Number> values = entries.stream()
						.filter(e -> e.getFund() != Fund.NOOP)
						.collect(Collectors.toMap(ScholarshareEntry::getFund,
								ScholarshareEntry::getValue));
				final Observation observation = Observation.builder().date(date)
						.value(values).build();
				return Response.builder()
						.observations(Arrays.asList(observation)).build();
			}
		}
		catch (final MalformedURLException e)
		{
			final String message = String.format("Unable to get daily entries");
			throw new RestClientException(message, e);
		}
		catch (final IOException e)
		{
			final String message = String.format("Unable to get daily entries");
			throw new RestClientException(message, e);
		}
		catch (final ParseException e)
		{
			final String message = String.format("Unable to get daily entries");
			throw new RestClientException(message, e);
		}
		return Response.builder().build();
	}

}
