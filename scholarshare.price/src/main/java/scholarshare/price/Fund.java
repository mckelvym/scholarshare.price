package scholarshare.price;

import java.util.Arrays;
import java.util.List;

/**
 * The fund types.
 *
 * @author mckelvym
 * @since Nov 19, 2017
 *
 */
@SuppressWarnings("javadoc")
public enum Fund
{
	ACTIVE_CONSERVATIVE_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Active Conservative Investment Portfolio (Investment Portfolio)";
		}
	},
	ACTIVE_DIVERSIFIED_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Active Diversified Equity Investment Portfolio (Investment Portfolio)";
		}
	},
	ACTIVE_DIVERSIFIED_FIXED_INCOME_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Active Diversified Fixed Income Investment Portfolio (Investment Portfolio)";
		}
	},
	ACTIVE_GROWTH_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Active Growth Investment Portfolio (Investment Portfolio)";
		}
	},
	ACTIVE_INTERNATIONAL_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Active International Equity Investment Portfolio (Investment Portfolio)";
		}
	},
	ACTIVE_MODERATE_GROWTH_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Active Moderate Growth Investment Portfolio (Investment Portfolio)";
		}
	},
	AGE_BAND_0_4_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 0-4 (Active Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_0_4_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 0-4 (Passive Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_11_12_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 11-12 (Active Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_11_12_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 11-12 (Passive Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_13_14_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 13-14 (Active Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_13_14_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 13-14 (Passive Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_15_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 15 (Active Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_15_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 15 (Passive Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_16_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 16 (Active Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_16_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 16 (Passive Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_17_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 17 (Active Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_17_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 17 (Passive Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_18_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 18+ (Active Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_18_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 18+ (Passive Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_5_8_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 5-8 (Active Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_5_8_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 5-8 (Passive Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_9_10_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 9-10 (Active Age-Based Investment Portfolio Option)";
		}
	},
	AGE_BAND_9_10_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION
	{
		@Override
		public String getDescription()
		{
			return "Age Band 9-10 (Passive Age-Based Investment Portfolio Option)";
		}
	},
	INDEX_BOND_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Index Bond Investment Portfolio (Investment Portfolio)";
		}
	},
	INDEX_INTERNATIONAL_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Index International Equity Investment Portfolio (Investment Portfolio)";
		}
	},
	INDEX_US_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Index U.S. Equity Investment Portfolio (Investment Portfolio)";
		}
	},
	INDEX_US_LARGE_CAP_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Index U.S. Large Cap Equity Investment Portfolio (Investment Portfolio)";
		}
	},
	PASSIVE_CONSERVATIVE_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Passive Conservative Investment Portfolio (Investment Portfolio)";
		}
	},
	PASSIVE_DIVERSIFIED_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Passive Diversified Equity Investment Portfolio (Investment Portfolio)";
		}
	},
	PASSIVE_DIVERSIFIED_FIXED_INCOME_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Passive Diversified Fixed Income Investment Portfolio (Investment Portfolio)";
		}
	},
	PASSIVE_GROWTH_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Passive Growth Investment Portfolio (Investment Portfolio)";
		}
	},
	PASSIVE_MODERATE_GROWTH_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Passive Moderate Growth Investment Portfolio (Investment Portfolio)";
		}
	},
	PRINCIPAL_PLUS_INTEREST_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Principal Plus Interest Investment Portfolio (Investment Portfolio)";
		}
	},
	SOCIAL_CHOICE_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO
	{
		@Override
		public String getDescription()
		{
			return "Social Choice Investment Portfolio (Investment Portfolio)";
		}
	},;

	/**
	 * @return ordered List of Fund
	 * @since Nov 19, 2017
	 */
	public static List<Fund> getOrdered()
	{
		return Arrays.asList(
				AGE_BAND_0_4_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_5_8_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_9_10_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_11_12_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_13_14_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_15_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_16_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_17_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_18_ACTIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_0_4_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_5_8_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_9_10_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_11_12_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_13_14_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_15_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_16_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_17_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				AGE_BAND_18_PASSIVE_AGE_BASED_INVESTMENT_PORTFOLIO_OPTION,
				PRINCIPAL_PLUS_INTEREST_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				ACTIVE_DIVERSIFIED_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				ACTIVE_GROWTH_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				ACTIVE_MODERATE_GROWTH_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				ACTIVE_CONSERVATIVE_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				ACTIVE_DIVERSIFIED_FIXED_INCOME_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				ACTIVE_INTERNATIONAL_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				PASSIVE_DIVERSIFIED_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				PASSIVE_GROWTH_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				PASSIVE_MODERATE_GROWTH_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				PASSIVE_CONSERVATIVE_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				PASSIVE_DIVERSIFIED_FIXED_INCOME_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				INDEX_INTERNATIONAL_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				SOCIAL_CHOICE_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				INDEX_BOND_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				INDEX_US_LARGE_CAP_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO,
				INDEX_US_EQUITY_INVESTMENT_PORTFOLIO_INVESTMENT_PORTFOLIO);
	}

	/**
	 * @return description of this fund.
	 * @since Nov 24, 2017
	 */
	public abstract String getDescription();
}
