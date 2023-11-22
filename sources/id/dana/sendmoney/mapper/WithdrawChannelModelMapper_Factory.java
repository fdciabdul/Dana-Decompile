package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class WithdrawChannelModelMapper_Factory implements Factory<WithdrawChannelModelMapper> {
    public static WithdrawChannelModelMapper_Factory PlaceComponentResult() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final WithdrawChannelModelMapper_Factory PlaceComponentResult = new WithdrawChannelModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new WithdrawChannelModelMapper();
    }
}
