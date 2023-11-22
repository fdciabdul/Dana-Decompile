package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SendMoneyScenariosMapper_Factory implements Factory<SendMoneyScenariosMapper> {
    @Override // javax.inject.Provider
    public final SendMoneyScenariosMapper get() {
        return newInstance();
    }

    public static SendMoneyScenariosMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static SendMoneyScenariosMapper newInstance() {
        return new SendMoneyScenariosMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final SendMoneyScenariosMapper_Factory PlaceComponentResult = new SendMoneyScenariosMapper_Factory();

        private InstanceHolder() {
        }
    }
}
