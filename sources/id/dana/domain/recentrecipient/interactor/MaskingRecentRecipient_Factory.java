package id.dana.domain.recentrecipient.interactor;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MaskingRecentRecipient_Factory implements Factory<MaskingRecentRecipient> {
    private final Provider<RecentRecipientRepository> recentRecipientRepositoryProvider;

    public MaskingRecentRecipient_Factory(Provider<RecentRecipientRepository> provider) {
        this.recentRecipientRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final MaskingRecentRecipient get() {
        return newInstance(this.recentRecipientRepositoryProvider.get());
    }

    public static MaskingRecentRecipient_Factory create(Provider<RecentRecipientRepository> provider) {
        return new MaskingRecentRecipient_Factory(provider);
    }

    public static MaskingRecentRecipient newInstance(RecentRecipientRepository recentRecipientRepository) {
        return new MaskingRecentRecipient(recentRecipientRepository);
    }
}
