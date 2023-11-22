package id.dana.domain.promoquest.interactor;

import dagger.internal.Factory;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetMissionsWithQuestByStatus_Factory implements Factory<GetMissionsWithQuestByStatus> {
    private final Provider<PromoQuestRepository> promoQuestRepositoryProvider;

    public GetMissionsWithQuestByStatus_Factory(Provider<PromoQuestRepository> provider) {
        this.promoQuestRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMissionsWithQuestByStatus get() {
        return newInstance(this.promoQuestRepositoryProvider.get());
    }

    public static GetMissionsWithQuestByStatus_Factory create(Provider<PromoQuestRepository> provider) {
        return new GetMissionsWithQuestByStatus_Factory(provider);
    }

    public static GetMissionsWithQuestByStatus newInstance(PromoQuestRepository promoQuestRepository) {
        return new GetMissionsWithQuestByStatus(promoQuestRepository);
    }
}
