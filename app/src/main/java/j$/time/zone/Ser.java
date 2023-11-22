package j$.time.zone;

import com.alibaba.wireless.security.SecExceptionCode;
import j$.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.TimeZone;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class Ser implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;
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
    public static long readEpochSec(DataInput dataInput) {
        return (dataInput.readByte() & 255) == 255 ? dataInput.readLong() : ((((r0 << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255)) * 900) - 4575744000L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffset readOffset(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds(readByte * 900);
    }

    private Object readResolve() {
        return this.object;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeEpochSec(long j, DataOutput dataOutput) {
        if (j < -4575744000L || j >= 10413792000L || j % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j);
            return;
        }
        int i = (int) ((j + 4575744000L) / 900);
        dataOutput.writeByte((i >>> 16) & 255);
        dataOutput.writeByte((i >>> 8) & 255);
        dataOutput.writeByte(i & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeOffset(ZoneOffset zoneOffset, DataOutput dataOutput) {
        int totalSeconds = zoneOffset.getTotalSeconds();
        int i = totalSeconds % SecExceptionCode.SEC_ERROR_UMID_VALID == 0 ? totalSeconds / SecExceptionCode.SEC_ERROR_UMID_VALID : 127;
        dataOutput.writeByte(i);
        if (i == 127) {
            dataOutput.writeInt(totalSeconds);
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        Object readExternal;
        byte readByte = objectInput.readByte();
        this.type = readByte;
        if (readByte == 1) {
            readExternal = ZoneRules.readExternal(objectInput);
        } else if (readByte == 2) {
            long readEpochSec = readEpochSec(objectInput);
            ZoneOffset readOffset = readOffset(objectInput);
            ZoneOffset readOffset2 = readOffset(objectInput);
            if (readOffset.equals(readOffset2)) {
                throw new IllegalArgumentException("Offsets must not be equal");
            }
            readExternal = new ZoneOffsetTransition(readEpochSec, readOffset, readOffset2);
        } else if (readByte == 3) {
            readExternal = ZoneOffsetTransitionRule.readExternal(objectInput);
        } else if (readByte != 100) {
            throw new StreamCorruptedException("Unknown serialized type");
        } else {
            readExternal = new ZoneRules(TimeZone.getTimeZone(objectInput.readUTF()));
        }
        this.object = readExternal;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b = this.type;
        Object obj = this.object;
        objectOutput.writeByte(b);
        if (b == 1) {
            ((ZoneRules) obj).writeExternal(objectOutput);
        } else if (b == 2) {
            ((ZoneOffsetTransition) obj).writeExternal(objectOutput);
        } else if (b == 3) {
            ((ZoneOffsetTransitionRule) obj).writeExternal(objectOutput);
        } else if (b != 100) {
            throw new InvalidClassException("Unknown serialized type");
        } else {
            ((ZoneRules) obj).writeExternalTimeZone(objectOutput);
        }
    }
}
