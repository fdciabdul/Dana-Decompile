package id.dana.domain.electronicmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class InquireBalanceEmoney_Factory implements Factory<InquireBalanceEmoney> {
    private final Provider<ElectronicmoneyRepository> electronicmoneyRepositoryProvider;

    public InquireBalanceEmoney_Factory(Provider<ElectronicmoneyRepository> provider) {
        this.electronicmoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InquireBalanceEmoney get() {
        return newInstance(this.electronicmoneyRepositoryProvider.get());
    }

    public static InquireBalanceEmoney_Factory create(Provider<ElectronicmoneyRepository> provider) {
        return new InquireBalanceEmoney_Factory(provider);
    }

    public static InquireBalanceEmoney newInstance(ElectronicmoneyRepository electronicmoneyRepository) {
        return new InquireBalanceEmoney(electronicmoneyRepository);
    }
}
