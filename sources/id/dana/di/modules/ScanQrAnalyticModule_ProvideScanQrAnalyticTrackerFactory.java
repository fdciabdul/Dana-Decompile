package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.scanner.tracker.ScannerMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ScanQrAnalyticModule_ProvideScanQrAnalyticTrackerFactory implements Factory<ScannerMixpanelTracker> {
    private final Provider<Context> PlaceComponentResult;
    private final ScanQrAnalyticModule getAuthRequestContext;

    private ScanQrAnalyticModule_ProvideScanQrAnalyticTrackerFactory(ScanQrAnalyticModule scanQrAnalyticModule, Provider<Context> provider) {
        this.getAuthRequestContext = scanQrAnalyticModule;
        this.PlaceComponentResult = provider;
    }

    public static ScanQrAnalyticModule_ProvideScanQrAnalyticTrackerFactory getAuthRequestContext(ScanQrAnalyticModule scanQrAnalyticModule, Provider<Context> provider) {
        return new ScanQrAnalyticModule_ProvideScanQrAnalyticTrackerFactory(scanQrAnalyticModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ScannerMixpanelTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
