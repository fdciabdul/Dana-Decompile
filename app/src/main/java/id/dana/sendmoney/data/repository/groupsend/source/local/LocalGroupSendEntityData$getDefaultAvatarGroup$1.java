package id.dana.sendmoney.data.repository.groupsend.source.local;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.data.repository.groupsend.source.local.LocalGroupSendEntityData$getDefaultAvatarGroup$1", f = "LocalGroupSendEntityData.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class LocalGroupSendEntityData$getDefaultAvatarGroup$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LocalGroupSendEntityData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalGroupSendEntityData$getDefaultAvatarGroup$1(LocalGroupSendEntityData localGroupSendEntityData, Continuation<? super LocalGroupSendEntityData$getDefaultAvatarGroup$1> continuation) {
        super(2, continuation);
        this.this$0 = localGroupSendEntityData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LocalGroupSendEntityData$getDefaultAvatarGroup$1 localGroupSendEntityData$getDefaultAvatarGroup$1 = new LocalGroupSendEntityData$getDefaultAvatarGroup$1(this.this$0, continuation);
        localGroupSendEntityData$getDefaultAvatarGroup$1.L$0 = obj;
        return localGroupSendEntityData$getDefaultAvatarGroup$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        return ((LocalGroupSendEntityData$getDefaultAvatarGroup$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Integer integer = groupSendPreference.getAuthRequestContext.getInteger("RandomizeAvatars");
            Intrinsics.checkNotNullExpressionValue(integer, "");
            this.label = 1;
            if (flowCollector.emit(Boxing.boxInt(integer.intValue()), this) == coroutine_suspended) {
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
