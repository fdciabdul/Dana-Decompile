package id.dana.danapoly.data.config.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DanapolyPreference_Factory implements Factory<DanapolyPreference> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Serializer> KClassImpl$Data$declaredNonStaticMembers$2;

    private DanapolyPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static DanapolyPreference_Factory getAuthRequestContext(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DanapolyPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyPreference(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
