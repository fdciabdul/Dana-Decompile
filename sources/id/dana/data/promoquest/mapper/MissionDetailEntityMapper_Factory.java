package id.dana.data.promoquest.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MissionDetailEntityMapper_Factory implements Factory<MissionDetailEntityMapper> {
    @Override // javax.inject.Provider
    public final MissionDetailEntityMapper get() {
        return newInstance();
    }

    public static MissionDetailEntityMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static MissionDetailEntityMapper newInstance() {
        return new MissionDetailEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MissionDetailEntityMapper_Factory BuiltInFictitiousFunctionClassFactory = new MissionDetailEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
