package id.dana.contract.staticqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.staticqr.ScanQrContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ScanQrModule_ProvideViewFactory implements Factory<ScanQrContract.View> {
    private final ScanQrModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ScanQrView> PlaceComponentResult;

    private ScanQrModule_ProvideViewFactory(ScanQrModule scanQrModule, Provider<ScanQrView> provider) {
        this.BuiltInFictitiousFunctionClassFactory = scanQrModule;
        this.PlaceComponentResult = provider;
    }

    public static ScanQrModule_ProvideViewFactory getAuthRequestContext(ScanQrModule scanQrModule, Provider<ScanQrView> provider) {
        return new ScanQrModule_ProvideViewFactory(scanQrModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ScanQrContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
