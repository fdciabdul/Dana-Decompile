package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.kycamledd.KycAmlEddContract;

/* loaded from: classes4.dex */
public final class KycAmlEddModule_ProvideView$app_productionReleaseFactory implements Factory<KycAmlEddContract.View> {
    private final KycAmlEddModule KClassImpl$Data$declaredNonStaticMembers$2;

    private KycAmlEddModule_ProvideView$app_productionReleaseFactory(KycAmlEddModule kycAmlEddModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = kycAmlEddModule;
    }

    public static KycAmlEddModule_ProvideView$app_productionReleaseFactory getAuthRequestContext(KycAmlEddModule kycAmlEddModule) {
        return new KycAmlEddModule_ProvideView$app_productionReleaseFactory(kycAmlEddModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KycAmlEddContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
