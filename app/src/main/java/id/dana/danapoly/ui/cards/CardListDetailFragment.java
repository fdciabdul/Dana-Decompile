package id.dana.danapoly.ui.cards;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
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
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.FragmentCardListDetailBinding;
import id.dana.danapoly.databinding.FragmentCardsListBinding;
import id.dana.danapoly.di.component.DanapolyComponent;
import id.dana.danapoly.di.provider.DanapolyComponentProvider;
import id.dana.danapoly.ui.cards.adapter.CardListAdapter;
import id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsDetailUiState;
import id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsDetailViewModel;
import id.dana.danapoly.ui.enums.CardFilterUiType;
import id.dana.danapoly.ui.enums.CardSortingType;
import id.dana.danapoly.ui.enums.RewardType;
import id.dana.danapoly.ui.model.CardItemModel;
import id.dana.danapoly.ui.model.CardListWrapperModel;
import id.dana.data.util.UrlUtil;
import id.dana.network.util.DanaDeeplinkHelper;
import id.dana.network.util.DanaH5Helper;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005R\u0013\u0010\n\u001a\u00020\u000bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\f\u001a\u00020\u000eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0012\u0010\u0014\u001a\u00020\u001aX\u0086\"¢\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0013\u0010\u0010\u001a\u00020\u001cX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\rR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0013\u0010\u0018\u001a\u00020!X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\"\u0010\rR\u0012\u0010$\u001a\u00020#X\u0087\"¢\u0006\u0006\n\u0004\b$\u0010%"}, d2 = {"Lid/dana/danapoly/ui/cards/CardListDetailFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/danapoly/databinding/FragmentCardListDetailBinding;", "", "FragmentBottomSheetPaymentSettingBinding", "()V", "Lid/dana/danapoly/ui/cards/CardListDetailFragment$ErrorState;", "p0", "PlaceComponentResult", "(Lid/dana/danapoly/ui/cards/CardListDetailFragment$ErrorState;)V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/ui/cards/adapter/CardListAdapter;", "MyBillsEntityDataFactory", "Lkotlin/Lazy;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailViewModel;", "Lid/dana/danapoly/ui/enums/CardFilterUiType;", "scheduleImpl", "Lid/dana/danapoly/ui/enums/CardFilterUiType;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/ui/enums/RewardType;", "moveToNextValue", "Lid/dana/danapoly/ui/enums/RewardType;", "getAuthRequestContext", "Lid/dana/danapoly/ui/enums/CardSortingType;", "getErrorConfigVersion", "Lid/dana/danapoly/ui/enums/CardSortingType;", "Lid/dana/danapoly/di/component/DanapolyComponent;", "Lid/dana/danapoly/di/component/DanapolyComponent;", "Lid/dana/danapoly/ui/cards/CardFilterBottomsheetFragment;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "lookAheadTest", "Z", "Lid/dana/danapoly/ui/cards/CardSortingBottomsheetFragment;", "initRecordTimeStamp", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "<init>", "Companion", "ErrorState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardListDetailFragment extends BaseViewBindingFragment<FragmentCardListDetailBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public DanapolyComponent moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;
    private boolean lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private RewardType getAuthRequestContext;
    @Inject
    public ViewModelFactory viewModelFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private CardSortingType PlaceComponentResult = CardSortingType.NEWEST;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private CardFilterUiType KClassImpl$Data$declaredNonStaticMembers$2 = CardFilterUiType.ALL;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<CardSortingBottomsheetFragment>() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$sortingBottomSheetFragment$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CardSortingBottomsheetFragment invoke() {
            final CardListDetailFragment cardListDetailFragment = CardListDetailFragment.this;
            return new CardSortingBottomsheetFragment(new Function1<CardSortingType, Unit>() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$sortingBottomSheetFragment$2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CardSortingType cardSortingType) {
                    invoke2(cardSortingType);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CardSortingType cardSortingType) {
                    Intrinsics.checkNotNullParameter(cardSortingType, "");
                    CardListDetailFragment.this.PlaceComponentResult = cardSortingType;
                    CardListDetailFragment.scheduleImpl(CardListDetailFragment.this);
                }
            });
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy scheduleImpl = LazyKt.lazy(new Function0<CardFilterBottomsheetFragment>() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$filterBottomSheetFragment$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CardFilterBottomsheetFragment invoke() {
            final CardListDetailFragment cardListDetailFragment = CardListDetailFragment.this;
            return new CardFilterBottomsheetFragment(new Function1<CardFilterUiType, Unit>() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$filterBottomSheetFragment$2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CardFilterUiType cardFilterUiType) {
                    invoke2(cardFilterUiType);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CardFilterUiType cardFilterUiType) {
                    Intrinsics.checkNotNullParameter(cardFilterUiType, "");
                    CardListDetailFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = cardFilterUiType;
                    CardListDetailFragment.scheduleImpl(CardListDetailFragment.this);
                }
            });
        }
    });

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<CardListAdapter>() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$cardListAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CardListAdapter invoke() {
            return new CardListAdapter();
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/danapoly/ui/cards/CardListDetailFragment$ErrorState;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY", "ERROR"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum ErrorState {
        EMPTY,
        ERROR
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentCardListDetailBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentCardListDetailBinding PlaceComponentResult = FragmentCardListDetailBinding.PlaceComponentResult(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danapoly/ui/cards/CardListDetailFragment$Companion;", "", "Lid/dana/danapoly/ui/model/CardListWrapperModel;", "p0", "Lid/dana/danapoly/ui/cards/CardListDetailFragment;", "MyBillsEntityDataFactory", "(Lid/dana/danapoly/ui/model/CardListWrapperModel;)Lid/dana/danapoly/ui/cards/CardListDetailFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static CardListDetailFragment MyBillsEntityDataFactory(CardListWrapperModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            CardListDetailFragment cardListDetailFragment = new CardListDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("CARD_ITEMS", p0);
            cardListDetailFragment.setArguments(bundle);
            return cardListDetailFragment;
        }
    }

    public CardListDetailFragment() {
        final CardListDetailFragment cardListDetailFragment = this;
        final Function0 function0 = null;
        this.MyBillsEntityDataFactory = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(cardListDetailFragment, Reflection.getOrCreateKotlinClass(DanapolyCardsDetailViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$special$$inlined$activityViewModels$default$2
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
                    CreationExtras defaultViewModelCreationExtras = cardListDetailFragment.requireActivity().getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$cardsDetailViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = CardListDetailFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        });
    }

    public static /* synthetic */ void getAuthRequestContext(CardListDetailFragment cardListDetailFragment) {
        RewardType rewardType;
        Intrinsics.checkNotNullParameter(cardListDetailFragment, "");
        cardListDetailFragment.getParentFragmentManager().popBackStack("CardsListFragment", 1);
        Fragment findFragmentByTag = cardListDetailFragment.getParentFragmentManager().findFragmentByTag("CardsListFragment");
        final CardsListFragment cardsListFragment = findFragmentByTag instanceof CardsListFragment ? (CardsListFragment) findFragmentByTag : null;
        if (cardsListFragment == null || (rewardType = cardListDetailFragment.getAuthRequestContext) == null) {
            return;
        }
        int indexOf = rewardType == null ? -1 : cardsListFragment.scheduleImpl.indexOf(rewardType);
        VB vb = cardsListFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCardsListBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1.setTransition(CardsListFragment.PlaceComponentResult(indexOf));
            VB vb2 = cardsListFragment.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCardsListBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda1.transitionToEnd(new Runnable() { // from class: id.dana.danapoly.ui.cards.CardsListFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        CardsListFragment.KClassImpl$Data$declaredNonStaticMembers$2(CardsListFragment.this);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CardListDetailFragment cardListDetailFragment) {
        Intrinsics.checkNotNullParameter(cardListDetailFragment, "");
        ((CardSortingBottomsheetFragment) cardListDetailFragment.getErrorConfigVersion.getValue()).show(cardListDetailFragment.getChildFragmentManager(), "CardSortingBottomsheetFragment");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(CardListDetailFragment cardListDetailFragment) {
        Intrinsics.checkNotNullParameter(cardListDetailFragment, "");
        ((CardFilterBottomsheetFragment) cardListDetailFragment.scheduleImpl.getValue()).show(cardListDetailFragment.getChildFragmentManager(), "CardFilterBottomsheetFragment");
    }

    public static final /* synthetic */ CardListAdapter PlaceComponentResult(CardListDetailFragment cardListDetailFragment) {
        return (CardListAdapter) cardListDetailFragment.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CardListDetailFragment cardListDetailFragment, String str) {
        Context context = cardListDetailFragment.getContext();
        if (context != null) {
            if (UrlUtil.isDeepLink(str)) {
                DanaDeeplinkHelper.INSTANCE.openUrl(context, str, "DANAPoly");
            } else {
                DanaH5Helper.INSTANCE.openUrl(context, str);
            }
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CardListDetailFragment cardListDetailFragment) {
        RewardType rewardType;
        if (!((DanapolyCardsDetailViewModel) cardListDetailFragment.MyBillsEntityDataFactory.getValue()).getBuiltInFictitiousFunctionClassFactory() || !(!((CardListAdapter) cardListDetailFragment.BuiltInFictitiousFunctionClassFactory.getValue()).getAuthRequestContext.isEmpty()) == true || cardListDetailFragment.lookAheadTest || (rewardType = cardListDetailFragment.getAuthRequestContext) == null) {
            return;
        }
        cardListDetailFragment.lookAheadTest = true;
        ((DanapolyCardsDetailViewModel) cardListDetailFragment.MyBillsEntityDataFactory.getValue()).BuiltInFictitiousFunctionClassFactory(rewardType, cardListDetailFragment.PlaceComponentResult.getSortName(), cardListDetailFragment.KClassImpl$Data$declaredNonStaticMembers$2, true);
    }

    public static final /* synthetic */ void scheduleImpl(CardListDetailFragment cardListDetailFragment) {
        RewardType rewardType = cardListDetailFragment.getAuthRequestContext;
        if (rewardType != null) {
            cardListDetailFragment.lookAheadTest = true;
            ((DanapolyCardsDetailViewModel) cardListDetailFragment.MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            ((DanapolyCardsDetailViewModel) cardListDetailFragment.MyBillsEntityDataFactory.getValue()).BuiltInFictitiousFunctionClassFactory(rewardType, cardListDetailFragment.PlaceComponentResult.getSortName(), cardListDetailFragment.KClassImpl$Data$declaredNonStaticMembers$2, false);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(CardListDetailFragment cardListDetailFragment, List list) {
        CardListAdapter cardListAdapter = (CardListAdapter) cardListDetailFragment.BuiltInFictitiousFunctionClassFactory.getValue();
        List<CardItemModel> mutableList = CollectionsKt.toMutableList((Collection) list);
        Intrinsics.checkNotNullParameter(mutableList, "");
        cardListAdapter.getAuthRequestContext = mutableList;
        cardListAdapter.notifyDataSetChanged();
    }

    public final void PlaceComponentResult(ErrorState p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            RecyclerView recyclerView = ((FragmentCardListDetailBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(8);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                LinearLayout linearLayout = ((FragmentCardListDetailBinding) vb2).PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                linearLayout.setVisibility(0);
                if (p0 == ErrorState.EMPTY) {
                    VB vb3 = this.PlaceComponentResult;
                    if (vb3 != 0) {
                        AppCompatImageView appCompatImageView = ((FragmentCardListDetailBinding) vb3).PlaceComponentResult.MyBillsEntityDataFactory;
                        int i = R.drawable.res_0x7f080801_networkuserentitydata_externalsyntheticlambda5;
                        if (appCompatImageView instanceof ImageView) {
                            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                        } else {
                            appCompatImageView.setImageResource(i);
                        }
                        VB vb4 = this.PlaceComponentResult;
                        if (vb4 != 0) {
                            ((FragmentCardListDetailBinding) vb4).PlaceComponentResult.getAuthRequestContext.setText(getString(R.string.card_detail_empty_title));
                            VB vb5 = this.PlaceComponentResult;
                            if (vb5 != 0) {
                                ((FragmentCardListDetailBinding) vb5).PlaceComponentResult.PlaceComponentResult.setText(getString(R.string.card_detail_empty_desc));
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                VB vb6 = this.PlaceComponentResult;
                if (vb6 != 0) {
                    AppCompatImageView appCompatImageView2 = ((FragmentCardListDetailBinding) vb6).PlaceComponentResult.MyBillsEntityDataFactory;
                    int i2 = R.drawable.ic_danapoly_error_illustration;
                    if (appCompatImageView2 instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(appCompatImageView2, i2);
                    } else {
                        appCompatImageView2.setImageResource(i2);
                    }
                    VB vb7 = this.PlaceComponentResult;
                    if (vb7 != 0) {
                        ((FragmentCardListDetailBinding) vb7).PlaceComponentResult.getAuthRequestContext.setText(getString(R.string.card_list_error_title));
                        VB vb8 = this.PlaceComponentResult;
                        if (vb8 != 0) {
                            ((FragmentCardListDetailBinding) vb8).PlaceComponentResult.PlaceComponentResult.setText(getString(R.string.card_list_error_desc));
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

    public final void BuiltInFictitiousFunctionClassFactory() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            RecyclerView recyclerView = ((FragmentCardListDetailBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(0);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                LinearLayout linearLayout = ((FragmentCardListDetailBinding) vb2).PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                linearLayout.setVisibility(8);
                return;
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
        this.moveToNextValue = MyBillsEntityDataFactory;
        if (MyBillsEntityDataFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            MyBillsEntityDataFactory = null;
        }
        MyBillsEntityDataFactory.PlaceComponentResult(this);
        StateFlow<DanapolyCardsDetailUiState> stateFlow = ((DanapolyCardsDetailViewModel) this.MyBillsEntityDataFactory.getValue()).PlaceComponentResult;
        Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        Flow onEach = FlowKt.onEach(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle), new CardListDetailFragment$initViewModel$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            RecyclerView recyclerView = ((FragmentCardListDetailBinding) vb).BuiltInFictitiousFunctionClassFactory;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter((CardListAdapter) this.BuiltInFictitiousFunctionClassFactory.getValue());
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$getItemDecoration$1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public final void getItemOffsets(Rect p0, View p1, RecyclerView p2, RecyclerView.State p3) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                    Intrinsics.checkNotNullParameter(p2, "");
                    Intrinsics.checkNotNullParameter(p3, "");
                    p0.bottom = ViewExtKt.getAuthRequestContext(12.0f);
                }
            });
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$initAdapter$1$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p0.canScrollVertically(130)) {
                        return;
                    }
                    CardListDetailFragment.BuiltInFictitiousFunctionClassFactory(CardListDetailFragment.this);
                }
            });
            ((CardListAdapter) this.BuiltInFictitiousFunctionClassFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2 = new CardListAdapter.Listener() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$initAdapter$2
                @Override // id.dana.danapoly.ui.cards.adapter.CardListAdapter.Listener
                public final void MyBillsEntityDataFactory(CardItemModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    new CardDetailBottomsheetFragment(p0, new Function1<String, Unit>() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$openCardDetailBottomSheet$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(String str) {
                            Intrinsics.checkNotNullParameter(str, "");
                            CardListDetailFragment.MyBillsEntityDataFactory(CardListDetailFragment.this, str);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }
                    }).show(CardListDetailFragment.this.getParentFragmentManager(), "CardDetailBottomsheetFragment");
                }
            };
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                AppCompatImageView appCompatImageView = ((FragmentCardListDetailBinding) vb2).MyBillsEntityDataFactory.getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(0);
                int i = R.drawable.ic_sorting;
                if (appCompatImageView instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                } else {
                    appCompatImageView.setImageResource(i);
                }
                appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CardListDetailFragment.KClassImpl$Data$declaredNonStaticMembers$2(CardListDetailFragment.this);
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    AppCompatImageView appCompatImageView2 = ((FragmentCardListDetailBinding) vb3).MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i2 = R.drawable.res_0x7f08091c_verifypinstatemanager_executeriskchallenge_2_2;
                    if (appCompatImageView2 instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(appCompatImageView2, i2);
                    } else {
                        appCompatImageView2.setImageResource(i2);
                    }
                    appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CardListDetailFragment.MyBillsEntityDataFactory(CardListDetailFragment.this);
                        }
                    });
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentCardListDetailBinding) vb4).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.cards.CardListDetailFragment$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CardListDetailFragment.getAuthRequestContext(CardListDetailFragment.this);
                            }
                        });
                        VB vb5 = this.PlaceComponentResult;
                        if (vb5 != 0) {
                            ((FragmentCardListDetailBinding) vb5).PlaceComponentResult.getAuthRequestContext.setText(getString(R.string.card_detail_empty_title));
                            VB vb6 = this.PlaceComponentResult;
                            if (vb6 != 0) {
                                ((FragmentCardListDetailBinding) vb6).PlaceComponentResult.PlaceComponentResult.setText(getString(R.string.card_detail_empty_desc));
                                Bundle arguments = getArguments();
                                if (arguments != null) {
                                    CardListWrapperModel cardListWrapperModel = (CardListWrapperModel) arguments.getParcelable("CARD_ITEMS");
                                    if (cardListWrapperModel != null) {
                                        if ((!cardListWrapperModel.getItems().isEmpty()) != false) {
                                            RewardType rewardType = cardListWrapperModel.getRewardType();
                                            VB vb7 = this.PlaceComponentResult;
                                            if (vb7 != 0) {
                                                AppCompatImageView appCompatImageView3 = ((FragmentCardListDetailBinding) vb7).MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                                                Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
                                                appCompatImageView3.setVisibility(rewardType == RewardType.DARE ? 0 : 8);
                                                List mutableList = CollectionsKt.toMutableList((Collection) cardListWrapperModel.getItems());
                                                CardListAdapter cardListAdapter = (CardListAdapter) this.BuiltInFictitiousFunctionClassFactory.getValue();
                                                List<CardItemModel> mutableList2 = CollectionsKt.toMutableList((Collection) mutableList);
                                                Intrinsics.checkNotNullParameter(mutableList2, "");
                                                cardListAdapter.getAuthRequestContext = mutableList2;
                                                cardListAdapter.notifyDataSetChanged();
                                                BuiltInFictitiousFunctionClassFactory();
                                                this.getAuthRequestContext = ((CardItemModel) CollectionsKt.first((List) cardListWrapperModel.getItems())).getCardType();
                                                ((DanapolyCardsDetailViewModel) this.MyBillsEntityDataFactory.getValue()).BuiltInFictitiousFunctionClassFactory = cardListWrapperModel.getHasMore();
                                                DanapolyCardsDetailViewModel danapolyCardsDetailViewModel = (DanapolyCardsDetailViewModel) this.MyBillsEntityDataFactory.getValue();
                                                danapolyCardsDetailViewModel.KClassImpl$Data$declaredNonStaticMembers$2 = 2;
                                                MutableStateFlow<DanapolyCardsDetailUiState> mutableStateFlow = danapolyCardsDetailViewModel.MyBillsEntityDataFactory;
                                                do {
                                                } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), DanapolyCardsDetailUiState.None.INSTANCE));
                                            } else {
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                        }
                                    }
                                    PlaceComponentResult(ErrorState.EMPTY);
                                }
                                LocaleUtil localeUtil = LocaleUtil.INSTANCE;
                                String str = LocaleUtil.PlaceComponentResult() ? "json/lottie/wallet_close_detail_page_id.lottie" : "json/lottie/wallet_close_detail_page_en.lottie";
                                VB vb8 = this.PlaceComponentResult;
                                if (vb8 != 0) {
                                    ((FragmentCardListDetailBinding) vb8).getAuthRequestContext.setAnimation(str);
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
}
