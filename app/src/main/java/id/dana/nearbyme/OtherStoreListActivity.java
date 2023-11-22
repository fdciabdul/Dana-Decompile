package id.dana.nearbyme;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ExpandableListView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import androidx.view.ComponentActivity;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.contract.nearbyme.OtherStoreListContract;
import id.dana.di.component.ApplicationComponent;
import id.dana.drawable.NewNearbyMeActivity;
import id.dana.model.OtherStoreListResultModel;
import id.dana.nearbyme.adapter.OtherStoreListAdapter;
import id.dana.nearbyme.adapter.OtherStoreListAdapter$hideLoadingSkeleton$1;
import id.dana.nearbyme.adapter.OtherStoreListAdapter$hideSeeMoreButton$1;
import id.dana.nearbyme.adapter.OtherStoreListListener;
import id.dana.nearbyme.di.component.DaggerOtherStoreListComponent;
import id.dana.nearbyme.di.module.OtherStoreListModule;
import id.dana.nearbyme.enums.SearchType;
import id.dana.nearbyme.homeshopping.HomeShoppingDialogFragment;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailViewState;
import id.dana.nearbyme.model.MerchantItemWrapper;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.LocationUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import id.dana.utils.showcase.Utils;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b<\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0019\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0003\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0003\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0016\u0010\t\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\u000e\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0013R\u0016\u0010\u0010\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0013R\"\u0010'\u001a\u00020&8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u0010$\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010!\u001a\u0002078\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b;\u0010\u0013"}, d2 = {"Lid/dana/nearbyme/OtherStoreListActivity;", "Lid/dana/base/BaseActivity;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "getLayout", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", IAPSyncCommand.COMMAND_INIT, "", "p0", "(Z)V", "getErrorConfigVersion", "()Z", "lookAheadTest", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "Landroid/view/animation/LayoutAnimationController;", "scheduleImpl", "Landroid/view/animation/LayoutAnimationController;", "PlaceComponentResult", "", SummaryActivity.DAYS, "MyBillsEntityDataFactory", "Landroidx/recyclerview/widget/LinearLayoutManager;", "DatabaseTableConfigUtil", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Lio/reactivex/disposables/Disposable;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lio/reactivex/disposables/Disposable;", "GetContactSyncConfig", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "isLayoutRequested", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "nearbyAnalyticTracker", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "getNearbyAnalyticTracker", "()Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "setNearbyAnalyticTracker", "(Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;)V", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;", "presenter", "Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;", "getPresenter", "()Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;", "setPresenter", "(Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;)V", "Lid/dana/nearbyme/adapter/OtherStoreListAdapter;", "PrepareContext", "Lid/dana/nearbyme/adapter/OtherStoreListAdapter;", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OtherStoreListActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int[] NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Disposable moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2 */
    private double getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private ActivityPermissionRequest initRecordTimeStamp;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private OtherStoreListAdapter GetContactSyncConfig;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private LayoutAnimationController KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest */
    private double MyBillsEntityDataFactory;
    @Inject
    public NearbyAnalyticTracker nearbyAnalyticTracker;
    @Inject
    public OtherStoreListContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private LayoutAnimationController PlaceComponentResult;
    public static final byte[] $$a = {TarHeader.LF_CHR, 112, -114, 9, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 87;
    public static final byte[] getAuthRequestContext = {105, 42, 72, -81, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 66;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory = "";

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String scheduleImpl = "";

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String lookAheadTest = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1 = "";

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private String DatabaseTableConfigUtil = "";

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private LinearLayoutManager getAuthRequestContext = new LinearLayoutManager(this, 1, false);

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        NetworkUserEntityData$$ExternalSyntheticLambda5 = new int[]{279143144, 1863778427, -106351654, -831583885, -1676244989, 695065057, -1286028786, -219133016, 75134599, 719365414, -890827823, 79078605, 1164920436, 1894723559, -1194710155, -898300452, -1448608230, 1133584975};
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = 23 - r6
            int r8 = 55 - r8
            byte[] r0 = id.dana.nearbyme.OtherStoreListActivity.getAuthRequestContext
            int r7 = 106 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L15:
            r3 = 0
        L16:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            int r7 = r7 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.OtherStoreListActivity.b(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = id.dana.nearbyme.OtherStoreListActivity.$$a
            int r9 = r9 * 3
            int r9 = 42 - r9
            int r8 = 46 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L33
        L18:
            r3 = 0
        L19:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L33:
            int r7 = r7 + r8
            int r7 = r7 + (-7)
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.OtherStoreListActivity.c(int, byte, short, java.lang.Object[]):void");
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new int[]{-1495016149, 1214977565, -569604495, -435817807, 1528945392, -1395243781, 777737965, -18527196, -1642999552, 1870764991}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(((byte) KeyEvent.getModifierMetaStateMask()) + 6, new int[]{-1310008544, 269941315, -1546425730, -1858873222}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((ViewConfiguration.getTapTimeout() >> 16) + 48, new int[]{-1382339103, 497597308, -1594509511, 1753972510, 395230800, -1873649438, 306696617, 1762008236, -1954411462, 395427510, -490807072, 1509405675, -878201267, 1396758610, -953598077, -975165071, 1035596696, 1498265923, -2045658852, 2059277457, 1219507662, 1332236269, -2050223671, -1645272319}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - TextUtils.getTrimmedLength(""), new int[]{-1915936109, 1174195615, -1875150786, -1662240324, 1582295998, 163387486, 91784335, -2080812759, 1937091224, -1529321393, -1953003782, -1649507595, -1989132395, -666452807, -1568580122, -321627955, 255576430, -188285121, 1943897995, 1832932529, 1197235998, 1088788210, 1252435455, -1416009925, 759541656, 2006468412, 1009269241, 1965505728, 996261516, -60951878, 895091004, 457840425}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), new int[]{813926561, -562073457, 672531154, -62563694, 1497720689, 219740702, -665170392, -166622838, 606042024, -1786606918, -1483030511, -158061192, -1305043671, 177287012, -223959357, -1537576211, 1536619261, -61426784, 1080586393, 2041462820, 1481765682, 376671071, 1823951168, 1554666696, 1540206421, -38403095, -1840690710, -2033093172, -656836302, -415873589, -1272852773, 1670086467}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(View.combineMeasuredStates(0, 0) + 60, new int[]{1226605774, -937140514, 148488201, 288605783, 1014519354, 46649721, 408635501, 163034596, 1968123312, -638313663, 1446660190, 805599009, 879677562, -2022262785, -1300288076, -551587626, 2000720287, -655506251, 1257926022, -833915138, 1696041092, -1285368946, -1403168362, 1971659042, 185279643, 1451938324, 390101283, 270826436, -1667747632, -524861691}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(6 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new int[]{-1791410536, -2072637975, -1784920213, 388673325}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, TextUtils.lastIndexOf("", '0', 0) + 19, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr13 = new Object[1];
                b(getAuthRequestContext[30], getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[30], getAuthRequestContext[9], (short) 30, objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.getOffsetAfter("", 0), 2 - TextUtils.indexOf((CharSequence) "", '0'), (char) TextUtils.getCapsMode("", 0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[53], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 800, 15 - TextUtils.indexOf("", "", 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 30, (char) (57995 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getJumpTapTimeout() >> 16), 15 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (ViewConfiguration.getJumpTapTimeout() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), KeyEvent.keyCodeFromString("") + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {946577907, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr19 = {this};
                Object[] objArr20 = new Object[1];
                b(getAuthRequestContext[30], getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                b(getAuthRequestContext[30], getAuthRequestContext[9], (short) 30, objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 60, KeyEvent.getDeadChar(0, 0) + 46, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1));
                        Object[] objArr23 = new Object[1];
                        c($$a[9], $$a[84], $$a[8], objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr25 = {946577907, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), (Process.myTid() >> 22) + 18, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr26 = {this};
                Object[] objArr27 = new Object[1];
                b(getAuthRequestContext[30], getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                b(getAuthRequestContext[30], getAuthRequestContext[9], (short) 30, objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 118, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2, (char) (TextUtils.lastIndexOf("", '0') + 38969));
                        Object[] objArr30 = new Object[1];
                        c($$a[9], $$a[84], $$a[8], objArr30);
                        obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                    int i2 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getOffsetAfter("", 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {946577907, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr32);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr33 = {this};
                Object[] objArr34 = new Object[1];
                b(getAuthRequestContext[30], getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                Object[] objArr35 = new Object[1];
                b(getAuthRequestContext[30], getAuthRequestContext[9], (short) 30, objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 107, 4 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16));
                        byte b = (byte) ($$a[78] - 1);
                        byte b2 = b;
                        Object[] objArr37 = new Object[1];
                        c(b, b2, b2, objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (Process.myPid() >> 22) + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr39 = {946577907, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, 18 - View.MeasureSpec.getMode(0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr39);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_other_store_list;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(getPackageName().codePointAt(4) - 79, new int[]{-1495016149, 1214977565, -569604495, -435817807, 1528945392, -1395243781, 777737965, -18527196, -1642999552, 1870764991}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(super.getResources().getString(R.string.ep_tnc_gold).substring(20, 21).codePointAt(0) - 27, new int[]{-1310008544, 269941315, -1546425730, -1858873222}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr4 = new Object[1];
                    b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    b(getAuthRequestContext[41], getAuthRequestContext[48], getAuthRequestContext[25], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) r6[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{-1495016149, 1214977565, -569604495, -435817807, -1189744919, 161595131, 1396432780, 1865863474, 1853651928, 2132538087, 1179574401, -449585766, -1125354517, -1116904791}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.pushverify_general_error_title).substring(11, 12).length() + 17, new int[]{-2060457068, -1906960800, -1402279053, 865043459, 431743074, 448093105, 1482839837, -959831898, 528853291, 1829756445}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(super.getResources().getString(R.string.quest_success_claim_title).substring(5, 7).codePointAt(1) - 68, new int[]{-1382339103, 497597308, -1594509511, 1753972510, 395230800, -1873649438, 306696617, 1762008236, -1954411462, 395427510, -490807072, 1509405675, -878201267, 1396758610, -953598077, -975165071, 1035596696, 1498265923, -2045658852, 2059277457, 1219507662, 1332236269, -2050223671, -1645272319}, objArr7);
                    String str = (String) objArr7[0];
                    try {
                        Object[] objArr8 = new Object[1];
                        b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b(getAuthRequestContext[41], getAuthRequestContext[48], getAuthRequestContext[25], objArr9);
                        Object[] objArr10 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 31, new int[]{-1915936109, 1174195615, -1875150786, -1662240324, 1582295998, 163387486, 91784335, -2080812759, 1937091224, -1529321393, -1953003782, -1649507595, -1989132395, -666452807, -1568580122, -321627955, 255576430, -188285121, 1943897995, 1832932529, 1197235998, 1088788210, 1252435455, -1416009925, 759541656, 2006468412, 1009269241, 1965505728, 996261516, -60951878, 895091004, 457840425}, objArr10);
                        String str2 = (String) objArr10[0];
                        try {
                            Object[] objArr11 = new Object[1];
                            b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (getAuthRequestContext[49] - 1), objArr11);
                            Class<?> cls5 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            b(getAuthRequestContext[41], getAuthRequestContext[48], getAuthRequestContext[25], objArr12);
                            Object[] objArr13 = new Object[1];
                            a(((ApplicationInfo) cls5.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 31, new int[]{813926561, -562073457, 672531154, -62563694, 1497720689, 219740702, -665170392, -166622838, 606042024, -1786606918, -1483030511, -158061192, -1305043671, 177287012, -223959357, -1537576211, 1536619261, -61426784, 1080586393, 2041462820, 1481765682, 376671071, 1823951168, 1554666696, 1540206421, -38403095, -1840690710, -2033093172, -656836302, -415873589, -1272852773, 1670086467}, objArr13);
                            String str3 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            a(60 - ((Process.getThreadPriority(0) + 20) >> 6), new int[]{1226605774, -937140514, 148488201, 288605783, 1014519354, 46649721, 408635501, 163034596, 1968123312, -638313663, 1446660190, 805599009, 879677562, -2022262785, -1300288076, -551587626, 2000720287, -655506251, 1257926022, -833915138, 1696041092, -1285368946, -1403168362, 1971659042, 185279643, 1451938324, 390101283, 270826436, -1667747632, -524861691}, objArr14);
                            String str4 = (String) objArr14[0];
                            Object[] objArr15 = new Object[1];
                            a(getPackageName().length() - 1, new int[]{-1791410536, -2072637975, -1784920213, 388673325}, objArr15);
                            try {
                                Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr16);
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
        try {
            Object[] objArr17 = new Object[1];
            b(getAuthRequestContext[30], getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), objArr17);
            Class<?> cls6 = Class.forName((String) objArr17[0]);
            Object[] objArr18 = new Object[1];
            b(getAuthRequestContext[30], getAuthRequestContext[9], (short) 30, objArr18);
            try {
                Object[] objArr19 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 4 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) View.resolveSizeAndState(0, 0, 0));
                    byte b = (byte) ($$a[78] - 1);
                    byte b2 = b;
                    Object[] objArr20 = new Object[1];
                    c(b, b2, b2, objArr20);
                    obj3 = cls7.getMethod((String) objArr20[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                int i = ((int[]) objArr21[1])[0];
                if (((int[]) objArr21[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSize(0, 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr22 = {-503756792, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr22);
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                }
                super.onCreate(bundle);
            } catch (Throwable th8) {
                Throwable cause8 = th8.getCause();
                if (cause8 == null) {
                    throw th8;
                }
                throw cause8;
            }
        } catch (Throwable th9) {
            Throwable cause9 = th9.getCause();
            if (cause9 == null) {
                throw th9;
            }
            throw cause9;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.lbl_enter_phone_number_intro).substring(11, 13).codePointAt(1) - 85, new int[]{-1495016149, 1214977565, -569604495, -435817807, -1189744919, 161595131, 1396432780, 1865863474, 1853651928, 2132538087, 1179574401, -449585766, -1125354517, -1116904791}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.card_binding_permission_dialog_button_cancel).substring(1, 2).codePointAt(0) - 47, new int[]{-2060457068, -1906960800, -1402279053, 865043459, 431743074, 448093105, 1482839837, -959831898, 528853291, 1829756445}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 35 - ExpandableListView.getPackedPositionType(0L), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.twilio_enroll_success_message).substring(1, 2).length() + 25, new int[]{-1495016149, 1214977565, -569604495, -435817807, -1189744919, 161595131, 1396432780, 1865863474, 1853651928, 2132538087, 1179574401, -449585766, -1125354517, -1116904791}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(18 - TextUtils.indexOf("", "", 0, 0), new int[]{-2060457068, -1906960800, -1402279053, 865043459, 431743074, 448093105, 1482839837, -959831898, 528853291, 1829756445}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    }

    @JvmName(name = "getPresenter")
    public final OtherStoreListContract.Presenter getPresenter() {
        OtherStoreListContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(OtherStoreListContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getNearbyAnalyticTracker")
    public final NearbyAnalyticTracker getNearbyAnalyticTracker() {
        NearbyAnalyticTracker nearbyAnalyticTracker = this.nearbyAnalyticTracker;
        if (nearbyAnalyticTracker != null) {
            return nearbyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setNearbyAnalyticTracker")
    public final void setNearbyAnalyticTracker(NearbyAnalyticTracker nearbyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(nearbyAnalyticTracker, "");
        this.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        LayoutAnimationController loadLayoutAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.f4612130772000);
        Intrinsics.checkNotNullExpressionValue(loadLayoutAnimation, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = loadLayoutAnimation;
        LayoutAnimationController loadLayoutAnimation2 = AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.f4622130772001);
        Intrinsics.checkNotNullExpressionValue(loadLayoutAnimation2, "");
        this.PlaceComponentResult = loadLayoutAnimation2;
        DaggerOtherStoreListComponent.Builder MyBillsEntityDataFactory = DaggerOtherStoreListComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (OtherStoreListModule) Preconditions.getAuthRequestContext(new OtherStoreListModule(new OtherStoreListContract.View() { // from class: id.dana.nearbyme.OtherStoreListActivity$initInjection$1
            @Override // id.dana.contract.nearbyme.OtherStoreListContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(List list) {
                OtherStoreListContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.contract.nearbyme.OtherStoreListContract.View
            public final /* synthetic */ void getAuthRequestContext(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                OtherStoreListAdapter otherStoreListAdapter;
                otherStoreListAdapter = OtherStoreListActivity.this.GetContactSyncConfig;
                if (otherStoreListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    otherStoreListAdapter = null;
                }
                List<MerchantItemWrapper> items = otherStoreListAdapter.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "");
                CollectionsKt.removeAll((List) items, (Function1) OtherStoreListAdapter$hideLoadingSkeleton$1.INSTANCE);
                otherStoreListAdapter.notifyDataSetChanged();
            }

            @Override // id.dana.contract.nearbyme.OtherStoreListContract.View
            public final void getAuthRequestContext(OtherStoreListResultModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OtherStoreListActivity.access$checkToolbarTitle(OtherStoreListActivity.this, p0.BuiltInFictitiousFunctionClassFactory);
                OtherStoreListActivity.access$populateShopItem(OtherStoreListActivity.this, p0.BuiltInFictitiousFunctionClassFactory);
                OtherStoreListActivity.access$showSeeMoreButtonIfHasMore(OtherStoreListActivity.this, p0.getGetAuthRequestContext());
            }

            @Override // id.dana.contract.nearbyme.OtherStoreListContract.View
            public final void getAuthRequestContext() {
                OtherStoreListAdapter otherStoreListAdapter;
                otherStoreListAdapter = OtherStoreListActivity.this.GetContactSyncConfig;
                if (otherStoreListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    otherStoreListAdapter = null;
                }
                List<MerchantItemWrapper> items = otherStoreListAdapter.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "");
                CollectionsKt.removeAll((List) items, (Function1) OtherStoreListAdapter$hideLoadingSkeleton$1.INSTANCE);
                otherStoreListAdapter.notifyDataSetChanged();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, OtherStoreListModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerOtherStoreListComponent.OtherStoreListComponentImpl(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).MyBillsEntityDataFactory(this);
        BuiltInFictitiousFunctionClassFactory();
        Bundle extras = getIntent().getExtras();
        OtherStoreListAdapter otherStoreListAdapter = null;
        String string = extras != null ? extras.getString("bundle_merchant_id") : null;
        if (string == null) {
            string = "";
        }
        this.scheduleImpl = string;
        Bundle extras2 = getIntent().getExtras();
        String string2 = extras2 != null ? extras2.getString("bundle_merchant_name") : null;
        if (string2 == null) {
            string2 = "";
        }
        this.lookAheadTest = string2;
        Bundle extras3 = getIntent().getExtras();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.MyBillsEntityDataFactory = extras3 != null ? extras3.getDouble("bundle_lat") : 0.0d;
        Bundle extras4 = getIntent().getExtras();
        if (extras4 != null) {
            d = extras4.getDouble("bundle_long");
        }
        this.getErrorConfigVersion = d;
        Bundle extras5 = getIntent().getExtras();
        String string3 = extras5 != null ? extras5.getString("bundle_search_type") : null;
        if (string3 == null) {
            string3 = "";
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = string3;
        Bundle extras6 = getIntent().getExtras();
        String string4 = extras6 != null ? extras6.getString("bundle_search_keyword") : null;
        if (string4 == null) {
            string4 = "";
        }
        this.DatabaseTableConfigUtil = string4;
        Bundle extras7 = getIntent().getExtras();
        String string5 = extras7 != null ? extras7.getString("bundle_source") : null;
        if (string5 == null) {
            string5 = "";
        }
        this.BuiltInFictitiousFunctionClassFactory = string5;
        BuiltInFictitiousFunctionClassFactory$default(this, false, 1, null);
        OtherStoreListAdapter otherStoreListAdapter2 = new OtherStoreListAdapter(new OtherStoreListListener() { // from class: id.dana.nearbyme.OtherStoreListActivity$initAdapter$1
            @Override // id.dana.nearbyme.adapter.OtherStoreListListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                OtherStoreListAdapter otherStoreListAdapter3;
                OtherStoreListAdapter otherStoreListAdapter4;
                otherStoreListAdapter3 = OtherStoreListActivity.this.GetContactSyncConfig;
                OtherStoreListAdapter otherStoreListAdapter5 = null;
                if (otherStoreListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    otherStoreListAdapter3 = null;
                }
                List<MerchantItemWrapper> items = otherStoreListAdapter3.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "");
                CollectionsKt.removeAll((List) items, (Function1) OtherStoreListAdapter$hideSeeMoreButton$1.INSTANCE);
                otherStoreListAdapter3.notifyDataSetChanged();
                otherStoreListAdapter4 = OtherStoreListActivity.this.GetContactSyncConfig;
                if (otherStoreListAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    otherStoreListAdapter5 = otherStoreListAdapter4;
                }
                otherStoreListAdapter5.getItems().add(new MerchantItemWrapper(3, new ShopModel()));
                otherStoreListAdapter5.notifyDataSetChanged();
                OtherStoreListActivity.this.getAuthRequestContext();
            }

            @Override // id.dana.nearbyme.adapter.OtherStoreListListener
            public final void BuiltInFictitiousFunctionClassFactory(ShopModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OtherStoreListActivity.access$goToMerchantDetailActivity(OtherStoreListActivity.this, p0);
            }

            @Override // id.dana.nearbyme.adapter.OtherStoreListListener
            public final void BuiltInFictitiousFunctionClassFactory(List<? extends PromoInfoModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OtherStoreListActivity.access$showPromoBottomSheet(OtherStoreListActivity.this, p0);
            }

            @Override // id.dana.nearbyme.adapter.OtherStoreListListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(MerchantDetailViewState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OtherStoreListActivity.this.getNearbyAnalyticTracker().MyBillsEntityDataFactory(p0.PlaceComponentResult, TrackerKey.SourceType.SHOP_LIST);
                Intrinsics.checkNotNullParameter(TrackerKey.SourceType.SHOP_LIST, "");
                p0.MyBillsEntityDataFactory = TrackerKey.SourceType.SHOP_LIST;
                HomeShoppingDialogFragment.Companion companion = HomeShoppingDialogFragment.INSTANCE;
                FragmentManager supportFragmentManager = OtherStoreListActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                HomeShoppingDialogFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(supportFragmentManager, p0);
            }
        });
        this.GetContactSyncConfig = otherStoreListAdapter2;
        otherStoreListAdapter2.setItems(CollectionsKt.arrayListOf(new MerchantItemWrapper(2, new ShopModel())));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1174_verifypinshared_errorsnackbarcallback_1);
        OtherStoreListAdapter otherStoreListAdapter3 = this.GetContactSyncConfig;
        if (otherStoreListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            otherStoreListAdapter3 = null;
        }
        recyclerView.setAdapter(otherStoreListAdapter3);
        recyclerView.setLayoutManager(this.getAuthRequestContext);
        final RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1174_verifypinshared_errorsnackbarcallback_1);
        if (recyclerView2 != null) {
            recyclerView2.setNestedScrollingEnabled(true);
            recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.nearbyme.OtherStoreListActivity$initOnScrollShowBackToTop$1$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    RecyclerView recyclerView3 = (RecyclerView) OtherStoreListActivity.this._$_findCachedViewById(R.id.res_0x7f0a1174_verifypinshared_errorsnackbarcallback_1);
                    RecyclerView.LayoutManager layoutManager = recyclerView3 != null ? recyclerView3.getLayoutManager() : null;
                    if (layoutManager == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    }
                    if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() == 0) {
                        OtherStoreListActivity.access$toggleShowSeeMoreButton(OtherStoreListActivity.this, false);
                    } else {
                        OtherStoreListActivity.access$toggleShowSeeMoreButton(OtherStoreListActivity.this, true);
                    }
                }
            });
            CardView cardView = (CardView) _$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572);
            if (cardView != null) {
                cardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.OtherStoreListActivity$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OtherStoreListActivity.$r8$lambda$M25nDtDDd7BiyubYtE9JWut7HdY(RecyclerView.this, view);
                    }
                });
                Unit unit = Unit.INSTANCE;
            }
        }
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.res_0x7f0a023f_apistatus_availablesince)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.OtherStoreListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtherStoreListActivity.m2729$r8$lambda$dNXwTqb9p2nQIONoBd47rqd_jY(OtherStoreListActivity.this, view);
            }
        });
        OtherStoreListAdapter otherStoreListAdapter4 = this.GetContactSyncConfig;
        if (otherStoreListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            otherStoreListAdapter = otherStoreListAdapter4;
        }
        otherStoreListAdapter.getItems().add(new MerchantItemWrapper(3, new ShopModel()));
        otherStoreListAdapter.notifyDataSetChanged();
        KClassImpl$Data$declaredNonStaticMembers$2();
        getNearbyAnalyticTracker().PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest);
    }

    private final boolean getErrorConfigVersion() {
        return OSUtil.GetContactSyncConfig() && ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, "android.permission.ACCESS_FINE_LOCATION") != 0;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (LocationUtil.getAuthRequestContext(this)) {
            if (this.initRecordTimeStamp == null) {
                BuiltInFictitiousFunctionClassFactory();
            }
            ActivityPermissionRequest activityPermissionRequest = this.initRecordTimeStamp;
            if (activityPermissionRequest != null) {
                activityPermissionRequest.check();
                return;
            }
            return;
        }
        lookAheadTest();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.nearbyme.OtherStoreListActivity$buildPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(OtherStoreListActivity.this.getApplicationContext(), true);
                    OtherStoreListActivity.access$initLocationUpdateRequest(OtherStoreListActivity.this);
                    OtherStoreListActivity.BuiltInFictitiousFunctionClassFactory$default(OtherStoreListActivity.this, false, 1, null);
                    return;
                }
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(OtherStoreListActivity.this.getApplicationContext(), false);
                OtherStoreListActivity.access$showError(OtherStoreListActivity.this);
                OtherStoreListActivity.this.BuiltInFictitiousFunctionClassFactory(true);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.continueToPermissionRequest();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OtherStoreListActivity.access$showError(OtherStoreListActivity.this);
                OtherStoreListActivity.this.BuiltInFictitiousFunctionClassFactory(true);
                PermissionHelper.MyBillsEntityDataFactory(OtherStoreListActivity.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.initRecordTimeStamp = builder.PlaceComponentResult();
    }

    public final void getAuthRequestContext() {
        getPresenter().MyBillsEntityDataFactory(this.scheduleImpl, this.MyBillsEntityDataFactory, this.getErrorConfigVersion, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory$default(OtherStoreListActivity otherStoreListActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        otherStoreListActivity.BuiltInFictitiousFunctionClassFactory(z);
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        setMenuLeftButton(p0 ? R.drawable.ic_close : R.drawable.btn_arrow_left);
        setCenterTitle(HtmlCompat.PlaceComponentResult(this.lookAheadTest, 0).toString());
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JE\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/nearbyme/OtherStoreListActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/nearbyme/model/ShopModel;", "p1", "", "p2", "p3", "Lid/dana/nearbyme/enums/SearchType;", "p4", "", "p5", "p6", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/nearbyme/model/ShopModel;DDLid/dana/nearbyme/enums/SearchType;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lid/dana/nearbyme/enums/SearchType;Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void BuiltInFictitiousFunctionClassFactory(Context p0, ShopModel p1, double p2, double p3, SearchType p4, String p5, String p6) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p4, "");
            Intrinsics.checkNotNullParameter(p5, "");
            Intrinsics.checkNotNullParameter(p6, "");
            Intent intent = new Intent(p0, OtherStoreListActivity.class);
            intent.putExtra("bundle_lat", p2);
            intent.putExtra("bundle_long", p3);
            intent.putExtra("bundle_merchant_id", p1.NetworkUserEntityData$$ExternalSyntheticLambda3);
            intent.putExtra("bundle_merchant_name", p1.NetworkUserEntityData$$ExternalSyntheticLambda6);
            intent.putExtra("bundle_search_type", p4.getValue());
            intent.putExtra("bundle_search_keyword", p5);
            intent.putExtra("bundle_source", p6);
            p0.startActivity(intent);
        }

        public static void BuiltInFictitiousFunctionClassFactory(Context p0, String p1, String p2, SearchType p3, String p4, String p5) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            Intrinsics.checkNotNullParameter(p5, "");
            Intent intent = new Intent(p0, OtherStoreListActivity.class);
            intent.putExtra("bundle_merchant_id", p1);
            intent.putExtra("bundle_merchant_name", p2);
            intent.putExtra("bundle_search_type", p3.getValue());
            intent.putExtra("bundle_search_keyword", p4);
            intent.putExtra("bundle_source", p5);
            p0.startActivity(intent);
        }
    }

    public static /* synthetic */ void $r8$lambda$M25nDtDDd7BiyubYtE9JWut7HdY(RecyclerView recyclerView, View view) {
        Intrinsics.checkNotNullParameter(recyclerView, "");
        recyclerView.scrollToPosition(0);
    }

    public static /* synthetic */ void $r8$lambda$M2stQ5ZuWFHgxH0NyKlIYZTqQTs(OtherStoreListActivity otherStoreListActivity, Location location) {
        if (location != null) {
            otherStoreListActivity.MyBillsEntityDataFactory = location.getLatitude();
            otherStoreListActivity.getErrorConfigVersion = location.getLongitude();
        } else {
            Location authRequestContext = LocationUtil.getAuthRequestContext();
            otherStoreListActivity.MyBillsEntityDataFactory = authRequestContext.getLatitude();
            otherStoreListActivity.getErrorConfigVersion = authRequestContext.getLongitude();
        }
        otherStoreListActivity.getAuthRequestContext();
        Disposable disposable = otherStoreListActivity.moveToNextValue;
        if (disposable != null) {
            disposable.dispose();
        }
        otherStoreListActivity.moveToNextValue = null;
    }

    public static /* synthetic */ void $r8$lambda$ZbZ_KfNYUx5bjnLrv2K4nXK0ZKo(OtherStoreListActivity otherStoreListActivity, LocationSettingsResult locationSettingsResult) {
        Status status;
        IntentSender intentSender;
        Unit unit = null;
        if (locationSettingsResult != null && (status = locationSettingsResult.getStatus()) != null) {
            int statusCode = status.getStatusCode();
            if (statusCode == 6) {
                PendingIntent resolution = status.getResolution();
                if (resolution != null && (intentSender = resolution.getIntentSender()) != null) {
                    LocationUtil.MyBillsEntityDataFactory(otherStoreListActivity, intentSender);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    Utils.PlaceComponentResult(otherStoreListActivity);
                }
            } else if (statusCode == 8502) {
                return;
            } else {
                Utils.PlaceComponentResult(otherStoreListActivity);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Utils.PlaceComponentResult(otherStoreListActivity);
        }
    }

    /* renamed from: $r8$lambda$dNXwTqb9p2nQIO-NoBd47rqd_jY */
    public static /* synthetic */ void m2729$r8$lambda$dNXwTqb9p2nQIONoBd47rqd_jY(OtherStoreListActivity otherStoreListActivity, View view) {
        Intrinsics.checkNotNullParameter(otherStoreListActivity, "");
        ((RecyclerView) otherStoreListActivity._$_findCachedViewById(R.id.res_0x7f0a1174_verifypinshared_errorsnackbarcallback_1)).setVisibility(0);
        otherStoreListActivity._$_findCachedViewById(R.id.DefaultStepCreator).setVisibility(8);
        otherStoreListActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        OtherStoreListAdapter otherStoreListAdapter = otherStoreListActivity.GetContactSyncConfig;
        OtherStoreListAdapter otherStoreListAdapter2 = null;
        if (otherStoreListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            otherStoreListAdapter = null;
        }
        List<MerchantItemWrapper> items = otherStoreListAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        CollectionsKt.removeAll((List) items, (Function1) new Function1<MerchantItemWrapper, Boolean>() { // from class: id.dana.nearbyme.adapter.OtherStoreListAdapter$hideErrorView$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(MerchantItemWrapper merchantItemWrapper) {
                return Boolean.valueOf(merchantItemWrapper.BuiltInFictitiousFunctionClassFactory == 4);
            }
        });
        otherStoreListAdapter.getItems().add(new MerchantItemWrapper(2, new ShopModel()));
        otherStoreListAdapter.notifyDataSetChanged();
        OtherStoreListAdapter otherStoreListAdapter3 = otherStoreListActivity.GetContactSyncConfig;
        if (otherStoreListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            otherStoreListAdapter2 = otherStoreListAdapter3;
        }
        otherStoreListAdapter2.getItems().add(new MerchantItemWrapper(3, new ShopModel()));
        otherStoreListAdapter2.notifyDataSetChanged();
    }

    public static final /* synthetic */ void access$checkToolbarTitle(OtherStoreListActivity otherStoreListActivity, List list) {
        Object obj;
        if (otherStoreListActivity.lookAheadTest.length() == 0) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ShopModel) obj).NetworkUserEntityData$$ExternalSyntheticLambda6 != null) {
                    break;
                }
            }
            ShopModel shopModel = (ShopModel) obj;
            String str = shopModel != null ? shopModel.NetworkUserEntityData$$ExternalSyntheticLambda6 : null;
            if (str == null) {
                str = "";
            }
            otherStoreListActivity.lookAheadTest = str;
            BuiltInFictitiousFunctionClassFactory$default(otherStoreListActivity, false, 1, null);
        }
    }

    public static final /* synthetic */ void access$goToMerchantDetailActivity(OtherStoreListActivity otherStoreListActivity, ShopModel shopModel) {
        shopModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = otherStoreListActivity.lookAheadTest;
        NewNearbyMeActivity.Companion companion = NewNearbyMeActivity.INSTANCE;
        NewNearbyMeActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(otherStoreListActivity, shopModel, TrackerKey.SourceType.NEARBY_SHOP_LIST);
    }

    public static final /* synthetic */ void access$initLocationUpdateRequest(final OtherStoreListActivity otherStoreListActivity) {
        if (otherStoreListActivity.getErrorConfigVersion()) {
            otherStoreListActivity.KClassImpl$Data$declaredNonStaticMembers$2();
            return;
        }
        Disposable disposable = otherStoreListActivity.moveToNextValue;
        if (disposable != null) {
            disposable.dispose();
        }
        otherStoreListActivity.moveToNextValue = null;
        Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) otherStoreListActivity.getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.nearbyme.OtherStoreListActivity$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OtherStoreListActivity.$r8$lambda$M2stQ5ZuWFHgxH0NyKlIYZTqQTs(OtherStoreListActivity.this, (Location) obj);
            }
        });
        otherStoreListActivity.moveToNextValue = subscribe;
        otherStoreListActivity.addDisposable(subscribe);
    }

    public static final /* synthetic */ void access$populateShopItem(OtherStoreListActivity otherStoreListActivity, List list) {
        OtherStoreListAdapter otherStoreListAdapter = otherStoreListActivity.GetContactSyncConfig;
        if (otherStoreListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            otherStoreListAdapter = null;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new MerchantItemWrapper(0, (ShopModel) it.next()));
        }
        otherStoreListAdapter.appendItems(arrayList);
    }

    public static final /* synthetic */ void access$showError(OtherStoreListActivity otherStoreListActivity) {
        OtherStoreListAdapter otherStoreListAdapter = otherStoreListActivity.GetContactSyncConfig;
        OtherStoreListAdapter otherStoreListAdapter2 = null;
        if (otherStoreListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            otherStoreListAdapter = null;
        }
        List<MerchantItemWrapper> items = otherStoreListAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        CollectionsKt.removeAll((List) items, (Function1) OtherStoreListAdapter$hideLoadingSkeleton$1.INSTANCE);
        otherStoreListAdapter.notifyDataSetChanged();
        OtherStoreListAdapter otherStoreListAdapter3 = otherStoreListActivity.GetContactSyncConfig;
        if (otherStoreListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            otherStoreListAdapter2 = otherStoreListAdapter3;
        }
        List<MerchantItemWrapper> items2 = otherStoreListAdapter2.getItems();
        Intrinsics.checkNotNullExpressionValue(items2, "");
        CollectionsKt.removeAll((List) items2, (Function1) new Function1<MerchantItemWrapper, Boolean>() { // from class: id.dana.nearbyme.adapter.OtherStoreListAdapter$hideLabel$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(MerchantItemWrapper merchantItemWrapper) {
                return Boolean.valueOf(merchantItemWrapper.BuiltInFictitiousFunctionClassFactory == 2);
            }
        });
        otherStoreListAdapter2.notifyDataSetChanged();
        otherStoreListActivity._$_findCachedViewById(R.id.DefaultStepCreator).setVisibility(0);
        ((RecyclerView) otherStoreListActivity._$_findCachedViewById(R.id.res_0x7f0a1174_verifypinshared_errorsnackbarcallback_1)).setVisibility(8);
    }

    public static final /* synthetic */ void access$showPromoBottomSheet(OtherStoreListActivity otherStoreListActivity, List list) {
        PromoListDialogFragment promoListDialogFragment = new PromoListDialogFragment(otherStoreListActivity);
        promoListDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        promoListDialogFragment.show(otherStoreListActivity.getSupportFragmentManager(), "Show Nearby Promo List Dialog");
    }

    public static final /* synthetic */ void access$showSeeMoreButtonIfHasMore(OtherStoreListActivity otherStoreListActivity, boolean z) {
        OtherStoreListAdapter otherStoreListAdapter = null;
        if (z) {
            OtherStoreListAdapter otherStoreListAdapter2 = otherStoreListActivity.GetContactSyncConfig;
            if (otherStoreListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                otherStoreListAdapter = otherStoreListAdapter2;
            }
            otherStoreListAdapter.getItems().add(new MerchantItemWrapper(1, new ShopModel()));
            otherStoreListAdapter.notifyDataSetChanged();
            return;
        }
        OtherStoreListAdapter otherStoreListAdapter3 = otherStoreListActivity.GetContactSyncConfig;
        if (otherStoreListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            otherStoreListAdapter = otherStoreListAdapter3;
        }
        List<MerchantItemWrapper> items = otherStoreListAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        CollectionsKt.removeAll((List) items, (Function1) OtherStoreListAdapter$hideSeeMoreButton$1.INSTANCE);
        otherStoreListAdapter.notifyDataSetChanged();
    }

    public static final /* synthetic */ void access$toggleShowSeeMoreButton(OtherStoreListActivity otherStoreListActivity, boolean z) {
        Slide slide = new Slide((byte) 0);
        slide.setDuration(600L);
        slide.addTarget((CardView) otherStoreListActivity._$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572));
        TransitionManager.getAuthRequestContext((ConstraintLayout) otherStoreListActivity._$_findCachedViewById(R.id.cl_parent), slide);
        ((CardView) otherStoreListActivity._$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572)).setVisibility(z ? 0 : 8);
    }

    private final void lookAheadTest() {
        Disposable disposable = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (disposable != null) {
            disposable.dispose();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        LocationUtil.LocationRequestBuilder locationRequestBuilder = new LocationUtil.LocationRequestBuilder((Application) getDanaApplication());
        locationRequestBuilder.MyBillsEntityDataFactory.setAlwaysShow(true);
        locationRequestBuilder.MyBillsEntityDataFactory.addLocationRequest(LocationUtil.LocationRequestBuilder.PlaceComponentResult());
        Disposable subscribe = locationRequestBuilder.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(locationRequestBuilder.MyBillsEntityDataFactory.build()).subscribe(new Consumer() { // from class: id.dana.nearbyme.OtherStoreListActivity$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OtherStoreListActivity.$r8$lambda$ZbZ_KfNYUx5bjnLrv2K4nXK0ZKo(OtherStoreListActivity.this, (LocationSettingsResult) obj);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = subscribe;
        addDisposable(subscribe);
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
            }
            int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
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
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
