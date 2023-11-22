package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import id.dana.R;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabs;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.MultipleClickHandler;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.deeplink.listener.DeeplinkFeatureListener;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.deeplink.path.FeatureSplitBill;
import id.dana.contract.deeplink.path.FeatureSplitBillPay;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.contract.deeplink.util.SourceParamUtil;
import id.dana.danah5.DanaCustomH5;
import id.dana.danah5.DanaH5;
import id.dana.danapoly.ui.deeplink.path.FeatureDanapoly;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.deeplink.interactor.GenerateReferralDeepLink;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount;
import id.dana.domain.familyaccount.model.ConsultFamilyAccountResult;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.featureconfig.model.SplitBillConfig;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.UserLoanInfo;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.promoquest.interactor.GetMissionDetail;
import id.dana.domain.promoquest.model.Mission;
import id.dana.domain.referral.interactor.GetReferralConsult;
import id.dana.domain.splitbill.interactor.GetPayerSplitBillDetail;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.familyaccount.util.FamilyStatusActionUtil;
import id.dana.ipg.IpgGuideActivity;
import id.dana.lazada.LazadaGuideActivity;
import id.dana.mapper.ThirdPartyServicesUrlMapper;
import id.dana.miniprogram.MiniProgramStoreActivity;
import id.dana.model.ThirdPartyService;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity;
import id.dana.notification.NotificationActivity;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import id.dana.onlinemerchant.OnlineMerchantActivity;
import id.dana.pay.PayActivity;
import id.dana.promoquest.mapper.PromoQuestMapper;
import id.dana.pushverify.model.PushVerifyParamsModel;
import id.dana.pushverify.view.verificationdetail.PushVerifyActivity;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.requestmoney.model.RequestMoneyInfoModel;
import id.dana.scanner.ScannerActivity;
import id.dana.service.ServiceMaintenanceUtil;
import id.dana.social.deeplink.FeatureFriendship;
import id.dana.social.deeplink.FeatureFriendshipDetail;
import id.dana.splitbill.model.SplitBillModel;
import id.dana.splitbill.view.SplitBillActivity;
import id.dana.splitbill.view.SplitBillDetailsActivity;
import id.dana.splitbill.view.SplitBillIntroductionActivity;
import id.dana.splitbill.view.SplitBillSummaryActivity;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.ErrorUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@PerActivity
/* loaded from: classes4.dex */
public class FeatureView implements FeatureContract.View {
    public String BuiltInFictitiousFunctionClassFactory;
    private final FeatureKyb DatabaseTableConfigUtil;
    private boolean FragmentBottomSheetPaymentSettingBinding = true;
    private final FeaturePromoQuest GetContactSyncConfig;
    public FeatureCallback KClassImpl$Data$declaredNonStaticMembers$2;
    private final CheckShowReferralCodeFeature MyBillsEntityDataFactory;
    private final FeatureHome NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final FeatureMyBills NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final FeatureOauth NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final GetReferralConsult NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final MyReferralConsultMapper NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final GetUserLoanInfo NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final FeatureSettingMore NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final GenerateReferralDeepLink NetworkUserEntityData$$ExternalSyntheticLambda8;
    public Activity PlaceComponentResult;
    private final FeatureSplitBill PrepareContext;
    public MultipleClickHandler getAuthRequestContext;
    private final DanaCustomH5 getErrorConfigVersion;
    private final FeaturePushVerify initRecordTimeStamp;
    private final FeatureScanQR isLayoutRequested;
    private DeeplinkFeatureListener lookAheadTest;
    private final FeatureFamilyAccount moveToNextValue;
    private final FeatureSplitBillPay newProxyInstance;
    private final FeatureCardBinding scheduleImpl;

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    @Inject
    public FeatureView(GetReferralConsult getReferralConsult, CheckShowReferralCodeFeature checkShowReferralCodeFeature, MyReferralConsultMapper myReferralConsultMapper, GenerateReferralDeepLink generateReferralDeepLink, FeatureSettingMore featureSettingMore, FeatureSplitBillPay featureSplitBillPay, FeatureSplitBill featureSplitBill, FeaturePromoQuest featurePromoQuest, FeatureScanQR featureScanQR, DanaCustomH5 danaCustomH5, FeatureHome featureHome, FeatureOauth featureOauth, FeatureKyb featureKyb, FeatureFamilyAccount featureFamilyAccount, FeatureCardBinding featureCardBinding, GetUserLoanInfo getUserLoanInfo, FeatureMyBills featureMyBills, FeaturePushVerify featurePushVerify) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = getReferralConsult;
        this.MyBillsEntityDataFactory = checkShowReferralCodeFeature;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = myReferralConsultMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = generateReferralDeepLink;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = featureSettingMore;
        this.newProxyInstance = featureSplitBillPay;
        this.PrepareContext = featureSplitBill;
        this.GetContactSyncConfig = featurePromoQuest;
        this.isLayoutRequested = featureScanQR;
        this.getErrorConfigVersion = danaCustomH5;
        this.scheduleImpl = featureCardBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = featureHome;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = featureOauth;
        this.DatabaseTableConfigUtil = featureKyb;
        this.moveToNextValue = featureFamilyAccount;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = getUserLoanInfo;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = featureMyBills;
        this.initRecordTimeStamp = featurePushVerify;
    }

    @Override // id.dana.contract.deeplink.path.FeatureContract.View
    public final void MyBillsEntityDataFactory(String str, final Map<String, String> map, String str2, boolean z, boolean z2, boolean z3) {
        Unit unit;
        final String str3;
        if (map == null) {
            map = new HashMap<>();
        }
        String str4 = map.get("source");
        if (TextUtils.isEmpty(str4)) {
            map.put("source", this.BuiltInFictitiousFunctionClassFactory);
        }
        if (!z2 && !z) {
            this.FragmentBottomSheetPaymentSettingBinding = false;
            MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
            if (multipleClickHandler != null) {
                multipleClickHandler.enableClick();
            }
            if (z3) {
                new FeatureAppNeedUpdate(this.PlaceComponentResult);
            } else {
                new FeatureUnsupportedDeepLink(this.PlaceComponentResult);
            }
        } else {
            MultipleClickHandler multipleClickHandler2 = this.getAuthRequestContext;
            if (multipleClickHandler2 != null) {
                multipleClickHandler2.enableClick();
            }
            str.hashCode();
            char c = 65535;
            final String str5 = "setting_more";
            switch (str.hashCode()) {
                case -2144786760:
                    if (str.equals(BranchLinkConstant.ActionTarget.EXPLORE_ONLINE_MERCHANTS)) {
                        c = 0;
                        break;
                    }
                    break;
                case -2085148305:
                    if (str.equals("statement")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1926151136:
                    if (str.equals(BranchLinkConstant.ActionTarget.OPEN_ACTIVITY_DETAIL)) {
                        c = 2;
                        break;
                    }
                    break;
                case -1707607021:
                    if (str.equals(BranchLinkConstant.ActionTarget.PUSH_VERIFY)) {
                        c = 3;
                        break;
                    }
                    break;
                case -1687404323:
                    if (str.equals(BranchLinkConstant.ActionTarget.MISSION_DETAIL)) {
                        c = 4;
                        break;
                    }
                    break;
                case -1579389856:
                    if (str.equals(BranchLinkConstant.ActionTarget.DEEPLINK_PAYMENT)) {
                        c = 5;
                        break;
                    }
                    break;
                case -1577785862:
                    if (str.equals(BranchLinkConstant.ActionTarget.PURCHASE_HISTORY_APPLE_ZONE)) {
                        c = 6;
                        break;
                    }
                    break;
                case -1497309563:
                    if (str.equals(BranchLinkConstant.ActionTarget.AC_CASHIER_PAYMENT)) {
                        c = 7;
                        break;
                    }
                    break;
                case -1482068345:
                    if (str.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_GROUPSEND)) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1420060106:
                    if (str.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_PHONE)) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1203723915:
                    if (str.equals(BranchLinkConstant.ActionTarget.CARD_BINDING)) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1109706535:
                    if (str.equals("lazada")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1088666555:
                    if (str.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_OUTLET)) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1049482625:
                    if (str.equals(BranchLinkConstant.ActionTarget.NEARBY)) {
                        c = '\r';
                        break;
                    }
                    break;
                case -952521218:
                    if (str.equals(BranchLinkConstant.ActionTarget.QR_BIND)) {
                        c = 14;
                        break;
                    }
                    break;
                case -799713412:
                    if (str.equals(BranchLinkConstant.ActionTarget.PROMO_CODE)) {
                        c = 15;
                        break;
                    }
                    break;
                case -795192327:
                    if (str.equals("wallet")) {
                        c = 16;
                        break;
                    }
                    break;
                case -600745409:
                    if (str.equals(BranchLinkConstant.ActionTarget.SMARTPAY)) {
                        c = 17;
                        break;
                    }
                    break;
                case -547007174:
                    if (str.equals(BranchLinkConstant.ActionTarget.FRIENDSHIP)) {
                        c = 18;
                        break;
                    }
                    break;
                case -538411956:
                    if (str.equals(BranchLinkConstant.ActionTarget.FAMILY_ACCOUNT_SERVICE)) {
                        c = 19;
                        break;
                    }
                    break;
                case -504043991:
                    if (str.equals(BranchLinkConstant.ActionTarget.HOME)) {
                        c = 20;
                        break;
                    }
                    break;
                case -485401581:
                    if (str.equals(BranchLinkConstant.ActionTarget.NEARBY_SHOP_LIST)) {
                        c = 21;
                        break;
                    }
                    break;
                case -482975375:
                    if (str.equals(BranchLinkConstant.ActionTarget.APPLE_ZONE)) {
                        c = 22;
                        break;
                    }
                    break;
                case -366717367:
                    if (str.equals(BranchLinkConstant.ActionTarget.FAMILY_ACCOUNT)) {
                        c = 23;
                        break;
                    }
                    break;
                case -326361783:
                    if (str.equals(BranchLinkConstant.ActionTarget.REFERRAL)) {
                        c = 24;
                        break;
                    }
                    break;
                case -309425751:
                    if (str.equals("profile")) {
                        c = 25;
                        break;
                    }
                    break;
                case -34640871:
                    if (str.equals(BranchLinkConstant.ActionTarget.MERCHANT_DETAIL)) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 3524221:
                    if (str.equals("scan")) {
                        c = 27;
                        break;
                    }
                    break;
                case 39503416:
                    if (str.equals(BranchLinkConstant.ActionTarget.SEND_MONEY)) {
                        c = 28;
                        break;
                    }
                    break;
                case 98526144:
                    if (str.equals("goals")) {
                        c = 29;
                        break;
                    }
                    break;
                case 105516695:
                    if (str.equals("oauth")) {
                        c = 30;
                        break;
                    }
                    break;
                case 106443977:
                    if (str.equals(BranchLinkConstant.ActionTarget.PAY_QR)) {
                        c = 31;
                        break;
                    }
                    break;
                case 242017035:
                    if (str.equals(BranchLinkConstant.ActionTarget.OPEN_GLOBAL_SEARCH)) {
                        c = InputCardNumberView.DIVIDER;
                        break;
                    }
                    break;
                case 265637412:
                    if (str.equals(BranchLinkConstant.ActionTarget.PROMO_CENTER)) {
                        c = '!';
                        break;
                    }
                    break;
                case 337815220:
                    if (str.equals(BranchLinkConstant.ActionTarget.MINI_PROGRAM_STORE)) {
                        c = Typography.quote;
                        break;
                    }
                    break;
                case 404759073:
                    if (str.equals(BranchLinkConstant.ActionTarget.SPLIT_BILL)) {
                        c = '#';
                        break;
                    }
                    break;
                case 407644048:
                    if (str.equals(BranchLinkConstant.ActionTarget.NEARBY_DETAIL)) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case 412732218:
                    if (str.equals(BranchLinkConstant.ActionTarget.KYBPAGE)) {
                        c = '%';
                        break;
                    }
                    break;
                case 516642788:
                    if (str.equals("setting_more")) {
                        c = Typography.amp;
                        break;
                    }
                    break;
                case 539814047:
                    if (str.equals(BranchLinkConstant.ActionTarget.UPDATE_USERNAME)) {
                        c = '\'';
                        break;
                    }
                    break;
                case 565607471:
                    if (str.equals(BranchLinkConstant.ActionTarget.SPLIT_BILL_DETAIL)) {
                        c = '(';
                        break;
                    }
                    break;
                case 680493486:
                    if (str.equals(BranchLinkConstant.ActionTarget.QRIS_CASHIER_PAYMENT)) {
                        c = ')';
                        break;
                    }
                    break;
                case 757209410:
                    if (str.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_CASHOUT_WITHDRAW)) {
                        c = '*';
                        break;
                    }
                    break;
                case 785051764:
                    if (str.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_BANK)) {
                        c = '+';
                        break;
                    }
                    break;
                case 785087888:
                    if (str.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_CHAT)) {
                        c = ',';
                        break;
                    }
                    break;
                case 907407721:
                    if (str.equals(BranchLinkConstant.ActionTarget.PROFILE_QRIS_ALERT)) {
                        c = '-';
                        break;
                    }
                    break;
                case 991797555:
                    if (str.equals(BranchLinkConstant.ActionTarget.PROMO_QUEST)) {
                        c = '.';
                        break;
                    }
                    break;
                case 1042376846:
                    if (str.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_GLOBAL)) {
                        c = '/';
                        break;
                    }
                    break;
                case 1064526442:
                    if (str.equals(BranchLinkConstant.ActionTarget.MINI_APP)) {
                        c = '0';
                        break;
                    }
                    break;
                case 1316056977:
                    if (str.equals(BranchLinkConstant.ActionTarget.REQUEST_MONEY)) {
                        c = '1';
                        break;
                    }
                    break;
                case 1359805206:
                    if (str.equals(BranchLinkConstant.ActionTarget.REVIEW_PAGE)) {
                        c = '2';
                        break;
                    }
                    break;
                case 1379209310:
                    if (str.equals("services")) {
                        c = '3';
                        break;
                    }
                    break;
                case 1380077785:
                    if (str.equals(BranchLinkConstant.ActionTarget.IPGREGISTRATION)) {
                        c = '4';
                        break;
                    }
                    break;
                case 1398960522:
                    if (str.equals(BranchLinkConstant.ActionTarget.KYB_TRANSACTION_LIST)) {
                        c = '5';
                        break;
                    }
                    break;
                case 1511521056:
                    if (str.equals(BranchLinkConstant.ActionTarget.MY_BILLS)) {
                        c = '6';
                        break;
                    }
                    break;
                case 1555157949:
                    if (str.equals(BranchLinkConstant.ActionTarget.MERCHANT_BINDING)) {
                        c = '7';
                        break;
                    }
                    break;
                case 1618120380:
                    if (str.equals(BranchLinkConstant.ActionTarget.DANAPOLY)) {
                        c = '8';
                        break;
                    }
                    break;
                case 1816389436:
                    if (str.equals(BranchLinkConstant.ActionTarget.NEARBY_ALL_SHOP)) {
                        c = '9';
                        break;
                    }
                    break;
                case 2060445984:
                    if (str.equals("reviewmerchant")) {
                        c = ':';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    OnlineMerchantActivity.openOnlineMerchantFromDeeplink(this.PlaceComponentResult);
                    break;
                case 1:
                    new FeatureStatement(this.PlaceComponentResult, map);
                    break;
                case 2:
                    FeatureFriendshipDetail.MyBillsEntityDataFactory(this.PlaceComponentResult, map);
                    break;
                case 3:
                    FeaturePushVerify featurePushVerify = this.initRecordTimeStamp;
                    Activity activity = this.PlaceComponentResult;
                    Intrinsics.checkNotNullParameter(activity, "");
                    Intrinsics.checkNotNullParameter(map, "");
                    String str6 = map.get("token");
                    if (str6 == null) {
                        str6 = "";
                    }
                    String str7 = map.get(BranchLinkConstant.PushVerifyParams.TRANSACTION_ID);
                    if (str7 == null) {
                        str7 = "";
                    }
                    String str8 = map.get("cacheKey");
                    if (str8 == null) {
                        str8 = "";
                    }
                    PushVerifyParamsModel pushVerifyParamsModel = new PushVerifyParamsModel(str6, str7, str8);
                    DeeplinkTracker deeplinkTracker = featurePushVerify.getAuthRequestContext;
                    String str9 = DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().getAuthRequestContext;
                    deeplinkTracker.KClassImpl$Data$declaredNonStaticMembers$2(str9 != null ? str9 : "", "Push Verify", "None");
                    PushVerifyActivity.Companion companion = PushVerifyActivity.INSTANCE;
                    activity.startActivity(PushVerifyActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(activity, pushVerifyParamsModel, map.get(FeatureParams.PUSH_VERIFY_ENTRY_POINT)));
                    break;
                case 4:
                    final FeaturePromoQuest featurePromoQuest = this.GetContactSyncConfig;
                    final Activity activity2 = this.PlaceComponentResult;
                    if (activity2 != null && map != null && !map.isEmpty()) {
                        final String str10 = map.get(BranchLinkConstant.Params.MISSION_ID);
                        if (str10 != null) {
                            featurePromoQuest.BuiltInFictitiousFunctionClassFactory.execute(GetMissionDetail.Params.INSTANCE.create(str10, true), new Function1<Mission, Unit>() { // from class: id.dana.contract.deeplink.path.FeaturePromoQuest$openMissionDetailNorMissionList$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(Mission mission) {
                                    invoke2(mission);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(Mission mission) {
                                    PromoQuestMapper unused;
                                    Intrinsics.checkNotNullParameter(mission, "");
                                    FeaturePromoQuest featurePromoQuest2 = featurePromoQuest;
                                    Activity activity3 = activity2;
                                    unused = featurePromoQuest2.getAuthRequestContext;
                                    Intrinsics.checkNotNullParameter(mission, "");
                                    FeaturePromoQuest.PlaceComponentResult(activity3, PromoQuestMapper.MyBillsEntityDataFactory(mission));
                                }
                            }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.deeplink.path.FeaturePromoQuest$openMissionDetailNorMissionList$1$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                    invoke2(th);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable th) {
                                    Intrinsics.checkNotNullParameter(th, "");
                                    FeaturePromoQuest.PlaceComponentResult(activity2);
                                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.MISSION_DETAIL_DEEPLINK_EXCEPTION, th.getMessage());
                                }
                            });
                            break;
                        } else {
                            FeaturePromoQuest.MyBillsEntityDataFactory(activity2);
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.MISSION_DETAIL_DEEPLINK_EXCEPTION, "mission id not found");
                            break;
                        }
                    }
                    break;
                case 5:
                    Activity activity3 = this.PlaceComponentResult;
                    String str11 = map.get("ott");
                    if (str11 != null) {
                        FirebasePerformanceMonitor.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2("deeplink_payment_with_ott");
                    } else {
                        FirebasePerformanceMonitor.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2("deeplink_payment_without_ott");
                    }
                    DeeplinkSaveDataManager MyBillsEntityDataFactory = DeeplinkSaveDataManager.MyBillsEntityDataFactory();
                    MyBillsEntityDataFactory.getErrorConfigVersion = str11;
                    MyBillsEntityDataFactory.moveToNextValue = Boolean.TRUE;
                    if (activity3 != null) {
                        activity3.startActivity(new Intent(activity3, HomeTabActivity.class));
                        break;
                    }
                    break;
                case 6:
                case 22:
                    FeatureAppleZone.BuiltInFictitiousFunctionClassFactory(map);
                    break;
                case 7:
                    FeatureAcCashierPayment.PlaceComponentResult(this.PlaceComponentResult, map);
                    break;
                case '\b':
                case '\t':
                case '\f':
                case 28:
                case '*':
                case '+':
                case ',':
                case '/':
                    new FeatureSendMoney(this.PlaceComponentResult, map, str);
                    break;
                case '\n':
                    this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, str4);
                    break;
                case 11:
                    Activity activity4 = this.PlaceComponentResult;
                    activity4.startActivity(LazadaGuideActivity.createIntent(activity4));
                    break;
                case '\r':
                    new FeatureNearbyMe(this.PlaceComponentResult, map);
                    break;
                case 14:
                    FeatureOauth featureOauth = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    Activity activity5 = this.PlaceComponentResult;
                    Intrinsics.checkNotNullParameter(map, "");
                    featureOauth.BuiltInFictitiousFunctionClassFactory(activity5, map, true);
                    break;
                case 15:
                    FeaturePromoCode.getAuthRequestContext(this.PlaceComponentResult, str2);
                    break;
                case 16:
                    FeaturePocket.getAuthRequestContext(this.PlaceComponentResult, map);
                    break;
                case 17:
                    FeatureSmartPay.getAuthRequestContext(this.PlaceComponentResult);
                    break;
                case 18:
                    FeatureFriendship.PlaceComponentResult(this.PlaceComponentResult, map);
                    break;
                case 19:
                    final FeatureFamilyAccount featureFamilyAccount = this.moveToNextValue;
                    final Activity activity6 = this.PlaceComponentResult;
                    Intrinsics.checkNotNullParameter(activity6, "");
                    featureFamilyAccount.getAuthRequestContext.execute(new CheckConsultFamilyAccount.Params(false), new Function1<ConsultFamilyAccountResult, Unit>() { // from class: id.dana.contract.deeplink.path.FeatureFamilyAccount$openFamilyAccountPage$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ConsultFamilyAccountResult consultFamilyAccountResult) {
                            invoke2(consultFamilyAccountResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(ConsultFamilyAccountResult consultFamilyAccountResult) {
                            DynamicUrlWrapper dynamicUrlWrapper;
                            Intrinsics.checkNotNullParameter(consultFamilyAccountResult, "");
                            Activity activity7 = activity6;
                            dynamicUrlWrapper = featureFamilyAccount.MyBillsEntityDataFactory;
                            FamilyStatusActionUtil.MyBillsEntityDataFactory(consultFamilyAccountResult, activity7, dynamicUrlWrapper);
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.deeplink.path.FeatureFamilyAccount$openFamilyAccountPage$2
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            Intrinsics.checkNotNullParameter(th, "");
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, "[GetConsultFamilyAccount]FeatureFamilyAccountOnError", th);
                        }
                    });
                    break;
                case 20:
                    FeatureHome.MyBillsEntityDataFactory(this.PlaceComponentResult, HomeTabs.HOME);
                    break;
                case 21:
                    FeatureNearbyShopList.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, map);
                    break;
                case 23:
                    FeatureFamilyAccount.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, map);
                    break;
                case 24:
                    new FeatureReferral(this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                    break;
                case 25:
                    FeatureHome.MyBillsEntityDataFactory(this.PlaceComponentResult, HomeTabs.ME);
                    break;
                case 26:
                case '$':
                    FeatureMerchantDetail.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, map, str.equals(BranchLinkConstant.ActionTarget.MERCHANT_DETAIL));
                    break;
                case 27:
                    FeatureScanQR.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, TrackerKey.SourceType.DEEP_LINK, map.get("source"));
                    break;
                case 29:
                    FeatureSaving.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, map);
                    break;
                case 30:
                    FeatureOauth featureOauth2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    Activity activity7 = this.PlaceComponentResult;
                    Intrinsics.checkNotNullParameter(map, "");
                    featureOauth2.BuiltInFictitiousFunctionClassFactory(activity7, map, false);
                    break;
                case 31:
                    new FeaturePayQR(this.PlaceComponentResult, map);
                    break;
                case ' ':
                    FeatureGlobalSearch.getAuthRequestContext(this.PlaceComponentResult, map);
                    break;
                case '!':
                    FeaturePromoCenter.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, map);
                    break;
                case '\"':
                    this.PlaceComponentResult.startActivity(new Intent(this.PlaceComponentResult, MiniProgramStoreActivity.class));
                    break;
                case '#':
                    final Activity activity8 = this.PlaceComponentResult;
                    if (activity8 != null) {
                        final FeatureSplitBill featureSplitBill = this.PrepareContext;
                        final FeatureSplitBill.Callback callback = new FeatureSplitBill.Callback() { // from class: id.dana.contract.deeplink.path.FeatureView.1
                            {
                                FeatureView.this = this;
                            }

                            @Override // id.dana.contract.deeplink.path.FeatureSplitBill.Callback
                            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                                Intent intent = new Intent(activity8, SplitBillIntroductionActivity.class);
                                intent.putExtra("source", SourceParamUtil.BuiltInFictitiousFunctionClassFactory(map));
                                activity8.startActivity(intent);
                                FeatureView.KClassImpl$Data$declaredNonStaticMembers$2(FeatureView.this);
                            }

                            @Override // id.dana.contract.deeplink.path.FeatureSplitBill.Callback
                            public final void MyBillsEntityDataFactory(RequestMoneyInfoModel requestMoneyInfoModel, long j, int i) {
                                Activity activity9 = activity8;
                                activity9.startActivity(SplitBillActivity.createSplitBillIntent(activity9, requestMoneyInfoModel, j, "", i, SourceParamUtil.BuiltInFictitiousFunctionClassFactory(map)));
                                FeatureView.KClassImpl$Data$declaredNonStaticMembers$2(FeatureView.this);
                            }
                        };
                        Intrinsics.checkNotNullParameter(map, "");
                        Intrinsics.checkNotNullParameter(callback, "");
                        String str12 = map.get("amount");
                        if (str12 != null) {
                            try {
                                final long parseLong = Long.parseLong(str12);
                                featureSplitBill.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<SplitBillConfig>() { // from class: id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillConfig$1
                                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                                    public final /* synthetic */ void onNext(Object obj) {
                                        SplitBillConfig splitBillConfig = (SplitBillConfig) obj;
                                        Intrinsics.checkNotNullParameter(splitBillConfig, "");
                                        r0.PlaceComponentResult.execute(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE 
                                              (wrap: id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature : 0x0000: IGET (r0v1 id.dana.contract.deeplink.path.FeatureSplitBill) A[WRAPPED] (LINE:1074) id.dana.contract.deeplink.path.FeatureSplitBill.getAuthRequestContext id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature)
                                              (wrap: id.dana.domain.DefaultObserver<id.dana.domain.featureconfig.model.RequestMoneyInfo> : 0x0009: CONSTRUCTOR 
                                              (wrap: id.dana.contract.deeplink.path.FeatureSplitBill$Callback : 0x000f: IGET (r4v0 'this' id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillConfig$1 A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillConfig$1.getAuthRequestContext id.dana.contract.deeplink.path.FeatureSplitBill$Callback)
                                              (wrap: id.dana.contract.deeplink.path.FeatureSplitBill : 0x0007: IGET (r4v0 'this' id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillConfig$1 A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] (LINE:1060) id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillConfig$1.KClassImpl$Data$declaredNonStaticMembers$2 id.dana.contract.deeplink.path.FeatureSplitBill)
                                              (wrap: long : 0x0009: IGET (r4v0 'this' id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillConfig$1 A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillConfig$1.BuiltInFictitiousFunctionClassFactory long)
                                              (wrap: int : 0x000b: INVOKE (r5v1 'splitBillConfig' id.dana.domain.featureconfig.model.SplitBillConfig) type: VIRTUAL call: id.dana.domain.featureconfig.model.SplitBillConfig.getMaxRecipient():int A[MD:():int (m), WRAPPED])
                                             A[MD:(id.dana.contract.deeplink.path.FeatureSplitBill$Callback, id.dana.contract.deeplink.path.FeatureSplitBill, long, int):void (m), WRAPPED] (LINE:1060) call: id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillAmountConfig$1.<init>(id.dana.contract.deeplink.path.FeatureSplitBill$Callback, id.dana.contract.deeplink.path.FeatureSplitBill, long, int):void type: CONSTRUCTOR)
                                             type: VIRTUAL call: id.dana.domain.UseCase.execute(io.reactivex.observers.DisposableObserver):void A[MD:(io.reactivex.observers.DisposableObserver<T>):void (m)] (LINE:1074) in method: id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillConfig$1.onNext(java.lang.Object):void, file: classes4.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                            	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillAmountConfig$1, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                                            	... 15 more
                                            */
                                        /*
                                            this = this;
                                            id.dana.domain.featureconfig.model.SplitBillConfig r5 = (id.dana.domain.featureconfig.model.SplitBillConfig) r5
                                            java.lang.String r0 = ""
                                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                                            id.dana.contract.deeplink.path.FeatureSplitBill r0 = id.dana.contract.deeplink.path.FeatureSplitBill.this
                                            long r1 = r2
                                            int r5 = r5.getMaxRecipient()
                                            id.dana.contract.deeplink.path.FeatureSplitBill$Callback r3 = r4
                                            id.dana.contract.deeplink.path.FeatureSplitBill.BuiltInFictitiousFunctionClassFactory(r0, r1, r5, r3)
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.path.FeatureSplitBill$getSplitBillConfig$1.onNext(java.lang.Object):void");
                                    }

                                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                                    public final void onError(Throwable p0) {
                                        Intrinsics.checkNotNullParameter(p0, "");
                                        super.onError(p0);
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("onError: ");
                                        sb.append(p0.getMessage());
                                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SPLIT_BILL_TAG, sb.toString());
                                    }
                                });
                            } catch (NumberFormatException e) {
                                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SPLIT_BILL_TAG, "Deeplink format wrong try to input correct amount", e);
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            callback.KClassImpl$Data$declaredNonStaticMembers$2();
                            return;
                        }
                        return;
                    }
                    DeeplinkFeatureListener deeplinkFeatureListener = this.lookAheadTest;
                    if (deeplinkFeatureListener != null) {
                        deeplinkFeatureListener.PlaceComponentResult();
                        return;
                    }
                    return;
                case '%':
                    FeatureKyb.MyBillsEntityDataFactory(this.PlaceComponentResult, map);
                    break;
                case '&':
                    final FeatureSettingMore featureSettingMore = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    featureSettingMore.getAuthRequestContext = this.PlaceComponentResult;
                    if (!map.isEmpty() && !TextUtils.isEmpty(map.get("setting"))) {
                        List asList = Arrays.asList(map.get("setting").split(","));
                        str3 = ((String) asList.get(0)).equalsIgnoreCase(MyProfileMenuAction.SETTING_SECURITY) ? "setting_new_security_settings" : (String) asList.get(0);
                    } else {
                        if (map.get("settings") != null && map.get("settings").equalsIgnoreCase(MyProfileMenuAction.AUTO_ROUTING_SETTING_PARAM)) {
                            featureSettingMore.BuiltInFictitiousFunctionClassFactory = true;
                        }
                        str3 = "setting_more";
                    }
                    if (!map.isEmpty() && !TextUtils.isEmpty(map.get(FeatureParams.COLLECTION_ID))) {
                        str5 = (String) Arrays.asList(map.get(FeatureParams.COLLECTION_ID).split(",")).get(0);
                    }
                    featureSettingMore.PlaceComponentResult.execute(new DefaultObserver<SettingModel>() { // from class: id.dana.contract.deeplink.path.FeatureSettingMore.1
                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public /* synthetic */ void onNext(Object obj) {
                            SettingModel settingModel = (SettingModel) obj;
                            if (!settingModel.isEnable()) {
                                FeatureSettingMore.BuiltInFictitiousFunctionClassFactory(featureSettingMore);
                            } else if (SmartPayActivity.SMARTPAY_COLLECTION.equalsIgnoreCase(str5)) {
                                FeatureSettingMore.MyBillsEntityDataFactory(featureSettingMore, settingModel);
                            } else if ("setting_more".equalsIgnoreCase(str3)) {
                                FeatureSettingMore.KClassImpl$Data$declaredNonStaticMembers$2(featureSettingMore, settingModel);
                            } else if ("setting_new_security_settings".equalsIgnoreCase(str3)) {
                                featureSettingMore.BuiltInFictitiousFunctionClassFactory(settingModel, TrackerKey.SourceType.DANA_PROTECTION);
                            } else {
                                FeatureSettingMore.PlaceComponentResult(featureSettingMore, settingModel);
                            }
                        }

                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public void onError(Throwable th) {
                            super.onError(th);
                            StringBuilder sb = new StringBuilder();
                            sb.append("onError: ");
                            sb.append(th.getMessage());
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DEEPLINK_SETTING_MORE_TAG, sb.toString());
                            FeatureSettingMore.BuiltInFictitiousFunctionClassFactory(featureSettingMore);
                        }
                    }, GetSettingByKey.Params.forSettingKey(str3));
                    break;
                case '\'':
                    FeatureUpdateUsername.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, map);
                    break;
                case '(':
                    String stringExtra = this.PlaceComponentResult.getIntent().getStringExtra(ScannerActivity.FROM_VIEW_TYPE);
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null && "split_bill".equals(stringExtra)) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(BranchLinkConstant.ActionTarget.SPLIT_BILL_DETAIL);
                        DeeplinkFeatureListener deeplinkFeatureListener2 = this.lookAheadTest;
                        if (deeplinkFeatureListener2 != null) {
                            deeplinkFeatureListener2.PlaceComponentResult();
                            return;
                        }
                        return;
                    } else if (MyBillsEntityDataFactory(map.get("type"))) {
                        String str13 = map.get("id");
                        String BuiltInFictitiousFunctionClassFactory = SourceParamUtil.BuiltInFictitiousFunctionClassFactory(map);
                        Activity activity9 = this.PlaceComponentResult;
                        if (activity9 != null) {
                            activity9.startActivity(SplitBillSummaryActivity.createIntent(activity9, str13, BuiltInFictitiousFunctionClassFactory));
                        }
                        DeeplinkFeatureListener deeplinkFeatureListener3 = this.lookAheadTest;
                        if (deeplinkFeatureListener3 != null) {
                            deeplinkFeatureListener3.PlaceComponentResult();
                            return;
                        }
                        return;
                    } else {
                        final FeatureSplitBillPay featureSplitBillPay = this.newProxyInstance;
                        final DeeplinkFeatureListener deeplinkFeatureListener4 = this.lookAheadTest;
                        final FeatureSplitBillPay.Listener listener = new FeatureSplitBillPay.Listener() { // from class: id.dana.contract.deeplink.path.FeatureView.2
                            {
                                FeatureView.this = this;
                            }

                            @Override // id.dana.contract.deeplink.path.FeatureSplitBillPay.Listener
                            public final void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillModel splitBillModel) {
                                FeatureView.PlaceComponentResult(FeatureView.this, splitBillModel, SourceParamUtil.BuiltInFictitiousFunctionClassFactory(map));
                                FeatureView.KClassImpl$Data$declaredNonStaticMembers$2(FeatureView.this);
                            }

                            @Override // id.dana.contract.deeplink.path.FeatureSplitBillPay.Listener
                            public final void MyBillsEntityDataFactory(Throwable th) {
                                FeatureView.MyBillsEntityDataFactory(FeatureView.this, th);
                                FeatureView.KClassImpl$Data$declaredNonStaticMembers$2(FeatureView.this);
                            }
                        };
                        if (!map.containsKey("id")) {
                            FeatureSplitBillPay.KClassImpl$Data$declaredNonStaticMembers$2(deeplinkFeatureListener4);
                            return;
                        } else {
                            featureSplitBillPay.PlaceComponentResult.execute(new DefaultObserver<SplitBillHistory>() { // from class: id.dana.contract.deeplink.path.FeatureSplitBillPay.1
                                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                                public /* synthetic */ void onNext(Object obj) {
                                    SplitBillHistory splitBillHistory = (SplitBillHistory) obj;
                                    FeatureSplitBillPay.BuiltInFictitiousFunctionClassFactory(deeplinkFeatureListener4);
                                    Listener listener2 = listener;
                                    if (listener2 != null) {
                                        listener2.KClassImpl$Data$declaredNonStaticMembers$2(featureSplitBillPay.BuiltInFictitiousFunctionClassFactory.apply(splitBillHistory));
                                    }
                                }

                                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                                public void onError(Throwable th) {
                                    super.onError(th);
                                    CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.SPLIT_BILL_EXCEPTION, DanaLogConstants.Prefix.GET_SPLIT_BILL_DETAIL, th);
                                    FeatureSplitBillPay.BuiltInFictitiousFunctionClassFactory(deeplinkFeatureListener4);
                                    Listener listener2 = listener;
                                    if (listener2 != null) {
                                        listener2.MyBillsEntityDataFactory(th);
                                    }
                                }
                            }, GetPayerSplitBillDetail.Params.forSplitBillId(map.get("id")));
                            return;
                        }
                    }
                case ')':
                    FeatureQrisPayment.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, map);
                    break;
                case '-':
                    Activity activity10 = this.PlaceComponentResult;
                    if ((activity10 instanceof ScannerActivity) || (activity10 instanceof PayActivity)) {
                        ((BaseActivity) activity10).showWarningDialog(activity10.getString(R.string.qr_profile_scanner_alert_message));
                        FeatureCallback featureCallback = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (featureCallback != null) {
                            featureCallback.BuiltInFictitiousFunctionClassFactory(BranchLinkConstant.ActionTarget.PROFILE_QRIS_ALERT);
                            DeeplinkFeatureListener deeplinkFeatureListener5 = this.lookAheadTest;
                            if (deeplinkFeatureListener5 != null) {
                                deeplinkFeatureListener5.PlaceComponentResult();
                                break;
                            }
                        }
                    } else {
                        CustomToastUtil.KClassImpl$Data$declaredNonStaticMembers$2(activity10, activity10.getString(R.string.qr_profile_scanner_alert_message));
                        break;
                    }
                    break;
                case '.':
                    Activity activity11 = this.PlaceComponentResult;
                    Function0 function0 = new Function0() { // from class: id.dana.contract.deeplink.path.FeatureView$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            new FeatureUnsupportedDeepLink(FeatureView.this.PlaceComponentResult);
                            return Unit.INSTANCE;
                        }
                    };
                    Intrinsics.checkNotNullParameter(activity11, "");
                    Intrinsics.checkNotNullParameter(map, "");
                    Intrinsics.checkNotNullParameter(function0, "");
                    String str14 = map.get("service_status");
                    if (!Intrinsics.areEqual(str14, "enabled")) {
                        if (Intrinsics.areEqual(str14, "maintenance")) {
                            ServiceMaintenanceUtil.getAuthRequestContext(TrackerKey.PromoCenterSourceType.PROMO_QUEST);
                            break;
                        } else {
                            function0.invoke();
                            break;
                        }
                    } else {
                        FeaturePromoQuest.MyBillsEntityDataFactory(activity11);
                        break;
                    }
                case '0':
                    FeatureMiniApp.getAuthRequestContext(this.PlaceComponentResult, map);
                    break;
                case '1':
                    new FeatureRequestMoney(this.PlaceComponentResult, map);
                    break;
                case '2':
                    FeatureReviewPage.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
                    break;
                case '3':
                    new FeatureService(this.PlaceComponentResult, map);
                    break;
                case '4':
                    IpgGuideActivity.Companion companion2 = IpgGuideActivity.INSTANCE;
                    IpgGuideActivity.Companion.PlaceComponentResult(this.PlaceComponentResult, map);
                    break;
                case '5':
                    FeatureKyb.PlaceComponentResult(this.PlaceComponentResult, map);
                    break;
                case '6':
                    FeatureMyBills.PlaceComponentResult(this.PlaceComponentResult, map);
                    break;
                case '7':
                    new FeatureMerchantBinding(this.PlaceComponentResult);
                    break;
                case '8':
                    FeatureDanapoly.MyBillsEntityDataFactory(this.PlaceComponentResult, map, new Function0() { // from class: id.dana.contract.deeplink.path.FeatureView$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            new FeatureUnsupportedDeepLink(FeatureView.this.PlaceComponentResult);
                            return Unit.INSTANCE;
                        }
                    });
                    break;
                case '9':
                    FeatureNearbyAllShops.MyBillsEntityDataFactory(this.PlaceComponentResult, map);
                    break;
                case ':':
                    new FeatureMerchantReview(this.PlaceComponentResult, map);
                    break;
                default:
                    this.FragmentBottomSheetPaymentSettingBinding = false;
                    if (z3) {
                        new FeatureAppNeedUpdate(this.PlaceComponentResult);
                        break;
                    } else {
                        new FeatureUnsupportedDeepLink(this.PlaceComponentResult);
                        break;
                    }
            }
        }
        Activity activity12 = this.PlaceComponentResult;
        if ((activity12 instanceof NotificationActivity) && this.FragmentBottomSheetPaymentSettingBinding) {
            activity12.finish();
        }
        DeeplinkFeatureListener deeplinkFeatureListener6 = this.lookAheadTest;
        if (deeplinkFeatureListener6 != null) {
            deeplinkFeatureListener6.PlaceComponentResult();
        }
    }

    @Override // id.dana.contract.deeplink.path.FeatureContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(ThirdPartyService thirdPartyService, String str, String str2, String str3) {
        dismissProgress();
        DanaH5.closeAllContainers();
        Bundle bundle = new Bundle();
        bundle.putString(DanaH5.SERVICE_KEY, thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8);
        String KClassImpl$Data$declaredNonStaticMembers$2 = ThirdPartyServicesUrlMapper.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, str3, thirdPartyService);
        String str4 = this.BuiltInFictitiousFunctionClassFactory;
        if (TextUtils.isEmpty(str4)) {
            str4 = TrackerKey.SourceType.DEEP_LINK;
        }
        UserLoanInfo execute = this.NetworkUserEntityData$$ExternalSyntheticLambda6.execute(new GetUserLoanInfo.Params(LoanInfo.LOAN_PERSONAL));
        DanaH5.startContainerFullUrlWithSendCredentials(UrlUtil.getAuthRequestContext(UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(execute, UrlUtil.BuiltInFictitiousFunctionClassFactory(execute, KClassImpl$Data$declaredNonStaticMembers$2)), str4), new DanaH5Listener() { // from class: id.dana.contract.deeplink.path.FeatureView.3
            @Override // id.dana.utils.danah5.DanaH5Listener
            public /* synthetic */ void onContainerDestroyed(Bundle bundle2) {
                DanaH5Listener.CC.MyBillsEntityDataFactory();
            }

            {
                FeatureView.this = this;
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerCreated(Bundle bundle2) {
                DanaH5.dispose();
                if (FeatureView.this.PlaceComponentResult instanceof NotificationActivity) {
                    FeatureView.this.PlaceComponentResult.finish();
                }
            }
        }, bundle);
    }

    @Override // id.dana.contract.deeplink.path.FeatureContract.View
    public final void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.dispose();
        FeatureSettingMore featureSettingMore = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        featureSettingMore.PlaceComponentResult.dispose();
        featureSettingMore.BuiltInFictitiousFunctionClassFactory = false;
        this.newProxyInstance.PlaceComponentResult.dispose();
        FeatureSplitBill featureSplitBill = this.PrepareContext;
        featureSplitBill.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        featureSplitBill.PlaceComponentResult.dispose();
        this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory.dispose();
        this.scheduleImpl.MyBillsEntityDataFactory.dispose();
        this.moveToNextValue.getAuthRequestContext.dispose();
    }

    @Override // id.dana.contract.deeplink.path.FeatureContract.View
    public final void PlaceComponentResult(DeeplinkFeatureListener deeplinkFeatureListener) {
        this.lookAheadTest = deeplinkFeatureListener;
    }

    @Override // id.dana.contract.deeplink.path.FeatureContract.View
    public final void MyBillsEntityDataFactory(boolean z) {
        Activity activity = this.PlaceComponentResult;
        if (activity instanceof LocalConfigSplashActivity) {
            if (z && this.FragmentBottomSheetPaymentSettingBinding) {
                activity.finishAffinity();
            } else {
                new Handler().postDelayed(new Runnable() { // from class: id.dana.contract.deeplink.path.FeatureView$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeatureView.this.PlaceComponentResult.finishAffinity();
                    }
                }, RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
            }
        }
    }

    @Override // id.dana.contract.deeplink.path.FeatureContract.View
    public final void PlaceComponentResult(String str) {
        this.getErrorConfigVersion.openUrl(this.PlaceComponentResult, str);
    }

    @Override // id.dana.contract.deeplink.path.FeatureContract.View
    public final void getAuthRequestContext(String str) {
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        DeeplinkFeatureListener deeplinkFeatureListener = this.lookAheadTest;
        if (deeplinkFeatureListener != null) {
            deeplinkFeatureListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private static boolean MyBillsEntityDataFactory(String str) {
        return str != null && str.equals(BranchLinkConstant.ParamValue.PAYEE);
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeatureView featureView) {
        DeeplinkFeatureListener deeplinkFeatureListener = featureView.lookAheadTest;
        if (deeplinkFeatureListener != null) {
            deeplinkFeatureListener.PlaceComponentResult();
        }
    }

    static /* synthetic */ void PlaceComponentResult(FeatureView featureView, SplitBillModel splitBillModel, String str) {
        Intent createIntent = SplitBillDetailsActivity.createIntent(featureView.PlaceComponentResult, splitBillModel, str);
        createIntent.putExtra(SplitBillDetailsActivity.FROM_NOTIF, featureView.PlaceComponentResult instanceof NotificationActivity);
        featureView.PlaceComponentResult.startActivity(createIntent);
        Activity activity = featureView.PlaceComponentResult;
        if (activity instanceof NotificationActivity) {
            activity.finish();
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(FeatureView featureView, Throwable th) {
        Activity activity = featureView.PlaceComponentResult;
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).showWarningDialog(ErrorUtil.PlaceComponentResult(th, activity.getBaseContext()));
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
        if (multipleClickHandler != null) {
            multipleClickHandler.enableClick();
        }
    }
}
