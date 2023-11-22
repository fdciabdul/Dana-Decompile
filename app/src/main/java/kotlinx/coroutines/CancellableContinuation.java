package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\u0011\u001a\u00020\n2\u001d\u0010\u0010\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\n0\rj\u0002`\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J4\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00028\u00002\u001b\u0010\u0014\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\rH&¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00028\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0018\u0010\u0019J@\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00028\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u001b\u0010\u0014\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\rH&¢\u0006\u0004\b\u0018\u0010\u001aJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u0003H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001f\u001a\u00020\n*\u00020\u001e2\u0006\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00058'X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\""}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "", "token", "", "completeResume", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "idempotent", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "isActive", "()Z"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CancellableContinuation<T> extends Continuation<T> {
    boolean cancel(Throwable cause);

    void completeResume(Object token);

    void invokeOnCancellation(Function1<? super Throwable, Unit> handler);

    @JvmName(name = "isActive")
    boolean isActive();

    void resume(T value, Function1<? super Throwable, Unit> onCancellation);

    void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t);

    Object tryResume(T value, Object idempotent);

    Object tryResume(T value, Object idempotent, Function1<? super Throwable, Unit> onCancellation);

    Object tryResumeWithException(Throwable exception);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object tryResume$default(CancellableContinuation cancellableContinuation, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 2) != 0) {
                    obj2 = null;
                }
                return cancellableContinuation.tryResume(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }
}
