package id.dana.qriscrossborder.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.data.constant.DanaUrl;
import id.dana.model.QrisCrossBorderContentModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.NoUnderlineClickableSpan;
import id.dana.utils.UrlUtil;
import id.dana.webview.WebViewActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J;\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0017\u0010\u0004R\u001c\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/qriscrossborder/view/OnboardingQrisCrossBorderSheetActivity;", "Lid/dana/base/BaseActivity;", "", "configToolbar", "()V", "", "getLayout", "()I", "", "p0", "p1", "p2", "Lid/dana/utils/NoUnderlineClickableSpan;", "p3", "p4", "Landroid/text/SpannableString;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;ILid/dana/utils/NoUnderlineClickableSpan;I)Landroid/text/SpannableString;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", IAPSyncCommand.COMMAND_INIT, "onBackPressed", "onPause", "onStart", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "getErrorConfigVersion", "Lcom/bumptech/glide/request/RequestListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/ethanhua/skeleton/SkeletonScreen;", "scheduleImpl", "Lcom/ethanhua/skeleton/SkeletonScreen;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnboardingQrisCrossBorderSheetActivity extends BaseActivity {
    public static final String EXTRA_QCB_CONTENT = "extra_qris_cross_border_content";
    public static final String EXTRA_QCB_COUNTRY_CODE = "extra_qris_cross_border_country_code";
    private static long NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final RequestListener<Drawable> KClassImpl$Data$declaredNonStaticMembers$2 = new RequestListener<Drawable>() { // from class: id.dana.qriscrossborder.view.OnboardingQrisCrossBorderSheetActivity$requestListener$1
        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException p0, Object p1, Target<Drawable> p2, boolean p3) {
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            return BuiltInFictitiousFunctionClassFactory(obj, target, dataSource);
        }

        private boolean BuiltInFictitiousFunctionClassFactory(Object obj, Target<Drawable> target, DataSource dataSource) {
            SkeletonScreen skeletonScreen;
            Intrinsics.checkNotNullParameter(obj, "");
            Intrinsics.checkNotNullParameter(target, "");
            Intrinsics.checkNotNullParameter(dataSource, "");
            skeletonScreen = OnboardingQrisCrossBorderSheetActivity.this.getAuthRequestContext;
            if (skeletonScreen != null) {
                skeletonScreen.PlaceComponentResult();
                return false;
            }
            return false;
        }
    };

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private SkeletonScreen getAuthRequestContext;
    public static final byte[] $$a = {112, Ascii.US, -51, -82, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 243;
    public static final byte[] getAuthRequestContext = {75, -23, 102, -23, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 150;

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = -2000737796197335020L;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 97
            int r9 = 55 - r9
            int r7 = r7 + 16
            byte[] r0 = id.dana.qriscrossborder.view.OnboardingQrisCrossBorderSheetActivity.getAuthRequestContext
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L31
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
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L31:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.qriscrossborder.view.OnboardingQrisCrossBorderSheetActivity.a(int, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 2
            int r6 = 103 - r6
            int r7 = r7 + 4
            byte[] r0 = id.dana.qriscrossborder.view.OnboardingQrisCrossBorderSheetActivity.$$a
            int r8 = r8 * 3
            int r8 = 42 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L34
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-7)
            int r7 = r8 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.qriscrossborder.view.OnboardingQrisCrossBorderSheetActivity.c(short, short, int, java.lang.Object[]):void");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(TextUtils.lastIndexOf("", '0') + 50708, new char[]{4406, 55082, 40213, 17180, 2420, 53089, 46401, 31740, 8608, 59279, 44487, 37846, 22977, 8143, 50238, 35375, 28692, 13927}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(19001 - ExpandableListView.getPackedPositionGroup(0L), new char[]{4410, 23319, 34160, 53141, 14807}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 51030, new char[]{4448, 54883, 40911, 18282, 3131, 62848, 48484, 25102, 11224, 4925, 55378, 33164, 18726, 3598, 63396, 49016, 25622, 11681, 5503, 55875, 33791, 19223, 12366, 63920, 41243, 26139, 12217, 5918, 56545, 34280, 19716, 12987, 64398, 41814, 26859, 20875, 6413, 57085, 34693, 20262, 13560, 64990, 42277, 27388, 21441, 6959, 49347, 35275}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(24517 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{4406, 20135, 44779, 3708, 28197, 53175, 12281, 36620, 61211, 19673, 44252, 3093, 27663, 52327, 11680, 36328, 60725, 19824, 43755, 2809, 27223, 51791, 11151, 35799, 60185, 19208, 43884, 2293, 26851, 51298, 10355, 35262, 59796, 18774, 43337, 1664, 26240, 50765, 9817, 34407, 59306, 18410, 42848, 1905, 25832, 50369, 9216, 33867, 58772, 17873, 42266, 1361, 25962, 49833, 8937, 33333, 57983, 17339, 41878, 850, 25418, 49310, 8325, 32799}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(Color.argb(0, 0, 0, 0) + 60733, new char[]{4453, 64603, 52040, 54914, 42394, 45905, 40459, 28104, 30855, 17994, 21773, 8441, 4026, 7549, 59441, 63475, 49894, 53311, 48937, 35508, 39329, 26420, 29192, 16671, 11480, 15300, 2396, 5120, 58269, 52952, 56390, 43863, 46784, 34286, 37759, 32312, 19873, 22705, 9839, 13604, 231, 61428, 64868, 51292, 55059, 41694, 45504, 40710, 27201, 31171, 17630, 21013, 8449, 3271, 7151, 59769, 62520, 50167, 44732, 48238, 35709, 38635, 26020, 29549}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(MotionEvent.axisFromString("") + 30342, new char[]{4415, 26534, 64553, 29352, 52016, 16884, 54886, 11483, 42267, 15259, 45067, 1665, 40773, 5602, 27257, 57582, 31074, 53219, 17529, 56043, 21330, 43469, 15949, 46218, 3400, 33759, 6324, 37154, 59327, 31797, 62128, 19257, 49558, 22016, 44184, 9558, 48000, 12289, 34436, 7995, 38398, 60010, 24812, 63791, 20450, 50264, 23254, 54105, 10708, 48726, 13442, 36190, 609, 39153, 4412, 26546, 64554, 29348, 51969, 16771}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(17291 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{4462, 21234, 38517, 56280, 8009, 16593}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - KeyEvent.normalizeMetaState(0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = getAuthRequestContext[25];
                byte b2 = (byte) (b | 8);
                Object[] objArr14 = new Object[1];
                a(b, b2, (byte) (b2 | 22), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 55, 3 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), (byte) ($$a[47] - 1), $$a[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 800, ExpandableListView.getPackedPositionGroup(0L) + 15, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 800, 15 - TextUtils.indexOf("", "", 0, 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 815, TextUtils.getOffsetBefore("", 0) + 29, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - ((byte) KeyEvent.getModifierMetaStateMask()), TextUtils.indexOf("", "", 0) + 15, (char) (ViewConfiguration.getTapTimeout() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1094175411, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 911, 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = getAuthRequestContext[25];
                byte b4 = (byte) (b3 | 8);
                Object[] objArr20 = new Object[1];
                a(b3, b4, (byte) (b4 | 22), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 61, 46 - Color.green(0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        byte b5 = (byte) ($$a[47] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b5, (byte) (b5 | Ascii.ETB), (byte) (-$$a[8]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1094175411, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 911, (Process.myPid() >> 22) + 18, (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b6 = getAuthRequestContext[25];
                byte b7 = (byte) (b6 | 8);
                Object[] objArr26 = new Object[1];
                a(b6, b7, (byte) (b7 | 22), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 2 - MotionEvent.axisFromString(""), (char) (38968 - TextUtils.indexOf("", "", 0)));
                        byte b8 = (byte) ($$a[47] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b8, (byte) (b8 | Ascii.ETB), (byte) (-$$a[8]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, Drawable.resolveOpacity(0, 0) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1094175411, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b9 = getAuthRequestContext[25];
                byte b10 = (byte) (b9 | 8);
                Object[] objArr32 = new Object[1];
                a(b9, b10, (byte) (b10 | 22), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 107, 3 - View.getDefaultSize(0, 0), (char) TextUtils.indexOf("", ""));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[53]), (byte) ($$a[47] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), 34 - TextUtils.lastIndexOf("", '0'), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1094175411, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.view_onboarding_qris_cross_border_bottomsheet;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(50707 - TextUtils.getCapsMode("", 0, 0), new char[]{4406, 55082, 40213, 17180, 2420, 53089, 46401, 31740, 8608, 59279, 44487, 37846, 22977, 8143, 50238, 35375, 28692, 13927}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 19001, new char[]{4410, 23319, 34160, 53141, 14807}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                b(super.getResources().getString(R.string.ep_paylater_activation_subtitle).substring(8, 18).codePointAt(0) + 49751, new char[]{4406, 54094, 38365, 22080, 6372, 56685, 40953, 16440, 654, 50952, 35201, 19044, 3202, 61759, 45985, 30151, 13905, 63705, 48509, 32763, 8271, 58108, 42783, 27011, 10782, 60588}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                b(super.getResources().getString(R.string.deals_express_voucher_context_offline_health).substring(9, 10).codePointAt(0) + 33242, new char[]{4404, 37661, 5467, 38808, 6606, 39426, 7257, 40623, 223, 34064, 1869, 35211, 3008, 35845, 3665, 45199, 13000, 46870}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Drawable.resolveOpacity(0, 0), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    b(getPackageName().codePointAt(3) + 50931, new char[]{4448, 54883, 40911, 18282, 3131, 62848, 48484, 25102, 11224, 4925, 55378, 33164, 18726, 3598, 63396, 49016, 25622, 11681, 5503, 55875, 33791, 19223, 12366, 63920, 41243, 26139, 12217, 5918, 56545, 34280, 19716, 12987, 64398, 41814, 26859, 20875, 6413, 57085, 34693, 20262, 13560, 64990, 42277, 27388, 21441, 6959, 49347, 35275}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    b(24517 - KeyEvent.keyCodeFromString(""), new char[]{4406, 20135, 44779, 3708, 28197, 53175, 12281, 36620, 61211, 19673, 44252, 3093, 27663, 52327, 11680, 36328, 60725, 19824, 43755, 2809, 27223, 51791, 11151, 35799, 60185, 19208, 43884, 2293, 26851, 51298, 10355, 35262, 59796, 18774, 43337, 1664, 26240, 50765, 9817, 34407, 59306, 18410, 42848, 1905, 25832, 50369, 9216, 33867, 58772, 17873, 42266, 1361, 25962, 49833, 8937, 33333, 57983, 17339, 41878, 850, 25418, 49310, 8325, 32799}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(ExpandableListView.getPackedPositionChild(0L) + 60734, new char[]{4453, 64603, 52040, 54914, 42394, 45905, 40459, 28104, 30855, 17994, 21773, 8441, 4026, 7549, 59441, 63475, 49894, 53311, 48937, 35508, 39329, 26420, 29192, 16671, 11480, 15300, 2396, 5120, 58269, 52952, 56390, 43863, 46784, 34286, 37759, 32312, 19873, 22705, 9839, 13604, 231, 61428, 64868, 51292, 55059, 41694, 45504, 40710, 27201, 31171, 17630, 21013, 8449, 3271, 7151, 59769, 62520, 50167, 44732, 48238, 35709, 38635, 26020, 29549}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(AndroidCharacter.getMirror('0') + 30293, new char[]{4415, 26534, 64553, 29352, 52016, 16884, 54886, 11483, 42267, 15259, 45067, 1665, 40773, 5602, 27257, 57582, 31074, 53219, 17529, 56043, 21330, 43469, 15949, 46218, 3400, 33759, 6324, 37154, 59327, 31797, 62128, 19257, 49558, 22016, 44184, 9558, 48000, 12289, 34436, 7995, 38398, 60010, 24812, 63791, 20450, 50264, 23254, 54105, 10708, 48726, 13442, 36190, 609, 39153, 4412, 26546, 64554, 29348, 51969, 16771}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(super.getResources().getString(R.string.family_account_text_contact_list).substring(3, 5).codePointAt(1) + 17194, new char[]{4462, 21234, 38517, 56280, 8009, 16593}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 911, 18 - Drawable.resolveOpacity(0, 0), (char) Color.alpha(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr11);
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
        try {
            Object[] objArr12 = new Object[1];
            a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b = getAuthRequestContext[25];
            byte b2 = (byte) (b | 8);
            Object[] objArr13 = new Object[1];
            a(b, b2, (byte) (b2 | 22), objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 4 - Color.blue(0), (char) (ViewConfiguration.getTapTimeout() >> 16));
                    Object[] objArr15 = new Object[1];
                    c((byte) (-$$a[9]), (byte) (-$$a[53]), (byte) ($$a[47] - 1), objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {2122781384, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), MotionEvent.axisFromString("") + 19, (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr17);
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
                super.onCreate(bundle);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(getPackageName().length() + 49776, new char[]{4406, 54094, 38365, 22080, 6372, 56685, 40953, 16440, 654, 50952, 35201, 19044, 3202, 61759, 45985, 30151, 13905, 63705, 48509, 32763, 8271, 58108, 42783, 27011, 10782, 60588}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(getPackageName().codePointAt(3) + 33243, new char[]{4404, 37661, 5467, 38808, 6606, 39426, 7257, 40623, 223, 34064, 1869, 35211, 3008, 35845, 3665, 45199, 13000, 46870}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 35, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 17 - TextUtils.lastIndexOf("", '0', 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = getAuthRequestContext[30];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(getAuthRequestContext[8], getAuthRequestContext[5], getAuthRequestContext[25], objArr2);
                Object[] objArr3 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 49750, new char[]{4406, 54094, 38365, 22080, 6372, 56685, 40953, 16440, 654, 50952, 35201, 19044, 3202, 61759, 45985, 30151, 13905, 63705, 48509, 32763, 8271, 58108, 42783, 27011, 10782, 60588}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(TextUtils.lastIndexOf("", '0', 0) + 33344, new char[]{4404, 37661, 5467, 38808, 6606, 39426, 7257, 40623, 223, 34064, 1869, 35211, 3008, 35845, 3665, 45199, 13000, 46870}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 930, 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, Color.red(0) + 18, (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        if (isFinishing()) {
            overridePendingTransition(R.anim.f5032130772052, R.anim.f5082130772059);
        }
    }

    static /* synthetic */ SpannableString BuiltInFictitiousFunctionClassFactory$default(OnboardingQrisCrossBorderSheetActivity onboardingQrisCrossBorderSheetActivity, String str, String str2, int i, NoUnderlineClickableSpan noUnderlineClickableSpan, int i2, int i3, Object obj) {
        return onboardingQrisCrossBorderSheetActivity.BuiltInFictitiousFunctionClassFactory(str, str2, i, noUnderlineClickableSpan, (i3 & 16) != 0 ? R.color.f22912131099753 : i2);
    }

    private final SpannableString BuiltInFictitiousFunctionClassFactory(String p0, String p1, int p2, NoUnderlineClickableSpan p3, int p4) {
        SpannableString spannableString = new SpannableString(p0);
        if (p3 != null) {
            spannableString.setSpan(p3, p2, p1.length() + p2, 33);
        }
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, p4)), p2, p1.length() + p2, 33);
        spannableString.setSpan(new StyleSpan(1), p2, p1.length() + p2, 33);
        return spannableString;
    }

    private final String getAuthRequestContext(String p0, String p1) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(p0);
            sb.append('_');
            sb.append(p1);
            return getString(getResources().getIdentifier(sb.toString(), "string", getPackageName()));
        } catch (Resources.NotFoundException unused) {
            return HtmlCompat.PlaceComponentResult(p0, 0).toString();
        }
    }

    /* renamed from: $r8$lambda$mZi-5xuHpjT67QUwDrsKcur7Km8 */
    public static /* synthetic */ void m2793$r8$lambda$mZi5xuHpjT67QUwDrsKcur7Km8(OnboardingQrisCrossBorderSheetActivity onboardingQrisCrossBorderSheetActivity, View view) {
        Intrinsics.checkNotNullParameter(onboardingQrisCrossBorderSheetActivity, "");
        onboardingQrisCrossBorderSheetActivity.finish();
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        String valueOf;
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((AppCompatImageView) _$_findCachedViewById(R.id.ivOnboardingImage));
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_skeleton_gn_onboarding_image;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        boolean z = true;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        this.getAuthRequestContext = viewSkeletonScreen;
        QrisCrossBorderContentModel qrisCrossBorderContentModel = (QrisCrossBorderContentModel) getIntent().getParcelableExtra(EXTRA_QCB_CONTENT);
        String stringExtra = getIntent().getStringExtra(EXTRA_QCB_COUNTRY_CODE);
        String str = stringExtra == null ? "" : stringExtra;
        if (qrisCrossBorderContentModel != null) {
            if (str.length() > 0) {
                TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a15f5_access_getinheritednonstaticmembers);
                if (textView != null) {
                    textView.setText(getAuthRequestContext(qrisCrossBorderContentModel.PlaceComponentResult, str));
                }
                String authRequestContext = getAuthRequestContext(qrisCrossBorderContentModel.MyBillsEntityDataFactory, str);
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvWelcomingInfo);
                if (textView2 != null) {
                    String str2 = authRequestContext;
                    if (str2 != null && str2.length() != 0) {
                        z = false;
                    }
                    if (!z && StringsKt.contains$default((CharSequence) str2, (CharSequence) TrackerKey.DanaBalanceRecipientTypeProperty.DANA, false, 2, (Object) null)) {
                        String obj = authRequestContext.toString();
                        valueOf = BuiltInFictitiousFunctionClassFactory(obj, TrackerKey.DanaBalanceRecipientTypeProperty.DANA, StringsKt.indexOf$default((CharSequence) obj, TrackerKey.DanaBalanceRecipientTypeProperty.DANA, 0, false, 6, (Object) null), null, R.color.f22832131099732);
                    } else {
                        valueOf = String.valueOf(authRequestContext);
                    }
                    textView2.setText(valueOf);
                }
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1434_trafficstatscompat_api24impl);
                if (textView3 != null) {
                    textView3.setText(qrisCrossBorderContentModel.getAuthRequestContext);
                }
                DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnStart);
                if (danaButtonPrimaryView != null) {
                    danaButtonPrimaryView.setActiveButton(getAuthRequestContext(qrisCrossBorderContentModel.BuiltInFictitiousFunctionClassFactory, str), null);
                }
                GlideApp.PlaceComponentResult(this).PlaceComponentResult(qrisCrossBorderContentModel.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory(325, (int) TarHeader.USTAR_FILENAME_PREFIX).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.ivOnboardingImage)));
            }
        }
        String string = getString(R.string.text_tnc_qcb);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.tnc);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        OnboardingQrisCrossBorderSheetActivity onboardingQrisCrossBorderSheetActivity = this;
        ((TextView) _$_findCachedViewById(R.id.tvTncPrivacyPolicy)).setText(BuiltInFictitiousFunctionClassFactory$default(this, string, string2, StringsKt.indexOf$default((CharSequence) string, string2, 0, false, 6, (Object) null), new NoUnderlineClickableSpan(onboardingQrisCrossBorderSheetActivity, WebViewActivity.ContentBuilder(onboardingQrisCrossBorderSheetActivity, string2, UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION))), 0, 16, null));
        ((TextView) _$_findCachedViewById(R.id.tvTncPrivacyPolicy)).setMovementMethod(LinkMovementMethod.getInstance());
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnStart)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.qriscrossborder.view.OnboardingQrisCrossBorderSheetActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnboardingQrisCrossBorderSheetActivity.m2793$r8$lambda$mZi5xuHpjT67QUwDrsKcur7Km8(OnboardingQrisCrossBorderSheetActivity.this, view);
            }
        });
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
        objArr[0] = new String(cArr2);
    }
}
