package id.dana.riskChallenges.data.danaprotection;

import dagger.internal.Factory;
import id.dana.riskChallenges.data.danaprotection.source.DanaProtectionEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DanaProtectionEntityRepository_Factory implements Factory<DanaProtectionEntityRepository> {
    private final Provider<DanaProtectionEntityDataFactory> PlaceComponentResult;

    private DanaProtectionEntityRepository_Factory(Provider<DanaProtectionEntityDataFactory> provider) {
        this.PlaceComponentResult = provider;
    }

    public static DanaProtectionEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<DanaProtectionEntityDataFactory> provider) {
        return new DanaProtectionEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaProtectionEntityRepository(this.PlaceComponentResult.get());
    }
}
