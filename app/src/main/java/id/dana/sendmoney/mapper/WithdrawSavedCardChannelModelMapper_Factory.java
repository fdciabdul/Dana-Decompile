package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class WithdrawSavedCardChannelModelMapper_Factory implements Factory<WithdrawSavedCardChannelModelMapper> {
    public static WithdrawSavedCardChannelModelMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final WithdrawSavedCardChannelModelMapper_Factory PlaceComponentResult = new WithdrawSavedCardChannelModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new WithdrawSavedCardChannelModelMapper();
    }
}
