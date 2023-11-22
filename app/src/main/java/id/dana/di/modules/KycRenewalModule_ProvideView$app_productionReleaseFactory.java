package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.kycrenewal.KycRenewalContract;

/* loaded from: classes4.dex */
public final class KycRenewalModule_ProvideView$app_productionReleaseFactory implements Factory<KycRenewalContract.View> {
    private final KycRenewalModule KClassImpl$Data$declaredNonStaticMembers$2;

    private KycRenewalModule_ProvideView$app_productionReleaseFactory(KycRenewalModule kycRenewalModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = kycRenewalModule;
    }

    public static KycRenewalModule_ProvideView$app_productionReleaseFactory PlaceComponentResult(KycRenewalModule kycRenewalModule) {
        return new KycRenewalModule_ProvideView$app_productionReleaseFactory(kycRenewalModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KycRenewalContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
