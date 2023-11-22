package id.dana.domain.miniprogram.interactor;

import dagger.internal.Factory;
import id.dana.domain.miniprogram.MiniProgramRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetRecentMiniProgram_Factory implements Factory<SetRecentMiniProgram> {
    private final Provider<MiniProgramRepository> repositoryProvider;

    public SetRecentMiniProgram_Factory(Provider<MiniProgramRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SetRecentMiniProgram get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static SetRecentMiniProgram_Factory create(Provider<MiniProgramRepository> provider) {
        return new SetRecentMiniProgram_Factory(provider);
    }

    public static SetRecentMiniProgram newInstance(MiniProgramRepository miniProgramRepository) {
        return new SetRecentMiniProgram(miniProgramRepository);
    }
}
