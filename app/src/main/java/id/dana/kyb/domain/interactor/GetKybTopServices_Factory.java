package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetKybTopServices_Factory implements Factory<GetKybTopServices> {
    private final Provider<KybRepository> MyBillsEntityDataFactory;

    private GetKybTopServices_Factory(Provider<KybRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetKybTopServices_Factory MyBillsEntityDataFactory(Provider<KybRepository> provider) {
        return new GetKybTopServices_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetKybTopServices(this.MyBillsEntityDataFactory.get());
    }
}
