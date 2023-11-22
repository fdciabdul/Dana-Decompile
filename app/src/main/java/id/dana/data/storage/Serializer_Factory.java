package id.dana.data.storage;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class Serializer_Factory implements Factory<Serializer> {
    @Override // javax.inject.Provider
    public final Serializer get() {
        return newInstance();
    }

    public static Serializer_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static Serializer newInstance() {
        return new Serializer();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final Serializer_Factory BuiltInFictitiousFunctionClassFactory = new Serializer_Factory();

        private InstanceHolder() {
        }
    }
}
