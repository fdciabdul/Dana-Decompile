package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetKybServiceList_Factory implements Factory<GetKybServiceList> {
    private final Provider<KybRepository> MyBillsEntityDataFactory;

    private GetKybServiceList_Factory(Provider<KybRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetKybServiceList_Factory getAuthRequestContext(Provider<KybRepository> provider) {
        return new GetKybServiceList_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetKybServiceList(this.MyBillsEntityDataFactory.get());
    }
}
