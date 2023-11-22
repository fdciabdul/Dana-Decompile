package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserKYCStatus_Factory implements Factory<GetUserKYCStatus> {
    private final Provider<PersonalTabRepository> personalTabRepositoryProvider;

    public GetUserKYCStatus_Factory(Provider<PersonalTabRepository> provider) {
        this.personalTabRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserKYCStatus get() {
        return newInstance(this.personalTabRepositoryProvider.get());
    }

    public static GetUserKYCStatus_Factory create(Provider<PersonalTabRepository> provider) {
        return new GetUserKYCStatus_Factory(provider);
    }

    public static GetUserKYCStatus newInstance(PersonalTabRepository personalTabRepository) {
        return new GetUserKYCStatus(personalTabRepository);
    }
}
