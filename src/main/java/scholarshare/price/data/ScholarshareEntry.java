package scholarshare.price.data;

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
 */
@Data
@RequiredArgsConstructor
@Builder
public class ScholarshareEntry {
    /**
     * @since Nov 24, 2017
     */
    @NonNull
    private Number change;

    /**
     * @since Nov 24, 2017
     */
    @NonNull
    private Number changePercent;

    /**
     * @since Nov 24, 2017
     */
    @NonNull
    private LocalDate date;

    /**
     * @since Dec 24, 2022
     */
    @NonNull
    private Fund fund;

    /**
     * @since Nov 24, 2017
     */
    @NonNull
    private String name;

    /**
     * @since Nov 24, 2017
     */
    @NonNull
    private Number value;
}
