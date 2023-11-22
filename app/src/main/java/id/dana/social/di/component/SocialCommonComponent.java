package id.dana.social.di.component;

import dagger.Subcomponent;
import id.dana.cashier.CashierBannerModule;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierFeedModule;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager;
import id.dana.di.PerModule;
import id.dana.di.component.CashierResultWithFeedComponent;
import id.dana.di.modules.DanaContactModule;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PayResultModule;
import id.dana.expresspurchase.di.ExpressPurchaseModule;
import id.dana.social.FriendshipBottomSheetOnBoardingActivity;
import id.dana.social.di.module.ActivityReactionsModule;
import id.dana.social.di.module.ContentGroupingDetailModule;
import id.dana.social.di.module.FeedCommentModule;
import id.dana.social.di.module.FeedNotificationModule;
import id.dana.social.di.module.FeedsCommentReportModule;
import id.dana.social.di.module.FriendListModule;
import id.dana.social.di.module.FriendRequestListModule;
import id.dana.social.di.module.FriendsFeedsModule;
import id.dana.social.di.module.FriendshipModule;
import id.dana.social.di.module.MyFeedsModule;
import id.dana.social.di.module.ReactionsModule;
import id.dana.social.di.module.RelationshipBottomSheetModule;
import id.dana.social.di.module.SocialCommonModule;
import id.dana.social.di.module.SocialProfileModule;
import kotlin.Metadata;

@Subcomponent(modules = {SocialCommonModule.class})
@PerModule
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u007f\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b#\u0010$JG\u0010'\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020%2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b'\u0010(JG\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020)2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b+\u0010,J\u001f\u0010+\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020-2\u0006\u0010\t\u001a\u00020.H&¢\u0006\u0004\b+\u00100J\u0017\u0010\u0005\u001a\u0002022\u0006\u0010\u0003\u001a\u000201H&¢\u0006\u0004\b\u0005\u00103J\u0017\u0010\u0005\u001a\u0002052\u0006\u0010\u0003\u001a\u000204H&¢\u0006\u0004\b\u0005\u00106JW\u0010+\u001a\u0002092\u0006\u0010\u0003\u001a\u0002072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u0002042\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u000208H&¢\u0006\u0004\b+\u0010:J\u001f\u0010=\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020;2\u0006\u0010\t\u001a\u00020.H&¢\u0006\u0004\b=\u0010>J\u0017\u0010'\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020.H&¢\u0006\u0004\b'\u0010@J\u000f\u0010+\u001a\u00020AH&¢\u0006\u0004\b+\u0010BJ\u0017\u0010'\u001a\u00020D2\u0006\u0010\u0003\u001a\u00020CH&¢\u0006\u0004\b'\u0010EJ\u0017\u0010#\u001a\u00020G2\u0006\u0010\u0003\u001a\u00020FH&¢\u0006\u0004\b#\u0010HJ\u0017\u0010=\u001a\u00020G2\u0006\u0010\u0003\u001a\u00020IH&¢\u0006\u0004\b=\u0010JJG\u0010#\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020K2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b#\u0010MJ\u0017\u0010#\u001a\u00020O2\u0006\u0010\u0003\u001a\u00020NH&¢\u0006\u0004\b#\u0010PJ/\u0010=\u001a\u00020Q2\u0006\u0010\u0003\u001a\u0002042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020.H&¢\u0006\u0004\b=\u0010RJG\u0010'\u001a\u00020T2\u0006\u0010\u0003\u001a\u00020S2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b'\u0010Uø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/di/component/SocialCommonComponent;", "", "Lid/dana/social/di/module/ActivityReactionsModule;", "p0", "Lid/dana/social/di/component/ActivityReactionsComponent;", "MyBillsEntityDataFactory", "(Lid/dana/social/di/module/ActivityReactionsModule;)Lid/dana/social/di/component/ActivityReactionsComponent;", "Lid/dana/di/modules/PayResultModule;", "Lid/dana/contract/deeplink/DeepLinkModule;", "p1", "Lid/dana/contract/staticqr/ScanQrModule;", "p2", "Lid/dana/contract/shortener/RestoreUrlModule;", "p3", "Lid/dana/contract/deeplink/FeatureModule;", "p4", "Lid/dana/di/modules/OauthModule;", "p5", "Lid/dana/contract/services/ServicesModule;", "p6", "Lid/dana/expresspurchase/di/ExpressPurchaseModule;", "p7", "Lid/dana/di/modules/GlobalNetworkModule;", "p8", "Lid/dana/cashier/CashierCardBindingModule;", "p9", "Lid/dana/cashier/CashierBannerModule;", "p10", "Lid/dana/cashier/CashierFeedModule;", "p11", "Lid/dana/cashier/CashierUserRelatedModule;", "p12", "Lid/dana/cashier/CashierPayLaterModule;", "p13", "Lid/dana/di/component/CashierResultWithFeedComponent;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/di/modules/PayResultModule;Lid/dana/contract/deeplink/DeepLinkModule;Lid/dana/contract/staticqr/ScanQrModule;Lid/dana/contract/shortener/RestoreUrlModule;Lid/dana/contract/deeplink/FeatureModule;Lid/dana/di/modules/OauthModule;Lid/dana/contract/services/ServicesModule;Lid/dana/expresspurchase/di/ExpressPurchaseModule;Lid/dana/di/modules/GlobalNetworkModule;Lid/dana/cashier/CashierCardBindingModule;Lid/dana/cashier/CashierBannerModule;Lid/dana/cashier/CashierFeedModule;Lid/dana/cashier/CashierUserRelatedModule;Lid/dana/cashier/CashierPayLaterModule;)Lid/dana/di/component/CashierResultWithFeedComponent;", "Lid/dana/social/di/module/ContentGroupingDetailModule;", "Lid/dana/social/di/component/ContentGroupingDetailComponent;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/social/di/module/ContentGroupingDetailModule;Lid/dana/contract/deeplink/DeepLinkModule;Lid/dana/contract/staticqr/ScanQrModule;Lid/dana/contract/shortener/RestoreUrlModule;Lid/dana/contract/deeplink/FeatureModule;Lid/dana/di/modules/OauthModule;Lid/dana/contract/services/ServicesModule;)Lid/dana/social/di/component/ContentGroupingDetailComponent;", "Lid/dana/social/di/module/FeedCommentModule;", "Lid/dana/social/di/component/FeedCommentComponent;", "PlaceComponentResult", "(Lid/dana/social/di/module/FeedCommentModule;Lid/dana/contract/deeplink/DeepLinkModule;Lid/dana/contract/staticqr/ScanQrModule;Lid/dana/contract/shortener/RestoreUrlModule;Lid/dana/contract/deeplink/FeatureModule;Lid/dana/di/modules/OauthModule;Lid/dana/contract/services/ServicesModule;)Lid/dana/social/di/component/FeedCommentComponent;", "Lid/dana/social/di/module/FeedNotificationModule;", "Lid/dana/social/di/module/FriendRequestListModule;", "Lid/dana/social/di/component/FeedNotificationComponent;", "(Lid/dana/social/di/module/FeedNotificationModule;Lid/dana/social/di/module/FriendRequestListModule;)Lid/dana/social/di/component/FeedNotificationComponent;", "Lid/dana/social/di/module/FeedsCommentReportModule;", "Lid/dana/social/di/component/FeedsCommentReportComponent;", "(Lid/dana/social/di/module/FeedsCommentReportModule;)Lid/dana/social/di/component/FeedsCommentReportComponent;", "Lid/dana/social/di/module/RelationshipBottomSheetModule;", "Lid/dana/social/di/component/FeedsFragmentComponent;", "(Lid/dana/social/di/module/RelationshipBottomSheetModule;)Lid/dana/social/di/component/FeedsFragmentComponent;", "Lid/dana/social/di/module/FriendsFeedsModule;", "Lid/dana/di/modules/DanaContactModule;", "Lid/dana/social/di/component/FriendFeedsComponent;", "(Lid/dana/social/di/module/FriendsFeedsModule;Lid/dana/contract/deeplink/DeepLinkModule;Lid/dana/social/di/module/RelationshipBottomSheetModule;Lid/dana/contract/staticqr/ScanQrModule;Lid/dana/contract/shortener/RestoreUrlModule;Lid/dana/contract/deeplink/FeatureModule;Lid/dana/di/modules/OauthModule;Lid/dana/contract/services/ServicesModule;Lid/dana/di/modules/DanaContactModule;)Lid/dana/social/di/component/FriendFeedsComponent;", "Lid/dana/social/di/module/FriendListModule;", "Lid/dana/social/di/component/FriendListComponent;", "getAuthRequestContext", "(Lid/dana/social/di/module/FriendListModule;Lid/dana/social/di/module/FriendRequestListModule;)Lid/dana/social/di/component/FriendListComponent;", "Lid/dana/social/di/component/FriendRequestComponent;", "(Lid/dana/social/di/module/FriendRequestListModule;)Lid/dana/social/di/component/FriendRequestComponent;", "Lid/dana/social/di/component/FriendshipBottomSheetHelpComponent;", "()Lid/dana/social/di/component/FriendshipBottomSheetHelpComponent;", "Lid/dana/social/di/module/FriendshipModule;", "Lid/dana/social/di/component/FriendshipListBaseFragmentComponent;", "(Lid/dana/social/di/module/FriendshipModule;)Lid/dana/social/di/component/FriendshipListBaseFragmentComponent;", "Lid/dana/danah5/bottomsheet/ShareFeedBottomSheetManager;", "", "(Lid/dana/danah5/bottomsheet/ShareFeedBottomSheetManager;)V", "Lid/dana/social/FriendshipBottomSheetOnBoardingActivity;", "(Lid/dana/social/FriendshipBottomSheetOnBoardingActivity;)V", "Lid/dana/social/di/module/MyFeedsModule;", "Lid/dana/social/di/component/MyFeedsComponent;", "(Lid/dana/social/di/module/MyFeedsModule;Lid/dana/contract/deeplink/DeepLinkModule;Lid/dana/contract/staticqr/ScanQrModule;Lid/dana/contract/shortener/RestoreUrlModule;Lid/dana/contract/deeplink/FeatureModule;Lid/dana/di/modules/OauthModule;Lid/dana/contract/services/ServicesModule;)Lid/dana/social/di/component/MyFeedsComponent;", "Lid/dana/social/di/module/ReactionsModule;", "Lid/dana/social/di/component/ReactionsComponent;", "(Lid/dana/social/di/module/ReactionsModule;)Lid/dana/social/di/component/ReactionsComponent;", "Lid/dana/social/di/component/RelationshipBottomSheetComponent;", "(Lid/dana/social/di/module/RelationshipBottomSheetModule;Lid/dana/contract/deeplink/DeepLinkModule;Lid/dana/contract/services/ServicesModule;Lid/dana/social/di/module/FriendRequestListModule;)Lid/dana/social/di/component/RelationshipBottomSheetComponent;", "Lid/dana/social/di/module/SocialProfileModule;", "Lid/dana/social/di/component/SocialProfileComponent;", "(Lid/dana/social/di/module/SocialProfileModule;Lid/dana/contract/deeplink/DeepLinkModule;Lid/dana/contract/staticqr/ScanQrModule;Lid/dana/contract/shortener/RestoreUrlModule;Lid/dana/contract/deeplink/FeatureModule;Lid/dana/di/modules/OauthModule;Lid/dana/contract/services/ServicesModule;)Lid/dana/social/di/component/SocialProfileComponent;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SocialCommonComponent {
    ContentGroupingDetailComponent BuiltInFictitiousFunctionClassFactory(ContentGroupingDetailModule p0, DeepLinkModule p1, ScanQrModule p2, RestoreUrlModule p3, FeatureModule p4, OauthModule p5, ServicesModule p6);

    FriendRequestComponent BuiltInFictitiousFunctionClassFactory(FriendRequestListModule p0);

    FriendshipListBaseFragmentComponent BuiltInFictitiousFunctionClassFactory(FriendshipModule p0);

    SocialProfileComponent BuiltInFictitiousFunctionClassFactory(SocialProfileModule p0, DeepLinkModule p1, ScanQrModule p2, RestoreUrlModule p3, FeatureModule p4, OauthModule p5, ServicesModule p6);

    CashierResultWithFeedComponent KClassImpl$Data$declaredNonStaticMembers$2(PayResultModule p0, DeepLinkModule p1, ScanQrModule p2, RestoreUrlModule p3, FeatureModule p4, OauthModule p5, ServicesModule p6, ExpressPurchaseModule p7, GlobalNetworkModule p8, CashierCardBindingModule p9, CashierBannerModule p10, CashierFeedModule p11, CashierUserRelatedModule p12, CashierPayLaterModule p13);

    MyFeedsComponent KClassImpl$Data$declaredNonStaticMembers$2(MyFeedsModule p0, DeepLinkModule p1, ScanQrModule p2, RestoreUrlModule p3, FeatureModule p4, OauthModule p5, ServicesModule p6);

    ReactionsComponent KClassImpl$Data$declaredNonStaticMembers$2(ReactionsModule p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(ShareFeedBottomSheetManager p0);

    ActivityReactionsComponent MyBillsEntityDataFactory(ActivityReactionsModule p0);

    FeedsCommentReportComponent MyBillsEntityDataFactory(FeedsCommentReportModule p0);

    FeedsFragmentComponent MyBillsEntityDataFactory(RelationshipBottomSheetModule p0);

    FeedCommentComponent PlaceComponentResult(FeedCommentModule p0, DeepLinkModule p1, ScanQrModule p2, RestoreUrlModule p3, FeatureModule p4, OauthModule p5, ServicesModule p6);

    FeedNotificationComponent PlaceComponentResult(FeedNotificationModule p0, FriendRequestListModule p1);

    FriendFeedsComponent PlaceComponentResult(FriendsFeedsModule p0, DeepLinkModule p1, RelationshipBottomSheetModule p2, ScanQrModule p3, RestoreUrlModule p4, FeatureModule p5, OauthModule p6, ServicesModule p7, DanaContactModule p8);

    FriendshipBottomSheetHelpComponent PlaceComponentResult();

    FriendListComponent getAuthRequestContext(FriendListModule p0, FriendRequestListModule p1);

    RelationshipBottomSheetComponent getAuthRequestContext(RelationshipBottomSheetModule p0, DeepLinkModule p1, ServicesModule p2, FriendRequestListModule p3);

    void getAuthRequestContext(FriendshipBottomSheetOnBoardingActivity p0);
}
