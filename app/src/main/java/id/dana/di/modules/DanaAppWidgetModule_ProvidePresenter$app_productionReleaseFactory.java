package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.appwidget.DanaAppWidgetContract;
import id.dana.appwidget.DanaAppWidgetPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DanaAppWidgetModule_ProvidePresenter$app_productionReleaseFactory implements Factory<DanaAppWidgetContract.Presenter> {
    private final Provider<DanaAppWidgetPresenter> BuiltInFictitiousFunctionClassFactory;
    private final DanaAppWidgetModule MyBillsEntityDataFactory;

    private DanaAppWidgetModule_ProvidePresenter$app_productionReleaseFactory(DanaAppWidgetModule danaAppWidgetModule, Provider<DanaAppWidgetPresenter> provider) {
        this.MyBillsEntityDataFactory = danaAppWidgetModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static DanaAppWidgetModule_ProvidePresenter$app_productionReleaseFactory MyBillsEntityDataFactory(DanaAppWidgetModule danaAppWidgetModule, Provider<DanaAppWidgetPresenter> provider) {
        return new DanaAppWidgetModule_ProvidePresenter$app_productionReleaseFactory(danaAppWidgetModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaAppWidgetContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
