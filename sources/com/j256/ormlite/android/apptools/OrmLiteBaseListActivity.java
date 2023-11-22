package com.j256.ormlite.android.apptools;

import android.app.ListActivity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import id.dana.R;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public abstract class OrmLiteBaseListActivity<H extends OrmLiteSqliteOpenHelper> extends ListActivity {
    private volatile boolean created = false;
    private volatile boolean destroyed = false;
    private volatile H helper;
    public static final byte[] $$a = {36, -25, -14, -85, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 116;
    public static final byte[] getAuthRequestContext = {56, -13, -61, 104, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 255;
    private static char MyBillsEntityDataFactory = 13492;
    private static long BuiltInFictitiousFunctionClassFactory = 8244068547625947480L;
    private static int PlaceComponentResult = -956812108;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = 106 - r7
            byte[] r0 = com.j256.ormlite.android.apptools.OrmLiteBaseListActivity.getAuthRequestContext
            int r8 = r8 + 16
            int r9 = 55 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2f
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2f:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.apptools.OrmLiteBaseListActivity.a(short, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r0 = com.j256.ormlite.android.apptools.OrmLiteBaseListActivity.$$a
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2c
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L2c:
            int r6 = r6 + 1
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.apptools.OrmLiteBaseListActivity.c(short, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x08e9  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0aa8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0565 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x028d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0725 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x08f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0280  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r31) {
        /*
            Method dump skipped, instructions count: 3136
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.apptools.OrmLiteBaseListActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {9708, 33743, 35500, 20205};
            char[] cArr2 = {18115, 47172, 22130, 12583};
            try {
                Object[] objArr = new Object[1];
                a((byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 52), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[48], getAuthRequestContext[8], getAuthRequestContext[25], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(cArr, cArr2, ((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (KeyEvent.keyCodeFromString("") + 10070), new char[]{2503, 21186, 23571, 60984, 14770, 14089, 65344, 27893, 59928, 58784, 17549, 60419, 56672, 1865, 63640, 45351, 36595, 58638, 30324, 60659, 43670, 16101, 19294, 24556, 48328, 63693}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(new char[]{9708, 33743, 35500, 20205}, new char[]{19902, 39166, 7910, 3081}, View.combineMeasuredStates(0, 0), (char) (getPackageName().length() + 2327), new char[]{24608, 21854, 3421, 30563, 58709, 58511, 35273, 60420, 28889, 44001, 51084, 31898, 29417, 20633, 44555, 44821, 44170, 35608}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ExpandableListView.getPackedPositionChild(0L), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, View.MeasureSpec.getMode(0) + 18, (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(new char[]{9708, 33743, 35500, 20205}, new char[]{18115, 47172, 22130, 12583}, getPackageName().codePointAt(2) - 46, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 10069), new char[]{2503, 21186, 23571, 60984, 14770, 14089, 65344, 27893, 59928, 58784, 17549, 60419, 56672, 1865, 63640, 45351, 36595, 58638, 30324, 60659, 43670, 16101, 19294, 24556, 48328, 63693}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            char[] cArr = {9708, 33743, 35500, 20205};
            char[] cArr2 = {19902, 39166, 7910, 3081};
            try {
                Object[] objArr2 = new Object[1];
                a((byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 52), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                a(getAuthRequestContext[48], getAuthRequestContext[8], getAuthRequestContext[25], new Object[1]);
                Object[] objArr3 = new Object[1];
                b(cArr, cArr2, ((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.deals_offline_category_fnb).substring(6, 7).length() + 2333), new char[]{24608, 21854, 3421, 30563, 58709, 58511, 35273, 60420, 28889, 44001, 51084, 31898, 29417, 20633, 44555, 44821, 44170, 35608}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) View.MeasureSpec.getSize(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public H getHelper() {
        if (this.helper == null) {
            if (!this.created) {
                throw new IllegalStateException("A call has not been made to onCreate() yet so the helper is null");
            }
            if (this.destroyed) {
                throw new IllegalStateException("A call to onDestroy has already been made and the helper cannot be used after that point");
            }
            throw new IllegalStateException("Helper is null for some unknown reason");
        }
        return this.helper;
    }

    public ConnectionSource getConnectionSource() {
        return getHelper().getConnectionSource();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Object[] objArr;
        char[] cArr = {9708, 33743, 35500, 20205};
        char[] cArr2 = {22891, 9068, 22586, 45043};
        try {
            Object[] objArr2 = new Object[1];
            a((byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 52), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            a(getAuthRequestContext[48], getAuthRequestContext[8], getAuthRequestContext[25], new Object[1]);
            Object[] objArr3 = new Object[1];
            b(cArr, cArr2, ((ApplicationInfo) cls.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().codePointAt(1) + 62196), new char[]{1058, 23533, 24632, 11212, 7422, 45758, 24521, 41169, 27811, 56470, 13816, 15607, 48796, 9419, 15808, 10896, 59564, 16263}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(new char[]{9708, 33743, 35500, 20205}, new char[]{53892, 33993, 12535, 48268}, getPackageName().codePointAt(0) - 142292631, (char) (super.getResources().getString(R.string.paylater_agreement_hyperlink).substring(0, 1).codePointAt(0) + 35808), new char[]{8479, 5311, 4805, 30776, 45889}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    b(new char[]{9708, 33743, 35500, 20205}, new char[]{18115, 47172, 22130, 12583}, super.getResources().getString(R.string.ep_price_change_dialog_desc).substring(18, 19).length() - 1, (char) (getPackageName().length() + 10063), new char[]{2503, 21186, 23571, 60984, 14770, 14089, 65344, 27893, 59928, 58784, 17549, 60419, 56672, 1865, 63640, 45351, 36595, 58638, 30324, 60659, 43670, 16101, 19294, 24556, 48328, 63693}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    char[] cArr3 = {9708, 33743, 35500, 20205};
                    char[] cArr4 = {19902, 39166, 7910, 3081};
                    int length = getPackageName().length() - 7;
                    try {
                        Object[] objArr6 = new Object[1];
                        a((byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 52), objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        a(getAuthRequestContext[48], getAuthRequestContext[8], getAuthRequestContext[25], objArr7);
                        Object[] objArr8 = new Object[1];
                        b(cArr3, cArr4, length, (char) (((ApplicationInfo) cls4.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + SecExceptionCode.SEC_ERROR_MIDDLE_TIER_INVALID_PARA), new char[]{24608, 21854, 3421, 30563, 58709, 58511, 35273, 60420, 28889, 44001, 51084, 31898, 29417, 20633, 44555, 44821, 44170, 35608}, objArr8);
                        baseContext = (Context) cls3.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr9 = new Object[1];
                        b(new char[]{9708, 33743, 35500, 20205}, new char[]{49500, 55128, 62622, 55957}, ViewConfiguration.getWindowTouchSlop() >> 8, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), new char[]{742, 60669, 13847, 28923, 41906, 39655, 20030, 11856, 33712, 49310, 5, 44442, 7209, 13569, 1776, 52120, 42262, 59991, 54176, 36792, 28691, 45577, 56243, 18526, 11772, 9261, 15198, 63989, 62399, 14603, 64300, 16093, 20332, 64352, 57510, 27038, 55560, 9144, 2935, 43678, 19929, 56328, 27150, 57098, 11580, 58915, 55549, 23782}, objArr9);
                        String str = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        b(new char[]{9708, 33743, 35500, 20205}, new char[]{13268, 21079, 23787, 45958}, Process.getGidForName("") + 1, (char) Color.blue(0), new char[]{41129, 51300, 34695, 20227, 37795, 30856, 31079, 45610, 33323, 51513, 61236, 25087, 41738, 48341, 27930, 18132, 44802, 38208, 11, 28525, 12107, 41223, 49868, 23517, 20690, 29695, 49410, 63410, 8747, 24358, 8521, 17329, 38327, 34114, 52076, 51847, 15994, 2673, 44119, 43672, 2572, 53413, 50711, 41260, 30204, 12659, 24583, 18060, 26112, 33706, 28977, 42726, 41997, 37705, 20856, 10970, 53757, 38619, 54984, 40996, 19561, 51875, 42351, 11469}, objArr10);
                        String str2 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        b(new char[]{9708, 33743, 35500, 20205}, new char[]{26153, 33184, 23418, 51097}, super.getResources().getString(R.string.automation_passkey_txt_wording_ernoll_passkey).substring(0, 26).codePointAt(15) - 111, (char) (getPackageName().length() - 7), new char[]{27765, 30400, 42833, 42902, 48810, 62002, 9247, 38397, 9448, 21275, 63829, 58904, 64271, 63582, 50510, 32139, 10412, 10065, 32469, 17330, 47756, 52982, 6317, 31525, 36604, 22596, 15856, 41868, 65142, 4044, 24938, 42790, 13146, 32772, 29834, 28033, 6919, 29877, 62450, 46276, 16531, 37848, 15918, 28740, 8890, 28370, 59591, 48035, 33523, 29803, 10793, 41470, 42357, 26845, 11833, 33663, 31561, 22724, 51426, 39251, 33908, 62783, 27661, 1636}, objArr11);
                        String str3 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        b(new char[]{9708, 33743, 35500, 20205}, new char[]{16668, 47435, 15957, 64593}, getPackageName().codePointAt(4) - 97, (char) (getPackageName().codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS), new char[]{54833, 3148, 46749, 39246, 11527, 43457, 47073, 34243, 57918, 59159, 28755, 36496, 35638, 28194, 61294, 29462, 38254, 16255, 20457, 38159, 53487, 26364, 51465, 59202, 62951, 6611, 41011, 3214, 40247, 44584, 2276, 11306, 46351, 13523, 49192, Typography.paragraph, 2559, 17620, 61228, 65328, 58816, 16392, 32756, 37861, 60568, 18068, 57266, 60525, 6020, 42921, 632, 26928, 40422, 53136, 19352, 20804, 29317, 46619, 65120, 18319}, objArr12);
                        String str4 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        b(new char[]{9708, 33743, 35500, 20205}, new char[]{7632, 49046, 16501, 17925}, ViewConfiguration.getDoubleTapTimeout() >> 16, (char) (TextUtils.getCapsMode("", 0, 0) + 1344), new char[]{61210, 12941, 12367, 36282, 15293, 40276}, objArr13);
                        try {
                            Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), 17 - Process.getGidForName(""), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr14);
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
                byte b = getAuthRequestContext[25];
                Object[] objArr15 = new Object[1];
                a(b, b, (byte) (-getAuthRequestContext[31]), objArr15);
                Class<?> cls5 = Class.forName((String) objArr15[0]);
                byte b2 = getAuthRequestContext[9];
                byte b3 = getAuthRequestContext[25];
                Object[] objArr16 = new Object[1];
                a(b2, b3, (byte) (b3 | Ascii.RS), objArr16);
                try {
                    Object[] objArr17 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 495, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 3, (char) KeyEvent.getDeadChar(0, 0));
                        Object[] objArr18 = new Object[1];
                        c($$a[53], $$a[8], $$a[9], objArr18);
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
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr20 = {1855638221, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr20);
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
                    if (this.helper == null) {
                        this.helper = getHelperInternal(this);
                        this.created = true;
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

    @Override // android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        releaseHelper(this.helper);
        this.destroyed = true;
    }

    protected H getHelperInternal(Context context) {
        return (H) OpenHelperManager.getHelper(context);
    }

    protected void releaseHelper(H h) {
        OpenHelperManager.releaseHelper();
        this.helper = null;
    }

    private static void b(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)) ^ ((int) (PlaceComponentResult ^ 4360990799332652212L))) ^ ((char) (MyBillsEntityDataFactory ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
