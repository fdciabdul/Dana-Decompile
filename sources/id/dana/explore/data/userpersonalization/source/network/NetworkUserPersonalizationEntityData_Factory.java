package id.dana.explore.data.userpersonalization.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkUserPersonalizationEntityData_Factory implements Factory<NetworkUserPersonalizationEntityData> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RpcConnector> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ApSecurityFacade> PlaceComponentResult;
    private final Provider<ThreadExecutor> getAuthRequestContext;

    private NetworkUserPersonalizationEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
    }

    public static NetworkUserPersonalizationEntityData_Factory PlaceComponentResult(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new NetworkUserPersonalizationEntityData_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkUserPersonalizationEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
