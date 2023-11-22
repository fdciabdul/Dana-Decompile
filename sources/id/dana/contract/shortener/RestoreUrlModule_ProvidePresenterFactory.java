package id.dana.contract.shortener;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.shortener.RestoreUrlContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RestoreUrlModule_ProvidePresenterFactory implements Factory<RestoreUrlContract.Presenter> {
    private final Provider<RestoreUrlPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final RestoreUrlModule MyBillsEntityDataFactory;

    private RestoreUrlModule_ProvidePresenterFactory(RestoreUrlModule restoreUrlModule, Provider<RestoreUrlPresenter> provider) {
        this.MyBillsEntityDataFactory = restoreUrlModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static RestoreUrlModule_ProvidePresenterFactory PlaceComponentResult(RestoreUrlModule restoreUrlModule, Provider<RestoreUrlPresenter> provider) {
        return new RestoreUrlModule_ProvidePresenterFactory(restoreUrlModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RestoreUrlContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
