package id.dana.feeds.data.synccontact.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class NetworkSocialSyncProcessEntityData_Factory implements Factory<NetworkSocialSyncProcessEntityData> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RpcConnector> PlaceComponentResult;
    private final Provider<ApSecurityFacade> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkSocialSyncProcessEntityData(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
