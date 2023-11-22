package id.dana.data.pushverify;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.pushverify.source.PushVerifyEntityDataFactory;
import id.dana.data.pushverify.source.PushVerifyPreferenceEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PushVerifyEntityRepository_Factory implements Factory<PushVerifyEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<PushVerifyEntityDataFactory> pushVerifyEntityDataFactoryProvider;
    private final Provider<PushVerifyPreferenceEntityDataFactory> pushVerifyPreferenceEntityDataFactoryProvider;

    public PushVerifyEntityRepository_Factory(Provider<PushVerifyEntityDataFactory> provider, Provider<PushVerifyPreferenceEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.pushVerifyEntityDataFactoryProvider = provider;
        this.pushVerifyPreferenceEntityDataFactoryProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final PushVerifyEntityRepository get() {
        return newInstance(this.pushVerifyEntityDataFactoryProvider.get(), this.pushVerifyPreferenceEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static PushVerifyEntityRepository_Factory create(Provider<PushVerifyEntityDataFactory> provider, Provider<PushVerifyPreferenceEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new PushVerifyEntityRepository_Factory(provider, provider2, provider3);
    }

    public static PushVerifyEntityRepository newInstance(PushVerifyEntityDataFactory pushVerifyEntityDataFactory, PushVerifyPreferenceEntityDataFactory pushVerifyPreferenceEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new PushVerifyEntityRepository(pushVerifyEntityDataFactory, pushVerifyPreferenceEntityDataFactory, holdLoginV1EntityRepository);
    }
}
