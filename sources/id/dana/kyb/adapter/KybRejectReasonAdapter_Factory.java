package id.dana.kyb.adapter;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class KybRejectReasonAdapter_Factory implements Factory<KybRejectReasonAdapter> {
    public static KybRejectReasonAdapter_Factory PlaceComponentResult() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final KybRejectReasonAdapter_Factory BuiltInFictitiousFunctionClassFactory = new KybRejectReasonAdapter_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybRejectReasonAdapter();
    }
}
