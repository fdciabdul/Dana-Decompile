package id.dana.data.recurring.subscription.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkRecurringSubscription_Factory implements Factory<NetworkRecurringSubscription> {
    private final Provider<ApSecurity> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ThreadExecutor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<RpcConnector> getAuthRequestContext;

    private NetworkRecurringSubscription_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurity> provider3, Provider<Context> provider4) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static NetworkRecurringSubscription_Factory MyBillsEntityDataFactory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurity> provider3, Provider<Context> provider4) {
        return new NetworkRecurringSubscription_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkRecurringSubscription(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
