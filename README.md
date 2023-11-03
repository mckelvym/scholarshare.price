# Scholarshare Price Harvester

Harvests price data from [https://www.scholarshare529.com/investment/price-performance](https://www.scholarshare529.com/investment/price-performance)

Data pushed to [https://github.com/mckelvym/scholarshare_prices](https://github.com/mckelvym/scholarshare_prices)

Notes: [https://mckelvym.gitlab.io/notes/scholarshare.price](https://mckelvym.gitlab.io/notes/scholarshare.price)

## Build

In `scholarshare.price`:

```bash
./gradlew build
```

This will build and push to Docker Hub.

## OpenRewrite

This will run any active recipes. See `build.gradle` file.

```bash
./gradlew rewriteRun
```

To see available recipes:

```bash
./gradlew rewriteDiscover
```

## GitHub

- https://github.com/mckelvym/scholarshare.price
- [Releases](https://github.com/mckelvym/scholarshare.price/releases)

## Run

```bash
docker run -it registry.hub.docker.com/mckelvym/scholarshare.price:1.4.0
```

See available options with:

```bash
docker run -it registry.hub.docker.com/mckelvym/scholarshare.price:1.4.0 --help
```

Example output:

```bash
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.5)

2023-04-21T19:52:55.242-04:00  INFO 1 --- [           main] scholarshare.price.Application           : Starting Application using Java 17.0.6 with PID 1 (/app/classes started by root in /)
2023-04-21T19:52:55.244-04:00  INFO 1 --- [           main] scholarshare.price.Application           : No active profile set, falling back to 1 default profile: "default"
2023-04-21T19:52:55.627-04:00  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-04-21T19:52:55.633-04:00  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-04-21T19:52:55.633-04:00  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.7]
2023-04-21T19:52:55.674-04:00  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-04-21T19:52:55.675-04:00  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 412 ms
2023-04-21T19:52:55.836-04:00  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-04-21T19:52:55.840-04:00  INFO 1 --- [           main] scholarshare.price.Application           : Started Application in 0.759 seconds (process running for 0.943)
Usage: scholarshare [-hV] [-m=merge-file.csv] [-o=out-file.csv]
  -h, --help      Show this help message and exit.
  -m, --merge-file=merge-file.csv
                  Merge with past entries in this file.
  -o, --out-file=out-file.csv
                  Output to this file, possibly with merges included (if
                    specified)
  -V, --version   Print version information and exit.
```
