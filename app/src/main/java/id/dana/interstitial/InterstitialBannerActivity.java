package id.dana.interstitial;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.widget.ImageView;
import android.widget.TextView;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.core.ui.glide.GlideApp;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.databinding.ActivityInterstitialBannerBinding;
import id.dana.model.CdpContentModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.LogoProgressView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.BitmapUtil;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ImageOss;
import id.dana.utils.LocaleUtil;
import id.dana.utils.SizeUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/interstitial/InterstitialBannerActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityInterstitialBannerBinding;", "", IAPSyncCommand.COMMAND_INIT, "()V", "initViewBinding", "()Lid/dana/databinding/ActivityInterstitialBannerBinding;", "", "p0", "PlaceComponentResult", "(Z)V", "Lid/dana/model/CdpContentModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/model/CdpContentModel;", "MyBillsEntityDataFactory", "", "lookAheadTest", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InterstitialBannerActivity extends ViewBindingActivity<ActivityInterstitialBannerBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] DatabaseTableConfigUtil = null;
    public static final String KEY_BANNERREAD = "bannerRead";
    public static final String KEY_CDPCONTENTMODEL = "cdpContentModel";
    public static final String KEY_SPACECODE = "spaceCode";
    private static long initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private CdpContentModel MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2 = "";
    public static final byte[] $$a = {Ascii.EM, 16, -94, Ascii.FS, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 237;
    public static final byte[] getAuthRequestContext = {14, -73, -90, 103, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 218;

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        DatabaseTableConfigUtil = new char[]{62255, 44155, 19868, 60717, 36429, 12256, 53000, 26653, 2551, 43277, 19120, 60297, 35659, 9394, 50624, 25970, 1672, 42540, 18268, 57590, 32774, 8529, 49902, 25094, 935, 48329, 62253, 44128, 19850, 60717, 36423, 12263, 53016, 26738, 2534, 43277, 19116, 60366, 35689, 9392, 50624, 25970, 1681, 42539, 7469, 17017, 41886, 815, 24655, 49634, 8458, 34335, 59387, 18188, 42220, 1525, 25978, 51900, 11221, 35708, 59535, 18484, 6417, 18014, 42911, 1796, 25716, 13038, 28129, 35929, 11504, 20357, 61050, 3778, 43420, 51254, 26767, 35636, 10838, 19192, 58740, 1042, 42170, 51032, 26595, 34441, 8569, 16801, 57549, 872, 41922, 49717, 32009, 40415, 15396, 24351, 65522, 7698, 48825, 55680, 30804, 39165, 15249, 23155, 64199, 5475, 46132, 54486, 30508, 38403, 13990, 20767, 61461, 4277, 45833, 24719, 16256, 56942, 32411, 7652, 48144, 23804, 64427, 39506, 15038, 55641, 30770, 6350, 46912, 22053, 63119, 38252, 13783, 54510, 29470, 5014, 45736, 20746, 61936, 36944, 12143, 53225, 28178, 3362, 44485, 19574, 60633, 35821, 10801, 51916, 27047, 2113, 43178, 18268, 58880, 34531, 9549, 50277, 25750, 809, 41510, 17029, 57708, 33229, 8374, 65311, 40950, 16043, 56590, 32236, 7250, 47926, 23452, 64019, 39285, 14731, 55417, 30848, 6072, 62332, 44068, 19869, 60733, 36379, 12222, 53086, 26631, 2478, 43333, 19192, 60310, 35643, 9442, 50564, 25900, 1695, 42528, 18204, 57579, 32864, 8539, 49917, 25168, 1009, 48331, 23625, 65007, 40668, 15975, 57299, 32552, 6169, 47505, 22890, 64007, 39904, 15198, 54522, 30123, 5454, 46779, 22417, 63283, 37074, 12673, 53621, 29337, 4664, 45852, 27883, 3082, 44288, 20136, 60954, 36854, 10385, 51256, 27113, 2689, 43644, 19412, 60273, 33810, 46865, 59478, 2491, 43288, 51814, 27524, 35700, 11307, 19909, 60715, 3737, 45041, 53011, 24722, 33259, 8542, 17068, 57875, 875, 42203, 50180, 25981, 34527, 9850, 18326, 63727, 6182, 47506, 56041, 31301, 39842, 15113, 23672, 64944, 7434, 48678, 57302, 32561, 37014, 12683, 20768, 62106, 5118, 45855, 54452, 30184, 38212, 13993, 22042, 63334, 10384, 18478, 59703, 2689, 43566, 52098, 27892, 35924, 11667, 20211, 15510, 25562, 33325, 8848, 16881, 57433};
        initRecordTimeStamp = -366556029554349035L;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r8, short r9, int r10, java.lang.Object[] r11) {
        /*
            int r10 = r10 + 16
            int r9 = 106 - r9
            int r8 = 56 - r8
            byte[] r0 = id.dana.interstitial.InterstitialBannerActivity.getAuthRequestContext
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L14
            r9 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L2f
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r10) goto L24
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L24:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L2f:
            int r8 = r8 + r10
            int r9 = r9 + 1
            int r8 = r8 + (-4)
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.interstitial.InterstitialBannerActivity.b(short, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r9 = 46 - r9
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r0 = id.dana.interstitial.InterstitialBannerActivity.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r4 = 0
            r8 = r7
            goto L2c
        L15:
            r3 = 0
        L16:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            int r9 = r9 + 1
            r1[r3] = r5
            if (r4 != r7) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r6
        L2c:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + (-7)
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.interstitial.InterstitialBannerActivity.c(int, int, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createIntent(BaseActivity baseActivity, CdpContentModel cdpContentModel, String str) {
        return Companion.MyBillsEntityDataFactory(baseActivity, cdpContentModel, str);
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
        a(TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 43, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 60930), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 5, Color.blue(0) + 62, (char) (59953 - TextUtils.indexOf((CharSequence) "", '0')), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((Process.myPid() >> 22) + 48, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 67, (char) (49559 - TextUtils.getTrimmedLength("")), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - KeyEvent.normalizeMetaState(0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 115, (char) (37792 - (Process.myTid() >> 22)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(TextUtils.getCapsMode("", 0, 0) + 64, 179 - View.combineMeasuredStates(0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 60, TextUtils.getCapsMode("", 0, 0) + 243, (char) (TextUtils.getOffsetAfter("", 0) + 17463), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((Process.myPid() >> 22) + 6, 303 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (53216 - Process.getGidForName("")), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 17 - Process.getGidForName(""), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = getAuthRequestContext[31];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (getAuthRequestContext[34] + 1), getAuthRequestContext[7], getAuthRequestContext[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 55, 2 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                        byte b3 = $$a[47];
                        Object[] objArr16 = new Object[1];
                        c(b3, b3, (byte) (-$$a[53]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, ((Process.getThreadPriority(0) + 20) >> 6) + 15, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 800, 15 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 814, 29 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (57994 - View.resolveSize(0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 800, View.MeasureSpec.getSize(0) + 15, (char) Gravity.getAbsoluteGravity(0, 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), 35 - View.MeasureSpec.getSize(0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {689567041, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, View.MeasureSpec.getSize(0) + 18, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = getAuthRequestContext[31];
                byte b5 = getAuthRequestContext[25];
                Object[] objArr19 = new Object[1];
                b(b4, b5, b5, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (getAuthRequestContext[34] + 1), getAuthRequestContext[7], getAuthRequestContext[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.getDefaultSize(0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 46, (char) ((-1) - TextUtils.lastIndexOf("", '0')));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[9]), $$a[20], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), 35 - TextUtils.getCapsMode("", 0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {689567041, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myTid() >> 22), 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = getAuthRequestContext[31];
                byte b7 = getAuthRequestContext[25];
                Object[] objArr25 = new Object[1];
                b(b6, b7, b7, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (getAuthRequestContext[34] + 1), getAuthRequestContext[7], getAuthRequestContext[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16777098) - Color.rgb(0, 0, 0), (ViewConfiguration.getTouchSlop() >> 8) + 3, (char) (38968 - View.MeasureSpec.makeMeasureSpec(0, 0)));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[9]), $$a[20], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {689567041, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b8 = getAuthRequestContext[31];
                byte b9 = getAuthRequestContext[25];
                Object[] objArr31 = new Object[1];
                b(b8, b9, b9, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (getAuthRequestContext[34] + 1), getAuthRequestContext[7], getAuthRequestContext[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0, 0) + 4, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        byte b10 = (byte) (-$$a[8]);
                        byte b11 = (byte) ($$a[47] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b10, b11, b11, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {689567041, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            b((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            b(getAuthRequestContext[25], getAuthRequestContext[13], getAuthRequestContext[56], new Object[1]);
            Object[] objArr3 = new Object[1];
            a(((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15, super.getResources().getString(R.string.location).substring(0, 2).codePointAt(1) - 67, (char) (60930 - Gravity.getAbsoluteGravity(0, 0)), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(super.getResources().getString(R.string.request_money_card_add_bank_title).substring(14, 15).codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS, super.getResources().getString(R.string.res_0x7f13059c_networkuserentitydata_externalsyntheticlambda7).substring(4, 5).codePointAt(0) + 29, (char) (super.getResources().getString(R.string.contact_no_permission_desc).substring(77, 80).codePointAt(1) + 59837), objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        Object[] objArr5 = new Object[1];
                        b((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        b(getAuthRequestContext[25], getAuthRequestContext[13], getAuthRequestContext[56], objArr6);
                        int i = ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion - 7;
                        int codePointAt = super.getResources().getString(R.string.my_bills_label_incorrect_phone_number).substring(3, 5).codePointAt(1) - 114;
                        try {
                            Object[] objArr7 = new Object[1];
                            b((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            b(getAuthRequestContext[25], getAuthRequestContext[13], getAuthRequestContext[56], new Object[1]);
                            Object[] objArr8 = new Object[1];
                            a(i, codePointAt, (char) (((ApplicationInfo) cls4.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 33), objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            a((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, super.getResources().getString(R.string.mybills_title_mobile_recharge).substring(11, 12).length() + 25, (char) ((-1) - Process.getGidForName("")), objArr9);
                            baseContext = (Context) cls5.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr10 = new Object[1];
                        a(getPackageName().codePointAt(1) - 52, View.combineMeasuredStates(0, 0) + 67, (char) (super.getResources().getString(R.string.family_account_text_invite_now).substring(1, 2).length() + 49558), objArr10);
                        String str = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(getPackageName().codePointAt(6) - 33, 115 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (super.getResources().getString(R.string.session_expired).substring(70, 73).length() + 37789), objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(getPackageName().codePointAt(2) + 18, 179 - TextUtils.indexOf("", "", 0, 0), (char) ((-16777216) - Color.rgb(0, 0, 0)), objArr12);
                        String str3 = (String) objArr12[0];
                        int i2 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 60;
                        try {
                            Object[] objArr13 = new Object[1];
                            b((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), objArr13);
                            Class<?> cls6 = Class.forName((String) objArr13[0]);
                            Object[] objArr14 = new Object[1];
                            b(getAuthRequestContext[25], getAuthRequestContext[13], getAuthRequestContext[56], objArr14);
                            Object[] objArr15 = new Object[1];
                            a(i2, ((ApplicationInfo) cls6.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 210, (char) (super.getResources().getString(R.string.btn_activate_onboarding_paylater_cicil).substring(2, 6).length() + 17459), objArr15);
                            String str4 = (String) objArr15[0];
                            Object[] objArr16 = new Object[1];
                            a(AndroidCharacter.getMirror('0') - '*', super.getResources().getString(R.string.daily_check_prompt_text).substring(9, 10).length() + 302, (char) (super.getResources().getString(R.string.bottom_on_boarding_title_send_money).substring(0, 2).length() + 53215), objArr16);
                            try {
                                Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), 18 - View.combineMeasuredStates(0, 0), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr17);
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
            }
            try {
                byte b = getAuthRequestContext[31];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr18 = new Object[1];
                b(b, b2, b2, objArr18);
                Class<?> cls7 = Class.forName((String) objArr18[0]);
                Object[] objArr19 = new Object[1];
                b((byte) (getAuthRequestContext[34] + 1), getAuthRequestContext[7], getAuthRequestContext[25], objArr19);
                try {
                    Object[] objArr20 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Gravity.getAbsoluteGravity(0, 0), 4 - TextUtils.getOffsetBefore("", 0), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                        byte b3 = (byte) (-$$a[8]);
                        byte b4 = (byte) ($$a[47] - 1);
                        Object[] objArr21 = new Object[1];
                        c(b3, b4, b4, objArr21);
                        obj3 = cls8.getMethod((String) objArr21[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                    int i3 = ((int[]) objArr22[1])[0];
                    if (((int[]) objArr22[0])[0] != i3) {
                        long j = ((r2 ^ i3) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr23 = {2048662510, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), View.MeasureSpec.getSize(0) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr23);
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
                    super.onCreate(bundle);
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
        } catch (Throwable th10) {
            Throwable cause10 = th10.getCause();
            if (cause10 == null) {
                throw th10;
            }
            throw cause10;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(Process.getGidForName("") + 27, getPackageName().codePointAt(4) - 97, (char) TextUtils.getOffsetAfter("", 0), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.pin_incorrect_lock_desc).substring(37, 38).length() + 17, super.getResources().getString(R.string.unsafe_device_tamper_image_title).substring(5, 6).codePointAt(0) - 71, (char) (getPackageName().codePointAt(4) - 97), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (Process.myTid() >> 22), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 18 - Color.green(0), (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int length = super.getResources().getString(R.string.negative_referral_engagement_dialog_button).substring(1, 2).length() + 25;
            int length2 = getPackageName().length() - 7;
            try {
                Object[] objArr = new Object[1];
                b((byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(getAuthRequestContext[25], getAuthRequestContext[13], getAuthRequestContext[56], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(length, length2, (char) (((ApplicationInfo) cls.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(super.getResources().getString(R.string.family_address_questionary_text).substring(0, 1).codePointAt(0) - 47, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), View.resolveSizeAndState(0, 0, 0) + 35, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, View.MeasureSpec.makeMeasureSpec(0, 0) + 18, (char) KeyEvent.keyCodeFromString(""))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityInterstitialBannerBinding initViewBinding() {
        ActivityInterstitialBannerBinding KClassImpl$Data$declaredNonStaticMembers$2 = ActivityInterstitialBannerBinding.KClassImpl$Data$declaredNonStaticMembers$2(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void PlaceComponentResult(boolean p0) {
        Intent intent = new Intent();
        intent.putExtra(KEY_CDPCONTENTMODEL, this.MyBillsEntityDataFactory);
        intent.putExtra("spaceCode", this.KClassImpl$Data$declaredNonStaticMembers$2);
        intent.putExtra(KEY_BANNERREAD, p0);
        setResult(-1, intent);
        finish();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\f"}, d2 = {"Lid/dana/interstitial/InterstitialBannerActivity$Companion;", "", "Lid/dana/base/BaseActivity;", "p0", "Lid/dana/model/CdpContentModel;", "p1", "", "p2", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Lid/dana/base/BaseActivity;Lid/dana/model/CdpContentModel;Ljava/lang/String;)Landroid/content/Intent;", "KEY_BANNERREAD", "Ljava/lang/String;", "KEY_CDPCONTENTMODEL", "KEY_SPACECODE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(BaseActivity p0, CdpContentModel p1, String p2) {
            Intent intent = new Intent(p0, InterstitialBannerActivity.class);
            intent.putExtra(InterstitialBannerActivity.KEY_CDPCONTENTMODEL, p1);
            intent.putExtra("spaceCode", p2);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$3fcZE_zl2CBjrgD99Q-JT5O26HI */
    public static /* synthetic */ void m2632$r8$lambda$3fcZE_zl2CBjrgD99QJT5O26HI(InterstitialBannerActivity interstitialBannerActivity, View view) {
        Intrinsics.checkNotNullParameter(interstitialBannerActivity, "");
        interstitialBannerActivity.PlaceComponentResult(false);
    }

    /* renamed from: $r8$lambda$46oyyu303_p2WR4xnuh18r8E-tU */
    public static /* synthetic */ void m2633$r8$lambda$46oyyu303_p2WR4xnuh18r8EtU(final InterstitialBannerActivity interstitialBannerActivity, String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(interstitialBannerActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(imageView, "");
        MixPanelTracker.getAuthRequestContext(TrackerKey.Event.INTERSTITIAL_BANNER_DOWNLOAD_FINISH);
        GlideApp.PlaceComponentResult(interstitialBannerActivity).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new RoundedCorners(SizeUtil.getAuthRequestContext(8))).BuiltInFictitiousFunctionClassFactory(str).getErrorConfigVersion((int) R.drawable.bg_white).BuiltInFictitiousFunctionClassFactory(new RequestListener<Bitmap>() { // from class: id.dana.interstitial.InterstitialBannerActivity$setImage$1
            @Override // com.bumptech.glide.request.RequestListener
            public final /* synthetic */ boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
                return MyBillsEntityDataFactory(bitmap, obj, target, dataSource);
            }

            @Override // com.bumptech.glide.request.RequestListener
            public final boolean onLoadFailed(GlideException p0, Object p1, Target<Bitmap> p2, boolean p3) {
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                InterstitialBannerActivity.access$dismissProgress(InterstitialBannerActivity.this);
                return false;
            }

            private boolean MyBillsEntityDataFactory(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource) {
                Intrinsics.checkNotNullParameter(obj, "");
                Intrinsics.checkNotNullParameter(target, "");
                Intrinsics.checkNotNullParameter(dataSource, "");
                InterstitialBannerActivity.access$dismissProgress(InterstitialBannerActivity.this);
                InterstitialBannerActivity.access$trackInterstitialBanner(InterstitialBannerActivity.this, bitmap);
                return false;
            }
        }).MyBillsEntityDataFactory(imageView);
    }

    /* renamed from: $r8$lambda$FVeiI_-jWma5kcwWHO7QMLh1Nm4 */
    public static /* synthetic */ void m2634$r8$lambda$FVeiI_jWma5kcwWHO7QMLh1Nm4(InterstitialBannerActivity interstitialBannerActivity, View view) {
        Intrinsics.checkNotNullParameter(interstitialBannerActivity, "");
        interstitialBannerActivity.PlaceComponentResult(true);
    }

    public static /* synthetic */ void $r8$lambda$QfqdsBUqE8nfrWjsnwLSb7nvoz8(InterstitialBannerActivity interstitialBannerActivity, View view) {
        Intrinsics.checkNotNullParameter(interstitialBannerActivity, "");
        interstitialBannerActivity.PlaceComponentResult(false);
    }

    public static final /* synthetic */ void access$dismissProgress(InterstitialBannerActivity interstitialBannerActivity) {
        TextView textView = interstitialBannerActivity.getBinding().getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(8);
        LogoProgressView logoProgressView = interstitialBannerActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(logoProgressView, "");
        logoProgressView.setVisibility(8);
        interstitialBannerActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.stopRefresh();
    }

    public static final /* synthetic */ void access$trackInterstitialBanner(InterstitialBannerActivity interstitialBannerActivity, Bitmap bitmap) {
        CdpContentModel cdpContentModel = interstitialBannerActivity.MyBillsEntityDataFactory;
        if (cdpContentModel != null) {
            int PlaceComponentResult2 = BitmapUtil.PlaceComponentResult(bitmap) / 1024;
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(interstitialBannerActivity.getBaseContext().getApplicationContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.INTERSTITIAL_BANNER_DOWNLOAD_FINISH;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_ID, cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_TYPE, cdpContentModel.DatabaseTableConfigUtil).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_NAME, cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_SPACE_CODE, interstitialBannerActivity.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult(TrackerKey.PromotionProperty.FILE_SIZE, PlaceComponentResult2).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.BANNER_URL, cdpContentModel.GetContactSyncConfig);
            if (cdpContentModel.PrepareContext != null) {
                MyBillsEntityDataFactory.MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_EXPIRY_DATE, DateTimeUtil.MyBillsEntityDataFactory(cdpContentModel.PrepareContext, "yyyy-MM-dd'T'HH:mm:ss", LocaleUtil.getAuthRequestContext()));
            }
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.interstitial.InterstitialBannerActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterstitialBannerActivity.m2632$r8$lambda$3fcZE_zl2CBjrgD99QJT5O26HI(InterstitialBannerActivity.this, view);
            }
        });
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.interstitial.InterstitialBannerActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterstitialBannerActivity.m2634$r8$lambda$FVeiI_jWma5kcwWHO7QMLh1Nm4(InterstitialBannerActivity.this, view);
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.interstitial.InterstitialBannerActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterstitialBannerActivity.$r8$lambda$QfqdsBUqE8nfrWjsnwLSb7nvoz8(InterstitialBannerActivity.this, view);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.interstitial.InterstitialBannerActivity$setupBackListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                InterstitialBannerActivity.this.PlaceComponentResult(false);
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
        String stringExtra = getIntent().getStringExtra("spaceCode");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = stringExtra;
        CdpContentModel cdpContentModel = (CdpContentModel) getIntent().getParcelableExtra(KEY_CDPCONTENTMODEL);
        this.MyBillsEntityDataFactory = cdpContentModel;
        if (cdpContentModel != null) {
            String str = cdpContentModel.GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(str, "");
            if (str.length() == 0) {
                setResult(0);
                finish();
                return;
            }
            TextView textView = getBinding().getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            LogoProgressView logoProgressView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(logoProgressView, "");
            logoProgressView.setVisibility(0);
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.startRefresh();
            ImageOss.MyBillsEntityDataFactory(cdpContentModel.GetContactSyncConfig, getBinding().PlaceComponentResult, new ImageOss.EventListener() { // from class: id.dana.interstitial.InterstitialBannerActivity$$ExternalSyntheticLambda0
                @Override // id.dana.utils.ImageOss.EventListener
                public final void PlaceComponentResult(String str2, ImageView imageView) {
                    InterstitialBannerActivity.m2633$r8$lambda$46oyyu303_p2WR4xnuh18r8EtU(InterstitialBannerActivity.this, str2, imageView);
                }
            });
            MixPanelTracker.BuiltInFictitiousFunctionClassFactory(this, cdpContentModel, "Promotion Banner Appear", this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (DatabaseTableConfigUtil[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ initRecordTimeStamp))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
