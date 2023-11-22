package id.dana.cardbinding.data.repository.source.local;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class MLKitCardBindingEntityData_Factory implements Factory<MLKitCardBindingEntityData> {
    public static MLKitCardBindingEntityData_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MLKitCardBindingEntityData_Factory BuiltInFictitiousFunctionClassFactory = new MLKitCardBindingEntityData_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MLKitCardBindingEntityData();
    }
}
