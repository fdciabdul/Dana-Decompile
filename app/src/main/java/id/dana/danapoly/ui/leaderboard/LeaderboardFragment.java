package id.dana.danapoly.ui.leaderboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.FlowExtKt;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.viewmodel.CreationExtras;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.FragmentLeaderboardBinding;
import id.dana.danapoly.di.component.DanapolyComponent;
import id.dana.danapoly.di.provider.DanapolyComponentProvider;
import id.dana.danapoly.ui.board.DanapolyBoardTabActivity;
import id.dana.danapoly.ui.leaderboard.DanapolyCustomDialog;
import id.dana.danapoly.ui.leaderboard.adapter.LeaderboardAdapter;
import id.dana.danapoly.ui.leaderboard.viewmodel.LeaderboardUiState;
import id.dana.danapoly.ui.leaderboard.viewmodel.LeaderboardViewModel;
import id.dana.danapoly.ui.model.DanapolyDeeplinkModel;
import id.dana.danapoly.ui.model.leaderboard.PrizeInfoModel;
import id.dana.danapoly.ui.splash.DanapolySplashActivity;
import id.dana.data.util.UrlUtil;
import id.dana.network.util.DanaDeeplinkHelper;
import id.dana.network.util.DanaH5Helper;
import id.dana.utils.android.IntentUtil;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005R\u0012\u0010\f\u001a\u00020\nX\u0086\"¢\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u0013X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0017\u001a\u00020\u0016X\u0087\"¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u00198\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\b\u0010\u001a"}, d2 = {"Lid/dana/danapoly/ui/leaderboard/LeaderboardFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/danapoly/databinding/FragmentLeaderboardBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "MyBillsEntityDataFactory", "FragmentBottomSheetPaymentSettingBinding", "lookAheadTest", "getOnBoardingScenario", "Lid/dana/danapoly/di/component/DanapolyComponent;", "Lid/dana/danapoly/di/component/DanapolyComponent;", "BuiltInFictitiousFunctionClassFactory", "", "PlaceComponentResult", "Ljava/lang/String;", "Lid/dana/danapoly/ui/leaderboard/adapter/LeaderboardAdapter;", "Lid/dana/danapoly/ui/leaderboard/adapter/LeaderboardAdapter;", "getAuthRequestContext", "Lid/dana/danapoly/ui/leaderboard/viewmodel/LeaderboardViewModel;", "scheduleImpl", "Lkotlin/Lazy;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog;", "Lid/dana/danapoly/ui/leaderboard/DanapolyCustomDialog;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LeaderboardFragment extends BaseViewBindingFragment<FragmentLeaderboardBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public DanapolyComponent BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final LeaderboardAdapter getAuthRequestContext = new LeaderboardAdapter();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private DanapolyCustomDialog PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentLeaderboardBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentLeaderboardBinding BuiltInFictitiousFunctionClassFactory = FragmentLeaderboardBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater(), viewGroup);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        super.lookAheadTest();
        FragmentActivity activity = getActivity();
        DanapolyBoardTabActivity danapolyBoardTabActivity = activity instanceof DanapolyBoardTabActivity ? (DanapolyBoardTabActivity) activity : null;
        if (danapolyBoardTabActivity != null) {
            danapolyBoardTabActivity.onBackToBoardPage();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void getOnBoardingScenario() {
        MyBillsEntityDataFactory();
    }

    private final void MyBillsEntityDataFactory() {
        Intent intent;
        DanapolyDeeplinkModel danapolyDeeplinkModel;
        Intent intent2;
        FragmentActivity activity = getActivity();
        Unit unit = null;
        if (activity != null && (intent = activity.getIntent()) != null && (danapolyDeeplinkModel = (DanapolyDeeplinkModel) intent.getParcelableExtra(DanapolySplashActivity.BUNDLE_POP_UP)) != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
                intent2.removeExtra(DanapolySplashActivity.BUNDLE_POP_UP);
            }
            if (!danapolyDeeplinkModel.isWinnerNotification()) {
                ((LeaderboardViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).KClassImpl$Data$declaredNonStaticMembers$2("");
            } else {
                LeaderboardViewModel leaderboardViewModel = (LeaderboardViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
                String lastEventId = danapolyDeeplinkModel.getLastEventId();
                if (lastEventId == null) {
                    lastEventId = "";
                }
                leaderboardViewModel.KClassImpl$Data$declaredNonStaticMembers$2(lastEventId);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            LeaderboardViewModel leaderboardViewModel2 = (LeaderboardViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            String str = this.MyBillsEntityDataFactory;
            leaderboardViewModel2.KClassImpl$Data$declaredNonStaticMembers$2(str != null ? str : "");
        }
    }

    public LeaderboardFragment() {
        final LeaderboardFragment leaderboardFragment = this;
        final Function0 function0 = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(leaderboardFragment, Reflection.getOrCreateKotlinClass(LeaderboardViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.danapoly.ui.leaderboard.LeaderboardFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: id.dana.danapoly.ui.leaderboard.LeaderboardFragment$special$$inlined$activityViewModels$default$2
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
                    CreationExtras defaultViewModelCreationExtras = leaderboardFragment.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.danapoly.ui.leaderboard.LeaderboardFragment$leaderboardViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = LeaderboardFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        });
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(LeaderboardFragment leaderboardFragment) {
        Intrinsics.checkNotNullParameter(leaderboardFragment, "");
        leaderboardFragment.lookAheadTest();
    }

    public static /* synthetic */ void PlaceComponentResult(LeaderboardFragment leaderboardFragment) {
        Intrinsics.checkNotNullParameter(leaderboardFragment, "");
        String string = leaderboardFragment.getString(R.string.leaderboard_share_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(string, Arrays.copyOf(new Object[]{"https://link.dana.id/danapoly"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        Intent KClassImpl$Data$declaredNonStaticMembers$2 = IntentUtil.KClassImpl$Data$declaredNonStaticMembers$2(format);
        Context context = leaderboardFragment.getContext();
        if (context != null) {
            leaderboardFragment.startActivity(Intent.createChooser(KClassImpl$Data$declaredNonStaticMembers$2, context.getString(R.string.E)));
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PrizeInfoModel prizeInfoModel, LeaderboardFragment leaderboardFragment) {
        Context context;
        Intrinsics.checkNotNullParameter(prizeInfoModel, "");
        Intrinsics.checkNotNullParameter(leaderboardFragment, "");
        String redirectLink = prizeInfoModel.getRedirectLink();
        if (!(redirectLink.length() > 0)) {
            redirectLink = null;
        }
        if (redirectLink == null || (context = leaderboardFragment.getContext()) == null) {
            return;
        }
        if (UrlUtil.isDeepLink(redirectLink)) {
            DanaDeeplinkHelper.INSTANCE.openUrl(context, redirectLink, "DANAPoly");
        } else {
            DanaH5Helper.INSTANCE.openUrl(context, redirectLink);
        }
    }

    public static final /* synthetic */ LeaderboardViewModel getAuthRequestContext(LeaderboardFragment leaderboardFragment) {
        return (LeaderboardViewModel) leaderboardFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final LeaderboardFragment leaderboardFragment, final PrizeInfoModel prizeInfoModel) {
        DanapolyCustomDialog danapolyCustomDialog = leaderboardFragment.PlaceComponentResult;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (danapolyCustomDialog != null) {
            if (danapolyCustomDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                danapolyCustomDialog = null;
            }
            if (danapolyCustomDialog.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                DanapolyCustomDialog danapolyCustomDialog2 = leaderboardFragment.PlaceComponentResult;
                if (danapolyCustomDialog2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    danapolyCustomDialog2 = null;
                }
                danapolyCustomDialog2.PlaceComponentResult();
            }
        }
        Context context = leaderboardFragment.getContext();
        if (context != null) {
            DanapolyCustomDialog.Builder PlaceComponentResult = new DanapolyCustomDialog.Builder(context, DanapolyCustomDialog.DialogType.RIBBON_WITH_MEDAL).PlaceComponentResult(true, true);
            PlaceComponentResult.PlaceComponentResult = prizeInfoModel.getMedalImageUrl();
            DanapolyCustomDialog.Builder BuiltInFictitiousFunctionClassFactory = DanapolyCustomDialog.Builder.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, prizeInfoModel.getPrizeImageUrl());
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = context.getString(R.string.res_0x7f1311c5_verifypinstatemanager_executeriskchallenge_2_2);
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = context.getString(R.string.popup_winner_message, prizeInfoModel.getDisplayedPrize());
            String displayedButtonTitle = prizeInfoModel.getDisplayedButtonTitle();
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.danapoly.ui.leaderboard.LeaderboardFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LeaderboardFragment.MyBillsEntityDataFactory(PrizeInfoModel.this, leaderboardFragment);
                }
            };
            Intrinsics.checkNotNullParameter(displayedButtonTitle, "");
            BuiltInFictitiousFunctionClassFactory.scheduleImpl = displayedButtonTitle;
            BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = onClickListener;
            DanapolyCustomDialog danapolyCustomDialog3 = new DanapolyCustomDialog(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, defaultConstructorMarker);
            leaderboardFragment.PlaceComponentResult = danapolyCustomDialog3;
            danapolyCustomDialog3.moveToNextValue();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            Toolbar toolbar = ((FragmentLeaderboardBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(toolbar, "");
            getAuthRequestContext(toolbar);
            Toolbar valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
            Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(valueOfTouchPositionAbsolute.getContext(), R.drawable.KClassImpl$Data$declaredNonStaticMembers$2);
            valueOfTouchPositionAbsolute.setContentDescription(getString(R.string.KClassImpl$Data$declaredNonStaticMembers$2));
            valueOfTouchPositionAbsolute.setNavigationIcon(PlaceComponentResult);
            valueOfTouchPositionAbsolute.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.leaderboard.LeaderboardFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LeaderboardFragment.BuiltInFictitiousFunctionClassFactory(LeaderboardFragment.this);
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentLeaderboardBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(R.string.leaderboard_page_title));
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    AppCompatImageView appCompatImageView = ((FragmentLeaderboardBinding) vb3).KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
                    appCompatImageView.setVisibility(0);
                    int i = R.drawable.ic_share;
                    if (appCompatImageView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                    } else {
                        appCompatImageView.setImageResource(i);
                    }
                    appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.leaderboard.LeaderboardFragment$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            LeaderboardFragment.PlaceComponentResult(LeaderboardFragment.this);
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
        Intent intent;
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.di.provider.DanapolyComponentProvider");
        }
        DanapolyComponent MyBillsEntityDataFactory = ((DanapolyComponentProvider) applicationContext).provideDanapolyComponent().MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
        if (MyBillsEntityDataFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            MyBillsEntityDataFactory = null;
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            this.MyBillsEntityDataFactory = intent.getStringExtra("last_event_id");
            intent.removeExtra("last_event_id");
        }
        StateFlow<LeaderboardUiState> stateFlow = ((LeaderboardViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).BuiltInFictitiousFunctionClassFactory;
        Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        Flow onEach = FlowKt.onEach(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle), new LeaderboardFragment$initViewModel$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            RecyclerView recyclerView = ((FragmentLeaderboardBinding) vb).MyBillsEntityDataFactory;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.setAdapter(this.getAuthRequestContext);
            KClassImpl$Data$declaredNonStaticMembers$2();
            MyBillsEntityDataFactory();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
