package id.dana.sendmoney.data.repository.globalsend.source.local;

import id.dana.sendmoney.domain.globalsend.model.sender.SenderDetail;
import id.dana.utils.extension.JSONExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.globalsend.source.local.LocalGlobalSendEntityData$getSenderDetail$1", f = "LocalGlobalSendEntityData.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class LocalGlobalSendEntityData$getSenderDetail$1 extends SuspendLambda implements Function2<FlowCollector<? super SenderDetail>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LocalGlobalSendEntityData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalGlobalSendEntityData$getSenderDetail$1(LocalGlobalSendEntityData localGlobalSendEntityData, Continuation<? super LocalGlobalSendEntityData$getSenderDetail$1> continuation) {
        super(2, continuation);
        this.this$0 = localGlobalSendEntityData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LocalGlobalSendEntityData$getSenderDetail$1 localGlobalSendEntityData$getSenderDetail$1 = new LocalGlobalSendEntityData$getSenderDetail$1(this.this$0, continuation);
        localGlobalSendEntityData$getSenderDetail$1.L$0 = obj;
        return localGlobalSendEntityData$getSenderDetail$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super SenderDetail> flowCollector, Continuation<? super Unit> continuation) {
        return ((LocalGlobalSendEntityData$getSenderDetail$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GlobalSendPreference globalSendPreference;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            globalSendPreference = this.this$0.BuiltInFictitiousFunctionClassFactory;
            String string = globalSendPreference.BuiltInFictitiousFunctionClassFactory.getString("senderDetail");
            SenderDetail senderDetail = string != null ? (SenderDetail) JSONExtKt.PlaceComponentResult().fromJson(string, SenderDetail.class) : null;
            if (senderDetail == null) {
                senderDetail = new SenderDetail(false, null, null, null, null, 31, null);
            }
            this.label = 1;
            if (flowCollector.emit(senderDetail, this) == coroutine_suspended) {
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
