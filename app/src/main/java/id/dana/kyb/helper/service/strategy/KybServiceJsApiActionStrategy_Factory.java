package id.dana.kyb.helper.service.strategy;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class KybServiceJsApiActionStrategy_Factory implements Factory<KybServiceJsApiActionStrategy> {
    public static KybServiceJsApiActionStrategy_Factory PlaceComponentResult() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final KybServiceJsApiActionStrategy_Factory BuiltInFictitiousFunctionClassFactory = new KybServiceJsApiActionStrategy_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybServiceJsApiActionStrategy();
    }
}
