package id.dana.onboarding.referral;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.referral.interactor.CheckDialogDailyLimit;
import id.dana.domain.referral.interactor.GetReferralEngagementDialog;
import id.dana.domain.referral.interactor.SaveReferralDialogDailyLimit;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import id.dana.onboarding.referral.ReferralDialogContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ReferralDialogPresenter_Factory implements Factory<ReferralDialogPresenter> {
    private final Provider<GetReferralEngagementDialog> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckDialogDailyLimit> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ReferralDialogContract.View> MyBillsEntityDataFactory;
    private final Provider<SaveReferralEngagementDialogCache> PlaceComponentResult;
    private final Provider<SaveReferralDialogDailyLimit> getAuthRequestContext;

    private ReferralDialogPresenter_Factory(Provider<ReferralDialogContract.View> provider, Provider<GetReferralEngagementDialog> provider2, Provider<SaveReferralEngagementDialogCache> provider3, Provider<SaveReferralDialogDailyLimit> provider4, Provider<CheckDialogDailyLimit> provider5) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.getAuthRequestContext = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
    }

    public static ReferralDialogPresenter_Factory PlaceComponentResult(Provider<ReferralDialogContract.View> provider, Provider<GetReferralEngagementDialog> provider2, Provider<SaveReferralEngagementDialogCache> provider3, Provider<SaveReferralDialogDailyLimit> provider4, Provider<CheckDialogDailyLimit> provider5) {
        return new ReferralDialogPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReferralDialogPresenter(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
