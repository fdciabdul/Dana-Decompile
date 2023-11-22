package id.dana.twilio.trusteddevice;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.twilio.trusteddevice.TrustedDeviceContract;

/* loaded from: classes5.dex */
public final class TrustedDeviceModule_ProvideViewFactory implements Factory<TrustedDeviceContract.View> {
    private final TrustedDeviceModule getAuthRequestContext;

    private TrustedDeviceModule_ProvideViewFactory(TrustedDeviceModule trustedDeviceModule) {
        this.getAuthRequestContext = trustedDeviceModule;
    }

    public static TrustedDeviceModule_ProvideViewFactory PlaceComponentResult(TrustedDeviceModule trustedDeviceModule) {
        return new TrustedDeviceModule_ProvideViewFactory(trustedDeviceModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TrustedDeviceContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getMyBillsEntityDataFactory());
    }
}
