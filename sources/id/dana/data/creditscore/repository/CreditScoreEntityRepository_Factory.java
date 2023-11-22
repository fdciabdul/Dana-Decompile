package id.dana.data.creditscore.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CreditScoreEntityRepository_Factory implements Factory<CreditScoreEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CreditScoreEntityDataFactory> getAuthRequestContext;

    private CreditScoreEntityRepository_Factory(Provider<CreditScoreEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static CreditScoreEntityRepository_Factory BuiltInFictitiousFunctionClassFactory(Provider<CreditScoreEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new CreditScoreEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CreditScoreEntityRepository(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
