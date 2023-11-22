package dagger.internal;

/* loaded from: classes.dex */
public final class Preconditions {
    public static <T> T getAuthRequestContext(T t) {
        return t;
    }

    public static <T> T getAuthRequestContext(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static <T> T BuiltInFictitiousFunctionClassFactory(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    public static <T> T PlaceComponentResult(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable component method");
    }

    public static <T> void KClassImpl$Data$declaredNonStaticMembers$2(T t, Class<T> cls) {
        if (t != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getCanonicalName());
        sb.append(" must be set");
        throw new IllegalStateException(sb.toString());
    }

    private Preconditions() {
    }
}
