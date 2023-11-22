package id.dana.contract.deeplink.path;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class FeatureMyBills_Factory implements Factory<FeatureMyBills> {
    public static FeatureMyBills_Factory PlaceComponentResult() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final FeatureMyBills_Factory BuiltInFictitiousFunctionClassFactory = new FeatureMyBills_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureMyBills();
    }
}
