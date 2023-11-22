package id.dana.data.banner.repository.source;

import dagger.internal.Factory;
import id.dana.data.banner.repository.source.network.NetworkBannerEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BannerEntityDataFactory_Factory implements Factory<BannerEntityDataFactory> {
    private final Provider<NetworkBannerEntityData> PlaceComponentResult;

    private BannerEntityDataFactory_Factory(Provider<NetworkBannerEntityData> provider) {
        this.PlaceComponentResult = provider;
    }

    public static BannerEntityDataFactory_Factory PlaceComponentResult(Provider<NetworkBannerEntityData> provider) {
        return new BannerEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BannerEntityDataFactory(this.PlaceComponentResult.get());
    }
}
