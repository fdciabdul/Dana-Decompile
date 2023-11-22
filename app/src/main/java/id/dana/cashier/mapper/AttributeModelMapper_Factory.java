package id.dana.cashier.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class AttributeModelMapper_Factory implements Factory<AttributeModelMapper> {
    private final Provider<CashierPayChannelModelsMapper> getAuthRequestContext;

    private AttributeModelMapper_Factory(Provider<CashierPayChannelModelsMapper> provider) {
        this.getAuthRequestContext = provider;
    }

    public static AttributeModelMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<CashierPayChannelModelsMapper> provider) {
        return new AttributeModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AttributeModelMapper(this.getAuthRequestContext.get());
    }
}
