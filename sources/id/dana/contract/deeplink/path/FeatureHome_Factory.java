package id.dana.contract.deeplink.path;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class FeatureHome_Factory implements Factory<FeatureHome> {
    public static FeatureHome_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final FeatureHome_Factory getAuthRequestContext = new FeatureHome_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureHome();
    }
}
