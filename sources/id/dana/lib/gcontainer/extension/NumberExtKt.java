package id.dana.lib.gcontainer.extension;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u001d\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\n\u001a\u001d\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\u000e"}, d2 = {"", "", "defaultValue", "toSafeFloat", "(Ljava/lang/Number;F)F", "", "(Ljava/lang/String;F)F", "", "toSafeInt", "(Ljava/lang/Number;I)I", "(Ljava/lang/String;I)I", "", "toSafeLong", "(Ljava/lang/Number;J)J", "(Ljava/lang/String;J)J"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class NumberExtKt {
    public static /* synthetic */ long toSafeLong$default(String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return toSafeLong(str, j);
    }

    public static final long toSafeLong(String str, long j) {
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return j;
            }
        }
        return j;
    }

    public static /* synthetic */ long toSafeLong$default(Number number, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return toSafeLong(number, j);
    }

    public static final long toSafeLong(Number number, long j) {
        if (number != null) {
            try {
                return number.longValue();
            } catch (NumberFormatException unused) {
                return j;
            }
        }
        return j;
    }

    public static /* synthetic */ int toSafeInt$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return toSafeInt(str, i);
    }

    public static final int toSafeInt(String str, int i) {
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i;
    }

    public static /* synthetic */ int toSafeInt$default(Number number, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return toSafeInt(number, i);
    }

    public static final int toSafeInt(Number number, int i) {
        if (number != null) {
            try {
                return number.intValue();
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i;
    }

    public static /* synthetic */ float toSafeFloat$default(String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        return toSafeFloat(str, f);
    }

    public static final float toSafeFloat(String str, float f) {
        if (str != null) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                return f;
            }
        }
        return f;
    }

    public static /* synthetic */ float toSafeFloat$default(Number number, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        return toSafeFloat(number, f);
    }

    public static final float toSafeFloat(Number number, float f) {
        if (number != null) {
            try {
                return number.floatValue();
            } catch (NumberFormatException unused) {
                return f;
            }
        }
        return f;
    }
}
