package id.dana.promocode.views;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.ExpandableListView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerRedeemPromoCodeComponent;
import id.dana.di.modules.RedeemPromoCodeModule;
import id.dana.domain.promoquest.model.PrizeInfoEntity;
import id.dana.extension.ContextExtKt;
import id.dana.extension.lang.StringExtKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.promocode.RedeemPromoCodeContract;
import id.dana.promocode.utils.PromoCodeUtil;
import id.dana.promocode.views.PromoCodeBottomSheet;
import id.dana.richview.LogoProgressView;
import id.dana.textbehavior.InvalidReason;
import id.dana.textbehavior.OnValidatedListener;
import id.dana.textbehavior.TextBehavior;
import id.dana.textbehavior.validate.Validator;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.KeyboardHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b:\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\b\u0010\u0017J+\u0010\u001b\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010 \u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010\u000bJ\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b\u0015\u0010$J\u0013\u0010%\u001a\u00020\u0003*\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u0010\u0014\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\b\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010\u0015\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u0010/"}, d2 = {"Lid/dana/promocode/views/RedeemPromoCodeActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/promocode/RedeemPromoCodeContract$View;", "", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZLjava/lang/String;)V", "dismissProgress", "()V", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View;", "(Landroid/view/View;)Z", "errorCode", "errorMessage", "code", "onErrorResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/promoquest/model/PrizeInfoEntity;", "prizeInfoEntity", "campaignId", "onRedeemResult", "(Ljava/lang/String;Lid/dana/domain/promoquest/model/PrizeInfoEntity;Ljava/lang/String;)V", "showProgress", "Lid/dana/promocode/views/PromoCodeBottomSheet;", "(Lid/dana/promocode/views/PromoCodeBottomSheet;)V", "PlaceComponentResult", "(Ljava/lang/String;)Z", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "getErrorConfigVersion", "Z", "lookAheadTest", "Lid/dana/domain/promoquest/model/PrizeInfoEntity;", "Lid/dana/promocode/RedeemPromoCodeContract$Presenter;", "redeemPromoCodePresenter", "Lid/dana/promocode/RedeemPromoCodeContract$Presenter;", "getRedeemPromoCodePresenter", "()Lid/dana/promocode/RedeemPromoCodeContract$Presenter;", "setRedeemPromoCodePresenter", "(Lid/dana/promocode/RedeemPromoCodeContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RedeemPromoCodeActivity extends BaseActivity implements RedeemPromoCodeContract.View {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private PrizeInfoEntity KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public RedeemPromoCodeContract.Presenter redeemPromoCodePresenter;
    public static final byte[] $$a = {42, -75, 2, Ascii.US, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 229;
    public static final byte[] getAuthRequestContext = {112, Ascii.US, -51, -82, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 145;
    private static char initRecordTimeStamp = 42376;
    private static char scheduleImpl = 1954;
    private static char GetContactSyncConfig = 14196;
    private static char DatabaseTableConfigUtil = 23322;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            int r7 = 23 - r7
            byte[] r0 = id.dana.promocode.views.RedeemPromoCodeActivity.getAuthRequestContext
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L2a
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L22:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2a:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-4)
            int r7 = r7 + 1
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promocode.views.RedeemPromoCodeActivity.b(byte, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r0 = id.dana.promocode.views.RedeemPromoCodeActivity.$$a
            int r7 = 46 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            int r7 = r7 + 1
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promocode.views.RedeemPromoCodeActivity.c(byte, int, int, java.lang.Object[]):void");
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
        a(18 - Color.green(0), new char[]{12618, 41102, 5226, 27187, 9570, 33163, 36250, 63609, 24892, 39399, 19108, 53771, 15374, 282, 30173, 48917, 24900, 58250}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 5, new char[]{53546, 26077, 9133, 32736, 4805, 13532}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 47, new char[]{42218, 50477, 28227, 4985, 46407, 938, 25634, 23273, 41535, 49801, 51344, 25288, 11409, 11643, 25938, 16512, 12303, 56503, 30507, 14979, 18444, 26101, 60437, 16564, 47983, 40924, 58599, 4177, 29039, 13833, 2681, 23424, 63859, 34349, 28371, 2967, 12317, 13839, 29195, 25077, 19355, 39264, 63226, 47451, 29843, 47844, 25327, 55845}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - TextUtils.getCapsMode("", 0, 0), new char[]{48994, 56900, 50533, 41009, 12317, 13839, 52873, 20353, 18444, 26101, 19200, 37657, 5995, 44277, 32435, 9715, 38845, 58983, 61089, 61692, 5995, 44277, 58871, 59089, 37224, 51163, 3689, 49336, 58599, 4177, 38845, 58983, 52479, 54688, 62375, 54209, 34173, Typography.euro, 15018, 16686, 44205, 46723, 1554, 41853, 60535, 29053, 51371, 31265, 38328, 30, 51874, 50347, 64754, 32241, 17713, 6678, 17713, 6678, 45902, 26021, 60349, 30763, 47983, 40924}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{29306, 50675, 33895, 11033, 64754, 32241, 21819, 38221, 29653, 8538, 59207, 42823, 9850, 17333, 51772, 49947, 2681, 23424, 45138, 64665, 42006, 12270, 3780, 40424, 19355, 39264, 25634, 23273, 24132, 26181, 42218, 50477, 26446, 49334, 34534, 52476, 56924, 29705, 28227, 4985, 49921, 30188, 32435, 9715, 29195, 25077, 59481, 18923, 12317, 13839, 30173, 48917, 29306, 50675, 6777, 38482, 57585, 30691, 63859, 34349, 6777, 38482, 61270, 64072}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((KeyEvent.getMaxKeyCode() >> 16) + 60, new char[]{61445, 5437, 15796, 22971, 44164, 1645, 5790, 44559, 18442, 7015, 53332, 31441, 35818, 44095, 2773, 22832, 41563, 15821, 63856, 30034, 13672, 62640, 31248, 55399, 20240, 31109, 49705, 23920, 55859, 27532, 32313, 61054, 49705, 23920, 11198, 16472, 56900, 19072, 60449, 12971, 27005, 53310, 26318, 18707, 18894, 39901, 10699, 42973, 6163, 14458, 57840, 51226, 20444, 16782, 29266, 2717, 28665, 9571, 64056, 48781}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(TextUtils.getOffsetAfter("", 0) + 6, new char[]{34373, 4911, 26069, 31573, 29306, 50675}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, View.MeasureSpec.getMode(0) + 18, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) 37, getAuthRequestContext[30], getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (-getAuthRequestContext[35]), getAuthRequestContext[30], getAuthRequestContext[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(54 - ExpandableListView.getPackedPositionChild(0L), 4 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) Color.green(0));
                        Object[] objArr16 = new Object[1];
                        c($$a[53], $$a[12], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 800, KeyEvent.keyCodeFromString("") + 15, (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 800, 14 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - ExpandableListView.getPackedPositionChild(0L), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 29, (char) (57994 - (ViewConfiguration.getTouchSlop() >> 8)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ((Process.getThreadPriority(0) + 20) >> 6), (Process.myPid() >> 22) + 15, (char) (ViewConfiguration.getTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1410535178, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), 18 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) 37, getAuthRequestContext[30], getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (-getAuthRequestContext[35]), getAuthRequestContext[30], getAuthRequestContext[9], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 45 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ExpandableListView.getPackedPositionGroup(0L));
                        Object[] objArr22 = new Object[1];
                        c($$a[84], (byte) ($$a[78] - 1), $$a[8], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, Color.alpha(0) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1410535178, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) 37, getAuthRequestContext[30], getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (-getAuthRequestContext[35]), getAuthRequestContext[30], getAuthRequestContext[9], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), TextUtils.lastIndexOf("", '0') + 4, (char) (38968 - (ViewConfiguration.getLongPressTimeout() >> 16)));
                        Object[] objArr28 = new Object[1];
                        c($$a[84], (byte) ($$a[78] - 1), $$a[8], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0) + 36, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1410535178, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, (Process.myTid() >> 22) + 18, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) 37, getAuthRequestContext[30], getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (-getAuthRequestContext[35]), getAuthRequestContext[30], getAuthRequestContext[9], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 3 - TextUtils.getTrimmedLength(""), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[9], (byte) ($$a[78] - 1), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1410535178, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 18 - View.resolveSize(0, 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_redeem_promo_code;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        a(TextUtils.indexOf("", "", 0, 0) + 18, new char[]{12618, 41102, 5226, 27187, 9570, 33163, 36250, 63609, 24892, 39399, 19108, 53771, 15374, 282, 30173, 48917, 24900, 58250}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(R.string.platform_service_fee).substring(2, 3).codePointAt(0) - 92, new char[]{53546, 26077, 9133, 32736, 4805, 13532}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    byte b = getAuthRequestContext[25];
                    Object[] objArr3 = new Object[1];
                    b(b, b, (byte) (-getAuthRequestContext[32]), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{12618, 41102, 5226, 27187, 9570, 33163, 36250, 63609, 27005, 53310, 18849, 32437, 1129, 6239, 44327, 37753, 36828, 12344, 39557, 24442, 52458, 17922, 9366, 12652, 18724, 28211}, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    a(super.getResources().getString(R.string.profile_completion_task_description_dana_viz).substring(1, 2).length() + 17, new char[]{57449, 37390, 2424, 28691, 28665, 9571, 49665, 30078, 42693, 22727, 65330, 42187, 41050, 59213, 44327, 37753, 58344, 1592}, objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.empty_state_bill_detail_title).substring(16, 17).length() + 47, new char[]{42218, 50477, 28227, 4985, 46407, 938, 25634, 23273, 41535, 49801, 51344, 25288, 11409, 11643, 25938, 16512, 12303, 56503, 30507, 14979, 18444, 26101, 60437, 16564, 47983, 40924, 58599, 4177, 29039, 13833, 2681, 23424, 63859, 34349, 28371, 2967, 12317, 13839, 29195, 25077, 19355, 39264, 63226, 47451, 29843, 47844, 25327, 55845}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(getPackageName().length() + 57, new char[]{48994, 56900, 50533, 41009, 12317, 13839, 52873, 20353, 18444, 26101, 19200, 37657, 5995, 44277, 32435, 9715, 38845, 58983, 61089, 61692, 5995, 44277, 58871, 59089, 37224, 51163, 3689, 49336, 58599, 4177, 38845, 58983, 52479, 54688, 62375, 54209, 34173, Typography.euro, 15018, 16686, 44205, 46723, 1554, 41853, 60535, 29053, 51371, 31265, 38328, 30, 51874, 50347, 64754, 32241, 17713, 6678, 17713, 6678, 45902, 26021, 60349, 30763, 47983, 40924}, objArr7);
                    String str2 = (String) objArr7[0];
                    try {
                        byte b2 = getAuthRequestContext[25];
                        Object[] objArr8 = new Object[1];
                        b(b2, b2, (byte) (-getAuthRequestContext[32]), objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[41], getAuthRequestContext[48], objArr9);
                        Object[] objArr10 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{29306, 50675, 33895, 11033, 64754, 32241, 21819, 38221, 29653, 8538, 59207, 42823, 9850, 17333, 51772, 49947, 2681, 23424, 45138, 64665, 42006, 12270, 3780, 40424, 19355, 39264, 25634, 23273, 24132, 26181, 42218, 50477, 26446, 49334, 34534, 52476, 56924, 29705, 28227, 4985, 49921, 30188, 32435, 9715, 29195, 25077, 59481, 18923, 12317, 13839, 30173, 48917, 29306, 50675, 6777, 38482, 57585, 30691, 63859, 34349, 6777, 38482, 61270, 64072}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.redeem).substring(1, 5).codePointAt(2) - 45, new char[]{61445, 5437, 15796, 22971, 44164, 1645, 5790, 44559, 18442, 7015, 53332, 31441, 35818, 44095, 2773, 22832, 41563, 15821, 63856, 30034, 13672, 62640, 31248, 55399, 20240, 31109, 49705, 23920, 55859, 27532, 32313, 61054, 49705, 23920, 11198, 16472, 56900, 19072, 60449, 12971, 27005, 53310, 26318, 18707, 18894, 39901, 10699, 42973, 6163, 14458, 57840, 51226, 20444, 16782, 29266, 2717, 28665, 9571, 64056, 48781}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(6 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{34373, 4911, 26069, 31573, 29306, 50675}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
            Object[] objArr14 = new Object[1];
            b((byte) 37, getAuthRequestContext[30], getAuthRequestContext[25], objArr14);
            Class<?> cls5 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b((byte) (-getAuthRequestContext[35]), getAuthRequestContext[30], getAuthRequestContext[9], objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 5, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1));
                    Object[] objArr17 = new Object[1];
                    c((byte) ($$a[78] - 1), $$a[9], (byte) ($$a[78] - 1), objArr17);
                    obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), (-16777181) - Color.rgb(0, 0, 0), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr19 = {1709897327, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
                super.onCreate(bundle);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(26 - Color.red(0), new char[]{12618, 41102, 5226, 27187, 9570, 33163, 36250, 63609, 27005, 53310, 18849, 32437, 1129, 6239, 44327, 37753, 36828, 12344, 39557, 24442, 52458, 17922, 9366, 12652, 18724, 28211}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().length() + 11, new char[]{57449, 37390, 2424, 28691, 28665, 9571, 49665, 30078, 42693, 22727, 65330, 42187, 41050, 59213, 44327, 37753, 58344, 1592}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), View.resolveSize(0, 0) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                b(b, b, (byte) (-getAuthRequestContext[32]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{12618, 41102, 5226, 27187, 9570, 33163, 36250, 63609, 27005, 53310, 18849, 32437, 1129, 6239, 44327, 37753, 36828, 12344, 39557, 24442, 52458, 17922, 9366, 12652, 18724, 28211}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                try {
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr3 = new Object[1];
                    b(b2, b2, (byte) (-getAuthRequestContext[32]), objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[41], getAuthRequestContext[48], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(((ApplicationInfo) cls3.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{57449, 37390, 2424, 28691, 28665, 9571, 49665, 30078, 42693, 22727, 65330, 42187, 41050, 59213, 44327, 37753, 58344, 1592}, objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) Drawable.resolveOpacity(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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

    @JvmName(name = "getRedeemPromoCodePresenter")
    public final RedeemPromoCodeContract.Presenter getRedeemPromoCodePresenter() {
        RedeemPromoCodeContract.Presenter presenter = this.redeemPromoCodePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRedeemPromoCodePresenter")
    public final void setRedeemPromoCodePresenter(RedeemPromoCodeContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.redeemPromoCodePresenter = presenter;
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if (dynamicUrlWrapper != null) {
            return dynamicUrlWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        String stringExtra;
        String string;
        ContextExtKt.PlaceComponentResult(this);
        DaggerRedeemPromoCodeComponent.Builder PlaceComponentResult2 = DaggerRedeemPromoCodeComponent.PlaceComponentResult();
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult2.PlaceComponentResult = (RedeemPromoCodeModule) Preconditions.getAuthRequestContext(new RedeemPromoCodeModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.PlaceComponentResult, RedeemPromoCodeModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        byte b = 0;
        new DaggerRedeemPromoCodeComponent.RedeemPromoCodeComponentImpl(PlaceComponentResult2.PlaceComponentResult, PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, b).MyBillsEntityDataFactory(this);
        registerPresenter(getRedeemPromoCodePresenter());
        KeyboardHelper.PlaceComponentResult(getWindow().getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.promocode.views.RedeemPromoCodeActivity$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                RedeemPromoCodeActivity.this.MyBillsEntityDataFactory = true;
                RedeemPromoCodeActivity redeemPromoCodeActivity = RedeemPromoCodeActivity.this;
                EditText editText = (EditText) redeemPromoCodeActivity._$_findCachedViewById(R.id.tryToInjectStartupParamsAndPushWorker);
                Intrinsics.checkNotNullExpressionValue(editText, "");
                KClassImpl$Data$declaredNonStaticMembers$2 = redeemPromoCodeActivity.KClassImpl$Data$declaredNonStaticMembers$2(editText);
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    ((NestedScrollView) r0._$_findCachedViewById(R.id.judgeRes)).post(new Runnable() { // from class: id.dana.promocode.views.RedeemPromoCodeActivity$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            RedeemPromoCodeActivity.$r8$lambda$wCbuCjVx9bLhXrrD9MBshQxO3WU(RedeemPromoCodeActivity.this);
                        }
                    });
                }
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                RedeemPromoCodeActivity.this.MyBillsEntityDataFactory = false;
            }
        });
        String str = "";
        setCenterTitle("");
        setMenuLeftButton(R.drawable.btn_arrow_left);
        TextBehavior.EditTextBehaviorBuilder PlaceComponentResult3 = TextBehavior.Builder.PlaceComponentResult((EditText) _$_findCachedViewById(R.id.tryToInjectStartupParamsAndPushWorker));
        Validator validator = new Validator() { // from class: id.dana.promocode.views.RedeemPromoCodeActivity$setupPromoCodeInput$1
            @Override // id.dana.textbehavior.validate.Validator
            public final boolean MyBillsEntityDataFactory(String p0) {
                boolean PlaceComponentResult4;
                if (p0 != null) {
                    RedeemPromoCodeActivity redeemPromoCodeActivity = RedeemPromoCodeActivity.this;
                    PlaceComponentResult4 = RedeemPromoCodeActivity.PlaceComponentResult(p0);
                    return PlaceComponentResult4;
                }
                return false;
            }

            @Override // id.dana.textbehavior.validate.Validator
            public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                String string2 = RedeemPromoCodeActivity.this.getString(R.string.error_promocode_character_length_not_valid);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                return string2;
            }
        };
        if (PlaceComponentResult3.BuiltInFictitiousFunctionClassFactory == null) {
            PlaceComponentResult3.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        }
        PlaceComponentResult3.BuiltInFictitiousFunctionClassFactory.add(validator);
        PlaceComponentResult3.MyBillsEntityDataFactory = new OnValidatedListener() { // from class: id.dana.promocode.views.RedeemPromoCodeActivity$setupPromoCodeInput$2
            @Override // id.dana.textbehavior.OnValidatedListener
            public final void MyBillsEntityDataFactory(String p0, List<InvalidReason> p1) {
                View _$_findCachedViewById = RedeemPromoCodeActivity.this._$_findCachedViewById(R.id.NotificationTarget);
                RedeemPromoCodeActivity redeemPromoCodeActivity = RedeemPromoCodeActivity.this;
                Integer valueOf = p0 != null ? Integer.valueOf(p0.length()) : null;
                if (valueOf != null) {
                    _$_findCachedViewById.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(redeemPromoCodeActivity, valueOf.intValue() > 0 ? 17170443 : R.color.res_0x7f060349_networkuserentitydata_externalsyntheticlambda2));
                    RedeemPromoCodeActivity.KClassImpl$Data$declaredNonStaticMembers$2$default(RedeemPromoCodeActivity.this, false, null, 2, null);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }

            @Override // id.dana.textbehavior.OnValidatedListener
            public final void getAuthRequestContext(String p0) {
                RedeemPromoCodeActivity.this._$_findCachedViewById(R.id.NotificationTarget).setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(RedeemPromoCodeActivity.this, 17170443));
                RedeemPromoCodeActivity.KClassImpl$Data$declaredNonStaticMembers$2$default(RedeemPromoCodeActivity.this, true, null, 2, null);
            }
        };
        PlaceComponentResult3.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2$default(this, false, null, 2, null);
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getDefaultSenderId_res_0x7f0a0238);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocode.views.RedeemPromoCodeActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RedeemPromoCodeActivity.$r8$lambda$j38Gp_4IDpFZq_KpfHJhwlhuwh4(RedeemPromoCodeActivity.this, view);
                }
            });
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && (string = extras.getString("promoCode")) != null) {
            String str2 = StringExtKt.BuiltInFictitiousFunctionClassFactory((CharSequence) string) ? string : null;
            if (str2 != null) {
                ((EditText) _$_findCachedViewById(R.id.tryToInjectStartupParamsAndPushWorker)).setText(StringsKt.take(str2, 10));
            }
        }
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMO_CODE_OPEN;
        Intent intent = getIntent();
        if (intent != null && (stringExtra = intent.getStringExtra("source")) != null) {
            str = stringExtra;
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", str);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev != null && ev.getAction() == 0 && MyBillsEntityDataFactory(ev)) {
            KeyboardHelper.MyBillsEntityDataFactory(this);
        }
        return super.dispatchTouchEvent(ev);
    }

    private final boolean MyBillsEntityDataFactory(MotionEvent p0) {
        return this.MyBillsEntityDataFactory && !BuiltInFictitiousFunctionClassFactory(p0);
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(MotionEvent p0) {
        Rect rect = new Rect();
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getDefaultSenderId_res_0x7f0a0238);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.getGlobalVisibleRect(rect);
            return rect.contains((int) p0.getRawX(), (int) p0.getRawY());
        }
        return false;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        LogoProgressView logoProgressView = (LogoProgressView) _$_findCachedViewById(R.id.progress_view);
        if (logoProgressView != null) {
            logoProgressView.setVisibility(0);
            logoProgressView.startRefresh();
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        LogoProgressView logoProgressView = (LogoProgressView) _$_findCachedViewById(R.id.progress_view);
        if (logoProgressView != null) {
            logoProgressView.setVisibility(8);
            logoProgressView.stopRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean PlaceComponentResult(String str) {
        int length = str.length();
        return 4 <= length && length <= 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2$default(RedeemPromoCodeActivity redeemPromoCodeActivity, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = redeemPromoCodeActivity.getString(R.string.title_btn_redeem);
            Intrinsics.checkNotNullExpressionValue(str, "");
        }
        redeemPromoCodeActivity.KClassImpl$Data$declaredNonStaticMembers$2(z, str);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, String p1) {
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getDefaultSenderId_res_0x7f0a0238);
        if (danaButtonSecondaryView != null) {
            if (p0) {
                danaButtonSecondaryView.setActiveButton(p1, null);
            } else {
                danaButtonSecondaryView.setDisabled(p1);
            }
            danaButtonSecondaryView.setEnabled(p0);
        }
    }

    @Override // id.dana.promocode.RedeemPromoCodeContract.View
    public final void onRedeemResult(String code, PrizeInfoEntity prizeInfoEntity, String campaignId) {
        Intrinsics.checkNotNullParameter(code, "");
        this.BuiltInFictitiousFunctionClassFactory = true;
        trackPromoCodeResult$default(this, true, code, campaignId, null, 8, null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = prizeInfoEntity;
        RedeemPromoCodeActivity redeemPromoCodeActivity = this;
        String voucherName = prizeInfoEntity != null ? prizeInfoEntity.getVoucherName() : null;
        BuiltInFictitiousFunctionClassFactory(PromoCodeUtil.getAuthRequestContext(redeemPromoCodeActivity, voucherName != null ? voucherName : ""));
        KClassImpl$Data$declaredNonStaticMembers$2$default(this, true, null, 2, null);
    }

    @Override // id.dana.promocode.RedeemPromoCodeContract.View
    public final void onErrorResult(String errorCode, String errorMessage, String code) {
        Intrinsics.checkNotNullParameter(code, "");
        this.BuiltInFictitiousFunctionClassFactory = false;
        trackPromoCodeResult$default(this, false, code, null, errorMessage, 4, null);
        KClassImpl$Data$declaredNonStaticMembers$2$default(this, true, null, 2, null);
        BuiltInFictitiousFunctionClassFactory(PromoCodeUtil.MyBillsEntityDataFactory(this, errorCode));
    }

    private final void BuiltInFictitiousFunctionClassFactory(final PromoCodeBottomSheet p0) {
        if (p0 != null) {
            p0.getAuthRequestContext = new PromoCodeBottomSheet.PromocodeBottomSheetListener() { // from class: id.dana.promocode.views.RedeemPromoCodeActivity$showPromoCodeBottomSheet$1$1
                @Override // id.dana.promocode.views.PromoCodeBottomSheet.PromocodeBottomSheetListener
                public final void MyBillsEntityDataFactory() {
                    RedeemPromoCodeActivity.this.finish();
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
                
                    r0 = r2.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                 */
                @Override // id.dana.promocode.views.PromoCodeBottomSheet.PromocodeBottomSheetListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    /*
                        r2 = this;
                        id.dana.promocode.views.RedeemPromoCodeActivity r0 = id.dana.promocode.views.RedeemPromoCodeActivity.this
                        boolean r0 = id.dana.promocode.views.RedeemPromoCodeActivity.access$getSuccessRedeem$p(r0)
                        if (r0 == 0) goto L19
                        id.dana.promocode.views.RedeemPromoCodeActivity r0 = id.dana.promocode.views.RedeemPromoCodeActivity.this
                        id.dana.domain.promoquest.model.PrizeInfoEntity r0 = id.dana.promocode.views.RedeemPromoCodeActivity.access$getPrizeInfoEntity$p(r0)
                        if (r0 == 0) goto L19
                        id.dana.promocode.views.RedeemPromoCodeActivity r1 = id.dana.promocode.views.RedeemPromoCodeActivity.this
                        id.dana.data.dynamicurl.DynamicUrlWrapper r1 = r1.getDynamicUrlWrapper()
                        id.dana.promoquest.extension.PrizeInfoEntityExtKt.PlaceComponentResult(r0, r1)
                    L19:
                        id.dana.promocode.views.PromoCodeBottomSheet r0 = r2
                        r0.dismiss()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.promocode.views.RedeemPromoCodeActivity$showPromoCodeBottomSheet$1$1.KClassImpl$Data$declaredNonStaticMembers$2():void");
                }
            };
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            Intrinsics.checkNotNullParameter(supportFragmentManager, "");
            p0.show(supportFragmentManager, "promo_code_bottomsheet_tag");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(View p0) {
        Rect rect = new Rect();
        ((NestedScrollView) _$_findCachedViewById(R.id.judgeRes)).getDrawingRect(rect);
        float y = p0.getY();
        return ((float) rect.top) < y && ((float) rect.bottom) > ((float) p0.getHeight()) + y;
    }

    public static /* synthetic */ void $r8$lambda$j38Gp_4IDpFZq_KpfHJhwlhuwh4(RedeemPromoCodeActivity redeemPromoCodeActivity, View view) {
        Intrinsics.checkNotNullParameter(redeemPromoCodeActivity, "");
        KeyboardHelper.MyBillsEntityDataFactory(redeemPromoCodeActivity);
        redeemPromoCodeActivity.getRedeemPromoCodePresenter().BuiltInFictitiousFunctionClassFactory(((EditText) redeemPromoCodeActivity._$_findCachedViewById(R.id.tryToInjectStartupParamsAndPushWorker)).getText().toString());
        String string = redeemPromoCodeActivity.getString(R.string.title_btn_redeem_on_submit);
        Intrinsics.checkNotNullExpressionValue(string, "");
        redeemPromoCodeActivity.KClassImpl$Data$declaredNonStaticMembers$2(false, string);
    }

    public static /* synthetic */ void $r8$lambda$wCbuCjVx9bLhXrrD9MBshQxO3WU(RedeemPromoCodeActivity redeemPromoCodeActivity) {
        Intrinsics.checkNotNullParameter(redeemPromoCodeActivity, "");
        ((NestedScrollView) redeemPromoCodeActivity._$_findCachedViewById(R.id.judgeRes)).fullScroll(130);
    }

    static /* synthetic */ void trackPromoCodeResult$default(RedeemPromoCodeActivity redeemPromoCodeActivity, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(redeemPromoCodeActivity);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMO_CODE_RESULT;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.NearbyMerchantProperty.PROMO_CODE, str).BuiltInFictitiousFunctionClassFactory("Success", z).MyBillsEntityDataFactory(TrackerKey.NearbyMerchantProperty.CAMPAIGN_ID, str2).MyBillsEntityDataFactory("Fail Reason", str3);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (DatabaseTableConfigUtil ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (GetContactSyncConfig ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (scheduleImpl ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (initRecordTimeStamp ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
