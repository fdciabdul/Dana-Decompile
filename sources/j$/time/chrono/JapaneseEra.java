package j$.time.chrono;

import com.alibaba.wireless.security.SecExceptionCode;
import j$.time.DateTimeException;
import j$.time.LocalDate;
import j$.time.chrono.Era;
import j$.time.temporal.ChronoField;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.ValueRange;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes9.dex */
public final class JapaneseEra implements Era, Serializable {
    private static final JapaneseEra[] KNOWN_ERAS;
    public static final JapaneseEra MEIJI;
    private static final long serialVersionUID = 1466499369062886794L;
    private final transient int eraValue;
    private final transient String name;
    private final transient LocalDate since;

    static {
        JapaneseEra japaneseEra = new JapaneseEra(-1, LocalDate.of(1868, 1, 1), "Meiji");
        MEIJI = japaneseEra;
        JapaneseEra japaneseEra2 = new JapaneseEra(0, LocalDate.of((int) SecExceptionCode.SEC_ERROR_GENERIC_AVMP_VM_CALL_FAILED, 7, 30), "Taisho");
        JapaneseEra japaneseEra3 = new JapaneseEra(1, LocalDate.of(1926, 12, 25), "Showa");
        JapaneseEra japaneseEra4 = new JapaneseEra(2, LocalDate.of(1989, 1, 8), "Heisei");
        JapaneseEra japaneseEra5 = new JapaneseEra(3, LocalDate.of(2019, 5, 1), "Reiwa");
        KNOWN_ERAS = r8;
        JapaneseEra[] japaneseEraArr = {japaneseEra, japaneseEra2, japaneseEra3, japaneseEra4, japaneseEra5};
    }

    private JapaneseEra(int i, LocalDate localDate, String str) {
        this.eraValue = i;
        this.since = localDate;
        this.name = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JapaneseEra from(LocalDate localDate) {
        JapaneseEra japaneseEra;
        if (localDate.isBefore(JapaneseDate.MEIJI_6_ISODATE)) {
            throw new DateTimeException("JapaneseDate before Meiji 6 are not supported");
        }
        int length = KNOWN_ERAS.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            japaneseEra = KNOWN_ERAS[length];
        } while (localDate.compareTo((ChronoLocalDate) japaneseEra.since) < 0);
        return japaneseEra;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JapaneseEra getCurrentEra() {
        return KNOWN_ERAS[r0.length - 1];
    }

    public static JapaneseEra of(int i) {
        if (i >= MEIJI.eraValue) {
            int i2 = i + 2;
            JapaneseEra[] japaneseEraArr = KNOWN_ERAS;
            if (i2 <= japaneseEraArr.length) {
                return japaneseEraArr[i2 - 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid era: ");
        sb.append(i);
        throw new DateTimeException(sb.toString());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long shortestDaysOfYear() {
        long smallestMaximum = ChronoField.DAY_OF_YEAR.range().getSmallestMaximum();
        for (JapaneseEra japaneseEra : KNOWN_ERAS) {
            smallestMaximum = Math.min(smallestMaximum, (japaneseEra.since.lengthOfYear() - japaneseEra.since.getDayOfYear()) + 1);
            if (japaneseEra.next() != null) {
                smallestMaximum = Math.min(smallestMaximum, (long) (japaneseEra.next().since.getDayOfYear() - 1));
            }
        }
        return smallestMaximum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long shortestYearsOfEra() {
        int year = (999999999 - getCurrentEra().since.getYear()) + 1;
        int year2 = KNOWN_ERAS[0].since.getYear();
        int i = 1;
        while (true) {
            JapaneseEra[] japaneseEraArr = KNOWN_ERAS;
            if (i >= japaneseEraArr.length) {
                return year;
            }
            JapaneseEra japaneseEra = japaneseEraArr[i];
            year = Math.min(year, (japaneseEra.since.getYear() - year2) + 1);
            year2 = japaneseEra.since.getYear();
            i++;
        }
    }

    public static JapaneseEra[] values() {
        JapaneseEra[] japaneseEraArr = KNOWN_ERAS;
        return (JapaneseEra[]) Arrays.copyOf(japaneseEraArr, japaneseEraArr.length);
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final /* synthetic */ Temporal adjustInto(Temporal temporal) {
        return Era.CC.BuiltInFictitiousFunctionClassFactory(this, temporal);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ int get(TemporalField temporalField) {
        return Era.CC.PlaceComponentResult(this, (ChronoField) temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ long getLong(TemporalField temporalField) {
        return Era.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LocalDate getSince() {
        return this.since;
    }

    @Override // j$.time.chrono.Era
    public final int getValue() {
        return this.eraValue;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ boolean isSupported(TemporalField temporalField) {
        return Era.CC.getAuthRequestContext(this, temporalField);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JapaneseEra next() {
        if (this == getCurrentEra()) {
            return null;
        }
        return of(this.eraValue + 1);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ Object query(TemporalQuery temporalQuery) {
        return Era.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        ChronoField chronoField = ChronoField.ERA;
        return temporalField == chronoField ? JapaneseChronology.INSTANCE.range(chronoField) : Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    public final String toString() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeExternal(DataOutput dataOutput) {
        dataOutput.writeByte(this.eraValue);
    }
}
