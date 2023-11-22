package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class CurrencyAmountResultMapper_Factory implements Factory<CurrencyAmountResultMapper> {
    @Override // javax.inject.Provider
    public final CurrencyAmountResultMapper get() {
        return newInstance();
    }

    public static CurrencyAmountResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static CurrencyAmountResultMapper newInstance() {
        return new CurrencyAmountResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CurrencyAmountResultMapper_Factory PlaceComponentResult = new CurrencyAmountResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
