package id.dana.contract.payqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payqr.OfflinePayContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OfflinePayModule_ProvidePresenterFactory implements Factory<OfflinePayContract.Presenter> {
    private final Provider<OfflinePayPresenter> MyBillsEntityDataFactory;
    private final OfflinePayModule PlaceComponentResult;

    private OfflinePayModule_ProvidePresenterFactory(OfflinePayModule offlinePayModule, Provider<OfflinePayPresenter> provider) {
        this.PlaceComponentResult = offlinePayModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static OfflinePayModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(OfflinePayModule offlinePayModule, Provider<OfflinePayPresenter> provider) {
        return new OfflinePayModule_ProvidePresenterFactory(offlinePayModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OfflinePayContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
