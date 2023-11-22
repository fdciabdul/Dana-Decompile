package id.dana.savings.activity;

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
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.EmptyStateRecyclerView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.common.DividerItemDecoration;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.core.ui.glide.ImageAttacherFactory;
import id.dana.core.ui.model.UiTextModel;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.saving.repository.source.network.exception.GoalsApiException;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSavingDetailComponent;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.SavingDetailModule;
import id.dana.di.modules.SavingTopUpModule;
import id.dana.domain.saving.interactor.TopUpSaving;
import id.dana.extension.view.ViewExtKt;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.EndlessOnScrollListener;
import id.dana.savings.activity.SavingUpdateActivity;
import id.dana.savings.adapter.HistoryAdapter;
import id.dana.savings.contract.SavingDetailContract;
import id.dana.savings.contract.SavingTopUpContract;
import id.dana.savings.ext.SavingModelExtKt;
import id.dana.savings.model.SavingCategoryModel;
import id.dana.savings.model.SavingDetailModel;
import id.dana.savings.model.SavingModel;
import id.dana.savings.model.SavingTopUpInitModel;
import id.dana.savings.model.TopUpModel;
import id.dana.savings.parser.SavingErrorParser;
import id.dana.savings.presenter.SavingDetailPresenter;
import id.dana.savings.presenter.SavingTopUpPresenter;
import id.dana.savings.view.RemoveSavingGoalDialogFragment;
import id.dana.savings.view.TopUpSavingDialogFragment;
import id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog;
import id.dana.sendmoney.external.TwoActionWithIconBottomSheetFragment;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.BalanceUtil;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.ImageOss;
import id.dana.utils.OSUtil;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.SizeUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
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
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.A;
import o.C;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\bL\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0011J)\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001d\u0010\nJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\nJ\u0013\u0010\f\u001a\u00020\u0006*\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010!R\"\u0010#\u001a\u00020\"8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010\u0018\u001a\u00020)8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u000b\u001a\u00020,8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0017\u00103\u001a\u0006*\u00020101X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b \u00102R\u0016\u0010\f\u001a\u0002048\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010/\u001a\u0004\u0018\u0001078\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bI\u0010J"}, d2 = {"Lid/dana/savings/activity/SavingDetailActivity;", "Lid/dana/base/BaseActivity;", "", "p0", "Lid/dana/savings/model/SavingModel;", "p1", "", "PlaceComponentResult", "(ZLid/dana/savings/model/SavingModel;)V", "configToolbar", "()V", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "(Z)V", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "onResume", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/savings/model/SavingModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Lid/dana/savings/model/SavingModel;)V", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "checkoutH5EventPresenter", "Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "getCheckoutH5EventPresenter", "()Lid/dana/h5event/CheckoutH5EventContract$Presenter;", "setCheckoutH5EventPresenter", "(Lid/dana/h5event/CheckoutH5EventContract$Presenter;)V", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "lookAheadTest", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "Lid/dana/savings/adapter/HistoryAdapter;", "scheduleImpl", "Lid/dana/savings/adapter/HistoryAdapter;", "getErrorConfigVersion", "Z", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/savings/model/SavingCategoryModel;", "GetContactSyncConfig", "Lid/dana/savings/model/SavingCategoryModel;", "Lid/dana/savings/model/SavingDetailModel;", "initRecordTimeStamp", "Lid/dana/savings/model/SavingDetailModel;", "Lid/dana/savings/presenter/SavingDetailPresenter;", "savingDetailPresenter", "Lid/dana/savings/presenter/SavingDetailPresenter;", "getSavingDetailPresenter", "()Lid/dana/savings/presenter/SavingDetailPresenter;", "setSavingDetailPresenter", "(Lid/dana/savings/presenter/SavingDetailPresenter;)V", "Lid/dana/savings/presenter/SavingTopUpPresenter;", "savingTopUpPresenter", "Lid/dana/savings/presenter/SavingTopUpPresenter;", "getSavingTopUpPresenter", "()Lid/dana/savings/presenter/SavingTopUpPresenter;", "setSavingTopUpPresenter", "(Lid/dana/savings/presenter/SavingTopUpPresenter;)V", "Lid/dana/savings/view/TopUpSavingDialogFragment;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/savings/view/TopUpSavingDialogFragment;", "moveToNextValue", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingDetailActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final int DEFAUL_THRESHOLD = 10;
    private static int DatabaseTableConfigUtil = 0;
    public static final String EXTRA_REVOKED_SAVING = "extra_revoked_saving";
    public static final int MIN_HISTORY_TOP_UP_ITEMS = 0;
    public static final int REQUEST_CODE_EDIT_SAVING = 1000;
    public static final long TOP_UP_VIEW_SIZE = 20;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private SavingCategoryModel getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private TopUpSavingDialogFragment moveToNextValue;
    @Inject
    public CheckoutH5EventContract.Presenter checkoutH5EventPresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private SavingDetailModel getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private CustomSnackbar KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public SavingDetailPresenter savingDetailPresenter;
    @Inject
    public SavingTopUpPresenter savingTopUpPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private HistoryAdapter BuiltInFictitiousFunctionClassFactory;
    public static final byte[] $$a = {TarHeader.LF_DIR, 18, -76, 65, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 37;
    public static final byte[] getAuthRequestContext = {Ascii.EM, 108, 7, 61, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 113;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.savings.activity.SavingDetailActivity$pageSkeleton$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewSkeletonScreen invoke() {
            return ShimmeringUtil.PlaceComponentResult((ConstraintLayout) SavingDetailActivity.this._$_findCachedViewById(R.id.res_0x7f0a041b_fontscontractcompat_fontrequestcallback), R.layout.activity_skeleton_saving_details);
        }
    });

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        DatabaseTableConfigUtil = 269894829;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 106 - r6
            int r7 = r7 + 4
            int r8 = 23 - r8
            byte[] r0 = id.dana.savings.activity.SavingDetailActivity.getAuthRequestContext
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2d
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L2d:
            int r8 = r8 + r6
            int r7 = r7 + 1
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingDetailActivity.a(short, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.savings.activity.SavingDetailActivity.$$a
            int r9 = r9 * 2
            int r9 = 103 - r9
            int r7 = r7 + 4
            int r8 = r8 * 3
            int r8 = 42 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r9
            r4 = 0
            r9 = r8
            goto L2c
        L15:
            r3 = 0
        L16:
            int r7 = r7 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r6
        L2c:
            int r8 = r8 + r3
            int r8 = r8 + (-7)
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingDetailActivity.c(int, int, short, java.lang.Object[]):void");
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
        Method method;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(false, (ViewConfiguration.getJumpTapTimeout() >> 16) + 235, KeyEvent.normalizeMetaState(0) + 12, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, new char[]{1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0, 2, 16, 16, 65534, 11, 1, 15, '\f', 6}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(false, TextUtils.lastIndexOf("", '0', 0) + 241, 1 - ExpandableListView.getPackedPositionChild(0L), 5 - (ViewConfiguration.getTapTimeout() >> 16), new char[]{1, 65532, 5, 17, 65517}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 35 - Color.green(0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(false, 207 - ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 5, 48 - (ViewConfiguration.getEdgeSlop() >> 16), new char[]{65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(true, 202 - (ViewConfiguration.getLongPressTimeout() >> 16), ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.FS, 64 - Color.blue(0), new char[]{65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#'}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(false, Drawable.resolveOpacity(0, 0) + 204, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 47, TextUtils.lastIndexOf("", '0', 0, 0) + 65, new char[]{65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!'}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(true, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 232, 44 - TextUtils.indexOf("", ""), 61 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b'}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(true, Color.alpha(0) + 186, 4 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 6 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{65532, 2, 65532, 7, 65535, 0}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, View.MeasureSpec.getMode(0) + 18, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                a(b, (byte) (b | 37), getAuthRequestContext[2], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(getAuthRequestContext[7], getAuthRequestContext[35], getAuthRequestContext[2], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 3, (char) ExpandableListView.getPackedPositionGroup(0L));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], $$a[31], $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778016, 15 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 800, (-16777201) - Color.rgb(0, 0, 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 815, TextUtils.getCapsMode("", 0, 0) + 29, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 800, TextUtils.indexOf("", "", 0) + 15, (char) (ViewConfiguration.getPressedStateDuration() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-601272913, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, View.combineMeasuredStates(0, 0) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = getAuthRequestContext[25];
                Object[] objArr19 = new Object[1];
                a(b2, (byte) (b2 | 37), getAuthRequestContext[2], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(getAuthRequestContext[7], getAuthRequestContext[35], getAuthRequestContext[2], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 61, 47 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (Process.myPid() >> 22));
                        Object[] objArr22 = new Object[1];
                        c($$a[28], $$a[8], (byte) ($$a[78] - 1), objArr22);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getEdgeSlop() >> 16), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 36, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-601272913, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = getAuthRequestContext[25];
                Object[] objArr25 = new Object[1];
                a(b3, (byte) (b3 | 37), getAuthRequestContext[2], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(getAuthRequestContext[7], getAuthRequestContext[35], getAuthRequestContext[2], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 118, TextUtils.getOffsetBefore("", 0) + 3, (char) (ExpandableListView.getPackedPositionChild(0L) + 38969));
                        Object[] objArr28 = new Object[1];
                        c($$a[28], $$a[8], (byte) ($$a[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-601272913, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), View.resolveSize(0, 0) + 18, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = getAuthRequestContext[25];
                Object[] objArr31 = new Object[1];
                a(b4, (byte) (b4 | 37), getAuthRequestContext[2], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(getAuthRequestContext[7], getAuthRequestContext[35], getAuthRequestContext[2], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 108, ((byte) KeyEvent.getModifierMetaStateMask()) + 4, (char) (ViewConfiguration.getScrollBarSize() >> 8));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[40]), (byte) ($$a[78] - 1), $$a[9], objArr34);
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
                                method = obj16;
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                method = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, method);
                            }
                            Object invoke6 = ((Method) method).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-601272913, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), 17 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_saving_details;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int resolveSize = 235 - View.resolveSize(0, 0);
        try {
            byte b = getAuthRequestContext[32];
            byte b2 = getAuthRequestContext[25];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            a(getAuthRequestContext[13], (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], new Object[1]);
            Object[] objArr2 = new Object[1];
            b(false, resolveSize, ((ApplicationInfo) cls.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 21, AndroidCharacter.getMirror('0') - 30, new char[]{1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0, 2, 16, 16, 65534, 11, 1, 15, '\f', 6}, objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            try {
                byte b3 = getAuthRequestContext[32];
                byte b4 = getAuthRequestContext[25];
                Object[] objArr3 = new Object[1];
                a(b3, b4, b4, objArr3);
                Class<?> cls3 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a(getAuthRequestContext[13], (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr4);
                Object[] objArr5 = new Object[1];
                b(false, ((ApplicationInfo) cls3.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 207, super.getResources().getString(R.string.cashier_acquirer_name_merchant_info_prepend).substring(0, 3).codePointAt(1) - 8224, getPackageName().codePointAt(3) - 95, new char[]{1, 65532, 5, 17, 65517}, objArr5);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr6 = new Object[1];
                        b(true, super.getResources().getString(R.string.mix_pay_promo_not_available_dialog_title).substring(15, 16).codePointAt(0) + 203, getPackageName().length() + 2, super.getResources().getString(R.string.group_send_type_contact).substring(4, 5).codePointAt(0) - 6, new char[]{65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r'}, objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        try {
                            byte b5 = getAuthRequestContext[32];
                            byte b6 = getAuthRequestContext[25];
                            Object[] objArr7 = new Object[1];
                            a(b5, b6, b6, objArr7);
                            Class<?> cls5 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            a(getAuthRequestContext[13], (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr8);
                            Object[] objArr9 = new Object[1];
                            b(false, ((ApplicationInfo) cls5.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 209, super.getResources().getString(R.string.monthly_auto_top_up_title).substring(2, 3).length() + 10, 18 - (ViewConfiguration.getScrollBarSize() >> 8), new char[]{65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n'}, objArr9);
                            baseContext = (Context) cls4.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr10 = new Object[1];
                            b(false, getPackageName().codePointAt(4) + 110, super.getResources().getString(R.string.fab_back_to_Top).substring(7, 8).length() + 5, getPackageName().codePointAt(6) - 49, new char[]{65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31}, objArr10);
                            String str = (String) objArr10[0];
                            int codePointAt = getPackageName().codePointAt(3) + 102;
                            int length = super.getResources().getString(R.string.too_many_request_otp_message_dialog).substring(3, 4).length() + 26;
                            try {
                                byte b7 = getAuthRequestContext[32];
                                byte b8 = getAuthRequestContext[25];
                                Object[] objArr11 = new Object[1];
                                a(b7, b8, b8, objArr11);
                                Class<?> cls6 = Class.forName((String) objArr11[0]);
                                Object[] objArr12 = new Object[1];
                                a(getAuthRequestContext[13], (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr12);
                                Object[] objArr13 = new Object[1];
                                b(true, codePointAt, length, ((ApplicationInfo) cls6.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#'}, objArr13);
                                String str2 = (String) objArr13[0];
                                int codePointAt2 = super.getResources().getString(R.string.near_merchant).substring(1, 2).codePointAt(0) + 103;
                                int length2 = super.getResources().getString(R.string.nps_survey_slider_label_sliding_to_right).substring(14, 15).length() + 45;
                                try {
                                    byte b9 = getAuthRequestContext[32];
                                    byte b10 = getAuthRequestContext[25];
                                    Object[] objArr14 = new Object[1];
                                    a(b9, b10, b10, objArr14);
                                    Class<?> cls7 = Class.forName((String) objArr14[0]);
                                    Object[] objArr15 = new Object[1];
                                    a(getAuthRequestContext[13], (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr15);
                                    Object[] objArr16 = new Object[1];
                                    b(false, codePointAt2, length2, ((ApplicationInfo) cls7.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!'}, objArr16);
                                    String str3 = (String) objArr16[0];
                                    Object[] objArr17 = new Object[1];
                                    b(true, super.getResources().getString(R.string.my_review_section_title).substring(6, 7).length() + 232, super.getResources().getString(R.string.home_shopping_tutorial_pay_step_2).substring(0, 1).codePointAt(0) - 40, super.getResources().getString(R.string.merchant_detail_error_state_message).substring(2, 3).length() + 59, new char[]{65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b'}, objArr17);
                                    String str4 = (String) objArr17[0];
                                    Object[] objArr18 = new Object[1];
                                    b(true, 186 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 4 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 6 - ((Process.getThreadPriority(0) + 20) >> 6), new char[]{65532, 2, 65532, 7, 65535, 0}, objArr18);
                                    try {
                                        Object[] objArr19 = {baseContext, str, str2, str3, str4, true, (String) objArr18[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr19);
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
                    byte b11 = getAuthRequestContext[25];
                    Object[] objArr20 = new Object[1];
                    a(b11, (byte) (b11 | 37), getAuthRequestContext[2], objArr20);
                    Class<?> cls8 = Class.forName((String) objArr20[0]);
                    Object[] objArr21 = new Object[1];
                    a(getAuthRequestContext[7], getAuthRequestContext[35], getAuthRequestContext[2], objArr21);
                    try {
                        Object[] objArr22 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 4 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)));
                            Object[] objArr23 = new Object[1];
                            c((byte) (-$$a[40]), (byte) ($$a[78] - 1), $$a[9], objArr23);
                            obj3 = cls9.getMethod((String) objArr23[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr24 = (Object[]) ((Method) obj3).invoke(null, objArr22);
                        int i = ((int[]) objArr24[1])[0];
                        if (((int[]) objArr24[0])[0] != i) {
                            long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 == null) {
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(null, null);
                                try {
                                    Object[] objArr25 = {-1248421868, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr25);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(true, getPackageName().length() + 228, View.MeasureSpec.makeMeasureSpec(0, 0) + 9, 26 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r'}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = getAuthRequestContext[32];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(getAuthRequestContext[13], (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr3);
                Object[] objArr4 = new Object[1];
                b(false, ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 209, 10 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), getPackageName().codePointAt(2) - 28, new char[]{65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n'}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, 35 - View.combineMeasuredStates(0, 0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), ExpandableListView.getPackedPositionGroup(0L) + 18, (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @JvmName(name = "getSavingDetailPresenter")
    public final SavingDetailPresenter getSavingDetailPresenter() {
        SavingDetailPresenter savingDetailPresenter = this.savingDetailPresenter;
        if (savingDetailPresenter != null) {
            return savingDetailPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSavingDetailPresenter")
    public final void setSavingDetailPresenter(SavingDetailPresenter savingDetailPresenter) {
        Intrinsics.checkNotNullParameter(savingDetailPresenter, "");
        this.savingDetailPresenter = savingDetailPresenter;
    }

    @JvmName(name = "getSavingTopUpPresenter")
    public final SavingTopUpPresenter getSavingTopUpPresenter() {
        SavingTopUpPresenter savingTopUpPresenter = this.savingTopUpPresenter;
        if (savingTopUpPresenter != null) {
            return savingTopUpPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSavingTopUpPresenter")
    public final void setSavingTopUpPresenter(SavingTopUpPresenter savingTopUpPresenter) {
        Intrinsics.checkNotNullParameter(savingTopUpPresenter, "");
        this.savingTopUpPresenter = savingTopUpPresenter;
    }

    @JvmName(name = "getCheckoutH5EventPresenter")
    public final CheckoutH5EventContract.Presenter getCheckoutH5EventPresenter() {
        CheckoutH5EventContract.Presenter presenter = this.checkoutH5EventPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCheckoutH5EventPresenter")
    public final void setCheckoutH5EventPresenter(CheckoutH5EventContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.checkoutH5EventPresenter = presenter;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setTitle(getString(R.string.detail_title_saving));
        setMenuLeftButton(R.drawable.btn_arrow_left);
        setMenuRightButton(getString(R.string.edit_savings_btn));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        SavingModel savingModel;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode != 1001) {
                if (resultCode == 1002) {
                    getAuthRequestContext();
                    return;
                }
                return;
            }
            SavingDetailModel savingDetailModel = this.getErrorConfigVersion;
            if (savingDetailModel == null || (savingModel = savingDetailModel.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            getSavingDetailPresenter().PlaceComponentResult(savingModel.GetContactSyncConfig);
            String string = getResources().getString(R.string.toast_edit_saving_goal_success);
            Intrinsics.checkNotNullExpressionValue(string, "");
            CustomToastUtil.PlaceComponentResult(this, R.drawable.ic_success, R.drawable.bg_rounded_toast_success, string, 48, 60, true, null, 256);
        }
    }

    public final void onError(String errorMessage) {
        TopUpSavingDialogFragment topUpSavingDialogFragment = this.moveToNextValue;
        if (topUpSavingDialogFragment != null) {
            topUpSavingDialogFragment.dismiss();
        }
        View findViewById = getWindow().getDecorView().findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder((ViewGroup) findViewById);
        builder.initRecordTimeStamp = errorMessage;
        builder.lookAheadTest = getString(R.string.pop_up_positive_button_saving_limit_info);
        builder.moveToNextValue = 0;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_orange;
        builder.MyBillsEntityDataFactory = R.drawable.bg_rectangle_tangerine;
        builder.scheduleImpl = new View.OnClickListener() { // from class: id.dana.savings.activity.SavingDetailActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SavingDetailActivity.m2880$r8$lambda$27gRWNNtdQE4qBI_qtCq6Mxxpo(SavingDetailActivity.this, view);
            }
        };
        CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.show();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        SavingModel savingModel;
        String str;
        SavingModel savingModel2;
        MoneyViewModel moneyViewModel;
        Context baseContext = getBaseContext();
        String str2 = null;
        if (baseContext == null) {
            int tapTimeout = 235 - (ViewConfiguration.getTapTimeout() >> 16);
            try {
                byte b = getAuthRequestContext[32];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[13], (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(true, tapTimeout, ((ApplicationInfo) cls.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 24, super.getResources().getString(R.string.tab_transaction).substring(0, 6).codePointAt(4) - 89, new char[]{65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r'}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                try {
                    byte b3 = getAuthRequestContext[32];
                    byte b4 = getAuthRequestContext[25];
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    a(getAuthRequestContext[13], (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr4);
                    Object[] objArr5 = new Object[1];
                    b(false, ((ApplicationInfo) cls3.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 209, TextUtils.indexOf("", "", 0, 0) + 11, 17 - Process.getGidForName(""), new char[]{65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n'}, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), 35 - Color.red(0), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, 18 - Drawable.resolveOpacity(0, 0), (char) View.getDefaultSize(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr6);
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
        SavingDetailModel savingDetailModel = this.getErrorConfigVersion;
        if (savingDetailModel != null && (savingModel2 = savingDetailModel.BuiltInFictitiousFunctionClassFactory) != null && (moneyViewModel = savingModel2.lookAheadTest) != null) {
            str2 = moneyViewModel.PlaceComponentResult;
        }
        BuiltInFictitiousFunctionClassFactory(Intrinsics.areEqual(str2, "0"));
        SavingDetailModel savingDetailModel2 = this.getErrorConfigVersion;
        if (savingDetailModel2 == null || (savingModel = savingDetailModel2.BuiltInFictitiousFunctionClassFactory) == null || (str = savingModel.GetContactSyncConfig) == null) {
            return;
        }
        getSavingDetailPresenter().PlaceComponentResult(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_REVOKED_SAVING, this.getErrorConfigVersion);
        setResult(1002, intent);
        finish();
    }

    private final void getAuthRequestContext(SavingModel savingModel) {
        PlaceComponentResult(SavingModelExtKt.lookAheadTest(savingModel), savingModel);
        String str = savingModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        TextView textView = (TextView) _$_findCachedViewById(R.id.setDrawValueAboveBar);
        if (textView != null) {
            textView.setText(str);
        }
        SavingCategoryModel savingCategoryModel = this.getAuthRequestContext;
        if (savingCategoryModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            savingCategoryModel = null;
        }
        String BuiltInFictitiousFunctionClassFactory = savingCategoryModel.BuiltInFictitiousFunctionClassFactory(SavingModelExtKt.KClassImpl$Data$declaredNonStaticMembers$2(savingModel));
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_category);
        if (imageView != null) {
            ImageOss.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, imageView, new ImageOss.EventListener() { // from class: id.dana.savings.activity.SavingDetailActivity$$ExternalSyntheticLambda0
                @Override // id.dana.utils.ImageOss.EventListener
                public final void PlaceComponentResult(String str2, ImageView imageView2) {
                    SavingDetailActivity.$r8$lambda$iQwMgBRDl3INAx9FMOMz1umSTRA(SavingDetailActivity.this, str2, imageView2);
                }
            });
        }
        MoneyViewModel moneyViewModel = savingModel.lookAheadTest;
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.drainLoop);
        if (textView2 != null) {
            textView2.setText(BalanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(moneyViewModel.PlaceComponentResult));
        }
        int authRequestContext = (int) SavingModelExtKt.getAuthRequestContext(savingModel);
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.progress_bar);
        if (progressBar != null) {
            progressBar.setProgress(authRequestContext);
        }
        getAuthRequestContext(savingModel.DatabaseTableConfigUtil, savingModel);
        BuiltInFictitiousFunctionClassFactory(Intrinsics.areEqual(savingModel.lookAheadTest.PlaceComponentResult, "0"));
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        if (p0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tv_history);
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_history);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        SavingModel savingModel;
        WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog = new WithdrawalSavingBottomSheetDialog();
        SavingDetailModel savingDetailModel = this.getErrorConfigVersion;
        if (savingDetailModel == null || (savingModel = savingDetailModel.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(savingModel, "");
        withdrawalSavingBottomSheetDialog.PlaceComponentResult = savingModel;
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.id.res_0x7f0a02bf_securitysettingsactivity_createpinlauncher_2_1);
        Boolean valueOf = checkBox != null ? Boolean.valueOf(checkBox.isChecked()) : null;
        withdrawalSavingBottomSheetDialog.BuiltInFictitiousFunctionClassFactory = valueOf != null ? valueOf.booleanValue() : false;
        WithdrawalSavingBottomSheetDialog.WithdrawListener withdrawListener = new WithdrawalSavingBottomSheetDialog.WithdrawListener() { // from class: id.dana.savings.activity.SavingDetailActivity$showWithdrawalSavingBottomDialog$1$1
            @Override // id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog.WithdrawListener
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaH5.startContainerFullUrl(p0, new DanaH5Listener() { // from class: id.dana.savings.activity.SavingDetailActivity$openH5WithdrawContainer$$inlined$withDanaH5Callback$1
                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerCreated(Bundle p02) {
                        SavingDetailActivity.this.getCheckoutH5EventPresenter().MyBillsEntityDataFactory();
                    }

                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerDestroyed(Bundle p02) {
                        SavingDetailActivity.this.getCheckoutH5EventPresenter().BuiltInFictitiousFunctionClassFactory();
                    }
                });
            }
        };
        Intrinsics.checkNotNullParameter(withdrawListener, "");
        withdrawalSavingBottomSheetDialog.getAuthRequestContext = withdrawListener;
        withdrawalSavingBottomSheetDialog.show(getSupportFragmentManager(), "WithdrawalDestinationFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        SavingModel savingModel;
        SavingDetailModel savingDetailModel = this.getErrorConfigVersion;
        if (savingDetailModel == null || (savingModel = savingDetailModel.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        SavingUpdateActivity.Companion companion = SavingUpdateActivity.INSTANCE;
        SavingUpdateActivity.Companion.MyBillsEntityDataFactory(this, 1000, savingModel, getIntent().getStringExtra(SavingsActivity.MAX_SAVING_COUNT), getIntent().getStringExtra(SavingsActivity.MAX_SAVING_AMOUNT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        SavingModel savingModel;
        SavingDetailModel savingDetailModel = this.getErrorConfigVersion;
        if (savingDetailModel != null) {
            HistoryAdapter historyAdapter = null;
            if (!(savingDetailModel.getMyBillsEntityDataFactory() && !this.PlaceComponentResult)) {
                savingDetailModel = null;
            }
            if (savingDetailModel == null || (savingModel = savingDetailModel.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            this.PlaceComponentResult = true;
            HistoryAdapter historyAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
            if (historyAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                historyAdapter = historyAdapter2;
            }
            historyAdapter.appendItem(new TopUpModel(null, null, null, null, null, null, 1, 63, null));
            SavingDetailPresenter savingDetailPresenter = getSavingDetailPresenter();
            String str = savingModel.GetContactSyncConfig;
            int i = getSavingDetailPresenter().PlaceComponentResult;
            savingDetailPresenter.KClassImpl$Data$declaredNonStaticMembers$2(str);
        }
    }

    private final void getAuthRequestContext(MoneyViewModel p0, SavingModel p1) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_target);
        if (textView != null) {
            String string = getString(R.string.saving_progress_text);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.roundToInt(SavingModelExtKt.PlaceComponentResult(p1))), BalanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0.PlaceComponentResult)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(format);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\nJ9\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/savings/activity/SavingDetailActivity$Companion;", "", "Lid/dana/base/BaseActivity;", "p0", "", "p1", "", "p2", "", "PlaceComponentResult", "(Lid/dana/base/BaseActivity;Ljava/lang/String;Ljava/util/Map;)V", "", "Lid/dana/savings/model/SavingModel;", "p3", "p4", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/base/BaseActivity;Lid/dana/savings/model/SavingModel;Ljava/lang/String;Ljava/lang/String;)V", "DEFAUL_THRESHOLD", "I", "EXTRA_REVOKED_SAVING", "Ljava/lang/String;", "MIN_HISTORY_TOP_UP_ITEMS", "REQUEST_CODE_EDIT_SAVING", "", "TOP_UP_VIEW_SIZE", "J", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void BuiltInFictitiousFunctionClassFactory(BaseActivity baseActivity, SavingModel savingModel, String str, String str2) {
            Intrinsics.checkNotNullParameter(baseActivity, "");
            Intrinsics.checkNotNullParameter(savingModel, "");
            Intent intentClassWithTracking = baseActivity.getIntentClassWithTracking(SavingDetailActivity.class);
            intentClassWithTracking.putExtra(SavingCreateActivity.EXTRA_SAVING, savingModel);
            intentClassWithTracking.putExtra(SavingsActivity.MAX_SAVING_COUNT, str);
            intentClassWithTracking.putExtra(SavingsActivity.MAX_SAVING_AMOUNT, str2);
            baseActivity.startActivityForResult(intentClassWithTracking, 2003);
        }

        public static void PlaceComponentResult(BaseActivity p0, String p1, Map<String, String> p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent putExtra = p0.getIntentClassWithTracking(SavingDetailActivity.class).putExtra("goals_id", p1);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            String str = p2.get("action");
            if (str != null) {
                if (!(str.length() > 0)) {
                    str = null;
                }
                if (str != null) {
                    putExtra.putExtra("action", str);
                }
            }
            p0.startActivity(putExtra);
        }
    }

    /* renamed from: $r8$lambda$27gRWNNtdQE4qBI_qt-Cq6Mxxpo  reason: not valid java name */
    public static /* synthetic */ void m2880$r8$lambda$27gRWNNtdQE4qBI_qtCq6Mxxpo(SavingDetailActivity savingDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(savingDetailActivity, "");
        CustomSnackbar customSnackbar = savingDetailActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customSnackbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            customSnackbar = null;
        }
        customSnackbar.dismiss();
    }

    public static /* synthetic */ void $r8$lambda$Hk_Uam3wTdfkQDNdAhQJ_D_QH9o(SavingDetailActivity savingDetailActivity, int i) {
        Intrinsics.checkNotNullParameter(savingDetailActivity, "");
        HistoryAdapter historyAdapter = savingDetailActivity.BuiltInFictitiousFunctionClassFactory;
        if (historyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            historyAdapter = null;
        }
        TopUpModel item = historyAdapter.getItem(i);
        int i2 = item.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (i2 != 0) {
            if (i2 == 2) {
                savingDetailActivity.BuiltInFictitiousFunctionClassFactory();
                return;
            }
            return;
        }
        String str = item.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(DanaUrl.TRANSACTION_DETAIL, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        sb.append(format);
        DanaH5.startContainerFullUrl(sb.toString());
    }

    public static /* synthetic */ void $r8$lambda$LP8cNzOs3TGtMtegwfbeD09XLes(SavingDetailActivity savingDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(savingDetailActivity, "");
        savingDetailActivity.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void $r8$lambda$P6UC76ST2Kqlx5AT6rIRhASbbLw(SavingDetailActivity savingDetailActivity, View view) {
        SavingModel savingModel;
        String str;
        Intrinsics.checkNotNullParameter(savingDetailActivity, "");
        SavingDetailModel savingDetailModel = savingDetailActivity.getErrorConfigVersion;
        if (savingDetailModel == null || (savingModel = savingDetailModel.BuiltInFictitiousFunctionClassFactory) == null || (str = savingModel.GetContactSyncConfig) == null) {
            return;
        }
        savingDetailActivity.getSavingTopUpPresenter().BuiltInFictitiousFunctionClassFactory(str);
    }

    public static /* synthetic */ void $r8$lambda$hbvOMgeLjC66TRQqLCP4Cj78sWM(SavingDetailActivity savingDetailActivity, boolean z) {
        Intrinsics.checkNotNullParameter(savingDetailActivity, "");
        if (z) {
            savingDetailActivity.finish();
        }
    }

    public static /* synthetic */ void $r8$lambda$iQwMgBRDl3INAx9FMOMz1umSTRA(SavingDetailActivity savingDetailActivity, String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(savingDetailActivity, "");
        new ImageAttacherFactory().KClassImpl$Data$declaredNonStaticMembers$2(savingDetailActivity.getBaseContext(), imageView, str, 0);
    }

    public static /* synthetic */ void $r8$lambda$mC9gzHyuqZvfTM4qxr3HiHaasoE(final SavingDetailActivity savingDetailActivity, View view) {
        SavingDetailModel savingDetailModel;
        SavingModel savingModel;
        final MoneyViewModel moneyViewModel;
        Intrinsics.checkNotNullParameter(savingDetailActivity, "");
        if (!savingDetailActivity.isActivityAvailable() || (savingDetailModel = savingDetailActivity.getErrorConfigVersion) == null || (savingModel = savingDetailModel.BuiltInFictitiousFunctionClassFactory) == null || (moneyViewModel = savingModel.lookAheadTest) == null) {
            return;
        }
        TwoActionWithIconBottomSheetFragment twoActionWithIconBottomSheetFragment = new TwoActionWithIconBottomSheetFragment(new Function0<Unit>() { // from class: id.dana.savings.activity.SavingDetailActivity$showWithdrawConfirmationBottomSheet$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SavingDetailActivity.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>() { // from class: id.dana.savings.activity.SavingDetailActivity$showWithdrawConfirmationBottomSheet$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (MoneyViewModel.this.BuiltInFictitiousFunctionClassFactory() > 0) {
                    savingDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
                } else {
                    new RemoveSavingGoalDialogFragment(new SavingDetailActivity$showRemoveSavingDialog$1(r0)).show(savingDetailActivity.getSupportFragmentManager(), "RemoveSavingGoalDialogFragment");
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        Context baseContext = savingDetailActivity.getBaseContext();
        if (baseContext != null) {
            Intrinsics.checkNotNullExpressionValue(baseContext, "");
            twoActionWithIconBottomSheetFragment.MyBillsEntityDataFactory = R.drawable.ic_withdraw_confirmation;
            AppCompatImageView appCompatImageView = (AppCompatImageView) twoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.GetLeaderboardEntryBanner);
            if (appCompatImageView != null) {
                TwoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView, twoActionWithIconBottomSheetFragment.MyBillsEntityDataFactory);
            }
            String string = baseContext.getString(R.string.saving_withdraw_confirmation_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            twoActionWithIconBottomSheetFragment.MyBillsEntityDataFactory(string);
            String string2 = baseContext.getString(R.string.saving_withdraw_confirmation_desc);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            twoActionWithIconBottomSheetFragment.PlaceComponentResult(string2);
            String string3 = baseContext.getString(R.string.saving_withdraw_confirmation_positive_btn);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            twoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(string3);
            String string4 = baseContext.getString(R.string.saving_withdraw_confirmation_negative_btn);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            twoActionWithIconBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(string4);
        }
        FragmentManager supportFragmentManager = savingDetailActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        twoActionWithIconBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(supportFragmentManager);
    }

    /* renamed from: $r8$lambda$w1-5O3zucxPTFhBJ6i6JuV3ASf4  reason: not valid java name */
    public static /* synthetic */ void m2881$r8$lambda$w15O3zucxPTFhBJ6i6JuV3ASf4(SavingDetailActivity savingDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(savingDetailActivity, "");
        savingDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public static final /* synthetic */ int access$getLastItemPosition(SavingDetailActivity savingDetailActivity) {
        HistoryAdapter historyAdapter = savingDetailActivity.BuiltInFictitiousFunctionClassFactory;
        if (historyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            historyAdapter = null;
        }
        return historyAdapter.getPlaceComponentResult() - 1;
    }

    public static final /* synthetic */ ViewSkeletonScreen access$getPageSkeleton(SavingDetailActivity savingDetailActivity) {
        return (ViewSkeletonScreen) savingDetailActivity.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ void access$onClickTopUp(final SavingDetailActivity savingDetailActivity, SavingTopUpInitModel savingTopUpInitModel) {
        if (savingTopUpInitModel != null) {
            TopUpSavingDialogFragment topUpSavingDialogFragment = new TopUpSavingDialogFragment();
            savingDetailActivity.moveToNextValue = topUpSavingDialogFragment;
            topUpSavingDialogFragment.getAuthRequestContext = savingTopUpInitModel;
            TopUpSavingDialogFragment topUpSavingDialogFragment2 = savingDetailActivity.moveToNextValue;
            if (topUpSavingDialogFragment2 != null) {
                TopUpSavingDialogFragment.TopUpListener topUpListener = new TopUpSavingDialogFragment.TopUpListener() { // from class: id.dana.savings.activity.SavingDetailActivity$onClickTopUp$1$1
                    @Override // id.dana.savings.view.TopUpSavingDialogFragment.TopUpListener
                    public final void PlaceComponentResult(String p0) {
                        SavingDetailModel savingDetailModel;
                        SavingModel savingModel;
                        Intrinsics.checkNotNullParameter(p0, "");
                        SavingDetailActivity savingDetailActivity2 = SavingDetailActivity.this;
                        savingDetailModel = savingDetailActivity2.getErrorConfigVersion;
                        String str = (savingDetailModel == null || (savingModel = savingDetailModel.BuiltInFictitiousFunctionClassFactory) == null) ? null : savingModel.GetContactSyncConfig;
                        SavingDetailActivity.access$requestTopUp(savingDetailActivity2, str != null ? str : "", p0);
                    }
                };
                Intrinsics.checkNotNullParameter(topUpListener, "");
                topUpSavingDialogFragment2.BuiltInFictitiousFunctionClassFactory = topUpListener;
            }
            TopUpSavingDialogFragment topUpSavingDialogFragment3 = savingDetailActivity.moveToNextValue;
            if (topUpSavingDialogFragment3 != null) {
                topUpSavingDialogFragment3.show(savingDetailActivity.getSupportFragmentManager(), "TopUpDialogFragment");
            }
        }
    }

    public static final /* synthetic */ void access$requestTopUp(SavingDetailActivity savingDetailActivity, String str, String str2) {
        final SavingTopUpPresenter savingTopUpPresenter = savingDetailActivity.getSavingTopUpPresenter();
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        savingTopUpPresenter.MyBillsEntityDataFactory.showProgress();
        savingTopUpPresenter.KClassImpl$Data$declaredNonStaticMembers$2.execute(new TopUpSaving.Param(str, str2), new Function1<String, Unit>() { // from class: id.dana.savings.presenter.SavingTopUpPresenter$topUpSaving$1
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
                SavingTopUpContract.View view;
                SavingTopUpContract.View view2;
                Intrinsics.checkNotNullParameter(str3, "");
                view = SavingTopUpPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = SavingTopUpPresenter.this.MyBillsEntityDataFactory;
                view2.PlaceComponentResult(str3);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingTopUpPresenter$topUpSaving$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $MyBillsEntityDataFactory = 0;
            private static int $scheduleImpl = 1;
            private static char BuiltInFictitiousFunctionClassFactory = 7722;
            private static char KClassImpl$Data$declaredNonStaticMembers$2 = 56777;
            private static char PlaceComponentResult = 23933;
            private static char getAuthRequestContext = 4212;

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Throwable th) {
                Unit unit;
                int i = $MyBillsEntityDataFactory + 15;
                $scheduleImpl = i % 128;
                Object[] objArr = null;
                if (i % 2 == 0) {
                    invoke2(th);
                    unit = Unit.INSTANCE;
                    int length = objArr.length;
                } else {
                    invoke2(th);
                    unit = Unit.INSTANCE;
                }
                int i2 = $MyBillsEntityDataFactory + 23;
                $scheduleImpl = i2 % 128;
                if (!(i2 % 2 != 0)) {
                    objArr.hashCode();
                    return unit;
                }
                return unit;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingTopUpContract.View view;
                int i = $MyBillsEntityDataFactory + 9;
                $scheduleImpl = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingTopUpPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                SavingTopUpPresenter.PlaceComponentResult(SavingTopUpPresenter.this, th);
                Object[] objArr = new Object[1];
                a(5 - ExpandableListView.getPackedPositionChild(0L), new char[]{19104, 53874, 7012, 63897, 61502, 18998}, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to top up", th);
                int i3 = $scheduleImpl + 39;
                $MyBillsEntityDataFactory = i3 % 128;
                if ((i3 % 2 != 0 ? '!' : 'H') != 'H') {
                    Object[] objArr2 = null;
                    int length = objArr2.length;
                }
            }

            private static void a(int i, char[] cArr, Object[] objArr) {
                int i2;
                C c = new C();
                char[] cArr2 = new char[cArr.length];
                c.BuiltInFictitiousFunctionClassFactory = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? 'U' : '*') != '*') {
                        int i3 = $10 + 79;
                        $11 = i3 % 128;
                        int i4 = 58224;
                        if ((i3 % 2 == 0 ? (char) 11 : Typography.less) != '<') {
                            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory / 1];
                            i2 = 1;
                        } else {
                            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                            i2 = 0;
                        }
                        while (true) {
                            if ((i2 < 16 ? (char) 20 : '@') != 20) {
                                break;
                            }
                            cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                            cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                            i4 -= 40503;
                            i2++;
                        }
                        cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                        cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                        c.BuiltInFictitiousFunctionClassFactory += 2;
                    } else {
                        String str3 = new String(cArr2, 0, i);
                        int i5 = $11 + 103;
                        $10 = i5 % 128;
                        int i6 = i5 % 2;
                        objArr[0] = str3;
                        return;
                    }
                }
            }
        });
    }

    public static final /* synthetic */ void access$revokeSaving(SavingDetailActivity savingDetailActivity) {
        SavingModel savingModel;
        String str;
        SavingDetailModel savingDetailModel = savingDetailActivity.getErrorConfigVersion;
        if (savingDetailModel == null || (savingModel = savingDetailModel.BuiltInFictitiousFunctionClassFactory) == null || (str = savingModel.GetContactSyncConfig) == null) {
            return;
        }
        final SavingDetailPresenter savingDetailPresenter = savingDetailActivity.getSavingDetailPresenter();
        Intrinsics.checkNotNullParameter(str, "");
        savingDetailPresenter.MyBillsEntityDataFactory.showProgress();
        savingDetailPresenter.KClassImpl$Data$declaredNonStaticMembers$2.execute(str, new Function1<Boolean, Unit>() { // from class: id.dana.savings.presenter.SavingDetailPresenter$revokeSaving$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                SavingDetailContract.View view;
                SavingDetailContract.View view2;
                view = SavingDetailPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = SavingDetailPresenter.this.MyBillsEntityDataFactory;
                view2.BuiltInFictitiousFunctionClassFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingDetailPresenter$revokeSaving$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $BuiltInFictitiousFunctionClassFactory = 1;
            private static int $KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            private static long PlaceComponentResult = -8841701734749306218L;

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 125;
                $BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                try {
                    invoke2(th);
                    Unit unit = Unit.INSTANCE;
                    int i3 = $BuiltInFictitiousFunctionClassFactory + 5;
                    $KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    if (i3 % 2 == 0) {
                        return unit;
                    }
                    int i4 = 54 / 0;
                    return unit;
                } catch (Exception e) {
                    throw e;
                }
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingDetailContract.View view;
                SavingDetailContract.View view2;
                Context context;
                int i = $BuiltInFictitiousFunctionClassFactory + 93;
                $KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingDetailPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = SavingDetailPresenter.this.MyBillsEntityDataFactory;
                SavingErrorParser savingErrorParser = SavingErrorParser.INSTANCE;
                context = SavingDetailPresenter.this.getAuthRequestContext;
                view2.onError(SavingErrorParser.PlaceComponentResult(context, th.getLocalizedMessage()));
                Object[] objArr = new Object[1];
                a(Color.alpha(0), new char[]{46052, 46007, 58060, 61864, 38919, 36466, 8386, 44499, 28450, 30228}, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to revoke saving", th);
                int i3 = $BuiltInFictitiousFunctionClassFactory + 13;
                $KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            }

            private static void a(int i, char[] cArr, Object[] objArr) {
                D d = new D();
                char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult ^ 3919452569568103912L, cArr, i);
                d.MyBillsEntityDataFactory = 4;
                while (true) {
                    try {
                        if (!(d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length)) {
                            break;
                        }
                        try {
                            int i2 = $10 + 105;
                            $11 = i2 % 128;
                            int i3 = i2 % 2;
                            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (PlaceComponentResult ^ 3919452569568103912L)));
                            d.MyBillsEntityDataFactory++;
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                String str2 = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                int i4 = $10 + 31;
                $11 = i4 % 128;
                if (!(i4 % 2 == 0)) {
                    objArr[0] = str2;
                    return;
                }
                Object obj = null;
                obj.hashCode();
                objArr[0] = str2;
            }
        });
    }

    public static final /* synthetic */ void access$setSavingDetailModel(SavingDetailActivity savingDetailActivity, SavingDetailModel savingDetailModel) {
        List<TopUpModel> list;
        SavingModel savingModel;
        SavingModel savingModel2;
        SavingCategoryModel savingCategoryModel;
        savingDetailActivity.getErrorConfigVersion = savingDetailModel;
        if (savingDetailModel != null && (savingModel2 = savingDetailModel.BuiltInFictitiousFunctionClassFactory) != null && (savingCategoryModel = savingModel2.BuiltInFictitiousFunctionClassFactory) != null) {
            savingDetailActivity.getAuthRequestContext = savingCategoryModel;
        }
        SavingDetailModel savingDetailModel2 = savingDetailActivity.getErrorConfigVersion;
        if (savingDetailModel2 != null && (savingModel = savingDetailModel2.BuiltInFictitiousFunctionClassFactory) != null) {
            savingDetailActivity.getAuthRequestContext(savingModel);
        }
        SavingDetailModel savingDetailModel3 = savingDetailActivity.getErrorConfigVersion;
        if (savingDetailModel3 == null || (list = savingDetailModel3.getAuthRequestContext) == null) {
            return;
        }
        HistoryAdapter historyAdapter = savingDetailActivity.BuiltInFictitiousFunctionClassFactory;
        if (historyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            historyAdapter = null;
        }
        historyAdapter.setItems(list);
    }

    public static final /* synthetic */ void access$trackingGoalCancelled(SavingDetailActivity savingDetailActivity) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(savingDetailActivity.getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.GOAL_SAVINGS_CANCELLED;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
    }

    private final void PlaceComponentResult(boolean p0, SavingModel p1) {
        if (p0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.setDrawValueAboveBar);
            if (textView != null) {
                textView.setTextAlignment(p0 ? 4 : 2);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_title_goal_achieved);
            if (textView2 != null) {
                textView2.setText(getString(R.string.goal_achieved_detail_title, p1.DatabaseTableConfigUtil.getAuthRequestContext()));
            }
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_subtitle_goal_achieved);
            if (textView3 != null) {
                String str = p1.getAuthRequestContext;
                String str2 = p1.KClassImpl$Data$declaredNonStaticMembers$2;
                getSavingDetailPresenter();
                textView3.setText(getString(R.string.goal_achieved_detail, Long.valueOf(SavingDetailPresenter.MyBillsEntityDataFactory(String.valueOf(str), String.valueOf(str2)))));
            }
            setMenuRightButtonEnabled(false);
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.ll_amount_progress);
        if (linearLayout != null) {
            Intrinsics.checkNotNullExpressionValue(linearLayout, "");
            linearLayout.setVisibility(p0 ^ true ? 0 : 8);
        }
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.progress_bar);
        if (progressBar != null) {
            Intrinsics.checkNotNullExpressionValue(progressBar, "");
            progressBar.setVisibility(p0 ^ true ? 0 : 8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0489_barcodeutil_externalsyntheticlambda0);
        if (constraintLayout != null) {
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(p0 ^ true ? 0 : 8);
        }
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.res_0x7f0a10a5_r8_lambda_aq1r93eeij0w7hyskezcrtizdnm);
        if (relativeLayout != null) {
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
            relativeLayout.setVisibility(p0 ? 0 : 8);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_achieved_bottom_segment);
        if (constraintLayout2 != null) {
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
            constraintLayout2.setVisibility(p0 ? 0 : 8);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        SavingModel savingModel;
        String stringExtra;
        DaggerSavingDetailComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerSavingDetailComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (SavingDetailModule) Preconditions.getAuthRequestContext(new SavingDetailModule(new SavingDetailContract.View() { // from class: id.dana.savings.activity.SavingDetailActivity$getSavingDetailModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                SavingDetailActivity.access$getPageSkeleton(SavingDetailActivity.this).PlaceComponentResult();
            }

            @Override // id.dana.savings.contract.SavingDetailContract.View
            public final void getAuthRequestContext(SavingDetailModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SavingDetailActivity.access$setSavingDetailModel(SavingDetailActivity.this, p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                SavingDetailActivity.this.onError(p0);
            }

            @Override // id.dana.savings.contract.SavingDetailContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                SavingDetailActivity.access$trackingGoalCancelled(SavingDetailActivity.this);
                SavingDetailActivity.this.getAuthRequestContext();
            }

            @Override // id.dana.savings.contract.SavingDetailContract.View
            public final void PlaceComponentResult(List<TopUpModel> p0) {
                HistoryAdapter historyAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                historyAdapter = SavingDetailActivity.this.BuiltInFictitiousFunctionClassFactory;
                if (historyAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    historyAdapter = null;
                }
                SavingDetailActivity savingDetailActivity = SavingDetailActivity.this;
                savingDetailActivity.PlaceComponentResult = false;
                historyAdapter.removeItem(SavingDetailActivity.access$getLastItemPosition(savingDetailActivity));
                historyAdapter.appendItems(p0);
            }

            @Override // id.dana.savings.contract.SavingDetailContract.View
            public final void PlaceComponentResult() {
                HistoryAdapter historyAdapter;
                historyAdapter = SavingDetailActivity.this.BuiltInFictitiousFunctionClassFactory;
                if (historyAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    historyAdapter = null;
                }
                SavingDetailActivity savingDetailActivity = SavingDetailActivity.this;
                savingDetailActivity.PlaceComponentResult = false;
                historyAdapter.removeItem(SavingDetailActivity.access$getLastItemPosition(savingDetailActivity));
                historyAdapter.appendItem(new TopUpModel(null, null, null, null, null, null, 2, 63, null));
            }

            @Override // id.dana.savings.contract.SavingDetailContract.View
            public final void getAuthRequestContext(Throwable p0, String p1, UiTextModel p2, String p3) {
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                Intrinsics.checkNotNullParameter(p3, "");
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(SavingDetailActivity.this);
                builder.MyBillsEntityDataFactory = "Displayed Error";
                EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", p3).MyBillsEntityDataFactory("Displayed Message", p2.asString(SavingDetailActivity.this)).MyBillsEntityDataFactory("Operation Type", p1);
                String message = p0 != null ? p0.getMessage() : null;
                EventTrackerModel.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", message != null ? message : "");
                if (p0 instanceof GoalsApiException) {
                    GoalsApiException goalsApiException = (GoalsApiException) p0;
                    if (goalsApiException.hasTraceIdAndErrorCode()) {
                        MyBillsEntityDataFactory2.MyBillsEntityDataFactory("Error Code", goalsApiException.getApiErrorCode());
                        MyBillsEntityDataFactory2.MyBillsEntityDataFactory("Trace ID", goalsApiException.getApiTraceId());
                    }
                }
                MyBillsEntityDataFactory2.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
            }

            @Override // id.dana.savings.contract.SavingDetailContract.View
            public final void getAuthRequestContext(UiTextModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SavingDetailActivity savingDetailActivity = SavingDetailActivity.this;
                savingDetailActivity.onError(p0.asString(savingDetailActivity));
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (SavingTopUpModule) Preconditions.getAuthRequestContext(new SavingTopUpModule(new SavingTopUpContract.View() { // from class: id.dana.savings.activity.SavingDetailActivity$getSavingTopUpModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.savings.contract.SavingTopUpContract.View
            public final void BuiltInFictitiousFunctionClassFactory(SavingTopUpInitModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SavingDetailActivity.access$onClickTopUp(SavingDetailActivity.this, p0);
            }

            @Override // id.dana.savings.contract.SavingTopUpContract.View
            public final void PlaceComponentResult(String p0) {
                TopUpSavingDialogFragment topUpSavingDialogFragment;
                Intrinsics.checkNotNullParameter(p0, "");
                SavingDetailActivity savingDetailActivity = SavingDetailActivity.this;
                DanaH5.startContainerFullUrl(p0);
                topUpSavingDialogFragment = SavingDetailActivity.this.moveToNextValue;
                if (topUpSavingDialogFragment != null) {
                    topUpSavingDialogFragment.dismiss();
                }
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(SavingDetailActivity.this.getApplicationContext());
                builder.MyBillsEntityDataFactory = TrackerKey.Event.GOAL_SAVINGS_TOPUP_CREATION;
                builder.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
            }

            @Override // id.dana.savings.contract.SavingTopUpContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                TopUpSavingDialogFragment topUpSavingDialogFragment;
                TopUpSavingDialogFragment topUpSavingDialogFragment2;
                Intrinsics.checkNotNullParameter(p0, "");
                topUpSavingDialogFragment = SavingDetailActivity.this.moveToNextValue;
                TextView textView = topUpSavingDialogFragment != null ? (TextView) topUpSavingDialogFragment.PlaceComponentResult(R.id.tv_warning_note) : null;
                if (textView != null) {
                    textView.setText(p0);
                }
                topUpSavingDialogFragment2 = SavingDetailActivity.this.moveToNextValue;
                if (topUpSavingDialogFragment2 != null) {
                    topUpSavingDialogFragment2.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                SavingDetailActivity.this.onError(p0);
            }

            @Override // id.dana.savings.contract.SavingTopUpContract.View
            public final void getAuthRequestContext(Throwable p0, String p1, UiTextModel p2, String p3) {
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                Intrinsics.checkNotNullParameter(p3, "");
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(SavingDetailActivity.this);
                builder.MyBillsEntityDataFactory = "Displayed Error";
                EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", p3).MyBillsEntityDataFactory("Displayed Message", p2.asString(SavingDetailActivity.this)).MyBillsEntityDataFactory("Operation Type", p1);
                String message = p0 != null ? p0.getMessage() : null;
                EventTrackerModel.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory("Error Message", message != null ? message : "");
                if (p0 instanceof GoalsApiException) {
                    GoalsApiException goalsApiException = (GoalsApiException) p0;
                    if (goalsApiException.hasTraceIdAndErrorCode()) {
                        MyBillsEntityDataFactory2.MyBillsEntityDataFactory("Error Code", goalsApiException.getApiErrorCode());
                        MyBillsEntityDataFactory2.MyBillsEntityDataFactory("Trace ID", goalsApiException.getApiTraceId());
                    }
                }
                MyBillsEntityDataFactory2.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
            }

            @Override // id.dana.savings.contract.SavingTopUpContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(UiTextModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SavingDetailActivity savingDetailActivity = SavingDetailActivity.this;
                savingDetailActivity.onError(p0.asString(savingDetailActivity));
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (CheckoutH5EventModule) Preconditions.getAuthRequestContext(new CheckoutH5EventModule(new CheckoutH5EventContract.View() { // from class: id.dana.savings.activity.SavingDetailActivity$$ExternalSyntheticLambda7
            @Override // id.dana.h5event.CheckoutH5EventContract.View
            public final void getAuthRequestContext(boolean z) {
                SavingDetailActivity.$r8$lambda$hbvOMgeLjC66TRQqLCP4Cj78sWM(SavingDetailActivity.this, z);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, SavingDetailModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, SavingTopUpModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, CheckoutH5EventModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerSavingDetailComponent.SavingDetailComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(getSavingDetailPresenter(), getSavingTopUpPresenter());
        TextView textView = (TextView) _$_findCachedViewById(R.id.addedContains).findViewById(R.id.getMinSeparation);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.activity.SavingDetailActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SavingDetailActivity.$r8$lambda$LP8cNzOs3TGtMtegwfbeD09XLes(SavingDetailActivity.this, view);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.JsonParseException_res_0x7f0a023e);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.activity.SavingDetailActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SavingDetailActivity.$r8$lambda$P6UC76ST2Kqlx5AT6rIRhASbbLw(SavingDetailActivity.this, view);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_withdraw);
        if (danaButtonPrimaryView2 != null) {
            danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.activity.SavingDetailActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SavingDetailActivity.m2881$r8$lambda$w15O3zucxPTFhBJ6i6JuV3ASf4(SavingDetailActivity.this, view);
                }
            });
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.btn_withdraw_on_progress);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.activity.SavingDetailActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SavingDetailActivity.$r8$lambda$mC9gzHyuqZvfTM4qxr3HiHaasoE(SavingDetailActivity.this, view);
                }
            });
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d6f_r8_lambda_yswxo8xrqbfuna9q9zrdqbbzsmm);
        if (linearLayout != null) {
            if (OSUtil.scheduleImpl()) {
                linearLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            }
            ViewExtKt.PlaceComponentResult(linearLayout, 4.0f);
        }
        EmptyStateRecyclerView emptyStateRecyclerView = (EmptyStateRecyclerView) _$_findCachedViewById(R.id.rv_history);
        if (emptyStateRecyclerView != null) {
            emptyStateRecyclerView.setEmptyView((TextView) _$_findCachedViewById(R.id.KybServiceActionStrategyFactory_Factory));
            HistoryAdapter historyAdapter = new HistoryAdapter();
            emptyStateRecyclerView.addOnScrollListener(new EndlessOnScrollListener() { // from class: id.dana.savings.activity.SavingDetailActivity$initRecyclerView$1$1$1
                @Override // id.dana.richview.EndlessOnScrollListener
                public final int MyBillsEntityDataFactory() {
                    return 10;
                }

                @Override // id.dana.richview.EndlessOnScrollListener
                public final void getAuthRequestContext() {
                    SavingDetailActivity.this.BuiltInFictitiousFunctionClassFactory();
                }
            });
            this.BuiltInFictitiousFunctionClassFactory = historyAdapter;
            historyAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.savings.activity.SavingDetailActivity$$ExternalSyntheticLambda1
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i) {
                    SavingDetailActivity.$r8$lambda$Hk_Uam3wTdfkQDNdAhQJ_D_QH9o(SavingDetailActivity.this, i);
                }
            });
            emptyStateRecyclerView.setAdapter(historyAdapter);
            emptyStateRecyclerView.setLayoutManager(new LinearLayoutManager(emptyStateRecyclerView.getContext(), 1, false));
            final Context context = emptyStateRecyclerView.getContext();
            final int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(emptyStateRecyclerView.getContext(), R.color.MyBillsEntityDataFactory_res_0x7f060157);
            final float authRequestContext = SizeUtil.getAuthRequestContext(16);
            emptyStateRecyclerView.addItemDecoration(new DividerItemDecoration(context, BuiltInFictitiousFunctionClassFactory, authRequestContext) { // from class: id.dana.savings.activity.SavingDetailActivity$initRecyclerView$1$2
                @Override // id.dana.common.DividerItemDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public final void getItemOffsets(Rect p0, View p1, RecyclerView p2, RecyclerView.State p3) {
                    int i;
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                    Intrinsics.checkNotNullParameter(p2, "");
                    Intrinsics.checkNotNullParameter(p3, "");
                    super.getItemOffsets(p0, p1, p2, p3);
                    int childAdapterPosition = p2.getChildAdapterPosition(p1);
                    if (p3.BuiltInFictitiousFunctionClassFactory) {
                        i = p3.getErrorConfigVersion - p3.PlaceComponentResult;
                    } else {
                        i = p3.scheduleImpl;
                    }
                    if (childAdapterPosition == i - 1) {
                        p0.setEmpty();
                    } else {
                        super.getItemOffsets(p0, p1, p2, p3);
                    }
                }
            });
        }
        Intent intent = getIntent();
        SavingModel savingModel2 = null;
        r4 = null;
        r4 = null;
        Unit unit = null;
        savingModel2 = null;
        if (intent != null && intent.hasExtra("goals_id")) {
            Intent intent2 = getIntent();
            if (intent2 != null && (stringExtra = intent2.getStringExtra("goals_id")) != null) {
                if (!(stringExtra.length() > 0)) {
                    stringExtra = null;
                }
                if (stringExtra != null) {
                    ((ViewSkeletonScreen) this.MyBillsEntityDataFactory.getValue()).MyBillsEntityDataFactory();
                    getSavingDetailPresenter().PlaceComponentResult(stringExtra);
                    Intent intent3 = getIntent();
                    if (StringsKt.equals(intent3 != null ? intent3.getStringExtra("action") : null, "top_up", true)) {
                        getSavingTopUpPresenter().BuiltInFictitiousFunctionClassFactory(stringExtra);
                    }
                    unit = Unit.INSTANCE;
                }
            }
            if (unit == null) {
                finish();
                return;
            }
            return;
        }
        Intent intent4 = getIntent();
        if (intent4 != null && (savingModel = (SavingModel) intent4.getParcelableExtra(SavingCreateActivity.EXTRA_SAVING)) != null) {
            SavingCategoryModel savingCategoryModel = savingModel.BuiltInFictitiousFunctionClassFactory;
            if (savingCategoryModel != null) {
                this.getAuthRequestContext = savingCategoryModel;
            }
            getAuthRequestContext(savingModel);
            getSavingDetailPresenter().PlaceComponentResult(savingModel.GetContactSyncConfig);
            savingModel2 = savingModel;
        }
        if (savingModel2 == null) {
            setResult(0);
            finish();
        }
    }

    private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (DatabaseTableConfigUtil ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i3) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
