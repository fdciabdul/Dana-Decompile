package id.dana;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class ApplicationOrientationCallback_Factory implements Factory<ApplicationOrientationCallback> {
    public static ApplicationOrientationCallback_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ApplicationOrientationCallback_Factory getAuthRequestContext = new ApplicationOrientationCallback_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ApplicationOrientationCallback();
    }
}
