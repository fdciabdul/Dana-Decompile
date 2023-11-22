package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.news.LatestNewsContract;
import id.dana.news.presenter.LatestNewsPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class LatestNewsModule_ProvidePresenterFactory implements Factory<LatestNewsContract.Presenter> {
    private final Provider<LatestNewsPresenter> MyBillsEntityDataFactory;
    private final LatestNewsModule PlaceComponentResult;

    private LatestNewsModule_ProvidePresenterFactory(LatestNewsModule latestNewsModule, Provider<LatestNewsPresenter> provider) {
        this.PlaceComponentResult = latestNewsModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static LatestNewsModule_ProvidePresenterFactory getAuthRequestContext(LatestNewsModule latestNewsModule, Provider<LatestNewsPresenter> provider) {
        return new LatestNewsModule_ProvidePresenterFactory(latestNewsModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LatestNewsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
