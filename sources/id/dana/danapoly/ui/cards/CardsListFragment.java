package id.dana.danapoly.ui.cards;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
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
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.richview.DanaPullToRefreshListener;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.FragmentCardsListBinding;
import id.dana.danapoly.di.component.DanapolyComponent;
import id.dana.danapoly.di.provider.DanapolyComponentProvider;
import id.dana.danapoly.ui.board.DanapolyBoardTabActivity;
import id.dana.danapoly.ui.board.view.DanapolyPromptInfoView;
import id.dana.danapoly.ui.cards.CardListDetailFragment;
import id.dana.danapoly.ui.cards.view.CardSectionView;
import id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsUiState;
import id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsViewModel;
import id.dana.danapoly.ui.enums.RewardType;
import id.dana.danapoly.ui.model.CardItemModel;
import id.dana.danapoly.ui.model.CardListWrapperModel;
import id.dana.data.util.UrlUtil;
import id.dana.network.util.DanaDeeplinkHelper;
import id.dana.network.util.DanaH5Helper;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0015R(\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u00020\u001bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0012\u0010\u0011\u001a\u00020 X\u0086\"¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0018\u0010#\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0012\u0010&\u001a\u00020%X\u0087\"¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lid/dana/danapoly/ui/cards/CardsListFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/danapoly/databinding/FragmentCardsListBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p0", "PlaceComponentResult", "(I)I", "FragmentBottomSheetPaymentSettingBinding", "", "MyBillsEntityDataFactory", "()Z", "lookAheadTest", "getOnBoardingScenario", "Lid/dana/danapoly/ui/cards/CardListDetailFragment$ErrorState;", "getAuthRequestContext", "(Lid/dana/danapoly/ui/cards/CardListDetailFragment$ErrorState;)V", "", "Lid/dana/danapoly/ui/cards/view/CardSectionView;", "Lkotlin/Lazy;", "Lkotlin/Pair;", "Lid/dana/danapoly/ui/enums/RewardType;", "Lid/dana/danapoly/ui/model/CardListWrapperModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/List;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsViewModel;", "", "scheduleImpl", "Ljava/util/Map;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/di/component/DanapolyComponent;", "Lid/dana/danapoly/di/component/DanapolyComponent;", "", "getErrorConfigVersion", "Lid/dana/danapoly/ui/cards/view/CardSectionView;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardsListFragment extends BaseViewBindingFragment<FragmentCardsListBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public DanapolyComponent getAuthRequestContext;
    private CardSectionView getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;
    @Inject
    public ViewModelFactory viewModelFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private List<? extends Pair<? extends RewardType, CardListWrapperModel>> PlaceComponentResult = CollectionsKt.emptyList();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private Map<CardSectionView, CardListWrapperModel> BuiltInFictitiousFunctionClassFactory = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    List<RewardType> scheduleImpl = new ArrayList();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<List<? extends CardSectionView>>() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$allCardSections$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends CardSectionView> invoke() {
            CardSectionView[] cardSectionViewArr = new CardSectionView[5];
            VB vb = CardsListFragment.this.PlaceComponentResult;
            if (vb != 0) {
                cardSectionViewArr[0] = ((FragmentCardsListBinding) vb).PlaceComponentResult;
                VB vb2 = CardsListFragment.this.PlaceComponentResult;
                if (vb2 != 0) {
                    cardSectionViewArr[1] = ((FragmentCardsListBinding) vb2).lookAheadTest;
                    VB vb3 = CardsListFragment.this.PlaceComponentResult;
                    if (vb3 != 0) {
                        cardSectionViewArr[2] = ((FragmentCardsListBinding) vb3).getErrorConfigVersion;
                        VB vb4 = CardsListFragment.this.PlaceComponentResult;
                        if (vb4 != 0) {
                            cardSectionViewArr[3] = ((FragmentCardsListBinding) vb4).getAuthRequestContext;
                            VB vb5 = CardsListFragment.this.PlaceComponentResult;
                            if (vb5 != 0) {
                                cardSectionViewArr[4] = ((FragmentCardsListBinding) vb5).MyBillsEntityDataFactory;
                                return CollectionsKt.listOf((Object[]) cardSectionViewArr);
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
    });

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentCardsListBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentCardsListBinding MyBillsEntityDataFactory = FragmentCardsListBinding.MyBillsEntityDataFactory(getLayoutInflater(), viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        KClassImpl$Data$declaredNonStaticMembers$2();
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.di.provider.DanapolyComponentProvider");
        }
        DanapolyComponent MyBillsEntityDataFactory = ((DanapolyComponentProvider) applicationContext).provideDanapolyComponent().MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        this.getAuthRequestContext = MyBillsEntityDataFactory;
        if (MyBillsEntityDataFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            MyBillsEntityDataFactory = null;
        }
        MyBillsEntityDataFactory.MyBillsEntityDataFactory(this);
        StateFlow<DanapolyCardsUiState> stateFlow = ((DanapolyCardsViewModel) this.MyBillsEntityDataFactory.getValue()).MyBillsEntityDataFactory;
        Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        Flow onEach = FlowKt.onEach(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle), new CardsListFragment$initViewModel$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCardsListBinding) vb).scheduleImpl.setOnCloseIconClicked(new Function0<Unit>() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$setupPromptListener$1
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
                    VB vb2 = CardsListFragment.this.PlaceComponentResult;
                    if (vb2 != 0) {
                        DanapolyPromptInfoView danapolyPromptInfoView = ((FragmentCardsListBinding) vb2).scheduleImpl;
                        Intrinsics.checkNotNullExpressionValue(danapolyPromptInfoView, "");
                        danapolyPromptInfoView.setVisibility(8);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            });
            for (final CardSectionView cardSectionView : (List) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()) {
                cardSectionView.setOnCardItemClicked(new Function1<CardItemModel, Unit>() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$setupListenerForCardSections$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(CardItemModel cardItemModel) {
                        invoke2(cardItemModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(CardItemModel cardItemModel) {
                        Intrinsics.checkNotNullParameter(cardItemModel, "");
                        new CardDetailBottomsheetFragment(cardItemModel, new Function1<String, Unit>() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$openCardDetailBottomSheet$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(String str) {
                                Intrinsics.checkNotNullParameter(str, "");
                                CardsListFragment.getAuthRequestContext(CardsListFragment.this, str);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }
                        }).show(CardsListFragment.this.getParentFragmentManager(), "CardDetailBottomsheetFragment");
                    }
                });
                cardSectionView.setOnExpandClicked(new Function1<List<? extends CardItemModel>, Unit>() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$setupListenerForCardSections$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends CardItemModel> list) {
                        invoke2((List<CardItemModel>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(List<CardItemModel> list) {
                        Intrinsics.checkNotNullParameter(list, "");
                        CardsListFragment cardsListFragment = CardsListFragment.this;
                        CardSectionView cardSectionView2 = cardSectionView;
                        Intrinsics.checkNotNullExpressionValue(cardSectionView2, "");
                        CardsListFragment.MyBillsEntityDataFactory(cardsListFragment, cardSectionView2, ((CardItemModel) CollectionsKt.first((List) list)).getCardType());
                    }
                });
            }
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCardsListBinding) vb2).scheduleImpl.setOnCloseIconClicked(new Function0<Unit>() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$initOnClick$1
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
                        CardsListFragment.MyBillsEntityDataFactory(CardsListFragment.this);
                        VB vb3 = CardsListFragment.this.PlaceComponentResult;
                        if (vb3 != 0) {
                            DanapolyPromptInfoView danapolyPromptInfoView = ((FragmentCardsListBinding) vb3).scheduleImpl;
                            Intrinsics.checkNotNullExpressionValue(danapolyPromptInfoView, "");
                            danapolyPromptInfoView.setVisibility(8);
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentCardsListBinding) vb3).initRecordTimeStamp.setDanaPullToRefreshListener(new DanaPullToRefreshListener() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$initPullToRefresh$1
                        @Override // id.dana.core.ui.richview.DanaPullToRefreshListener
                        public final void PlaceComponentResult(PtrFrameLayout p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            CardsListFragment.getAuthRequestContext(CardsListFragment.this).getAuthRequestContext();
                        }

                        @Override // id.dana.core.ui.richview.DanaPullToRefreshListener
                        public final void BuiltInFictitiousFunctionClassFactory() {
                            VB vb4 = CardsListFragment.this.PlaceComponentResult;
                            if (vb4 != 0) {
                                ((FragmentCardsListBinding) vb4).initRecordTimeStamp.cancelRefreshProgress();
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    });
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentCardsListBinding) vb4).DatabaseTableConfigUtil.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$$ExternalSyntheticLambda2
                            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                            public final void onScrollChanged() {
                                CardsListFragment.PlaceComponentResult(CardsListFragment.this);
                            }
                        });
                        ((DanapolyCardsViewModel) this.MyBillsEntityDataFactory.getValue()).getAuthRequestContext();
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

    private final boolean MyBillsEntityDataFactory() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return ((DanapolyBoardTabActivity) activity).getCardPromptShown();
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.ui.board.DanapolyBoardTabActivity");
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        super.lookAheadTest();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.ui.board.DanapolyBoardTabActivity");
        }
        ((DanapolyBoardTabActivity) activity).onBackToBoardPage();
    }

    public static int PlaceComponentResult(int p0) {
        if (p0 != 0) {
            if (p0 != 1) {
                if (p0 != 2) {
                    if (p0 == 3) {
                        return R.id.step2to1SectionBalance;
                    }
                    return R.id.res_0x7f0a128e_view_onclicklistener;
                }
                return R.id.DebugCoroutineInfoImpl_res_0x7f0a128d;
            }
            return R.id.res_0x7f0a128f_trackerkey_globalsearchopenproperties;
        }
        return R.id.BannerEntityDataFactory_Factory_res_0x7f0a128c;
    }

    public CardsListFragment() {
        final CardsListFragment cardsListFragment = this;
        final Function0 function0 = null;
        this.MyBillsEntityDataFactory = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(cardsListFragment, Reflection.getOrCreateKotlinClass(DanapolyCardsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$special$$inlined$activityViewModels$default$2
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
                    CreationExtras defaultViewModelCreationExtras = cardsListFragment.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$cardListViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = CardsListFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        });
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CardsListFragment cardsListFragment) {
        Intrinsics.checkNotNullParameter(cardsListFragment, "");
        super.lookAheadTest();
        FragmentActivity activity = cardsListFragment.getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.ui.board.DanapolyBoardTabActivity");
        }
        ((DanapolyBoardTabActivity) activity).onBackToBoardPage();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CardsListFragment cardsListFragment) {
        Intrinsics.checkNotNullParameter(cardsListFragment, "");
        CardSectionView cardSectionView = cardsListFragment.getErrorConfigVersion;
        if (cardSectionView != null) {
            cardSectionView.onCollapse();
        }
        VB vb = cardsListFragment.PlaceComponentResult;
        if (vb != 0) {
            ConstraintLayout constraintLayout = ((FragmentCardsListBinding) vb).GetContactSyncConfig.GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(0);
            VB vb2 = cardsListFragment.PlaceComponentResult;
            if (vb2 != 0) {
                DanapolyPromptInfoView danapolyPromptInfoView = ((FragmentCardsListBinding) vb2).scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(danapolyPromptInfoView, "");
                danapolyPromptInfoView.setVisibility(cardsListFragment.MyBillsEntityDataFactory() ? 0 : 8);
                FragmentActivity activity = cardsListFragment.getActivity();
                if (activity != null) {
                    ((DanapolyBoardTabActivity) activity).renderTabLayout(true);
                    VB vb3 = cardsListFragment.PlaceComponentResult;
                    if (vb3 != 0) {
                        ((FragmentCardsListBinding) vb3).initRecordTimeStamp.setEnable(true);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.ui.board.DanapolyBoardTabActivity");
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void PlaceComponentResult(CardsListFragment cardsListFragment) {
        Intrinsics.checkNotNullParameter(cardsListFragment, "");
        if (FragmentExtKt.PlaceComponentResult(cardsListFragment)) {
            Rect rect = new Rect();
            VB vb = cardsListFragment.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentCardsListBinding) vb).DatabaseTableConfigUtil.getDrawingRect(rect);
                VB vb2 = cardsListFragment.PlaceComponentResult;
                if (vb2 != 0) {
                    float y = ((FragmentCardsListBinding) vb2).PlaceComponentResult.getY();
                    VB vb3 = cardsListFragment.PlaceComponentResult;
                    if (vb3 == 0) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    boolean z = ((float) rect.top) < y && ((float) rect.bottom) > ((float) ((FragmentCardsListBinding) vb3).PlaceComponentResult.getHeight()) + y;
                    VB vb4 = cardsListFragment.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentCardsListBinding) vb4).initRecordTimeStamp.setEnable(z);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final /* synthetic */ DanapolyCardsViewModel getAuthRequestContext(CardsListFragment cardsListFragment) {
        return (DanapolyCardsViewModel) cardsListFragment.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ void getAuthRequestContext(CardsListFragment cardsListFragment, String str) {
        Context context = cardsListFragment.getContext();
        if (context != null) {
            if (UrlUtil.isDeepLink(str)) {
                DanaDeeplinkHelper.INSTANCE.openUrl(context, str, "DANAPoly");
            } else {
                DanaH5Helper.INSTANCE.openUrl(context, str);
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CardsListFragment cardsListFragment) {
        FragmentActivity activity = cardsListFragment.getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.ui.board.DanapolyBoardTabActivity");
        }
        ((DanapolyBoardTabActivity) activity).setCardPromptShown(false);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final CardsListFragment cardsListFragment, final CardSectionView cardSectionView, RewardType rewardType) {
        final CardListWrapperModel cardListWrapperModel;
        int i;
        if (rewardType == null || (cardListWrapperModel = cardsListFragment.BuiltInFictitiousFunctionClassFactory.get(cardSectionView)) == null) {
            return;
        }
        cardsListFragment.getErrorConfigVersion = cardSectionView;
        FragmentActivity activity = cardsListFragment.getActivity();
        if (activity != null) {
            ((DanapolyBoardTabActivity) activity).renderTabLayout(false);
            RewardType rewardType2 = cardListWrapperModel.getRewardType();
            int indexOf = rewardType2 == null ? -1 : cardsListFragment.scheduleImpl.indexOf(rewardType2);
            if (indexOf != -1) {
                VB vb = cardsListFragment.PlaceComponentResult;
                if (vb != 0) {
                    MotionLayout motionLayout = ((FragmentCardsListBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (indexOf == 0) {
                        i = R.id.WithdrawSavedCardChannelView_res_0x7f0a1281;
                    } else if (indexOf == 1) {
                        i = R.id.SchedulerPoolFactory_res_0x7f0a1284;
                    } else if (indexOf == 2) {
                        i = R.id.res_0x7f0a1282_flowkt__reducekt_firstornull_inlined_collectwhile_2_1;
                    } else if (indexOf == 3) {
                        i = R.id.res_0x7f0a1280_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_2;
                    } else {
                        i = R.id.step1to2SectionTrick;
                    }
                    motionLayout.setTransition(i);
                    VB vb2 = cardsListFragment.PlaceComponentResult;
                    if (vb2 != 0) {
                        ((FragmentCardsListBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda1.addTransitionListener(new MotionLayout.TransitionListener() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$openCardListDetail$1
                            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                            public final void onTransitionChange(MotionLayout p0, int p1, int p2, float p3) {
                            }

                            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                            public final void onTransitionTrigger(MotionLayout p0, int p1, boolean p2, float p3) {
                            }

                            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                            public final void onTransitionStarted(MotionLayout p0, int p1, int p2) {
                                VB vb3 = CardsListFragment.this.PlaceComponentResult;
                                if (vb3 != 0) {
                                    ConstraintLayout constraintLayout = ((FragmentCardsListBinding) vb3).GetContactSyncConfig.GetContactSyncConfig;
                                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                                    constraintLayout.setVisibility(8);
                                    VB vb4 = CardsListFragment.this.PlaceComponentResult;
                                    if (vb4 != 0) {
                                        DanapolyPromptInfoView danapolyPromptInfoView = ((FragmentCardsListBinding) vb4).scheduleImpl;
                                        Intrinsics.checkNotNullExpressionValue(danapolyPromptInfoView, "");
                                        danapolyPromptInfoView.setVisibility(8);
                                        return;
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }

                            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
                            public final void onTransitionCompleted(MotionLayout p0, int p1) {
                                CardSectionView cardSectionView2 = cardSectionView;
                                final CardsListFragment cardsListFragment2 = CardsListFragment.this;
                                final CardListWrapperModel cardListWrapperModel2 = cardListWrapperModel;
                                cardSectionView2.onExpand(new Function0<Unit>() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$openCardListDetail$1$onTransitionCompleted$1
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
                                        CardsListFragment.KClassImpl$Data$declaredNonStaticMembers$2(CardsListFragment.this, cardListWrapperModel2);
                                    }
                                });
                                VB vb3 = CardsListFragment.this.PlaceComponentResult;
                                if (vb3 != 0) {
                                    ((FragmentCardsListBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda1.removeTransitionListener(this);
                                    return;
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        });
                        VB vb3 = cardsListFragment.PlaceComponentResult;
                        if (vb3 != 0) {
                            ((FragmentCardsListBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda1.transitionToEnd();
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.ui.board.DanapolyBoardTabActivity");
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CardsListFragment cardsListFragment, CardListWrapperModel cardListWrapperModel) {
        FragmentTransaction beginTransaction = cardsListFragment.getParentFragmentManager().beginTransaction();
        beginTransaction.isLayoutRequested = true;
        FragmentTransaction PlaceComponentResult = beginTransaction.PlaceComponentResult(cardsListFragment);
        int i = R.id.fragment_container_view;
        CardListDetailFragment.Companion companion = CardListDetailFragment.INSTANCE;
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(i, CardListDetailFragment.Companion.MyBillsEntityDataFactory(cardListWrapperModel), null, 1);
        if (!PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        PlaceComponentResult.scheduleImpl = true;
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8 = "CardsListFragment";
        PlaceComponentResult.getAuthRequestContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void getAuthRequestContext(CardsListFragment cardsListFragment, List list) {
        if (list.isEmpty()) {
            cardsListFragment.getAuthRequestContext(CardListDetailFragment.ErrorState.EMPTY);
            return;
        }
        int i = 0;
        for (Object obj : (List) cardsListFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CardSectionView cardSectionView = (CardSectionView) obj;
            if (i < list.size()) {
                Map<CardSectionView, CardListWrapperModel> map = cardsListFragment.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(cardSectionView, "");
                map.put(cardSectionView, ((Pair) list.get(i)).getSecond());
                cardsListFragment.scheduleImpl.add(((Pair) list.get(i)).getFirst());
                cardSectionView.showCardItems(CollectionsKt.take(((CardListWrapperModel) ((Pair) list.get(i)).getSecond()).getItems(), 3));
            }
            i++;
        }
        if (((List) cardsListFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).size() != cardsListFragment.BuiltInFictitiousFunctionClassFactory.size()) {
            List list2 = (List) cardsListFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list2) {
                if ((!cardsListFragment.BuiltInFictitiousFunctionClassFactory.containsKey((CardSectionView) obj2)) != false) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((CardSectionView) it.next()).hideSection();
                arrayList3.add(Unit.INSTANCE);
            }
        }
        VB vb = cardsListFragment.PlaceComponentResult;
        if (vb != 0) {
            CardSectionView cardSectionView2 = ((FragmentCardsListBinding) vb).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(cardSectionView2, "");
            ViewExtKt.PlaceComponentResult(cardSectionView2, 0);
            VB vb2 = cardsListFragment.PlaceComponentResult;
            if (vb2 != 0) {
                CardSectionView cardSectionView3 = ((FragmentCardsListBinding) vb2).lookAheadTest;
                Intrinsics.checkNotNullExpressionValue(cardSectionView3, "");
                ViewExtKt.PlaceComponentResult(cardSectionView3, 0);
                VB vb3 = cardsListFragment.PlaceComponentResult;
                if (vb3 != 0) {
                    CardSectionView cardSectionView4 = ((FragmentCardsListBinding) vb3).getErrorConfigVersion;
                    Intrinsics.checkNotNullExpressionValue(cardSectionView4, "");
                    ViewExtKt.PlaceComponentResult(cardSectionView4, 0);
                    VB vb4 = cardsListFragment.PlaceComponentResult;
                    if (vb4 != 0) {
                        CardSectionView cardSectionView5 = ((FragmentCardsListBinding) vb4).getAuthRequestContext;
                        Intrinsics.checkNotNullExpressionValue(cardSectionView5, "");
                        ViewExtKt.PlaceComponentResult(cardSectionView5, 0);
                        VB vb5 = cardsListFragment.PlaceComponentResult;
                        if (vb5 != 0) {
                            CardSectionView cardSectionView6 = ((FragmentCardsListBinding) vb5).MyBillsEntityDataFactory;
                            Intrinsics.checkNotNullExpressionValue(cardSectionView6, "");
                            ViewExtKt.PlaceComponentResult(cardSectionView6, 0);
                            VB vb6 = cardsListFragment.PlaceComponentResult;
                            if (vb6 != 0) {
                                Group group = ((FragmentCardsListBinding) vb6).NetworkUserEntityData$$ExternalSyntheticLambda0;
                                Intrinsics.checkNotNullExpressionValue(group, "");
                                ViewExtKt.PlaceComponentResult(group, 0);
                                VB vb7 = cardsListFragment.PlaceComponentResult;
                                if (vb7 != 0) {
                                    LinearLayout linearLayout = ((FragmentCardsListBinding) vb7).isLayoutRequested.BuiltInFictitiousFunctionClassFactory;
                                    Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                                    ViewExtKt.PlaceComponentResult(linearLayout, 8);
                                    VB vb8 = cardsListFragment.PlaceComponentResult;
                                    if (vb8 != 0) {
                                        DanapolyPromptInfoView danapolyPromptInfoView = ((FragmentCardsListBinding) vb8).scheduleImpl;
                                        Intrinsics.checkNotNullExpressionValue(danapolyPromptInfoView, "");
                                        danapolyPromptInfoView.setVisibility(cardsListFragment.MyBillsEntityDataFactory() ? 0 : 8);
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

    public final void getAuthRequestContext(CardListDetailFragment.ErrorState p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            CardSectionView cardSectionView = ((FragmentCardsListBinding) vb).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(cardSectionView, "");
            ViewExtKt.PlaceComponentResult(cardSectionView, 8);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                CardSectionView cardSectionView2 = ((FragmentCardsListBinding) vb2).lookAheadTest;
                Intrinsics.checkNotNullExpressionValue(cardSectionView2, "");
                ViewExtKt.PlaceComponentResult(cardSectionView2, 8);
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    CardSectionView cardSectionView3 = ((FragmentCardsListBinding) vb3).getErrorConfigVersion;
                    Intrinsics.checkNotNullExpressionValue(cardSectionView3, "");
                    ViewExtKt.PlaceComponentResult(cardSectionView3, 8);
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        CardSectionView cardSectionView4 = ((FragmentCardsListBinding) vb4).getAuthRequestContext;
                        Intrinsics.checkNotNullExpressionValue(cardSectionView4, "");
                        ViewExtKt.PlaceComponentResult(cardSectionView4, 8);
                        VB vb5 = this.PlaceComponentResult;
                        if (vb5 != 0) {
                            CardSectionView cardSectionView5 = ((FragmentCardsListBinding) vb5).MyBillsEntityDataFactory;
                            Intrinsics.checkNotNullExpressionValue(cardSectionView5, "");
                            ViewExtKt.PlaceComponentResult(cardSectionView5, 8);
                            VB vb6 = this.PlaceComponentResult;
                            if (vb6 != 0) {
                                Group group = ((FragmentCardsListBinding) vb6).NetworkUserEntityData$$ExternalSyntheticLambda0;
                                Intrinsics.checkNotNullExpressionValue(group, "");
                                ViewExtKt.PlaceComponentResult(group, 8);
                                VB vb7 = this.PlaceComponentResult;
                                if (vb7 != 0) {
                                    LinearLayout linearLayout = ((FragmentCardsListBinding) vb7).isLayoutRequested.BuiltInFictitiousFunctionClassFactory;
                                    Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                                    ViewExtKt.PlaceComponentResult(linearLayout, 0);
                                    VB vb8 = this.PlaceComponentResult;
                                    if (vb8 != 0) {
                                        DanapolyPromptInfoView danapolyPromptInfoView = ((FragmentCardsListBinding) vb8).scheduleImpl;
                                        Intrinsics.checkNotNullExpressionValue(danapolyPromptInfoView, "");
                                        danapolyPromptInfoView.setVisibility(8);
                                        VB vb9 = this.PlaceComponentResult;
                                        if (vb9 != 0) {
                                            ((FragmentCardsListBinding) vb9).initRecordTimeStamp.setEnable(true);
                                            if (p0 == CardListDetailFragment.ErrorState.EMPTY) {
                                                VB vb10 = this.PlaceComponentResult;
                                                if (vb10 != 0) {
                                                    AppCompatImageView appCompatImageView = ((FragmentCardsListBinding) vb10).isLayoutRequested.MyBillsEntityDataFactory;
                                                    int i = R.drawable.res_0x7f080801_networkuserentitydata_externalsyntheticlambda5;
                                                    if (appCompatImageView instanceof ImageView) {
                                                        InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                                                    } else {
                                                        appCompatImageView.setImageResource(i);
                                                    }
                                                    VB vb11 = this.PlaceComponentResult;
                                                    if (vb11 != 0) {
                                                        ((FragmentCardsListBinding) vb11).isLayoutRequested.getAuthRequestContext.setText(getString(R.string.card_list_empty_title));
                                                        VB vb12 = this.PlaceComponentResult;
                                                        if (vb12 != 0) {
                                                            ((FragmentCardsListBinding) vb12).isLayoutRequested.PlaceComponentResult.setText(getString(R.string.card_list_empty_desc));
                                                            return;
                                                        }
                                                        throw new IllegalArgumentException("Required value was null.".toString());
                                                    }
                                                    throw new IllegalArgumentException("Required value was null.".toString());
                                                }
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                            VB vb13 = this.PlaceComponentResult;
                                            if (vb13 != 0) {
                                                AppCompatImageView appCompatImageView2 = ((FragmentCardsListBinding) vb13).isLayoutRequested.MyBillsEntityDataFactory;
                                                int i2 = R.drawable.ic_danapoly_error_illustration;
                                                if (appCompatImageView2 instanceof ImageView) {
                                                    InstrumentInjector.Resources_setImageResource(appCompatImageView2, i2);
                                                } else {
                                                    appCompatImageView2.setImageResource(i2);
                                                }
                                                VB vb14 = this.PlaceComponentResult;
                                                if (vb14 != 0) {
                                                    ((FragmentCardsListBinding) vb14).isLayoutRequested.getAuthRequestContext.setText(getString(R.string.card_list_error_title));
                                                    VB vb15 = this.PlaceComponentResult;
                                                    if (vb15 != 0) {
                                                        ((FragmentCardsListBinding) vb15).isLayoutRequested.PlaceComponentResult.setText(getString(R.string.card_list_error_desc));
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
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            Toolbar toolbar = ((FragmentCardsListBinding) vb).GetContactSyncConfig.DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(toolbar, "");
            getAuthRequestContext(toolbar);
            Toolbar valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
            Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(valueOfTouchPositionAbsolute.getContext(), R.drawable.KClassImpl$Data$declaredNonStaticMembers$2);
            valueOfTouchPositionAbsolute.setContentDescription(getString(R.string.KClassImpl$Data$declaredNonStaticMembers$2));
            valueOfTouchPositionAbsolute.setNavigationIcon(PlaceComponentResult);
            valueOfTouchPositionAbsolute.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CardsListFragment.BuiltInFictitiousFunctionClassFactory(CardsListFragment.this);
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCardsListBinding) vb2).GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(R.string.res_0x7f130454_networkuserentitydata_externalsyntheticlambda2));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void getOnBoardingScenario() {
        ((DanapolyCardsViewModel) this.MyBillsEntityDataFactory.getValue()).getAuthRequestContext();
    }
}
