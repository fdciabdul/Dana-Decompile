package id.dana.domain.core.usecase;

import com.alibaba.ariver.kernel.RVEvents;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b(\u0010\nJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0004\u001a\u00028\u0001H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ]\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u00012\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\rj\u0002`\u00112\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\b0\u0013j\u0002`\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001d"}, d2 = {"Lid/dana/domain/core/usecase/CancellableUseCase;", "T", "Params", "", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/lang/Object;)Lio/reactivex/Observable;", "", "cancel", "()V", "destroy", "dispose", "Lkotlin/Function1;", "Lid/dana/domain/core/usecase/OnSuccessCallback;", "onSuccess", "", "Lid/dana/domain/core/usecase/OnErrorCallback;", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "Lkotlin/Function0;", "Lid/dana/domain/core/usecase/OnCancelCallback;", "onCancel", "execute", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/disposables/Disposable;", "disposable", "Lio/reactivex/disposables/Disposable;", "Lkotlinx/coroutines/CoroutineScope;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", "observableJob", "Lkotlinx/coroutines/Job;", "Ljava/lang/Thread;", "observableWorkerThread", "Ljava/lang/Thread;", "uiScope", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class CancellableUseCase<T, Params> {
    private Disposable disposable;
    private final CoroutineScope ioScope;
    private final CompletableJob job;
    private Job observableJob;
    private Thread observableWorkerThread;
    private final CoroutineScope uiScope;

    public abstract Observable<T> buildUseCase(Params params);

    public CancellableUseCase() {
        CompletableJob Job$default;
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        this.job = Job$default;
        CompletableJob completableJob = Job$default;
        this.ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJob));
        this.uiScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(completableJob));
    }

    public final void execute(Params params, Function1<? super T, Unit> onSuccess, Function1<? super Throwable, Unit> onError, Function0<Unit> onCancel) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(onSuccess, "");
        Intrinsics.checkNotNullParameter(onError, "");
        Intrinsics.checkNotNullParameter(onCancel, "");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new CancellableUseCase$execute$1(this, params, onSuccess, onCancel, onError, null), 3, null);
        this.observableJob = launch$default;
    }

    public final void cancel() {
        Job job = this.observableJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        Thread thread = this.observableWorkerThread;
        if (thread != null) {
            thread.interrupt();
        }
        dispose();
        this.observableJob = null;
        this.observableWorkerThread = null;
    }

    public final void destroy() {
        Job.DefaultImpls.cancel$default(this.job, null, 1, null);
        Thread thread = this.observableWorkerThread;
        if (thread != null) {
            thread.interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispose() {
        Disposable disposable = this.disposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.disposable = null;
    }
}
