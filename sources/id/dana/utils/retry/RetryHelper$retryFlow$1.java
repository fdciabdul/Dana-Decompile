package id.dana.utils.retry;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [S] */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@"}, d2 = {"", "S", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.utils.retry.RetryHelper$retryFlow$1", f = "RetryHelper.kt", i = {1, 1, 3}, l = {49, 66, 73, 87, 94}, m = "invokeSuspend", n = {"$this$flow", "factor", "$this$flow"}, s = {"L$0", "I$2", "L$0"})
/* loaded from: classes5.dex */
public final class RetryHelper$retryFlow$1<S> extends SuspendLambda implements Function2<FlowCollector<? super S>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<S> $block;
    final /* synthetic */ Long $delayInMillis;
    final /* synthetic */ Function0<Observable<Boolean>> $holdLoginV2Processing;
    final /* synthetic */ Function4<String, String, String, Throwable, Unit> $logErrorRetryOperationType;
    final /* synthetic */ int $maxRetry;
    final /* synthetic */ String $operationType;
    final /* synthetic */ Function1<Throwable, Boolean> $predicate;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RetryHelper$retryFlow$1(Function0<? extends S> function0, int i, Function0<? extends Observable<Boolean>> function02, Long l, String str, Function4<? super String, ? super String, ? super String, ? super Throwable, Unit> function4, Function1<? super Throwable, Boolean> function1, Continuation<? super RetryHelper$retryFlow$1> continuation) {
        super(2, continuation);
        this.$block = function0;
        this.$maxRetry = i;
        this.$holdLoginV2Processing = function02;
        this.$delayInMillis = l;
        this.$operationType = str;
        this.$logErrorRetryOperationType = function4;
        this.$predicate = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RetryHelper$retryFlow$1 retryHelper$retryFlow$1 = new RetryHelper$retryFlow$1(this.$block, this.$maxRetry, this.$holdLoginV2Processing, this.$delayInMillis, this.$operationType, this.$logErrorRetryOperationType, this.$predicate, continuation);
        retryHelper$retryFlow$1.L$0 = obj;
        return retryHelper$retryFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object invoke(FlowCollector<? super S> flowCollector, Continuation<? super Unit> continuation) {
        return ((RetryHelper$retryFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:62|(1:63)|64|65|66|67|68|(1:70)|47|48|49|50|(0)(4:52|(1:54)|41|42)) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:14|(3:15|16|17)|18|19|20|21|(4:23|(1:25)|9|10)(2:26|(2:31|32)(1:30))) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012f, code lost:
    
        r2 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0133, code lost:
    
        r1 = r11;
        r11 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01e4, code lost:
    
        r1 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.m3179constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0212  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x012b -> B:56:0x0140). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0135 -> B:56:0x0140). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.retry.RetryHelper$retryFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
