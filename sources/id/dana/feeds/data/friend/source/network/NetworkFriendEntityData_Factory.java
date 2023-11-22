package id.dana.feeds.data.friend.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkFriendEntityData_Factory implements Factory<NetworkFriendEntityData> {
    private final Provider<ThreadExecutor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ApSecurityFacade> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<RpcConnector> getAuthRequestContext;

    private NetworkFriendEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static NetworkFriendEntityData_Factory getAuthRequestContext(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new NetworkFriendEntityData_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkFriendEntityData(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
