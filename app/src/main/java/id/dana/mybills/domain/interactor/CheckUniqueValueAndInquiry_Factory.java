package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CheckUniqueValueAndInquiry_Factory implements Factory<CheckUniqueValueAndInquiry> {
    private final Provider<MyBillsRepository> MyBillsEntityDataFactory;

    private CheckUniqueValueAndInquiry_Factory(Provider<MyBillsRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static CheckUniqueValueAndInquiry_Factory MyBillsEntityDataFactory(Provider<MyBillsRepository> provider) {
        return new CheckUniqueValueAndInquiry_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CheckUniqueValueAndInquiry(this.MyBillsEntityDataFactory.get());
    }
}
