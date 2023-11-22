package id.dana.explore.data.globalsearch.source;

import dagger.internal.Factory;
import id.dana.explore.data.globalsearch.source.network.NetworkGlobalSearchEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalSearchEntityDataFactory_Factory implements Factory<GlobalSearchEntityDataFactory> {
    private final Provider<NetworkGlobalSearchEntityData> BuiltInFictitiousFunctionClassFactory;

    private GlobalSearchEntityDataFactory_Factory(Provider<NetworkGlobalSearchEntityData> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GlobalSearchEntityDataFactory_Factory PlaceComponentResult(Provider<NetworkGlobalSearchEntityData> provider) {
        return new GlobalSearchEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSearchEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
