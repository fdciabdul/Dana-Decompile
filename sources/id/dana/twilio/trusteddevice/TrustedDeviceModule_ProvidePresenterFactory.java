package id.dana.twilio.trusteddevice;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.twilio.trusteddevice.TrustedDeviceContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TrustedDeviceModule_ProvidePresenterFactory implements Factory<TrustedDeviceContract.Presenter> {
    private final Provider<TrustedDevicePresenter> PlaceComponentResult;
    private final TrustedDeviceModule getAuthRequestContext;

    private TrustedDeviceModule_ProvidePresenterFactory(TrustedDeviceModule trustedDeviceModule, Provider<TrustedDevicePresenter> provider) {
        this.getAuthRequestContext = trustedDeviceModule;
        this.PlaceComponentResult = provider;
    }

    public static TrustedDeviceModule_ProvidePresenterFactory MyBillsEntityDataFactory(TrustedDeviceModule trustedDeviceModule, Provider<TrustedDevicePresenter> provider) {
        return new TrustedDeviceModule_ProvidePresenterFactory(trustedDeviceModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TrustedDeviceContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
