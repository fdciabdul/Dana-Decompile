package id.dana.domain.electronicmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetBrizziAccessToken_Factory implements Factory<GetBrizziAccessToken> {
    private final Provider<ElectronicmoneyRepository> electronicmoneyRepositoryProvider;

    public GetBrizziAccessToken_Factory(Provider<ElectronicmoneyRepository> provider) {
        this.electronicmoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetBrizziAccessToken get() {
        return newInstance(this.electronicmoneyRepositoryProvider.get());
    }

    public static GetBrizziAccessToken_Factory create(Provider<ElectronicmoneyRepository> provider) {
        return new GetBrizziAccessToken_Factory(provider);
    }

    public static GetBrizziAccessToken newInstance(ElectronicmoneyRepository electronicmoneyRepository) {
        return new GetBrizziAccessToken(electronicmoneyRepository);
    }
}
