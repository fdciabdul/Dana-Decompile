package id.dana.data.authcode.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class AuthMapper_Factory implements Factory<AuthMapper> {
    @Override // javax.inject.Provider
    public final AuthMapper get() {
        return newInstance();
    }

    public static AuthMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static AuthMapper newInstance() {
        return new AuthMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final AuthMapper_Factory MyBillsEntityDataFactory = new AuthMapper_Factory();

        private InstanceHolder() {
        }
    }
}
