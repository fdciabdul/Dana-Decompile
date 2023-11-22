package id.dana.domain.mybills.interactor;

import dagger.internal.Factory;
import id.dana.domain.mybills.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckSplitService_Factory implements Factory<CheckSplitService> {
    private final Provider<MyBillsRepository> myBillsRepositoryProvider;

    public CheckSplitService_Factory(Provider<MyBillsRepository> provider) {
        this.myBillsRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckSplitService get() {
        return newInstance(this.myBillsRepositoryProvider.get());
    }

    public static CheckSplitService_Factory create(Provider<MyBillsRepository> provider) {
        return new CheckSplitService_Factory(provider);
    }

    public static CheckSplitService newInstance(MyBillsRepository myBillsRepository) {
        return new CheckSplitService(myBillsRepository);
    }
}
