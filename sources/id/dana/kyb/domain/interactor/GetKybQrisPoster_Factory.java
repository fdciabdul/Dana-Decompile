package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetKybQrisPoster_Factory implements Factory<GetKybQrisPoster> {
    private final Provider<KybRepository> MyBillsEntityDataFactory;

    private GetKybQrisPoster_Factory(Provider<KybRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetKybQrisPoster_Factory getAuthRequestContext(Provider<KybRepository> provider) {
        return new GetKybQrisPoster_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetKybQrisPoster(this.MyBillsEntityDataFactory.get());
    }
}
