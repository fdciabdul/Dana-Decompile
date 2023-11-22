package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.kycrenewal.KycRenewalContract;
import id.dana.kycrenewal.KycRenewalPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class KycRenewalModule_ProvidePresenter$app_productionReleaseFactory implements Factory<KycRenewalContract.Presenter> {
    private final Provider<KycRenewalPresenter> MyBillsEntityDataFactory;
    private final KycRenewalModule PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KycRenewalContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
