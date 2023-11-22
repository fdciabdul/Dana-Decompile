package id.dana.data.sendmoney.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitAddPayMethodConfig_Factory implements Factory<SplitAddPayMethodConfig> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitAddPayMethodConfig_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitAddPayMethodConfig get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitAddPayMethodConfig_Factory create(Provider<SplitFacade> provider) {
        return new SplitAddPayMethodConfig_Factory(provider);
    }

    public static SplitAddPayMethodConfig newInstance(SplitFacade splitFacade) {
        return new SplitAddPayMethodConfig(splitFacade);
    }
}
