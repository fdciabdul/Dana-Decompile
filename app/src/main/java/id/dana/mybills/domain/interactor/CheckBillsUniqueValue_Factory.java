package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CheckBillsUniqueValue_Factory implements Factory<CheckBillsUniqueValue> {
    private final Provider<MyBillsRepository> PlaceComponentResult;

    private CheckBillsUniqueValue_Factory(Provider<MyBillsRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static CheckBillsUniqueValue_Factory MyBillsEntityDataFactory(Provider<MyBillsRepository> provider) {
        return new CheckBillsUniqueValue_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CheckBillsUniqueValue(this.PlaceComponentResult.get());
    }
}
