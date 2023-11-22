package id.dana.sendmoney.data.repository.groupsend.source.local;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.source.local.LocalGroupSendEntityData$saveDefaultAvatarGroup$1", f = "LocalGroupSendEntityData.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class LocalGroupSendEntityData$saveDefaultAvatarGroup$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $lastStateSelected;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LocalGroupSendEntityData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalGroupSendEntityData$saveDefaultAvatarGroup$1(LocalGroupSendEntityData localGroupSendEntityData, int i, Continuation<? super LocalGroupSendEntityData$saveDefaultAvatarGroup$1> continuation) {
        super(2, continuation);
        this.this$0 = localGroupSendEntityData;
        this.$lastStateSelected = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LocalGroupSendEntityData$saveDefaultAvatarGroup$1 localGroupSendEntityData$saveDefaultAvatarGroup$1 = new LocalGroupSendEntityData$saveDefaultAvatarGroup$1(this.this$0, this.$lastStateSelected, continuation);
        localGroupSendEntityData$saveDefaultAvatarGroup$1.L$0 = obj;
        return localGroupSendEntityData$saveDefaultAvatarGroup$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Unit> flowCollector, Continuation<? super Unit> continuation) {
        return ((LocalGroupSendEntityData$saveDefaultAvatarGroup$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GroupSendPreference groupSendPreference;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            groupSendPreference = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
            groupSendPreference.getAuthRequestContext.saveData("RandomizeAvatars", Integer.valueOf(this.$lastStateSelected));
            this.label = 1;
            if (flowCollector.emit(Unit.INSTANCE, this) == coroutine_suspended) {
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
