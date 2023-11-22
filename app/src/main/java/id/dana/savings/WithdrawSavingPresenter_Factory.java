package id.dana.savings;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.saving.interactor.GetWithdrawOption;
import id.dana.domain.saving.interactor.InitSavingWithdraw;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.savings.contract.WithdrawSavingContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class WithdrawSavingPresenter_Factory implements Factory<WithdrawSavingPresenter> {
    private final Provider<InitSavingWithdraw> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetWithdrawOption> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetUserInfoWithKyc> MyBillsEntityDataFactory;
    private final Provider<WithdrawSavingContract.View> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private WithdrawSavingPresenter_Factory(Provider<WithdrawSavingContract.View> provider, Provider<Context> provider2, Provider<GetUserInfoWithKyc> provider3, Provider<GetWithdrawOption> provider4, Provider<InitSavingWithdraw> provider5) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
    }

    public static WithdrawSavingPresenter_Factory PlaceComponentResult(Provider<WithdrawSavingContract.View> provider, Provider<Context> provider2, Provider<GetUserInfoWithKyc> provider3, Provider<GetWithdrawOption> provider4, Provider<InitSavingWithdraw> provider5) {
        return new WithdrawSavingPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new WithdrawSavingPresenter(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
