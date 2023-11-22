package id.dana.qriscrossborder;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.qriscrossborder.interactor.GetQrisCountryCodeByLocation;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderConfig;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderContent;
import id.dana.domain.qriscrossborder.interactor.GetQrisCrossBorderCountries;
import id.dana.domain.qriscrossborder.interactor.GetQrisCurrentCountryCode;
import id.dana.domain.qriscrossborder.interactor.GetQrisOriginCountryCode;
import id.dana.domain.qriscrossborder.interactor.SaveQrisCurrentCountryCode;
import id.dana.domain.qriscrossborder.interactor.SaveQrisOriginCountryCode;
import id.dana.domain.qriscrossborder.interactor.SendRiskEventWithParams;
import id.dana.qriscrossborder.QrisCrossBorderContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class QrisCrossBorderPresenter_Factory implements Factory<QrisCrossBorderPresenter> {
    private final Provider<GetQrisCurrentCountryCode> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetQrisCrossBorderCountries> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetQrisCrossBorderConfig> MyBillsEntityDataFactory;
    private final Provider<QrisCrossBorderContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetQrisCountryCodeByLocation> PlaceComponentResult;
    private final Provider<GetQrisCrossBorderContent> getAuthRequestContext;
    private final Provider<GetQrisOriginCountryCode> getErrorConfigVersion;
    private final Provider<SaveQrisOriginCountryCode> lookAheadTest;
    private final Provider<SendRiskEventWithParams> moveToNextValue;
    private final Provider<SaveQrisCurrentCountryCode> scheduleImpl;

    private QrisCrossBorderPresenter_Factory(Provider<QrisCrossBorderContract.View> provider, Provider<GetQrisCrossBorderConfig> provider2, Provider<GetQrisCrossBorderCountries> provider3, Provider<GetQrisCountryCodeByLocation> provider4, Provider<GetQrisCurrentCountryCode> provider5, Provider<GetQrisOriginCountryCode> provider6, Provider<SaveQrisOriginCountryCode> provider7, Provider<SaveQrisCurrentCountryCode> provider8, Provider<GetQrisCrossBorderContent> provider9, Provider<SendRiskEventWithParams> provider10) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.PlaceComponentResult = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.getErrorConfigVersion = provider6;
        this.lookAheadTest = provider7;
        this.scheduleImpl = provider8;
        this.getAuthRequestContext = provider9;
        this.moveToNextValue = provider10;
    }

    public static QrisCrossBorderPresenter_Factory PlaceComponentResult(Provider<QrisCrossBorderContract.View> provider, Provider<GetQrisCrossBorderConfig> provider2, Provider<GetQrisCrossBorderCountries> provider3, Provider<GetQrisCountryCodeByLocation> provider4, Provider<GetQrisCurrentCountryCode> provider5, Provider<GetQrisOriginCountryCode> provider6, Provider<SaveQrisOriginCountryCode> provider7, Provider<SaveQrisCurrentCountryCode> provider8, Provider<GetQrisCrossBorderContent> provider9, Provider<SendRiskEventWithParams> provider10) {
        return new QrisCrossBorderPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new QrisCrossBorderPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
    }
}
