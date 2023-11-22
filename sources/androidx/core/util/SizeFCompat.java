package androidx.core.util;

/* loaded from: classes6.dex */
public final class SizeFCompat {
    private final float BuiltInFictitiousFunctionClassFactory;
    private final float getAuthRequestContext;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SizeFCompat) {
            SizeFCompat sizeFCompat = (SizeFCompat) obj;
            return sizeFCompat.BuiltInFictitiousFunctionClassFactory == this.BuiltInFictitiousFunctionClassFactory && sizeFCompat.getAuthRequestContext == this.getAuthRequestContext;
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.BuiltInFictitiousFunctionClassFactory) ^ Float.floatToIntBits(this.getAuthRequestContext);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append("x");
        sb.append(this.getAuthRequestContext);
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    static final class Api21Impl {
        private Api21Impl() {
        }
    }
}
