package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetKtpInfo_Factory implements Factory<GetKtpInfo> {
    private final Provider<PersonalTabRepository> personalTabRepositoryProvider;

    public GetKtpInfo_Factory(Provider<PersonalTabRepository> provider) {
        this.personalTabRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetKtpInfo get() {
        return newInstance(this.personalTabRepositoryProvider.get());
    }

    public static GetKtpInfo_Factory create(Provider<PersonalTabRepository> provider) {
        return new GetKtpInfo_Factory(provider);
    }

    public static GetKtpInfo newInstance(PersonalTabRepository personalTabRepository) {
        return new GetKtpInfo(personalTabRepository);
    }
}
