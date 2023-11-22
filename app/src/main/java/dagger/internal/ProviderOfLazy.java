package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ProviderOfLazy<T> implements Provider<Lazy<T>> {
    private final Provider<T> BuiltInFictitiousFunctionClassFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
    }
}
