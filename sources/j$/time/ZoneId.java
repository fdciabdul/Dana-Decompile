package j$.time;

import com.google.common.net.HttpHeaders;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.zone.ZoneRules;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public abstract class ZoneId implements Serializable {
    public static final Map SHORT_IDS;
    private static final long serialVersionUID = 8352817235686L;

    static {
        HashMap hashMap = new HashMap(64);
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put(HttpHeaders.ECT, "Europe/Paris");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("NST", "Pacific/Auckland");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("EST", "-05:00");
        hashMap.put("MST", "-07:00");
        hashMap.put("HST", "-10:00");
        SHORT_IDS = Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != ZoneRegion.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static ZoneId from(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.query(Temporal.CC.getErrorConfigVersion());
        if (zoneId != null) {
            return zoneId;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to obtain ZoneId from TemporalAccessor: ");
        sb.append(temporalAccessor);
        sb.append(" of type ");
        sb.append(temporalAccessor.getClass().getName());
        throw new DateTimeException(sb.toString());
    }

    public static ZoneId of(String str) {
        return of(str, true);
    }

    public static ZoneId of(String str, Map map) {
        if (str != null) {
            if (map != null) {
                String str2 = (String) map.get(str);
                if (str2 != null) {
                    str = str2;
                }
                return of(str, true);
            }
            throw new NullPointerException("aliasMap");
        }
        throw new NullPointerException("zoneId");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneId of(String str, boolean z) {
        int i;
        if (str != null) {
            if (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) {
                return ZoneOffset.of(str);
            }
            if (str.startsWith("UTC") || str.startsWith("GMT")) {
                i = 3;
            } else if (!str.startsWith("UT")) {
                return ZoneRegion.ofId(str, z);
            } else {
                i = 2;
            }
            return ofWithPrefix(str, i, z);
        }
        throw new NullPointerException("zoneId");
    }

    public static ZoneId ofOffset(String str, ZoneOffset zoneOffset) {
        if (str != null) {
            if (zoneOffset != null) {
                if (str.length() == 0) {
                    return zoneOffset;
                }
                if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
                    if (zoneOffset.getTotalSeconds() != 0) {
                        str = str.concat(zoneOffset.getId());
                    }
                    return new ZoneRegion(str, ZoneRules.of(zoneOffset));
                }
                StringBuilder sb = new StringBuilder();
                sb.append("prefix should be GMT, UTC or UT, is: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new NullPointerException("offset");
        }
        throw new NullPointerException("prefix");
    }

    private static ZoneId ofWithPrefix(String str, int i, boolean z) {
        String substring = str.substring(0, i);
        if (str.length() == i) {
            return ofOffset(substring, ZoneOffset.UTC);
        }
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            try {
                ZoneOffset of = ZoneOffset.of(str.substring(i));
                return of == ZoneOffset.UTC ? ofOffset(substring, of) : ofOffset(substring, of);
            } catch (DateTimeException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid ID for offset-based ZoneId: ");
                sb.append(str);
                throw new DateTimeException(sb.toString(), e);
            }
        }
        return ZoneRegion.ofId(str, z);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return getId().equals(((ZoneId) obj).getId());
        }
        return false;
    }

    public abstract String getId();

    public abstract ZoneRules getRules();

    public int hashCode() {
        return getId().hashCode();
    }

    public String toString() {
        return getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void write(DataOutput dataOutput);
}
