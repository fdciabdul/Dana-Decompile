package id.dana.danapoly.ui.cards;

import id.dana.danapoly.databinding.FragmentCardsListBinding;
import id.dana.danapoly.ui.cards.CardListDetailFragment;
import id.dana.danapoly.ui.cards.viewmodel.DanapolyCardsUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/danapoly/ui/cards/viewmodel/DanapolyCardsUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.ui.cards.CardsListFragment$initViewModel$1", f = "CardsListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class CardsListFragment$initViewModel$1 extends SuspendLambda implements Function2<DanapolyCardsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CardsListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardsListFragment$initViewModel$1(CardsListFragment cardsListFragment, Continuation<? super CardsListFragment$initViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = cardsListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CardsListFragment$initViewModel$1 cardsListFragment$initViewModel$1 = new CardsListFragment$initViewModel$1(this.this$0, continuation);
        cardsListFragment$initViewModel$1.L$0 = obj;
        return cardsListFragment$initViewModel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DanapolyCardsUiState danapolyCardsUiState, Continuation<? super Unit> continuation) {
        return ((CardsListFragment$initViewModel$1) create(danapolyCardsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DanapolyCardsUiState danapolyCardsUiState = (DanapolyCardsUiState) this.L$0;
            if (danapolyCardsUiState instanceof DanapolyCardsUiState.OnInitialCardListLoaded) {
                DanapolyCardsUiState.OnInitialCardListLoaded onInitialCardListLoaded = (DanapolyCardsUiState.OnInitialCardListLoaded) danapolyCardsUiState;
                this.this$0.PlaceComponentResult = onInitialCardListLoaded.getAuthRequestContext;
                CardsListFragment.getAuthRequestContext(this.this$0, onInitialCardListLoaded.getAuthRequestContext);
                VB vb = this.this$0.PlaceComponentResult;
                if (vb != 0) {
                    ((FragmentCardsListBinding) vb).initRecordTimeStamp.cancelRefreshProgress();
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else if (danapolyCardsUiState instanceof DanapolyCardsUiState.OnCardListError) {
                this.this$0.getAuthRequestContext(CardListDetailFragment.ErrorState.ERROR);
                VB vb2 = this.this$0.PlaceComponentResult;
                if (vb2 != 0) {
                    ((FragmentCardsListBinding) vb2).initRecordTimeStamp.cancelRefreshProgress();
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else if (danapolyCardsUiState instanceof DanapolyCardsUiState.OnCardListEmpty) {
                this.this$0.getAuthRequestContext(CardListDetailFragment.ErrorState.EMPTY);
                VB vb3 = this.this$0.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentCardsListBinding) vb3).initRecordTimeStamp.cancelRefreshProgress();
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
