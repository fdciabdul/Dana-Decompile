package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class CurrencyAmountModelMapper_Factory implements Factory<CurrencyAmountModelMapper> {
    public static CurrencyAmountModelMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final CurrencyAmountModelMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new CurrencyAmountModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CurrencyAmountModelMapper();
    }
}
