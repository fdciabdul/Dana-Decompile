package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class WithdrawSavedCardChannelViewResultMapper_Factory implements Factory<WithdrawSavedCardChannelViewResultMapper> {
    @Override // javax.inject.Provider
    public final WithdrawSavedCardChannelViewResultMapper get() {
        return newInstance();
    }

    public static WithdrawSavedCardChannelViewResultMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static WithdrawSavedCardChannelViewResultMapper newInstance() {
        return new WithdrawSavedCardChannelViewResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final WithdrawSavedCardChannelViewResultMapper_Factory MyBillsEntityDataFactory = new WithdrawSavedCardChannelViewResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
