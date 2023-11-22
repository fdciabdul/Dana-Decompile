package id.dana.data.registration;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class RegistrationProcessManager_Factory implements Factory<RegistrationProcessManager> {
    @Override // javax.inject.Provider
    public final RegistrationProcessManager get() {
        return newInstance();
    }

    public static RegistrationProcessManager_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static RegistrationProcessManager newInstance() {
        return new RegistrationProcessManager();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final RegistrationProcessManager_Factory getAuthRequestContext = new RegistrationProcessManager_Factory();

        private InstanceHolder() {
        }
    }
}
