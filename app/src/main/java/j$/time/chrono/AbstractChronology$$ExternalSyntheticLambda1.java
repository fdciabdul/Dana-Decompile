package j$.time.chrono;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes6.dex */
public final /* synthetic */ class AbstractChronology$$ExternalSyntheticLambda1 implements Comparator, Serializable {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) obj;
        ChronoLocalDateTime chronoLocalDateTime2 = (ChronoLocalDateTime) obj2;
        int i = AbstractChronology.$r8$clinit;
        int compare = Long.compare(chronoLocalDateTime.toLocalDate().toEpochDay(), chronoLocalDateTime2.toLocalDate().toEpochDay());
        return compare == 0 ? Long.compare(chronoLocalDateTime.toLocalTime().toNanoOfDay(), chronoLocalDateTime2.toLocalTime().toNanoOfDay()) : compare;
    }
}
