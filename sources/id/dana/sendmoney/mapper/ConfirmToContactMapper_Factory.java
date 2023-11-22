package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ConfirmToContactMapper_Factory implements Factory<ConfirmToContactMapper> {
    public static ConfirmToContactMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final ConfirmToContactMapper_Factory PlaceComponentResult = new ConfirmToContactMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ConfirmToContactMapper();
    }
}
