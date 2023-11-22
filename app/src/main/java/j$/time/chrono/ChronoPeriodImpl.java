package j$.time.chrono;

import id.dana.cashier.view.InputCardNumberView;
import j$.time.temporal.ChronoUnit;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes9.dex */
final class ChronoPeriodImpl implements Serializable {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final long serialVersionUID = 57387258289L;
    private final Chronology chrono;
    final int days;
    final int months;
    final int years;

    static {
        Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChronoPeriodImpl(Chronology chronology, int i, int i2, int i3) {
        this.chrono = chronology;
        this.years = i;
        this.months = i2;
        this.days = i3;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) obj;
            if (this.years == chronoPeriodImpl.years && this.months == chronoPeriodImpl.months && this.days == chronoPeriodImpl.days) {
                if (((AbstractChronology) this.chrono).equals(chronoPeriodImpl.chrono)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.years;
        return ((AbstractChronology) this.chrono).hashCode() ^ (Integer.rotateLeft(this.days, 16) + (Integer.rotateLeft(this.months, 8) + i));
    }

    public final String toString() {
        if (this.years == 0 && this.months == 0 && this.days == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(((AbstractChronology) this.chrono).getId());
            sb.append(" P0D");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((AbstractChronology) this.chrono).getId());
        sb2.append(InputCardNumberView.DIVIDER);
        sb2.append('P');
        int i = this.years;
        if (i != 0) {
            sb2.append(i);
            sb2.append('Y');
        }
        int i2 = this.months;
        if (i2 != 0) {
            sb2.append(i2);
            sb2.append('M');
        }
        int i3 = this.days;
        if (i3 != 0) {
            sb2.append(i3);
            sb2.append('D');
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeExternal(DataOutput dataOutput) {
        dataOutput.writeUTF(this.chrono.getId());
        dataOutput.writeInt(this.years);
        dataOutput.writeInt(this.months);
        dataOutput.writeInt(this.days);
    }

    protected final Object writeReplace() {
        return new Ser((byte) 9, this);
    }
}
