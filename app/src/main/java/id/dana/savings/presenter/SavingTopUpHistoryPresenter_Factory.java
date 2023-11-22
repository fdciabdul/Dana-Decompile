package id.dana.savings.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.saving.interactor.GetSavingDetail;
import id.dana.savings.contract.SavingTopUpHistoryContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SavingTopUpHistoryPresenter_Factory implements Factory<SavingTopUpHistoryPresenter> {
    private final Provider<SavingTopUpHistoryContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<GetSavingDetail> getAuthRequestContext;

    private SavingTopUpHistoryPresenter_Factory(Provider<Context> provider, Provider<SavingTopUpHistoryContract.View> provider2, Provider<GetSavingDetail> provider3) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static SavingTopUpHistoryPresenter_Factory getAuthRequestContext(Provider<Context> provider, Provider<SavingTopUpHistoryContract.View> provider2, Provider<GetSavingDetail> provider3) {
        return new SavingTopUpHistoryPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SavingTopUpHistoryPresenter(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
