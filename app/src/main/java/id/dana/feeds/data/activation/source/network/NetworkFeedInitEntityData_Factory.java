package id.dana.feeds.data.activation.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkFeedInitEntityData_Factory implements Factory<NetworkFeedInitEntityData> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RpcConnector> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ApSecurityFacade> getAuthRequestContext;

    private NetworkFeedInitEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static NetworkFeedInitEntityData_Factory getAuthRequestContext(Provider<RpcConnector> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3) {
        return new NetworkFeedInitEntityData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkFeedInitEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
