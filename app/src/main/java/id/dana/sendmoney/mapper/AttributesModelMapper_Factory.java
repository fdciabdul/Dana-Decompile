package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AttributesModelMapper_Factory implements Factory<AttributesModelMapper> {
    private final Provider<PayMethodRiskMapper> KClassImpl$Data$declaredNonStaticMembers$2;

    private AttributesModelMapper_Factory(Provider<PayMethodRiskMapper> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static AttributesModelMapper_Factory MyBillsEntityDataFactory(Provider<PayMethodRiskMapper> provider) {
        return new AttributesModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AttributesModelMapper(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
