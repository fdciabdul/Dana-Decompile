package id.dana.data.recentrecipient.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class BankCardConversionMapper_Factory implements Factory<BankCardConversionMapper> {
    @Override // javax.inject.Provider
    public final BankCardConversionMapper get() {
        return newInstance();
    }

    public static BankCardConversionMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static BankCardConversionMapper newInstance() {
        return new BankCardConversionMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final BankCardConversionMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new BankCardConversionMapper_Factory();

        private InstanceHolder() {
        }
    }
}
