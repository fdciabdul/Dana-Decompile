package kotlinx.coroutines.reactive;

import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.Flow;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\"\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"", "T", "Lorg/reactivestreams/Publisher;", "Lkotlinx/coroutines/flow/Flow;", "asFlow", "(Lorg/reactivestreams/Publisher;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "injectCoroutineContext", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/CoroutineContext;)Lorg/reactivestreams/Publisher;", "", "Lkotlinx/coroutines/reactive/ContextInjector;", "contextInjectors", "[Lkotlinx/coroutines/reactive/ContextInjector;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactiveFlowKt {
    private static final ContextInjector[] contextInjectors;

    public static final <T> Flow<T> asFlow(Publisher<T> publisher) {
        return new PublisherAsFlow(publisher, null, 0, null, 14, null);
    }

    static {
        Object[] array = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(ContextInjector.class, ContextInjector.class.getClassLoader()).iterator())).toArray(new ContextInjector[0]);
        if (array != null) {
            contextInjectors = (ContextInjector[]) array;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final <T> Publisher<T> injectCoroutineContext(Publisher<T> publisher, CoroutineContext coroutineContext) {
        for (ContextInjector contextInjector : contextInjectors) {
            publisher = contextInjector.injectCoroutineContext(publisher, coroutineContext);
        }
        return publisher;
    }
}
