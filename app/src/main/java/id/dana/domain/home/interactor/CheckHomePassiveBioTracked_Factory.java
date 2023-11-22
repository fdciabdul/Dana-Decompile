package id.dana.domain.home.interactor;

import dagger.internal.Factory;
import id.dana.domain.home.HomePassiveBioRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckHomePassiveBioTracked_Factory implements Factory<CheckHomePassiveBioTracked> {
    private final Provider<HomePassiveBioRepository> repositoryProvider;

    public CheckHomePassiveBioTracked_Factory(Provider<HomePassiveBioRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckHomePassiveBioTracked get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static CheckHomePassiveBioTracked_Factory create(Provider<HomePassiveBioRepository> provider) {
        return new CheckHomePassiveBioTracked_Factory(provider);
    }

    public static CheckHomePassiveBioTracked newInstance(HomePassiveBioRepository homePassiveBioRepository) {
        return new CheckHomePassiveBioTracked(homePassiveBioRepository);
    }
}
