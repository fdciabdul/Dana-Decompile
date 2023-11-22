package id.dana.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class SendMoneyScenariosMapper_Factory implements Factory<SendMoneyScenariosMapper> {
    public static SendMoneyScenariosMapper_Factory PlaceComponentResult() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final SendMoneyScenariosMapper_Factory MyBillsEntityDataFactory = new SendMoneyScenariosMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyScenariosMapper();
    }
}
