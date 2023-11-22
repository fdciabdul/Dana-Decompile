package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tncsummary.TncSummaryPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TncSummaryModules_ProvideTncSummaryPresenterFactory implements Factory<TncSummaryContract.Presenter> {
    private final Provider<TncSummaryPresenter> BuiltInFictitiousFunctionClassFactory;
    private final TncSummaryModules getAuthRequestContext;

    private TncSummaryModules_ProvideTncSummaryPresenterFactory(TncSummaryModules tncSummaryModules, Provider<TncSummaryPresenter> provider) {
        this.getAuthRequestContext = tncSummaryModules;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static TncSummaryModules_ProvideTncSummaryPresenterFactory PlaceComponentResult(TncSummaryModules tncSummaryModules, Provider<TncSummaryPresenter> provider) {
        return new TncSummaryModules_ProvideTncSummaryPresenterFactory(tncSummaryModules, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TncSummaryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
