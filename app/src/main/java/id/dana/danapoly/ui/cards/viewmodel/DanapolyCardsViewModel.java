package id.dana.danapoly.ui.cards.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.danapoly.domain.rewards.interactor.GetRewardList;
import id.dana.danapoly.domain.rewards.model.CardsSourcePage;
import id.dana.danapoly.domain.rewards.model.GetRewardResult;
import id.dana.danapoly.domain.rewards.model.GetRewardsParams;
import id.dana.danapoly.ui.cards.mapper.CardModelMapperKt;
import id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsUiState;
import id.dana.danapoly.ui.enums.RewardType;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsViewModel;", "Landroidx/lifecycle/ViewModel;", "", "getAuthRequestContext", "()V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/danapoly/domain/rewards/interactor/GetRewardList;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/domain/rewards/interactor/GetRewardList;", "PlaceComponentResult", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/danapoly/domain/rewards/interactor/GetRewardList;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyCardsViewModel extends ViewModel {
    private final MutableStateFlow<DanapolyCardsUiState> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetRewardList PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final StateFlow<DanapolyCardsUiState> MyBillsEntityDataFactory;

    @Inject
    public DanapolyCardsViewModel(GetRewardList getRewardList) {
        Intrinsics.checkNotNullParameter(getRewardList, "");
        this.PlaceComponentResult = getRewardList;
        MutableStateFlow<DanapolyCardsUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(DanapolyCardsUiState.None.INSTANCE);
        this.BuiltInFictitiousFunctionClassFactory = MutableStateFlow;
        this.MyBillsEntityDataFactory = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void getAuthRequestContext() {
        BaseFlowUseCase.execute$default(this.PlaceComponentResult, new GetRewardsParams(null, CollectionsKt.listOf((Object[]) new String[]{RewardType.DARE.name(), RewardType.TRICK.name(), RewardType.TRIVIA.name(), RewardType.TREASURE.name(), RewardType.DANA_BALANCE.name()}), null, null, 1, 0, CardsSourcePage.LIST, 45, null), null, new Function1<GetRewardResult, Unit>() { // from class: id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsViewModel$getAllRewardList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GetRewardResult getRewardResult) {
                invoke2(getRewardResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GetRewardResult getRewardResult) {
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(getRewardResult, "");
                if (getRewardResult.getAllRewards().isEmpty()) {
                    mutableStateFlow2 = DanapolyCardsViewModel.this.BuiltInFictitiousFunctionClassFactory;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        DanapolyCardsUiState danapolyCardsUiState = (DanapolyCardsUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, DanapolyCardsUiState.OnCardListEmpty.INSTANCE));
                    return;
                }
                mutableStateFlow = DanapolyCardsViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyCardsUiState danapolyCardsUiState2 = (DanapolyCardsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyCardsUiState.OnInitialCardListLoaded(CardModelMapperKt.PlaceComponentResult(getRewardResult.getAllRewards()))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsViewModel$getAllRewardList$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = DanapolyCardsViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyCardsUiState danapolyCardsUiState = (DanapolyCardsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyCardsUiState.OnCardListError(th)));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }
}
