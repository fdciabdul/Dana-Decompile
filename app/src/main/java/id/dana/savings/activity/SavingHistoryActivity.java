package id.dana.savings.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.common.DividerItemDecoration;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSavingTopUpHistoryComponent;
import id.dana.di.modules.SavingTopUpHistoryModule;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.EndlessOnScrollListener;
import id.dana.savings.adapter.HistoryAdapter;
import id.dana.savings.contract.SavingTopUpHistoryContract;
import id.dana.savings.model.SavingDetailModel;
import id.dana.savings.model.SavingModel;
import id.dana.savings.model.TopUpModel;
import id.dana.utils.SizeUtil;
import id.dana.utils.UrlUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0018\u001a\u00020\u0015X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/savings/activity/SavingHistoryActivity;", "Lid/dana/base/BaseActivity;", "", "configToolbar", "()V", "getAuthRequestContext", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "Lid/dana/savings/adapter/HistoryAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/savings/adapter/HistoryAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "scheduleImpl", "Z", "PlaceComponentResult", "Lid/dana/savings/model/SavingDetailModel;", "getErrorConfigVersion", "Lid/dana/savings/model/SavingDetailModel;", "Lid/dana/di/modules/SavingTopUpHistoryModule;", "lookAheadTest", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/savings/contract/SavingTopUpHistoryContract$Presenter;", "savingTopUpHistoryPresenter", "Lid/dana/savings/contract/SavingTopUpHistoryContract$Presenter;", "getSavingTopUpHistoryPresenter", "()Lid/dana/savings/contract/SavingTopUpHistoryContract$Presenter;", "setSavingTopUpHistoryPresenter", "(Lid/dana/savings/contract/SavingTopUpHistoryContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SavingHistoryActivity extends BaseActivity {
    public static final int DEFAUL_THRESHOLD = 10;
    public static final String EXTRA_HISTORY = "extra_history";
    private static char GetContactSyncConfig = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    public static final long TOP_UP_VIEW_SIZE = 40;
    private static char initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private HistoryAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private SavingDetailModel getAuthRequestContext;
    @Inject
    public SavingTopUpHistoryContract.Presenter savingTopUpHistoryPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult;
    public static final byte[] $$a = {39, -116, 116, Byte.MAX_VALUE, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 218;
    public static final byte[] PlaceComponentResult = {4, -20, -33, -123, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 47;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<SavingTopUpHistoryModule>() { // from class: id.dana.savings.activity.SavingHistoryActivity$savingTopUpHistoryModule$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SavingTopUpHistoryModule invoke() {
            final SavingHistoryActivity savingHistoryActivity = SavingHistoryActivity.this;
            return new SavingTopUpHistoryModule(new SavingTopUpHistoryContract.View() { // from class: id.dana.savings.activity.SavingHistoryActivity$savingTopUpHistoryModule$2.1
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

                @Override // id.dana.savings.contract.SavingTopUpHistoryContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(SavingDetailModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SavingHistoryActivity.access$setSavingDetailModel(SavingHistoryActivity.this, p0);
                }

                @Override // id.dana.savings.contract.SavingTopUpHistoryContract.View
                public final void PlaceComponentResult(List<TopUpModel> p0) {
                    HistoryAdapter historyAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    historyAdapter = SavingHistoryActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (historyAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        historyAdapter = null;
                    }
                    SavingHistoryActivity savingHistoryActivity2 = SavingHistoryActivity.this;
                    savingHistoryActivity2.PlaceComponentResult = false;
                    historyAdapter.removeItem(SavingHistoryActivity.access$getLastItemPosition(savingHistoryActivity2));
                    historyAdapter.appendItems(p0);
                }

                @Override // id.dana.savings.contract.SavingTopUpHistoryContract.View
                public final void getAuthRequestContext() {
                    HistoryAdapter historyAdapter;
                    historyAdapter = SavingHistoryActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (historyAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        historyAdapter = null;
                    }
                    SavingHistoryActivity savingHistoryActivity2 = SavingHistoryActivity.this;
                    savingHistoryActivity2.PlaceComponentResult = false;
                    historyAdapter.removeItem(SavingHistoryActivity.access$getLastItemPosition(savingHistoryActivity2));
                    historyAdapter.appendItem(new TopUpModel(null, null, null, null, null, null, 2, 63, null));
                }
            });
        }
    });

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        initRecordTimeStamp = (char) 19160;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = (char) 6476;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = (char) 26992;
        GetContactSyncConfig = (char) 60615;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.savings.activity.SavingHistoryActivity.PlaceComponentResult
            int r7 = 23 - r7
            int r8 = r8 + 97
            int r6 = 55 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L34
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
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
        L34:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingHistoryActivity.a(short, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.savings.activity.SavingHistoryActivity.$$a
            int r6 = r6 * 2
            int r6 = 103 - r6
            int r7 = 46 - r7
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
            goto L36
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
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r6 = r6 + r7
            int r6 = r6 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingHistoryActivity.c(int, short, short, java.lang.Object[]):void");
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
        b((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, new char[]{27319, 23232, 16431, 55745, 32034, 22731, 22761, 16346, 16196, 9792, 57809, 56774, 47567, 62172, 6589, 7320, 39193, 7425}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(5 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{12691, 24628, 24306, 12077, 35163, 52380}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSize(0, 0) + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 48, new char[]{45359, 7596, 24571, 49678, 35596, 52723, 26711, 53445, 43887, 4220, 56483, 20894, 14840, 47831, 48039, 40802, 15126, 8198, 17608, 27116, 19855, 9155, 40838, 25697, 4686, 53308, 53010, 30521, 17496, 65164, 30770, 24712, 938, 54524, 18638, 'Q', 50233, 41041, 53932, 2946, 17775, 50970, 54408, 923, 40798, 22622, 41013, 5593}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(65 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new char[]{64091, 62271, 62044, 62477, 50233, 41041, 25387, 43460, 19855, 9155, 57271, 27492, 37497, 62872, 2652, 5009, 21084, 37958, 39880, 38388, 37497, 62872, 51897, 46526, 54058, 36295, 15758, 20665, 53010, 30521, 21084, 37958, 51005, 12621, 29313, 56517, 3351, 16964, 43337, 229, 8691, 53394, 28774, 47613, 51331, 17147, 7820, 61450, 26088, 60009, 29719, 11621, 46648, 18191, 10197, 6945, 10197, 6945, 9098, 26787, 38960, 8640, 4686, 53308}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(64 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{13437, 25588, 62480, 10583, 46648, 18191, 17215, 62454, 63638, 63647, 44540, 47345, 12671, 30773, 3386, 39503, 30770, 24712, 39060, 21796, 40830, 4805, 52452, 55896, 17775, 50970, 26711, 53445, 42365, 11253, 45359, 7596, 45677, 38725, 51604, 46323, 43795, 16553, 24571, 49678, 49825, 42640, 2652, 5009, 53932, 2946, 19014, 29717, 50233, 41041, 6589, 7320, 13437, 25588, 37987, 38236, 4276, 710, 938, 54524, 37987, 38236, 32848, 18421}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(TextUtils.indexOf((CharSequence) "", '0', 0) + 61, new char[]{31015, 1438, 57278, 44122, 7798, 59663, 33995, 33372, 52558, 14212, 14210, 14875, 16466, 42016, 25402, 39352, 62924, 25733, 49939, 11944, 47803, 56346, 10721, 39721, 27650, 35712, 58929, 29384, 12613, 31672, 28511, 42064, 58929, 29384, 35356, 36738, 63315, 55737, 17361, 62742, 60901, 6024, 47828, 56577, 60622, 2023, 43295, 19252, 65534, 62165, 63881, 17527, 42177, 7998, 31820, 58780, 64080, 39117, 52649, 37355}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(View.MeasureSpec.makeMeasureSpec(0, 0) + 6, new char[]{64602, 52169, 12957, 38145, 13437, 25588}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (-PlaceComponentResult[31]), PlaceComponentResult[30], (byte) (-PlaceComponentResult[32]), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b = PlaceComponentResult[30];
                Object[] objArr15 = new Object[1];
                a((short) 30, b, (byte) (b + 1), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 55, KeyEvent.keyCodeFromString("") + 3, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1));
                        Object[] objArr17 = new Object[1];
                        c($$a[12], $$a[53], $$a[31], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ((Process.getThreadPriority(0) + 20) >> 6), 15 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.resolveSize(0, 0), MotionEvent.axisFromString("") + 16, (char) View.MeasureSpec.getSize(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 29, (char) (57994 - (ViewConfiguration.getLongPressTimeout() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 15, (char) (TextUtils.lastIndexOf("", '0') + 1)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-259018104, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-PlaceComponentResult[31]), PlaceComponentResult[30], (byte) (-PlaceComponentResult[32]), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b2 = PlaceComponentResult[30];
                Object[] objArr22 = new Object[1];
                a((short) 30, b2, (byte) (b2 + 1), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 46 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getTapTimeout() >> 16));
                        Object[] objArr24 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], $$a[8], objArr24);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-259018104, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 911, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-PlaceComponentResult[31]), PlaceComponentResult[30], (byte) (-PlaceComponentResult[32]), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b3 = PlaceComponentResult[30];
                Object[] objArr29 = new Object[1];
                a((short) 30, b3, (byte) (b3 + 1), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 117, (ViewConfiguration.getEdgeSlop() >> 16) + 3, (char) (38968 - TextUtils.getOffsetAfter("", 0)));
                        Object[] objArr31 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], $$a[8], objArr31);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.blue(0), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-259018104, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-PlaceComponentResult[31]), PlaceComponentResult[30], (byte) (-PlaceComponentResult[32]), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b4 = PlaceComponentResult[30];
                Object[] objArr36 = new Object[1];
                a((short) 30, b4, (byte) (b4 + 1), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 108, 3 - ExpandableListView.getPackedPositionType(0L), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        byte b5 = $$a[9];
                        byte b6 = (byte) ($$a[78] - 1);
                        Object[] objArr38 = new Object[1];
                        c(b5, b6, b6, objArr38);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.combineMeasuredStates(0, 0), 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-259018104, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_saving_history;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(super.getResources().getString(R.string.dana_viz_prompt_monitored_by_description).substring(0, 5).length() + 13, new char[]{27319, 23232, 16431, 55745, 32034, 22731, 22761, 16346, 16196, 9792, 57809, 56774, 47567, 62172, 6589, 7320, 39193, 7425}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b(5 - TextUtils.getCapsMode("", 0, 0), new char[]{12691, 24628, 24306, 12077, 35163, 52380}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                b(super.getResources().getString(R.string.mp_maximum_favorite_items).substring(26, 28).length() + 24, new char[]{27319, 23232, 16431, 55745, 32034, 22731, 22761, 16346, 60901, 6024, 53516, 51806, 53513, 44167, 50366, 11041, 51185, 49243, 55118, 49536, 53921, 45455, 62297, 5023, 44741, 937}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                b(getPackageName().codePointAt(5) - 92, new char[]{56886, 10144, 17119, 6177, 64080, 39117, 7107, 37791, 44890, 15816, 10603, 56933, 38334, 65085, 50366, 11041, 56710, 52165}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), AndroidCharacter.getMirror('0') - '\r', (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    b((ViewConfiguration.getWindowTouchSlop() >> 8) + 48, new char[]{45359, 7596, 24571, 49678, 35596, 52723, 26711, 53445, 43887, 4220, 56483, 20894, 14840, 47831, 48039, 40802, 15126, 8198, 17608, 27116, 19855, 9155, 40838, 25697, 4686, 53308, 53010, 30521, 17496, 65164, 30770, 24712, 938, 54524, 18638, 'Q', 50233, 41041, 53932, 2946, 17775, 50970, 54408, 923, 40798, 22622, 41013, 5593}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    b(super.getResources().getString(R.string.error_merchant_list_title).substring(2, 7).length() + 59, new char[]{64091, 62271, 62044, 62477, 50233, 41041, 25387, 43460, 19855, 9155, 57271, 27492, 37497, 62872, 2652, 5009, 21084, 37958, 39880, 38388, 37497, 62872, 51897, 46526, 54058, 36295, 15758, 20665, 53010, 30521, 21084, 37958, 51005, 12621, 29313, 56517, 3351, 16964, 43337, 229, 8691, 53394, 28774, 47613, 51331, 17147, 7820, 61450, 26088, 60009, 29719, 11621, 46648, 18191, 10197, 6945, 10197, 6945, 9098, 26787, 38960, 8640, 4686, 53308}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 64, new char[]{13437, 25588, 62480, 10583, 46648, 18191, 17215, 62454, 63638, 63647, 44540, 47345, 12671, 30773, 3386, 39503, 30770, 24712, 39060, 21796, 40830, 4805, 52452, 55896, 17775, 50970, 26711, 53445, 42365, 11253, 45359, 7596, 45677, 38725, 51604, 46323, 43795, 16553, 24571, 49678, 49825, 42640, 2652, 5009, 53932, 2946, 19014, 29717, 50233, 41041, 6589, 7320, 13437, 25588, 37987, 38236, 4276, 710, 938, 54524, 37987, 38236, 32848, 18421}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 59, new char[]{31015, 1438, 57278, 44122, 7798, 59663, 33995, 33372, 52558, 14212, 14210, 14875, 16466, 42016, 25402, 39352, 62924, 25733, 49939, 11944, 47803, 56346, 10721, 39721, 27650, 35712, 58929, 29384, 12613, 31672, 28511, 42064, 58929, 29384, 35356, 36738, 63315, 55737, 17361, 62742, 60901, 6024, 47828, 56577, 60622, 2023, 43295, 19252, 65534, 62165, 63881, 17527, 42177, 7998, 31820, 58780, 64080, 39117, 52649, 37355}, objArr9);
                    String str4 = (String) objArr9[0];
                    try {
                        byte b = (byte) (getAuthRequestContext + 5);
                        byte b2 = PlaceComponentResult[25];
                        Object[] objArr10 = new Object[1];
                        a(b, b2, b2, objArr10);
                        Class<?> cls3 = Class.forName((String) objArr10[0]);
                        a(PlaceComponentResult[25], PlaceComponentResult[41], PlaceComponentResult[5], new Object[1]);
                        Object[] objArr11 = new Object[1];
                        b(((ApplicationInfo) cls3.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 27, new char[]{64602, 52169, 12957, 38145, 13437, 25588}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            Object[] objArr13 = new Object[1];
            a((byte) (-PlaceComponentResult[31]), PlaceComponentResult[30], (byte) (-PlaceComponentResult[32]), objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            byte b3 = PlaceComponentResult[30];
            Object[] objArr14 = new Object[1];
            a((short) 30, b3, (byte) (b3 + 1), objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getLongPressTimeout() >> 16), 4 - (Process.myPid() >> 22), (char) Color.argb(0, 0, 0, 0));
                    byte b4 = $$a[9];
                    byte b5 = (byte) ($$a[78] - 1);
                    Object[] objArr16 = new Object[1];
                    c(b4, b5, b5, objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, Color.argb(0, 0, 0, 0) + 35, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr18 = {2019289609, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = (byte) (getAuthRequestContext + 5);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[25], PlaceComponentResult[41], PlaceComponentResult[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{27319, 23232, 16431, 55745, 32034, 22731, 22761, 16346, 60901, 6024, 53516, 51806, 53513, 44167, 50366, 11041, 51185, 49243, 55118, 49536, 53921, 45455, 62297, 5023, 44741, 937}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, new char[]{56886, 10144, 17119, 6177, 64080, 39117, 7107, 37791, 44890, 15816, 10603, 56933, 38334, 65085, 50366, 11041, 56710, 52165}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), 35 - Gravity.getAbsoluteGravity(0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myTid() >> 22), 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = (byte) (getAuthRequestContext + 5);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[25], PlaceComponentResult[41], PlaceComponentResult[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{27319, 23232, 16431, 55745, 32034, 22731, 22761, 16346, 60901, 6024, 53516, 51806, 53513, 44167, 50366, 11041, 51185, 49243, 55118, 49536, 53921, 45455, 62297, 5023, 44741, 937}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(super.getResources().getString(R.string.res_0x7f130739_kclassimpl_data_declarednonstaticmembers_2).substring(0, 9).codePointAt(5) - 79, new char[]{56886, 10144, 17119, 6177, 64080, 39117, 7107, 37791, 44890, 15816, 10603, 56933, 38334, 65085, 50366, 11041, 56710, 52165}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.combineMeasuredStates(0, 0), ExpandableListView.getPackedPositionChild(0L) + 36, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getSavingTopUpHistoryPresenter")
    public final SavingTopUpHistoryContract.Presenter getSavingTopUpHistoryPresenter() {
        SavingTopUpHistoryContract.Presenter presenter = this.savingTopUpHistoryPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSavingTopUpHistoryPresenter")
    public final void setSavingTopUpHistoryPresenter(SavingTopUpHistoryContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.savingTopUpHistoryPresenter = presenter;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setTitle(getString(R.string.history));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        SavingModel savingModel;
        SavingDetailModel savingDetailModel = this.getAuthRequestContext;
        if (savingDetailModel != null) {
            HistoryAdapter historyAdapter = null;
            if (!(savingDetailModel.getMyBillsEntityDataFactory() && !this.PlaceComponentResult)) {
                savingDetailModel = null;
            }
            if (savingDetailModel == null || (savingModel = savingDetailModel.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            this.PlaceComponentResult = true;
            HistoryAdapter historyAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (historyAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                historyAdapter = historyAdapter2;
            }
            historyAdapter.appendItem(new TopUpModel(null, null, null, null, null, null, 1, 63, null));
            SavingTopUpHistoryContract.Presenter savingTopUpHistoryPresenter = getSavingTopUpHistoryPresenter();
            String str = savingModel.GetContactSyncConfig;
            getSavingTopUpHistoryPresenter().getPlaceComponentResult();
            savingTopUpHistoryPresenter.MyBillsEntityDataFactory(str);
        }
    }

    public static /* synthetic */ void $r8$lambda$kjGxoMKv137dIRQyW9TtEOGRF7A(SavingHistoryActivity savingHistoryActivity, int i) {
        Intrinsics.checkNotNullParameter(savingHistoryActivity, "");
        HistoryAdapter historyAdapter = savingHistoryActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (historyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            historyAdapter = null;
        }
        TopUpModel item = historyAdapter.getItem(i);
        int i2 = item.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (i2 != 0) {
            if (i2 == 2) {
                savingHistoryActivity.getAuthRequestContext();
                return;
            }
            return;
        }
        String str = item.KClassImpl$Data$declaredNonStaticMembers$2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(DanaUrl.TRANSACTION_DETAIL, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        String authRequestContext = UrlUtil.getAuthRequestContext(format);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext);
    }

    public static final /* synthetic */ int access$getLastItemPosition(SavingHistoryActivity savingHistoryActivity) {
        HistoryAdapter historyAdapter = savingHistoryActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (historyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            historyAdapter = null;
        }
        return historyAdapter.getItemCount() - 1;
    }

    public static final /* synthetic */ void access$setSavingDetailModel(SavingHistoryActivity savingHistoryActivity, SavingDetailModel savingDetailModel) {
        List<TopUpModel> list;
        savingHistoryActivity.getAuthRequestContext = savingDetailModel;
        if (savingDetailModel == null || (list = savingDetailModel.getAuthRequestContext) == null) {
            return;
        }
        HistoryAdapter historyAdapter = savingHistoryActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (historyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            historyAdapter = null;
        }
        historyAdapter.setItems(list);
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        SavingDetailModel savingDetailModel;
        DaggerSavingTopUpHistoryComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerSavingTopUpHistoryComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (SavingTopUpHistoryModule) Preconditions.getAuthRequestContext((SavingTopUpHistoryModule) this.MyBillsEntityDataFactory.getValue());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, SavingTopUpHistoryModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
        new DaggerSavingTopUpHistoryComponent.SavingTopUpHistoryComponentImpl(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, (byte) 0).PlaceComponentResult(this);
        registerPresenter(getSavingTopUpHistoryPresenter());
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1158_paymentsettingpresenter_getautorouteinitialstate_2);
        if (recyclerView != null) {
            HistoryAdapter historyAdapter = new HistoryAdapter();
            recyclerView.addOnScrollListener(new EndlessOnScrollListener() { // from class: id.dana.savings.activity.SavingHistoryActivity$initRecyclerView$1$1$1
                @Override // id.dana.richview.EndlessOnScrollListener
                public final int MyBillsEntityDataFactory() {
                    return 10;
                }

                @Override // id.dana.richview.EndlessOnScrollListener
                public final void getAuthRequestContext() {
                    SavingHistoryActivity.this.getAuthRequestContext();
                }
            });
            this.KClassImpl$Data$declaredNonStaticMembers$2 = historyAdapter;
            historyAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.savings.activity.SavingHistoryActivity$$ExternalSyntheticLambda0
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i) {
                    SavingHistoryActivity.$r8$lambda$kjGxoMKv137dIRQyW9TtEOGRF7A(SavingHistoryActivity.this, i);
                }
            });
            recyclerView.setAdapter(historyAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), ContextCompat.BuiltInFictitiousFunctionClassFactory(recyclerView.getContext(), R.color.MyBillsEntityDataFactory_res_0x7f060157), SizeUtil.getAuthRequestContext(16), (byte) 0));
        }
        Intent intent = getIntent();
        if (intent == null || (savingDetailModel = (SavingDetailModel) intent.getParcelableExtra(EXTRA_HISTORY)) == null) {
            return;
        }
        List<TopUpModel> list = savingDetailModel.getAuthRequestContext;
        HistoryAdapter historyAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (historyAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            historyAdapter2 = null;
        }
        historyAdapter2.setItems(list);
        getSavingTopUpHistoryPresenter().PlaceComponentResult(savingDetailModel.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig);
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
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (GetContactSyncConfig ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (initRecordTimeStamp ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
