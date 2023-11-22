package id.dana.di.modules;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.cashier.CashierEventHandler;
import id.dana.cashier.TncCardPaymentEventHandler;
import id.dana.danah5.bottomsheet.service.ServicesBottomSheetManager;
import id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager;
import id.dana.danah5.faceverificationenablement.FaceAuthenticationManager;
import id.dana.danah5.globalnetwork.manager.GlobalNetworkPluginManager;
import id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager;
import id.dana.data.risk.riskevent.SendRiskEventReceiver;
import id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiver;
import id.dana.di.PerActivity;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.globalnetwork.interactor.GetForex;
import id.dana.domain.globalnetwork.interactor.GetRealTimeForex;
import id.dana.domain.globalnetwork.interactor.GetSelectedCountryCode;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.domain.transferaccount.interactor.DeletionChangeNumber;
import id.dana.domain.transferaccount.interactor.SaveTransferAccountToken;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.twilio.interactor.TwilioRequestChallenge;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import id.dana.domain.twilio.interactor.UpdateTwilioChallenge;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.sendmoney_v2.recipient.SendMoneyEventHandler;
import id.dana.splitbill.SplitBillEventHandler;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007JG\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u001eH\u0007¢\u0006\u0004\b\u0006\u0010 J\u000f\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010\u001c\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020'H\u0007¢\u0006\u0004\b\u001c\u0010)J\u001f\u0010%\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020*2\u0006\u0010\n\u001a\u00020+H\u0007¢\u0006\u0004\b%\u0010-J\u001f\u0010%\u001a\u0002002\u0006\u0010\u0004\u001a\u00020.2\u0006\u0010\n\u001a\u00020/H\u0007¢\u0006\u0004\b%\u00101J7\u0010\"\u001a\u0002072\u0006\u0010\u0004\u001a\u0002022\u0006\u0010\n\u001a\u0002032\u0006\u0010\f\u001a\u0002042\u0006\u0010\u000e\u001a\u0002052\u0006\u0010\u0010\u001a\u000206H\u0007¢\u0006\u0004\b\"\u00108"}, d2 = {"Lid/dana/di/modules/GContainerModule;", "", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/GetCashierNativeConfig;", "p0", "Lid/dana/cashier/CashierEventHandler;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ldagger/Lazy;)Lid/dana/cashier/CashierEventHandler;", "Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;", "Lid/dana/domain/account/interactor/GetUserId;", "p1", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "p2", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "p3", "Lid/dana/domain/transferaccount/interactor/SaveTransferAccountToken;", "p4", "Lid/dana/domain/transferaccount/interactor/DeletionChangeNumber;", "p5", "Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;", "p6", "Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;", "PlaceComponentResult", "(Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;Lid/dana/domain/account/interactor/GetUserId;Lid/dana/lib/bio/faceauth/FaceAuthentication;Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;Lid/dana/domain/transferaccount/interactor/SaveTransferAccountToken;Lid/dana/domain/transferaccount/interactor/DeletionChangeNumber;Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;)Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;", "Lid/dana/domain/globalnetwork/interactor/GetSelectedCountryCode;", "Lid/dana/domain/globalnetwork/interactor/GetForex;", "Lid/dana/domain/globalnetwork/interactor/GetRealTimeForex;", "Lid/dana/danah5/globalnetwork/manager/GlobalNetworkPluginManager;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/globalnetwork/interactor/GetSelectedCountryCode;Lid/dana/domain/globalnetwork/interactor/GetForex;Lid/dana/domain/globalnetwork/interactor/GetRealTimeForex;)Lid/dana/danah5/globalnetwork/manager/GlobalNetworkPluginManager;", "Lid/dana/domain/referral/ReferralRepository;", "Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache;", "(Lid/dana/domain/referral/ReferralRepository;)Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache;", "Lid/dana/sendmoney_v2/recipient/SendMoneyEventHandler;", "getAuthRequestContext", "()Lid/dana/sendmoney_v2/recipient/SendMoneyEventHandler;", "Lid/dana/danah5/bottomsheet/service/ServicesBottomSheetManager;", "MyBillsEntityDataFactory", "()Lid/dana/danah5/bottomsheet/service/ServicesBottomSheetManager;", "Lid/dana/data/risk/riskevent/SendRiskEventReceiver;", "Lid/dana/data/risk/riskevent/sharetextbroadcast/ShareTextBroadcastReceiver;", "(Lid/dana/data/risk/riskevent/SendRiskEventReceiver;)Lid/dana/data/risk/riskevent/sharetextbroadcast/ShareTextBroadcastReceiver;", "Lid/dana/domain/featureconfig/interactor/GetRequestMoneyInfoFeature;", "Lid/dana/domain/featureconfig/interactor/GetSplitBillConfig;", "Lid/dana/splitbill/SplitBillEventHandler;", "(Lid/dana/domain/featureconfig/interactor/GetRequestMoneyInfoFeature;Lid/dana/domain/featureconfig/interactor/GetSplitBillConfig;)Lid/dana/splitbill/SplitBillEventHandler;", "Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;", "Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey;", "Lid/dana/cashier/TncCardPaymentEventHandler;", "(Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey;)Lid/dana/cashier/TncCardPaymentEventHandler;", "Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;", "Lid/dana/domain/twilio/interactor/TwilioRequestChallenge;", "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;", "Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge;", "Lid/dana/twilio/tracker/TwilioMixpanelTracker;", "Lid/dana/danah5/twilioverifysecurityproduct/TwilioVerifySecurityProductManager;", "(Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;Lid/dana/domain/twilio/interactor/TwilioRequestChallenge;Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge;Lid/dana/twilio/tracker/TwilioMixpanelTracker;)Lid/dana/danah5/twilioverifysecurityproduct/TwilioVerifySecurityProductManager;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class GContainerModule {
    @Provides
    @PerActivity
    public final GlobalNetworkPluginManager BuiltInFictitiousFunctionClassFactory(GetSelectedCountryCode p0, GetForex p1, GetRealTimeForex p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        return new GlobalNetworkPluginManager(p0, p1, p2);
    }

    @Provides
    @PerActivity
    public final ShareTextBroadcastReceiver BuiltInFictitiousFunctionClassFactory(SendRiskEventReceiver p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerActivity
    public final ServicesBottomSheetManager MyBillsEntityDataFactory() {
        return new ServicesBottomSheetManager();
    }

    @Provides
    @PerActivity
    public final FaceAuthenticationManager PlaceComponentResult(SwitchFaceAuthentication p0, GetUserId p1, FaceAuthentication p2, DanaVizTrackerImpl p3, SaveTransferAccountToken p4, DeletionChangeNumber p5, FinishForceDanaVizEnroll p6) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p5, "");
        Intrinsics.checkNotNullParameter(p6, "");
        return new DefaultFaceAuthenticationManager(p0, p1, p2, p3, p4, p5, p6);
    }

    @Provides
    @PerActivity
    public final TwilioVerifySecurityProductManager getAuthRequestContext(CheckTwilioEnrollmentStatus p0, TwilioRequestChallenge p1, TwilioVerifySecurityProduct p2, UpdateTwilioChallenge p3, TwilioMixpanelTracker p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        return new TwilioVerifySecurityProductManager(p0, p1, p2, p3, p4);
    }

    @Provides
    @PerActivity
    public final SaveReferralEngagementDialogCache KClassImpl$Data$declaredNonStaticMembers$2(ReferralRepository p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new SaveReferralEngagementDialogCache(p0);
    }

    @Provides
    @PerActivity
    public final CashierEventHandler KClassImpl$Data$declaredNonStaticMembers$2(Lazy<GetCashierNativeConfig> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new CashierEventHandler(p0);
    }

    @Provides
    @PerActivity
    public final SendMoneyEventHandler getAuthRequestContext() {
        return new SendMoneyEventHandler();
    }

    @Provides
    @PerActivity
    public final SplitBillEventHandler MyBillsEntityDataFactory(GetRequestMoneyInfoFeature p0, GetSplitBillConfig p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return new SplitBillEventHandler(p0, p1);
    }

    @Provides
    @PerActivity
    public final TncCardPaymentEventHandler MyBillsEntityDataFactory(ConsultAgreementOnlyParamSpaceCodes p0, RecordAgreementOnlyAgreementKey p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return new TncCardPaymentEventHandler(p0, p1);
    }
}
