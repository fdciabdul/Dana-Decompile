package id.dana.mybills;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.databinding.ActivityContinualBillsBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.MyBillsModule;
import id.dana.domain.mybills.model.MyBillsMonthlyAmount;
import id.dana.model.CurrencyAmountModel;
import id.dana.mybills.adapter.BillsPaymentAdapter;
import id.dana.mybills.di.DaggerContinualBillsComponent;
import id.dana.mybills.di.MyBillsContract;
import id.dana.mybills.listener.GroupedBillPaymentsListener;
import id.dana.mybills.model.BillPaymentAdapterModel;
import id.dana.mybills.model.BillPaymentAdapterModelKt;
import id.dana.mybills.model.BillPaymentStatusModel;
import id.dana.mybills.model.BillSubscriptionHighlightModel;
import id.dana.mybills.model.BillsPaymentHeaderModel;
import id.dana.mybills.model.BizProductModel;
import id.dana.mybills.model.BizProductOrderModel;
import id.dana.mybills.model.HighlighTransactionPayModel;
import id.dana.mybills.model.MonthlyHighlightBillModel;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.utils.MyBillsMoneyUtils;
import id.dana.mybills.view.FooterMonthlyView;
import id.dana.mybills.view.TotalEstimatedBillsView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.showcase.Content;
import id.dana.showcase.Showcase;
import id.dana.showcase.SimpleDismissibleWithCustomDrawable;
import id.dana.showcase.shape.RectangleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.SizeUtil;
import id.dana.utils.TagFormat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00148\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/mybills/ContinualBillsActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityContinualBillsBinding;", "", "configToolbar", "()V", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityContinualBillsBinding;", "getAuthRequestContext", "Lid/dana/mybills/adapter/BillsPaymentAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/mybills/adapter/BillsPaymentAdapter;", "BuiltInFictitiousFunctionClassFactory", "", "lookAheadTest", "I", "MyBillsEntityDataFactory", "GetContactSyncConfig", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/di/MyBillsContract$Presenter;", "presenter", "Lid/dana/mybills/di/MyBillsContract$Presenter;", "getPresenter", "()Lid/dana/mybills/di/MyBillsContract$Presenter;", "setPresenter", "(Lid/dana/mybills/di/MyBillsContract$Presenter;)V", "Lid/dana/showcase/Showcase;", "DatabaseTableConfigUtil", "Lid/dana/showcase/Showcase;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContinualBillsActivity extends ViewBindingActivity<ActivityContinualBillsBinding> {
    public static final String CONTINUAL_DATA = "continual_data";

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private Showcase getAuthRequestContext;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private BillsPaymentAdapter BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;
    @Inject
    public MyBillsContract.Presenter presenter;
    public static final byte[] $$a = {44, -51, -23, -10, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 80;
    public static final byte[] PlaceComponentResult = {10, -99, -17, -84, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getAuthRequestContext = 137;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda1 = -7086014406457957772L;

    private static void b(byte b, short s, byte b2, Object[] objArr) {
        int i = (b * 4) + 16;
        int i2 = s + 105;
        int i3 = 18 - (b2 * 15);
        byte[] bArr = PlaceComponentResult;
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            int i6 = i3 + (-i5) + 2;
            i3 = i3;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i2 = i6;
            i5 = i5;
        }
        while (true) {
            int i7 = i4 + 1;
            int i8 = i3 + 1;
            bArr2[i7] = (byte) i2;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i2;
            int i10 = i5;
            i3 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i7;
            i2 = i9 + (-bArr[i8]) + 2;
            i5 = i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r0 = id.dana.mybills.ContinualBillsActivity.$$a
            int r6 = r6 * 2
            int r6 = 103 - r6
            int r7 = 46 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            int r7 = r7 + 1
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ContinualBillsActivity.c(int, byte, byte, java.lang.Object[]):void");
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
        a(ViewConfiguration.getTapTimeout() >> 16, new char[]{22059, 27376, 22090, 50434, 15411, 25455, 59458, 59108, 59444, 1173, 32419, 9512, 10916, 18175, 48985, 25510, 27913, 32883, 63876, 41475, 44952, 50143}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(TextUtils.getOffsetBefore("", 0), new char[]{2418, 16914, 2335, 60919, 40523, 49446, 58790, 60187, 46950}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(View.resolveSize(0, 0), new char[]{46804, 13080, 46819, 40167, 29776, 11102, 65236, 61496, 2196, 23920, 14031, 13224, 51715, 7937, 63269, 29958, 36321, 55750, 45543, 46278, 20261, 39541, 29584, 63009, 3712, 21687, 15445, 14822, 49168, 5399, 65214, 31684, 33782, 55248, 49015, 48469, 17773, 36914, 31188, 64697, 1858, 21165, 14926, 15904, 50819, 11394, 58610, 33238, 39014, 60743, 42336, 49941}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(ViewConfiguration.getEdgeSlop() >> 16, new char[]{3809, 21146, 3712, 64819, 15848, 25318, 42026, 43674, 45303, 15535, 32638, 26966, 29285, 32389, 48839, 12203, 13781, 47175, 63583, 60986, 63251, 64500, 14968, 44175, 46773, 13671, 30136, 25373, 30839, 29892, 46855, 8507, 15305, 46674, 63132, 59388, 64770, 61922, 12394, 42566, 49010, 13173, 29694, 25821, 32436, 19798, 44315, 56111, 8274, 36033, 60639, 39353, 58258, 52853, 11945, 22535, 42344, 2529, 26686, 7839, 25841, 19223, 43997, 56508, 9792, 35470, 58698, 37757}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(Drawable.resolveOpacity(0, 0), new char[]{42318, 35850, 42364, 9127, 47309, 59280, 35229, 34603, 6919, 57905, 64010, 17645, 55702, 41038, 15280, 536, 40495, 26325, 32040, 50062, 23791, 9523, 48988, 33133, 7500, 60324, 61593, 20138, 54233, 43600, 12913, 3281, 36920, 26816, 29679, 51738, 22265, 12146, 46362, 35825, 5340, 60849, 63118, 18785, 54550, 37776, 10297, 63133, 35750, 21078, 27129, 46171, 18536, 4335, 43915, 30188, 3788, 55159, 60702, 13100, 53081, 38275, 12017, 61791, 36280, 21523, 24685, 48832}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(ViewConfiguration.getScrollDefaultDelay() >> 16, new char[]{24998, 18050, 25038, 59754, 499, 24255, 31513, 30141, 57253, 10420, 17208, 46706, 7458, 27295, 33481, 61644, 23256, 44058, 50271, 12623, 38915, 61375, 1587, 29678, 55799, 8509, 18851, 48179, 5985, 24779, 35590, 65055, 21714, 41565, 51846, 14472, 37447, 58860, 3170, 31075, 53301, 10081, 20474, 48114, 4519, 22798, 37198, 1026, 20255, 39040, 53456, 18136, 35989, 55850, 4840, 34683, 51748, 7649, 21554, 49643, 3043, 24400, 38803, 926}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(ViewConfiguration.getKeyRepeatTimeout() >> 16, new char[]{31686, 49264, 31743, 28610, 17101, 7617, 14418, 13992, 50564, 44621}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, View.resolveSizeAndState(0, 0, 0) + 18, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (PlaceComponentResult[5] - 1);
                byte b2 = PlaceComponentResult[5];
                Object[] objArr13 = new Object[1];
                b(b, b2, (byte) (b2 - 1), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (PlaceComponentResult[5] - 1);
                Object[] objArr14 = new Object[1];
                b(b3, b3, PlaceComponentResult[5], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 55, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 3, (char) Drawable.resolveOpacity(0, 0));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), (byte) (-$$a[53]), $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.red(0), TextUtils.indexOf((CharSequence) "", '0') + 16, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - KeyEvent.getDeadChar(0, 0), 15 - ExpandableListView.getPackedPositionGroup(0L), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 815, (ViewConfiguration.getScrollBarSize() >> 8) + 29, (char) (57994 - Drawable.resolveOpacity(0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - ExpandableListView.getPackedPositionChild(0L), 15 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ExpandableListView.getPackedPositionChild(0L), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-581606206, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), 18 - View.resolveSize(0, 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (PlaceComponentResult[5] - 1);
                byte b5 = PlaceComponentResult[5];
                Object[] objArr19 = new Object[1];
                b(b4, b5, (byte) (b5 - 1), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b6 = (byte) (PlaceComponentResult[5] - 1);
                Object[] objArr20 = new Object[1];
                b(b6, b6, PlaceComponentResult[5], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 61, 46 - (ViewConfiguration.getScrollBarSize() >> 8), (char) View.combineMeasuredStates(0, 0));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[20], (byte) ($$a[47] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-581606206, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, 17 - MotionEvent.axisFromString(""), (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (PlaceComponentResult[5] - 1);
                byte b8 = PlaceComponentResult[5];
                Object[] objArr25 = new Object[1];
                b(b7, b8, (byte) (b8 - 1), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b9 = (byte) (PlaceComponentResult[5] - 1);
                Object[] objArr26 = new Object[1];
                b(b9, b9, PlaceComponentResult[5], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 118, 3 - KeyEvent.normalizeMetaState(0), (char) (38968 - (ViewConfiguration.getEdgeSlop() >> 16)));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[20], (byte) ($$a[47] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-581606206, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (PlaceComponentResult[5] - 1);
                byte b11 = PlaceComponentResult[5];
                Object[] objArr31 = new Object[1];
                b(b10, b11, (byte) (b11 - 1), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b12 = (byte) (PlaceComponentResult[5] - 1);
                Object[] objArr32 = new Object[1];
                b(b12, b12, PlaceComponentResult[5], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getTapTimeout() >> 16) + 3, (char) View.resolveSizeAndState(0, 0, 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[9]), (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-581606206, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, 18 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(id.dana.R.string.merchant_static_banner_title).substring(17, 18).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN, new char[]{22059, 27376, 22090, 50434, 15411, 25455, 59458, 59108, 59444, 1173, 32419, 9512, 10916, 18175, 48985, 25510, 27913, 32883, 63876, 41475, 44952, 50143}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(super.getResources().getString(id.dana.R.string.delete_group_from_favorite).substring(8, 9).codePointAt(0) - 114, new char[]{2418, 16914, 2335, 60919, 40523, 49446, 58790, 60187, 46950}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(ViewConfiguration.getWindowTouchSlop() >> 8, new char[]{6652, 13829, 6557, 39415, 39146, 51126, 63687, 63073, 42979, 22624, 55930, 13741, 25981, 6665, 7134, 29533, 8941, 56458, 23882, 45706, 57418, 40752, 40762, 61482, 41368, 20897, 53420, 16294, 28477, 4189}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(ViewConfiguration.getJumpTapTimeout() >> 16, new char[]{15862, 11373, 15765, 33668, 56914, 33048, 29075, 32565, 33763, 16911, 40132, 48278, 16742, 'a', 23916, 64078, 1733, 50912, 7140, 15326, 50265, 34143}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), TextUtils.indexOf("", "", 0, 0) + 35, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(ViewConfiguration.getDoubleTapTimeout() >> 16, new char[]{46804, 13080, 46819, 40167, 29776, 11102, 65236, 61496, 2196, 23920, 14031, 13224, 51715, 7937, 63269, 29958, 36321, 55750, 45543, 46278, 20261, 39541, 29584, 63009, 3712, 21687, 15445, 14822, 49168, 5399, 65214, 31684, 33782, 55248, 49015, 48469, 17773, 36914, 31188, 64697, 1858, 21165, 14926, 15904, 50819, 11394, 58610, 33238, 39014, 60743, 42336, 49941}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(super.getResources().getString(id.dana.R.string.payment_pending_message).substring(11, 13).codePointAt(0) - 44, new char[]{3809, 21146, 3712, 64819, 15848, 25318, 42026, 43674, 45303, 15535, 32638, 26966, 29285, 32389, 48839, 12203, 13781, 47175, 63583, 60986, 63251, 64500, 14968, 44175, 46773, 13671, 30136, 25373, 30839, 29892, 46855, 8507, 15305, 46674, 63132, 59388, 64770, 61922, 12394, 42566, 49010, 13173, 29694, 25821, 32436, 19798, 44315, 56111, 8274, 36033, 60639, 39353, 58258, 52853, 11945, 22535, 42344, 2529, 26686, 7839, 25841, 19223, 43997, 56508, 9792, 35470, 58698, 37757}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(getPackageName().length() - 7, new char[]{42318, 35850, 42364, 9127, 47309, 59280, 35229, 34603, 6919, 57905, 64010, 17645, 55702, 41038, 15280, 536, 40495, 26325, 32040, 50062, 23791, 9523, 48988, 33133, 7500, 60324, 61593, 20138, 54233, 43600, 12913, 3281, 36920, 26816, 29679, 51738, 22265, 12146, 46362, 35825, 5340, 60849, 63118, 18785, 54550, 37776, 10297, 63133, 35750, 21078, 27129, 46171, 18536, 4335, 43915, 30188, 3788, 55159, 60702, 13100, 53081, 38275, 12017, 61791, 36280, 21523, 24685, 48832}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(getPackageName().length() - 7, new char[]{24998, 18050, 25038, 59754, 499, 24255, 31513, 30141, 57253, 10420, 17208, 46706, 7458, 27295, 33481, 61644, 23256, 44058, 50271, 12623, 38915, 61375, 1587, 29678, 55799, 8509, 18851, 48179, 5985, 24779, 35590, 65055, 21714, 41565, 51846, 14472, 37447, 58860, 3170, 31075, 53301, 10081, 20474, 48114, 4519, 22798, 37198, 1026, 20255, 39040, 53456, 18136, 35989, 55850, 4840, 34683, 51748, 7649, 21554, 49643, 3043, 24400, 38803, 926}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(super.getResources().getString(id.dana.R.string.resend_otp_cashier).substring(9, 10).codePointAt(0) - 78, new char[]{31686, 49264, 31743, 28610, 17101, 7617, 14418, 13992, 50564, 44621}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), Gravity.getAbsoluteGravity(0, 0) + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            byte b = (byte) (PlaceComponentResult[5] - 1);
            byte b2 = PlaceComponentResult[5];
            Object[] objArr12 = new Object[1];
            b(b, b2, (byte) (b2 - 1), objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = (byte) (PlaceComponentResult[5] - 1);
            Object[] objArr13 = new Object[1];
            b(b3, b3, PlaceComponentResult[5], objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 494, 4 - ExpandableListView.getPackedPositionType(0L), (char) ('0' - AndroidCharacter.getMirror('0')));
                    Object[] objArr15 = new Object[1];
                    c((byte) (-$$a[9]), (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getTouchSlop() >> 8) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-1512070981, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(id.dana.R.string.error_connection_subtitle).substring(0, 1).codePointAt(0) - 67, new char[]{6652, 13829, 6557, 39415, 39146, 51126, 63687, 63073, 42979, 22624, 55930, 13741, 25981, 6665, 7134, 29533, 8941, 56458, 23882, 45706, 57418, 40752, 40762, 61482, 41368, 20897, 53420, 16294, 28477, 4189}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(id.dana.R.string.withdraw_description).substring(1, 2).codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS, new char[]{15862, 11373, 15765, 33668, 56914, 33048, 29075, 32565, 33763, 16911, 40132, 48278, 16742, 'a', 23916, 64078, 1733, 50912, 7140, 15326, 50265, 34143}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), 17 - ExpandableListView.getPackedPositionChild(0L), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            a(View.combineMeasuredStates(0, 0), new char[]{6652, 13829, 6557, 39415, 39146, 51126, 63687, 63073, 42979, 22624, 55930, 13741, 25981, 6665, 7134, 29533, 8941, 56458, 23882, 45706, 57418, 40752, 40762, 61482, 41368, 20897, 53420, 16294, 28477, 4189}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(id.dana.R.string.username_error_param).substring(0, 9).length() - 9, new char[]{15862, 11373, 15765, 33668, 56914, 33048, 29075, 32565, 33763, 16911, 40132, 48278, 16742, 'a', 23916, 64078, 1733, 50912, 7140, 15326, 50265, 34143}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Drawable.resolveOpacity(0, 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, 18 - View.MeasureSpec.getSize(0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    public final MyBillsContract.Presenter getPresenter() {
        MyBillsContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(MyBillsContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityContinualBillsBinding initViewBinding() {
        ActivityContinualBillsBinding MyBillsEntityDataFactory = ActivityContinualBillsBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(id.dana.R.string.continual_bills_title_page));
        setMenuLeftButton(id.dana.R.drawable.btn_arrow_left);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        getBinding().getAuthRequestContext.setTotalItems(this.KClassImpl$Data$declaredNonStaticMembers$2, new MoneyViewModel(String.valueOf(this.MyBillsEntityDataFactory), "Rp.", null, 4, null));
    }

    public static final /* synthetic */ Target access$createTooltipTarget(ContinualBillsActivity continualBillsActivity, View view, String str) {
        if (view == null) {
            return null;
        }
        return new TargetBuilder(continualBillsActivity).BuiltInFictitiousFunctionClassFactory(new RectangleShape(view, SizeUtil.getAuthRequestContext(4), SizeUtil.getAuthRequestContext(4), SizeUtil.getAuthRequestContext(2), SizeUtil.getAuthRequestContext(2), SizeUtil.getAuthRequestContext(2), SizeUtil.getAuthRequestContext(2))).BuiltInFictitiousFunctionClassFactory(view).getAuthRequestContext(new Content("", str)).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void access$mapDataMonthlyAmountMyBills(ContinualBillsActivity continualBillsActivity, MyBillsMonthlyAmount myBillsMonthlyAmount) {
        TotalEstimatedBillsView totalEstimatedBillsView = continualBillsActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        MyBillsMoneyUtils myBillsMoneyUtils = MyBillsMoneyUtils.INSTANCE;
        MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
        MoneyViewModel MyBillsEntityDataFactory = MyBillsMoneyUtils.MyBillsEntityDataFactory(MoneyViewModel.Companion.PlaceComponentResult(myBillsMonthlyAmount.getTotalEstimatedAmount()));
        MyBillsMoneyUtils myBillsMoneyUtils2 = MyBillsMoneyUtils.INSTANCE;
        MoneyViewModel.Companion companion2 = MoneyViewModel.INSTANCE;
        MoneyViewModel MyBillsEntityDataFactory2 = MyBillsMoneyUtils.MyBillsEntityDataFactory(MoneyViewModel.Companion.PlaceComponentResult(myBillsMonthlyAmount.getPaidTotalAmount()));
        MyBillsMoneyUtils myBillsMoneyUtils3 = MyBillsMoneyUtils.INSTANCE;
        MoneyViewModel.Companion companion3 = MoneyViewModel.INSTANCE;
        totalEstimatedBillsView.setBillsInformation(MyBillsEntityDataFactory, MyBillsEntityDataFactory2, MyBillsMoneyUtils.MyBillsEntityDataFactory(MoneyViewModel.Companion.PlaceComponentResult(myBillsMonthlyAmount.getUnpaidTotalAmount())));
    }

    public static final /* synthetic */ void access$mapDataRangeDate(ContinualBillsActivity continualBillsActivity, String str, String str2) {
        ActivityContinualBillsBinding binding = continualBillsActivity.getBinding();
        binding.lookAheadTest.setText(str);
        binding.MyBillsEntityDataFactory.setText(str2);
    }

    public static final /* synthetic */ void access$mapDataUserBalance(ContinualBillsActivity continualBillsActivity, CurrencyAmountModel currencyAmountModel) {
        FooterMonthlyView footerMonthlyView = continualBillsActivity.getBinding().getAuthRequestContext;
        MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
        footerMonthlyView.setBalance(MoneyViewModel.Companion.getAuthRequestContext(currencyAmountModel));
    }

    public static final /* synthetic */ void access$openTopUpPage(ContinualBillsActivity continualBillsActivity) {
        String MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory("https://m.dana.id/m/portal/topup?entryPoint={entryPoint}").MyBillsEntityDataFactory("entryPoint", TopupSource.MY_BILLS).MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        DanaH5.startContainerFullUrl(MyBillsEntityDataFactory);
    }

    public static final /* synthetic */ void access$showProfileCompletionTooltip(ContinualBillsActivity continualBillsActivity, Target target) {
        if (target == null || continualBillsActivity.getAuthRequestContext != null) {
            return;
        }
        SimpleDismissibleWithCustomDrawable simpleDismissibleWithCustomDrawable = new SimpleDismissibleWithCustomDrawable(continualBillsActivity, Integer.valueOf((int) id.dana.R.color.transparent));
        simpleDismissibleWithCustomDrawable.NetworkUserEntityData$$ExternalSyntheticLambda2 = target;
        simpleDismissibleWithCustomDrawable.BuiltInFictitiousFunctionClassFactory(SizeUtil.getAuthRequestContext(16)).BuiltInFictitiousFunctionClassFactory(true).PlaceComponentResult();
        continualBillsActivity.getAuthRequestContext = null;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        ArrayList parcelableArrayListExtra;
        getBinding().getAuthRequestContext.setButtonTopUpOnCLick(new Function0<Unit>() { // from class: id.dana.mybills.ContinualBillsActivity$initViews$1
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
                ContinualBillsActivity.access$openTopUpPage(ContinualBillsActivity.this);
            }
        });
        DaggerContinualBillsComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerContinualBillsComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (MyBillsModule) Preconditions.getAuthRequestContext(new MyBillsModule(new MyBillsContract.View() { // from class: id.dana.mybills.ContinualBillsActivity$provideMyBillsModule$1
            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(HighlighTransactionPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsMonthlyAmount p0, MonthlyHighlightBillModel p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void MyBillsEntityDataFactory(BizProductOrderModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void MyBillsEntityDataFactory(MonthlyHighlightBillModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void MyBillsEntityDataFactory(List<BillSubscriptionHighlightModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void PlaceComponentResult(List<BizProductModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

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

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(MyBillsMonthlyAmount p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ContinualBillsActivity.access$mapDataMonthlyAmountMyBills(ContinualBillsActivity.this, p0);
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CurrencyAmountModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ContinualBillsActivity.access$mapDataUserBalance(ContinualBillsActivity.this, p0);
            }

            @Override // id.dana.mybills.di.MyBillsContract.View
            public final void getAuthRequestContext(String p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                ContinualBillsActivity.access$mapDataRangeDate(ContinualBillsActivity.this, p0, p1);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, MyBillsModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, ApplicationComponent.class);
        new DaggerContinualBillsComponent.ContinualBillsComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (byte) 0).MyBillsEntityDataFactory(this);
        registerPresenter(getPresenter());
        this.BuiltInFictitiousFunctionClassFactory = new BillsPaymentAdapter();
        RecyclerView recyclerView = getBinding().BuiltInFictitiousFunctionClassFactory;
        BillsPaymentAdapter billsPaymentAdapter = this.BuiltInFictitiousFunctionClassFactory;
        BillsPaymentAdapter billsPaymentAdapter2 = null;
        if (billsPaymentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            billsPaymentAdapter = null;
        }
        recyclerView.setAdapter(billsPaymentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        Intent intent = getIntent();
        if (intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(CONTINUAL_DATA)) != null) {
            BillsPaymentAdapter billsPaymentAdapter3 = this.BuiltInFictitiousFunctionClassFactory;
            if (billsPaymentAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                billsPaymentAdapter3 = null;
            }
            List list = CollectionsKt.toList(parcelableArrayListExtra);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(BillPaymentAdapterModelKt.getAuthRequestContext((BillSubscriptionHighlightModel) it.next()));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : arrayList) {
                BillPaymentStatusModel billPaymentStatusModel = ((BillPaymentAdapterModel) obj).BuiltInFictitiousFunctionClassFactory;
                Boolean valueOf = Boolean.valueOf(Intrinsics.areEqual(billPaymentStatusModel != null ? billPaymentStatusModel.NetworkUserEntityData$$ExternalSyntheticLambda2 : null, "PAID"));
                Object obj2 = linkedHashMap.get(valueOf);
                if (obj2 == null) {
                    obj2 = (List) new ArrayList();
                    linkedHashMap.put(valueOf, obj2);
                }
                ((List) obj2).add(obj);
            }
            BillPaymentAdapterModel[] billPaymentAdapterModelArr = new BillPaymentAdapterModel[4];
            List list2 = (List) linkedHashMap.get(Boolean.FALSE);
            BillPaymentStatusModel billPaymentStatusModel2 = null;
            DefaultConstructorMarker defaultConstructorMarker = null;
            billPaymentAdapterModelArr[0] = new BillPaymentAdapterModel(new BillsPaymentHeaderModel("UNPAID", list2 != null ? list2.size() : 0, false), billPaymentStatusModel2, null, BillPaymentAdapterModel.ViewTypeEnum.HEADER.ordinal(), 6, defaultConstructorMarker);
            billPaymentAdapterModelArr[1] = new BillPaymentAdapterModel(null, billPaymentStatusModel2, (List) linkedHashMap.get(Boolean.FALSE), BillPaymentAdapterModel.ViewTypeEnum.GROUP.ordinal(), 3, defaultConstructorMarker);
            List list3 = (List) linkedHashMap.get(Boolean.TRUE);
            billPaymentAdapterModelArr[2] = new BillPaymentAdapterModel(new BillsPaymentHeaderModel("PAID", list3 != null ? list3.size() : (byte) 0, true), null, null, BillPaymentAdapterModel.ViewTypeEnum.HEADER.ordinal(), 6, null);
            billPaymentAdapterModelArr[3] = new BillPaymentAdapterModel(null, null, (List) linkedHashMap.get(Boolean.TRUE), BillPaymentAdapterModel.ViewTypeEnum.GROUP.ordinal(), 3, null);
            billsPaymentAdapter3.setItems(CollectionsKt.listOf((Object[]) billPaymentAdapterModelArr));
        }
        BillsPaymentAdapter billsPaymentAdapter4 = this.BuiltInFictitiousFunctionClassFactory;
        if (billsPaymentAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            billsPaymentAdapter2 = billsPaymentAdapter4;
        }
        billsPaymentAdapter2.setOnItemClickListener(new GroupedBillPaymentsListener() { // from class: id.dana.mybills.ContinualBillsActivity$setupBillPaymentRecyclerViewData$2
            @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
            }

            @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
            public final void MyBillsEntityDataFactory(int p0) {
            }

            @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
            public final void PlaceComponentResult(int p0, boolean p1) {
            }

            @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
            public final void PlaceComponentResult(BillPaymentAdapterModel p0) {
            }

            @Override // id.dana.mybills.listener.GroupedBillPaymentsListener, id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int p0) {
            }

            @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
            public final void PlaceComponentResult(BillPaymentAdapterModel p0, boolean p1) {
                int i;
                int i2;
                BillPaymentStatusModel billPaymentStatusModel3;
                MoneyViewModel moneyViewModel;
                String str;
                String replace$default;
                int i3;
                int i4;
                BillPaymentStatusModel billPaymentStatusModel4;
                MoneyViewModel moneyViewModel2;
                String str2;
                String replace$default2;
                int i5 = 0;
                if (p1) {
                    ContinualBillsActivity continualBillsActivity = ContinualBillsActivity.this;
                    i3 = continualBillsActivity.KClassImpl$Data$declaredNonStaticMembers$2;
                    continualBillsActivity.KClassImpl$Data$declaredNonStaticMembers$2 = i3 + 1;
                    ContinualBillsActivity continualBillsActivity2 = ContinualBillsActivity.this;
                    i4 = continualBillsActivity2.MyBillsEntityDataFactory;
                    if (p0 != null && (billPaymentStatusModel4 = p0.BuiltInFictitiousFunctionClassFactory) != null && (moneyViewModel2 = billPaymentStatusModel4.initRecordTimeStamp) != null && (str2 = moneyViewModel2.PlaceComponentResult) != null && (replace$default2 = StringsKt.replace$default(str2, ".", "", false, 4, (Object) null)) != null) {
                        i5 = Integer.parseInt(replace$default2);
                    }
                    continualBillsActivity2.MyBillsEntityDataFactory = i4 + i5;
                } else {
                    ContinualBillsActivity continualBillsActivity3 = ContinualBillsActivity.this;
                    i = continualBillsActivity3.KClassImpl$Data$declaredNonStaticMembers$2;
                    continualBillsActivity3.KClassImpl$Data$declaredNonStaticMembers$2 = i - 1;
                    ContinualBillsActivity continualBillsActivity4 = ContinualBillsActivity.this;
                    i2 = continualBillsActivity4.MyBillsEntityDataFactory;
                    if (p0 != null && (billPaymentStatusModel3 = p0.BuiltInFictitiousFunctionClassFactory) != null && (moneyViewModel = billPaymentStatusModel3.initRecordTimeStamp) != null && (str = moneyViewModel.PlaceComponentResult) != null && (replace$default = StringsKt.replace$default(str, ".", "", false, 4, (Object) null)) != null) {
                        i5 = Integer.parseInt(replace$default);
                    }
                    continualBillsActivity4.MyBillsEntityDataFactory = i2 - i5;
                }
                ContinualBillsActivity.this.getAuthRequestContext();
            }

            @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
            public final void PlaceComponentResult(BillPaymentAdapterModel p0, RecyclerView.ViewHolder p1) {
                View view;
                ContinualBillsActivity continualBillsActivity = ContinualBillsActivity.this;
                View findViewById = (p1 == null || (view = p1.itemView) == null) ? null : view.findViewById(id.dana.R.id.ivBillHelp);
                String string = ContinualBillsActivity.this.getString(id.dana.R.string.mybills_tooltip_description);
                Intrinsics.checkNotNullExpressionValue(string, "");
                ContinualBillsActivity.access$showProfileCompletionTooltip(continualBillsActivity, ContinualBillsActivity.access$createTooltipTarget(continualBillsActivity, findViewById, string));
            }

            @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(BillPaymentAdapterModel p0, RecyclerView.ViewHolder p1) {
                String string;
                BillPaymentStatusModel billPaymentStatusModel3;
                View view;
                ContinualBillsActivity continualBillsActivity = ContinualBillsActivity.this;
                String str = null;
                View findViewById = (p1 == null || (view = p1.itemView) == null) ? null : view.findViewById(id.dana.R.id.civBizRecurringLogo);
                if (p0 != null && (billPaymentStatusModel3 = p0.BuiltInFictitiousFunctionClassFactory) != null) {
                    str = billPaymentStatusModel3.DatabaseTableConfigUtil;
                }
                if (Intrinsics.areEqual(str, RecurringType.REMINDER)) {
                    string = ContinualBillsActivity.this.getString(id.dana.R.string.mybills_tooltip_reminder);
                } else {
                    string = ContinualBillsActivity.this.getString(id.dana.R.string.mybills_tooltip_auto_deduct);
                }
                Intrinsics.checkNotNullExpressionValue(string, "");
                ContinualBillsActivity.access$showProfileCompletionTooltip(continualBillsActivity, ContinualBillsActivity.access$createTooltipTarget(continualBillsActivity, findViewById, string));
            }
        });
        getPresenter().getAuthRequestContext();
        getPresenter().BuiltInFictitiousFunctionClassFactory();
        getPresenter().KClassImpl$Data$declaredNonStaticMembers$2("", "", "");
        getAuthRequestContext();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}
