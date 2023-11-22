package id.dana.mapper;

import dagger.internal.Factory;

/* loaded from: classes9.dex */
public final class ReferralStatusMapper_Factory implements Factory<ReferralStatusMapper> {
    public static ReferralStatusMapper_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes9.dex */
    static final class InstanceHolder {
        private static final ReferralStatusMapper_Factory getAuthRequestContext = new ReferralStatusMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReferralStatusMapper();
    }
}
