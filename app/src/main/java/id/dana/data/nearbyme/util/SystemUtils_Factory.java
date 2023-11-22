package id.dana.data.nearbyme.util;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SystemUtils_Factory implements Factory<SystemUtils> {
    @Override // javax.inject.Provider
    public final SystemUtils get() {
        return newInstance();
    }

    public static SystemUtils_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static SystemUtils newInstance() {
        return new SystemUtils();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final SystemUtils_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new SystemUtils_Factory();

        private InstanceHolder() {
        }
    }
}
