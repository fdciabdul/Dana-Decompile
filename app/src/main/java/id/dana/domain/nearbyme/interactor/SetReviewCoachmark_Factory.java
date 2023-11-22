package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetReviewCoachmark_Factory implements Factory<SetReviewCoachmark> {
    private final Provider<MerchantInfoRepository> merchantInfoRepositoryProvider;

    public SetReviewCoachmark_Factory(Provider<MerchantInfoRepository> provider) {
        this.merchantInfoRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SetReviewCoachmark get() {
        return newInstance(this.merchantInfoRepositoryProvider.get());
    }

    public static SetReviewCoachmark_Factory create(Provider<MerchantInfoRepository> provider) {
        return new SetReviewCoachmark_Factory(provider);
    }

    public static SetReviewCoachmark newInstance(MerchantInfoRepository merchantInfoRepository) {
        return new SetReviewCoachmark(merchantInfoRepository);
    }
}
