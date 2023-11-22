package id.dana.danapoly.ui.board;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.FlowExtKt;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContract;
import androidx.view.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import com.afollestad.materialdialogs.MaterialDialog;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_content_DialogInterface_OnDismissListener$0;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.FragmentDanapolyBinding;
import id.dana.danapoly.databinding.ViewDanapolyPointInfoBinding;
import id.dana.danapoly.di.component.DanapolyComponent;
import id.dana.danapoly.di.provider.DanapolyComponentProvider;
import id.dana.danapoly.domain.config.model.PlayBoard;
import id.dana.danapoly.ui.board.DanapolyNoEventActivity;
import id.dana.danapoly.ui.board.view.DanapolyBoardView;
import id.dana.danapoly.ui.board.view.DanapolyPromptInfoView;
import id.dana.danapoly.ui.board.viewmodel.DanapolyBoardUiState;
import id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel;
import id.dana.danapoly.ui.dailycheck.DailyCheckActivity;
import id.dana.danapoly.ui.enums.RewardType;
import id.dana.danapoly.ui.enums.RewardTypeKt;
import id.dana.danapoly.ui.leaderboard.DanapolyCustomDialog;
import id.dana.danapoly.ui.model.BackgroundColorType;
import id.dana.danapoly.ui.model.PlayerInfoModel;
import id.dana.danapoly.ui.model.mapper.PlayBoardModelMapperKt;
import id.dana.danapoly.ui.model.play.LocalizationModel;
import id.dana.danapoly.ui.model.play.PlayModel;
import id.dana.danapoly.ui.model.play.RollDiceModel;
import id.dana.danapoly.ui.tracker.DanapolyAnalyticTracker;
import id.dana.data.util.UrlUtil;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.network.util.DanaDeeplinkHelper;
import id.dana.network.util.DanaH5Helper;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b7\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0004\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u0012\u0010&\u001a\u00020#X\u0086\"¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u000f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010\u001d\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0012\u00100\u001a\u00020/X\u0087\"¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010$\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0012\u00105\u001a\u000204X\u0087\"¢\u0006\u0006\n\u0004\b5\u00106"}, d2 = {"Lid/dana/danapoly/ui/board/DanapolyBoardFragment;", "Lid/dana/danapoly/ui/board/BaseDanapolyAudioFragment;", "Lid/dana/danapoly/databinding/FragmentDanapolyBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)I", "FragmentBottomSheetPaymentSettingBinding", "Landroid/content/Context;", "onAttach", "(Landroid/content/Context;)V", "lookAheadTest", "", "p1", "(ZZ)V", "Lid/dana/danapoly/ui/model/PlayerInfoModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/danapoly/ui/model/PlayerInfoModel;)V", "Lid/dana/danapoly/ui/board/DanapolyBoardListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/danapoly/ui/board/DanapolyBoardListener;", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardViewModel;", "moveToNextValue", "Lkotlin/Lazy;", "Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog;", "getErrorConfigVersion", "Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResultLauncher;", "getAuthRequestContext", "Lid/dana/danapoly/di/component/DanapolyComponent;", "scheduleImpl", "Lid/dana/danapoly/di/component/DanapolyComponent;", "PlaceComponentResult", "DatabaseTableConfigUtil", "Z", "GetContactSyncConfig", "Lcom/afollestad/materialdialogs/MaterialDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lcom/afollestad/materialdialogs/MaterialDialog;", "initRecordTimeStamp", "Lid/dana/danapoly/ui/model/PlayerInfoModel;", "Lid/dana/danapoly/ui/tracker/DanapolyAnalyticTracker;", "tracker", "Lid/dana/danapoly/ui/tracker/DanapolyAnalyticTracker;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/Integer;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyBoardFragment extends BaseDanapolyAudioFragment<FragmentDanapolyBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private DanapolyBoardListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Integer scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private MaterialDialog getErrorConfigVersion;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private DanapolyCustomDialog MyBillsEntityDataFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private PlayerInfoModel moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public DanapolyComponent PlaceComponentResult;
    @Inject
    public DanapolyAnalyticTracker tracker;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ ViewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentDanapolyBinding PlaceComponentResult = FragmentDanapolyBinding.PlaceComponentResult(getLayoutInflater(), viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, boolean p1) {
        DanapolyBoardListener danapolyBoardListener = this.BuiltInFictitiousFunctionClassFactory;
        if (danapolyBoardListener != null) {
            danapolyBoardListener.enableBoardInteraction(p0);
        }
        DanapolyBoardListener danapolyBoardListener2 = this.BuiltInFictitiousFunctionClassFactory;
        if (danapolyBoardListener2 != null) {
            danapolyBoardListener2.enableDice(p1);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private static int MyBillsEntityDataFactory(String p0) {
        try {
            return RewardTypeKt.BuiltInFictitiousFunctionClassFactory(RewardType.valueOf(p0));
        } catch (Exception unused) {
            return RewardTypeKt.BuiltInFictitiousFunctionClassFactory(RewardType.DEFAULT);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        if (p0 instanceof DanapolyBoardListener) {
            this.BuiltInFictitiousFunctionClassFactory = (DanapolyBoardListener) p0;
        }
    }

    public DanapolyBoardFragment() {
        final DanapolyBoardFragment danapolyBoardFragment = this;
        final Function0 function0 = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(danapolyBoardFragment, Reflection.getOrCreateKotlinClass(DanapolyBoardViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = Fragment.this.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = danapolyBoardFragment.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$boardViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = DanapolyBoardFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DanapolyBoardFragment danapolyBoardFragment) {
        Intrinsics.checkNotNullParameter(danapolyBoardFragment, "");
        FragmentActivity activity = danapolyBoardFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(DanapolyBoardFragment danapolyBoardFragment) {
        Intrinsics.checkNotNullParameter(danapolyBoardFragment, "");
        DanapolyCustomDialog danapolyCustomDialog = danapolyBoardFragment.MyBillsEntityDataFactory;
        if (danapolyCustomDialog != null) {
            danapolyCustomDialog.PlaceComponentResult();
        }
    }

    public static /* synthetic */ void getAuthRequestContext(DanapolyBoardFragment danapolyBoardFragment, PlayModel playModel) {
        Intrinsics.checkNotNullParameter(danapolyBoardFragment, "");
        Intrinsics.checkNotNullParameter(playModel, "");
        if (Intrinsics.areEqual(playModel.getRedirectLink(), "ROLL_DICE")) {
            DanapolyBoardListener danapolyBoardListener = danapolyBoardFragment.BuiltInFictitiousFunctionClassFactory;
            if (danapolyBoardListener != null) {
                danapolyBoardListener.onClickRollDicePopupAction();
            }
        } else {
            if (playModel.getRedirectLink().length() > 0) {
                String redirectLink = playModel.getRedirectLink();
                Context context = danapolyBoardFragment.getContext();
                if (context != null) {
                    if (UrlUtil.isDeepLink(redirectLink)) {
                        DanaDeeplinkHelper.INSTANCE.openUrl(context, redirectLink, "DANAPoly");
                    } else {
                        DanaH5Helper.INSTANCE.openUrl(context, redirectLink);
                    }
                }
            }
        }
        DanapolyCustomDialog danapolyCustomDialog = danapolyBoardFragment.MyBillsEntityDataFactory;
        if (danapolyCustomDialog != null) {
            danapolyCustomDialog.PlaceComponentResult();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(DanapolyBoardFragment danapolyBoardFragment, AppCompatImageView appCompatImageView) {
        Intrinsics.checkNotNullParameter(danapolyBoardFragment, "");
        Intrinsics.checkNotNullParameter(appCompatImageView, "");
        VB vb = danapolyBoardFragment.PlaceComponentResult;
        if (vb != 0) {
            if (((FragmentDanapolyBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1.isClickable()) {
                return;
            }
            DanaH5Helper danaH5Helper = DanaH5Helper.INSTANCE;
            Context context = appCompatImageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            danaH5Helper.openUrl(context, DanapolyNoEventActivity.DANAPOLY_TNC_PAGE_URL);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DanapolyBoardFragment danapolyBoardFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(danapolyBoardFragment, "");
        Intrinsics.checkNotNullExpressionValue(bool, "");
        if (bool.booleanValue()) {
            ((DanapolyBoardViewModel) danapolyBoardFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).PlaceComponentResult();
            ((DanapolyBoardViewModel) danapolyBoardFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getAuthRequestContext();
        }
    }

    public static /* synthetic */ void getAuthRequestContext(DanapolyBoardFragment danapolyBoardFragment) {
        Intrinsics.checkNotNullParameter(danapolyBoardFragment, "");
        Context context = danapolyBoardFragment.getContext();
        if (context != null) {
            FragmentActivity activity = danapolyBoardFragment.getActivity();
            if (activity != null) {
                ((DanapolyBoardTabActivity) activity).setNeedStopMusicBackground(false);
                ActivityResultLauncher<Intent> activityResultLauncher = danapolyBoardFragment.getAuthRequestContext;
                if (activityResultLauncher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    activityResultLauncher = null;
                }
                DailyCheckActivity.Companion companion = DailyCheckActivity.INSTANCE;
                PlayerInfoModel playerInfoModel = danapolyBoardFragment.moveToNextValue;
                activityResultLauncher.MyBillsEntityDataFactory(DailyCheckActivity.Companion.BuiltInFictitiousFunctionClassFactory(context, playerInfoModel != null ? playerInfoModel.getDanaPoint() : 0), null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.ui.board.DanapolyBoardTabActivity");
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(DanapolyBoardFragment danapolyBoardFragment) {
        Intrinsics.checkNotNullParameter(danapolyBoardFragment, "");
        VB vb = danapolyBoardFragment.PlaceComponentResult;
        if (vb != 0) {
            DanapolyBoardView danapolyBoardView = ((FragmentDanapolyBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(danapolyBoardView, "");
            DanapolyBoardView.checkAndStartPawnMovement$default(danapolyBoardView, false, 1, null);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void getAuthRequestContext(DanapolyBoardFragment danapolyBoardFragment, int i) {
        PlayerInfoModel playerInfoModel = danapolyBoardFragment.moveToNextValue;
        if (playerInfoModel != null) {
            playerInfoModel.setDanaPoint(i);
            danapolyBoardFragment.BuiltInFictitiousFunctionClassFactory(playerInfoModel);
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DanapolyBoardFragment danapolyBoardFragment) {
        VB vb = danapolyBoardFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentDanapolyBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1.setClickable(false);
            danapolyBoardFragment.KClassImpl$Data$declaredNonStaticMembers$2(true, true);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ DanapolyBoardViewModel moveToNextValue(DanapolyBoardFragment danapolyBoardFragment) {
        return (DanapolyBoardViewModel) danapolyBoardFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ DanapolyBoardTabActivity NetworkUserEntityData$$ExternalSyntheticLambda0(DanapolyBoardFragment danapolyBoardFragment) {
        FragmentActivity activity = danapolyBoardFragment.getActivity();
        if (activity != null) {
            return (DanapolyBoardTabActivity) activity;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.ui.board.DanapolyBoardTabActivity");
    }

    public static final /* synthetic */ void getAuthRequestContext(DanapolyBoardFragment danapolyBoardFragment, String str) {
        FragmentActivity activity = danapolyBoardFragment.getActivity();
        if (activity != null) {
            DanapolyNoEventActivity.Companion companion = DanapolyNoEventActivity.INSTANCE;
            DanapolyNoEventActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(activity, str);
            activity.finish();
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda1(DanapolyBoardFragment danapolyBoardFragment) {
        PlayerInfoModel playerInfoModel = danapolyBoardFragment.moveToNextValue;
        if (playerInfoModel != null) {
            if (playerInfoModel != null) {
                VB vb = danapolyBoardFragment.PlaceComponentResult;
                if (vb != 0) {
                    ((FragmentDanapolyBinding) vb).BuiltInFictitiousFunctionClassFactory.setInitialPosition(playerInfoModel.getPosition());
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            danapolyBoardFragment.BuiltInFictitiousFunctionClassFactory(playerInfoModel);
            String avatarUrl = playerInfoModel.getAvatarUrl();
            Context context = danapolyBoardFragment.getContext();
            if (context != null) {
                VB vb2 = danapolyBoardFragment.PlaceComponentResult;
                if (vb2 != 0) {
                    GlideApp.getAuthRequestContext(context).PlaceComponentResult(avatarUrl).getErrorConfigVersion(R.drawable.ic_default_avatar_square).PlaceComponentResult(R.drawable.ic_default_avatar_square).MyBillsEntityDataFactory((ImageView) ((FragmentDanapolyBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory);
                    VB vb3 = danapolyBoardFragment.PlaceComponentResult;
                    if (vb3 != 0) {
                        ((FragmentDanapolyBinding) vb3).BuiltInFictitiousFunctionClassFactory.loadPawn(avatarUrl);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final DanapolyBoardFragment danapolyBoardFragment, final PlayModel playModel) {
        DanapolyCustomDialog.DialogType dialogType;
        String string;
        DanapolyCustomDialog danapolyCustomDialog;
        Context context = danapolyBoardFragment.getContext();
        if (context != null) {
            DanapolyCustomDialog danapolyCustomDialog2 = danapolyBoardFragment.MyBillsEntityDataFactory;
            if ((danapolyCustomDialog2 != null && danapolyCustomDialog2.NetworkUserEntityData$$ExternalSyntheticLambda0()) && (danapolyCustomDialog = danapolyBoardFragment.MyBillsEntityDataFactory) != null) {
                danapolyCustomDialog.PlaceComponentResult();
            }
            if (playModel.getHasPrize()) {
                dialogType = DanapolyCustomDialog.DialogType.RIBBON;
            } else {
                dialogType = DanapolyCustomDialog.DialogType.DEFAULT;
            }
            DanapolyCustomDialog.Builder PlaceComponentResult = new DanapolyCustomDialog.Builder(context, dialogType).PlaceComponentResult(false, false);
            String imageUrl = playModel.getImageUrl();
            int MyBillsEntityDataFactory = MyBillsEntityDataFactory(playModel.getRewardType());
            Intrinsics.checkNotNullParameter(imageUrl, "");
            PlaceComponentResult.getAuthRequestContext = imageUrl;
            PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory;
            PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2 = LocalizationModel.INSTANCE.localized(playModel.getTitle());
            PlaceComponentResult.getErrorConfigVersion = LocalizationModel.INSTANCE.localized(playModel.getSubtitle());
            String localized = LocalizationModel.INSTANCE.localized(playModel.getActionButton());
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanapolyBoardFragment.getAuthRequestContext(DanapolyBoardFragment.this, playModel);
                }
            };
            Intrinsics.checkNotNullParameter(localized, "");
            PlaceComponentResult.scheduleImpl = localized;
            PlaceComponentResult.initRecordTimeStamp = onClickListener;
            if (playModel.getRedirectLink().length() > 0) {
                if (Intrinsics.areEqual(playModel.getRewardType(), RewardType.DARE.name())) {
                    string = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getString(R.string.res_0x7f130439_networkuserentitydata_externalsyntheticlambda0);
                } else {
                    string = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.getString(R.string.card_popup_action_close);
                }
                View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DanapolyBoardFragment.PlaceComponentResult(DanapolyBoardFragment.this);
                    }
                };
                PlaceComponentResult.lookAheadTest = string;
                PlaceComponentResult.moveToNextValue = onClickListener2;
            }
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = new DialogInterface.OnDismissListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    DanapolyBoardFragment.MyBillsEntityDataFactory(DanapolyBoardFragment.this);
                }
            };
            DanapolyCustomDialog danapolyCustomDialog3 = new DanapolyCustomDialog(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult, PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, null);
            danapolyBoardFragment.MyBillsEntityDataFactory = danapolyCustomDialog3;
            danapolyCustomDialog3.moveToNextValue();
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(DanapolyBoardFragment danapolyBoardFragment, boolean z) {
        VB vb = danapolyBoardFragment.PlaceComponentResult;
        if (vb != 0) {
            AppCompatImageView appCompatImageView = ((FragmentDanapolyBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(z ? 0 : 8);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DanapolyBoardFragment danapolyBoardFragment, RollDiceModel rollDiceModel) {
        VB vb = danapolyBoardFragment.PlaceComponentResult;
        if (vb != 0) {
            DanapolyBoardView danapolyBoardView = ((FragmentDanapolyBinding) vb).BuiltInFictitiousFunctionClassFactory;
            danapolyBoardView.setPawnPlayModels(rollDiceModel.getResults());
            danapolyBoardView.checkAndStartPawnMovement(true);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DanapolyBoardFragment danapolyBoardFragment, final Function0 function0) {
        Integer num = danapolyBoardFragment.scheduleImpl;
        Unit unit = null;
        if (num != null) {
            int intValue = num.intValue();
            VB vb = danapolyBoardFragment.PlaceComponentResult;
            if (vb != 0) {
                if (((FragmentDanapolyBinding) vb).BuiltInFictitiousFunctionClassFactory.isMovementQueueEmpty()) {
                    danapolyBoardFragment.BuiltInFictitiousFunctionClassFactory();
                    FragmentActivity activity = danapolyBoardFragment.getActivity();
                    if (activity != null) {
                        ((DanapolyBoardTabActivity) activity).showLapCount(intValue, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$showLapCount$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                function0.invoke();
                            }
                        });
                        danapolyBoardFragment.scheduleImpl = null;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.ui.board.DanapolyBoardTabActivity");
                    }
                } else {
                    function0.invoke();
                }
                unit = Unit.INSTANCE;
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        if (unit == null) {
            function0.invoke();
        }
    }

    public static final /* synthetic */ void GetContactSyncConfig(final DanapolyBoardFragment danapolyBoardFragment) {
        MaterialDialog materialDialog;
        final Context context = danapolyBoardFragment.getContext();
        if (context != null) {
            MaterialDialog materialDialog2 = danapolyBoardFragment.getErrorConfigVersion;
            if ((materialDialog2 != null && materialDialog2.isShowing()) && (materialDialog = danapolyBoardFragment.getErrorConfigVersion) != null) {
                materialDialog.dismiss();
            }
            CustomDialog.Builder builder = new CustomDialog.Builder(context);
            builder.getCallingPid = R.layout.view_out_of_dice_popup;
            builder.SubSequence = danapolyBoardFragment.getString(R.string.getValueOfTouchPositionAbsolute);
            builder.GetContactSyncConfig = danapolyBoardFragment.getString(R.string.res_0x7f1310c0_bottomsheetcardbindingview_watchercardnumberview_1);
            builder.DatabaseTableConfigUtil = R.drawable.ic_out_of_dice;
            CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2(danapolyBoardFragment.getString(R.string.res_0x7f1310c1_verifypinstatemanager_executeriskchallenge_2_1), new Function1<View, Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$showOutOfDiceAlert$1$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }
            }).BuiltInFictitiousFunctionClassFactory(danapolyBoardFragment.getString(R.string.out_of_dice_error_positive), new Function1<View, Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$showOutOfDiceAlert$1$2
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
                    Intrinsics.checkNotNullParameter(view, "");
                    DanaH5Helper danaH5Helper = DanaH5Helper.INSTANCE;
                    Context context2 = context;
                    Intrinsics.checkNotNullExpressionValue(context2, "");
                    danaH5Helper.openUrl(context2, "https://m.dana.id/n/dana-promotion/points/howto");
                }
            });
            Function1<DialogInterface, Unit> function1 = new Function1<DialogInterface, Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$showOutOfDiceAlert$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface) {
                    invoke2(dialogInterface);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DialogInterface dialogInterface) {
                    Intrinsics.checkNotNullParameter(dialogInterface, "");
                    DanapolyBoardFragment.BuiltInFictitiousFunctionClassFactory(DanapolyBoardFragment.this);
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = new CustomDialog$sam$android_content_DialogInterface_OnDismissListener$0(function1);
            MaterialDialog BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            danapolyBoardFragment.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory2;
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                BuiltInFictitiousFunctionClassFactory2.show();
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(DanapolyBoardFragment danapolyBoardFragment, RollDiceModel rollDiceModel) {
        for (PlayModel playModel : rollDiceModel.getResults()) {
            DanapolyAnalyticTracker danapolyAnalyticTracker = danapolyBoardFragment.tracker;
            if (danapolyAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                danapolyAnalyticTracker = null;
            }
            danapolyAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(Integer.parseInt(playModel.getRandomResult()), playModel.getRewardType());
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(PlayerInfoModel p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ViewDanapolyPointInfoBinding viewDanapolyPointInfoBinding = ((FragmentDanapolyBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda2;
            viewDanapolyPointInfoBinding.scheduleImpl.setText(String.valueOf(p0.getDanaPoint()));
            viewDanapolyPointInfoBinding.lookAheadTest.setText(p0.calculateDiceCount());
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            Toolbar toolbar = ((FragmentDanapolyBinding) vb).getErrorConfigVersion.DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(toolbar, "");
            getAuthRequestContext(toolbar);
            Toolbar valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
            Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(valueOfTouchPositionAbsolute.getContext(), R.drawable.KClassImpl$Data$declaredNonStaticMembers$2);
            valueOfTouchPositionAbsolute.setContentDescription(getString(R.string.KClassImpl$Data$declaredNonStaticMembers$2));
            valueOfTouchPositionAbsolute.setNavigationIcon(PlaceComponentResult);
            valueOfTouchPositionAbsolute.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanapolyBoardFragment.KClassImpl$Data$declaredNonStaticMembers$2(DanapolyBoardFragment.this);
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentDanapolyBinding) vb2).getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(R.string.FragmentBottomSheetPaymentSettingBinding_res_0x7f1305a0));
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    final AppCompatImageView appCompatImageView = ((FragmentDanapolyBinding) vb3).getErrorConfigVersion.getErrorConfigVersion;
                    appCompatImageView.setVisibility(0);
                    int i = R.drawable.ic_info;
                    if (appCompatImageView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                    } else {
                        appCompatImageView.setImageResource(i);
                    }
                    appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DanapolyBoardFragment.PlaceComponentResult(DanapolyBoardFragment.this, appCompatImageView);
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.di.provider.DanapolyComponentProvider");
        }
        DanapolyComponent MyBillsEntityDataFactory = ((DanapolyComponentProvider) applicationContext).provideDanapolyComponent().MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        this.PlaceComponentResult = MyBillsEntityDataFactory;
        if (MyBillsEntityDataFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            MyBillsEntityDataFactory = null;
        }
        MyBillsEntityDataFactory.getAuthRequestContext(this);
        KClassImpl$Data$declaredNonStaticMembers$2();
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContract<Intent, Boolean>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$initDailyCheckActivityResultLauncher$1
            @Override // androidx.view.result.contract.ActivityResultContract
            public final /* synthetic */ Intent createIntent(Context context, Intent intent) {
                Intent intent2 = intent;
                Intrinsics.checkNotNullParameter(context, "");
                Intrinsics.checkNotNullParameter(intent2, "");
                return intent2;
            }

            @Override // androidx.view.result.contract.ActivityResultContract
            public final /* synthetic */ Boolean parseResult(int i, Intent intent) {
                Bundle extras;
                boolean z = false;
                if (i == -1 && intent != null && (extras = intent.getExtras()) != null) {
                    z = extras.getBoolean(DailyCheckActivity.BUNDLE_SHOULD_REFRESH_CHECK_IN);
                }
                return Boolean.valueOf(z);
            }
        }, new ActivityResultCallback() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$$ExternalSyntheticLambda5
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                DanapolyBoardFragment.BuiltInFictitiousFunctionClassFactory(DanapolyBoardFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.getAuthRequestContext = registerForActivityResult;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentDanapolyBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult.setAnimation("json/lottie/danapoly_point_animation.lottie");
            StateFlow<DanapolyBoardUiState> stateFlow = ((DanapolyBoardViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda2;
            Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "");
            Flow onEach = FlowKt.onEach(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle), new DanapolyBoardFragment$initViewModel$1(this, null));
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
            FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentDanapolyBinding) vb2).moveToNextValue.setOnChangeColor(new Function1<BackgroundColorType, Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$setupChangeBackgroundColor$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(BackgroundColorType backgroundColorType) {
                        invoke2(backgroundColorType);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(BackgroundColorType backgroundColorType) {
                        Intrinsics.checkNotNullParameter(backgroundColorType, "");
                        DanapolyBoardViewModel moveToNextValue = DanapolyBoardFragment.moveToNextValue(DanapolyBoardFragment.this);
                        Intrinsics.checkNotNullParameter(backgroundColorType, "");
                        moveToNextValue.lookAheadTest = backgroundColorType;
                        moveToNextValue.moveToNextValue.execute(backgroundColorType, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$saveLastBackgroundColor$1
                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        }, new Function1<Boolean, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$saveLastBackgroundColor$2
                            public final void invoke(boolean z) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$saveLastBackgroundColor$3
                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                Intrinsics.checkNotNullParameter(th, "");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }
                        }, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$saveLastBackgroundColor$4
                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        }, ViewModelKt.PlaceComponentResult(moveToNextValue));
                        VB vb3 = DanapolyBoardFragment.this.PlaceComponentResult;
                        if (vb3 != 0) {
                            ((FragmentDanapolyBinding) vb3).BuiltInFictitiousFunctionClassFactory.changeColor(backgroundColorType);
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentDanapolyBinding) vb3).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DanapolyBoardFragment.getAuthRequestContext(DanapolyBoardFragment.this);
                        }
                    });
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentDanapolyBinding) vb4).BuiltInFictitiousFunctionClassFactory.setActionTryAgain(new Function1<DanapolyBoardView.BoardState, Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$setupTryAgainButton$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(DanapolyBoardView.BoardState boardState) {
                                invoke2(boardState);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(DanapolyBoardView.BoardState boardState) {
                                PlayerInfoModel playerInfoModel;
                                DanapolyBoardListener danapolyBoardListener;
                                Intrinsics.checkNotNullParameter(boardState, "");
                                if (boardState != DanapolyBoardView.BoardState.ERROR_ROLL_DICE) {
                                    final DanapolyBoardViewModel moveToNextValue = DanapolyBoardFragment.moveToNextValue(DanapolyBoardFragment.this);
                                    final boolean z = true;
                                    BaseFlowUseCase.execute$default(moveToNextValue.MyBillsEntityDataFactory, NoParams.INSTANCE, null, new Function1<PlayBoard, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getPlayBoard$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(PlayBoard playBoard) {
                                            invoke2(playBoard);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(PlayBoard playBoard) {
                                            MutableStateFlow mutableStateFlow;
                                            Object value;
                                            Intrinsics.checkNotNullParameter(playBoard, "");
                                            if (playBoard.getEventId().length() == 0) {
                                                mutableStateFlow = DanapolyBoardViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                                do {
                                                    value = mutableStateFlow.getValue();
                                                    DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) value;
                                                } while (!mutableStateFlow.compareAndSet(value, new DanapolyBoardUiState.OnEventNotExist(playBoard.getLastActiveEventId())));
                                                return;
                                            }
                                            DanapolyBoardViewModel.this.MyBillsEntityDataFactory(PlayBoardModelMapperKt.toPlayBoardModel(playBoard), z);
                                        }
                                    }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getPlayBoard$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            Intrinsics.checkNotNullParameter(th, "");
                                            DanapolyBoardViewModel.this.MyBillsEntityDataFactory(null, z);
                                        }
                                    }, null, ViewModelKt.PlaceComponentResult(moveToNextValue), 18, null);
                                    playerInfoModel = DanapolyBoardFragment.this.moveToNextValue;
                                    if (playerInfoModel == null) {
                                        DanapolyBoardFragment.moveToNextValue(DanapolyBoardFragment.this).getAuthRequestContext();
                                        return;
                                    }
                                    return;
                                }
                                VB vb5 = DanapolyBoardFragment.this.PlaceComponentResult;
                                if (vb5 != 0) {
                                    DanapolyBoardView danapolyBoardView = ((FragmentDanapolyBinding) vb5).BuiltInFictitiousFunctionClassFactory;
                                    Intrinsics.checkNotNullExpressionValue(danapolyBoardView, "");
                                    DanapolyBoardView.renderErrorState$default(danapolyBoardView, false, null, 2, null);
                                    danapolyBoardListener = DanapolyBoardFragment.this.BuiltInFictitiousFunctionClassFactory;
                                    if (danapolyBoardListener != null) {
                                        danapolyBoardListener.onClickRollDicePopupAction();
                                        return;
                                    }
                                    return;
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        });
                        VB vb5 = this.PlaceComponentResult;
                        if (vb5 != 0) {
                            ((FragmentDanapolyBinding) vb5).scheduleImpl.setOnCloseIconClicked(new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$setupBoardTooltipInfoListener$1
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
                                    VB vb6 = DanapolyBoardFragment.this.PlaceComponentResult;
                                    if (vb6 != 0) {
                                        DanapolyPromptInfoView danapolyPromptInfoView = ((FragmentDanapolyBinding) vb6).scheduleImpl;
                                        Intrinsics.checkNotNullExpressionValue(danapolyPromptInfoView, "");
                                        ViewExtKt.PlaceComponentResult(danapolyPromptInfoView, 8);
                                        return;
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            });
                            VB vb6 = this.PlaceComponentResult;
                            if (vb6 != 0) {
                                ((FragmentDanapolyBinding) vb6).BuiltInFictitiousFunctionClassFactory.setOnPawnStopMoving(new Function1<PlayModel, Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$setupBoardViewListener$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(PlayModel playModel) {
                                        invoke2(playModel);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(final PlayModel playModel) {
                                        Intrinsics.checkNotNullParameter(playModel, "");
                                        DanapolyBoardFragment danapolyBoardFragment = DanapolyBoardFragment.this;
                                        final DanapolyBoardFragment danapolyBoardFragment2 = DanapolyBoardFragment.this;
                                        DanapolyBoardFragment.KClassImpl$Data$declaredNonStaticMembers$2(danapolyBoardFragment, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$setupBoardViewListener$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                if (Intrinsics.areEqual(PlayModel.this.getRewardType(), RewardType.START.name()) || Intrinsics.areEqual(PlayModel.this.getRewardType(), RewardType.STOP.name())) {
                                                    DanapolyBoardFragment.BuiltInFictitiousFunctionClassFactory(danapolyBoardFragment2);
                                                } else {
                                                    DanapolyBoardFragment.MyBillsEntityDataFactory(danapolyBoardFragment2, PlayModel.this);
                                                }
                                            }
                                        });
                                    }
                                });
                                VB vb7 = this.PlaceComponentResult;
                                if (vb7 != 0) {
                                    ((FragmentDanapolyBinding) vb7).BuiltInFictitiousFunctionClassFactory.setOnAllDiceMovementDone(new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$setupBoardViewListener$2
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
                                            boolean z;
                                            z = DanapolyBoardFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                            if (z) {
                                                return;
                                            }
                                            DanapolyBoardFragment.BuiltInFictitiousFunctionClassFactory(DanapolyBoardFragment.this);
                                        }
                                    });
                                    VB vb8 = this.PlaceComponentResult;
                                    if (vb8 != 0) {
                                        ((FragmentDanapolyBinding) vb8).BuiltInFictitiousFunctionClassFactory.setOnBoardAnimationFinished(new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$setupBoardViewListener$3
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
                                                PlayerInfoModel playerInfoModel;
                                                VB vb9 = DanapolyBoardFragment.this.PlaceComponentResult;
                                                if (vb9 != 0) {
                                                    if (!((FragmentDanapolyBinding) vb9).BuiltInFictitiousFunctionClassFactory.isErrorStateShown()) {
                                                        playerInfoModel = DanapolyBoardFragment.this.moveToNextValue;
                                                        if (playerInfoModel != null) {
                                                            DanapolyBoardFragment.BuiltInFictitiousFunctionClassFactory(DanapolyBoardFragment.this);
                                                        }
                                                    }
                                                    BackgroundColorType backgroundColorType = DanapolyBoardFragment.moveToNextValue(DanapolyBoardFragment.this).lookAheadTest;
                                                    if (backgroundColorType != null) {
                                                        VB vb10 = DanapolyBoardFragment.this.PlaceComponentResult;
                                                        if (vb10 != 0) {
                                                            ((FragmentDanapolyBinding) vb10).moveToNextValue.setSelectedColor(backgroundColorType);
                                                            return;
                                                        }
                                                        throw new IllegalArgumentException("Required value was null.".toString());
                                                    }
                                                    return;
                                                }
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                        });
                                        PlaceComponentResult();
                                        final DanapolyBoardViewModel danapolyBoardViewModel = (DanapolyBoardViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
                                        danapolyBoardViewModel.getAuthRequestContext.execute(NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getLastBackgroundColor$1
                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }
                                        }, new Function1<BackgroundColorType, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getLastBackgroundColor$2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(BackgroundColorType backgroundColorType) {
                                                invoke2(backgroundColorType);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2(BackgroundColorType backgroundColorType) {
                                                MutableStateFlow mutableStateFlow;
                                                Object value;
                                                Intrinsics.checkNotNullParameter(backgroundColorType, "");
                                                mutableStateFlow = DanapolyBoardViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                                do {
                                                    value = mutableStateFlow.getValue();
                                                    DanapolyBoardUiState danapolyBoardUiState = (DanapolyBoardUiState) value;
                                                } while (!mutableStateFlow.compareAndSet(value, new DanapolyBoardUiState.OnGetLastBackgroundColor(backgroundColorType)));
                                                DanapolyBoardViewModel.this.lookAheadTest = backgroundColorType;
                                            }
                                        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getLastBackgroundColor$3
                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2(Throwable th) {
                                                Intrinsics.checkNotNullParameter(th, "");
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                                invoke2(th);
                                                return Unit.INSTANCE;
                                            }
                                        }, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel$getLastBackgroundColor$4
                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }
                                        }, ViewModelKt.PlaceComponentResult(danapolyBoardViewModel));
                                        ((DanapolyBoardViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getAuthRequestContext();
                                        ((DanapolyBoardViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).PlaceComponentResult();
                                        VB vb9 = this.PlaceComponentResult;
                                        if (vb9 != 0) {
                                            ((FragmentDanapolyBinding) vb9).lookAheadTest.setTransitionListener(new MotionLayout.TransitionListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardFragment$init$1
                                                @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                                                public final void onTransitionChange(MotionLayout p0, int p1, int p2, float p3) {
                                                }

                                                @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                                                public final void onTransitionTrigger(MotionLayout p0, int p1, boolean p2, float p3) {
                                                }

                                                @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                                                public final void onTransitionStarted(MotionLayout p0, int p1, int p2) {
                                                    DanapolyBoardFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(false, false);
                                                }

                                                @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                                                public final void onTransitionCompleted(MotionLayout p0, int p1) {
                                                    PlayerInfoModel playerInfoModel;
                                                    boolean z;
                                                    DanapolyBoardFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                                                    VB vb10 = DanapolyBoardFragment.this.PlaceComponentResult;
                                                    if (vb10 != 0) {
                                                        ((FragmentDanapolyBinding) vb10).BuiltInFictitiousFunctionClassFactory.showBoard();
                                                        playerInfoModel = DanapolyBoardFragment.this.moveToNextValue;
                                                        if (playerInfoModel != null) {
                                                            DanapolyBoardFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(DanapolyBoardFragment.this);
                                                        }
                                                        DanapolyBoardFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(DanapolyBoardFragment.this).checkExtraForDareNotification();
                                                        DanapolyBoardFragment danapolyBoardFragment = DanapolyBoardFragment.this;
                                                        z = danapolyBoardFragment.lookAheadTest;
                                                        DanapolyBoardFragment.PlaceComponentResult(danapolyBoardFragment, z);
                                                        VB vb11 = DanapolyBoardFragment.this.PlaceComponentResult;
                                                        if (vb11 != 0) {
                                                            if (((FragmentDanapolyBinding) vb11).BuiltInFictitiousFunctionClassFactory.isErrorStateShown()) {
                                                                DanapolyBoardFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(true, false);
                                                            }
                                                            FragmentActivity activity = DanapolyBoardFragment.this.getActivity();
                                                            BaseDanapolyAudioActivity baseDanapolyAudioActivity = activity instanceof BaseDanapolyAudioActivity ? (BaseDanapolyAudioActivity) activity : null;
                                                            if (baseDanapolyAudioActivity != null) {
                                                                baseDanapolyAudioActivity.startBackgroundMusic();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        throw new IllegalArgumentException("Required value was null.".toString());
                                                    }
                                                    throw new IllegalArgumentException("Required value was null.".toString());
                                                }
                                            });
                                            return;
                                        }
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
