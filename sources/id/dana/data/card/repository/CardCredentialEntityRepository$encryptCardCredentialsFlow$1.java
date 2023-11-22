package id.dana.data.card.repository;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.data.card.repository.CardCredentialEntityRepository$encryptCardCredentialsFlow$1", f = "CardCredentialEntityRepository.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class CardCredentialEntityRepository$encryptCardCredentialsFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $cardCredentials;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CardCredentialEntityRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardCredentialEntityRepository$encryptCardCredentialsFlow$1(CardCredentialEntityRepository cardCredentialEntityRepository, Map<String, String> map, Continuation<? super CardCredentialEntityRepository$encryptCardCredentialsFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = cardCredentialEntityRepository;
        this.$cardCredentials = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CardCredentialEntityRepository$encryptCardCredentialsFlow$1 cardCredentialEntityRepository$encryptCardCredentialsFlow$1 = new CardCredentialEntityRepository$encryptCardCredentialsFlow$1(this.this$0, this.$cardCredentials, continuation);
        cardCredentialEntityRepository$encryptCardCredentialsFlow$1.L$0 = obj;
        return cardCredentialEntityRepository$encryptCardCredentialsFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
        return ((CardCredentialEntityRepository$encryptCardCredentialsFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            String blockingFirst = this.this$0.encryptCardCredentials(this.$cardCredentials).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            this.label = 1;
            if (flowCollector.emit(blockingFirst, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
