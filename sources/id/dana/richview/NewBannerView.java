package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import butterknife.Unbinder;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.firebase.messaging.Constants;
import com.rd.PageIndicatorView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.banner.NewPromotionBannerAdapter;
import id.dana.animation.banner.PromotionBannerAdapter;
import id.dana.announcement.AnnouncementContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.base.SimplePageAdapterSingleItemClickListener;
import id.dana.base.extension.UnbinderKtx;
import id.dana.base.extension.UnbinderKtx$$ExternalSyntheticLambda0;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.paylater.PayLaterViewListener;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNewBannerComponent;
import id.dana.di.component.NewBannerComponent;
import id.dana.di.modules.AnnouncementModule;
import id.dana.di.modules.OauthModule;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.UserLoanInfo;
import id.dana.kyb.view.MyBusinessFragment;
import id.dana.model.CdpContentModel;
import id.dana.model.PromotionModel;
import id.dana.model.ThirdPartyService;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.performancetracker.FirstActionTracker;
import id.dana.richview.CircularViewPager;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ¥\u00012\u00020\u00012\u00020\u0002:\u0002¥\u0001B(\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\t\b\u0002\u0010¢\u0001\u001a\u00020\u0006¢\u0006\u0006\b£\u0001\u0010¤\u0001J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0005J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\b\u000e\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001b\u0010\u001fJ\u001f\u0010$\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0003¢\u0006\u0004\b&\u0010\u0005J\r\u0010'\u001a\u00020\u0003¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010)\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010.\u001a\u00020\u00032\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b.\u0010*J\u001b\u00101\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030/¢\u0006\u0004\b1\u00102J\u0015\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u00020\r¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0003H\u0002¢\u0006\u0004\b:\u0010\u0005J\u0017\u0010=\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>J\u0015\u0010@\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0006¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020\u0003¢\u0006\u0004\bB\u0010\u0005J\u000f\u0010C\u001a\u00020\u0003H\u0016¢\u0006\u0004\bC\u0010\u0005J\r\u0010D\u001a\u00020\u0003¢\u0006\u0004\bD\u0010\u0005J\r\u0010E\u001a\u00020\u0003¢\u0006\u0004\bE\u0010\u0005J\r\u0010F\u001a\u00020\u0003¢\u0006\u0004\bF\u0010\u0005J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010GJ!\u0010\u000e\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00172\u0006\u0010\f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u000e\u0010HJ\r\u0010I\u001a\u00020\u0003¢\u0006\u0004\bI\u0010\u0005R\"\u0010K\u001a\u00020J8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010W\u001a\u00020Q8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010YR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170[8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bZ\u0010\\R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u0010]R\"\u0010_\u001a\u00020^8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010f\u001a\u00020e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010lR\u0018\u0010:\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010q\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u001c\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00030/8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010r\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bt\u0010pR\"\u0010v\u001a\u00020u8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0018\u0010m\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bq\u0010}R\u0018\u0010t\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR*\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R*\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u008f\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010lR*\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0017\u0010~\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010lR\u0018\u0010\u008e\u0001\u001a\u00030\u009b\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u009c\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u009b\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009c\u0001R\u0018\u0010\u009f\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010lR\u0018\u0010¡\u0001\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010l"}, d2 = {"Lid/dana/richview/NewBannerView;", "Lid/dana/base/BaseRichView;", "Lid/dana/announcement/AnnouncementContract$View;", "", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "()V", "", "getLayout", "()I", "Landroid/view/View;", "p0", "Landroid/view/MotionEvent;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "hideIndicator", "hideSkeleton", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "Lid/dana/model/CdpContentModel;", "(Ljava/util/List;)Z", "getAuthRequestContext", "()Z", "PlaceComponentResult", "(Lid/dana/model/CdpContentModel;)Z", "onDetachedFromWindow", "", "(Ljava/lang/String;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "pauseAutoScroll", "resumeAutoScroll", "contents", "setContents", "(Ljava/util/List;)V", "entryPoint", "setEntryPoint", "initialContents", "setFormattedPromoContent", "Lkotlin/Function0;", "onGnNotificationClose", "setGnNotificationCloseContainerCallback", "(Lkotlin/jvm/functions/Function0;)V", "Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;", "kybOpenH5Listener", "setKybBannerType", "(Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;)V", "nestedScroll", "setNestedScroll", "(Z)V", "MyBillsEntityDataFactory", "Lid/dana/model/PromotionModel;", "promotionModel", "setPromotionModel", "(Lid/dana/model/PromotionModel;)V", "color", "setSelectedColor", "(I)V", "setTopRoundedCornerBanner", "setup", "showIndicator", "showSkeleton", "skipPauseAutoScrollAfterDisplay", "(Lid/dana/model/CdpContentModel;)V", "(Lid/dana/model/CdpContentModel;Ljava/lang/String;)V", "unbindAdapter", "Lid/dana/announcement/AnnouncementContract$Presenter;", "announcementPresenter", "Lid/dana/announcement/AnnouncementContract$Presenter;", "getAnnouncementPresenter", "()Lid/dana/announcement/AnnouncementContract$Presenter;", "setAnnouncementPresenter", "(Lid/dana/announcement/AnnouncementContract$Presenter;)V", "", "J", "getBannerClickTimer", "()J", "setBannerClickTimer", "(J)V", "bannerClickTimer", "Lid/dana/di/component/NewBannerComponent;", "Lid/dana/di/component/NewBannerComponent;", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/util/List;", "Ljava/lang/String;", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "getFeaturePresenter", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "setFeaturePresenter", "(Lid/dana/contract/deeplink/path/FeatureContract$Presenter;)V", "Lid/dana/data/config/source/HomeWidgetEntityData;", "homeWidgetCache", "Lid/dana/data/config/source/HomeWidgetEntityData;", "getHomeWidgetCache", "()Lid/dana/data/config/source/HomeWidgetEntityData;", "setHomeWidgetCache", "(Lid/dana/data/config/source/HomeWidgetEntityData;)V", "Z", "scheduleImpl", "Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;", "getErrorConfigVersion", "I", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "Lkotlin/jvm/functions/Function0;", "lookAheadTest", "Lid/dana/contract/paylater/PayLaterContract$Presenter;", "payLaterPresenter", "Lid/dana/contract/paylater/PayLaterContract$Presenter;", "getPayLaterPresenter", "()Lid/dana/contract/paylater/PayLaterContract$Presenter;", "setPayLaterPresenter", "(Lid/dana/contract/paylater/PayLaterContract$Presenter;)V", "Lid/dana/home/banner/NewPromotionBannerAdapter;", "Lid/dana/home/banner/NewPromotionBannerAdapter;", "initRecordTimeStamp", "Lid/dana/model/PromotionModel;", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadDeepLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadDeepLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/contract/shortener/RestoreUrlContract$Presenter;", "restorePresenter", "Lid/dana/contract/shortener/RestoreUrlContract$Presenter;", "getRestorePresenter", "()Lid/dana/contract/shortener/RestoreUrlContract$Presenter;", "setRestorePresenter", "(Lid/dana/contract/shortener/RestoreUrlContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "scanQrPresenter", "Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "getScanQrPresenter", "()Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "setScanQrPresenter", "(Lid/dana/contract/staticqr/ScanQrContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "DatabaseTableConfigUtil", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroid/os/Handler;", "Landroid/os/Handler;", "newProxyInstance", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewBannerView extends BaseRichView implements AnnouncementContract.View {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private List<CdpContentModel> PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private SkeletonScreen NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Handler NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private long bannerClickTimer;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private NewPromotionBannerAdapter scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean PrepareContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public AnnouncementContract.Presenter announcementPresenter;
    @Inject
    public FeatureContract.Presenter featurePresenter;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private NewBannerComponent BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public HomeWidgetEntityData homeWidgetCache;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private PromotionModel lookAheadTest;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private Function0<Unit> getErrorConfigVersion;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Handler DatabaseTableConfigUtil;
    @Inject
    public PayLaterContract.Presenter payLaterPresenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;
    @Inject
    public RestoreUrlContract.Presenter restorePresenter;
    @Inject
    public ScanQrContract.Presenter scanQrPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private MyBusinessFragment.KybOpenH5Listener MyBillsEntityDataFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewBannerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.new_view_banner;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.DatabaseTableConfigUtil = new Handler();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Handler(Looper.getMainLooper());
        this.PlaceComponentResult = new ArrayList();
        this.getErrorConfigVersion = new Function0<Unit>() { // from class: id.dana.richview.NewBannerView$onGnNotificationClose$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
    }

    public /* synthetic */ NewBannerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getBannerClickTimer")
    public final long getBannerClickTimer() {
        return this.bannerClickTimer;
    }

    @JvmName(name = "setBannerClickTimer")
    public final void setBannerClickTimer(long j) {
        this.bannerClickTimer = j;
    }

    @JvmName(name = "getFeaturePresenter")
    public final FeatureContract.Presenter getFeaturePresenter() {
        FeatureContract.Presenter presenter = this.featurePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFeaturePresenter")
    public final void setFeaturePresenter(FeatureContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.featurePresenter = presenter;
    }

    @JvmName(name = "getReadDeepLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadDeepLinkPropertiesPresenter() {
        ReadLinkPropertiesContract.Presenter presenter = this.readDeepLinkPropertiesPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setReadDeepLinkPropertiesPresenter")
    public final void setReadDeepLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.readDeepLinkPropertiesPresenter = presenter;
    }

    @JvmName(name = "getRestorePresenter")
    public final RestoreUrlContract.Presenter getRestorePresenter() {
        RestoreUrlContract.Presenter presenter = this.restorePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRestorePresenter")
    public final void setRestorePresenter(RestoreUrlContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.restorePresenter = presenter;
    }

    @JvmName(name = "getScanQrPresenter")
    public final ScanQrContract.Presenter getScanQrPresenter() {
        ScanQrContract.Presenter presenter = this.scanQrPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setScanQrPresenter")
    public final void setScanQrPresenter(ScanQrContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.scanQrPresenter = presenter;
    }

    @JvmName(name = "getAnnouncementPresenter")
    public final AnnouncementContract.Presenter getAnnouncementPresenter() {
        AnnouncementContract.Presenter presenter = this.announcementPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setAnnouncementPresenter")
    public final void setAnnouncementPresenter(AnnouncementContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.announcementPresenter = presenter;
    }

    @JvmName(name = "getHomeWidgetCache")
    public final HomeWidgetEntityData getHomeWidgetCache() {
        HomeWidgetEntityData homeWidgetEntityData = this.homeWidgetCache;
        if (homeWidgetEntityData != null) {
            return homeWidgetEntityData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setHomeWidgetCache")
    public final void setHomeWidgetCache(HomeWidgetEntityData homeWidgetEntityData) {
        Intrinsics.checkNotNullParameter(homeWidgetEntityData, "");
        this.homeWidgetCache = homeWidgetEntityData;
    }

    @JvmName(name = "getPayLaterPresenter")
    public final PayLaterContract.Presenter getPayLaterPresenter() {
        PayLaterContract.Presenter presenter = this.payLaterPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPayLaterPresenter")
    public final void setPayLaterPresenter(PayLaterContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.payLaterPresenter = presenter;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        byte b = 0;
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            DaggerNewBannerComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerNewBannerComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.richview.NewBannerView$injectComponent$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionFailed(String str) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                    ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                    ServicesContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onEmptySearchService() {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onFeatureServices(List list) {
                    ServicesContract.View.CC.PlaceComponentResult(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetThirdPartyServices(List list) {
                    ServicesContract.View.CC.getAuthRequestContext(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onShowTooltip(boolean z) {
                    ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }
            }));
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getBaseActivity();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = TrackerKey.SourceType.BANNER;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getBaseActivity();
            KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            MyBillsEntityDataFactory.PlaceComponentResult = TrackerKey.SourceType.BANNER;
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (AnnouncementModule) Preconditions.getAuthRequestContext(new AnnouncementModule(this));
            KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = (PayLaterModule) Preconditions.getAuthRequestContext(new PayLaterModule(new PayLaterViewListener() { // from class: id.dana.richview.NewBannerView$injectComponent$2
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, DeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, ScanQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, RestoreUrlModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, FeatureModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, OauthModule.class);
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue == null) {
                KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = new ServicesModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, AnnouncementModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, PayLaterModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            this.BuiltInFictitiousFunctionClassFactory = new DaggerNewBannerComponent.NewBannerComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
        NewBannerComponent newBannerComponent = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNull(newBannerComponent);
        newBannerComponent.KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getReadDeepLinkPropertiesPresenter(), getScanQrPresenter(), getRestorePresenter(), getFeaturePresenter());
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context r3, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(r3, "");
        Intrinsics.checkNotNullParameter(attrs, "");
        TypedArray obtainStyledAttributes = r3.obtainStyledAttributes(attrs, R.styleable.SubSequence);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        try {
            this.GetContactSyncConfig = obtainStyledAttributes.getBoolean(3, true);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.moveToNextValue = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.getAuthRequestContext = obtainStyledAttributes.getString(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // id.dana.base.BaseRichView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        CircularViewPager circularViewPager;
        if (!this.initRecordTimeStamp && (circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl)) != null) {
            circularViewPager.pauseAutoScroll();
        }
        this.initRecordTimeStamp = false;
        super.onDetachedFromWindow();
    }

    public final void setGnNotificationCloseContainerCallback(Function0<Unit> onGnNotificationClose) {
        Intrinsics.checkNotNullParameter(onGnNotificationClose, "");
        this.getErrorConfigVersion = onGnNotificationClose;
    }

    public final boolean getAuthRequestContext() {
        Rect rect = new Rect();
        CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager != null) {
            circularViewPager.getHitRect(rect);
        }
        CircularViewPager circularViewPager2 = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager2 != null) {
            return circularViewPager2.getGlobalVisibleRect(rect);
        }
        return false;
    }

    public final void pauseAutoScroll() {
        CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager != null) {
            circularViewPager.pauseAutoScroll();
        }
    }

    public final void resumeAutoScroll() {
        CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager != null) {
            circularViewPager.resumeAutoScroll();
        }
    }

    public final void setNestedScroll(boolean nestedScroll) {
        CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager != null) {
            circularViewPager.setNestedScroll(nestedScroll);
        }
    }

    public final void setPromotionModel(PromotionModel promotionModel) {
        this.lookAheadTest = promotionModel;
    }

    public final void setContents(List<? extends CdpContentModel> contents) {
        Intrinsics.checkNotNullParameter(contents, "");
        CdpContentModel cdpContentModel = (CdpContentModel) CollectionsKt.first((List) contents);
        if (KClassImpl$Data$declaredNonStaticMembers$2(contents) && PlaceComponentResult(cdpContentModel)) {
            List<CdpContentModel> list = this.PlaceComponentResult;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if ((!PlaceComponentResult((CdpContentModel) obj)) != false) {
                    arrayList.add(obj);
                }
            }
            List<CdpContentModel> list2 = this.PlaceComponentResult;
            list2.clear();
            list2.addAll(arrayList);
            List<CdpContentModel> list3 = cdpContentModel.PlaceComponentResult;
            if (list3 != null) {
                Intrinsics.checkNotNullExpressionValue(list3, "");
                list2.add(cdpContentModel);
            }
        } else if (!KClassImpl$Data$declaredNonStaticMembers$2(contents) || PlaceComponentResult(cdpContentModel)) {
            this.PlaceComponentResult.addAll(0, contents);
        } else {
            CdpContentModel cdpContentModel2 = null;
            for (CdpContentModel cdpContentModel3 : this.PlaceComponentResult) {
                if (cdpContentModel3.DatabaseTableConfigUtil.equals("SUBSCRIPTION")) {
                    cdpContentModel2 = cdpContentModel3;
                }
            }
            this.PlaceComponentResult.clear();
            this.PlaceComponentResult.addAll(contents);
            if (cdpContentModel2 != null) {
                this.PlaceComponentResult.add(cdpContentModel2);
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
        MyBillsEntityDataFactory();
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(List<? extends CdpContentModel> p0) {
        return (this.PlaceComponentResult.isEmpty() ^ true) && (p0.isEmpty() ^ true);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.PlaceComponentResult.size() > 1) {
            CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
            if (circularViewPager != null) {
                int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                circularViewPager.setPadding(i, 0, i, 0);
                return;
            }
            return;
        }
        CircularViewPager circularViewPager2 = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager2 != null) {
            int i2 = this.moveToNextValue;
            circularViewPager2.setPadding(i2, 0, i2, 0);
        }
    }

    private final void MyBillsEntityDataFactory() {
        if (this.scheduleImpl == null) {
            this.scheduleImpl = new NewPromotionBannerAdapter(getContext(), new View.OnTouchListener() { // from class: id.dana.richview.NewBannerView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean authRequestContext;
                    authRequestContext = NewBannerView.getAuthRequestContext(NewBannerView.this, view, motionEvent);
                    return authRequestContext;
                }
            }, this.GetContactSyncConfig, this.PrepareContext);
        }
        NewPromotionBannerAdapter newPromotionBannerAdapter = this.scheduleImpl;
        if (newPromotionBannerAdapter != null) {
            newPromotionBannerAdapter.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SimplePageAdapterSingleItemClickListener(getBaseActivity()) { // from class: id.dana.richview.NewBannerView$getItemClickListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(r2);
                }

                @Override // id.dana.base.SimplePageAdapterSingleItemClickListener
                public final void getAuthRequestContext(int p0) {
                    NewPromotionBannerAdapter newPromotionBannerAdapter2;
                    boolean z;
                    NewPromotionBannerAdapter newPromotionBannerAdapter3;
                    String str;
                    newPromotionBannerAdapter2 = NewBannerView.this.scheduleImpl;
                    Intrinsics.checkNotNull(newPromotionBannerAdapter2);
                    String str2 = null;
                    CdpContentModel cdpContentModel = newPromotionBannerAdapter2.getAuthRequestContext(p0) ? null : newPromotionBannerAdapter2.MyBillsEntityDataFactory().get(p0);
                    if (cdpContentModel != null) {
                        NewBannerView newBannerView = NewBannerView.this;
                        z = newBannerView.KClassImpl$Data$declaredNonStaticMembers$2;
                        String str3 = "";
                        if (!z) {
                            newBannerView.KClassImpl$Data$declaredNonStaticMembers$2(cdpContentModel, TrackerKey.Event.PROMOTION_BANNER_OPEN);
                        } else {
                            String str4 = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            Intrinsics.checkNotNullExpressionValue(str4, "");
                            NewBannerView.access$trackKybBannerClick(newBannerView, str4);
                        }
                        String str5 = cdpContentModel.DatabaseTableConfigUtil;
                        if (str5 != null) {
                            int hashCode = str5.hashCode();
                            if (hashCode != -1636482787) {
                                if (hashCode != 79491) {
                                    if (hashCode == 2461856 && str5.equals("POST")) {
                                        NewBannerView.access$openAutoRouteSubscriptionPost(newBannerView, cdpContentModel);
                                        return;
                                    }
                                } else if (str5.equals("PRE")) {
                                    NewBannerView.access$openH5ContainerGnSubscriptionsPage(newBannerView, cdpContentModel);
                                    return;
                                }
                            } else if (str5.equals("SUBSCRIPTION")) {
                                return;
                            }
                        }
                        newPromotionBannerAdapter3 = newBannerView.scheduleImpl;
                        if (newPromotionBannerAdapter3 != null) {
                            str = newBannerView.getAuthRequestContext;
                            if (!newPromotionBannerAdapter3.getAuthRequestContext(p0)) {
                                str2 = UrlUtil.BuiltInFictitiousFunctionClassFactory(newPromotionBannerAdapter3.KClassImpl$Data$declaredNonStaticMembers$2(p0).NetworkUserEntityData$$ExternalSyntheticLambda4, str);
                            }
                        }
                        if (str2 != null) {
                            Intrinsics.checkNotNullExpressionValue(str2, "");
                            str3 = str2;
                        }
                        newBannerView.PlaceComponentResult(str3);
                    }
                }
            };
        }
        NewPromotionBannerAdapter newPromotionBannerAdapter2 = this.scheduleImpl;
        if (newPromotionBannerAdapter2 != null) {
            newPromotionBannerAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 = new NewPromotionBannerAdapter.OnSubscriptionItemClickListener() { // from class: id.dana.richview.NewBannerView$$ExternalSyntheticLambda2
                @Override // id.dana.home.banner.NewPromotionBannerAdapter.OnSubscriptionItemClickListener
                public final void getAuthRequestContext(CdpContentModel cdpContentModel) {
                    NewBannerView.$r8$lambda$bg6v0r3YMtlka__c3Cf5RhpkYx8(NewBannerView.this, cdpContentModel);
                }
            };
        }
        NewPromotionBannerAdapter newPromotionBannerAdapter3 = this.scheduleImpl;
        if (newPromotionBannerAdapter3 != null) {
            newPromotionBannerAdapter3.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
        }
        CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager != null) {
            circularViewPager.setCircularViewPagerListener(new CircularViewPager.CircularViewPagerListener() { // from class: id.dana.richview.NewBannerView$addBannerPageChangeListener$1
                @Override // id.dana.richview.CircularViewPager.CircularViewPagerListener
                public final void PlaceComponentResult(boolean p0) {
                    boolean z;
                    if (!p0) {
                        z = NewBannerView.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        if (z) {
                            NewBannerView.access$resumeSliderWithDelay(NewBannerView.this);
                            return;
                        } else {
                            NewBannerView.this.resumeAutoScroll();
                            return;
                        }
                    }
                    NewBannerView.this.showIndicator();
                    CircularViewPager circularViewPager2 = (CircularViewPager) NewBannerView.this._$_findCachedViewById(R.id.scheduleImpl);
                    if (circularViewPager2 != null) {
                        circularViewPager2.pauseAutoScroll();
                    }
                }
            });
        }
        CircularViewPager circularViewPager2 = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager2 != null) {
            circularViewPager2.setOffscreenPageLimit(this.PlaceComponentResult.size() <= 2 ? 1 : 2);
        }
        CircularViewPager circularViewPager3 = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager3 != null) {
            circularViewPager3.setAdapter(this.scheduleImpl);
        }
        CircularViewPager circularViewPager4 = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager4 != null) {
            circularViewPager4.post(new Runnable() { // from class: id.dana.richview.NewBannerView$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    NewBannerView.m2809$r8$lambda$UtnnNVPxuV2FBp4IosMUfFNb5Q(NewBannerView.this);
                }
            });
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.removeCallbacksAndMessages(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.postDelayed(new NewBannerView$$ExternalSyntheticLambda0(this), RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
    }

    public static final boolean getAuthRequestContext(NewBannerView newBannerView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(newBannerView, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(motionEvent, "");
        return newBannerView.KClassImpl$Data$declaredNonStaticMembers$2(view, motionEvent);
    }

    public final void setFormattedPromoContent(List<? extends CdpContentModel> initialContents) {
        Intrinsics.checkNotNullParameter(initialContents, "");
        if (initialContents.isEmpty()) {
            return;
        }
        this.PlaceComponentResult = CollectionsKt.toMutableList((Collection) initialContents);
        KClassImpl$Data$declaredNonStaticMembers$2();
        MyBillsEntityDataFactory();
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(View p0, MotionEvent p1) {
        if (p1.getAction() == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
            this.bannerClickTimer = Calendar.getInstance().getTimeInMillis();
            CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
            if (circularViewPager != null) {
                circularViewPager.pauseAutoScroll();
            }
        } else if (p1.getAction() == 1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.removeCallbacksAndMessages(null);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.postDelayed(new NewBannerView$$ExternalSyntheticLambda0(this), RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
            if (Calendar.getInstance().getTimeInMillis() - this.bannerClickTimer < 500) {
                p0.performClick();
            }
        }
        return true;
    }

    public final void PlaceComponentResult(String p0) {
        String str = p0;
        if (TextUtils.isEmpty(str)) {
            getBaseActivity().enableClick();
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        Unit unit = null;
        if (StringsKt.contains$default((CharSequence) str.subSequence(i, length + 1).toString(), (CharSequence) DanaUrl.DEEPLINK_URL, false, 2, (Object) null)) {
            getReadDeepLinkPropertiesPresenter().MyBillsEntityDataFactory(p0);
            return;
        }
        UserLoanInfo PlaceComponentResult = getPayLaterPresenter().PlaceComponentResult(LoanInfo.LOAN_PERSONAL);
        String BuiltInFictitiousFunctionClassFactory = UrlUtil.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, p0);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        String KClassImpl$Data$declaredNonStaticMembers$2 = UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        MyBusinessFragment.KybOpenH5Listener kybOpenH5Listener = this.MyBillsEntityDataFactory;
        if (kybOpenH5Listener != null) {
            kybOpenH5Listener.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            DanaH5.startContainerFullUrl(KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    public final void setTopRoundedCornerBanner() {
        this.PrepareContext = true;
    }

    public final void skipPauseAutoScrollAfterDisplay() {
        this.initRecordTimeStamp = true;
    }

    public final void setKybBannerType(MyBusinessFragment.KybOpenH5Listener kybOpenH5Listener) {
        Intrinsics.checkNotNullParameter(kybOpenH5Listener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.MyBillsEntityDataFactory = kybOpenH5Listener;
    }

    public final void hideSkeleton() {
        SkeletonScreen skeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public final void display() {
        if (this.PlaceComponentResult.isEmpty()) {
            return;
        }
        hideSkeleton();
        PageIndicatorView pageIndicatorView = (PageIndicatorView) _$_findCachedViewById(R.id.getDiscountType);
        if (pageIndicatorView != null) {
            CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
            pageIndicatorView.setCount(circularViewPager != null ? circularViewPager.getIndicatorCount() : 0);
        }
        if (this.GetContactSyncConfig) {
            hideIndicator();
        }
    }

    public final void showIndicator() {
        PageIndicatorView pageIndicatorView = (PageIndicatorView) _$_findCachedViewById(R.id.getDiscountType);
        if (pageIndicatorView != null) {
            pageIndicatorView.setVisibility(0);
        }
    }

    public final void hideIndicator() {
        PageIndicatorView pageIndicatorView = (PageIndicatorView) _$_findCachedViewById(R.id.getDiscountType);
        if (pageIndicatorView != null) {
            pageIndicatorView.setVisibility(8);
        }
    }

    public final void setSelectedColor(int color) {
        PageIndicatorView pageIndicatorView = (PageIndicatorView) _$_findCachedViewById(R.id.getDiscountType);
        if (pageIndicatorView != null) {
            pageIndicatorView.setSelectedColor(color);
        }
        invalidate();
    }

    public final void showSkeleton() {
        SkeletonScreen skeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (skeletonScreen != null) {
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((ConstraintLayout) _$_findCachedViewById(R.id.WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1$invoke$$inlined$sortedBy$1));
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.new_view_banner_skeleton;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = viewSkeletonScreen;
    }

    private final void getAuthRequestContext(CdpContentModel p0) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.ANNOUNCEMENT_WIDGET_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Merchant ID", p0.NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory(TrackerKey.Property.ANNOUNCEMENT_TITLE, p0.scheduleImpl).MyBillsEntityDataFactory(TrackerKey.Property.ANNOUNCEMENT_SUBTITLE, p0.getErrorConfigVersion).MyBillsEntityDataFactory(TrackerKey.Property.ANNOUNCEMENT_TYPE, p0.DatabaseTableConfigUtil);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(CdpContentModel p0, String p1) {
        if (p0 == null) {
            return;
        }
        Context context = getContext();
        PromotionModel promotionModel = this.lookAheadTest;
        MixPanelTracker.BuiltInFictitiousFunctionClassFactory(context, p0, p1, promotionModel != null ? promotionModel.NetworkUserEntityData$$ExternalSyntheticLambda1 : null);
    }

    public final void setEntryPoint(String entryPoint) {
        this.getAuthRequestContext = entryPoint;
    }

    public final void unbindAdapter() {
        if (((CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl)) == null || !(((CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl)).getAdapter() instanceof PromotionBannerAdapter)) {
            return;
        }
        PagerAdapter adapter = ((CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl)).getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.home.banner.PromotionBannerAdapter");
        }
        PromotionBannerAdapter promotionBannerAdapter = (PromotionBannerAdapter) adapter;
        List<BaseSimpleView> list = promotionBannerAdapter.MyBillsEntityDataFactory;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<BaseSimpleView> it = promotionBannerAdapter.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            Unbinder unbinder = it.next().getAuthRequestContext;
            if (unbinder != null) {
                UnbinderKtx.getAuthRequestContext(unbinder, new UnbinderKtx$$ExternalSyntheticLambda0());
            }
        }
    }

    /* renamed from: $r8$lambda$UtnnNVPxu-V2FBp4IosMUfFNb5Q */
    public static /* synthetic */ void m2809$r8$lambda$UtnnNVPxuV2FBp4IosMUfFNb5Q(NewBannerView newBannerView) {
        Intrinsics.checkNotNullParameter(newBannerView, "");
        CircularViewPager circularViewPager = (CircularViewPager) newBannerView._$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager != null) {
            circularViewPager.setCurrentItem(1, true);
        }
    }

    public static /* synthetic */ void $r8$lambda$bg6v0r3YMtlka__c3Cf5RhpkYx8(NewBannerView newBannerView, CdpContentModel cdpContentModel) {
        Intrinsics.checkNotNullParameter(newBannerView, "");
        Intrinsics.checkNotNullParameter(cdpContentModel, "");
        newBannerView.KClassImpl$Data$declaredNonStaticMembers$2(cdpContentModel, TrackerKey.Event.PROMOTION_BANNER_OPEN);
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.MyBillsEntityDataFactory();
        String str = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
        Intrinsics.checkNotNullExpressionValue(str, "");
        newBannerView.PlaceComponentResult(str);
    }

    public static /* synthetic */ void $r8$lambda$exzAOQwPmW0DAgHOlOsL0OhTCiM(NewBannerView newBannerView, CdpContentModel cdpContentModel) {
        Intrinsics.checkNotNullParameter(newBannerView, "");
        Intrinsics.checkNotNullParameter(cdpContentModel, "");
        newBannerView.KClassImpl$Data$declaredNonStaticMembers$2(cdpContentModel, "Promotion Banner Appear");
    }

    public static /* synthetic */ void $r8$lambda$qBJshA_4PCfhtIpGbOY0FFd20BA(NewBannerView newBannerView) {
        Intrinsics.checkNotNullParameter(newBannerView, "");
        newBannerView.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
        newBannerView.resumeAutoScroll();
    }

    public static final /* synthetic */ void access$openAutoRouteSubscriptionPost(NewBannerView newBannerView, CdpContentModel cdpContentModel) {
        newBannerView.getAuthRequestContext(cdpContentModel);
        newBannerView.getReadDeepLinkPropertiesPresenter().MyBillsEntityDataFactory("https://link.dana.id/setting-more?params=[settings=setting_autoroute,collection_id=setting_collection_payment_settings]");
        AnnouncementContract.Presenter announcementPresenter = newBannerView.getAnnouncementPresenter();
        String str = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(str, "");
        announcementPresenter.PlaceComponentResult(str);
        newBannerView.getErrorConfigVersion.invoke();
    }

    public static final /* synthetic */ void access$openH5ContainerGnSubscriptionsPage(NewBannerView newBannerView, final CdpContentModel cdpContentModel) {
        newBannerView.getAuthRequestContext(cdpContentModel);
        DanaH5.startContainerFullUrl("https://m.dana.id/i/dana-my-bills/subscription/autodeduction?openSection=gn_section", new DanaH5Listener() { // from class: id.dana.richview.NewBannerView$openH5ContainerGnSubscriptionsPage$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                Function0 function0;
                AnnouncementContract.Presenter announcementPresenter = NewBannerView.this.getAnnouncementPresenter();
                String str = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
                Intrinsics.checkNotNullExpressionValue(str, "");
                announcementPresenter.PlaceComponentResult(str);
                function0 = NewBannerView.this.getErrorConfigVersion;
                function0.invoke();
            }
        });
    }

    public static final /* synthetic */ void access$resumeSliderWithDelay(NewBannerView newBannerView) {
        newBannerView.NetworkUserEntityData$$ExternalSyntheticLambda1.removeCallbacksAndMessages(null);
        newBannerView.NetworkUserEntityData$$ExternalSyntheticLambda1.postDelayed(new NewBannerView$$ExternalSyntheticLambda0(newBannerView), RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
    }

    public static final /* synthetic */ void access$trackKybBannerClick(NewBannerView newBannerView, String str) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(newBannerView.getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_BANNER_CLICK;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.Property.CONTENT, str);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    public static final /* synthetic */ void access$trackVisibleSlideItem(NewBannerView newBannerView, final CdpContentModel cdpContentModel) {
        newBannerView.DatabaseTableConfigUtil.removeCallbacksAndMessages(null);
        newBannerView.DatabaseTableConfigUtil.postDelayed(new Runnable() { // from class: id.dana.richview.NewBannerView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                NewBannerView.$r8$lambda$exzAOQwPmW0DAgHOlOsL0OhTCiM(NewBannerView.this, cdpContentModel);
            }
        }, 2000L);
    }

    private static boolean PlaceComponentResult(CdpContentModel p0) {
        return Intrinsics.areEqual(p0.DatabaseTableConfigUtil, "SUBSCRIPTION");
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager != null) {
            circularViewPager.setIndicatorPageChangeListener(new NewBannerView$initViewPager$1(this));
        }
        CircularViewPager circularViewPager2 = (CircularViewPager) _$_findCachedViewById(R.id.scheduleImpl);
        if (circularViewPager2 != null) {
            circularViewPager2.setPageMargin(this.moveToNextValue);
        }
    }
}
