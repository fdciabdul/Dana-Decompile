package id.dana.data.miniprogram.source.network;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class NetworkMiniPrograms_Factory implements Factory<NetworkMiniPrograms> {
    public static NetworkMiniPrograms_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final NetworkMiniPrograms_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new NetworkMiniPrograms_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkMiniPrograms();
    }
}
