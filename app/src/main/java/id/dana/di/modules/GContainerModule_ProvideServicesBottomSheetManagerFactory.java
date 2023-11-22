package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.danah5.bottomsheet.service.ServicesBottomSheetManager;

/* loaded from: classes4.dex */
public final class GContainerModule_ProvideServicesBottomSheetManagerFactory implements Factory<ServicesBottomSheetManager> {
    private final GContainerModule getAuthRequestContext;

    private GContainerModule_ProvideServicesBottomSheetManagerFactory(GContainerModule gContainerModule) {
        this.getAuthRequestContext = gContainerModule;
    }

    public static GContainerModule_ProvideServicesBottomSheetManagerFactory PlaceComponentResult(GContainerModule gContainerModule) {
        return new GContainerModule_ProvideServicesBottomSheetManagerFactory(gContainerModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ServicesBottomSheetManager) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory());
    }
}
