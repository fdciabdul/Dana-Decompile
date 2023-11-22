package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.danah5.locationpicker.contract.MapPageContract;

/* loaded from: classes8.dex */
public final class MapPageModule_ProvideView$app_productionReleaseFactory implements Factory<MapPageContract.View> {
    private final MapPageModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static MapPageContract.View PlaceComponentResult(MapPageModule mapPageModule) {
        return (MapPageContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(mapPageModule.getMyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MapPageContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getMyBillsEntityDataFactory());
    }
}
