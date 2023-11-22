package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 &2\u00020\u0001:\u0001&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00060\u0007j\u0002`\bH&¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001d\u0010\u0016\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u0013¢\u0006\u0002\b\u0014\u0012\u0004\u0012\u00020\n0\u0012j\u0002`\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J.\u0010\u0018\u001a\u00020\u00172\u001d\u0010\u0016\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u0013¢\u0006\u0002\b\u0014\u0012\u0004\u0012\u00020\n0\u0012j\u0002`\u0015H&¢\u0006\u0004\b\u0018\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000fH&¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00000\u001f8'X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u000f8'X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0014\u0010$\u001a\u00020\u000f8'X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001eR\u0014\u0010%\u001a\u00020\u000f8'X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "()Z", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "isActive", "isCancelled", "isCompleted", "Key"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Job extends CoroutineContext.Element {

    /* renamed from: Key  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    ChildHandle attachChild(ChildJob child);

    void cancel(CancellationException cause);

    CancellationException getCancellationException();

    @JvmName(name = "getChildren")
    Sequence<Job> getChildren();

    DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> handler);

    DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler);

    @JvmName(name = "isActive")
    boolean isActive();

    @JvmName(name = "isCancelled")
    boolean isCancelled();

    @JvmName(name = "isCompleted")
    boolean isCompleted();

    Object join(Continuation<? super Unit> continuation);

    boolean start();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static <R> R fold(Job job, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(job, r, function2);
        }

        public static <E extends CoroutineContext.Element> E get(Job job, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.get(job, key);
        }

        public static CoroutineContext minusKey(Job job, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey(job, key);
        }

        public static CoroutineContext plus(Job job, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(job, coroutineContext);
        }

        public static /* synthetic */ void cancel$default(Job job, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            job.cancel(cancellationException);
        }

        public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return job.invokeOnCompletion(z, z2, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.Job$Key  reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion implements CoroutineContext.Key<Job> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
