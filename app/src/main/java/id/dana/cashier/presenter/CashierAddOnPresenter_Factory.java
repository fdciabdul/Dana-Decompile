package id.dana.cashier.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.cashier.CashierAddOnContract;
import id.dana.cashier.domain.interactor.GetCashierAddOnInfo;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierAddOnPresenter_Factory implements Factory<CashierAddOnPresenter> {
    private final Provider<CashierAddOnContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<GetCashierAddOnInfo> PlaceComponentResult;

    private CashierAddOnPresenter_Factory(Provider<GetCashierAddOnInfo> provider, Provider<CashierAddOnContract.View> provider2, Provider<Context> provider3) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static CashierAddOnPresenter_Factory PlaceComponentResult(Provider<GetCashierAddOnInfo> provider, Provider<CashierAddOnContract.View> provider2, Provider<Context> provider3) {
        return new CashierAddOnPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierAddOnPresenter(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
