package scholarshare.price;

import java.util.concurrent.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import scholarshare.price.config.OutputConfig;
import scholarshare.price.output.CsvWriter;
import scholarshare.price.output.StdOutWriter;
import scholarshare.price.xfer.Request;
import scholarshare.price.xfer.Response;
import scholarshare.price.xfer.ServiceClient;

/**
 * PicoCLI command
 *
 * @author mckelvym
 * @since Mar 30, 2023
 */
@Component
@Command(name = "scholarshare", mixinStandardHelpOptions = true)
public class ApplicationCommand implements Callable<Integer> {

    /**
     * Class logger
     *
     * @author mckelvym
     * @since Mar 30, 2023
     */
    private static final Logger log = LoggerFactory
            .getLogger(ApplicationCommand.class);
    /**
     * @since Nov 23, 2017
     */
    @Autowired
    private ConfigurableApplicationContext context;
    /**
     * @since Mar 8, 2020
     */
    @Option(
            names = {"-m", "--merge-file"},
            description = "Merge with past entries in this file.",
            paramLabel = "merge-file.csv")
    private String mergeFile;
    /**
     * @since Mar 8, 2020
     */
    @Option(
            names = {"-o", "--out-file"},
            description = "Output to this file, possibly with merges included (if specified)",
            paramLabel = "out-file.csv")
    private String outFile;

    /**
     * Suppress normal logging from httpclient and http headers traffic.
     *
     * @since Feb 16, 2016
     */
    private static void disableNoisyLogging() {
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

    @Override
    public Integer call() {
        log.info("merge-file=" + mergeFile);
        log.info("out-file=" + outFile);

        disableNoisyLogging();

        @SuppressWarnings("null") final Response response = context.getBean(ServiceClient.class)
                .get(context.getBean(Request.class));

        new StdOutWriter().writeResponse(response);
        new CsvWriter(new OutputConfig(mergeFile, outFile)).writeResponse(response);

        return 0;
    }
}
