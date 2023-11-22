package id.dana.oauth;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ScopeAdapter_Factory implements Factory<ScopeAdapter> {
    public static ScopeAdapter KClassImpl$Data$declaredNonStaticMembers$2() {
        return new ScopeAdapter();
    }

    /* loaded from: classes9.dex */
    static final class InstanceHolder {
        private static final ScopeAdapter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new ScopeAdapter_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ScopeAdapter();
    }
}
