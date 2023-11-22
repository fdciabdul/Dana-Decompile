package com.alibaba.griver.image.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.hardware.Camera;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.capture.CaptureServiceImpl;
import com.alibaba.griver.image.capture.meta.CaptureParam;
import com.alibaba.griver.image.capture.meta.MediaInfo;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class GriverVideoPreviewActivity extends GriverMediaBaseActivity {
    private static short[] lookAheadTest;

    /* renamed from: a  reason: collision with root package name */
    private Bundle f6559a;
    private int b;
    private boolean c;
    private int d;
    public static final byte[] $$a = {63, Ascii.SUB, 111, -17, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 226;
    public static final byte[] getAuthRequestContext = {112, Ascii.US, -51, -82, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int BuiltInFictitiousFunctionClassFactory = 151;
    private static int MyBillsEntityDataFactory = 1257195755;
    private static int getErrorConfigVersion = 126183231;
    private static byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {-95, -81, -93, 85, 92, -125, -125, Ascii.SUB, -91, -32, 107, 90, 91, 92, -81, 87, -84, -66, 81, -103, 73, -10, 9, 6, -1, -31, 46, -16, -2, 6, -8, 0, -28, -41, -26, 75, -11, -6, -58, 63, 14, 15, 8, -5, 3, -8, 109, -108, 103, -127, 108, 104, 111, 110, -110, -67, 95, -108, -101, 97, -110, 111, Byte.MIN_VALUE, 74, 102, -76, 73, 103, -85, 74, 98, -99, -102, -74, 72, 98, -103, -104, -79, 97, -104, 87, -85, 73, 96, -86, 75, -74, 101, -102, 102, 78, 96, 101, -98, 96, -102, -88, -102, 102, -101, 75, -102, -102, -80, 81, -99, 103, -74, 73, -77, 80, 123, -77, -125, 78, 125, -125, 125, -123, -126, 124, 126, 120, 124, Byte.MIN_VALUE, 122, -122, -88, 78, -80, 73, -121, 126, Byte.MAX_VALUE, -79, 124, 87, 120, -84, 125, 77, 124, -78, 80, -81, 80, -85, 80, Byte.MAX_VALUE, -127, 121, -79, 79, -73, 72, 124, -126, Byte.MAX_VALUE, 124, -79, 83, Byte.MIN_VALUE, -86, -125, 80, 116, -117, -81, 126, 82, 125, -88, -26, -30, 45, -46, Ascii.US, -26, Ascii.FS, -32, 45, -41, Ascii.GS, 47, -32, -56, TarHeader.LF_LINK, -26, -29, -45, Ascii.SUB, -26, -31, 41, -52, -30, -32, Ascii.GS, TarHeader.LF_CONTIG, -56, -28, 44, -49, TarHeader.LF_FIFO, -50, TarHeader.LF_CHR, -30, -52, Ascii.GS, TarHeader.LF_LINK, -51, -26, TarHeader.LF_NORMAL, Ascii.GS, -46, 44, -46, 45, -26, -56, -27, Ascii.US, -32, -30, Ascii.ESC, -30, -30, -26, -32, Ascii.EM, Ascii.FS, TarHeader.LF_DIR, Ascii.US, -42, Ascii.GS, Byte.MAX_VALUE, -122, -119, 111, -111, -74, 125, 60, -57, 59, -127, -114, 126, 121, -123, -70, 70, 121, -113, -78, 66, 126, -116, -75, 73, 115, -111, 108, -124, 126, -113, 114, -111, 108, -114, -71, 58, -127, -110, 126, 111, -109, 124, 115, -118, 116, -58, 77, 115, -115, 125, -75, Byte.MIN_VALUE, 117, 71, -125, 124, Byte.MIN_VALUE, -116, 5, -2, 0, -4, 15, -97, -97, -97, -97, -97, -97, -97, -97, -97};
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = -1298532305;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 16
            byte[] r0 = com.alibaba.griver.image.activity.GriverVideoPreviewActivity.getAuthRequestContext
            int r7 = 106 - r7
            int r9 = r9 + 4
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
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2d:
            int r10 = r10 + 1
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
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.activity.GriverVideoPreviewActivity.f(byte, int, short, java.lang.Object[]):void");
    }

    private static void g(short s, short s2, byte b, Object[] objArr) {
        int i = 42 - (b * 3);
        byte[] bArr = $$a;
        int i2 = 46 - s;
        int i3 = 103 - (s2 * 2);
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            int i6 = (i5 + (-i2)) - 7;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i3 = i6;
            i2 = i2;
        }
        while (true) {
            int i7 = i2 + 1;
            int i8 = i4 + 1;
            bArr2[i8] = (byte) i3;
            if (i8 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i7];
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i8;
            i3 = (i3 + (-b2)) - 7;
            i2 = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x075f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0920  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0929  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0aea A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x02c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02bb  */
    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r32) {
        /*
            Method dump skipped, instructions count: 2795
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.activity.GriverVideoPreviewActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(super.getResources().getString(R.string.look_for_merchant_near_you_title).substring(4, 5).codePointAt(0) - 1298804575, super.getResources().getString(R.string.action_direction).substring(3, 4).length() - 91, (byte) (105 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (short) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 126439269 - (ViewConfiguration.getTapTimeout() >> 16), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            e(53491 - AndroidCharacter.getMirror('0'), (-98) - KeyEvent.getDeadChar(0, 0), (byte) (super.getResources().getString(R.string.upgrade_to_dana_premium_message_general).substring(3, 4).codePointAt(0) - 104), (short) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), super.getResources().getString(R.string.topup_and_pay_via_bank_card_title).substring(0, 4).codePointAt(1) + 126439189, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + PDF417Common.NUMBER_OF_CODEWORDS, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 36, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(super.getResources().getString(R.string.parking).substring(0, 5).length() - 1298804548, getPackageName().length() - 97, (byte) (super.getResources().getString(R.string.permission_setting).substring(1, 2).codePointAt(0) + 37), (short) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 126439268 + super.getResources().getString(R.string.payment_failed).substring(0, 1).length(), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int length = super.getResources().getString(R.string.text_desc_banner_global_send).substring(8, 9).length() - 1298804542;
            int i = (-97) - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            byte codePointAt = (byte) (super.getResources().getString(R.string.msg_system_busy).substring(2, 7).codePointAt(3) - 96);
            try {
                Object[] objArr2 = new Object[1];
                f(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                f(getAuthRequestContext[13], getAuthRequestContext[56], (byte) (getAuthRequestContext[59] + 1), new Object[1]);
                Object[] objArr3 = new Object[1];
                e(length, i, codePointAt, (short) (((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.topup_and_pay_via_other_agent_description).substring(0, 17).length() + 126439277, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 911, 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        e((-1298804543) - (ViewConfiguration.getJumpTapTimeout() >> 16), (-98) - (ViewConfiguration.getJumpTapTimeout() >> 16), (byte) (getPackageName().length() + 55), (short) (getPackageName().codePointAt(3) - 100), 126439148 + getPackageName().codePointAt(3), objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        e((-1298804531) - (ViewConfiguration.getLongPressTimeout() >> 16), super.getResources().getString(R.string.invalid_number_dialog_title).substring(3, 5).length() - 113, (byte) (super.getResources().getString(R.string.empty_recent_title).substring(0, 1).length() - 39), (short) (super.getResources().getString(R.string.tooltip_highlight_title).substring(1, 3).codePointAt(1) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS), 126439167 + super.getResources().getString(R.string.global_search_system_busy_title).substring(21, 23).codePointAt(0), objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int codePointAt = super.getResources().getString(R.string.my_bills_label_save_bill).substring(0, 1).codePointAt(0) - 1298804626;
                int codePointAt2 = getPackageName().codePointAt(1) - 190;
                byte codePointAt3 = (byte) (super.getResources().getString(R.string.gn_button_title_jp).substring(0, 12).codePointAt(8) + 9);
                short lastIndexOf = (short) (TextUtils.lastIndexOf("", '0') + 1);
                try {
                    Object[] objArr4 = new Object[1];
                    f(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    f(getAuthRequestContext[13], getAuthRequestContext[56], (byte) (getAuthRequestContext[59] + 1), objArr5);
                    int i = ((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 126439236;
                    Object[] objArr6 = new Object[1];
                    e(codePointAt, codePointAt2, codePointAt3, lastIndexOf, i, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    e(super.getResources().getString(R.string.lbl_dana_redirect_payment).substring(0, 78).length() - 1298804619, super.getResources().getString(R.string.banner_button_emoney_update_balance).substring(0, 7).length() + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS, (byte) (super.getResources().getString(R.string.topup_and_pay_amount_maximum_error_message).substring(45, 50).codePointAt(3) - 24), (short) (super.getResources().getString(R.string.voucher_code_valid).substring(6, 7).codePointAt(0) - 117), View.MeasureSpec.makeMeasureSpec(0, 0) + 126439294, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr8 = new Object[1];
                        f(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        f(getAuthRequestContext[13], getAuthRequestContext[56], (byte) (getAuthRequestContext[59] + 1), objArr9);
                        int i2 = ((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion - 1298804618;
                        int codePointAt4 = getPackageName().codePointAt(5) - 178;
                        byte b = (byte) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 7);
                        try {
                            Object[] objArr10 = new Object[1];
                            f(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr10);
                            Class<?> cls5 = Class.forName((String) objArr10[0]);
                            f(getAuthRequestContext[13], getAuthRequestContext[56], (byte) (getAuthRequestContext[59] + 1), new Object[1]);
                            Object[] objArr11 = new Object[1];
                            e(i2, codePointAt4, b, (short) (((ApplicationInfo) cls5.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.saving_withdrawal_address).substring(2, 3).length() + 126439310, objArr11);
                            String str = (String) objArr11[0];
                            int defaultSize = (-1298804543) - View.getDefaultSize(0, 0);
                            try {
                                Object[] objArr12 = new Object[1];
                                f(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr12);
                                Class<?> cls6 = Class.forName((String) objArr12[0]);
                                f(getAuthRequestContext[13], getAuthRequestContext[56], (byte) (getAuthRequestContext[59] + 1), new Object[1]);
                                Object[] objArr13 = new Object[1];
                                e(defaultSize, ((ApplicationInfo) cls6.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 85, (byte) (getPackageName().length() - 36), (short) (super.getResources().getString(R.string.res_0x7f1306fa_flowviewutil_textchanges_2).substring(12, 13).codePointAt(0) - 32), super.getResources().getString(R.string.voucher_failed_button).substring(0, 7).length() + 126439351, objArr13);
                                String str2 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                e((ViewConfiguration.getScrollBarFadeDuration() >> 16) - 1298804590, super.getResources().getString(R.string.error_username_space_unique_char).substring(0, 9).length() - 61, (byte) (125 - ExpandableListView.getPackedPositionGroup(0L)), (short) (super.getResources().getString(R.string.bottom_cancel).substring(1, 2).codePointAt(0) - 97), 126439421 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr14);
                                String str3 = (String) objArr14[0];
                                int indexOf = (-1298804537) - TextUtils.indexOf((CharSequence) "", '0');
                                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) - 56;
                                try {
                                    Object[] objArr15 = new Object[1];
                                    f(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr15);
                                    Class<?> cls7 = Class.forName((String) objArr15[0]);
                                    f(getAuthRequestContext[13], getAuthRequestContext[56], (byte) (getAuthRequestContext[59] + 1), new Object[1]);
                                    Object[] objArr16 = new Object[1];
                                    e(indexOf, makeMeasureSpec, (byte) (((ApplicationInfo) cls7.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 2), (short) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 126439485, objArr16);
                                    String str4 = (String) objArr16[0];
                                    Object[] objArr17 = new Object[1];
                                    e((-1298804583) - TextUtils.indexOf("", ""), super.getResources().getString(R.string.verify_limit_amount_daily_min_reached_error).substring(1, 2).length() - 111, (byte) (100 - TextUtils.lastIndexOf("", '0', 0, 0)), (short) (getPackageName().codePointAt(3) - 100), super.getResources().getString(R.string.my_bills_title).substring(0, 8).length() + 126439535, objArr17);
                                    try {
                                        Object[] objArr18 = {baseContext, str, str2, str3, str4, true, (String) objArr17[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr18);
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
            byte b2 = getAuthRequestContext[25];
            byte b3 = b2;
            Object[] objArr19 = new Object[1];
            f(b2, b3, (byte) (b3 | 37), objArr19);
            Class<?> cls8 = Class.forName((String) objArr19[0]);
            Object[] objArr20 = new Object[1];
            f(getAuthRequestContext[7], getAuthRequestContext[25], getAuthRequestContext[35], objArr20);
            try {
                Object[] objArr21 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.getOffsetAfter("", 0), (ViewConfiguration.getEdgeSlop() >> 16) + 4, (char) ('0' - AndroidCharacter.getMirror('0')));
                    Object[] objArr22 = new Object[1];
                    g((byte) ($$a[47] - 1), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr22);
                    obj3 = cls9.getMethod((String) objArr22[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr23 = (Object[]) ((Method) obj3).invoke(null, objArr21);
                int i3 = ((int[]) objArr23[1])[0];
                if (((int[]) objArr23[0])[0] != i3) {
                    long j = ((r2 ^ i3) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr24 = {1520913949, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr24);
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
                Bundle extras = getIntent().getExtras();
                this.f6559a = extras;
                if (extras == null) {
                    this.f6559a = new Bundle();
                }
                a();
                Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
                intent.putExtra("android.intent.extra.videoQuality", 1);
                intent.putExtra("android.intent.extra.durationLimit", this.b);
                if ((this.c || this.d == 1) ? b() : false) {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", this.d);
                } else {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
                }
                startActivityForResult(intent, 1001);
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

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && intent != null && (data = intent.getData()) != null) {
            CaptureServiceImpl.notifyAction(false, new MediaInfo(1, data.getPath(), 0, 0, 0, this.b), true);
        }
        finish();
    }

    private void a() {
        this.b = this.f6559a.getInt(CaptureParam.KEY_MAX_DURATION, 60);
        this.c = this.f6559a.getBoolean(CaptureParam.ENABLE_SWITCH_CAMERA, false);
        this.d = this.f6559a.getInt(CaptureParam.INIT_CAMERA_FACING, 0);
    }

    private boolean b() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            for (int i = 0; i < numberOfCameras; i++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Parse camera info exception :");
            sb.append(e.getMessage());
            RVLogger.w("GriverVideoPreviewActivity", sb.toString());
        }
        return false;
    }

    private static void e(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[i3 + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (lookAheadTest[i3 + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (getErrorConfigVersion ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = NetworkUserEntityData$$ExternalSyntheticLambda0;
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
                    byte[] bArr5 = NetworkUserEntityData$$ExternalSyntheticLambda0;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = lookAheadTest;
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
