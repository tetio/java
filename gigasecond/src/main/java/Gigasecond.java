import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    public static final int ONE_GIGASECOND = 1_000_000_000;
    LocalDateTime moment;

    public Gigasecond(LocalDate moment) {
        this.moment = moment.atTime(0, 0);
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    public LocalDateTime getDateTime() {
        return moment.plusSeconds(ONE_GIGASECOND);
    }
}
