package j$.time.temporal;

/* loaded from: classes2.dex */
public interface TemporalAccessor {
    int get(TemporalField temporalField);

    long getLong(TemporalField temporalField);

    boolean isSupported(TemporalField temporalField);

    Object query(TemporalQuery temporalQuery);

    ValueRange range(TemporalField temporalField);
}
