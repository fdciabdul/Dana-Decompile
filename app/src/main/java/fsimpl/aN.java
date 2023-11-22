package fsimpl;

import android.graphics.PorterDuff;
import java.lang.reflect.Field;
import java.util.HashSet;

/* loaded from: classes4.dex */
public class aN {
    private static int[] b;

    /* renamed from: a  reason: collision with root package name */
    private static int[] f7830a = new int[PorterDuff.Mode.values().length];
    private static boolean c = false;

    static {
        a();
    }

    public static int a(int i) {
        if (c && i >= 0) {
            int[] iArr = b;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        return 0;
    }

    public static int a(PorterDuff.Mode mode) {
        if (c) {
            int ordinal = mode.ordinal();
            int[] iArr = f7830a;
            if (ordinal >= iArr.length) {
                return 0;
            }
            return iArr[ordinal];
        }
        return 0;
    }

    private static void a() {
        try {
            HashSet hashSet = new HashSet();
            int i = 0;
            for (PorterDuff.Mode mode : PorterDuff.Mode.values()) {
                i = Math.max(b(mode), i);
                hashSet.add(mode.name());
            }
            b = new int[i + 1];
            for (Field field : cA.class.getDeclaredFields()) {
                if (field.getType() == Byte.TYPE) {
                    byte b2 = field.getByte(null);
                    String name = cA.name(b2);
                    if (hashSet.contains(name)) {
                        PorterDuff.Mode valueOf = PorterDuff.Mode.valueOf(name);
                        int b3 = b(valueOf);
                        int ordinal = valueOf.ordinal();
                        b[b3] = b2;
                        f7830a[ordinal] = b2;
                        c = true;
                    }
                }
            }
        } catch (Throwable th) {
            cS.a("Failed to get nativeInt field mappings", th);
        }
    }

    private static int b(PorterDuff.Mode mode) {
        return mode.nativeInt;
    }
}
