package id.dana.savings.activity;

import android.content.Context;
import android.content.Intent;
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
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
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
import id.dana.common.decoration.HorizontalItemDecoration;
import id.dana.common.decoration.VerticalItemDecoration;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.model.UiTextModel;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.saving.repository.source.network.exception.GoalsApiException;
import id.dana.data.util.NumberUtils;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSavingComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.SavingConfigModule;
import id.dana.di.modules.SavingModule;
import id.dana.domain.saving.model.SavingCreateInit;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.savings.activity.SavingCreateActivity;
import id.dana.savings.activity.SavingDetailActivity;
import id.dana.savings.activity.SavingsActivity;
import id.dana.savings.adapter.SavingAdapter;
import id.dana.savings.adapter.SavingBenefitAdapter;
import id.dana.savings.contract.SavingConfigContract;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.contract.SavingViewListener;
import id.dana.savings.model.SavingBenefitModel;
import id.dana.savings.model.SavingCreateInitModel;
import id.dana.savings.model.SavingCreateInitModelKt;
import id.dana.savings.model.SavingDetailModel;
import id.dana.savings.model.SavingEmptyStateModel;
import id.dana.savings.model.SavingModel;
import id.dana.savings.model.SavingSummaryModel;
import id.dana.savings.presenter.SavingConfigPresenter;
import id.dana.savings.view.TotalSavingAmountView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.ResourceUtils;
import id.dana.utils.SizeUtil;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.BehaviorSubject;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 V2\u00020\u0001:\u0002VWB\u0007¢\u0006\u0004\bU\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J)\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001e\u0010\u0004J\r\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010!\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u0010\u0013\u001a\u0002018\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u0015\u001a\u0002048\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\"\u0010C\u001a\u00020B8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0019\u0010(\u001a\b\u0012\u0004\u0012\u00020J0IX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010$\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0013\u0010R\u001a\u00020PX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bQ\u0010LR\u0013\u0010T\u001a\u00020PX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bS\u0010L"}, d2 = {"Lid/dana/savings/activity/SavingsActivity;", "Lid/dana/savings/activity/OnBoardingActivity;", "", "configToolbar", "()V", "", "getLayout", "()I", "", "Lid/dana/usereducation/model/ContentOnBoardingModel;", "getOnBoardingContents", "()Ljava/util/List;", "", "getOnBoardingListViewTitleStringRes", "()Ljava/lang/String;", "getOnBoardingPageViewTitleStringRes", "getOnBoardingScenario", IAPSyncCommand.COMMAND_INIT, "", "PlaceComponentResult", "()Z", "BuiltInFictitiousFunctionClassFactory", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "moveToNextValue", "onDestroy", "onResume", "showSavingLimitDialog", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "Lio/reactivex/disposables/CompositeDisposable;", "scheduleImpl", "Lio/reactivex/disposables/CompositeDisposable;", "MyBillsEntityDataFactory", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "getErrorConfigVersion", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lid/dana/savings/adapter/SavingAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/savings/adapter/SavingAdapter;", "Lid/dana/savings/adapter/SavingBenefitAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/savings/adapter/SavingBenefitAdapter;", "Lid/dana/savings/presenter/SavingConfigPresenter;", "savingConfigPresenter", "Lid/dana/savings/presenter/SavingConfigPresenter;", "getSavingConfigPresenter", "()Lid/dana/savings/presenter/SavingConfigPresenter;", "setSavingConfigPresenter", "(Lid/dana/savings/presenter/SavingConfigPresenter;)V", "Lid/dana/savings/model/SavingEmptyStateModel;", "GetContactSyncConfig", "Lid/dana/savings/model/SavingEmptyStateModel;", "getAuthRequestContext", "Lid/dana/savings/contract/SavingContract$Presenter;", "savingPresenter", "Lid/dana/savings/contract/SavingContract$Presenter;", "getSavingPresenter", "()Lid/dana/savings/contract/SavingContract$Presenter;", "setSavingPresenter", "(Lid/dana/savings/contract/SavingContract$Presenter;)V", "Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/savings/activity/SavingsActivity$SavingScreenState;", "initRecordTimeStamp", "Lkotlin/Lazy;", "Lid/dana/savings/model/SavingSummaryModel;", "DatabaseTableConfigUtil", "Lid/dana/savings/model/SavingSummaryModel;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda0", "<init>", "Companion", "SavingScreenState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingsActivity extends OnBoardingActivity {
    public static final String MAX_SAVING_AMOUNT = "max_saving_amount";
    public static final String MAX_SAVING_COUNT = "max_saving_count";
    public static final int REQUEST_CODE_CREATE_SAVING = 2002;
    public static final int REQUEST_CODE_DETAIL_SAVING = 2003;
    public static final int SHIMMER_ANGLE = 20;
    public static final int SHIMMER_DURATION = 1500;
    public static final int SHIMMER_ITEM_COUNT = 1;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private SavingSummaryModel scheduleImpl;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private SavingEmptyStateModel getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private SavingBenefitAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private SavingAdapter PlaceComponentResult;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private CustomSnackbar KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public SavingConfigPresenter savingConfigPresenter;
    @Inject
    public SavingContract.Presenter savingPresenter;
    public static final byte[] $$g = {75, -23, 102, -23, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 248;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {14, -73, -90, 103, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int lookAheadTest = 241;
    private static long PrepareContext = 501179906346207241L;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<BehaviorSubject<SavingScreenState>>() { // from class: id.dana.savings.activity.SavingsActivity$savingScreenReadySubject$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BehaviorSubject<SavingsActivity.SavingScreenState> invoke() {
            return BehaviorSubject.getAuthRequestContext(new SavingsActivity.SavingScreenState(false, false, false, 7, null));
        }
    });

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final CompositeDisposable MyBillsEntityDataFactory = new CompositeDisposable();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<RecyclerViewSkeletonScreen>() { // from class: id.dana.savings.activity.SavingsActivity$skeletonGoalList$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RecyclerViewSkeletonScreen invoke() {
            SavingAdapter savingAdapter;
            RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((RecyclerView) ((EmptyStateRecyclerView) SavingsActivity.this._$_findCachedViewById(R.id.handleSystemError)));
            savingAdapter = SavingsActivity.this.PlaceComponentResult;
            if (savingAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                savingAdapter = null;
            }
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = savingAdapter;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_goal_list_skeleton;
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = 20;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 1;
            RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
            return recyclerViewSkeletonScreen;
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.savings.activity.SavingsActivity$skeletonTotalAmount$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewSkeletonScreen invoke() {
            TotalSavingAmountView totalSavingAmountView = (TotalSavingAmountView) SavingsActivity.this._$_findCachedViewById(R.id.view_total_saving_amount);
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(totalSavingAmountView != null ? (TextView) totalSavingAmountView._$_findCachedViewById(R.id.PushVerifyPreferenceEntityDataFactory) : null);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_total_amount_skeleton;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            return viewSkeletonScreen;
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:32:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0025 -> B:35:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(int r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.savings.activity.SavingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r9 = 23 - r9
            int r7 = 55 - r7
            int r8 = 106 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2d
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            int r7 = r7 + 1
            if (r5 != r9) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L25:
            r3 = r0[r7]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2d:
            int r8 = r8 + r9
            int r8 = r8 + (-4)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingsActivity.g(int, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0029 -> B:35:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.savings.activity.SavingsActivity.$$g
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r7 = 46 - r7
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingsActivity.j(short, byte, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void startActivity(BaseActivity baseActivity, String str) {
        Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity, str);
    }

    @Override // id.dana.savings.activity.OnBoardingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.savings.activity.OnBoardingActivity
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

    @Override // id.dana.savings.activity.OnBoardingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        h(35291 - View.getDefaultSize(0, 0), new char[]{39211, 4351, 35480, 1193, 48713, 10340, 41484, 23961, 55293, 16778, 64490, 30067, 61308, 39226, 4307, 35578, 1161, 48818}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        h((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 64230, new char[]{39207, 25556, 27857, 27030, 29362}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    h((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 40543, new char[]{39293, 1910, 42434, 17007, 57350, 36597, 12105, 52715, 27525, 2168, 46751, 22329, 62811, 37803, 12361, 57069, 31883, 7476, 48082, 22566, 50754, 25826, 1283, 41973, 16838, 60990, 36052, 11563, 51996, 27117, 5641, 46254, 21139, 62275, 37350, 16270, 56432, 31432, 7016, 47363, 10149, 50203, 25320, 137, 41340, 20426, 60526, 35422}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    h((-16730447) - Color.rgb(0, 0, 0), new char[]{39211, 12238, 62494, 48445, 17384, 2054, 53596, 26533, 11430, 62736, 48025, 16612, 2402, 57222, 25813, 11553, 62056, 47289, 16734, 5720, 56570, 26110, 10826, 61598, 47588, 20065, 5257, 56708, 25134, 11043, 61894, 34327, 20233, 5631, 56060, 25409, 10701, 65212, 34620, 19854, 4823, 56099, 24613, 14016, 65349, 33888, 19125, 4866, 55369, 28312, 14319, 64560, 33415, 19416, 4140, 55676, 28610, 13330, 64819, 33763, 18439, 4447, 42992, 27894}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    h(6719 - Color.red(0), new char[]{39288, 33604, 44369, 55189, 61839, 6726, 1026, 11975, 18570, 30021, 40708, 47566, 41871, 52298, 62984, 4300, 15067, 9984, 16656, 27523, 38292, 48643, 55361, 49872, 60565, 2315, 13077, 24023, 18376, 24591, 35359, 46216, 56989, 64305, 58662, 4079, 10740, 21094, 31782, 26347, 32938, 44347, 55085, 61931, 7078, 1129, 11897, 18617, 29436, 40828, 47463, 41890, 52660, 63088, 4198, 15094, 9397, 16760, 27445, 38393, 49128, 55420, 49725, 60658}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    h((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 52301, new char[]{39202, 21875, 420, 64989, 43021, 25841, 20651, 3966, 64326, 47006, 25126, 24164, 2808, 50903, 46356, 25019, 24063, 2102, 50260, 45214, 28463, 23400, 6048, 50063, 48661, 27322, 9977, 5415, 49474, 48512, 26685, 9324, 4235, 52437, 47893, 30691, 9213, 7684, 51785, 34526, 29987, 8559, 7553, 51594, 33823, 28845, 11515, 6924, 55113, 33667, 32367, 10859, 59100, 53908, 33041, 32183, 10743, 58369, 53324, 35974}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    h(41579 - (ViewConfiguration.getKeyRepeatDelay() >> 16), new char[]{39283, 15119, 56744, 32293, 4308, 46444}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), View.MeasureSpec.getSize(0) + 18, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                g(NetworkUserEntityData$$ExternalSyntheticLambda0[31], NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                g((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[34] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[7], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 54, 3 - TextUtils.getTrimmedLength(""), (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        Object[] objArr16 = new Object[1];
                        j($$g[47], (byte) (-$$g[53]), $$g[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.lastIndexOf("", '0', 0, 0), TextUtils.lastIndexOf("", '0', 0) + 16, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778016, Color.alpha(0) + 15, (char) (Process.getGidForName("") + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getFadingEdgeLength() >> 16), KeyEvent.getDeadChar(0, 0) + 29, (char) (57995 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.getMode(0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 15, (char) View.MeasureSpec.getMode(0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-95433721, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                g(NetworkUserEntityData$$ExternalSyntheticLambda0[31], NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                g((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[34] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[7], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 45 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) Color.green(0));
                        Object[] objArr22 = new Object[1];
                        j((byte) (-$$g[9]), $$g[20], (byte) ($$g[47] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-95433721, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, 18 - KeyEvent.normalizeMetaState(0), (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                g(NetworkUserEntityData$$ExternalSyntheticLambda0[31], NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                g((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[34] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[7], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 118, 3 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (KeyEvent.normalizeMetaState(0) + 38968));
                        Object[] objArr28 = new Object[1];
                        j((byte) (-$$g[9]), $$g[20], (byte) ($$g[47] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-95433721, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, ExpandableListView.getPackedPositionType(0L) + 18, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                g(NetworkUserEntityData$$ExternalSyntheticLambda0[31], NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                g((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[34] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[7], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 107, TextUtils.getCapsMode("", 0, 0) + 3, (char) View.resolveSize(0, 0));
                        byte b = (byte) ($$g[47] - 1);
                        Object[] objArr34 = new Object[1];
                        j(b, b, (byte) (-$$g[8]), objArr34);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-95433721, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.savings.activity.OnBoardingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.savings.activity.OnBoardingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_savings;
    }

    @Override // id.dana.savings.activity.OnBoardingActivity
    public final String getOnBoardingScenario() {
        return "saving_goal";
    }

    @Override // id.dana.savings.activity.OnBoardingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.savings.activity.OnBoardingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        h(35291 - KeyEvent.normalizeMetaState(0), new char[]{39211, 4351, 35480, 1193, 48713, 10340, 41484, 23961, 55293, 16778, 64490, 30067, 61308, 39226, 4307, 35578, 1161, 48818}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        h(64232 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new char[]{39207, 25556, 27857, 27030, 29362}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                h(getPackageName().length() + 62010, new char[]{39211, 27493, 32172, 20475, 20513, 8806, 13480, 1699, 2851, 7539, 61360, 61871, 49671, 54372, 42672, 43244, 48428, 36722, 37292, 25568, 29706, 18039, 18606, 23288, 12083, 12663}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                h((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 58756, new char[]{39209, 31930, 21042, 10679, 3899, 58045, 63520, 57256, 46354, 34967, 28180, 17812, 23317, 16106, 5240, 60392, 49525, 42225}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    h((ViewConfiguration.getDoubleTapTimeout() >> 16) + 40543, new char[]{39293, 1910, 42434, 17007, 57350, 36597, 12105, 52715, 27525, 2168, 46751, 22329, 62811, 37803, 12361, 57069, 31883, 7476, 48082, 22566, 50754, 25826, 1283, 41973, 16838, 60990, 36052, 11563, 51996, 27117, 5641, 46254, 21139, 62275, 37350, 16270, 56432, 31432, 7016, 47363, 10149, 50203, 25320, 137, 41340, 20426, 60526, 35422}, objArr6);
                    String str = (String) objArr6[0];
                    try {
                        Object[] objArr7 = new Object[1];
                        g((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[59] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[32], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        g(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[13], NetworkUserEntityData$$ExternalSyntheticLambda0[27], objArr8);
                        Object[] objArr9 = new Object[1];
                        h(((ApplicationInfo) cls3.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 46736, new char[]{39211, 12238, 62494, 48445, 17384, 2054, 53596, 26533, 11430, 62736, 48025, 16612, 2402, 57222, 25813, 11553, 62056, 47289, 16734, 5720, 56570, 26110, 10826, 61598, 47588, 20065, 5257, 56708, 25134, 11043, 61894, 34327, 20233, 5631, 56060, 25409, 10701, 65212, 34620, 19854, 4823, 56099, 24613, 14016, 65349, 33888, 19125, 4866, 55369, 28312, 14319, 64560, 33415, 19416, 4140, 55676, 28610, 13330, 64819, 33763, 18439, 4447, 42992, 27894}, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(6719 - TextUtils.indexOf("", ""), new char[]{39288, 33604, 44369, 55189, 61839, 6726, 1026, 11975, 18570, 30021, 40708, 47566, 41871, 52298, 62984, 4300, 15067, 9984, 16656, 27523, 38292, 48643, 55361, 49872, 60565, 2315, 13077, 24023, 18376, 24591, 35359, 46216, 56989, 64305, 58662, 4079, 10740, 21094, 31782, 26347, 32938, 44347, 55085, 61931, 7078, 1129, 11897, 18617, 29436, 40828, 47463, 41890, 52660, 63088, 4198, 15094, 9397, 16760, 27445, 38393, 49128, 55420, 49725, 60658}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h(super.getResources().getString(R.string.share).substring(10, 11).codePointAt(0) + 52269, new char[]{39202, 21875, 420, 64989, 43021, 25841, 20651, 3966, 64326, 47006, 25126, 24164, 2808, 50903, 46356, 25019, 24063, 2102, 50260, 45214, 28463, 23400, 6048, 50063, 48661, 27322, 9977, 5415, 49474, 48512, 26685, 9324, 4235, 52437, 47893, 30691, 9213, 7684, 51785, 34526, 29987, 8559, 7553, 51594, 33823, 28845, 11515, 6924, 55113, 33667, 32367, 10859, 59100, 53908, 33041, 32183, 10743, 58369, 53324, 35974}, objArr11);
                        String str4 = (String) objArr11[0];
                        try {
                            Object[] objArr12 = new Object[1];
                            g((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[59] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[32], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr12);
                            Class<?> cls4 = Class.forName((String) objArr12[0]);
                            Object[] objArr13 = new Object[1];
                            g(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[13], NetworkUserEntityData$$ExternalSyntheticLambda0[27], objArr13);
                            Object[] objArr14 = new Object[1];
                            h(((ApplicationInfo) cls4.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 41546, new char[]{39283, 15119, 56744, 32293, 4308, 46444}, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetAfter("", 0), 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            Object[] objArr16 = new Object[1];
            g(NetworkUserEntityData$$ExternalSyntheticLambda0[31], NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), objArr16);
            Class<?> cls5 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            g((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[34] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[7], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 494, 4 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) View.getDefaultSize(0, 0));
                    byte b = (byte) ($$g[47] - 1);
                    Object[] objArr19 = new Object[1];
                    j(b, b, (byte) (-$$g[8]), objArr19);
                    obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                int i = ((int[]) objArr20[1])[0];
                if (((int[]) objArr20[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {-668521300, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr21);
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

    @Override // id.dana.savings.activity.OnBoardingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            h(super.getResources().getString(R.string.identity_tooltip_desc).substring(20, 22).codePointAt(0) + 61907, new char[]{39211, 27493, 32172, 20475, 20513, 8806, 13480, 1699, 2851, 7539, 61360, 61871, 49671, 54372, 42672, 43244, 48428, 36722, 37292, 25568, 29706, 18039, 18606, 23288, 12083, 12663}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            h(getPackageName().length() + 58750, new char[]{39209, 31930, 21042, 10679, 3899, 58045, 63520, 57256, 46354, 34967, 28180, 17812, 23317, 16106, 5240, 60392, 49525, 42225}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @JvmName(name = "getSavingPresenter")
    public final SavingContract.Presenter getSavingPresenter() {
        SavingContract.Presenter presenter = this.savingPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSavingPresenter")
    public final void setSavingPresenter(SavingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.savingPresenter = presenter;
    }

    @JvmName(name = "getSavingConfigPresenter")
    public final SavingConfigPresenter getSavingConfigPresenter() {
        SavingConfigPresenter savingConfigPresenter = this.savingConfigPresenter;
        if (savingConfigPresenter != null) {
            return savingConfigPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSavingConfigPresenter")
    public final void setSavingConfigPresenter(SavingConfigPresenter savingConfigPresenter) {
        Intrinsics.checkNotNullParameter(savingConfigPresenter, "");
        this.savingConfigPresenter = savingConfigPresenter;
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

    /* JADX WARN: Type inference failed for: r6v4, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.common.decoration.HorizontalItemDecoration$DecorationMode] */
    @Override // id.dana.base.BaseActivity
    public final void init() {
        MixPanelTracker.getAuthRequestContext(TrackerKey.Event.SAVINGS_GOAL_OPEN);
        DaggerSavingComponent.Builder PlaceComponentResult = DaggerSavingComponent.PlaceComponentResult();
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult.PlaceComponentResult = (SavingConfigModule) Preconditions.getAuthRequestContext(new SavingConfigModule(new SavingConfigContract.View() { // from class: id.dana.savings.activity.SavingsActivity$getSavingConfigModule$1
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

            @Override // id.dana.savings.contract.SavingConfigContract.View
            public final void getAuthRequestContext(boolean p0) {
                SavingSummaryModel savingSummaryModel;
                List<SavingModel> list;
                savingSummaryModel = SavingsActivity.this.scheduleImpl;
                if (savingSummaryModel == null || (list = savingSummaryModel.scheduleImpl) == null) {
                    return;
                }
                List<SavingModel> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (SavingModel savingModel : list2) {
                    savingModel.moveToNextValue = p0;
                    arrayList.add(savingModel);
                }
                SavingsActivity.access$setSavings(SavingsActivity.this, arrayList);
            }
        }));
        PlaceComponentResult.getAuthRequestContext = (SavingModule) Preconditions.getAuthRequestContext(new SavingModule(new SavingViewListener() { // from class: id.dana.savings.activity.SavingsActivity$getSavingModule$1
            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void MyBillsEntityDataFactory(SavingSummaryModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SavingsActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(false);
                SavingsActivity.access$setSavingSummary(SavingsActivity.this, p0);
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                if (!p0) {
                    SavingsActivity.access$showUpgradeToKycDialog(SavingsActivity.this);
                } else {
                    SavingsActivity.this.showSavingLimitDialog();
                }
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void getAuthRequestContext(SavingCreateInit p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SavingsActivity.access$startSavingCreateActivity(SavingsActivity.this, p0);
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void PlaceComponentResult() {
                Object obj = SavingsActivity.access$getSavingScreenReadySubject(SavingsActivity.this).getErrorConfigVersion.get();
                SavingsActivity.SavingScreenState savingScreenState = (SavingsActivity.SavingScreenState) ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj));
                if (savingScreenState != null) {
                    SavingsActivity.access$getSavingScreenReadySubject(SavingsActivity.this).onNext(SavingsActivity.SavingScreenState.BuiltInFictitiousFunctionClassFactory(savingScreenState, true, false, false, 6));
                }
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void MyBillsEntityDataFactory() {
                Object obj = SavingsActivity.access$getSavingScreenReadySubject(SavingsActivity.this).getErrorConfigVersion.get();
                SavingsActivity.SavingScreenState savingScreenState = (SavingsActivity.SavingScreenState) ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj));
                if (savingScreenState != null) {
                    SavingsActivity.access$getSavingScreenReadySubject(SavingsActivity.this).onNext(SavingsActivity.SavingScreenState.BuiltInFictitiousFunctionClassFactory(savingScreenState, false, true, false, 5));
                }
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void getAuthRequestContext() {
                SavingsActivity.this.showSavingLimitDialog();
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void PlaceComponentResult(SavingEmptyStateModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SavingsActivity.access$setEmptyState(SavingsActivity.this, p0);
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                SavingsActivity savingsActivity = SavingsActivity.this;
                if (p0 == null) {
                    p0 = "";
                }
                SavingsActivity.access$showErrorSnackbar(savingsActivity, p0);
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1, UiTextModel p2, String p3) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                Intrinsics.checkNotNullParameter(p3, "");
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(SavingsActivity.this);
                builder.MyBillsEntityDataFactory = "Displayed Error";
                EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", p3).MyBillsEntityDataFactory("Displayed Message", p2.asString(SavingsActivity.this)).MyBillsEntityDataFactory("Operation Type", p1);
                String message = p0.getMessage();
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

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void getAuthRequestContext(UiTextModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SavingsActivity savingsActivity = SavingsActivity.this;
                SavingsActivity.access$showErrorSnackbar(savingsActivity, p0.asString(savingsActivity));
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void PlaceComponentResult(UiTextModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SavingsActivity savingsActivity = SavingsActivity.this;
                SavingsActivity.access$showErrorSnackbar(savingsActivity, p0.asString(savingsActivity));
            }
        }));
        PlaceComponentResult.MyBillsEntityDataFactory = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(getBottomOnBoardingModule());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, SavingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, BottomSheetOnBoardingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, SavingConfigModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerSavingComponent.SavingComponentImpl(PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.MyBillsEntityDataFactory, PlaceComponentResult.PlaceComponentResult, PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        int i = 2;
        final boolean z = false;
        final boolean z2 = true;
        registerPresenter(getSavingPresenter(), getSavingConfigPresenter());
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_benefit);
        if (recyclerView != null) {
            SavingBenefitAdapter savingBenefitAdapter = new SavingBenefitAdapter();
            recyclerView.setAdapter(savingBenefitAdapter);
            this.BuiltInFictitiousFunctionClassFactory = savingBenefitAdapter;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(new VerticalItemDecoration(16));
        }
        EmptyStateRecyclerView emptyStateRecyclerView = (EmptyStateRecyclerView) _$_findCachedViewById(R.id.handleSystemError);
        if (emptyStateRecyclerView != null) {
            SavingAdapter savingAdapter = new SavingAdapter();
            savingAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda0
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i2) {
                    SavingsActivity.m2885$r8$lambda$MzC1zA_pX1WWq61p1IfSncqTs(SavingsActivity.this, i2);
                }
            });
            this.PlaceComponentResult = savingAdapter;
            emptyStateRecyclerView.setAdapter(savingAdapter);
            emptyStateRecyclerView.setLayoutManager(new LinearLayoutManager(emptyStateRecyclerView.getContext(), 1, false));
            emptyStateRecyclerView.setNestedScrollingEnabled(false);
            ?? r6 = 0;
            emptyStateRecyclerView.addItemDecoration(new HorizontalItemDecoration(SizeUtil.getAuthRequestContext(12), r6, i, r6));
        }
        final DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.res_0x7f0a01ab_flowviewutil_textchanges_2);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SavingsActivity.$r8$lambda$CmmspWpVzAuMhg3m5JcIJxB5kgg(SavingsActivity.this, view);
                }
            });
            final NestedScrollView nestedScrollView = (NestedScrollView) _$_findCachedViewById(R.id.checkRegionForParsing);
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
            ViewTreeObserver viewTreeObserver = nestedScrollView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        SavingsActivity.$r8$lambda$bpmRv9WF1iW0oUwb3n0CJdW6lYE(z, danaButtonSecondaryView, nestedScrollView, this);
                    }
                });
            }
        }
        final DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.btn_add_scrollable);
        if (danaButtonSecondaryView2 != null) {
            danaButtonSecondaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SavingsActivity.m2883$r8$lambda$4s8cLZLjczf5vArNTXbha4J7Iw(SavingsActivity.this, view);
                }
            });
            final NestedScrollView nestedScrollView2 = (NestedScrollView) _$_findCachedViewById(R.id.checkRegionForParsing);
            Intrinsics.checkNotNullExpressionValue(nestedScrollView2, "");
            ViewTreeObserver viewTreeObserver2 = nestedScrollView2.getViewTreeObserver();
            if (viewTreeObserver2 != null) {
                viewTreeObserver2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        SavingsActivity.$r8$lambda$bpmRv9WF1iW0oUwb3n0CJdW6lYE(z2, danaButtonSecondaryView2, nestedScrollView2, this);
                    }
                });
            }
        }
        final DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_add_empty);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SavingsActivity.$r8$lambda$JUNZp0RCO25UZqow67Diy9qepNE(SavingsActivity.this, view);
                }
            });
            final NestedScrollView nestedScrollView3 = (NestedScrollView) _$_findCachedViewById(R.id.checkRegionForParsing);
            Intrinsics.checkNotNullExpressionValue(nestedScrollView3, "");
            ViewTreeObserver viewTreeObserver3 = nestedScrollView3.getViewTreeObserver();
            if (viewTreeObserver3 != null) {
                viewTreeObserver3.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda6
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        SavingsActivity.m2884$r8$lambda$8zAYG1C26k4ch0eg9xyTHj86I(z, danaButtonPrimaryView, nestedScrollView3, this);
                    }
                });
            }
        }
        final DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_add_empty_scrollable);
        if (danaButtonPrimaryView2 != null) {
            danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SavingsActivity.m2886$r8$lambda$Vp2R2TjTNFfjD4HMb_vvPJSJrQ(SavingsActivity.this, view);
                }
            });
            final NestedScrollView nestedScrollView4 = (NestedScrollView) _$_findCachedViewById(R.id.checkRegionForParsing);
            Intrinsics.checkNotNullExpressionValue(nestedScrollView4, "");
            ViewTreeObserver viewTreeObserver4 = nestedScrollView4.getViewTreeObserver();
            if (viewTreeObserver4 != null) {
                viewTreeObserver4.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda6
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        SavingsActivity.m2884$r8$lambda$8zAYG1C26k4ch0eg9xyTHj86I(z2, danaButtonPrimaryView2, nestedScrollView4, this);
                    }
                });
            }
        }
        Object value = this.getErrorConfigVersion.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        if (!((BehaviorSubject) value).PlaceComponentResult()) {
            Object value2 = this.getErrorConfigVersion.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "");
            this.MyBillsEntityDataFactory.getAuthRequestContext(((BehaviorSubject) value2).subscribe(new Consumer() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SavingsActivity.m2888$r8$lambda$wK3XYwkrsL78lR2ovGVBXbOn1Y(SavingsActivity.this, (SavingsActivity.SavingScreenState) obj);
                }
            }));
        }
        KClassImpl$Data$declaredNonStaticMembers$2(true);
        getSavingPresenter().MyBillsEntityDataFactory();
        getSavingPresenter().PlaceComponentResult();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        super.onDestroy();
    }

    @Override // id.dana.savings.activity.OnBoardingActivity, id.dana.base.BaseActivity
    public final void configToolbar() {
        setTitle(getString(R.string.title_saving));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    @Override // id.dana.savings.activity.OnBoardingActivity
    public final String getOnBoardingPageViewTitleStringRes() {
        String string = getString(R.string.bottom_on_boarding_page_title_saving_goal);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Override // id.dana.savings.activity.OnBoardingActivity
    public final String getOnBoardingListViewTitleStringRes() {
        String string = getString(R.string.bottom_on_boarding_list_title_saving_goal);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Override // id.dana.savings.activity.OnBoardingActivity
    public final List<ContentOnBoardingModel> getOnBoardingContents() {
        List<SavingBenefitModel> list;
        ArrayList arrayList = new ArrayList();
        SavingEmptyStateModel savingEmptyStateModel = this.getAuthRequestContext;
        if (savingEmptyStateModel != null && (list = savingEmptyStateModel.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            for (SavingBenefitModel savingBenefitModel : list) {
                Context baseContext = getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext, "");
                int KClassImpl$Data$declaredNonStaticMembers$2 = ResourceUtils.KClassImpl$Data$declaredNonStaticMembers$2(baseContext, savingBenefitModel.KClassImpl$Data$declaredNonStaticMembers$2);
                if (KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
                    Context baseContext2 = getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(baseContext2, "");
                    String PlaceComponentResult = ResourceUtils.PlaceComponentResult(baseContext2, savingBenefitModel.BuiltInFictitiousFunctionClassFactory, savingBenefitModel.BuiltInFictitiousFunctionClassFactory);
                    Context baseContext3 = getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(baseContext3, "");
                    arrayList.add(new ContentOnBoardingModel(KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult, ResourceUtils.PlaceComponentResult(baseContext3, savingBenefitModel.getAuthRequestContext, savingBenefitModel.getAuthRequestContext)));
                } else {
                    String str = savingBenefitModel.KClassImpl$Data$declaredNonStaticMembers$2;
                    Context baseContext4 = getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(baseContext4, "");
                    String PlaceComponentResult2 = ResourceUtils.PlaceComponentResult(baseContext4, savingBenefitModel.BuiltInFictitiousFunctionClassFactory, savingBenefitModel.BuiltInFictitiousFunctionClassFactory);
                    Context baseContext5 = getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(baseContext5, "");
                    arrayList.add(new ContentOnBoardingModel(str, PlaceComponentResult2, ResourceUtils.PlaceComponentResult(baseContext5, savingBenefitModel.getAuthRequestContext, savingBenefitModel.getAuthRequestContext)));
                }
            }
        }
        return arrayList;
    }

    private final void moveToNextValue() {
        if (this.scheduleImpl != null) {
            if (BuiltInFictitiousFunctionClassFactory() || PlaceComponentResult()) {
                getSavingPresenter().getAuthRequestContext();
            } else {
                getSavingPresenter().BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    @Override // id.dana.savings.activity.OnBoardingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                g((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[59] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[32], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                g(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[13], NetworkUserEntityData$$ExternalSyntheticLambda0[27], objArr2);
                Object[] objArr3 = new Object[1];
                h(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 61984, new char[]{39211, 27493, 32172, 20475, 20513, 8806, 13480, 1699, 2851, 7539, 61360, 61871, 49671, 54372, 42672, 43244, 48428, 36722, 37292, 25568, 29706, 18039, 18606, 23288, 12083, 12663}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                h(super.getResources().getString(R.string.kyc_aml_edd_activity_button).substring(0, 5).length() + 58752, new char[]{39209, 31930, 21042, 10679, 3899, 58045, 63520, 57256, 46354, 34967, 28180, 17812, 23317, 16106, 5240, 60392, 49525, 42225}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, Color.argb(0, 0, 0, 0) + 35, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 18 - Color.argb(0, 0, 0, 0), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
        KClassImpl$Data$declaredNonStaticMembers$2(true);
        getSavingPresenter().MyBillsEntityDataFactory();
        getSavingPresenter().PlaceComponentResult();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        ImageView imageView;
        if (p0) {
            setMenuRightButton(R.drawable.ic_tooltip_help);
            TotalSavingAmountView totalSavingAmountView = (TotalSavingAmountView) _$_findCachedViewById(R.id.view_total_saving_amount);
            if (totalSavingAmountView != null) {
                totalSavingAmountView.setVisibility(0);
            }
            TotalSavingAmountView totalSavingAmountView2 = (TotalSavingAmountView) _$_findCachedViewById(R.id.view_total_saving_amount);
            ImageView imageView2 = totalSavingAmountView2 != null ? (ImageView) totalSavingAmountView2._$_findCachedViewById(R.id.iv_hide_balance_loading) : null;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            TotalSavingAmountView totalSavingAmountView3 = (TotalSavingAmountView) _$_findCachedViewById(R.id.view_total_saving_amount);
            imageView = totalSavingAmountView3 != null ? (ImageView) totalSavingAmountView3._$_findCachedViewById(R.id.iv_hide_balance) : null;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.btn_add_loading);
            if (danaButtonSecondaryView != null) {
                danaButtonSecondaryView.setVisibility(0);
            }
            Object value = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "");
            ((SkeletonScreen) value).MyBillsEntityDataFactory();
            Object value2 = this.lookAheadTest.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "");
            ((SkeletonScreen) value2).MyBillsEntityDataFactory();
            return;
        }
        TotalSavingAmountView totalSavingAmountView4 = (TotalSavingAmountView) _$_findCachedViewById(R.id.view_total_saving_amount);
        ImageView imageView3 = totalSavingAmountView4 != null ? (ImageView) totalSavingAmountView4._$_findCachedViewById(R.id.iv_hide_balance_loading) : null;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        TotalSavingAmountView totalSavingAmountView5 = (TotalSavingAmountView) _$_findCachedViewById(R.id.view_total_saving_amount);
        imageView = totalSavingAmountView5 != null ? (ImageView) totalSavingAmountView5._$_findCachedViewById(R.id.iv_hide_balance) : null;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.btn_add_loading);
        if (danaButtonSecondaryView2 != null) {
            danaButtonSecondaryView2.setVisibility(8);
        }
        Object value3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
        Intrinsics.checkNotNullExpressionValue(value3, "");
        ((SkeletonScreen) value3).PlaceComponentResult();
        Object value4 = this.lookAheadTest.getValue();
        Intrinsics.checkNotNullExpressionValue(value4, "");
        ((SkeletonScreen) value4).PlaceComponentResult();
    }

    public final void showSavingLimitDialog() {
        MoneyViewModel moneyViewModel;
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.DatabaseTableConfigUtil = R.drawable.ic_faceenrol_invalid;
        builder.SubSequence = getString(R.string.pop_up_title_saving_limit_decline);
        String string = getString(R.string.pop_up_description_saving_limit_decline);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Object[] objArr = new Object[2];
        SavingSummaryModel savingSummaryModel = this.scheduleImpl;
        String str = null;
        objArr[0] = String.valueOf(savingSummaryModel != null ? Long.valueOf(savingSummaryModel.getAuthRequestContext) : null);
        SavingSummaryModel savingSummaryModel2 = this.scheduleImpl;
        if (savingSummaryModel2 != null && (moneyViewModel = savingSummaryModel2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            str = moneyViewModel.PlaceComponentResult;
        }
        objArr[1] = str;
        String format = String.format(string, Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(format, "");
        builder.GetContactSyncConfig = format;
        builder.moveToNextValue = 0L;
        builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory(getString(R.string.pop_up_positive_button_saving_limit_info), new Function1<View, Unit>() { // from class: id.dana.savings.activity.SavingsActivity$showSavingLimitDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        SavingAdapter savingAdapter = this.PlaceComponentResult;
        if (savingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            savingAdapter = null;
        }
        return savingAdapter.getPlaceComponentResult() == 10;
    }

    private final boolean PlaceComponentResult() {
        MoneyViewModel moneyViewModel;
        SavingSummaryModel savingSummaryModel = this.scheduleImpl;
        return Intrinsics.areEqual((savingSummaryModel == null || (moneyViewModel = savingSummaryModel.lookAheadTest) == null) ? null : moneyViewModel.PlaceComponentResult, "0");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00038\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00038\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00038\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f"}, d2 = {"Lid/dana/savings/activity/SavingsActivity$SavingScreenState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "PlaceComponentResult", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "<init>", "(ZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class SavingScreenState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private boolean MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean getAuthRequestContext;

        public SavingScreenState() {
            this(false, false, false, 7, null);
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof SavingScreenState) {
                SavingScreenState savingScreenState = (SavingScreenState) p0;
                return this.MyBillsEntityDataFactory == savingScreenState.MyBillsEntityDataFactory && this.getAuthRequestContext == savingScreenState.getAuthRequestContext && this.KClassImpl$Data$declaredNonStaticMembers$2 == savingScreenState.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public final int hashCode() {
            boolean z = this.MyBillsEntityDataFactory;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            ?? r2 = this.getAuthRequestContext;
            int i = r2;
            if (r2 != 0) {
                i = 1;
            }
            boolean z2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return (((r0 * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SavingScreenState(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        private SavingScreenState(boolean z, boolean z2, boolean z3) {
            this.MyBillsEntityDataFactory = z;
            this.getAuthRequestContext = z2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z3;
        }

        public /* synthetic */ SavingScreenState(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public static /* synthetic */ SavingScreenState BuiltInFictitiousFunctionClassFactory(SavingScreenState savingScreenState, boolean z, boolean z2, boolean z3, int i) {
            if ((i & 1) != 0) {
                z = savingScreenState.MyBillsEntityDataFactory;
            }
            if ((i & 2) != 0) {
                z2 = savingScreenState.getAuthRequestContext;
            }
            if ((i & 4) != 0) {
                z3 = savingScreenState.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return new SavingScreenState(z, z2, z3);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000e"}, d2 = {"Lid/dana/savings/activity/SavingsActivity$Companion;", "", "Lid/dana/base/BaseActivity;", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/base/BaseActivity;Ljava/lang/String;)V", "MAX_SAVING_AMOUNT", "Ljava/lang/String;", "MAX_SAVING_COUNT", "", "REQUEST_CODE_CREATE_SAVING", "I", "REQUEST_CODE_DETAIL_SAVING", "SHIMMER_ANGLE", "SHIMMER_DURATION", "SHIMMER_ITEM_COUNT", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(BaseActivity p0, String p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            if (p0 != null) {
                p0.startActivity(p0.getIntentClassWithTracking(SavingsActivity.class, p1));
            }
        }
    }

    /* renamed from: $r8$lambda$4-s8cLZLjczf5vArNTXbha4J7Iw */
    public static /* synthetic */ void m2883$r8$lambda$4s8cLZLjczf5vArNTXbha4J7Iw(SavingsActivity savingsActivity, View view) {
        Intrinsics.checkNotNullParameter(savingsActivity, "");
        savingsActivity.moveToNextValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x002f, code lost:
    
        if ((r4.getVisibility() == 0) == true) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x005a, code lost:
    
        if ((r4.getVisibility() == 0) == true) goto L91;
     */
    /* renamed from: $r8$lambda$8zAYG1C26k4ch0eg9xy-THj8-6I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void m2884$r8$lambda$8zAYG1C26k4ch0eg9xyTHj86I(boolean r4, id.dana.component.buttoncomponent.DanaButtonPrimaryView r5, androidx.core.widget.NestedScrollView r6, id.dana.savings.activity.SavingsActivity r7) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r1 = 0
            r2 = 1
            r3 = 8
            if (r4 == 0) goto L3c
            android.view.View r5 = (android.view.View) r5
            boolean r4 = r6.canScrollVertically(r2)
            if (r4 == 0) goto L32
            int r4 = id.dana.R.id.ll_empty_state
            android.view.View r4 = r7._$_findCachedViewById(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.view.View r4 = (android.view.View) r4
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L2e
            r4 = 1
            goto L2f
        L2e:
            r4 = 0
        L2f:
            if (r4 != r2) goto L32
            goto L33
        L32:
            r2 = 0
        L33:
            if (r2 == 0) goto L36
            goto L38
        L36:
            r1 = 8
        L38:
            r5.setVisibility(r1)
            return
        L3c:
            android.view.View r5 = (android.view.View) r5
            boolean r4 = r6.canScrollVertically(r2)
            if (r4 != 0) goto L5d
            int r4 = id.dana.R.id.ll_empty_state
            android.view.View r4 = r7._$_findCachedViewById(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.view.View r4 = (android.view.View) r4
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L59
            r4 = 1
            goto L5a
        L59:
            r4 = 0
        L5a:
            if (r4 != r2) goto L5d
            goto L5e
        L5d:
            r2 = 0
        L5e:
            if (r2 == 0) goto L61
            goto L63
        L61:
            r1 = 8
        L63:
            r5.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingsActivity.m2884$r8$lambda$8zAYG1C26k4ch0eg9xyTHj86I(boolean, id.dana.component.buttoncomponent.DanaButtonPrimaryView, androidx.core.widget.NestedScrollView, id.dana.savings.activity.SavingsActivity):void");
    }

    public static /* synthetic */ void $r8$lambda$CmmspWpVzAuMhg3m5JcIJxB5kgg(SavingsActivity savingsActivity, View view) {
        Intrinsics.checkNotNullParameter(savingsActivity, "");
        savingsActivity.moveToNextValue();
    }

    public static /* synthetic */ void $r8$lambda$JUNZp0RCO25UZqow67Diy9qepNE(SavingsActivity savingsActivity, View view) {
        Intrinsics.checkNotNullParameter(savingsActivity, "");
        savingsActivity.moveToNextValue();
    }

    /* renamed from: $r8$lambda$MzC1-zA_pX1WWq61p1IfSnc-qTs */
    public static /* synthetic */ void m2885$r8$lambda$MzC1zA_pX1WWq61p1IfSncqTs(SavingsActivity savingsActivity, int i) {
        MoneyViewModel moneyViewModel;
        Intrinsics.checkNotNullParameter(savingsActivity, "");
        SavingAdapter savingAdapter = savingsActivity.PlaceComponentResult;
        String str = null;
        if (savingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            savingAdapter = null;
        }
        SavingModel item = savingAdapter.getItem(i);
        if (item != null) {
            SavingDetailActivity.Companion companion = SavingDetailActivity.INSTANCE;
            SavingsActivity savingsActivity2 = savingsActivity;
            SavingSummaryModel savingSummaryModel = savingsActivity.scheduleImpl;
            String valueOf = String.valueOf(savingSummaryModel != null ? Long.valueOf(savingSummaryModel.getAuthRequestContext) : null);
            SavingSummaryModel savingSummaryModel2 = savingsActivity.scheduleImpl;
            if (savingSummaryModel2 != null && (moneyViewModel = savingSummaryModel2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                str = moneyViewModel.PlaceComponentResult;
            }
            SavingDetailActivity.Companion.BuiltInFictitiousFunctionClassFactory(savingsActivity2, item, valueOf, str);
        }
    }

    /* renamed from: $r8$lambda$Vp2R2Tj-TNFfjD4HMb_vvPJSJrQ */
    public static /* synthetic */ void m2886$r8$lambda$Vp2R2TjTNFfjD4HMb_vvPJSJrQ(SavingsActivity savingsActivity, View view) {
        Intrinsics.checkNotNullParameter(savingsActivity, "");
        savingsActivity.moveToNextValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x002f, code lost:
    
        if ((r4.getVisibility() == 0) == true) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x005a, code lost:
    
        if ((r4.getVisibility() == 0) == true) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void $r8$lambda$bpmRv9WF1iW0oUwb3n0CJdW6lYE(boolean r4, id.dana.component.buttoncomponent.DanaButtonSecondaryView r5, androidx.core.widget.NestedScrollView r6, id.dana.savings.activity.SavingsActivity r7) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r1 = 0
            r2 = 1
            r3 = 8
            if (r4 == 0) goto L3c
            android.view.View r5 = (android.view.View) r5
            boolean r4 = r6.canScrollVertically(r2)
            if (r4 == 0) goto L32
            int r4 = id.dana.R.id.cl_goal_list
            android.view.View r4 = r7._$_findCachedViewById(r4)
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.view.View r4 = (android.view.View) r4
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L2e
            r4 = 1
            goto L2f
        L2e:
            r4 = 0
        L2f:
            if (r4 != r2) goto L32
            goto L33
        L32:
            r2 = 0
        L33:
            if (r2 == 0) goto L36
            goto L38
        L36:
            r1 = 8
        L38:
            r5.setVisibility(r1)
            return
        L3c:
            android.view.View r5 = (android.view.View) r5
            boolean r4 = r6.canScrollVertically(r2)
            if (r4 != 0) goto L5d
            int r4 = id.dana.R.id.cl_goal_list
            android.view.View r4 = r7._$_findCachedViewById(r4)
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.view.View r4 = (android.view.View) r4
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L59
            r4 = 1
            goto L5a
        L59:
            r4 = 0
        L5a:
            if (r4 != r2) goto L5d
            goto L5e
        L5d:
            r2 = 0
        L5e:
            if (r2 == 0) goto L61
            goto L63
        L61:
            r1 = 8
        L63:
            r5.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.SavingsActivity.$r8$lambda$bpmRv9WF1iW0oUwb3n0CJdW6lYE(boolean, id.dana.component.buttoncomponent.DanaButtonSecondaryView, androidx.core.widget.NestedScrollView, id.dana.savings.activity.SavingsActivity):void");
    }

    /* renamed from: $r8$lambda$hnESY-02cVUVTrTgYFS_Tg65WAw */
    public static /* synthetic */ void m2887$r8$lambda$hnESY02cVUVTrTgYFS_Tg65WAw(SavingsActivity savingsActivity, View view) {
        Intrinsics.checkNotNullParameter(savingsActivity, "");
        CustomSnackbar customSnackbar = savingsActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customSnackbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            customSnackbar = null;
        }
        customSnackbar.dismiss();
    }

    /* renamed from: $r8$lambda$wK3XY-wkrsL78lR2ovGVBXbOn1Y */
    public static /* synthetic */ void m2888$r8$lambda$wK3XYwkrsL78lR2ovGVBXbOn1Y(SavingsActivity savingsActivity, SavingScreenState savingScreenState) {
        Intrinsics.checkNotNullParameter(savingsActivity, "");
        if (!savingScreenState.getKClassImpl$Data$declaredNonStaticMembers$2() && savingScreenState.getMyBillsEntityDataFactory() && savingScreenState.getGetAuthRequestContext()) {
            String source = savingsActivity.getSource();
            Intrinsics.checkNotNullExpressionValue(source, "");
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(savingsActivity);
            builder.MyBillsEntityDataFactory = TrackerKey.Event.SAVINGS_GOAL_OPEN;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", source);
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
            Object value = savingsActivity.getErrorConfigVersion.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "");
            Object obj = ((BehaviorSubject) value).getErrorConfigVersion.get();
            SavingScreenState savingScreenState2 = (SavingScreenState) ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj));
            if (savingScreenState2 != null) {
                Object value2 = savingsActivity.getErrorConfigVersion.getValue();
                Intrinsics.checkNotNullExpressionValue(value2, "");
                ((BehaviorSubject) value2).onNext(SavingScreenState.BuiltInFictitiousFunctionClassFactory(savingScreenState2, false, false, true, 3));
            }
        }
    }

    public static final /* synthetic */ BehaviorSubject access$getSavingScreenReadySubject(SavingsActivity savingsActivity) {
        Object value = savingsActivity.getErrorConfigVersion.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (BehaviorSubject) value;
    }

    public static final /* synthetic */ void access$openKycContainer(SavingsActivity savingsActivity) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(savingsActivity.getDynamicUrlWrapper().getKycFromGoalSavingUrl());
        DanaH5.startContainerFullUrl(sb.toString());
    }

    public static final /* synthetic */ void access$setEmptyState(SavingsActivity savingsActivity, SavingEmptyStateModel savingEmptyStateModel) {
        Context context;
        savingsActivity.getAuthRequestContext = savingEmptyStateModel;
        List<SavingBenefitModel> list = savingEmptyStateModel.KClassImpl$Data$declaredNonStaticMembers$2;
        SavingBenefitAdapter savingBenefitAdapter = savingsActivity.BuiltInFictitiousFunctionClassFactory;
        if (savingBenefitAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            savingBenefitAdapter = null;
        }
        savingBenefitAdapter.setItems(list);
        TextView textView = (TextView) savingsActivity._$_findCachedViewById(R.id.tv_empty_state_title);
        if (textView != null) {
            Context baseContext = savingsActivity.getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "");
            textView.setText(ResourceUtils.PlaceComponentResult(baseContext, savingEmptyStateModel.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, savingEmptyStateModel.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult));
        }
        TextView textView2 = (TextView) savingsActivity._$_findCachedViewById(R.id.tv_empty_state_desc);
        if (textView2 != null) {
            Context baseContext2 = savingsActivity.getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext2, "");
            textView2.setText(ResourceUtils.PlaceComponentResult(baseContext2, savingEmptyStateModel.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, savingEmptyStateModel.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext));
        }
        Context baseContext3 = savingsActivity.getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext3, "");
        int KClassImpl$Data$declaredNonStaticMembers$2 = ResourceUtils.KClassImpl$Data$declaredNonStaticMembers$2(baseContext3, savingEmptyStateModel.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory);
        if (KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
            ImageView imageView = (ImageView) savingsActivity._$_findCachedViewById(R.id.getCustomAttributesOrThrow);
            if (imageView == null || (context = imageView.getContext()) == null) {
                return;
            }
            GlideApp.getAuthRequestContext(context).PlaceComponentResult(Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2)).getErrorConfigVersion((int) R.drawable.ic_savings_empty).PlaceComponentResult((int) R.drawable.ic_savings_empty).MyBillsEntityDataFactory(imageView);
            return;
        }
        ImageView imageView2 = (ImageView) savingsActivity._$_findCachedViewById(R.id.getCustomAttributesOrThrow);
        if (imageView2 != null) {
            String str = savingEmptyStateModel.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
            Context context2 = imageView2.getContext();
            if (context2 != null) {
                GlideApp.getAuthRequestContext(context2).PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.ic_savings_empty).PlaceComponentResult((int) R.drawable.ic_savings_empty).MyBillsEntityDataFactory(imageView2);
            }
        }
    }

    public static final /* synthetic */ void access$setSavingSummary(SavingsActivity savingsActivity, SavingSummaryModel savingSummaryModel) {
        savingsActivity.scheduleImpl = savingSummaryModel;
        String cleanAll = NumberUtils.getCleanAll(savingSummaryModel.moveToNextValue.PlaceComponentResult);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        int parseInt = Integer.parseInt(cleanAll);
        TotalSavingAmountView totalSavingAmountView = (TotalSavingAmountView) savingsActivity._$_findCachedViewById(R.id.view_total_saving_amount);
        if (totalSavingAmountView != null) {
            totalSavingAmountView.setAmount(parseInt);
        }
        savingsActivity.getSavingConfigPresenter().getAuthRequestContext();
    }

    public static final /* synthetic */ void access$setSavings(SavingsActivity savingsActivity, List list) {
        MoneyViewModel moneyViewModel;
        SavingAdapter savingAdapter = savingsActivity.PlaceComponentResult;
        if (savingAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            savingAdapter = null;
        }
        savingAdapter.setItems(list);
        boolean isEmpty = list.isEmpty();
        LinearLayout linearLayout = (LinearLayout) savingsActivity._$_findCachedViewById(R.id.ll_empty_state);
        if (linearLayout != null) {
            linearLayout.setVisibility(isEmpty ? 0 : 8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) savingsActivity._$_findCachedViewById(R.id.cl_goal_list);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(isEmpty ^ true ? 0 : 8);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) savingsActivity._$_findCachedViewById(R.id.cl_goal_list);
        if (constraintLayout2 != null && constraintLayout2.getVisibility() == 0) {
            savingsActivity.setMenuRightButton(R.drawable.ic_tooltip_help);
            SavingSummaryModel savingSummaryModel = savingsActivity.scheduleImpl;
            if (savingSummaryModel != null && (moneyViewModel = savingSummaryModel.moveToNextValue) != null) {
                String cleanAll = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
                if (cleanAll == null) {
                    cleanAll = "0";
                }
                if (cleanAll != null) {
                    int parseInt = Integer.parseInt(cleanAll);
                    TotalSavingAmountView totalSavingAmountView = (TotalSavingAmountView) savingsActivity._$_findCachedViewById(R.id.view_total_saving_amount);
                    if (totalSavingAmountView != null) {
                        totalSavingAmountView.setAmount(parseInt);
                    }
                }
            }
            TotalSavingAmountView totalSavingAmountView2 = (TotalSavingAmountView) savingsActivity._$_findCachedViewById(R.id.view_total_saving_amount);
            if (totalSavingAmountView2 != null) {
                totalSavingAmountView2.setVisibility(0);
                return;
            }
            return;
        }
        View _$_findCachedViewById = savingsActivity._$_findCachedViewById(R.id.toolbar_layout);
        TextView textView = _$_findCachedViewById != null ? (TextView) _$_findCachedViewById.findViewById(R.id.getMinSeparation) : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TotalSavingAmountView totalSavingAmountView3 = (TotalSavingAmountView) savingsActivity._$_findCachedViewById(R.id.view_total_saving_amount);
        if (totalSavingAmountView3 != null) {
            totalSavingAmountView3.setVisibility(8);
        }
    }

    public static final /* synthetic */ void access$showErrorSnackbar(SavingsActivity savingsActivity, String str) {
        View findViewById = savingsActivity.getWindow().getDecorView().findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder((ViewGroup) findViewById);
        builder.initRecordTimeStamp = str;
        builder.lookAheadTest = savingsActivity.getString(R.string.pop_up_positive_button_saving_limit_info);
        builder.moveToNextValue = 0;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_orange;
        builder.MyBillsEntityDataFactory = R.drawable.bg_rectangle_tangerine;
        builder.scheduleImpl = new View.OnClickListener() { // from class: id.dana.savings.activity.SavingsActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SavingsActivity.m2887$r8$lambda$hnESY02cVUVTrTgYFS_Tg65WAw(SavingsActivity.this, view);
            }
        };
        CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        savingsActivity.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.show();
    }

    public static final /* synthetic */ void access$showUpgradeToKycDialog(SavingsActivity savingsActivity) {
        CustomDialog.Builder builder = new CustomDialog.Builder(savingsActivity);
        builder.SubSequence = savingsActivity.getString(R.string.saving_withdrawal_title_dialog);
        String string = savingsActivity.getString(R.string.pop_up_description_saving_limit_about_info_non_kyc);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Object[] objArr = new Object[3];
        SavingSummaryModel savingSummaryModel = savingsActivity.scheduleImpl;
        objArr[0] = savingSummaryModel != null ? savingSummaryModel.getErrorConfigVersion : null;
        SavingSummaryModel savingSummaryModel2 = savingsActivity.scheduleImpl;
        objArr[1] = savingSummaryModel2 != null ? savingSummaryModel2.PlaceComponentResult : null;
        SavingSummaryModel savingSummaryModel3 = savingsActivity.scheduleImpl;
        objArr[2] = savingSummaryModel3 != null ? savingSummaryModel3.BuiltInFictitiousFunctionClassFactory : null;
        String format = String.format(string, Arrays.copyOf(objArr, 3));
        Intrinsics.checkNotNullExpressionValue(format, "");
        builder.GetContactSyncConfig = format;
        builder.DatabaseTableConfigUtil = R.drawable.ic_premium_feature;
        builder.moveToNextValue = 0L;
        builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(savingsActivity.getString(R.string.saving_withdrawal_negative_dialog), new Function1<View, Unit>() { // from class: id.dana.savings.activity.SavingsActivity$showUpgradeToKycDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory(savingsActivity.getString(R.string.upgrade), new Function1<View, Unit>() { // from class: id.dana.savings.activity.SavingsActivity$showUpgradeToKycDialog$2
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
                SavingsActivity.access$openKycContainer(SavingsActivity.this);
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final /* synthetic */ void access$startSavingCreateActivity(SavingsActivity savingsActivity, SavingCreateInit savingCreateInit) {
        SavingSummaryModel savingSummaryModel = savingsActivity.scheduleImpl;
        SavingCreateInitModel KClassImpl$Data$declaredNonStaticMembers$2 = SavingCreateInitModelKt.KClassImpl$Data$declaredNonStaticMembers$2(savingCreateInit, String.valueOf(savingSummaryModel != null ? Long.valueOf(savingSummaryModel.getAuthRequestContext) : null));
        SavingCreateActivity.Companion companion = SavingCreateActivity.INSTANCE;
        SavingCreateActivity.Companion.BuiltInFictitiousFunctionClassFactory(savingsActivity, 2002, KClassImpl$Data$declaredNonStaticMembers$2);
        savingsActivity.setIntent(savingsActivity.getIntentClassWithTracking(SavingCreateActivity.class));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r17, int resultCode, Intent data) {
        SavingDetailModel savingDetailModel;
        SavingModel savingModel;
        if (-1 == resultCode && r17 == 2002) {
            if (data != null && (savingModel = (SavingModel) data.getParcelableExtra(SavingCreateActivity.EXTRA_CREATED_SAVING)) != null) {
                String string = getResources().getString(R.string.toast_create_saving_goal_success);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String format = String.format(string, Arrays.copyOf(new Object[]{savingModel.NetworkUserEntityData$$ExternalSyntheticLambda2}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                CustomToastUtil.PlaceComponentResult(this, R.drawable.ic_success, R.drawable.bg_rounded_toast_success, format, 48, 60, true, null, 256);
            }
        } else if (1002 == resultCode && r17 == 2003 && data != null && (savingDetailModel = (SavingDetailModel) data.getParcelableExtra(SavingDetailActivity.EXTRA_REVOKED_SAVING)) != null) {
            CustomToastUtil customToastUtil = CustomToastUtil.MyBillsEntityDataFactory;
            SavingModel savingModel2 = savingDetailModel.BuiltInFictitiousFunctionClassFactory;
            String string2 = getResources().getString(R.string.toast_revoke_saving_goal_success);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{savingModel2.NetworkUserEntityData$$ExternalSyntheticLambda2}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "");
            CustomToastUtil.BuiltInFictitiousFunctionClassFactory(this, format2);
        }
        super.onActivityResult(r17, resultCode, data);
    }

    private static void h(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (PrepareContext ^ 4796183387843776835L);
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
