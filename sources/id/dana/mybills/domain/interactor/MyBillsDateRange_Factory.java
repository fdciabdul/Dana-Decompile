package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyBillsDateRange_Factory implements Factory<MyBillsDateRange> {
    private final Provider<MyBillsRepository> MyBillsEntityDataFactory;

    private MyBillsDateRange_Factory(Provider<MyBillsRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static MyBillsDateRange_Factory MyBillsEntityDataFactory(Provider<MyBillsRepository> provider) {
        return new MyBillsDateRange_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyBillsDateRange(this.MyBillsEntityDataFactory.get());
    }
}
