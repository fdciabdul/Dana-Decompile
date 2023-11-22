package id.dana.paymentsetting;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.paymentsetting.interactor.PaymentSettingCheck;
import id.dana.domain.paymentsetting.interactor.SavePaymentSettingCheck;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.profilemenu.interactor.InitPaymentAuthentication;
import id.dana.myprofile.mapper.PaymentSecurityInitMapper;
import id.dana.myprofile.mapper.PaymentSecuritySwitchMapper;
import id.dana.paymentsetting.PaymentSettingContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PaymentSettingPresenter_Factory implements Factory<PaymentSettingPresenter> {
    private final Provider<GetAutoRouteInitialSetting> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetSettingByKey> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ControlSwitchPaymentAuthentication> MyBillsEntityDataFactory;
    private final Provider<PaymentSecuritySwitchMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<InitPaymentAuthentication> PlaceComponentResult;
    private final Provider<PaymentSecurityInitMapper> getAuthRequestContext;
    private final Provider<SavePaymentSettingCheck> getErrorConfigVersion;
    private final Provider<SwitchAutoRouting> lookAheadTest;
    private final Provider<PaymentSettingContract.View> moveToNextValue;
    private final Provider<PaymentSettingCheck> scheduleImpl;

    private PaymentSettingPresenter_Factory(Provider<PaymentSettingContract.View> provider, Provider<PaymentSettingCheck> provider2, Provider<SavePaymentSettingCheck> provider3, Provider<GetSettingByKey> provider4, Provider<GetAutoRouteInitialSetting> provider5, Provider<SwitchAutoRouting> provider6, Provider<InitPaymentAuthentication> provider7, Provider<PaymentSecurityInitMapper> provider8, Provider<ControlSwitchPaymentAuthentication> provider9, Provider<PaymentSecuritySwitchMapper> provider10) {
        this.moveToNextValue = provider;
        this.scheduleImpl = provider2;
        this.getErrorConfigVersion = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.lookAheadTest = provider6;
        this.PlaceComponentResult = provider7;
        this.getAuthRequestContext = provider8;
        this.MyBillsEntityDataFactory = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider10;
    }

    public static PaymentSettingPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<PaymentSettingContract.View> provider, Provider<PaymentSettingCheck> provider2, Provider<SavePaymentSettingCheck> provider3, Provider<GetSettingByKey> provider4, Provider<GetAutoRouteInitialSetting> provider5, Provider<SwitchAutoRouting> provider6, Provider<InitPaymentAuthentication> provider7, Provider<PaymentSecurityInitMapper> provider8, Provider<ControlSwitchPaymentAuthentication> provider9, Provider<PaymentSecuritySwitchMapper> provider10) {
        return new PaymentSettingPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PaymentSettingPresenter(this.moveToNextValue.get(), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
    }
}
