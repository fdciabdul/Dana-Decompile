package id.dana.data.h5event.repository;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class ChangePhoneNumberH5EventEntityRepository_Factory implements Factory<ChangePhoneNumberH5EventEntityRepository> {
    @Override // javax.inject.Provider
    public final ChangePhoneNumberH5EventEntityRepository get() {
        return newInstance();
    }

    public static ChangePhoneNumberH5EventEntityRepository_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static ChangePhoneNumberH5EventEntityRepository newInstance() {
        return new ChangePhoneNumberH5EventEntityRepository();
    }

    /* loaded from: classes8.dex */
    static final class InstanceHolder {
        private static final ChangePhoneNumberH5EventEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new ChangePhoneNumberH5EventEntityRepository_Factory();

        private InstanceHolder() {
        }
    }
}
