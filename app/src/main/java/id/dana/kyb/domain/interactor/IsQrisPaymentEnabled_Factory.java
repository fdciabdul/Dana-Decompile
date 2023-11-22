package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class IsQrisPaymentEnabled_Factory implements Factory<IsQrisPaymentEnabled> {
    private final Provider<KybRepository> MyBillsEntityDataFactory;

    private IsQrisPaymentEnabled_Factory(Provider<KybRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static IsQrisPaymentEnabled_Factory getAuthRequestContext(Provider<KybRepository> provider) {
        return new IsQrisPaymentEnabled_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new IsQrisPaymentEnabled(this.MyBillsEntityDataFactory.get());
    }
}
