package id.dana.data.services.repository.source.local;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class DefaultServicesEntityData_Factory implements Factory<DefaultServicesEntityData> {
    @Override // javax.inject.Provider
    public final DefaultServicesEntityData get() {
        return newInstance();
    }

    public static DefaultServicesEntityData_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static DefaultServicesEntityData newInstance() {
        return new DefaultServicesEntityData();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final DefaultServicesEntityData_Factory BuiltInFictitiousFunctionClassFactory = new DefaultServicesEntityData_Factory();

        private InstanceHolder() {
        }
    }
}
