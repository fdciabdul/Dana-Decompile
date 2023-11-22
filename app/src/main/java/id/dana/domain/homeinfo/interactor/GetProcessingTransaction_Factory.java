package id.dana.domain.homeinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.homeinfo.repository.HomeOmniRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetProcessingTransaction_Factory implements Factory<GetProcessingTransaction> {
    private final Provider<HomeOmniRepository> homeOmniRepositoryProvider;

    public GetProcessingTransaction_Factory(Provider<HomeOmniRepository> provider) {
        this.homeOmniRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetProcessingTransaction get() {
        return newInstance(this.homeOmniRepositoryProvider.get());
    }

    public static GetProcessingTransaction_Factory create(Provider<HomeOmniRepository> provider) {
        return new GetProcessingTransaction_Factory(provider);
    }

    public static GetProcessingTransaction newInstance(HomeOmniRepository homeOmniRepository) {
        return new GetProcessingTransaction(homeOmniRepository);
    }
}
