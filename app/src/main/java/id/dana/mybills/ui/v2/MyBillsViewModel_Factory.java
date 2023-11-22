package id.dana.mybills.ui.v2;

import dagger.internal.Factory;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig;
import id.dana.mybills.domain.interactor.DeleteSubscriptionBill;
import id.dana.mybills.domain.interactor.GetGeneralProducts;
import id.dana.mybills.domain.interactor.GetHighlightPayTransaction;
import id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.mybills.domain.interactor.GetListHighlightMyBills;
import id.dana.mybills.domain.interactor.GetMonthlyWithConsultView;
import id.dana.mybills.domain.interactor.GetUserCurrentBalance;
import id.dana.mybills.domain.interactor.UpdateSubscriptionBill;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyBillsViewModel_Factory implements Factory<MyBillsViewModel> {
    private final Provider<GetHighlightPayTransaction> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckMyBillsVersionConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetListHighlightMyBills> MyBillsEntityDataFactory;
    private final Provider<UpdateSubscriptionBill> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<DeleteSubscriptionBill> PlaceComponentResult;
    private final Provider<GetGeneralProducts> getAuthRequestContext;
    private final Provider<GetInquirySubscriptionPaylaterWithDestination> getErrorConfigVersion;
    private final Provider<GetUserCurrentBalance> lookAheadTest;
    private final Provider<GetMonthlyWithConsultView> moveToNextValue;

    private MyBillsViewModel_Factory(Provider<GetMonthlyWithConsultView> provider, Provider<GetInquirySubscriptionPaylaterWithDestination> provider2, Provider<GetUserCurrentBalance> provider3, Provider<GetListHighlightMyBills> provider4, Provider<GetHighlightPayTransaction> provider5, Provider<GetGeneralProducts> provider6, Provider<UpdateSubscriptionBill> provider7, Provider<DeleteSubscriptionBill> provider8, Provider<CheckMyBillsVersionConfig> provider9) {
        this.moveToNextValue = provider;
        this.getErrorConfigVersion = provider2;
        this.lookAheadTest = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.getAuthRequestContext = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider7;
        this.PlaceComponentResult = provider8;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider9;
    }

    public static MyBillsViewModel_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GetMonthlyWithConsultView> provider, Provider<GetInquirySubscriptionPaylaterWithDestination> provider2, Provider<GetUserCurrentBalance> provider3, Provider<GetListHighlightMyBills> provider4, Provider<GetHighlightPayTransaction> provider5, Provider<GetGeneralProducts> provider6, Provider<UpdateSubscriptionBill> provider7, Provider<DeleteSubscriptionBill> provider8, Provider<CheckMyBillsVersionConfig> provider9) {
        return new MyBillsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyBillsViewModel(this.moveToNextValue.get(), this.getErrorConfigVersion.get(), this.lookAheadTest.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
