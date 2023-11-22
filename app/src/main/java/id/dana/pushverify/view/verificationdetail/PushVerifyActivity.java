package id.dana.pushverify.view.verificationdetail;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.OSUtil;
import id.dana.databinding.ActivityPushVerifyBinding;
import id.dana.databinding.LayoutPushVerifyChallengeBinding;
import id.dana.databinding.LayoutPushVerifyErrorBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPushVerifyComponent;
import id.dana.di.modules.PushVerifyModule;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.pushverify.constant.PushVerifyEntryPoint;
import id.dana.pushverify.constant.PushVerifyTab;
import id.dana.pushverify.model.PushVerifyChallengeModel;
import id.dana.pushverify.model.PushVerifyParamsModel;
import id.dana.pushverify.model.VerifyPushChallengeParamModel;
import id.dana.pushverify.utlis.VerificationExpiryUtil;
import id.dana.pushverify.view.richview.PushVerifyChallengeInfoView;
import id.dana.pushverify.view.verificationdetail.PushVerifyContract;
import id.dana.pushverify.view.verificationlist.VerificationListActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001NB\u0007¢\u0006\u0004\bM\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0006J\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0006J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020!H\u0002¢\u0006\u0004\b\u0012\u0010\"J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020#H\u0002¢\u0006\u0004\b\r\u0010$J\u0090\u0001\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010%2\u001b\b\u0002\u00100\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010!¢\u0006\u0002\b/\u0012\u0004\u0012\u00020\u00040.H\u0002¢\u0006\u0004\b\u0012\u00101J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u000f\u00102\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u0010\u0006J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u000bR\u0016\u0010\n\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u0012\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010:R(\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bK\u0010:"}, d2 = {"Lid/dana/pushverify/view/verificationdetail/PushVerifyActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityPushVerifyBinding;", "Lid/dana/pushverify/view/verificationdetail/PushVerifyContract$View;", "", "configToolbar", "()V", "dismissProgress", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "Lid/dana/pushverify/constant/PushVerifyTab;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/pushverify/constant/PushVerifyTab;)V", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityPushVerifyBinding;", "getAuthRequestContext", "()Z", "", "throwable", "onErrorGetPushVerifyChallenge", "(Ljava/lang/Throwable;)V", "onErrorVerifyPushChallenge", "onExpiredGetPushVerifyChallenge", "onInvalidSessionGetPushVerifyChallenge", "onRejectVerifyPushChallenge", "Lid/dana/pushverify/model/PushVerifyChallengeModel;", "pushVerifyChallengeModel", "onSuccessGetPushVerifyChallenge", "(Lid/dana/pushverify/model/PushVerifyChallengeModel;)V", "onSuccessVerifyPushChallenge", "Landroid/view/View;", "(Landroid/view/View;)V", "", "(I)V", "", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p9", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "showProgress", "Lid/dana/databinding/LayoutPushVerifyChallengeBinding;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/databinding/LayoutPushVerifyChallengeBinding;", "lookAheadTest", "I", "PlaceComponentResult", "DatabaseTableConfigUtil", "Ljava/lang/String;", "Lid/dana/databinding/LayoutPushVerifyErrorBinding;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/databinding/LayoutPushVerifyErrorBinding;", "MyBillsEntityDataFactory", "GetContactSyncConfig", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "moveToNextValue", "Ldagger/Lazy;", "Lid/dana/pushverify/view/verificationdetail/PushVerifyContract$Presenter;", "presenter", "Ldagger/Lazy;", "getPresenter", "()Ldagger/Lazy;", "setPresenter", "(Ldagger/Lazy;)V", "initRecordTimeStamp", "getErrorConfigVersion", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushVerifyActivity extends ViewBindingActivity<ActivityPushVerifyBinding> implements PushVerifyContract.View {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int[] PrepareContext;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private LayoutPushVerifyChallengeBinding BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private LayoutPushVerifyErrorBinding MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private String moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int PlaceComponentResult;
    @Inject
    public Lazy<PushVerifyContract.Presenter> presenter;
    public static final byte[] $$a = {125, -100, 71, Ascii.FS, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 228;
    public static final byte[] getAuthRequestContext = {36, -18, 4, 125, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 45;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String getAuthRequestContext = "Other";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[PushVerifyTab.values().length];
            iArr[PushVerifyTab.ACTIVE.ordinal()] = 1;
            iArr[PushVerifyTab.HISTORY.ordinal()] = 2;
            PlaceComponentResult = iArr;
        }
    }

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        PrepareContext = new int[]{563692214, -88329558, -1358430397, -995429097, -16725327, 665908665, 666388213, 1484035375, -483330635, 1268001811, 752533032, 36804014, -1575016730, -696455303, 674553636, 1233169087, -2104395647, -2087948438};
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.pushverify.view.verificationdetail.PushVerifyActivity.getAuthRequestContext
            int r6 = 55 - r6
            int r7 = r7 + 16
            int r8 = r8 + 97
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r6 = r6 + 1
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r8 = r8 + r6
            int r8 = r8 + (-4)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.verificationdetail.PushVerifyActivity.b(int, short, short, java.lang.Object[]):void");
    }

    private static void c(short s, byte b, byte b2, Object[] objArr) {
        byte[] bArr = $$a;
        int i = 42 - (s * 3);
        int i2 = 103 - (b * 2);
        int i3 = b2 + 4;
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            i3 = i3;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i2 = (i2 + (-i5)) - 7;
            i5 = i5;
        }
        while (true) {
            int i6 = i4 + 1;
            int i7 = i3 + 1;
            bArr2[i6] = (byte) i2;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i2;
            int i9 = i5;
            i3 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
            i2 = (i8 + (-bArr[i7])) - 7;
            i5 = i9;
        }
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
        a(TextUtils.indexOf((CharSequence) "", '0') + 19, new int[]{-1557747510, -1138331156, -288733865, -2077575131, 1823622953, 599145197, -806817543, 202374800, 958839808, -2082788331}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(5 - TextUtils.getCapsMode("", 0, 0), new int[]{991539094, -31578925, 1985513942, 593985855}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) (MotionEvent.axisFromString("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(47 - TextUtils.indexOf((CharSequence) "", '0'), new int[]{888922003, -1459987589, 555648087, -1740760828, -768447278, -261513736, 1163477149, 2124705257, 1605890764, -1579557556, -1129526054, 2013323924, -896968627, -1967500352, -1533723701, 541429947, -522876782, 1108129570, -1200588302, 1422948183, -481305415, -420039141, 1011341077, -15414952}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(View.getDefaultSize(0, 0) + 64, new int[]{-1303664858, -521753564, -1201098379, 1038509569, 1477531199, -2100562972, 1124422215, 944768237, 1694995106, 43824383, -1264999680, 2048198699, 1067722724, -798238329, -711843733, 509060306, -1467906793, 1346645824, 467794850, -785776688, -1178816240, -1295337637, -909362975, -1441294682, -461078876, 1158848160, -965038803, 1863508799, 1762909211, 1495910883, 941566177, -320648718}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(Color.red(0) + 64, new int[]{-2019919451, -1681165798, -808043943, 23920156, -1215683665, 185883293, 147200396, 486478176, 1632935899, -1805067280, 1987650279, 1541946226, 604505163, 1223389381, 921282476, -1131660888, 1309582570, 1037371880, -785448796, -1996655714, 1665420985, 1359389741, -1669407296, 43825588, 1508429384, 329112890, -1233379583, 1340110309, 820446667, -1300630397, 351895678, 2087029677}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - Color.argb(0, 0, 0, 0), new int[]{-322696643, -670754272, 1646622384, -735092218, 823265746, 554002965, 2075393229, -468939430, 329228494, 1442827419, -1647832738, 869961551, -868566616, 122738127, 311201805, 646935422, -446397430, 1939532018, -1703894950, -644439287, -324095032, -1179449773, 1669618673, 155347127, -119351394, -208165222, -877375155, 452927672, 1444900931, -653888721}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(6 - View.resolveSizeAndState(0, 0, 0), new int[]{-907900269, -255574651, -1396153864, 102278448}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), 18 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) TextUtils.getOffsetAfter("", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (getAuthRequestContext[34] + 1);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), AndroidCharacter.getMirror('0') - '-', (char) View.resolveSizeAndState(0, 0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[68], (byte) (-$$a[12]), $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Gravity.getAbsoluteGravity(0, 0), 15 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (Process.myPid() >> 22), 15 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 815, (ViewConfiguration.getJumpTapTimeout() >> 16) + 29, (char) (57994 - (KeyEvent.getMaxKeyCode() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 800, Gravity.getAbsoluteGravity(0, 0) + 15, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1179858570, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 18 - TextUtils.getCapsMode("", 0, 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (getAuthRequestContext[34] + 1);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr20 = new Object[1];
                b(b3, b4, (byte) (b4 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 61, 46 - TextUtils.getOffsetAfter("", 0), (char) (Process.myTid() >> 22));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[8]), (byte) ($$a[47] - 1), (byte) (-$$a[28]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1179858570, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), 18 - View.resolveSize(0, 0), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (getAuthRequestContext[34] + 1);
                byte b6 = getAuthRequestContext[25];
                Object[] objArr26 = new Object[1];
                b(b5, b6, (byte) (b6 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - TextUtils.indexOf((CharSequence) "", '0', 0), 3 - Drawable.resolveOpacity(0, 0), (char) (38969 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[8]), (byte) ($$a[47] - 1), (byte) (-$$a[28]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1179858570, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = (byte) (getAuthRequestContext[34] + 1);
                byte b8 = getAuthRequestContext[25];
                Object[] objArr32 = new Object[1];
                b(b7, b8, (byte) (b8 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - KeyEvent.keyCodeFromString(""), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 3, (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[9]), $$a[40], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 36, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1179858570, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), MotionEvent.axisFromString("") + 19, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
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
            b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
            Object[] objArr3 = new Object[1];
            a(((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{-1557747510, -1138331156, -288733865, -2077575131, 1823622953, 599145197, -806817543, 202374800, 958839808, -2082788331}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            try {
                Object[] objArr4 = new Object[1];
                b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr4);
                Class<?> cls3 = Class.forName((String) objArr4[0]);
                b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
                Object[] objArr5 = new Object[1];
                a(((ApplicationInfo) cls3.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 28, new int[]{991539094, -31578925, 1985513942, 593985855}, objArr5);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr6 = new Object[1];
                        a((ViewConfiguration.getKeyRepeatDelay() >> 16) + 26, new int[]{-1557747510, -1138331156, -288733865, -2077575131, -1663051501, 1005732892, 398999192, 226582822, 525252235, 2094712965, 1259009314, -323532615, 1182397589, -34623071}, objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        a(super.getResources().getString(R.string.contact_no_permission_negative_action).substring(1, 2).codePointAt(0) - 79, new int[]{191083386, -1777232131, -804023429, -454547229, 1442192742, 1828406542, -323860623, 1154469815, -973759625, 1778067873}, objArr7);
                        baseContext = (Context) cls4.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.combineMeasuredStates(0, 0), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr8 = new Object[1];
                            a((ViewConfiguration.getEdgeSlop() >> 16) + 48, new int[]{888922003, -1459987589, 555648087, -1740760828, -768447278, -261513736, 1163477149, 2124705257, 1605890764, -1579557556, -1129526054, 2013323924, -896968627, -1967500352, -1533723701, 541429947, -522876782, 1108129570, -1200588302, 1422948183, -481305415, -420039141, 1011341077, -15414952}, objArr8);
                            String str = (String) objArr8[0];
                            Object[] objArr9 = new Object[1];
                            a(super.getResources().getString(R.string.exceed_limit_smart_friction_description).substring(18, 19).codePointAt(0) - 40, new int[]{-1303664858, -521753564, -1201098379, 1038509569, 1477531199, -2100562972, 1124422215, 944768237, 1694995106, 43824383, -1264999680, 2048198699, 1067722724, -798238329, -711843733, 509060306, -1467906793, 1346645824, 467794850, -785776688, -1178816240, -1295337637, -909362975, -1441294682, -461078876, 1158848160, -965038803, 1863508799, 1762909211, 1495910883, 941566177, -320648718}, objArr9);
                            String str2 = (String) objArr9[0];
                            Object[] objArr10 = new Object[1];
                            a(super.getResources().getString(R.string.dont_show_this_message_again).substring(19, 21).length() + 62, new int[]{-2019919451, -1681165798, -808043943, 23920156, -1215683665, 185883293, 147200396, 486478176, 1632935899, -1805067280, 1987650279, 1541946226, 604505163, 1223389381, 921282476, -1131660888, 1309582570, 1037371880, -785448796, -1996655714, 1665420985, 1359389741, -1669407296, 43825588, 1508429384, 329112890, -1233379583, 1340110309, 820446667, -1300630397, 351895678, 2087029677}, objArr10);
                            String str3 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            a(super.getResources().getString(R.string.feeds_delete_dialog).substring(0, 1).codePointAt(0) - 5, new int[]{-322696643, -670754272, 1646622384, -735092218, 823265746, 554002965, 2075393229, -468939430, 329228494, 1442827419, -1647832738, 869961551, -868566616, 122738127, 311201805, 646935422, -446397430, 1939532018, -1703894950, -644439287, -324095032, -1179449773, 1669618673, 155347127, -119351394, -208165222, -877375155, 452927672, 1444900931, -653888721}, objArr11);
                            String str4 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            a(getPackageName().length() - 1, new int[]{-907900269, -255574651, -1396153864, 102278448}, objArr12);
                            try {
                                Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) KeyEvent.keyCodeFromString(""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr13);
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
                    Object[] objArr14 = new Object[1];
                    b(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr14);
                    Class<?> cls5 = Class.forName((String) objArr14[0]);
                    byte b = (byte) (getAuthRequestContext[34] + 1);
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr15 = new Object[1];
                    b(b, b2, (byte) (b2 | 8), objArr15);
                    try {
                        Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (Process.myPid() >> 22), ExpandableListView.getPackedPositionGroup(0L) + 4, (char) (ViewConfiguration.getEdgeSlop() >> 16));
                            Object[] objArr17 = new Object[1];
                            c((byte) ($$a[47] - 1), (byte) (-$$a[9]), $$a[40], objArr17);
                            obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                        int i = ((int[]) objArr18[1])[0];
                        if (((int[]) objArr18[0])[0] != i) {
                            long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr19 = {-466786321, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr19);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(26 - (Process.myPid() >> 22), new int[]{-1557747510, -1138331156, -288733865, -2077575131, -1663051501, 1005732892, 398999192, 226582822, 525252235, 2094712965, 1259009314, -323532615, 1182397589, -34623071}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.request_money_AE15112158147536).substring(26, 27).length() + 17, new int[]{191083386, -1777232131, -804023429, -454547229, 1442192742, 1828406542, -323860623, 1154469815, -973759625, 1778067873}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - MotionEvent.axisFromString(""), Color.red(0) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.zdoc_confirm_00620000001_1).substring(0, 1).length() + 25, new int[]{-1557747510, -1138331156, -288733865, -2077575131, -1663051501, 1005732892, 398999192, 226582822, 525252235, 2094712965, 1259009314, -323532615, 1182397589, -34623071}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(TextUtils.getTrimmedLength("") + 18, new int[]{191083386, -1777232131, -804023429, -454547229, 1442192742, 1828406542, -323860623, 1154469815, -973759625, 1778067873}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getTrimmedLength(""), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, 17 - MotionEvent.axisFromString(""), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getPresenter")
    public final Lazy<PushVerifyContract.Presenter> getPresenter() {
        Lazy<PushVerifyContract.Presenter> lazy = this.presenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(Lazy<PushVerifyContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.presenter = lazy;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityPushVerifyBinding initViewBinding() {
        ActivityPushVerifyBinding authRequestContext = ActivityPushVerifyBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.pushverify.view.verificationdetail.PushVerifyContract.View
    public final void onExpiredGetPushVerifyChallenge() {
        KClassImpl$Data$declaredNonStaticMembers$2(1);
        LayoutPushVerifyErrorBinding layoutPushVerifyErrorBinding = this.MyBillsEntityDataFactory;
        if (layoutPushVerifyErrorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            layoutPushVerifyErrorBinding = null;
        }
        layoutPushVerifyErrorBinding.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushVerifyActivity.$r8$lambda$dgbiubp1h61ijZKo1kSQVSzCZbI(PushVerifyActivity.this, view);
            }
        });
    }

    @Override // id.dana.pushverify.view.verificationdetail.PushVerifyContract.View
    public final void onInvalidSessionGetPushVerifyChallenge() {
        KClassImpl$Data$declaredNonStaticMembers$2(3);
        LayoutPushVerifyErrorBinding layoutPushVerifyErrorBinding = this.MyBillsEntityDataFactory;
        if (layoutPushVerifyErrorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            layoutPushVerifyErrorBinding = null;
        }
        layoutPushVerifyErrorBinding.MyBillsEntityDataFactory.setText(getString(R.string.pushverify_invalid_session_title));
        layoutPushVerifyErrorBinding.PlaceComponentResult.setText(getString(R.string.pushverify_invalid_session_message));
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(layoutPushVerifyErrorBinding.BuiltInFictitiousFunctionClassFactory, R.drawable.ic_push_verify_invalid_user_id);
        layoutPushVerifyErrorBinding.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushVerifyActivity.$r8$lambda$9rMtzUaz2FsmhoKH9BtvfAVRlNg(PushVerifyActivity.this, view);
            }
        });
    }

    @Override // id.dana.pushverify.view.verificationdetail.PushVerifyContract.View
    public final void onErrorGetPushVerifyChallenge(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "");
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x005a  */
    @Override // id.dana.pushverify.view.verificationdetail.PushVerifyContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onSuccessVerifyPushChallenge() {
        /*
            r13 = this;
            r0 = 1
            r13.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            java.lang.String r1 = r13.getErrorConfigVersion
            java.lang.String r2 = "BINDING"
            r3 = 609761893(0x24583a65, float:4.6886996E-17)
            java.lang.String r4 = "LOGIN"
            r5 = 72611657(0x453f749, float:2.4916479E-36)
            java.lang.String r6 = "PAYMENT"
            r7 = -68698650(0xfffffffffbe7bde6, float:-2.4065443E36)
            java.lang.String r8 = ""
            if (r1 == 0) goto L55
            int r9 = r1.hashCode()
            if (r9 == r7) goto L44
            if (r9 == r5) goto L33
            if (r9 != r3) goto L55
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L55
            r1 = 2131956357(0x7f131285, float:1.9549267E38)
            java.lang.String r1 = r13.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
            goto L56
        L33:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L55
            r1 = 2131956364(0x7f13128c, float:1.9549282E38)
            java.lang.String r1 = r13.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
            goto L56
        L44:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L55
            r1 = 2131956369(0x7f131291, float:1.9549292E38)
            java.lang.String r1 = r13.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
            goto L56
        L55:
            r1 = r8
        L56:
            java.lang.String r9 = r13.getErrorConfigVersion
            if (r9 == 0) goto Lab
            int r10 = r9.hashCode()
            r11 = 0
            if (r10 == r7) goto L93
            if (r10 == r5) goto L7c
            if (r10 != r3) goto Lab
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto Lab
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = r13.moveToNextValue
            r0[r11] = r2
            r2 = 2131956356(0x7f131284, float:1.9549265E38)
            java.lang.String r0 = r13.getString(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
            goto La9
        L7c:
            boolean r2 = r9.equals(r4)
            if (r2 == 0) goto Lab
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = r13.moveToNextValue
            r0[r11] = r2
            r2 = 2131956363(0x7f13128b, float:1.954928E38)
            java.lang.String r0 = r13.getString(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
            goto La9
        L93:
            boolean r2 = r9.equals(r6)
            if (r2 == 0) goto Lab
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = r13.moveToNextValue
            r0[r11] = r2
            r2 = 2131956368(0x7f131290, float:1.954929E38)
            java.lang.String r0 = r13.getString(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
        La9:
            r2 = r0
            goto Lac
        Lab:
            r2 = r8
        Lac:
            r0 = 2131956372(0x7f131294, float:1.9549298E38)
            java.lang.String r5 = r13.getString(r0)
            r0 = 2131954850(0x7f130ca2, float:1.954621E38)
            java.lang.String r6 = r13.getString(r0)
            r0 = 2131954849(0x7f130ca1, float:1.9546209E38)
            java.lang.String r7 = r13.getString(r0)
            r0 = 2131952294(0x7f1302a6, float:1.9541027E38)
            java.lang.String r9 = r13.getString(r0)
            r0 = 2131233555(0x7f080b13, float:1.808325E38)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r4 = 0
            r8 = 0
            id.dana.pushverify.view.verificationdetail.PushVerifyActivity$showSuccessVerifyDialog$1 r0 = new id.dana.pushverify.view.verificationdetail.PushVerifyActivity$showSuccessVerifyDialog$1
            r0.<init>()
            r10 = r0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r11 = 136(0x88, float:1.9E-43)
            r12 = 0
            r0 = r13
            getAuthRequestContext$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.verificationdetail.PushVerifyActivity.onSuccessVerifyPushChallenge():void");
    }

    @Override // id.dana.pushverify.view.verificationdetail.PushVerifyContract.View
    public final void onRejectVerifyPushChallenge() {
        String str;
        String string;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        String str2 = this.getErrorConfigVersion;
        if (str2 != null) {
            int hashCode = str2.hashCode();
            if (hashCode != -68698650) {
                if (hashCode != 72611657) {
                    if (hashCode == 609761893 && str2.equals("BINDING")) {
                        string = getString(R.string.pushverify_verify_dialog_binding_reject_title);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        str = string;
                    }
                } else if (str2.equals("LOGIN")) {
                    string = getString(R.string.pushverify_verify_dialog_login_reject_title);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    str = string;
                }
            } else if (str2.equals("PAYMENT")) {
                string = getString(R.string.pushverify_verify_dialog_payment_reject_title);
                Intrinsics.checkNotNullExpressionValue(string, "");
                str = string;
            }
            String string2 = getString(R.string.pushverify_verify_dialog_reject_message);
            String string3 = getString(R.string.pushverify_verify_dialog_reject_positive);
            String string4 = getString(R.string.lbl_2fa_success_reject_pop_up_title);
            String string5 = getString(R.string.lbl_2fa_success_reject_pop_up_description);
            String string6 = getString(R.string.btn_2fa_understand);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            getAuthRequestContext$default(this, str, string2, Integer.valueOf((int) R.drawable.ic_push_verify_dialog_failed), null, string3, string4, string5, null, string6, new Function1<View, Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$showRejectVerifyDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    PushVerifyActivity.BuiltInFictitiousFunctionClassFactory$default(PushVerifyActivity.this, false, 1, null);
                }
            }, 136, null);
        }
        str = "";
        String string22 = getString(R.string.pushverify_verify_dialog_reject_message);
        String string32 = getString(R.string.pushverify_verify_dialog_reject_positive);
        String string42 = getString(R.string.lbl_2fa_success_reject_pop_up_title);
        String string52 = getString(R.string.lbl_2fa_success_reject_pop_up_description);
        String string62 = getString(R.string.btn_2fa_understand);
        Intrinsics.checkNotNullExpressionValue(string22, "");
        getAuthRequestContext$default(this, str, string22, Integer.valueOf((int) R.drawable.ic_push_verify_dialog_failed), null, string32, string42, string52, null, string62, new Function1<View, Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$showRejectVerifyDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                PushVerifyActivity.BuiltInFictitiousFunctionClassFactory$default(PushVerifyActivity.this, false, 1, null);
            }
        }, 136, null);
    }

    @Override // id.dana.pushverify.view.verificationdetail.PushVerifyContract.View
    public final void onErrorVerifyPushChallenge(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "");
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        String string = getString(R.string.pushverify_general_error_title);
        String string2 = getString(R.string.pushverify_general_error_message);
        String string3 = getString(R.string.pushverify_general_error_button);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullExpressionValue(string2, "");
        getAuthRequestContext$default(this, string, string2, Integer.valueOf((int) R.drawable.ic_push_verify_dialog_general_error), null, string3, null, null, null, null, new Function1<View, Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$showGeneralErrorDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                PushVerifyActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyTab.ACTIVE);
            }
        }, 488, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        FrameLayout frameLayout = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(0);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        FrameLayout frameLayout = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(8);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        this.PlaceComponentResult = p0;
        if (p0 == 2) {
            BuiltInFictitiousFunctionClassFactory();
            ViewStub viewStub = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            viewStub.setLayoutResource(R.layout.layout_push_verify_challenge);
            Intrinsics.checkNotNullExpressionValue(viewStub, "");
            viewStub.setVisibility(0);
            return;
        }
        BuiltInFictitiousFunctionClassFactory();
        ViewStub viewStub2 = getBinding().getAuthRequestContext;
        viewStub2.setLayoutResource(R.layout.layout_push_verify_error);
        Intrinsics.checkNotNullExpressionValue(viewStub2, "");
        viewStub2.setVisibility(0);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory$default(PushVerifyActivity pushVerifyActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        pushVerifyActivity.BuiltInFictitiousFunctionClassFactory(z);
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        if (getAuthRequestContext()) {
            if (p0) {
                setResult(-1);
            }
            finish();
        } else if (this.PlaceComponentResult == 2) {
            KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2 ? PushVerifyTab.HISTORY : PushVerifyTab.ACTIVE);
        } else {
            backToHomepage(null);
            finish();
        }
    }

    private final boolean getAuthRequestContext() {
        return Intrinsics.areEqual(this.getAuthRequestContext, PushVerifyEntryPoint.VERIFICATION_LIST);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyTab p0) {
        int i = WhenMappings.PlaceComponentResult[p0.ordinal()];
        if (i == 1) {
            VerificationListActivity.Companion companion = VerificationListActivity.INSTANCE;
            PushVerifyActivity pushVerifyActivity = this;
            Intrinsics.checkNotNullParameter(pushVerifyActivity, "");
            VerificationListActivity.Companion.MyBillsEntityDataFactory(pushVerifyActivity, 0);
        } else if (i == 2) {
            VerificationListActivity.Companion companion2 = VerificationListActivity.INSTANCE;
            PushVerifyActivity pushVerifyActivity2 = this;
            Intrinsics.checkNotNullParameter(pushVerifyActivity2, "");
            VerificationListActivity.Companion.MyBillsEntityDataFactory(pushVerifyActivity2, 1);
        }
        finish();
    }

    public final void getAuthRequestContext(boolean p0) {
        Parcelable parcelable;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "");
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (OSUtil.PlaceComponentResult()) {
            parcelable = (Parcelable) intent.getParcelableExtra("push-verify-params", PushVerifyParamsModel.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra("push-verify-params");
            if (!(parcelableExtra instanceof PushVerifyParamsModel)) {
                parcelableExtra = null;
            }
            parcelable = (PushVerifyParamsModel) parcelableExtra;
        }
        PushVerifyParamsModel pushVerifyParamsModel = (PushVerifyParamsModel) parcelable;
        if (pushVerifyParamsModel != null) {
            getPresenter().get().PlaceComponentResult(new VerifyPushChallengeParamModel(pushVerifyParamsModel.MyBillsEntityDataFactory, null, p0, pushVerifyParamsModel.getAuthRequestContext, pushVerifyParamsModel.BuiltInFictitiousFunctionClassFactory, 2, null), this.getAuthRequestContext);
        }
    }

    private final void getAuthRequestContext(View p0) {
        if (this.PlaceComponentResult == 2) {
            LayoutPushVerifyChallengeBinding PlaceComponentResult2 = LayoutPushVerifyChallengeBinding.PlaceComponentResult(p0);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
            this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult2;
            return;
        }
        LayoutPushVerifyErrorBinding authRequestContext = LayoutPushVerifyErrorBinding.getAuthRequestContext(p0);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        this.MyBillsEntityDataFactory = authRequestContext;
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        ActivityPushVerifyBinding binding = getBinding();
        ViewStub viewStub = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(viewStub, "");
        viewStub.setVisibility(8);
        ViewStub viewStub2 = binding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(viewStub2, "");
        viewStub2.setVisibility(8);
    }

    static /* synthetic */ void getAuthRequestContext$default(PushVerifyActivity pushVerifyActivity, String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, Function1 function1, int i, Object obj) {
        pushVerifyActivity.getAuthRequestContext(str, str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? new Function1<View, Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$showConfirmationDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        } : function1);
    }

    private final void getAuthRequestContext(String p0, String p1, Integer p2, String p3, String p4, String p5, String p6, String p7, String p8, Function1<? super View, Unit> p9) {
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.SubSequence = p0;
        builder.whenAvailable = p5;
        builder.GetContactSyncConfig = p1;
        builder.isLayoutRequested = p6;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        if (p2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = p2.intValue();
        }
        if (p3 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(p3, new Function1<View, Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$showConfirmationDialog$3$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }
            });
            KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance = p7;
        }
        if (p4 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(p4, p9);
            KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4 = p8;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().show();
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setMenuLeftButton(R.drawable.ic_close_white);
        setToolbarTitleContentDescription(getString(R.string.lbl_2fa_request_type));
        setMenuLeftButtonOnClick(new View.OnClickListener() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushVerifyActivity.$r8$lambda$6L6ew7LvylwwPwqhvFibAuBOvHQ(PushVerifyActivity.this, view);
            }
        });
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/pushverify/view/verificationdetail/PushVerifyActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/pushverify/model/PushVerifyParamsModel;", "p1", "", "p2", "Landroid/content/Intent;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Lid/dana/pushverify/model/PushVerifyParamsModel;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent KClassImpl$Data$declaredNonStaticMembers$2(Context p0, PushVerifyParamsModel p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, PushVerifyActivity.class);
            intent.putExtra("push-verify-params", p1);
            intent.putExtra("push-verify-entry-point", p2);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$6L6ew7LvylwwPwqhvFibAuBOvHQ(PushVerifyActivity pushVerifyActivity, View view) {
        Intrinsics.checkNotNullParameter(pushVerifyActivity, "");
        pushVerifyActivity.BuiltInFictitiousFunctionClassFactory(false);
    }

    public static /* synthetic */ void $r8$lambda$9rMtzUaz2FsmhoKH9BtvfAVRlNg(PushVerifyActivity pushVerifyActivity, View view) {
        Intrinsics.checkNotNullParameter(pushVerifyActivity, "");
        BuiltInFictitiousFunctionClassFactory$default(pushVerifyActivity, false, 1, null);
    }

    public static /* synthetic */ void $r8$lambda$MfnYk4WWFANuVY1t9V_nD_g7qNw(PushVerifyActivity pushVerifyActivity, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(pushVerifyActivity, "");
        Intrinsics.checkNotNullExpressionValue(view, "");
        pushVerifyActivity.getAuthRequestContext(view);
    }

    public static /* synthetic */ void $r8$lambda$bwcKCDUaPONN7RPBPmWIfC0XvXo(PushVerifyActivity pushVerifyActivity, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(pushVerifyActivity, "");
        Intrinsics.checkNotNullExpressionValue(view, "");
        pushVerifyActivity.getAuthRequestContext(view);
    }

    public static /* synthetic */ void $r8$lambda$dgbiubp1h61ijZKo1kSQVSzCZbI(PushVerifyActivity pushVerifyActivity, View view) {
        Intrinsics.checkNotNullParameter(pushVerifyActivity, "");
        BuiltInFictitiousFunctionClassFactory$default(pushVerifyActivity, false, 1, null);
    }

    public static /* synthetic */ void $r8$lambda$f6BUpFnwP97IRxj_AtfhwmD0a00(PushVerifyActivity pushVerifyActivity, View view) {
        Intrinsics.checkNotNullParameter(pushVerifyActivity, "");
        pushVerifyActivity.getAuthRequestContext(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x005a  */
    /* renamed from: $r8$lambda$wouMEyU7Z1MR7yW398mLoQa-REI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void m2792$r8$lambda$wouMEyU7Z1MR7yW398mLoQaREI(id.dana.pushverify.view.verificationdetail.PushVerifyActivity r12, android.view.View r13) {
        /*
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r2 = r12.getErrorConfigVersion
            java.lang.String r3 = "BINDING"
            r4 = 609761893(0x24583a65, float:4.6886996E-17)
            java.lang.String r5 = "LOGIN"
            r6 = 72611657(0x453f749, float:2.4916479E-36)
            java.lang.String r7 = "PAYMENT"
            r8 = -68698650(0xfffffffffbe7bde6, float:-2.4065443E36)
            if (r2 == 0) goto L55
            int r9 = r2.hashCode()
            if (r9 == r8) goto L44
            if (r9 == r6) goto L33
            if (r9 != r4) goto L55
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L55
            r2 = 2131956354(0x7f131282, float:1.9549261E38)
            java.lang.String r2 = r12.getString(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            goto L56
        L33:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L55
            r2 = 2131956361(0x7f131289, float:1.9549276E38)
            java.lang.String r2 = r12.getString(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            goto L56
        L44:
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L55
            r2 = 2131956366(0x7f13128e, float:1.9549286E38)
            java.lang.String r2 = r12.getString(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            goto L56
        L55:
            r2 = r1
        L56:
            java.lang.String r9 = r12.getErrorConfigVersion
            if (r9 == 0) goto L97
            int r10 = r9.hashCode()
            if (r10 == r8) goto L86
            if (r10 == r6) goto L75
            if (r10 != r4) goto L97
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L97
            r3 = 2131956353(0x7f131281, float:1.954926E38)
            java.lang.String r3 = r12.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            goto L98
        L75:
            boolean r3 = r9.equals(r5)
            if (r3 == 0) goto L97
            r3 = 2131956360(0x7f131288, float:1.9549274E38)
            java.lang.String r3 = r12.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            goto L98
        L86:
            boolean r3 = r9.equals(r7)
            if (r3 == 0) goto L97
            r3 = 2131956365(0x7f13128d, float:1.9549284E38)
            java.lang.String r3 = r12.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            goto L98
        L97:
            r3 = r1
        L98:
            r1 = 2131956358(0x7f131286, float:1.954927E38)
            java.lang.String r4 = r12.getString(r1)
            r1 = 2131956359(0x7f131287, float:1.9549271E38)
            java.lang.String r5 = r12.getString(r1)
            r1 = 2131954847(0x7f130c9f, float:1.9546205E38)
            java.lang.String r6 = r12.getString(r1)
            r1 = 2131954846(0x7f130c9e, float:1.9546203E38)
            java.lang.String r7 = r12.getString(r1)
            r1 = 2131952290(0x7f1302a2, float:1.9541019E38)
            java.lang.String r8 = r12.getString(r1)
            r1 = 2131952293(0x7f1302a5, float:1.9541025E38)
            java.lang.String r9 = r12.getString(r1)
            r1 = 2131233796(0x7f080c04, float:1.808374E38)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
            id.dana.pushverify.view.verificationdetail.PushVerifyActivity$showDenyDialog$1 r1 = new id.dana.pushverify.view.verificationdetail.PushVerifyActivity$showDenyDialog$1
            r1.<init>()
            r11 = r1
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r0 = r12
            r1 = r2
            r2 = r3
            r3 = r10
            r10 = r11
            r0.getAuthRequestContext(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.verificationdetail.PushVerifyActivity.m2792$r8$lambda$wouMEyU7Z1MR7yW398mLoQaREI(id.dana.pushverify.view.verificationdetail.PushVerifyActivity, android.view.View):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        Parcelable parcelable;
        DaggerPushVerifyComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerPushVerifyComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (PushVerifyModule) Preconditions.getAuthRequestContext(new PushVerifyModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, PushVerifyModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, ApplicationComponent.class);
        new DaggerPushVerifyComponent.PushVerifyComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getPresenter().get());
        ActivityPushVerifyBinding binding = getBinding();
        binding.KClassImpl$Data$declaredNonStaticMembers$2.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$$ExternalSyntheticLambda1
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                PushVerifyActivity.$r8$lambda$bwcKCDUaPONN7RPBPmWIfC0XvXo(PushVerifyActivity.this, viewStub, view);
            }
        });
        binding.getAuthRequestContext.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$$ExternalSyntheticLambda2
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                PushVerifyActivity.$r8$lambda$MfnYk4WWFANuVY1t9V_nD_g7qNw(PushVerifyActivity.this, viewStub, view);
            }
        });
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "");
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (OSUtil.PlaceComponentResult()) {
            parcelable = (Parcelable) intent.getParcelableExtra("push-verify-params", PushVerifyParamsModel.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra("push-verify-params");
            if (!(parcelableExtra instanceof PushVerifyParamsModel)) {
                parcelableExtra = null;
            }
            parcelable = (PushVerifyParamsModel) parcelableExtra;
        }
        PushVerifyParamsModel pushVerifyParamsModel = (PushVerifyParamsModel) parcelable;
        if (pushVerifyParamsModel != null) {
            getPresenter().get().MyBillsEntityDataFactory(pushVerifyParamsModel.getAuthRequestContext, pushVerifyParamsModel.BuiltInFictitiousFunctionClassFactory);
        }
        Intent intent2 = getIntent();
        String stringExtra = intent2 != null ? intent2.getStringExtra("push-verify-entry-point") : null;
        if (stringExtra == null) {
            stringExtra = "Other";
        }
        this.getAuthRequestContext = stringExtra;
    }

    @Override // id.dana.pushverify.view.verificationdetail.PushVerifyContract.View
    public final void onSuccessGetPushVerifyChallenge(PushVerifyChallengeModel pushVerifyChallengeModel) {
        int i;
        int i2;
        if (pushVerifyChallengeModel != null) {
            this.moveToNextValue = pushVerifyChallengeModel.BuiltInFictitiousFunctionClassFactory;
            this.getErrorConfigVersion = pushVerifyChallengeModel.moveToNextValue;
            KClassImpl$Data$declaredNonStaticMembers$2(2);
            String str = pushVerifyChallengeModel.moveToNextValue;
            if (Intrinsics.areEqual(str, "LOGIN")) {
                i = R.string.pushverify_login_toolbar_title;
            } else {
                i = Intrinsics.areEqual(str, "PAYMENT") ? R.string.pushverify_payment_toolbar_title : R.string.pushverify_binding_toolbar_title;
            }
            setCenterTitle(getString(i));
            final LayoutPushVerifyChallengeBinding layoutPushVerifyChallengeBinding = this.BuiltInFictitiousFunctionClassFactory;
            if (layoutPushVerifyChallengeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                layoutPushVerifyChallengeBinding = null;
            }
            String str2 = pushVerifyChallengeModel.moveToNextValue;
            if (Intrinsics.areEqual(str2, "LOGIN")) {
                i2 = R.string.pushverify_login_title;
            } else {
                i2 = Intrinsics.areEqual(str2, "PAYMENT") ? R.string.pushverify_payment_title : R.string.pushverify_binding_title;
            }
            layoutPushVerifyChallengeBinding.DatabaseTableConfigUtil.setText(getString(i2, pushVerifyChallengeModel.BuiltInFictitiousFunctionClassFactory));
            PushVerifyChallengeInfoView pushVerifyChallengeInfoView = layoutPushVerifyChallengeBinding.lookAheadTest;
            pushVerifyChallengeInfoView.setContentDescription(getString(R.string.lbl_2fa_device_model));
            pushVerifyChallengeInfoView.setValue(pushVerifyChallengeModel.getAuthRequestContext);
            PushVerifyChallengeInfoView pushVerifyChallengeInfoView2 = layoutPushVerifyChallengeBinding.initRecordTimeStamp;
            pushVerifyChallengeInfoView2.setContentDescription(getString(R.string.lbl_2fa_device_time));
            pushVerifyChallengeInfoView2.setValue(pushVerifyChallengeModel.getErrorConfigVersion);
            layoutPushVerifyChallengeBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.setContentDescription(getString(R.string.lbl_2fa_expiry_time));
            VerificationExpiryUtil verificationExpiryUtil = VerificationExpiryUtil.getAuthRequestContext;
            VerificationExpiryUtil.MyBillsEntityDataFactory(this, pushVerifyChallengeModel.KClassImpl$Data$declaredNonStaticMembers$2, new Function1<String, Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$setupChallengeLayout$1$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str3) {
                    invoke2(str3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str3) {
                    Intrinsics.checkNotNullParameter(str3, "");
                    LayoutPushVerifyChallengeBinding.this.NetworkUserEntityData$$ExternalSyntheticLambda0.setValue(str3);
                }
            }, new Function0<Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$setupChallengeLayout$1$1$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PushVerifyActivity.this.onExpiredGetPushVerifyChallenge();
                }
            });
            GlideApp.PlaceComponentResult(this).PlaceComponentResult(pushVerifyChallengeModel.MyBillsEntityDataFactory).getErrorConfigVersion((int) R.drawable.ic_default_merchant_logo).PlaceComponentResult((int) R.drawable.ic_default_merchant_logo).MyBillsEntityDataFactory((ImageView) layoutPushVerifyChallengeBinding.getErrorConfigVersion);
            layoutPushVerifyChallengeBinding.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PushVerifyActivity.$r8$lambda$f6BUpFnwP97IRxj_AtfhwmD0a00(PushVerifyActivity.this, view);
                }
            });
            layoutPushVerifyChallengeBinding.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PushVerifyActivity.m2792$r8$lambda$wouMEyU7Z1MR7yW398mLoQaREI(PushVerifyActivity.this, view);
                }
            });
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = PrepareContext;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = PrepareContext;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
            }
            int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
