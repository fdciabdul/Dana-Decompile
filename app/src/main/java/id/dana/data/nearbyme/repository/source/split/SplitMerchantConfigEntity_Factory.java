package id.dana.data.nearbyme.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitMerchantConfigEntity_Factory implements Factory<SplitMerchantConfigEntity> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitMerchantConfigEntity_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitMerchantConfigEntity get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitMerchantConfigEntity_Factory create(Provider<SplitFacade> provider) {
        return new SplitMerchantConfigEntity_Factory(provider);
    }

    public static SplitMerchantConfigEntity newInstance(SplitFacade splitFacade) {
        return new SplitMerchantConfigEntity(splitFacade);
    }
}
