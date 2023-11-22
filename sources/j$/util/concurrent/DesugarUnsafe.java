package j$.util.concurrent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
abstract class DesugarUnsafe {
    private static final Unsafe getAuthRequestContext;

    static {
        Field PlaceComponentResult = PlaceComponentResult();
        PlaceComponentResult.setAccessible(true);
        try {
            getAuthRequestContext = (Unsafe) PlaceComponentResult.get(null);
        } catch (IllegalAccessException e) {
            throw new Error("Couldn't get the Unsafe", e);
        }
    }

    public static final int KClassImpl$Data$declaredNonStaticMembers$2(Unsafe unsafe, Object obj, long j) {
        int intVolatile;
        do {
            intVolatile = unsafe.getIntVolatile(obj, j);
        } while (!unsafe.compareAndSwapInt(obj, j, intVolatile, intVolatile - 4));
        return intVolatile;
    }

    private static Field PlaceComponentResult() {
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Unsafe.class.isAssignableFrom(field.getType())) {
                    return field;
                }
            }
            throw new Error("Couldn't find the Unsafe", e);
        }
    }
}
