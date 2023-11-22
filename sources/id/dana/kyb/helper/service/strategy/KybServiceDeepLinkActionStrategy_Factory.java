package id.dana.kyb.helper.service.strategy;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class KybServiceDeepLinkActionStrategy_Factory implements Factory<KybServiceDeepLinkActionStrategy> {
    public static KybServiceDeepLinkActionStrategy_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final KybServiceDeepLinkActionStrategy_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new KybServiceDeepLinkActionStrategy_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybServiceDeepLinkActionStrategy();
    }
}
