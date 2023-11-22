package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class WithdrawInitChannelOptionModelMapper_Factory implements Factory<WithdrawInitChannelOptionModelMapper> {
    public static WithdrawInitChannelOptionModelMapper_Factory PlaceComponentResult() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final WithdrawInitChannelOptionModelMapper_Factory getAuthRequestContext = new WithdrawInitChannelOptionModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new WithdrawInitChannelOptionModelMapper();
    }
}
