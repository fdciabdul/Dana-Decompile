package id.dana.feeds.data.username.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkUserProfileEntityData_Factory implements Factory<NetworkUserProfileEntityData> {
    private final Provider<ApSecurityFacade> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<RpcConnector> getAuthRequestContext;

    private NetworkUserProfileEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static NetworkUserProfileEntityData_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<RpcConnector> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3) {
        return new NetworkUserProfileEntityData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkUserProfileEntityData(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
