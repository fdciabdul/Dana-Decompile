package id.dana.sync_engine.data.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContactEntityDataNetwork_Factory implements Factory<ContactEntityDataNetwork> {
    private final Provider<ApSecurityFacade> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ThreadExecutor> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<RpcConnector> getAuthRequestContext;

    private ContactEntityDataNetwork_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
    }

    public static ContactEntityDataNetwork_Factory PlaceComponentResult(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4) {
        return new ContactEntityDataNetwork_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactEntityDataNetwork(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
