package id.dana.domain.miniprogram.interactor;

import dagger.internal.Factory;
import id.dana.domain.miniprogram.MiniProgramRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMiniPrograms_Factory implements Factory<GetMiniPrograms> {
    private final Provider<MiniProgramRepository> repositoryProvider;

    public GetMiniPrograms_Factory(Provider<MiniProgramRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMiniPrograms get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetMiniPrograms_Factory create(Provider<MiniProgramRepository> provider) {
        return new GetMiniPrograms_Factory(provider);
    }

    public static GetMiniPrograms newInstance(MiniProgramRepository miniProgramRepository) {
        return new GetMiniPrograms(miniProgramRepository);
    }
}
