package id.dana.onlinemerchant;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.contract.onlinemerchant.OnlineMerchantContract;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.OnlineMerchantAnalyticModule;
import id.dana.explore.domain.globalsearch.model.Paginator;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.model.SearchResult;
import id.dana.globalsearch.model.SearchResultExtKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.onlinemerchant.di.DaggerOnlineMerchantComponent;
import id.dana.onlinemerchant.di.module.OnlineMerchantModule;
import id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker;
import id.dana.onlinemerchant.view.OnlineMerchantListView;
import id.dana.onlinemerchant.view.OnlineMerchantView;
import id.dana.richview.ToolbarSearchView;
import id.dana.utils.KeyboardHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0007¢\u0006\u0004\b/\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\f\u0012\b\u0012\u0006*\u00020\u00150\u00150\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010\u000e\u001a\u00020$8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u0010\u0004\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010\u0017"}, d2 = {"Lid/dana/onlinemerchant/OnlineMerchantActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/onlinemerchant/view/OnlineMerchantView$OnlineMerchantListener;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "getLayout", "()I", "", "p0", "MyBillsEntityDataFactory", "(Z)V", IAPSyncCommand.COMMAND_INIT, "getAuthRequestContext", "()Z", "isHasOnlineMerchantsMore", "onRefresh", "onTouchBottom", "getErrorConfigVersion", "Z", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "PlaceComponentResult", "Lio/reactivex/subjects/PublishSubject;", "lookAheadTest", "Lio/reactivex/subjects/PublishSubject;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "onlineMerchantAnalyticTracker", "Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "getOnlineMerchantAnalyticTracker", "()Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "setOnlineMerchantAnalyticTracker", "(Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;)V", "Lid/dana/onlinemerchant/OnlineMerchantActivity$onlineMerchantItemListener$1;", "scheduleImpl", "Lid/dana/onlinemerchant/OnlineMerchantActivity$onlineMerchantItemListener$1;", "Lid/dana/contract/onlinemerchant/OnlineMerchantContract$Presenter;", "onlineMerchantPresenter", "Lid/dana/contract/onlinemerchant/OnlineMerchantContract$Presenter;", "getOnlineMerchantPresenter", "()Lid/dana/contract/onlinemerchant/OnlineMerchantContract$Presenter;", "setOnlineMerchantPresenter", "(Lid/dana/contract/onlinemerchant/OnlineMerchantContract$Presenter;)V", "GetContactSyncConfig", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnlineMerchantActivity extends BaseActivity implements OnlineMerchantView.OnlineMerchantListener {
    public static final int AUTO_SEARCH_MIN_CHAR = 3;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final long SEARCH_DEBOUNCE = 500;
    public static final int SEARCH_MAX_LENGTH = 30;
    public static final String SOURCE = "source";
    public static final String TRENDING_MERCHANTS_EXTRA = "trending_merchants_extra";
    private static int[] initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final PublishSubject<String> KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public OnlineMerchantAnalyticTracker onlineMerchantAnalyticTracker;
    @Inject
    public OnlineMerchantContract.Presenter onlineMerchantPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private OnlineMerchantActivity$onlineMerchantItemListener$1 getAuthRequestContext;
    public static final byte[] $$a = {119, -93, -18, -42, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 237;
    public static final byte[] PlaceComponentResult = {61, 16, -46, 32, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 178;

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        initRecordTimeStamp = new int[]{-443004164, -502632274, 1100627790, 709490839, 235396047, -100080383, 1173918319, 1772205636, 82271786, -199902197, -1224702382, 1534987103, 2092870499, -2062757750, 2066409864, 1463286577, 1083275304, -913323275};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = 23 - r8
            int r9 = 56 - r9
            int r7 = 106 - r7
            byte[] r0 = id.dana.onlinemerchant.OnlineMerchantActivity.PlaceComponentResult
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2e
        L13:
            r3 = 0
            r6 = r9
            r9 = r7
            r7 = r6
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r7]
            r6 = r10
            r10 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2e:
            int r7 = -r7
            int r9 = r9 + r7
            int r9 = r9 + (-4)
            int r7 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onlinemerchant.OnlineMerchantActivity.b(short, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r0 = id.dana.onlinemerchant.OnlineMerchantActivity.$$a
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            int r6 = r6 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r8 = r8 + r6
            int r8 = r8 + (-7)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onlinemerchant.OnlineMerchantActivity.c(byte, int, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void openOnlineMerchantFromDeeplink(Context context) {
        Companion.BuiltInFictitiousFunctionClassFactory(context);
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
        a(18 - View.MeasureSpec.getMode(0), new int[]{1911902305, -802468036, -460890183, 895882356, -1028018229, 973238522, 1509209183, 679035891, 1153301940, -840761831}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(TextUtils.getTrimmedLength("") + 5, new int[]{1607126069, -1970103378, -1153326435, 1547817474}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(ExpandableListView.getPackedPositionChild(0L) + 49, new int[]{1889696645, -1325455190, 1216258005, -1149568827, 725627246, 1001542735, 800897967, -1305466332, 1113900749, 1848972249, -1946218813, 939871212, -2007339742, 1917865628, 482416255, -1019390535, -1293761124, -127466662, 722534112, -1055826877, -1061163959, -1597956152, -1776272099, -770289837}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - Color.blue(0), new int[]{908826991, -429658610, -724914342, -2019301997, 226756112, -65631402, -1348183201, -473360126, -77861079, 2130477073, -144601120, -1132588063, -1552906830, 30280343, 1484147180, -690603732, 1232658930, -609724181, 447027110, 1359188750, 699339116, 1557846745, -193075240, 1731878315, -853455599, 1549915128, -1915131325, 1728865479, -1088404072, 2072346891, 606100564, 1704832384}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 63, new int[]{1998283110, 342152983, -818583998, 963533145, -581913641, 1345118800, -1171129469, 98715269, -1117284428, -203251655, -2128472485, -1508734913, 601007086, 662569719, 632528614, 1804743454, 224002846, 750553359, 1788366177, 467138427, 398870611, -2004044003, -1331654583, 594859734, 2129510433, -343160669, -1533725730, 692848121, 16266960, -1865369572, 846066838, 1214374357}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - View.combineMeasuredStates(0, 0), new int[]{132144008, -1347146159, -1544246315, -766231931, -1202836394, -2065692108, 1559186073, 780202132, 1308457821, 1681229731, 2129204533, 538465343, 1664006132, -636642959, 1423832686, -1189464539, -2043088458, 1328559378, -568515148, -809337766, 1505939211, 1735048301, -16451479, -51992062, 526819967, 375885345, -159170151, 2138611075, 654780816, -528270369}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(6 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new int[]{-1253424143, -1466599254, -574062352, -2146261798}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(PlaceComponentResult[9], PlaceComponentResult[30], Ascii.RS, objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 55, KeyEvent.normalizeMetaState(0) + 3, (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], $$a[31], $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 800, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 14, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 800, 16 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (Process.myPid() >> 22))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 816, Color.blue(0) + 29, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 16 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) Color.alpha(0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1428470271, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(PlaceComponentResult[9], PlaceComponentResult[30], Ascii.RS, objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.getTrimmedLength("") + 46, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1));
                        Object[] objArr22 = new Object[1];
                        c($$a[28], $$a[8], (byte) ($$a[78] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1428470271, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, TextUtils.lastIndexOf("", '0', 0) + 19, (char) Color.blue(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
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
                Object[] objArr25 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(PlaceComponentResult[9], PlaceComponentResult[30], Ascii.RS, objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - TextUtils.indexOf("", "", 0, 0), TextUtils.indexOf("", "", 0) + 3, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 38968));
                        Object[] objArr28 = new Object[1];
                        c($$a[28], $$a[8], (byte) ($$a[78] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", "", 0, 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1428470271, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), TextUtils.lastIndexOf("", '0') + 19, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
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
                Object[] objArr31 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(PlaceComponentResult[9], PlaceComponentResult[30], Ascii.RS, objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 107, 3 - View.MeasureSpec.getSize(0), (char) ((Process.getThreadPriority(0) + 20) >> 6));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[3]), (byte) ($$a[78] - 1), $$a[9], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), TextUtils.lastIndexOf("", '0') + 36, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1428470271, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
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
        return R.layout.activity_online_merchant;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(R.string.description_auth_payment).substring(2, 6).length() + 14, new int[]{1911902305, -802468036, -460890183, 895882356, -1028018229, 973238522, 1509209183, 679035891, 1153301940, -840761831}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(getPackageName().codePointAt(3) - 95, new int[]{1607126069, -1970103378, -1153326435, 1547817474}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(26 - (ViewConfiguration.getLongPressTimeout() >> 16), new int[]{1911902305, -802468036, -460890183, 895882356, 1139559546, 414457226, 405253841, -1672509486, -1221320747, 914080057, -1381585596, -1376420240, 1482049750, -1106034635}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, new int[]{880659842, 385808729, 1304737501, -1105052437, 467346784, 1267871531, -1163286967, 2093354285, -693725224, -2011050202}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.merchant_review_main_title).substring(5, 6).length() + 47, new int[]{1889696645, -1325455190, 1216258005, -1149568827, 725627246, 1001542735, 800897967, -1305466332, 1113900749, 1848972249, -1946218813, 939871212, -2007339742, 1917865628, 482416255, -1019390535, -1293761124, -127466662, 722534112, -1055826877, -1061163959, -1597956152, -1776272099, -770289837}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(64 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new int[]{908826991, -429658610, -724914342, -2019301997, 226756112, -65631402, -1348183201, -473360126, -77861079, 2130477073, -144601120, -1132588063, -1552906830, 30280343, 1484147180, -690603732, 1232658930, -609724181, 447027110, 1359188750, 699339116, 1557846745, -193075240, 1731878315, -853455599, 1549915128, -1915131325, 1728865479, -1088404072, 2072346891, 606100564, 1704832384}, objArr7);
                    String str2 = (String) objArr7[0];
                    try {
                        byte b = (byte) (-PlaceComponentResult[32]);
                        byte b2 = PlaceComponentResult[25];
                        Object[] objArr8 = new Object[1];
                        b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr8);
                        Class<?> cls3 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b(PlaceComponentResult[48], PlaceComponentResult[41], PlaceComponentResult[25], objArr9);
                        Object[] objArr10 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 31, new int[]{1998283110, 342152983, -818583998, 963533145, -581913641, 1345118800, -1171129469, 98715269, -1117284428, -203251655, -2128472485, -1508734913, 601007086, 662569719, 632528614, 1804743454, 224002846, 750553359, 1788366177, 467138427, 398870611, -2004044003, -1331654583, 594859734, 2129510433, -343160669, -1533725730, 692848121, 16266960, -1865369572, 846066838, 1214374357}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.postal_code_error_message).substring(28, 30).length() + 58, new int[]{132144008, -1347146159, -1544246315, -766231931, -1202836394, -2065692108, 1559186073, 780202132, 1308457821, 1681229731, 2129204533, 538465343, 1664006132, -636642959, 1423832686, -1189464539, -2043088458, 1328559378, -568515148, -809337766, 1505939211, 1735048301, -16451479, -51992062, 526819967, 375885345, -159170151, 2138611075, 654780816, -528270369}, objArr11);
                        String str4 = (String) objArr11[0];
                        try {
                            byte b3 = (byte) (-PlaceComponentResult[32]);
                            byte b4 = PlaceComponentResult[25];
                            Object[] objArr12 = new Object[1];
                            b(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr12);
                            Class<?> cls4 = Class.forName((String) objArr12[0]);
                            b(PlaceComponentResult[48], PlaceComponentResult[41], PlaceComponentResult[25], new Object[1]);
                            Object[] objArr13 = new Object[1];
                            a(((ApplicationInfo) cls4.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 27, new int[]{-1253424143, -1466599254, -574062352, -2146261798}, objArr13);
                            try {
                                Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), View.resolveSize(0, 0) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr14);
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
        try {
            Object[] objArr15 = new Object[1];
            b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), objArr15);
            Class<?> cls5 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            b(PlaceComponentResult[9], PlaceComponentResult[30], Ascii.RS, objArr16);
            try {
                Object[] objArr17 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 494, TextUtils.indexOf("", "") + 4, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                    Object[] objArr18 = new Object[1];
                    c((byte) (-$$a[3]), (byte) ($$a[78] - 1), $$a[9], objArr18);
                    obj3 = cls6.getMethod((String) objArr18[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                int i = ((int[]) objArr19[1])[0];
                if (((int[]) objArr19[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr20 = {1041789102, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), 18 - TextUtils.indexOf("", "", 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr20);
                        } catch (Throwable th5) {
                            Throwable cause5 = th5.getCause();
                            if (cause5 == null) {
                                throw th5;
                            }
                            throw cause5;
                        }
                    } catch (Throwable th6) {
                        Throwable cause6 = th6.getCause();
                        if (cause6 == null) {
                            throw th6;
                        }
                        throw cause6;
                    }
                }
                super.onCreate(bundle);
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
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(2) - 20, new int[]{1911902305, -802468036, -460890183, 895882356, 1139559546, 414457226, 405253841, -1672509486, -1221320747, 914080057, -1381585596, -1376420240, 1482049750, -1106034635}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.family_account_revoked_role_member_title).substring(13, 14).length() + 17, new int[]{880659842, 385808729, 1304737501, -1105052437, 467346784, 1267871531, -1163286967, 2093354285, -693725224, -2011050202}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            a(26 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new int[]{1911902305, -802468036, -460890183, 895882356, 1139559546, 414457226, 405253841, -1672509486, -1221320747, 914080057, -1381585596, -1376420240, 1482049750, -1106034635}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = (byte) (-PlaceComponentResult[32]);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr2 = new Object[1];
                b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(PlaceComponentResult[48], PlaceComponentResult[41], PlaceComponentResult[25], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{880659842, 385808729, 1304737501, -1105052437, 467346784, 1267871531, -1163286967, 2093354285, -693725224, -2011050202}, objArr3);
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
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), 34 - ImageFormat.getBitsPerPixel(0), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        }
        super.onResume();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [id.dana.onlinemerchant.OnlineMerchantActivity$onlineMerchantItemListener$1] */
    public OnlineMerchantActivity() {
        PublishSubject<String> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult2;
        this.PlaceComponentResult = "";
        this.BuiltInFictitiousFunctionClassFactory = TrackerKey.SourceType.ONLINE_MERCHANT_LIST;
        this.getAuthRequestContext = new OnlineMerchantListView.OnlineMerchantItemListener() { // from class: id.dana.onlinemerchant.OnlineMerchantActivity$onlineMerchantItemListener$1
            @Override // id.dana.onlinemerchant.view.OnlineMerchantListView.OnlineMerchantItemListener
            public final void getAuthRequestContext(PaySearchInfoModel p0) {
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                OnlineMerchantAnalyticTracker onlineMerchantAnalyticTracker = OnlineMerchantActivity.this.getOnlineMerchantAnalyticTracker();
                str = OnlineMerchantActivity.this.BuiltInFictitiousFunctionClassFactory;
                onlineMerchantAnalyticTracker.BuiltInFictitiousFunctionClassFactory(str, p0);
            }
        };
    }

    @JvmName(name = "getOnlineMerchantPresenter")
    public final OnlineMerchantContract.Presenter getOnlineMerchantPresenter() {
        OnlineMerchantContract.Presenter presenter = this.onlineMerchantPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOnlineMerchantPresenter")
    public final void setOnlineMerchantPresenter(OnlineMerchantContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.onlineMerchantPresenter = presenter;
    }

    @JvmName(name = "getOnlineMerchantAnalyticTracker")
    public final OnlineMerchantAnalyticTracker getOnlineMerchantAnalyticTracker() {
        OnlineMerchantAnalyticTracker onlineMerchantAnalyticTracker = this.onlineMerchantAnalyticTracker;
        if (onlineMerchantAnalyticTracker != null) {
            return onlineMerchantAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOnlineMerchantAnalyticTracker")
    public final void setOnlineMerchantAnalyticTracker(OnlineMerchantAnalyticTracker onlineMerchantAnalyticTracker) {
        Intrinsics.checkNotNullParameter(onlineMerchantAnalyticTracker, "");
        this.onlineMerchantAnalyticTracker = onlineMerchantAnalyticTracker;
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        OnlineMerchantView onlineMerchantView = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_view);
        if (onlineMerchantView != null) {
            onlineMerchantView.setVisibility(p0 ^ true ? 0 : 8);
        }
        OnlineMerchantView onlineMerchantView2 = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_search_view);
        if (onlineMerchantView2 != null) {
            onlineMerchantView2.setVisibility(p0 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(TRENDING_MERCHANTS_EXTRA);
        if (parcelableArrayListExtra == null) {
            parcelableArrayListExtra = CollectionsKt.emptyList();
        }
        OnlineMerchantView onlineMerchantView = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_view);
        if (onlineMerchantView != null) {
            onlineMerchantView.setViewOnSuccess();
        }
        if ((!parcelableArrayListExtra.isEmpty()) != false) {
            OnlineMerchantView onlineMerchantView2 = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_view);
            if (onlineMerchantView2 != null) {
                onlineMerchantView2.startOnlineMerchantShimmer();
                onlineMerchantView2.setTrendingMerchantList(parcelableArrayListExtra);
            }
            OnlineMerchantContract.Presenter onlineMerchantPresenter = getOnlineMerchantPresenter();
            onlineMerchantPresenter.getAuthRequestContext();
            onlineMerchantPresenter.BuiltInFictitiousFunctionClassFactory();
            onlineMerchantPresenter.MyBillsEntityDataFactory(parcelableArrayListExtra);
            onlineMerchantPresenter.BuiltInFictitiousFunctionClassFactory(true);
            return;
        }
        OnlineMerchantView onlineMerchantView3 = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_view);
        if (onlineMerchantView3 != null) {
            onlineMerchantView3.startTrendingMerchantShimmer();
            onlineMerchantView3.startOnlineMerchantShimmer();
        }
        OnlineMerchantContract.Presenter onlineMerchantPresenter2 = getOnlineMerchantPresenter();
        onlineMerchantPresenter2.getAuthRequestContext();
        onlineMerchantPresenter2.BuiltInFictitiousFunctionClassFactory();
        onlineMerchantPresenter2.PlaceComponentResult();
        onlineMerchantPresenter2.BuiltInFictitiousFunctionClassFactory(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean getAuthRequestContext() {
        /*
            r3 = this;
            int r0 = id.dana.R.id.fl_online_merchant_search_view
            android.view.View r0 = r3._$_findCachedViewById(r0)
            id.dana.onlinemerchant.view.OnlineMerchantView r0 = (id.dana.onlinemerchant.view.OnlineMerchantView) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1b
            android.view.View r0 = (android.view.View) r0
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L16
            r0 = 1
            goto L17
        L16:
            r0 = 0
        L17:
            if (r0 != 0) goto L1b
            r0 = 1
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 == 0) goto L35
            int r0 = id.dana.R.id.tsv_online_merchant
            android.view.View r0 = r3._$_findCachedViewById(r0)
            id.dana.richview.ToolbarSearchView r0 = (id.dana.richview.ToolbarSearchView) r0
            if (r0 == 0) goto L30
            boolean r0 = r0.getIsDismissHideSearchBar()
            if (r0 != r2) goto L30
            r0 = 1
            goto L31
        L30:
            r0 = 0
        L31:
            if (r0 != 0) goto L34
            goto L35
        L34:
            r1 = 1
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onlinemerchant.OnlineMerchantActivity.getAuthRequestContext():boolean");
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/onlinemerchant/OnlineMerchantActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)V", "", "AUTO_SEARCH_MIN_CHAR", "I", "", "SEARCH_DEBOUNCE", "J", "SEARCH_MAX_LENGTH", "", "SOURCE", "Ljava/lang/String;", "TRENDING_MERCHANTS_EXTRA", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intent intent = new Intent(p0, OnlineMerchantActivity.class);
            intent.putExtra("source", "Deeplink");
            p0.startActivity(intent);
        }
    }

    @Override // id.dana.onlinemerchant.view.OnlineMerchantView.OnlineMerchantListener
    public final void onRefresh() {
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.onlinemerchant.view.OnlineMerchantView.OnlineMerchantListener
    public final void onTouchBottom() {
        getOnlineMerchantPresenter().BuiltInFictitiousFunctionClassFactory(false);
    }

    @Override // id.dana.onlinemerchant.view.OnlineMerchantView.OnlineMerchantListener
    public final boolean isHasOnlineMerchantsMore() {
        return getOnlineMerchantPresenter().getBuiltInFictitiousFunctionClassFactory();
    }

    /* renamed from: $r8$lambda$5EUTquGi-xhdrs55_GTE3MvDP4M  reason: not valid java name */
    public static /* synthetic */ void m2770$r8$lambda$5EUTquGixhdrs55_GTE3MvDP4M(OnlineMerchantActivity onlineMerchantActivity, String str) {
        Intrinsics.checkNotNullParameter(onlineMerchantActivity, "");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            onlineMerchantActivity.MyBillsEntityDataFactory(false);
            OnlineMerchantView onlineMerchantView = (OnlineMerchantView) onlineMerchantActivity._$_findCachedViewById(R.id.fl_online_merchant_view);
            if (onlineMerchantView != null) {
                onlineMerchantView.setTryAgainClickListener(new OnlineMerchantActivity$setTryAgainFetchListener$1(onlineMerchantActivity));
            }
            ToolbarSearchView toolbarSearchView = (ToolbarSearchView) onlineMerchantActivity._$_findCachedViewById(R.id.tsv_online_merchant);
            if (toolbarSearchView != null) {
                toolbarSearchView.setIsDismissHideSearchbar(true);
            }
        } else if (onlineMerchantActivity.MyBillsEntityDataFactory && str.length() < 3) {
            onlineMerchantActivity.MyBillsEntityDataFactory = false;
            return;
        } else {
            onlineMerchantActivity.MyBillsEntityDataFactory(true);
            OnlineMerchantView onlineMerchantView2 = (OnlineMerchantView) onlineMerchantActivity._$_findCachedViewById(R.id.fl_online_merchant_search_view);
            if (onlineMerchantView2 != null) {
                onlineMerchantView2.setViewOnSuccess();
            }
            OnlineMerchantView onlineMerchantView3 = (OnlineMerchantView) onlineMerchantActivity._$_findCachedViewById(R.id.fl_online_merchant_search_view);
            if (onlineMerchantView3 != null) {
                onlineMerchantView3.startSearchOnlineMerchantShimmer();
            }
            ToolbarSearchView toolbarSearchView2 = (ToolbarSearchView) onlineMerchantActivity._$_findCachedViewById(R.id.tsv_online_merchant);
            if (toolbarSearchView2 != null) {
                toolbarSearchView2.setIsDismissHideSearchbar(false);
            }
            OnlineMerchantContract.Presenter onlineMerchantPresenter = onlineMerchantActivity.getOnlineMerchantPresenter();
            Intrinsics.checkNotNullExpressionValue(str, "");
            onlineMerchantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(str);
        }
        if (onlineMerchantActivity.MyBillsEntityDataFactory) {
            onlineMerchantActivity.MyBillsEntityDataFactory = false;
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        Bundle extras;
        String string;
        DaggerOnlineMerchantComponent.Builder MyBillsEntityDataFactory = DaggerOnlineMerchantComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (OnlineMerchantModule) Preconditions.getAuthRequestContext(new OnlineMerchantModule(new OnlineMerchantContract.View() { // from class: id.dana.onlinemerchant.OnlineMerchantActivity$initComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
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

            @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.View
            public final void BuiltInFictitiousFunctionClassFactory(SearchResult p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OnlineMerchantView onlineMerchantView = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_search_view);
                if (onlineMerchantView != null) {
                    onlineMerchantView.setStopRefreshAnimationOnRepeat(true);
                    onlineMerchantView.setViewOnSuccess();
                    onlineMerchantView.hideSearchOnlineMerchantShimmer();
                    Context context = onlineMerchantView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    Paginator paginator = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    Integer pageNum = paginator != null ? paginator.getPageNum() : null;
                    Paginator paginator2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    onlineMerchantView.setSearchOnlineMerchantList(SearchResultExtKt.BuiltInFictitiousFunctionClassFactory(p0, context, Intrinsics.areEqual(pageNum, paginator2 != null ? paginator2.getTotalPage() : null), 0, 12).getAuthRequestContext);
                }
            }

            @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                OnlineMerchantView onlineMerchantView = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_search_view);
                if (onlineMerchantView != null) {
                    final OnlineMerchantActivity onlineMerchantActivity = OnlineMerchantActivity.this;
                    onlineMerchantView.setStopRefreshAnimationOnRepeat(true);
                    onlineMerchantView.setViewOnError();
                    onlineMerchantView.setErrorStateOnView(0);
                    onlineMerchantView.setTryAgainClickListener(new Function0<Unit>() { // from class: id.dana.onlinemerchant.OnlineMerchantActivity$initComponent$1$onGetOnlineMerchantSearchFailed$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            PublishSubject publishSubject;
                            String str;
                            publishSubject = OnlineMerchantActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                            str = OnlineMerchantActivity.this.PlaceComponentResult;
                            publishSubject.onNext(str);
                        }
                    });
                }
            }

            @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.View
            public final void MyBillsEntityDataFactory() {
                OnlineMerchantView onlineMerchantView = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_search_view);
                if (onlineMerchantView != null) {
                    onlineMerchantView.setStopRefreshAnimationOnRepeat(true);
                    onlineMerchantView.setViewOnError();
                    onlineMerchantView.setErrorStateOnView(1);
                }
            }

            @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.View
            public final void PlaceComponentResult(List<PaySearchInfoModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OnlineMerchantView onlineMerchantView = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_view);
                if (onlineMerchantView != null) {
                    onlineMerchantView.setStopRefreshAnimationOnRepeat(true);
                    onlineMerchantView.setViewOnSuccess();
                    onlineMerchantView.hideTrendingMerchantShimmer();
                    onlineMerchantView.setTrendingMerchantList(p0);
                }
            }

            @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.View
            public final void MyBillsEntityDataFactory(List<PaySearchInfoModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OnlineMerchantView onlineMerchantView = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_view);
                if (onlineMerchantView != null) {
                    onlineMerchantView.setStopRefreshAnimationOnRepeat(true);
                    onlineMerchantView.setViewOnSuccess();
                    onlineMerchantView.hideOnlineMerchantShimmer();
                    onlineMerchantView.setOnlineMerchantList(p0);
                }
            }

            @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.View
            public final void getAuthRequestContext() {
                OnlineMerchantView onlineMerchantView = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_view);
                if (onlineMerchantView != null) {
                    onlineMerchantView.setStopRefreshAnimationOnRepeat(true);
                    onlineMerchantView.hideTrendingMerchantShimmer();
                    onlineMerchantView.hideOnlineMerchantShimmer();
                    onlineMerchantView.setViewOnError();
                    onlineMerchantView.setErrorStateOnView(0);
                }
            }

            @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<PaySearchInfoModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OnlineMerchantView onlineMerchantView = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_view);
                if (onlineMerchantView != null) {
                    onlineMerchantView.hideLoadingLoadMore();
                    onlineMerchantView.appendOnlineMerchantList(p0);
                }
            }

            @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.View
            public final void PlaceComponentResult() {
                OnlineMerchantView onlineMerchantView = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_view);
                if (onlineMerchantView != null) {
                    onlineMerchantView.showLoadMoreBtn();
                    onlineMerchantView.hideLoadingLoadMore();
                }
            }

            @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                OnlineMerchantView onlineMerchantView = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_view);
                if (onlineMerchantView != null) {
                    onlineMerchantView.hideTrendingOnlineMerchantSection();
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, OnlineMerchantModule.class);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = new OnlineMerchantAnalyticModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, ApplicationComponent.class);
        new DaggerOnlineMerchantComponent.OnlineMerchantComponentImpl(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getOnlineMerchantPresenter());
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && (string = extras.getString("source")) != null) {
            this.BuiltInFictitiousFunctionClassFactory = string;
        }
        final ToolbarSearchView toolbarSearchView = (ToolbarSearchView) _$_findCachedViewById(R.id.tsv_online_merchant);
        if (toolbarSearchView != null) {
            toolbarSearchView.setMenuRightButton(R.drawable.ic_search_white);
            toolbarSearchView.setMenuRightButtonContentDescription(getString(R.string.btn_search));
            toolbarSearchView.setTitle(getString(R.string.online_merchant));
            toolbarSearchView.setTitleContentDescription(getString(R.string.lbl_header));
            toolbarSearchView.setMenuLeftButton(R.drawable.btn_arrow_left);
            toolbarSearchView.setMenuLeftButtonContentDescription(getString(R.string.btn_back));
            toolbarSearchView.setMaxChar(30);
            toolbarSearchView.setCloseButtonText(getString(R.string.close_search_button_title));
            toolbarSearchView.setClearToolbarSearchContentDescription(getString(R.string.DatabaseTableConfigUtil_res_0x7f1302c7));
            addDisposable(this.KClassImpl$Data$declaredNonStaticMembers$2.debounce(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.onlinemerchant.OnlineMerchantActivity$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    OnlineMerchantActivity.m2770$r8$lambda$5EUTquGixhdrs55_GTE3MvDP4M(OnlineMerchantActivity.this, (String) obj);
                }
            }));
            toolbarSearchView.setIsMerchantOnline(true);
            toolbarSearchView.setIsDismissHideSearchbar(true);
            toolbarSearchView.setListener(new ToolbarSearchView.Listener() { // from class: id.dana.onlinemerchant.OnlineMerchantActivity$setupToolbar$1$1
                @Override // id.dana.richview.ToolbarSearchView.Listener
                public final void BuiltInFictitiousFunctionClassFactory() {
                }

                @Override // id.dana.richview.ToolbarSearchView.Listener
                public final void getAuthRequestContext() {
                }

                @Override // id.dana.richview.ToolbarSearchView.Listener
                public final void PlaceComponentResult(CharSequence p0) {
                    PublishSubject publishSubject;
                    Intrinsics.checkNotNullParameter(p0, "");
                    OnlineMerchantActivity.this.PlaceComponentResult = p0.toString();
                    OnlineMerchantActivity.this.MyBillsEntityDataFactory = true;
                    publishSubject = OnlineMerchantActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    publishSubject.onNext(p0.toString());
                    if (p0.length() >= 3) {
                        ToolbarSearchView toolbarSearchView2 = (ToolbarSearchView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.tsv_online_merchant);
                        if (toolbarSearchView2 != null) {
                            toolbarSearchView2.setIsDismissHideSearchbar(false);
                            return;
                        }
                        return;
                    }
                    ToolbarSearchView toolbarSearchView3 = (ToolbarSearchView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.tsv_online_merchant);
                    if (toolbarSearchView3 != null) {
                        toolbarSearchView3.setIsDismissHideSearchbar(true);
                    }
                }

                @Override // id.dana.richview.ToolbarSearchView.Listener
                public final void MyBillsEntityDataFactory() {
                    OnlineMerchantActivity.this.onBackPressed();
                }

                @Override // id.dana.richview.ToolbarSearchView.Listener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    toolbarSearchView.clearSearch();
                }

                @Override // id.dana.richview.ToolbarSearchView.Listener
                public final void MyBillsEntityDataFactory(CharSequence p0) {
                    PublishSubject publishSubject;
                    ToolbarSearchView toolbarSearchView2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    if ((p0.length() > 0) && (toolbarSearchView2 = (ToolbarSearchView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.tsv_online_merchant)) != null) {
                        toolbarSearchView2.setIsDismissHideSearchbar(false);
                    }
                    OnlineMerchantActivity.this.MyBillsEntityDataFactory = false;
                    publishSubject = OnlineMerchantActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    publishSubject.onNext(p0.toString());
                }
            });
        }
        OnlineMerchantView onlineMerchantView = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_view);
        if (onlineMerchantView != null) {
            onlineMerchantView.setListener(this);
        }
        OnlineMerchantView onlineMerchantView2 = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_view);
        if (onlineMerchantView2 != null) {
            onlineMerchantView2.setOnlineMerchantItemListener(this.getAuthRequestContext);
        }
        OnlineMerchantView onlineMerchantView3 = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_search_view);
        if (onlineMerchantView3 != null) {
            onlineMerchantView3.setOnlineMerchantItemListener(this.getAuthRequestContext);
        }
        OnlineMerchantView onlineMerchantView4 = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_search_view);
        if (onlineMerchantView4 != null) {
            onlineMerchantView4.setListener(new OnlineMerchantView.OnlineMerchantListener() { // from class: id.dana.onlinemerchant.OnlineMerchantActivity$setOnlineMerchantViewListener$1
                @Override // id.dana.onlinemerchant.view.OnlineMerchantView.OnlineMerchantListener
                public final boolean isHasOnlineMerchantsMore() {
                    return false;
                }

                @Override // id.dana.onlinemerchant.view.OnlineMerchantView.OnlineMerchantListener
                public final void onRefresh() {
                }

                @Override // id.dana.onlinemerchant.view.OnlineMerchantView.OnlineMerchantListener
                public final void onTouchBottom() {
                    String str;
                    OnlineMerchantContract.Presenter onlineMerchantPresenter = OnlineMerchantActivity.this.getOnlineMerchantPresenter();
                    str = OnlineMerchantActivity.this.PlaceComponentResult;
                    onlineMerchantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(str);
                }
            });
        }
        OnlineMerchantView onlineMerchantView5 = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_view);
        if (onlineMerchantView5 != null) {
            onlineMerchantView5.setTryAgainClickListener(new OnlineMerchantActivity$setTryAgainFetchListener$1(this));
        }
        OnlineMerchantView onlineMerchantView6 = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_view);
        if (onlineMerchantView6 != null) {
            onlineMerchantView6.setLoadMoreClickListener(new Function0<Unit>() { // from class: id.dana.onlinemerchant.OnlineMerchantActivity$setLoadMoreButtonListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OnlineMerchantActivity.this.getOnlineMerchantPresenter().BuiltInFictitiousFunctionClassFactory(false);
                }
            });
        }
        OnlineMerchantView onlineMerchantView7 = (OnlineMerchantView) _$_findCachedViewById(R.id.fl_online_merchant_search_view);
        if (onlineMerchantView7 != null) {
            onlineMerchantView7.setLoadMoreClickListener(new Function0<Unit>() { // from class: id.dana.onlinemerchant.OnlineMerchantActivity$setLoadMoreButtonListener$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str;
                    OnlineMerchantContract.Presenter onlineMerchantPresenter = OnlineMerchantActivity.this.getOnlineMerchantPresenter();
                    str = OnlineMerchantActivity.this.PlaceComponentResult;
                    onlineMerchantPresenter.KClassImpl$Data$declaredNonStaticMembers$2(str);
                    OnlineMerchantView onlineMerchantView8 = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_search_view);
                    if (onlineMerchantView8 != null) {
                        onlineMerchantView8.hideLoadMoreBtn();
                    }
                    OnlineMerchantView onlineMerchantView9 = (OnlineMerchantView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.fl_online_merchant_search_view);
                    if (onlineMerchantView9 != null) {
                        onlineMerchantView9.showLoadingLoadMore();
                    }
                }
            });
        }
        getOnlineMerchantAnalyticTracker().MyBillsEntityDataFactory();
        getOnlineMerchantPresenter().MyBillsEntityDataFactory();
        BuiltInFictitiousFunctionClassFactory();
        KeyboardHelper.PlaceComponentResult((ConstraintLayout) _$_findCachedViewById(R.id.WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1$invoke$$inlined$sortedBy$1), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.onlinemerchant.OnlineMerchantActivity$setKeyboardVisibilityListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                boolean authRequestContext;
                ToolbarSearchView toolbarSearchView2;
                authRequestContext = OnlineMerchantActivity.this.getAuthRequestContext();
                if (!authRequestContext || (toolbarSearchView2 = (ToolbarSearchView) OnlineMerchantActivity.this._$_findCachedViewById(R.id.tsv_online_merchant)) == null) {
                    return;
                }
                toolbarSearchView2.hideSearchView();
            }
        });
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = initRecordTimeStamp;
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
        int[] iArr5 = initRecordTimeStamp;
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
