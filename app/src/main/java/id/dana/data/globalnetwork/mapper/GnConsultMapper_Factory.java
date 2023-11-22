package id.dana.data.globalnetwork.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class GnConsultMapper_Factory implements Factory<GnConsultMapper> {
    @Override // javax.inject.Provider
    public final GnConsultMapper get() {
        return newInstance();
    }

    public static GnConsultMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static GnConsultMapper newInstance() {
        return new GnConsultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final GnConsultMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new GnConsultMapper_Factory();

        private InstanceHolder() {
        }
    }
}
