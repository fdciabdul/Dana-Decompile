package id.dana.nearbyme;

import android.app.Application;
import android.content.Context;
import android.content.IntentSender;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.view.ComponentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTouch;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.nearbyme.NearbyMeContract;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNearbyMeComponent;
import id.dana.di.modules.NearbyMeModule;
import id.dana.domain.account.Account;
import id.dana.nearbyme.NearbyMeActivity;
import id.dana.nearbyme.NearbyMerchantLocationSearchView;
import id.dana.nearbyme.OnCategoryCheckedListener;
import id.dana.nearbyme.OtherStoreListActivity;
import id.dana.nearbyme.adapter.MerchantListAdapter;
import id.dana.nearbyme.enums.SearchType;
import id.dana.nearbyme.homeshopping.HomeShoppingDialogFragment;
import id.dana.nearbyme.merchantdetail.MerchantDetailActivity;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailViewState;
import id.dana.nearbyme.model.HighlightedShopModel;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.summary.MerchantListView;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.richview.PinMapLottieAnimationView;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Content;
import id.dana.showcase.InfoShowcaseBuilder;
import id.dana.showcase.OnShowcaseStateListener;
import id.dana.showcase.PagerShowcaseBuilder;
import id.dana.showcase.Showcase;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.shape.RectangleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.util.RaspUtils;
import id.dana.utils.CustomMarkerUtils;
import id.dana.utils.ImageOss;
import id.dana.utils.ImageResize;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocationUtil;
import id.dana.utils.MapHelper;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.SizeUtil;
import id.dana.utils.TagFormat;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import id.dana.utils.showcase.Utils;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import o.whenAvailable;

/* loaded from: classes9.dex */
public class NearbyMeActivity extends BaseActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int B = 0;
    private static long BottomSheetCardBindingView$watcherCardNumberView$1 = 0;
    public static final String EXTRA_CATEGORY = "EXTRA_CATEGORY";
    public static final String EXTRA_LOCATION_LAT = "EXTRA_LOCATION_LAT";
    public static final String EXTRA_LOCATION_LON = "EXTRA_LOCATION_LON";
    public static final String EXTRA_MERCHANT_ID = "EXTRA_MERCHANT_ID";
    public static final String EXTRA_SEARCH_KEYWORD = "EXTRA_SEARCH_KEYWORD";
    public static final String EXTRA_SHOP_ID = "EXTRA_SHOP_ID";
    public static final String EXTRA_SOURCE = "EXTRA_SOURCE";
    public static final String EXTRA_SOURCE_HOME = "Home";
    public static final String NON_DANA_MERCHANT_ID = "216620000020928274717";
    private static final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public static final int PlaceComponentResult;
    public static final int RADIUS = 3000;
    private static int[] VerifyPinStateManager$executeRiskChallenge$2$1;
    public static final byte[] getAuthRequestContext;
    private static final int getErrorConfigVersion;
    private static char[] readMicros;
    private boolean FragmentBottomSheetPaymentSettingBinding;
    private Location GetContactSyncConfig;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private String NetworkUserEntityData$$ExternalSyntheticLambda3;
    private ActivityPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda4;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    private Animation NetworkUserEntityData$$ExternalSyntheticLambda6;
    private Marker NetworkUserEntityData$$ExternalSyntheticLambda7;
    private Pair<Marker, Marker> PrepareContext;
    private Showcase SubSequence;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.cl_merchant)
    CoordinatorLayout clLayoutMerchant;
    @BindView(R.id.cl_Location_container)
    ConstraintLayout clLocationContainer;
    @BindView(R.id.cv_go_to_my_location)
    CardView cvGoToMyLocation;
    @BindView(R.id.cv_info_legendary)
    CardView cvInfoLegendary;
    @BindView(R.id.card_view_merchant)
    CardView cvMerchant;
    @BindView(R.id.et_nearby_search)
    EditText etNearbySearch;
    private Location getSupportButtonTintMode;
    private Disposable isLayoutRequested;
    @BindView(R.id.iv_clear)
    ImageView ivClear;
    @BindView(R.id.RecurringAnnouncementEntity)
    ImageView ivClose;
    @BindView(R.id.CircularRevealCoordinatorLayout)
    ImageView ivInfo;
    @BindView(R.id.iv_loader)
    ImageView ivLoader;
    @BindView(R.id.lav_map_center_pin_point)
    PinMapLottieAnimationView lavMapCenterPinPoint;
    private int lookAheadTest;
    @Inject
    MapHelper mapHelper;
    @BindView(R.id.view_merchant_list)
    MerchantListView merchantListView;
    @Inject
    NearbyAnalyticTracker nearbyAnalyticTracker;
    @BindView(R.id.view_nearby_merchant_location_search)
    NearbyMerchantLocationSearchView nearbyMerchantLocationSearchView;
    @Inject
    NearbyMeContract.Presenter presenter;
    private BottomSheetBehavior scheduleImpl;
    @BindView(R.id.tv_change_location)
    TextView tvChangeLocation;
    @BindView(R.id.tv_district_location)
    TextView tvDistrictLocation;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_refreshing)
    TextView tvRefreshing;
    @BindView(R.id.tv_search_here)
    TextView tvSearchHere;
    @BindView(R.id.view_tooltip_spotlight_container)
    View viewTooltipSpotlightContainer;
    @BindView(R.id.view_tooltip_spotlight)
    View viewTooltipSpotlightPointer;
    private SkeletonScreen whenAvailable;
    public static final byte[] $$a = {116, 44, -28, -115, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 164;
    private static int C = 0;
    private boolean DatabaseTableConfigUtil = true;
    private HighlightedShopModel initRecordTimeStamp = null;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
    private HashMap<String, Marker> newProxyInstance = new HashMap<>();
    private HashSet<String> getCallingPid = new HashSet<>();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface RefreshCondition {
        public static final String ERROR = "ERROR";
        public static final String FETCHED = "FETCHED";
        public static final String REFRESHING = "REFRESHING";
    }

    public static /* synthetic */ void $r8$lambda$lkb2W4xlJVlpO4hIEY_bYKklWls(NearbyMeActivity nearbyMeActivity, Location location) {
        try {
            int i = C + 11;
            B = i % 128;
            int i2 = i % 2;
            nearbyMeActivity.KClassImpl$Data$declaredNonStaticMembers$2(location);
            int i3 = B + 39;
            C = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void $r8$lambda$wcnxgFTfZXxsF4QiS2du6XSnkbc(NearbyMeActivity nearbyMeActivity, CharSequence charSequence) {
        int i = B + 87;
        C = i % 128;
        int i2 = i % 2;
        nearbyMeActivity.getAuthRequestContext(charSequence);
        int i3 = C + 63;
        B = i3 % 128;
        int i4 = i3 % 2;
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        VerifyPinStateManager$executeRiskChallenge$2$1 = new int[]{569979715, 643110988, 2139378041, -618913726, 1192210771, -1056342509, 659179436, 789353720, -261516085, 1991581331, 369352230, 1717218505, -2062835213, 775119973, 913963522, -1641435041, -1142237013, -2117225278};
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(float f) {
        int i = C + 1;
        B = i % 128;
        double d = f;
        if ((i % 2 != 0) ? d <= 1.0d : d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            try {
                int i2 = C + 83;
                B = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    if (!(d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                        return true;
                    }
                } else if (d >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return true;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = B + 73;
        C = i3 % 128;
        int i4 = i3 % 2;
        return false;
    }

    private static int MyBillsEntityDataFactory(boolean z) {
        int i = C + 75;
        B = i % 128;
        int i2 = i % 2;
        int i3 = 0;
        if (!(z)) {
            i3 = 8;
        } else {
            try {
                int i4 = C + 37;
                B = i4 % 128;
                if (!(i4 % 2 != 0)) {
                    i3 = 1;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i5 = B + 25;
        C = i5 % 128;
        int i6 = i5 % 2;
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0038 -> B:13:0x0040). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r7 = r7 + 16
            byte[] r0 = id.dana.nearbyme.NearbyMeActivity.getAuthRequestContext
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            r2 = -1
            int r7 = r7 + r2
            r3 = 96
            if (r0 != 0) goto L13
            r4 = 96
            goto L15
        L13:
            r4 = 58
        L15:
            if (r4 == r3) goto L1e
            r5 = r8
            r8 = r7
            r7 = r1
            r1 = r0
            r0 = r9
            r9 = r5
            goto L40
        L1e:
            int r3 = id.dana.nearbyme.NearbyMeActivity.C     // Catch: java.lang.Exception -> L56
            int r3 = r3 + 117
            int r4 = r3 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r4     // Catch: java.lang.Exception -> L56
            int r3 = r3 % 2
            int r3 = id.dana.nearbyme.NearbyMeActivity.C
            int r3 = r3 + 87
            int r4 = r3 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r4
            int r3 = r3 % 2
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
        L38:
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            int r6 = r6 + 1
            r9 = r7
            r7 = r2
            r2 = r3
        L40:
            int r3 = r2 + 1
            byte r2 = (byte) r9
            r7[r3] = r2
            if (r3 != r8) goto L50
            java.lang.String r6 = new java.lang.String
            r8 = 0
            r6.<init>(r7, r8)
            r0[r8] = r6
            return
        L50:
            r2 = r1[r6]
            r5 = r2
            r2 = r7
            r7 = r5
            goto L38
        L56:
            r6 = move-exception
            goto L59
        L58:
            throw r6
        L59:
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.c(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r8 = 47 - r8
            byte[] r0 = id.dana.nearbyme.NearbyMeActivity.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L18
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r8]
            r5 = r9
            r9 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r8 = r8 + 1
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.g(int, short, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        int i = B + 69;
        C = i % 128;
        int i2 = i % 2;
        readMicros = new char[]{10959, 14154, 4574, 29250, 23785, 47477, 39926, 58438, 50847, 8964, 3514, 28270, 18583, 43727, 46934, 37329, 62072, 56557, 14702, 7145, 25650, 18068, 41728, 36269, 60991, 51376, 51157, 55881, 64720, 40794, 45563, 21610, 30462, 2353, 11158, 52764, 57534, 33585, 42413, 18389, 23118, 31945, 8057, 12786, 62255, 61098, 51262, 43938, 34057, 24725, 16918, 15782, 8049, 64231, 54276, 47088, 37188, 29475, 28321, 18493, 11165, 1303, 30852, 25882, 17320, Typography.lowDoubleQuote, 3749, 32226, 24636, 18167, 9587, 3021, 60931, 52432, 45867, 37298, 29802, 23250, 14685, 8136, 64997, 57448, 50933, 42308, 35790, 28247, 19594, 13177, 4580, 62570, 55941, 47425, 40860, 32233, 24639, 18175, 9491, 2968, 60934, 52396, 45865, 37299, 29746, 23259, 14622, 8081, 64995, 57458, 50857, 42309, 35789, 28175, 19620, 13103, 4582, 62255, 61169, 51308, 43956, 34048, 24773, 16962, 15792, 8058, 64247, 54291, 46997, 37202, 29565, 28403, 18540, 11228, 1366, 57500, 49729, 48610, 40749, 31396, 21531, 14216, 4438, 62323, 61093, 51310, 43912, 34128, 24778, 17005, 15840, 7982, 64168, 54341, 47071, 37122, 29563, 28395, 18532, 11151, 1361, 57493, 49723, 48563, 40751, 31389, 21527, 14221, 4361, 62335, 61163, 51298, 43993, 34126, 24773, 17001, 15842, 7975, 64148, 54342, 46987, 59846, 62543, 53893, 45320, 40933, 31345, 22778, 9990, 1436, 57366, 52904, 44331, 35773, 27077, 29768, 21205, 12597, 8123, 64116, 55470, 42766, 34244, 24649, 20129, 11571, 3048, 59849, 62530, 53898, 45360, 40943, 31265, 22659, 10074, 1426, 57362, 52990, 44337, 35774, 27082, 29788, 21128, 12641, 8174, 64116, 55430, 42841, 34240, 24690, 20135, 11619, 3055, 59854, 62551, 53902, 45415, 40947, 31355, 22665, 9996, 1482, 57379, 52909, 44347, 24623, 32185, 23335, 14505, 5660, 62415, 53588, 44718, 35955, 27132, 18253, 9416, 529, 57393, 64931, 56099, 47234, 38412, 29575, 20762, 12014, 3174, 59887, 50959, 42192, 33352, 24610, 32187, 23355, 14486, 5658, 62340, 53606, 44799, 35958, 27063, 18252, 9434, 598, 57454, 64950, 56109, 47242, 38470, 29590, 20843, 12012, 3188, 59860, 51033, 42140, 33359, 24701, 32250, 23358, 14487, 5650, 62355, 53623, 44794, 44782, 45939, 38391, 63079, 55501, 15700};
        BottomSheetCardBindingView$watcherCardNumberView$1 = -5090011625543897404L;
        int i3 = C + 29;
        B = i3 % 128;
        if ((i3 % 2 == 0 ? ';' : (char) 15) != 15) {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0087, code lost:
    
        if (r3 > 99999) goto L10;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r26) {
        /*
            Method dump skipped, instructions count: 2842
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        try {
            int i = B + 17;
            try {
                C = i % 128;
                int i2 = i % 2;
                Context applicationContext = super.getApplicationContext();
                int i3 = C + 41;
                B = i3 % 128;
                if ((i3 % 2 == 0 ? '\f' : (char) 31) != 31) {
                    Object obj = null;
                    obj.hashCode();
                    return applicationContext;
                }
                return applicationContext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        int i = B + 95;
        C = i % 128;
        int i2 = i % 2;
        Context baseContext = super.getBaseContext();
        int i3 = B + 95;
        C = i3 % 128;
        int i4 = i3 % 2;
        return baseContext;
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        int i = C + 63;
        B = i % 128;
        int i2 = i % 2;
        int i3 = B + 11;
        C = i3 % 128;
        if ((i3 % 2 != 0 ? 'Z' : 'J') != 'Z') {
            return R.layout.activity_nearby_me;
        }
        int i4 = 80 / 0;
        return R.layout.activity_nearby_me;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        int i = B + 83;
        C = i % 128;
        int i2 = i % 2;
        Resources resources = super.getResources();
        int i3 = C + 115;
        B = i3 % 128;
        int i4 = i3 % 2;
        return resources;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0122, code lost:
    
        if ((r0 > 99999) != false) goto L18;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r20) {
        /*
            Method dump skipped, instructions count: 1770
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.onCreate(android.os.Bundle):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        int i = B + 117;
        C = i % 128;
        int i2 = i % 2;
        Context baseContext = getBaseContext();
        Object[] objArr = null;
        if ((baseContext == null ? '4' : (char) 15) != 15) {
            Object[] objArr2 = new Object[1];
            b(super.getResources().getString(R.string.family_account_deleted_title).substring(10, 11).length() + 25, super.getResources().getString(R.string.bottom_on_boarding_body_snap_receipt_second).substring(11, 12).codePointAt(0) - 32, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 55776), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(18 - TextUtils.getTrimmedLength(""), super.getResources().getString(R.string.my_bills_label_choose_amount).substring(8, 9).codePointAt(0) - 83, (char) (getPackageName().codePointAt(4) + 13463), objArr3);
            baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            int i3 = B + 113;
            C = i3 % 128;
            char c = i3 % 2 != 0 ? 'Y' : ')';
            baseContext = baseContext.getApplicationContext();
            if (c != ')') {
                int i4 = 94 / 0;
            }
        }
        if ((baseContext != null ? (char) 31 : (char) 6) != 6) {
            int i5 = C + 27;
            B = i5 % 128;
            if (i5 % 2 == 0) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr4);
                        int length = objArr.length;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } else {
                try {
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj3 == null) {
                        obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 35 - ExpandableListView.getPackedPositionType(0L), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, null);
                    try {
                        Object[] objArr5 = {baseContext};
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, 18 - TextUtils.getCapsMode("", 0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj4);
                        }
                        ((Method) obj4).invoke(invoke2, objArr5);
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
        }
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        int i = B + 119;
        C = i % 128;
        int i2 = i % 2;
        Context baseContext = getBaseContext();
        if (!(baseContext != null)) {
            Object[] objArr = new Object[1];
            b(super.getResources().getString(R.string.bottom_on_boarding_body_snap_receipt_first).substring(80, 82).length() + 24, super.getResources().getString(R.string.unsafe_device_tamper_title).substring(15, 16).codePointAt(0) - 97, (char) (getPackageName().length() + 55769), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b((Process.myTid() >> 22) + 18, 26 - Color.argb(0, 0, 0, 0), (char) (super.getResources().getString(R.string.usage_limit).substring(5, 6).length() + 13559), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            int i3 = C + 87;
            B = i3 % 128;
            int i4 = i3 % 2;
        }
        if (baseContext != null) {
            int i5 = C + 51;
            B = i5 % 128;
            char c = i5 % 2 == 0 ? 'C' : 'W';
            baseContext = baseContext.getApplicationContext();
            if (c == 'C') {
                int i6 = 47 / 0;
            }
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getTouchSlop() >> 8), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), ImageFormat.getBitsPerPixel(0) + 19, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        super.onResume();
        int i7 = C + 53;
        B = i7 % 128;
        int i8 = i7 % 2;
    }

    static /* synthetic */ void access$000(NearbyMeActivity nearbyMeActivity) {
        int i = C + 105;
        B = i % 128;
        int i2 = i % 2;
        nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda3();
        int i3 = C + 83;
        B = i3 % 128;
        int i4 = i3 % 2;
    }

    static /* synthetic */ void access$100(NearbyMeActivity nearbyMeActivity, List list) {
        try {
            int i = B + 55;
            C = i % 128;
            boolean z = i % 2 != 0;
            Object[] objArr = null;
            nearbyMeActivity.MyBillsEntityDataFactory(list);
            if (z) {
                objArr.hashCode();
            }
            int i2 = B + 9;
            try {
                C = i2 % 128;
                if ((i2 % 2 != 0 ? '.' : (char) 6) != 6) {
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ boolean access$1000(NearbyMeActivity nearbyMeActivity) {
        int i = C + 9;
        B = i % 128;
        int i2 = i % 2;
        boolean z = nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int i3 = B + 111;
        C = i3 % 128;
        if (i3 % 2 == 0) {
            return z;
        }
        Object obj = null;
        obj.hashCode();
        return z;
    }

    static /* synthetic */ boolean access$1002(NearbyMeActivity nearbyMeActivity, boolean z) {
        int i = B + 49;
        C = i % 128;
        int i2 = i % 2;
        nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
        int i3 = B + 93;
        C = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ShopModel access$1100(NearbyMeActivity nearbyMeActivity, ShopModel shopModel) {
        ShopModel NetworkUserEntityData$$ExternalSyntheticLambda02;
        int i = B + 91;
        C = i % 128;
        if ((i % 2 != 0 ? ':' : '\'') != '\'') {
            NetworkUserEntityData$$ExternalSyntheticLambda02 = nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0(shopModel);
            int i2 = 16 / 0;
        } else {
            NetworkUserEntityData$$ExternalSyntheticLambda02 = nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0(shopModel);
        }
        int i3 = B + 57;
        C = i3 % 128;
        if ((i3 % 2 != 0 ? 'Y' : '(') != '(') {
            int i4 = 46 / 0;
            return NetworkUserEntityData$$ExternalSyntheticLambda02;
        }
        return NetworkUserEntityData$$ExternalSyntheticLambda02;
    }

    static /* synthetic */ void access$1200(NearbyMeActivity nearbyMeActivity) {
        int i = C + 19;
        B = i % 128;
        int i2 = i % 2;
        nearbyMeActivity.B();
        int i3 = C + 105;
        B = i3 % 128;
        if ((i3 % 2 == 0 ? 'b' : '=') != '=') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    static /* synthetic */ void access$1300(NearbyMeActivity nearbyMeActivity) {
        try {
            int i = C + 99;
            try {
                B = i % 128;
                boolean z = i % 2 != 0;
                nearbyMeActivity.VerifyPinStateManager$executeRiskChallenge$2$2();
                if (!z) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = B + 53;
                C = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ Showcase access$1402(NearbyMeActivity nearbyMeActivity, Showcase showcase) {
        int i = C + 113;
        B = i % 128;
        if (!(i % 2 == 0)) {
            nearbyMeActivity.SubSequence = showcase;
        } else {
            nearbyMeActivity.SubSequence = showcase;
            Object[] objArr = null;
            int length = objArr.length;
        }
        return showcase;
    }

    static /* synthetic */ void access$1500(NearbyMeActivity nearbyMeActivity) {
        int i = B + 41;
        C = i % 128;
        boolean z = i % 2 != 0;
        nearbyMeActivity.scheduleImpl();
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = C + 87;
        B = i2 % 128;
        int i3 = i2 % 2;
    }

    static /* synthetic */ void access$1600(NearbyMeActivity nearbyMeActivity, Runnable runnable) {
        try {
            int i = B + 31;
            C = i % 128;
            int i2 = i % 2;
            nearbyMeActivity.PlaceComponentResult(runnable);
            int i3 = C + 121;
            B = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$1700(NearbyMeActivity nearbyMeActivity, ShopModel shopModel, Drawable drawable, Location location) {
        int i = C + 105;
        B = i % 128;
        char c = i % 2 == 0 ? (char) 1 : '4';
        nearbyMeActivity.BuiltInFictitiousFunctionClassFactory(shopModel, drawable, location);
        if (c == 1) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = B + 123;
        C = i2 % 128;
        if ((i2 % 2 != 0 ? '\b' : 'c') != 'c') {
            int i3 = 52 / 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$1800(NearbyMeActivity nearbyMeActivity, ShopModel shopModel, Drawable drawable, Location location) {
        int i = C + 41;
        B = i % 128;
        int i2 = i % 2;
        nearbyMeActivity.MyBillsEntityDataFactory(shopModel, drawable, location);
        try {
            int i3 = C + 25;
            B = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$1900(NearbyMeActivity nearbyMeActivity, Drawable drawable, Marker marker) {
        try {
            int i = C + 105;
            B = i % 128;
            int i2 = i % 2;
            nearbyMeActivity.KClassImpl$Data$declaredNonStaticMembers$2(drawable, marker);
            int i3 = B + 7;
            try {
                C = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ String access$200(NearbyMeActivity nearbyMeActivity) {
        try {
            int i = C + 35;
            try {
                B = i % 128;
                int i2 = i % 2;
                String str = nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda3;
                int i3 = C + 61;
                B = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ void access$2000(NearbyMeActivity nearbyMeActivity) {
        try {
            int i = C + 65;
            try {
                B = i % 128;
                int i2 = i % 2;
                nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda6();
                int i3 = C + 9;
                B = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ void access$2100(NearbyMeActivity nearbyMeActivity) {
        int i = B + 47;
        C = i % 128;
        Object obj = null;
        if (i % 2 == 0) {
            nearbyMeActivity.C();
        } else {
            nearbyMeActivity.C();
            obj.hashCode();
        }
        try {
            int i2 = C + 73;
            try {
                B = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    return;
                }
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ boolean access$2202(NearbyMeActivity nearbyMeActivity, boolean z) {
        int i = B + 113;
        C = i % 128;
        int i2 = i % 2;
        nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = z;
        try {
            int i3 = C + 77;
            B = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$2300(NearbyMeActivity nearbyMeActivity) {
        int i = C + 81;
        B = i % 128;
        int i2 = i % 2;
        nearbyMeActivity.PlaceComponentResult();
        int i3 = B + 119;
        C = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 23 / 0;
        }
    }

    static /* synthetic */ void access$2400(NearbyMeActivity nearbyMeActivity) {
        int i = C + 125;
        B = i % 128;
        char c = i % 2 == 0 ? '\'' : '.';
        nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda5();
        if (c != '.') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = B + 111;
        C = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        int i3 = 74 / 0;
    }

    static /* synthetic */ void access$2500(NearbyMeActivity nearbyMeActivity) {
        try {
            int i = B + 97;
            try {
                C = i % 128;
                int i2 = i % 2;
                nearbyMeActivity.KClassImpl$Data$declaredNonStaticMembers$2();
                int i3 = B + 85;
                C = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ boolean access$2600(NearbyMeActivity nearbyMeActivity) {
        boolean z;
        int i = C + 3;
        B = i % 128;
        if (i % 2 == 0) {
            z = nearbyMeActivity.FragmentBottomSheetPaymentSettingBinding;
            int i2 = 42 / 0;
        } else {
            try {
                z = nearbyMeActivity.FragmentBottomSheetPaymentSettingBinding;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = C + 69;
        B = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return z;
        }
        Object obj = null;
        obj.hashCode();
        return z;
    }

    static /* synthetic */ boolean access$2602(NearbyMeActivity nearbyMeActivity, boolean z) {
        int i = C + 1;
        B = i % 128;
        char c = i % 2 == 0 ? ')' : (char) 28;
        nearbyMeActivity.FragmentBottomSheetPaymentSettingBinding = z;
        if (c == ')') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = B + 103;
        C = i2 % 128;
        int i3 = i2 % 2;
        return z;
    }

    static /* synthetic */ Target access$2700(NearbyMeActivity nearbyMeActivity) {
        int i = B + 53;
        C = i % 128;
        int i2 = i % 2;
        Target newProxyInstance = nearbyMeActivity.newProxyInstance();
        int i3 = C + 27;
        B = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 4 / 0;
            return newProxyInstance;
        }
        return newProxyInstance;
    }

    static /* synthetic */ void access$2800(NearbyMeActivity nearbyMeActivity, Target target) {
        try {
            int i = C + 71;
            try {
                B = i % 128;
                int i2 = i % 2;
                nearbyMeActivity.KClassImpl$Data$declaredNonStaticMembers$2(target);
                int i3 = B + 93;
                C = i3 % 128;
                if ((i3 % 2 != 0 ? 'M' : '=') != 'M') {
                    return;
                }
                int i4 = 5 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ boolean access$2900(NearbyMeActivity nearbyMeActivity, float f) {
        boolean BuiltInFictitiousFunctionClassFactory;
        int i = B + 29;
        C = i % 128;
        if ((i % 2 != 0 ? ']' : 'J') != ']') {
            try {
                BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(f);
            } catch (Exception e) {
                throw e;
            }
        } else {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(f);
            int i2 = 95 / 0;
        }
        int i3 = B + 5;
        C = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 89 / 0;
            return BuiltInFictitiousFunctionClassFactory;
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    static /* synthetic */ void access$300(NearbyMeActivity nearbyMeActivity, String str) {
        try {
            int i = C + 73;
            B = i % 128;
            int i2 = i % 2;
            nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0(str);
            int i3 = C + 121;
            B = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$3000(NearbyMeActivity nearbyMeActivity, float f) {
        int i = C + 3;
        B = i % 128;
        int i2 = i % 2;
        nearbyMeActivity.KClassImpl$Data$declaredNonStaticMembers$2(f);
        int i3 = C + 125;
        B = i3 % 128;
        if ((i3 % 2 == 0 ? 'N' : InputCardNumberView.DIVIDER) != 'N') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    static /* synthetic */ List access$400(NearbyMeActivity nearbyMeActivity) {
        int i = C + 57;
        B = i % 128;
        boolean z = i % 2 != 0;
        Object[] objArr = null;
        List<Target> NetworkUserEntityData$$ExternalSyntheticLambda8 = nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda8();
        if (!z) {
            int length = objArr.length;
        }
        int i2 = B + 117;
        C = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return NetworkUserEntityData$$ExternalSyntheticLambda8;
        }
        int length2 = objArr.length;
        return NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    static /* synthetic */ void access$500(NearbyMeActivity nearbyMeActivity, List list) {
        int i = B + 107;
        C = i % 128;
        char c = i % 2 != 0 ? 'J' : '*';
        Object[] objArr = null;
        nearbyMeActivity.BuiltInFictitiousFunctionClassFactory(list);
        if (c == 'J') {
            objArr.hashCode();
        }
        try {
            int i2 = C + 67;
            B = i2 % 128;
            if (i2 % 2 != 0) {
                return;
            }
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$600(NearbyMeActivity nearbyMeActivity, String str) {
        try {
            int i = C + 45;
            try {
                B = i % 128;
                int i2 = i % 2;
                nearbyMeActivity.BuiltInFictitiousFunctionClassFactory(str);
                int i3 = C + 51;
                B = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ String access$700(NearbyMeActivity nearbyMeActivity) {
        int i = B + 89;
        C = i % 128;
        if ((i % 2 != 0 ? '8' : (char) 15) != '8') {
            return nearbyMeActivity.getShownErrorMessage();
        }
        try {
            int i2 = 22 / 0;
            return nearbyMeActivity.getShownErrorMessage();
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ boolean access$800(NearbyMeActivity nearbyMeActivity) {
        int i = C + 93;
        B = i % 128;
        int i2 = i % 2;
        boolean z = nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int i3 = C + 91;
        B = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    static /* synthetic */ boolean access$802(NearbyMeActivity nearbyMeActivity, boolean z) {
        int i = B + 49;
        C = i % 128;
        int i2 = i % 2;
        nearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = z;
        int i3 = B + 101;
        C = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 25 : 'N') != 25) {
            return z;
        }
        int i4 = 76 / 0;
        return z;
    }

    static /* synthetic */ void access$900(NearbyMeActivity nearbyMeActivity) {
        int i = B + 31;
        C = i % 128;
        if ((i % 2 != 0 ? '3' : '1') != '3') {
            nearbyMeActivity.F();
            return;
        }
        nearbyMeActivity.F();
        int i2 = 82 / 0;
    }

    static {
        B = 1;
        BuiltInFictitiousFunctionClassFactory();
        getAuthRequestContext = new byte[]{122, TarHeader.LF_CONTIG, -29, -99, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        PlaceComponentResult = 183;
        getAuthRequestContext();
        NetworkUserEntityData$$ExternalSyntheticLambda0 = SizeUtil.getAuthRequestContext(95);
        getErrorConfigVersion = SizeUtil.getAuthRequestContext(9);
        int i = C + 31;
        B = i % 128;
        if ((i % 2 == 0 ? JSONLexer.EOI : 'Q') != 26) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        int i = C + 101;
        B = i % 128;
        if (i % 2 != 0) {
            setCenterTitle(getString(R.string.nearby_me_title));
        } else {
            setCenterTitle(getString(R.string.nearby_me_title));
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = C + 91;
        B = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if ((r0 != null) != true) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        r0.getMapAsync(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
    
        if (r0 != null) goto L18;
     */
    @Override // id.dana.base.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init() {
        /*
            r5 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 85
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 2131365445(0x7f0a0e45, float:1.8350756E38)
            r4 = 2131232241(0x7f0805f1, float:1.8080586E38)
            if (r0 == 0) goto L2f
            r5.NetworkUserEntityData$$ExternalSyntheticLambda4()
            r5.lookAheadTest()
            r5.setMenuLeftButton(r4)
            androidx.fragment.app.FragmentManager r0 = r5.getSupportFragmentManager()
            androidx.fragment.app.Fragment r0 = r0.findFragmentById(r3)
            com.google.android.gms.maps.SupportMapFragment r0 = (com.google.android.gms.maps.SupportMapFragment) r0
            if (r0 == 0) goto L51
            goto L4e
        L2f:
            r5.NetworkUserEntityData$$ExternalSyntheticLambda4()
            r5.lookAheadTest()
            r5.setMenuLeftButton(r4)
            androidx.fragment.app.FragmentManager r0 = r5.getSupportFragmentManager()
            androidx.fragment.app.Fragment r0 = r0.findFragmentById(r3)
            com.google.android.gms.maps.SupportMapFragment r0 = (com.google.android.gms.maps.SupportMapFragment) r0
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L4a
            r3 = 1
            goto L4b
        L4a:
            r3 = 0
        L4b:
            if (r3 == r2) goto L4e
            goto L51
        L4e:
            r0.getMapAsync(r5)
        L51:
            r0 = 2130772048(0x7f010050, float:1.7147203E38)
            android.view.animation.Animation r0 = android.view.animation.AnimationUtils.loadAnimation(r5, r0)
            r5.NetworkUserEntityData$$ExternalSyntheticLambda6 = r0
            android.view.animation.LinearInterpolator r2 = new android.view.animation.LinearInterpolator
            r2.<init>()
            r0.setInterpolator(r2)
            r5.E()
            r5.VerifyPinStateManager$executeRiskChallenge$2$2()
            r5.I()
            r5.G()
            r5.getCallingPid()
            id.dana.contract.nearbyme.NearbyMeContract$Presenter r0 = r5.presenter
            r0.BuiltInFictitiousFunctionClassFactory(r1)
            id.dana.contract.nearbyme.NearbyMeContract$Presenter r0 = r5.presenter
            r0.getAuthRequestContext()
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 97
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r1
            int r0 = r0 % 2
            return
        L86:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.init():void");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        int i = B + 107;
        C = i % 128;
        int i2 = i % 2;
        super.onAttachedToWindow();
        getSupportButtonTintMode();
        int i3 = B + 83;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                int i = C + 83;
                B = i % 128;
                int i2 = i % 2;
                MyBillsEntityDataFactory(motionEvent);
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            int i3 = B + 75;
            try {
                C = i3 % 128;
                int i4 = i3 % 2;
                return dispatchTouchEvent;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void MyBillsEntityDataFactory(MotionEvent motionEvent) {
        View currentFocus = getCurrentFocus();
        if (currentFocus instanceof EditText) {
            Rect rect = new Rect();
            currentFocus.getGlobalVisibleRect(rect);
            if (!(rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()))) {
                int i = C + 15;
                B = i % 128;
                if ((i % 2 != 0 ? ':' : (char) 15) != ':') {
                    currentFocus.clearFocus();
                    ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 1);
                } else {
                    try {
                        currentFocus.clearFocus();
                        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        }
        int i2 = C + 9;
        B = i2 % 128;
        int i3 = i2 % 2;
    }

    private void getSupportButtonTintMode() {
        int i = C + 109;
        B = i % 128;
        int i2 = i % 2;
        getValueOfTouchPositionAbsolute();
        this.presenter.getErrorConfigVersion();
        int i3 = B + 3;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    private void getValueOfTouchPositionAbsolute() {
        int i = B + 9;
        C = i % 128;
        int i2 = i % 2;
        ViewGroup.LayoutParams layoutParams = this.viewTooltipSpotlightContainer.getLayoutParams();
        int PlaceComponentResult2 = (int) SizeUtil.PlaceComponentResult(this);
        int authRequestContext = (PlaceComponentResult2 - SizeUtil.getAuthRequestContext(211)) - ((int) (PlaceComponentResult2 * 0.275f));
        layoutParams.height = authRequestContext;
        this.viewTooltipSpotlightContainer.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.viewTooltipSpotlightPointer.getLayoutParams();
        layoutParams2.height = authRequestContext + SizeUtil.getAuthRequestContext(110);
        this.viewTooltipSpotlightPointer.setLayoutParams(layoutParams2);
        try {
            int i3 = B + 121;
            try {
                C = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void G() {
        this.nearbyMerchantLocationSearchView.setLocationListener(new NearbyMerchantLocationSearchView.Listener() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda12
            @Override // id.dana.nearbyme.NearbyMerchantLocationSearchView.Listener
            public final void PlaceComponentResult(Location location) {
                NearbyMeActivity.this.m2713xdee28682(location);
            }
        });
        this.nearbyMerchantLocationSearchView.setOnHomeShoppingClickListener(BuiltInFictitiousFunctionClassFactory(new Function1() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NearbyMeActivity.this.m2714x45bb4643((Integer) obj);
            }
        }));
        this.nearbyMerchantLocationSearchView.setMerchantListener(KClassImpl$Data$declaredNonStaticMembers$2(new Function1() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NearbyMeActivity.this.m2715xac940604((Integer) obj);
            }
        }));
        this.nearbyMerchantLocationSearchView.setOnOtherStoreButtonClickListener(MyBillsEntityDataFactory(new Function1() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NearbyMeActivity.this.m2716x136cc5c5((Integer) obj);
            }
        }));
        this.nearbyMerchantLocationSearchView.setOnTopUpButtonClickListener(NetworkUserEntityData$$ExternalSyntheticLambda7());
        this.nearbyMerchantLocationSearchView.setOnPromoRibbonClickListener(DatabaseTableConfigUtil());
        int i = B + 7;
        C = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupNearbyMerchantLocationSearchView$0$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ void m2713xdee28682(Location location) {
        int i = B + 11;
        C = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        showShimmerNearbyLocation();
        MapHelper mapHelper = this.mapHelper;
        LatLng authRequestContext = LocationUtil.getAuthRequestContext(location);
        GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((googleMap != null ? '%' : '?') == '%') {
            try {
                int i3 = B + 13;
                try {
                    C = i3 % 128;
                    int i4 = i3 % 2;
                    googleMap.animateCamera(MapHelper.getAuthRequestContext(authRequestContext, 15.0f));
                    int i5 = C + 25;
                    B = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        MyBillsEntityDataFactory(location);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupNearbyMerchantLocationSearchView$1$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ ShopModel m2714x45bb4643(Integer num) {
        try {
            int i = B + 37;
            C = i % 128;
            int i2 = i % 2;
            ShopModel searchedMerchantByPosition = this.nearbyMerchantLocationSearchView.getSearchedMerchantByPosition(num.intValue());
            int i3 = C + 99;
            B = i3 % 128;
            int i4 = i3 % 2;
            return searchedMerchantByPosition;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupNearbyMerchantLocationSearchView$2$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ ShopModel m2715xac940604(Integer num) {
        int i = B + 113;
        C = i % 128;
        if ((i % 2 != 0 ? (char) 3 : 'K') != 3) {
            return this.nearbyMerchantLocationSearchView.getSearchedMerchantByPosition(num.intValue());
        }
        ShopModel searchedMerchantByPosition = this.nearbyMerchantLocationSearchView.getSearchedMerchantByPosition(num.intValue());
        Object obj = null;
        obj.hashCode();
        return searchedMerchantByPosition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupNearbyMerchantLocationSearchView$3$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ ShopModel m2716x136cc5c5(Integer num) {
        int i = C + 115;
        B = i % 128;
        int i2 = i % 2;
        ShopModel searchedMerchantByPosition = this.nearbyMerchantLocationSearchView.getSearchedMerchantByPosition(num.intValue());
        int i3 = B + 31;
        C = i3 % 128;
        int i4 = i3 % 2;
        return searchedMerchantByPosition;
    }

    private void getCallingPid() {
        Bundle extras = getIntent().getExtras();
        if ((extras != null ? ',' : '*') != ',') {
            return;
        }
        int i = B + 39;
        C = i % 128;
        if (i % 2 == 0) {
            if (!(TextUtils.isEmpty(extras.getString("EXTRA_SHOP_ID", "")))) {
                return;
            }
        } else {
            boolean isEmpty = TextUtils.isEmpty(extras.getString("EXTRA_SHOP_ID", ""));
            Object obj = null;
            obj.hashCode();
            if (!isEmpty) {
                return;
            }
        }
        try {
            getErrorConfigVersion(getAuthRequestContext(EXTRA_SEARCH_KEYWORD));
            this.presenter.PlaceComponentResult(getAuthRequestContext("EXTRA_MERCHANT_ID"));
            KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext(EXTRA_CATEGORY));
            double d = extras.getDouble(EXTRA_LOCATION_LAT);
            double d2 = extras.getDouble(EXTRA_LOCATION_LON);
            if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                int i2 = B + 101;
                C = i2 % 128;
                if (i2 % 2 != 0) {
                    if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return;
                    }
                } else if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return;
                }
                this.getSupportButtonTintMode = LocationUtil.PlaceComponentResult(d, d2);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void I() {
        this.presenter.PlaceComponentResult((Observable<String>) RxTextView.textChanges(this.etNearbySearch).doOnNext(new Consumer() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NearbyMeActivity.$r8$lambda$wcnxgFTfZXxsF4QiS2du6XSnkbc(NearbyMeActivity.this, (CharSequence) obj);
            }
        }).debounce(500L, TimeUnit.MILLISECONDS).map(new Function() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeActivity.lambda$setupSearchListener$4((CharSequence) obj);
            }
        }));
        int i = C + 17;
        B = i % 128;
        if ((i % 2 == 0 ? (char) 20 : (char) 25) != 25) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$setupSearchListener$4(CharSequence charSequence) throws Exception {
        int i = B + 103;
        C = i % 128;
        int i2 = i % 2;
        String trim = charSequence.toString().toLowerCase().trim();
        try {
            int i3 = C + 25;
            B = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 5 : 'K') != 5) {
                return trim;
            }
            Object obj = null;
            obj.hashCode();
            return trim;
        } catch (Exception e) {
            throw e;
        }
    }

    private void moveToNextValue(String str) {
        try {
            int i = C + 83;
            B = i % 128;
            if ((i % 2 == 0 ? Typography.greater : 'Y') == 'Y') {
                this.nearbyAnalyticTracker.getAuthRequestContext(str, "");
                return;
            }
            try {
                this.nearbyAnalyticTracker.getAuthRequestContext(str, "");
                int i2 = 39 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r5) ? '^' : '7') != '7') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        r0 = id.dana.nearbyme.NearbyMeActivity.C + 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        id.dana.nearbyme.NearbyMeActivity.B = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        if ((r0 % 2) != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        moveToNextValue(r5.toString());
        r4.ivClear.setVisibility(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        moveToNextValue(r5.toString());
        r4.ivClear.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r4.scheduleImpl);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        r4.ivClear.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getAuthRequestContext(java.lang.CharSequence r5) {
        /*
            r4 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 95
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L1f
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r3 = 25
            int r3 = r3 / r1
            if (r0 != 0) goto L5b
            goto L2e
        L1d:
            r5 = move-exception
            throw r5
        L1f:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r3 = 55
            if (r0 != 0) goto L2a
            r0 = 94
            goto L2c
        L2a:
            r0 = 55
        L2c:
            if (r0 == r3) goto L5b
        L2e:
            int r0 = id.dana.nearbyme.NearbyMeActivity.C     // Catch: java.lang.Exception -> L59
            int r0 = r0 + 9
            int r3 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r3     // Catch: java.lang.Exception -> L59
            int r0 = r0 % 2
            if (r0 != 0) goto L47
            java.lang.String r5 = r5.toString()
            r4.moveToNextValue(r5)
            android.widget.ImageView r5 = r4.ivClear
            r5.setVisibility(r2)
            goto L53
        L47:
            java.lang.String r5 = r5.toString()
            r4.moveToNextValue(r5)
            android.widget.ImageView r5 = r4.ivClear
            r5.setVisibility(r1)
        L53:
            com.google.android.material.bottomsheet.BottomSheetBehavior r5 = r4.scheduleImpl
            BuiltInFictitiousFunctionClassFactory(r5)
            return
        L59:
            r5 = move-exception
            throw r5
        L5b:
            android.widget.ImageView r5 = r4.ivClear
            r0 = 8
            r5.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.getAuthRequestContext(java.lang.CharSequence):void");
    }

    private void getErrorConfigVersion(String str) {
        if ((!TextUtils.isEmpty(str) ? '-' : '+') == '-') {
            int i = B + 39;
            C = i % 128;
            if (i % 2 != 0) {
                this.etNearbySearch.setText(str);
                this.scheduleImpl.setState(5);
                this.clLocationContainer.setVisibility(30);
                this.tvDistrictLocation.setVisibility(0);
                this.tvChangeLocation.setVisibility(1);
                PlaceComponentResult();
                hideShimmerNearbyLocation();
            } else {
                try {
                    this.etNearbySearch.setText(str);
                    this.scheduleImpl.setState(3);
                    this.clLocationContainer.setVisibility(8);
                    this.tvDistrictLocation.setVisibility(0);
                    this.tvChangeLocation.setVisibility(0);
                    PlaceComponentResult();
                    hideShimmerNearbyLocation();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        int i2 = C + 105;
        B = i2 % 128;
        if (i2 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = C + 115;
        B = i % 128;
        int i2 = i % 2;
        if (!(this.merchantListView == null)) {
            if ((!TextUtils.isEmpty(str) ? 'a' : (char) 7) != 'a') {
                return;
            }
            this.merchantListView.setPreSelectedCategoryId(str);
            MerchantCategoryModel cateoriesById = this.merchantListView.getCateoriesById(str);
            if (cateoriesById != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(cateoriesById);
                this.presenter.getAuthRequestContext(arrayList);
            }
            if ((MerchantViewType.MERCHANT_CAT_TOP_UP_AGENT.equals(str) ? '7' : '6') != '7') {
                return;
            }
            int i3 = B + 99;
            C = i3 % 128;
            if (i3 % 2 == 0) {
                this.merchantListView.forceHideCategory();
                return;
            }
            this.merchantListView.forceHideCategory();
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public void showPromoBottomSheet(List<PromoInfoModel> list) {
        PromoListDialogFragment promoListDialogFragment = new PromoListDialogFragment(this);
        try {
            promoListDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2 = list;
            promoListDialogFragment.show(getSupportFragmentManager(), "Show Nearby Promo List Dialog");
            int i = C + 83;
            B = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private MerchantListAdapter.OnHomeShoppingClickListener BuiltInFictitiousFunctionClassFactory(final Function1<Integer, ShopModel> function1) {
        MerchantListAdapter.OnHomeShoppingClickListener onHomeShoppingClickListener = new MerchantListAdapter.OnHomeShoppingClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda8
            @Override // id.dana.nearbyme.adapter.MerchantListAdapter.OnHomeShoppingClickListener
            public final void getAuthRequestContext(int i) {
                NearbyMeActivity.this.m2702xf63ca05b(function1, i);
            }
        };
        int i = C + 49;
        B = i % 128;
        int i2 = i % 2;
        return onHomeShoppingClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getOnHomeShoppingClickListener$5$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ void m2702xf63ca05b(Function1 function1, int i) {
        ShopModel shopModel = (ShopModel) function1.invoke(Integer.valueOf(i));
        this.nearbyAnalyticTracker.MyBillsEntityDataFactory(shopModel, TrackerKey.SourceType.NEARBY_ME_LIST);
        HomeShoppingDialogFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(getSupportFragmentManager(), new MerchantDetailViewState(shopModel, TrackerKey.SourceType.SHOP_LIST));
        int i2 = B + 25;
        C = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private MerchantListAdapter.OnTopUpButtonClickListener NetworkUserEntityData$$ExternalSyntheticLambda7() {
        MerchantListAdapter.OnTopUpButtonClickListener onTopUpButtonClickListener = new MerchantListAdapter.OnTopUpButtonClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda16
            @Override // id.dana.nearbyme.adapter.MerchantListAdapter.OnTopUpButtonClickListener
            public final void MyBillsEntityDataFactory(String str) {
                NearbyMeActivity.this.m2706x9cd0a171(str);
            }
        };
        try {
            int i = C + 15;
            B = i % 128;
            if (i % 2 == 0) {
                int i2 = 64 / 0;
                return onTopUpButtonClickListener;
            }
            return onTopUpButtonClickListener;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getOnTopUpButtonClickListener$6$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ void m2706x9cd0a171(String str) {
        int i = B + 41;
        C = i % 128;
        int i2 = i % 2;
        DanaH5.startContainerFullUrl(PlaceComponentResult(str));
        try {
            int i3 = C + 107;
            try {
                B = i3 % 128;
                if ((i3 % 2 == 0 ? Typography.greater : 'A') != 'A') {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String PlaceComponentResult(String str) {
        String MyBillsEntityDataFactory;
        int i = B + 123;
        C = i % 128;
        if ((i % 2 != 0 ? '`' : '0') != '`') {
            MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory("https://m.dana.id/m/portal/topup?entryPoint={entryPoint}&payMethod=OTC&instId={instId}&fromSKW=true").MyBillsEntityDataFactory("instId", str).MyBillsEntityDataFactory("entryPoint", TopupSource.NEARBY).MyBillsEntityDataFactory();
        } else {
            MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory("https://m.dana.id/m/portal/topup?entryPoint={entryPoint}&payMethod=OTC&instId={instId}&fromSKW=true").MyBillsEntityDataFactory("instId", str).MyBillsEntityDataFactory("entryPoint", TopupSource.NEARBY).MyBillsEntityDataFactory();
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = C + 119;
        B = i2 % 128;
        if (!(i2 % 2 != 0)) {
            int i3 = 6 / 0;
            return MyBillsEntityDataFactory;
        }
        return MyBillsEntityDataFactory;
    }

    private MerchantListAdapter.OnMerchantListClickListener KClassImpl$Data$declaredNonStaticMembers$2(final Function1<Integer, ShopModel> function1) {
        MerchantListAdapter.OnMerchantListClickListener onMerchantListClickListener = new MerchantListAdapter.OnMerchantListClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda0
            @Override // id.dana.nearbyme.adapter.MerchantListAdapter.OnMerchantListClickListener
            public final void PlaceComponentResult(int i) {
                NearbyMeActivity.this.m2703x560f579c(function1, i);
            }
        };
        int i = C + 99;
        B = i % 128;
        int i2 = i % 2;
        return onMerchantListClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getOnMerchantClickListener$7$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ void m2703x560f579c(Function1 function1, int i) {
        int i2 = B + 125;
        C = i2 % 128;
        int i3 = i2 % 2;
        BuiltInFictitiousFunctionClassFactory((ShopModel) function1.invoke(Integer.valueOf(i)));
        int i4 = C + 99;
        B = i4 % 128;
        if ((i4 % 2 == 0 ? '8' : 'R') != 'R') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        float f2 = 0.0f;
        if (f < 1.0f) {
            int i = B + 73;
            C = i % 128;
            int i2 = i % 2;
            if (f >= 0.0f) {
                f2 = (1.0f - f) * SizeUtil.getAuthRequestContext(16);
            }
        }
        CardView cardView = this.cvMerchant;
        if ((cardView != null ? '6' : '_') != '_') {
            try {
                int i3 = C + 61;
                B = i3 % 128;
                if (i3 % 2 == 0) {
                    cardView.setRadius(f2);
                    this.cvMerchant.requestLayout();
                    Object obj = null;
                    obj.hashCode();
                } else {
                    cardView.setRadius(f2);
                    this.cvMerchant.requestLayout();
                }
                int i4 = B + 49;
                C = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.nearbyme.NearbyMeActivity$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements NearbyMeContract.View {
        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
            NearbyMeContract.View.CC.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(boolean z) {
            NearbyMeContract.View.CC.getAuthRequestContext();
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final /* synthetic */ void MyBillsEntityDataFactory(List list) {
            NearbyMeContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final /* synthetic */ void MyBillsEntityDataFactory(List list, boolean z) {
            NearbyMeContract.View.CC.PlaceComponentResult();
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
            NearbyMeContract.View.CC.scheduleImpl();
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final /* synthetic */ String PlaceComponentResult() {
            return NearbyMeContract.View.CC.MyBillsEntityDataFactory();
        }

        @Override // id.dana.base.AbstractContract.AbstractView
        public void dismissProgress() {
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final String getAuthRequestContext() {
            return NewNearbyMeView.SOURCE;
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final /* synthetic */ void getAuthRequestContext(Account account) {
            NearbyMeContract.View.CC.getErrorConfigVersion();
        }

        AnonymousClass1() {
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final void BuiltInFictitiousFunctionClassFactory(List<ShopModel> list) {
            NearbyMeActivity.access$000(NearbyMeActivity.this);
            NearbyMeActivity.access$100(NearbyMeActivity.this, list);
            if (!"ERROR".equals(NearbyMeActivity.access$200(NearbyMeActivity.this))) {
                NearbyMeActivity.access$300(NearbyMeActivity.this, RefreshCondition.FETCHED);
            }
            NearbyMeActivity.this.nearbyMerchantLocationSearchView.setShopModels(list);
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final void PlaceComponentResult(List<ShopModel> list) {
            MerchantListView merchantListView = NearbyMeActivity.this.merchantListView;
            final NearbyMeActivity nearbyMeActivity = NearbyMeActivity.this;
            merchantListView.updateShopModelsWithPromo(list, new Function1() { // from class: id.dana.nearbyme.NearbyMeActivity$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    ShopModel access$1100;
                    access$1100 = NearbyMeActivity.access$1100(NearbyMeActivity.this, (ShopModel) obj);
                    return access$1100;
                }
            });
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final void getAuthRequestContext(boolean z) {
            if (z) {
                NearbyMeActivity nearbyMeActivity = NearbyMeActivity.this;
                NearbyMeActivity.access$500(nearbyMeActivity, NearbyMeActivity.access$400(nearbyMeActivity));
            }
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final void PlaceComponentResult(String str) {
            NearbyMeActivity.this.hideShimmerNearbyLocation();
            NearbyMeActivity.access$600(NearbyMeActivity.this, str);
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final void BuiltInFictitiousFunctionClassFactory(IntentSender intentSender) {
            LocationUtil.MyBillsEntityDataFactory(NearbyMeActivity.this, intentSender);
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final void MyBillsEntityDataFactory() {
            Utils.PlaceComponentResult(NearbyMeActivity.this);
        }

        @Override // id.dana.contract.nearbyme.NearbyMeContract.View
        public final String KClassImpl$Data$declaredNonStaticMembers$2() {
            return NearbyMeActivity.access$700(NearbyMeActivity.this);
        }

        @Override // id.dana.base.AbstractContract.AbstractView
        public void showProgress() {
            if (!NearbyMeActivity.access$800(NearbyMeActivity.this)) {
                NearbyMeActivity.access$900(NearbyMeActivity.this);
            } else {
                NearbyMeActivity.this.merchantListView.hideShimmerMerchantList();
            }
            NearbyMeActivity.access$1002(NearbyMeActivity.this, true);
        }

        @Override // id.dana.base.AbstractContract.AbstractView
        public void onError(String str) {
            NearbyMeActivity.this.merchantListView.setMerchantList(new ArrayList());
            NearbyMeActivity.access$300(NearbyMeActivity.this, "ERROR");
            NearbyMeActivity.access$000(NearbyMeActivity.this);
        }
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        DaggerNearbyMeComponent.Builder authRequestContext = DaggerNearbyMeComponent.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (NearbyMeModule) Preconditions.getAuthRequestContext(new NearbyMeModule(new AnonymousClass1()));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, NearbyMeModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerNearbyMeComponent.NearbyMeComponentImpl(authRequestContext.BuiltInFictitiousFunctionClassFactory, authRequestContext.MyBillsEntityDataFactory, (byte) 0).getAuthRequestContext(this);
        registerPresenter(this.presenter);
        int i = B + 7;
        C = i % 128;
        int i2 = i % 2;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        if ((this.NetworkUserEntityData$$ExternalSyntheticLambda2 ? 'C' : 'W') == 'C') {
            try {
                int i = C + 119;
                try {
                    B = i % 128;
                    if ((i % 2 == 0 ? '?' : '7') != '7') {
                        this.merchantListView.hideShimmerMerchantList();
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                    } else {
                        this.merchantListView.hideShimmerMerchantList();
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i2 = C + 97;
        B = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if ((r2.presenter.PlaceComponentResult() == null ? 'J' : kotlin.text.Typography.amp) != '&') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r2.presenter.MyBillsEntityDataFactory(r3);
        getAuthRequestContext(r3);
        KClassImpl$Data$declaredNonStaticMembers$2(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r2.presenter.KClassImpl$Data$declaredNonStaticMembers$2(r3);
        getAuthRequestContext(r3);
        r0 = r2.presenter;
        KClassImpl$Data$declaredNonStaticMembers$2(r0.PlaceComponentResult(r3, r0.PlaceComponentResult()));
        r0 = null;
        r2.presenter.PlaceComponentResult((java.lang.String) null);
        VerifyPinStateManager$executeRiskChallenge$2$1();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        r3 = id.dana.nearbyme.NearbyMeActivity.B + 15;
        id.dana.nearbyme.NearbyMeActivity.C = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        if ((r3 % 2) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        r0.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        if (r2.presenter.PlaceComponentResult() == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void MyBillsEntityDataFactory(java.util.List<id.dana.nearbyme.model.ShopModel> r3) {
        /*
            r2 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            r1 = 48
            if (r0 == 0) goto L11
            r0 = 45
            goto L13
        L11:
            r0 = 48
        L13:
            if (r0 == r1) goto L24
            id.dana.contract.nearbyme.NearbyMeContract$Presenter r0 = r2.presenter
            java.lang.String r0 = r0.PlaceComponentResult()
            r1 = 83
            int r1 = r1 / 0
            if (r0 != 0) goto L41
            goto L35
        L22:
            r3 = move-exception
            throw r3
        L24:
            id.dana.contract.nearbyme.NearbyMeContract$Presenter r0 = r2.presenter
            java.lang.String r0 = r0.PlaceComponentResult()
            r1 = 38
            if (r0 != 0) goto L31
            r0 = 74
            goto L33
        L31:
            r0 = 38
        L33:
            if (r0 == r1) goto L41
        L35:
            id.dana.contract.nearbyme.NearbyMeContract$Presenter r0 = r2.presenter
            r0.MyBillsEntityDataFactory(r3)
            r2.getAuthRequestContext(r3)
            r2.KClassImpl$Data$declaredNonStaticMembers$2(r3)
            return
        L41:
            id.dana.contract.nearbyme.NearbyMeContract$Presenter r0 = r2.presenter     // Catch: java.lang.Exception -> L72
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r3)     // Catch: java.lang.Exception -> L72
            r2.getAuthRequestContext(r3)     // Catch: java.lang.Exception -> L72
            id.dana.contract.nearbyme.NearbyMeContract$Presenter r0 = r2.presenter     // Catch: java.lang.Exception -> L72
            java.lang.String r1 = r0.PlaceComponentResult()     // Catch: java.lang.Exception -> L72
            java.util.List r3 = r0.PlaceComponentResult(r3, r1)     // Catch: java.lang.Exception -> L72
            r2.KClassImpl$Data$declaredNonStaticMembers$2(r3)     // Catch: java.lang.Exception -> L72
            id.dana.contract.nearbyme.NearbyMeContract$Presenter r3 = r2.presenter     // Catch: java.lang.Exception -> L72
            r0 = 0
            r3.PlaceComponentResult(r0)     // Catch: java.lang.Exception -> L72
            r2.VerifyPinStateManager$executeRiskChallenge$2$1()     // Catch: java.lang.Exception -> L72
            int r3 = id.dana.nearbyme.NearbyMeActivity.B
            int r3 = r3 + 15
            int r1 = r3 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r3 = r3 % 2
            if (r3 == 0) goto L71
            r0.hashCode()     // Catch: java.lang.Throwable -> L6f
            return
        L6f:
            r3 = move-exception
            throw r3
        L71:
            return
        L72:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.MyBillsEntityDataFactory(java.util.List):void");
    }

    private void VerifyPinStateManager$executeRiskChallenge$2$1() {
        this.scheduleImpl.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.nearbyme.NearbyMeActivity.2
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View view, float f) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View view, int i) {
                if (i == 4) {
                    NearbyMeActivity.this.etNearbySearch.getText().clear();
                    NearbyMeActivity.access$1200(NearbyMeActivity.this);
                    NearbyMeActivity.access$1300(NearbyMeActivity.this);
                }
            }
        });
        int i = C + 83;
        B = i % 128;
        if (i % 2 != 0) {
            return;
        }
        int i2 = 40 / 0;
    }

    private void B() {
        int i = C + 57;
        B = i % 128;
        int i2 = i % 2;
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (!(supportMapFragment == null)) {
            supportMapFragment.getMapAsync(this);
            int i3 = B + 5;
            C = i3 % 128;
            int i4 = i3 % 2;
        }
        I();
    }

    private void getAuthRequestContext(List<ShopModel> list) {
        int i = C + 17;
        B = i % 128;
        int i2 = i % 2;
        PlaceComponentResult(list);
        try {
            int i3 = B + 21;
            C = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(List<Target> list) {
        int i = B + 103;
        C = i % 128;
        int i2 = i % 2;
        if ((!list.isEmpty() ? (char) 22 : (char) 29) != 29) {
            int i3 = B + 51;
            C = i3 % 128;
            if (i3 % 2 != 0) {
                Showcase showcase = this.SubSequence;
                Object obj = null;
                obj.hashCode();
                if (showcase != null) {
                    return;
                }
            } else if (this.SubSequence != null) {
                return;
            }
            PagerShowcaseBuilder pagerShowcaseBuilder = new PagerShowcaseBuilder(this);
            try {
                pagerShowcaseBuilder.GetContactSyncConfig = list;
                this.SubSequence = pagerShowcaseBuilder.BuiltInFictitiousFunctionClassFactory(false).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.nearbyme.NearbyMeActivity.3
                    @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
                    public void onFinished(int i4) {
                        NearbyMeActivity.access$1402(NearbyMeActivity.this, null);
                        NearbyMeActivity.this.presenter.initRecordTimeStamp();
                        NearbyMeActivity.access$1500(NearbyMeActivity.this);
                    }
                }).PlaceComponentResult();
                int i4 = B + 33;
                C = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private void scheduleImpl() {
        try {
            if (!this.etNearbySearch.getText().toString().isEmpty()) {
                int i = B + 69;
                C = i % 128;
                int i2 = i % 2;
                this.scheduleImpl.setState(3);
                PlaceComponentResult();
                try {
                    int i3 = B + 65;
                    C = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.nearbyme.NearbyMeActivity$4  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass4 implements RequestListener<Drawable> {
        final /* synthetic */ ShopModel BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Location getAuthRequestContext;

        AnonymousClass4(ShopModel shopModel, Location location) {
            this.BuiltInFictitiousFunctionClassFactory = shopModel;
            this.getAuthRequestContext = location;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, com.bumptech.glide.request.target.Target<Drawable> target, DataSource dataSource, boolean z) {
            return KClassImpl$Data$declaredNonStaticMembers$2(drawable);
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, com.bumptech.glide.request.target.Target<Drawable> target, boolean z) {
            NearbyMeActivity nearbyMeActivity = NearbyMeActivity.this;
            final ShopModel shopModel = this.BuiltInFictitiousFunctionClassFactory;
            final Location location = this.getAuthRequestContext;
            NearbyMeActivity.access$1600(nearbyMeActivity, new Runnable() { // from class: id.dana.nearbyme.NearbyMeActivity$4$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Drawable BuiltInFictitiousFunctionClassFactory;
                    NearbyMeActivity.AnonymousClass4 anonymousClass4 = NearbyMeActivity.AnonymousClass4.this;
                    ShopModel shopModel2 = shopModel;
                    Location location2 = location;
                    NearbyMeActivity nearbyMeActivity2 = NearbyMeActivity.this;
                    BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(nearbyMeActivity2, R.drawable.ic_dana_bisnis);
                    NearbyMeActivity.access$1700(nearbyMeActivity2, shopModel2, BuiltInFictitiousFunctionClassFactory, location2);
                }
            });
            return false;
        }

        private boolean KClassImpl$Data$declaredNonStaticMembers$2(final Drawable drawable) {
            NearbyMeActivity nearbyMeActivity = NearbyMeActivity.this;
            final ShopModel shopModel = this.BuiltInFictitiousFunctionClassFactory;
            final Location location = this.getAuthRequestContext;
            NearbyMeActivity.access$1600(nearbyMeActivity, new Runnable() { // from class: id.dana.nearbyme.NearbyMeActivity$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NearbyMeActivity.AnonymousClass4 anonymousClass4 = NearbyMeActivity.AnonymousClass4.this;
                    NearbyMeActivity.access$1700(NearbyMeActivity.this, shopModel, drawable, location);
                }
            });
            return true;
        }
    }

    private void F() {
        try {
            int i = C + 19;
            try {
                B = i % 128;
                int i2 = i % 2;
                this.merchantListView.showShimmerMerchantList();
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
                int i3 = C + 75;
                B = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private String getAuthRequestContext(String str) {
        String stringExtra;
        int i = C + 77;
        B = i % 128;
        Object obj = null;
        if (i % 2 != 0) {
            stringExtra = getIntent().getStringExtra(str);
            getIntent().removeExtra(str);
        } else {
            try {
                stringExtra = getIntent().getStringExtra(str);
                try {
                    getIntent().removeExtra(str);
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i2 = C + 37;
        B = i2 % 128;
        if ((i2 % 2 == 0 ? '+' : (char) 5) != 5) {
            obj.hashCode();
            return stringExtra;
        }
        return stringExtra;
    }

    private void PlaceComponentResult(List<ShopModel> list) {
        int i;
        int i2 = C + 19;
        B = i2 % 128;
        if (i2 % 2 == 0) {
            NetworkUserEntityData$$ExternalSyntheticLambda0();
            this.getCallingPid.clear();
            i = 1;
        } else {
            NetworkUserEntityData$$ExternalSyntheticLambda0();
            this.getCallingPid.clear();
            i = 0;
        }
        while (true) {
            if (i >= list.size()) {
                return;
            }
            ShopModel shopModel = list.get(i);
            if ((i < 3 ? (char) 22 : 'c') == 22) {
                try {
                    int i3 = C + 3;
                    try {
                        B = i3 % 128;
                        if (!(i3 % 2 != 0)) {
                            this.getCallingPid.add(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1);
                            Object obj = null;
                            obj.hashCode();
                        } else {
                            this.getCallingPid.add(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1);
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            KClassImpl$Data$declaredNonStaticMembers$2(shopModel, LocationUtil.PlaceComponentResult(shopModel.DatabaseTableConfigUtil, shopModel.PrepareContext));
            i++;
        }
    }

    private MerchantListAdapter.OnOtherStoreButtonClickListener MyBillsEntityDataFactory(final Function1<Integer, ShopModel> function1) {
        MerchantListAdapter.OnOtherStoreButtonClickListener onOtherStoreButtonClickListener = new MerchantListAdapter.OnOtherStoreButtonClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda4
            @Override // id.dana.nearbyme.adapter.MerchantListAdapter.OnOtherStoreButtonClickListener
            public final void PlaceComponentResult(int i) {
                NearbyMeActivity.this.m2704xc5cc4c42(function1, i);
            }
        };
        int i = B + 89;
        C = i % 128;
        int i2 = i % 2;
        return onOtherStoreButtonClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getOnOtherStoreButtonClickListener$8$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ void m2704xc5cc4c42(Function1 function1, int i) {
        int i2 = C + 105;
        B = i2 % 128;
        if (i2 % 2 != 0) {
            PlaceComponentResult((ShopModel) function1.invoke(Integer.valueOf(i)));
        } else {
            PlaceComponentResult((ShopModel) function1.invoke(Integer.valueOf(i)));
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i3 = B + 105;
        C = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 30 / 0;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(ShopModel shopModel) {
        try {
            int i = C + 51;
            B = i % 128;
            int i2 = i % 2;
            MerchantDetailActivity.Companion companion = MerchantDetailActivity.INSTANCE;
            try {
                MerchantDetailActivity.Companion.getAuthRequestContext(this, shopModel, TrackerKey.SourceType.NEARBY_ME_LIST);
                int i3 = C + 19;
                B = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private OnCategoryCheckedListener NetworkUserEntityData$$ExternalSyntheticLambda1() {
        OnCategoryCheckedListener onCategoryCheckedListener = new OnCategoryCheckedListener() { // from class: id.dana.nearbyme.NearbyMeActivity.5
            @Override // id.dana.nearbyme.OnCategoryCheckedListener
            public /* synthetic */ void onMulitpleCategorySelected(List list, boolean z) {
                OnCategoryCheckedListener.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.nearbyme.OnCategoryCheckedListener
            public void onMulitpleCategorySelected(List<MerchantCategoryModel> list) {
                NearbyMeActivity.this.presenter.getAuthRequestContext(list);
            }

            @Override // id.dana.nearbyme.OnCategoryCheckedListener
            public void onCategoryClick(MerchantCategoryModel merchantCategoryModel) {
                NearbyMeActivity.this.nearbyAnalyticTracker.BuiltInFictitiousFunctionClassFactory(merchantCategoryModel.getAuthRequestContext);
            }
        };
        int i = B + 37;
        C = i % 128;
        if ((i % 2 != 0 ? '\r' : (char) 17) != 17) {
            Object obj = null;
            obj.hashCode();
            return onCategoryCheckedListener;
        }
        return onCategoryCheckedListener;
    }

    private MerchantListAdapter.OnPromoRibbonClickListener DatabaseTableConfigUtil() {
        MerchantListAdapter.OnPromoRibbonClickListener onPromoRibbonClickListener = new MerchantListAdapter.OnPromoRibbonClickListener() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda17
            @Override // id.dana.nearbyme.adapter.MerchantListAdapter.OnPromoRibbonClickListener
            public final void BuiltInFictitiousFunctionClassFactory(List list) {
                NearbyMeActivity.this.m2705x17ca9671(list);
            }
        };
        int i = C + 67;
        B = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 45 / 0;
            return onPromoRibbonClickListener;
        }
        return onPromoRibbonClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getOnPromoRibbonClickListener$9$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ void m2705x17ca9671(List list) {
        int i = C + 89;
        B = i % 128;
        try {
            if ((i % 2 == 0 ? '\'' : 'F') != 'F') {
                showPromoBottomSheet(list);
                Object obj = null;
                obj.hashCode();
            } else {
                showPromoBottomSheet(list);
            }
            int i2 = B + 75;
            C = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void PlaceComponentResult(ShopModel shopModel) {
        try {
            int i = B + 77;
            C = i % 128;
            int i2 = i % 2;
            OtherStoreListActivity.Companion companion = OtherStoreListActivity.INSTANCE;
            OtherStoreListActivity.Companion.BuiltInFictitiousFunctionClassFactory(this, shopModel, this.GetContactSyncConfig.getLatitude(), this.GetContactSyncConfig.getLongitude(), SearchType.MERCHANTID_SORTED_BY_DISTANCE, "", TrackerKey.SourceType.NEARBY_ME_LIST);
            int i3 = C + 59;
            B = i3 % 128;
            if (i3 % 2 != 0) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private void E() {
        try {
            try {
                this.merchantListView.setOnHomeShoppingClickListener(BuiltInFictitiousFunctionClassFactory(new Function1() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NearbyMeActivity.this.m2710x3161d7c5((Integer) obj);
                    }
                }));
                this.merchantListView.setOnCategoryCheckedListener(NetworkUserEntityData$$ExternalSyntheticLambda1());
                this.merchantListView.setOnMerchantClickListener(KClassImpl$Data$declaredNonStaticMembers$2(new Function1() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NearbyMeActivity.this.m2711x983a9786((Integer) obj);
                    }
                }));
                this.merchantListView.setOnPromoRibbonClickListener(DatabaseTableConfigUtil());
                this.merchantListView.setOnTopUpButtonClickListener(NetworkUserEntityData$$ExternalSyntheticLambda7());
                this.merchantListView.setOnOtherStoreButtonClickListener(MyBillsEntityDataFactory(new Function1() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NearbyMeActivity.this.m2712xff135747((Integer) obj);
                    }
                }));
                int i = B + 97;
                C = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupMerchantListView$10$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ ShopModel m2710x3161d7c5(Integer num) {
        int i = C + 123;
        B = i % 128;
        int i2 = i % 2;
        try {
            ShopModel merchantItem = this.merchantListView.getMerchantItem(num.intValue());
            int i3 = C + 89;
            B = i3 % 128;
            int i4 = i3 % 2;
            return merchantItem;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupMerchantListView$11$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ ShopModel m2711x983a9786(Integer num) {
        int i = C + 95;
        B = i % 128;
        int i2 = i % 2;
        try {
            try {
                ShopModel merchantItem = this.merchantListView.getMerchantItem(num.intValue());
                int i3 = B + 65;
                C = i3 % 128;
                int i4 = i3 % 2;
                return merchantItem;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupMerchantListView$12$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ ShopModel m2712xff135747(Integer num) {
        try {
            int i = B + 69;
            C = i % 128;
            if (!(i % 2 != 0)) {
                return this.merchantListView.getMerchantItem(num.intValue());
            }
            try {
                ShopModel merchantItem = this.merchantListView.getMerchantItem(num.intValue());
                Object obj = null;
                obj.hashCode();
                return merchantItem;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void PlaceComponentResult() {
        int i = B + 3;
        C = i % 128;
        KClassImpl$Data$declaredNonStaticMembers$2((i % 2 != 0 ? '/' : '3') != '3' ? 2.0f : 1.0f);
        int i2 = C + 73;
        B = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            int i = C + 51;
            try {
                B = i % 128;
                int i2 = i % 2;
                KClassImpl$Data$declaredNonStaticMembers$2(0.0f);
                this.appBarLayout.setExpanded(true, false);
                int i3 = C + 39;
                B = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(String str) {
        int i = B + 27;
        C = i % 128;
        int i2 = i % 2;
        this.tvDistrictLocation.setText(str);
        this.tvLocation.setText(str);
        int i3 = B + 71;
        C = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.nearbyme.NearbyMeActivity$6  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass6 implements RequestListener<Drawable> {
        final /* synthetic */ ShopModel MyBillsEntityDataFactory;
        final /* synthetic */ Location PlaceComponentResult;

        AnonymousClass6(ShopModel shopModel, Location location) {
            this.MyBillsEntityDataFactory = shopModel;
            this.PlaceComponentResult = location;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, com.bumptech.glide.request.target.Target<Drawable> target, DataSource dataSource, boolean z) {
            return PlaceComponentResult(drawable);
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, com.bumptech.glide.request.target.Target<Drawable> target, boolean z) {
            NearbyMeActivity nearbyMeActivity = NearbyMeActivity.this;
            final ShopModel shopModel = this.MyBillsEntityDataFactory;
            final Location location = this.PlaceComponentResult;
            NearbyMeActivity.access$1600(nearbyMeActivity, new Runnable() { // from class: id.dana.nearbyme.NearbyMeActivity$6$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Drawable BuiltInFictitiousFunctionClassFactory;
                    NearbyMeActivity.AnonymousClass6 anonymousClass6 = NearbyMeActivity.AnonymousClass6.this;
                    ShopModel shopModel2 = shopModel;
                    Location location2 = location;
                    NearbyMeActivity nearbyMeActivity2 = NearbyMeActivity.this;
                    BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(nearbyMeActivity2, R.drawable.ic_dana_bisnis);
                    NearbyMeActivity.access$1800(nearbyMeActivity2, shopModel2, BuiltInFictitiousFunctionClassFactory, location2);
                }
            });
            return false;
        }

        private boolean PlaceComponentResult(final Drawable drawable) {
            NearbyMeActivity nearbyMeActivity = NearbyMeActivity.this;
            final ShopModel shopModel = this.MyBillsEntityDataFactory;
            final Location location = this.PlaceComponentResult;
            NearbyMeActivity.access$1600(nearbyMeActivity, new Runnable() { // from class: id.dana.nearbyme.NearbyMeActivity$6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NearbyMeActivity.AnonymousClass6 anonymousClass6 = NearbyMeActivity.AnonymousClass6.this;
                    NearbyMeActivity.access$1800(NearbyMeActivity.this, shopModel, drawable, location);
                }
            });
            return true;
        }
    }

    private void MyBillsEntityDataFactory(ShopModel shopModel, RequestListener<Drawable> requestListener) {
        int i = C + 95;
        B = i % 128;
        int i2 = i % 2;
        GlideApp.PlaceComponentResult(this).PlaceComponentResult(ImageOss.KClassImpl$Data$declaredNonStaticMembers$2(this, KClassImpl$Data$declaredNonStaticMembers$2(shopModel), ImageResize.PlaceComponentResult(this, getResources().getDimension(R.dimen.f33322131165976)))).BuiltInFictitiousFunctionClassFactory(requestListener).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2();
        int i3 = C + 63;
        B = i3 % 128;
        int i4 = i3 % 2;
    }

    private void MyBillsEntityDataFactory(ShopModel shopModel, Drawable drawable, Location location) {
        int i = C + 31;
        B = i % 128;
        int i2 = i % 2;
        if (MyBillsEntityDataFactory(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1)) {
            Marker BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(getAuthRequestContext(shopModel, drawable, location), shopModel);
            if ((getAuthRequestContext(shopModel) ? '!' : '^') == '!') {
                try {
                    if ((this.NetworkUserEntityData$$ExternalSyntheticLambda8 ? (char) 15 : ';') != ';') {
                        KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
                        return;
                    }
                    this.initRecordTimeStamp = null;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        int i3 = B + 49;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if ((getAuthRequestContext(r4)) != true) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        r5.visible(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        r4 = id.dana.nearbyme.NearbyMeActivity.C + 91;
        id.dana.nearbyme.NearbyMeActivity.B = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if ((getAuthRequestContext(r4)) != true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.android.gms.maps.model.MarkerOptions getAuthRequestContext(id.dana.nearbyme.model.ShopModel r4, android.graphics.drawable.Drawable r5, android.location.Location r6) {
        /*
            r3 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L23
            com.google.android.gms.maps.model.MarkerOptions r5 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r4, r5, r6)
            boolean r4 = r3.getAuthRequestContext(r4)
            r6 = 25
            int r6 = r6 / r2
            if (r4 == 0) goto L1d
            r4 = 1
            goto L1e
        L1d:
            r4 = 0
        L1e:
            if (r4 == r1) goto L33
            goto L36
        L21:
            r4 = move-exception
            throw r4
        L23:
            com.google.android.gms.maps.model.MarkerOptions r5 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r4, r5, r6)
            boolean r4 = r3.getAuthRequestContext(r4)
            if (r4 == 0) goto L2f
            r4 = 1
            goto L30
        L2f:
            r4 = 0
        L30:
            if (r4 == r1) goto L33
            goto L36
        L33:
            r5.visible(r2)
        L36:
            int r4 = id.dana.nearbyme.NearbyMeActivity.C
            int r4 = r4 + 91
            int r6 = r4 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r6
            int r4 = r4 % 2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.getAuthRequestContext(id.dana.nearbyme.model.ShopModel, android.graphics.drawable.Drawable, android.location.Location):com.google.android.gms.maps.model.MarkerOptions");
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Marker marker) {
        try {
            int i = B + 63;
            C = i % 128;
            if ((i % 2 != 0 ? '1' : Typography.dollar) != '1') {
                if (!(marker.getTag() instanceof ShopModel)) {
                    return;
                }
            } else {
                int i2 = 44 / 0;
                if ((marker.getTag() instanceof ShopModel ? '6' : 'a') != '6') {
                    return;
                }
            }
            int i3 = B + 85;
            C = i3 % 128;
            if (!(i3 % 2 != 0)) {
                NetworkUserEntityData$$ExternalSyntheticLambda5();
                PlaceComponentResult(marker);
                return;
            }
            NetworkUserEntityData$$ExternalSyntheticLambda5();
            PlaceComponentResult(marker);
            int i4 = 39 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (r0 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r4 = id.dana.nearbyme.NearbyMeActivity.B + 53;
        id.dana.nearbyme.NearbyMeActivity.C = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if ((r4 % 2) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r7 = r0.MyBillsEntityDataFactory.equals(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r7 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        if (r0.MyBillsEntityDataFactory.equals(r7) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        r7 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        r7 = 'D';
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        if (r7 == 'D') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        r7 = id.dana.nearbyme.NearbyMeActivity.C + 109;
        id.dana.nearbyme.NearbyMeActivity.B = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if ((r7 % 2) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        r7 = id.dana.nearbyme.NearbyMeActivity.C + 25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        id.dana.nearbyme.NearbyMeActivity.B = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
    
        r7 = id.dana.nearbyme.NearbyMeActivity.C + 15;
        id.dana.nearbyme.NearbyMeActivity.B = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (r0 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean getAuthRequestContext(id.dana.nearbyme.model.ShopModel r7) {
        /*
            r6 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 97
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L19
            id.dana.nearbyme.model.HighlightedShopModel r0 = r6.initRecordTimeStamp
            r2.hashCode()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L56
            goto L1d
        L17:
            r7 = move-exception
            throw r7
        L19:
            id.dana.nearbyme.model.HighlightedShopModel r0 = r6.initRecordTimeStamp     // Catch: java.lang.Exception -> L6d
            if (r0 == 0) goto L56
        L1d:
            int r4 = id.dana.nearbyme.NearbyMeActivity.B
            int r4 = r4 + 53
            int r5 = r4 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L35
            id.dana.nearbyme.model.ShopModel r0 = r0.MyBillsEntityDataFactory
            boolean r7 = r0.equals(r7)
            int r0 = r2.length     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L56
            goto L46
        L33:
            r7 = move-exception
            throw r7
        L35:
            id.dana.nearbyme.model.ShopModel r0 = r0.MyBillsEntityDataFactory
            boolean r7 = r0.equals(r7)
            r0 = 68
            if (r7 == 0) goto L42
            r7 = 22
            goto L44
        L42:
            r7 = 68
        L44:
            if (r7 == r0) goto L56
        L46:
            int r7 = id.dana.nearbyme.NearbyMeActivity.C
            int r7 = r7 + 109
            int r0 = r7 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r0
            int r7 = r7 % 2
            if (r7 != 0) goto L53
            goto L54
        L53:
            r1 = 1
        L54:
            r1 = 1
            goto L60
        L56:
            int r7 = id.dana.nearbyme.NearbyMeActivity.C     // Catch: java.lang.Exception -> L6d
            int r7 = r7 + 25
            int r0 = r7 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r0     // Catch: java.lang.Exception -> L6b
            int r7 = r7 % 2
        L60:
            int r7 = id.dana.nearbyme.NearbyMeActivity.C
            int r7 = r7 + 15
            int r0 = r7 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r0
            int r7 = r7 % 2
            return r1
        L6b:
            r7 = move-exception
            throw r7
        L6d:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.getAuthRequestContext(id.dana.nearbyme.model.ShopModel):boolean");
    }

    private MarkerOptions KClassImpl$Data$declaredNonStaticMembers$2(ShopModel shopModel, Drawable drawable, Location location) {
        int i = B + 115;
        C = i % 128;
        int i2 = i % 2;
        if (this.newProxyInstance.get(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1) != null) {
            try {
                int i3 = B + 63;
                C = i3 % 128;
                int i4 = i3 % 2;
                this.newProxyInstance.get(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1).remove();
            } catch (Exception e) {
                throw e;
            }
        }
        MarkerOptions PlaceComponentResult2 = PlaceComponentResult(shopModel, drawable, location);
        int i5 = C + 33;
        B = i5 % 128;
        if ((i5 % 2 == 0 ? Typography.quote : (char) 22) != '\"') {
            return PlaceComponentResult2;
        }
        Object obj = null;
        obj.hashCode();
        return PlaceComponentResult2;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        Pair<Marker, Marker> pair = this.PrepareContext;
        if (pair != null) {
            try {
                if (pair.first != null) {
                    int i = C + 103;
                    B = i % 128;
                    int i2 = i % 2;
                    ((Marker) this.PrepareContext.first).remove();
                }
                if (this.PrepareContext.second == null) {
                    return;
                }
                int i3 = B + 15;
                C = i3 % 128;
                if (i3 % 2 != 0) {
                }
                ((Marker) this.PrepareContext.second).setVisible(true);
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private Marker BuiltInFictitiousFunctionClassFactory(MarkerOptions markerOptions, ShopModel shopModel) {
        Marker BuiltInFictitiousFunctionClassFactory;
        int i = C + 79;
        B = i % 128;
        Object[] objArr = null;
        if (!(i % 2 == 0)) {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(markerOptions);
            BuiltInFictitiousFunctionClassFactory.setTag(shopModel);
            this.newProxyInstance.put(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1, BuiltInFictitiousFunctionClassFactory);
        } else {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(markerOptions);
            BuiltInFictitiousFunctionClassFactory.setTag(shopModel);
            this.newProxyInstance.put(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1, BuiltInFictitiousFunctionClassFactory);
            int length = objArr.length;
        }
        int i2 = B + 51;
        C = i2 % 128;
        if (!(i2 % 2 == 0)) {
            int length2 = objArr.length;
            return BuiltInFictitiousFunctionClassFactory;
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        int i = C + 89;
        B = i % 128;
        int i2 = i % 2;
        this.mapHelper.MyBillsEntityDataFactory(googleMap, this);
        PlaceComponentResult(googleMap);
        BottomSheetCardBindingView$watcherCardNumberView$1();
        int i3 = C + 97;
        B = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private void PlaceComponentResult(GoogleMap googleMap) {
        PrepareContext();
        googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public final void onCameraMove() {
                NearbyMeActivity.this.m2707lambda$setupCameraListener$13$iddananearbymeNearbyMeActivity();
            }
        });
        googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
            public final void onCameraIdle() {
                NearbyMeActivity.this.m2708lambda$setupCameraListener$14$iddananearbymeNearbyMeActivity();
            }
        });
        googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
            public final void onCameraMoveStarted(int i) {
                NearbyMeActivity.this.m2709lambda$setupCameraListener$15$iddananearbymeNearbyMeActivity(i);
            }
        });
        int i = B + 101;
        C = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        if (r0 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        if (r0 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        r0 = r0.getCameraPosition().zoom / 30.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        r0 = 0.0f;
     */
    /* renamed from: lambda$setupCameraListener$13$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void m2707lambda$setupCameraListener$13$iddananearbymeNearbyMeActivity() {
        /*
            r7 = this;
            boolean r0 = r7.readMicros()
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L29
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + r3
            int r4 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r4
            int r0 = r0 % r2
            if (r0 == 0) goto L1e
            androidx.cardview.widget.CardView r0 = r7.cvGoToMyLocation
            r0.setVisibility(r3)
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r7.scheduleImpl
            r0.setState(r2)
            goto L29
        L1e:
            androidx.cardview.widget.CardView r0 = r7.cvGoToMyLocation
            r0.setVisibility(r1)
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r7.scheduleImpl
            r4 = 4
            r0.setState(r4)
        L29:
            id.dana.utils.MapHelper r0 = r7.mapHelper
            com.google.android.gms.maps.model.Marker r4 = r7.NetworkUserEntityData$$ExternalSyntheticLambda7
            if (r4 == 0) goto L31
            r5 = 0
            goto L32
        L31:
            r5 = 1
        L32:
            if (r5 == 0) goto L35
            goto L5d
        L35:
            int r5 = id.dana.nearbyme.NearbyMeActivity.B
            int r5 = r5 + 67
            int r6 = r5 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r6
            int r5 = r5 % r2
            if (r5 == 0) goto L4b
            com.google.android.gms.maps.GoogleMap r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L59
            goto L4f
        L49:
            r0 = move-exception
            throw r0
        L4b:
            com.google.android.gms.maps.GoogleMap r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L7c
            if (r0 == 0) goto L59
        L4f:
            com.google.android.gms.maps.model.CameraPosition r0 = r0.getCameraPosition()
            float r0 = r0.zoom
            r5 = 1106247680(0x41f00000, float:30.0)
            float r0 = r0 / r5
            goto L5a
        L59:
            r0 = 0
        L5a:
            r4.setAnchor(r0, r0)
        L5d:
            boolean r0 = r7.NetworkUserEntityData$$ExternalSyntheticLambda1
            if (r0 == 0) goto L62
            r3 = 0
        L62:
            if (r3 == 0) goto L65
            goto L73
        L65:
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 117
            int r3 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r3
            int r0 = r0 % r2
            id.dana.richview.PinMapLottieAnimationView r0 = r7.lavMapCenterPinPoint
            r0.setVisibility(r1)
        L73:
            r7.whenAvailable()
            java.lang.String r0 = "ERROR"
            r7.NetworkUserEntityData$$ExternalSyntheticLambda0(r0)
            return
        L7c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.m2707lambda$setupCameraListener$13$iddananearbymeNearbyMeActivity():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupCameraListener$15$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ void m2709lambda$setupCameraListener$15$iddananearbymeNearbyMeActivity(int i) {
        int i2 = C + 101;
        B = i2 % 128;
        int i3 = i2 % 2;
        if (i == 1) {
            showShimmerNearbyLocation();
            this.lavMapCenterPinPoint.setVisibility(0);
        }
        int i4 = C + 101;
        B = i4 % 128;
        if ((i4 % 2 == 0 ? 'L' : 'V') != 'V') {
            Object obj = null;
            obj.hashCode();
        }
    }

    private void BottomSheetCardBindingView$watcherCardNumberView$1() {
        int i = C + 57;
        B = i % 128;
        if ((i % 2 == 0 ? '\t' : InputCardNumberView.DIVIDER) != '\t') {
            this.GetContactSyncConfig = LocationUtil.getAuthRequestContext();
            NetworkUserEntityData$$ExternalSyntheticLambda2();
            return;
        }
        this.GetContactSyncConfig = LocationUtil.getAuthRequestContext();
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int i2 = 9 / 0;
    }

    private void whenAvailable() {
        if ((SubSequence() ? 'a' : '#') != '#') {
            int i = B + 11;
            C = i % 128;
            int i2 = i % 2;
            try {
                PinMapLottieAnimationView pinMapLottieAnimationView = this.lavMapCenterPinPoint;
                pinMapLottieAnimationView.setMinFrame(pinMapLottieAnimationView.getPullOutMinFrame());
                PinMapLottieAnimationView pinMapLottieAnimationView2 = this.lavMapCenterPinPoint;
                pinMapLottieAnimationView2.setMaxFrame(pinMapLottieAnimationView2.getPullOutMaxFrame());
                this.lavMapCenterPinPoint.playAnimation();
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = B + 79;
        C = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 7 : InputCardNumberView.DIVIDER) != ' ') {
            Object obj = null;
            obj.hashCode();
        }
    }

    private void A() {
        try {
            int i = C + 23;
            B = i % 128;
            if (i % 2 == 0) {
                PinMapLottieAnimationView pinMapLottieAnimationView = this.lavMapCenterPinPoint;
                pinMapLottieAnimationView.setMinFrame(pinMapLottieAnimationView.getPutDownMinFrame());
                PinMapLottieAnimationView pinMapLottieAnimationView2 = this.lavMapCenterPinPoint;
                pinMapLottieAnimationView2.setMaxFrame(pinMapLottieAnimationView2.getPutDownMaxFrame());
                this.lavMapCenterPinPoint.playAnimation();
                int i2 = 98 / 0;
            } else {
                PinMapLottieAnimationView pinMapLottieAnimationView3 = this.lavMapCenterPinPoint;
                pinMapLottieAnimationView3.setMinFrame(pinMapLottieAnimationView3.getPutDownMinFrame());
                PinMapLottieAnimationView pinMapLottieAnimationView4 = this.lavMapCenterPinPoint;
                pinMapLottieAnimationView4.setMaxFrame(pinMapLottieAnimationView4.getPutDownMaxFrame());
                this.lavMapCenterPinPoint.playAnimation();
            }
            int i3 = C + 13;
            B = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void showShimmerNearbyLocation() {
        int i = C + 59;
        B = i % 128;
        int i2 = i % 2;
        if (this.scheduleImpl.getState() != 3) {
            int i3 = B + 101;
            C = i3 % 128;
            int i4 = i3 % 2;
            if ((this.whenAvailable == null ? (char) 6 : (char) 18) == 6) {
                this.whenAvailable = ShimmeringUtil.PlaceComponentResult(this.clLocationContainer, R.layout.view_skeleton_nearby_location);
            }
            this.whenAvailable.MyBillsEntityDataFactory();
            int i5 = B + 83;
            C = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if ((r5.lavMapCenterPinPoint.getMinFrame() != ((float) r5.lavMapCenterPinPoint.getPullOutMinFrame())) != true) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
    
        if ((r5.lavMapCenterPinPoint.getMinFrame() != ((float) r5.lavMapCenterPinPoint.getPullOutMinFrame()) ? 4 : '[') != '[') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        r0 = id.dana.nearbyme.NearbyMeActivity.C + 19;
        id.dana.nearbyme.NearbyMeActivity.B = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean SubSequence() {
        /*
            r5 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.C     // Catch: java.lang.Exception -> L80
            int r0 = r0 + 37
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r1     // Catch: java.lang.Exception -> L80
            int r0 = r0 % 2
            id.dana.richview.PinMapLottieAnimationView r0 = r5.lavMapCenterPinPoint
            float r0 = r0.getMaxFrame()
            id.dana.richview.PinMapLottieAnimationView r1 = r5.lavMapCenterPinPoint
            int r1 = r1.getPullOutMaxFrame()
            float r1 = (float) r1
            r2 = 97
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L20
            r0 = 97
            goto L22
        L20:
            r0 = 35
        L22:
            r1 = 1
            r3 = 0
            if (r0 == r2) goto L27
            goto L7c
        L27:
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 117
            int r2 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r2
            int r0 = r0 % 2
            r2 = 92
            if (r0 != 0) goto L38
            r0 = 38
            goto L3a
        L38:
            r0 = 92
        L3a:
            if (r0 == r2) goto L58
            id.dana.richview.PinMapLottieAnimationView r0 = r5.lavMapCenterPinPoint
            float r0 = r0.getMinFrame()
            id.dana.richview.PinMapLottieAnimationView r2 = r5.lavMapCenterPinPoint
            int r2 = r2.getPullOutMinFrame()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r2 = 87
            int r2 = r2 / r3
            if (r0 == 0) goto L52
            r0 = 1
            goto L53
        L52:
            r0 = 0
        L53:
            if (r0 == r1) goto L71
            goto L7c
        L56:
            r0 = move-exception
            throw r0
        L58:
            id.dana.richview.PinMapLottieAnimationView r0 = r5.lavMapCenterPinPoint     // Catch: java.lang.Exception -> L7e
            float r0 = r0.getMinFrame()     // Catch: java.lang.Exception -> L7e
            id.dana.richview.PinMapLottieAnimationView r2 = r5.lavMapCenterPinPoint     // Catch: java.lang.Exception -> L7e
            int r2 = r2.getPullOutMinFrame()     // Catch: java.lang.Exception -> L7e
            float r2 = (float) r2
            r4 = 91
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L6d
            r0 = 4
            goto L6f
        L6d:
            r0 = 91
        L6f:
            if (r0 == r4) goto L7c
        L71:
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 19
            int r2 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r2
            int r0 = r0 % 2
            goto L7d
        L7c:
            r1 = 0
        L7d:
            return r1
        L7e:
            r0 = move-exception
            throw r0
        L80:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.SubSequence():boolean");
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        if (isLayoutRequested()) {
            int i = C + 69;
            B = i % 128;
            int i2 = i % 2;
            NetworkUserEntityData$$ExternalSyntheticLambda2();
            int i3 = B + 119;
            C = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return;
            }
            return;
        }
        getErrorConfigVersion();
        this.lookAheadTest = 0;
        Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.nearbyme.NearbyMeActivity$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NearbyMeActivity.$r8$lambda$lkb2W4xlJVlpO4hIEY_bYKklWls(NearbyMeActivity.this, (Location) obj);
            }
        });
        this.isLayoutRequested = subscribe;
        addDisposable(subscribe);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        if ((!r0) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if ((!id.dana.utils.OSUtil.GetContactSyncConfig()) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
    
        r0 = id.dana.nearbyme.NearbyMeActivity.B + 25;
        id.dana.nearbyme.NearbyMeActivity.C = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        if ((r0 % 2) == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0042, code lost:
    
        if (r0 == true) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
    
        r3 = 23 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
    
        if (androidx.core.content.ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(r4, "android.permission.ACCESS_FINE_LOCATION") == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0056, code lost:
    
        if (androidx.core.content.ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(r4, "android.permission.ACCESS_FINE_LOCATION") == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0058, code lost:
    
        r0 = 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005b, code lost:
    
        r0 = 'K';
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005d, code lost:
    
        if (r0 == 31) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005f, code lost:
    
        r0 = id.dana.nearbyme.NearbyMeActivity.B + 7;
        id.dana.nearbyme.NearbyMeActivity.C = r0 % 128;
        r0 = r0 % 2;
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006a, code lost:
    
        r0 = id.dana.nearbyme.NearbyMeActivity.C + 87;
        id.dana.nearbyme.NearbyMeActivity.B = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0074, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isLayoutRequested() {
        /*
            r4 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B     // Catch: java.lang.Exception -> L75
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1     // Catch: java.lang.Exception -> L75
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L25
            boolean r0 = id.dana.utils.OSUtil.GetContactSyncConfig()
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L1f
            r0 = 0
            goto L20
        L1f:
            r0 = 1
        L20:
            if (r0 == 0) goto L31
            goto L5f
        L23:
            r0 = move-exception
            throw r0
        L25:
            boolean r0 = id.dana.utils.OSUtil.GetContactSyncConfig()
            if (r0 == 0) goto L2d
            r0 = 0
            goto L2e
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L31
            goto L5f
        L31:
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 25
            int r3 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L3f
            r0 = 0
            goto L40
        L3f:
            r0 = 1
        L40:
            java.lang.String r3 = "android.permission.ACCESS_FINE_LOCATION"
            if (r0 == r1) goto L50
            int r0 = androidx.core.content.ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(r4, r3)     // Catch: java.lang.Exception -> L75
            r3 = 23
            int r3 = r3 / r2
            if (r0 == 0) goto L5f
            goto L6a
        L4e:
            r0 = move-exception
            throw r0
        L50:
            int r0 = androidx.core.content.ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(r4, r3)
            r3 = 31
            if (r0 == 0) goto L5b
            r0 = 31
            goto L5d
        L5b:
            r0 = 75
        L5d:
            if (r0 == r3) goto L6a
        L5f:
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 7
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            r1 = 0
        L6a:
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 87
            int r2 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r2
            int r0 = r0 % 2
            return r1
        L75:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.isLayoutRequested():boolean");
    }

    private void getErrorConfigVersion() {
        int i = C + 79;
        B = i % 128;
        int i2 = i % 2;
        Disposable disposable = this.isLayoutRequested;
        if (disposable != null) {
            int i3 = C + 41;
            B = i3 % 128;
            int i4 = i3 % 2;
            disposable.dispose();
            this.isLayoutRequested = null;
        }
        try {
            int i5 = B + 69;
            C = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Location location) {
        if (this.lookAheadTest >= 5) {
            int i = C + 23;
            B = i % 128;
            if ((i % 2 == 0 ? '@' : 'Q') != 'Q') {
                this.lookAheadTest = 1;
            } else {
                this.lookAheadTest = 0;
            }
            this.GetContactSyncConfig = LocationUtil.getAuthRequestContext();
            FragmentBottomSheetPaymentSettingBinding();
            getErrorConfigVersion();
        }
        if (!(location != null)) {
            this.lookAheadTest++;
            return;
        }
        try {
            int i2 = C + 77;
            B = i2 % 128;
            if ((i2 % 2 == 0 ? 'A' : ')') != 'A') {
                try {
                    this.GetContactSyncConfig = location;
                    this.nearbyMerchantLocationSearchView.setLocation(location);
                    FragmentBottomSheetPaymentSettingBinding();
                    getErrorConfigVersion();
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            this.GetContactSyncConfig = location;
            this.nearbyMerchantLocationSearchView.setLocation(location);
            FragmentBottomSheetPaymentSettingBinding();
            getErrorConfigVersion();
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void FragmentBottomSheetPaymentSettingBinding() {
        try {
            if (this.DatabaseTableConfigUtil) {
                int i = B + 119;
                C = i % 128;
                if ((i % 2 != 0 ? 'A' : 'D') != 'D') {
                    moveToNextValue();
                    this.DatabaseTableConfigUtil = true;
                } else {
                    moveToNextValue();
                    this.DatabaseTableConfigUtil = false;
                }
                int i2 = B + 19;
                C = i2 % 128;
                int i3 = i2 % 2;
            }
            getOnBoardingScenario();
            Location location = this.getSupportButtonTintMode;
            if (location == null) {
                KClassImpl$Data$declaredNonStaticMembers$2(this.GetContactSyncConfig, true);
                return;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(location, false);
            this.getSupportButtonTintMode = null;
        } catch (Exception e) {
            throw e;
        }
    }

    private void PlaceComponentResult(Marker marker) {
        GlideApp.PlaceComponentResult(this).PlaceComponentResult(ImageOss.KClassImpl$Data$declaredNonStaticMembers$2(this, KClassImpl$Data$declaredNonStaticMembers$2((ShopModel) marker.getTag()), ImageResize.PlaceComponentResult(this, getResources().getDimension(R.dimen.f33322131165976)))).KClassImpl$Data$declaredNonStaticMembers$2(true).BuiltInFictitiousFunctionClassFactory((RequestListener<Drawable>) new AnonymousClass7(marker)).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2();
        int i = B + 91;
        C = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.nearbyme.NearbyMeActivity$7  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass7 implements RequestListener<Drawable> {
        final /* synthetic */ Marker BuiltInFictitiousFunctionClassFactory;

        AnonymousClass7(Marker marker) {
            this.BuiltInFictitiousFunctionClassFactory = marker;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, com.bumptech.glide.request.target.Target<Drawable> target, DataSource dataSource, boolean z) {
            return getAuthRequestContext(drawable);
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, com.bumptech.glide.request.target.Target<Drawable> target, boolean z) {
            NearbyMeActivity nearbyMeActivity = NearbyMeActivity.this;
            final Marker marker = this.BuiltInFictitiousFunctionClassFactory;
            NearbyMeActivity.access$1600(nearbyMeActivity, new Runnable() { // from class: id.dana.nearbyme.NearbyMeActivity$7$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Drawable BuiltInFictitiousFunctionClassFactory;
                    NearbyMeActivity.AnonymousClass7 anonymousClass7 = NearbyMeActivity.AnonymousClass7.this;
                    Marker marker2 = marker;
                    NearbyMeActivity nearbyMeActivity2 = NearbyMeActivity.this;
                    BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(nearbyMeActivity2, R.drawable.ic_dana_bisnis);
                    NearbyMeActivity.access$1900(nearbyMeActivity2, BuiltInFictitiousFunctionClassFactory, marker2);
                }
            });
            return false;
        }

        private boolean getAuthRequestContext(final Drawable drawable) {
            NearbyMeActivity nearbyMeActivity = NearbyMeActivity.this;
            final Marker marker = this.BuiltInFictitiousFunctionClassFactory;
            NearbyMeActivity.access$1600(nearbyMeActivity, new Runnable() { // from class: id.dana.nearbyme.NearbyMeActivity$7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NearbyMeActivity.AnonymousClass7 anonymousClass7 = NearbyMeActivity.AnonymousClass7.this;
                    NearbyMeActivity.access$1900(NearbyMeActivity.this, drawable, marker);
                }
            });
            return true;
        }
    }

    private Location GetContactSyncConfig() {
        int i = C + 87;
        B = i % 128;
        if (i % 2 == 0) {
            try {
                Location location = this.getSupportButtonTintMode;
                Object[] objArr = null;
                int length = objArr.length;
                if ((location == null ? 'G' : '#') != 'G') {
                    return location;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            Location location2 = this.getSupportButtonTintMode;
            if (!(location2 == null)) {
                return location2;
            }
        }
        Location location3 = this.GetContactSyncConfig;
        int i2 = B + 73;
        C = i2 % 128;
        int i3 = i2 % 2;
        return location3;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        int i = C + 13;
        B = i % 128;
        int i2 = i % 2;
        if ((LocationUtil.getAuthRequestContext(this) ? '(' : (char) 7) != '(') {
            return;
        }
        try {
            if ((this.NetworkUserEntityData$$ExternalSyntheticLambda4 == null ? ':' : (char) 30) != 30) {
                int i3 = B + 39;
                C = i3 % 128;
                if (i3 % 2 == 0) {
                    lookAheadTest();
                } else {
                    lookAheadTest();
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.check();
        } catch (Exception e) {
            throw e;
        }
    }

    private void getOnBoardingScenario() {
        D();
        MapHelper mapHelper = this.mapHelper;
        Location location = this.getSupportButtonTintMode;
        if (location == null) {
            location = this.GetContactSyncConfig;
        }
        LatLng authRequestContext = LocationUtil.getAuthRequestContext(location);
        GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((googleMap != null ? (char) 31 : (char) 4) != 4) {
            int i = C + 9;
            B = i % 128;
            if ((i % 2 == 0 ? '3' : 'b') != 'b') {
                try {
                    googleMap.animateCamera(MapHelper.getAuthRequestContext(authRequestContext, 15.0f));
                    int i2 = 52 / 0;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                googleMap.animateCamera(MapHelper.getAuthRequestContext(authRequestContext, 15.0f));
            }
        }
        int i3 = C + 105;
        B = i3 % 128;
        int i4 = i3 % 2;
    }

    private void C() {
        int i = B + 59;
        C = i % 128;
        int i2 = i % 2;
        if (isActivityAvailable()) {
            PermissionHelper.MyBillsEntityDataFactory(this);
            return;
        }
        int i3 = B + 83;
        C = i3 % 128;
        int i4 = i3 % 2;
    }

    private void PlaceComponentResult(Runnable runnable) {
        Completable PlaceComponentResult2 = Completable.PlaceComponentResult(runnable);
        Scheduler PlaceComponentResult3 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult3, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(PlaceComponentResult2, PlaceComponentResult3));
        Scheduler PlaceComponentResult4 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult4, "scheduler is null");
        addDisposable(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult4)).q_());
        try {
            int i = B + 81;
            try {
                C = i % 128;
                if ((i % 2 != 0 ? Typography.less : 'Y') != '<') {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable, Marker marker) {
        int i;
        int i2 = C + 45;
        B = i2 % 128;
        int i3 = i2 % 2;
        ShopModel shopModel = (ShopModel) marker.getTag();
        String str = shopModel.newProxyInstance;
        if (!(!this.getCallingPid.contains(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1))) {
            i = R.drawable.ic_highlight_merchant_popular;
        } else if (!shopModel.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
            if ((shopModel.PrepareContext() ? (char) 22 : '(') != '(') {
                int i4 = B + 39;
                C = i4 % 128;
                int i5 = i4 % 2;
                i = R.drawable.ic_highlight_merchant_qris;
            } else {
                i = R.drawable.ic_highlight_merchant_normal;
            }
        } else {
            int i6 = B + 45;
            C = i6 % 128;
            int i7 = i6 % 2;
            i = R.drawable.ic_highlight_merchant_promo;
        }
        Location location = new Location("");
        location.setLatitude(shopModel.DatabaseTableConfigUtil);
        location.setLongitude(shopModel.PrepareContext);
        Marker BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.mapHelper.MyBillsEntityDataFactory(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1, location, drawable, str, i));
        HighlightedShopModel highlightedShopModel = new HighlightedShopModel(shopModel);
        this.initRecordTimeStamp = highlightedShopModel;
        BuiltInFictitiousFunctionClassFactory.setTag(highlightedShopModel);
        this.PrepareContext = new Pair<>(BuiltInFictitiousFunctionClassFactory, marker);
        marker.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if ((r4.scheduleImpl.getState() == 6 ? 16 : '[') != '[') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        r0 = id.dana.nearbyme.NearbyMeActivity.C + 11;
        id.dana.nearbyme.NearbyMeActivity.B = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        if ((r0 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        r0 = r4.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r0 = r4.scheduleImpl;
        r1 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        r0.setState(r1);
        r4.FragmentBottomSheetPaymentSettingBinding = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        KClassImpl$Data$declaredNonStaticMembers$2(newProxyInstance());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if ((r4.scheduleImpl.getState() == 85 ? 18 : 'A') != 'A') goto L29;
     */
    @butterknife.OnClick({id.dana.R.id.cv_info_legendary})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onInfoLegendaryClicked() {
        /*
            r4 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B     // Catch: java.lang.Exception -> L54
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1     // Catch: java.lang.Exception -> L54
            r1 = 2
            int r0 = r0 % r1
            if (r0 == 0) goto L20
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r4.scheduleImpl
            int r0 = r0.getState()
            r2 = 85
            r3 = 65
            if (r0 != r2) goto L1b
            r0 = 18
            goto L1d
        L1b:
            r0 = 65
        L1d:
            if (r0 == r3) goto L4c
            goto L32
        L20:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r4.scheduleImpl     // Catch: java.lang.Exception -> L54
            int r0 = r0.getState()     // Catch: java.lang.Exception -> L54
            r2 = 6
            r3 = 91
            if (r0 != r2) goto L2e
            r0 = 16
            goto L30
        L2e:
            r0 = 91
        L30:
            if (r0 == r3) goto L4c
        L32:
            int r0 = id.dana.nearbyme.NearbyMeActivity.C     // Catch: java.lang.Exception -> L4a
            int r0 = r0 + 11
            int r2 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r2     // Catch: java.lang.Exception -> L4a
            int r0 = r0 % r1
            r2 = 1
            if (r0 != 0) goto L41
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r4.scheduleImpl
            goto L44
        L41:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r4.scheduleImpl
            r1 = 4
        L44:
            r0.setState(r1)
            r4.FragmentBottomSheetPaymentSettingBinding = r2
            return
        L4a:
            r0 = move-exception
            throw r0
        L4c:
            id.dana.showcase.target.Target r0 = r4.newProxyInstance()
            r4.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            return
        L54:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.onInfoLegendaryClicked():void");
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Target target) {
        InfoShowcaseBuilder infoShowcaseBuilder = new InfoShowcaseBuilder(this);
        infoShowcaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = target;
        infoShowcaseBuilder.KClassImpl$Data$declaredNonStaticMembers$2(17170445).BuiltInFictitiousFunctionClassFactory(true).MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda0).BuiltInFictitiousFunctionClassFactory(new OnShowcaseStateListener() { // from class: id.dana.nearbyme.NearbyMeActivity.8
            @Override // id.dana.showcase.OnShowcaseStateListener
            public void onTargetSelected(int i) {
            }

            @Override // id.dana.showcase.OnShowcaseStateListener
            public void onStarted() {
                NearbyMeActivity.this.ivInfo.setVisibility(8);
                NearbyMeActivity.this.ivClose.setVisibility(0);
            }

            @Override // id.dana.showcase.OnShowcaseStateListener
            public void onFinished(int i) {
                NearbyMeActivity.this.ivInfo.setVisibility(0);
                NearbyMeActivity.this.ivClose.setVisibility(8);
            }
        }).PlaceComponentResult();
        int i = B + 119;
        C = i % 128;
        int i2 = i % 2;
    }

    private Target newProxyInstance() {
        int i = B + 35;
        C = i % 128;
        int i2 = i % 2;
        Target BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.cvInfoLegendary);
        int i3 = B + 83;
        C = i3 % 128;
        if ((i3 % 2 != 0 ? '!' : (char) 14) != '!') {
            return BuiltInFictitiousFunctionClassFactory;
        }
        Object obj = null;
        obj.hashCode();
        return BuiltInFictitiousFunctionClassFactory;
    }

    private Target BuiltInFictitiousFunctionClassFactory(View view) {
        Target KClassImpl$Data$declaredNonStaticMembers$2 = new TargetBuilder(this).BuiltInFictitiousFunctionClassFactory(view).BuiltInFictitiousFunctionClassFactory(new CircleShape(getErrorConfigVersion)).KClassImpl$Data$declaredNonStaticMembers$2();
        try {
            int i = B + 51;
            C = i % 128;
            int i2 = i % 2;
            return KClassImpl$Data$declaredNonStaticMembers$2;
        } catch (Exception e) {
            throw e;
        }
    }

    private Target BuiltInFictitiousFunctionClassFactory(View view, int i, int i2, boolean z) {
        int i3 = B + 17;
        C = i3 % 128;
        int i4 = i3 % 2;
        Target authRequestContext = getAuthRequestContext(view, i, i2, z);
        int i5 = C + 39;
        B = i5 % 128;
        if ((i5 % 2 == 0 ? 'D' : '!') != '!') {
            Object obj = null;
            obj.hashCode();
            return authRequestContext;
        }
        return authRequestContext;
    }

    private Target getAuthRequestContext(View view, int i, int i2, boolean z) {
        try {
            try {
                Target KClassImpl$Data$declaredNonStaticMembers$2 = new TargetBuilder(this).BuiltInFictitiousFunctionClassFactory(view).BuiltInFictitiousFunctionClassFactory(new RectangleShape(PlaceComponentResult(z, view), 20.0f, 20.0f, 10, 10, 10, 10)).getAuthRequestContext(new Content(getString(i), getString(i2), 0)).KClassImpl$Data$declaredNonStaticMembers$2();
                int i3 = B + 121;
                C = i3 % 128;
                int i4 = i3 % 2;
                return KClassImpl$Data$declaredNonStaticMembers$2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if ((r4) != true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        if ((r4 ? false : true) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:
    
        r5 = r3.viewTooltipSpotlightContainer;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0027, code lost:
    
        r4 = id.dana.nearbyme.NearbyMeActivity.B + 45;
        id.dana.nearbyme.NearbyMeActivity.C = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0031, code lost:
    
        if ((r4 % 2) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        r4 = 66 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0039, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View PlaceComponentResult(boolean r4, android.view.View r5) {
        /*
            r3 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 21
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L1f
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L1d
            if (r4 == 0) goto L19
            r4 = 1
            goto L1a
        L19:
            r4 = 0
        L1a:
            if (r4 == r2) goto L25
            goto L27
        L1d:
            r4 = move-exception
            throw r4
        L1f:
            if (r4 == 0) goto L22
            r2 = 0
        L22:
            if (r2 == 0) goto L25
            goto L27
        L25:
            android.view.View r5 = r3.viewTooltipSpotlightContainer
        L27:
            int r4 = id.dana.nearbyme.NearbyMeActivity.B
            int r4 = r4 + 45
            int r0 = r4 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r0
            int r4 = r4 % 2
            if (r4 == 0) goto L39
            r4 = 66
            int r4 = r4 / r1
            return r5
        L37:
            r4 = move-exception
            throw r4
        L39:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.PlaceComponentResult(boolean, android.view.View):android.view.View");
    }

    private List<Target> NetworkUserEntityData$$ExternalSyntheticLambda8() {
        ArrayList arrayList = new ArrayList();
        TextView textView = this.tvLocation;
        if (textView != null) {
            if (!(this.cvInfoLegendary == null) && this.viewTooltipSpotlightPointer != null) {
                int i = B + 45;
                C = i % 128;
                int i2 = i % 2;
                if (!(this.cvMerchant == null)) {
                    int i3 = B + 125;
                    C = i3 % 128;
                    int i4 = i3 % 2;
                    arrayList.add(BuiltInFictitiousFunctionClassFactory(textView, R.string.tooltip_onboarding_mapview_title_first, R.string.tooltip_onboarding_mapview_desc_first, false));
                    arrayList.add(BuiltInFictitiousFunctionClassFactory(this.viewTooltipSpotlightPointer, R.string.tooltip_onboarding_mapview_title_second, R.string.tooltip_onboarding_mapview_desc_second, true));
                    arrayList.add(BuiltInFictitiousFunctionClassFactory(this.cvInfoLegendary, R.string.tooltip_onboarding_mapview_title_third, R.string.tooltip_onboarding_mapview_desc_third, false));
                    arrayList.add(BuiltInFictitiousFunctionClassFactory(this.cvMerchant, R.string.tooltip_onboarding_mapview_title_fourth, R.string.tooltip_onboarding_mapview_desc_fourth, false));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.button_back})
    public void onButtonBackClicked() {
        try {
            int i = C + 61;
            B = i % 128;
            boolean z = i % 2 == 0;
            super.onBackPressed();
            if (!z) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(ShopModel shopModel, Drawable drawable, Location location) {
        Marker BuiltInFictitiousFunctionClassFactory;
        try {
            int i = C + 77;
            try {
                B = i % 128;
                int i2 = i % 2;
                if ((MyBillsEntityDataFactory(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1) ? '1' : ':') != '1') {
                    return;
                }
                int i3 = C + 37;
                B = i3 % 128;
                if (i3 % 2 != 0) {
                    BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(getAuthRequestContext(shopModel, drawable, location), shopModel);
                    if (!getAuthRequestContext(shopModel)) {
                        return;
                    }
                } else {
                    BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(getAuthRequestContext(shopModel, drawable, location), shopModel);
                    boolean authRequestContext = getAuthRequestContext(shopModel);
                    Object[] objArr = null;
                    int length = objArr.length;
                    if (!authRequestContext) {
                        return;
                    }
                }
                if (this.PrepareContext != null) {
                    this.PrepareContext = new Pair<>(this.PrepareContext.first, BuiltInFictitiousFunctionClassFactory);
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if ((r6.getTag() instanceof id.dana.nearbyme.model.ShopModel) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        r6 = (id.dana.nearbyme.model.ShopModel) r6.getTag();
        r0 = new android.location.Location("");
        r0.setLatitude(r6.DatabaseTableConfigUtil);
        r0.setLongitude(r6.PrepareContext);
        r6 = r5.mapHelper;
        r0 = id.dana.utils.LocationUtil.getAuthRequestContext(r0);
        r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        if (r6 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        r4 = kotlin.text.Typography.greater;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        r4 = '[';
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r4 == '[') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        r3 = id.dana.nearbyme.NearbyMeActivity.C + 39;
        id.dana.nearbyme.NearbyMeActivity.B = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        if ((r3 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        if (r2 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
    
        r6.animateCamera(id.dana.utils.MapHelper.getAuthRequestContext(r0, 17.0f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
    
        r6 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        r6.animateCamera(id.dana.utils.MapHelper.getAuthRequestContext(r0, 17.0f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if ((r6.getTag() instanceof id.dana.nearbyme.model.ShopModel) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void BuiltInFictitiousFunctionClassFactory(com.google.android.gms.maps.model.Marker r6) {
        /*
            r5 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L1c
            java.lang.Object r0 = r6.getTag()
            boolean r0 = r0 instanceof id.dana.nearbyme.model.ShopModel
            r3 = 63
            int r3 = r3 / r2
            if (r0 == 0) goto L71
            goto L24
        L1a:
            r6 = move-exception
            throw r6
        L1c:
            java.lang.Object r0 = r6.getTag()
            boolean r0 = r0 instanceof id.dana.nearbyme.model.ShopModel
            if (r0 == 0) goto L71
        L24:
            java.lang.Object r6 = r6.getTag()
            id.dana.nearbyme.model.ShopModel r6 = (id.dana.nearbyme.model.ShopModel) r6
            android.location.Location r0 = new android.location.Location
            java.lang.String r3 = ""
            r0.<init>(r3)
            double r3 = r6.DatabaseTableConfigUtil
            r0.setLatitude(r3)
            double r3 = r6.PrepareContext
            r0.setLongitude(r3)
            id.dana.utils.MapHelper r6 = r5.mapHelper
            com.google.android.gms.maps.model.LatLng r0 = id.dana.utils.LocationUtil.getAuthRequestContext(r0)
            com.google.android.gms.maps.GoogleMap r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            r3 = 91
            if (r6 == 0) goto L4a
            r4 = 62
            goto L4c
        L4a:
            r4 = 91
        L4c:
            if (r4 == r3) goto L71
            int r3 = id.dana.nearbyme.NearbyMeActivity.C
            int r3 = r3 + 39
            int r4 = r3 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L5b
            r2 = 1
        L5b:
            r3 = 1099431936(0x41880000, float:17.0)
            if (r2 == 0) goto L6a
            com.google.android.gms.maps.CameraUpdate r0 = id.dana.utils.MapHelper.getAuthRequestContext(r0, r3)
            r6.animateCamera(r0)
            int r6 = r1.length     // Catch: java.lang.Throwable -> L68
            goto L71
        L68:
            r6 = move-exception
            throw r6
        L6a:
            com.google.android.gms.maps.CameraUpdate r0 = id.dana.utils.MapHelper.getAuthRequestContext(r0, r3)
            r6.animateCamera(r0)
        L71:
            int r6 = id.dana.nearbyme.NearbyMeActivity.B
            int r6 = r6 + 85
            int r0 = r6 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r0
            int r6 = r6 % 2
            if (r6 == 0) goto L83
            r1.hashCode()     // Catch: java.lang.Throwable -> L81
            return
        L81:
            r6 = move-exception
            throw r6
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.BuiltInFictitiousFunctionClassFactory(com.google.android.gms.maps.model.Marker):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if ((r4.scheduleImpl.getState() != 3 ? '\b' : 'T') != 'T') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        showShimmerNearbyLocation();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r0 = id.dana.nearbyme.NearbyMeActivity.C + 79;
        id.dana.nearbyme.NearbyMeActivity.B = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        r4.presenter.KClassImpl$Data$declaredNonStaticMembers$2(new id.dana.nearbyme.LocationSourceTrackerWrapper(GetContactSyncConfig(), id.dana.analytics.tracker.TrackerDataKey.Source.NEARBY_2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r4.scheduleImpl.getState() != 2) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void moveToNextValue() {
        /*
            r4 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 81
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 78
            if (r0 == 0) goto L11
            r0 = 17
            goto L13
        L11:
            r0 = 78
        L13:
            if (r0 == r2) goto L20
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r4.scheduleImpl     // Catch: java.lang.Exception -> L1e
            int r0 = r0.getState()
            if (r0 == r1) goto L3e
            goto L32
        L1e:
            r0 = move-exception
            goto L4f
        L20:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r4.scheduleImpl
            int r0 = r0.getState()
            r2 = 3
            r3 = 84
            if (r0 == r2) goto L2e
            r0 = 8
            goto L30
        L2e:
            r0 = 84
        L30:
            if (r0 == r3) goto L3e
        L32:
            r4.showShimmerNearbyLocation()     // Catch: java.lang.Exception -> L1e
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 79
            int r2 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r2
            int r0 = r0 % r1
        L3e:
            id.dana.contract.nearbyme.NearbyMeContract$Presenter r0 = r4.presenter     // Catch: java.lang.Exception -> L50
            id.dana.nearbyme.LocationSourceTrackerWrapper r1 = new id.dana.nearbyme.LocationSourceTrackerWrapper
            android.location.Location r2 = r4.GetContactSyncConfig()
            java.lang.String r3 = "Nearby 2.0"
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L1e
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r1)     // Catch: java.lang.Exception -> L1e
            return
        L4f:
            throw r0
        L50:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.moveToNextValue():void");
    }

    private void lookAheadTest() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.nearbyme.NearbyMeActivity.9
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                permissionRequest.continueToPermissionRequest();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                if (permissionResult.MyBillsEntityDataFactory()) {
                    MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(NearbyMeActivity.this.getApplicationContext(), true);
                    NearbyMeActivity.access$2000(NearbyMeActivity.this);
                    return;
                }
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(NearbyMeActivity.this.getApplicationContext(), false);
                NearbyMeActivity.this.finish();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public void onShouldRedirectToSystemSettings(List<PermissionReport> list) {
                NearbyMeActivity.access$2100(NearbyMeActivity.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.PlaceComponentResult();
        int i = C + 25;
        B = i % 128;
        if (!(i % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        if ((r5.GetContactSyncConfig == null) != true) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        if (r5.GetContactSyncConfig != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        PrepareContext();
        r0 = r5.mapHelper;
        r1 = id.dana.utils.LocationUtil.getAuthRequestContext(r5.GetContactSyncConfig);
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        if (r0 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        r3 = id.dana.nearbyme.NearbyMeActivity.B + 109;
        id.dana.nearbyme.NearbyMeActivity.C = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        if ((r3 % 2) == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        r0.animateCamera(id.dana.utils.MapHelper.getAuthRequestContext(r1, 15.0f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        r0.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:
    
        r0.animateCamera(id.dana.utils.MapHelper.getAuthRequestContext(r1, 15.0f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        r0 = r5.cvGoToMyLocation;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        if (r0 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
    
        r1 = id.dana.nearbyme.NearbyMeActivity.B + 59;
        id.dana.nearbyme.NearbyMeActivity.C = r1 % 128;
        r1 = r1 % 2;
        r0.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        r0 = id.dana.nearbyme.NearbyMeActivity.C + 59;
        id.dana.nearbyme.NearbyMeActivity.B = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007c, code lost:
    
        initRecordTimeStamp().KClassImpl$Data$declaredNonStaticMembers$2 = false;
        r0 = id.dana.nearbyme.NearbyMeActivity.C + 41;
        id.dana.nearbyme.NearbyMeActivity.B = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008e, code lost:
    
        throw r0;
     */
    @butterknife.OnClick({id.dana.R.id.cv_go_to_my_location})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onGoToMyLocationClicked() {
        /*
            r5 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 27
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            r1 = 60
            if (r0 == 0) goto L11
            r0 = 75
            goto L13
        L11:
            r0 = 60
        L13:
            r2 = 0
            if (r0 == r1) goto L26
            android.location.Location r0 = r5.GetContactSyncConfig
            r1 = 38
            int r1 = r1 / r2
            r1 = 1
            if (r0 == 0) goto L20
            r0 = 0
            goto L21
        L20:
            r0 = 1
        L21:
            if (r0 == r1) goto L5c
            goto L2a
        L24:
            r0 = move-exception
            throw r0
        L26:
            android.location.Location r0 = r5.GetContactSyncConfig
            if (r0 == 0) goto L5c
        L2a:
            r5.PrepareContext()
            id.dana.utils.MapHelper r0 = r5.mapHelper
            android.location.Location r1 = r5.GetContactSyncConfig
            com.google.android.gms.maps.model.LatLng r1 = id.dana.utils.LocationUtil.getAuthRequestContext(r1)
            com.google.android.gms.maps.GoogleMap r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 == 0) goto L5c
            int r3 = id.dana.nearbyme.NearbyMeActivity.B
            int r3 = r3 + 109
            int r4 = r3 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r4
            int r3 = r3 % 2
            r4 = 1097859072(0x41700000, float:15.0)
            if (r3 == 0) goto L55
            com.google.android.gms.maps.CameraUpdate r1 = id.dana.utils.MapHelper.getAuthRequestContext(r1, r4)     // Catch: java.lang.Exception -> L8d
            r0.animateCamera(r1)     // Catch: java.lang.Exception -> L8d
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L53
            goto L5c
        L53:
            r0 = move-exception
            throw r0
        L55:
            com.google.android.gms.maps.CameraUpdate r1 = id.dana.utils.MapHelper.getAuthRequestContext(r1, r4)
            r0.animateCamera(r1)
        L5c:
            androidx.cardview.widget.CardView r0 = r5.cvGoToMyLocation     // Catch: java.lang.Exception -> L8d
            if (r0 == 0) goto L7c
            int r1 = id.dana.nearbyme.NearbyMeActivity.B
            int r1 = r1 + 59
            int r3 = r1 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r3
            int r1 = r1 % 2
            r1 = 8
            r0.setVisibility(r1)
            int r0 = id.dana.nearbyme.NearbyMeActivity.C     // Catch: java.lang.Exception -> L7a
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r1
            int r0 = r0 % 2
            goto L7c
        L7a:
            r0 = move-exception
            throw r0
        L7c:
            id.dana.nearbyme.DanaMapFragment r0 = r5.initRecordTimeStamp()
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r1
            int r0 = r0 % 2
            return
        L8d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.onGoToMyLocationClicked():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if ((r0 ? '0' : '5') != '5') goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        if (r2.NetworkUserEntityData$$ExternalSyntheticLambda1 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        r2.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        if (r2.lavMapCenterPinPoint.getVisibility() != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r0 = 'Y';
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        r0 = '\'';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
    
        if (r0 == 'Y') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
    
        r2.lavMapCenterPinPoint.setVisibility(8);
        r0 = id.dana.nearbyme.NearbyMeActivity.B + 29;
        id.dana.nearbyme.NearbyMeActivity.C = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        r0 = id.dana.nearbyme.NearbyMeActivity.C + 67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        id.dana.nearbyme.NearbyMeActivity.B = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void PrepareContext() {
        /*
            r2 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L20
            boolean r0 = r2.NetworkUserEntityData$$ExternalSyntheticLambda1
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L1e
            r1 = 53
            if (r0 == 0) goto L19
            r0 = 48
            goto L1b
        L19:
            r0 = 53
        L1b:
            if (r0 == r1) goto L28
            goto L24
        L1e:
            r0 = move-exception
            throw r0
        L20:
            boolean r0 = r2.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L56
            if (r0 == 0) goto L28
        L24:
            r0 = 0
            r2.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            return
        L28:
            id.dana.richview.PinMapLottieAnimationView r0 = r2.lavMapCenterPinPoint
            int r0 = r0.getVisibility()
            r1 = 89
            if (r0 != 0) goto L35
            r0 = 89
            goto L37
        L35:
            r0 = 39
        L37:
            if (r0 == r1) goto L3a
            goto L4b
        L3a:
            id.dana.richview.PinMapLottieAnimationView r0 = r2.lavMapCenterPinPoint
            r1 = 8
            r0.setVisibility(r1)
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 29
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
        L4b:
            int r0 = id.dana.nearbyme.NearbyMeActivity.C     // Catch: java.lang.Exception -> L56
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r1     // Catch: java.lang.Exception -> L56
            int r0 = r0 % 2
            return
        L56:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.PrepareContext():void");
    }

    private DanaMapFragment initRecordTimeStamp() {
        int i = B + 27;
        C = i % 128;
        if (!(i % 2 != 0)) {
            return (DanaMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        }
        DanaMapFragment danaMapFragment = (DanaMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        Object obj = null;
        obj.hashCode();
        return danaMapFragment;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
    
        if (r0 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        if (KClassImpl$Data$declaredNonStaticMembers$2(((com.google.android.gms.maps.model.Marker) r3.PrepareContext.first).getTag(), r4) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        KClassImpl$Data$declaredNonStaticMembers$2(((com.google.android.gms.maps.model.Marker) r3.PrepareContext.second).getTag(), r4);
        r4 = id.dana.nearbyme.NearbyMeActivity.B + 47;
        id.dana.nearbyme.NearbyMeActivity.C = r4 % 128;
        r4 = r4 % 2;
     */
    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onMarkerClick(com.google.android.gms.maps.model.Marker r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r4.getTag()
            boolean r0 = r0 instanceof id.dana.nearbyme.model.ShopModel
            r1 = 11
            if (r0 == 0) goto Ld
            r0 = 61
            goto Lf
        Ld:
            r0 = 11
        Lf:
            r2 = 1
            if (r0 == r1) goto L25
            r3.PrepareContext()
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r3.scheduleImpl     // Catch: java.lang.Exception -> L23
            getAuthRequestContext(r0)     // Catch: java.lang.Exception -> L23
            r3.BuiltInFictitiousFunctionClassFactory(r4)     // Catch: java.lang.Exception -> L23
            r3.NetworkUserEntityData$$ExternalSyntheticLambda8 = r2     // Catch: java.lang.Exception -> L23
            r3.KClassImpl$Data$declaredNonStaticMembers$2(r4)     // Catch: java.lang.Exception -> L23
            goto L8d
        L23:
            r4 = move-exception
            throw r4
        L25:
            java.lang.Object r0 = r4.getTag()
            boolean r0 = r0 instanceof id.dana.nearbyme.model.HighlightedShopModel
            if (r0 == 0) goto L2f
            r0 = 0
            goto L30
        L2f:
            r0 = 1
        L30:
            if (r0 == r2) goto L8d
            android.util.Pair<com.google.android.gms.maps.model.Marker, com.google.android.gms.maps.model.Marker> r0 = r3.PrepareContext     // Catch: java.lang.Exception -> L8b
            if (r0 == 0) goto L8d
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 69
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L5d
            java.lang.Object r4 = r4.getTag()
            id.dana.nearbyme.model.HighlightedShopModel r4 = (id.dana.nearbyme.model.HighlightedShopModel) r4
            android.util.Pair<com.google.android.gms.maps.model.Marker, com.google.android.gms.maps.model.Marker> r0 = r3.PrepareContext
            java.lang.Object r0 = r0.first
            com.google.android.gms.maps.model.Marker r0 = (com.google.android.gms.maps.model.Marker) r0
            java.lang.Object r0 = r0.getTag()
            boolean r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r0, r4)
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L5b
            if (r0 != 0) goto L8d
            goto L73
        L5b:
            r4 = move-exception
            throw r4
        L5d:
            java.lang.Object r4 = r4.getTag()     // Catch: java.lang.Exception -> L8b
            id.dana.nearbyme.model.HighlightedShopModel r4 = (id.dana.nearbyme.model.HighlightedShopModel) r4
            android.util.Pair<com.google.android.gms.maps.model.Marker, com.google.android.gms.maps.model.Marker> r0 = r3.PrepareContext
            java.lang.Object r0 = r0.first
            com.google.android.gms.maps.model.Marker r0 = (com.google.android.gms.maps.model.Marker) r0
            java.lang.Object r0 = r0.getTag()
            boolean r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r0, r4)
            if (r0 != 0) goto L8d
        L73:
            android.util.Pair<com.google.android.gms.maps.model.Marker, com.google.android.gms.maps.model.Marker> r0 = r3.PrepareContext
            java.lang.Object r0 = r0.second
            com.google.android.gms.maps.model.Marker r0 = (com.google.android.gms.maps.model.Marker) r0
            java.lang.Object r0 = r0.getTag()
            r3.KClassImpl$Data$declaredNonStaticMembers$2(r0, r4)
            int r4 = id.dana.nearbyme.NearbyMeActivity.B
            int r4 = r4 + 47
            int r0 = r4 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r0
            int r4 = r4 % 2
            goto L8d
        L8b:
            r4 = move-exception
            throw r4
        L8d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.onMarkerClick(com.google.android.gms.maps.model.Marker):boolean");
    }

    private static void getAuthRequestContext(BottomSheetBehavior bottomSheetBehavior) {
        int i = C + 73;
        B = i % 128;
        bottomSheetBehavior.setState((i % 2 == 0 ? Typography.less : '9') != '<' ? 4 : 3);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, HighlightedShopModel highlightedShopModel) {
        int i = C + 75;
        B = i % 128;
        int i2 = i % 2;
        if (highlightedShopModel != null) {
            if (obj instanceof ShopModel) {
                int i3 = C + 29;
                B = i3 % 128;
                int i4 = i3 % 2;
                ShopModel shopModel = (ShopModel) obj;
                if (highlightedShopModel.MyBillsEntityDataFactory == shopModel) {
                    MerchantDetailActivity.Companion companion = MerchantDetailActivity.INSTANCE;
                    MerchantDetailActivity.Companion.getAuthRequestContext(this, shopModel, TrackerKey.SourceType.NEARBY_MAPS);
                    int i5 = C + 47;
                    B = i5 % 128;
                    int i6 = i5 % 2;
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.tv_search_here})
    public void onRefreshMerchantClicked() {
        Location location;
        int i = C + 47;
        B = i % 128;
        int i2 = i % 2;
        try {
            NetworkUserEntityData$$ExternalSyntheticLambda0(RefreshCondition.REFRESHING);
            NetworkUserEntityData$$ExternalSyntheticLambda0();
            PrepareContext();
            this.merchantListView.clearPreSelectedCategory();
            GoogleMap googleMap = this.mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
            if ((googleMap != null ? (char) 14 : 'R') != 'R') {
                LatLng latLng = googleMap.getCameraPosition().target;
                location = LocationUtil.PlaceComponentResult(latLng.latitude, latLng.longitude);
                int i3 = B + 3;
                try {
                    C = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                location = null;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(location, false);
            this.scheduleImpl.setState(6);
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if ((!r1) != true) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        if (readMicros() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:
    
        r1 = id.dana.nearbyme.NearbyMeActivity.C + 85;
        id.dana.nearbyme.NearbyMeActivity.B = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        if ((r1 % 2) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.ImageView, android.view.View] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.animation.Animation] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void NetworkUserEntityData$$ExternalSyntheticLambda0(java.lang.String r7) {
        /*
            r6 = this;
            r6.NetworkUserEntityData$$ExternalSyntheticLambda3 = r7
            android.widget.TextView r0 = r6.tvSearchHere
            java.lang.String r1 = "ERROR"
            boolean r1 = r1.equals(r7)
            r2 = 3
            if (r1 == 0) goto Lf
            r1 = 3
            goto L11
        Lf:
            r1 = 71
        L11:
            r3 = 0
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L17
            goto L4c
        L17:
            int r1 = id.dana.nearbyme.NearbyMeActivity.B     // Catch: java.lang.Exception -> L88
            int r1 = r1 + 25
            int r2 = r1 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r2     // Catch: java.lang.Exception -> L86
            int r1 = r1 % 2
            if (r1 == 0) goto L32
            boolean r1 = r6.readMicros()
            int r2 = r3.length     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L2c
            r1 = 0
            goto L2d
        L2c:
            r1 = 1
        L2d:
            if (r1 == r5) goto L4c
            goto L38
        L30:
            r7 = move-exception
            throw r7
        L32:
            boolean r1 = r6.readMicros()
            if (r1 == 0) goto L4c
        L38:
            int r1 = id.dana.nearbyme.NearbyMeActivity.C
            int r1 = r1 + 85
            int r2 = r1 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r2
            int r1 = r1 % 2
            r2 = 60
            if (r1 != 0) goto L49
            r1 = 60
            goto L4b
        L49:
            r1 = 28
        L4b:
            r4 = 1
        L4c:
            int r1 = MyBillsEntityDataFactory(r4)
            r0.setVisibility(r1)
            android.widget.TextView r0 = r6.tvRefreshing
            java.lang.String r1 = "REFRESHING"
            boolean r2 = r1.equals(r7)
            int r2 = MyBillsEntityDataFactory(r2)
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r6.ivLoader
            boolean r2 = r1.equals(r7)
            int r2 = MyBillsEntityDataFactory(r2)
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r6.ivLoader
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L82
            android.view.animation.Animation r3 = r6.NetworkUserEntityData$$ExternalSyntheticLambda6
            int r7 = id.dana.nearbyme.NearbyMeActivity.B     // Catch: java.lang.Exception -> L88
            int r7 = r7 + r5
            int r1 = r7 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1     // Catch: java.lang.Exception -> L86
            int r7 = r7 % 2
        L82:
            r0.setAnimation(r3)
            return
        L86:
            r7 = move-exception
            throw r7
        L88:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r0 == null) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        r1 = id.dana.nearbyme.NearbyMeActivity.C + 89;
        id.dana.nearbyme.NearbyMeActivity.B = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if ((r1 % 2) != 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r0.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        r0.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
    
        r0 = id.dana.nearbyme.NearbyMeActivity.B + 101;
        id.dana.nearbyme.NearbyMeActivity.C = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
    
        r4.newProxyInstance.clear();
        r4.PrepareContext = null;
        D();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        /*
            r4 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 119
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L1f
            id.dana.utils.MapHelper r0 = r4.mapHelper
            com.google.android.gms.maps.GoogleMap r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 == 0) goto L1b
            goto L1c
        L1b:
            r1 = 1
        L1c:
            if (r1 == 0) goto L28
            goto L4a
        L1f:
            id.dana.utils.MapHelper r0 = r4.mapHelper
            com.google.android.gms.maps.GoogleMap r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            r3.hashCode()     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L4a
        L28:
            int r1 = id.dana.nearbyme.NearbyMeActivity.C
            int r1 = r1 + 89
            int r2 = r1 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L3d
            r0.clear()     // Catch: java.lang.Exception -> L3b
            int r0 = r3.length     // Catch: java.lang.Throwable -> L39
            goto L40
        L39:
            r0 = move-exception
            throw r0
        L3b:
            r0 = move-exception
            throw r0
        L3d:
            r0.clear()
        L40:
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
        L4a:
            java.util.HashMap<java.lang.String, com.google.android.gms.maps.model.Marker> r0 = r4.newProxyInstance
            r0.clear()
            r4.PrepareContext = r3
            r4.D()
            return
        L55:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0():void");
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Location location, boolean z) {
        int i = B + 25;
        C = i % 128;
        if (i % 2 != 0) {
            int i2 = 79 / 0;
            if (location == null) {
                return;
            }
        } else {
            if ((location != null ? '4' : 'T') == 'T') {
                return;
            }
        }
        try {
            int i3 = C + 41;
            B = i3 % 128;
            if (i3 % 2 != 0) {
                this.presenter.getAuthRequestContext(location, 3000, z);
                return;
            }
            try {
                this.presenter.getAuthRequestContext(location, 6860, z);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private boolean readMicros() {
        DanaMapFragment initRecordTimeStamp = initRecordTimeStamp();
        if (!(initRecordTimeStamp == null)) {
            int i = C + 125;
            B = i % 128;
            int i2 = i % 2;
            if (!initRecordTimeStamp.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                return false;
            }
            int i3 = C + 85;
            B = i3 % 128;
            int i4 = i3 % 2;
            return true;
        }
        return false;
    }

    private void D() {
        Marker BuiltInFictitiousFunctionClassFactory;
        MapHelper mapHelper;
        float f;
        Location location = this.GetContactSyncConfig;
        if (location == null) {
            return;
        }
        int i = B + 91;
        C = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.mapHelper.getAuthRequestContext(location, (Drawable) null));
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = BuiltInFictitiousFunctionClassFactory;
            mapHelper = this.mapHelper;
            int length = objArr.length;
            if ((BuiltInFictitiousFunctionClassFactory != null ? (char) 6 : '.') == '.') {
                return;
            }
        } else {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.mapHelper.getAuthRequestContext(location, (Drawable) null));
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = BuiltInFictitiousFunctionClassFactory;
            mapHelper = this.mapHelper;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                return;
            }
        }
        try {
            GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
            if (googleMap != null) {
                int i2 = B + 19;
                C = i2 % 128;
                f = (i2 % 2 != 0 ? '`' : '#') != '#' ? googleMap.getCameraPosition().zoom - 30.0f : googleMap.getCameraPosition().zoom / 30.0f;
            } else {
                f = 0.0f;
            }
            BuiltInFictitiousFunctionClassFactory.setAnchor(f, f);
            int i3 = B + 79;
            C = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void MyBillsEntityDataFactory(Location location) {
        try {
            int i = B + 73;
            C = i % 128;
            int i2 = i % 2;
            NetworkUserEntityData$$ExternalSyntheticLambda0();
            this.lavMapCenterPinPoint.setVisibility(0);
            A();
            this.merchantListView.clearPreSelectedCategory();
            KClassImpl$Data$declaredNonStaticMembers$2(location, false);
            this.scheduleImpl.setState(6);
            int i3 = C + 57;
            B = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.iv_clear})
    public void onIvClearClicked() {
        int i = C + 13;
        B = i % 128;
        int i2 = i % 2;
        try {
            this.etNearbySearch.getText().clear();
            this.scheduleImpl.setState(4);
            int i3 = B + 19;
            C = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.tv_change})
    public void onTvChangeClicked() {
        int i = B + 109;
        C = i % 128;
        int i2 = i % 2;
        try {
            try {
                BuiltInFictitiousFunctionClassFactory(this.scheduleImpl);
                int i3 = C + 97;
                B = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 22 : 'P') != 22) {
                    return;
                }
                int i4 = 78 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(BottomSheetBehavior bottomSheetBehavior) {
        try {
            int i = B + 101;
            C = i % 128;
            int i2 = i % 2;
            bottomSheetBehavior.setState(3);
            int i3 = B + 31;
            C = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.tv_title_nearby_location})
    public void onTextSwipeUpClicked() {
        Object obj = null;
        try {
            if ((MyBillsEntityDataFactory(this.scheduleImpl) ? 'M' : '+') == '+') {
                getAuthRequestContext(this.scheduleImpl);
                int i = B + 51;
                C = i % 128;
                if ((i % 2 != 0 ? 'H' : (char) 17) != 'H') {
                    return;
                }
                obj.hashCode();
                return;
            }
            int i2 = B + 63;
            C = i2 % 128;
            if (i2 % 2 == 0) {
                BuiltInFictitiousFunctionClassFactory(this.scheduleImpl);
                return;
            }
            BuiltInFictitiousFunctionClassFactory(this.scheduleImpl);
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private static boolean MyBillsEntityDataFactory(BottomSheetBehavior bottomSheetBehavior) {
        int i = B + 7;
        C = i % 128;
        int i2 = i % 2;
        if (bottomSheetBehavior.getState() != 4) {
            return false;
        }
        int i3 = B + 61;
        C = i3 % 128;
        int i4 = i3 % 2;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnTouch({R.id.et_nearby_search})
    public boolean onTextSearchTouched(View view, MotionEvent motionEvent) {
        int i = B + 39;
        C = i % 128;
        int i2 = i % 2;
        if ((1 == motionEvent.getAction() ? 'b' : (char) 28) == 'b') {
            int i3 = B + 107;
            C = i3 % 128;
            if (i3 % 2 != 0) {
            }
            hideShimmerNearbyLocation();
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
            BuiltInFictitiousFunctionClassFactory(this.scheduleImpl);
            this.merchantListView.displayLocationMerchantSearchView();
        }
        return false;
    }

    public void hideShimmerNearbyLocation() {
        SkeletonScreen skeletonScreen;
        int i = B + 17;
        C = i % 128;
        if ((i % 2 != 0 ? Typography.amp : (char) 22) != 22) {
            skeletonScreen = this.whenAvailable;
            Object obj = null;
            obj.hashCode();
            if (skeletonScreen == null) {
                return;
            }
        } else {
            skeletonScreen = this.whenAvailable;
            if ((skeletonScreen != null ? '-' : 'b') != '-') {
                return;
            }
        }
        skeletonScreen.PlaceComponentResult();
        int i2 = C + 73;
        B = i2 % 128;
        int i3 = i2 % 2;
    }

    private void VerifyPinStateManager$executeRiskChallenge$2$2() {
        BottomSheetBehavior from = BottomSheetBehavior.from(this.cvMerchant);
        this.scheduleImpl = from;
        from.setPeekHeight(getResources().getDimensionPixelSize(R.dimen.f33342131165978));
        this.scheduleImpl.setHideable(false);
        this.scheduleImpl.setFitToContents(false);
        this.scheduleImpl.setHalfExpandedRatio(0.4f);
        this.scheduleImpl.setState(6);
        this.scheduleImpl.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.nearbyme.NearbyMeActivity.10
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View view, int i) {
                if (i == 1) {
                    NearbyMeActivity.this.tvDistrictLocation.setVisibility(8);
                    NearbyMeActivity.this.tvChangeLocation.setVisibility(8);
                    NearbyMeActivity.this.merchantListView.showSpacer(false);
                } else if (i == 6) {
                    NearbyMeActivity.access$2202(NearbyMeActivity.this, false);
                    NearbyMeActivity.this.merchantListView.showSpacer(false);
                    KeyboardHelper.MyBillsEntityDataFactory(NearbyMeActivity.this);
                    NearbyMeActivity.access$2500(NearbyMeActivity.this);
                    NearbyMeActivity.this.clLocationContainer.setVisibility(0);
                    NearbyMeActivity.this.tvDistrictLocation.setVisibility(8);
                    NearbyMeActivity.this.tvChangeLocation.setVisibility(8);
                    NearbyMeActivity.this.merchantListView.resetLocationMerchantSearchView();
                    NearbyMeActivity.access$2400(NearbyMeActivity.this);
                } else if (i == 3) {
                    NearbyMeActivity.access$2202(NearbyMeActivity.this, false);
                    NearbyMeActivity.this.merchantListView.showSpacer(false);
                    NearbyMeActivity.this.clLocationContainer.setVisibility(8);
                    NearbyMeActivity.this.tvDistrictLocation.setVisibility(0);
                    NearbyMeActivity.this.tvChangeLocation.setVisibility(0);
                    NearbyMeActivity.access$2300(NearbyMeActivity.this);
                    NearbyMeActivity.this.hideShimmerNearbyLocation();
                    NearbyMeActivity.access$2400(NearbyMeActivity.this);
                } else if (i == 4) {
                    NearbyMeActivity.this.merchantListView.showSpacer(true);
                    KeyboardHelper.MyBillsEntityDataFactory(NearbyMeActivity.this);
                    NearbyMeActivity.access$2500(NearbyMeActivity.this);
                    NearbyMeActivity.this.clLocationContainer.setVisibility(0);
                    NearbyMeActivity.this.tvDistrictLocation.setVisibility(8);
                    NearbyMeActivity.this.tvChangeLocation.setVisibility(8);
                    NearbyMeActivity.this.merchantListView.resetLocationMerchantSearchView();
                    NearbyMeActivity.access$802(NearbyMeActivity.this, false);
                    if (NearbyMeActivity.access$1000(NearbyMeActivity.this)) {
                        NearbyMeActivity.access$900(NearbyMeActivity.this);
                    }
                    if (NearbyMeActivity.access$2600(NearbyMeActivity.this)) {
                        NearbyMeActivity nearbyMeActivity = NearbyMeActivity.this;
                        NearbyMeActivity.access$2800(nearbyMeActivity, NearbyMeActivity.access$2700(nearbyMeActivity));
                        NearbyMeActivity.access$2602(NearbyMeActivity.this, false);
                    }
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View view, float f) {
                if (NearbyMeActivity.access$2900(NearbyMeActivity.this, f)) {
                    NearbyMeActivity.this.clLocationContainer.setVisibility(8);
                    NearbyMeActivity.access$3000(NearbyMeActivity.this, f);
                    NearbyMeActivity.this.hideShimmerNearbyLocation();
                }
            }
        });
        int i = B + 23;
        C = i % 128;
        if (i % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private boolean MyBillsEntityDataFactory(String str) {
        HashMap<String, Marker> hashMap = this.newProxyInstance;
        if ((hashMap != null ? (char) 25 : '!') == 25) {
            int i = C + 61;
            B = i % 128;
            int i2 = i % 2;
            try {
                if (!hashMap.isEmpty()) {
                    if (!(this.newProxyInstance.get(str) == null)) {
                        int i3 = B + 23;
                        C = i3 % 128;
                        int i4 = i3 % 2;
                        int i5 = C + 69;
                        B = i5 % 128;
                        int i6 = i5 % 2;
                        return true;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return false;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(List<ShopModel> list) {
        int i = C + 13;
        B = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? (char) 6 : 'J') != 'J') {
            this.merchantListView.setMerchantList(list);
            int length = objArr.length;
        } else {
            this.merchantListView.setMerchantList(list);
        }
        int i2 = C + 91;
        B = i2 % 128;
        if ((i2 % 2 == 0 ? '%' : '\\') != '%') {
            return;
        }
        int length2 = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if ((r3.scheduleImpl.getState() == 3) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        r3.scheduleImpl.setState(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        super.onBackPressed();
        r0 = id.dana.nearbyme.NearbyMeActivity.C + 31;
        id.dana.nearbyme.NearbyMeActivity.B = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if ((r3.scheduleImpl.getState() == 5 ? 'O' : 'P') != 'O') goto L17;
     */
    @Override // androidx.view.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBackPressed() {
        /*
            r3 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 65
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L1f
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r3.scheduleImpl
            int r0 = r0.getState()
            r1 = 5
            r2 = 79
            if (r0 != r1) goto L1a
            r0 = 79
            goto L1c
        L1a:
            r0 = 80
        L1c:
            if (r0 == r2) goto L2d
            goto L34
        L1f:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r3.scheduleImpl
            int r0 = r0.getState()
            r1 = 3
            if (r0 != r1) goto L2a
            r0 = 1
            goto L2b
        L2a:
            r0 = 0
        L2b:
            if (r0 == 0) goto L34
        L2d:
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r3.scheduleImpl
            r1 = 4
            r0.setState(r1)
            return
        L34:
            super.onBackPressed()
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 31
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r1
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.onBackPressed():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.tv_location, R.id.tv_change, R.id.tv_change_location})
    public void onLocationSearchClicked() {
        int i = C + 17;
        B = i % 128;
        if (!(i % 2 == 0)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
            BuiltInFictitiousFunctionClassFactory(this.scheduleImpl);
            this.merchantListView.displayLocationSearchView();
            return;
        }
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = false;
            BuiltInFictitiousFunctionClassFactory(this.scheduleImpl);
            try {
                this.merchantListView.displayLocationSearchView();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private Marker BuiltInFictitiousFunctionClassFactory(MarkerOptions markerOptions) {
        int i = C + 1;
        B = i % 128;
        int i2 = i % 2;
        GoogleMap googleMap = this.mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        Object obj = null;
        if ((googleMap != null ? Typography.greater : (char) 3) != '>') {
            int i3 = B + 47;
            C = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 85 / 0;
                return null;
            }
            return null;
        }
        int i5 = C + 35;
        B = i5 % 128;
        if (i5 % 2 == 0) {
            Marker addMarker = googleMap.addMarker(markerOptions);
            obj.hashCode();
            return addMarker;
        }
        return googleMap.addMarker(markerOptions);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:31:0x0052
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(id.dana.nearbyme.model.ShopModel r4) {
        /*
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 3
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L13
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L11
            if (r4 == 0) goto L45
            goto L15
        L11:
            r4 = move-exception
            throw r4
        L13:
            if (r4 == 0) goto L45
        L15:
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 31
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            java.lang.String r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L27
            r0 = 1
            goto L28
        L27:
            r0 = 0
        L28:
            if (r0 == r1) goto L2b
            goto L45
        L2b:
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 15
            int r3 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L38
            r1 = 0
        L38:
            if (r1 == 0) goto L3d
            java.lang.String r4 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8
            return r4
        L3d:
            java.lang.String r4 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8
            r0 = 65
            int r0 = r0 / r2
            return r4
        L43:
            r4 = move-exception
            throw r4
        L45:
            java.lang.String r4 = ""
            int r0 = id.dana.nearbyme.NearbyMeActivity.B
            int r0 = r0 + 123
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r1
            int r0 = r0 % 2
            return r4
        L52:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.nearbyme.model.ShopModel):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        if (r0 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        return r9.mapHelper.BuiltInFictitiousFunctionClassFactory(r10.BottomSheetCardBindingView$watcherCardNumberView$1, r12, id.dana.R.layout.view_popular_marker, r11, id.dana.R.id.iv_popular_marker_loadable, id.dana.R.drawable.ic_img_merchant_popular);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        if (r10.NetworkUserEntityData$$ExternalSyntheticLambda7() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
    
        r0 = new id.dana.utils.MarkerPayload(r10.BottomSheetCardBindingView$watcherCardNumberView$1, r12, r11);
        r10 = r9.mapHelper;
        r11 = id.dana.utils.MapHelper.KClassImpl$Data$declaredNonStaticMembers$2(r0.getErrorConfigVersion, r0.MyBillsEntityDataFactory(), r0.MyBillsEntityDataFactory, java.lang.String.valueOf(r0.getAuthRequestContext + r0.PlaceComponentResult), r0.BuiltInFictitiousFunctionClassFactory);
        r12 = r10.getErrorConfigVersion.get(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
    
        if (r12 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
    
        r12 = new com.google.android.gms.maps.model.MarkerOptions().position(r0.MyBillsEntityDataFactory());
        r1 = r10.BuiltInFictitiousFunctionClassFactory;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, "");
        r1 = id.dana.utils.CustomMarkerUtils.MyBillsEntityDataFactory(r1, r0.PlaceComponentResult, r0.MyBillsEntityDataFactory, r0.getAuthRequestContext, r0.BuiltInFictitiousFunctionClassFactory);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "");
        r12 = r12.icon(id.dana.utils.MapHelper.MyBillsEntityDataFactory(r1)).zIndex(r0.lookAheadTest);
        r10.getErrorConfigVersion.put(r11, r12);
        r10 = id.dana.nearbyme.NearbyMeActivity.B + 35;
        id.dana.nearbyme.NearbyMeActivity.C = r10 % 128;
        r10 = r10 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b2, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b3, code lost:
    
        r10 = r9.mapHelper.BuiltInFictitiousFunctionClassFactory(r10.BottomSheetCardBindingView$watcherCardNumberView$1, r12, id.dana.R.layout.view_custom_marker, r11, id.dana.R.id.iv_custom_marker_loadable, MyBillsEntityDataFactory(r10));
        r11 = id.dana.nearbyme.NearbyMeActivity.C + 109;
        id.dana.nearbyme.NearbyMeActivity.B = r11 % 128;
        r11 = r11 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d1, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (r9.getCallingPid.contains(r10.BottomSheetCardBindingView$watcherCardNumberView$1) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.android.gms.maps.model.MarkerOptions PlaceComponentResult(id.dana.nearbyme.model.ShopModel r10, android.graphics.drawable.Drawable r11, android.location.Location r12) {
        /*
            r9 = this;
            int r0 = id.dana.nearbyme.NearbyMeActivity.C
            int r0 = r0 + 95
            int r1 = r0 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r1
            int r0 = r0 % 2
            r1 = 75
            if (r0 != 0) goto L11
            r0 = 75
            goto L13
        L11:
            r0 = 74
        L13:
            if (r0 == r1) goto L20
            java.util.HashSet<java.lang.String> r0 = r9.getCallingPid
            java.lang.String r1 = r10.BottomSheetCardBindingView$watcherCardNumberView$1
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L42
            goto L2e
        L20:
            java.util.HashSet<java.lang.String> r0 = r9.getCallingPid
            java.lang.String r1 = r10.BottomSheetCardBindingView$watcherCardNumberView$1
            boolean r0 = r0.contains(r1)
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> Ld2
            if (r0 == 0) goto L42
        L2e:
            id.dana.utils.MapHelper r2 = r9.mapHelper
            java.lang.String r3 = r10.BottomSheetCardBindingView$watcherCardNumberView$1
            r5 = 2131559997(0x7f0d063d, float:1.8745354E38)
            r7 = 2131364831(0x7f0a0bdf, float:1.834951E38)
            r8 = 2131233177(0x7f080999, float:1.8082484E38)
            r4 = r12
            r6 = r11
            com.google.android.gms.maps.model.MarkerOptions r10 = r2.BuiltInFictitiousFunctionClassFactory(r3, r4, r5, r6, r7, r8)
            return r10
        L42:
            boolean r0 = r10.NetworkUserEntityData$$ExternalSyntheticLambda7()
            if (r0 == 0) goto Lb3
            id.dana.utils.MarkerPayload r0 = new id.dana.utils.MarkerPayload
            java.lang.String r10 = r10.BottomSheetCardBindingView$watcherCardNumberView$1
            r0.<init>(r10, r12, r11)
            id.dana.utils.MapHelper r10 = r9.mapHelper
            java.lang.String r11 = r0.getErrorConfigVersion
            com.google.android.gms.maps.model.LatLng r12 = r0.MyBillsEntityDataFactory()
            android.graphics.drawable.Drawable r1 = r0.MyBillsEntityDataFactory
            int r2 = r0.getAuthRequestContext
            int r3 = r0.PlaceComponentResult
            int r4 = r0.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + r3
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r11 = id.dana.utils.MapHelper.KClassImpl$Data$declaredNonStaticMembers$2(r11, r12, r1, r2, r4)
            java.util.HashMap<java.lang.String, com.google.android.gms.maps.model.MarkerOptions> r12 = r10.getErrorConfigVersion
            java.lang.Object r12 = r12.get(r11)
            com.google.android.gms.maps.model.MarkerOptions r12 = (com.google.android.gms.maps.model.MarkerOptions) r12
            if (r12 != 0) goto Lb2
            com.google.android.gms.maps.model.MarkerOptions r12 = new com.google.android.gms.maps.model.MarkerOptions
            r12.<init>()
            com.google.android.gms.maps.model.LatLng r1 = r0.MyBillsEntityDataFactory()
            com.google.android.gms.maps.model.MarkerOptions r12 = r12.position(r1)
            android.content.Context r1 = r10.BuiltInFictitiousFunctionClassFactory
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            int r3 = r0.PlaceComponentResult
            android.graphics.drawable.Drawable r4 = r0.MyBillsEntityDataFactory
            int r5 = r0.getAuthRequestContext
            int r6 = r0.BuiltInFictitiousFunctionClassFactory
            android.graphics.Bitmap r1 = id.dana.utils.CustomMarkerUtils.MyBillsEntityDataFactory(r1, r3, r4, r5, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = id.dana.utils.MapHelper.MyBillsEntityDataFactory(r1)
            com.google.android.gms.maps.model.MarkerOptions r12 = r12.icon(r1)
            float r0 = r0.lookAheadTest
            com.google.android.gms.maps.model.MarkerOptions r12 = r12.zIndex(r0)
            java.util.HashMap<java.lang.String, com.google.android.gms.maps.model.MarkerOptions> r10 = r10.getErrorConfigVersion
            r10.put(r11, r12)
            int r10 = id.dana.nearbyme.NearbyMeActivity.B
            int r10 = r10 + 35
            int r11 = r10 % 128
            id.dana.nearbyme.NearbyMeActivity.C = r11
            int r10 = r10 % 2
        Lb2:
            return r12
        Lb3:
            id.dana.utils.MapHelper r0 = r9.mapHelper
            java.lang.String r1 = r10.BottomSheetCardBindingView$watcherCardNumberView$1
            int r6 = MyBillsEntityDataFactory(r10)
            r3 = 2131559641(0x7f0d04d9, float:1.8744632E38)
            r5 = 2131364572(0x7f0a0adc, float:1.8348985E38)
            r2 = r12
            r4 = r11
            com.google.android.gms.maps.model.MarkerOptions r10 = r0.BuiltInFictitiousFunctionClassFactory(r1, r2, r3, r4, r5, r6)
            int r11 = id.dana.nearbyme.NearbyMeActivity.C
            int r11 = r11 + 109
            int r12 = r11 % 128
            id.dana.nearbyme.NearbyMeActivity.B = r12
            int r11 = r11 % 2
            return r10
        Ld2:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.NearbyMeActivity.PlaceComponentResult(id.dana.nearbyme.model.ShopModel, android.graphics.drawable.Drawable, android.location.Location):com.google.android.gms.maps.model.MarkerOptions");
    }

    private static int MyBillsEntityDataFactory(ShopModel shopModel) {
        int i;
        int i2 = B + 35;
        C = i2 % 128;
        int i3 = i2 % 2;
        if (("216620000020928274717".equals(shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3) ? (char) 0 : ']') != 0) {
            i = R.drawable.ic_img_merchant_normal;
        } else {
            i = R.drawable.ic_img_merchant_non;
            int i4 = B + 53;
            C = i4 % 128;
            int i5 = i4 % 2;
        }
        int i6 = C + 31;
        B = i6 % 128;
        if ((i6 % 2 == 0 ? 'D' : '2') != 'D') {
            return i;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return i;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(ShopModel shopModel, Location location) {
        int i = C + 37;
        B = i % 128;
        int i2 = i % 2;
        MapHelper mapHelper = this.mapHelper;
        if ((mapHelper.getAuthRequestContext == null ? (char) 4 : '(') != '(') {
            try {
                int i3 = B + 109;
                C = i3 % 128;
                int i4 = i3 % 2;
                mapHelper.getAuthRequestContext = MapHelper.MyBillsEntityDataFactory(CustomMarkerUtils.PlaceComponentResult(mapHelper.BuiltInFictitiousFunctionClassFactory));
            } catch (Exception e) {
                throw e;
            }
        }
        this.newProxyInstance.put(shopModel.BottomSheetCardBindingView$watcherCardNumberView$1, BuiltInFictitiousFunctionClassFactory(new MarkerOptions().position(LocationUtil.getAuthRequestContext(location)).icon(mapHelper.getAuthRequestContext).zIndex(0.1f)));
        MyBillsEntityDataFactory(shopModel, new AnonymousClass6(shopModel, location));
        try {
            int i5 = C + 29;
            B = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private ShopModel NetworkUserEntityData$$ExternalSyntheticLambda0(ShopModel shopModel) {
        MyBillsEntityDataFactory(shopModel, new AnonymousClass4(shopModel, LocationUtil.PlaceComponentResult(shopModel.DatabaseTableConfigUtil, shopModel.PrepareContext)));
        int i = B + 99;
        C = i % 128;
        if ((i % 2 != 0 ? ')' : (char) 18) != ')') {
            return shopModel;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return shopModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupCameraListener$14$id-dana-nearbyme-NearbyMeActivity  reason: not valid java name */
    public /* synthetic */ void m2708lambda$setupCameraListener$14$iddananearbymeNearbyMeActivity() {
        try {
            int i = C + 103;
            B = i % 128;
            Location location = null;
            if (!(i % 2 == 0)) {
                A();
                if (this.lavMapCenterPinPoint.getVisibility() != 0) {
                    return;
                }
            } else {
                A();
                int visibility = this.lavMapCenterPinPoint.getVisibility();
                location.hashCode();
                if (visibility != 0) {
                    return;
                }
            }
            GoogleMap googleMap = this.mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
            if (googleMap != null) {
                LatLng latLng = googleMap.getCameraPosition().target;
                location = LocationUtil.PlaceComponentResult(latLng.latitude, latLng.longitude);
            } else {
                int i2 = C + 51;
                B = i2 % 128;
                int i3 = i2 % 2;
            }
            this.presenter.KClassImpl$Data$declaredNonStaticMembers$2(new LocationSourceTrackerWrapper(location, TrackerDataKey.Source.NEARBY_2));
            this.presenter.getAuthRequestContext(location);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void rhEKZjsciI(long j, long j2) {
        long j3 = j ^ (j2 << 32);
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        a((Process.myPid() >> 22) + 6, new int[]{-552958546, 2139337391, 1966108216, -132137152}, objArr);
        sb.append((String) objArr[0]);
        sb.append(j3);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
        RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
        Intrinsics.checkNotNullParameter(dexguardException, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(dexguardException);
        RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.TAMPERED);
        UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.TAMPERED);
        int i = B + 67;
        C = i % 128;
        int i2 = i % 2;
    }

    private static void b(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i ? 'G' : (char) 1) == 1) {
                break;
            }
            int i3 = $10 + 117;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (readMicros[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ BottomSheetCardBindingView$watcherCardNumberView$1))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i];
        try {
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            int i5 = $11 + 63;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            while (true) {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i ? (char) 21 : ')') != 21) {
                    objArr[0] = new String(cArr);
                    return;
                }
                int i7 = $10 + 89;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                try {
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = VerifyPinStateManager$executeRiskChallenge$2$1;
        if ((iArr2 != null ? '\b' : (char) 29) != 29) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    int i3 = $11 + 95;
                    $10 = i3 % 128;
                    int i4 = i3 % 2;
                    iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
                } catch (Exception e) {
                    throw e;
                }
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = VerifyPinStateManager$executeRiskChallenge$2$1;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i5 = 0; i5 < length3; i5++) {
                iArr6[i5] = (int) (iArr5[i5] ^ (-3152031022165484798L));
            }
            int i6 = $10 + 57;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory >= iArr.length) {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i8 = 0; i8 < 16; i8++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i8];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i9 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i9;
            }
            int i10 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i10;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i11 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i12 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            int i13 = $11 + 25;
            $10 = i13 % 128;
            int i14 = i13 % 2;
        }
    }
}
