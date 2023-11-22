package id.dana.core.ui;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.util.preventscreenshot.PreventScreenshotEvent;
import id.dana.core.ui.util.preventscreenshot.PreventScreenshotUtil;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001,B\u0007¢\u0006\u0004\b+\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\nJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\r\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\nJ\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\nJ\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0017¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u00028\u00008EX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0005@\u0005X\u0085.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*"}, d2 = {"Lid/dana/core/ui/BaseViewBindingActivity;", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/content/res/Configuration;", "configuration", "", "adjustFontScale", "(Landroid/content/res/Configuration;)V", "configToolbar", "()V", "inflateViewBinding", "()Landroidx/viewbinding/ViewBinding;", IAPSyncCommand.COMMAND_INIT, "Landroid/os/Bundle;", "savedInstanceState", "(Landroid/os/Bundle;)V", "initComponent", "Lid/dana/core/ui/BaseViewBindingActivity$FinishSubActivitiesMessageEvent;", "event", "onActivityShouldFinished", "(Lid/dana/core/ui/BaseViewBindingActivity$FinishSubActivitiesMessageEvent;)V", "onCreate", "onDestroy", "Lid/dana/core/ui/util/preventscreenshot/PreventScreenshotEvent;", "eventData", "onPreventScreenshotEvent", "(Lid/dana/core/ui/util/preventscreenshot/PreventScreenshotEvent;)V", "binding$delegate", "Lkotlin/Lazy;", "getBinding", "binding", "", "", "screenshotDisabledActivities", "Ljava/util/List;", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "<init>", "FinishSubActivitiesMessageEvent"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseViewBindingActivity<VB extends ViewBinding> extends AppCompatActivity {

    /* renamed from: binding$delegate  reason: from kotlin metadata */
    private final Lazy binding;
    protected Toolbar toolbar;
    public static final byte[] $$d = {114, -79, -70, 22, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 125;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {11, -83, -14, 91, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int moveToNextValue = 149;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 269894836;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private List<String> screenshotDisabledActivities = new ArrayList();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/core/ui/BaseViewBindingActivity$FinishSubActivitiesMessageEvent;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class FinishSubActivitiesMessageEvent {
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002a -> B:35:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = 23 - r7
            byte[] r0 = id.dana.core.ui.BaseViewBindingActivity.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r6 = r6 + 4
            int r8 = r8 + 97
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r7
            goto L34
        L14:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L19:
            byte r4 = (byte) r6
            int r7 = r7 + 1
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
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
            int r6 = r6 + r7
            int r6 = r6 + (-4)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.BaseViewBindingActivity.e(int, short, int, java.lang.Object[]):void");
    }

    private static void f(byte b, int i, short s, Object[] objArr) {
        int i2 = 42 - (i * 3);
        byte[] bArr = $$d;
        int i3 = s + 4;
        int i4 = 103 - (b * 2);
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            int i7 = (i6 + i3) - 7;
            i3 = i3;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i6 = i6;
            i4 = i7;
        }
        while (true) {
            int i8 = i5 + 1;
            bArr2[i8] = (byte) i4;
            int i9 = i3 + 1;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i10 = i6;
            Object[] objArr2 = objArr;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            int i11 = (i4 + bArr[i9]) - 7;
            i3 = i9;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i5 = i8;
            i6 = i10;
            i4 = i11;
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:623:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:700:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:701:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:746:0x070e  */
    /* JADX WARN: Removed duplicated region for block: B:747:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:792:0x08d8  */
    /* JADX WARN: Removed duplicated region for block: B:793:0x08dd  */
    /* JADX WARN: Removed duplicated region for block: B:837:0x0a9e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:842:0x054d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:854:0x0717 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:866:0x08e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:874:0x0270 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r29) {
        /*
            Method dump skipped, instructions count: 3014
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.BaseViewBindingActivity.attachBaseContext(android.content.Context):void");
    }

    protected void configToolbar() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    public abstract VB inflateViewBinding();

    public abstract void init();

    protected void initComponent() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int length = super.getResources().getString(id.dana.R.string.voucher_dana_deals_header).substring(10, 21).length() + 15;
            int codePointAt = getPackageName().codePointAt(5) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS;
            try {
                byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[9];
                byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                Object[] objArr = new Object[1];
                e(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                e(NetworkUserEntityData$$ExternalSyntheticLambda0[59], NetworkUserEntityData$$ExternalSyntheticLambda0[27], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), objArr2);
                Object[] objArr3 = new Object[1];
                d(length, codePointAt, ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 211, new char[]{'\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6}, true, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                try {
                    byte b3 = NetworkUserEntityData$$ExternalSyntheticLambda0[9];
                    byte b4 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                    Object[] objArr4 = new Object[1];
                    e(b3, b4, b4, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    e(NetworkUserEntityData$$ExternalSyntheticLambda0[59], NetworkUserEntityData$$ExternalSyntheticLambda0[27], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), new Object[1]);
                    Object[] objArr5 = new Object[1];
                    d(((ApplicationInfo) cls3.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 15, getPackageName().length() - 6, super.getResources().getString(id.dana.R.string.home_shopping_tutorial_order_step_3).substring(0, 1).length() + 250, new char[]{65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11}, true, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (KeyEvent.getMaxKeyCode() >> 16), Color.blue(0) + 35, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), MotionEvent.axisFromString("") + 19, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr6);
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
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Class<?> cls;
        Object[] objArr;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr2 = new Object[1];
            d(25 - MotionEvent.axisFromString(""), getPackageName().codePointAt(0) - 100, super.getResources().getString(id.dana.R.string.total_savings_limit).substring(1, 2).codePointAt(0) + 147, new char[]{'\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6}, true, objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            int i = 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            int codePointAt = super.getResources().getString(id.dana.R.string.pocket_voucher_expired_in_months).substring(4, 5).codePointAt(0) - 31;
            try {
                byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[9];
                byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                Object[] objArr3 = new Object[1];
                e(b, b2, b2, objArr3);
                cls = Class.forName((String) objArr3[0]);
                objArr = new Object[1];
                e(NetworkUserEntityData$$ExternalSyntheticLambda0[59], NetworkUserEntityData$$ExternalSyntheticLambda0[27], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), objArr);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr4 = new Object[1];
                d(i, codePointAt, ((ApplicationInfo) cls.getMethod((String) objArr[0], null).invoke(this, null)).targetSdkVersion + 218, new char[]{65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11}, true, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            } catch (Throwable th2) {
                th = th2;
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) TextUtils.indexOf("", ""))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
                } catch (Throwable th3) {
                    Throwable cause2 = th3.getCause();
                    if (cause2 == null) {
                        throw th3;
                    }
                    throw cause2;
                }
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        }
        super.onResume();
    }

    public BaseViewBindingActivity() {
        AppCompatDelegate.BuiltInFictitiousFunctionClassFactory(true);
        this.binding = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<VB>(this) { // from class: id.dana.core.ui.BaseViewBindingActivity$binding$2
            final /* synthetic */ BaseViewBindingActivity<VB> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TVB; */
            /* JADX WARN: Type inference failed for: r0v1, types: [androidx.viewbinding.ViewBinding] */
            @Override // kotlin.jvm.functions.Function0
            public final ViewBinding invoke() {
                return this.this$0.inflateViewBinding();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        d(super.getResources().getString(id.dana.R.string.activate_nfc_title).substring(11, 12).length() + 17, -((byte) KeyEvent.getModifierMetaStateMask()), getPackageName().codePointAt(0) + 139, new char[]{65534, 16, 16, 2, 0, '\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11}, true, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        d(5 - TextUtils.indexOf("", "", 0, 0), Color.blue(0) + 2, super.getResources().getString(id.dana.R.string.linking_oneklik_confirmation_description).substring(0, 121).length() + 128, new char[]{17, 5, 65532, 1, 65517}, true, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                d(super.getResources().getString(id.dana.R.string.join_invitation_success_title_content).substring(1, 3).length() + 24, super.getResources().getString(id.dana.R.string.kyc_failed_title).substring(0, 13).codePointAt(1) - 60, View.combineMeasuredStates(0, 0) + 244, new char[]{'\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6}, true, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                int i = 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                int codePointAt = super.getResources().getString(id.dana.R.string.profile_empty_title_blocked).substring(11, 12).codePointAt(0) - 106;
                try {
                    byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[9];
                    byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                    Object[] objArr5 = new Object[1];
                    e(b, b2, b2, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    e(NetworkUserEntityData$$ExternalSyntheticLambda0[59], NetworkUserEntityData$$ExternalSyntheticLambda0[27], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), objArr6);
                    Object[] objArr7 = new Object[1];
                    d(i, codePointAt, ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 218, new char[]{65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11}, true, objArr7);
                    baseContext = (Context) cls2.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 35 - TextUtils.getOffsetAfter("", 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr8 = new Object[1];
                    d(View.MeasureSpec.getSize(0) + 48, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 12, super.getResources().getString(id.dana.R.string.zdoc_noface_msg).substring(0, 1).length() + 215, new char[]{65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515}, false, objArr8);
                    String str = (String) objArr8[0];
                    try {
                        byte b3 = NetworkUserEntityData$$ExternalSyntheticLambda0[9];
                        byte b4 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                        Object[] objArr9 = new Object[1];
                        e(b3, b4, b4, objArr9);
                        Class<?> cls4 = Class.forName((String) objArr9[0]);
                        Object[] objArr10 = new Object[1];
                        e(NetworkUserEntityData$$ExternalSyntheticLambda0[59], NetworkUserEntityData$$ExternalSyntheticLambda0[27], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), objArr10);
                        Object[] objArr11 = new Object[1];
                        d(((ApplicationInfo) cls4.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 31, TextUtils.getOffsetBefore("", 0) + 5, super.getResources().getString(id.dana.R.string.reset_pin_input_new_pin_error_not_match_pin).substring(1, 2).codePointAt(0) + 114, new char[]{InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!'}, false, objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        d(super.getResources().getString(id.dana.R.string.pushverify_list_error_try_again).substring(6, 7).codePointAt(0) - 1, ((Process.getThreadPriority(0) + 20) >> 6) + 45, getPackageName().length() + 206, new char[]{InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520}, false, objArr12);
                        String str3 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        d(getPackageName().codePointAt(1) - 40, super.getResources().getString(id.dana.R.string.share_dana).substring(8, 13).codePointAt(1) - 20, getPackageName().length() + 235, new char[]{65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0}, false, objArr13);
                        String str4 = (String) objArr13[0];
                        Object[] objArr14 = new Object[1];
                        d(super.getResources().getString(id.dana.R.string.trusted_device_description).substring(56, 58).length() + 4, super.getResources().getString(id.dana.R.string.desc_call_cs_emoney).substring(0, 1).codePointAt(0) - 71, super.getResources().getString(id.dana.R.string.clear_all).substring(5, 6).length() + 194, new char[]{65535, 7, 65532, 2, 65532, 0}, false, objArr14);
                        try {
                            Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.lastIndexOf("", '0') + 19, (char) View.getDefaultSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr15);
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
            Object[] objArr16 = new Object[1];
            e(36, (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr16);
            Class<?> cls5 = Class.forName((String) objArr16[0]);
            byte b5 = (byte) (moveToNextValue & 127);
            byte b6 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]);
            Object[] objArr17 = new Object[1];
            e(b5, b6, (byte) (b6 + 1), objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.getDefaultSize(0, 0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 5, (char) TextUtils.getCapsMode("", 0, 0));
                    Object[] objArr19 = new Object[1];
                    f($$d[9], (byte) ($$d[78] - 1), (byte) (-$$d[40]), objArr19);
                    obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                int i2 = ((int[]) objArr20[1])[0];
                if (((int[]) objArr20[0])[0] != i2) {
                    long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {-380024663, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.getDefaultSize(0, 0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr21);
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
                super.onCreate(savedInstanceState);
                Configuration configuration = getResources().getConfiguration();
                Intrinsics.checkNotNullExpressionValue(configuration, "");
                adjustFontScale(configuration);
                setContentView(getBinding().KClassImpl$Data$declaredNonStaticMembers$2());
                init(savedInstanceState);
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

    private final void adjustFontScale(Configuration configuration) {
        configuration.fontScale = 1.0f;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Object systemService = getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
        getBaseContext().getResources().updateConfiguration(configuration, displayMetrics);
    }

    @JvmName(name = "getBinding")
    public final VB getBinding() {
        return (VB) this.binding.getValue();
    }

    public void init(Bundle bundle) {
        initComponent();
        init();
        configToolbar();
        EventBus.getDefault().register(this);
    }

    @JvmName(name = "getToolbar")
    public final Toolbar getToolbar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            return toolbar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setToolbar")
    public final void setToolbar(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "");
        this.toolbar = toolbar;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PreventScreenshotUtil preventScreenshotUtil = PreventScreenshotUtil.INSTANCE;
        PreventScreenshotUtil.KClassImpl$Data$declaredNonStaticMembers$2(this, this.screenshotDisabledActivities);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onActivityShouldFinished(FinishSubActivitiesMessageEvent event) {
        finish();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onPreventScreenshotEvent(PreventScreenshotEvent eventData) {
        Intrinsics.checkNotNullParameter(eventData, "");
        this.screenshotDisabledActivities = eventData.KClassImpl$Data$declaredNonStaticMembers$2;
        PreventScreenshotUtil preventScreenshotUtil = PreventScreenshotUtil.INSTANCE;
        PreventScreenshotUtil.getAuthRequestContext(this, this.screenshotDisabledActivities);
    }

    private static void d(int i, int i2, int i3, char[] cArr, boolean z, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i3);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i];
            System.arraycopy(cArr2, 0, cArr3, 0, i);
            System.arraycopy(cArr3, 0, cArr2, i - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
