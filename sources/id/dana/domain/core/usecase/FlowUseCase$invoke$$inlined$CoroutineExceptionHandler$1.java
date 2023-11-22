package id.dana.domain.core.usecase;

import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¸\u0006\n"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "", "exception", "", "handleException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FlowUseCase$invoke$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ Function1 $onError$inlined;
    final /* synthetic */ FlowUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowUseCase$invoke$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Companion companion, FlowUseCase flowUseCase, Function1 function1) {
        super(companion);
        this.this$0 = flowUseCase;
        this.$onError$inlined = function1;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext context, Throwable exception) {
        CoroutineDispatcher coroutineDispatcher;
        FlowUseCase flowUseCase = this.this$0;
        FlowUseCase flowUseCase2 = flowUseCase;
        coroutineDispatcher = flowUseCase.coroutineDispatcher;
        BuildersKt__Builders_commonKt.launch$default(flowUseCase2, coroutineDispatcher, null, new FlowUseCase$invoke$handler$1$1(this.$onError$inlined, exception, null), 2, null);
    }
}
