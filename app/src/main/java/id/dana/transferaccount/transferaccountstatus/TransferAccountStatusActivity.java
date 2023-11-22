package id.dana.transferaccount.transferaccountstatus;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.view.ComponentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.danah5.DanaH5;
import id.dana.databinding.ActivityTransferAccountStatusBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerTransferAccountComponent;
import id.dana.di.modules.TransferAccountModule;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.transferaccount.success.TransferAccountSuccessActivity;
import id.dana.transferaccount.transferaccountstatus.TransferAccountContract;
import id.dana.utils.PhoneCall;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/transferaccount/transferaccountstatus/TransferAccountStatusActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityTransferAccountStatusBinding;", "", IAPSyncCommand.COMMAND_INIT, "()V", "initViewBinding", "()Lid/dana/databinding/ActivityTransferAccountStatusBinding;", "onBackPressed", "onPause", "onResume", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "PlaceComponentResult", "Lid/dana/transferaccount/transferaccountstatus/TransferAccountContract$Presenter;", "presenter", "Lid/dana/transferaccount/transferaccountstatus/TransferAccountContract$Presenter;", "getPresenter", "()Lid/dana/transferaccount/transferaccountstatus/TransferAccountContract$Presenter;", "setPresenter", "(Lid/dana/transferaccount/transferaccountstatus/TransferAccountContract$Presenter;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransferAccountStatusActivity extends ViewBindingActivity<ActivityTransferAccountStatusBinding> {
    public static final byte[] $$a = {65, TarHeader.LF_CHR, -100, -34, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 7;
    public static final byte[] PlaceComponentResult = {Ascii.DC4, -68, -64, 70, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 4;
    private static long lookAheadTest = -2904821144257555776L;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final ActivityPermissionRequest PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public TransferAccountContract.Presenter presenter;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 55 - r8
            int r6 = r6 + 97
            int r7 = r7 + 16
            byte[] r0 = id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity.PlaceComponentResult
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L32
        L16:
            r3 = 0
        L17:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L32:
            int r6 = -r6
            int r7 = r7 + r6
            int r6 = r7 + (-4)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity.b(int, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r0 = id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity.$$a
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
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
        L38:
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity.c(byte, int, int, java.lang.Object[]):void");
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
        a(26479 - View.resolveSizeAndState(0, 0, 0), new char[]{50146, 42114, 3385, 62908, 24144, 50881, 44925, 6052, 63636, 24855, 51707, 45590, 6853, 33615, 27634, 52327, 46336, 7599}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(17783 - View.MeasureSpec.getSize(0), new char[]{50158, 34445, 18744, 5007, 54843}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 34 - MotionEvent.axisFromString(""), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(21433 - (ViewConfiguration.getTapTimeout() >> 16), new char[]{50100, 36953, 25799, 14480, 36183, 24954, 13804, 35252, 24188, 12903, 34522, 23318, 12106, 33748, 22444, 9314, 63522, 19707, 8375, 62809, 18835, 7629, 61958, 17962, 6847, 61089, 17265, 5988, 60301, 47122, 3148, 57473, 46234, 2412, 56611, 45553, 1505, 55815, 44749, 668, 55132, 43844, 32749, 54182, 41005, 29749, 51339, 40209}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(View.combineMeasuredStates(0, 0) + 7703, new char[]{50146, 56737, 65435, 39330, 48057, 21961, 30521, 4378, 13151, 52527, 61276, 35147, 43763, 17561, 26352, 238, 8897, 15414, 56955, 63495, 39467, 46161, 22095, 30625, 4509, 13278, 52716, 61323, 35135, 43900, 17667, 26488, 256, 8976, 15545, 56990, 63708, 39603, 46297, 22065, 28718, 4636, 11296, 52847, 59412, 35263, 43920, 17805, 26592, 471, 9162, 15663, 57110, 63863, 39785, 46403, 22203, 28845, 4822, 11436, 52950, 59584, 35445, 42009}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(31247 - (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{50097, 47549, 14328, 44492, 11142, 41471, 8171, 38366, 5059, 35132, 1837, 64791, 31494, 61811, 28513, 58709, 25362, 55577, 22201, 52474, 19101, 49370, 48808, 13545, 45788, 10386, 42556, 7214, 39489, 4182, 36470, 1073, 33364, 30728, 63055, 29622, 59901, 26527, 56719, 23538, 53731, 20354, 50628, 17202, 14639, 46864, 11600, 43808, 8501, 40805, 5390, 37659, 2237, 34473, 31951, 64143, 28924, 61153, 25820, 58048, 22625, 54821, 19476, 51723}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(TextUtils.getCapsMode("", 0, 0) + 58943, new char[]{50155, 9672, 3977, 29006, 23308, 48258, 42710, 34837, 61983, 56277, 15771, 10071, 2393, 29380, 21657, 48704, 40982, 35277, 62361, 54605, 16142, 8411, 2717, 27652, 22028, 49105, 41348, 35668, 60675, 54995, 14480, 8791, 1026, 28142, 22456, 47408, 41788, 34039, 61108, 53301, 14906, 9188, 1468, 28473, 20798, 47870, 40118, 34423, 59424, 53752, 15330, 7544, 1917, 26791, 21164, 46204, 40494, 34794, 59825, 54133}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(Color.blue(0) + 27479, new char[]{50106, 43258, 5401, 33192, 28397, 56065}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (getAuthRequestContext + 4);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | Ascii.RS), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 3, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1));
                        byte b3 = $$a[47];
                        byte b4 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b3, b4, b4, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 800, 15 - TextUtils.indexOf("", "", 0), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.argb(0, 0, 0, 0), Color.red(0) + 15, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.indexOf((CharSequence) "", '0'), ImageFormat.getBitsPerPixel(0) + 30, (char) (57994 - View.resolveSize(0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getCapsMode("", 0, 0), TextUtils.lastIndexOf("", '0', 0) + 16, (char) (ViewConfiguration.getTapTimeout() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionType(0L), (char) (MotionEvent.axisFromString("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1252622162, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b5 = (byte) (getAuthRequestContext + 4);
                byte b6 = PlaceComponentResult[25];
                Object[] objArr20 = new Object[1];
                b(b5, b6, (byte) (b6 | Ascii.RS), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 61, 47 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)));
                        Object[] objArr22 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1252622162, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 910, 18 - KeyEvent.normalizeMetaState(0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b7 = (byte) (getAuthRequestContext + 4);
                byte b8 = PlaceComponentResult[25];
                Object[] objArr26 = new Object[1];
                b(b7, b8, (byte) (b8 | Ascii.RS), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 3 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (38967 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)));
                        Object[] objArr28 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1252622162, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b9 = (byte) (getAuthRequestContext + 4);
                byte b10 = PlaceComponentResult[25];
                Object[] objArr32 = new Object[1];
                b(b9, b10, (byte) (b10 | Ascii.RS), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 106, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[40]), (byte) $$b, (byte) ($$a[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.combineMeasuredStates(0, 0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1252622162, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 910, 18 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (getAuthRequestContext | 48), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], objArr3);
            Object[] objArr4 = new Object[1];
            a(((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 26446, new char[]{50146, 42114, 3385, 62908, 24144, 50881, 44925, 6052, 63636, 24855, 51707, 45590, 6853, 33615, 27634, 52327, 46336, 7599}, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            a(super.getResources().getString(R.string.passkey_faq_two_desc).substring(35, 37).codePointAt(0) + 17686, new char[]{50158, 34445, 18744, 5007, 54843}, objArr5);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.force_face_auth_content).substring(17, 18).codePointAt(0) + 22532, new char[]{50146, 39808, 29501, 51894, 41560, 31179, 53609, 43350, 138, 55334, 47025, 3842, 59102, 48745, 5633, 60809, 17701, 7383, 62557, 21485, 11091, 33562, 23215, 12845, 35290, 24898}, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    a(getPackageName().length() + 6892, new char[]{50144, 55557, 62999, 37672, 43050, 17746, 25157, 32615, 5227, 12664, 52881, 60315, 32900, 40373, 47805, 22487, 27868, 2510}, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        a(super.getResources().getString(R.string.ac_service_title).substring(0, 14).codePointAt(8) + 21322, new char[]{50100, 36953, 25799, 14480, 36183, 24954, 13804, 35252, 24188, 12903, 34522, 23318, 12106, 33748, 22444, 9314, 63522, 19707, 8375, 62809, 18835, 7629, 61958, 17962, 6847, 61089, 17265, 5988, 60301, 47122, 3148, 57473, 46234, 2412, 56611, 45553, 1505, 55815, 44749, 668, 55132, 43844, 32749, 54182, 41005, 29749, 51339, 40209}, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(super.getResources().getString(R.string.promo_center_entry_description).substring(13, 14).length() + 7702, new char[]{50146, 56737, 65435, 39330, 48057, 21961, 30521, 4378, 13151, 52527, 61276, 35147, 43763, 17561, 26352, 238, 8897, 15414, 56955, 63495, 39467, 46161, 22095, 30625, 4509, 13278, 52716, 61323, 35135, 43900, 17667, 26488, 256, 8976, 15545, 56990, 63708, 39603, 46297, 22065, 28718, 4636, 11296, 52847, 59412, 35263, 43920, 17805, 26592, 471, 9162, 15663, 57110, 63863, 39785, 46403, 22203, 28845, 4822, 11436, 52950, 59584, 35445, 42009}, objArr9);
                        String str2 = (String) objArr9[0];
                        try {
                            Object[] objArr10 = new Object[1];
                            b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (getAuthRequestContext | 48), objArr10);
                            Class<?> cls4 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], objArr11);
                            Object[] objArr12 = new Object[1];
                            a(((ApplicationInfo) cls4.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 31214, new char[]{50097, 47549, 14328, 44492, 11142, 41471, 8171, 38366, 5059, 35132, 1837, 64791, 31494, 61811, 28513, 58709, 25362, 55577, 22201, 52474, 19101, 49370, 48808, 13545, 45788, 10386, 42556, 7214, 39489, 4182, 36470, 1073, 33364, 30728, 63055, 29622, 59901, 26527, 56719, 23538, 53731, 20354, 50628, 17202, 14639, 46864, 11600, 43808, 8501, 40805, 5390, 37659, 2237, 34473, 31951, 64143, 28924, 61153, 25820, 58048, 22625, 54821, 19476, 51723}, objArr12);
                            String str3 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            a(getPackageName().codePointAt(0) + 58838, new char[]{50155, 9672, 3977, 29006, 23308, 48258, 42710, 34837, 61983, 56277, 15771, 10071, 2393, 29380, 21657, 48704, 40982, 35277, 62361, 54605, 16142, 8411, 2717, 27652, 22028, 49105, 41348, 35668, 60675, 54995, 14480, 8791, 1026, 28142, 22456, 47408, 41788, 34039, 61108, 53301, 14906, 9188, 1468, 28473, 20798, 47870, 40118, 34423, 59424, 53752, 15330, 7544, 1917, 26791, 21164, 46204, 40494, 34794, 59825, 54133}, objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            a(getPackageName().length() + 27472, new char[]{50106, 43258, 5401, 33192, 28397, 56065}, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 18 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr15);
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
            }
            try {
                Object[] objArr16 = new Object[1];
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr16);
                Class<?> cls5 = Class.forName((String) objArr16[0]);
                byte b = (byte) (getAuthRequestContext + 4);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr17 = new Object[1];
                b(b, b2, (byte) (b2 | Ascii.RS), objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 494, ((byte) KeyEvent.getModifierMetaStateMask()) + 5, (char) KeyEvent.keyCodeFromString(""));
                        Object[] objArr19 = new Object[1];
                        c((byte) (-$$a[40]), (byte) $$b, (byte) ($$a[78] - 1), objArr19);
                        obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), 35 - Drawable.resolveOpacity(0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {-208564857, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, 18 - Drawable.resolveOpacity(0, 0), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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

    public TransferAccountStatusActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity$phonePermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(TransferAccountStatusActivity.this, "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.PlaceComponentResult = builder.PlaceComponentResult();
    }

    @JvmName(name = "getPresenter")
    public final TransferAccountContract.Presenter getPresenter() {
        TransferAccountContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(TransferAccountContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityTransferAccountStatusBinding initViewBinding() {
        ActivityTransferAccountStatusBinding authRequestContext = ActivityTransferAccountStatusBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(22637 - (ViewConfiguration.getEdgeSlop() >> 16), new char[]{50146, 39808, 29501, 51894, 41560, 31179, 53609, 43350, 138, 55334, 47025, 3842, 59102, 48745, 5633, 60809, 17701, 7383, 62557, 21485, 11091, 33562, 23215, 12845, 35290, 24898}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().length() + 6892, new char[]{50144, 55557, 62999, 37672, 43050, 17746, 25157, 32615, 5227, 12664, 52881, 60315, 32900, 40373, 47805, 22487, 27868, 2510}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        getBinding().MyBillsEntityDataFactory.playAnimation();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.tnc_checkbox_description).substring(4, 5).length() + 22636, new char[]{50146, 39808, 29501, 51894, 41560, 31179, 53609, 43350, 138, 55334, 47025, 3842, 59102, 48745, 5633, 60809, 17701, 7383, 62557, 21485, 11091, 33562, 23215, 12845, 35290, 24898}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().length() + 6892, new char[]{50144, 55557, 62999, 37672, 43050, 17746, 25157, 32615, 5227, 12664, 52881, 60315, 32900, 40373, 47805, 22487, 27868, 2510}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), Color.red(0) + 35, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 912, 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        getBinding().MyBillsEntityDataFactory.pauseAnimation();
    }

    /* renamed from: $r8$lambda$TpTVNQDqcLi4nkbZZwOLnZIb-V0  reason: not valid java name */
    public static /* synthetic */ void m2990$r8$lambda$TpTVNQDqcLi4nkbZZwOLnZIbV0(TransferAccountStatusActivity transferAccountStatusActivity, View view) {
        Intrinsics.checkNotNullParameter(transferAccountStatusActivity, "");
        transferAccountStatusActivity.PlaceComponentResult.check();
    }

    public static final /* synthetic */ void access$setFailedTransferAccountConstraint(TransferAccountStatusActivity transferAccountStatusActivity) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.getAuthRequestContext(transferAccountStatusActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2);
        constraintSet.BuiltInFictitiousFunctionClassFactory(transferAccountStatusActivity.getBinding().getErrorConfigVersion.getId(), 3, transferAccountStatusActivity.getBinding().getAuthRequestContext.getId(), 4);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(transferAccountStatusActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        DaggerTransferAccountComponent.Builder PlaceComponentResult2 = DaggerTransferAccountComponent.PlaceComponentResult();
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (TransferAccountModule) Preconditions.getAuthRequestContext(new TransferAccountModule(new TransferAccountContract.View() { // from class: id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity$getTransferAccountModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.transferaccount.transferaccountstatus.TransferAccountContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                TransferAccountStatusActivity.this.startActivity(new Intent(TransferAccountStatusActivity.this, TransferAccountSuccessActivity.class));
                TransferAccountStatusActivity.this.finish();
            }

            @Override // id.dana.transferaccount.transferaccountstatus.TransferAccountContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ActivityTransferAccountStatusBinding binding;
                ActivityTransferAccountStatusBinding binding2;
                ActivityTransferAccountStatusBinding binding3;
                ActivityTransferAccountStatusBinding binding4;
                TextView textView;
                ActivityTransferAccountStatusBinding binding5;
                binding = TransferAccountStatusActivity.this.getBinding();
                LottieAnimationView lottieAnimationView = binding.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
                lottieAnimationView.setVisibility(8);
                binding2 = TransferAccountStatusActivity.this.getBinding();
                AppCompatImageView appCompatImageView = binding2.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(0);
                binding3 = TransferAccountStatusActivity.this.getBinding();
                binding3.getErrorConfigVersion.setText(TransferAccountStatusActivity.this.getString(R.string.transfer_account_status_title_failed));
                binding4 = TransferAccountStatusActivity.this.getBinding();
                binding4.scheduleImpl.setText(TransferAccountStatusActivity.this.getString(R.string.transfer_account_status_subtitle_failed));
                textView = TransferAccountStatusActivity.this.toolbarTitle;
                if (textView != null) {
                    textView.setText(TransferAccountStatusActivity.this.getString(R.string.transfer_account_status_toolbar_title_failed));
                }
                binding5 = TransferAccountStatusActivity.this.getBinding();
                binding5.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
                TransferAccountStatusActivity.access$setFailedTransferAccountConstraint(TransferAccountStatusActivity.this);
            }

            @Override // id.dana.transferaccount.transferaccountstatus.TransferAccountContract.View
            public final void getAuthRequestContext() {
                ActivityTransferAccountStatusBinding binding;
                ActivityTransferAccountStatusBinding binding2;
                ActivityTransferAccountStatusBinding binding3;
                ActivityTransferAccountStatusBinding binding4;
                TextView textView;
                binding = TransferAccountStatusActivity.this.getBinding();
                LottieAnimationView lottieAnimationView = binding.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
                lottieAnimationView.setVisibility(0);
                binding2 = TransferAccountStatusActivity.this.getBinding();
                AppCompatImageView appCompatImageView = binding2.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(8);
                binding3 = TransferAccountStatusActivity.this.getBinding();
                binding3.getErrorConfigVersion.setText(TransferAccountStatusActivity.this.getString(R.string.transfer_account_status_title_pending));
                binding4 = TransferAccountStatusActivity.this.getBinding();
                binding4.scheduleImpl.setText(TransferAccountStatusActivity.this.getString(R.string.transfer_account_status_subtitle_pending));
                textView = TransferAccountStatusActivity.this.toolbarTitle;
                if (textView != null) {
                    textView.setText(TransferAccountStatusActivity.this.getString(R.string.transfer_account_status_toolbar_title));
                }
            }

            @Override // id.dana.transferaccount.transferaccountstatus.TransferAccountContract.View
            public final void MyBillsEntityDataFactory() {
                DanaH5.startContainerFullUrl("https://m.dana.id/i/kyc/transfer-account/error/failedDeleteAccount");
            }

            @Override // id.dana.transferaccount.transferaccountstatus.TransferAccountContract.View
            public final void PlaceComponentResult() {
                DanaH5.startContainerFullUrl("https://m.dana.id/i/kyc/transfer-account/error/failedGeneral");
            }
        }));
        PlaceComponentResult2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, TransferAccountModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.PlaceComponentResult, ApplicationComponent.class);
        new DaggerTransferAccountComponent.TransferAccountComponentImpl(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2.PlaceComponentResult, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferAccountStatusActivity.m2990$r8$lambda$TpTVNQDqcLi4nkbZZwOLnZIbV0(TransferAccountStatusActivity.this, view);
            }
        });
        TextView textView = this.toolbarTitle;
        if (textView != null) {
            textView.setText(getString(R.string.transfer_account_status_toolbar_title));
        }
        getPresenter().getAuthRequestContext();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (lookAheadTest ^ 4796183387843776835L);
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
