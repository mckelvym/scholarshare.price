# Change Log

## v1.6.1 (2023-12-10)

- Update gradle plugins:
	- io.freefair.lombok version '8.4'
	- com.google.cloud.tools.jib version '3.4.0'
	- org.openrewrite.rewrite '6.5.12'
- Update gradle dependencies:
	- org.springframework.boot:spring-boot-starter:3.2.0
	- org.springframework.boot:spring-boot-starter-web:3.2.0
	- org.springframework.boot:spring-boot-configuration-processor:3.2.0
	- org.projectlombok:lombok:1.18.30
	- org.springframework.boot:spring-boot-starter-test:3.2.0
	- org.glassfish.jaxb:jaxb-runtime:4.0.4
	- org.openrewrite.recipe:rewrite-recipe-bom:2.5.3
	- org.glassfish.jaxb:jaxb-runtime:2.3.9
- Update rewrite recipes:
	- org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
	- org.openrewrite.java.migrate.lombok.UpdateLombokToJava17 (removed)
	- org.openrewrite.java.cleanup.FixStringFormatExpressions (removed)
	- org.openrewrite.java.RemoveUnusedImports (added)

## v1.6.0 (2023-12-10)

- Support for RSS export
- Refactor classes separate packages

## v1.5.0 (2023-11-03)

- Restructure folder such that everything is in the root
- Remove Maven & Eclipse files

## v1.4.0 (2023-04-17)

- Migrate to Gradle

## v1.3.0 (2023-04-09)

- Migrate Java 11 -> Java 17
- `.project` name change from `financial` to `scholarshare.price.project`
- Coordinates change from `mckelvym:scholarshare.price` to `scholarshare:price`
- Update Spring Boot version to 3.0.5
- Update guava to 31.1-jre
- Update org.eclipse.jdt:org.eclipse.jdt.annotation to 2.2.700
- Add PicoCLI with options:
	- --merge-file
	- --out-file
- Add OpenRewrite
	- org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
	- org.openrewrite.java.migrate.UpgradeToJava17
	- org.openrewrite.java.migrate.JavaVersion17
	- org.openrewrite.java.migrate.lombok.UpdateLombokToJava17
	- org.openrewrite.java.logging.log4j.ParameterizedLogging
	- org.openrewrite.java.migrate.lang.StringFormatted
	- org.openrewrite.java.cleanup.FixStringFormatExpressions
- Add Jib for container publish

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
