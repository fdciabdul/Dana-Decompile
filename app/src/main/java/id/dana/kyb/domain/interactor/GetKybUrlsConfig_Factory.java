package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetKybUrlsConfig_Factory implements Factory<GetKybUrlsConfig> {
    private final Provider<KybRepository> MyBillsEntityDataFactory;

    private GetKybUrlsConfig_Factory(Provider<KybRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetKybUrlsConfig_Factory PlaceComponentResult(Provider<KybRepository> provider) {
        return new GetKybUrlsConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetKybUrlsConfig(this.MyBillsEntityDataFactory.get());
    }
}
