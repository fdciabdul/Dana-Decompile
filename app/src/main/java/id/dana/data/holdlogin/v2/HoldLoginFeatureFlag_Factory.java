package id.dana.data.holdlogin.v2;

import dagger.internal.Factory;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.domain.account.LiteAccountRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HoldLoginFeatureFlag_Factory implements Factory<HoldLoginFeatureFlag> {
    private final Provider<SharedPrefStartupConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<LiteAccountRepository> PlaceComponentResult;

    private HoldLoginFeatureFlag_Factory(Provider<SharedPrefStartupConfig> provider, Provider<LiteAccountRepository> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static HoldLoginFeatureFlag_Factory MyBillsEntityDataFactory(Provider<SharedPrefStartupConfig> provider, Provider<LiteAccountRepository> provider2) {
        return new HoldLoginFeatureFlag_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HoldLoginFeatureFlag(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
