package id.dana.domain.danaprotection.interactor;

import dagger.internal.Factory;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDanaProtectionInfo_Factory implements Factory<GetDanaProtectionInfo> {
    private final Provider<DanaProtectionInfoRepository> danaProtectionInfoRepositoryProvider;

    public GetDanaProtectionInfo_Factory(Provider<DanaProtectionInfoRepository> provider) {
        this.danaProtectionInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDanaProtectionInfo get() {
        return newInstance(this.danaProtectionInfoRepositoryProvider.get());
    }

    public static GetDanaProtectionInfo_Factory create(Provider<DanaProtectionInfoRepository> provider) {
        return new GetDanaProtectionInfo_Factory(provider);
    }

    public static GetDanaProtectionInfo newInstance(DanaProtectionInfoRepository danaProtectionInfoRepository) {
        return new GetDanaProtectionInfo(danaProtectionInfoRepository);
    }
}
