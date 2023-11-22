package id.dana.contract.sendmoney;

import dagger.internal.Factory;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig;
import id.dana.domain.sendmoney.interactor.CheckBelowKitkatDialogX2BFeature;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RecipientPresenter_Factory implements Factory<RecipientPresenter> {
    private final Provider<CheckBelowKitkatDialogX2BFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SaveRecentBank> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetReferralSendMoneyConfig> MyBillsEntityDataFactory;
    private final Provider<RecipientContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetSmartFrictionConfig> PlaceComponentResult;
    private final Provider<SaveRecentContact> getAuthRequestContext;
    private final Provider<SaveRecentGroup> scheduleImpl;

    private RecipientPresenter_Factory(Provider<RecipientContract.View> provider, Provider<CheckBelowKitkatDialogX2BFeature> provider2, Provider<GetReferralSendMoneyConfig> provider3, Provider<SaveRecentBank> provider4, Provider<SaveRecentContact> provider5, Provider<GetSmartFrictionConfig> provider6, Provider<SaveRecentGroup> provider7) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.getAuthRequestContext = provider5;
        this.PlaceComponentResult = provider6;
        this.scheduleImpl = provider7;
    }

    public static RecipientPresenter_Factory PlaceComponentResult(Provider<RecipientContract.View> provider, Provider<CheckBelowKitkatDialogX2BFeature> provider2, Provider<GetReferralSendMoneyConfig> provider3, Provider<SaveRecentBank> provider4, Provider<SaveRecentContact> provider5, Provider<GetSmartFrictionConfig> provider6, Provider<SaveRecentGroup> provider7) {
        return new RecipientPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RecipientPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.scheduleImpl.get());
    }
}
