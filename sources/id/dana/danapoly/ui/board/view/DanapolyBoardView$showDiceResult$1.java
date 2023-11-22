package id.dana.danapoly.ui.board.view;

import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import id.dana.danapoly.databinding.ViewDanapolyBoardBinding;
import id.dana.danapoly.ui.board.view.DanapolyBoardView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.danapoly.ui.board.view.DanapolyBoardView$showDiceResult$1", f = "DanapolyBoardView.kt", i = {}, l = {190, 193}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DanapolyBoardView$showDiceResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DanapolyBoardView.PawnMovementType $movementType;
    final /* synthetic */ int $rollDiceResult;
    int label;
    final /* synthetic */ DanapolyBoardView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardView$showDiceResult$1(DanapolyBoardView danapolyBoardView, int i, DanapolyBoardView.PawnMovementType pawnMovementType, Continuation<? super DanapolyBoardView$showDiceResult$1> continuation) {
        super(2, continuation);
        this.this$0 = danapolyBoardView;
        this.$rollDiceResult = i;
        this.$movementType = pawnMovementType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DanapolyBoardView$showDiceResult$1(this.this$0, this.$rollDiceResult, this.$movementType, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DanapolyBoardView$showDiceResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DanapolyBoardView.OnRollDiceShowListener onRollDiceShowListener;
        ViewDanapolyBoardBinding binding;
        ViewDanapolyBoardBinding binding2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.setVisibility(8);
            binding = this.this$0.getBinding();
            TextView textView = binding.getSupportButtonTintMode;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(4);
            binding2 = this.this$0.getBinding();
            AppCompatImageView appCompatImageView = binding2.NetworkUserEntityData$$ExternalSyntheticLambda5;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(4);
            this.this$0.MyBillsEntityDataFactory(true);
            this.this$0.BuiltInFictitiousFunctionClassFactory(true);
            this.this$0.PlaceComponentResult(this.$rollDiceResult, this.$movementType);
            return Unit.INSTANCE;
        } else {
            ResultKt.throwOnFailure(obj);
        }
        DanapolyBoardView.access$setAndShowRollDiceResult(this.this$0, this.$rollDiceResult, this.$movementType);
        onRollDiceShowListener = this.this$0.scheduleImpl;
        if (onRollDiceShowListener != null) {
            onRollDiceShowListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        this.label = 2;
        if (DelayKt.delay(1000L, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.setVisibility(8);
        binding = this.this$0.getBinding();
        TextView textView2 = binding.getSupportButtonTintMode;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(4);
        binding2 = this.this$0.getBinding();
        AppCompatImageView appCompatImageView2 = binding2.NetworkUserEntityData$$ExternalSyntheticLambda5;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        appCompatImageView2.setVisibility(4);
        this.this$0.MyBillsEntityDataFactory(true);
        this.this$0.BuiltInFictitiousFunctionClassFactory(true);
        this.this$0.PlaceComponentResult(this.$rollDiceResult, this.$movementType);
        return Unit.INSTANCE;
    }
}
