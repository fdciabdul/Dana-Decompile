package id.dana.sendmoney.premium;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.CircularRevealAnimationUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.RandomInteger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes5.dex */
public class PremiumNoticeActivity extends BaseActivity implements CircularRevealAnimationUtil.OnAnimationFinishedListener {
    private static byte[] DatabaseTableConfigUtil = null;
    public static final String KEY_IS_SELECTED_UPGRADE_BUTTON = "is_selected_upgrade_button";
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static short[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    public static final int PREMIUM_NOTICE_REQUEST_CODE;
    private static int getErrorConfigVersion;
    private static int lookAheadTest;
    @BindView(R.id.f3647res_0x7f0a041b_fontscontractcompat_fontrequestcallback)
    ConstraintLayout clContainer;
    private boolean scheduleImpl;
    public static final byte[] $$a = {44, 104, -53, -66, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 15;
    public static final byte[] PlaceComponentResult = {111, 84, 114, 59, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 64;

    static void BuiltInFictitiousFunctionClassFactory() {
        lookAheadTest = 1257195656;
        getErrorConfigVersion = 620800467;
        DatabaseTableConfigUtil = new byte[]{-39, -96, -87, -46, -56, -127, -41, -47, -87, -49, -89, -53, -6, -55, -98, -36, -51, -23, -110, -95, -94, -33, -50, -90, -49, -87, -94, -77, -43, -86, -82, -85, -84, -88, -7, -101, -94, -33, -75, -88, -85, -42, -41, -55, -43, -93, -38, -11, -11, -100, -45, 22, -115, -36, -35, -38, -55, -95, -54, -15, Ascii.CAN, -48, -32, 57, -27, -41, 60, -26, -38, 57, -31, -16, -23, -43, 59, -31, -20, -21, -44, -28, -21, TarHeader.LF_FIFO, -38, 60, -29, -39, 58, -43, -24, -23, -27, 61, -29, -24, -19, -29, -23, -37, -23, -27, -22, 58, -23, -23, -45, TarHeader.LF_BLK, -16, -26, -43, 60, 113, -44, -71, 113, -127, -50, -65, -127, -65, -121, -126, Byte.MIN_VALUE, -66, -68, Byte.MIN_VALUE, -124, -70, -122, 108, -50, 116, -53, -123, -66, -67, 115, Byte.MIN_VALUE, -43, -68, 112, -65, -49, Byte.MIN_VALUE, 114, -44, 109, -44, 105, -44, -67, -125, -69, 115, -51, 117, -52, Byte.MIN_VALUE, -126, -67, Byte.MIN_VALUE, 115, -47, -124, 106, -127, -44, -72, -119, 109, -66, -46, -65, 108, -61, -57, -72, Ascii.ETB, -54, -61, -55, -59, -72, 18, -56, -70, -59, Ascii.GS, -76, -61, -58, 22, -49, -61, -60, -68, Ascii.EM, -57, -59, -56, -78, Ascii.GS, -63, -71, Ascii.SUB, -77, Ascii.ESC, -74, -57, Ascii.EM, -56, -76, Ascii.CAN, -61, -75, -56, Ascii.ETB, -71, Ascii.ETB, -72, -61, Ascii.GS, -64, -54, -59, -57, -50, -57, -57, -61, -59, -52, -55, -80, -54, 19, -56, -75, -82, -85, -123, -93, -2, -73, 120, -19, 121, -77, -90, -74, -69, -81, -6, 110, -69, -91, -62, 114, -74, -88, -1, 107, -127, -93, -120, -80, -74, -91, -126, -93, -120, -90, -5, 122, -77, -94, -74, -123, -95, -72, -127, -86, Byte.MIN_VALUE, -18, 103, -127, -89, -73, -1, -76, -65, 109, -79, -72, -76, -88, 58, TarHeader.LF_DIR, 63, TarHeader.LF_CHR, 4, -97, -97, -97, -97, -97, -97, -97, -97, -97};
        NetworkUserEntityData$$ExternalSyntheticLambda0 = 1308272476;
    }

    private static boolean PlaceComponentResult(ConstraintLayout constraintLayout) {
        return constraintLayout != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0023). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            byte[] r0 = id.dana.sendmoney.premium.PremiumNoticeActivity.PlaceComponentResult
            int r7 = r7 + 4
            int r6 = 23 - r6
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r8
            r4 = 0
            r8 = r7
            goto L23
        L11:
            r3 = 0
        L12:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            r3 = r0[r7]
        L23:
            int r7 = r7 + 1
            int r8 = r8 + r3
            int r8 = r8 + (-4)
            r3 = r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.premium.PremiumNoticeActivity.a(short, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r0 = id.dana.sendmoney.premium.PremiumNoticeActivity.$$a
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r8
            r4 = 0
            goto L26
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            r3 = r0[r8]
        L26:
            int r8 = r8 + 1
            int r6 = r6 + r3
            int r6 = r6 + (-7)
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.premium.PremiumNoticeActivity.c(int, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0930  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0935  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0b08 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x02ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02c2  */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r35) {
        /*
            Method dump skipped, instructions count: 2825
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.premium.PremiumNoticeActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        return R.layout.activity_premium_notice;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            byte b = PlaceComponentResult[25];
            Object[] objArr2 = new Object[1];
            a(b, b, PlaceComponentResult[32], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], objArr3);
            int i = ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 1877991692;
            int mirror = '+' - AndroidCharacter.getMirror('0');
            try {
                byte b2 = PlaceComponentResult[25];
                Object[] objArr4 = new Object[1];
                a(b2, b2, PlaceComponentResult[32], objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], new Object[1]);
                Object[] objArr5 = new Object[1];
                b(i, mirror, (byte) (((ApplicationInfo) cls2.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (super.getResources().getString(R.string.auto_routing_tnc).substring(29, 30).codePointAt(0) - 189), getPackageName().length() - 118878112, objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                int length = super.getResources().getString(R.string.balance_title).substring(1, 3).length() - 1877991649;
                int length2 = getPackageName().length() - 25;
                byte length3 = (byte) (super.getResources().getString(R.string.pocket_voucher_value).substring(0, 9).length() - 9);
                short s = (short) ((-115) - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                try {
                    byte b3 = PlaceComponentResult[25];
                    Object[] objArr6 = new Object[1];
                    a(b3, b3, PlaceComponentResult[32], objArr6);
                    Class<?> cls4 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], objArr7);
                    int i2 = ((ApplicationInfo) cls4.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion - 118878121;
                    Object[] objArr8 = new Object[1];
                    b(length, length2, length3, s, i2, objArr8);
                    int intValue = ((Integer) cls3.getDeclaredMethod((String) objArr8[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                    if (intValue < 99000 || intValue > 99999) {
                        Context baseContext = getBaseContext();
                        if (baseContext == null) {
                            Object[] objArr9 = new Object[1];
                            b(getPackageName().codePointAt(2) - 1877991705, getPackageName().codePointAt(1) - 97, (byte) (super.getResources().getString(R.string.payment_setting_always_ask_pin_dialog_message).substring(34, 35).codePointAt(0) - 110), (short) (getPackageName().codePointAt(1) - 167), super.getResources().getString(R.string.btn_continue_verify_phone_number).substring(2, 3).codePointAt(0) - 118878257, objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            int codePointAt = super.getResources().getString(R.string.voucher_and_ticket_expired_empty_state_desc).substring(1, 3).codePointAt(1) - 1877991774;
                            int codePointAt2 = super.getResources().getString(R.string.global_search_bottomsheet_general_error_title).substring(14, 15).codePointAt(0) - 37;
                            try {
                                byte b4 = PlaceComponentResult[25];
                                Object[] objArr10 = new Object[1];
                                a(b4, b4, PlaceComponentResult[32], objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], new Object[1]);
                                Object[] objArr11 = new Object[1];
                                b(codePointAt, codePointAt2, (byte) (((ApplicationInfo) cls6.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (getPackageName().length() - 62), getPackageName().length() - 118878129, objArr11);
                                baseContext = (Context) cls5.getMethod((String) objArr11[0], new Class[0]).invoke(null, null);
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
                                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSize(0, 0), 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                }
                                Object invoke = ((Method) obj).invoke(null, null);
                                int green = (-1877991701) - Color.green(0);
                                int length4 = super.getResources().getString(R.string.res_0x7f1302fa_networkuserentitydata_externalsyntheticlambda5).substring(0, 1).length() + 24;
                                byte scrollDefaultDelay = (byte) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                                try {
                                    byte b5 = PlaceComponentResult[25];
                                    Object[] objArr12 = new Object[1];
                                    a(b5, b5, PlaceComponentResult[32], objArr12);
                                    Class<?> cls7 = Class.forName((String) objArr12[0]);
                                    a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], new Object[1]);
                                    short s2 = (short) (((ApplicationInfo) cls7.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 152);
                                    try {
                                        byte b6 = PlaceComponentResult[25];
                                        Object[] objArr13 = new Object[1];
                                        a(b6, b6, PlaceComponentResult[32], objArr13);
                                        Class<?> cls8 = Class.forName((String) objArr13[0]);
                                        Object[] objArr14 = new Object[1];
                                        a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], objArr14);
                                        int i3 = ((ApplicationInfo) cls8.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion - 118878117;
                                        Object[] objArr15 = new Object[1];
                                        b(green, length4, scrollDefaultDelay, s2, i3, objArr15);
                                        String str = (String) objArr15[0];
                                        Object[] objArr16 = new Object[1];
                                        b((-1877991659) - View.MeasureSpec.getMode(0), getPackageName().codePointAt(5) - 69, (byte) (ViewConfiguration.getLongPressTimeout() >> 16), (short) (17 - AndroidCharacter.getMirror('0')), super.getResources().getString(R.string.edit_savings_title).substring(2, 3).codePointAt(0) - 118878134, objArr16);
                                        String str2 = (String) objArr16[0];
                                        Object[] objArr17 = new Object[1];
                                        b(getPackageName().length() - 1877991713, super.getResources().getString(R.string.dana_protection_security_suggestion_title).substring(1, 2).codePointAt(0) - 60, (byte) (getPackageName().length() - 7), (short) (TextUtils.lastIndexOf("", '0', 0, 0) - 87), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 118877975, objArr17);
                                        String str3 = (String) objArr17[0];
                                        Object[] objArr18 = new Object[1];
                                        b(getPackageName().codePointAt(5) - 1877991762, super.getResources().getString(R.string.username_guidelines_span).substring(2, 3).codePointAt(0) - 60, (byte) Gravity.getAbsoluteGravity(0, 0), (short) ((-43) - (ViewConfiguration.getJumpTapTimeout() >> 16)), getPackageName().codePointAt(5) - 118878021, objArr18);
                                        String str4 = (String) objArr18[0];
                                        try {
                                            byte b7 = PlaceComponentResult[25];
                                            Object[] objArr19 = new Object[1];
                                            a(b7, b7, PlaceComponentResult[32], objArr19);
                                            Class<?> cls9 = Class.forName((String) objArr19[0]);
                                            Object[] objArr20 = new Object[1];
                                            a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], objArr20);
                                            int i4 = ((ApplicationInfo) cls9.getMethod((String) objArr20[0], null).invoke(this, null)).targetSdkVersion - 1877991732;
                                            int lastIndexOf = TextUtils.lastIndexOf("", '0') - 16;
                                            try {
                                                byte b8 = PlaceComponentResult[25];
                                                Object[] objArr21 = new Object[1];
                                                a(b8, b8, PlaceComponentResult[32], objArr21);
                                                Class<?> cls10 = Class.forName((String) objArr21[0]);
                                                a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], new Object[1]);
                                                byte b9 = (byte) (((ApplicationInfo) cls10.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33);
                                                try {
                                                    byte b10 = PlaceComponentResult[25];
                                                    Object[] objArr22 = new Object[1];
                                                    a(b10, b10, PlaceComponentResult[32], objArr22);
                                                    Class<?> cls11 = Class.forName((String) objArr22[0]);
                                                    Object[] objArr23 = new Object[1];
                                                    a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], objArr23);
                                                    Object[] objArr24 = new Object[1];
                                                    b(i4, lastIndexOf, b9, (short) (((ApplicationInfo) cls11.getMethod((String) objArr23[0], null).invoke(this, null)).targetSdkVersion + 57), (-118877852) - (Process.myTid() >> 22), objArr24);
                                                    try {
                                                        Object[] objArr25 = {baseContext, str, str2, str3, str4, true, (String) objArr24[0], 995651014};
                                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                        if (obj2 == null) {
                                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                        }
                                                        ((Method) obj2).invoke(invoke, objArr25);
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
                            } catch (Throwable th8) {
                                Throwable cause8 = th8.getCause();
                                if (cause8 == null) {
                                    throw th8;
                                }
                                throw cause8;
                            }
                        }
                    }
                    try {
                        Object[] objArr26 = new Object[1];
                        a((byte) (-PlaceComponentResult[30]), (short) 37, PlaceComponentResult[25], objArr26);
                        Class<?> cls12 = Class.forName((String) objArr26[0]);
                        Object[] objArr27 = new Object[1];
                        a((byte) (-PlaceComponentResult[30]), PlaceComponentResult[35], PlaceComponentResult[7], objArr27);
                        try {
                            Object[] objArr28 = {Integer.valueOf(((Integer) cls12.getMethod((String) objArr27[0], Object.class).invoke(null, this)).intValue())};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                            if (obj3 == null) {
                                Class cls13 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 494, 4 - Color.green(0), (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                                Object[] objArr29 = new Object[1];
                                c((byte) ($$a[78] - 1), $$a[8], $$a[53], objArr29);
                                obj3 = cls13.getMethod((String) objArr29[0], Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                            }
                            Object[] objArr30 = (Object[]) ((Method) obj3).invoke(null, objArr28);
                            int i5 = ((int[]) objArr30[1])[0];
                            if (((int[]) objArr30[0])[0] != i5) {
                                long j = ((r2 ^ i5) & 4294967295L) | 42949672960L;
                                try {
                                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj4 != null) {
                                        objArr = null;
                                    } else {
                                        objArr = null;
                                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                    }
                                    Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                    try {
                                        Object[] objArr31 = {636564967, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                        if (obj5 == null) {
                                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, (Process.myTid() >> 22) + 18, (char) (Process.getGidForName("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                        }
                                        ((Method) obj5).invoke(invoke2, objArr31);
                                    } catch (Throwable th9) {
                                        Throwable cause9 = th9.getCause();
                                        if (cause9 == null) {
                                            throw th9;
                                        }
                                        throw cause9;
                                    }
                                } catch (Throwable th10) {
                                    Throwable cause10 = th10.getCause();
                                    if (cause10 == null) {
                                        throw th10;
                                    }
                                    throw cause10;
                                }
                            }
                            super.onCreate(bundle);
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
        } catch (Throwable th15) {
            Throwable cause15 = th15.getCause();
            if (cause15 == null) {
                throw th15;
            }
            throw cause15;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                a(b, b, PlaceComponentResult[32], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 1877991692, super.getResources().getString(R.string.quest_failed_claim_description).substring(8, 9).length() + 2, (byte) TextUtils.getOffsetAfter("", 0), (short) (super.getResources().getString(R.string.family_account_setting_subtitle).substring(11, 12).codePointAt(0) - 99), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 118878148, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int modifierMetaStateMask = (-1877991658) - ((byte) KeyEvent.getModifierMetaStateMask());
                try {
                    byte b2 = PlaceComponentResult[25];
                    Object[] objArr3 = new Object[1];
                    a(b2, b2, PlaceComponentResult[32], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], objArr4);
                    int i = ((ApplicationInfo) cls3.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion - 38;
                    try {
                        byte b3 = PlaceComponentResult[25];
                        Object[] objArr5 = new Object[1];
                        a(b3, b3, PlaceComponentResult[32], objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        b(modifierMetaStateMask, i, (byte) (((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (getPackageName().length() - 62), super.getResources().getString(R.string.kyc_success_description).substring(0, 30).codePointAt(25) - 118878233, objArr6);
                        baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 34 - ExpandableListView.getPackedPositionChild(0L), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr7);
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
        super.onResume();
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        PREMIUM_NOTICE_REQUEST_CODE = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int length = super.getResources().getString(R.string.profile_empty_desc).substring(18, 19).length() - 1877991660;
            int absoluteGravity = 3 - Gravity.getAbsoluteGravity(0, 0);
            byte b = (byte) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            try {
                byte b2 = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                a(b2, b2, PlaceComponentResult[32], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[27], (byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[13], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(length, absoluteGravity, b, (short) (((ApplicationInfo) cls.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 100), super.getResources().getString(R.string.res_0x7f130f31_networkuserentitydata_externalsyntheticlambda3).substring(3, 4).length() - 118878148, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(super.getResources().getString(R.string.voucher_dana_deals_header).substring(10, 21).length() - 1877991668, TextUtils.lastIndexOf("", '0') - 4, (byte) (super.getResources().getString(R.string.four_king_quest).substring(0, 11).codePointAt(8) + SecLiteException.ERROR_API_KEY_OR_SIGN), (short) ((-54) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (-118878121) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 930, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        overridePendingTransition(0, 0);
        super.onPause();
    }

    @OnClick({R.id.btn_upgrade})
    public void goToUpgradeProcess() {
        this.scheduleImpl = true;
        if (OSUtil.GetContactSyncConfig()) {
            getWindow().setStatusBarColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.colorPrimaryDark));
        }
        CircularRevealAnimationUtil.MyBillsEntityDataFactory(this, this.clContainer, this);
    }

    @OnClick({R.id.btn_use_card})
    public void applyUseCardPayMethod() {
        this.scheduleImpl = false;
        if (OSUtil.GetContactSyncConfig()) {
            getWindow().setStatusBarColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.colorPrimaryDark));
        }
        CircularRevealAnimationUtil.MyBillsEntityDataFactory(this, this.clContainer, this);
    }

    @Override // id.dana.utils.CircularRevealAnimationUtil.OnAnimationFinishedListener
    public void onRevealAnimationStart() {
        if (OSUtil.GetContactSyncConfig()) {
            getWindow().setStatusBarColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.f22932131099760));
        }
    }

    @Override // id.dana.utils.CircularRevealAnimationUtil.OnAnimationFinishedListener
    public void onUnRevealAnimationEnd() {
        Intent intent = new Intent();
        intent.putExtra(KEY_IS_SELECTED_UPGRADE_BUTTON, this.scheduleImpl);
        setResult(-1, intent);
        if (PlaceComponentResult(this.clContainer)) {
            this.clContainer.setVisibility(8);
        }
        finish();
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        CircularRevealAnimationUtil.PlaceComponentResult(this, this.clContainer, this);
    }

    private static void b(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (lookAheadTest ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = DatabaseTableConfigUtil;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (DatabaseTableConfigUtil[i3 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (lookAheadTest ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (NetworkUserEntityData$$ExternalSyntheticLambda1[i3 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (lookAheadTest ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (getErrorConfigVersion ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = DatabaseTableConfigUtil;
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
                    byte[] bArr5 = DatabaseTableConfigUtil;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = NetworkUserEntityData$$ExternalSyntheticLambda1;
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
