package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckKtpIsSaved_Factory implements Factory<CheckKtpIsSaved> {
    private final Provider<PersonalTabRepository> personalTabRepositoryProvider;

    public CheckKtpIsSaved_Factory(Provider<PersonalTabRepository> provider) {
        this.personalTabRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckKtpIsSaved get() {
        return newInstance(this.personalTabRepositoryProvider.get());
    }

    public static CheckKtpIsSaved_Factory create(Provider<PersonalTabRepository> provider) {
        return new CheckKtpIsSaved_Factory(provider);
    }

    public static CheckKtpIsSaved newInstance(PersonalTabRepository personalTabRepository) {
        return new CheckKtpIsSaved(personalTabRepository);
    }
}
