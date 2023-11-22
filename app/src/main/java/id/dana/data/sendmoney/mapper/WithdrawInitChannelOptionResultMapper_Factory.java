package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class WithdrawInitChannelOptionResultMapper_Factory implements Factory<WithdrawInitChannelOptionResultMapper> {
    @Override // javax.inject.Provider
    public final WithdrawInitChannelOptionResultMapper get() {
        return newInstance();
    }

    public static WithdrawInitChannelOptionResultMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static WithdrawInitChannelOptionResultMapper newInstance() {
        return new WithdrawInitChannelOptionResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final WithdrawInitChannelOptionResultMapper_Factory getAuthRequestContext = new WithdrawInitChannelOptionResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
