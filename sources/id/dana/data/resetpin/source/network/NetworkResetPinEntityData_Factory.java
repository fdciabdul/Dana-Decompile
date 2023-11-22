package id.dana.data.resetpin.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkResetPinEntityData_Factory implements Factory<NetworkResetPinEntityData> {
    private final Provider<RpcConnector> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ApSecurityFacade> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ThreadExecutor> MyBillsEntityDataFactory;
    private final Provider<Context> getAuthRequestContext;

    private NetworkResetPinEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
    }

    public static NetworkResetPinEntityData_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        return new NetworkResetPinEntityData_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkResetPinEntityData(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
