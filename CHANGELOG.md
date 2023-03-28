# Change Log

## v1.2.0 (2023-03-28)

- Migrate Java 8 -> Java 11
- Add OpenRewrite 
	- org.openrewrite.java.migrate.guava.NoGuava
- Update Spring Boot version to 2.2.0

## v1.1.0 (2022-12-24)

- Update Spring Boot version to 2.2.0
- Update for new Scholarshare format, including fund renames and page restructuring
	- Adjusted pattern matching
	- New service URL: [https://www.scholarshare529.com/investment/price-performance](https://www.scholarshare529.com/investment/price-performance)

## v1.0.1 (2020-03-08)

- Update Spring Boot version to 2.2.0
- Support for merge file and output file
- Update for new Scholarshare format, including fund renames
	- Filter out `Fund.NOOP`

## v1.0.0 (2017-11-24)

- Initial harvester application for Scholarshare at service URL: [https://www.scholarshare.com/research/daily.shtml](https://www.scholarshare.com/research/daily.shtml) 
- Spring project based on 1.5.8
