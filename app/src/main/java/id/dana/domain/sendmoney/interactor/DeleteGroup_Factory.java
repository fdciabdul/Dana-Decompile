package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DeleteGroup_Factory implements Factory<DeleteGroup> {
    private final Provider<SendMoneyRepository> sendMoneyRepositoryProvider;

    public DeleteGroup_Factory(Provider<SendMoneyRepository> provider) {
        this.sendMoneyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DeleteGroup get() {
        return newInstance(this.sendMoneyRepositoryProvider.get());
    }

    public static DeleteGroup_Factory create(Provider<SendMoneyRepository> provider) {
        return new DeleteGroup_Factory(provider);
    }

    public static DeleteGroup newInstance(SendMoneyRepository sendMoneyRepository) {
        return new DeleteGroup(sendMoneyRepository);
    }
}
