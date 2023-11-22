package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveExternalOnboardingDialog_Factory implements Factory<SaveExternalOnboardingDialog> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public SaveExternalOnboardingDialog_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveExternalOnboardingDialog get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static SaveExternalOnboardingDialog_Factory create(Provider<SendMoneyRepository> provider) {
        return new SaveExternalOnboardingDialog_Factory(provider);
    }

    public static SaveExternalOnboardingDialog newInstance(SendMoneyRepository sendMoneyRepository) {
        return new SaveExternalOnboardingDialog(sendMoneyRepository);
    }
}
