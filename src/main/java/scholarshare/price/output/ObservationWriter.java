package scholarshare.price.output;

import java.util.List;
import scholarshare.price.data.Observation;

public interface ObservationWriter {
    void writeObservations(List<Observation> observations);
}
