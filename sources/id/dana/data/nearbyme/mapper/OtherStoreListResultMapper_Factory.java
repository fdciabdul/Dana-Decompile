package id.dana.data.nearbyme.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class OtherStoreListResultMapper_Factory implements Factory<OtherStoreListResultMapper> {
    @Override // javax.inject.Provider
    public final OtherStoreListResultMapper get() {
        return newInstance();
    }

    public static OtherStoreListResultMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static OtherStoreListResultMapper newInstance() {
        return new OtherStoreListResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final OtherStoreListResultMapper_Factory getAuthRequestContext = new OtherStoreListResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
