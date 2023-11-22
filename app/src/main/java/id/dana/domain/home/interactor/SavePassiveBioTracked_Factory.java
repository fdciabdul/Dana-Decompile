package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomePassiveBioRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavePassiveBioTracked_Factory implements Factory<SavePassiveBioTracked> {
    private final Provider<HomePassiveBioRepository> repositoryProvider;

    public SavePassiveBioTracked_Factory(Provider<HomePassiveBioRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SavePassiveBioTracked get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static SavePassiveBioTracked_Factory create(Provider<HomePassiveBioRepository> provider) {
        return new SavePassiveBioTracked_Factory(provider);
    }

    public static SavePassiveBioTracked newInstance(HomePassiveBioRepository homePassiveBioRepository) {
        return new SavePassiveBioTracked(homePassiveBioRepository);
    }
}
