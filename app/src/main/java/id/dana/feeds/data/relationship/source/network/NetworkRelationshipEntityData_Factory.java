package id.dana.feeds.data.relationship.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class NetworkRelationshipEntityData_Factory implements Factory<NetworkRelationshipEntityData> {
    private final Provider<RpcConnector> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ApSecurityFacade> PlaceComponentResult;
    private final Provider<ThreadExecutor> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkRelationshipEntityData(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
