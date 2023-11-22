package id.dana.data.config.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class GeofenceConfigMapper_Factory implements Factory<GeofenceConfigMapper> {
    @Override // javax.inject.Provider
    public final GeofenceConfigMapper get() {
        return newInstance();
    }

    public static GeofenceConfigMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static GeofenceConfigMapper newInstance() {
        return new GeofenceConfigMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final GeofenceConfigMapper_Factory BuiltInFictitiousFunctionClassFactory = new GeofenceConfigMapper_Factory();

        private InstanceHolder() {
        }
    }
}
