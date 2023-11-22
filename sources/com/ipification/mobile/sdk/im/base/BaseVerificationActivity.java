package com.ipification.mobile.sdk.im.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.ipification.mobile.sdk.im.IMLocale;
import com.ipification.mobile.sdk.im.IMService;
import com.ipification.mobile.sdk.im.IMTheme;
import com.ipification.mobile.sdk.im.ui.dialog.LoadingScreen;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010\u0013J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0019\u0010\u0013J)\u0010\u001a\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u0013R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0013\u0010$\u001a\u00020!X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lcom/ipification/mobile/sdk/im/base/BaseVerificationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "", "containerId", "Landroidx/fragment/app/Fragment;", "fragment", "", "addToBackStack", "", "addFragmentTo", "(ILandroidx/fragment/app/Fragment;Z)V", "Landroid/widget/TextView;", "toolbar", "customizeToolbar", "(Landroid/widget/TextView;)V", "Landroid/view/View;", "getBindingRoot", "()Landroid/view/View;", "hideLoading", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onCreateActivity", "onDestroy", "replaceFragmentWith", "(Landroidx/fragment/app/Fragment;ZI)V", "showLoading", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lcom/ipification/mobile/sdk/im/ui/dialog/LoadingScreen;", "lookAheadTest", "Lkotlin/Lazy;", "getAuthRequestContext", "<init>"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseVerificationActivity extends AppCompatActivity {
    public static final byte[] $$a = {10, -99, -17, -84, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 131;
    public static final byte[] PlaceComponentResult = {56, 110, 47, 101, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 31;
    private static char scheduleImpl = 42066;
    private static char[] moveToNextValue = {37373, 37282, 37280, 37308, 37307, 37372, 37289, 37309, 37365, 37291, 37262, 37287, 37369, 37367, 37302, 37310, 37306, 37344, 37281, 37350, 37286, 37283, 37371, 37370, 37356, 37374, 37275, 37368, 37366, 37357, 37311, 37345, 37292, 37347, 37279, 37351, 37274, 37349, 37346, 37348, 37359, 37358, 37305, 37294, 37288, 37290, 37293, 37353, 37375};

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<LoadingScreen>() { // from class: com.ipification.mobile.sdk.im.base.BaseVerificationActivity$loadingScreen$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LoadingScreen invoke() {
            return new LoadingScreen(BaseVerificationActivity.this);
        }
    });

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory = "BaseVerificationAct";

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            int r7 = r7 + 4
            int r6 = r6 + 16
            byte[] r0 = com.ipification.mobile.sdk.im.base.BaseVerificationActivity.PlaceComponentResult
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
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L28:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + (-4)
            int r8 = r8 + 1
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.im.base.BaseVerificationActivity.b(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r5, int r6, byte r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 2
            int r5 = 103 - r5
            byte[] r0 = com.ipification.mobile.sdk.im.base.BaseVerificationActivity.$$a
            int r6 = r6 * 3
            int r6 = r6 + 21
            int r7 = 47 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r7
            r4 = 0
            goto L28
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r5
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L26
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L26:
            r3 = r0[r7]
        L28:
            int r7 = r7 + 1
            int r5 = r5 + r3
            int r5 = r5 + (-7)
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.im.base.BaseVerificationActivity.c(byte, int, byte, java.lang.Object[]):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((byte) (ExpandableListView.getPackedPositionChild(0L) + 6), new char[]{'.', 15, '\n', '\b', 6, 16, '\n', 30, 3, 4, InputCardNumberView.DIVIDER, 28, '\t', 0, 31, '.', 13806, 13806}, 18 - Color.blue(0), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((byte) (ExpandableListView.getPackedPositionChild(0L) + 71), new char[]{0, 15, ')', 15, 13892}, 6 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((byte) (77 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), new char[]{25, Typography.quote, '\r', 7, ',', '\r', Typography.quote, 7, 24, '0', Typography.quote, 4, '*', 3, JSONLexer.EOI, 11, 13815, 13815, '\b', '/', 11, 30, '!', 11, '\f', 2, 7, '\n', 2, 7, ',', '.', '!', 7, 7, '#', 0, Typography.quote, 20, 6, Typography.quote, '\r', JSONLexer.EOI, '\b', '/', 4, '\n', '/'}, (ViewConfiguration.getPressedStateDuration() >> 16) + 48, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((byte) (ExpandableListView.getPackedPositionGroup(0L) + 111), new char[]{',', 22, '\r', '\n', 0, Typography.quote, 6, 20, 11, 30, 30, 21, 11, 23, JSONLexer.EOI, 23, 13847, 13847, 4, 27, 11, 23, 19, '\f', 11, '/', 31, '*', 7, '\n', 13847, 13847, 30, 11, 27, '\b', 13928, 13928, '/', 6, 27, ',', '.', 24, Typography.quote, 25, JSONLexer.EOI, 21, 13848, 13848, 21, Typography.quote, Typography.quote, 21, '.', 27, '.', 27, '\'', 4, 27, 11, '\f', 2}, 63 - TextUtils.indexOf((CharSequence) "", '0', 0), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((byte) (75 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), new char[]{4, 21, '.', '/', Typography.quote, 21, 1, 21, 13804, 13804, 11, 27, JSONLexer.EOI, 4, 6, Typography.quote, ',', '.', 23, '\b', 4, '*', '/', 1, Typography.quote, '\r', Typography.quote, 7, 13894, 13894, 25, Typography.quote, 23, '\r', 6, 7, '0', 25, '\r', 7, 20, '\r', JSONLexer.EOI, 23, 20, 6, ',', '/', 0, Typography.quote, 31, '.', 4, 21, 2, 27, 21, 24, '!', 7, 2, 27, 21, 30}, AndroidCharacter.getMirror('0') + 16, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((byte) (Process.getGidForName("") + 88), new char[]{18, 11, 2, InputCardNumberView.DIVIDER, 1, '\n', 13836, 13836, '\b', ',', 15, '.', InputCardNumberView.DIVIDER, 3, '\f', '\b', '.', ',', 11, '\'', '-', 1, 3, InputCardNumberView.DIVIDER, 2, 23, '*', '\b', '\n', 2, 16, 17, '*', '\b', 3, Typography.amp, 30, 4, 3, 15, ',', 29, 14, 18, 14, 19, '-', '.', 4, 5, 14, '-', 3, 14, '.', '+', '.', 17, 5, 4}, (ViewConfiguration.getTapTimeout() >> 16) + 60, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((byte) (37 - TextUtils.lastIndexOf("", '0', 0, 0)), new char[]{29, InputCardNumberView.DIVIDER, 24, 29, 4, 21}, TextUtils.lastIndexOf("", '0') + 7, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) TextUtils.getTrimmedLength(""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[25];
                Object[] objArr13 = new Object[1];
                b(b, (byte) (b | 37), PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (-16777213) - Color.rgb(0, 0, 0), (char) (Process.myTid() >> 22));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], $$a[78], $$a[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getWindowTouchSlop() >> 8), TextUtils.indexOf("", "", 0) + 15, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), View.combineMeasuredStates(0, 0) + 15, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 29 - ExpandableListView.getPackedPositionGroup(0L), (char) (57994 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) Color.green(0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r3 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1311413446, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = PlaceComponentResult[25];
                Object[] objArr19 = new Object[1];
                b(b2, (byte) (b2 | 37), PlaceComponentResult[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.getOffsetAfter("", 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 47, (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                        byte b3 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b3, b3, $$a[84], objArr22);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1311413446, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), KeyEvent.getDeadChar(0, 0) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = PlaceComponentResult[25];
                Object[] objArr25 = new Object[1];
                b(b4, (byte) (b4 | 37), PlaceComponentResult[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 118, 3 - Color.red(0), (char) (38968 - Color.green(0)));
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b5, b5, $$a[84], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1311413446, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 18 - TextUtils.getTrimmedLength(""), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = PlaceComponentResult[25];
                Object[] objArr31 = new Object[1];
                b(b6, (byte) (b6 | 37), PlaceComponentResult[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - TextUtils.indexOf((CharSequence) "", '0', 0), Gravity.getAbsoluteGravity(0, 0) + 3, (char) ((-1) - TextUtils.lastIndexOf("", '0')));
                        Object[] objArr34 = new Object[1];
                        c($$a[9], $$a[8], (byte) ($$a[78] - 1), objArr34);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, KeyEvent.getDeadChar(0, 0) + 35, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1311413446, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 18 - View.getDefaultSize(0, 0), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    public abstract View getBindingRoot();

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    public final void hideLoading() {
        try {
            runOnUiThread(new Runnable() { // from class: com.ipification.mobile.sdk.im.base.BaseVerificationActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BaseVerificationActivity.$r8$lambda$jXoqW0LmC7nyVe6K5f0XiFIJY98(BaseVerificationActivity.this);
                }
            });
        } catch (Exception unused) {
        }
    }

    public abstract void onCreateActivity(Bundle savedInstanceState);

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        hideLoading();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            byte length = (byte) (getPackageName().length() + 62);
            char[] cArr = {'.', 15, '\n', '\b', 6, 16, '\n', 30, ',', 29, 31, InputCardNumberView.DIVIDER, 11, 31, 6, 18, '0', 14, 0, 18, 25, '\f', '\n', '*', ',', '\b'};
            try {
                Object[] objArr = new Object[1];
                b(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[48], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(length, cArr, ((ApplicationInfo) cls.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 7, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a((byte) (super.getResources().getString(R.string.feed_detail_title).substring(2, 7).codePointAt(3) - 76), new char[]{30, 18, 13829, 13829, '.', 17, 3, 11, 13831, 13831, 27, 14, 29, '.', 6, 18, 4, 16}, 18 - KeyEvent.getDeadChar(0, 0), objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), ((byte) KeyEvent.getModifierMetaStateMask()) + 19, (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) (69 - (Process.myTid() >> 22)), new char[]{'.', 15, '\n', '\b', 6, 16, '\n', 30, ',', 29, 31, InputCardNumberView.DIVIDER, 11, 31, 6, 18, '0', 14, 0, 18, 25, '\f', '\n', '*', ',', '\b'}, getPackageName().length() + 19, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[48], new Object[1]);
                Object[] objArr3 = new Object[1];
                a((byte) (((ApplicationInfo) cls2.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 4), new char[]{30, 18, 13829, 13829, '.', 17, 3, 11, 13831, 13831, 27, 14, 29, '.', 6, 18, 4, 16}, TextUtils.getTrimmedLength("") + 18, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public final void showLoading() {
        try {
            runOnUiThread(new Runnable() { // from class: com.ipification.mobile.sdk.im.base.BaseVerificationActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    BaseVerificationActivity.m230$r8$lambda$8zMfgi3TL17DTrIPkKX6O9Gz4A(BaseVerificationActivity.this);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* renamed from: $r8$lambda$8zMfgi-3TL17DTrIPkKX6O9Gz4A  reason: not valid java name */
    public static /* synthetic */ void m230$r8$lambda$8zMfgi3TL17DTrIPkKX6O9Gz4A(BaseVerificationActivity baseVerificationActivity) {
        Intrinsics.checkParameterIsNotNull(baseVerificationActivity, "");
        LoadingScreen loadingScreen = (LoadingScreen) baseVerificationActivity.getAuthRequestContext.getValue();
        if (loadingScreen.isShowing()) {
            return;
        }
        loadingScreen.show();
    }

    public static /* synthetic */ void $r8$lambda$jXoqW0LmC7nyVe6K5f0XiFIJY98(BaseVerificationActivity baseVerificationActivity) {
        Intrinsics.checkParameterIsNotNull(baseVerificationActivity, "");
        LoadingScreen loadingScreen = (LoadingScreen) baseVerificationActivity.getAuthRequestContext.getValue();
        if (loadingScreen.isShowing()) {
            loadingScreen.dismiss();
        }
    }

    public final void addFragmentTo(int containerId, Fragment fragment, boolean addToBackStack) {
        if (fragment == null) {
            return;
        }
        try {
            String simpleName = fragment.getClass().getSimpleName();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "");
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(containerId, fragment, null, 1);
            Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "");
            if (addToBackStack) {
                if (!beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                }
                beginTransaction.scheduleImpl = true;
                beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda8 = simpleName;
            }
            beginTransaction.getAuthRequestContext();
        } catch (Exception unused) {
        }
    }

    public final void customizeToolbar(TextView toolbar) {
        IMTheme iMTheme;
        Intrinsics.checkParameterIsNotNull(toolbar, "");
        IMService.Companion companion = IMService.INSTANCE;
        IMLocale BuiltInFictitiousFunctionClassFactory = IMService.Companion.BuiltInFictitiousFunctionClassFactory();
        iMTheme = IMService.KClassImpl$Data$declaredNonStaticMembers$2;
        String str = BuiltInFictitiousFunctionClassFactory.lookAheadTest;
        if (str != null) {
            toolbar.setText(str);
        }
        toolbar.setVisibility(BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp);
        Integer num = iMTheme == null ? null : iMTheme.PlaceComponentResult;
        if (num != null) {
            toolbar.setTextColor(num.intValue());
        }
        Integer num2 = iMTheme != null ? iMTheme.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (num2 != null) {
            toolbar.setBackgroundColor(num2.intValue());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        IMTheme iMTheme;
        Object[] objArr2 = new Object[1];
        a((byte) (super.getResources().getString(R.string.estimation_fee_value).substring(0, 6).length() - 1), new char[]{'.', 15, '\n', '\b', 6, 16, '\n', 30, 3, 4, InputCardNumberView.DIVIDER, 28, '\t', 0, 31, '.', 13806, 13806}, super.getResources().getString(R.string.transfer_account_status_subtitle_failed).substring(0, 1).length() + 17, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a((byte) (70 - Color.argb(0, 0, 0, 0)), new char[]{0, 15, ')', 15, 13892}, super.getResources().getString(R.string.mini_minute).substring(0, 1).codePointAt(0) - 104, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a((byte) (super.getResources().getString(R.string.promo_try_again_button).substring(6, 7).length() + 68), new char[]{'.', 15, '\n', '\b', 6, 16, '\n', 30, ',', 29, 31, InputCardNumberView.DIVIDER, 11, 31, 6, 18, '0', 14, 0, 18, 25, '\f', '\n', '*', ',', '\b'}, super.getResources().getString(R.string.akamai_verify_dialog_desc).substring(3, 4).codePointAt(0) - 71, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a((byte) (super.getResources().getString(R.string.voucher_failed_button).substring(0, 7).codePointAt(3) - 53), new char[]{30, 18, 13829, 13829, '.', 17, 3, 11, 13831, 13831, 27, 14, 29, '.', 6, 18, 4, 16}, (ViewConfiguration.getLongPressTimeout() >> 16) + 18, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    byte b = (byte) (75 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    char[] cArr = {25, Typography.quote, '\r', 7, ',', '\r', Typography.quote, 7, 24, '0', Typography.quote, 4, '*', 3, JSONLexer.EOI, 11, 13815, 13815, '\b', '/', 11, 30, '!', 11, '\f', 2, 7, '\n', 2, 7, ',', '.', '!', 7, 7, '#', 0, Typography.quote, 20, 6, Typography.quote, '\r', JSONLexer.EOI, '\b', '/', 4, '\n', '/'};
                    try {
                        Object[] objArr6 = new Object[1];
                        b(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        b(PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[48], objArr7);
                        Object[] objArr8 = new Object[1];
                        a(b, cArr, ((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 15, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a((byte) (getPackageName().length() + 104), new char[]{',', 22, '\r', '\n', 0, Typography.quote, 6, 20, 11, 30, 30, 21, 11, 23, JSONLexer.EOI, 23, 13847, 13847, 4, 27, 11, 23, 19, '\f', 11, '/', 31, '*', 7, '\n', 13847, 13847, 30, 11, 27, '\b', 13928, 13928, '/', 6, 27, ',', '.', 24, Typography.quote, 25, JSONLexer.EOI, 21, 13848, 13848, 21, Typography.quote, Typography.quote, 21, '.', 27, '.', 27, '\'', 4, 27, 11, '\f', 2}, 64 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a((byte) (getPackageName().codePointAt(2) + 28), new char[]{4, 21, '.', '/', Typography.quote, 21, 1, 21, 13804, 13804, 11, 27, JSONLexer.EOI, 4, 6, Typography.quote, ',', '.', 23, '\b', 4, '*', '/', 1, Typography.quote, '\r', Typography.quote, 7, 13894, 13894, 25, Typography.quote, 23, '\r', 6, 7, '0', 25, '\r', 7, 20, '\r', JSONLexer.EOI, 23, 20, 6, ',', '/', 0, Typography.quote, 31, '.', 4, 21, 2, 27, 21, 24, '!', 7, 2, 27, 21, 30}, getPackageName().codePointAt(1) - 36, objArr10);
                        String str3 = (String) objArr10[0];
                        try {
                            Object[] objArr11 = new Object[1];
                            b(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            b(PlaceComponentResult[8], (byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[48], objArr12);
                            Object[] objArr13 = new Object[1];
                            a((byte) (((ApplicationInfo) cls4.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 54), new char[]{18, 11, 2, InputCardNumberView.DIVIDER, 1, '\n', 13836, 13836, '\b', ',', 15, '.', InputCardNumberView.DIVIDER, 3, '\f', '\b', '.', ',', 11, '\'', '-', 1, 3, InputCardNumberView.DIVIDER, 2, 23, '*', '\b', '\n', 2, 16, 17, '*', '\b', 3, Typography.amp, 30, 4, 3, 15, ',', 29, 14, 18, 14, 19, '-', '.', 4, 5, 14, '-', 3, 14, '.', '+', '.', 17, 5, 4}, super.getResources().getString(R.string.family_account_text_available_service_section).substring(5, 6).codePointAt(0) - 37, objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            a((byte) (AndroidCharacter.getMirror('0') - '\n'), new char[]{29, InputCardNumberView.DIVIDER, 24, 29, 4, 21}, 6 - View.MeasureSpec.getSize(0), objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr15);
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
            byte b2 = PlaceComponentResult[25];
            Object[] objArr16 = new Object[1];
            b(b2, (byte) (b2 | 37), PlaceComponentResult[25], objArr16);
            Class<?> cls5 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            b(PlaceComponentResult[25], (byte) (-PlaceComponentResult[35]), PlaceComponentResult[9], objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - ((Process.getThreadPriority(0) + 20) >> 6), 4 - TextUtils.indexOf("", "", 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                    Object[] objArr19 = new Object[1];
                    c($$a[9], $$a[8], (byte) ($$a[78] - 1), objArr19);
                    obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                int i = ((int[]) objArr20[1])[0];
                if (((int[]) objArr20[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 34 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {-560212545, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), Color.rgb(0, 0, 0) + 16777234, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                } else {
                    objArr = null;
                }
                super.onCreate(savedInstanceState);
                getWindow().requestFeature(8);
                ActionBar supportActionBar = getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.scheduleImpl();
                }
                setContentView(getBindingRoot());
                onCreateActivity(savedInstanceState);
                IMService.Companion companion = IMService.INSTANCE;
                iMTheme = IMService.KClassImpl$Data$declaredNonStaticMembers$2;
                if ((iMTheme == null ? objArr : iMTheme.BuiltInFictitiousFunctionClassFactory) != null) {
                    View decorView = getWindow().getDecorView();
                    Integer num = iMTheme.BuiltInFictitiousFunctionClassFactory;
                    if (num == null) {
                        Intrinsics.throwNpe();
                    }
                    decorView.setBackgroundColor(num.intValue());
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

    public final void replaceFragmentWith(Fragment fragment, boolean addToBackStack, int containerId) {
        if (fragment == null) {
            return;
        }
        try {
            String simpleName = fragment.getClass().getSimpleName();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "");
            if (containerId == 0) {
                throw new IllegalArgumentException("Must use non-zero containerViewId");
            }
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(containerId, fragment, simpleName, 2);
            Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "");
            if (addToBackStack) {
                if (!beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                }
                beginTransaction.scheduleImpl = true;
                beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda8 = simpleName;
            }
            beginTransaction.getAuthRequestContext();
        } catch (Exception unused) {
        }
    }

    private static void a(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = moveToNextValue;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ scheduleImpl);
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
