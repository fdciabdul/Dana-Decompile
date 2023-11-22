package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.ActivityReactionsContract;
import id.dana.social.presenter.ActivityReactionsPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ActivityReactionsModule_ProvidePresenter$app_productionReleaseFactory implements Factory<ActivityReactionsContract.Presenter> {
    private final ActivityReactionsModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ActivityReactionsPresenter> PlaceComponentResult;

    public static ActivityReactionsContract.Presenter MyBillsEntityDataFactory(ActivityReactionsModule activityReactionsModule, ActivityReactionsPresenter activityReactionsPresenter) {
        return (ActivityReactionsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(activityReactionsModule.BuiltInFictitiousFunctionClassFactory(activityReactionsPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ActivityReactionsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
