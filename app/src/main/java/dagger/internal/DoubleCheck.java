package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    private static final Object BuiltInFictitiousFunctionClassFactory = new Object();
    private volatile Provider<T> KClassImpl$Data$declaredNonStaticMembers$2;
    private volatile Object PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;

    private DoubleCheck(Provider<T> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    @Override // javax.inject.Provider
    public final T get() {
        T t = (T) this.PlaceComponentResult;
        Object obj = BuiltInFictitiousFunctionClassFactory;
        if (t == obj) {
            synchronized (this) {
                t = this.PlaceComponentResult;
                if (t == obj) {
                    t = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
                    Object obj2 = this.PlaceComponentResult;
                    if ((obj2 != BuiltInFictitiousFunctionClassFactory) && obj2 != t) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(obj2);
                        sb.append(" & ");
                        sb.append(t);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.PlaceComponentResult = t;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                }
            }
        }
        return t;
    }

    public static <P extends Provider<T>, T> Provider<T> getAuthRequestContext(P p) {
        Preconditions.getAuthRequestContext(p);
        return p instanceof DoubleCheck ? p : new DoubleCheck(p);
    }

    public static <P extends Provider<T>, T> Lazy<T> MyBillsEntityDataFactory(P p) {
        if (p instanceof Lazy) {
            return (Lazy) p;
        }
        return new DoubleCheck((Provider) Preconditions.getAuthRequestContext(p));
    }
}
