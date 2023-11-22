package id.dana.contract.deeplink.path;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class FeatureKyb_Factory implements Factory<FeatureKyb> {
    public static FeatureKyb_Factory getAuthRequestContext() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final FeatureKyb_Factory MyBillsEntityDataFactory = new FeatureKyb_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureKyb();
    }
}
