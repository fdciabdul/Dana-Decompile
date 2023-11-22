package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.danah5.DanaCustomH5;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.referral.model.MyReferralConsultMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeatureView_Factory implements Factory<FeatureView> {
    private final Provider<FeatureFamilyAccount> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GenerateReferralDeepLink> DatabaseTableConfigUtil;
    private final Provider<FeatureScanQR> GetContactSyncConfig;
    private final Provider<DanaCustomH5> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckShowReferralCodeFeature> MyBillsEntityDataFactory;
    private final Provider<FeaturePushVerify> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<FeatureSettingMore> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<FeatureSplitBill> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<GetReferralConsult> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<FeatureHome> PlaceComponentResult;
    private final Provider<FeatureCardBinding> getAuthRequestContext;
    private final Provider<FeaturePromoQuest> getErrorConfigVersion;
    private final Provider<FeatureSplitBillPay> initRecordTimeStamp;
    private final Provider<MyReferralConsultMapper> isLayoutRequested;
    private final Provider<FeatureOauth> lookAheadTest;
    private final Provider<FeatureMyBills> moveToNextValue;
    private final Provider<GetUserLoanInfo> newProxyInstance;
    private final Provider<FeatureKyb> scheduleImpl;

    private FeatureView_Factory(Provider<GetReferralConsult> provider, Provider<CheckShowReferralCodeFeature> provider2, Provider<MyReferralConsultMapper> provider3, Provider<GenerateReferralDeepLink> provider4, Provider<FeatureSettingMore> provider5, Provider<FeatureSplitBillPay> provider6, Provider<FeatureSplitBill> provider7, Provider<FeaturePromoQuest> provider8, Provider<FeatureScanQR> provider9, Provider<DanaCustomH5> provider10, Provider<FeatureHome> provider11, Provider<FeatureOauth> provider12, Provider<FeatureKyb> provider13, Provider<FeatureFamilyAccount> provider14, Provider<FeatureCardBinding> provider15, Provider<GetUserLoanInfo> provider16, Provider<FeatureMyBills> provider17, Provider<FeaturePushVerify> provider18) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.isLayoutRequested = provider3;
        this.DatabaseTableConfigUtil = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider5;
        this.initRecordTimeStamp = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider7;
        this.getErrorConfigVersion = provider8;
        this.GetContactSyncConfig = provider9;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider10;
        this.PlaceComponentResult = provider11;
        this.lookAheadTest = provider12;
        this.scheduleImpl = provider13;
        this.BuiltInFictitiousFunctionClassFactory = provider14;
        this.getAuthRequestContext = provider15;
        this.newProxyInstance = provider16;
        this.moveToNextValue = provider17;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider18;
    }

    public static FeatureView_Factory getAuthRequestContext(Provider<GetReferralConsult> provider, Provider<CheckShowReferralCodeFeature> provider2, Provider<MyReferralConsultMapper> provider3, Provider<GenerateReferralDeepLink> provider4, Provider<FeatureSettingMore> provider5, Provider<FeatureSplitBillPay> provider6, Provider<FeatureSplitBill> provider7, Provider<FeaturePromoQuest> provider8, Provider<FeatureScanQR> provider9, Provider<DanaCustomH5> provider10, Provider<FeatureHome> provider11, Provider<FeatureOauth> provider12, Provider<FeatureKyb> provider13, Provider<FeatureFamilyAccount> provider14, Provider<FeatureCardBinding> provider15, Provider<GetUserLoanInfo> provider16, Provider<FeatureMyBills> provider17, Provider<FeaturePushVerify> provider18) {
        return new FeatureView_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureView(this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(), this.MyBillsEntityDataFactory.get(), this.isLayoutRequested.get(), this.DatabaseTableConfigUtil.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.initRecordTimeStamp.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.getErrorConfigVersion.get(), this.GetContactSyncConfig.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.lookAheadTest.get(), this.scheduleImpl.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.newProxyInstance.get(), this.moveToNextValue.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
    }
}
