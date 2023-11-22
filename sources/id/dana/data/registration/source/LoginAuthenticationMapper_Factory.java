package id.dana.data.registration.source;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class LoginAuthenticationMapper_Factory implements Factory<LoginAuthenticationMapper> {
    @Override // javax.inject.Provider
    public final LoginAuthenticationMapper get() {
        return newInstance();
    }

    public static LoginAuthenticationMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static LoginAuthenticationMapper newInstance() {
        return new LoginAuthenticationMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final LoginAuthenticationMapper_Factory PlaceComponentResult = new LoginAuthenticationMapper_Factory();

        private InstanceHolder() {
        }
    }
}
