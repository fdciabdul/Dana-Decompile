package id.dana.domain.miniprogram.interactor;

import dagger.internal.Factory;
import id.dana.domain.miniprogram.MiniProgramRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetFavoriteMiniPrograms_Factory implements Factory<SetFavoriteMiniPrograms> {
    private final Provider<MiniProgramRepository> repositoryProvider;

    public SetFavoriteMiniPrograms_Factory(Provider<MiniProgramRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SetFavoriteMiniPrograms get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static SetFavoriteMiniPrograms_Factory create(Provider<MiniProgramRepository> provider) {
        return new SetFavoriteMiniPrograms_Factory(provider);
    }

    public static SetFavoriteMiniPrograms newInstance(MiniProgramRepository miniProgramRepository) {
        return new SetFavoriteMiniPrograms(miniProgramRepository);
    }
}
