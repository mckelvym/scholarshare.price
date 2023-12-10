package scholarshare.price.output;

import static java.util.Objects.requireNonNull;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scholarshare.price.config.OutputConfig;
import scholarshare.price.data.Fund;
import scholarshare.price.data.Observation;
import scholarshare.price.xfer.Response;

public class CsvWriter {

    private static final Logger log = LoggerFactory
            .getLogger(CsvWriter.class);

    private final OutputConfig outputConfig;

    private final List<Fund> funds;

    private BufferedWriter writer;

    public CsvWriter(OutputConfig outputConfig) {
        this.outputConfig = requireNonNull(outputConfig);
        funds = new ArrayList<>(Fund.getOrdered());
        Collections.reverse(funds);
    }

    public void writeResponse(Response response) {
        requireNonNull(response);

        final Optional<File> outFileOpt = outputConfig.outFile();
        if (!outFileOpt.isPresent()) {
            return;
        }
        log.info("Write to " + outFileOpt.get());
        try (BufferedWriter writer = Files.newWriter(outFileOpt.get(),
                Charset.defaultCharset())) {
            this.writer = writer;
            printHeader();
            response.getObservations().forEach(this::printObservation);

            processMergeFile(response, outputConfig);

        } catch (final FileNotFoundException e) {
            final String message = "Unable to locate file: %s"
                    .formatted(outFileOpt.get());
            log.error(message, e);
        } catch (final IOException e) {
            final String message = "Unable to write to: %s"
                    .formatted(outFileOpt.get());
            log.error(message, e);
        }
    }

    private void processMergeFile(Response response, OutputConfig outputConfig) throws IOException {
        Set<String> dates = response.getObservations().stream()
                .map(Observation::getDate)
                .map(String::valueOf)
                .collect(Collectors.toSet());
        final Optional<File> mergeFileOpt = outputConfig.mergeFile();
        if (mergeFileOpt.isPresent() && mergeFileOpt.get().exists()) {
            log.info("Read from: " + mergeFileOpt);
            final List<List<String>> lines = Files.asCharSource(mergeFileOpt.get(),
                    Charset.defaultCharset()).readLines(lineProcessor(dates));
            lines.stream().skip(1).forEach(this::printRow);
        }
    }

    private LineProcessor<List<List<String>>> lineProcessor(Set<String> excludeDates) {
        return new LineProcessor<>() {
            private final List<List<String>> results = Lists.newArrayList();
            private final Splitter splitter = Splitter.on(",");

            @Override
            public boolean processLine(String line) {
                final List<String> elements = splitter.splitToList(line);
                final boolean isValid = elements.size() > 0 && !excludeDates.contains(elements.get(0));
                if (isValid) {
                    results.add(elements);
                }
                return true;
            }

            @Override
            public List<List<String>> getResult() {
                return results;
            }
        };
    }

    private void printHeader() throws IOException {
        List<String> elements = Lists.newArrayList("Date");
        funds.stream().map(Fund::getDescription).forEach(elements::add);
        printRow(elements);
    }

    private void printObservation(Observation o) {
        final List<String> elements = Lists.newArrayList(String.valueOf(o.getDate()));
        funds.stream()
                .map(o.getValue()::get)
                .map(v -> String.format("%.2f", v))
                .forEach(elements::add);
        printRow(elements);
    }

    private void printRow(List<String> elements) {
        try {
            writer.write(elements.stream().collect(Collectors.joining(",")));
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
