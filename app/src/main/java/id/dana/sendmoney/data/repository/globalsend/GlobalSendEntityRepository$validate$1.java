package id.dana.sendmoney.data.repository.globalsend;

import id.dana.sendmoney.data.api.globalsend.validate.mapper.TransferValidateEntityMapperKt;
import id.dana.sendmoney.data.api.globalsend.validate.model.response.TransferValidateEntityResult;
import id.dana.sendmoney.domain.globalsend.model.validate.TransferValidateRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "cardCredential", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/response/TransferValidateEntityResult;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository$validate$1", f = "GlobalSendEntityRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class GlobalSendEntityRepository$validate$1 extends SuspendLambda implements Function2<String, Continuation<? super Flow<? extends TransferValidateEntityResult>>, Object> {
    final /* synthetic */ TransferValidateRequest $validateRequest;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GlobalSendEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSendEntityRepository$validate$1(GlobalSendEntityRepository globalSendEntityRepository, TransferValidateRequest transferValidateRequest, Continuation<? super GlobalSendEntityRepository$validate$1> continuation) {
        super(2, continuation);
        this.this$0 = globalSendEntityRepository;
        this.$validateRequest = transferValidateRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GlobalSendEntityRepository$validate$1 globalSendEntityRepository$validate$1 = new GlobalSendEntityRepository$validate$1(this.this$0, this.$validateRequest, continuation);
        globalSendEntityRepository$validate$1.L$0 = obj;
        return globalSendEntityRepository$validate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super Flow<? extends TransferValidateEntityResult>> continuation) {
        return invoke2(str, (Continuation<? super Flow<TransferValidateEntityResult>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, Continuation<? super Flow<TransferValidateEntityResult>> continuation) {
        return ((GlobalSendEntityRepository$validate$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return GlobalSendEntityRepository.BuiltInFictitiousFunctionClassFactory(this.this$0).PlaceComponentResult(TransferValidateEntityMapperKt.toTransferValidateEntityRequest(this.$validateRequest, (String) this.L$0));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
