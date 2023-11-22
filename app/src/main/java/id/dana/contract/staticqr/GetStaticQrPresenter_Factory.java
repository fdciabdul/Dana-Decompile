package id.dana.contract.staticqr;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig;
import id.dana.domain.qrbarcode.interactor.GetUserDynamicQr;
import id.dana.domain.qrbarcode.interactor.GetUserStaticQr;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetStaticQrPresenter_Factory implements Factory<GetStaticQrPresenter> {
    private final Provider<GetQrisTcicoConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserDynamicQr> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetUserStaticQr> MyBillsEntityDataFactory;
    private final Provider<GetStaticQrContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<ApiHitTimer> getAuthRequestContext;

    private GetStaticQrPresenter_Factory(Provider<Context> provider, Provider<GetStaticQrContract.View> provider2, Provider<GetUserStaticQr> provider3, Provider<GetUserDynamicQr> provider4, Provider<GetQrisTcicoConfig> provider5, Provider<ApiHitTimer> provider6) {
        this.PlaceComponentResult = provider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.getAuthRequestContext = provider6;
    }

    public static GetStaticQrPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<GetStaticQrContract.View> provider2, Provider<GetUserStaticQr> provider3, Provider<GetUserDynamicQr> provider4, Provider<GetQrisTcicoConfig> provider5, Provider<ApiHitTimer> provider6) {
        return new GetStaticQrPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetStaticQrPresenter(this.PlaceComponentResult.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
