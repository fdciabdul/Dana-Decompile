package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyPinPersonalKtp_Factory implements Factory<VerifyPinPersonalKtp> {
    private final Provider<PersonalTabRepository> personalTabRepositoryProvider;

    public VerifyPinPersonalKtp_Factory(Provider<PersonalTabRepository> provider) {
        this.personalTabRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VerifyPinPersonalKtp get() {
        return newInstance(this.personalTabRepositoryProvider.get());
    }

    public static VerifyPinPersonalKtp_Factory create(Provider<PersonalTabRepository> provider) {
        return new VerifyPinPersonalKtp_Factory(provider);
    }

    public static VerifyPinPersonalKtp newInstance(PersonalTabRepository personalTabRepository) {
        return new VerifyPinPersonalKtp(personalTabRepository);
    }
}
