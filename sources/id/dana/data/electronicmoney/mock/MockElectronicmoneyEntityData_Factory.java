package id.dana.data.electronicmoney.mock;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class MockElectronicmoneyEntityData_Factory implements Factory<MockElectronicmoneyEntityData> {
    public static MockElectronicmoneyEntityData_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final MockElectronicmoneyEntityData_Factory BuiltInFictitiousFunctionClassFactory = new MockElectronicmoneyEntityData_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MockElectronicmoneyEntityData();
    }
}
