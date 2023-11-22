package id.dana.domain.promoquest.interactor;

import dagger.internal.Factory;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMissionDetail_Factory implements Factory<GetMissionDetail> {
    private final Provider<PromoQuestRepository> questRepositoryProvider;

    public GetMissionDetail_Factory(Provider<PromoQuestRepository> provider) {
        this.questRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMissionDetail get() {
        return newInstance(this.questRepositoryProvider.get());
    }

    public static GetMissionDetail_Factory create(Provider<PromoQuestRepository> provider) {
        return new GetMissionDetail_Factory(provider);
    }

    public static GetMissionDetail newInstance(PromoQuestRepository promoQuestRepository) {
        return new GetMissionDetail(promoQuestRepository);
    }
}
