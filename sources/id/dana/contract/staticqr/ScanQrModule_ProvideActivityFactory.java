package id.dana.contract.staticqr;

import android.app.Activity;
import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class ScanQrModule_ProvideActivityFactory implements Factory<Activity> {
    private final ScanQrModule PlaceComponentResult;

    private ScanQrModule_ProvideActivityFactory(ScanQrModule scanQrModule) {
        this.PlaceComponentResult = scanQrModule;
    }

    public static ScanQrModule_ProvideActivityFactory getAuthRequestContext(ScanQrModule scanQrModule) {
        return new ScanQrModule_ProvideActivityFactory(scanQrModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
