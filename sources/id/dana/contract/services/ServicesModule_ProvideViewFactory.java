package id.dana.contract.services;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.services.ServicesContract;

/* loaded from: classes4.dex */
public final class ServicesModule_ProvideViewFactory implements Factory<ServicesContract.View> {
    private final ServicesModule PlaceComponentResult;

    private ServicesModule_ProvideViewFactory(ServicesModule servicesModule) {
        this.PlaceComponentResult = servicesModule;
    }

    public static ServicesModule_ProvideViewFactory MyBillsEntityDataFactory(ServicesModule servicesModule) {
        return new ServicesModule_ProvideViewFactory(servicesModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ServicesContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getPlaceComponentResult());
    }
}
