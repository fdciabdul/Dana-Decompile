package com.alipay.mobile.verifyidentity.business.face.activity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.verifyidentity.business.activity.ProductActivity;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes7.dex */
public class ZolozDemoActivity extends ProductActivity {
    private static short[] GetContactSyncConfig;
    public static finishCallBack mfinishCallBack;
    private CountDownTimer king;
    public static final byte[] $$g = {65, TarHeader.LF_CHR, -100, -34, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 115;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {112, -20, -94, -81, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int scheduleImpl = 109;
    private static int moveToNextValue = 1257195648;
    private static int lookAheadTest = -1254350331;
    private static byte[] getErrorConfigVersion = {108, -108, -102, -106, 96, 105, -74, -74, 47, -112, -43, 94, 111, 110, 105, -102, 98, -103, 121, -22, 5, -51, Ascii.GS, 100, -62, 61, TarHeader.LF_SYMLINK, -53, -43, Ascii.SUB, -60, -54, TarHeader.LF_SYMLINK, -52, TarHeader.LF_BLK, -48, -29, -46, Byte.MAX_VALUE, -63, -50, -14, 11, 58, 59, 60, -49, TarHeader.LF_CONTIG, -52, 108, -22, 19, -32, 6, -21, -17, -24, -23, Ascii.NAK, 58, -40, 19, Ascii.FS, -26, Ascii.NAK, -24, 7, -114, 116, 88, -118, 119, 89, -107, 116, 92, -93, -92, -120, 118, 92, -89, -90, -113, 95, -90, 105, -107, 119, 94, -108, 117, -120, 91, -92, 88, 112, 94, 91, -96, 94, -92, -106, -92, 88, -91, 117, -92, -92, -114, 111, -93, 89, -120, 119, -66, 126, -99, -74, 126, 78, -125, -80, 78, -80, 72, 79, -79, -77, -75, -79, 77, -73, 75, 101, -125, 125, -124, 74, -77, -78, 124, -79, -102, -75, 97, -80, Byte.MIN_VALUE, -79, Byte.MAX_VALUE, -99, 98, -99, 102, -99, -78, 76, -76, 124, -126, 122, -123, -79, 79, -78, -79, 124, -98, 77, 103, 78, -99, -71, 70, 98, -77, -97, -80, 101, -66, 66, 70, -119, 118, -69, 66, -72, 68, -119, 115, -71, -117, 68, 108, -107, 66, 71, 119, -66, 66, 69, -115, 104, 70, 68, -71, -109, 108, SignedBytes.MAX_POWER_OF_TWO, -120, 107, -110, 106, -105, 70, 104, -71, -107, 105, 66, -108, -71, 118, -120, 118, -119, 66, 108, 65, -69, 68, 70, -65, 70, 70, 66, 68, -67, -72, -111, -69, 114, -71, -126, -47, 40, 39, -63, 63, Ascii.CAN, -45, -110, 105, -107, 47, 32, -48, -41, 43, Ascii.DC4, -24, -41, 33, Ascii.FS, -20, -48, 34, Ascii.ESC, -25, -35, 63, -62, 42, -48, 33, -36, 63, -62, 32, Ascii.ETB, -108, 47, 60, -48, -63, 61, -46, -35, 36, -38, 104, -29, -35, 35, -45, Ascii.ESC, 46, -37, -23, 45, -46, 46, 34, 120, 45, -42, 40, -44, 39};
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1571861744;

    /* loaded from: classes7.dex */
    public interface finishCallBack {
        void finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.mobile.verifyidentity.business.face.activity.ZolozDemoActivity.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 + 16
            int r6 = r6 + 4
            int r7 = r7 + 97
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L34
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
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
            r9 = r8
            r8 = r5
        L34:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.face.activity.ZolozDemoActivity.g(short, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void i(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r7 = r7 + 4
            int r9 = r9 * 2
            int r9 = 103 - r9
            byte[] r0 = com.alipay.mobile.verifyidentity.business.face.activity.ZolozDemoActivity.$$g
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            r8 = r7
            goto L36
        L18:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L1d:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r9) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L36:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.face.activity.ZolozDemoActivity.i(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x075a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x075f  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0763  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x092a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x092e  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0af6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x02b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02b1  */
    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r29) {
        /*
            Method dump skipped, instructions count: 2807
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.face.activity.ZolozDemoActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void modifyViewFromOutside() {
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 2921894;
                try {
                    Object[] objArr3 = new Object[1];
                    g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], objArr4);
                    int i2 = ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion - 392166521;
                    short mode = (short) View.MeasureSpec.getMode(0);
                    byte length = (byte) (getPackageName().length() + 87);
                    try {
                        Object[] objArr5 = new Object[1];
                        g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], objArr6);
                        int i3 = ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion - 65;
                        Object[] objArr7 = new Object[1];
                        h(i, i2, mode, length, i3, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 2921929;
                        int length2 = super.getResources().getString(R.string.kyb_apply_body).substring(10, 11).length() - 392166463;
                        short length3 = (short) (super.getResources().getString(R.string.zdoc_wrong_document_title).substring(3, 4).length() - 1);
                        try {
                            Object[] objArr8 = new Object[1];
                            g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
                            byte b = (byte) (((ApplicationInfo) cls5.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 151);
                            try {
                                Object[] objArr9 = new Object[1];
                                g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr9);
                                Class<?> cls6 = Class.forName((String) objArr9[0]);
                                Object[] objArr10 = new Object[1];
                                g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], objArr10);
                                int i4 = ((ApplicationInfo) cls6.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion - 65;
                                Object[] objArr11 = new Object[1];
                                h(jumpTapTimeout, length2, length3, b, i4, objArr11);
                                baseContext = (Context) cls4.getMethod((String) objArr11[0], new Class[0]).invoke(null, null);
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
            } catch (Throwable th5) {
                Throwable cause5 = th5.getCause();
                if (cause5 == null) {
                    throw th5;
                }
                throw cause5;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr12 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 911, 18 - Color.blue(0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr12);
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
        super.onPause();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            h(super.getResources().getString(R.string.force_face_auth_action).substring(0, 5).codePointAt(2) + 2921845, (-392166488) - TextUtils.indexOf("", "", 0), (short) (super.getResources().getString(R.string.share_feed_error_description).substring(9, 10).codePointAt(0) - 32), (byte) (getPackageName().codePointAt(3) - 6), getPackageName().codePointAt(3) - 132, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 2921929;
            int packedPositionChild = (-392166461) + ExpandableListView.getPackedPositionChild(0L);
            try {
                Object[] objArr2 = new Object[1];
                g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
                short s = (short) (((ApplicationInfo) cls2.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 33);
                byte b = (byte) ((-117) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                try {
                    Object[] objArr3 = new Object[1];
                    g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], objArr4);
                    int i = ((ApplicationInfo) cls3.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion - 65;
                    Object[] objArr5 = new Object[1];
                    h(keyRepeatTimeout, packedPositionChild, s, b, i, objArr5);
                    baseContext = (Context) cls.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) TextUtils.indexOf("", "", 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    public static void setFinishCallBack(finishCallBack finishcallback) {
        mfinishCallBack = finishcallback;
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = 2921928 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
        int length = getPackageName().length() - 392166518;
        short windowTouchSlop = (short) (ViewConfiguration.getWindowTouchSlop() >> 8);
        try {
            Object[] objArr = new Object[1];
            g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
            Object[] objArr2 = new Object[1];
            h(i, length, windowTouchSlop, (byte) (((ApplicationInfo) cls.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 22), getPackageName().length() - 39, objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            int codePointAt = super.getResources().getString(R.string.verification_list_history_title).substring(1, 2).codePointAt(0) + 2921834;
            try {
                Object[] objArr3 = new Object[1];
                g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr3);
                Class<?> cls3 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], objArr4);
                int i2 = ((ApplicationInfo) cls3.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion - 392166526;
                short myPid = (short) (Process.myPid() >> 22);
                try {
                    Object[] objArr5 = new Object[1];
                    g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr5);
                    Class<?> cls4 = Class.forName((String) objArr5[0]);
                    g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
                    Object[] objArr6 = new Object[1];
                    h(codePointAt, i2, myPid, (byte) (((ApplicationInfo) cls4.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 147), super.getResources().getString(R.string.more_for_you_description).substring(1, 2).length() - 33, objArr6);
                    int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                    if (intValue < 99000 || intValue > 99999) {
                        Context baseContext = getBaseContext();
                        if (baseContext == null) {
                            int red = Color.red(0) + 2921927;
                            int packedPositionGroup = (-392166488) - ExpandableListView.getPackedPositionGroup(0L);
                            short length2 = (short) (getPackageName().length() - 7);
                            byte length3 = (byte) (super.getResources().getString(R.string.tooltip_home_send_desc).substring(0, 9).length() + 85);
                            try {
                                Object[] objArr7 = new Object[1];
                                g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr7);
                                Class<?> cls5 = Class.forName((String) objArr7[0]);
                                Object[] objArr8 = new Object[1];
                                g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], objArr8);
                                int i3 = ((ApplicationInfo) cls5.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion - 65;
                                Object[] objArr9 = new Object[1];
                                h(red, packedPositionGroup, length2, length3, i3, objArr9);
                                Class<?> cls6 = Class.forName((String) objArr9[0]);
                                Object[] objArr10 = new Object[1];
                                h(getPackageName().codePointAt(3) + 2921829, super.getResources().getString(R.string.getSupportButtonTintMode).substring(9, 10).codePointAt(0) - 392166566, (short) (getPackageName().codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS), (byte) (super.getResources().getString(R.string.profile_completion_task_phone_number).substring(5, 6).codePointAt(0) - 150), super.getResources().getString(R.string.mybills_detail_total_payment_period).substring(0, 3).codePointAt(0) - 69, objArr10);
                                baseContext = (Context) cls6.getMethod((String) objArr10[0], new Class[0]).invoke(null, null);
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
                                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), 34 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                }
                                Object invoke = ((Method) obj).invoke(null, null);
                                Object[] objArr11 = new Object[1];
                                h(super.getResources().getString(R.string.merchant_title).substring(6, 7).codePointAt(0) + 2921784, super.getResources().getString(R.string.ktp_detail_failed_state_desc).substring(17, 18).length() - 392166445, (short) (getPackageName().codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS), (byte) ((-61) - MotionEvent.axisFromString("")), super.getResources().getString(R.string.home_shopping_tutorial_pay_step_4).substring(12, 13).codePointAt(0) - 146, objArr11);
                                String str = (String) objArr11[0];
                                int length4 = super.getResources().getString(R.string.setting_more_deeplink_error_msg).substring(31, 33).length() + 2921925;
                                int codePointAt2 = getPackageName().codePointAt(2) - 392166442;
                                try {
                                    Object[] objArr12 = new Object[1];
                                    g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr12);
                                    Class<?> cls7 = Class.forName((String) objArr12[0]);
                                    g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
                                    Object[] objArr13 = new Object[1];
                                    h(length4, codePointAt2, (short) (((ApplicationInfo) cls7.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33), (byte) (47 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), getPackageName().codePointAt(5) - 142, objArr13);
                                    String str2 = (String) objArr13[0];
                                    int jumpTapTimeout = 2921880 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                                    try {
                                        Object[] objArr14 = new Object[1];
                                        g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr14);
                                        Class<?> cls8 = Class.forName((String) objArr14[0]);
                                        Object[] objArr15 = new Object[1];
                                        g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], objArr15);
                                        int i4 = ((ApplicationInfo) cls8.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion - 392166365;
                                        try {
                                            Object[] objArr16 = new Object[1];
                                            g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr16);
                                            Class<?> cls9 = Class.forName((String) objArr16[0]);
                                            g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
                                            Object[] objArr17 = new Object[1];
                                            h(jumpTapTimeout, i4, (short) (((ApplicationInfo) cls9.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), (byte) ((-40) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), super.getResources().getString(R.string.msg_confirm_pin_not_match).substring(0, 4).codePointAt(2) - 110, objArr17);
                                            String str3 = (String) objArr17[0];
                                            Object[] objArr18 = new Object[1];
                                            h(super.getResources().getString(R.string.request_money_add_bank_account_number_hint).substring(19, 20).codePointAt(0) + 2921824, super.getResources().getString(R.string.voucher_title).substring(0, 7).length() - 392166275, (short) (super.getResources().getString(R.string.top_up_dialog_error).substring(6, 7).codePointAt(0) - 32), (byte) ((-79) - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), super.getResources().getString(R.string.smartpay_info_desc_2).substring(21, 22).codePointAt(0) - 129, objArr18);
                                            String str4 = (String) objArr18[0];
                                            int codePointAt3 = super.getResources().getString(R.string.saving_progress_text).substring(0, 10).codePointAt(1) + 2921787;
                                            try {
                                                Object[] objArr19 = new Object[1];
                                                g(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[30], objArr19);
                                                Class<?> cls10 = Class.forName((String) objArr19[0]);
                                                g((byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[5], BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
                                                Object[] objArr20 = new Object[1];
                                                h(codePointAt3, ((ApplicationInfo) cls10.getMethod((String) r6[0], null).invoke(this, null)).targetSdkVersion - 392166241, (short) (getPackageName().codePointAt(2) - 46), (byte) (super.getResources().getString(R.string.mybills_edit_description_text).substring(5, 8).codePointAt(1) - 33), getPackageName().length() - 39, objArr20);
                                                try {
                                                    Object[] objArr21 = {baseContext, str, str2, str3, str4, true, (String) objArr20[0], 995651014};
                                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                    if (obj2 == null) {
                                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), 17 - TextUtils.lastIndexOf("", '0', 0), (char) View.MeasureSpec.getMode(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                    }
                                                    ((Method) obj2).invoke(invoke, objArr21);
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
                    }
                    try {
                        Object[] objArr22 = new Object[1];
                        g((byte) (scheduleImpl & 182), (byte) (-BuiltInFictitiousFunctionClassFactory[32]), BuiltInFictitiousFunctionClassFactory[25], objArr22);
                        Class<?> cls11 = Class.forName((String) objArr22[0]);
                        Object[] objArr23 = new Object[1];
                        g((short) 21, (byte) (scheduleImpl & 26), BuiltInFictitiousFunctionClassFactory[25], objArr23);
                        try {
                            Object[] objArr24 = {Integer.valueOf(((Integer) cls11.getMethod((String) objArr23[0], Object.class).invoke(null, this)).intValue())};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                            if (obj3 == null) {
                                Class cls12 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 4 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                                Object[] objArr25 = new Object[1];
                                i($$g[40], (byte) (-$$g[8]), (byte) (-$$g[9]), objArr25);
                                obj3 = cls12.getMethod((String) objArr25[0], Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                            }
                            Object[] objArr26 = (Object[]) ((Method) obj3).invoke(null, objArr24);
                            int i5 = ((int[]) objArr26[1])[0];
                            if (((int[]) objArr26[0])[0] != i5) {
                                long j = ((r0 ^ i5) & 4294967295L) | 42949672960L;
                                try {
                                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj4 == null) {
                                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                    }
                                    Object invoke2 = ((Method) obj4).invoke(null, null);
                                    try {
                                        Object[] objArr27 = {-1236719528, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                        if (obj5 == null) {
                                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                        }
                                        ((Method) obj5).invoke(invoke2, objArr27);
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
                            super.onCreate(bundle);
                            setContentView(com.alipay.mobile.verifyidentity.business.face.R.layout.zolozdemoactivity);
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
        } catch (Throwable th14) {
            Throwable cause14 = th14.getCause();
            if (cause14 == null) {
                throw th14;
            }
            throw cause14;
        }
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void initData() {
        this.king = new CountDownTimer(10000L, 1000L) { // from class: com.alipay.mobile.verifyidentity.business.face.activity.ZolozDemoActivity.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                InstrumentInjector.log_e("king", "  CountDownTimer  onFinish  ");
                if (ZolozDemoActivity.mfinishCallBack != null) {
                    ZolozDemoActivity.mfinishCallBack.finish();
                }
                ZolozDemoActivity.this.finish();
            }
        }.start();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.king.cancel();
    }

    private static void h(int i, int i2, short s, byte b, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i3 + ((int) (moveToNextValue ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = getErrorConfigVersion;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (getErrorConfigVersion[i2 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (moveToNextValue ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (GetContactSyncConfig[i2 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (moveToNextValue ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i2 + i4) - 2) + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (lookAheadTest ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = getErrorConfigVersion;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = getErrorConfigVersion;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = GetContactSyncConfig;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
