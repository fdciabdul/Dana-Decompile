package id.dana.domain.homeinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.homeinfo.repository.HomeOmniRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPaylaterChannel_Factory implements Factory<GetPaylaterChannel> {
    private final Provider<HomeOmniRepository> homeOmniRepositoryProvider;

    public GetPaylaterChannel_Factory(Provider<HomeOmniRepository> provider) {
        this.homeOmniRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPaylaterChannel get() {
        return newInstance(this.homeOmniRepositoryProvider.get());
    }

    public static GetPaylaterChannel_Factory create(Provider<HomeOmniRepository> provider) {
        return new GetPaylaterChannel_Factory(provider);
    }

    public static GetPaylaterChannel newInstance(HomeOmniRepository homeOmniRepository) {
        return new GetPaylaterChannel(homeOmniRepository);
    }
}
