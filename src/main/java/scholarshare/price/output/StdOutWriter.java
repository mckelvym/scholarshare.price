package scholarshare.price.output;

import static java.util.Objects.requireNonNull;

import com.google.common.collect.Lists;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import scholarshare.price.data.Fund;
import scholarshare.price.data.Observation;
import scholarshare.price.xfer.Response;

public class StdOutWriter {

    private final List<Fund> funds;

    private PrintStream out;

    public StdOutWriter() {
        funds = new ArrayList<>(Fund.getOrdered());
        Collections.reverse(funds);
    }

    public void writeResponse(Response response) {
        requireNonNull(response);

        out = System.out;

        printHeader();
        response.getObservations().forEach(this::printObservation);
    }

    private void printHeader() {
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
        out.println(elements.stream().collect(Collectors.joining(",")));
    }
}
