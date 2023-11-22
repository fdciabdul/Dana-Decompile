package id.dana.lazada;

import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.lazada.interactor.GetLazadaClickedAgree;
import id.dana.domain.lazada.interactor.GetLazadaRegistrationUrl;
import id.dana.domain.lazada.interactor.SaveLazadaClickedAgree;
import id.dana.lazada.LazadaGuideContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class LazadaGuidePresenter_Factory implements Factory<LazadaGuidePresenter> {
    private final Provider<GetAuthCode> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SaveLazadaClickedAgree> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetLazadaRegistrationUrl> MyBillsEntityDataFactory;
    private final Provider<DeviceInformationProvider> PlaceComponentResult;
    private final Provider<GetLazadaClickedAgree> getAuthRequestContext;
    private final Provider<LazadaGuideContract.View> moveToNextValue;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LazadaGuidePresenter(this.moveToNextValue.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
