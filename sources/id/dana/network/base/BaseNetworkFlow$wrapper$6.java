package id.dana.network.base;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.util.BaseNetworkUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [S] */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@"}, d2 = {"Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "S", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "throwable", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.network.base.BaseNetworkFlow$wrapper$6", f = "BaseNetworkFlow.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class BaseNetworkFlow$wrapper$6<S> extends SuspendLambda implements Function3<FlowCollector<? super S>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Class<S> $outputType;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNetworkFlow$wrapper$6(Class<S> cls, Continuation<? super BaseNetworkFlow$wrapper$6> continuation) {
        super(3, continuation);
        this.$outputType = cls;
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Throwable th, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector) ((FlowCollector) obj), th, continuation);
    }

    public final Object invoke(FlowCollector<? super S> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        BaseNetworkFlow$wrapper$6 baseNetworkFlow$wrapper$6 = new BaseNetworkFlow$wrapper$6(this.$outputType, continuation);
        baseNetworkFlow$wrapper$6.L$0 = flowCollector;
        baseNetworkFlow$wrapper$6.L$1 = th;
        return baseNetworkFlow$wrapper$6.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            BaseRpcResult onDeserializeFailure = BaseNetworkUtils.onDeserializeFailure(this.$outputType, (Throwable) this.L$1);
            Intrinsics.checkNotNullExpressionValue(onDeserializeFailure, "");
            this.L$0 = null;
            this.label = 1;
            if (flowCollector.emit(onDeserializeFailure, this) == coroutine_suspended) {
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
