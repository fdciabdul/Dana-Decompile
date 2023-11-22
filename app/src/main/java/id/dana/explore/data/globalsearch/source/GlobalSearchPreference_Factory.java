package id.dana.explore.data.globalsearch.source;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalSearchPreference_Factory implements Factory<GlobalSearchPreference> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private GlobalSearchPreference_Factory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GlobalSearchPreference_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider) {
        return new GlobalSearchPreference_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSearchPreference(this.MyBillsEntityDataFactory.get());
    }
}
