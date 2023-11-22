package id.dana.familyaccount.view.managefamily;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewGroupKt;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengeScenario;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.databinding.ActivityFamilyOrganizerDetailBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFamilyAccountManageComponent;
import id.dana.di.modules.FamilyAccountManageModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.familyaccount.contract.FamilyManageContract;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.SetLimitAndServicesRequestModel;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.DANAToast;
import id.dana.utils.ShimmeringUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u0005J)\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0013\u0010\u0005J\r\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0005J\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0005J#\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001a\u001a\u00020\u001cX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010\u001d\u001a\u00020-8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b0\u00101R$\u0010:\u001a\u0004\u0018\u0001038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109"}, d2 = {"Lid/dana/familyaccount/view/managefamily/ManageOrganizerActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityFamilyOrganizerDetailBinding;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/databinding/ActivityFamilyOrganizerDetailBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "initView", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "onDestroy", "prepareBundle", "showShimmer", "", "p0", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(ZLjava/lang/String;)V", "Lid/dana/dialog/DanaLoadingDialog;", "getAuthRequestContext", "Lkotlin/Lazy;", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "familyAccountAnalyticalTracker", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "getFamilyAccountAnalyticalTracker", "()Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "setFamilyAccountAnalyticalTracker", "(Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;)V", "Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "familyManagePresenter", "Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "getFamilyManagePresenter", "()Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "setFamilyManagePresenter", "(Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;)V", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "lookAheadTest", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "scheduleImpl", "Z", "MyBillsEntityDataFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getErrorConfigVersion", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getSkeletonScreen", "()Lcom/ethanhua/skeleton/SkeletonScreen;", "setSkeletonScreen", "(Lcom/ethanhua/skeleton/SkeletonScreen;)V", "skeletonScreen", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageOrganizerActivity extends BaseViewBindingActivity<ActivityFamilyOrganizerDetailBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String FAMILY_MEMBER_INFO_MODEL = "FAMILY_MEMBER_INFO_MODEL";
    private static int[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    @Inject
    public FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker;
    @Inject
    public FamilyManageContract.Presenter familyManagePresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private SkeletonScreen skeletonScreen;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private FamilyMemberInfoModel getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public static final byte[] $$a = {44, 104, -53, -66, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 247;
    public static final byte[] PlaceComponentResult = {82, -89, -124, -60, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 204;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.familyaccount.view.managefamily.ManageOrganizerActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(ManageOrganizerActivity.this);
        }
    });

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda1 = new int[]{-1828344342, 1498310352, -1200342022, -200562255, -1664753294, 854540979, -795122974, 1304185782, -63768968, -1833335074, -1078943900, -359362615, 851999555, 1458934319, 1152170324, 1142424548, -1544999681, -1523352136};
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r6 = r6 + 16
            byte[] r0 = id.dana.familyaccount.view.managefamily.ManageOrganizerActivity.PlaceComponentResult
            int r8 = 106 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r8
            r4 = 0
            r8 = r7
            goto L28
        L13:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r8]
        L28:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + (-4)
            int r8 = r8 + 1
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.managefamily.ManageOrganizerActivity.b(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r9 = r9 * 3
            int r9 = r9 + 21
            byte[] r0 = id.dana.familyaccount.view.managefamily.ManageOrganizerActivity.$$a
            int r7 = 46 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            int r7 = r7 + 1
            if (r5 != r9) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.managefamily.ManageOrganizerActivity.c(short, byte, int, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new int[]{2088456694, -954427537, 1851344321, 264076236, 1430575110, 796643872, 66176021, 1701817703, 611768821, -1914366222}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(((Process.getThreadPriority(0) + 20) >> 6) + 5, new int[]{2041372556, 826933008, 1842612041, -816586208}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, View.MeasureSpec.getSize(0) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 48, new int[]{1251368515, 1054069007, -1109763251, 646846581, 713932244, 2085521210, 1391940237, -105963121, 1451656825, 978147409, -1350184026, 1999085123, 1604749393, 191853433, 587231210, 764733804, -927941724, 491533257, -1366748232, -1607894080, -1391845750, 1843632831, -1821610976, -1977884213}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - (ViewConfiguration.getLongPressTimeout() >> 16), new int[]{-1296044211, -547396017, 658102542, 2101027951, 412090740, -31047412, -1325317840, -1315227255, -1155662736, -1502211457, 724807756, 1089809990, -46413502, 1259207169, -571895171, 1168135465, 1671591875, -912578914, 425504247, 412398241, 1852620313, 1338296912, 1741766417, -1637632527, -1303880266, 1813279631, -1186400983, -68812821, 1443604316, 627494009, 144022525, -50449704}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - TextUtils.getOffsetAfter("", 0), new int[]{-868765635, 839622437, 1764720709, -610718102, 104044577, -1824694255, 143302673, 1013254203, -2059590908, -516395669, 1310144434, -161143010, 1311107507, -1332222398, 850352758, -792432291, 1698596686, -2025435244, -333276662, 1658318485, 1185708068, 702117471, -856417150, -1554989786, 1472505672, -1269785999, 838336812, 1888995615, 1641859842, -1445445641, -1879806393, 582251758}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(61 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new int[]{-646621397, 2052814979, -1636029397, -1538267168, 646529082, 1467116254, -622298215, -1755618475, 1035122090, 437824605, -1466795157, -1240851134, -726562037, -340267376, -282707150, 1879134025, 1256734824, 1592666671, -1439116918, -1280292002, -1984538876, -684855027, 152042320, 1961213617, -1438271685, -1865416093, 976914373, -2083098357, -115286363, 647467463}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(View.MeasureSpec.makeMeasureSpec(0, 0) + 6, new int[]{-264700057, -1330892703, 1829202839, -1174532056}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) View.MeasureSpec.getMode(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = {this};
                byte b = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | 37), PlaceComponentResult[25], objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (Process.myPid() >> 22), (-16777213) - Color.rgb(0, 0, 0), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))));
                        byte b2 = (byte) (-$$a[53]);
                        byte b3 = $$a[47];
                        Object[] objArr17 = new Object[1];
                        c(b2, b3, b3, objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 800, (ViewConfiguration.getFadingEdgeLength() >> 16) + 15, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - ExpandableListView.getPackedPositionChild(0L), 30 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (57995 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 800, 14 - TextUtils.lastIndexOf("", '0', 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), ExpandableListView.getPackedPositionChild(0L) + 36, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-1313791914, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.getDefaultSize(0, 0), 18 - TextUtils.indexOf("", "", 0, 0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                Object[] objArr20 = {this};
                byte b4 = PlaceComponentResult[25];
                Object[] objArr21 = new Object[1];
                b(b4, (byte) (b4 | 37), PlaceComponentResult[25], objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.getOffsetBefore("", 0), 46 - View.MeasureSpec.getMode(0), (char) TextUtils.getTrimmedLength(""));
                        Object[] objArr24 = new Object[1];
                        c($$a[20], (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-1313791914, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, (ViewConfiguration.getTapTimeout() >> 16) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
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
                Object[] objArr27 = {this};
                byte b5 = PlaceComponentResult[25];
                Object[] objArr28 = new Object[1];
                b(b5, (byte) (b5 | 37), PlaceComponentResult[25], objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - View.getDefaultSize(0, 0), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2, (char) (38967 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                        Object[] objArr31 = new Object[1];
                        c($$a[20], (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 35 - Gravity.getAbsoluteGravity(0, 0), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-1313791914, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, View.resolveSizeAndState(0, 0, 0) + 18, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
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
                Object[] objArr34 = {this};
                byte b6 = PlaceComponentResult[25];
                Object[] objArr35 = new Object[1];
                b(b6, (byte) (b6 | 37), PlaceComponentResult[25], objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 107, 4 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        byte b7 = (byte) ($$a[47] - 1);
                        Object[] objArr38 = new Object[1];
                        c(b7, b7, (byte) (-$$a[8]), objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getLongPressTimeout() >> 16), (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-1313791914, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            b(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            b(PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[48], new Object[1]);
            Object[] objArr3 = new Object[1];
            a(((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{2088456694, -954427537, 1851344321, 264076236, 1430575110, 796643872, 66176021, 1701817703, 611768821, -1914366222}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(getPackageName().length() - 2, new int[]{2041372556, 826933008, 1842612041, -816586208}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        Object[] objArr5 = new Object[1];
                        b(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        b(PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[48], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{2088456694, -954427537, 1851344321, 264076236, -1670742255, 471238716, -1331645374, -1169935844, 1454982180, -437510696, -1524454407, 300792992, 276629003, 934839739}, objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        a(super.getResources().getString(R.string.unregistered_user_notes).substring(0, 94).codePointAt(80) - 103, new int[]{907409646, 1013278013, -814689622, 1271075563, -1025526255, -1139302600, 718498165, -1057867952, 277502103, -90471084}, objArr7);
                        baseContext = (Context) cls4.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        a(getPackageName().length() + 41, new int[]{1251368515, 1054069007, -1109763251, 646846581, 713932244, 2085521210, 1391940237, -105963121, 1451656825, 978147409, -1350184026, 1999085123, 1604749393, 191853433, 587231210, 764733804, -927941724, 491533257, -1366748232, -1607894080, -1391845750, 1843632831, -1821610976, -1977884213}, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(64 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new int[]{-1296044211, -547396017, 658102542, 2101027951, 412090740, -31047412, -1325317840, -1315227255, -1155662736, -1502211457, 724807756, 1089809990, -46413502, 1259207169, -571895171, 1168135465, 1671591875, -912578914, 425504247, 412398241, 1852620313, 1338296912, 1741766417, -1637632527, -1303880266, 1813279631, -1186400983, -68812821, 1443604316, 627494009, 144022525, -50449704}, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(63 - TextUtils.indexOf((CharSequence) "", '0', 0), new int[]{-868765635, 839622437, 1764720709, -610718102, 104044577, -1824694255, 143302673, 1013254203, -2059590908, -516395669, 1310144434, -161143010, 1311107507, -1332222398, 850352758, -792432291, 1698596686, -2025435244, -333276662, 1658318485, 1185708068, 702117471, -856417150, -1554989786, 1472505672, -1269785999, 838336812, 1888995615, 1641859842, -1445445641, -1879806393, 582251758}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.sendmoney_search_not_found_desc).substring(37, 39).codePointAt(0) + 14, new int[]{-646621397, 2052814979, -1636029397, -1538267168, 646529082, 1467116254, -622298215, -1755618475, 1035122090, 437824605, -1466795157, -1240851134, -726562037, -340267376, -282707150, 1879134025, 1256734824, 1592666671, -1439116918, -1280292002, -1984538876, -684855027, 152042320, 1961213617, -1438271685, -1865416093, 976914373, -2083098357, -115286363, 647467463}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(super.getResources().getString(R.string.option_mute_friend).substring(0, 4).codePointAt(0) - 71, new int[]{-264700057, -1330892703, 1829202839, -1174532056}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) Drawable.resolveOpacity(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
            }
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | 37), PlaceComponentResult[25], objArr14);
                Class<?> cls5 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], objArr15);
                try {
                    Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getEdgeSlop() >> 16) + 4, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        byte b2 = (byte) ($$a[47] - 1);
                        Object[] objArr17 = new Object[1];
                        c(b2, b2, (byte) (-$$a[8]), objArr17);
                        obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                    int i = ((int[]) objArr18[1])[0];
                    if (((int[]) objArr18[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr19 = {-2030022001, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, 18 - Gravity.getAbsoluteGravity(0, 0), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr19);
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
                    super.onCreate(bundle);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(26 - Color.alpha(0), new int[]{2088456694, -954427537, 1851344321, 264076236, -1670742255, 471238716, -1331645374, -1169935844, 1454982180, -437510696, -1524454407, 300792992, 276629003, 934839739}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(TextUtils.getOffsetBefore("", 0) + 18, new int[]{907409646, 1013278013, -814689622, 1271075563, -1025526255, -1139302600, 718498165, -1057867952, 277502103, -90471084}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, KeyEvent.normalizeMetaState(0) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(2) - 20, new int[]{2088456694, -954427537, 1851344321, 264076236, -1670742255, 471238716, -1331645374, -1169935844, 1454982180, -437510696, -1524454407, 300792992, 276629003, 934839739}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.all_same_numbers).substring(21, 22).length() + 17, new int[]{907409646, 1013278013, -814689622, 1271075563, -1025526255, -1139302600, 718498165, -1057867952, 277502103, -90471084}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.resolveSize(0, 0), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 17 - Process.getGidForName(""), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getFamilyManagePresenter")
    public final FamilyManageContract.Presenter getFamilyManagePresenter() {
        FamilyManageContract.Presenter presenter = this.familyManagePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFamilyManagePresenter")
    public final void setFamilyManagePresenter(FamilyManageContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.familyManagePresenter = presenter;
    }

    @JvmName(name = "getFamilyAccountAnalyticalTracker")
    public final FamilyAccountAnalyticalTracker getFamilyAccountAnalyticalTracker() {
        FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker = this.familyAccountAnalyticalTracker;
        if (familyAccountAnalyticalTracker != null) {
            return familyAccountAnalyticalTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFamilyAccountAnalyticalTracker")
    public final void setFamilyAccountAnalyticalTracker(FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        Intrinsics.checkNotNullParameter(familyAccountAnalyticalTracker, "");
        this.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
    }

    @JvmName(name = "getSkeletonScreen")
    public final SkeletonScreen getSkeletonScreen() {
        return this.skeletonScreen;
    }

    @JvmName(name = "setSkeletonScreen")
    public final void setSkeletonScreen(SkeletonScreen skeletonScreen) {
        this.skeletonScreen = skeletonScreen;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityFamilyOrganizerDetailBinding inflateViewBinding() {
        ActivityFamilyOrganizerDetailBinding PlaceComponentResult2 = ActivityFamilyOrganizerDetailBinding.PlaceComponentResult(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        return PlaceComponentResult2;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerFamilyAccountManageComponent.Builder authRequestContext = DaggerFamilyAccountManageComponent.getAuthRequestContext();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        authRequestContext.PlaceComponentResult = (FamilyAccountManageModule) Preconditions.getAuthRequestContext(new FamilyAccountManageModule(new FamilyManageContract.View() { // from class: id.dana.familyaccount.view.managefamily.ManageOrganizerActivity$getFamilyManageModule$1
            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                FamilyManageContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
                FamilyManageContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3) {
                FamilyManageContract.View.CC.getAuthRequestContext(str, str2, str3);
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, SetLimitAndServicesRequestModel setLimitAndServicesRequestModel) {
                FamilyManageContract.View.CC.BuiltInFictitiousFunctionClassFactory(setLimitAndServicesRequestModel);
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void getAuthRequestContext() {
                FamilyManageContract.View.CC.getAuthRequestContext();
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
            public final void showProgress() {
                DanaLoadingDialog access$getDanaLoadingDialog = ManageOrganizerActivity.access$getDanaLoadingDialog(ManageOrganizerActivity.this);
                if (access$getDanaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                access$getDanaLoadingDialog.MyBillsEntityDataFactory.show();
                access$getDanaLoadingDialog.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                ManageOrganizerActivity.access$getDanaLoadingDialog(ManageOrganizerActivity.this).PlaceComponentResult();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final void MyBillsEntityDataFactory() {
                ManageOrganizerActivity.access$doWhenSuccessRemoveFamilyAccount(ManageOrganizerActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final void PlaceComponentResult() {
                ManageOrganizerActivity.access$doWhenFailedRemoveFamilyAccount(ManageOrganizerActivity.this, "");
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final void getAuthRequestContext(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                ManageOrganizerActivity.access$startPinChallenge(ManageOrganizerActivity.this, p0, p1);
            }
        }));
        authRequestContext.PlaceComponentResult().MyBillsEntityDataFactory(this);
    }

    public final void prepareBundle() {
        FamilyMemberInfoModel familyMemberInfoModel;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (familyMemberInfoModel = (FamilyMemberInfoModel) extras.getParcelable("FAMILY_MEMBER_INFO_MODEL")) == null) {
            return;
        }
        this.getAuthRequestContext = familyMemberInfoModel;
    }

    public final void initView() {
        TextView textView = getBinding().PlaceComponentResult;
        FamilyMemberInfoModel familyMemberInfoModel = this.getAuthRequestContext;
        if (familyMemberInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyMemberInfoModel = null;
        }
        String str = familyMemberInfoModel.getAuthRequestContext.getAuthRequestContext;
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, (char) InputCardNumberView.DIVIDER, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            str = str.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(str, "");
        }
        if (str.length() > 0) {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            StringBuilder sb = new StringBuilder();
            sb.append(upperCase);
            sb.append(substring);
            str = sb.toString();
        }
        textView.setText(str);
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.managefamily.ManageOrganizerActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageOrganizerActivity.m2603$r8$lambda$SnFjW2jswF2mKEWjXQquj4x4L8(ManageOrganizerActivity.this, view);
            }
        });
        getBinding().getAuthRequestContext.setVisibility(0);
        SkeletonScreen skeletonScreen = this.skeletonScreen;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory$default(ManageOrganizerActivity manageOrganizerActivity, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        manageOrganizerActivity.BuiltInFictitiousFunctionClassFactory(z, str);
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0, String p1) {
        if (p0) {
            DANAToast dANAToast = DANAToast.PlaceComponentResult;
            String string = getString(R.string.family_account_success_delete_family_account_message);
            Intrinsics.checkNotNullExpressionValue(string, "");
            DANAToast.getAuthRequestContext(this, string);
            return;
        }
        String str = p1;
        if (str == null || str.length() == 0) {
            DANAToast dANAToast2 = DANAToast.PlaceComponentResult;
            String string2 = getString(R.string.family_account_failed_delete_family_account_message);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            DANAToast.PlaceComponentResult(this, string2);
            return;
        }
        DANAToast dANAToast3 = DANAToast.PlaceComponentResult;
        DANAToast.PlaceComponentResult(this, p1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r2, int resultCode, Intent data) {
        Bundle extras;
        Bundle extras2;
        super.onActivityResult(r2, resultCode, data);
        if (r2 == 1009) {
            String str = null;
            if (resultCode == -1) {
                getFamilyAccountAnalyticalTracker().getAuthRequestContext("Success");
                BuiltInFictitiousFunctionClassFactory$default(this, true, null, 2, null);
                Intent intent = new Intent(this, FamilyStatusInformationActivity.class);
                intent.putExtra(FamilyStatusInformationActivity.FAMILY_STATUS, "FAMILY_ACCOUNT_DELETED");
                startActivity(intent);
            } else if (resultCode == 0) {
                String string = (data == null || (extras2 = data.getExtras()) == null) ? null : extras2.getString("message");
                if (data != null && (extras = data.getExtras()) != null) {
                    str = extras.getString(ChallengeControl.Key.CANCEL_REASON);
                }
                if (Intrinsics.areEqual(str, "back") || Intrinsics.areEqual(str, "close")) {
                    return;
                }
                getFamilyAccountAnalyticalTracker().getAuthRequestContext("Failed");
                BuiltInFictitiousFunctionClassFactory(false, string);
            }
        }
    }

    public final void showShimmer() {
        SkeletonScreen skeletonScreen = this.skeletonScreen;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
        getBinding().getAuthRequestContext.setVisibility(8);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getFamilyManagePresenter().onDestroy();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.MyBillsEntityDataFactory) {
            setResult(-1);
        }
        finish();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/familyaccount/view/managefamily/ManageOrganizerActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "p1", "Landroid/content/Intent;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Lid/dana/familyaccount/model/FamilyMemberInfoModel;)Landroid/content/Intent;", "", "FAMILY_MEMBER_INFO_MODEL", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent KClassImpl$Data$declaredNonStaticMembers$2(Context p0, FamilyMemberInfoModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, ManageOrganizerActivity.class);
            intent.putExtra("FAMILY_MEMBER_INFO_MODEL", p1);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$26r-xe5ZifiCaeynLuSwYGjIECo */
    public static /* synthetic */ void m2602$r8$lambda$26rxe5ZifiCaeynLuSwYGjIECo(ManageOrganizerActivity manageOrganizerActivity, View view) {
        Intrinsics.checkNotNullParameter(manageOrganizerActivity, "");
        manageOrganizerActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: $r8$lambda$SnFjW2js-wF2mKEWjXQquj4x4L8 */
    public static /* synthetic */ void m2603$r8$lambda$SnFjW2jswF2mKEWjXQquj4x4L8(ManageOrganizerActivity manageOrganizerActivity, View view) {
        Intrinsics.checkNotNullParameter(manageOrganizerActivity, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(manageOrganizerActivity);
        builder.GetContactSyncConfig = manageOrganizerActivity.getString(R.string.family_account_delete_family_account_description);
        builder.SubSequence = manageOrganizerActivity.getString(R.string.family_account_delete_family_account_question_mark);
        builder.BuiltInFictitiousFunctionClassFactory(manageOrganizerActivity.getString(R.string.button_delete), new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.managefamily.ManageOrganizerActivity$showDeleteFamilyAccountDialog$dialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                Intrinsics.checkNotNullParameter(view2, "");
                ManageOrganizerActivity.this.getFamilyManagePresenter().BuiltInFictitiousFunctionClassFactory();
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(manageOrganizerActivity.getString(R.string.cancel_allow_contact), new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.managefamily.ManageOrganizerActivity$showDeleteFamilyAccountDialog$dialog$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                Intrinsics.checkNotNullParameter(view2, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final /* synthetic */ void access$doWhenFailedRemoveFamilyAccount(ManageOrganizerActivity manageOrganizerActivity, String str) {
        manageOrganizerActivity.getFamilyAccountAnalyticalTracker().getAuthRequestContext("Failed");
        manageOrganizerActivity.BuiltInFictitiousFunctionClassFactory(false, str);
    }

    public static final /* synthetic */ void access$doWhenSuccessRemoveFamilyAccount(ManageOrganizerActivity manageOrganizerActivity) {
        manageOrganizerActivity.getFamilyAccountAnalyticalTracker().getAuthRequestContext("Success");
        BuiltInFictitiousFunctionClassFactory$default(manageOrganizerActivity, true, null, 2, null);
        Intent intent = new Intent(manageOrganizerActivity, FamilyStatusInformationActivity.class);
        intent.putExtra(FamilyStatusInformationActivity.FAMILY_STATUS, "FAMILY_ACCOUNT_DELETED");
        manageOrganizerActivity.startActivity(intent);
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(ManageOrganizerActivity manageOrganizerActivity) {
        return (DanaLoadingDialog) manageOrganizerActivity.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ void access$startPinChallenge(ManageOrganizerActivity manageOrganizerActivity, String str, String str2) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(manageOrganizerActivity);
        builder.scheduleImpl = ChallengeScenario.REMOVE_FAMILY_ACCOUNT;
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "family_account";
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        builder.E = str;
        builder.BottomSheetCardBindingView$watcherCardNumberView$1 = str2;
        new ChallengeControl(builder, null).getAuthRequestContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().BuiltInFictitiousFunctionClassFactory;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.manage_family_role_organizer));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().BuiltInFictitiousFunctionClassFactory;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.managefamily.ManageOrganizerActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageOrganizerActivity.m2602$r8$lambda$26rxe5ZifiCaeynLuSwYGjIECo(ManageOrganizerActivity.this, view);
            }
        });
        Toolbar toolbar = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        for (View view : ViewGroupKt.BuiltInFictitiousFunctionClassFactory(toolbar)) {
            ImageButton imageButton = view instanceof ImageButton ? (ImageButton) view : null;
            if (imageButton != null) {
                imageButton.setContentDescription(getResources().getString(R.string.imgBtnLeft));
            }
        }
        TextView textView2 = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(4);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        this.skeletonScreen = ShimmeringUtil.PlaceComponentResult(getBinding().scheduleImpl, R.layout.view_family_account_manage_skeleton);
        showShimmer();
        prepareBundle();
        initView();
        ManageFamilyView manageFamilyView = getBinding().lookAheadTest;
        FamilyMemberInfoModel familyMemberInfoModel = this.getAuthRequestContext;
        if (familyMemberInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyMemberInfoModel = null;
        }
        manageFamilyView.setManageFamilyType(familyMemberInfoModel);
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = NetworkUserEntityData$$ExternalSyntheticLambda1;
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
        int[] iArr5 = NetworkUserEntityData$$ExternalSyntheticLambda1;
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
