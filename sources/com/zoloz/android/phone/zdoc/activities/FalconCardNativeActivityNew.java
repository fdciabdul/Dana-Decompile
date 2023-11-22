package com.zoloz.android.phone.zdoc.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Build;
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
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.mobile.security.bio.api.BioDetector;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.local.apsecurity.ApSecurityService;
import com.alipay.mobile.security.bio.workspace.BioFragmentContainer;
import com.alipay.mobile.security.bio.workspace.BioFragmentResponse;
import com.alipay.zoloz.config.ConfigCenter;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.zoloz.android.phone.zdoc.cardmanager.CardManagerCallBack;
import com.zoloz.android.phone.zdoc.cardmanager.FalconTaskManager;
import com.zoloz.android.phone.zdoc.cardmanager.ZdocResponse;
import com.zoloz.android.phone.zdoc.constant.DocCodeConstants;
import com.zoloz.android.phone.zdoc.fragment.BaseDocFragment;
import com.zoloz.android.phone.zdoc.fragment.BaseFragment;
import com.zoloz.android.phone.zdoc.fragment.ZdocCaptureFragment;
import com.zoloz.android.phone.zdoc.module.ZdocRemoteConfig;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import com.zoloz.android.phone.zdoc.ui.UIFacade;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public class FalconCardNativeActivityNew extends BioFragmentContainer implements CardManagerCallBack {
    private FrameLayout mContainerView;
    protected Fragment mFragment;
    private String mProtocolConfig;
    private ZdocRecordService mRecoreService;
    public static final byte[] $$d = {42, -48, 107, -19, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 41;
    public static final byte[] getAuthRequestContext = {110, -41, 63, 58, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int moveToNextValue = 148;
    private static int lookAheadTest = 269894668;
    protected String mTarget = ZdocCaptureFragment.class.getName();
    protected Bundle mArgs = new Bundle();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 97
            int r8 = r8 + 16
            int r7 = r7 + 4
            byte[] r0 = com.zoloz.android.phone.zdoc.activities.FalconCardNativeActivityNew.getAuthRequestContext
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2d
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2d:
            int r7 = r7 + 1
            int r8 = -r8
            int r10 = r10 + r8
            int r8 = r10 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.android.phone.zdoc.activities.FalconCardNativeActivityNew.d(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r9 = 47 - r9
            byte[] r0 = com.zoloz.android.phone.zdoc.activities.FalconCardNativeActivityNew.$$d
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L35
        L18:
            r3 = 0
        L19:
            r6 = r8
            r8 = r7
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            int r9 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.android.phone.zdoc.activities.FalconCardNativeActivityNew.f(int, byte, short, java.lang.Object[]):void");
    }

    @Override // com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        e(18 - ExpandableListView.getPackedPositionType(0L), 16 - View.MeasureSpec.getMode(0), 139 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{2, 0, '\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, 16, 16}, true, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        e(Color.argb(0, 0, 0, 0) + 5, TextUtils.indexOf("", "", 0, 0) + 2, 145 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{17, 5, 65532, 1, 65517}, true, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    e((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 47, 16 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 112 - Color.argb(0, 0, 0, 0), new char[]{65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30}, false, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    e(65 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 28 - Color.blue(0), 107 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{'!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526}, false, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    e(64 - Color.red(0), (KeyEvent.getMaxKeyCode() >> 16) + 56, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 108, new char[]{65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520}, false, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    e(60 - KeyEvent.normalizeMetaState(0), 14 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0, 0) + 139, new char[]{65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19}, true, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    e((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 5, (ViewConfiguration.getEdgeSlop() >> 16) + 5, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 91, new char[]{0, 65532, 2, 65532, 7, 65535}, true, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                d((byte) (moveToNextValue >>> 2), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (-getAuthRequestContext[35]);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                d(b, b2, (byte) (b2 | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getPressedStateDuration() >> 16), 3 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr16 = new Object[1];
                        f($$d[47], $$d[68], (byte) (-$$d[53]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 16 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 800, 15 - TextUtils.getCapsMode("", 0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 816, View.MeasureSpec.getSize(0) + 29, (char) (57994 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.red(0), 15 - TextUtils.getOffsetAfter("", 0), (char) View.MeasureSpec.getSize(0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myTid() >> 22), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1084780998, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                d((byte) (moveToNextValue >>> 2), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (-getAuthRequestContext[35]);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr20 = new Object[1];
                d(b3, b4, (byte) (b4 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 61, (Process.myPid() >> 22) + 46, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        Object[] objArr22 = new Object[1];
                        f((byte) (-$$d[9]), (byte) (-$$d[8]), $$d[20], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1084780998, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                d((byte) (moveToNextValue >>> 2), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (-getAuthRequestContext[35]);
                byte b6 = getAuthRequestContext[25];
                Object[] objArr26 = new Object[1];
                d(b5, b6, (byte) (b6 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 117, (ViewConfiguration.getJumpTapTimeout() >> 16) + 3, (char) (38968 - ((Process.getThreadPriority(0) + 20) >> 6)));
                        Object[] objArr28 = new Object[1];
                        f((byte) (-$$d[9]), (byte) (-$$d[8]), $$d[20], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1084780998, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                d((byte) (moveToNextValue >>> 2), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = (byte) (-getAuthRequestContext[35]);
                byte b8 = getAuthRequestContext[25];
                Object[] objArr32 = new Object[1];
                d(b7, b8, (byte) (b8 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - TextUtils.lastIndexOf("", '0'), 3 - TextUtils.indexOf("", "", 0, 0), (char) Gravity.getAbsoluteGravity(0, 0));
                        byte b9 = (byte) ($$d[47] - 1);
                        byte b10 = b9;
                        Object[] objArr34 = new Object[1];
                        f(b9, b10, b10, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1084780998, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(super.getResources().getString(R.string.empty_statement_history_note).substring(22, 23).length() + 25, getPackageName().codePointAt(4) - 73, getPackageName().length() + 133, new char[]{2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534}, true, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                d(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                d((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[8], getAuthRequestContext[5], new Object[1]);
                try {
                    Object[] objArr3 = new Object[1];
                    e(((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 15, getPackageName().codePointAt(5) - 93, TextUtils.getOffsetBefore("", 0) + 147, new char[]{11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529}, false, objArr3);
                    baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    th = th;
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        super.onPause();
    }

    @Override // com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(getPackageName().length() + 19, 24 - Color.red(0), super.getResources().getString(R.string.mybills_edit_usage_meter).substring(0, 4).length() + 136, new char[]{2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534}, true, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            e(getPackageName().length() + 11, 16 - TextUtils.lastIndexOf("", '0', 0), View.combineMeasuredStates(0, 0) + 147, new char[]{11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529}, false, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), Process.getGidForName("") + 36, (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            d(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            d((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[8], getAuthRequestContext[5], new Object[1]);
            Object[] objArr3 = new Object[1];
            e(((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 15, super.getResources().getString(R.string.bank_name).substring(1, 2).codePointAt(0) - 81, getPackageName().length() + 133, new char[]{2, 0, '\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, 16, 16}, true, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            e(getPackageName().length() - 2, TextUtils.getOffsetBefore("", 0) + 2, TextUtils.indexOf("", "", 0) + 145, new char[]{17, 5, 65532, 1, 65517}, true, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        Object[] objArr5 = new Object[1];
                        d(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[25], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        d((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[8], getAuthRequestContext[5], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        e(((ApplicationInfo) cls3.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 7, 24 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), super.getResources().getString(R.string.voucher_promo_available).substring(0, 8).codePointAt(6) + 26, new char[]{2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534}, true, objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        e(18 - KeyEvent.getDeadChar(0, 0), getPackageName().codePointAt(5) - 93, super.getResources().getString(R.string.voucher_available).substring(29, 30).length() + 146, new char[]{11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529}, false, objArr7);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 35, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        int codePointAt = getPackageName().codePointAt(1) - 52;
                        int i = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 15;
                        try {
                            Object[] objArr8 = new Object[1];
                            d(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[25], objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            d((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[8], getAuthRequestContext[5], objArr9);
                            Object[] objArr10 = new Object[1];
                            e(codePointAt, i, ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 79, new char[]{65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30}, false, objArr10);
                            String str = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            e(getPackageName().codePointAt(2) + 18, getPackageName().codePointAt(1) - 72, 107 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{'!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526}, false, objArr11);
                            String str2 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            e(super.getResources().getString(R.string.sm_min_transfer_amount).substring(12, 13).length() + 63, TextUtils.indexOf("", "") + 56, 108 - Process.getGidForName(""), new char[]{65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520}, false, objArr12);
                            String str3 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            e(super.getResources().getString(R.string.home_dana_plus_unactive).substring(9, 10).codePointAt(0) - 50, super.getResources().getString(R.string.family_account_text_title_intro_1).substring(0, 2).codePointAt(0) - 53, TextUtils.indexOf((CharSequence) "", '0', 0) + 139, new char[]{65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19}, true, objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            e(getPackageName().codePointAt(3) - 94, 6 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), getPackageName().length() + 84, new char[]{0, 65532, 2, 65532, 7, 65535}, true, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), View.getDefaultSize(0, 0) + 18, (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                d((byte) (moveToNextValue >>> 2), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr16);
                Class<?> cls6 = Class.forName((String) objArr16[0]);
                byte b = (byte) (-getAuthRequestContext[35]);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr17 = new Object[1];
                d(b, b2, (byte) (b2 | 8), objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 3 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getTapTimeout() >> 16));
                        byte b3 = (byte) ($$d[47] - 1);
                        byte b4 = b3;
                        Object[] objArr19 = new Object[1];
                        f(b3, b4, b4, objArr19);
                        obj3 = cls7.getMethod((String) objArr19[0], Integer.TYPE);
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
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Color.argb(0, 0, 0, 0) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {1898380479, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, View.resolveSize(0, 0) + 18, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    requestWindowFeature(1);
                    setRequestedOrientation(1);
                    super.onCreate(bundle);
                    if (BioServiceManager.getCurrentInstance() == null) {
                        new IllegalStateException("null == BioServiceManager.getCurrentInstance()");
                        finish();
                    } else if (this.mBioAppDescription == null) {
                        new IllegalStateException("null == mBioAppDescription");
                        finish();
                    } else {
                        ConfigCenter.getInstance().setApplicationContext(getApplicationContext());
                        updateLocale(this.mBioAppDescription.getExtProperty().get("locale"));
                        recordStartZdoc();
                        FalconTaskManager.getInstance().setContext(this);
                        FalconTaskManager.getInstance().registerCallback(this);
                        FalconTaskManager.getInstance().setBioServiceManager(BioServiceManager.getCurrentInstance());
                        initContainerView();
                        try {
                            ZdocRemoteConfig zdocRemoteConfig = (ZdocRemoteConfig) JSON.parseObject(this.mBioAppDescription.getCfg(), ZdocRemoteConfig.class);
                            if (zdocRemoteConfig.getCaptureMode() == 1) {
                                this.mTarget = "com.zoloz.android.phone.zdoc.fragment.ZdocScanTasksFragment";
                            } else {
                                this.mTarget = ZdocCaptureFragment.class.getName();
                            }
                            this.mArgs.putSerializable("bio", this.mBioAppDescription);
                            this.mArgs.putSerializable("config", zdocRemoteConfig);
                            bindActivityFragment();
                        } catch (Exception unused) {
                            finish();
                        }
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

    private void updateLocale(String str) {
        Locale locale;
        if (str != null) {
            try {
                Configuration configuration = getResources().getConfiguration();
                if (str.contains("-")) {
                    String[] split = str.split("-");
                    if (split.length == 2) {
                        locale = new Locale(split[0], split[1]);
                    } else if (split.length == 1) {
                        locale = new Locale(split[0]);
                    } else if (Build.VERSION.SDK_INT >= 24) {
                        locale = getResources().getConfiguration().getLocales().get(0);
                    } else {
                        locale = getResources().getConfiguration().locale;
                    }
                } else {
                    locale = new Locale(str);
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    configuration.setLocale(locale);
                } else {
                    configuration.locale = new Locale(str);
                }
                getBaseContext().getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Fragment fragment = this.mFragment;
        if (fragment == null || !(fragment instanceof BaseFragment)) {
            return;
        }
        ((BaseFragment) fragment).onRestart();
    }

    private void recordStartZdoc() {
        ApSecurityService apSecurityService;
        if (this.mRecoreService == null) {
            this.mRecoreService = (ZdocRecordService) BioServiceManager.getCurrentInstance().getBioService(ZdocRecordService.class);
        }
        this.mProtocolConfig = this.mBioAppDescription.getCfg();
        HashMap hashMap = new HashMap();
        hashMap.put("productId", "zoloz_zdoc");
        hashMap.put("sdkVersion", "3.0");
        hashMap.put(ZdocRecordService.BISTOKEN, this.mBioAppDescription.getBistoken());
        String staticApDidToken = ApSecurityService.getStaticApDidToken();
        if (TextUtils.isEmpty(staticApDidToken) && (apSecurityService = (ApSecurityService) BioServiceManager.getCurrentInstance().getBioService(ApSecurityService.class)) != null) {
            staticApDidToken = apSecurityService.getApDidToken();
        }
        hashMap.put("apdidToken", staticApDidToken);
        this.mRecoreService.addExtProperties(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("params", this.mProtocolConfig);
        hashMap2.put(ZdocRecordService.DEVICE_BRAND, Build.BRAND);
        this.mRecoreService.write(ZdocRecordService.START_ZDOC, hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("module", BlobStatic.META_TYPE_DOC);
        this.mRecoreService.write("ztech_enter", hashMap3);
    }

    private void initContainerView() {
        this.mContainerView = new FrameLayout(this);
        this.mContainerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mContainerView.setId(16908300);
        setContentView(this.mContainerView);
    }

    private void bindActivityFragment() {
        try {
            Class<?> cls = Class.forName(this.mTarget, true, getClassLoader());
            try {
                String makeTag = makeTag(this.mContainerView.getId(), cls.getName());
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                BaseDocFragment baseDocFragment = (BaseDocFragment) supportFragmentManager.findFragmentByTag(makeTag);
                if (baseDocFragment != null) {
                    if (baseDocFragment.getArguments() == null) {
                        try {
                            baseDocFragment.setArguments(this.mArgs);
                        } catch (IllegalStateException unused) {
                        }
                    } else {
                        baseDocFragment.getArguments().putAll(this.mArgs);
                    }
                    beginTransaction.BuiltInFictitiousFunctionClassFactory(new FragmentTransaction.Op(7, baseDocFragment));
                } else {
                    baseDocFragment = (BaseDocFragment) cls.newInstance();
                    baseDocFragment.setArguments(this.mArgs);
                    int id2 = this.mContainerView.getId();
                    if (id2 == 0) {
                        throw new IllegalArgumentException("Must use non-zero containerViewId");
                    }
                    beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(id2, baseDocFragment, makeTag, 2);
                }
                beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
                this.mFragment = baseDocFragment;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    private String makeTag(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(":");
        sb.append(i);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment fragment = this.mFragment;
        if (fragment instanceof BaseDocFragment ? ((BaseDocFragment) fragment).onBackPressed() : false) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ((BaseDocFragment) this.mFragment).onWindowFocusChanged(z);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Fragment fragment;
        if ((i >> 16) == 0 && (fragment = this.mFragment) != null) {
            fragment.onActivityResult(i, i2, intent);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.zoloz.android.phone.zdoc.cardmanager.CardManagerCallBack
    public void onResult(ZdocResponse zdocResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put(ZdocRecordService.ZDOC_RESULT, Integer.toString(zdocResponse.retCode));
        if (this.mRecoreService == null) {
            this.mRecoreService = (ZdocRecordService) BioServiceManager.getCurrentInstance().getBioService(ZdocRecordService.class);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("module", BlobStatic.META_TYPE_DOC);
        this.mRecoreService.write("ztech_exit", hashMap2);
        this.mRecoreService.write(ZdocRecordService.END_ZDOC, hashMap);
        if (zdocResponse != null) {
            BioFragmentResponse bioFragmentResponse = new BioFragmentResponse();
            if (zdocResponse.bioUploadResult != null) {
                bioFragmentResponse.isSucess = zdocResponse.bioUploadResult.productRetCode == 1001;
                bioFragmentResponse.suggest = zdocResponse.bioUploadResult.productRetCode;
                bioFragmentResponse.resultMessage = zdocResponse.bioUploadResult.subMsg;
                bioFragmentResponse.ext.put(BioDetector.EXT_KEY_UPLOAD_RESPONSE, JSON.toJSONString(zdocResponse.bioUploadResult));
            }
            bioFragmentResponse.errorCode = zdocResponse.retCode;
            bioFragmentResponse.ext.putAll(zdocResponse.ext);
            bioFragmentResponse.token = getAppDescription().getBistoken();
            int i = zdocResponse.retCode;
            if (i == 101 || i == 200 || i == 100) {
                bioFragmentResponse.subCode = DocCodeConstants.ERROR_CAMERA;
                bioFragmentResponse.subMsg = DocCodeConstants.getMessage(bioFragmentResponse.subCode);
            } else if (i == 205) {
                bioFragmentResponse.subCode = DocCodeConstants.ERROR_SYSTEM;
                bioFragmentResponse.subMsg = DocCodeConstants.getMessage(bioFragmentResponse.subCode);
            } else if (i == 209) {
                bioFragmentResponse.subCode = DocCodeConstants.TOO_MANY_FAIL;
                bioFragmentResponse.subMsg = DocCodeConstants.getMessage(bioFragmentResponse.subCode);
            } else if (i == 202) {
                bioFragmentResponse.subCode = DocCodeConstants.INTERRUPT;
                bioFragmentResponse.subMsg = DocCodeConstants.getMessage(bioFragmentResponse.subCode);
            } else if (i == 203) {
                bioFragmentResponse.subCode = DocCodeConstants.TIME_OUT;
                bioFragmentResponse.subMsg = DocCodeConstants.getMessage(bioFragmentResponse.subCode);
            } else if (i == 207) {
                bioFragmentResponse.subCode = DocCodeConstants.NETWORK_BAD;
                bioFragmentResponse.subMsg = DocCodeConstants.getMessage(bioFragmentResponse.subCode);
            } else if (i == 208) {
                if (zdocResponse.bioUploadResult != null) {
                    bioFragmentResponse.subCode = zdocResponse.bioUploadResult.subCode;
                    bioFragmentResponse.subMsg = zdocResponse.bioUploadResult.subMsg;
                } else {
                    bioFragmentResponse.subCode = DocCodeConstants.FAIL_RETRY;
                    bioFragmentResponse.subMsg = DocCodeConstants.getMessage(bioFragmentResponse.subCode);
                }
            } else if (i == 301) {
                bioFragmentResponse.subCode = DocCodeConstants.USER_QUIT;
                bioFragmentResponse.subMsg = DocCodeConstants.getMessage(bioFragmentResponse.subCode);
            }
            sendResponse(bioFragmentResponse);
            finishActivity(false);
        }
    }

    @Override // com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        UIFacade.release();
    }

    private static void e(int i, int i2, int i3, char[] cArr, boolean z, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i3);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (lookAheadTest ^ (-5694784870793460699L))));
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
