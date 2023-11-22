package id.dana.data.statement.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkUserStatementEntityData_Factory implements Factory<NetworkUserStatementEntityData> {
    private final Provider<RpcConnector> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ThreadExecutor> MyBillsEntityDataFactory;
    private final Provider<ApSecurityFacade> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private NetworkUserStatementEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static NetworkUserStatementEntityData_Factory getAuthRequestContext(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        return new NetworkUserStatementEntityData_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkUserStatementEntityData(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
