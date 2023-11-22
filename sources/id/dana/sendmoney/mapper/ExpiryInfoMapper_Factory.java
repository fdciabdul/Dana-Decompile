package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ExpiryInfoMapper_Factory implements Factory<ExpiryInfoMapper> {
    public static ExpiryInfoMapper_Factory PlaceComponentResult() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final ExpiryInfoMapper_Factory BuiltInFictitiousFunctionClassFactory = new ExpiryInfoMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ExpiryInfoMapper();
    }
}
