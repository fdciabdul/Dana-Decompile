package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetKybCompressQrConfig_Factory implements Factory<GetKybCompressQrConfig> {
    private final Provider<KybRepository> PlaceComponentResult;

    private GetKybCompressQrConfig_Factory(Provider<KybRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetKybCompressQrConfig_Factory PlaceComponentResult(Provider<KybRepository> provider) {
        return new GetKybCompressQrConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetKybCompressQrConfig(this.PlaceComponentResult.get());
    }
}
