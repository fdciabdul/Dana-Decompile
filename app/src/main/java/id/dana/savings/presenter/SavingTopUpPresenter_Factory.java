package id.dana.savings.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.saving.interactor.InitSavingTopUp;
import id.dana.domain.saving.interactor.TopUpSaving;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.savings.contract.SavingTopUpContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SavingTopUpPresenter_Factory implements Factory<SavingTopUpPresenter> {
    private final Provider<InitSavingTopUp> BuiltInFictitiousFunctionClassFactory;
    private final Provider<TopUpSaving> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetUserInfoWithKyc> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<SavingTopUpContract.View> getAuthRequestContext;

    private SavingTopUpPresenter_Factory(Provider<Context> provider, Provider<SavingTopUpContract.View> provider2, Provider<InitSavingTopUp> provider3, Provider<TopUpSaving> provider4, Provider<GetUserInfoWithKyc> provider5) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.MyBillsEntityDataFactory = provider5;
    }

    public static SavingTopUpPresenter_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<SavingTopUpContract.View> provider2, Provider<InitSavingTopUp> provider3, Provider<TopUpSaving> provider4, Provider<GetUserInfoWithKyc> provider5) {
        return new SavingTopUpPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SavingTopUpPresenter(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
