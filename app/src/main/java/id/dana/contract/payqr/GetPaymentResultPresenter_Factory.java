package id.dana.contract.payqr;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.payqr.GetPaymentResultContract;
import id.dana.domain.globalnetwork.interactor.ClearAllPaymentCodes;
import id.dana.domain.globalnetwork.interactor.GetUniPaymentResult;
import id.dana.domain.qrpay.interactor.GetPaymentResult;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPaymentResultPresenter_Factory implements Factory<GetPaymentResultPresenter> {
    private final Provider<GetPaymentResultContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUniPaymentResult> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetPaymentResult> MyBillsEntityDataFactory;
    private final Provider<ClearAllPaymentCodes> getAuthRequestContext;

    private GetPaymentResultPresenter_Factory(Provider<GetPaymentResultContract.View> provider, Provider<GetPaymentResult> provider2, Provider<GetUniPaymentResult> provider3, Provider<ClearAllPaymentCodes> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static GetPaymentResultPresenter_Factory getAuthRequestContext(Provider<GetPaymentResultContract.View> provider, Provider<GetPaymentResult> provider2, Provider<GetUniPaymentResult> provider3, Provider<ClearAllPaymentCodes> provider4) {
        return new GetPaymentResultPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetPaymentResultPresenter(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
