package id.dana.cardbinding.viewmodel;

import android.app.Application;
import dagger.internal.Factory;
import id.dana.cardbinding.domain.interactor.BindingCardAdd;
import id.dana.cardbinding.domain.interactor.GetCardInfoFromImage;
import id.dana.cardbinding.domain.interactor.GetSupportedCardsConfig;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfoFlow;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrlFlow;
import id.dana.cashier.domain.interactor.GetQueryCardPolicyFlow;
import id.dana.cashier.domain.interactor.PayCashierFlow;
import id.dana.cashier.domain.interactor.PayQueryCashierFlow;
import id.dana.cashier.mapper.CashierCheckoutModelMapper;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.payasset.interactor.QueryPayMethod;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CardBindingViewModel_Factory implements Factory<CardBindingViewModel> {
    private final Provider<CashierPayModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SaveShowToolTip> DatabaseTableConfigUtil;
    private final Provider<QueryPayMethod> GetContactSyncConfig;
    private final Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CashierCheckoutModelMapper> MyBillsEntityDataFactory;
    private final Provider<GetCashierCheckoutInfoFlow> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<IsNeedToShowToolTip> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<PayCashierFlow> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<DeviceInformationProvider> PlaceComponentResult;
    private final Provider<BindingCardAdd> getAuthRequestContext;
    private final Provider<GetOneklikRedirectUrlFlow> getErrorConfigVersion;
    private final Provider<PayQueryCashierFlow> initRecordTimeStamp;
    private final Provider<GetQueryCardPolicyFlow> lookAheadTest;
    private final Provider<GetCardInfoFromImage> moveToNextValue;
    private final Provider<GetSupportedCardsConfig> scheduleImpl;

    private CardBindingViewModel_Factory(Provider<Application> provider, Provider<GetCardInfoFromImage> provider2, Provider<IsNeedToShowToolTip> provider3, Provider<SaveShowToolTip> provider4, Provider<BindingCardAdd> provider5, Provider<GetQueryCardPolicyFlow> provider6, Provider<GetCashierCheckoutInfoFlow> provider7, Provider<CashierCheckoutModelMapper> provider8, Provider<CashierPayModelMapper> provider9, Provider<GetSupportedCardsConfig> provider10, Provider<PayCashierFlow> provider11, Provider<PayQueryCashierFlow> provider12, Provider<DeviceInformationProvider> provider13, Provider<GetOneklikRedirectUrlFlow> provider14, Provider<QueryPayMethod> provider15) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.moveToNextValue = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider3;
        this.DatabaseTableConfigUtil = provider4;
        this.getAuthRequestContext = provider5;
        this.lookAheadTest = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider7;
        this.MyBillsEntityDataFactory = provider8;
        this.BuiltInFictitiousFunctionClassFactory = provider9;
        this.scheduleImpl = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider11;
        this.initRecordTimeStamp = provider12;
        this.PlaceComponentResult = provider13;
        this.getErrorConfigVersion = provider14;
        this.GetContactSyncConfig = provider15;
    }

    public static CardBindingViewModel_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Application> provider, Provider<GetCardInfoFromImage> provider2, Provider<IsNeedToShowToolTip> provider3, Provider<SaveShowToolTip> provider4, Provider<BindingCardAdd> provider5, Provider<GetQueryCardPolicyFlow> provider6, Provider<GetCashierCheckoutInfoFlow> provider7, Provider<CashierCheckoutModelMapper> provider8, Provider<CashierPayModelMapper> provider9, Provider<GetSupportedCardsConfig> provider10, Provider<PayCashierFlow> provider11, Provider<PayQueryCashierFlow> provider12, Provider<DeviceInformationProvider> provider13, Provider<GetOneklikRedirectUrlFlow> provider14, Provider<QueryPayMethod> provider15) {
        return new CardBindingViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CardBindingViewModel(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.moveToNextValue.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.DatabaseTableConfigUtil.get(), this.getAuthRequestContext.get(), this.lookAheadTest.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.scheduleImpl.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.initRecordTimeStamp.get(), this.PlaceComponentResult.get(), this.getErrorConfigVersion.get(), this.GetContactSyncConfig.get());
    }
}
