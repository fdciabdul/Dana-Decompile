package id.dana.data.login;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class LoginLogoutSubject_Factory implements Factory<LoginLogoutSubject> {
    @Override // javax.inject.Provider
    public final LoginLogoutSubject get() {
        return newInstance();
    }

    public static LoginLogoutSubject_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static LoginLogoutSubject newInstance() {
        return new LoginLogoutSubject();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final LoginLogoutSubject_Factory BuiltInFictitiousFunctionClassFactory = new LoginLogoutSubject_Factory();

        private InstanceHolder() {
        }
    }
}
