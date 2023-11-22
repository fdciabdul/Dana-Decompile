package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveKtpConsultPopUp_Factory implements Factory<SaveKtpConsultPopUp> {
    private final Provider<PersonalTabRepository> personalTabRepositoryProvider;

    public SaveKtpConsultPopUp_Factory(Provider<PersonalTabRepository> provider) {
        this.personalTabRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveKtpConsultPopUp get() {
        return newInstance(this.personalTabRepositoryProvider.get());
    }

    public static SaveKtpConsultPopUp_Factory create(Provider<PersonalTabRepository> provider) {
        return new SaveKtpConsultPopUp_Factory(provider);
    }

    public static SaveKtpConsultPopUp newInstance(PersonalTabRepository personalTabRepository) {
        return new SaveKtpConsultPopUp(personalTabRepository);
    }
}
