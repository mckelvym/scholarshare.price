package scholarshare.price;

import com.google.common.base.CharMatcher;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * A single entry
 *
 * @author mckelvym
 * @since Nov 24, 2017
 *
 */
@Data
@RequiredArgsConstructor
@Builder
public class ScholarshareEntry
{
	/**
	 * @since Nov 24, 2017
	 */
	@NonNull
	private Number		change;

	/**
	 * @since Nov 24, 2017
	 */
	@NonNull
	private Number		changePercent;

	/**
	 * @since Nov 24, 2017
	 */
	@NonNull
	private LocalDate	date;

	/**
	 * @since Nov 24, 2017
	 */
	@NonNull
	private String		group;

	/**
	 * @since Nov 24, 2017
	 */
	@NonNull
	private String		name;

	/**
	 * @since Nov 24, 2017
	 */
	@NonNull
	private Number		value;

	/**
	 * @return a string formatted like an enum constant
	 * @since Nov 24, 2017
	 */
	public String getFormattedAsEnum()
	{
		return CharMatcher.javaLetterOrDigit().or(CharMatcher.is('_'))
				.retainFrom(CharMatcher.whitespace().or(CharMatcher.is('-'))
						.replaceFrom(getNameAndGroup(), "_"))
				.toUpperCase();
	}

	/**
	 * @return the {@link Fund} by calling {@link #getFormattedAsEnum()} and
	 *         valueOf
	 * @since Nov 24, 2017
	 */
	public Fund getFund()
	{
		return Fund.valueOf(getFormattedAsEnum());
	}

	/**
	 * @return the combined name and group
	 * @since Nov 24, 2017
	 */
	public String getNameAndGroup()
	{
		return CharMatcher.whitespace().replaceFrom(
				String.format("%s (%s)", getName(), getGroup()), ' ');
	}
}