package id.dana.contract.deeplink;

import android.app.Application;
import dagger.internal.Factory;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.deeplink.path.OauthContract;
import id.dana.contract.services.ServicesPresenter;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DeepLinkView_Factory implements Factory<DeepLinkView> {
    private final Provider<GetUserLoanInfo> BuiltInFictitiousFunctionClassFactory;
    private final Provider<OauthContract.Presenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Application> MyBillsEntityDataFactory;
    private final Provider<ScanQrContract.Presenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<RestoreUrlContract.Presenter> PlaceComponentResult;
    private final Provider<FeatureContract.Presenter> getAuthRequestContext;
    private final Provider<ServicesPresenter> moveToNextValue;

    private DeepLinkView_Factory(Provider<ScanQrContract.Presenter> provider, Provider<RestoreUrlContract.Presenter> provider2, Provider<FeatureContract.Presenter> provider3, Provider<OauthContract.Presenter> provider4, Provider<ServicesPresenter> provider5, Provider<Application> provider6, Provider<GetUserLoanInfo> provider7) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.moveToNextValue = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.BuiltInFictitiousFunctionClassFactory = provider7;
    }

    public static DeepLinkView_Factory getAuthRequestContext(Provider<ScanQrContract.Presenter> provider, Provider<RestoreUrlContract.Presenter> provider2, Provider<FeatureContract.Presenter> provider3, Provider<OauthContract.Presenter> provider4, Provider<ServicesPresenter> provider5, Provider<Application> provider6, Provider<GetUserLoanInfo> provider7) {
        return new DeepLinkView_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        DeepLinkView deepLinkView = new DeepLinkView(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.moveToNextValue.get(), this.MyBillsEntityDataFactory.get());
        DeepLinkView_MembersInjector.MyBillsEntityDataFactory(deepLinkView, this.BuiltInFictitiousFunctionClassFactory.get());
        return deepLinkView;
    }
}
