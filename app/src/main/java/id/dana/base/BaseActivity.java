package id.dana.base;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.Unbinder;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.anggrayudi.storage.extension.ContextUtils;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContract;
import id.dana.base.BaseButterKnife;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.dialog.WarningDialogUtil;
import id.dana.core.ui.util.preventscreenshot.PreventScreenshotEvent;
import id.dana.core.ui.util.preventscreenshot.PreventScreenshotUtil;
import id.dana.data.foundation.RpcException;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.ActivityModule;
import id.dana.dialog.CommonDialog;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.util.StringUtils;
import id.dana.utils.NfcHelper;
import id.dana.utils.OSUtil;
import id.dana.utils.SizeUtil;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public abstract class BaseActivity extends AppCompatActivity implements MenuItemFacade, DisposableHandler, PresenterHandler, FragmentListener, MultipleClickHandler, BaseButterKnife {
    private static char[] PlaceComponentResult;
    private static char getAuthRequestContext;
    @Inject
    AppLifeCycleObserver appLifeCycleObserver;
    private boolean clickable;
    @Inject
    Lazy<ConnectionStatusReceiver> connectionStatusReceiver;
    @Inject
    Lazy<FeatureConfigRepository> featureConfigRepository;
    protected ImageView icImageFg;
    private int icon;
    protected TextView leftButton;
    private List<AbstractContract.AbstractPresenter> presenterList;
    protected TextView rightButton;
    protected RelativeLayout rightProgressBar;
    protected RelativeLayout rlToolbar;
    protected Toolbar toolbar;
    protected ImageView toolbarImage;
    protected ConstraintLayout toolbarLayout;
    protected AppCompatImageView toolbarLeftImage;
    public TextView toolbarTitle;
    private Unbinder unbinder;
    public static final byte[] $$d = {95, 85, -94, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 79;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {37, 81, 122, 15, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int moveToNextValue = 12;
    protected boolean injectConnectionStatusReceiver = true;
    protected boolean lazyInit = false;
    protected boolean skipInit = false;
    private final NfcHelper nfcHelper = new NfcHelper();
    private CompositeDisposable disposables = new CompositeDisposable();
    public int pageHeight = 0;
    private List<String> screenshotDisabledActivities = new ArrayList();

    static void MyBillsEntityDataFactory() {
        getAuthRequestContext = (char) 42066;
        PlaceComponentResult = new char[]{42070, 42068, 37374, 37288, 37371, 37305, 37310, 37367, 37292, 37262, 37365, 37291, 37311, 37279, 37375, 42077, 42078, 37275, 42079, 37306, 37287, 37286, 37372, 42064, 37370, 42066, 42067, 37308, 37309, 37290, 37302, 37345, 37274, 37282, 37368, 42065, 37369, 37283, 37344, 37294, 37307, 37373, 37293, 42076, 37366, 37281, 37289, 37280, 42071};
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0029 -> B:35:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = 55 - r6
            byte[] r0 = id.dana.base.BaseActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = 23 - r8
            int r7 = r7 + 97
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L14:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L18:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.base.BaseActivity.e(short, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0024 -> B:35:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.base.BaseActivity.$$d
            int r7 = 47 - r7
            int r6 = r6 * 3
            int r6 = r6 + 21
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r7
            r4 = 0
            goto L26
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r6) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            r3 = r0[r7]
        L26:
            int r7 = r7 + 1
            int r8 = r8 + r3
            int r8 = r8 + (-7)
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.base.BaseActivity.f(short, int, short, java.lang.Object[]):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        d((byte) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 47), new char[]{Typography.amp, '.', 7, InputCardNumberView.DIVIDER, '*', JSONLexer.EOI, '\n', InputCardNumberView.DIVIDER, '0', JSONLexer.EOI, Typography.quote, '\n', '!', '*', 15, Typography.dollar, 13848, 13848}, 18 - Color.blue(0), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        d((byte) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 55), new char[]{Typography.quote, 31, 28, 25, 13877}, View.resolveSizeAndState(0, 0, 0) + 5, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    d((byte) (17 - MotionEvent.axisFromString("")), new char[]{29, '\r', '#', '\b', 18, 7, '*', '\t', 28, 30, 11, '+', Typography.quote, Typography.dollar, 1, '%', 13757, 13757, '%', '(', '\f', '\t', 15, '+', '\b', 25, '\b', '\f', '\'', '\r', Typography.dollar, InputCardNumberView.DIVIDER, '+', '%', '%', '0', '/', '-', 14, 21, InputCardNumberView.DIVIDER, '0', 1, '\'', '+', 21, '+', Typography.dollar}, 48 - (Process.myTid() >> 22), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d((byte) (Color.red(0) + 107), new char[]{Typography.amp, 25, '\'', '\b', '/', '-', 21, 14, '\f', '\t', '-', 23, '\t', 4, 3, 5, 13843, 13843, ',', 4, '\t', 4, '+', 29, '#', '+', '+', 30, '\b', '\f', 13843, 13843, '\t', '\f', 0, 11, 13924, 13924, 15, 21, 21, 17, 30, 1, '\r', 29, 6, 30, 13844, 13844, 30, '0', '0', 30, 16, 0, 16, 0, 7, '+', 0, '\t', '\b', 25}, ExpandableListView.getPackedPositionType(0L) + 64, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d((byte) (97 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), new char[]{'%', 6, 28, '+', '0', 30, '\'', 6, 13827, 13827, '\t', 0, 1, 23, 20, 28, Typography.dollar, InputCardNumberView.DIVIDER, 11, 18, '#', '0', Typography.dollar, 25, InputCardNumberView.DIVIDER, '0', '*', '\t', 13917, 13917, 29, '\r', InputCardNumberView.DIVIDER, '\r', '#', '\r', '0', 28, '#', '\b', 11, '*', 3, 5, 14, 21, '#', '.', '/', '-', 15, Typography.dollar, '%', 6, '-', 25, 31, 27, '+', '%', '-', 25, 23, '-'}, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 63, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d((byte) (51 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), new char[]{19, ')', '/', 19, 24, '\r', 13800, 13800, 18, '.', '.', Typography.amp, '!', Typography.amp, 14, Typography.quote, InputCardNumberView.DIVIDER, Typography.dollar, Typography.dollar, '\f', ')', 25, Typography.amp, '!', 5, 17, '#', InputCardNumberView.DIVIDER, '\r', 25, 5, 20, '#', InputCardNumberView.DIVIDER, 30, InputCardNumberView.DIVIDER, '\f', '+', 31, '(', '(', 11, 24, '#', 24, '*', 1, 31, JSONLexer.EOI, ')', '(', 3, '#', '\'', '!', 1, 31, '+', ')', JSONLexer.EOI}, MotionEvent.axisFromString("") + 61, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    d((byte) (TextUtils.lastIndexOf("", '0', 0) + 59), new char[]{'-', 30, 3, InputCardNumberView.DIVIDER, '%', 6}, 5 - TextUtils.indexOf((CharSequence) "", '0'), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 912, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                e(KClassImpl$Data$declaredNonStaticMembers$2[3], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (moveToNextValue | 18);
                Object[] objArr14 = new Object[1];
                e(b, (byte) (b & 40), KClassImpl$Data$declaredNonStaticMembers$2[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 55, 3 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getScrollBarSize() >> 8));
                        Object[] objArr16 = new Object[1];
                        f($$d[78], $$d[53], $$d[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.blue(0), 15 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getTouchSlop() >> 8) + 15, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getLongPressTimeout() >> 16), View.resolveSize(0, 0) + 29, (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 15 - TextUtils.indexOf("", ""), (char) ((-1) - MotionEvent.axisFromString(""))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1517112299, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e(KClassImpl$Data$declaredNonStaticMembers$2[3], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (moveToNextValue | 18);
                Object[] objArr20 = new Object[1];
                e(b2, (byte) (b2 & 40), KClassImpl$Data$declaredNonStaticMembers$2[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 61, 47 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1));
                        Object[] objArr22 = new Object[1];
                        f((byte) ($$d[78] - 1), $$d[84], $$d[9], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, View.combineMeasuredStates(0, 0) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1517112299, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e(KClassImpl$Data$declaredNonStaticMembers$2[3], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b3 = (byte) (moveToNextValue | 18);
                Object[] objArr26 = new Object[1];
                e(b3, (byte) (b3 & 40), KClassImpl$Data$declaredNonStaticMembers$2[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 117, 3 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (38968 - TextUtils.getOffsetBefore("", 0)));
                        Object[] objArr28 = new Object[1];
                        f((byte) ($$d[78] - 1), $$d[84], $$d[9], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), 35 - (Process.myTid() >> 22), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1517112299, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, 18 - View.MeasureSpec.getMode(0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e(KClassImpl$Data$declaredNonStaticMembers$2[3], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b4 = (byte) (moveToNextValue | 18);
                Object[] objArr32 = new Object[1];
                e(b4, (byte) (b4 & 40), KClassImpl$Data$declaredNonStaticMembers$2[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 3, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))));
                        byte b5 = $$d[8];
                        byte b6 = (byte) ($$d[78] - 1);
                        Object[] objArr34 = new Object[1];
                        f(b5, b6, b6, objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.red(0), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1517112299, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (-16777198) - Color.rgb(0, 0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public /* synthetic */ void bind(Activity activity) {
        BaseButterKnife.CC.MyBillsEntityDataFactory(this, activity);
    }

    public /* synthetic */ void bind(Object obj, View view) {
        BaseButterKnife.CC.BuiltInFictitiousFunctionClassFactory(this, obj, view);
    }

    public void configToolbar() {
    }

    @Override // id.dana.base.FragmentListener
    public void doAction(String str, Object obj) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Deprecated
    public abstract int getLayout();

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    public abstract void init();

    public /* synthetic */ boolean isViewBinded() {
        return BaseButterKnife.CC.PlaceComponentResult(this);
    }

    public void onClickLeftMenuButton(View view) {
    }

    public void onClickRightMenuButton(View view) {
    }

    public void onClickTitle(View view) {
    }

    public /* synthetic */ void tryUnbind() {
        BaseButterKnife.CC.BuiltInFictitiousFunctionClassFactory(this);
    }

    static {
        MyBillsEntityDataFactory();
        AppCompatDelegate.BuiltInFictitiousFunctionClassFactory(true);
    }

    @Override // id.dana.base.BaseButterKnife
    public Unbinder getUnbinder() {
        return this.unbinder;
    }

    @Override // id.dana.base.BaseButterKnife
    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    /* JADX WARN: Removed duplicated region for block: B:314:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x03d2 A[Catch: all -> 0x0529, TryCatch #6 {all -> 0x0529, blocks: (B:312:0x03b9, B:316:0x041f, B:315:0x03d2), top: B:375:0x03b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x051c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x051d  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r22) {
        /*
            Method dump skipped, instructions count: 1688
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.base.BaseActivity.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.pageHeight = getWindowManager().getCurrentWindowMetrics().getBounds().height();
        } else {
            this.pageHeight = getWindowManager().getDefaultDisplay().getHeight();
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d((byte) (super.getResources().getString(R.string.km_away_with_dot).substring(0, 10).codePointAt(6) - 11), new char[]{Typography.amp, '.', 7, InputCardNumberView.DIVIDER, '*', JSONLexer.EOI, '\n', InputCardNumberView.DIVIDER, '(', 11, '\n', '!', '\n', '\t', '#', JSONLexer.EOI, 0, JSONLexer.EOI, '%', '!', 18, 14, 29, 30, '.', 18}, 26 - View.getDefaultSize(0, 0), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d((byte) (super.getResources().getString(R.string.split_bill_entry_title).substring(1, 2).codePointAt(0) - 83), new char[]{'\f', 15, 13814, 13814, 31, '+', '%', '\f', 13816, 13816, '#', 23, 11, Typography.dollar, '#', JSONLexer.EOI, '0', '.'}, super.getResources().getString(R.string.deals_express_confirmation_title).substring(1, 3).length() + 16, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, KeyEvent.getDeadChar(0, 0) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        NfcAdapter nfcAdapter = this.nfcHelper.MyBillsEntityDataFactory;
        if (nfcAdapter != null && nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
        super.onPause();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String action = intent.getAction();
        if (action != null) {
            this.nfcHelper.MyBillsEntityDataFactory(action, this.disposables, intent);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        PendingIntent pendingIntent;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d((byte) (super.getResources().getString(R.string.loyalty_header_title).substring(0, 7).length() + 14), new char[]{Typography.amp, '.', 7, InputCardNumberView.DIVIDER, '*', JSONLexer.EOI, '\n', InputCardNumberView.DIVIDER, '(', 11, '\n', '!', '\n', '\t', '#', JSONLexer.EOI, 0, JSONLexer.EOI, '%', '!', 18, 14, 29, 30, '.', 18}, (ViewConfiguration.getScrollBarSize() >> 8) + 26, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d((byte) (getPackageName().codePointAt(3) - 86), new char[]{'\f', 15, 13814, 13814, 31, '+', '%', '\f', 13816, 13816, '#', 23, 11, Typography.dollar, '#', JSONLexer.EOI, '0', '.'}, super.getResources().getString(R.string.save_reminder_btn).substring(2, 3).codePointAt(0) - 90, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, Color.argb(0, 0, 0, 0) + 35, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, TextUtils.indexOf("", "") + 18, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        enableClick();
        NfcHelper nfcHelper = this.nfcHelper;
        NfcAdapter nfcAdapter = nfcHelper.MyBillsEntityDataFactory;
        if (nfcAdapter == null || (pendingIntent = nfcHelper.BuiltInFictitiousFunctionClassFactory) == null || nfcAdapter == null) {
            return;
        }
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (this.injectConnectionStatusReceiver) {
            registerReceiver(this.connectionStatusReceiver.get(), intentFilter, "android.permission.ACCESS_NETWORK_STATE", null);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (this.injectConnectionStatusReceiver) {
            ContextUtils.MyBillsEntityDataFactory(this, this.connectionStatusReceiver.get());
        }
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tryUnbind();
        dispose();
        disposePresenter();
        PreventScreenshotUtil preventScreenshotUtil = PreventScreenshotUtil.INSTANCE;
        PreventScreenshotUtil.KClassImpl$Data$declaredNonStaticMembers$2(this, this.screenshotDisabledActivities);
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    protected void initContentView() {
        if (getLayout() > 0) {
            setContentView(getLayout());
        }
        this.icImageFg = (ImageView) findViewById(R.id.ic_image_fg);
        this.leftButton = (TextView) findViewById(R.id.left_button);
        this.toolbarLeftImage = (AppCompatImageView) findViewById(R.id.iv_left_button);
        this.rightButton = (TextView) findViewById(R.id.right_button);
        this.rightProgressBar = (RelativeLayout) findViewById(R.id.loader_wrapper);
        this.rlToolbar = (RelativeLayout) findViewById(R.id.rl_toolbar);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbarImage = (ImageView) findViewById(R.id.iv_title_image);
        this.toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        this.toolbarLayout = (ConstraintLayout) findViewById(R.id.f4218toolbar_layout);
        TextView textView = this.leftButton;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.base.BaseActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseActivity.this.onClickLeftMenuButton(view);
                }
            });
        }
        TextView textView2 = this.rightButton;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.base.BaseActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseActivity.this.onClickRightMenuButton(view);
                }
            });
        }
        TextView textView3 = this.toolbarTitle;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.base.BaseActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseActivity.this.onClickTitle(view);
                }
            });
        }
    }

    private void normalInitComponents(Bundle bundle) {
        getApplicationComponent().MyBillsEntityDataFactory(this);
        adjustFontScale(getResources().getConfiguration());
        EventBus.getDefault().register(this);
        initContentView();
        bind(this);
        m425lambda$lazyInitComponents$1$iddanabaseBaseActivity(bundle);
    }

    private void lazyInitComponents(final Bundle bundle) {
        adjustFontScale(getResources().getConfiguration());
        initContentView();
        bind(this);
        initAsync(new Action() { // from class: id.dana.base.BaseActivity$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseActivity.this.m424lambda$lazyInitComponents$0$iddanabaseBaseActivity();
            }
        }, new Action() { // from class: id.dana.base.BaseActivity$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseActivity.this.m425lambda$lazyInitComponents$1$iddanabaseBaseActivity(bundle);
            }
        });
    }

    /* renamed from: lambda$lazyInitComponents$0$id-dana-base-BaseActivity */
    public /* synthetic */ void m424lambda$lazyInitComponents$0$iddanabaseBaseActivity() throws Exception {
        getApplicationComponent().MyBillsEntityDataFactory(this);
        EventBus.getDefault().register(this);
        if (this.injectConnectionStatusReceiver) {
            this.connectionStatusReceiver.get();
        }
    }

    /* renamed from: initComponents */
    public void m425lambda$lazyInitComponents$1$iddanabaseBaseActivity(Bundle bundle) {
        initToolbar();
        init(bundle);
        this.nfcHelper.KClassImpl$Data$declaredNonStaticMembers$2(this, this.disposables);
    }

    public void backToHomepage(Bundle bundle) {
        EventBus.getDefault().post(new HomeTabActivity.FinishSubActivitiesMessageEvent());
        EventBus.getDefault().post(new HomeTabActivity.OnBackToHomepageMessageEvent(bundle));
        EventBus.getDefault().post(new BaseViewBindingActivity.FinishSubActivitiesMessageEvent());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onActivityShouldFinished(HomeTabActivity.FinishSubActivitiesMessageEvent finishSubActivitiesMessageEvent) {
        if (this instanceof HomeTabActivity) {
            return;
        }
        finish();
    }

    public ApplicationComponent getApplicationComponent() {
        return getDanaApplication().getApplicationComponent();
    }

    public DanaApplication getDanaApplication() {
        return (DanaApplication) getApplication();
    }

    private void initToolbar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().BuiltInFictitiousFunctionClassFactory("");
            setTitle("");
            configToolbar();
        }
    }

    public void init(Bundle bundle) {
        init();
    }

    protected void initAsync(Action action, Action action2) {
        Completable PlaceComponentResult2 = Completable.PlaceComponentResult(action);
        Scheduler PlaceComponentResult3 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult3, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(PlaceComponentResult2, PlaceComponentResult3));
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        addDisposable(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$22, MyBillsEntityDataFactory)).KClassImpl$Data$declaredNonStaticMembers$2(action2));
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected ConnectionStatusReceiver getConnectionStatusReceiver() {
        return this.connectionStatusReceiver.get();
    }

    protected void setTitle(String str, int i, int i2, int i3, int i4) {
        this.toolbarTitle.setText(str);
        this.toolbarTitle.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    protected void setTitle(String str, int i) {
        setTitle(str);
        this.toolbarTitle.setTextColor(i);
    }

    @Override // id.dana.base.MenuItemFacade
    public void setTitle(String str) {
        TextView textView = this.toolbarTitle;
        if (textView == null || this.toolbarImage == null) {
            return;
        }
        textView.setVisibility(0);
        this.toolbarImage.setVisibility(8);
        this.toolbarTitle.setText(str);
    }

    @Override // id.dana.base.MenuItemFacade
    public void setToolbarTitleContentDescription(String str) {
        TextView textView = this.toolbarTitle;
        if (textView != null) {
            textView.setContentDescription(str);
        }
    }

    protected void setCenterTitle(String str, int i) {
        setCenterTitle(str);
        TextView textView = this.toolbarTitle;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setCenterTitle(String str) {
        setTitle(str);
    }

    private Toolbar.LayoutParams getCenterParams() {
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams();
        layoutParams.BuiltInFictitiousFunctionClassFactory = 17;
        return layoutParams;
    }

    @Override // id.dana.base.MenuItemFacade
    public void setToolbarImage(int i) {
        this.toolbarTitle.setVisibility(8);
        this.toolbarImage.setVisibility(0);
        this.toolbarImage.setImageDrawable(getDrawableFromRes(i));
    }

    public Drawable getDrawableFromRes(int i) {
        return ContextCompat.PlaceComponentResult(this, i);
    }

    public void showToolbarLeftButton(int i) {
        AppCompatImageView appCompatImageView = this.toolbarLeftImage;
        if (appCompatImageView == null || this.leftButton == null) {
            return;
        }
        appCompatImageView.setVisibility(0);
        this.leftButton.setVisibility(8);
        this.toolbarLeftImage.setImageDrawable(getDrawableFromRes(i));
    }

    @Override // id.dana.base.MenuItemFacade
    public void setMenuLeftButton(String str) {
        if (this.leftButton != null) {
            setMarginLeft(10);
            this.leftButton.setText(str);
            if (str != null && !str.isEmpty()) {
                this.leftButton.setVisibility(0);
            } else {
                this.leftButton.setVisibility(4);
            }
        }
    }

    public void setMenuLeftButtonContentDescription(String str) {
        TextView textView = this.leftButton;
        if (textView != null) {
            textView.setContentDescription(str);
        }
    }

    @Override // id.dana.base.MenuItemFacade
    public void setMenuRightButtonContentDescription(String str) {
        TextView textView = this.rightButton;
        if (textView != null) {
            textView.setContentDescription(str);
        }
    }

    public void setMenuLeftButtonEnabled(boolean z) {
        TextView textView = this.leftButton;
        if (textView != null) {
            textView.setEnabled(z);
        }
    }

    @Override // id.dana.base.MenuItemFacade
    public void setMenuRightButton(String str) {
        if (this.rightButton != null) {
            setMarginRight(10);
            this.rightButton.setText(str);
            if (str != null && !str.isEmpty()) {
                this.rightButton.setVisibility(0);
            } else {
                this.rightButton.setVisibility(4);
            }
        }
    }

    @Override // id.dana.base.MenuItemFacade
    public void setMenuRightButtonEnabled(boolean z) {
        TextView textView = this.rightButton;
        if (textView != null) {
            textView.setEnabled(z);
        }
    }

    @Override // id.dana.base.MenuItemFacade
    public void setMenuRightProgressBar(boolean z) {
        setMenuRightButtonEnabled(!z);
        TextView textView = this.rightButton;
        if (textView != null) {
            textView.setVisibility(z ? 8 : 0);
        }
        RelativeLayout relativeLayout = this.rightProgressBar;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
            animateProgress();
        }
    }

    @Override // id.dana.base.MenuItemFacade
    public void setMenuLeftButton(int i) {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null || i == 0) {
            return;
        }
        toolbar.setNavigationIcon(i);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.base.BaseActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseActivity.this.m426lambda$setMenuLeftButton$2$iddanabaseBaseActivity(view);
            }
        });
        this.leftButton.setVisibility(4);
        getNavigationButton(this.toolbar);
    }

    /* renamed from: lambda$setMenuLeftButton$2$id-dana-base-BaseActivity */
    public /* synthetic */ void m426lambda$setMenuLeftButton$2$iddanabaseBaseActivity(View view) {
        onBackPressed();
    }

    private void getNavigationButton(Toolbar toolbar) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View childAt = toolbar.getChildAt(i);
            if (childAt instanceof ImageButton) {
                childAt.setContentDescription(getResources().getString(R.string.imgBtnLeft));
            }
        }
    }

    public void clearMenuLeftButtonIcon() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setNavigationIcon((Drawable) null);
        }
    }

    @Override // id.dana.base.MenuItemFacade
    public void setMenuLeftContentDescription(String str) {
        this.leftButton.setContentDescription(str);
    }

    private void animateProgress() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.icImageFg.startAnimation(loadAnimation);
    }

    private void setMarginRight(int i) {
        ViewGroup.MarginLayoutParams toolbarParam = getToolbarParam();
        toolbarParam.setMargins(toolbarParam.leftMargin, toolbarParam.topMargin, SizeUtil.getAuthRequestContext(i), toolbarParam.bottomMargin);
        this.rlToolbar.setLayoutParams(toolbarParam);
    }

    private void setMarginLeft(int i) {
        ViewGroup.MarginLayoutParams toolbarParam = getToolbarParam();
        toolbarParam.setMargins(SizeUtil.getAuthRequestContext(i), toolbarParam.topMargin, toolbarParam.rightMargin, toolbarParam.bottomMargin);
        this.rlToolbar.setLayoutParams(toolbarParam);
    }

    private ViewGroup.MarginLayoutParams getToolbarParam() {
        return (ViewGroup.MarginLayoutParams) this.rlToolbar.getLayoutParams();
    }

    public void setMenuRightContentDescription(String str) {
        this.rightButton.setContentDescription(str);
    }

    public void setMenuLeftButton(Drawable drawable, View.OnClickListener onClickListener) {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null || drawable == null) {
            return;
        }
        toolbar.setNavigationIcon(drawable);
        this.toolbar.setNavigationOnClickListener(onClickListener);
        this.leftButton.setVisibility(4);
    }

    public void setMenuLeftButtonOnClick(View.OnClickListener onClickListener) {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null || toolbar.getNavigationIcon() == null) {
            return;
        }
        this.toolbar.setNavigationOnClickListener(onClickListener);
    }

    @Override // id.dana.base.MenuItemFacade
    public void setMenuRightButton(int i) {
        this.icon = i;
        if (this.rightButton == null || i == 0) {
            return;
        }
        setMarginRight(10);
        this.rightButton.setBackground(getDrawableFromRes(i));
        this.rightButton.setVisibility(0);
    }

    public void setMenuRightButton(int i, int i2) {
        if (this.rightButton == null || i == 0) {
            return;
        }
        setMarginRight(i2);
        this.rightButton.setBackground(getDrawableFromRes(i));
        this.rightButton.setVisibility(0);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onHomeIndicatorClick();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onHomeIndicatorClick() {
        super.onBackPressed();
    }

    private int getStatusBarHeight() {
        int identifier;
        if (!OSUtil.getErrorConfigVersion() || (identifier = getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return getResources().getDimensionPixelSize(identifier);
    }

    public void showToast(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public void addDisposable(Disposable disposable) {
        if (this.disposables == null) {
            this.disposables = new CompositeDisposable();
        }
        Preconditions.getAuthRequestContext(disposable);
        Preconditions.getAuthRequestContext(this.disposables);
        this.disposables.getAuthRequestContext(disposable);
    }

    public void dispose() {
        CompositeDisposable compositeDisposable = this.disposables;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            return;
        }
        this.disposables.dispose();
        this.disposables = null;
    }

    public void registerPresenter(AbstractContract.AbstractPresenter... abstractPresenterArr) {
        if (this.presenterList == null) {
            this.presenterList = new ArrayList();
        }
        if (abstractPresenterArr == null || abstractPresenterArr.length <= 0) {
            return;
        }
        this.presenterList.addAll(Arrays.asList(abstractPresenterArr));
    }

    public void disposePresenter() {
        List<AbstractContract.AbstractPresenter> list = this.presenterList;
        if (list != null) {
            Iterator<AbstractContract.AbstractPresenter> it = list.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }

    public void showWarningDialog(String str) {
        showWarningDialog(str, null);
    }

    public void showWarningDialog(String str, DialogInterface.OnDismissListener onDismissListener) {
        showWarningDialog(str, onDismissListener, true, 0);
    }

    public void showWarningDialog(String str, DialogInterface.OnDismissListener onDismissListener, boolean z, int i) {
        String[] strArr = {"rpcexception", "networkexception", "connectexception", "unknownhostexception"};
        if (str != null && StringUtils.PlaceComponentResult(str.toLowerCase(Locale.ROOT), strArr)) {
            String string = getString(R.string.uh_oh_no_internet_connection);
            trackRpcErrorAsNonFatal(str);
            str = string;
        }
        WarningDialogUtil.MyBillsEntityDataFactory(this, str, onDismissListener, z, i);
    }

    private void trackRpcErrorAsNonFatal(String str) {
        try {
            String take = StringsKt.take(str, StringsKt.indexOf((CharSequence) str, ']', 0, false) + 1);
            if (take.contains("2000")) {
                trackRpcError2000(take, str);
                return;
            }
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter("case", "");
            Intrinsics.checkNotNullParameter("RpcError", "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("case", "RpcError");
            Intrinsics.checkNotNullParameter("errorCode", "");
            Intrinsics.checkNotNullParameter(take, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("errorCode", take);
            RpcException rpcException = new RpcException(str);
            Intrinsics.checkNotNullParameter(rpcException, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(rpcException);
        } catch (Exception unused) {
        }
    }

    private void trackRpcError2000(String str, String str2) {
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("case", "");
        Intrinsics.checkNotNullParameter("RpcError", "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("case", "RpcError");
        Intrinsics.checkNotNullParameter("errorCode", "");
        Intrinsics.checkNotNullParameter(str, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("errorCode", str);
        RpcException rpcException = new RpcException(str2);
        Intrinsics.checkNotNullParameter(rpcException, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(rpcException);
    }

    public void showWarningDialog(String str, DialogInterface.OnDismissListener onDismissListener, boolean z) {
        showWarningDialog(str, onDismissListener, z, 0);
    }

    public void showWarningDialog(String str, DialogInterface.OnDismissListener onDismissListener, int i) {
        showWarningDialog(str, onDismissListener, true, i);
    }

    public void showSuccessDialog(String str, DialogInterface.OnDismissListener onDismissListener) {
        CommonDialog.Builder builder = new CommonDialog.Builder(this);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        builder.DatabaseTableConfigUtil = DialogType.SUCCESS;
        builder.MyBillsEntityDataFactory = onDismissListener;
        new CommonDialog(builder.BuiltInFictitiousFunctionClassFactory, builder.MyBillsEntityDataFactory, builder.scheduleImpl, builder).MyBillsEntityDataFactory();
    }

    public void adjustFontScale(Configuration configuration) {
        configuration.fontScale = 1.0f;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
        getBaseContext().getResources().updateConfiguration(configuration, displayMetrics);
    }

    @Override // id.dana.base.MultipleClickHandler
    public void disableClick() {
        this.clickable = false;
    }

    @Override // id.dana.base.MultipleClickHandler
    public void enableClick() {
        this.clickable = true;
    }

    @Override // id.dana.base.MultipleClickHandler
    public boolean isClickable() {
        return this.clickable;
    }

    public Intent getIntentClassWithTracking(Class<?> cls) {
        return getIntentClassWithTracking(cls, getSource());
    }

    public Intent getIntentClassWithTracking(Class<?> cls, String str) {
        Intent intent = new Intent(this, cls);
        intent.putExtra("source", str);
        return intent;
    }

    public String getSource() {
        return getSource(getIntent().getExtras());
    }

    public String getSource(Bundle bundle) {
        return bundle != null ? bundle.getString("source") : "";
    }

    public Bundle getBundleWithSource() {
        Bundle bundle = new Bundle();
        bundle.putString("source", getSource());
        return bundle;
    }

    public boolean isActivityAvailable() {
        return (isFinishing() || isDestroyed()) ? false : true;
    }

    public void setRightButtonContentDescription(String str) {
        TextView textView = this.rightButton;
        if (textView != null) {
            textView.setContentDescription(str);
        }
    }

    public String getShownErrorMessage() {
        try {
            List<TextView> errorMessages = getErrorMessages((ViewGroup) findViewById(16908290));
            if (!errorMessages.isEmpty()) {
                return errorMessages.get(0).getText().toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private List<TextView> getErrorMessages(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        String string = getResources().getString(R.string.error_message_tag);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                arrayList.addAll(getErrorMessages((ViewGroup) childAt));
            }
            if (childAt.getTag() == string && (childAt instanceof TextView) && childAt.getVisibility() == 0) {
                arrayList.add((TextView) childAt);
            }
        }
        return arrayList;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onPreventScreenshotEvent(PreventScreenshotEvent preventScreenshotEvent) {
        this.screenshotDisabledActivities = preventScreenshotEvent.KClassImpl$Data$declaredNonStaticMembers$2;
        PreventScreenshotUtil preventScreenshotUtil = PreventScreenshotUtil.INSTANCE;
        PreventScreenshotUtil.getAuthRequestContext(this, this.screenshotDisabledActivities);
    }

    private static void d(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = PlaceComponentResult;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ getAuthRequestContext);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i4 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i5 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i4];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i5];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i6 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i7 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i6];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i7];
                    } else {
                        int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i10 = 0; i10 < i; i10++) {
            cArr4[i10] = (char) (cArr4[i10] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
