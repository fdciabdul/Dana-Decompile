package id.dana.kyb.helper.service.strategy;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class KybServiceUrlActionStrategy_Factory implements Factory<KybServiceUrlActionStrategy> {
    public static KybServiceUrlActionStrategy_Factory getAuthRequestContext() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final KybServiceUrlActionStrategy_Factory getAuthRequestContext = new KybServiceUrlActionStrategy_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybServiceUrlActionStrategy();
    }
}
