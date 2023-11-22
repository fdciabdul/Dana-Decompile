package id.dana.cashier.presenter;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.cashier.CashierContract;
import id.dana.cashier.domain.interactor.CashierUpdateOrder;
import id.dana.cashier.domain.interactor.CheckNeedToShowSmartpayDialog;
import id.dana.cashier.domain.interactor.CreateCashierOrder;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfo;
import id.dana.cashier.domain.interactor.GetCashierKybProduct;
import id.dana.cashier.domain.interactor.GetCurrencyFromCdn;
import id.dana.cashier.domain.interactor.GetCustomLoading3dsUrls;
import id.dana.cashier.domain.interactor.GetQueryPromotion;
import id.dana.cashier.domain.interactor.PayCashier;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.domain.interactor.SaveLastSmartpayActivationShow;
import id.dana.cashier.mapper.CashierCheckoutModelMapper;
import id.dana.cashier.mapper.CashierPayMethodModelMapper;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.cashier.mapper.QueryPromotionModelMapper;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.featureconfig.interactor.CheckAutoRouteSmartPayFeature;
import id.dana.domain.featureconfig.interactor.CheckMixPayFeature;
import id.dana.domain.qrbarcode.interactor.PreCreateCashierOrder;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierPresenter_Factory implements Factory<CashierPresenter> {
    private final Provider<CashierPayMethodModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetCashierCheckoutInfo> DatabaseTableConfigUtil;
    private final Provider<SaveShowToolTip> FragmentBottomSheetPaymentSettingBinding;
    private final Provider<FaceAuthentication> GetContactSyncConfig;
    private final Provider<CashierPayModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CashierCheckoutModelMapper> MyBillsEntityDataFactory;
    private final Provider<CheckNeedToShowSmartpayDialog> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<GetAutoRouteInitialSetting> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<SaveLastSmartpayActivationShow> NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final Provider<PreCreateCashierOrder> NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final Provider<PayQueryCashier> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final Provider<QueryPromotionModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Provider<PayCashier> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<GetQueryPromotion> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Provider<CheckAutoRouteSmartPayFeature> PlaceComponentResult;
    private final Provider<GetCurrencyFromCdn> PrepareContext;
    private final Provider<CashierUpdateOrder> getAuthRequestContext;
    private final Provider<SwitchAutoRouting> getCallingPid;
    private final Provider<Context> getErrorConfigVersion;
    private final Provider<GetCashierKybProduct> initRecordTimeStamp;
    private final Provider<GetCustomLoading3dsUrls> isLayoutRequested;
    private final Provider<DanaVizTrackerImpl> lookAheadTest;
    private final Provider<CreateCashierOrder> moveToNextValue;
    private final Provider<IsNeedToShowToolTip> newProxyInstance;
    private final Provider<CashierContract.View> readMicros;
    private final Provider<CheckMixPayFeature> scheduleImpl;

    private CashierPresenter_Factory(Provider<Context> provider, Provider<CashierContract.View> provider2, Provider<CashierCheckoutModelMapper> provider3, Provider<CashierPayMethodModelMapper> provider4, Provider<CashierPayModelMapper> provider5, Provider<QueryPromotionModelMapper> provider6, Provider<GetCashierCheckoutInfo> provider7, Provider<PayCashier> provider8, Provider<PayQueryCashier> provider9, Provider<CreateCashierOrder> provider10, Provider<DeviceInformationProvider> provider11, Provider<CheckAutoRouteSmartPayFeature> provider12, Provider<GetAutoRouteInitialSetting> provider13, Provider<FaceAuthentication> provider14, Provider<CheckMixPayFeature> provider15, Provider<GetQueryPromotion> provider16, Provider<IsNeedToShowToolTip> provider17, Provider<SaveShowToolTip> provider18, Provider<CashierUpdateOrder> provider19, Provider<GetCashierKybProduct> provider20, Provider<DanaVizTrackerImpl> provider21, Provider<PreCreateCashierOrder> provider22, Provider<GetCustomLoading3dsUrls> provider23, Provider<SwitchAutoRouting> provider24, Provider<CheckNeedToShowSmartpayDialog> provider25, Provider<SaveLastSmartpayActivationShow> provider26, Provider<GetCurrencyFromCdn> provider27) {
        this.getErrorConfigVersion = provider;
        this.readMicros = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = provider6;
        this.DatabaseTableConfigUtil = provider7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = provider9;
        this.moveToNextValue = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider11;
        this.PlaceComponentResult = provider12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider13;
        this.GetContactSyncConfig = provider14;
        this.scheduleImpl = provider15;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = provider16;
        this.newProxyInstance = provider17;
        this.FragmentBottomSheetPaymentSettingBinding = provider18;
        this.getAuthRequestContext = provider19;
        this.initRecordTimeStamp = provider20;
        this.lookAheadTest = provider21;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = provider22;
        this.isLayoutRequested = provider23;
        this.getCallingPid = provider24;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider25;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = provider26;
        this.PrepareContext = provider27;
    }

    public static CashierPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<CashierContract.View> provider2, Provider<CashierCheckoutModelMapper> provider3, Provider<CashierPayMethodModelMapper> provider4, Provider<CashierPayModelMapper> provider5, Provider<QueryPromotionModelMapper> provider6, Provider<GetCashierCheckoutInfo> provider7, Provider<PayCashier> provider8, Provider<PayQueryCashier> provider9, Provider<CreateCashierOrder> provider10, Provider<DeviceInformationProvider> provider11, Provider<CheckAutoRouteSmartPayFeature> provider12, Provider<GetAutoRouteInitialSetting> provider13, Provider<FaceAuthentication> provider14, Provider<CheckMixPayFeature> provider15, Provider<GetQueryPromotion> provider16, Provider<IsNeedToShowToolTip> provider17, Provider<SaveShowToolTip> provider18, Provider<CashierUpdateOrder> provider19, Provider<GetCashierKybProduct> provider20, Provider<DanaVizTrackerImpl> provider21, Provider<PreCreateCashierOrder> provider22, Provider<GetCustomLoading3dsUrls> provider23, Provider<SwitchAutoRouting> provider24, Provider<CheckNeedToShowSmartpayDialog> provider25, Provider<SaveLastSmartpayActivationShow> provider26, Provider<GetCurrencyFromCdn> provider27) {
        return new CashierPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierPresenter(this.getErrorConfigVersion.get(), DoubleCheck.MyBillsEntityDataFactory(this.readMicros), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda6.get(), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda5), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8), DoubleCheck.MyBillsEntityDataFactory(this.newProxyInstance), DoubleCheck.MyBillsEntityDataFactory(this.FragmentBottomSheetPaymentSettingBinding), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), this.lookAheadTest.get(), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda4), DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested), DoubleCheck.MyBillsEntityDataFactory(this.getCallingPid), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3), DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext));
    }
}
