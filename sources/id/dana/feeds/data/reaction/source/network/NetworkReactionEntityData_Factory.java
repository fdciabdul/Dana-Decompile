package id.dana.feeds.data.reaction.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class NetworkReactionEntityData_Factory implements Factory<NetworkReactionEntityData> {
    private final Provider<RpcConnector> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ThreadExecutor> MyBillsEntityDataFactory;
    private final Provider<ApSecurityFacade> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkReactionEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
