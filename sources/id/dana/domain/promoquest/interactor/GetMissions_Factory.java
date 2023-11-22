package id.dana.domain.promoquest.interactor;

import dagger.internal.Factory;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetMissions_Factory implements Factory<GetMissions> {
    private final Provider<PromoQuestRepository> promoQuestRepositoryProvider;

    public GetMissions_Factory(Provider<PromoQuestRepository> provider) {
        this.promoQuestRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMissions get() {
        return newInstance(this.promoQuestRepositoryProvider.get());
    }

    public static GetMissions_Factory create(Provider<PromoQuestRepository> provider) {
        return new GetMissions_Factory(provider);
    }

    public static GetMissions newInstance(PromoQuestRepository promoQuestRepository) {
        return new GetMissions(promoQuestRepository);
    }
}
