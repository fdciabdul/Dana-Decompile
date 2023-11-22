package j$.time;

import j$.time.temporal.ChronoUnit;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

/* loaded from: classes9.dex */
public final class Period implements Serializable {
    public static final Period ZERO = new Period(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;
    private final int days;
    private final int months;
    private final int years;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS));
    }

    private Period(int i, int i2, int i3) {
        this.years = i;
        this.months = i2;
        this.days = i3;
    }

    public static Period ofDays(int i) {
        return (i | 0) == 0 ? ZERO : new Period(0, 0, i);
    }

    public static Period readExternal(DataInput dataInput) {
        int readInt = dataInput.readInt();
        int readInt2 = dataInput.readInt();
        int readInt3 = dataInput.readInt();
        return ((readInt | readInt2) | readInt3) == 0 ? ZERO : new Period(readInt, readInt2, readInt3);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 14, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final j$.time.temporal.Temporal addTo(j$.time.chrono.ChronoLocalDate r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L56
            j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0 r0 = j$.time.temporal.Temporal.CC.getAuthRequestContext()
            java.lang.Object r0 = r6.query(r0)
            j$.time.chrono.Chronology r0 = (j$.time.chrono.Chronology) r0
            if (r0 == 0) goto L2e
            j$.time.chrono.IsoChronology r1 = j$.time.chrono.IsoChronology.INSTANCE
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L17
            goto L2e
        L17:
            java.lang.String r6 = "Chronology mismatch, expected: ISO, actual: "
            java.lang.StringBuilder r6 = j$.time.DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult(r6)
            java.lang.String r0 = r0.getId()
            r6.append(r0)
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            java.lang.String r6 = r6.toString()
            r0.<init>(r6)
            throw r0
        L2e:
            int r0 = r5.months
            if (r0 != 0) goto L3a
            int r0 = r5.years
            if (r0 == 0) goto L4a
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.YEARS
            goto L46
        L3a:
            long r0 = r5.toTotalMonths()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L4a
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.MONTHS
        L46:
            j$.time.temporal.Temporal r6 = r6.plus(r0, r2)
        L4a:
            int r0 = r5.days
            if (r0 == 0) goto L55
            long r0 = (long) r0
            j$.time.temporal.ChronoUnit r2 = j$.time.temporal.ChronoUnit.DAYS
            j$.time.temporal.Temporal r6 = r6.plus(r0, r2)
        L55:
            return r6
        L56:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "temporal"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.Period.addTo(j$.time.chrono.ChronoLocalDate):j$.time.temporal.Temporal");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Period) {
            Period period = (Period) obj;
            return this.years == period.years && this.months == period.months && this.days == period.days;
        }
        return false;
    }

    public final int getDays() {
        return this.days;
    }

    public final int hashCode() {
        int i = this.years;
        return Integer.rotateLeft(this.days, 16) + Integer.rotateLeft(this.months, 8) + i;
    }

    public final String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        int i = this.years;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.months;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.days;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    public final long toTotalMonths() {
        return (this.years * 12) + this.months;
    }

    public final void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.years);
        dataOutput.writeInt(this.months);
        dataOutput.writeInt(this.days);
    }
}
