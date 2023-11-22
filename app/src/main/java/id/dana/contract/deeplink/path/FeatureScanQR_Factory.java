package id.dana.contract.deeplink.path;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class FeatureScanQR_Factory implements Factory<FeatureScanQR> {
    public static FeatureScanQR_Factory PlaceComponentResult() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final FeatureScanQR_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new FeatureScanQR_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureScanQR();
    }
}
