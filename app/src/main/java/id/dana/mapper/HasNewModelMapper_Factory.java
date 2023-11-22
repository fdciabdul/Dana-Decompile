package id.dana.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class HasNewModelMapper_Factory implements Factory<HasNewModelMapper> {
    public static HasNewModelMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final HasNewModelMapper_Factory BuiltInFictitiousFunctionClassFactory = new HasNewModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HasNewModelMapper();
    }
}
