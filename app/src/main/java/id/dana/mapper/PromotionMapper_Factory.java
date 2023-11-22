package id.dana.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class PromotionMapper_Factory implements Factory<PromotionMapper> {
    public static PromotionMapper_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final PromotionMapper_Factory MyBillsEntityDataFactory = new PromotionMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromotionMapper();
    }
}
