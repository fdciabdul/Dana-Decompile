package id.dana.domain.paylater.interactor;

import dagger.internal.Factory;
import id.dana.domain.paylater.PaylaterRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetPaylaterChannel_Factory implements Factory<SetPaylaterChannel> {
    private final Provider<PaylaterRepository> paylaterRepositoryProvider;

    public SetPaylaterChannel_Factory(Provider<PaylaterRepository> provider) {
        this.paylaterRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SetPaylaterChannel get() {
        return newInstance(this.paylaterRepositoryProvider.get());
    }

    public static SetPaylaterChannel_Factory create(Provider<PaylaterRepository> provider) {
        return new SetPaylaterChannel_Factory(provider);
    }

    public static SetPaylaterChannel newInstance(PaylaterRepository paylaterRepository) {
        return new SetPaylaterChannel(paylaterRepository);
    }
}
