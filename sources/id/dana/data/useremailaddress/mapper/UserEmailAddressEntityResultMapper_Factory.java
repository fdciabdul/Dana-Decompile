package id.dana.data.useremailaddress.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class UserEmailAddressEntityResultMapper_Factory implements Factory<UserEmailAddressEntityResultMapper> {
    @Override // javax.inject.Provider
    public final UserEmailAddressEntityResultMapper get() {
        return newInstance();
    }

    public static UserEmailAddressEntityResultMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static UserEmailAddressEntityResultMapper newInstance() {
        return new UserEmailAddressEntityResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final UserEmailAddressEntityResultMapper_Factory BuiltInFictitiousFunctionClassFactory = new UserEmailAddressEntityResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
