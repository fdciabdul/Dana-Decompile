package id.dana.statement.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
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
import android.view.ViewTreeObserver;
import android.widget.ExpandableListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.domain.statement.StatementType;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.statement.StatementChartView;
import id.dana.statement.adapter.StatementDownloadAdapter;
import id.dana.statement.model.StatementDetailModel;
import id.dana.statement.model.StatementSummaryModel;
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.UserStatementModel;
import id.dana.util.media.FileUtil;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.ScreenShotUtil;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J?\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00100\nj\b\u0012\u0004\u0012\u00020\u0010`\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0011\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/statement/view/StatementDownloadActivity;", "Lid/dana/base/BaseActivity;", "", "PlaceComponentResult", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "getAuthRequestContext", "Ljava/util/ArrayList;", "Lid/dana/statement/model/StatementDetailModel;", "Lkotlin/collections/ArrayList;", "p0", "Lid/dana/domain/statement/StatementType;", "p1", "Lcom/github/mikephil/charting/data/Entry;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/ArrayList;Lid/dana/domain/statement/StatementType;)Ljava/util/ArrayList;", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lid/dana/statement/model/UserStatementModel;", "getErrorConfigVersion", "Lid/dana/statement/model/UserStatementModel;", "Lid/dana/statement/adapter/StatementDownloadAdapter;", "scheduleImpl", "Lid/dana/statement/adapter/StatementDownloadAdapter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementDownloadActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char DatabaseTableConfigUtil;
    private static char GetContactSyncConfig;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda2;
    private static char lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final ActivityPermissionRequest KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private UserStatementModel getAuthRequestContext;
    public static final byte[] $$a = {116, -27, -60, 115, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 14;
    public static final byte[] getAuthRequestContext = {116, 58, -28, -63, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = 118;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private StatementDownloadAdapter PlaceComponentResult = new StatementDownloadAdapter();

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        GetContactSyncConfig = (char) 9288;
        lookAheadTest = (char) 14643;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = (char) 47533;
        DatabaseTableConfigUtil = (char) 7625;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 105
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r0 = id.dana.statement.view.StatementDownloadActivity.getAuthRequestContext
            int r6 = r6 * 15
            int r6 = 19 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = 0
            r8 = r7
            r7 = r6
            goto L2e
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + 2
            int r7 = r7 + 1
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.statement.view.StatementDownloadActivity.b(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = 42 - r9
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = id.dana.statement.view.StatementDownloadActivity.$$a
            int r8 = 46 - r8
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r8 = r8 + r9
            int r8 = r8 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.statement.view.StatementDownloadActivity.c(byte, short, short, java.lang.Object[]):void");
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
        a(Color.rgb(0, 0, 0) + 16777234, new char[]{51435, 60542, 34468, 52483, 30455, 62970, 37816, 24526, 18995, 59926, 27590, 16252, 15730, 7962, 62778, 49249, 39683, 52295}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(5 - ExpandableListView.getPackedPositionType(0L), new char[]{64300, 28831, 28538, 22647, 23560, 12545}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, View.combineMeasuredStates(0, 0) + 35, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - TextUtils.indexOf("", "", 0), new char[]{35949, 4009, 38731, 35555, 8539, 11063, 12873, 31409, 41079, 43654, 53836, 47930, 9386, 64325, 6580, '}', 46186, 41601, 61846, 50211, 42085, 62491, 48561, 1523, 13156, 60080, 35548, 34384, 35771, 11973, 492, 47254, 25117, 44890, 65420, 36823, 297, 13981, 43573, 6314, 17439, 7760, 31753, 17484, 20427, 2852, 22166, 37157}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(TextUtils.lastIndexOf("", '0', 0, 0) + 65, new char[]{8584, 55875, 5800, 52260, 297, 13981, 5946, 17986, 42085, 62491, 50448, 48026, 30317, 48562, 56072, 5679, 48732, 30339, 35633, 59625, 30317, 48562, 63905, 39850, 25730, 49259, 34931, 29305, 35548, 34384, 48732, 30339, 26906, 27915, 49753, 25095, 44560, 9382, 1249, 45916, 51886, 63021, 30349, 45228, 41374, 59465, 41595, 29493, 47055, 23262, 54491, 5938, 52323, 16911, 22634, 17497, 22634, 17497, 3404, 32320, 45615, 21968, 13156, 60080}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(Process.getGidForName("") + 65, new char[]{51639, 56550, 14345, 21041, 52323, 16911, 33327, 63860, 47705, 34486, 55602, 27772, 64310, 58575, 41783, 11792, 492, 47254, 59379, 3932, 58255, 32408, 30082, 6435, 17439, 7760, 12873, 31409, 54423, 50628, 35949, 4009, 12798, 12628, 53691, 47360, 34473, 34062, 38731, 35555, 44211, 61676, 56072, 5679, 43573, 6314, 11842, 65239, 297, 13981, 62778, 49249, 51639, 56550, 49301, 33186, 30969, 14656, 25117, 44890, 49301, 33186, 42381, 18195}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{2950, 27289, 25218, 15420, 4685, 44424, 33504, 41489, 12112, 2071, 5750, 29526, 2886, 64158, 61287, 22890, 23427, 45908, 56605, 45858, 27904, 58826, 16617, 63101, 64145, 50908, 9542, 2248, 34497, 62528, 42270, 21777, 9542, 2248, 44791, 14184, 61221, 26843, 50412, 45810, 42930, 30372, 31886, 35377, 48602, 33515, 16389, 12437, 23381, 14632, 15388, 20339, 11409, 51081, 62768, 20779, 58038, 5922, 7519, 63671}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(Color.rgb(0, 0, 0) + 16777222, new char[]{48582, 59770, 9184, 19148, 51639, 56550}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (getAuthRequestContext[5] - 1);
                Object[] objArr13 = new Object[1];
                b(b, b, getAuthRequestContext[5], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = getAuthRequestContext[5];
                byte b3 = (byte) (b2 - 1);
                Object[] objArr14 = new Object[1];
                b(b2, b3, b3, objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 2, (char) View.combineMeasuredStates(0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[53], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 800, 14 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 16 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 815, 29 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (57994 - (ViewConfiguration.getPressedStateDuration() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 800, 15 - KeyEvent.keyCodeFromString(""), (char) (ViewConfiguration.getPressedStateDuration() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getTrimmedLength("") + 35, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1740360829, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 910, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (getAuthRequestContext[5] - 1);
                Object[] objArr19 = new Object[1];
                b(b4, b4, getAuthRequestContext[5], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b5 = getAuthRequestContext[5];
                byte b6 = (byte) (b5 - 1);
                Object[] objArr20 = new Object[1];
                b(b5, b6, b6, objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - ((Process.getThreadPriority(0) + 20) >> 6), 46 - TextUtils.getCapsMode("", 0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        Object[] objArr22 = new Object[1];
                        c((byte) $$b, $$a[84], $$a[8], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), Color.argb(0, 0, 0, 0) + 35, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1740360829, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), View.getDefaultSize(0, 0) + 18, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (getAuthRequestContext[5] - 1);
                Object[] objArr25 = new Object[1];
                b(b7, b7, getAuthRequestContext[5], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b8 = getAuthRequestContext[5];
                byte b9 = (byte) (b8 - 1);
                Object[] objArr26 = new Object[1];
                b(b8, b9, b9, objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - TextUtils.getTrimmedLength(""), 3 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 38969));
                        Object[] objArr28 = new Object[1];
                        c((byte) $$b, $$a[84], $$a[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 35 - TextUtils.indexOf("", "", 0), (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1740360829, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, View.resolveSizeAndState(0, 0, 0) + 18, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (getAuthRequestContext[5] - 1);
                Object[] objArr31 = new Object[1];
                b(b10, b10, getAuthRequestContext[5], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b11 = getAuthRequestContext[5];
                byte b12 = (byte) (b11 - 1);
                Object[] objArr32 = new Object[1];
                b(b11, b12, b12, objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 107, 3 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        byte b13 = (byte) ($$a[78] - 1);
                        byte b14 = b13;
                        Object[] objArr34 = new Object[1];
                        c(b13, b14, b14, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1740360829, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 17 - TextUtils.lastIndexOf("", '0', 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_download_statement;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(getPackageName().codePointAt(3) - 82, new char[]{51435, 60542, 34468, 52483, 30455, 62970, 37816, 24526, 18995, 59926, 27590, 16252, 15730, 7962, 62778, 49249, 39683, 52295}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(5 - ExpandableListView.getPackedPositionGroup(0L), new char[]{64300, 28831, 28538, 22647, 23560, 12545}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{51435, 60542, 34468, 52483, 30455, 62970, 37816, 24526, 42930, 30372, 33734, 56741, 48056, 36609, 15949, 29038, 660, 51477, 26724, 17759, 18584, 29632, 24645, 21531, 34026, 45067}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a((ViewConfiguration.getEdgeSlop() >> 16) + 18, new char[]{56257, 64553, 1651, 18948, 58038, 5922, 7263, 21825, 12326, 23095, 37414, 16794, 54479, 9638, 15949, 29038, 23631, 13656}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(48 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{35949, 4009, 38731, 35555, 8539, 11063, 12873, 31409, 41079, 43654, 53836, 47930, 9386, 64325, 6580, '}', 46186, 41601, 61846, 50211, 42085, 62491, 48561, 1523, 13156, 60080, 35548, 34384, 35771, 11973, 492, 47254, 25117, 44890, 65420, 36823, 297, 13981, 43573, 6314, 17439, 7760, 31753, 17484, 20427, 2852, 22166, 37157}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(super.getResources().getString(R.string.lbl_dialog_account_freeze).substring(0, 1).codePointAt(0) - 1, new char[]{8584, 55875, 5800, 52260, 297, 13981, 5946, 17986, 42085, 62491, 50448, 48026, 30317, 48562, 56072, 5679, 48732, 30339, 35633, 59625, 30317, 48562, 63905, 39850, 25730, 49259, 34931, 29305, 35548, 34384, 48732, 30339, 26906, 27915, 49753, 25095, 44560, 9382, 1249, 45916, 51886, 63021, 30349, 45228, 41374, 59465, 41595, 29493, 47055, 23262, 54491, 5938, 52323, 16911, 22634, 17497, 22634, 17497, 3404, 32320, 45615, 21968, 13156, 60080}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(super.getResources().getString(R.string.danaviz_only_confirmation_subtitle).substring(7, 8).codePointAt(0) - 37, new char[]{51639, 56550, 14345, 21041, 52323, 16911, 33327, 63860, 47705, 34486, 55602, 27772, 64310, 58575, 41783, 11792, 492, 47254, 59379, 3932, 58255, 32408, 30082, 6435, 17439, 7760, 12873, 31409, 54423, 50628, 35949, 4009, 12798, 12628, 53691, 47360, 34473, 34062, 38731, 35555, 44211, 61676, 56072, 5679, 43573, 6314, 11842, 65239, 297, 13981, 62778, 49249, 51639, 56550, 49301, 33186, 30969, 14656, 25117, 44890, 49301, 33186, 42381, 18195}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(super.getResources().getString(R.string.give_notes).substring(4, 5).length() + 59, new char[]{2950, 27289, 25218, 15420, 4685, 44424, 33504, 41489, 12112, 2071, 5750, 29526, 2886, 64158, 61287, 22890, 23427, 45908, 56605, 45858, 27904, 58826, 16617, 63101, 64145, 50908, 9542, 2248, 34497, 62528, 42270, 21777, 9542, 2248, 44791, 14184, 61221, 26843, 50412, 45810, 42930, 30372, 31886, 35377, 48602, 33515, 16389, 12437, 23381, 14632, 15388, 20339, 11409, 51081, 62768, 20779, 58038, 5922, 7519, 63671}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(super.getResources().getString(R.string.no_contact).substring(0, 1).length() + 5, new char[]{48582, 59770, 9184, 19148, 51639, 56550}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), ExpandableListView.getPackedPositionChild(0L) + 19, (char) (MotionEvent.axisFromString("") + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            byte b = (byte) (getAuthRequestContext[5] - 1);
            Object[] objArr12 = new Object[1];
            b(b, b, getAuthRequestContext[5], objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b2 = getAuthRequestContext[5];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr13 = new Object[1];
            b(b2, b3, b3, objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 494, 4 - (ViewConfiguration.getTouchSlop() >> 8), (char) Color.alpha(0));
                    byte b4 = (byte) ($$a[78] - 1);
                    byte b5 = b4;
                    Object[] objArr15 = new Object[1];
                    c(b4, b5, b5, objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-1100163496, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 911, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 26, new char[]{51435, 60542, 34468, 52483, 30455, 62970, 37816, 24526, 42930, 30372, 33734, 56741, 48056, 36609, 15949, 29038, 660, 51477, 26724, 17759, 18584, 29632, 24645, 21531, 34026, 45067}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(Color.green(0) + 18, new char[]{56257, 64553, 1651, 18948, 58038, 5922, 7263, 21825, 12326, 23095, 37414, 16794, 54479, 9638, 15949, 29038, 23631, 13656}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.family_account_text_month_transaction_limit_desc).substring(7, 8).codePointAt(0) - 6, new char[]{51435, 60542, 34468, 52483, 30455, 62970, 37816, 24526, 42930, 30372, 33734, 56741, 48056, 36609, 15949, 29038, 660, 51477, 26724, 17759, 18584, 29632, 24645, 21531, 34026, 45067}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().codePointAt(2) - 28, new char[]{56257, 64553, 1651, 18948, 58038, 5922, 7263, 21825, 12326, 23095, 37414, 16794, 54479, 9638, 15949, 29038, 23631, 13656}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 17 - MotionEvent.axisFromString(""), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public StatementDownloadActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.statement.view.StatementDownloadActivity$screenShotPermission$1
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
                    StatementDownloadActivity.this.PlaceComponentResult();
                } else {
                    StatementDownloadActivity.this.getAuthRequestContext();
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult();
    }

    private static ArrayList<Entry> KClassImpl$Data$declaredNonStaticMembers$2(ArrayList<StatementDetailModel> p0, StatementType p1) {
        ArrayList<Entry> arrayList = new ArrayList<>();
        Iterator<T> it = p0.iterator();
        while (it.hasNext()) {
            String str = ((StatementDetailModel) it.next()).MyBillsEntityDataFactory.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(str, "");
            arrayList.add(new Entry(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(r1.getAuthRequestContext), Float.parseFloat(StringsKt.replace$default(str, ".", "", false, 4, (Object) null)), p1));
        }
        return arrayList;
    }

    public final void PlaceComponentResult() {
        final Ref.IntRef intRef = new Ref.IntRef();
        ((RecyclerView) _$_findCachedViewById(R.id.rv_statement_history)).setLayoutManager(new LinearLayoutManager() { // from class: id.dana.statement.view.StatementDownloadActivity$checkRecyclerViewFullyLoaded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(StatementDownloadActivity.this, 1, false);
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public final void onLayoutCompleted(RecyclerView.State p0) {
                super.onLayoutCompleted(p0);
                intRef.element++;
                int findLastVisibleItemPosition = findLastVisibleItemPosition();
                int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
                RecyclerView.Adapter adapter = ((RecyclerView) StatementDownloadActivity.this._$_findCachedViewById(R.id.rv_statement_history)).getAdapter();
                Integer valueOf = adapter != null ? Integer.valueOf(adapter.getPlaceComponentResult()) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.intValue() < (findLastVisibleItemPosition - findFirstVisibleItemPosition) + 1 || intRef.element != 2) {
                    return;
                }
                StatementDownloadActivity.access$prepareViewToSnap(StatementDownloadActivity.this);
            }
        });
    }

    public final void getAuthRequestContext() {
        CustomToastUtil.PlaceComponentResult(this, R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1, R.drawable.bg_rounded_toast_failed, getString(R.string.download_statement_failed_message), 48, 60, false, null, 384);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J[\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/statement/view/StatementDownloadActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "Lid/dana/statement/model/StatementViewModel;", "p1", "Lid/dana/statement/model/UserStatementModel;", "p2", "Ljava/util/ArrayList;", "Lid/dana/statement/model/StatementDetailModel;", "Lkotlin/collections/ArrayList;", "p3", "p4", "Landroid/content/Intent;", "PlaceComponentResult", "(Landroid/content/Context;Ljava/util/List;Lid/dana/statement/model/UserStatementModel;Ljava/util/ArrayList;Ljava/util/ArrayList;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent PlaceComponentResult(Context p0, List<StatementViewModel> p1, UserStatementModel p2, ArrayList<StatementDetailModel> p3, ArrayList<StatementDetailModel> p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            Intent intent = new Intent(p0, StatementDownloadActivity.class);
            intent.putParcelableArrayListExtra("data", new ArrayList<>(p1));
            intent.putExtra("source", p2);
            intent.putParcelableArrayListExtra("statement_income_data", p3);
            intent.putParcelableArrayListExtra("statement_expense_data", p4);
            return intent;
        }
    }

    public static final /* synthetic */ void access$prepareViewToSnap(final StatementDownloadActivity statementDownloadActivity) {
        final ScrollView scrollView = (ScrollView) statementDownloadActivity._$_findCachedViewById(R.id.sv_statement_feeds);
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.statement.view.StatementDownloadActivity$prepareViewToSnap$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                scrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                StatementDownloadActivity statementDownloadActivity2 = statementDownloadActivity;
                ScrollView scrollView2 = scrollView;
                Intrinsics.checkNotNullExpressionValue(scrollView2, "");
                StatementDownloadActivity.access$takeScreenShot(statementDownloadActivity2, scrollView2);
            }
        });
    }

    public static final /* synthetic */ void access$takeScreenShot(StatementDownloadActivity statementDownloadActivity, View view) {
        String BuiltInFictitiousFunctionClassFactory;
        String str;
        ScreenShotUtil screenShotUtil = ScreenShotUtil.INSTANCE;
        StatementDownloadActivity statementDownloadActivity2 = statementDownloadActivity;
        Intrinsics.checkNotNullParameter(statementDownloadActivity2, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(DanaLogConstants.TAG.STATEMENT, "");
        if (FileUtil.BuiltInFictitiousFunctionClassFactory() <= 100) {
            str = "004";
        } else {
            if (view instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) view;
                int childCount = scrollView.getChildCount();
                int i = 0;
                for (int i2 = 0; i2 < childCount; i2++) {
                    i += scrollView.getChildAt(i2).getHeight();
                }
                Bitmap KClassImpl$Data$declaredNonStaticMembers$2 = ScreenShotUtil.KClassImpl$Data$declaredNonStaticMembers$2(scrollView, scrollView.getWidth(), i);
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.TAG.STATEMENT);
                sb.append('-');
                sb.append(System.currentTimeMillis());
                BuiltInFictitiousFunctionClassFactory = ScreenShotUtil.BuiltInFictitiousFunctionClassFactory(statementDownloadActivity2, KClassImpl$Data$declaredNonStaticMembers$2, sb.toString());
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null && Intrinsics.areEqual("001", BuiltInFictitiousFunctionClassFactory) && !KClassImpl$Data$declaredNonStaticMembers$2.isRecycled()) {
                    KClassImpl$Data$declaredNonStaticMembers$2.recycle();
                }
            } else {
                Bitmap PlaceComponentResult2 = ScreenShotUtil.PlaceComponentResult(view);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(DanaLogConstants.TAG.STATEMENT);
                sb2.append('-');
                sb2.append(System.currentTimeMillis());
                BuiltInFictitiousFunctionClassFactory = ScreenShotUtil.BuiltInFictitiousFunctionClassFactory(statementDownloadActivity2, PlaceComponentResult2, sb2.toString());
                if (PlaceComponentResult2 != null && Intrinsics.areEqual("001", BuiltInFictitiousFunctionClassFactory) && !PlaceComponentResult2.isRecycled()) {
                    PlaceComponentResult2.recycle();
                }
            }
            str = BuiltInFictitiousFunctionClassFactory;
        }
        if (!Intrinsics.areEqual("001", str)) {
            statementDownloadActivity.getAuthRequestContext();
        } else {
            CustomToastUtil.PlaceComponentResult(statementDownloadActivity, R.drawable.ic_success, R.drawable.bg_rounded_toast_success, statementDownloadActivity.getString(R.string.download_statement_success_message), 48, 60, false, statementDownloadActivity.getString(R.string.toastDownloadSuccess), 128);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        setTitle(getString(R.string.statement_summary));
        setMenuLeftButton(R.drawable.ic_close);
        View _$_findCachedViewById = _$_findCachedViewById(R.id.SecurityGuardProfileProvider);
        UserStatementModel userStatementModel = null;
        TextView textView = _$_findCachedViewById != null ? (TextView) _$_findCachedViewById.findViewById(R.id.getDataset2Color) : null;
        if (textView != null) {
            textView.setContentDescription(getString(R.string.lblStatementSummary));
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ArrayList parcelableArrayList = extras.getParcelableArrayList("data");
            UserStatementModel userStatementModel2 = (UserStatementModel) extras.getParcelable("source");
            if (parcelableArrayList != null) {
                ArrayList arrayList = parcelableArrayList;
                CollectionsKt.removeAll((List) arrayList, (Function1) new Function1<StatementViewModel, Boolean>() { // from class: id.dana.statement.view.StatementDownloadActivity$removeEmptyData$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(StatementViewModel statementViewModel) {
                        Intrinsics.checkNotNullParameter(statementViewModel, "");
                        List<StatementSummaryModel> list = statementViewModel.PlaceComponentResult.MyBillsEntityDataFactory;
                        return Boolean.valueOf(list != null && list.isEmpty());
                    }
                });
                this.PlaceComponentResult.setItems(arrayList);
            }
            if (userStatementModel2 != null) {
                this.getAuthRequestContext = userStatementModel2;
            }
            Collection parcelableArrayList2 = extras.getParcelableArrayList("statement_income_data");
            if (parcelableArrayList2 == null) {
                parcelableArrayList2 = CollectionsKt.emptyList();
            }
            ArrayList arrayList2 = new ArrayList(parcelableArrayList2);
            Collection parcelableArrayList3 = extras.getParcelableArrayList("statement_expense_data");
            if (parcelableArrayList3 == null) {
                parcelableArrayList3 = CollectionsKt.emptyList();
            }
            ArrayList arrayList3 = new ArrayList(parcelableArrayList3);
            ArrayList<Entry> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(arrayList2, StatementType.INCOME);
            ArrayList<Entry> KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(arrayList3, StatementType.EXPENSE);
            StatementChartView statementChartView = (StatementChartView) _$_findCachedViewById(R.id.SQLiteDatabaseCorruptException);
            statementChartView.setLineDataSet1(new LineDataSet(KClassImpl$Data$declaredNonStaticMembers$2, "income"));
            statementChartView.getLineDataSet1().readMicros();
            statementChartView.setLineDataSet2(new LineDataSet(KClassImpl$Data$declaredNonStaticMembers$22, "expense"));
            statementChartView.getLineDataSet2().readMicros();
            statementChartView.getXAxis().KClassImpl$Data$declaredNonStaticMembers$2(4.0f);
            statementChartView.setAnimationEnable(false);
            statementChartView.build();
        }
        StatementDateView statementDateView = (StatementDateView) _$_findCachedViewById(R.id.WithdrawSavedCardChannelModel);
        statementDateView.hideRollingMonthArrow();
        UserStatementModel userStatementModel3 = this.getAuthRequestContext;
        if (userStatementModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userStatementModel3 = null;
        }
        statementDateView.setMonth(userStatementModel3.BuiltInFictitiousFunctionClassFactory);
        UserStatementModel userStatementModel4 = this.getAuthRequestContext;
        if (userStatementModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userStatementModel4 = null;
        }
        statementDateView.setRunningDate(userStatementModel4.KClassImpl$Data$declaredNonStaticMembers$2);
        AccumulateStatementAmountView accumulateStatementAmountView = (AccumulateStatementAmountView) _$_findCachedViewById(R.id.view_accumulate_statement_amount);
        UserStatementModel userStatementModel5 = this.getAuthRequestContext;
        if (userStatementModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userStatementModel5 = null;
        }
        accumulateStatementAmountView.setTotalIncome(userStatementModel5.lookAheadTest);
        UserStatementModel userStatementModel6 = this.getAuthRequestContext;
        if (userStatementModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            userStatementModel = userStatementModel6;
        }
        accumulateStatementAmountView.setTotalExpense(userStatementModel.moveToNextValue);
        accumulateStatementAmountView.disableClickOptionStatementMenu();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_statement_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(this.PlaceComponentResult);
        if (OSUtil.MyBillsEntityDataFactory()) {
            PlaceComponentResult();
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.check();
        }
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
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (DatabaseTableConfigUtil ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (lookAheadTest ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (GetContactSyncConfig ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
