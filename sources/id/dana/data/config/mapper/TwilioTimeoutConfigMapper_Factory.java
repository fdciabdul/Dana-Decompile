package id.dana.data.config.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class TwilioTimeoutConfigMapper_Factory implements Factory<TwilioTimeoutConfigMapper> {
    @Override // javax.inject.Provider
    public final TwilioTimeoutConfigMapper get() {
        return newInstance();
    }

    public static TwilioTimeoutConfigMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static TwilioTimeoutConfigMapper newInstance() {
        return new TwilioTimeoutConfigMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final TwilioTimeoutConfigMapper_Factory MyBillsEntityDataFactory = new TwilioTimeoutConfigMapper_Factory();

        private InstanceHolder() {
        }
    }
}
