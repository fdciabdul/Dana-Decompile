package id.dana.referral;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import butterknife.OnClick;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.SimplePageAdapterSingleItemClickListener;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.referraltracker.ReferralTrackerContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerReferralTrackerComponent;
import id.dana.di.component.ReferralTrackerComponent;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.ReferralTrackerModule;
import id.dana.domain.deeplink.model.DeepLink;
import id.dana.domain.featureconfig.model.ReferralMessageTemplateConfig;
import id.dana.model.ReferralWidgetModel;
import id.dana.model.ThirdPartyService;
import id.dana.referral.adapter.ReferralBannerAdapter;
import id.dana.referral.model.MyReferralConsult;
import id.dana.referral.model.ReferralBannerContent;
import id.dana.referral.referraltracker.model.ReferralTrackerModel;
import id.dana.richview.CircularViewPager;
import id.dana.richview.SearchView;
import id.dana.richview.contactselector.ContactSelectorView;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocaleUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.android.IntentUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.A;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 w2\u00020\u00012\u00020\u0002:\u0002xwB\u0007¢\u0006\u0004\bv\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0007\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\nJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\nJ\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\nJ\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\nJ\u0017\u0010#\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u0015J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u001aH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u001aH\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020*H\u0002¢\u0006\u0004\b#\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\nJ\u0017\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u001aH\u0016¢\u0006\u0004\b.\u0010%J\u0017\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u0010\nJ\u0017\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010\nJ\u001d\u0010@\u001a\u00020\u00062\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=H\u0016¢\u0006\u0004\b@\u0010\bJ\u0017\u0010A\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\bA\u00102J\u000f\u0010B\u001a\u00020\u0006H\u0016¢\u0006\u0004\bB\u0010\nJ\u0017\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\u0015\u0010H\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u001a¢\u0006\u0004\bH\u0010%J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\t\u0010%J\u000f\u0010I\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010\nJ'\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020J2\u0006\u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u001aH\u0002¢\u0006\u0004\b$\u0010MJ\u001d\u0010O\u001a\u00020\u00062\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\bO\u0010\bJ\u000f\u0010P\u001a\u00020\u0006H\u0002¢\u0006\u0004\bP\u0010\nJ\u000f\u0010Q\u001a\u00020\u0006H\u0002¢\u0006\u0004\bQ\u0010\nJ\u000f\u0010R\u001a\u00020\u0006H\u0002¢\u0006\u0004\bR\u0010\nJ\u000f\u0010S\u001a\u00020\u0006H\u0002¢\u0006\u0004\bS\u0010\nJ\u000f\u0010T\u001a\u00020\u0006H\u0002¢\u0006\u0004\bT\u0010\nJ\u000f\u0010U\u001a\u00020\u0006H\u0016¢\u0006\u0004\bU\u0010\nJ\u000f\u0010V\u001a\u00020\u0006H\u0002¢\u0006\u0004\bV\u0010\nJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020>H\u0002¢\u0006\u0004\b\t\u0010WR\u0014\u0010\t\u001a\u00020X8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0016\u0010#\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010[R\u0014\u0010\u0007\u001a\u00020\u001a8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u001cR\u0014\u0010$\u001a\u00020\u00138\u0002X\u0083D¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010\u0016\u001a\u00020\u00138CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bY\u0010^R\u0016\u0010\\\u001a\u00020/8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001d\u0010aR\"\u0010c\u001a\u00020b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u0018\u0010Y\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010jR\u0014\u0010]\u001a\u00020k8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010lR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010[R\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b_\u0010[R\u0018\u0010\"\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010nR\"\u0010p\u001a\u00020o8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010u"}, d2 = {"Lid/dana/referral/MyReferralDetailActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/contract/referraltracker/ReferralTrackerContract$View;", "", "Lid/dana/model/ReferralWidgetModel;", "p0", "", "MyBillsEntityDataFactory", "(Ljava/util/List;)V", "BuiltInFictitiousFunctionClassFactory", "()V", "Landroid/view/View;", "view", "closeToHome", "(Landroid/view/View;)V", "configToolbar", "dismissProgress", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getLayout", "()I", "", "getErrorConfigVersion", "()Ljava/lang/String;", "scheduleImpl", "(Landroid/view/MotionEvent;)V", IAPSyncCommand.COMMAND_INIT, "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "initRecordTimeStamp", "getAuthRequestContext", "PlaceComponentResult", "(Ljava/lang/String;)V", "isRegistered", "phoneNumber", "onCheckRegisteredUser", "(ZLjava/lang/String;)V", "Lid/dana/sendmoney/model/RecipientModel;", "(Lid/dana/sendmoney/model/RecipientModel;)V", "onDetachedFromWindow", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "Lid/dana/referral/model/MyReferralConsult;", "myReferralConsult", "onFinishCheckLatestReferralCampaign", "(Lid/dana/referral/model/MyReferralConsult;)V", "Lid/dana/domain/deeplink/model/DeepLink;", "deepLinkReferral", "onGetDeeplinkReferralSuccess", "(Lid/dana/domain/deeplink/model/DeepLink;)V", "onGetMessageTemplateError", "Lid/dana/domain/featureconfig/model/ReferralMessageTemplateConfig;", "message", "onGetMessageTemplateSuccess", "(Lid/dana/domain/featureconfig/model/ReferralMessageTemplateConfig;)V", "onGetReferralBannerError", "", "Lid/dana/referral/model/ReferralBannerContent;", "referralBannerContents", "onGetReferralBannerSuccess", "onGetReferralConsultSuccess", "onGetReferralTrackerError", "Lid/dana/referral/referraltracker/model/ReferralTrackerModel;", "referralTrackerModel", "onGetReferralTrackerSuccess", "(Lid/dana/referral/referraltracker/model/ReferralTrackerModel;)V", "url", "openRedirectUrl", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Landroid/content/Intent;", "p1", "p2", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)V", "referralWidgetModels", "setReferralWidgetFeatureValue", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "showProgress", "FragmentBottomSheetPaymentSettingBinding", "(Lid/dana/referral/model/ReferralBannerContent;)V", "Lid/dana/richview/contactselector/ContactSelectorView$Listener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lid/dana/richview/contactselector/ContactSelectorView$Listener;", "Ljava/lang/String;", "moveToNextValue", "lookAheadTest", "Z", "DatabaseTableConfigUtil", "()Z", "Lid/dana/referral/model/MyReferralConsult;", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadDeepLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadDeepLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/referral/adapter/ReferralBannerAdapter;", "Lid/dana/referral/adapter/ReferralBannerAdapter;", "Lid/dana/base/SimplePageAdapterSingleItemClickListener;", "()Lid/dana/base/SimplePageAdapterSingleItemClickListener;", "Lid/dana/di/component/ReferralTrackerComponent;", "Lid/dana/di/component/ReferralTrackerComponent;", "Lid/dana/contract/referraltracker/ReferralTrackerContract$Presenter;", "referralTrackerPresenter", "Lid/dana/contract/referraltracker/ReferralTrackerContract$Presenter;", "getReferralTrackerPresenter", "()Lid/dana/contract/referraltracker/ReferralTrackerContract$Presenter;", "setReferralTrackerPresenter", "(Lid/dana/contract/referraltracker/ReferralTrackerContract$Presenter;)V", "<init>", "Companion", "BundleKey"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MyReferralDetailActivity extends BaseActivity implements ReferralTrackerContract.View {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda8 = 0;
    public static final String OPEN_BOTTOM_SHEET_DIRECTLY = "open_bottom_sheet_directly";
    public static final int PlaceComponentResult;
    public static final byte[] getAuthRequestContext;
    private static int newProxyInstance;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private ReferralTrackerComponent initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private ReferralBannerAdapter NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;
    @Inject
    public ReferralTrackerContract.Presenter referralTrackerPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private MyReferralConsult moveToNextValue;
    public static final byte[] $$a = {4, -41, 37, 5, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 145;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String getAuthRequestContext = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private String scheduleImpl = "";

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final boolean PlaceComponentResult = true;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String GetContactSyncConfig = "";

    public static /* synthetic */ void $r8$lambda$0nidmHfR2f2q8fW5735saZ7sYxw(ContactSelectorView contactSelectorView, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 107;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        try {
            KClassImpl$Data$declaredNonStaticMembers$2(contactSelectorView, str);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 53;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            if ((i3 % 2 == 0 ? '^' : 'Z') != 'Z') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$1-n1dr4GqgW5pijj6fCEf9WRm1Y  reason: not valid java name */
    public static /* synthetic */ void m2794$r8$lambda$1n1dr4GqgW5pijj6fCEf9WRm1Y(MyReferralDetailActivity myReferralDetailActivity, RecipientModel recipientModel) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 109;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            MyBillsEntityDataFactory(myReferralDetailActivity, recipientModel);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 1;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                int i4 = 89 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        NetworkUserEntityData$$ExternalSyntheticLambda8 = 1;
        getAuthRequestContext();
        getAuthRequestContext = new byte[]{0, Byte.MIN_VALUE, -111, -10, 6, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        PlaceComponentResult = 149;
        PlaceComponentResult();
        INSTANCE = new Companion(null);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        if (i % 2 == 0) {
            int i2 = 85 / 0;
        }
    }

    static void PlaceComponentResult() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = 4576763145025573612L;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 101;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 79 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        r4 = r1;
        r5 = 0;
        r6 = r11;
        r11 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        if ((r10 == null) != true) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        r4 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 27;
        id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
    
        if ((r4 % 2) != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        if (r4 == true) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        r4.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        r4 = r1;
        r5 = 0;
        r1 = r0;
        r0 = r11;
        r11 = r10;
        r10 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x005d -> B:12:0x002b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r8, short r9, int r10, java.lang.Object[] r11) {
        /*
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r0 + 121
            int r1 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            r1 = 93
            if (r0 == 0) goto L11
            r0 = 71
            goto L13
        L11:
            r0 = 93
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L2d
            int r8 = r8 + 60
            r0 = 81
            int r0 = r0 % r10
            byte[] r10 = id.dana.referral.MyReferralDetailActivity.getAuthRequestContext
            int r9 = r9 + 13
            byte[] r1 = new byte[r8]
            int r8 = r8 + 23
            if (r10 != 0) goto L27
            goto L41
        L27:
            r4 = r1
            r5 = 0
            r6 = r11
            r11 = r10
        L2b:
            r10 = r6
            goto L65
        L2d:
            int r8 = r8 + 16
            int r0 = 106 - r10
            byte[] r10 = id.dana.referral.MyReferralDetailActivity.getAuthRequestContext
            int r9 = r9 + 5
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            if (r10 != 0) goto L3d
            r4 = 1
            goto L3e
        L3d:
            r4 = 0
        L3e:
            if (r4 == r2) goto L41
            goto L27
        L41:
            int r4 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r4 = r4 + 27
            int r5 = r4 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L4f
            r4 = 1
            goto L50
        L4f:
            r4 = 0
        L50:
            if (r4 == r2) goto L53
            goto L57
        L53:
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L7f
        L57:
            r4 = r1
            r5 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            r10 = r9
        L5d:
            int r1 = -r1
            int r9 = r9 + r1
            int r9 = r9 + (-4)
            r6 = r0
            r0 = r9
            r9 = r10
            goto L2b
        L65:
            int r9 = r9 + r2
            byte r1 = (byte) r0
            r4[r5] = r1
            int r1 = r5 + 1
            if (r5 != r8) goto L75
            java.lang.String r8 = new java.lang.String
            r8.<init>(r4, r3)
            r10[r3] = r8
            return
        L75:
            r5 = r11[r9]
            r6 = r10
            r10 = r9
            r9 = r0
            r0 = r6
            r7 = r5
            r5 = r1
            r1 = r7
            goto L5d
        L7f:
            r8 = move-exception
            goto L82
        L81:
            throw r8
        L82:
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.b(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            byte[] r0 = id.dana.referral.MyReferralDetailActivity.$$a
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r7 = 47 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L33
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r7 = -r7
            int r8 = r8 + 1
            int r6 = r6 + r7
            int r6 = r6 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.g(short, short, int, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        newProxyInstance = 269894780;
    }

    public final void _$_clearFindViewByIdCache() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 69;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if ((i % 2 != 0 ? '8' : Typography.less) != '8') {
            this._$_findViewCache.clear();
            return;
        }
        this._$_findViewCache.clear();
        Object obj = null;
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (r1 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        if (r1 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        r2 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 105;
        id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        if ((r2 % 2) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (r2 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        r0.put(java.lang.Integer.valueOf(r6), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        r6 = 15 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r0.put(java.lang.Integer.valueOf(r6), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r6) {
        /*
            r5 = this;
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5._$_findViewCache     // Catch: java.lang.Exception -> L6c
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L6c
            java.lang.Object r1 = r0.get(r1)     // Catch: java.lang.Exception -> L6c
            android.view.View r1 = (android.view.View) r1     // Catch: java.lang.Exception -> L6c
            if (r1 != 0) goto L61
            int r1 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r1 = r1 + 93
            int r2 = r1 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r2
            int r1 = r1 % 2
            r2 = 24
            if (r1 != 0) goto L1f
            r1 = 24
            goto L21
        L1f:
            r1 = 55
        L21:
            r3 = 0
            if (r1 == r2) goto L2d
            android.view.View r1 = r5.findViewById(r6)     // Catch: java.lang.Exception -> L2b
            if (r1 == 0) goto L5d
            goto L36
        L2b:
            r6 = move-exception
            goto L5c
        L2d:
            android.view.View r1 = r5.findViewById(r6)
            r2 = 42
            int r2 = r2 / r3
            if (r1 == 0) goto L5d
        L36:
            int r2 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r2 = r2 + 105
            int r4 = r2 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r4
            int r2 = r2 % 2
            if (r2 != 0) goto L44
            r2 = 1
            goto L45
        L44:
            r2 = 0
        L45:
            if (r2 == 0) goto L54
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.put(r6, r1)
            r6 = 15
            int r6 = r6 / r3
            goto L61
        L52:
            r6 = move-exception
            throw r6
        L54:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L2b
            r0.put(r6, r1)     // Catch: java.lang.Exception -> L2b
            goto L61
        L5c:
            throw r6
        L5d:
            r1 = 0
            goto L61
        L5f:
            r6 = move-exception
            throw r6
        L61:
            int r6 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r6 = r6 + 7
            int r0 = r6 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r0
            int r6 = r6 % 2
            return r1
        L6c:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity._$_findCachedViewById(int):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0063, code lost:
    
        if ((r2 <= 99999) != true) goto L9;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r25) {
        /*
            Method dump skipped, instructions count: 3076
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 85;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 67;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 65;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        if ((i % 2 == 0 ? (char) 25 : (char) 22) != 25) {
            return super.getApplicationContext();
        }
        Context applicationContext = super.getApplicationContext();
        Object[] objArr = null;
        int length = objArr.length;
        return applicationContext;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        Context baseContext = super.getBaseContext();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
        int i4 = i3 % 2;
        return baseContext;
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
        int i4 = i3 % 2;
        return R.layout.activity_my_referral;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 99;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        Resources resources = super.getResources();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        if ((i3 % 2 != 0 ? '`' : '+') != '`') {
            return resources;
        }
        Object obj = null;
        obj.hashCode();
        return resources;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x007b, code lost:
    
        if ((r0 > 99999 ? kotlin.text.Typography.amp : '!') != '&') goto L52;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r20) {
        /*
            Method dump skipped, instructions count: 1532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.onCreate(android.os.Bundle):void");
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 3;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            Object[] objArr = null;
            if ((i % 2 == 0 ? ',' : '%') != '%') {
                try {
                    Intrinsics.checkNotNullParameter(errorMessage, "");
                    objArr.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                Intrinsics.checkNotNullParameter(errorMessage, "");
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 3;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                int length = objArr.length;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    public final void onFinishCheckLatestReferralCampaign(MyReferralConsult myReferralConsult) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 9;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(myReferralConsult, "");
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 67;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 69;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        Context baseContext = getBaseContext();
        if (!(baseContext != null)) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 69;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
            int i4 = i3 % 2;
            Object[] objArr = new Object[1];
            c(getPackageName().length() - 7, new char[]{52351, 10448, 52254, 60956, 28859, 14266, 53360, 11717, 45056, 45997, 21600, 43401, 13374, 16260, 55364, 9657, 47118, 48007, 23632, 41454, 15433, 10237, 49184, 15758, 41083, 41964, 17462, 47490, 9342, 12240}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(getAuthRequestContext[31], getAuthRequestContext[8], (byte) (-getAuthRequestContext[33]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(getAuthRequestContext[9], (byte) (-getAuthRequestContext[60]), getAuthRequestContext[49], new Object[1]);
                Object[] objArr3 = new Object[1];
                c(((ApplicationInfo) cls2.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{40712, 43962, 40811, 6942, 5965, 46283, 9572, 18995, 58237, 12480, 41330, 52752, 26456, 48366, 11610, 16904, 60251, 14575, 43346, 50712, 28455, 42128}, objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if ((baseContext != null ? (char) 2 : '^') != '^') {
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 33;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i5 % 128;
            if (i5 % 2 != 0) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Color.green(0) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), 18 - KeyEvent.normalizeMetaState(0), (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr4);
                        int i6 = 92 / 0;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            } else {
                try {
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj3 == null) {
                        obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, null);
                    try {
                        Object[] objArr5 = {baseContext};
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj4);
                        }
                        ((Method) obj4).invoke(invoke2, objArr5);
                    } catch (Throwable th4) {
                        Throwable cause4 = th4.getCause();
                        if (cause4 == null) {
                            throw th4;
                        }
                        throw cause4;
                    }
                } catch (Throwable th5) {
                    Throwable cause5 = th5.getCause();
                    if (cause5 == null) {
                        throw th5;
                    }
                    throw cause5;
                }
            }
        }
        super.onPause();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        r5 = new java.lang.Object[1];
        c(android.view.ViewConfiguration.getDoubleTapTimeout() >> 16, new char[]{52351, 10448, 52254, 60956, 28859, 14266, 53360, 11717, 45056, 45997, 21600, 43401, 13374, 16260, 55364, 9657, 47118, 48007, 23632, 41454, 15433, 10237, 49184, 15758, 41083, 41964, 17462, 47490, 9342, 12240}, r5);
        r0 = java.lang.Class.forName((java.lang.String) r5[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        r7 = new java.lang.Object[1];
        b(id.dana.referral.MyReferralDetailActivity.getAuthRequestContext[31], id.dana.referral.MyReferralDetailActivity.getAuthRequestContext[8], (byte) (-id.dana.referral.MyReferralDetailActivity.getAuthRequestContext[33]), r7);
        r4 = java.lang.Class.forName((java.lang.String) r7[0]);
        b(id.dana.referral.MyReferralDetailActivity.getAuthRequestContext[9], (byte) (-id.dana.referral.MyReferralDetailActivity.getAuthRequestContext[60]), id.dana.referral.MyReferralDetailActivity.getAuthRequestContext[49], new java.lang.Object[1]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008b, code lost:
    
        r6 = new java.lang.Object[1];
        c(((android.content.pm.ApplicationInfo) r4.getMethod((java.lang.String) r8[0], null).invoke(r12, null)).targetSdkVersion - 33, new char[]{40712, 43962, 40811, 6942, 5965, 46283, 9572, 18995, 58237, 12480, 41330, 52752, 26456, 48366, 11610, 16904, 60251, 14575, 43346, 50712, 28455, 42128}, r6);
        r0 = (android.content.Context) r0.getMethod((java.lang.String) r6[0], new java.lang.Class[0]).invoke(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00ac, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ad, code lost:
    
        r1 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b1, code lost:
    
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b3, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b4, code lost:
    
        throw r0;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onResume() {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.onResume():void");
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 83;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        if ((i % 2 == 0 ? (char) 16 : (char) 3) != 3) {
            int i2 = 65 / 0;
        }
    }

    public static final /* synthetic */ ReferralBannerAdapter access$getReferralBannerAdapter$p(MyReferralDetailActivity myReferralDetailActivity) {
        ReferralBannerAdapter referralBannerAdapter;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        if (!(i % 2 != 0)) {
            referralBannerAdapter = myReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i2 = 97 / 0;
        } else {
            try {
                referralBannerAdapter = myReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        if ((i3 % 2 != 0 ? '0' : 'C') != '0') {
            return referralBannerAdapter;
        }
        Object obj = null;
        obj.hashCode();
        return referralBannerAdapter;
    }

    public static final /* synthetic */ void access$loadReferralBannerPageOnH5(MyReferralDetailActivity myReferralDetailActivity, String str) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 107;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            myReferralDetailActivity.PlaceComponentResult(str);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setKeyboardShown$p(MyReferralDetailActivity myReferralDetailActivity, boolean z) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 15;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            if (i % 2 == 0) {
                myReferralDetailActivity.getErrorConfigVersion = z;
                return;
            }
            myReferralDetailActivity.getErrorConfigVersion = z;
            int i2 = 25 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$trackReferralBannerEvent(MyReferralDetailActivity myReferralDetailActivity, ReferralBannerContent referralBannerContent) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        Object[] objArr = null;
        if (!(i % 2 != 0)) {
            myReferralDetailActivity.BuiltInFictitiousFunctionClassFactory(referralBannerContent);
            int length = objArr.length;
        } else {
            myReferralDetailActivity.BuiltInFictitiousFunctionClassFactory(referralBannerContent);
        }
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
            if (i2 % 2 != 0) {
                objArr.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getReferralTrackerPresenter")
    public final ReferralTrackerContract.Presenter getReferralTrackerPresenter() {
        try {
            ReferralTrackerContract.Presenter presenter = this.referralTrackerPresenter;
            Object obj = null;
            if ((presenter != null ? '^' : 'G') == 'G') {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 75;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
                int i2 = i % 2;
                return null;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 61;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            if ((i3 % 2 == 0 ? '0' : '7') == '0') {
                obj.hashCode();
            }
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 43;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i4 % 128;
            int i5 = i4 % 2;
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setReferralTrackerPresenter")
    public final void setReferralTrackerPresenter(ReferralTrackerContract.Presenter presenter) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(presenter, "");
        this.referralTrackerPresenter = presenter;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if ((r0 == null) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:
    
        if (r0 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
    
        r1 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 + 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0035, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0036, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getReadDeepLinkPropertiesPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter getReadDeepLinkPropertiesPresenter() {
        /*
            r3 = this;
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r0 + 39
            int r1 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r1
            int r0 = r0 % 2
            r1 = 30
            if (r0 != 0) goto L11
            r0 = 44
            goto L13
        L11:
            r0 = 30
        L13:
            if (r0 == r1) goto L26
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r3.readDeepLinkPropertiesPresenter     // Catch: java.lang.Exception -> L24
            r1 = 53
            r2 = 0
            int r1 = r1 / r2
            if (r0 == 0) goto L1e
            goto L1f
        L1e:
            r2 = 1
        L1f:
            if (r2 == 0) goto L2a
            goto L37
        L22:
            r0 = move-exception
            throw r0
        L24:
            r0 = move-exception
            throw r0
        L26:
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r3.readDeepLinkPropertiesPresenter
            if (r0 == 0) goto L37
        L2a:
            int r1 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L35
            int r1 = r1 + 3
            int r2 = r1 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r2     // Catch: java.lang.Exception -> L35
            int r1 = r1 % 2
            return r0
        L35:
            r0 = move-exception
            throw r0
        L37:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.getReadDeepLinkPropertiesPresenter():id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter");
    }

    @JvmName(name = "setReadDeepLinkPropertiesPresenter")
    public final void setReadDeepLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.readDeepLinkPropertiesPresenter = presenter;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 19;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final String getErrorConfigVersion() {
        String moveToNextValue;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 125;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        if (!(!TextUtils.isEmpty(this.GetContactSyncConfig))) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 5;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            if (i3 % 2 == 0) {
                moveToNextValue = moveToNextValue();
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                moveToNextValue = moveToNextValue();
            }
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 43;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i4 % 128;
            int i5 = i4 % 2;
            return moveToNextValue;
        }
        return this.GetContactSyncConfig;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        if (!(i % 2 == 0)) {
            NetworkUserEntityData$$ExternalSyntheticLambda2();
            setCenterTitle(getString(R.string.share_referral_code));
            setMenuLeftButton(R.drawable.btn_arrow_left);
            NetworkUserEntityData$$ExternalSyntheticLambda1();
            newProxyInstance();
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        setCenterTitle(getString(R.string.share_referral_code));
        setMenuLeftButton(R.drawable.btn_arrow_left);
        NetworkUserEntityData$$ExternalSyntheticLambda1();
        newProxyInstance();
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if ((r0 == null) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r0.getBoolean(id.dana.referral.MyReferralDetailActivity.OPEN_BOTTOM_SHEET_DIRECTLY) == true) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        r2 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory() {
        /*
            r4 = this;
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r0 + 83
            int r1 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L23
            android.content.Intent r0 = r4.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L1f
            r3 = 0
            goto L20
        L1f:
            r3 = 1
        L20:
            if (r3 == 0) goto L2d
            goto L35
        L23:
            android.content.Intent r0 = r4.getIntent()     // Catch: java.lang.Exception -> L65
            android.os.Bundle r0 = r0.getExtras()     // Catch: java.lang.Exception -> L65
            if (r0 == 0) goto L35
        L2d:
            java.lang.String r3 = "open_bottom_sheet_directly"
            boolean r0 = r0.getBoolean(r3)
            if (r0 == r2) goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L64
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r0 + 45
            int r2 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L54
            int r0 = id.dana.R.id.rcsv_referral_code
            android.view.View r0 = r4._$_findCachedViewById(r0)
            id.dana.referral.ReferralCodeSectionView r0 = (id.dana.referral.ReferralCodeSectionView) r0
            r2 = 25
            int r2 = r2 / r1
            if (r0 == 0) goto L64
            goto L5e
        L52:
            r0 = move-exception
            throw r0
        L54:
            int r0 = id.dana.R.id.rcsv_referral_code     // Catch: java.lang.Exception -> L65
            android.view.View r0 = r4._$_findCachedViewById(r0)     // Catch: java.lang.Exception -> L65
            id.dana.referral.ReferralCodeSectionView r0 = (id.dana.referral.ReferralCodeSectionView) r0     // Catch: java.lang.Exception -> L65
            if (r0 == 0) goto L64
        L5e:
            r0.onShareReferralCodeClicked()     // Catch: java.lang.Exception -> L62
            goto L64
        L62:
            r0 = move-exception
            throw r0
        L64:
            return
        L65:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.BuiltInFictitiousFunctionClassFactory():void");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent event) {
        try {
            Intrinsics.checkNotNullParameter(event, "");
            if (!(!KClassImpl$Data$declaredNonStaticMembers$2(event))) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 39;
                try {
                    NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
                    int i2 = i % 2;
                    if (!(event.getAction() != 0)) {
                        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 63;
                        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
                        int i4 = i3 % 2;
                        MyBillsEntityDataFactory(event);
                    }
                    int i5 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 51;
                    NetworkUserEntityData$$ExternalSyntheticLambda8 = i5 % 128;
                    if (i5 % 2 == 0) {
                        int i6 = 91 / 0;
                        return false;
                    }
                    return false;
                } catch (Exception e) {
                    throw e;
                }
            }
            return super.dispatchTouchEvent(event);
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        ((ContactSelectorView) _$_findCachedViewById(R.id.GroupRecipientPermissionHelper)).setIsReferralPage(true);
        ReferralCodeSectionView referralCodeSectionView = (ReferralCodeSectionView) _$_findCachedViewById(R.id.rcsv_referral_code);
        if (referralCodeSectionView != null) {
            referralCodeSectionView.showSkeleton();
        }
        initRecordTimeStamp();
        ReferralTrackerContract.Presenter referralTrackerPresenter = getReferralTrackerPresenter();
        referralTrackerPresenter.MyBillsEntityDataFactory();
        referralTrackerPresenter.PlaceComponentResult();
        referralTrackerPresenter.BuiltInFictitiousFunctionClassFactory();
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 63;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        if ((r0 != null ? 'O' : '@') != 'O') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        r1 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 67;
        id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if ((r1 % 2) != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        if (r1 == true) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        r0.pauseAutoScroll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0053, code lost:
    
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0057, code lost:
    
        r0.pauseAutoScroll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005a, code lost:
    
        super.onDetachedFromWindow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005d, code lost:
    
        return;
     */
    @Override // android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDetachedFromWindow() {
        /*
            r4 = this;
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r0 + 9
            int r1 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            r1 = 51
            if (r0 == 0) goto L11
            r0 = 98
            goto L13
        L11:
            r0 = 51
        L13:
            r2 = 0
            if (r0 == r1) goto L2a
            int r0 = id.dana.R.id.res_0x7f0a0595_otpchallengeuistate_verifyinvalidotp     // Catch: java.lang.Exception -> L28
            android.view.View r0 = r4._$_findCachedViewById(r0)     // Catch: java.lang.Exception -> L26
            id.dana.richview.CircularViewPager r0 = (id.dana.richview.CircularViewPager) r0     // Catch: java.lang.Exception -> L28
            r2.hashCode()     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L5a
            goto L3e
        L24:
            r0 = move-exception
            throw r0
        L26:
            r0 = move-exception
            throw r0
        L28:
            r0 = move-exception
            throw r0
        L2a:
            int r0 = id.dana.R.id.res_0x7f0a0595_otpchallengeuistate_verifyinvalidotp
            android.view.View r0 = r4._$_findCachedViewById(r0)
            id.dana.richview.CircularViewPager r0 = (id.dana.richview.CircularViewPager) r0
            r1 = 79
            if (r0 == 0) goto L39
            r3 = 79
            goto L3b
        L39:
            r3 = 64
        L3b:
            if (r3 == r1) goto L3e
            goto L5a
        L3e:
            int r1 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r1 = r1 + 67
            int r3 = r1 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r3
            int r1 = r1 % 2
            r3 = 1
            if (r1 != 0) goto L4d
            r1 = 0
            goto L4e
        L4d:
            r1 = 1
        L4e:
            if (r1 == r3) goto L57
            r0.pauseAutoScroll()
            int r0 = r2.length     // Catch: java.lang.Throwable -> L55
            goto L5a
        L55:
            r0 = move-exception
            throw r0
        L57:
            r0.pauseAutoScroll()
        L5a:
            super.onDetachedFromWindow()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.onDetachedFromWindow():void");
    }

    private final void initRecordTimeStamp() {
        ReferralBannerAdapter referralBannerAdapter = new ReferralBannerAdapter(this, this.PlaceComponentResult);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = referralBannerAdapter;
        referralBannerAdapter.NetworkUserEntityData$$ExternalSyntheticLambda0 = lookAheadTest();
        CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.res_0x7f0a0595_otpchallengeuistate_verifyinvalidotp);
        circularViewPager.setAdapter(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        circularViewPager.setIntervalAutoScroll(3000);
        circularViewPager.resumeAutoScroll();
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
    }

    @JvmName(name = "lookAheadTest")
    private final SimplePageAdapterSingleItemClickListener lookAheadTest() {
        SimplePageAdapterSingleItemClickListener simplePageAdapterSingleItemClickListener = new SimplePageAdapterSingleItemClickListener() { // from class: id.dana.referral.MyReferralDetailActivity$referralBannerListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(MyReferralDetailActivity.this);
            }

            @Override // id.dana.base.SimplePageAdapterSingleItemClickListener
            public final void getAuthRequestContext(int p0) {
                ReferralBannerAdapter access$getReferralBannerAdapter$p = MyReferralDetailActivity.access$getReferralBannerAdapter$p(MyReferralDetailActivity.this);
                if (access$getReferralBannerAdapter$p != null) {
                    MyReferralDetailActivity myReferralDetailActivity = MyReferralDetailActivity.this;
                    ReferralBannerContent referralBannerContent = access$getReferralBannerAdapter$p.MyBillsEntityDataFactory().get(p0);
                    Intrinsics.checkNotNullExpressionValue(referralBannerContent, "");
                    MyReferralDetailActivity.access$trackReferralBannerEvent(myReferralDetailActivity, referralBannerContent);
                    MyReferralDetailActivity.access$loadReferralBannerPageOnH5(myReferralDetailActivity, access$getReferralBannerAdapter$p.KClassImpl$Data$declaredNonStaticMembers$2(p0).KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        };
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return simplePageAdapterSingleItemClickListener;
        }
        return simplePageAdapterSingleItemClickListener;
    }

    private final void PlaceComponentResult(String p0) {
        if ((StringsKt.contains$default((CharSequence) p0, (CharSequence) DanaUrl.DEEPLINK_URL, false, 2, (Object) null) ? '\'' : 'P') == '\'') {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 17;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            try {
                getReadDeepLinkPropertiesPresenter().MyBillsEntityDataFactory(p0);
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 25;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
                int i4 = i3 % 2;
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        DanaH5.startContainerFullUrl(p0);
    }

    private final void BuiltInFictitiousFunctionClassFactory(ReferralBannerContent p0) {
        EventTrackerModel.Builder MyBillsEntityDataFactory = new EventTrackerModel.Builder(getBaseContext().getApplicationContext()).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_ID, p0.PlaceComponentResult).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_NAME, p0.getAuthRequestContext).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_TYPE, p0.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_EXPIRY_DATE, DateTimeUtil.MyBillsEntityDataFactory(p0.MyBillsEntityDataFactory, "yyyy-MM-dd'T'HH:mm:ss", LocaleUtil.getAuthRequestContext())).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_SPACE_CODE, p0.getErrorConfigVersion);
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = TrackerKey.Event.PROMOTION_BANNER_OPEN;
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 51;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void newProxyInstance() {
        KeyboardHelper.PlaceComponentResult(getWindow().getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.referral.MyReferralDetailActivity$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                MyReferralDetailActivity.access$setKeyboardShown$p(MyReferralDetailActivity.this, true);
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                MyReferralDetailActivity.access$setKeyboardShown$p(MyReferralDetailActivity.this, false);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
    }

    public final void openRedirectUrl(String url) {
        boolean z;
        Intrinsics.checkNotNullParameter(url, "");
        String str = url;
        int length = str.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            if (Intrinsics.compare((int) str.charAt(!z2 ? i : length), 32) <= 0) {
                z = true;
            } else {
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 9;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i2 % 128;
                int i3 = i2 % 2;
                z = false;
            }
            if (z2) {
                if (!(z)) {
                    break;
                }
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 25;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i4 % 128;
                length = (i4 % 2 != 0 ? 'M' : (char) 1) != 'M' ? length - 1 : length + 75;
            } else if (z) {
                i++;
            } else {
                z2 = true;
            }
        }
        if ((StringsKt.contains$default((CharSequence) str.subSequence(i, length + 1).toString(), (CharSequence) DanaUrl.DEEPLINK_URL, false, 2, (Object) null) ? (char) 24 : (char) 30) != 30) {
            getReadDeepLinkPropertiesPresenter().MyBillsEntityDataFactory(url);
            return;
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(url);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext);
    }

    private final void PrepareContext() {
        int i;
        ContactSelectorView contactSelectorView = (ContactSelectorView) _$_findCachedViewById(R.id.GroupRecipientPermissionHelper);
        if (contactSelectorView != null) {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 1;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
            int i3 = i2 % 2;
            ContactSelectorView contactSelectorView2 = contactSelectorView;
            if (DatabaseTableConfigUtil()) {
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 103;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i4 % 128;
                i = i4 % 2 == 0 ? 1 : 0;
            } else {
                i = 8;
            }
            contactSelectorView2.setVisibility(i);
        }
        SearchView searchView = (SearchView) _$_findCachedViewById(R.id.res_0x7f0a1b79_com_alibaba_ariver_engine_api_extopt_6);
        if ((searchView != null ? '\t' : 'E') != 'E') {
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 19;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i5 % 128;
            if (i5 % 2 == 0) {
                searchView.setSearchHint(getString(R.string.referral_search_hint));
            } else {
                searchView.setSearchHint(getString(R.string.referral_search_hint));
                int i6 = 93 / 0;
            }
        }
        NetworkUserEntityData$$ExternalSyntheticLambda8();
        BuiltInFictitiousFunctionClassFactory();
        getReferralTrackerPresenter().scheduleImpl();
        int i7 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i7 % 128;
        int i8 = i7 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if ((r0 == null ? 'L' : '\\') != 'L') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:
    
        r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 + 61;
        id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r0 % 128;
        r0 = r0 % 2;
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        if (r0 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        r3.hashCode();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        /*
            r5 = this;
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7     // Catch: java.lang.Exception -> L82
            int r0 = r0 + 77
            int r1 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r1     // Catch: java.lang.Exception -> L80
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            java.lang.String r4 = ""
            if (r0 == r2) goto L22
            id.dana.referral.model.MyReferralConsult r0 = r5.moveToNextValue
            r2 = 48
            int r2 = r2 / r1
            if (r0 != 0) goto L1e
            goto L30
        L1e:
            r3 = r0
            goto L45
        L20:
            r0 = move-exception
            throw r0
        L22:
            id.dana.referral.model.MyReferralConsult r0 = r5.moveToNextValue
            r1 = 76
            if (r0 != 0) goto L2b
            r2 = 76
            goto L2d
        L2b:
            r2 = 92
        L2d:
            if (r2 == r1) goto L30
            goto L1e
        L30:
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r0 + 61
            int r1 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            if (r0 == 0) goto L45
            r3.hashCode()     // Catch: java.lang.Throwable -> L43
            goto L45
        L43:
            r0 = move-exception
            throw r0
        L45:
            java.lang.String r0 = r3.MyBillsEntityDataFactory
            r1 = 83
            if (r0 != 0) goto L4e
            r2 = 83
            goto L4f
        L4e:
            r2 = 3
        L4f:
            if (r2 == r1) goto L52
            r4 = r0
        L52:
            r5.scheduleImpl = r4
            int r0 = id.dana.R.id.rcsv_referral_code
            android.view.View r0 = r5._$_findCachedViewById(r0)
            id.dana.referral.ReferralCodeSectionView r0 = (id.dana.referral.ReferralCodeSectionView) r0
            if (r0 == 0) goto L79
            java.lang.String r1 = r5.scheduleImpl
            r0.setReferralCode(r1)
            java.lang.String r1 = r5.getAuthRequestContext
            r0.setDeepLinkReferral(r1)
            id.dana.contract.referraltracker.ReferralTrackerContract$Presenter r1 = r5.getReferralTrackerPresenter()
            r1.KClassImpl$Data$declaredNonStaticMembers$2()
            id.dana.referral.MyReferralDetailActivity$setupReferralCodeSectionView$1$1 r1 = new id.dana.referral.MyReferralDetailActivity$setupReferralCodeSectionView$1$1
            r1.<init>()
            id.dana.referral.ReferralCodeSectionView$Listener r1 = (id.dana.referral.ReferralCodeSectionView.Listener) r1
            r0.setListener(r1)
        L79:
            r5.NetworkUserEntityData$$ExternalSyntheticLambda7()
            r5.KClassImpl$Data$declaredNonStaticMembers$2()
            return
        L80:
            r0 = move-exception
            throw r0
        L82:
            r0 = move-exception
            goto L85
        L84:
            throw r0
        L85:
            goto L84
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8():void");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        AppBarLayout.LayoutParams layoutParams;
        CollapsingToolbarLayout collapsingToolbarLayout;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        ViewGroup.LayoutParams layoutParams2 = ((CollapsingToolbarLayout) _$_findCachedViewById(R.id.collapsing_toolbar)).getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        }
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 123;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
            if (i3 % 2 != 0) {
                layoutParams = (AppBarLayout.LayoutParams) layoutParams2;
                layoutParams.setScrollFlags(0);
                collapsingToolbarLayout = (CollapsingToolbarLayout) _$_findCachedViewById(R.id.collapsing_toolbar);
                if ((collapsingToolbarLayout != null ? 'S' : 'H') == 'H') {
                    return;
                }
            } else {
                layoutParams = (AppBarLayout.LayoutParams) layoutParams2;
                layoutParams.setScrollFlags(1);
                collapsingToolbarLayout = (CollapsingToolbarLayout) _$_findCachedViewById(R.id.collapsing_toolbar);
                if ((collapsingToolbarLayout != null ? JSONLexer.EOI : Typography.greater) != 26) {
                    return;
                }
            }
            try {
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 109;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i4 % 128;
                int i5 = i4 % 2;
                collapsingToolbarLayout.setLayoutParams(layoutParams);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if ((r0 == null ? com.alibaba.fastjson.parser.JSONLexer.EOI : 22) != 26) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
    
        if ((r0 == null ? 'W' : 7) != 7) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002e, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    @kotlin.jvm.JvmName(name = "DatabaseTableConfigUtil")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean DatabaseTableConfigUtil() {
        /*
            r5 = this;
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r2
            int r0 = r0 % 2
            if (r0 != 0) goto Le
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            r2 = 0
            if (r0 == r1) goto L23
            id.dana.referral.model.MyReferralConsult r0 = r5.moveToNextValue
            int r3 = r2.length     // Catch: java.lang.Throwable -> L21
            r3 = 26
            if (r0 != 0) goto L1c
            r4 = 26
            goto L1e
        L1c:
            r4 = 22
        L1e:
            if (r4 == r3) goto L2e
            goto L34
        L21:
            r0 = move-exception
            throw r0
        L23:
            id.dana.referral.model.MyReferralConsult r0 = r5.moveToNextValue
            r3 = 7
            if (r0 != 0) goto L2b
            r4 = 87
            goto L2c
        L2b:
            r4 = 7
        L2c:
            if (r4 == r3) goto L34
        L2e:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L35
        L34:
            r2 = r0
        L35:
            java.lang.String r0 = r2.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L49
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L49
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L49
            r0 = r0 ^ r1
            int r1 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r1 = r1 + 5
            int r2 = r1 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r2
            int r1 = r1 % 2
            return r0
        L49:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.DatabaseTableConfigUtil():boolean");
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    public final void setReferralWidgetFeatureValue(List<? extends ReferralWidgetModel> referralWidgetModels) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 77;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(referralWidgetModels, "");
            MyBillsEntityDataFactory(referralWidgetModels);
            ReferralCodeSectionView referralCodeSectionView = (ReferralCodeSectionView) _$_findCachedViewById(R.id.rcsv_referral_code);
            if ((referralCodeSectionView != null ? (char) 6 : (char) 22) != 22) {
                try {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 75;
                    NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
                    char c = i3 % 2 != 0 ? (char) 19 : 'M';
                    referralCodeSectionView.setReferralButtons(referralWidgetModels);
                    if (c != 19) {
                        int i4 = 38 / 0;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if ((r4) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        if (r4 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        FragmentBottomSheetPaymentSettingBinding();
        r4 = (id.dana.richview.contactselector.ContactSelectorView) _$_findCachedViewById(id.dana.R.id.GroupRecipientPermissionHelper);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        if (r4 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        r0 = 'c';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        r0 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        if (r0 == 5) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        r5 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 + 115;
        id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        r4.checkPermission();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return;
     */
    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCheckRegisteredUser(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r1
            int r0 = r0 % 2
            r1 = 44
            if (r0 != 0) goto L11
            r0 = 44
            goto L13
        L11:
            r0 = 26
        L13:
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            if (r0 == r1) goto L22
            if (r4 == 0) goto L1e
            r4 = 1
            goto L1f
        L1e:
            r4 = 0
        L1f:
            if (r4 == 0) goto L4c
            goto L28
        L22:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L50
            if (r4 == 0) goto L4c
        L28:
            r3.FragmentBottomSheetPaymentSettingBinding()
            int r4 = id.dana.R.id.GroupRecipientPermissionHelper
            android.view.View r4 = r3._$_findCachedViewById(r4)
            id.dana.richview.contactselector.ContactSelectorView r4 = (id.dana.richview.contactselector.ContactSelectorView) r4
            r5 = 5
            if (r4 == 0) goto L39
            r0 = 99
            goto L3a
        L39:
            r0 = 5
        L3a:
            if (r0 == r5) goto L4f
            int r5 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L4a
            int r5 = r5 + 115
            int r0 = r5 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r0     // Catch: java.lang.Exception -> L4a
            int r5 = r5 % 2
            r4.checkPermission()
            return
        L4a:
            r4 = move-exception
            throw r4
        L4c:
            r3.BuiltInFictitiousFunctionClassFactory(r5)
        L4f:
            return
        L50:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.onCheckRegisteredUser(boolean, java.lang.String):void");
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    public final void onGetReferralConsultSuccess(MyReferralConsult myReferralConsult) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 113;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        Object obj = null;
        if (i % 2 == 0) {
            try {
                Intrinsics.checkNotNullParameter(myReferralConsult, "");
                this.moveToNextValue = myReferralConsult;
                getReferralTrackerPresenter().MyBillsEntityDataFactory(myReferralConsult);
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(myReferralConsult, "");
            this.moveToNextValue = myReferralConsult;
            getReferralTrackerPresenter().MyBillsEntityDataFactory(myReferralConsult);
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i2 % 128;
        if ((i2 % 2 == 0 ? '/' : 'F') != '/') {
            return;
        }
        obj.hashCode();
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    public final void onGetDeeplinkReferralSuccess(DeepLink deepLinkReferral) {
        Intrinsics.checkNotNullParameter(deepLinkReferral, "");
        String link = deepLinkReferral.getLink();
        Intrinsics.checkNotNullExpressionValue(link, "");
        this.getAuthRequestContext = link;
        ReferralCodeSectionView referralCodeSectionView = (ReferralCodeSectionView) _$_findCachedViewById(R.id.rcsv_referral_code);
        if ((referralCodeSectionView != null ? (char) 3 : ';') != ';') {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 27;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            referralCodeSectionView.hideSkeleton();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 89;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
            int i4 = i3 % 2;
        }
        PrepareContext();
        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 125;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i5 % 128;
        int i6 = i5 % 2;
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    public final void onGetMessageTemplateSuccess(ReferralMessageTemplateConfig message) {
        boolean z;
        ReferralCodeSectionView referralCodeSectionView;
        Intrinsics.checkNotNullParameter(message, "");
        ReferralMessageTemplateConfig insertReferralLink = message.insertReferralCode(this.scheduleImpl).insertReferralLink(this.getAuthRequestContext);
        String messageIndonesia = LocaleUtil.BuiltInFictitiousFunctionClassFactory() ? insertReferralLink.getMessageIndonesia() : insertReferralLink.getMessageEnglish();
        this.GetContactSyncConfig = messageIndonesia;
        if ((messageIndonesia.length() == 0 ? 'Y' : '6') != 'Y') {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 25;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            int i2 = i % 2;
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            ReferralCodeSectionView referralCodeSectionView2 = (ReferralCodeSectionView) _$_findCachedViewById(R.id.rcsv_referral_code);
            if ((referralCodeSectionView2 != null ? '5' : '`') != '`') {
                try {
                    referralCodeSectionView2.setMessage(this.GetContactSyncConfig);
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            return;
        }
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 125;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
            Object[] objArr = null;
            if (i3 % 2 != 0) {
                referralCodeSectionView = (ReferralCodeSectionView) _$_findCachedViewById(R.id.rcsv_referral_code);
                int length = objArr.length;
                if (referralCodeSectionView == null) {
                    return;
                }
            } else {
                referralCodeSectionView = (ReferralCodeSectionView) _$_findCachedViewById(R.id.rcsv_referral_code);
                if ((referralCodeSectionView != null ? (char) 17 : '\f') != 17) {
                    return;
                }
            }
            referralCodeSectionView.setMessage(moveToNextValue());
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 31;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i4 % 128;
            if ((i4 % 2 == 0 ? '\r' : 'T') != '\r') {
                return;
            }
            int length2 = objArr.length;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    public final void onGetReferralBannerSuccess(List<ReferralBannerContent> referralBannerContents) {
        Intrinsics.checkNotNullParameter(referralBannerContents, "");
        int i = 2;
        if (referralBannerContents.isEmpty()) {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 19;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i2 % 128;
            int i3 = i2 % 2;
            isLayoutRequested();
            return;
        }
        scheduleImpl();
        ReferralBannerAdapter referralBannerAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (referralBannerAdapter != null) {
            try {
                referralBannerAdapter.KClassImpl$Data$declaredNonStaticMembers$2(referralBannerContents);
            } catch (Exception e) {
                throw e;
            }
        }
        CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.res_0x7f0a0595_otpchallengeuistate_verifyinvalidotp);
        if (!(circularViewPager != null)) {
            return;
        }
        if (!(referralBannerContents.size() > 2)) {
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 119;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i4 % 128;
            if (i4 % 2 != 0) {
            }
            i = 1;
        }
        circularViewPager.setOffscreenPageLimit(i);
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    public final void onGetReferralBannerError() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        char c = i % 2 == 0 ? 'A' : '\f';
        isLayoutRequested();
        if (c != '\f') {
            int i2 = 68 / 0;
        }
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    public final void onGetReferralTrackerSuccess(ReferralTrackerModel referralTrackerModel) {
        int i;
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 81;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
            int i3 = i2 % 2;
            Intrinsics.checkNotNullParameter(referralTrackerModel, "");
            if (!(referralTrackerModel.getAuthRequestContext == null)) {
                i = referralTrackerModel.getAuthRequestContext.size();
            } else {
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 39;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i4 % 128;
                int i5 = i4 % 2;
                i = 0;
            }
            ReferralCodeSectionView referralCodeSectionView = (ReferralCodeSectionView) _$_findCachedViewById(R.id.rcsv_referral_code);
            if ((referralCodeSectionView != null ? ';' : (char) 0) != ';') {
                return;
            }
            referralCodeSectionView.setReferralTracker(i);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    public final void onGetReferralTrackerError() {
        ReferralCodeSectionView referralCodeSectionView = (ReferralCodeSectionView) _$_findCachedViewById(R.id.rcsv_referral_code);
        if (!(referralCodeSectionView == null)) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 109;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            try {
                referralCodeSectionView.setReferralTracker(0);
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 89;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if ((r0 != null ? '\'' : '5') != '\'') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
    
        if ((r0 != null ? 0 : '(') != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
    
        r0.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        r0 = (id.dana.richview.CircularViewPager) _$_findCachedViewById(id.dana.R.id.res_0x7f0a0595_otpchallengeuistate_verifyinvalidotp);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
    
        if (r0 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        r1 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 + 5;
        id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1 % 128;
        r1 = r1 % 2;
        r0.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void isLayoutRequested() {
        /*
            r4 = this;
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L5b
            int r0 = r0 + 21
            int r1 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1     // Catch: java.lang.Exception -> L5b
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L29
            int r0 = id.dana.R.id.iv_default_referral_banner     // Catch: java.lang.Exception -> L27
            android.view.View r0 = r4._$_findCachedViewById(r0)     // Catch: java.lang.Exception -> L27
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch: java.lang.Exception -> L27
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L25
            r2 = 39
            if (r0 == 0) goto L20
            r3 = 39
            goto L22
        L20:
            r3 = 53
        L22:
            if (r3 == r2) goto L3a
            goto L3f
        L25:
            r0 = move-exception
            throw r0
        L27:
            r0 = move-exception
            throw r0
        L29:
            int r0 = id.dana.R.id.iv_default_referral_banner
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L35
            r2 = 0
            goto L37
        L35:
            r2 = 40
        L37:
            if (r2 == 0) goto L3a
            goto L3f
        L3a:
            android.view.View r0 = (android.view.View) r0
            r0.setVisibility(r1)
        L3f:
            int r0 = id.dana.R.id.res_0x7f0a0595_otpchallengeuistate_verifyinvalidotp
            android.view.View r0 = r4._$_findCachedViewById(r0)
            id.dana.richview.CircularViewPager r0 = (id.dana.richview.CircularViewPager) r0
            if (r0 == 0) goto L5a
            int r1 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r1 = r1 + 5
            int r2 = r1 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r2
            int r1 = r1 % 2
            android.view.View r0 = (android.view.View) r0
            r1 = 8
            r0.setVisibility(r1)
        L5a:
            return
        L5b:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.isLayoutRequested():void");
    }

    private final void scheduleImpl() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        try {
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_default_referral_banner);
            if (imageView != null) {
                try {
                    imageView.setVisibility(8);
                } catch (Exception e) {
                    throw e;
                }
            }
            CircularViewPager circularViewPager = (CircularViewPager) _$_findCachedViewById(R.id.res_0x7f0a0595_otpchallengeuistate_verifyinvalidotp);
            if ((circularViewPager != null ? '7' : '4') != '4') {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 107;
                NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
                int i4 = i3 % 2;
                circularViewPager.setVisibility(0);
            }
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 75;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i5 % 128;
            if (i5 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.contract.referraltracker.ReferralTrackerContract.View
    public final void onGetMessageTemplateError() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        try {
            ReferralCodeSectionView referralCodeSectionView = (ReferralCodeSectionView) _$_findCachedViewById(R.id.rcsv_referral_code);
            if ((referralCodeSectionView != null ? (char) 22 : '8') != '8') {
                referralCodeSectionView.setMessage(getErrorConfigVersion());
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 83;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                int i4 = 34 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "moveToNextValue")
    private final String moveToNextValue() {
        String string;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 83;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        Object obj = null;
        if (i % 2 != 0) {
            string = getString(R.string.msg_referral_text);
            Intrinsics.checkNotNullExpressionValue(string, "");
            obj.hashCode();
        } else {
            string = getString(R.string.msg_referral_text);
            Intrinsics.checkNotNullExpressionValue(string, "");
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 5;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        if (i2 % 2 != 0) {
            obj.hashCode();
            return string;
        }
        return string;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        GetContactSyncConfig();
        ContactSelectorView contactSelectorView = (ContactSelectorView) _$_findCachedViewById(R.id.GroupRecipientPermissionHelper);
        if (!(contactSelectorView == null)) {
            try {
                contactSelectorView.setVisibility(0);
            } catch (Exception e) {
                throw e;
            }
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1891_splitbillmixpaneltracker_tracksplitbillconfirm_1);
        if (textView != null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 113;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
            if ((i % 2 == 0 ? (char) 20 : '8') != '8') {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(0);
            }
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(java.util.List<? extends id.dana.model.ReferralWidgetModel> r7) {
        /*
            r6 = this;
            int r0 = id.dana.R.id.rcsv_referral_code
            android.view.View r0 = r6._$_findCachedViewById(r0)
            id.dana.referral.ReferralCodeSectionView r0 = (id.dana.referral.ReferralCodeSectionView) r0
            if (r0 == 0) goto L85
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r1 = r7 instanceof java.util.Collection
            r2 = 36
            if (r1 == 0) goto L15
            r1 = 10
            goto L17
        L15:
            r1 = 36
        L17:
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L32
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Exception -> L30
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> L30
            if (r1 == 0) goto L32
            int r7 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r7 = r7 + 93
            int r1 = r7 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r1
            int r7 = r7 % 2
            r1 = 0
            goto L72
        L30:
            r7 = move-exception
            goto L84
        L32:
            java.util.Iterator r7 = r7.iterator()
            r1 = 0
        L37:
            boolean r2 = r7.hasNext()
            r5 = 45
            if (r2 == 0) goto L42
            r2 = 57
            goto L44
        L42:
            r2 = 45
        L44:
            if (r2 == r5) goto L72
            java.lang.Object r2 = r7.next()     // Catch: java.lang.Exception -> L30
            id.dana.model.ReferralWidgetModel r2 = (id.dana.model.ReferralWidgetModel) r2
            boolean r2 = r2.PlaceComponentResult()
            if (r2 == 0) goto L54
            r2 = 1
            goto L55
        L54:
            r2 = 0
        L55:
            if (r2 == 0) goto L37
            int r2 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r2 = r2 + 125
            int r5 = r2 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r5
            int r2 = r2 % 2
            int r1 = r1 + 1
            r2 = 9
            if (r1 >= 0) goto L6a
            r5 = 43
            goto L6c
        L6a:
            r5 = 9
        L6c:
            if (r5 == r2) goto L37
            kotlin.collections.CollectionsKt.throwCountOverflow()     // Catch: java.lang.Exception -> L30
            goto L37
        L72:
            if (r1 <= 0) goto L75
            goto L76
        L75:
            r3 = 0
        L76:
            r0.setReferralContainerBottomPadding(r3)     // Catch: java.lang.Exception -> L30
            int r7 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r7 = r7 + 47
            int r0 = r7 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r0
            int r7 = r7 % 2
            goto L85
        L84:
            throw r7
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.MyBillsEntityDataFactory(java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
    
        if (r2 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
    
        if (r2 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        r1 = r2.subscribe(new id.dana.referral.MyReferralDetailActivity$$ExternalSyntheticLambda0(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void GetContactSyncConfig() {
        /*
            r5 = this;
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r0 + 71
            int r1 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            int r0 = r0 % 2
            int r0 = id.dana.R.id.GroupRecipientPermissionHelper
            android.view.View r0 = r5._$_findCachedViewById(r0)
            id.dana.richview.contactselector.ContactSelectorView r0 = (id.dana.richview.contactselector.ContactSelectorView) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            r3 = 0
            goto L19
        L18:
            r3 = 1
        L19:
            if (r3 == r2) goto L86
            int r2 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r2 = r2 + 111
            int r3 = r2 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r3
            int r2 = r2 % 2
            r2 = r5
            android.content.Context r2 = (android.content.Context) r2
            r3 = 2131100497(0x7f060351, float:1.7813377E38)
            int r2 = androidx.core.content.ContextCompat.BuiltInFictitiousFunctionClassFactory(r2, r3)
            r0.setContactHeaderColor(r2)
            id.dana.richview.contactselector.ContactSelectorView$Listener r2 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0()
            r0.setListener(r2)
            int r2 = id.dana.R.id.res_0x7f0a1b79_com_alibaba_ariver_engine_api_extopt_6
            android.view.View r2 = r5._$_findCachedViewById(r2)
            id.dana.richview.SearchView r2 = (id.dana.richview.SearchView) r2
            r3 = 85
            if (r2 == 0) goto L48
            r4 = 29
            goto L4a
        L48:
            r4 = 85
        L4a:
            if (r4 == r3) goto L74
            int r3 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r3 = r3 + 43
            int r4 = r3 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L64
            io.reactivex.subjects.PublishSubject r2 = r2.getKeyword()
            r3 = 44
            int r3 = r3 / r1
            if (r2 == 0) goto L74
            goto L6a
        L62:
            r0 = move-exception
            throw r0
        L64:
            io.reactivex.subjects.PublishSubject r2 = r2.getKeyword()
            if (r2 == 0) goto L74
        L6a:
            id.dana.referral.MyReferralDetailActivity$$ExternalSyntheticLambda0 r1 = new id.dana.referral.MyReferralDetailActivity$$ExternalSyntheticLambda0
            r1.<init>()
            io.reactivex.disposables.Disposable r1 = r2.subscribe(r1)
            goto L75
        L74:
            r1 = 0
        L75:
            r5.addDisposable(r1)
            id.dana.referral.MyReferralDetailActivity$$ExternalSyntheticLambda1 r1 = new id.dana.referral.MyReferralDetailActivity$$ExternalSyntheticLambda1
            r1.<init>()
            r0.setRecipientListener(r1)
            r0.initContactList()
            r0.checkPermission()
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.GetContactSyncConfig():void");
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(ContactSelectorView contactSelectorView, String str) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 49;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            try {
                Intrinsics.checkNotNullParameter(contactSelectorView, "");
                contactSelectorView.observeContactPagedList(str);
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 97;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 25 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final void MyBillsEntityDataFactory(MyReferralDetailActivity myReferralDetailActivity, RecipientModel recipientModel) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if ((i % 2 != 0 ? (char) 17 : (char) 7) != 7) {
            Intrinsics.checkNotNullParameter(myReferralDetailActivity, "");
            Intrinsics.checkNotNullParameter(recipientModel, "");
            myReferralDetailActivity.getAuthRequestContext(recipientModel);
            int i2 = 12 / 0;
        } else {
            try {
                Intrinsics.checkNotNullParameter(myReferralDetailActivity, "");
                Intrinsics.checkNotNullParameter(recipientModel, "");
                myReferralDetailActivity.getAuthRequestContext(recipientModel);
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 101;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 21 : 'K') != 'K') {
            int i4 = 83 / 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.left_button})
    public final void closeToHome(View view) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 7;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        Object[] objArr = null;
        if (i % 2 == 0) {
            try {
                backToHomepage(null);
            } catch (Exception e) {
                throw e;
            }
        } else {
            backToHomepage(null);
            int length = objArr.length;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 99;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i2 % 128;
        int i3 = i2 % 2;
    }

    private final void getAuthRequestContext(RecipientModel p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        getReferralTrackerPresenter().BuiltInFictitiousFunctionClassFactory(p0.getErrorConfigVersion, p0.PlaceComponentResult());
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        int i4 = 7 / 0;
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intent intent = new Intent("android.intent.action.VIEW");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.msg_referral_text);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.getAuthRequestContext, this.scheduleImpl}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "");
        PlaceComponentResult(intent, p0, format);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
    }

    private final void PlaceComponentResult(Intent p0, String p1, String p2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("https://api.whatsapp.com/send?phone=");
            sb.append(new Regex("^0").replace(p1, "+62"));
            sb.append("&text=");
            Object[] objArr = new Object[1];
            a(false, 157 - (ViewConfiguration.getPressedStateDuration() >> 16), super.getResources().getString(R.string.error_message_form_first_name).substring(6, 7).codePointAt(0) - 96, new char[]{2, 65513, 65524, 17, 16}, getApplicationInfo().targetSdkVersion - 30, objArr);
            sb.append(URLEncoder.encode(p2, ((String) objArr[0]).intern()));
            String obj = sb.toString();
            p0.setPackage("com.whatsapp");
            p0.setData(Uri.parse(obj));
            if (!(!IntentUtil.PlaceComponentResult(this, "com.whatsapp"))) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 99;
                NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
                int i2 = i % 2;
                startActivity(p0);
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.msg_referral_text_non_bold);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.getAuthRequestContext, this.scheduleImpl}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            startActivity(Intent.createChooser(IntentUtil.KClassImpl$Data$declaredNonStaticMembers$2(format), getString(R.string.share_via)));
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 79;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return;
            }
            Object obj2 = null;
            obj2.hashCode();
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.URL_ENCODE, DanaLogConstants.ExceptionType.URL_ENCODE_EXCEPTION, e.toString());
        }
    }

    private final void MyBillsEntityDataFactory(MotionEvent p0) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda7 + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i % 128;
        int i2 = i % 2;
        View currentFocus = getCurrentFocus();
        if (currentFocus instanceof EditText) {
            Rect rect = new Rect();
            try {
                EditText editText = (EditText) currentFocus;
                editText.getGlobalVisibleRect(rect);
                if (!rect.contains((int) p0.getRawX(), (int) p0.getRawY())) {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 121;
                    NetworkUserEntityData$$ExternalSyntheticLambda7 = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        KeyboardHelper.MyBillsEntityDataFactory(this);
                        editText.clearFocus();
                        return;
                    }
                    KeyboardHelper.MyBillsEntityDataFactory(this);
                    editText.clearFocus();
                    int i4 = 81 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private final void FragmentBottomSheetPaymentSettingBinding() {
        int authRequestContext;
        int i;
        View inflate = getLayoutInflater().inflate(R.layout.view_top_toast, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        Toast toast = new Toast(this);
        toast.setView(inflate);
        toast.setDuration(0);
        ActionBar supportActionBar = getSupportActionBar();
        if ((supportActionBar != null ? (char) 23 : '\f') == 23) {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 111;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                authRequestContext = supportActionBar.getAuthRequestContext();
                i = 17;
            } else {
                authRequestContext = supportActionBar.getAuthRequestContext();
                i = 55;
            }
            toast.setGravity(i, 0, authRequestContext);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 85;
            NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
            int i4 = i3 % 2;
        }
        toast.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if ((r0 ? '+' : '\n') != '+') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
    
        if (r5 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0057, code lost:
    
        if ((getAuthRequestContext(r5) ? '\f' : '\r') != '\r') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005b, code lost:
    
        r5 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 + 17;
        id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0065, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0067, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0068, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r0 + 45
            int r1 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 12
            if (r0 != 0) goto L20
            boolean r0 = r4.getErrorConfigVersion
            int r3 = r1.length     // Catch: java.lang.Throwable -> L1e
            r3 = 43
            if (r0 == 0) goto L19
            r0 = 43
            goto L1b
        L19:
            r0 = 10
        L1b:
            if (r0 == r3) goto L2c
            goto L59
        L1e:
            r5 = move-exception
            throw r5
        L20:
            boolean r0 = r4.getErrorConfigVersion     // Catch: java.lang.Exception -> L69
            if (r0 == 0) goto L27
            r0 = 12
            goto L29
        L27:
            r0 = 97
        L29:
            if (r0 == r2) goto L2c
            goto L59
        L2c:
            int r0 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L69
            int r0 = r0 + 75
            int r3 = r0 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = r3     // Catch: java.lang.Exception -> L69
            int r0 = r0 % 2
            r3 = 42
            if (r0 == 0) goto L3d
            r0 = 44
            goto L3f
        L3d:
            r0 = 42
        L3f:
            if (r0 == r3) goto L4d
            boolean r5 = r4.getAuthRequestContext(r5)
            r1.hashCode()     // Catch: java.lang.Throwable -> L4b
            if (r5 != 0) goto L59
            goto L5b
        L4b:
            r5 = move-exception
            throw r5
        L4d:
            boolean r5 = r4.getAuthRequestContext(r5)
            r0 = 13
            if (r5 != 0) goto L57
            r2 = 13
        L57:
            if (r2 == r0) goto L5b
        L59:
            r5 = 0
            goto L66
        L5b:
            int r5 = id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda7     // Catch: java.lang.Exception -> L67
            int r5 = r5 + 17
            int r0 = r5 % 128
            id.dana.referral.MyReferralDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = r0     // Catch: java.lang.Exception -> L67
            int r5 = r5 % 2
            r5 = 1
        L66:
            return r5
        L67:
            r5 = move-exception
            throw r5
        L69:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.MyReferralDetailActivity.KClassImpl$Data$declaredNonStaticMembers$2(android.view.MotionEvent):boolean");
    }

    private final boolean getAuthRequestContext(MotionEvent p0) {
        boolean isClearImageViewRect;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 89;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        if (!(i % 2 == 0)) {
            try {
                try {
                    isClearImageViewRect = ((SearchView) _$_findCachedViewById(R.id.res_0x7f0a1b79_com_alibaba_ariver_engine_api_extopt_6)).isClearImageViewRect((int) p0.getRawX(), (int) p0.getRawY());
                    int i2 = 61 / 0;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            isClearImageViewRect = ((SearchView) _$_findCachedViewById(R.id.res_0x7f0a1b79_com_alibaba_ariver_engine_api_extopt_6)).isClearImageViewRect((int) p0.getRawX(), (int) p0.getRawY());
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
        if ((i3 % 2 == 0 ? '!' : 'S') != '!') {
            return isClearImageViewRect;
        }
        int i4 = 20 / 0;
        return isClearImageViewRect;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    private final ContactSelectorView.Listener NetworkUserEntityData$$ExternalSyntheticLambda0() {
        try {
            ContactSelectorView.Listener listener = new ContactSelectorView.Listener() { // from class: id.dana.referral.MyReferralDetailActivity$contactSelectorListener$1
                @Override // id.dana.richview.contactselector.ContactSelectorView.Listener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                }

                @Override // id.dana.richview.contactselector.ContactSelectorView.Listener
                public final void PlaceComponentResult(boolean p0) {
                    SearchView searchView = (SearchView) MyReferralDetailActivity.this._$_findCachedViewById(R.id.res_0x7f0a1b79_com_alibaba_ariver_engine_api_extopt_6);
                    if (searchView != null) {
                        searchView.setVisibility(Boolean.valueOf(p0).equals(Boolean.TRUE) ? 0 : 8);
                    }
                }
            };
            int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 95;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
            int i2 = i % 2;
            return listener;
        } catch (Exception e) {
            throw e;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/referral/MyReferralDetailActivity$BundleKey;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BundleKey {
        public static final String BUNDLE_REFERRAL_CONSULT = "referral_consult";
        public static final String BUNDLE_REFERRAL_DEEPLINK = "referral_deepLink";
        public static final String BUNDLE_SHOW_REFERRAL = "referral_show";

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/referral/MyReferralDetailActivity$BundleKey$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

            private Companion() {
            }
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda8 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = i % 128;
        int i2 = i % 2;
        byte b = 0;
        if (this.initRecordTimeStamp == null) {
            DaggerReferralTrackerComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerReferralTrackerComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ReferralTrackerModule) Preconditions.getAuthRequestContext(new ReferralTrackerModule(this));
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.referral.MyReferralDetailActivity$initComponent$1
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
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            MyReferralDetailActivity myReferralDetailActivity = this;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = myReferralDetailActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = TrackerKey.SourceType.REFERRAL;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = myReferralDetailActivity;
            BuiltInFictitiousFunctionClassFactory.moveToNextValue = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = myReferralDetailActivity;
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = myReferralDetailActivity;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory2 = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = myReferralDetailActivity;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory2, b));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, DeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.moveToNextValue, ScanQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.lookAheadTest, RestoreUrlModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, FeatureModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, OauthModule.class);
            if (BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion == null) {
                BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = new ServicesModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ReferralTrackerModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
            this.initRecordTimeStamp = new DaggerReferralTrackerComponent.ReferralTrackerComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.moveToNextValue, BuiltInFictitiousFunctionClassFactory.lookAheadTest, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, (byte) 0);
        }
        try {
            ReferralTrackerComponent referralTrackerComponent = this.initRecordTimeStamp;
            if (referralTrackerComponent != null) {
                try {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda7 + 107;
                    NetworkUserEntityData$$ExternalSyntheticLambda8 = i3 % 128;
                    int i4 = i3 % 2;
                    referralTrackerComponent.getAuthRequestContext(this);
                    int i5 = NetworkUserEntityData$$ExternalSyntheticLambda8 + 1;
                    NetworkUserEntityData$$ExternalSyntheticLambda7 = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            registerPresenter(getReferralTrackerPresenter(), getReadDeepLinkPropertiesPresenter());
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void c(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            try {
                if (!(d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length)) {
                    break;
                }
                int i2 = $10 + 27;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        String str = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
        int i4 = $10 + 53;
        $11 = i4 % 128;
        if (i4 % 2 != 0) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }

    private static void a(boolean z, int i, int i2, char[] cArr, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((a2.MyBillsEntityDataFactory < i2 ? (char) 29 : (char) 16) == 16) {
                break;
            }
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (newProxyInstance ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if ((i3 > 0 ? '^' : (char) 7) == '^') {
            try {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            } catch (Exception e) {
                throw e;
            }
        }
        if (!(!z)) {
            int i5 = $11 + 67;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i2) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
                int i7 = $11 + 51;
                $10 = i7 % 128;
                int i8 = i7 % 2;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
