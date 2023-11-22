package id.dana.data.holdlogin.v2.entity.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NewHoldLoginEntityNetwork_Factory implements Factory<NewHoldLoginEntityNetwork> {
    private final Provider<ApSecurityFacade> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ImplSharedHoldLoginNetwork> MyBillsEntityDataFactory;
    private final Provider<ThreadExecutor> PlaceComponentResult;
    private final Provider<HoldLoginConfig> getAuthRequestContext;

    private NewHoldLoginEntityNetwork_Factory(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<ThreadExecutor> provider3, Provider<ImplSharedHoldLoginNetwork> provider4, Provider<HoldLoginConfig> provider5) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.getAuthRequestContext = provider5;
    }

    public static NewHoldLoginEntityNetwork_Factory PlaceComponentResult(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<ThreadExecutor> provider3, Provider<ImplSharedHoldLoginNetwork> provider4, Provider<HoldLoginConfig> provider5) {
        return new NewHoldLoginEntityNetwork_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NewHoldLoginEntityNetwork(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
