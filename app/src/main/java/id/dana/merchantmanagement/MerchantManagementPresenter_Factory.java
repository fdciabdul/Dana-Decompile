package id.dana.merchantmanagement;

import dagger.internal.Factory;
import id.dana.domain.merchantmanagement.interactor.CheckUnbindEligibility;
import id.dana.domain.merchantmanagement.interactor.ConsultUnbind;
import id.dana.domain.merchantmanagement.interactor.GetHomeShoppingBanner;
import id.dana.domain.merchantmanagement.interactor.GetLinkedMerchants;
import id.dana.merchantmanagement.MerchantManagementContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class MerchantManagementPresenter_Factory implements Factory<MerchantManagementPresenter> {
    private final Provider<MerchantManagementContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ConsultUnbind> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckUnbindEligibility> MyBillsEntityDataFactory;
    private final Provider<GetLinkedMerchants> PlaceComponentResult;
    private final Provider<GetHomeShoppingBanner> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantManagementPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
