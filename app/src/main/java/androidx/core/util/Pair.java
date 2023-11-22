package androidx.core.util;

/* loaded from: classes.dex */
public class Pair<F, S> {
    public final S PlaceComponentResult;
    public final F getAuthRequestContext;

    public Pair(F f, S s) {
        this.getAuthRequestContext = f;
        this.PlaceComponentResult = s;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return ObjectsCompat.MyBillsEntityDataFactory(pair.getAuthRequestContext, this.getAuthRequestContext) && ObjectsCompat.MyBillsEntityDataFactory(pair.PlaceComponentResult, this.PlaceComponentResult);
        }
        return false;
    }

    public int hashCode() {
        F f = this.getAuthRequestContext;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.PlaceComponentResult;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pair{");
        sb.append(this.getAuthRequestContext);
        sb.append(" ");
        sb.append(this.PlaceComponentResult);
        sb.append("}");
        return sb.toString();
    }

    public static <A, B> Pair<A, B> MyBillsEntityDataFactory(A a2, B b) {
        return new Pair<>(a2, b);
    }
}
