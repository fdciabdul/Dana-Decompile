package id.dana.danapoly.ui.cards.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.danapoly.domain.rewards.interactor.GetRewardList;
import id.dana.danapoly.domain.rewards.model.CardsSourcePage;
import id.dana.danapoly.domain.rewards.model.GetRewardResult;
import id.dana.danapoly.domain.rewards.model.GetRewardsParams;
import id.dana.danapoly.domain.rewards.model.RewardItem;
import id.dana.danapoly.domain.rewards.model.RewardList;
import id.dana.danapoly.ui.cards.mapper.CardModelMapperKt;
import id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsDetailUiState;
import id.dana.danapoly.ui.enums.CardFilterUiType;
import id.dana.danapoly.ui.enums.RewardType;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\b8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0016\u001a\u00020\u0018X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aX\u0007¢\u0006\u0006\n\u0004\b\u0016\u0010\u001b"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/danapoly/ui/enums/RewardType;", "p0", "", "p1", "Lid/dana/danapoly/ui/enums/CardFilterUiType;", "p2", "", "p3", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/danapoly/ui/enums/RewardType;Ljava/lang/String;Lid/dana/danapoly/ui/enums/CardFilterUiType;Z)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "MyBillsEntityDataFactory", "Lid/dana/danapoly/domain/rewards/interactor/GetRewardList;", "PlaceComponentResult", "Lid/dana/danapoly/domain/rewards/interactor/GetRewardList;", "getAuthRequestContext", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "", "I", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "<init>", "(Lid/dana/danapoly/domain/rewards/interactor/GetRewardList;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyCardsDetailViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final MutableStateFlow<DanapolyCardsDetailUiState> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final StateFlow<DanapolyCardsDetailUiState> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetRewardList getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    @Inject
    public DanapolyCardsDetailViewModel(GetRewardList getRewardList) {
        Intrinsics.checkNotNullParameter(getRewardList, "");
        this.getAuthRequestContext = getRewardList;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        MutableStateFlow<DanapolyCardsDetailUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(DanapolyCardsDetailUiState.None.INSTANCE);
        this.MyBillsEntityDataFactory = MutableStateFlow;
        this.PlaceComponentResult = FlowKt.asStateFlow(MutableStateFlow);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final void BuiltInFictitiousFunctionClassFactory(RewardType p0, String p1, CardFilterUiType p2, final boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        String str = null;
        BaseFlowUseCase.execute$default(this.getAuthRequestContext, new GetRewardsParams(str, CollectionsKt.listOf(p0.name()), p2.getStatusBasedOnFilterType(), p1, this.KClassImpl$Data$declaredNonStaticMembers$2, 0, CardsSourcePage.STACK, 33, null), new Function0<Unit>() { // from class: id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsDetailViewModel$getRewardList$1
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = DanapolyCardsDetailViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyCardsDetailUiState danapolyCardsDetailUiState = (DanapolyCardsDetailUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, DanapolyCardsDetailUiState.OnCardDetailLoading.INSTANCE));
            }
        }, new Function1<GetRewardResult, Unit>() { // from class: id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsDetailViewModel$getRewardList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ArrayList arrayList;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(getRewardResult, "");
                if (getRewardResult.getAllRewards().isEmpty()) {
                    mutableStateFlow2 = DanapolyCardsDetailViewModel.this.MyBillsEntityDataFactory;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        DanapolyCardsDetailUiState danapolyCardsDetailUiState = (DanapolyCardsDetailUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, DanapolyCardsDetailUiState.OnCardDetailListEmpty.INSTANCE));
                    return;
                }
                DanapolyCardsDetailViewModel.this.BuiltInFictitiousFunctionClassFactory = ((RewardList) CollectionsKt.first((List) getRewardResult.getAllRewards())).getItemsPaginator().getHasMore();
                DanapolyCardsDetailViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2++;
                mutableStateFlow = DanapolyCardsDetailViewModel.this.MyBillsEntityDataFactory;
                boolean z = p3;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyCardsDetailUiState danapolyCardsDetailUiState2 = (DanapolyCardsDetailUiState) value;
                    List<RewardItem> items = ((RewardList) CollectionsKt.first((List) getRewardResult.getAllRewards())).getItems();
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
                    for (RewardItem rewardItem : items) {
                        arrayList.add(CardModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(rewardItem, RewardType.valueOf(rewardItem.getType())));
                    }
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyCardsDetailUiState.OnCardDetailListLoaded(arrayList, z)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsDetailViewModel$getRewardList$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(th, "");
                if (!p3) {
                    mutableStateFlow2 = this.MyBillsEntityDataFactory;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        DanapolyCardsDetailUiState danapolyCardsDetailUiState = (DanapolyCardsDetailUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, new DanapolyCardsDetailUiState.OnCardDetailListError(th)));
                    return;
                }
                mutableStateFlow = this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyCardsDetailUiState danapolyCardsDetailUiState2 = (DanapolyCardsDetailUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, DanapolyCardsDetailUiState.OnCardPaginationError.INSTANCE));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 16, null);
    }
}
