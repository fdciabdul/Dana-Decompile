package id.dana.biometric.data.source.local;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class LocalRiskTrackerEntityData_Factory implements Factory<LocalRiskTrackerEntityData> {
    @Override // javax.inject.Provider
    public final LocalRiskTrackerEntityData get() {
        return newInstance();
    }

    public static LocalRiskTrackerEntityData_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static LocalRiskTrackerEntityData newInstance() {
        return new LocalRiskTrackerEntityData();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final LocalRiskTrackerEntityData_Factory BuiltInFictitiousFunctionClassFactory = new LocalRiskTrackerEntityData_Factory();

        private InstanceHolder() {
        }
    }
}
