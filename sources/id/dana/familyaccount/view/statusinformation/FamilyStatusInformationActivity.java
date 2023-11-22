package id.dana.familyaccount.view.statusinformation;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewGroupKt;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.databinding.ActivityFamilyStatusInformationBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0013\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\tR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010"}, d2 = {"Lid/dana/familyaccount/view/statusinformation/FamilyStatusInformationActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityFamilyStatusInformationBinding;", "Landroid/os/Bundle;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/os/Bundle;)V", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/databinding/ActivityFamilyStatusInformationBinding;", IAPSyncCommand.COMMAND_INIT, "onBackPressed", "", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "lookAheadTest", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyStatusInformationActivity extends BaseViewBindingActivity<ActivityFamilyStatusInformationBinding> {
    public static final String FAMILY_STATUS = "FAMILY_STATUS";
    private static char NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    public static final String ROLE = "ROLE";
    private static char getErrorConfigVersion;
    private static char scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String PlaceComponentResult;
    public static final byte[] $$a = {121, 107, -47, -24, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 144;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {14, -73, -90, 103, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 133;

    static {
        MyBillsEntityDataFactory();
        INSTANCE = new Companion(null);
    }

    static void MyBillsEntityDataFactory() {
        getErrorConfigVersion = (char) 38292;
        scheduleImpl = (char) 8532;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = (char) 8464;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = (char) 19242;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 106 - r6
            byte[] r0 = id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 4
            int r7 = 23 - r7
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
            goto L33
        L16:
            r3 = 0
        L17:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L33:
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity.b(short, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r8 = r8 + 4
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r0 = id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity.$$a
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L17:
            r3 = 0
        L18:
            int r4 = r3 + 1
            int r8 = r8 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity.c(short, int, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new char[]{22187, 35016, 38327, 56784, 59847, 3994, 64126, 47477, 65337, 31705, 13997, 41729, 43386, 29331, 10719, 62694, 26158, 59891}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((Process.myTid() >> 22) + 5, new char[]{36091, 42739, 57854, 33413, 40756, 52853}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((KeyEvent.getMaxKeyCode() >> 16) + 48, new char[]{35635, 54966, 54925, 28335, 51681, 31511, 37977, 51212, 5647, 33712, 20394, 48186, 19204, 41397, 33031, 45217, 20486, 14883, 54139, 13568, 13019, 57497, 45953, 23219, 4796, 24123, 15299, 22917, 19548, 57753, 27459, 27227, 26433, 47327, 56676, 13968, 19698, 34056, 56984, 38187, 11633, 50162, 3243, 17350, 21252, 53894, 46033, 16801}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(KeyEvent.getDeadChar(0, 0) + 64, new char[]{16022, 22723, 33962, 53385, 19698, 34056, 19651, 36041, 13019, 57497, 65200, 51754, 45533, 54396, 12368, 45665, 26756, 45656, 30956, 31737, 45533, 54396, 25588, 47949, 51808, 42324, 64485, 58732, 15299, 22917, 26756, 45656, 31328, 5974, 54394, 13479, 4443, 50612, 28579, 38907, 36660, 60308, 28153, 29688, 36910, 62914, 56522, 29069, 59990, 43642, 35718, 25388, 52212, 15163, 65092, 11446, 65092, 11446, 53650, 37696, 51883, 34387, 4796, 24123}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(ExpandableListView.getPackedPositionGroup(0L) + 64, new char[]{44918, 45587, 34029, 62582, 52212, 15163, 8895, 1894, 8553, 16643, 55952, 35696, 26518, 61863, 59713, 61616, 27459, 27227, 16453, 46453, 42669, 34296, 47981, 40047, 11633, 50162, 37977, 51212, 22452, 19624, 35635, 54966, 28051, 26756, 31339, 34204, 49977, 61752, 54925, 28335, 45745, 33105, 12368, 45665, 56984, 38187, 49995, 40113, 19698, 34056, 10719, 62694, 44918, 45587, 20110, 14337, 35851, 15545, 26433, 47327, 20110, 14337, 58120, 4968}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(KeyEvent.normalizeMetaState(0) + 60, new char[]{58177, 53940, 57658, 30767, 51726, 50614, 2048, 5999, 50391, 9119, 64033, 59343, 8965, 31196, 31111, 5160, 5862, 18746, 23415, 52084, 16637, 59166, 11969, 47742, 16197, 60185, 48882, 53305, 19604, 17157, 56556, 52772, 48882, 53305, 59823, 39183, 43952, 33676, 60211, 32107, 24890, 5582, 7483, 47452, 3249, 7672, 56882, 48701, 23567, 63054, 17717, 16995, 32175, 21717, 4903, 23686, 44144, 25627, 726, 28615}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(6 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{9672, 61724, 36828, 33083, 44918, 45587}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), 36, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[35] - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 55, 3 - ExpandableListView.getPackedPositionGroup(0L), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], $$a[78], $$a[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - ImageFormat.getBitsPerPixel(0), 14 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 16, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 815, Color.green(0) + 29, (char) (Color.alpha(0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 15 - KeyEvent.getDeadChar(0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-861146717, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, TextUtils.getOffsetAfter("", 0) + 18, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), 36, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[35] - 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 61, 47 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) View.resolveSize(0, 0));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[28]), (byte) (-$$a[8]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (KeyEvent.getMaxKeyCode() >> 16), View.resolveSizeAndState(0, 0, 0) + 35, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-861146717, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), 36, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[35] - 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 118, AndroidCharacter.getMirror('0') - '-', (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 38969));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[28]), (byte) (-$$a[8]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-861146717, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), 36, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[35] - 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Drawable.resolveOpacity(0, 0), Color.alpha(0) + 3, (char) (Process.myTid() >> 22));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[40], (byte) ($$a[47] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 35 - Color.argb(0, 0, 0, 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-861146717, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), ImageFormat.getBitsPerPixel(0) + 19, (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, new char[]{22187, 35016, 38327, 56784, 59847, 3994, 64126, 47477, 65337, 31705, 13997, 41729, 43386, 29331, 10719, 62694, 26158, 59891}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(super.getResources().getString(R.string.promo_code_discovery_subtitle).substring(13, 14).codePointAt(0) - 106, new char[]{36091, 42739, 57854, 33413, 40756, 52853}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr4 = new Object[1];
                    b(KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[9], objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    b(KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[27], KClassImpl$Data$declaredNonStaticMembers$2[59], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{22187, 35016, 38327, 56784, 59847, 3994, 64126, 47477, 24890, 5582, 24738, 1289, 14130, 2826, 27305, 13663, 20532, 46681, 16785, 29567, 3200, 23695, 32062, 1901, 31622, 47033}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    try {
                        Object[] objArr6 = new Object[1];
                        b(KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[9], objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        b(KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[27], KClassImpl$Data$declaredNonStaticMembers$2[59], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{52073, 7047, 30085, 39715, 44144, 25627, 17147, 4122, 11350, 9511, 21987, 29357, 63033, 51708, 27305, 13663, 37664, 37613}, objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr8 = new Object[1];
                    a(super.getResources().getString(R.string.bpjs).substring(0, 4).codePointAt(1) - 32, new char[]{35635, 54966, 54925, 28335, 51681, 31511, 37977, 51212, 5647, 33712, 20394, 48186, 19204, 41397, 33031, 45217, 20486, 14883, 54139, 13568, 13019, 57497, 45953, 23219, 4796, 24123, 15299, 22917, 19548, 57753, 27459, 27227, 26433, 47327, 56676, 13968, 19698, 34056, 56984, 38187, 11633, 50162, 3243, 17350, 21252, 53894, 46033, 16801}, objArr8);
                    String str = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(super.getResources().getString(R.string.title_btn_redeem_on_submit).substring(0, 5).length() + 59, new char[]{16022, 22723, 33962, 53385, 19698, 34056, 19651, 36041, 13019, 57497, 65200, 51754, 45533, 54396, 12368, 45665, 26756, 45656, 30956, 31737, 45533, 54396, 25588, 47949, 51808, 42324, 64485, 58732, 15299, 22917, 26756, 45656, 31328, 5974, 54394, 13479, 4443, 50612, 28579, 38907, 36660, 60308, 28153, 29688, 36910, 62914, 56522, 29069, 59990, 43642, 35718, 25388, 52212, 15163, 65092, 11446, 65092, 11446, 53650, 37696, 51883, 34387, 4796, 24123}, objArr9);
                    String str2 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(super.getResources().getString(R.string.unsafe_device_tamper_title).substring(15, 16).codePointAt(0) - 33, new char[]{44918, 45587, 34029, 62582, 52212, 15163, 8895, 1894, 8553, 16643, 55952, 35696, 26518, 61863, 59713, 61616, 27459, 27227, 16453, 46453, 42669, 34296, 47981, 40047, 11633, 50162, 37977, 51212, 22452, 19624, 35635, 54966, 28051, 26756, 31339, 34204, 49977, 61752, 54925, 28335, 45745, 33105, 12368, 45665, 56984, 38187, 49995, 40113, 19698, 34056, 10719, 62694, 44918, 45587, 20110, 14337, 35851, 15545, 26433, 47327, 20110, 14337, 58120, 4968}, objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(60 - View.MeasureSpec.getSize(0), new char[]{58177, 53940, 57658, 30767, 51726, 50614, 2048, 5999, 50391, 9119, 64033, 59343, 8965, 31196, 31111, 5160, 5862, 18746, 23415, 52084, 16637, 59166, 11969, 47742, 16197, 60185, 48882, 53305, 19604, 17157, 56556, 52772, 48882, 53305, 59823, 39183, 43952, 33676, 60211, 32107, 24890, 5582, 7483, 47452, 3249, 7672, 56882, 48701, 23567, 63054, 17717, 16995, 32175, 21717, 4903, 23686, 44144, 25627, 726, 28615}, objArr11);
                    String str4 = (String) objArr11[0];
                    try {
                        Object[] objArr12 = new Object[1];
                        b(KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[9], objArr12);
                        Class<?> cls5 = Class.forName((String) objArr12[0]);
                        b(KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[27], KClassImpl$Data$declaredNonStaticMembers$2[59], new Object[1]);
                        Object[] objArr13 = new Object[1];
                        a(((ApplicationInfo) cls5.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 27, new char[]{9672, 61724, 36828, 33083, 44918, 45587}, objArr13);
                        try {
                            Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, View.MeasureSpec.getSize(0) + 18, (char) View.resolveSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr14);
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
            Object[] objArr15 = new Object[1];
            b(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), 36, objArr15);
            Class<?> cls6 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            b(KClassImpl$Data$declaredNonStaticMembers$2[7], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[35] - 1), objArr16);
            try {
                Object[] objArr17 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 493, Color.green(0) + 4, (char) (Color.rgb(0, 0, 0) + 16777216));
                    Object[] objArr18 = new Object[1];
                    c((byte) ($$a[47] - 1), $$a[40], (byte) ($$a[47] - 1), objArr18);
                    obj3 = cls7.getMethod((String) objArr18[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                int i = ((int[]) objArr19[1])[0];
                if (((int[]) objArr19[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 35, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr20 = {-506465096, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr20);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(5) - 84, new char[]{22187, 35016, 38327, 56784, 59847, 3994, 64126, 47477, 24890, 5582, 24738, 1289, 14130, 2826, 27305, 13663, 20532, 46681, 16785, 29567, 3200, 23695, 32062, 1901, 31622, 47033}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.send_money_wording_toast_after_rename_recent_saved_bank).substring(19, 20).codePointAt(0) - 97, new char[]{52073, 7047, 30085, 39715, 44144, 25627, 17147, 4122, 11350, 9511, 21987, 29357, 63033, 51708, 27305, 13663, 37664, 37613}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - TextUtils.indexOf("", "", 0, 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, 18 - TextUtils.getCapsMode("", 0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.error_select_own_number).substring(10, 11).codePointAt(0) - 6, new char[]{22187, 35016, 38327, 56784, 59847, 3994, 64126, 47477, 24890, 5582, 24738, 1289, 14130, 2826, 27305, 13663, 20532, 46681, 16785, 29567, 3200, 23695, 32062, 1901, 31622, 47033}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.board_info).substring(10, 11).codePointAt(0) - 14, new char[]{52073, 7047, 30085, 39715, 44144, 25627, 17147, 4122, 11350, 9511, 21987, 29357, 63033, 51708, 27305, 13663, 37664, 37613}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), View.resolveSizeAndState(0, 0, 0) + 35, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) (Process.myTid() >> 22))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityFamilyStatusInformationBinding inflateViewBinding() {
        ActivityFamilyStatusInformationBinding PlaceComponentResult = ActivityFamilyStatusInformationBinding.PlaceComponentResult(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        String str = this.PlaceComponentResult;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        if (Intrinsics.areEqual("FAMILY_ACCOUNT_DELETED", str)) {
            MyBillsEntityDataFactory(null);
        } else {
            super.onBackPressed();
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Bundle, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static void MyBillsEntityDataFactory(Bundle p0) {
        ?? r2 = 0;
        EventBus.getDefault().post(new HomeTabActivity.FinishSubActivitiesMessageEvent(r2, 1, r2));
        EventBus.getDefault().post(new HomeTabActivity.OnBackToHomepageMessageEvent(p0));
        EventBus.getDefault().post(new BaseViewBindingActivity.FinishSubActivitiesMessageEvent());
    }

    public static /* synthetic */ void $r8$lambda$gytAeRWxJUJbUg2SoNfVX3Wbpzc(FamilyStatusInformationActivity familyStatusInformationActivity, View view) {
        Intrinsics.checkNotNullParameter(familyStatusInformationActivity, "");
        familyStatusInformationActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().BuiltInFictitiousFunctionClassFactory;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.family_account_text_title_toolbar));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().BuiltInFictitiousFunctionClassFactory;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyStatusInformationActivity.$r8$lambda$gytAeRWxJUJbUg2SoNfVX3Wbpzc(FamilyStatusInformationActivity.this, view);
            }
        });
        Toolbar toolbar = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        for (View view : ViewGroupKt.BuiltInFictitiousFunctionClassFactory(toolbar)) {
            ImageButton imageButton = view instanceof ImageButton ? (ImageButton) view : null;
            if (imageButton != null) {
                imageButton.setContentDescription(getResources().getString(R.string.imgBtnLeft));
            }
        }
        TextView textView2 = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x003f, code lost:
    
        if (r0.equals("REVOKED") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0097, code lost:
    
        if (r0.equals("FAMILY_ACCOUNT_DELETED") != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0099, code lost:
    
        getBinding().PlaceComponentResult.setStatusInformationType("FAMILY_ACCOUNT_DELETED");
     */
    @Override // id.dana.core.ui.BaseViewBindingActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void init() {
        /*
            r3 = this;
            android.content.Intent r0 = r3.getIntent()
            java.lang.String r1 = ""
            if (r0 == 0) goto L26
            java.lang.String r2 = "FAMILY_STATUS"
            java.lang.String r2 = r0.getStringExtra(r2)
            if (r2 != 0) goto L12
            r2 = r1
            goto L15
        L12:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
        L15:
            r3.PlaceComponentResult = r2
            java.lang.String r2 = "ROLE"
            java.lang.String r0 = r0.getStringExtra(r2)
            if (r0 != 0) goto L21
            r0 = r1
            goto L24
        L21:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L24:
            r3.getAuthRequestContext = r0
        L26:
            java.lang.String r0 = r3.PlaceComponentResult
            if (r0 != 0) goto L2e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = 0
        L2e:
            int r1 = r0.hashCode()
            java.lang.String r2 = "FAMILY_ACCOUNT_DELETED"
            switch(r1) {
                case -1824356621: goto La5;
                case -1164871444: goto L93;
                case -850510209: goto L7f;
                case -86067292: goto L6b;
                case 1136849717: goto L57;
                case 1441245012: goto L43;
                case 1818119806: goto L39;
                default: goto L37;
            }
        L37:
            goto Lb8
        L39:
            java.lang.String r1 = "REVOKED"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L99
            goto Lb8
        L43:
            java.lang.String r1 = "MEMBER_DELETED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb8
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.ActivityFamilyStatusInformationBinding r0 = (id.dana.databinding.ActivityFamilyStatusInformationBinding) r0
            id.dana.familyaccount.view.statusinformation.StatusInformationView r0 = r0.PlaceComponentResult
            r0.setStatusInformationType(r1)
            goto Lb8
        L57:
            java.lang.String r1 = "ORGANIZER_HAS_FROZEN"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb8
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.ActivityFamilyStatusInformationBinding r0 = (id.dana.databinding.ActivityFamilyStatusInformationBinding) r0
            id.dana.familyaccount.view.statusinformation.StatusInformationView r0 = r0.PlaceComponentResult
            r0.setStatusInformationType(r1)
            goto Lb8
        L6b:
            java.lang.String r1 = "ORGANIZER_KYC_REVOKED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb8
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.ActivityFamilyStatusInformationBinding r0 = (id.dana.databinding.ActivityFamilyStatusInformationBinding) r0
            id.dana.familyaccount.view.statusinformation.StatusInformationView r0 = r0.PlaceComponentResult
            r0.setStatusInformationType(r1)
            goto Lb8
        L7f:
            java.lang.String r1 = "INVITATION_CANCELED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb8
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.ActivityFamilyStatusInformationBinding r0 = (id.dana.databinding.ActivityFamilyStatusInformationBinding) r0
            id.dana.familyaccount.view.statusinformation.StatusInformationView r0 = r0.PlaceComponentResult
            r0.setStatusInformationType(r1)
            goto Lb8
        L93:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto Lb8
        L99:
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.ActivityFamilyStatusInformationBinding r0 = (id.dana.databinding.ActivityFamilyStatusInformationBinding) r0
            id.dana.familyaccount.view.statusinformation.StatusInformationView r0 = r0.PlaceComponentResult
            r0.setStatusInformationType(r2)
            goto Lb8
        La5:
            java.lang.String r1 = "MAINTENANCE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb8
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.ActivityFamilyStatusInformationBinding r0 = (id.dana.databinding.ActivityFamilyStatusInformationBinding) r0
            id.dana.familyaccount.view.statusinformation.StatusInformationView r0 = r0.PlaceComponentResult
            r0.setStatusInformationType(r1)
        Lb8:
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            id.dana.databinding.ActivityFamilyStatusInformationBinding r0 = (id.dana.databinding.ActivityFamilyStatusInformationBinding) r0
            id.dana.familyaccount.view.statusinformation.StatusInformationView r0 = r0.PlaceComponentResult
            id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity$setOnButtonClickListener$1 r1 = new id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity$setOnButtonClickListener$1
            r1.<init>()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r0.setGotItButtonListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity.init():void");
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
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (scheduleImpl ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (getErrorConfigVersion ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
