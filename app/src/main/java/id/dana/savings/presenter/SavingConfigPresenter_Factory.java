package id.dana.savings.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.saving.interactor.GetSavingBalanceVisibility;
import id.dana.domain.saving.interactor.SaveSavingBalanceVisibility;
import id.dana.savings.contract.SavingConfigContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SavingConfigPresenter_Factory implements Factory<SavingConfigPresenter> {
    private final Provider<GetSavingBalanceVisibility> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SaveSavingBalanceVisibility> MyBillsEntityDataFactory;
    private final Provider<SavingConfigContract.View> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private SavingConfigPresenter_Factory(Provider<Context> provider, Provider<SavingConfigContract.View> provider2, Provider<GetSavingBalanceVisibility> provider3, Provider<SaveSavingBalanceVisibility> provider4) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static SavingConfigPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<SavingConfigContract.View> provider2, Provider<GetSavingBalanceVisibility> provider3, Provider<SaveSavingBalanceVisibility> provider4) {
        return new SavingConfigPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SavingConfigPresenter(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
