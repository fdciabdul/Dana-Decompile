package id.dana.contract.onlinemerchant;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.onlinemerchant.OnlineMerchantContract;
import id.dana.explore.domain.globalsearch.interactor.GetOnlineMerchant;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class OnlineMerchantPresenter_Factory implements Factory<OnlineMerchantPresenter> {
    private final Provider<GetOnlineMerchant> BuiltInFictitiousFunctionClassFactory;
    private final Provider<OnlineMerchantContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<GetOnlineMerchant> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OnlineMerchantPresenter(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
