package id.dana.feeds.data.detail.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class NetworkFeedsDetailEntityData_Factory implements Factory<NetworkFeedsDetailEntityData> {
    private final Provider<ApSecurityFacade> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RpcConnector> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<ThreadExecutor> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkFeedsDetailEntityData(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
