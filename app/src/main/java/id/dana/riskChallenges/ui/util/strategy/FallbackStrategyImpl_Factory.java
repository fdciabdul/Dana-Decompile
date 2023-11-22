package id.dana.riskChallenges.ui.util.strategy;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class FallbackStrategyImpl_Factory implements Factory<FallbackStrategyImpl> {
    public static FallbackStrategyImpl_Factory PlaceComponentResult() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final FallbackStrategyImpl_Factory MyBillsEntityDataFactory = new FallbackStrategyImpl_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FallbackStrategyImpl();
    }
}
