package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ClearKybData_Factory implements Factory<ClearKybData> {
    private final Provider<KybRepository> MyBillsEntityDataFactory;

    private ClearKybData_Factory(Provider<KybRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static ClearKybData_Factory getAuthRequestContext(Provider<KybRepository> provider) {
        return new ClearKybData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ClearKybData(this.MyBillsEntityDataFactory.get());
    }
}
