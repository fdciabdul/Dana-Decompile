package id.dana.sendmoney.ui.groupsend.groupdetail.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.databinding.ActivityMemberListBinding;
import id.dana.sendmoney.ui.groupsend.groupdetail.adapter.MemberListAdapter;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.GroupDetailModel;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/activity/MemberListActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/sendmoney/databinding/ActivityMemberListBinding;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ActivityMemberListBinding;", IAPSyncCommand.COMMAND_INIT, "Lid/dana/sendmoney/ui/groupsend/groupdetail/adapter/MemberListAdapter;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/groupsend/groupdetail/adapter/MemberListAdapter;", "getAuthRequestContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MemberListActivity extends BaseViewBindingActivity<ActivityMemberListBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String MEMBER_LIST_INTENT_MODEL = "member_list_intent_model";
    private static long scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private MemberListAdapter getAuthRequestContext;
    public static final byte[] $$a = {22, 66, -65, -82, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 184;
    public static final byte[] getAuthRequestContext = {110, -41, 63, 58, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 238;

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        scheduleImpl = -5662702580534889428L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.sendmoney.ui.groupsend.groupdetail.activity.MemberListActivity.getAuthRequestContext
            int r9 = r9 + 16
            int r7 = r7 + 97
            int r8 = 55 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L15
            r7 = r9
            r3 = r1
            r4 = 0
            r9 = r8
            r1 = r0
            r0 = r10
            r10 = r7
            goto L33
        L15:
            r3 = 0
            r6 = r9
            r9 = r7
            r7 = r6
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r7) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L33:
            int r8 = -r8
            int r10 = r10 + r8
            int r8 = r10 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.groupdetail.activity.MemberListActivity.b(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r0 = id.dana.sendmoney.ui.groupsend.groupdetail.activity.MemberListActivity.$$a
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r6 = 46 - r6
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r6 = r6 + 1
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.groupdetail.activity.MemberListActivity.c(byte, short, int, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(Color.blue(0) + 36997, new char[]{25870, 62852, 17409, 54418, 10004, 47007, 1557, 38626, 57640, 29105, 49267, 20616, 41761, 13249, 33354, 4801, 27980, 64969}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(28607 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{25858, 2729, 47684, 10811, 56311}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(1553 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{25944, 25373, 27003, 30564, 32027, 31582, 16688, 20256, 21968, 21395, 22950, 10162, 11718, 11136, 12720, 16294, 1102, 639, 2155, 5709, 7263, 6761, 57466, 61150, 62611, 62197, 63725, 50880, 52353, 51942, 53488, 55557, 42870, 44392, 43807, 45317, 49005, 34083, 33745, 35272, 38896, 40368, 39825, 24962, 28641, 30113, 29271, 30741}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 64660, new char[]{25870, 39375, 40051, 37044, 38749, 35775, 36385, 36164, 33187, 33841, 47236, 48957, 46071, 46799, 46456, 43488, 44045, 41144, 42867, 55889, 57007, 56679, 53655, 54335, 51361, 53120, 49780, 50877, 50459, 63978, 64555, 62294, 63404, 59966, 61073, 60680, 57848, 58501, 6977, 8175, 4626, 5762, 5496, 2137, 3216, 873, 1944, 14851, 16044, 15833, 12354, 13561, 11026, 12161, 8753, 8541, 9671, 22643, 23758, 21338, 22450, 19158, 18717, 19959}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(62071 - (ViewConfiguration.getKeyRepeatDelay() >> 16), new char[]{25949, 38697, 33252, 45672, 44170, 55563, 52119, 50202, 63215, 58232, 7665, 3651, 14538, 13655, 10205, 20897, 17022, 31981, 26885, 39902, 37905, 34510, 45876, 44525, 56944, 51350, 50496, 63450, 57357, 4722, 3242, 14693, 11192, 9308, 22163, 17170, 32177, 28267, 39155, 38262, 34767, 45062, 41688, 56486, 51491, 64436, 62572, 59092, 4953, 3473, 15922, 10431, 9585, 22525, 16403, 29387, 28496, 39205, 35744, 33844, 46829, 41729, 56712, 52767}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(11743 - View.MeasureSpec.getSize(0), new char[]{25863, 18628, 16037, 60546, 53856, 32782, 30330, 9305, 3059, 63961, 44983, 40347, 17205, 12616, 59189, 54540, 47354, 28353, 23733, 641, 61538, 42583, 37937, 31304, 10720, 8157, 52648, 45976, 24943, 22367, 1340, 60187, 57070, 36002, 29332, 8252, 5712, 50235, 43544, 39353, 20438, 15784, 58256, 53557, 34642, 30002, 23322, 3835, 64716, 41652, 37070, 18036, 13329, 6763, 51200, 49136, 28098, 21414, 413, 63353}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(22189 - View.getDefaultSize(0, 0), new char[]{25942, 13292, 51201, 24902, 16361, 54335}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getMode(0), 18 - Color.blue(0), (char) TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 24);
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | 22), getAuthRequestContext[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.getTrimmedLength(""), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                        Object[] objArr16 = new Object[1];
                        c($$a[53], $$a[12], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) View.MeasureSpec.getMode(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, View.resolveSizeAndState(0, 0, 0) + 15, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - Color.red(0), Color.red(0) + 29, (char) (57994 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778016, (ViewConfiguration.getJumpTapTimeout() >> 16) + 15, (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1759933599, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), TextUtils.getCapsMode("", 0, 0) + 18, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 24);
                Object[] objArr20 = new Object[1];
                b(b2, (byte) (b2 | 22), getAuthRequestContext[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Drawable.resolveOpacity(0, 0), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 45, (char) (ViewConfiguration.getJumpTapTimeout() >> 16));
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.normalizeMetaState(0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1759933599, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), ExpandableListView.getPackedPositionGroup(0L) + 18, (char) Color.blue(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 24);
                Object[] objArr26 = new Object[1];
                b(b3, (byte) (b3 | 22), getAuthRequestContext[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 3 - TextUtils.indexOf("", ""), (char) (38968 - KeyEvent.getDeadChar(0, 0)));
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.combineMeasuredStates(0, 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1759933599, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 24);
                Object[] objArr32 = new Object[1];
                b(b4, (byte) (b4 | 22), getAuthRequestContext[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 107, 4 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)));
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, (Process.myPid() >> 22) + 35, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1759933599, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Gravity.getAbsoluteGravity(0, 0), 18 - KeyEvent.keyCodeFromString(""), (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        a(getPackageName().length() + 36990, new char[]{25870, 62852, 17409, 54418, 10004, 47007, 1557, 38626, 57640, 29105, 49267, 20616, 41761, 13249, 33354, 4801, 27980, 64969}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(ExpandableListView.getPackedPositionChild(0L) + 28608, new char[]{25858, 2729, 47684, 10811, 56311}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(getPackageName().length() + 63172, new char[]{25870, 37834, 34973, 33148, 48684, 46321, 44489, 56012, 54102, 51260, 50929, 65528, 62634, 60739, 6657, 4323, 2473, 1661, 16221, 13319, 8935, 23456, 20591, 18743, 17926, 31960}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a((KeyEvent.getMaxKeyCode() >> 16) + 42589, new char[]{25868, 49991, 10663, 38410, 64638, 23248, 33589, 59813, 22519, 48218, 6817, 16633, 43344, 6071, 31757, 55925, 208, 26924}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.first_time_phone_number_smart_friction).substring(4, 5).length() + 1552, new char[]{25944, 25373, 27003, 30564, 32027, 31582, 16688, 20256, 21968, 21395, 22950, 10162, 11718, 11136, 12720, 16294, 1102, 639, 2155, 5709, 7263, 6761, 57466, 61150, 62611, 62197, 63725, 50880, 52353, 51942, 53488, 55557, 42870, 44392, 43807, 45317, 49005, 34083, 33745, 35272, 38896, 40368, 39825, 24962, 28641, 30113, 29271, 30741}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(TextUtils.lastIndexOf("", '0') + 64662, new char[]{25870, 39375, 40051, 37044, 38749, 35775, 36385, 36164, 33187, 33841, 47236, 48957, 46071, 46799, 46456, 43488, 44045, 41144, 42867, 55889, 57007, 56679, 53655, 54335, 51361, 53120, 49780, 50877, 50459, 63978, 64555, 62294, 63404, 59966, 61073, 60680, 57848, 58501, 6977, 8175, 4626, 5762, 5496, 2137, 3216, 873, 1944, 14851, 16044, 15833, 12354, 13561, 11026, 12161, 8753, 8541, 9671, 22643, 23758, 21338, 22450, 19158, 18717, 19959}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(super.getResources().getString(R.string.receive_money).substring(1, 2).codePointAt(0) + 61970, new char[]{25949, 38697, 33252, 45672, 44170, 55563, 52119, 50202, 63215, 58232, 7665, 3651, 14538, 13655, 10205, 20897, 17022, 31981, 26885, 39902, 37905, 34510, 45876, 44525, 56944, 51350, 50496, 63450, 57357, 4722, 3242, 14693, 11192, 9308, 22163, 17170, 32177, 28267, 39155, 38262, 34767, 45062, 41688, 56486, 51491, 64436, 62572, 59092, 4953, 3473, 15922, 10431, 9585, 22525, 16403, 29387, 28496, 39205, 35744, 33844, 46829, 41729, 56712, 52767}, objArr8);
                    String str3 = (String) objArr8[0];
                    try {
                        byte b = getAuthRequestContext[25];
                        Object[] objArr9 = new Object[1];
                        b(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[30], objArr9);
                        Class<?> cls3 = Class.forName((String) objArr9[0]);
                        Object[] objArr10 = new Object[1];
                        b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[8], objArr10);
                        Object[] objArr11 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 11710, new char[]{25863, 18628, 16037, 60546, 53856, 32782, 30330, 9305, 3059, 63961, 44983, 40347, 17205, 12616, 59189, 54540, 47354, 28353, 23733, 641, 61538, 42583, 37937, 31304, 10720, 8157, 52648, 45976, 24943, 22367, 1340, 60187, 57070, 36002, 29332, 8252, 5712, 50235, 43544, 39353, 20438, 15784, 58256, 53557, 34642, 30002, 23322, 3835, 64716, 41652, 37070, 18036, 13329, 6763, 51200, 49136, 28098, 21414, 413, 63353}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 22189, new char[]{25942, 13292, 51201, 24902, 16361, 54335}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 911, 18 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            Object[] objArr14 = new Object[1];
            b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 24);
            Object[] objArr15 = new Object[1];
            b(b2, (byte) (b2 | 22), getAuthRequestContext[25], objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getTapTimeout() >> 16), ExpandableListView.getPackedPositionGroup(0L) + 4, (char) (Process.getGidForName("") + 1));
                    Object[] objArr17 = new Object[1];
                    c((byte) ($$a[78] - 1), $$a[9], (byte) ($$a[78] - 1), objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 35 - TextUtils.getOffsetAfter("", 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {1524832516, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.tnc_failed_toast_text).substring(53, 54).length() + 63178, new char[]{25870, 37834, 34973, 33148, 48684, 46321, 44489, 56012, 54102, 51260, 50929, 65528, 62634, 60739, 6657, 4323, 2473, 1661, 16221, 13319, 8935, 23456, 20591, 18743, 17926, 31960}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr2 = new Object[1];
                b(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[30], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[8], objArr3);
                Object[] objArr4 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 42556, new char[]{25868, 49991, 10663, 38410, 64638, 23248, 33589, 59813, 22519, 48218, 6817, 16633, 43344, 6071, 31757, 55925, 208, 26924}, objArr4);
                baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(Color.rgb(0, 0, 0) + 16840395, new char[]{25870, 37834, 34973, 33148, 48684, 46321, 44489, 56012, 54102, 51260, 50929, 65528, 62634, 60739, 6657, 4323, 2473, 1661, 16221, 13319, 8935, 23456, 20591, 18743, 17926, 31960}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 42589, new char[]{25868, 49991, 10663, 38410, 64638, 23248, 33589, 59813, 22519, 48218, 6817, 16633, 43344, 6071, 31757, 55925, 208, 26924}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), View.resolveSize(0, 0) + 35, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 911, (ViewConfiguration.getTapTimeout() >> 16) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    public final ActivityMemberListBinding inflateViewBinding() {
        ActivityMemberListBinding BuiltInFictitiousFunctionClassFactory = ActivityMemberListBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        Toolbar toolbar = getBinding().getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        toolbar2.setNavigationIcon(ContextCompat.PlaceComponentResult(toolbar2.getContext(), id.dana.sendmoney.R.drawable.PlaceComponentResult));
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.MemberListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberListActivity.m2919$r8$lambda$rAUdKYT2zaUgVDk0AjQTaFBZKI(MemberListActivity.this, view);
            }
        });
        getBinding().getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(id.dana.sendmoney.R.string.text_group_member));
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/activity/MemberListActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;", "p1", "", "getAuthRequestContext", "(Landroid/content/Context;Ljava/util/List;)V", "", "MEMBER_LIST_INTENT_MODEL", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void getAuthRequestContext(Context p0, List<GroupDetailModel> p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, MemberListActivity.class);
            intent.putParcelableArrayListExtra(MemberListActivity.MEMBER_LIST_INTENT_MODEL, (ArrayList) p1);
            p0.startActivity(intent);
        }
    }

    /* renamed from: $r8$lambda$rAUdKYT2zaUgVDk0AjQT-aFBZKI  reason: not valid java name */
    public static /* synthetic */ void m2919$r8$lambda$rAUdKYT2zaUgVDk0AjQTaFBZKI(MemberListActivity memberListActivity, View view) {
        Intrinsics.checkNotNullParameter(memberListActivity, "");
        memberListActivity.onBackPressed();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(MEMBER_LIST_INTENT_MODEL);
        if (parcelableArrayListExtra != null) {
            Intrinsics.checkNotNullExpressionValue(parcelableArrayListExtra, "");
            ArrayList arrayList = parcelableArrayListExtra;
            this.getAuthRequestContext = new MemberListAdapter(arrayList);
            RecyclerView recyclerView = getBinding().PlaceComponentResult;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
            MemberListAdapter memberListAdapter = this.getAuthRequestContext;
            if (memberListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                memberListAdapter = null;
            }
            recyclerView.setAdapter(memberListAdapter);
            recyclerView.setLayoutManager(linearLayoutManager);
            TextView textView = getBinding().BuiltInFictitiousFunctionClassFactory;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(id.dana.sendmoney.R.string.text_total_member);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(arrayList.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(format);
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (scheduleImpl ^ 4796183387843776835L);
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
