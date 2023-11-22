package id.dana.savings.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.saving.interactor.CreateSaving;
import id.dana.domain.saving.interactor.InitSavingCreate;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.savings.contract.SavingCreateContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SavingCreatePresenter_Factory implements Factory<SavingCreatePresenter> {
    private final Provider<SavingCreateContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<InitSavingCreate> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<GetUserInfoWithKyc> PlaceComponentResult;
    private final Provider<CreateSaving> getAuthRequestContext;

    private SavingCreatePresenter_Factory(Provider<Context> provider, Provider<SavingCreateContract.View> provider2, Provider<InitSavingCreate> provider3, Provider<CreateSaving> provider4, Provider<GetUserInfoWithKyc> provider5) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.getAuthRequestContext = provider4;
        this.PlaceComponentResult = provider5;
    }

    public static SavingCreatePresenter_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<SavingCreateContract.View> provider2, Provider<InitSavingCreate> provider3, Provider<CreateSaving> provider4, Provider<GetUserInfoWithKyc> provider5) {
        return new SavingCreatePresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SavingCreatePresenter(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
