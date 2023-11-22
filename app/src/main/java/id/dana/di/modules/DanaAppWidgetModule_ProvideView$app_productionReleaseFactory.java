package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.appwidget.DanaAppWidgetContract;

/* loaded from: classes8.dex */
public final class DanaAppWidgetModule_ProvideView$app_productionReleaseFactory implements Factory<DanaAppWidgetContract.View> {
    private final DanaAppWidgetModule KClassImpl$Data$declaredNonStaticMembers$2;

    private DanaAppWidgetModule_ProvideView$app_productionReleaseFactory(DanaAppWidgetModule danaAppWidgetModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaAppWidgetModule;
    }

    public static DanaAppWidgetModule_ProvideView$app_productionReleaseFactory MyBillsEntityDataFactory(DanaAppWidgetModule danaAppWidgetModule) {
        return new DanaAppWidgetModule_ProvideView$app_productionReleaseFactory(danaAppWidgetModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaAppWidgetContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
