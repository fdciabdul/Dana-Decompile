package id.dana.data.kycrenewal.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.kycrenewal.repository.source.KycRenewalEntityDataFactory;
import id.dana.data.kycrenewal.repository.source.KycRenewalPreferenceEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class KycRenewalEntityRepository_Factory implements Factory<KycRenewalEntityRepository> {
    private final Provider<KycRenewalPreferenceEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<KycRenewalEntityDataFactory> PlaceComponentResult;
    private final Provider<HoldLoginV1EntityRepository> getAuthRequestContext;

    private KycRenewalEntityRepository_Factory(Provider<KycRenewalEntityDataFactory> provider, Provider<KycRenewalPreferenceEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static KycRenewalEntityRepository_Factory BuiltInFictitiousFunctionClassFactory(Provider<KycRenewalEntityDataFactory> provider, Provider<KycRenewalPreferenceEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new KycRenewalEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KycRenewalEntityRepository(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
