package id.dana.cashier.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TopUpPayModelMapper_Factory implements Factory<TopUpPayModelMapper> {
    private final Provider<AttributeModelMapper> MyBillsEntityDataFactory;

    private TopUpPayModelMapper_Factory(Provider<AttributeModelMapper> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static TopUpPayModelMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<AttributeModelMapper> provider) {
        return new TopUpPayModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TopUpPayModelMapper(this.MyBillsEntityDataFactory.get());
    }
}
