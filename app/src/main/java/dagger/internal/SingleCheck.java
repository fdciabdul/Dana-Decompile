package dagger.internal;

import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SingleCheck<T> implements Provider<T> {
    private static final Object getAuthRequestContext = new Object();
    private volatile Object BuiltInFictitiousFunctionClassFactory;
    private volatile Provider<T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final T get() {
        T t = (T) this.BuiltInFictitiousFunctionClassFactory;
        if (t == getAuthRequestContext) {
            Provider<T> provider = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (provider == null) {
                return (T) this.BuiltInFictitiousFunctionClassFactory;
            }
            T t2 = provider.get();
            this.BuiltInFictitiousFunctionClassFactory = t2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            return t2;
        }
        return t;
    }
}
