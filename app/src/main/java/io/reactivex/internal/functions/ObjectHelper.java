package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

/* loaded from: classes.dex */
public final class ObjectHelper {
    static final BiPredicate<Object, Object> KClassImpl$Data$declaredNonStaticMembers$2 = new BiObjectPredicate();

    public static int BuiltInFictitiousFunctionClassFactory(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static int getAuthRequestContext(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> T PlaceComponentResult(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean getAuthRequestContext(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> BiPredicate<T, T> KClassImpl$Data$declaredNonStaticMembers$2() {
        return (BiPredicate<T, T>) KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static int BuiltInFictitiousFunctionClassFactory(int i, String str) {
        if (i > 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" > 0 required but it was ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static long BuiltInFictitiousFunctionClassFactory(long j, String str) {
        if (j > 0) {
            return j;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" > 0 required but it was ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* loaded from: classes.dex */
    static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        BiObjectPredicate() {
        }

        @Override // io.reactivex.functions.BiPredicate
        public final boolean BuiltInFictitiousFunctionClassFactory(Object obj, Object obj2) {
            return ObjectHelper.getAuthRequestContext(obj, obj2);
        }
    }
}
