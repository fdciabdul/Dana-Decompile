package id.dana.domain.electronicmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ConfirmUpdateBalanceEmoney_Factory implements Factory<ConfirmUpdateBalanceEmoney> {
    private final Provider<ElectronicmoneyRepository> repositoryProvider;

    public ConfirmUpdateBalanceEmoney_Factory(Provider<ElectronicmoneyRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ConfirmUpdateBalanceEmoney get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static ConfirmUpdateBalanceEmoney_Factory create(Provider<ElectronicmoneyRepository> provider) {
        return new ConfirmUpdateBalanceEmoney_Factory(provider);
    }

    public static ConfirmUpdateBalanceEmoney newInstance(ElectronicmoneyRepository electronicmoneyRepository) {
        return new ConfirmUpdateBalanceEmoney(electronicmoneyRepository);
    }
}
