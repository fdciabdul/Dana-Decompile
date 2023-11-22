package id.dana.data.holdlogin.v2.entity.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class OldHoldLoginEntityNetwork_Factory implements Factory<OldHoldLoginEntityNetwork> {
    private final Provider<ImplSharedHoldLoginNetwork> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ThreadExecutor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<HoldLoginConfig> PlaceComponentResult;
    private final Provider<ApSecurityFacade> getAuthRequestContext;

    private OldHoldLoginEntityNetwork_Factory(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<ThreadExecutor> provider3, Provider<ImplSharedHoldLoginNetwork> provider4, Provider<HoldLoginConfig> provider5) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.PlaceComponentResult = provider5;
    }

    public static OldHoldLoginEntityNetwork_Factory PlaceComponentResult(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<ThreadExecutor> provider3, Provider<ImplSharedHoldLoginNetwork> provider4, Provider<HoldLoginConfig> provider5) {
        return new OldHoldLoginEntityNetwork_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OldHoldLoginEntityNetwork(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
