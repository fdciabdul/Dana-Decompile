package id.dana.cashier.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.cashier.CashierPayLaterContract;
import id.dana.cashier.domain.interactor.GetLoanRegistrationInfo;
import id.dana.cashier.domain.interactor.GetPaylaterCicilOnboardingContent;
import id.dana.cashier.domain.interactor.GetPaylaterCicilRegistrationCooldownCache;
import id.dana.cashier.domain.interactor.GetQueryInstallment;
import id.dana.cashier.domain.interactor.SavePaylaterCicilRegistrationCacheCooldownCount;
import id.dana.cashier.domain.interactor.SavePaylaterCicilRegistrationCacheCooldownDelay;
import id.dana.cashier.mapper.CashierPayMethodModelMapper;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierPayLaterPresenter_Factory implements Factory<CashierPayLaterPresenter> {
    private final Provider<DeviceInformationProvider> BuiltInFictitiousFunctionClassFactory;
    private final Provider<UpdatePayLaterLoanCache> GetContactSyncConfig;
    private final Provider<ClearCachePayLaterLoanWhitelist> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ConsultAgreementOnlyParamSpaceCodes> MyBillsEntityDataFactory;
    private final Provider<GetLoanRegistrationInfo> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<SavePaylaterCicilRegistrationCacheCooldownDelay> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<CashierPayMethodModelMapper> getAuthRequestContext;
    private final Provider<GetQueryInstallment> getErrorConfigVersion;
    private final Provider<CashierPayLaterContract.View> initRecordTimeStamp;
    private final Provider<GetPaylaterCicilOnboardingContent> lookAheadTest;
    private final Provider<SavePaylaterCicilRegistrationCacheCooldownCount> moveToNextValue;
    private final Provider<GetPaylaterCicilRegistrationCooldownCache> scheduleImpl;

    private CashierPayLaterPresenter_Factory(Provider<Context> provider, Provider<CashierPayLaterContract.View> provider2, Provider<GetQueryInstallment> provider3, Provider<GetPaylaterCicilOnboardingContent> provider4, Provider<GetLoanRegistrationInfo> provider5, Provider<CashierPayMethodModelMapper> provider6, Provider<DeviceInformationProvider> provider7, Provider<ConsultAgreementOnlyParamSpaceCodes> provider8, Provider<ClearCachePayLaterLoanWhitelist> provider9, Provider<GetPaylaterCicilRegistrationCooldownCache> provider10, Provider<SavePaylaterCicilRegistrationCacheCooldownCount> provider11, Provider<SavePaylaterCicilRegistrationCacheCooldownDelay> provider12, Provider<UpdatePayLaterLoanCache> provider13) {
        this.PlaceComponentResult = provider;
        this.initRecordTimeStamp = provider2;
        this.getErrorConfigVersion = provider3;
        this.lookAheadTest = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider5;
        this.getAuthRequestContext = provider6;
        this.BuiltInFictitiousFunctionClassFactory = provider7;
        this.MyBillsEntityDataFactory = provider8;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider9;
        this.scheduleImpl = provider10;
        this.moveToNextValue = provider11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider12;
        this.GetContactSyncConfig = provider13;
    }

    public static CashierPayLaterPresenter_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<CashierPayLaterContract.View> provider2, Provider<GetQueryInstallment> provider3, Provider<GetPaylaterCicilOnboardingContent> provider4, Provider<GetLoanRegistrationInfo> provider5, Provider<CashierPayMethodModelMapper> provider6, Provider<DeviceInformationProvider> provider7, Provider<ConsultAgreementOnlyParamSpaceCodes> provider8, Provider<ClearCachePayLaterLoanWhitelist> provider9, Provider<GetPaylaterCicilRegistrationCooldownCache> provider10, Provider<SavePaylaterCicilRegistrationCacheCooldownCount> provider11, Provider<SavePaylaterCicilRegistrationCacheCooldownDelay> provider12, Provider<UpdatePayLaterLoanCache> provider13) {
        return new CashierPayLaterPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierPayLaterPresenter(this.PlaceComponentResult.get(), this.initRecordTimeStamp.get(), this.getErrorConfigVersion.get(), this.lookAheadTest.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.scheduleImpl.get(), this.moveToNextValue.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.GetContactSyncConfig.get());
    }
}
