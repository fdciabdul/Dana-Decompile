package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveLastKybTransactionId_Factory implements Factory<SaveLastKybTransactionId> {
    private final Provider<KybRepository> MyBillsEntityDataFactory;

    private SaveLastKybTransactionId_Factory(Provider<KybRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static SaveLastKybTransactionId_Factory MyBillsEntityDataFactory(Provider<KybRepository> provider) {
        return new SaveLastKybTransactionId_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveLastKybTransactionId(this.MyBillsEntityDataFactory.get());
    }
}
