package id.dana.domain.paylater.interactor;

import dagger.internal.Factory;
import id.dana.domain.paylater.PaylaterRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPaylaterRotationDelayTime_Factory implements Factory<GetPaylaterRotationDelayTime> {
    private final Provider<PaylaterRepository> paylaterRepositoryProvider;

    public GetPaylaterRotationDelayTime_Factory(Provider<PaylaterRepository> provider) {
        this.paylaterRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPaylaterRotationDelayTime get() {
        return newInstance(this.paylaterRepositoryProvider.get());
    }

    public static GetPaylaterRotationDelayTime_Factory create(Provider<PaylaterRepository> provider) {
        return new GetPaylaterRotationDelayTime_Factory(provider);
    }

    public static GetPaylaterRotationDelayTime newInstance(PaylaterRepository paylaterRepository) {
        return new GetPaylaterRotationDelayTime(paylaterRepository);
    }
}
