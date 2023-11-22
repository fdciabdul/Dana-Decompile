package id.dana.contract.paylater;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist;
import id.dana.domain.paylater.interactor.GetPayLaterCacheLoanWhitelist;
import id.dana.domain.paylater.interactor.GetPayLaterLoanStatusWhitelist;
import id.dana.domain.paylater.interactor.GetPaylaterRotationDelayTime;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.interactor.SavePaylaterRotationDelayTime;
import id.dana.domain.paylater.interactor.SetPayLaterLoanCache;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayLaterPresenter_Factory implements Factory<PayLaterPresenter> {
    private final Provider<GetPayLaterCacheLoanWhitelist> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserLoanInfo> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetPayLaterLoanStatusWhitelist> MyBillsEntityDataFactory;
    private final Provider<SavePaylaterRotationDelayTime> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<ClearCachePayLaterLoanWhitelist> PlaceComponentResult;
    private final Provider<GetPaylaterRotationDelayTime> getAuthRequestContext;
    private final Provider<SetPayLaterLoanCache> lookAheadTest;
    private final Provider<UpdatePayLaterLoanCache> moveToNextValue;
    private final Provider<PayLaterContract.View> scheduleImpl;

    private PayLaterPresenter_Factory(Provider<PayLaterContract.View> provider, Provider<ClearCachePayLaterLoanWhitelist> provider2, Provider<GetPayLaterCacheLoanWhitelist> provider3, Provider<GetUserLoanInfo> provider4, Provider<SavePaylaterRotationDelayTime> provider5, Provider<GetPaylaterRotationDelayTime> provider6, Provider<GetPayLaterLoanStatusWhitelist> provider7, Provider<UpdatePayLaterLoanCache> provider8, Provider<SetPayLaterLoanCache> provider9) {
        this.scheduleImpl = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider5;
        this.getAuthRequestContext = provider6;
        this.MyBillsEntityDataFactory = provider7;
        this.moveToNextValue = provider8;
        this.lookAheadTest = provider9;
    }

    public static PayLaterPresenter_Factory getAuthRequestContext(Provider<PayLaterContract.View> provider, Provider<ClearCachePayLaterLoanWhitelist> provider2, Provider<GetPayLaterCacheLoanWhitelist> provider3, Provider<GetUserLoanInfo> provider4, Provider<SavePaylaterRotationDelayTime> provider5, Provider<GetPaylaterRotationDelayTime> provider6, Provider<GetPayLaterLoanStatusWhitelist> provider7, Provider<UpdatePayLaterLoanCache> provider8, Provider<SetPayLaterLoanCache> provider9) {
        return new PayLaterPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PayLaterPresenter(DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
    }
}
