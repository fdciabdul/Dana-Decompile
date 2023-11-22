package id.dana.data.login.source;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class LoginMapper_Factory implements Factory<LoginMapper> {
    @Override // javax.inject.Provider
    public final LoginMapper get() {
        return newInstance();
    }

    public static LoginMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static LoginMapper newInstance() {
        return new LoginMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final LoginMapper_Factory MyBillsEntityDataFactory = new LoginMapper_Factory();

        private InstanceHolder() {
        }
    }
}
