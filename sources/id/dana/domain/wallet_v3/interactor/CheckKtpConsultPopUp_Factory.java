package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckKtpConsultPopUp_Factory implements Factory<CheckKtpConsultPopUp> {
    private final Provider<PersonalTabRepository> personalTabRepositoryProvider;

    public CheckKtpConsultPopUp_Factory(Provider<PersonalTabRepository> provider) {
        this.personalTabRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckKtpConsultPopUp get() {
        return newInstance(this.personalTabRepositoryProvider.get());
    }

    public static CheckKtpConsultPopUp_Factory create(Provider<PersonalTabRepository> provider) {
        return new CheckKtpConsultPopUp_Factory(provider);
    }

    public static CheckKtpConsultPopUp newInstance(PersonalTabRepository personalTabRepository) {
        return new CheckKtpConsultPopUp(personalTabRepository);
    }
}
