package j$.time;

import java.io.Serializable;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public abstract class Clock {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class SystemClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SystemClock(ZoneId zoneId) {
            this.zone = zoneId;
        }

        @Override // j$.time.Clock
        public final boolean equals(Object obj) {
            if (obj instanceof SystemClock) {
                return this.zone.equals(((SystemClock) obj).zone);
            }
            return false;
        }

        @Override // j$.time.Clock
        public final ZoneId getZone() {
            return this.zone;
        }

        @Override // j$.time.Clock
        public final int hashCode() {
            return this.zone.hashCode() + 1;
        }

        @Override // j$.time.Clock
        public final Instant instant() {
            return Instant.ofEpochMilli(System.currentTimeMillis());
        }

        @Override // j$.time.Clock
        public final long millis() {
            return System.currentTimeMillis();
        }

        public final String toString() {
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("SystemClock[");
            PlaceComponentResult.append(this.zone);
            PlaceComponentResult.append("]");
            return PlaceComponentResult.toString();
        }
    }

    protected Clock() {
    }

    public static Clock systemDefaultZone() {
        Map map = ZoneId.SHORT_IDS;
        return new SystemClock(ZoneId.of(TimeZone.getDefault().getID(), ZoneId.SHORT_IDS));
    }

    public static Clock systemUTC() {
        return new SystemClock(ZoneOffset.UTC);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public abstract ZoneId getZone();

    public int hashCode() {
        return super.hashCode();
    }

    public abstract Instant instant();

    public long millis() {
        return instant().toEpochMilli();
    }
}
