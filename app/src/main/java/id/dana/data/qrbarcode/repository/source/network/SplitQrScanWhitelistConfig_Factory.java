package id.dana.data.qrbarcode.repository.source.network;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitQrScanWhitelistConfig_Factory implements Factory<SplitQrScanWhitelistConfig> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitQrScanWhitelistConfig_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitQrScanWhitelistConfig get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitQrScanWhitelistConfig_Factory create(Provider<SplitFacade> provider) {
        return new SplitQrScanWhitelistConfig_Factory(provider);
    }

    public static SplitQrScanWhitelistConfig newInstance(SplitFacade splitFacade) {
        return new SplitQrScanWhitelistConfig(splitFacade);
    }
}
