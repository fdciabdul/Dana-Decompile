package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.service.ExploreServiceContract;
import id.dana.explore.service.presenter.ExploreServicePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ExploreServiceModule_ProvidePresenterFactory implements Factory<ExploreServiceContract.Presenter> {
    private final ExploreServiceModule PlaceComponentResult;
    private final Provider<ExploreServicePresenter> getAuthRequestContext;

    public static ExploreServiceContract.Presenter MyBillsEntityDataFactory(ExploreServiceModule exploreServiceModule, ExploreServicePresenter exploreServicePresenter) {
        return (ExploreServiceContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(exploreServiceModule.MyBillsEntityDataFactory(exploreServicePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ExploreServiceContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
