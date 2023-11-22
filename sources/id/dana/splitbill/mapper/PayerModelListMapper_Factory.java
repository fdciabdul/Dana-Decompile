package id.dana.splitbill.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PayerModelListMapper_Factory implements Factory<PayerModelListMapper> {
    private final Provider<PayerModelMapper> MyBillsEntityDataFactory;

    private PayerModelListMapper_Factory(Provider<PayerModelMapper> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static PayerModelListMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<PayerModelMapper> provider) {
        return new PayerModelListMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PayerModelListMapper(this.MyBillsEntityDataFactory.get());
    }
}
