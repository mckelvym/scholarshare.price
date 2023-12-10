package scholarshare.price.config;

import static com.google.common.base.MoreObjects.firstNonNull;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import java.io.File;
import java.util.Optional;

public record OutputConfig(Optional<String> mergeFilePath, Optional<String> outFilePath) {
    public OutputConfig(Optional<String> mergeFilePath, Optional<String> outFilePath) {
        final Optional<String> empty = empty();
        this.mergeFilePath = firstNonNull(mergeFilePath, empty);
        this.outFilePath = firstNonNull(outFilePath, empty);
    }

    public OutputConfig(String mergeFilePath, String outFilePath) {
        this(ofNullable(mergeFilePath), ofNullable(outFilePath));
    }

    public Optional<File> mergeFile() {
        return mergeFilePath().map(File::new);
    }

    public Optional<File> outFile() {
        return outFilePath().map(File::new);
    }
}
