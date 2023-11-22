package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.reactivestreams.Subscriber;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\"&\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext;", "", "DEFAULT_HANDLER", "Lkotlin/jvm/functions/Function2;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PublishKt {
    private static final Function2<Throwable, CoroutineContext, Unit> DEFAULT_HANDLER = new Function2<Throwable, CoroutineContext, Unit>() { // from class: kotlinx.coroutines.reactive.PublishKt$DEFAULT_HANDLER$1
        @Override // kotlin.jvm.functions.Function2
        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th, CoroutineContext coroutineContext) {
            invoke2(th, coroutineContext);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th, CoroutineContext coroutineContext) {
            if (th instanceof CancellationException) {
                return;
            }
            CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, th);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: publishInternal$lambda-1  reason: not valid java name */
    public static final void m4670publishInternal$lambda1(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, Function2 function22, Subscriber subscriber) {
        if (subscriber == null) {
            throw new NullPointerException("Subscriber cannot be null");
        }
        PublisherCoroutine publisherCoroutine = new PublisherCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext), subscriber, function2);
        subscriber.onSubscribe(publisherCoroutine);
        publisherCoroutine.start(CoroutineStart.DEFAULT, publisherCoroutine, function22);
    }
}
