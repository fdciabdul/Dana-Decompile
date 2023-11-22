package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.animation.ScanQrLoyaltyContract;

/* loaded from: classes8.dex */
public final class ScanQrLoyaltyModule_ProvidScanQrLoyaltyViewFactory implements Factory<ScanQrLoyaltyContract.View> {
    private final ScanQrLoyaltyModule getAuthRequestContext;

    private ScanQrLoyaltyModule_ProvidScanQrLoyaltyViewFactory(ScanQrLoyaltyModule scanQrLoyaltyModule) {
        this.getAuthRequestContext = scanQrLoyaltyModule;
    }

    public static ScanQrLoyaltyModule_ProvidScanQrLoyaltyViewFactory MyBillsEntityDataFactory(ScanQrLoyaltyModule scanQrLoyaltyModule) {
        return new ScanQrLoyaltyModule_ProvidScanQrLoyaltyViewFactory(scanQrLoyaltyModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ScanQrLoyaltyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getBuiltInFictitiousFunctionClassFactory());
    }
}
