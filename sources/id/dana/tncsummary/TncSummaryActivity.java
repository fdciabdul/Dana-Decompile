package id.dana.tncsummary;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Process;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.CompoundButtonCompat;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.base.BaseActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerTncSummaryComponent;
import id.dana.di.component.TncSummaryComponent;
import id.dana.di.modules.TncSummaryModules;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.richview.WebProgressView;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tncsummary.model.TncSummaryEvent;
import id.dana.util.RaspUtils;
import id.dana.utils.DANAToast;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class TncSummaryActivity extends BaseActivity {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String AGREEMENT_INFO = "agreement_info";
    private static char[] DatabaseTableConfigUtil;
    private static int GetContactSyncConfig;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2;
    public static final byte[] PlaceComponentResult;
    public static final int getAuthRequestContext;
    @BindView(R.id.btn_dialog_tnc_agree)
    DanaButtonPrimaryView btnDialogTncAgree;
    @BindView(R.id.cb_dialog_tnc)
    CheckBox cbDialogTnc;
    @BindView(R.id.cl_tnc_container)
    ConstraintLayout clContainer;
    @BindView(R.id.iv_dialog_tnc)
    ImageView ivDialogTnc;
    private TncSummaryComponent lookAheadTest;
    @BindView(R.id.pb_dialog_tnc)
    ProgressBar pbDialogTnc;
    private List<AgreementInfo> scheduleImpl;
    @Inject
    TncSummaryContract.Presenter tncSummaryPresenter;
    @BindView(R.id.tv_dialog_tnc_agreement)
    TextView tvDialogTncAgreement;
    @BindView(R.id.tv_dialog_tnc_error)
    TextView tvDialogTncError;
    @BindView(R.id.tv_dialog_tnc_header)
    TextView tvDialogTncHeader;
    @BindView(R.id.wpv_dialog_tnc)
    WebProgressView wpvDialogTnc;
    public static final byte[] $$a = {2, -87, 98, TarHeader.LF_FIFO, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 159;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private int getErrorConfigVersion = 0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;

    static {
        NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
        getAuthRequestContext();
        PlaceComponentResult = new byte[]{112, Ascii.US, -51, -82, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        getAuthRequestContext = 57;
        GetContactSyncConfig = 269894730;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 63;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0038 -> B:9:0x001d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = id.dana.tncsummary.TncSummaryActivity.PlaceComponentResult
            int r5 = r5 + 97
            int r7 = r7 + 16
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 79
            if (r0 != 0) goto L13
            r3 = 79
            goto L15
        L13:
            r3 = 78
        L15:
            r4 = 0
            if (r3 == r2) goto L1f
            r2 = r1
            r3 = 0
            r1 = r0
            r0 = r8
            r8 = r7
        L1d:
            r7 = r5
            goto L3e
        L1f:
            int r2 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r2 = r2 + 37
            int r3 = r2 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3
            int r2 = r2 % 2
            int r2 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r2 = r2 + 17
            int r3 = r2 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r3
            int r2 = r2 % 2
            r2 = r1
            r3 = 0
            r1 = r0
            r0 = r8
            r8 = r7
        L38:
            int r7 = r7 + r5
            int r6 = r6 + 1
            int r5 = r7 + (-4)
            goto L1d
        L3e:
            byte r5 = (byte) r7
            r2[r3] = r5
            if (r3 != r8) goto L4b
            java.lang.String r5 = new java.lang.String
            r5.<init>(r2, r4)
            r0[r4] = r5
            return
        L4b:
            int r3 = r3 + 1
            r5 = r1[r6]
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.tncsummary.TncSummaryActivity.a(short, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = 46 - r7
            int r6 = r6 * 2
            int r6 = r6 + 75
            byte[] r0 = id.dana.tncsummary.TncSummaryActivity.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L19
            r6 = r8
            r3 = r1
            r4 = 0
            r8 = r7
            r1 = r0
            r0 = r9
            r9 = r6
            goto L38
        L19:
            r3 = 0
            r5 = r8
            r8 = r6
            r6 = r5
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            int r3 = r3 + 1
            if (r3 != r6) goto L2e
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2e:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.tncsummary.TncSummaryActivity.c(byte, int, int, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        DatabaseTableConfigUtil = new char[]{35460, 35548, 35575, 35553, 35553, 35358};
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x00a0, code lost:
    
        if ((r1 > 99999) != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0730  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0919  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x091b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x091e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0aea A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0927 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0571 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0291 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x055a  */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r31) {
        /*
            Method dump skipped, instructions count: 3150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.tncsummary.TncSummaryActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 == 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 89;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        Context applicationContext = super.getApplicationContext();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 != 0 ? '`' : 'W') != '`') {
            return applicationContext;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return applicationContext;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if (!(i % 2 == 0)) {
            return super.getBaseContext();
        }
        Context baseContext = super.getBaseContext();
        Object[] objArr = null;
        int length = objArr.length;
        return baseContext;
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? '9' : 'B') != 'B') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        if ((i2 % 2 != 0 ? 'S' : '%') != 'S') {
            return R.layout.activity_dialog_tnc;
        }
        int i3 = 2 / 0;
        return R.layout.activity_dialog_tnc;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 != 0) {
            int i2 = 43 / 0;
            return super.getResources();
        }
        return super.getResources();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (!(baseContext != null)) {
            int touchSlop = 210 - (ViewConfiguration.getTouchSlop() >> 8);
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 95;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                a(b, b, (byte) (-PlaceComponentResult[30]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a((byte) (-PlaceComponentResult[5]), (byte) (getAuthRequestContext - 5), PlaceComponentResult[56], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(true, touchSlop, ((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 17, getPackageName().length() + 19, new char[]{6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int length = super.getResources().getString(R.string.system_busy_error).substring(49, 51).length() + 215;
                int capsMode = 12 - TextUtils.getCapsMode("", 0, 0);
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 17;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
                int i4 = i3 % 2;
                try {
                    byte b2 = PlaceComponentResult[25];
                    Object[] objArr3 = new Object[1];
                    a(b2, b2, (byte) (-PlaceComponentResult[30]), objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    a((byte) (-PlaceComponentResult[5]), (byte) (getAuthRequestContext - 5), PlaceComponentResult[56], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(true, length, capsMode, ((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529}, objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
        if ((baseContext != null ? InputCardNumberView.DIVIDER : '\f') != '\f') {
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 67;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
            char c = i5 % 2 != 0 ? '+' : (char) 5;
            baseContext = baseContext.getApplicationContext();
            if (c == '+') {
                int i6 = 96 / 0;
            }
        }
        if (!(baseContext == null)) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 18 - View.getDefaultSize(0, 0), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onResume();
    }

    static /* synthetic */ int access$000(TncSummaryActivity tncSummaryActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        boolean z = i % 2 == 0;
        int i2 = tncSummaryActivity.getErrorConfigVersion;
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return i2;
    }

    static /* synthetic */ void access$100(TncSummaryActivity tncSummaryActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? '#' : 'c') == 'c') {
            tncSummaryActivity.BuiltInFictitiousFunctionClassFactory();
            return;
        }
        tncSummaryActivity.BuiltInFictitiousFunctionClassFactory();
        Object[] objArr = null;
        int length = objArr.length;
    }

    static /* synthetic */ void access$200(TncSummaryActivity tncSummaryActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        char c = i % 2 != 0 ? '(' : '`';
        tncSummaryActivity.newProxyInstance();
        if (c != '(') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    static /* synthetic */ void access$300(TncSummaryActivity tncSummaryActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 33;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        scheduleImpl();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 6 : 'W') != 6) {
            return;
        }
        int i4 = 51 / 0;
    }

    static /* synthetic */ void access$400(TncSummaryActivity tncSummaryActivity) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 55;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                lookAheadTest();
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 51;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ int access$502(TncSummaryActivity tncSummaryActivity, int i) {
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 13;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
                int i3 = i2 % 2;
                tncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 35;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i4 % 128;
                if (i4 % 2 == 0) {
                    int i5 = 66 / 0;
                    return i;
                }
                return i;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private TncSummaryModules PlaceComponentResult() {
        TncSummaryModules tncSummaryModules = new TncSummaryModules(new TncSummaryContract.View() { // from class: id.dana.tncsummary.TncSummaryActivity.1
            @Override // id.dana.tncsummary.TncSummaryContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<AgreementInfo> list) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void onError(String str) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void showProgress() {
            }

            @Override // id.dana.tncsummary.TncSummaryContract.View
            public final void PlaceComponentResult(boolean z) {
                String string;
                String string2;
                if (z) {
                    DANAToast dANAToast = DANAToast.PlaceComponentResult;
                    TncSummaryActivity tncSummaryActivity = TncSummaryActivity.this;
                    if (TncSummaryActivity.access$000(tncSummaryActivity) == 1) {
                        string2 = TncSummaryActivity.this.getString(R.string.kyb_record_tnc_success_message);
                    } else {
                        string2 = TncSummaryActivity.this.getString(R.string.tnc_custom_toast_text);
                    }
                    Intrinsics.checkNotNullParameter(tncSummaryActivity, "");
                    Intrinsics.checkNotNullParameter(string2, "");
                    DANAToast.getAuthRequestContext(tncSummaryActivity, string2);
                    TncSummaryActivity.this.setResult(-1, new Intent());
                    TncSummaryActivity.this.finish();
                    return;
                }
                DANAToast dANAToast2 = DANAToast.PlaceComponentResult;
                TncSummaryActivity tncSummaryActivity2 = TncSummaryActivity.this;
                if (TncSummaryActivity.access$000(tncSummaryActivity2) == 1) {
                    string = TncSummaryActivity.this.getString(R.string.kyb_record_tnc_fail_message);
                } else {
                    string = TncSummaryActivity.this.getString(R.string.tnc_failed_toast_text);
                }
                Intrinsics.checkNotNullParameter(tncSummaryActivity2, "");
                Intrinsics.checkNotNullParameter(string, "");
                DANAToast.PlaceComponentResult(tncSummaryActivity2, string);
                if (TncSummaryActivity.access$000(TncSummaryActivity.this) == 1) {
                    TncSummaryActivity.this.finish();
                }
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        return tncSummaryModules;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00eb, code lost:
    
        if ((r2 <= 99999) != true) goto L16;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r30) {
        /*
            Method dump skipped, instructions count: 2078
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.tncsummary.TncSummaryActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
    
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
    
        if ((r0 != null ? '8' : 24) != '8') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
    
        r0.chckTmprdApp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        r0 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 + 125;
        id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
    
        if ((r0 % 2) == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        if (r1 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        r0 = 31 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
    
        return;
     */
    @Override // id.dana.base.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init() {
        /*
            r5 = this;
            int r0 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            java.lang.String r3 = "tnc_summary_variant"
            java.lang.String r4 = "agreement_info"
            if (r0 == 0) goto L3d
            android.content.Intent r0 = r5.getIntent()     // Catch: java.lang.Exception -> L3b
            java.util.ArrayList r0 = r0.getParcelableArrayListExtra(r4)     // Catch: java.lang.Exception -> L39
            r5.scheduleImpl = r0     // Catch: java.lang.Exception -> L39
            android.content.Intent r0 = r5.getIntent()     // Catch: java.lang.Exception -> L39
            int r0 = r0.getIntExtra(r3, r2)     // Catch: java.lang.Exception -> L39
            r5.getErrorConfigVersion = r0     // Catch: java.lang.Exception -> L39
            r5.NetworkUserEntityData$$ExternalSyntheticLambda0()     // Catch: java.lang.Exception -> L39
            r5.moveToNextValue()     // Catch: java.lang.Exception -> L39
            id.dana.DanaApplication r0 = r5.getDanaApplication()     // Catch: java.lang.Exception -> L39
            if (r0 == 0) goto L6a
            goto L67
        L39:
            r0 = move-exception
            throw r0
        L3b:
            r0 = move-exception
            throw r0
        L3d:
            android.content.Intent r0 = r5.getIntent()
            java.util.ArrayList r0 = r0.getParcelableArrayListExtra(r4)
            r5.scheduleImpl = r0
            android.content.Intent r0 = r5.getIntent()
            int r0 = r0.getIntExtra(r3, r2)
            r5.getErrorConfigVersion = r0
            r5.NetworkUserEntityData$$ExternalSyntheticLambda0()
            r5.moveToNextValue()
            id.dana.DanaApplication r0 = r5.getDanaApplication()
            r3 = 56
            if (r0 == 0) goto L62
            r4 = 56
            goto L64
        L62:
            r4 = 24
        L64:
            if (r4 == r3) goto L67
            goto L6a
        L67:
            r0.chckTmprdApp()
        L6a:
            int r0 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 125
            int r3 = r0 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L77
            goto L78
        L77:
            r1 = 0
        L78:
            if (r1 == 0) goto L80
            r0 = 31
            int r0 = r0 / r2
            return
        L7e:
            r0 = move-exception
            throw r0
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.tncsummary.TncSummaryActivity.init():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        r1 = new java.lang.Object[1];
        b(true, android.text.TextUtils.lastIndexOf("", '0', 0, 0) + 211, getPackageName().length() + 9, super.getResources().getString(id.dana.R.string.automation_passkey_btn_activate_passkey).substring(0, 20).length() + 6, new char[]{6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19}, r1);
        r1 = java.lang.Class.forName((java.lang.String) r1[0]);
        r0 = new java.lang.Object[1];
        b(true, super.getResources().getString(id.dana.R.string.error_16_digit).substring(20, 23).codePointAt(0) + com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant.HANDSHAKE_RECEIVE_SIZE, 11 - android.text.TextUtils.lastIndexOf("", '0', 0), getPackageName().length() + 11, new char[]{65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529}, r0);
        r0 = (android.content.Context) r1.getMethod((java.lang.String) r0[0], new java.lang.Class[0]).invoke(null, null);
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPause() {
        /*
            Method dump skipped, instructions count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.tncsummary.TncSummaryActivity.onPause():void");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTncSummaryEvent(TncSummaryEvent tncSummaryEvent) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 69;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        this.scheduleImpl = tncSummaryEvent.PlaceComponentResult;
        moveToNextValue();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 113;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 12 / 0;
        }
    }

    private void moveToNextValue() {
        String str;
        List<AgreementInfo> list = this.scheduleImpl;
        if (list != null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 9;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            Object obj = null;
            if ((i % 2 == 0 ? '7' : 'D') != 'D') {
                boolean isEmpty = list.isEmpty();
                obj.hashCode();
                if (isEmpty) {
                    return;
                }
            } else {
                if ((!list.isEmpty() ? '\r' : (char) 4) != '\r') {
                    return;
                }
            }
            this.btnDialogTncAgree.setEnabled(false);
            NetworkUserEntityData$$ExternalSyntheticLambda1();
            KClassImpl$Data$declaredNonStaticMembers$2();
            if (this.scheduleImpl.get(0).getContentValue() != null) {
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 55;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
                int i3 = i2 % 2;
                str = (String) Objects.requireNonNull(this.scheduleImpl.get(0).getContentValue());
            } else {
                str = "";
            }
            this.wpvDialogTnc.loadDataWithBaseUrl(null, TextUtil.getAuthRequestContext(str));
            this.wpvDialogTnc.getWebView().setInitialScale(0);
            this.wpvDialogTnc.getWebView().getSettings().setDefaultFontSize(16);
            this.wpvDialogTnc.getWebView().getSettings().setBuiltInZoomControls(false);
            this.wpvDialogTnc.getWebView().getSettings().setLoadWithOverviewMode(false);
            this.wpvDialogTnc.getWebView().getSettings().setUseWideViewPort(false);
            this.wpvDialogTnc.getWebView().setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.f27102131100497));
            this.wpvDialogTnc.setScrollbarFadingEnabled(false);
            this.wpvDialogTnc.setWebProgressViewListener(new WebProgressView.WebProgressViewListener() { // from class: id.dana.tncsummary.TncSummaryActivity.2
                @Override // id.dana.richview.WebProgressView.WebProgressViewListener
                public final void PlaceComponentResult(WebView webView, String str2) {
                    if (TncSummaryActivity.access$000(TncSummaryActivity.this) != 1) {
                        TncSummaryActivity.access$100(TncSummaryActivity.this);
                        return;
                    }
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.addJavascriptInterface(new TncSummaryWebAppInterface(webView), "AndroidGetHeightFunction");
                    InstrumentInjector.trackWebView(webView);
                    webView.loadUrl("javascript:AndroidGetHeightFunction.checkContentHeight(document.body.scrollHeight)");
                }

                @Override // id.dana.richview.WebProgressView.WebProgressViewListener
                public final void PlaceComponentResult(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    TncSummaryActivity.access$200(TncSummaryActivity.this);
                }
            });
        }
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        if (this.getErrorConfigVersion != 1) {
            GetContactSyncConfig();
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 113;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
        } else {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 91;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            char c = i3 % 2 == 0 ? 'O' : (char) 1;
            NetworkUserEntityData$$ExternalSyntheticLambda2();
            if (c != 'O') {
                Object obj = null;
                obj.hashCode();
            }
        }
        this.clContainer.setVisibility(0);
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        this.ivDialogTnc.setVisibility(8);
        this.clContainer.setBackgroundResource(R.drawable.bg_rounded_8dp);
        initRecordTimeStamp();
        DatabaseTableConfigUtil();
        this.tvDialogTncHeader.setText(getString(R.string.kyb_tnc_header));
        this.tvDialogTncAgreement.setText(getString(R.string.kyb_agree_tnc));
        this.wpvDialogTnc.getWebView().getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: id.dana.tncsummary.TncSummaryActivity$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                TncSummaryActivity.this.m2988lambda$setKybTncVariant$0$iddanatncsummaryTncSummaryActivity();
            }
        });
        getErrorConfigVersion();
        BuiltInFictitiousFunctionClassFactory();
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 95;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? 'C' : '8') != 'C') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setKybTncVariant$0$id-dana-tncsummary-TncSummaryActivity  reason: not valid java name */
    public /* synthetic */ void m2988lambda$setKybTncVariant$0$iddanatncsummaryTncSummaryActivity() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 63;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                int i2 = i % 2;
                WebView webView = this.wpvDialogTnc.getWebView();
                double floor = Math.floor(webView.getContentHeight() * getResources().getDisplayMetrics().density);
                double height = webView.getHeight();
                double scrollY = webView.getScrollY();
                Double.isNaN(height);
                boolean z = false;
                if (!(scrollY < (floor - height) - 10.0d)) {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 3;
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
                    if (i3 % 2 != 0) {
                        z = true;
                    }
                }
                if ((z ? 'Z' : (char) 23) != 'Z') {
                    return;
                }
                BuiltInFictitiousFunctionClassFactory();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void DatabaseTableConfigUtil() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f28052131165274);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f28012131165267);
        this.clContainer.setPadding(getResources().getDimensionPixelSize(R.dimen.f28012131165267), dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.f28012131165267), dimensionPixelSize2);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    private void initRecordTimeStamp() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 99;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.clContainer.getLayoutParams();
        marginLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.f30562131165658);
        marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.f30562131165658);
        this.clContainer.setLayoutParams(marginLayoutParams);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private void getErrorConfigVersion() {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$22;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (!(i % 2 != 0)) {
            KClassImpl$Data$declaredNonStaticMembers$22 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(getResources(), R.color.f25512131100174, getTheme());
            CompoundButtonCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.cbDialogTnc, KClassImpl$Data$declaredNonStaticMembers$22);
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(getResources(), R.color.f25512131100174, getTheme());
        CompoundButtonCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.cbDialogTnc, KClassImpl$Data$declaredNonStaticMembers$2);
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if ((r1 != null) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        if (r6.cbDialogTnc != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        if (r6.tvDialogTncAgreement == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        r1 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 + 125;
        id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        if ((r1 % 2) != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
    
        r0.setVisibility(123);
        r6.cbDialogTnc.setVisibility(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        r0.setVisibility(8);
        r6.cbDialogTnc.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
    
        r6.cbDialogTnc.setEnabled(true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void BuiltInFictitiousFunctionClassFactory() {
        /*
            r6 = this;
            int r0 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            android.widget.ProgressBar r0 = r6.pbDialogTnc
            r1 = 42
            if (r0 == 0) goto L13
            r2 = 42
            goto L15
        L13:
            r2 = 77
        L15:
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == r1) goto L1b
            goto L64
        L1b:
            int r1 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r1 = r1 + 65
            int r2 = r1 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L36
            android.widget.CheckBox r1 = r6.cbDialogTnc     // Catch: java.lang.Exception -> L34
            int r2 = r3.length     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L2e
            r1 = 1
            goto L2f
        L2e:
            r1 = 0
        L2f:
            if (r1 == 0) goto L64
            goto L3a
        L32:
            r0 = move-exception
            throw r0
        L34:
            r0 = move-exception
            throw r0
        L36:
            android.widget.CheckBox r1 = r6.cbDialogTnc
            if (r1 == 0) goto L64
        L3a:
            android.widget.TextView r1 = r6.tvDialogTncAgreement
            if (r1 == 0) goto L64
            int r1 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r1 = r1 + 125
            int r2 = r1 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L55
            r1 = 123(0x7b, float:1.72E-43)
            r0.setVisibility(r1)
            android.widget.CheckBox r0 = r6.cbDialogTnc
            r0.setVisibility(r5)
            goto L5f
        L55:
            r1 = 8
            r0.setVisibility(r1)
            android.widget.CheckBox r0 = r6.cbDialogTnc
            r0.setVisibility(r4)
        L5f:
            android.widget.CheckBox r0 = r6.cbDialogTnc
            r0.setEnabled(r5)
        L64:
            int r0 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 121
            int r1 = r0 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L71
            r4 = 1
        L71:
            if (r4 == r5) goto L74
            return
        L74:
            r3.hashCode()     // Catch: java.lang.Throwable -> L78
            return
        L78:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.tncsummary.TncSummaryActivity.BuiltInFictitiousFunctionClassFactory():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        if ((r0 != null ? 'T' : 'K') != 'K') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        r2 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 + 61;
        id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        if (r4.tvDialogTncError == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        r0.setVisibility(8);
        r4.tvDialogTncError.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        r0 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 + 107;
        id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r0 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void newProxyInstance() {
        /*
            r4 = this;
            int r0 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 125
            int r1 = r0 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto Lf
            r0 = 0
            goto L11
        Lf:
            r0 = 90
        L11:
            if (r0 == 0) goto L1a
            id.dana.richview.WebProgressView r0 = r4.wpvDialogTnc     // Catch: java.lang.Exception -> L18
            if (r0 == 0) goto L46
            goto L2b
        L18:
            r0 = move-exception
            throw r0
        L1a:
            id.dana.richview.WebProgressView r0 = r4.wpvDialogTnc
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L51
            r2 = 75
            if (r0 == 0) goto L27
            r3 = 84
            goto L29
        L27:
            r3 = 75
        L29:
            if (r3 == r2) goto L46
        L2b:
            int r2 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r2 = r2 + 61
            int r3 = r2 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r3
            int r2 = r2 % 2
            android.widget.TextView r2 = r4.tvDialogTncError     // Catch: java.lang.Exception -> L44
            if (r2 == 0) goto L46
            r2 = 8
            r0.setVisibility(r2)
            android.widget.TextView r0 = r4.tvDialogTncError
            r0.setVisibility(r1)
            goto L46
        L44:
            r0 = move-exception
            throw r0
        L46:
            int r0 = id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.tncsummary.TncSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            return
        L51:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.tncsummary.TncSummaryActivity.newProxyInstance():void");
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        if (this.lookAheadTest == null) {
            DaggerTncSummaryComponent.Builder PlaceComponentResult2 = DaggerTncSummaryComponent.PlaceComponentResult();
            PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            PlaceComponentResult2.MyBillsEntityDataFactory = (TncSummaryModules) Preconditions.getAuthRequestContext(PlaceComponentResult());
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.MyBillsEntityDataFactory, TncSummaryModules.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            this.lookAheadTest = new DaggerTncSummaryComponent.TncSummaryComponentImpl(PlaceComponentResult2.MyBillsEntityDataFactory, PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, (byte) 0);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 5;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            int i4 = i3 % 2;
        }
        this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 101;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.heightPixels;
        float f2 = displayMetrics.widthPixels;
        if (this.clContainer != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.getAuthRequestContext(this.clContainer);
            int id2 = this.clContainer.getId();
            StringBuilder sb = new StringBuilder();
            sb.append("H,");
            sb.append(f2);
            sb.append(":");
            sb.append(f);
            constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(id2).BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = sb.toString();
            constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this.clContainer);
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 24 : '!') != '!') {
            int i4 = 0 / 0;
        }
    }

    private static void scheduleImpl() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION));
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 111;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            if (i3 % 2 == 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static void lookAheadTest() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        try {
            DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(DanaUrl.PRIVACY_POLICY));
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 121;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if ((i3 % 2 != 0 ? '#' : 'M') != '#') {
                return;
            }
            int i4 = 81 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @OnClick({R.id.btn_dialog_tnc_agree})
    public void onDialogTncAgree() {
        ArrayList arrayList = new ArrayList();
        Iterator<AgreementInfo> it = this.scheduleImpl.iterator();
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 63;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        while (true) {
            if (it.hasNext()) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 123;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
                try {
                    arrayList.add(it.next().getAgreementKey());
                } catch (Exception e) {
                    throw e;
                }
            } else {
                this.tncSummaryPresenter.KClassImpl$Data$declaredNonStaticMembers$2(arrayList);
                return;
            }
        }
    }

    @OnCheckedChanged({R.id.cb_dialog_tnc})
    public void onCheckboxChanged(boolean z) {
        if ((this.getErrorConfigVersion != 1 ? '5' : (char) 11) != 11) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 27;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            GetContactSyncConfig();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 79;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            int i4 = i3 % 2;
        }
        if (this.getErrorConfigVersion == 1) {
            this.wpvDialogTnc.post(new Runnable() { // from class: id.dana.tncsummary.TncSummaryActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    TncSummaryActivity.this.m2987lambda$onCheckboxChanged$1$iddanatncsummaryTncSummaryActivity();
                }
            });
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 119;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i5 % 128;
            int i6 = i5 % 2;
        }
        this.btnDialogTncAgree.setDanaButtonView(z ? 1 : 0, getString(R.string.tnc_ok_button), null, null);
        this.btnDialogTncAgree.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCheckboxChanged$1$id-dana-tncsummary-TncSummaryActivity  reason: not valid java name */
    public /* synthetic */ void m2987lambda$onCheckboxChanged$1$iddanatncsummaryTncSummaryActivity() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 41;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        if ((this.NetworkUserEntityData$$ExternalSyntheticLambda0 > 0 ? Typography.less : (char) 17) == '<') {
            this.wpvDialogTnc.getWebView().scrollTo(0, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 65 / 0;
        }
    }

    private void GetContactSyncConfig() {
        TextUtil.PlaceComponentResult(this.tvDialogTncAgreement, new ClickableSpan[]{new ClickableSpan() { // from class: id.dana.tncsummary.TncSummaryActivity.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TncSummaryActivity.access$300(TncSummaryActivity.this);
            }
        }, new ClickableSpan() { // from class: id.dana.tncsummary.TncSummaryActivity.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TncSummaryActivity.access$400(TncSummaryActivity.this);
            }
        }}, -15692055, getString(R.string.tnc_checkbox_description), new String[]{getString(R.string.i_agree_check_box_clickable), getString(R.string.privacy_policy_check_box_clickable)});
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 == 0) {
            return;
        }
        int i2 = 71 / 0;
    }

    /* loaded from: classes3.dex */
    class TncSummaryWebAppInterface {
        private final WebView PlaceComponentResult;

        public TncSummaryWebAppInterface(WebView webView) {
            this.PlaceComponentResult = webView;
        }

        @JavascriptInterface
        public void checkContentHeight(float f) {
            int measuredHeight = this.PlaceComponentResult.getMeasuredHeight();
            double d = TncSummaryActivity.this.getResources().getDisplayMetrics().density;
            double d2 = f;
            Double.isNaN(d2);
            Double.isNaN(d);
            double d3 = d2 * d;
            TncSummaryActivity.access$502(TncSummaryActivity.this, (int) d3);
            if (!(d3 >= ((double) (measuredHeight + 10)))) {
                TncSummaryActivity.access$100(TncSummaryActivity.this);
            }
            this.PlaceComponentResult.getSettings().setJavaScriptEnabled(false);
        }
    }

    public static void aueHbkmutZ(long j, long j2) {
        long j3 = j ^ (j2 << 32);
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        g(new byte[]{1, 0, 1, 1, 0, 1}, new int[]{0, 6, 21, 0}, true, objArr);
        sb.append((String) objArr[0]);
        sb.append(j3);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
        RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
        Intrinsics.checkNotNullParameter(dexguardException, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(dexguardException);
        RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.ROOTED);
        UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.ROOTED);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
    }

    private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if (a2.MyBillsEntityDataFactory >= i3) {
                break;
            }
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (GetContactSyncConfig ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
            int i5 = $11 + 103;
            $10 = i5 % 128;
            int i6 = i5 % 2;
        }
        if ((i2 > 0 ? 'c' : 'N') != 'N') {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            int i7 = $10 + 113;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            while (true) {
                if (!(a2.MyBillsEntityDataFactory < i3)) {
                    break;
                }
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    private static void g(byte[] bArr, int[] iArr, boolean z, Object[] objArr) {
        int length;
        char[] cArr;
        int i;
        int i2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = 2;
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr2 = DatabaseTableConfigUtil;
        if (!(cArr2 == null)) {
            try {
                int i9 = $10 + 113;
                $11 = i9 % 128;
                if (i9 % 2 == 0) {
                    length = cArr2.length;
                    cArr = new char[length];
                    i = 1;
                } else {
                    length = cArr2.length;
                    cArr = new char[length];
                    i = 0;
                }
                while (i < length) {
                    int i10 = $11 + 77;
                    $10 = i10 % 128;
                    if (i10 % i6 != 0) {
                        i3 = i7;
                        cArr[i] = (char) (cArr2[i] - 5097613533456403102L);
                        i /= 0;
                    } else {
                        i3 = i7;
                        cArr[i] = (char) (cArr2[i] ^ 5097613533456403102L);
                        i++;
                    }
                    i7 = i3;
                    i6 = 2;
                }
                i2 = i7;
                cArr2 = cArr;
            } catch (Exception e) {
                throw e;
            }
        } else {
            i2 = i7;
        }
        char[] cArr3 = new char[i5];
        System.arraycopy(cArr2, i4, cArr3, 0, i5);
        if (bArr != null) {
            char[] cArr4 = new char[i5];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (true) {
                if (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory >= i5) {
                    break;
                }
                if (!(bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1)) {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if (!(i8 <= 0)) {
            int i11 = $11 + 1;
            $10 = i11 % 128;
            if ((i11 % 2 != 0 ? (char) 23 : '(') != 23) {
                char[] cArr5 = new char[i5];
                System.arraycopy(cArr3, 0, cArr5, 0, i5);
                int i12 = i5 - i8;
                System.arraycopy(cArr5, 0, cArr3, i12, i8);
                System.arraycopy(cArr5, i8, cArr3, 0, i12);
            } else {
                char[] cArr6 = new char[i5];
                System.arraycopy(cArr3, 1, cArr6, 1, i5);
                System.arraycopy(cArr6, 1, cArr3, i5 >> i8, i8);
                System.arraycopy(cArr6, i8, cArr3, 0, i5 + i8);
            }
        }
        if ((z ? '`' : '\\') == '`') {
            int i13 = $10 + 113;
            $11 = i13 % 128;
            int i14 = i13 % 2;
            char[] cArr7 = new char[i5];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                cArr7[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i5 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr7;
        }
        if ((i2 > 0 ? '9' : 'S') != 'S') {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        String str = new String(cArr3);
        int i15 = $10 + 121;
        $11 = i15 % 128;
        if ((i15 % 2 == 0 ? '0' : (char) 11) == 11) {
            objArr[0] = str;
            return;
        }
        int i16 = 28 / 0;
        objArr[0] = str;
    }
}
