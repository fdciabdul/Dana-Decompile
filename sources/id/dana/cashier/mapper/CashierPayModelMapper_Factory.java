package id.dana.cashier.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierPayModelMapper_Factory implements Factory<CashierPayModelMapper> {
    private final Provider<AttributeModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;

    private CashierPayModelMapper_Factory(Provider<AttributeModelMapper> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static CashierPayModelMapper_Factory getAuthRequestContext(Provider<AttributeModelMapper> provider) {
        return new CashierPayModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierPayModelMapper(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
