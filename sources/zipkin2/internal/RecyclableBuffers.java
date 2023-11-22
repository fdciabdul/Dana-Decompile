package zipkin2.internal;

/* loaded from: classes6.dex */
public final class RecyclableBuffers {
    static final ThreadLocal<char[]> PlaceComponentResult = new ThreadLocal<>();

    RecyclableBuffers() {
    }

    public static char[] BuiltInFictitiousFunctionClassFactory() {
        ThreadLocal<char[]> threadLocal = PlaceComponentResult;
        char[] cArr = threadLocal.get();
        if (cArr == null) {
            char[] cArr2 = new char[256];
            threadLocal.set(cArr2);
            return cArr2;
        }
        return cArr;
    }
}
