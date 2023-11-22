package id.dana.cancelsurvey.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractActivityResultContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.ThrottledOnItemClickListener;
import id.dana.cancelsurvey.adapter.CancelReasonAdapter;
import id.dana.cancelsurvey.di.CancelSurveyModule;
import id.dana.cancelsurvey.di.DaggerCancelSurveyComponent;
import id.dana.cancelsurvey.model.BottomSheetCancelReasonModel;
import id.dana.cancelsurvey.model.BottomSheetCancelReasonResultModel;
import id.dana.cancelsurvey.model.CancelReasonModel;
import id.dana.cancelsurvey.presenter.CancelSurveyContract;
import id.dana.cancelsurvey.presenter.CancelSurveyPresenter;
import id.dana.common.DividerItemDecoration;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.cancelsurvey.interactor.SubmitCancelSurveyReason;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.DANAToast;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.OSUtil;
import id.dana.utils.SafeClickListenerExtensionKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0002@CX\u0083\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001d\"\u0004\b\r\u0010\u001e"}, d2 = {"Lid/dana/cancelsurvey/view/BottomSheetCancelSurveyActivity;", "Lid/dana/base/BaseActivity;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onBackPressed", "Lid/dana/cancelsurvey/adapter/CancelReasonAdapter;", "p0", "Lid/dana/cancelsurvey/model/CancelReasonModel;", "p1", "MyBillsEntityDataFactory", "(Lid/dana/cancelsurvey/adapter/CancelReasonAdapter;Lid/dana/cancelsurvey/model/CancelReasonModel;)V", "onPause", "onStart", "Lid/dana/cancelsurvey/model/BottomSheetCancelReasonModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/cancelsurvey/model/BottomSheetCancelReasonModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cancelsurvey/presenter/CancelSurveyPresenter;", "cancelSurveyPresenter", "Lid/dana/cancelsurvey/presenter/CancelSurveyPresenter;", "getCancelSurveyPresenter", "()Lid/dana/cancelsurvey/presenter/CancelSurveyPresenter;", "setCancelSurveyPresenter", "(Lid/dana/cancelsurvey/presenter/CancelSurveyPresenter;)V", "scheduleImpl", "Lid/dana/cancelsurvey/model/CancelReasonModel;", "(Lid/dana/cancelsurvey/model/CancelReasonModel;)V", "getAuthRequestContext", "<init>", "BottomSheetCancelSurveyActivityContract"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BottomSheetCancelSurveyActivity extends BaseActivity {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private BottomSheetCancelReasonModel KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public CancelSurveyPresenter cancelSurveyPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private CancelReasonModel getAuthRequestContext;
    public static final byte[] $$a = {36, -25, -14, -85, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 133;
    public static final byte[] PlaceComponentResult = {99, 56, -99, 122, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 240;
    private static char lookAheadTest = 6478;
    private static char getErrorConfigVersion = 65456;
    private static char initRecordTimeStamp = 6010;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda1 = 32693;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = 23 - r6
            int r7 = 56 - r7
            byte[] r0 = id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity.PlaceComponentResult
            int r8 = r8 + 97
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L17:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r6 = -r6
            int r8 = r8 + 1
            int r9 = r9 + r6
            int r6 = r9 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity.a(byte, int, byte, java.lang.Object[]):void");
    }

    private static void c(int i, short s, int i2, Object[] objArr) {
        int i3 = 103 - (s * 2);
        byte[] bArr = $$a;
        int i4 = 42 - (i2 * 3);
        int i5 = 47 - i;
        byte[] bArr2 = new byte[i4];
        int i6 = -1;
        int i7 = i4 - 1;
        if (bArr == null) {
            i5++;
            i3 = (i3 + (-i7)) - 7;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
        }
        while (true) {
            int i8 = i6 + 1;
            bArr2[i8] = (byte) i3;
            if (i8 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            Object[] objArr2 = objArr;
            int i9 = i7;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            i5++;
            i3 = (i3 + (-bArr[i5])) - 7;
            i7 = i9;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i6 = i8;
        }
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
        b(18 - (ViewConfiguration.getFadingEdgeLength() >> 16), new char[]{3321, 35252, 55813, 23358, 21839, 20438, 43537, 28536, 43430, 14339, 25712, 27413, 59695, 2910, 8624, 51298, 57561, 36749}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(5 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{54216, 822, 17290, 58779, 21599, 25208}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(48 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{63195, 56845, 60875, 14925, 4290, 32558, 4144, 10945, 16147, 54867, 64474, 27844, 16779, 60707, 62539, 12552, 36422, 13323, 23329, 9347, 28863, 54956, 15867, 55129, 31554, 61827, 52654, 9811, 54102, 44925, 48124, 14557, 16956, 33536, 31298, 60185, 26947, 37149, 18169, 16590, 36299, 37127, 48629, 22726, 51398, 30574, 17524, 14145}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(TextUtils.getOffsetBefore("", 0) + 64, new char[]{48649, 17502, 47652, 7531, 26947, 37149, 52546, 64717, 28863, 54956, 63827, 9983, 32574, 21803, 54292, 35896, 829, 6571, 24348, 8131, 32574, 21803, 13393, 39594, 15550, 51765, 53243, 39263, 52654, 9811, 829, 6571, 25941, 35695, 41935, 6979, 42751, 2973, 52905, 57341, 61922, 61105, 64688, 31042, 3218, 34171, 22051, 22639, 36269, 48292, 45788, 48805, 41288, 45311, 30683, 2842, 30683, 2842, 42764, 53057, 12338, 53772, 31554, 61827}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(64 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{37826, 31550, 60392, 17017, 41288, 45311, 62224, 38826, 26675, 31657, 62125, 24622, 39405, 47207, 18817, 50152, 48124, 14557, 46157, 18770, 60429, 61324, 6105, 22981, 36299, 37127, 4144, 10945, 36535, 58814, 63195, 56845, 61363, 27415, 32114, 47927, 25793, 5742, 60875, 14925, 43754, 15770, 54292, 35896, 18169, 16590, 42213, 64653, 26947, 37149, 8624, 51298, 37826, 31550, 35371, 62601, 17601, 28363, 16956, 33536, 35371, 62601, 61981, 61861}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 60, new char[]{26820, 53408, 8799, 43133, 28323, 15989, 1295, 5849, 50124, 2959, 53289, 39635, 8505, 4632, 24406, 49537, 48773, 65155, 21782, 1563, 59143, 14317, 27386, 7336, 38657, 30094, 25594, 30296, 50669, 62510, 43820, 29696, 25594, 30296, 9070, 35105, 52706, 57470, 20542, 46149, 1071, 49801, 9145, 51113, 15476, 42853, 47105, 50568, 7602, 55774, 25117, 22814, 3416, 10511, 34111, 32580, 19379, 49844, 40473, 35059}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(5 - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{27651, 63482, 31352, 20988, 37826, 31550}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 910, 18 - View.MeasureSpec.getSize(0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = {this};
                Object[] objArr14 = new Object[1];
                a(PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), (byte) (-PlaceComponentResult[32]), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                a(PlaceComponentResult[30], 30, (byte) 8, objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (KeyEvent.getMaxKeyCode() >> 16), 3 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                        Object[] objArr17 = new Object[1];
                        c((byte) (-$$a[53]), (byte) (-$$a[12]), $$a[68], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (Process.myPid() >> 22), 16 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 15, (char) View.getDefaultSize(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 29, (char) (57995 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 15 - View.getDefaultSize(0, 0), (char) View.MeasureSpec.getSize(0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {503754567, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                Object[] objArr20 = {this};
                Object[] objArr21 = new Object[1];
                a(PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), (byte) (-PlaceComponentResult[32]), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                a(PlaceComponentResult[30], 30, (byte) 8, objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 61, View.combineMeasuredStates(0, 0) + 46, (char) TextUtils.indexOf("", "", 0));
                        Object[] objArr24 = new Object[1];
                        c($$a[20], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {503754567, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 911, 18 - TextUtils.indexOf("", ""), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
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
                Object[] objArr27 = {this};
                Object[] objArr28 = new Object[1];
                a(PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), (byte) (-PlaceComponentResult[32]), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                a(PlaceComponentResult[30], 30, (byte) 8, objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - View.resolveSizeAndState(0, 0, 0), 3 - Gravity.getAbsoluteGravity(0, 0), (char) (38968 - TextUtils.getOffsetBefore("", 0)));
                        Object[] objArr31 = new Object[1];
                        c($$a[20], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getPressedStateDuration() >> 16), 35 - View.resolveSize(0, 0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {503754567, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), 18 - View.MeasureSpec.getMode(0), (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
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
                Object[] objArr34 = {this};
                Object[] objArr35 = new Object[1];
                a(PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), (byte) (-PlaceComponentResult[32]), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                a(PlaceComponentResult[30], 30, (byte) 8, objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Drawable.resolveOpacity(0, 0), Color.argb(0, 0, 0, 0) + 3, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                        Object[] objArr38 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[2]), (byte) ($$a[47] - 1), objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getTrimmedLength(""), 35 - TextUtils.indexOf("", "", 0, 0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {503754567, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), KeyEvent.getDeadChar(0, 0) + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
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
        return R.layout.activity_cancel_survey_bottom_sheet;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(super.getResources().getString(R.string.dana_will_not_save_your_bank_photo).substring(0, 15).codePointAt(10) - 83, new char[]{3321, 35252, 55813, 23358, 21839, 20438, 43537, 28536, 43430, 14339, 25712, 27413, 59695, 2910, 8624, 51298, 57561, 36749}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b(super.getResources().getString(R.string.pushverify_list_error_try_again).substring(6, 7).length() + 4, new char[]{54216, 822, 17290, 58779, 21599, 25208}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    byte b = PlaceComponentResult[25];
                    Object[] objArr4 = new Object[1];
                    a(b, (byte) (b | TarHeader.LF_BLK), PlaceComponentResult[25], objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[5], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    b(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{3321, 35252, 55813, 23358, 21839, 20438, 43537, 28536, 1071, 49801, 22398, 26827, 60054, 35376, 56173, 41876, 1958, 53812, 31614, 24827, 45021, 30980, 54067, 49248, 49931, 27725}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(super.getResources().getString(R.string.sendmoney_external_onboardingdialog_title).substring(1, 2).codePointAt(0) - 83, new char[]{21406, 33494, 29603, 18701, 19379, 49844, 55039, 63149, 24040, 32708, 60900, 62053, 40366, 39663, 56173, 41876, 39848, 54673}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), ExpandableListView.getPackedPositionChild(0L) + 36, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        byte b2 = PlaceComponentResult[25];
                        Object[] objArr7 = new Object[1];
                        a(b2, (byte) (b2 | TarHeader.LF_BLK), PlaceComponentResult[25], objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[5], objArr8);
                        Object[] objArr9 = new Object[1];
                        b(((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 15, new char[]{63195, 56845, 60875, 14925, 4290, 32558, 4144, 10945, 16147, 54867, 64474, 27844, 16779, 60707, 62539, 12552, 36422, 13323, 23329, 9347, 28863, 54956, 15867, 55129, 31554, 61827, 52654, 9811, 54102, 44925, 48124, 14557, 16956, 33536, 31298, 60185, 26947, 37149, 18169, 16590, 36299, 37127, 48629, 22726, 51398, 30574, 17524, 14145}, objArr9);
                        String str = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        b(super.getResources().getString(R.string.text_tnc_mp).substring(9, 11).codePointAt(1) - 39, new char[]{48649, 17502, 47652, 7531, 26947, 37149, 52546, 64717, 28863, 54956, 63827, 9983, 32574, 21803, 54292, 35896, 829, 6571, 24348, 8131, 32574, 21803, 13393, 39594, 15550, 51765, 53243, 39263, 52654, 9811, 829, 6571, 25941, 35695, 41935, 6979, 42751, 2973, 52905, 57341, 61922, 61105, 64688, 31042, 3218, 34171, 22051, 22639, 36269, 48292, 45788, 48805, 41288, 45311, 30683, 2842, 30683, 2842, 42764, 53057, 12338, 53772, 31554, 61827}, objArr10);
                        String str2 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        b((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 65, new char[]{37826, 31550, 60392, 17017, 41288, 45311, 62224, 38826, 26675, 31657, 62125, 24622, 39405, 47207, 18817, 50152, 48124, 14557, 46157, 18770, 60429, 61324, 6105, 22981, 36299, 37127, 4144, 10945, 36535, 58814, 63195, 56845, 61363, 27415, 32114, 47927, 25793, 5742, 60875, 14925, 43754, 15770, 54292, 35896, 18169, 16590, 42213, 64653, 26947, 37149, 8624, 51298, 37826, 31550, 35371, 62601, 17601, 28363, 16956, 33536, 35371, 62601, 61981, 61861}, objArr11);
                        String str3 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        b(super.getResources().getString(R.string.request_money_display_name_hint).substring(13, 14).codePointAt(0) - 37, new char[]{26820, 53408, 8799, 43133, 28323, 15989, 1295, 5849, 50124, 2959, 53289, 39635, 8505, 4632, 24406, 49537, 48773, 65155, 21782, 1563, 59143, 14317, 27386, 7336, 38657, 30094, 25594, 30296, 50669, 62510, 43820, 29696, 25594, 30296, 9070, 35105, 52706, 57470, 20542, 46149, 1071, 49801, 9145, 51113, 15476, 42853, 47105, 50568, 7602, 55774, 25117, 22814, 3416, 10511, 34111, 32580, 19379, 49844, 40473, 35059}, objArr12);
                        String str4 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        b(Color.alpha(0) + 6, new char[]{27651, 63482, 31352, 20988, 37826, 31550}, objArr13);
                        try {
                            Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 18 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr14);
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
            Object[] objArr15 = new Object[1];
            a(PlaceComponentResult[30], (byte) (-PlaceComponentResult[31]), (byte) (-PlaceComponentResult[32]), objArr15);
            Class<?> cls5 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            a(PlaceComponentResult[30], 30, (byte) 8, objArr16);
            try {
                Object[] objArr17 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 494, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 3, (char) Color.red(0));
                    Object[] objArr18 = new Object[1];
                    c((byte) ($$a[47] - 1), (byte) (-$$a[2]), (byte) ($$a[47] - 1), objArr18);
                    obj3 = cls6.getMethod((String) objArr18[0], Integer.TYPE);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), 35 - ExpandableListView.getPackedPositionType(0L), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr20 = {1783327724, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr20);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                a(b, (byte) (b | TarHeader.LF_BLK), PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{3321, 35252, 55813, 23358, 21839, 20438, 43537, 28536, 1071, 49801, 22398, 26827, 60054, 35376, 56173, 41876, 1958, 53812, 31614, 24827, 45021, 30980, 54067, 49248, 49931, 27725}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 18, new char[]{21406, 33494, 29603, 18701, 19379, 49844, 55039, 63149, 24040, 32708, 60900, 62053, 40366, 39663, 56173, 41876, 39848, 54673}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.argb(0, 0, 0, 0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, View.getDefaultSize(0, 0) + 18, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getCancelSurveyPresenter")
    public final CancelSurveyPresenter getCancelSurveyPresenter() {
        CancelSurveyPresenter cancelSurveyPresenter = this.cancelSurveyPresenter;
        if (cancelSurveyPresenter != null) {
            return cancelSurveyPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCancelSurveyPresenter")
    public final void setCancelSurveyPresenter(CancelSurveyPresenter cancelSurveyPresenter) {
        Intrinsics.checkNotNullParameter(cancelSurveyPresenter, "");
        this.cancelSurveyPresenter = cancelSurveyPresenter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    @JvmName(name = "MyBillsEntityDataFactory")
    private final void MyBillsEntityDataFactory(CancelReasonModel cancelReasonModel) {
        this.getAuthRequestContext = cancelReasonModel;
        if (cancelReasonModel != null) {
            ?? r1 = 1;
            r1 = 1;
            if (cancelReasonModel.getBuiltInFictitiousFunctionClassFactory() && (!cancelReasonModel.getBuiltInFictitiousFunctionClassFactory() || (!StringsKt.isBlank(cancelReasonModel.KClassImpl$Data$declaredNonStaticMembers$2)) == false)) {
                r1 = 0;
            }
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_cta);
            if (danaButtonPrimaryView != 0) {
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
                BottomSheetCancelReasonModel bottomSheetCancelReasonModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (bottomSheetCancelReasonModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bottomSheetCancelReasonModel = null;
                }
                String str = bottomSheetCancelReasonModel.PlaceComponentResult;
                danaButtonPrimaryView.setClickable(r1);
                danaButtonPrimaryView.setEnabled(r1);
                danaButtonPrimaryView.setDanaButtonView(r1, str, null, null);
            }
            if (!cancelReasonModel.getBuiltInFictitiousFunctionClassFactory()) {
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(this);
            } else {
                KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2((Activity) this);
            }
        }
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
                byte b = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                a(b, (byte) (b | TarHeader.LF_BLK), PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[41], PlaceComponentResult[25], PlaceComponentResult[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{3321, 35252, 55813, 23358, 21839, 20438, 43537, 28536, 1071, 49801, 22398, 26827, 60054, 35376, 56173, 41876, 1958, 53812, 31614, 24827, 45021, 30980, 54067, 49248, 49931, 27725}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(getPackageName().length() + 11, new char[]{21406, 33494, 29603, 18701, 19379, 49844, 55039, 63149, 24040, 32708, 60900, 62053, 40366, 39663, 56173, 41876, 39848, 54673}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 34, (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(R.anim.f5032130772052, R.anim.f5082130772059);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(final CancelReasonAdapter p0, CancelReasonModel p1) {
        CancelReasonModel cancelReasonModel = this.getAuthRequestContext;
        if (cancelReasonModel != null) {
            cancelReasonModel.getAuthRequestContext = false;
        }
        p1.getAuthRequestContext = true;
        MyBillsEntityDataFactory(p1);
        ((RecyclerView) _$_findCachedViewById(R.id.ImageDrawableAttacher)).post(new Runnable() { // from class: id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BottomSheetCancelSurveyActivity.$r8$lambda$nidl7R03EexQDXArxIC6iJBN4Mo(CancelReasonAdapter.this);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/cancelsurvey/view/BottomSheetCancelSurveyActivity$BottomSheetCancelSurveyActivityContract;", "Lid/dana/base/AbstractActivityResultContract;", "Lid/dana/cancelsurvey/model/BottomSheetCancelReasonModel;", "Lid/dana/cancelsurvey/model/BottomSheetCancelReasonResultModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class BottomSheetCancelSurveyActivityContract extends AbstractActivityResultContract<BottomSheetCancelReasonModel, BottomSheetCancelReasonResultModel> {
        @Override // id.dana.base.AbstractActivityResultContract
        public final /* synthetic */ Intent PlaceComponentResult(BaseActivity baseActivity, BottomSheetCancelReasonModel bottomSheetCancelReasonModel) {
            BottomSheetCancelReasonModel bottomSheetCancelReasonModel2 = bottomSheetCancelReasonModel;
            Intrinsics.checkNotNullParameter(baseActivity, "");
            Intrinsics.checkNotNullParameter(bottomSheetCancelReasonModel2, "");
            Intent intentClassWithTracking = baseActivity.getIntentClassWithTracking(BottomSheetCancelSurveyActivity.class);
            intentClassWithTracking.putExtra("data", bottomSheetCancelReasonModel2);
            Intrinsics.checkNotNullExpressionValue(intentClassWithTracking, "");
            return intentClassWithTracking;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ Object parseResult(int i, Intent intent) {
            int i2 = 3;
            ?? r1 = 0;
            if (i == -1) {
                BottomSheetCancelReasonResultModel bottomSheetCancelReasonResultModel = intent != null ? (BottomSheetCancelReasonResultModel) intent.getParcelableExtra("data") : null;
                return bottomSheetCancelReasonResultModel == null ? new BottomSheetCancelReasonResultModel(r1, r1, i2, r1) : bottomSheetCancelReasonResultModel;
            }
            return new BottomSheetCancelReasonResultModel(r1, r1, i2, r1);
        }
    }

    public static /* synthetic */ void $r8$lambda$nidl7R03EexQDXArxIC6iJBN4Mo(CancelReasonAdapter cancelReasonAdapter) {
        Intrinsics.checkNotNullParameter(cancelReasonAdapter, "");
        cancelReasonAdapter.notifyDataSetChanged();
    }

    public static final /* synthetic */ void access$closeBottomSheet(BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity) {
        bottomSheetCancelSurveyActivity.setResult(0);
        bottomSheetCancelSurveyActivity.finish();
    }

    public static final /* synthetic */ void access$closeBottomSheetWithSuccessMessage(BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity, String str) {
        Intent intent = new Intent();
        String string = bottomSheetCancelSurveyActivity.getString(R.string.cancel_survey_success_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        intent.putExtra("data", new BottomSheetCancelReasonResultModel(str, string));
        bottomSheetCancelSurveyActivity.setResult(-1, intent);
        bottomSheetCancelSurveyActivity.finish();
    }

    public static final /* synthetic */ void access$onClickReason(BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity, CancelReasonAdapter cancelReasonAdapter, int i) {
        CancelReasonModel item = cancelReasonAdapter.getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "");
        bottomSheetCancelSurveyActivity.MyBillsEntityDataFactory(cancelReasonAdapter, item);
    }

    public static final /* synthetic */ void access$setEnable(BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity, DanaButtonPrimaryView danaButtonPrimaryView, boolean z, String str) {
        danaButtonPrimaryView.setClickable(z);
        danaButtonPrimaryView.setEnabled(z);
        danaButtonPrimaryView.setDanaButtonView(z ? 1 : 0, str, null, null);
    }

    public static final /* synthetic */ void access$showErrorSubmitCancellationSurveyMessage(BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity) {
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity2 = bottomSheetCancelSurveyActivity;
        String string = bottomSheetCancelSurveyActivity.getString(R.string.cancel_survey_failed_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DANAToast.PlaceComponentResult(bottomSheetCancelSurveyActivity2, string);
    }

    public static final /* synthetic */ void access$showWarningToSelectAReason(BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity) {
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity2 = bottomSheetCancelSurveyActivity;
        String string = bottomSheetCancelSurveyActivity.getString(R.string.cancel_survey_warning_to_select_reason_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DANAToast.MyBillsEntityDataFactory(bottomSheetCancelSurveyActivity2, string);
    }

    public static final /* synthetic */ void access$submitCancelSurvey(BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity, final CancelReasonModel cancelReasonModel) {
        final CancelSurveyPresenter cancelSurveyPresenter = bottomSheetCancelSurveyActivity.getCancelSurveyPresenter();
        BottomSheetCancelReasonModel bottomSheetCancelReasonModel = bottomSheetCancelSurveyActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        BottomSheetCancelReasonModel bottomSheetCancelReasonModel2 = null;
        if (bottomSheetCancelReasonModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetCancelReasonModel = null;
        }
        String str = bottomSheetCancelReasonModel.getAuthRequestContext;
        BottomSheetCancelReasonModel bottomSheetCancelReasonModel3 = bottomSheetCancelSurveyActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bottomSheetCancelReasonModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bottomSheetCancelReasonModel2 = bottomSheetCancelReasonModel3;
        }
        String str2 = bottomSheetCancelReasonModel2.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cancelReasonModel, "");
        if (StringsKt.isBlank(cancelReasonModel.KClassImpl$Data$declaredNonStaticMembers$2)) {
            return;
        }
        cancelSurveyPresenter.MyBillsEntityDataFactory.showProgress();
        cancelSurveyPresenter.PlaceComponentResult.execute(SubmitCancelSurveyReason.Params.INSTANCE.createParamsFromExpressPurchase(str, str2 != null ? str2 : ""), new Function1<Boolean, Unit>() { // from class: id.dana.cancelsurvey.presenter.CancelSurveyPresenter$submitCancelSurvey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                CancelSurveyContract.View view;
                CancelSurveyContract.View view2;
                CancelSurveyContract.View view3;
                view = CancelSurveyPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                if (!z) {
                    view2 = CancelSurveyPresenter.this.MyBillsEntityDataFactory;
                    view2.PlaceComponentResult();
                    return;
                }
                CancelSurveyPresenter.BuiltInFictitiousFunctionClassFactory(CancelSurveyPresenter.this, cancelReasonModel);
                view3 = CancelSurveyPresenter.this.MyBillsEntityDataFactory;
                view3.KClassImpl$Data$declaredNonStaticMembers$2(cancelReasonModel.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cancelsurvey.presenter.CancelSurveyPresenter$submitCancelSurvey$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                CancelSurveyContract.View view;
                CancelSurveyContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CANCEL_SURVEY_PRESENTER, th.getLocalizedMessage());
                view = CancelSurveyPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = CancelSurveyPresenter.this.MyBillsEntityDataFactory;
                view2.PlaceComponentResult();
            }
        });
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        setRequestedOrientation((OSUtil.DatabaseTableConfigUtil() || OSUtil.initRecordTimeStamp()) ? -1 : 1);
        DaggerCancelSurveyComponent.Builder MyBillsEntityDataFactory = DaggerCancelSurveyComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (CancelSurveyModule) Preconditions.getAuthRequestContext(new CancelSurveyModule(new CancelSurveyContract.View() { // from class: id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity$cancelSurveyModule$1
            @Override // id.dana.cancelsurvey.presenter.CancelSurveyContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BottomSheetCancelReasonModel bottomSheetCancelReasonModel) {
                CancelSurveyContract.View.CC.MyBillsEntityDataFactory(bottomSheetCancelReasonModel);
            }

            @Override // id.dana.cancelsurvey.presenter.CancelSurveyContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                CancelSurveyContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
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
            public final void showProgress() {
                BottomSheetCancelReasonModel bottomSheetCancelReasonModel;
                DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) BottomSheetCancelSurveyActivity.this._$_findCachedViewById(R.id.btn_cta);
                if (danaButtonPrimaryView != null) {
                    BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity = BottomSheetCancelSurveyActivity.this;
                    bottomSheetCancelReasonModel = bottomSheetCancelSurveyActivity.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (bottomSheetCancelReasonModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        bottomSheetCancelReasonModel = null;
                    }
                    BottomSheetCancelSurveyActivity.access$setEnable(bottomSheetCancelSurveyActivity, danaButtonPrimaryView, false, bottomSheetCancelReasonModel.PlaceComponentResult);
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                BottomSheetCancelReasonModel bottomSheetCancelReasonModel;
                DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) BottomSheetCancelSurveyActivity.this._$_findCachedViewById(R.id.btn_cta);
                if (danaButtonPrimaryView != null) {
                    BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity = BottomSheetCancelSurveyActivity.this;
                    bottomSheetCancelReasonModel = bottomSheetCancelSurveyActivity.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (bottomSheetCancelReasonModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        bottomSheetCancelReasonModel = null;
                    }
                    BottomSheetCancelSurveyActivity.access$setEnable(bottomSheetCancelSurveyActivity, danaButtonPrimaryView, true, bottomSheetCancelReasonModel.PlaceComponentResult);
                }
            }

            @Override // id.dana.cancelsurvey.presenter.CancelSurveyContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BottomSheetCancelSurveyActivity.access$closeBottomSheetWithSuccessMessage(BottomSheetCancelSurveyActivity.this, p0);
            }

            @Override // id.dana.cancelsurvey.presenter.CancelSurveyContract.View
            public final void PlaceComponentResult() {
                BottomSheetCancelSurveyActivity.access$showErrorSubmitCancellationSurveyMessage(BottomSheetCancelSurveyActivity.this);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, CancelSurveyModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerCancelSurveyComponent.CancelSurveyComponentImpl(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getCancelSurveyPresenter());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            BottomSheetCancelReasonModel bottomSheetCancelReasonModel = (BottomSheetCancelReasonModel) extras.getParcelable("data");
            if (bottomSheetCancelReasonModel != null) {
                Intrinsics.checkNotNullExpressionValue(bottomSheetCancelReasonModel, "");
                TextView textView = (TextView) _$_findCachedViewById(R.id.tv_header);
                if (textView != null) {
                    textView.setText(bottomSheetCancelReasonModel.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                ImageButton imageButton = (ImageButton) _$_findCachedViewById(R.id.getWarmth);
                if (imageButton != null) {
                    SafeClickListenerExtensionKt.MyBillsEntityDataFactory(imageButton, new Function1<View, Unit>() { // from class: id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity$initViews$1
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
                            BottomSheetCancelSurveyActivity.access$closeBottomSheet(BottomSheetCancelSurveyActivity.this);
                        }
                    });
                }
                List<CancelReasonModel> list = bottomSheetCancelReasonModel.MyBillsEntityDataFactory;
                RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.ImageDrawableAttacher);
                if (recyclerView != null) {
                    final CancelReasonAdapter cancelReasonAdapter = new CancelReasonAdapter(list);
                    cancelReasonAdapter.setOnItemClickListener(new ThrottledOnItemClickListener(300L, new Function1<Integer, Unit>() { // from class: id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity$getOnItemClickListener$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i) {
                            BottomSheetCancelSurveyActivity.access$onClickReason(BottomSheetCancelSurveyActivity.this, cancelReasonAdapter, i);
                        }
                    }));
                    cancelReasonAdapter.MyBillsEntityDataFactory = new Function1<Boolean, Unit>() { // from class: id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity$initList$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            BottomSheetCancelReasonModel bottomSheetCancelReasonModel2;
                            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) BottomSheetCancelSurveyActivity.this._$_findCachedViewById(R.id.btn_cta);
                            if (danaButtonPrimaryView != null) {
                                BottomSheetCancelSurveyActivity bottomSheetCancelSurveyActivity = BottomSheetCancelSurveyActivity.this;
                                bottomSheetCancelReasonModel2 = bottomSheetCancelSurveyActivity.KClassImpl$Data$declaredNonStaticMembers$2;
                                if (bottomSheetCancelReasonModel2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    bottomSheetCancelReasonModel2 = null;
                                }
                                BottomSheetCancelSurveyActivity.access$setEnable(bottomSheetCancelSurveyActivity, danaButtonPrimaryView, z, bottomSheetCancelReasonModel2.PlaceComponentResult);
                            }
                        }
                    };
                    cancelReasonAdapter.PlaceComponentResult = new Function1<CancelReasonModel, Unit>() { // from class: id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity$initList$1$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(CancelReasonModel cancelReasonModel) {
                            invoke2(cancelReasonModel);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(CancelReasonModel cancelReasonModel) {
                            Intrinsics.checkNotNullParameter(cancelReasonModel, "");
                            BottomSheetCancelSurveyActivity.this.MyBillsEntityDataFactory(cancelReasonAdapter, cancelReasonModel);
                        }
                    };
                    recyclerView.setAdapter(cancelReasonAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
                    recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), ContextCompat.BuiltInFictitiousFunctionClassFactory(recyclerView.getContext(), R.color.MyBillsEntityDataFactory_res_0x7f060157), (byte) 0));
                }
                final DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_cta);
                if (danaButtonPrimaryView != null) {
                    String str = bottomSheetCancelReasonModel.PlaceComponentResult;
                    danaButtonPrimaryView.setClickable(false);
                    danaButtonPrimaryView.setEnabled(false);
                    danaButtonPrimaryView.setDanaButtonView(0, str, null, null);
                    SafeClickListenerExtensionKt.MyBillsEntityDataFactory(danaButtonPrimaryView, new Function1<View, Unit>() { // from class: id.dana.cancelsurvey.view.BottomSheetCancelSurveyActivity$initViews$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            CancelReasonModel cancelReasonModel;
                            Unit unit;
                            Intrinsics.checkNotNullParameter(view, "");
                            cancelReasonModel = BottomSheetCancelSurveyActivity.this.getAuthRequestContext;
                            if (cancelReasonModel != null) {
                                BottomSheetCancelSurveyActivity.access$submitCancelSurvey(BottomSheetCancelSurveyActivity.this, cancelReasonModel);
                                unit = Unit.INSTANCE;
                            } else {
                                unit = null;
                            }
                            if (unit == null) {
                                BottomSheetCancelSurveyActivity.access$showWarningToSelectAReason(BottomSheetCancelSurveyActivity.this);
                            }
                        }
                    });
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = bottomSheetCancelReasonModel;
            }
        } else {
            extras = null;
        }
        if (extras == null) {
            setResult(0);
            finish();
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        setResult(0);
        finish();
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (initRecordTimeStamp ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (getErrorConfigVersion ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (lookAheadTest ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
