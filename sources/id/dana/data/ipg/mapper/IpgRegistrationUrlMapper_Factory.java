package id.dana.data.ipg.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class IpgRegistrationUrlMapper_Factory implements Factory<IpgRegistrationUrlMapper> {
    @Override // javax.inject.Provider
    public final IpgRegistrationUrlMapper get() {
        return newInstance();
    }

    public static IpgRegistrationUrlMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static IpgRegistrationUrlMapper newInstance() {
        return new IpgRegistrationUrlMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final IpgRegistrationUrlMapper_Factory MyBillsEntityDataFactory = new IpgRegistrationUrlMapper_Factory();

        private InstanceHolder() {
        }
    }
}
