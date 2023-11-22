package j$.time;

import j$.time.zone.ZoneRules;
import j$.time.zone.ZoneRulesException;
import j$.time.zone.ZoneRulesProvider;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ZoneRegion extends ZoneId {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: id  reason: collision with root package name */
    private final String f8260id;
    private final transient ZoneRules rules;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneRegion(String str, ZoneRules zoneRules) {
        this.f8260id = str;
        this.rules = zoneRules;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneRegion ofId(String str, boolean z) {
        if (str != null) {
            int length = str.length();
            if (length < 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid ID for region-based ZoneId, invalid format: ");
                sb.append(str);
                throw new DateTimeException(sb.toString());
            }
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i == 0) && ((charAt < '0' || charAt > '9' || i == 0) && ((charAt != '~' || i == 0) && ((charAt != '.' || i == 0) && ((charAt != '_' || i == 0) && ((charAt != '+' || i == 0) && (charAt != '-' || i == 0))))))))) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid ID for region-based ZoneId, invalid format: ");
                    sb2.append(str);
                    throw new DateTimeException(sb2.toString());
                }
            }
            ZoneRules zoneRules = null;
            try {
                zoneRules = ZoneRulesProvider.getAuthRequestContext(str);
            } catch (ZoneRulesException e) {
                if (z) {
                    throw e;
                }
            }
            return new ZoneRegion(str, zoneRules);
        }
        throw new NullPointerException("zoneId");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // j$.time.ZoneId
    public final String getId() {
        return this.f8260id;
    }

    @Override // j$.time.ZoneId
    public final ZoneRules getRules() {
        ZoneRules zoneRules = this.rules;
        return zoneRules == null ? ZoneRulesProvider.getAuthRequestContext(this.f8260id) : zoneRules;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.time.ZoneId
    public final void write(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.f8260id);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeExternal(DataOutput dataOutput) {
        dataOutput.writeUTF(this.f8260id);
    }
}
