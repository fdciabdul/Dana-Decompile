package j$.time;

import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class Ser implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;
    private Object object;
    private byte type;

    public Ser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ser(byte b, Object obj) {
        this.type = b;
        this.object = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Serializable read(ObjectInput objectInput) {
        return readInternal(objectInput.readByte(), objectInput);
    }

    private static Serializable readInternal(byte b, ObjectInput objectInput) {
        switch (b) {
            case 1:
                Duration duration = Duration.ZERO;
                return Duration.ofSeconds(objectInput.readLong(), objectInput.readInt());
            case 2:
                Instant instant = Instant.EPOCH;
                return Instant.ofEpochSecond(objectInput.readLong(), objectInput.readInt());
            case 3:
                LocalDate localDate = LocalDate.MIN;
                return LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return LocalTime.readExternal(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.MIN;
                LocalDate localDate2 = LocalDate.MIN;
                return LocalDateTime.of(LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), LocalTime.readExternal(objectInput));
            case 6:
                return ZonedDateTime.readExternal(objectInput);
            case 7:
                int i = ZoneRegion.$r8$clinit;
                return ZoneId.of(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.readExternal(objectInput);
            case 9:
                return OffsetTime.readExternal(objectInput);
            case 10:
                return OffsetDateTime.readExternal(objectInput);
            case 11:
                int i2 = Year.$r8$clinit;
                return Year.of(objectInput.readInt());
            case 12:
                int i3 = YearMonth.$r8$clinit;
                return YearMonth.of(objectInput.readInt(), objectInput.readByte());
            case 13:
                return MonthDay.readExternal(objectInput);
            case 14:
                return Period.readExternal(objectInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.object;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.type = readByte;
        this.object = readInternal(readByte, objectInput);
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b = this.type;
        Object obj = this.object;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                ((Duration) obj).writeExternal(objectOutput);
                return;
            case 2:
                ((Instant) obj).writeExternal(objectOutput);
                return;
            case 3:
                ((LocalDate) obj).writeExternal(objectOutput);
                return;
            case 4:
                ((LocalTime) obj).writeExternal(objectOutput);
                return;
            case 5:
                ((LocalDateTime) obj).writeExternal(objectOutput);
                return;
            case 6:
                ((ZonedDateTime) obj).writeExternal(objectOutput);
                return;
            case 7:
                ((ZoneRegion) obj).writeExternal(objectOutput);
                return;
            case 8:
                ((ZoneOffset) obj).writeExternal(objectOutput);
                return;
            case 9:
                ((OffsetTime) obj).writeExternal(objectOutput);
                return;
            case 10:
                ((OffsetDateTime) obj).writeExternal(objectOutput);
                return;
            case 11:
                ((Year) obj).writeExternal(objectOutput);
                return;
            case 12:
                ((YearMonth) obj).writeExternal(objectOutput);
                return;
            case 13:
                ((MonthDay) obj).writeExternal(objectOutput);
                return;
            case 14:
                ((Period) obj).writeExternal(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }
}
