package id.dana.domain.version.interactor;

import dagger.internal.Factory;
import id.dana.domain.version.VersionRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetAppStatus_Factory implements Factory<GetAppStatus> {
    private final Provider<VersionRepository> versionRepositoryProvider;

    public GetAppStatus_Factory(Provider<VersionRepository> provider) {
        this.versionRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAppStatus get() {
        return newInstance(this.versionRepositoryProvider.get());
    }

    public static GetAppStatus_Factory create(Provider<VersionRepository> provider) {
        return new GetAppStatus_Factory(provider);
    }

    public static GetAppStatus newInstance(VersionRepository versionRepository) {
        return new GetAppStatus(versionRepository);
    }
}
