package id.dana.kyb.helper.service.strategy;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class KybServiceActionTypeStrategy_Factory implements Factory<KybServiceActionTypeStrategy> {
    public static KybServiceActionTypeStrategy_Factory getAuthRequestContext() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final KybServiceActionTypeStrategy_Factory PlaceComponentResult = new KybServiceActionTypeStrategy_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybServiceActionTypeStrategy();
    }
}
