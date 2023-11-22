package j$.time.chrono;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes6.dex */
public final /* synthetic */ class AbstractChronology$$ExternalSyntheticLambda2 implements Comparator, Serializable {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = AbstractChronology.$r8$clinit;
        int compare = Long.compare(((ChronoZonedDateTime) obj).toEpochSecond(), ((ChronoZonedDateTime) obj2).toEpochSecond());
        return compare == 0 ? Long.compare(r5.toLocalTime().getNano(), r6.toLocalTime().getNano()) : compare;
    }
}
