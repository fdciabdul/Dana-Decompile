package id.dana.danapoly.domain.config.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetLastBackgroundColor_Factory implements Factory<GetLastBackgroundColor> {
    private final Provider<DanapolyConfigRepository> MyBillsEntityDataFactory;

    private GetLastBackgroundColor_Factory(Provider<DanapolyConfigRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetLastBackgroundColor_Factory MyBillsEntityDataFactory(Provider<DanapolyConfigRepository> provider) {
        return new GetLastBackgroundColor_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetLastBackgroundColor(this.MyBillsEntityDataFactory.get());
    }
}
