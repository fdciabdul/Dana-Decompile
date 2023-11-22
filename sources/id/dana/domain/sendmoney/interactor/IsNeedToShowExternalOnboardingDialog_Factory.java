package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsNeedToShowExternalOnboardingDialog_Factory implements Factory<IsNeedToShowExternalOnboardingDialog> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public IsNeedToShowExternalOnboardingDialog_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsNeedToShowExternalOnboardingDialog get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static IsNeedToShowExternalOnboardingDialog_Factory create(Provider<SendMoneyRepository> provider) {
        return new IsNeedToShowExternalOnboardingDialog_Factory(provider);
    }

    public static IsNeedToShowExternalOnboardingDialog newInstance(SendMoneyRepository sendMoneyRepository) {
        return new IsNeedToShowExternalOnboardingDialog(sendMoneyRepository);
    }
}
