package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00060\bj\u0002`\tH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJH\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102'\u0010\u0018\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0013j\u0002`\u0017H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ8\u0010\u001a\u001a\u00020\u00192'\u0010\u0018\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0013j\u0002`\u0017H\u0017¢\u0006\u0004\b\u001a\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u000bH\u0097@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020$8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010 R\u0014\u0010)\u001a\u00020\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010 R\u0014\u0010*\u001a\u00020\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010 \u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "()Z", "", "toString", "()Ljava/lang/String;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "isActive", "isCancelled", "isCompleted", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {
    public static final NonCancellable INSTANCE = new NonCancellable();

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public final void cancel(CancellationException cause) {
    }

    @Override // kotlinx.coroutines.Job
    @JvmName(name = "isActive")
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    @JvmName(name = "isCancelled")
    public final boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @JvmName(name = "isCompleted")
    public final boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }

    private NonCancellable() {
        super(Job.INSTANCE);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public final Object join(Continuation<? super Unit> continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public final CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public final DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    @JvmName(name = "getChildren")
    public final Sequence<Job> getChildren() {
        return SequencesKt.emptySequence();
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public final ChildHandle attachChild(ChildJob child) {
        return NonDisposableHandle.INSTANCE;
    }
}
