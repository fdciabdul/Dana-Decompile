package j$.time.zone;

import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.Duration;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.Era;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public final class ZoneOffsetTransition implements Comparable, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final LocalDateTime transition;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneOffsetTransition(long j, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.transition = LocalDateTime.ofEpochSecond(j, 0, zoneOffset);
        this.offsetBefore = zoneOffset;
        this.offsetAfter = zoneOffset2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneOffsetTransition(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.transition = localDateTime;
        this.offsetBefore = zoneOffset;
        this.offsetAfter = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
        return Era.CC.PlaceComponentResult(this.transition, this.offsetBefore).compareTo(Era.CC.PlaceComponentResult(zoneOffsetTransition.transition, zoneOffsetTransition.offsetBefore));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ZoneOffsetTransition) {
            ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
            return this.transition.equals(zoneOffsetTransition.transition) && this.offsetBefore.equals(zoneOffsetTransition.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransition.offsetAfter);
        }
        return false;
    }

    public final LocalDateTime getDateTimeAfter() {
        return this.transition.plusSeconds(this.offsetAfter.getTotalSeconds() - this.offsetBefore.getTotalSeconds());
    }

    public final LocalDateTime getDateTimeBefore() {
        return this.transition;
    }

    public final Duration getDuration() {
        return Duration.ofSeconds(this.offsetAfter.getTotalSeconds() - this.offsetBefore.getTotalSeconds());
    }

    public final ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public final ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List getValidOffsets() {
        return isGap() ? Collections.emptyList() : Arrays.asList(this.offsetBefore, this.offsetAfter);
    }

    public final int hashCode() {
        return (this.transition.hashCode() ^ this.offsetBefore.hashCode()) ^ Integer.rotateLeft(this.offsetAfter.hashCode(), 16);
    }

    public final boolean isGap() {
        return this.offsetAfter.getTotalSeconds() > this.offsetBefore.getTotalSeconds();
    }

    public final long toEpochSecond() {
        return Era.CC.getAuthRequestContext(this.transition, this.offsetBefore);
    }

    public final String toString() {
        StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Transition[");
        PlaceComponentResult.append(isGap() ? "Gap" : "Overlap");
        PlaceComponentResult.append(" at ");
        PlaceComponentResult.append(this.transition);
        PlaceComponentResult.append(this.offsetBefore);
        PlaceComponentResult.append(" to ");
        PlaceComponentResult.append(this.offsetAfter);
        PlaceComponentResult.append(']');
        return PlaceComponentResult.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeExternal(DataOutput dataOutput) {
        Ser.writeEpochSec(toEpochSecond(), dataOutput);
        Ser.writeOffset(this.offsetBefore, dataOutput);
        Ser.writeOffset(this.offsetAfter, dataOutput);
    }
}
