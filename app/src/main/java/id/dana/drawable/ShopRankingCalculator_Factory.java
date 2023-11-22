package id.dana.drawable;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ShopRankingCalculator_Factory implements Factory<ShopRankingCalculator> {
    public static ShopRankingCalculator_Factory getAuthRequestContext() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final ShopRankingCalculator_Factory BuiltInFictitiousFunctionClassFactory = new ShopRankingCalculator_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ShopRankingCalculator();
    }
}
