package id.dana.danapoly.ui.cards;

import id.dana.danapoly.ui.cards.CardListDetailFragment;
import id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsDetailUiState;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsDetailUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.ui.cards.CardListDetailFragment$initViewModel$1", f = "CardListDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class CardListDetailFragment$initViewModel$1 extends SuspendLambda implements Function2<DanapolyCardsDetailUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CardListDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardListDetailFragment$initViewModel$1(CardListDetailFragment cardListDetailFragment, Continuation<? super CardListDetailFragment$initViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = cardListDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CardListDetailFragment$initViewModel$1 cardListDetailFragment$initViewModel$1 = new CardListDetailFragment$initViewModel$1(this.this$0, continuation);
        cardListDetailFragment$initViewModel$1.L$0 = obj;
        return cardListDetailFragment$initViewModel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DanapolyCardsDetailUiState danapolyCardsDetailUiState, Continuation<? super Unit> continuation) {
        return ((CardListDetailFragment$initViewModel$1) create(danapolyCardsDetailUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DanapolyCardsDetailUiState danapolyCardsDetailUiState = (DanapolyCardsDetailUiState) this.L$0;
            if (danapolyCardsDetailUiState instanceof DanapolyCardsDetailUiState.OnCardDetailListLoaded) {
                if (!CardListDetailFragment.PlaceComponentResult(this.this$0).getAuthRequestContext.isEmpty()) {
                    DanapolyCardsDetailUiState.OnCardDetailListLoaded onCardDetailListLoaded = (DanapolyCardsDetailUiState.OnCardDetailListLoaded) danapolyCardsDetailUiState;
                    if (onCardDetailListLoaded.getBuiltInFictitiousFunctionClassFactory()) {
                        CardListDetailFragment.PlaceComponentResult(this.this$0).getAuthRequestContext.addAll(CollectionsKt.toMutableList((Collection) onCardDetailListLoaded.KClassImpl$Data$declaredNonStaticMembers$2));
                        CardListDetailFragment.PlaceComponentResult(this.this$0).notifyDataSetChanged();
                        this.this$0.BuiltInFictitiousFunctionClassFactory();
                    }
                }
                CardListDetailFragment.PlaceComponentResult(this.this$0, CollectionsKt.toMutableList((Collection) ((DanapolyCardsDetailUiState.OnCardDetailListLoaded) danapolyCardsDetailUiState).KClassImpl$Data$declaredNonStaticMembers$2));
                this.this$0.BuiltInFictitiousFunctionClassFactory();
            } else if (danapolyCardsDetailUiState instanceof DanapolyCardsDetailUiState.OnCardDetailLoading) {
                this.this$0.lookAheadTest = true;
            } else if (danapolyCardsDetailUiState instanceof DanapolyCardsDetailUiState.OnCardDetailListError) {
                if ((!CardListDetailFragment.PlaceComponentResult(this.this$0).getAuthRequestContext.isEmpty()) != false) {
                    int size = CardListDetailFragment.PlaceComponentResult(this.this$0).getAuthRequestContext.size();
                    CardListDetailFragment.PlaceComponentResult(this.this$0).getAuthRequestContext.clear();
                    CardListDetailFragment.PlaceComponentResult(this.this$0).notifyItemRangeRemoved(0, size);
                }
                this.this$0.PlaceComponentResult(CardListDetailFragment.ErrorState.ERROR);
            } else if (danapolyCardsDetailUiState instanceof DanapolyCardsDetailUiState.OnCardDetailListEmpty) {
                if ((!CardListDetailFragment.PlaceComponentResult(this.this$0).getAuthRequestContext.isEmpty()) != false) {
                    int size2 = CardListDetailFragment.PlaceComponentResult(this.this$0).getAuthRequestContext.size();
                    CardListDetailFragment.PlaceComponentResult(this.this$0).getAuthRequestContext.clear();
                    CardListDetailFragment.PlaceComponentResult(this.this$0).notifyItemRangeRemoved(0, size2);
                }
                this.this$0.PlaceComponentResult(CardListDetailFragment.ErrorState.EMPTY);
            } else if (danapolyCardsDetailUiState instanceof DanapolyCardsDetailUiState.OnCardPaginationError) {
                this.this$0.lookAheadTest = false;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
