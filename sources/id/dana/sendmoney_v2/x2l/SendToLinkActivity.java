package id.dana.sendmoney_v2.x2l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.databinding.ActivitySendToLinkBinding;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.SendMoneyScenarioDirector;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.sendmoney_v2.x2l.model.SocialLinkModel;
import id.dana.utils.DateTimeUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0010\u0010\u0005R\u0013\u0010\u0014\u001a\u00020\u0011X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0017\u001a\u00020\u0015X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013"}, d2 = {"Lid/dana/sendmoney_v2/x2l/SendToLinkActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivitySendToLinkBinding;", "", "configToolbar", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivitySendToLinkBinding;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "lookAheadTest", "Lkotlin/Lazy;", "getAuthRequestContext", "Lid/dana/sendmoney/SendMoneyScenarioDirector;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "BuiltInFictitiousFunctionClassFactory", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendToLinkActivity extends ViewBindingActivity<ActivitySendToLinkBinding> {
    public static final byte[] $$a = {1, -107, Ascii.ESC, -41, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 62;
    public static final byte[] getAuthRequestContext = {11, Ascii.GS, 107, 8, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 247;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda2 = 4513;
    private static long DatabaseTableConfigUtil = 4360990799332652212L;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = -956812108;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<SendMoneyScenarioDirector>() { // from class: id.dana.sendmoney_v2.x2l.SendToLinkActivity$sendMoneyScenarioDirector$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyScenarioDirector invoke() {
            return new SendMoneyScenarioDirector(SendToLinkActivity.this);
        }
    });

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.sendmoney_v2.x2l.SendToLinkActivity$sendMoneyFeatureTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyFeatureTime invoke() {
            return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 55 - r7
            byte[] r0 = id.dana.sendmoney_v2.x2l.SendToLinkActivity.getAuthRequestContext
            int r6 = 23 - r6
            int r8 = r8 + 97
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r7
            goto L31
        L13:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r8 = r8 + 1
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L31:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.x2l.SendToLinkActivity.a(byte, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r0 = id.dana.sendmoney_v2.x2l.SendToLinkActivity.$$a
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r6 = 46 - r6
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L2e
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r6 = r6 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-7)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.x2l.SendToLinkActivity.c(int, int, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final View _$_findCachedViewById(int i) {
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{13281, 45408, 20061, 24196}, ViewConfiguration.getTapTimeout() >> 16, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 33870), new char[]{57073, 51079, 37336, 4929, 26179, 11198, 56735, 65444, 26104, 55871, 25678, 9810, 43097, 56701, 17406, 62565, 43366, 22085}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{57603, 8834, 46247, 64963}, (-1490910495) - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (50100 - View.MeasureSpec.getMode(0)), new char[]{26880, 63466, 34727, 25227, 32879}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{57833, 36965, 29604, 27194}, 1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), new char[]{62564, 60434, 12638, 62920, 28059, 55099, 42295, 56387, 44014, 64399, 7031, 34324, 64381, 61227, 29678, 35430, 25919, 33695, 9669, 25467, 48966, 55025, 25151, 35729, 43358, 8564, 38698, 44308, 42108, 31758, 2034, 61663, 20692, 46727, 32265, 25757, 64296, 48194, 12482, 35812, 20682, 37940, 9991, 7075, 43670, 62885, 26518, 35716}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{62764, 49628, 51236, 56429}, ViewConfiguration.getMinimumFlingVelocity() >> 16, (char) KeyEvent.keyCodeFromString(""), new char[]{45754, 54523, 57961, 8999, 14999, 59384, 6712, 7631, 29303, 32437, 17578, 28392, 64366, 27346, 41904, 39079, 35475, 19467, 42798, 27876, 11769, 34695, 54512, 49121, 5902, 58545, 50869, 24974, 61562, 46010, 11444, 37891, 24418, 13797, 12177, 19708, 1720, 3742, 14188, 15839, 37455, 11674, 58544, 13347, 65264, 49644, 7332, 51972, 61272, 27243, 16534, 53276, 33886, 40852, 39866, 56895, 17718, 53650, 27192, 28187, 3801, 65407, 49611, 770}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{38875, 47819, 12348, 65307}, KeyEvent.getMaxKeyCode() >> 16, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{1581, 50643, 56668, 46012, 15627, 12782, 58069, 30070, 24831, 18352, 9389, 50829, 45961, 64956, 36548, 31500, 43715, 43622, 4877, 11936, 41231, 60229, 23543, 43027, 561, 28414, 48186, 5592, 4062, 23760, 2924, 44679, 13943, 1089, 34978, 65287, 65145, 55663, 50276, 56940, 1786, 30852, 19856, 10110, 63286, 63015, 7422, 13971, 4432, 28038, 46536, 41627, 55335, 14346, 31055, 31154, 47698, 36227, 3432, 31974, 14305, 41803, 23976, 23031}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{45865, 23773, 18739, 16637}, ViewConfiguration.getScrollBarSize() >> 8, (char) ((Process.getThreadPriority(0) + 20) >> 6), new char[]{65042, 36546, 38759, 25950, 20739, 9325, 20225, 29304, 50364, 2795, 1079, 11981, 21363, 9698, 30211, 5371, 18933, 13140, 19948, 34967, 62715, 23475, 52870, 3032, 30197, 28199, 35600, 18171, 11374, 19162, 51123, 14064, 46015, 33449, 18972, 60890, 45624, 39594, 55653, 53463, 26648, 11995, 30524, 41047, 4340, 6732, 40028, 59977, 44043, 26961, 43227, 27814, 35130, 28741, 18195, 23163, 14789, 60110, 45587, 383}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{44847, 61706, 3168, 58988}, Color.alpha(0), (char) ((Process.myTid() >> 22) + 27660), new char[]{57785, 62032, 55800, 53339, 64500, 55513}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(getAuthRequestContext[30], (byte) (getAuthRequestContext[1] + 1), getAuthRequestContext[3], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getWindowTouchSlop() >> 8), AndroidCharacter.getMirror('0') - '-', (char) Color.red(0));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[53]), $$a[68], $$a[0], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 14 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) KeyEvent.getDeadChar(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 800, TextUtils.lastIndexOf("", '0') + 16, (char) Color.blue(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - ((byte) KeyEvent.getModifierMetaStateMask()), 28 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (57994 - Drawable.resolveOpacity(0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getKeyRepeatDelay() >> 16), Gravity.getAbsoluteGravity(0, 0) + 15, (char) KeyEvent.normalizeMetaState(0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {295919088, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = {this};
                Object[] objArr20 = new Object[1];
                a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                a(getAuthRequestContext[30], (byte) (getAuthRequestContext[1] + 1), getAuthRequestContext[3], objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.indexOf("", "", 0), 46 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr23 = new Object[1];
                        c($$a[20], (byte) (-$$a[8]), (byte) (-$$a[9]), objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), ImageFormat.getBitsPerPixel(0) + 36, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {295919088, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), Color.red(0) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
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
                Object[] objArr26 = {this};
                Object[] objArr27 = new Object[1];
                a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                a(getAuthRequestContext[30], (byte) (getAuthRequestContext[1] + 1), getAuthRequestContext[3], objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getWindowTouchSlop() >> 8) + 3, (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 38968));
                        Object[] objArr30 = new Object[1];
                        c($$a[20], (byte) (-$$a[8]), (byte) (-$$a[9]), objArr30);
                        obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                    int i2 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, 34 - Process.getGidForName(""), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {295919088, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr32);
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
                Object[] objArr33 = {this};
                Object[] objArr34 = new Object[1];
                a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                Object[] objArr35 = new Object[1];
                a(getAuthRequestContext[30], (byte) (getAuthRequestContext[1] + 1), getAuthRequestContext[3], objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 107, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 3, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        byte b = (byte) ($$a[0] - 1);
                        byte b2 = b;
                        Object[] objArr37 = new Object[1];
                        c(b, b2, b2, objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), TextUtils.indexOf("", "", 0) + 35, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {295919088, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr39);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_send_to_link;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Class<?> cls;
        Object[] objArr;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {0, 0, 0, 0};
            char[] cArr2 = {18101, 11944, 55273, 62248};
            int indexOf = TextUtils.indexOf((CharSequence) "", '0') + 1;
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr2 = new Object[1];
                a(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr2);
                cls = Class.forName((String) objArr2[0]);
                objArr = new Object[1];
                a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], objArr);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr3 = new Object[1];
                b(cArr, cArr2, indexOf, (char) (((ApplicationInfo) cls.getMethod((String) objArr[0], null).invoke(this, null)).targetSdkVersion + 10422), new char[]{33411, 22180, 53781, 14735, 41327, 22697, 34694, 21602, 7378, 6762, 61795, 3715, 41591, 14336, 36415, 60679, 17951, 1493, 61348, 15468, 46626, 22801, 8110, 16394, 55540, 20189}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(new char[]{0, 0, 0, 0}, new char[]{39871, 3135, 7596, 44567}, ViewConfiguration.getMaximumDrawingCacheSize() >> 24, (char) (5918 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), new char[]{60391, 24024, 44041, 45452, 37460, 61755, 54742, 65110, 6826, 27320, 13715, 34022, 22906, 65516, 52505, 10619, 10597, 28662}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), Color.green(0) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, Color.blue(0) + 18, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivitySendToLinkBinding initViewBinding() {
        ActivitySendToLinkBinding MyBillsEntityDataFactory = ActivitySendToLinkBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.sendmoney_summary_x2l_toolbar_title));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{18101, 11944, 55273, 62248}, super.getResources().getString(R.string.qcb_subtitle_jp).substring(0, 76).length() - 76, (char) (getPackageName().length() + 10448), new char[]{33411, 22180, 53781, 14735, 41327, 22697, 34694, 21602, 7378, 6762, 61795, 3715, 41591, 14336, 36415, 60679, 17951, 1493, 61348, 15468, 46626, 22801, 8110, 16394, 55540, 20189}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{39871, 3135, 7596, 44567}, getPackageName().codePointAt(5) - 110, (char) (super.getResources().getString(R.string.bill_empty_state_description).substring(10, 11).length() + 5916), new char[]{60391, 24024, 44041, 45452, 37460, 61755, 54742, 65110, 6826, 27320, 13715, 34022, 22906, 65516, 52505, 10619, 10597, 28662}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), TextUtils.getOffsetBefore("", 0) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) this.getAuthRequestContext.getValue();
        sendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("OPEN LINK LANDING PAGE", "");
        if (sendMoneyFeatureTime.getAuthRequestContext.get("OPEN LINK LANDING PAGE") == null) {
            long MyBillsEntityDataFactory = sendMoneyFeatureTime.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullParameter("OPEN LINK LANDING PAGE", "");
            sendMoneyFeatureTime.getAuthRequestContext.put("OPEN LINK LANDING PAGE", Long.valueOf(MyBillsEntityDataFactory));
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        getBinding().getAuthRequestContext.setOnSocialLinkSelected(new SendToLinkActivity$init$1$1(this));
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.sendmoney_v2.x2l.SendToLinkActivity$setOnBackListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = SendToLinkActivity.access$getSendMoneyFeatureTime(SendToLinkActivity.this);
                Intrinsics.checkNotNullParameter("OPEN LINK LANDING PAGE", "");
                access$getSendMoneyFeatureTime.getAuthRequestContext.remove("OPEN LINK LANDING PAGE");
                SendToLinkActivity.this.finish();
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
    }

    public static final /* synthetic */ SendMoneyFeatureTime access$getSendMoneyFeatureTime(SendToLinkActivity sendToLinkActivity) {
        return (SendMoneyFeatureTime) sendToLinkActivity.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ void access$onSocialLinkSelected(SendToLinkActivity sendToLinkActivity, SocialLinkModel socialLinkModel) {
        String str;
        Bundle bundleWithSource = sendToLinkActivity.getBundleWithSource();
        bundleWithSource.putString("recipientType", "chat");
        if ((!StringsKt.isBlank(socialLinkModel.PlaceComponentResult)) != false) {
            str = socialLinkModel.PlaceComponentResult;
        } else {
            str = socialLinkModel.getAuthRequestContext;
        }
        bundleWithSource.putString("iconUrl", str);
        bundleWithSource.putParcelable("socilaLink", socialLinkModel);
        SendMoneyScenarioDirector sendMoneyScenarioDirector = (SendMoneyScenarioDirector) sendToLinkActivity.BuiltInFictitiousFunctionClassFactory.getValue();
        Intrinsics.checkNotNullExpressionValue(bundleWithSource, "");
        sendMoneyScenarioDirector.KClassImpl$Data$declaredNonStaticMembers$2(bundleWithSource);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        char[] cArr = {0, 0, 0, 0};
        char[] cArr2 = {13281, 45408, 20061, 24196};
        int length = super.getResources().getString(R.string.payer).substring(0, 1).length() - 1;
        try {
            byte b = getAuthRequestContext[25];
            Object[] objArr2 = new Object[1];
            a(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], objArr3);
            Object[] objArr4 = new Object[1];
            b(cArr, cArr2, length, (char) (((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 33837), new char[]{57073, 51079, 37336, 4929, 26179, 11198, 56735, 65444, 26104, 55871, 25678, 9810, 43097, 56701, 17406, 62565, 43366, 22085}, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{57603, 8834, 46247, 64963}, super.getResources().getString(R.string.card_binding_success_save_card_text).substring(0, 5).length() - 1490910500, (char) (50101 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), new char[]{26880, 63466, 34727, 25227, 32879}, objArr5);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    char[] cArr3 = {0, 0, 0, 0};
                    char[] cArr4 = {18101, 11944, 55273, 62248};
                    int codePointAt = getPackageName().codePointAt(4) - 97;
                    try {
                        byte b2 = getAuthRequestContext[25];
                        Object[] objArr6 = new Object[1];
                        a(b2, (byte) (b2 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], objArr7);
                        Object[] objArr8 = new Object[1];
                        b(cArr3, cArr4, codePointAt, (char) (((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 10422), new char[]{33411, 22180, 53781, 14735, 41327, 22697, 34694, 21602, 7378, 6762, 61795, 3715, 41591, 14336, 36415, 60679, 17951, 1493, 61348, 15468, 46626, 22801, 8110, 16394, 55540, 20189}, objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b(new char[]{0, 0, 0, 0}, new char[]{39871, 3135, 7596, 44567}, super.getResources().getString(R.string.identity_tooltip_desc).substring(20, 22).codePointAt(0) - 110, (char) (5918 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), new char[]{60391, 24024, 44041, 45452, 37460, 61755, 54742, 65110, 6826, 27320, 13715, 34022, 22906, 65516, 52505, 10619, 10597, 28662}, objArr9);
                        baseContext = (Context) cls4.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr10 = new Object[1];
                        b(new char[]{0, 0, 0, 0}, new char[]{57833, 36965, 29604, 27194}, (-1) - TextUtils.lastIndexOf("", '0', 0, 0), (char) (super.getResources().getString(R.string.voucher_and_ticket_header_new_total_assets_nine_plus).substring(0, 3).length() - 3), new char[]{62564, 60434, 12638, 62920, 28059, 55099, 42295, 56387, 44014, 64399, 7031, 34324, 64381, 61227, 29678, 35430, 25919, 33695, 9669, 25467, 48966, 55025, 25151, 35729, 43358, 8564, 38698, 44308, 42108, 31758, 2034, 61663, 20692, 46727, 32265, 25757, 64296, 48194, 12482, 35812, 20682, 37940, 9991, 7075, 43670, 62885, 26518, 35716}, objArr10);
                        String str = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        b(new char[]{0, 0, 0, 0}, new char[]{62764, 49628, 51236, 56429}, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1, (char) (super.getResources().getString(R.string.upgrade_to_premium_message).substring(43, 44).length() - 1), new char[]{45754, 54523, 57961, 8999, 14999, 59384, 6712, 7631, 29303, 32437, 17578, 28392, 64366, 27346, 41904, 39079, 35475, 19467, 42798, 27876, 11769, 34695, 54512, 49121, 5902, 58545, 50869, 24974, 61562, 46010, 11444, 37891, 24418, 13797, 12177, 19708, 1720, 3742, 14188, 15839, 37455, 11674, 58544, 13347, 65264, 49644, 7332, 51972, 61272, 27243, 16534, 53276, 33886, 40852, 39866, 56895, 17718, 53650, 27192, 28187, 3801, 65407, 49611, 770}, objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        b(new char[]{0, 0, 0, 0}, new char[]{38875, 47819, 12348, 65307}, super.getResources().getString(R.string.merchant_review_negative_subtitle).substring(1, 2).length() - 1, (char) (super.getResources().getString(R.string.delete_photo).substring(9, 10).codePointAt(0) - 111), new char[]{1581, 50643, 56668, 46012, 15627, 12782, 58069, 30070, 24831, 18352, 9389, 50829, 45961, 64956, 36548, 31500, 43715, 43622, 4877, 11936, 41231, 60229, 23543, 43027, 561, 28414, 48186, 5592, 4062, 23760, 2924, 44679, 13943, 1089, 34978, 65287, 65145, 55663, 50276, 56940, 1786, 30852, 19856, 10110, 63286, 63015, 7422, 13971, 4432, 28038, 46536, 41627, 55335, 14346, 31055, 31154, 47698, 36227, 3432, 31974, 14305, 41803, 23976, 23031}, objArr12);
                        String str3 = (String) objArr12[0];
                        char[] cArr5 = {0, 0, 0, 0};
                        char[] cArr6 = {45865, 23773, 18739, 16637};
                        int i = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        try {
                            byte b3 = getAuthRequestContext[25];
                            Object[] objArr13 = new Object[1];
                            a(b3, (byte) (b3 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr13);
                            Class<?> cls5 = Class.forName((String) objArr13[0]);
                            a(getAuthRequestContext[41], getAuthRequestContext[25], getAuthRequestContext[5], new Object[1]);
                            Object[] objArr14 = new Object[1];
                            b(cArr5, cArr6, i, (char) (((ApplicationInfo) cls5.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{65042, 36546, 38759, 25950, 20739, 9325, 20225, 29304, 50364, 2795, 1079, 11981, 21363, 9698, 30211, 5371, 18933, 13140, 19948, 34967, 62715, 23475, 52870, 3032, 30197, 28199, 35600, 18171, 11374, 19162, 51123, 14064, 46015, 33449, 18972, 60890, 45624, 39594, 55653, 53463, 26648, 11995, 30524, 41047, 4340, 6732, 40028, 59977, 44043, 26961, 43227, 27814, 35130, 28741, 18195, 23163, 14789, 60110, 45587, 383}, objArr14);
                            String str4 = (String) objArr14[0];
                            Object[] objArr15 = new Object[1];
                            b(new char[]{0, 0, 0, 0}, new char[]{44847, 61706, 3168, 58988}, Color.alpha(0), (char) (super.getResources().getString(R.string.investment_me_desc_non_registered).substring(0, 5).codePointAt(3) + 27559), new char[]{57785, 62032, 55800, 53339, 64500, 55513}, objArr15);
                            try {
                                Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (Process.myTid() >> 22) + 18, (char) (Process.getGidForName("") + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr16);
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
                Object[] objArr17 = new Object[1];
                a(getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), (byte) (-getAuthRequestContext[32]), objArr17);
                Class<?> cls6 = Class.forName((String) objArr17[0]);
                Object[] objArr18 = new Object[1];
                a(getAuthRequestContext[30], (byte) (getAuthRequestContext[1] + 1), getAuthRequestContext[3], objArr18);
                try {
                    Object[] objArr19 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.indexOf("", ""), 4 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) TextUtils.getOffsetBefore("", 0));
                        byte b4 = (byte) ($$a[0] - 1);
                        byte b5 = b4;
                        Object[] objArr20 = new Object[1];
                        c(b4, b5, b5, objArr20);
                        obj3 = cls7.getMethod((String) objArr20[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                    int i2 = ((int[]) objArr21[1])[0];
                    if (((int[]) objArr21[0])[0] != i2) {
                        long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 'S' - AndroidCharacter.getMirror('0'), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr22 = {1944303889, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), Color.rgb(0, 0, 0) + 16777234, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr22);
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
                    ((SendMoneyFeatureTime) this.getAuthRequestContext.getValue()).getAuthRequestContext();
                    ((SendMoneyFeatureTime) this.getAuthRequestContext.getValue()).lookAheadTest = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    super.onCreate(savedInstanceState);
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
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (DatabaseTableConfigUtil ^ 4360990799332652212L)) ^ ((int) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 4360990799332652212L))) ^ ((char) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
