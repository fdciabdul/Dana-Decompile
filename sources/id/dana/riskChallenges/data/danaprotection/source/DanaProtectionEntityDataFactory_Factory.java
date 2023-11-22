package id.dana.riskChallenges.data.danaprotection.source;

import dagger.internal.Factory;
import id.dana.riskChallenges.data.danaprotection.source.network.NetworkDanaProtectionEntityData;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DanaProtectionEntityDataFactory_Factory implements Factory<DanaProtectionEntityDataFactory> {
    private final Provider<NetworkDanaProtectionEntityData> BuiltInFictitiousFunctionClassFactory;

    private DanaProtectionEntityDataFactory_Factory(Provider<NetworkDanaProtectionEntityData> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static DanaProtectionEntityDataFactory_Factory PlaceComponentResult(Provider<NetworkDanaProtectionEntityData> provider) {
        return new DanaProtectionEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaProtectionEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
