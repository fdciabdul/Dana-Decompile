package id.dana.feeds.data.timeline.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkFeedsTimelineData_Factory implements Factory<NetworkFeedsTimelineData> {
    private final Provider<ThreadExecutor> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ApSecurityFacade> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<RpcConnector> getAuthRequestContext;

    private NetworkFeedsTimelineData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static NetworkFeedsTimelineData_Factory PlaceComponentResult(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new NetworkFeedsTimelineData_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkFeedsTimelineData(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
