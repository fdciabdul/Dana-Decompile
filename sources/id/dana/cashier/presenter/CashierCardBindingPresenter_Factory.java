package id.dana.cashier.presenter;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.cashier.CashierCardBindingContract;
import id.dana.cashier.domain.interactor.AddAssetCardForUser;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrl;
import id.dana.cashier.domain.interactor.GetQueryCardPolicy;
import id.dana.data.config.DeviceInformationProvider;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierCardBindingPresenter_Factory implements Factory<CashierCardBindingPresenter> {
    private final Provider<GetQueryCardPolicy> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetOneklikRedirectUrl> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AddAssetCardForUser> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<DeviceInformationProvider> getAuthRequestContext;
    private final Provider<CashierCardBindingContract.View> lookAheadTest;

    private CashierCardBindingPresenter_Factory(Provider<Context> provider, Provider<CashierCardBindingContract.View> provider2, Provider<GetQueryCardPolicy> provider3, Provider<AddAssetCardForUser> provider4, Provider<DeviceInformationProvider> provider5, Provider<GetOneklikRedirectUrl> provider6) {
        this.PlaceComponentResult = provider;
        this.lookAheadTest = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.getAuthRequestContext = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
    }

    public static CashierCardBindingPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<CashierCardBindingContract.View> provider2, Provider<GetQueryCardPolicy> provider3, Provider<AddAssetCardForUser> provider4, Provider<DeviceInformationProvider> provider5, Provider<GetOneklikRedirectUrl> provider6) {
        return new CashierCardBindingPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierCardBindingPresenter(this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
