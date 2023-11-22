package id.dana.danah5;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class DanaH5Impl_Factory implements Factory<DanaH5Impl> {
    @Override // javax.inject.Provider
    public final DanaH5Impl get() {
        return newInstance();
    }

    public static DanaH5Impl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DanaH5Impl newInstance() {
        return new DanaH5Impl();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final DanaH5Impl_Factory INSTANCE = new DanaH5Impl_Factory();

        private InstanceHolder() {
        }
    }
}
