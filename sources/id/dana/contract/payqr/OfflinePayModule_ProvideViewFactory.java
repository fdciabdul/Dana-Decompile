package id.dana.contract.payqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payqr.OfflinePayContract;

/* loaded from: classes4.dex */
public final class OfflinePayModule_ProvideViewFactory implements Factory<OfflinePayContract.View> {
    private final OfflinePayModule KClassImpl$Data$declaredNonStaticMembers$2;

    private OfflinePayModule_ProvideViewFactory(OfflinePayModule offlinePayModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = offlinePayModule;
    }

    public static OfflinePayModule_ProvideViewFactory getAuthRequestContext(OfflinePayModule offlinePayModule) {
        return new OfflinePayModule_ProvideViewFactory(offlinePayModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OfflinePayContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
    }
}
