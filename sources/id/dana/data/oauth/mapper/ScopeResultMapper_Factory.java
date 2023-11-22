package id.dana.data.oauth.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ScopeResultMapper_Factory implements Factory<ScopeResultMapper> {
    @Override // javax.inject.Provider
    public final ScopeResultMapper get() {
        return newInstance();
    }

    public static ScopeResultMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static ScopeResultMapper newInstance() {
        return new ScopeResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ScopeResultMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new ScopeResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
