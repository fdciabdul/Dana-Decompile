package id.dana.animation;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.richview.PaymentCardsView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.util.RaspUtils;
import id.dana.utils.SizeUtil;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

/* loaded from: classes8.dex */
public class WalletActivity extends BaseActivity {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public static final byte[] PlaceComponentResult;
    public static final int getAuthRequestContext;
    private static char getErrorConfigVersion;
    private static char[] lookAheadTest;
    private static long scheduleImpl;
    @BindView(R.id.cl_list_card)
    ConstraintLayout clListCard;
    @BindView(R.id.pcv_cards)
    PaymentCardsView pcvCards;
    public static final byte[] $$a = {121, 107, -47, -24, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 139;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;

    static {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        getAuthRequestContext();
        PlaceComponentResult = new byte[]{11, Ascii.GS, 107, 8, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        getAuthRequestContext = 147;
        getErrorConfigVersion = (char) 42066;
        lookAheadTest = new char[]{37372, 37356, 37290, 37353, 37368, 37306, 37348, 37309, 37370, 37366, 37288, 37281, 37291, 37275, 37308, 37365, 37282, 37302, 37346, 37359, 37293, 37371, 37311, 37286, 37262, 37289, 37345, 37344, 37373, 37274, 37351, 37292, 37374, 37279, 37349, 37367, 37350, 37294, 37280, 37347, 37369, 37307, 37305, 37375, 37287, 37357, 37283, 37310, 37358};
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 119;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 != 0 ? 'c' : (char) 22) != 'c') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0037 -> B:12:0x003b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 16
            byte[] r0 = id.dana.animation.WalletActivity.PlaceComponentResult     // Catch: java.lang.Exception -> L51
            int r7 = 106 - r7
            int r9 = 55 - r9
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L12
            r4 = 0
            goto L13
        L12:
            r4 = 1
        L13:
            if (r4 == 0) goto L1d
            r4 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r6 = r8
            r8 = r7
            r7 = r6
            goto L3b
        L1d:
            int r7 = id.dana.animation.WalletActivity.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r7 = r7 + 37
            int r4 = r7 % 128
            id.dana.animation.WalletActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = r4
            int r7 = r7 % 2
            int r7 = id.dana.animation.WalletActivity.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r7 = r7 + 53
            int r4 = r7 % 128
            id.dana.animation.WalletActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4
            int r7 = r7 % 2
            r7 = r8
            r4 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
        L37:
            int r8 = r8 + r9
            int r8 = r8 + (-4)
            r9 = r10
        L3b:
            byte r10 = (byte) r8
            int r9 = r9 + r2
            r4[r5] = r10
            if (r5 != r7) goto L49
            java.lang.String r7 = new java.lang.String
            r7.<init>(r4, r3)
            r0[r3] = r7
            return
        L49:
            int r5 = r5 + 1
            r10 = r1[r9]
            r6 = r10
            r10 = r9
            r9 = r6
            goto L37
        L51:
            r7 = move-exception
            goto L54
        L53:
            throw r7
        L54:
            goto L53
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.WalletActivity.c(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.animation.WalletActivity.$$a
            int r7 = r7 + 4
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L1b:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1f:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r8 = r8 + 1
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.WalletActivity.g(byte, int, short, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        scheduleImpl = 1042057950077202059L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x007b, code lost:
    
        if (r4 > 99999) goto L6;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r27) {
        /*
            Method dump skipped, instructions count: 3012
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.WalletActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 != 0 ? (char) 14 : '3') != '3') {
            int i2 = 70 / 0;
            return super.getApplicationContext();
        }
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        Context baseContext = super.getBaseContext();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return baseContext;
        }
        Object obj = null;
        obj.hashCode();
        return baseContext;
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? ':' : (char) 3) == ':') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        return R.layout.activity_wallet;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        Resources resources = super.getResources();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 89;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return resources;
        }
        return resources;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00d4, code lost:
    
        if (r2 > 99999) goto L13;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r25) {
        /*
            Method dump skipped, instructions count: 1830
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.WalletActivity.onCreate(android.os.Bundle):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Class<?> cls;
        int codePointAt;
        Class<?> cls2;
        Context baseContext = getBaseContext();
        Object obj = null;
        if (baseContext == null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if ((i % 2 != 0 ? 'K' : '0') != '0') {
                Object[] objArr = new Object[1];
                b((byte) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) * 2), new char[]{'\'', '\t', '\r', '\b', '%', 24, 19, '!', Typography.dollar, 23, 23, 27, 31, Typography.amp, '%', 27, ',', 21, Typography.amp, 20, '\t', '0', '\t', 0, '(', '\t'}, 42 / ImageFormat.getBitsPerPixel(0), objArr);
                cls = Class.forName((String) objArr[0]);
                codePointAt = 95 - getPackageName().codePointAt(5);
            } else {
                Object[] objArr2 = new Object[1];
                b((byte) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 117), new char[]{'\'', '\t', '\r', '\b', '%', 24, 19, '!', Typography.dollar, 23, 23, 27, 31, Typography.amp, '%', 27, ',', 21, Typography.amp, 20, '\t', '0', '\t', 0, '(', '\t'}, ImageFormat.getBitsPerPixel(0) + 27, objArr2);
                cls = Class.forName((String) objArr2[0]);
                codePointAt = getPackageName().codePointAt(5) - 33;
            }
            byte b = (byte) codePointAt;
            char[] cArr = {'!', 3, 13877, 13877, 4, '\t', Typography.amp, 27, 13879, 13879, ',', 25, 30, Typography.amp, '%', 27, '\'', '\n'};
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 15;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
            int i3 = i2 % 2;
            try {
                Object[] objArr3 = new Object[1];
                c(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[59] + 1), objArr3);
                cls2 = Class.forName((String) objArr3[0]);
                c(PlaceComponentResult[13], PlaceComponentResult[56], PlaceComponentResult[25], new Object[1]);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr4 = new Object[1];
                b(b, cArr, ((ApplicationInfo) cls2.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 15, objArr4);
                baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            } catch (Throwable th2) {
                th = th2;
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (!(baseContext == null)) {
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i4 % 128;
            char c = i4 % 2 == 0 ? ';' : '\r';
            baseContext = baseContext.getApplicationContext();
            if (c == ';') {
                obj.hashCode();
            }
        }
        if (baseContext != null) {
            try {
                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj2 == null) {
                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getTouchSlop() >> 8) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                }
                Object invoke = ((Method) obj2).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj3 == null) {
                        obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj3);
                    }
                    ((Method) obj3).invoke(invoke, objArr5);
                    int i5 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 95;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
                    int i6 = i5 % 2;
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r0 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        r0 = id.dana.animation.WalletActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 + 19;
        id.dana.animation.WalletActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = r0 % 128;
        r0 = r0 % 2;
        r8 = new java.lang.Object[1];
        b((byte) (super.getResources().getString(id.dana.R.string.express_pay_desc_gpn).substring(38, 39).codePointAt(0) + 85), new char[]{'\'', '\t', '\r', '\b', '%', 24, 19, '!', kotlin.text.Typography.dollar, 23, 23, 27, 31, kotlin.text.Typography.amp, '%', 27, ',', 21, kotlin.text.Typography.amp, 20, '\t', '0', '\t', 0, '(', '\t'}, super.getResources().getString(id.dana.R.string.group_send_type_bank).substring(4, 5).codePointAt(0) - 6, r8);
        r0 = java.lang.Class.forName((java.lang.String) r8[0]);
        r9 = new java.lang.Object[1];
        b((byte) (77 - android.graphics.Color.argb(0, 0, 0, 0)), new char[]{'!', 3, 13877, 13877, 4, '\t', kotlin.text.Typography.amp, 27, 13879, 13879, ',', 25, 30, kotlin.text.Typography.amp, '%', 27, '\'', '\n'}, android.view.Gravity.getAbsoluteGravity(0, 0) + 18, r9);
        r0 = (android.content.Context) r0.getMethod((java.lang.String) r9[0], new java.lang.Class[0]).invoke(null, null);
        r6 = id.dana.animation.WalletActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 + 83;
        id.dana.animation.WalletActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r0 == null) goto L12;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.WalletActivity.onResume():void");
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        KClassImpl$Data$declaredNonStaticMembers$2();
        try {
            this.pcvCards.setEntryPoint(TopupSource.DANA_WALLET);
            this.pcvCards.post(new Runnable() { // from class: id.dana.home.WalletActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    WalletActivity.this.m2622lambda$init$0$iddanahomeWalletActivity();
                }
            });
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 125;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if (i % 2 != 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$0$id-dana-home-WalletActivity  reason: not valid java name */
    public /* synthetic */ void m2622lambda$init$0$iddanahomeWalletActivity() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 57;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if ((i % 2 != 0 ? 'Z' : '1') == '1') {
                PaymentCardsView paymentCardsView = this.pcvCards;
                paymentCardsView.setParentPosY(SizeUtil.KClassImpl$Data$declaredNonStaticMembers$2(paymentCardsView));
                return;
            }
            PaymentCardsView paymentCardsView2 = this.pcvCards;
            paymentCardsView2.setParentPosY(SizeUtil.KClassImpl$Data$declaredNonStaticMembers$2(paymentCardsView2));
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.DANA_WALLET_OPEN;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                if ((i % 2 != 0 ? (byte) 1 : (byte) 0) != 1) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.view_close_click_area})
    public void closeActivity() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            this.pcvCards.closeClicked();
            objArr.hashCode();
        } else {
            this.pcvCards.closeClicked();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
        if (i2 % 2 == 0) {
            int length = objArr.length;
        }
    }

    public static void ktujKpdUad(long j, long j2) {
        long j3 = j ^ (j2 << 32);
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        a(Color.alpha(0) + 1, new char[]{5846, 24374, 5823, 15419, 3775, 51231, 13822, 8120, 39776, 45049}, objArr);
        sb.append((String) objArr[0]);
        sb.append(j3);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
        RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
        Intrinsics.checkNotNullParameter(dexguardException, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(dexguardException);
        RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.EMULATOR);
        UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.EMULATOR);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 19;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
    }

    private static void b(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        try {
            char[] cArr2 = lookAheadTest;
            if ((cArr2 != null ? 'O' : (char) 23) != 23) {
                int i3 = $11 + 115;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = $11 + 117;
                    $10 = i6 % 128;
                    if (i6 % 2 != 0) {
                        cArr3[i5] = (char) (cArr2[i5] & (-1549216646985767851L));
                        i5 >>>= 0;
                    } else {
                        cArr3[i5] = (char) (cArr2[i5] ^ (-1549216646985767851L));
                        i5++;
                    }
                }
                cArr2 = cArr3;
            }
            try {
                char c = (char) (getErrorConfigVersion ^ (-1549216646985767851L));
                char[] cArr4 = new char[i];
                if (i % 2 != 0) {
                    i2 = i - 1;
                    cArr4[i2] = (char) (cArr[i2] - b);
                } else {
                    i2 = i;
                }
                if (i2 > 1) {
                    int i7 = $11 + 125;
                    $10 = i7 % 128;
                    int i8 = i7 % 2;
                    getcallingpid.getAuthRequestContext = 0;
                    while (true) {
                        if (getcallingpid.getAuthRequestContext >= i2) {
                            break;
                        }
                        getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                        getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                        if (!(getcallingpid.MyBillsEntityDataFactory != getcallingpid.PlaceComponentResult)) {
                            int i9 = $11 + 99;
                            $10 = i9 % 128;
                            if (!(i9 % 2 == 0)) {
                                cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory / b);
                                cArr4[getcallingpid.getAuthRequestContext - 0] = (char) (getcallingpid.PlaceComponentResult + b);
                            } else {
                                cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                                cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                            }
                        } else {
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                            getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                            getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                            if ((getcallingpid.scheduleImpl == getcallingpid.lookAheadTest ? (char) 27 : Typography.less) == 27) {
                                getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                                getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                                int i10 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                int i11 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i10];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i11];
                            } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                                getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                                getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                                int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                            } else {
                                int i14 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                                int i15 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i14];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i15];
                            }
                        }
                        getcallingpid.getAuthRequestContext += 2;
                    }
                }
                int i16 = $11 + 107;
                $10 = i16 % 128;
                int i17 = i16 % 2;
                for (int i18 = 0; i18 < i; i18++) {
                    cArr4[i18] = (char) (cArr4[i18] ^ 13722);
                }
                objArr[0] = new String(cArr4);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        try {
            char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(scheduleImpl ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            int i2 = $11 + 111;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length ? '?' : '@') != '@') {
                    int i4 = $11 + 103;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (scheduleImpl ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                } else {
                    objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                    return;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
