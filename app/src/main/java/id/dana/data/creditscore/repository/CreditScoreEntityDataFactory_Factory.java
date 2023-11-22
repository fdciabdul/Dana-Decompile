package id.dana.data.creditscore.repository;

import dagger.internal.Factory;
import id.dana.data.creditscore.repository.source.network.NetworkCreditScoreEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CreditScoreEntityDataFactory_Factory implements Factory<CreditScoreEntityDataFactory> {
    private final Provider<NetworkCreditScoreEntityData> BuiltInFictitiousFunctionClassFactory;

    private CreditScoreEntityDataFactory_Factory(Provider<NetworkCreditScoreEntityData> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static CreditScoreEntityDataFactory_Factory PlaceComponentResult(Provider<NetworkCreditScoreEntityData> provider) {
        return new CreditScoreEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CreditScoreEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
