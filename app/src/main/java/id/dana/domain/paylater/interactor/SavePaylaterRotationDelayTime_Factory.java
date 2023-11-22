package id.dana.domain.paylater.interactor;

import dagger.internal.Factory;
import id.dana.domain.paylater.PaylaterRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavePaylaterRotationDelayTime_Factory implements Factory<SavePaylaterRotationDelayTime> {
    private final Provider<PaylaterRepository> paylaterRepositoryProvider;

    public SavePaylaterRotationDelayTime_Factory(Provider<PaylaterRepository> provider) {
        this.paylaterRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SavePaylaterRotationDelayTime get() {
        return newInstance(this.paylaterRepositoryProvider.get());
    }

    public static SavePaylaterRotationDelayTime_Factory create(Provider<PaylaterRepository> provider) {
        return new SavePaylaterRotationDelayTime_Factory(provider);
    }

    public static SavePaylaterRotationDelayTime newInstance(PaylaterRepository paylaterRepository) {
        return new SavePaylaterRotationDelayTime(paylaterRepository);
    }
}
