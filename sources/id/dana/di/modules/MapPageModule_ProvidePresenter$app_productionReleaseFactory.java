package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.danah5.locationpicker.contract.MapPageContract;
import id.dana.danah5.locationpicker.presenter.MapPagePresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MapPageModule_ProvidePresenter$app_productionReleaseFactory implements Factory<MapPageContract.Presenter> {
    private final MapPageModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MapPagePresenter> getAuthRequestContext;

    public static MapPageContract.Presenter getAuthRequestContext(MapPageModule mapPageModule, MapPagePresenter mapPagePresenter) {
        return (MapPageContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(mapPageModule.MyBillsEntityDataFactory(mapPagePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MapPageContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
